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

import com.shifeng.entity.order.PorderInfo;
import com.shifeng.op.order.service.PorderInfoService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 订单父表(o_porderInfo)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */ 
@Controller
@RequestMapping(value="/porderInfo")
public class PorderInfoController{
	
	@Resource(name="porderInfoServiceImpl")
	private PorderInfoService porderInfoServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goPorderInfoList")
	public ModelAndView goPorderInfoList(ModelAndView mv) throws Exception{
		mv.setViewName("order/porderInfoList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param porderInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllPorderInfo")
	@ResponseBody
	public Map<String,Object> findAllPorderInfo(Page page,PorderInfo porderInfo) throws Exception{
		if(porderInfo==null){
			porderInfo = new PorderInfo();
		}
		page.setT(porderInfo);
		Map<String,Object> map = new HashMap<String,Object>();
		List<PorderInfo> porderInfos = porderInfoServiceImpl.findAllPorderInfo(page);
		map.put("porderInfos", porderInfos);
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
	@RequestMapping(value="/goPorderInfoEdit")
	@ResponseBody
	public ModelAndView goPorderInfoEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("order/porderInfoEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findPorderInfoById")
	@ResponseBody
	public Map<String,Object> findPorderInfoById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PorderInfo porderInfo = porderInfoServiceImpl.findPorderInfoById(id);
		map.put("porderInfo",porderInfo);
		return map;
	}
	
	/**
	 * 新增
	 * @param porderInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/savePorderInfo")
	@ResponseBody
	public Map<String,Object> savePorderInfo(PorderInfo porderInfo,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			porderInfoServiceImpl.savePorderInfo(porderInfo);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param porderInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updatePorderInfo")
	@ResponseBody
	public Map<String,Object> updatePorderInfo(PorderInfo porderInfo,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			porderInfoServiceImpl.updatePorderInfo(porderInfo);
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
	@RequestMapping(value="/deletePorderInfo")
	@ResponseBody
 	public Map<String,Object> deletePorderInfo(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			porderInfoServiceImpl.deletePorderInfo(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
