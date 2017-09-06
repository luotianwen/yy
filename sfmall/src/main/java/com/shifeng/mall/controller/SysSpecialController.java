package com.shifeng.mall.controller;

import com.shifeng.entity.system.SysSpecial;
import com.shifeng.mall.homepage.service.SysSpecialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yongshi on 2017/5/18.
 * 专题页
 */
@Controller
public class SysSpecialController extends BaseController {
    @Resource(name = "sysSpecialServiceImpl")
    SysSpecialService sysSpecialServiceImpl;
    @RequestMapping(value = "special/{id}")
    public ModelAndView detail(ModelAndView mv, HttpSession session, HttpServletRequest request, @PathVariable String id)throws Exception {
        SysSpecial s=sysSpecialServiceImpl.getSysSpecialByTitle(id);
        mv.addObject("special",s);
        mv.setViewName(basePath + "special.btl");
        return mv;
    }

    }
