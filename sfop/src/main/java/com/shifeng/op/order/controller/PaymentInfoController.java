package com.shifeng.op.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.order.PaymentInfo;
import com.shifeng.op.order.service.PaymentInfoService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 支付表(o_paymentInfo)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */ 
@Controller
@RequestMapping(value="/paymentInfo")
public class PaymentInfoController{
	
	@Resource(name="paymentInfoServiceImpl")
	private PaymentInfoService paymentInfoServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPaymentInfoList")
	public ModelAndView goPaymentInfoList(ModelAndView mv) throws Exception{
		mv.setViewName("order/paymentInfoList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param paymentInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllPaymentInfo")
	@ResponseBody
	public Map<String,Object> findAllPaymentInfo(Page page,PaymentInfo paymentInfo) throws Exception{
		if(paymentInfo==null){
			paymentInfo = new PaymentInfo();
		}
		page.setT(paymentInfo);
		Map<String,Object> map = new HashMap<String,Object>();
		List<PaymentInfo> paymentInfos = paymentInfoServiceImpl.findAllPaymentInfo(page);
		map.put("paymentInfos", paymentInfos);
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
	@RequestMapping(value="/goPaymentInfoEdit")
	@ResponseBody
	public ModelAndView goPaymentInfoEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("order/paymentInfoEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findPaymentInfoById")
	@ResponseBody
	public Map<String,Object> findPaymentInfoById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PaymentInfo paymentInfo = paymentInfoServiceImpl.findPaymentInfoById(id);
		map.put("paymentInfo",paymentInfo);
		return map;
	}
	
	/**
	 * 新增
	 * @param paymentInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/savePaymentInfo")
	@ResponseBody
	public Map<String,Object> savePaymentInfo(PaymentInfo paymentInfo,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			paymentInfoServiceImpl.savePaymentInfo(paymentInfo);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param paymentInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updatePaymentInfo")
	@ResponseBody
	public Map<String,Object> updatePaymentInfo(PaymentInfo paymentInfo,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			paymentInfoServiceImpl.updatePaymentInfo(paymentInfo);
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
	@RequestMapping(value="/deletePaymentInfo")
	@ResponseBody
 	public Map<String,Object> deletePaymentInfo(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			paymentInfoServiceImpl.deletePaymentInfo(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
