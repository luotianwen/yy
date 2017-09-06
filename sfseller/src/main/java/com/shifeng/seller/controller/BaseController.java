package com.shifeng.seller.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.provide.system.service.SystemService;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.util.Const;

/**
 * Created by yongshi on 2017/3/31.
 */
public class BaseController {
	@Resource(name="systemService")
    private SystemService systemServiceImpl;
	
	
    @ModelAttribute
    public void init(  HttpServletResponse response, HttpSession session)throws Exception {
        Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
        if(null==user){
            response.setHeader("sessionstatus", "timeout");
        }

    }
    
    /**
     *获取所有省份
     */
    @RequestMapping(value = "/getAllProvince")
    @ResponseBody
    public List getAllProvince() throws Exception {
         return systemServiceImpl.getAllProvince();
    }
    /**
     *通过省份id获取市
     */
    @RequestMapping(value = "/getAllCityByPid")
    @ResponseBody
    public List getAllCityByPid(String pid) throws Exception {
         return systemServiceImpl.getAllCityByPid(pid);
    }
    /**
     *通过市id获取区
     */
    @RequestMapping(value = "/getAllAreaByCid")
    @ResponseBody
    public List getAllAreaByCid(String cid) throws Exception {
         return systemServiceImpl.getAllAreaByCid(cid);
    }
}
