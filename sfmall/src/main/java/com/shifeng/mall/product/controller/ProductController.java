package com.shifeng.mall.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dto.mall.MallCategoryDTO;
import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.search.SearchParameter;
import com.shifeng.entity.search.Suggest;
import com.shifeng.entity.search.WareSkuInfo;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.product.service.ProductService;
import com.shifeng.plugin.page.Page;
import com.shifeng.plugin.page.SolrPage;
import com.shifeng.provide.coupon.service.CouponService;
import com.shifeng.provide.mall.service.MallWareCommentService;
import com.shifeng.provide.search.MallSearchService;
import com.shifeng.response.ReqResponse;

/**
 * 商品
 */
@Controller
@RequestMapping(value = "product")
public class ProductController extends BaseController{
    @Resource(name="productService")
    private ProductService productService;
    @Resource(name="mallWareCommentService")
    private MallWareCommentService mallWareCommentService;
    @Resource(name="couponService")
    private CouponService couponService;
    @Resource(name="mallSearchService")
    private MallSearchService mallSearchService;
    
    /**
     *大家都在买
     */
    @RequestMapping(value = "/everybodybuy")
    @ResponseBody
    public List<WareSkuInfo> everybodybuy(String cid, String pcid, String pid) throws Exception {
         List<WareSkuInfo> skuInfos=productService.everybodybuy(cid,pcid,pid);
        return skuInfos;
    }
    /**
     *猜你喜欢
     */
    @RequestMapping(value = "/guessyoulike")
    @ResponseBody
    public List guessyoulike(String cid,String pcid,String pid) throws Exception {
        List<WareSkuInfo> skuInfos=productService.guessyoulike(cid,pcid,pid);
        return skuInfos;
    }
    /**
     *品牌信息
     */
    @RequestMapping(value = "/getBrandInfoById")
    @ResponseBody
    public Brand getBrandInfoById(String brandid) throws Exception {
        Brand brand=productService.getBandInfoById(brandid);
        return brand;
    }
    /**
     *商品评价
     */
    @RequestMapping(value = "/getComment")
    @ResponseBody
    public ModelAndView getComment(ModelAndView mv, String pid, Page page) throws Exception {
        ReqResponse<Page> pages=mallWareCommentService.getWareComments(pid,page.getCurrentPage(),page.getPageSize());
        if(pages.getCode()==0) {

            Page page2 = pages.getData();
            mv.addObject("page",page2);//List<WareCommentDTO>
            mv.addObject("wareComments",page2.getResultData());
        }
        mv.setViewName(basePath + "product/comment.btl");
        return mv;
    }
    
    /**
     * 跳转查询商品页面
     * @param mv
     * @return
     */
    @RequestMapping(value = "/searchWare")
    @ResponseBody
    public ModelAndView searchWare(ModelAndView mv,SearchParameter searchParameter,SolrPage page){
    	if(StringUtils.isEmpty(searchParameter.getKeyword())){
    		searchParameter.setKeyword("*");
    	}else{
    		if(!"*".equals(searchParameter.getKeyword())){
    			mv.addObject("keyword", searchParameter.getKeyword());
        	}
    	}
    	page.setPageSize(20);
    	page = mallSearchService.searchWare(searchParameter, page);
    	
    	mv.addObject("page", page);
    	mv.setViewName(basePath + "product/goodslist.btl");
    	
    	return mv;
    }
    
    /**
     * 查询商品
     * @param searchParameter
     * @param page
     * @return
     */
    @RequestMapping(value = "/wareList")
    @ResponseBody
    public Map<String,Object> wareList(SearchParameter searchParameter,SolrPage page){
    	Map<String,Object> map = new HashMap<String,Object>();
    	
    	if(StringUtils.isEmpty(searchParameter.getKeyword())){
    		searchParameter.setKeyword("*");
    	}
    	searchParameter.setP(2);
    	page.setPageSize(20);
    	page = mallSearchService.searchWare(searchParameter, page);
    	
    	map.put("page", page);
    	return map;
    }
    
    /**
     * 关键词提示
     * @param keyword 关键词
     * @return
     */
    @RequestMapping(value="suggest")
    @ResponseBody
    public List<Suggest> suggest(String keyword){
    	List<Suggest> list = mallSearchService.suggest(keyword);
    	return list;
    }
    
}
