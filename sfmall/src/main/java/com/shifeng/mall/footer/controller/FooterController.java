package com.shifeng.mall.footer.controller;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.footer.dto.ExplainDTO;
import com.shifeng.mall.footer.service.FooterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by martins on 2017-04-25.
 */
@Controller
@RequestMapping("/footer")
public class FooterController  extends BaseController {

    @Resource(name="footerServiceImpl")
    private FooterService footerServiceImpl;

    /**
     * 购物指南
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/shop")
    public ModelAndView shop(ModelAndView mv, String name) throws Exception {
        if(StringUtils.isEmpty(name)){
            mv.setViewName("404");
            return mv;
        }
        ExplainDTO explain=footerServiceImpl.getExplain(1,name);
        if(explain==null){
                mv.setViewName("404");
            return mv;
        }
        mv.addObject("explain", explain);
        mv.setViewName(basePath + "system/shop.btl");
        return mv;
    }
    /**
     * 支付/配送
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/pay")
    public ModelAndView pay(ModelAndView mv, String name) throws Exception {
        if(StringUtils.isEmpty(name)){
            mv.setViewName("404");
            return mv;
        }
        ExplainDTO explain=footerServiceImpl.getExplain(2,name);
        if(explain==null){
            mv.setViewName("404");
            return mv;
        }
        mv.addObject("explain", explain);
        mv.setViewName(basePath + "system/pay.btl");
        return mv;
    }
    /**
     * 常见问题
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/problem")
    public ModelAndView problem(ModelAndView mv, String name) throws Exception {
        if(StringUtils.isEmpty(name)){
            mv.setViewName("404");
            return mv;
        }
        ExplainDTO explain=footerServiceImpl.getExplain(3,name);
        if(explain==null){
            mv.setViewName("404");
            return mv;
        }
        mv.addObject("explain", explain);
        mv.setViewName(basePath + "system/problem.btl");
        return mv;
    }
    /**
     * 售后服务
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/customerservice")
    public ModelAndView customerservice(ModelAndView mv,  String name) throws Exception {
        if(StringUtils.isEmpty(name)){
            mv.setViewName("404");
            return mv;
        }
        ExplainDTO explain=footerServiceImpl.getExplain(4,name);
        if(explain==null){
            mv.setViewName("404");
            return mv;
        }
        mv.addObject("explain", explain);
        mv.setViewName(basePath + "system/customerservice.btl");
        return mv;
    }
    /**
     * 商务合作
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/businesscooperation")
    public ModelAndView businesscooperation(ModelAndView mv,  String name) throws Exception {
        if(StringUtils.isEmpty(name)){
            mv.setViewName("404");
            return mv;
        }
        ExplainDTO explain=footerServiceImpl.getExplain(5,name);
        if(explain==null){
            mv.setViewName("404");
            return mv;
        }
        mv.addObject("explain", explain);
        mv.setViewName(basePath + "system/businesscooperation.btl");
        return mv;
    }
    /**
     * 商务合作
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/about")
    public ModelAndView about(ModelAndView mv,  String name) throws Exception {
        if(StringUtils.isEmpty(name)){
            mv.setViewName("404");
            return mv;
        }
        ExplainDTO explain=footerServiceImpl.getExplain(7,name);
        if(explain==null){
            mv.setViewName("404");
            return mv;
        }
        mv.addObject("explain", explain);
        mv.setViewName(basePath + "system/about.btl");
        return mv;
    }

}
