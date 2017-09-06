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

import com.shifeng.entity.coupon.CouponPackage;
import com.shifeng.op.coupon.service.CouponPackageService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 优惠券套餐(c_couponPackage)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:54 
 */ 
@Controller
@RequestMapping(value="/couponPackage")
public class CouponPackageController{
	
	@Resource(name="couponPackageServiceImpl")
	private CouponPackageService couponPackageServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goCouponPackageList")
	public ModelAndView goCouponPackageList(ModelAndView mv) throws Exception{
		mv.setViewName("coupon/couponPackageList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param couponPackage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllCouponPackage")
	@ResponseBody
	public Map<String,Object> findAllCouponPackage(Page page,CouponPackage couponPackage) throws Exception{
		if(couponPackage==null){
			couponPackage = new CouponPackage();
		}
		page.setT(couponPackage);
		Map<String,Object> map = new HashMap<String,Object>();
		List<CouponPackage> couponPackages = couponPackageServiceImpl.findAllCouponPackage(page);
		map.put("couponPackages", couponPackages);
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
	@RequestMapping(value="/goCouponPackageEdit")
	@ResponseBody
	public ModelAndView goCouponPackageEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("coupon/couponPackageEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCouponPackageById")
	@ResponseBody
	public Map<String,Object> findCouponPackageById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		CouponPackage couponPackage = couponPackageServiceImpl.findCouponPackageById(id);
		map.put("couponPackage",couponPackage);
		return map;
	}
	
	/**
	 * 新增
	 * @param couponPackage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveCouponPackage")
	@ResponseBody
	public Map<String,Object> saveCouponPackage(CouponPackage couponPackage,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		couponPackage.setUpdatename(user.getuName());
		try {
			couponPackageServiceImpl.saveCouponPackage(couponPackage);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param couponPackage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCouponPackage")
	@ResponseBody
	public Map<String,Object> updateCouponPackage(CouponPackage couponPackage,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			couponPackageServiceImpl.updateCouponPackage(couponPackage);
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
	@RequestMapping(value="/deleteCouponPackage")
	@ResponseBody
 	public Map<String,Object> deleteCouponPackage(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			couponPackageServiceImpl.deleteCouponPackage(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
