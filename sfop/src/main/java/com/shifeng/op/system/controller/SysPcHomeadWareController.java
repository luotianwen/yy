package com.shifeng.op.system.controller;

import com.shifeng.entity.product.ProRules;
import com.shifeng.entity.product.Product;
import com.shifeng.entity.system.SysPcHomeadWare;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.product.service.ProRulesService;
import com.shifeng.op.product.service.ProductService;
import com.shifeng.op.system.service.SysPcHomeadWareService;
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
 * pc首页广告商品(sys_pc_homead_ware)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 18:27:40 
 */ 
@Controller
@RequestMapping(value="/syspchomeadware")
public class SysPcHomeadWareController{
	
	@Resource(name="syspchomeadwareServiceImpl")
	private SysPcHomeadWareService syspchomeadwareServiceImpl;
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
	@RequestMapping(value="/goSysPcHomeadWareList")
	public ModelAndView goSysPcHomeadWareList(ModelAndView mv,String ad_id) throws Exception{
		mv.addObject("ad_id",ad_id);
		
		mv.setViewName("system/syspchomeadwareList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param syspchomeadware
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllSysPcHomeadWare")
	@ResponseBody
	public Map<String,Object> findAllSysPcHomeadWare(Page page,SysPcHomeadWare syspchomeadware) throws Exception{
		if(syspchomeadware==null){
			syspchomeadware = new SysPcHomeadWare();
		}
		page.setT(syspchomeadware);
		Map<String,Object> map = new HashMap<String,Object>();
		List<SysPcHomeadWare> syspchomeadwares = syspchomeadwareServiceImpl.findAllSysPcHomeadWare(page);
		map.put("syspchomeadwares", syspchomeadwares);
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
	@RequestMapping(value="/goSysPcHomeadWareEdit")
	@ResponseBody
	public ModelAndView goSysPcHomeadWareEdit(ModelAndView mv,String id,String ad_id) throws Exception{
		mv.addObject("id", id);
		mv.addObject("ad_id", ad_id);
		mv.setViewName("system/syspchomeadwareEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findSysPcHomeadWareById")
	@ResponseBody
	public Map<String,Object> findSysPcHomeadWareById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		SysPcHomeadWare syspchomeadware = syspchomeadwareServiceImpl.findSysPcHomeadWareById(id);
		map.put("syspchomeadware",syspchomeadware);
		return map;
	}
	
	/**
	 * 新增
	 * @param syspchomeadware
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSysPcHomeadWare")
	@ResponseBody
	public Map<String,Object> saveSysPcHomeadWare(SysPcHomeadWare syspchomeadware,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		ProRules prorules=prorulesServiceImpl.findProRulesById(syspchomeadware.getSku());
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
			syspchomeadware.setUpdatename(user.getuName());
			syspchomeadwareServiceImpl.saveSysPcHomeadWare(syspchomeadware);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param syspchomeadware
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateSysPcHomeadWare")
	@ResponseBody
	public Map<String,Object> updateSysPcHomeadWare(SysPcHomeadWare syspchomeadware,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		ProRules prorules=prorulesServiceImpl.findProRulesById(syspchomeadware.getSku());
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
		try {
			syspchomeadware.setUpdatename(user.getuName());
			syspchomeadwareServiceImpl.updateSysPcHomeadWare(syspchomeadware);
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
	@RequestMapping(value="/deleteSysPcHomeadWare")
	@ResponseBody
 	public Map<String,Object> deleteSysPcHomeadWare(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			syspchomeadwareServiceImpl.deleteSysPcHomeadWare(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
