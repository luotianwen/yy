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

import com.shifeng.entity.coupon.CouponsDetail;
import com.shifeng.op.coupon.service.CouponsDetailService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 优惠券明细表(c_couponsDetail)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:55 
 */ 
@Controller
@RequestMapping(value="/couponsDetail")
public class CouponsDetailController{
	
	@Resource(name="couponsDetailServiceImpl")
	private CouponsDetailService couponsDetailServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goCouponsDetailList")
	public ModelAndView goCouponsDetailList(ModelAndView mv) throws Exception{
		mv.setViewName("coupon/couponsDetailList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param couponsDetail
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllCouponsDetail")
	@ResponseBody
	public Map<String,Object> findAllCouponsDetail(Page page,CouponsDetail couponsDetail) throws Exception{
		if(couponsDetail==null){
			couponsDetail = new CouponsDetail();
		}
		page.setT(couponsDetail);
		Map<String,Object> map = new HashMap<String,Object>();
		List<CouponsDetail> couponsDetails = couponsDetailServiceImpl.findAllCouponsDetail(page);
		map.put("couponsDetails", couponsDetails);
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
	@RequestMapping(value="/goCouponsDetailEdit")
	@ResponseBody
	public ModelAndView goCouponsDetailEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("coupon/couponsDetailEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findCouponsDetailById")
	@ResponseBody
	public Map<String,Object> findCouponsDetailById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		CouponsDetail couponsDetail = couponsDetailServiceImpl.findCouponsDetailById(id);
		map.put("couponsDetail",couponsDetail);
		return map;
	}
	
	/**
	 * 新增
	 * @param couponsDetail
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveCouponsDetail")
	@ResponseBody
	public Map<String,Object> saveCouponsDetail(String id,String number) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			couponsDetailServiceImpl.saveCouponsDetail(id,number,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param couponsDetail
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateCouponsDetail")
	@ResponseBody
	public Map<String,Object> updateCouponsDetail(CouponsDetail couponsDetail,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			couponsDetailServiceImpl.updateCouponsDetail(couponsDetail);
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
	@RequestMapping(value="/deleteCouponsDetail")
	@ResponseBody
 	public Map<String,Object> deleteCouponsDetail(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			couponsDetailServiceImpl.deleteCouponsDetail(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
