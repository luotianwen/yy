package com.shifeng.seller.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.freight.Freight;
import com.shifeng.entity.product.Product;
import com.shifeng.entity.shop.AfterSalesPolicy;
import com.shifeng.entity.shop.ReturnAddress;
import com.shifeng.entity.shop.ShopBrand;
import com.shifeng.entity.shop.ShopCategoryColor;
import com.shifeng.entity.shop.ShopCategorySpec;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.controller.BaseController;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.shop.service.FreightService;
import com.shifeng.seller.product.dto.ProductDTO;
import com.shifeng.seller.product.dto.ProductListDTO;
import com.shifeng.seller.product.service.ColorService;
import com.shifeng.seller.product.service.ImagesService;
import com.shifeng.seller.product.service.ProRulesService;
import com.shifeng.seller.product.service.ProductPropertyService;
import com.shifeng.seller.product.service.ProductService;
import com.shifeng.seller.product.service.SkuImagesService;
import com.shifeng.seller.product.service.SpecService;
import com.shifeng.seller.property.dto.PropertyCategoryDTO;
import com.shifeng.seller.property.service.PropertycategoryService;
import com.shifeng.seller.shop.dto.ShopCategoryDTO;
import com.shifeng.seller.shop.service.AfterSalesPolicyService;
import com.shifeng.seller.shop.service.ShopBrandService;
import com.shifeng.seller.shop.service.ShopCategoryColorService;
import com.shifeng.seller.shop.service.ShopCategoryService;
import com.shifeng.seller.shop.service.ShopCategorySpecService;
import com.shifeng.seller.shop.service.ShopinfoService;
import com.shifeng.util.Const;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
	/**
	 * 产品
	 */
	@Resource(name="productServiceImpl")
	private ProductService productServiceImpl;
	/**
	 * SKU
	 */
	@Resource(name="prorulesServiceImpl")
	private ProRulesService prorulesServiceImpl;
	/**
	 * 店铺类目
	 */
	@Resource(name="shopcategoryServiceImpl")
	private ShopCategoryService shopcategoryServiceImpl;
	/**
	 * 分类属性
	 */
	@Resource(name="propertycategoryServiceImpl")
	private PropertycategoryService propertycategoryServiceImpl;
	/**
	 * 店铺品牌
	 */
	@Resource(name="shopbrandServiceImpl")
	private ShopBrandService shopbrandServiceImpl;
	/**
	 * 售后服务
	 */
	@Resource(name="aftersalespolicyServiceImpl")
	private AfterSalesPolicyService aftersalespolicyServiceImpl;
	/**
	 * 运费模板
	 */
	@Resource(name="freightServiceImpl")
	private FreightService freightServiceImpl;
	/**
	 * 店铺分类颜色
	 */
	@Resource(name="shopcategorycolorServiceImpl")
	private ShopCategoryColorService shopcategorycolorServiceImpl;
	/**
	 * 店铺分类规格
	 */
	@Resource(name="shopcategoryspecServiceImpl")
	private ShopCategorySpecService shopcategoryspecServiceImpl;
	/**
	 * 商家信息
	 */
	@Resource(name="shopinfoServiceImpl")
	private ShopinfoService shopinfoServiceImpl;
	/**
	 * 商品图片
	 */
	@Resource(name="imagesServiceImpl")
	private ImagesService imagesServiceImpl;
	/**
	 * 商品属性
	 */
	@Resource(name="productpropertyServiceImpl")
	private ProductPropertyService productpropertyServiceImpl;
	/**
	 * SKU图片
	 */
	@Resource(name="skuimagesServiceImpl")
	private SkuImagesService skuimagesServiceImpl;
	/**
	 * 产品颜色
	 */
	@Resource(name="colorServiceImpl")
	private ColorService colorServiceImpl;
	/**
	 * 产品规格
	 */
	@Resource(name="specServiceImpl")
	private SpecService specServiceImpl;
	
	
	/**
	 * 跳转选择类目页面
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="goProductCategory")
	public ModelAndView goProductCategory(ModelAndView mv,HttpSession session){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		try {
			List<ShopCategoryDTO> shopCategoryDTO = shopcategoryServiceImpl.findAllParentCategoryByShopId(user.getShopid()+"");
			mv.addObject("shopCategoryDTO", shopCategoryDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("product/chooseCategory");
		return mv;
	}
	
	/**
	 * 根据分类查询所有分类属性
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="findShopCategoryByPid")
	@ResponseBody
	public Map<String,Object> findShopCategoryByPid(String id,HttpSession session){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<ShopCategoryDTO> shopCategoryDTO = shopcategoryServiceImpl.findShopCategoryByPid(id,user.getShopid()+"");
			
			map.put("shopCategoryDTO", shopCategoryDTO);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "查询失败，请稍后重试!!!");
		}
		
		return map;
	}
	
	/**
	 * 跳转新增产品页
	 * @param mv
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="goSaveProduct")
	@ResponseBody
	public ModelAndView goSaveProduct(ModelAndView mv,String id,String pid,HttpSession session) {
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		try {
			//查询分类属性
			List<PropertyCategoryDTO> propertycategory = propertycategoryServiceImpl.findAllPropertycategoryByCid(id, pid);
			mv.addObject("propertycategory", propertycategory);
			
			//查询商家可用品牌
			List<ShopBrand> shopBrand = shopbrandServiceImpl.findShopBrand(user.getShopid()+"");
			mv.addObject("shopBrand", shopBrand);
			
			//查询商家售后服务
			List<AfterSalesPolicy> afterSalesPolicy = aftersalespolicyServiceImpl.findAllAfterSalesPolicyByShopId(user.getShopid()+"");
			mv.addObject("afterSalesPolicy", afterSalesPolicy);
			
			//查询商家运费模板
			List<Freight> freight = freightServiceImpl.findAllFreightByShopId(user.getShopid()+"");
			mv.addObject("freight", freight);
			
			//查询商家分类颜色属性
			List<ShopCategoryColor> colors = shopcategorycolorServiceImpl.findAllShopCategoryColor(id,user.getShopid()+"");
			mv.addObject("colors", colors);
			
			//查询商家分类规格属性
			List<ShopCategorySpec> specs = shopcategoryspecServiceImpl.findAllShopCategorySpec(id,user.getShopid()+"");
			mv.addObject("specs", specs);
			
			//省份
			List citys = getAllProvince();
			mv.addObject("citys", citys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("product/saveProduct");
		return mv;
	}
	
	/**
	 * 新增商品
	 * @param prodcut 商品信息
	 * @param prorules sku信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value="saveProduct")
	@ResponseBody
	public Map<String,Object> saveProduct(ProductDTO product,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		product.setUpdatename(user.getuName());
		try {
			//店铺编号
			product.setShopid(user.getShopid());
			//新增商品
			productServiceImpl.saveProduct(product,user);
			
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "保存失败，请稍后再试");
		}
		
		return map;
	}
	
	/**
	 * 跳转产品编辑页面
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="goProductEdit")
	@ResponseBody
	public ModelAndView goProductEdit(ModelAndView mv,HttpSession session,String id,String state){
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		mv.addObject("state", state);
		try {
			//查询商品信息
			Product product = productServiceImpl.findProductById(id,user.getShopid()+"");
			mv.addObject("product", product);
			/*
			//查询商品图片
			List<Images> images = imagesServiceImpl.findAllImages(id);
			mv.addObject("images", images);
			
			//查询商品属性
			List<ProductProperty> productPropertys = productpropertyServiceImpl.findAllProductProperty(id);
			mv.addObject("productPropertys", productPropertys);
			
			//查询SKU
			List<ProRules> prorules = prorulesServiceImpl.findAllProRules(id);
			mv.addObject("prorules", prorules);
			
			//查询SKU图片
			List<SkuImages> skuimages = skuimagesServiceImpl.findAllSkuImages(id);
			mv.addObject("skuimages", skuimages);
			
			//查询SKU颜色
			List<SkuImages> skucolors = skuimagesServiceImpl.findAllColorId(id);
			mv.addObject("skucolors", skucolors);
			
			//产品颜色
			List<Color> pcolors = colorServiceImpl.findAllColor(id);
			mv.addObject("pcolors", pcolors);
			
			//产品规格
			List<Spec> pspecs = specServiceImpl.findAllSpec(id);
			mv.addObject("pspecs", pspecs);*/
			
			//查询分类属性
			List<PropertyCategoryDTO> propertycategory = propertycategoryServiceImpl.findAllPropertycategoryByCid(product.getCid()+"", product.getPcid()+"");
			mv.addObject("propertycategory", propertycategory);
			
			//查询商家可用品牌
			List<ShopBrand> shopBrand = shopbrandServiceImpl.findShopBrand(user.getShopid()+"");
			mv.addObject("shopBrand", shopBrand);
			
			//查询商家售后服务
			List<AfterSalesPolicy> afterSalesPolicy = aftersalespolicyServiceImpl.findAllAfterSalesPolicyByShopId(user.getShopid()+"");
			mv.addObject("afterSalesPolicy", afterSalesPolicy);
			
			//查询商家运费模板
			List<Freight> freight = freightServiceImpl.findAllFreightByShopId(user.getShopid()+"");
			mv.addObject("freight", freight);
			
			//查询商家分类颜色属性
			List<ShopCategoryColor> colors = shopcategorycolorServiceImpl.findAllShopCategoryColor(product.getCid()+"",user.getShopid()+"");
			mv.addObject("colors", colors);
			
			//查询商家分类规格属性
			List<ShopCategorySpec> specs = shopcategoryspecServiceImpl.findAllShopCategorySpec(product.getCid()+"",user.getShopid()+"");
			mv.addObject("specs", specs);
			
			//省份
			List citys = getAllProvince();
			mv.addObject("citys", citys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("product/updateProduct");
		return mv;
	}
	
	/**
	 * 修改产品
	 * @param session
	 * @param product
	 * @return
	 */
	@RequestMapping(value="updateProduct")
	@ResponseBody
	public Map<String,Object> updateProduct(HttpSession session,ProductDTO product){
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		//修改产品
		try {
			productServiceImpl.updateProduct(product,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "保存失败，请稍后重试!!!");
		}
		
		return map;
	}
	
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProduct")
	public ModelAndView goProduct(ModelAndView mv,String state) throws Exception{
		mv.addObject("state", state);
		mv.setViewName("product/product");
		return mv;
	}
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllProduct")
	@ResponseBody
	public ModelAndView findAllProduct(ModelAndView mv,Page page,String state,HttpSession session) throws Exception{
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("shopId", user.getShopid()+"");
		map.put("state", state);
		page.setT(map);
		
		List<ProductListDTO> products = productServiceImpl.findAllProduct(page);
		
		mv.addObject("products", products);
		mv.addObject("page", page);
		mv.addObject("state", state);
		
		mv.setViewName("product/productList");
		return mv;
	}
	
	/**
	 * 修改产品状态
	 * @param id 产品ID
	 * @param state 状态
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateProductState")
	@ResponseBody
	public Map<String,Object> updateProductState(@RequestParam(value="id")String id,@RequestParam(value="state")String state,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.SELLER_SESSION_USER);
		//产品上架
		try {
			productServiceImpl.updateProductState(id,user,state);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "修改失败，请稍后重试!!!");
		}

		return map;
	}
	
}
