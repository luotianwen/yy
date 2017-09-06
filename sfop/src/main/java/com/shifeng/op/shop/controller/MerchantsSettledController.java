package com.shifeng.op.shop.controller;

import com.shifeng.entity.shop.MerchantsSettled;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.shop.service.MerchantsSettledService;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.system.service.SystemService;
import com.shifeng.util.Const;
import org.apache.commons.lang.StringUtils;
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
 * 入驻基本信息填写(s_merchants_settled)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:21 
 */ 
@Controller
@RequestMapping(value="/merchantssettled")
public class MerchantsSettledController{
	
	@Resource(name="merchantssettledServiceImpl")
	private MerchantsSettledService merchantssettledServiceImpl;
	@Resource(name="systemService")
	private SystemService systemServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMerchantsSettledList")
	public ModelAndView goMerchantsSettledList(ModelAndView mv) throws Exception{
		mv.setViewName("shop/merchantssettledList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param merchantssettled
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMerchantsSettled")
	@ResponseBody
	public Map<String,Object> findAllMerchantsSettled(Page page,MerchantsSettled merchantssettled) throws Exception{
		if(merchantssettled==null){
			merchantssettled = new MerchantsSettled();
		}
		page.setT(merchantssettled);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MerchantsSettled> merchantssettleds = merchantssettledServiceImpl.findAllMerchantsSettled(page);
		map.put("merchantssettleds", merchantssettleds);
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
	@RequestMapping(value="/goMerchantsSettledEdit")
	@ResponseBody
	public ModelAndView goMerchantsSettledEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/merchantssettledEdit");
		return mv;
	}

	/**
	 * 跳转查看页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMerchantsSettledView")
	@ResponseBody
	public ModelAndView goMerchantsSettledView(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("shop/merchantssettledView");
		return mv;
	}

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMerchantsSettledById")
	@ResponseBody
	public Map<String,Object> findMerchantsSettledById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MerchantsSettled merchantssettled = merchantssettledServiceImpl.findMerchantsSettledById(id);
		StringBuffer sb=new StringBuffer("");
		if(!StringUtils.isEmpty(merchantssettled.getCompanyArea())){
			String[] area=merchantssettled.getCompanyArea().split(",");
			sb.append(systemServiceImpl.getProvinceNameById(area[0])).append(" ");
			sb.append(systemServiceImpl.getCityNameByPid(area[1])).append(" ");
			sb.append(systemServiceImpl.getAreaNameByCid(area[2]));
			merchantssettled.setCompanyArea(sb.toString());
		}
		if(!StringUtils.isEmpty(merchantssettled.getLocationBankbranch())){
			sb=new StringBuffer("");
			String[] area=merchantssettled.getLocationBankbranch().split(",");
			sb.append(systemServiceImpl.getProvinceNameById(area[0])).append(" ");
			sb.append(systemServiceImpl.getCityNameByPid(area[1])).append(" ");
			sb.append(systemServiceImpl.getAreaNameByCid(area[2]));
			merchantssettled.setLocationBankbranch(sb.toString());
		}
		map.put("merchantssettled",merchantssettled);
		return map;
	}
	
	/**
	 *审核通过
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/passMerchantsSettled")
	@ResponseBody
	public Map<String,Object> passMerchantsSettled(int id,String note,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			merchantssettledServiceImpl.passMerchantsSettled(id,note,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 驳回
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/backMerchantsSettled")
	@ResponseBody
	public Map<String,Object> backMerchantsSettled(int id,String note,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			merchantssettledServiceImpl.backMerchantsSettled(id,note,user);
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
	@RequestMapping(value="/deleteMerchantsSettled")
	@ResponseBody
 	public Map<String,Object> deleteMerchantsSettled(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			merchantssettledServiceImpl.deleteMerchantsSettled(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
