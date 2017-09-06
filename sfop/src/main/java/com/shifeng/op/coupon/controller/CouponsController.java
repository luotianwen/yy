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

import com.shifeng.entity.coupon.Coupons;
import com.shifeng.op.coupon.service.CouponsService;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.util.IdWorker;


/** 
 * 优惠券(c_coupons)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 16:59:02 
 */ 
@Controller
@RequestMapping(value="/coupons")
public class CouponsController{
	
	@Resource(name="couponsServiceImpl")
	private CouponsService couponsServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goCouponsList")
	public ModelAndView goCouponsList(ModelAndView mv) throws Exception{
		mv.setViewName("coupon/couponsList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllCoupons")
	@ResponseBody
	public Map<String,Object> findAllCoupons(Page page,Coupons coupons) throws Exception{
		if(coupons==null){
			coupons = new Coupons();
		}
		page.setT(coupons);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Coupons> couponss = couponsServiceImpl.findAllCoupons(page);
		map.put("couponss", couponss);
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
	@RequestMapping(value="/goCouponsEdit")
	@ResponseBody
	public ModelAndView goCouponsEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		
		/*Coupons coupons = couponsServiceImpl.findCouponsById(id);
		mv.addObject("coupons", coupons);*/
		
		mv.setViewName("coupon/couponsEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCouponsById")
	@ResponseBody
	public Map<String,Object> findCouponsById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Coupons coupons = couponsServiceImpl.findCouponsById(id);
		map.put("coupons", coupons);
		return map;
	}
	
	/**
	 * 新增
	 * @param Coupons
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveCoupons")
	@ResponseBody
	public Map<String,Object> saveCoupons(Coupons coupons,String range,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			coupons.setId(IdWorker.getId()+"");
			coupons.setUser_id(Integer.valueOf(user.getuId()));
			//3：待发放
			coupons.setState(3);
			couponsServiceImpl.saveCoupons(coupons,range);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param Coupons
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCoupons")
	@ResponseBody
	public Map<String,Object> updateCoupons(Coupons coupons,String range,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			coupons.setUpdateName(user.getuName());
			couponsServiceImpl.updateCoupons(coupons,range);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 发放/暂停发放优惠券
	 * @param id 优惠券ID
	 * @param state 优惠券状态
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="grantCoupons")
	@ResponseBody
	public Map<String,Object> grantCoupons(String id,String state,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			map.put("id", id);
			map.put("state", state);
			map.put("uName", user.getuName());
			couponsServiceImpl.updateCouponsState(map);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
 
	/**
	 * 跳转生成密钥页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="goCouponsSecret")
	@ResponseBody
	public ModelAndView goCouponsSecret(String id,ModelAndView mv){
		mv.addObject("id", id);
		mv.setViewName("coupon/couponsSecret");
		return mv;
	}
	
	@RequestMapping(value="findAllCouponsByPackage")
	@ResponseBody
	public List<Coupons> findAllCouponsByPackage() throws Exception{
		List<Coupons> list = couponsServiceImpl.findAllCouponsByPackage();
		return list;
	}
	
	
}
