package com.shifeng.mall.controller;

import com.shifeng.provide.system.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yongshi on 2017/4/11.
 */
@Controller
public class SystemController {
    @Resource(name="systemService")
    private SystemService systemServiceImpl;

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
