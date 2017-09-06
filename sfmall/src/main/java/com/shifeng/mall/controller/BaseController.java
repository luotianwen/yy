package com.shifeng.mall.controller;


import com.shifeng.entity.category.Category;
import com.shifeng.entity.category.Navigation;
import com.shifeng.mall.entity.user.Users;
import com.shifeng.provide.navigation.service.NavigationService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
import org.apache.commons.lang.StringUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by yongshi on 2017/3/3.
 */

public class BaseController {
    public String basePath ="/WEB-INF/view/";
     @Resource(name="navigationService")
     private NavigationService navigationServiceImpl;
    @Resource(name = "beetlConfig")
    BeetlGroupUtilConfiguration config;

     @ModelAttribute
     public void init(HttpServletResponse response, HttpSession session)throws Exception {
          List<Navigation> list=null;
          String flag="0";//0标识要更新 1不要
          try {
              flag = RedisTool.get(Const.NAVIGATION_CACHE_FLAG);
               if(StringUtils.isEmpty(flag)){
                    flag="0";
               }
          } catch (Exception e) {
                   flag="0";
          }
          //缓存没有
          if(flag.equals("0")){
              create(session);
          }

     }
     private void create(HttpSession session){
         List<Navigation> list=null;
         List<Category> categorys=null;
         ReqResponse<List<Navigation>> navigations= navigationServiceImpl.getNav();

         if(navigations!=null){
             list=navigations.getData();
             if(list!=null&&list.size()>0){
                 createNav(session,list);
             }
         }
         RedisTool.set(Const.NAVIGATION_CACHE_FLAG,"1");
     }


     private void createNav(HttpSession session, List<Navigation> navs){
          GroupTemplate group = config.getGroupTemplate();
          String contextPath = session.getServletContext().getRealPath("/");
          String detailnavTemp = contextPath+"/detailnav.btl";
          String btlUrl = "/btl/detailnav.btl";
           File newFile = new File(detailnavTemp);
          Template t = group.getTemplate(btlUrl);
          t.binding("navs",navs);
         OutputStream out = null ; // 准备好一个输出的对象
         try {
             out = new FileOutputStream(newFile);
             t.renderTo(out);
         }catch (Exception e){

         }

         String navTemp = contextPath+"/nav.btl";
         String navUrl = "/btl/nav.btl";
         File navFile = new File(navTemp);
         Template navt = group.getTemplate(navUrl);
         navt.binding("navs",navs);
         OutputStream navout = null ; // 准备好一个输出的对象
         try {
             navout = new FileOutputStream(navFile);
             navt.renderTo(navout);
         }catch (Exception e){

         }
     }

     public void checkLogin(ModelAndView mv, HttpSession session) throws Exception {
          Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
          if(user==null) {
              throw new Exception("用户未登录！或者登录超时");
          }
     }

}
