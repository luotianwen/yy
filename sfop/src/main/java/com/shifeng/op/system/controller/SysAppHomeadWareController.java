package com.shifeng.op.system.controller;

import com.shifeng.entity.product.ProRules;
import com.shifeng.entity.product.Product;
import com.shifeng.entity.system.SysAppHomeadWare;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.product.service.ProRulesService;
import com.shifeng.op.product.service.ProductService;
import com.shifeng.op.system.service.SysAppHomeadWareService;
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
 * app首页广告商品(sys_app_homead_ware)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-16 18:50:00 
 */ 
@Controller
@RequestMapping(value="/sysapphomeadware")
public class SysAppHomeadWareController{
	
	@Resource(name="sysapphomeadwareServiceImpl")
	private SysAppHomeadWareService sysapphomeadwareServiceImpl;
	@Resource(name="prorulesServiceImpl")
	private ProRulesService prorulesServiceImpl;
	@Resource(name="productServiceImpl")
	private ProductService productServiceImpl;
	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goSysAppHomeadWareList")
	public ModelAndView goSysAppHomeadWareList(ModelAndView mv,String ad_id) throws Exception{

		mv.addObject("ad_id",ad_id);
		mv.setViewName("system/sysapphomeadwareList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param sysapphomeadware
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysAppHomeadWare")
	@ResponseBody
	public Map<String,Object> findAllSysAppHomeadWare(Page page,SysAppHomeadWare sysapphomeadware) throws Exception{
		if(sysapphomeadware==null){
			sysapphomeadware = new SysAppHomeadWare();
		}
		page.setT(sysapphomeadware);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysAppHomeadWare> sysapphomeadwares = sysapphomeadwareServiceImpl.findAllSysAppHomeadWare(page);
		map.put("sysapphomeadwares", sysapphomeadwares);
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
	@RequestMapping(value="/goSysAppHomeadWareEdit")
	@ResponseBody
	public ModelAndView goSysAppHomeadWareEdit(ModelAndView mv,String id,String ad_id) throws Exception{
		mv.addObject("id", id);
		mv.addObject("ad_id", ad_id);
		mv.setViewName("system/sysapphomeadwareEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysAppHomeadWareById")
	@ResponseBody
	public Map<String,Object> findSysAppHomeadWareById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysAppHomeadWare sysapphomeadware = sysapphomeadwareServiceImpl.findSysAppHomeadWareById(id);
		map.put("sysapphomeadware",sysapphomeadware);
		return map;
	}
	
	/**
	 * 新增
	 * @param sysapphomeadware
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysAppHomeadWare")
	@ResponseBody
	public Map<String,Object> saveSysAppHomeadWare(SysAppHomeadWare sysapphomeadware,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		ProRules prorules=prorulesServiceImpl.findProRulesById(sysapphomeadware.getSku());
         if(prorules==null){
			 map.put(Const.ERROR_INFO, "sku不存在");
			 return map;
		 }
		Product product=productServiceImpl.findProductById(prorules.getPid()+"");
		if(product==null){
			map.put(Const.ERROR_INFO, "产品不存在");
			return map;
		}
		if(product.getState()!=1) {
			map.put(Const.ERROR_INFO, "产品已下架");
			return map;
		}

		try {
			sysapphomeadware.setUpdatename(user.getuName());
			sysapphomeadwareServiceImpl.saveSysAppHomeadWare(sysapphomeadware);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param sysapphomeadware
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysAppHomeadWare")
	@ResponseBody
	public Map<String,Object> updateSysAppHomeadWare(SysAppHomeadWare sysapphomeadware,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		ProRules prorules=prorulesServiceImpl.findProRulesById(sysapphomeadware.getSku());
		if(prorules==null){
			map.put(Const.ERROR_INFO, "sku不存在");
			return map;
		}
		Product product=productServiceImpl.findProductById(prorules.getPid()+"");
		if(product==null){
			map.put(Const.ERROR_INFO, "产品不存在");
			return map;
		}
		if(product.getState()!=1) {
			map.put(Const.ERROR_INFO, "产品已下架");
			return map;
		}
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {sysapphomeadware.setUpdatename(user.getuName());
			sysapphomeadwareServiceImpl.updateSysAppHomeadWare(sysapphomeadware);
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
	@RequestMapping(value="/deleteSysAppHomeadWare")
	@ResponseBody
 	public Map<String,Object> deleteSysAppHomeadWare(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			sysapphomeadwareServiceImpl.deleteSysAppHomeadWare(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
