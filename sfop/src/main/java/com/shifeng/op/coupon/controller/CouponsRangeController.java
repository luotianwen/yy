package com.shifeng.op.coupon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.coupon.CouponsRange;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.coupon.service.CouponsRangeService;
import com.shifeng.op.dto.category.CategoryDTO;
import com.shifeng.op.dto.coupons.ProductDTO;
import com.shifeng.op.dto.coupons.SearchRangeDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.product.service.ProRulesService;


/** 
 * 优惠券使用范围(c_coupons_range)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:55 
 */ 
@Controller
@RequestMapping(value="/couponsrange")
public class CouponsRangeController{
	//优惠券适用范围
	@Resource(name="couponsrangeServiceImpl")
	private CouponsRangeService couponsrangeServiceImpl;

	//sku
	@Resource(name="prorulesServiceImpl")
	private ProRulesService prorulesServiceImpl;
	
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goCouponsRangeEdit")
	@ResponseBody
	public ModelAndView goCouponsRangeEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("coupon/couponsrangeEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCouponsRangeById")
	@ResponseBody
	public Map<String,Object> findCouponsRangeById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		CouponsRange couponsrange = couponsrangeServiceImpl.findCouponsRangeById(id);
		map.put("couponsrange",couponsrange);
		return map;
	}
	
	/**
	 * 新增
	 * @param couponsrange
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveCouponsRange")
	@ResponseBody
	public Map<String,Object> saveCouponsRange(CouponsRange couponsrange,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			couponsrangeServiceImpl.saveCouponsRange(couponsrange);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param couponsrange
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCouponsRange")
	@ResponseBody
	public Map<String,Object> updateCouponsRange(CouponsRange couponsrange,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			couponsrangeServiceImpl.updateCouponsRange(couponsrange);
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
	@RequestMapping(value="/deleteCouponsRange")
	@ResponseBody
 	public Map<String,Object> deleteCouponsRange(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			couponsrangeServiceImpl.deleteCouponsRange(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
	/**
	 * 优惠券使用范围(指定参加/不参加商品)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="findProductForCoupons")
	@ResponseBody
	public Map<String,Object> findProductForCoupons(Page page,SearchRangeDTO dto) throws Exception{
		if(dto==null){
			dto = new SearchRangeDTO();
		}
		page.setT(dto);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProductDTO> products = prorulesServiceImpl.findProductForCoupons(page);
		map.put("products", products);
		map.put("page", page);
		
		return map;
	}
	
	/**
	 * 优惠券使用范围(指定参加/不参加店铺)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="findShopForCoupons")
	@ResponseBody
	public Map<String,Object> findShopForCoupons(Page page,SearchRangeDTO dto) throws Exception{
		if(dto==null){
			dto = new SearchRangeDTO();
		}
		page.setT(dto);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Shopinfo> shopinfos = couponsrangeServiceImpl.findShopForCoupons(page);
		map.put("shopinfos", shopinfos);
		map.put("page", page);
		
		return map;
	}
	
	/**
	 * 优惠券使用范围(指定参加/不参加分类)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="findAllCategoryForCoupons")
	@ResponseBody
	public Map<String,Object> findAllCategoryForCoupons(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<CategoryDTO> category = couponsrangeServiceImpl.findAllCategoryForCoupons(id);
			map.put("category", category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 查询所有适用范围
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="findAllCouponsRange")
	@ResponseBody
	public Object findAllCouponsRange(String id,String scope) throws Exception{
		return couponsrangeServiceImpl.findAllCouponsRange(id,scope);
	}
	
	
}
