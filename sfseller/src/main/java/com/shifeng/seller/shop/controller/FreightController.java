package com.shifeng.seller.shop.controller;

import com.shifeng.entity.freight.Freight;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.system.service.SystemService;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.service.FreightService;
import com.shifeng.util.Const;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creaed by yongshi on 2017/4/5.
 */
@Controller
@RequestMapping(value ="fright")
public class FreightController extends BaseController {
    /**
     * 运费模板
     */
	@Resource(name="freightServiceImpl")
	private FreightService freightServiceImpl;
	
	@Resource(name="systemService")
    private SystemService systemServiceImpl;

  @RequestMapping(value = "goFright")
  @ResponseBody
  public ModelAndView goFright(ModelAndView mv, HttpSession session){
      Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
      mv.setViewName("fright/myFright");
   return mv;
  }
    @RequestMapping(value = "frightList")
    @ResponseBody
    public ModelAndView frightList(ModelAndView mv, HttpSession session,Page<Freight> page,Freight f){
        Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
        try {
            if(page==null){
                page=new Page<Freight>();
            }
            f.setShopid(user.getShopid());
            page.setPageSize(1000);
            page.setT(f);
            List<Freight> list=freightServiceImpl.findAllFreight(page);
            mv.addObject("frights",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("fright/frightList");
        return mv;
    }
    @RequestMapping(value = "frightEdit")
    @ResponseBody
    public ModelAndView frightEdit(ModelAndView mv, HttpSession session,String id) throws Exception {
        Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
        if(!StringUtils.isEmpty(id)) {
            Freight freight = (Freight) freightServiceImpl.findFreightById(id);
            mv.addObject("freight", freight);
        }
        List citys = getAllProvince();
        mv.addObject("citys", citys);
        mv.setViewName("fright/frightEdit");
        return mv;
    }
    @RequestMapping(value = "frightDel")
    @ResponseBody
    public Map frightDel(String id, HttpSession session){
        Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
        Map map=new HashMap();
            map.put("code",500);
        try {
            freightServiceImpl.deleteFreight(id);
            map.put("code",200);
        }catch (Exception e){
            map.put("code",500);
        }

        return map;
    }
    @RequestMapping(value = "frightSave")
    @ResponseBody
    public Map frightSave( HttpSession session,Freight freight){
        Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
        Map map=new HashMap();
        map.put("code",500);
        try {
            freight.setShopid(user.getShopid());
            freight.setUpdatename(user.getuName());
            freightServiceImpl.saveFreight(freight);
            map.put("code",200);
        }catch (Exception e){
            map.put("code",500);
        }
        return map;
    }
    @RequestMapping(value = "frightUpdate")
    @ResponseBody
    public Map frightUpdate( HttpSession session,Freight freight){
        Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
        Map map=new HashMap();
        map.put("code",500);
        try {
            freight.setUpdatename(user.getuName());
            freightServiceImpl.updateFreight(freight);
            map.put("code",200);
        }catch (Exception e){
            map.put("code",500);
        }
        return map;
    }
}
