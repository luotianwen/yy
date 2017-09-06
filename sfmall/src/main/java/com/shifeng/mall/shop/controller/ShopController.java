package com.shifeng.mall.shop.controller;

import com.shifeng.dto.mall.shop.ShopInfoDTO;
import com.shifeng.entity.search.SearchParameter;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.search.service.SearchService;
import com.shifeng.plugin.page.SolrPage;
import com.shifeng.provide.mall.service.MallShopService;
import com.shifeng.response.ReqResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yongshi on 2017/5/11.
 */
@Controller
@RequestMapping(value = "shop")
public class ShopController extends BaseController {

    @Resource(name="mallShopService")
    private MallShopService mallShopService;
    @Resource(name = "searchServiceImpl")
    protected SearchService searchService;
    //店铺主页
    @RequestMapping(value = "/{shopid}")
    public ModelAndView shop(ModelAndView mv, HttpSession session, HttpServletRequest request, @PathVariable String shopid)throws Exception {
        ReqResponse<ShopInfoDTO> s=mallShopService.getShopInfo(shopid);
        if(s.getCode()==0){
            ShopInfoDTO shop=s.getData();
            mv.addObject("shop",shop);
            mv.setViewName(basePath + "shop/detail.btl");
        }
        else{
            mv.setViewName(basePath + "sku404.btl");
        }

        return mv;
    }

    /**
     *店铺商品
     */
    @RequestMapping(value = "/product")
    @ResponseBody
    public  ModelAndView  product(ModelAndView mv,String shopid, SearchParameter searchParameter, SolrPage page) throws Exception {
        SolrPage pages=searchService.searchShopWare(shopid,searchParameter,page);
        mv.addObject("page",pages);
        mv.addObject("index",searchParameter.getSort());
        mv.setViewName(basePath + "shop/page.btl");
        return mv;
    }
 }
