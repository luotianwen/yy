package com.shifeng.op.product.controller;

import com.shifeng.entity.brand.Brand;
import com.shifeng.entity.product.Product;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.brand.service.BrandService;
import com.shifeng.op.category.service.CategoryService;
import com.shifeng.op.dto.category.CategoryDTO;
import com.shifeng.op.dto.product.ProductDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.product.service.ProductService;
import com.shifeng.op.shop.service.ShopinfoService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
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
 * 产品表(p_product)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */ 
@Controller
@RequestMapping(value="/product")
public class ProductController{
	
	@Resource(name="productServiceImpl")
	private ProductService productServiceImpl;
	@Resource(name="brandServiceImpl")
	private BrandService brandServiceImpl;
	@Resource(name="categoryServiceImpl")
	private CategoryService categoryServiceImpl;
	@Resource(name="shopinfoServiceImpl")
	private ShopinfoService shopinfoServiceImpl;
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProductList")
	public ModelAndView goProductList(ModelAndView mv) throws Exception{
		List<Brand> brands =brandServiceImpl.findAllBrandByState();
		mv.addObject("brands",brands);
		List<CategoryDTO> categorys =categoryServiceImpl.findAllCategoryState();
		mv.addObject("categorys",categorys);
		List<Shopinfo> shopinfos =shopinfoServiceImpl.findAllShopinfoByState();
		mv.addObject("shopinfos",shopinfos);

		mv.setViewName("product/productList");
		return mv;
	}

	/**
	 * 待售列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/forSaleProductList")
	public ModelAndView forSaleProductList(ModelAndView mv) throws Exception{
		List<Brand> brands =brandServiceImpl.findAllBrandByState();
		mv.addObject("brands",brands);
		List<CategoryDTO> categorys =categoryServiceImpl.findAllCategoryState();
		mv.addObject("categorys",categorys);
		List<Shopinfo> shopinfos =shopinfoServiceImpl.findAllShopinfoByState();
		mv.addObject("shopinfos",shopinfos);
		mv.setViewName("product/productForSaleList");
		return mv;
	}
	/**
	 * 回收列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/recoveryProductList")
	public ModelAndView recoveryProductList(ModelAndView mv) throws Exception{
		List<Brand> brands =brandServiceImpl.findAllBrandByState();
		mv.addObject("brands",brands);
		List<CategoryDTO> categorys =categoryServiceImpl.findAllCategoryState();
		mv.addObject("categorys",categorys);
		List<Shopinfo> shopinfos =shopinfoServiceImpl.findAllShopinfoByState();
		mv.addObject("shopinfos",shopinfos);
		mv.setViewName("product/productRecoveryList");
		return mv;
	}
	/**
	 * 查询所有
	 * @param page
	 * @param product
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllProduct")
	@ResponseBody
	public Map<String,Object> findAllProduct(Page page,Product product) throws Exception{
		if(product==null){
			product = new Product();
		}
		page.setT(product);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProductDTO> products = productServiceImpl.findAllProduct(page);
		map.put("products", products);
		map.put("page", page);
		return map;
	}


	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goProductEdit")
	@ResponseBody
	public ModelAndView goProductEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("product/productEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findProductById")
	@ResponseBody
	public Map<String,Object> findProductById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Product product = productServiceImpl.findProductById(id);
		map.put("product",product);
		return map;
	}
	
	/**
	 * 新增
	 * @param product
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveProduct")
	@ResponseBody
	public Map<String,Object> saveProduct(Product product,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			productServiceImpl.saveProduct(product);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param product
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateProduct")
	@ResponseBody
	public Map<String,Object> updateProduct(Product product,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			productServiceImpl.updateProduct(product);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	

	/**
	 * 下架
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/downProduct")
	@ResponseBody
	public Map<String,Object> downProduct(int[] id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {

			productServiceImpl.updateDownProduct(id,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 上架
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/upProduct")
	@ResponseBody
	public Map<String,Object> upProduct(int[] id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {

			productServiceImpl.updateUpProduct(id,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteProduct")
	@ResponseBody
	public Map<String,Object> deleteProduct(int[] id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {

			productServiceImpl.updateDeleteProduct(id,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	/**
	 * 恢复
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/recoveryProduct")
	@ResponseBody
	public Map<String,Object> recoveryProduct(int[] id,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			productServiceImpl.updateRecoveryProduct(id,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
}
