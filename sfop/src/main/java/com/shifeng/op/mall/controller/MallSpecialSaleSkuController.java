package com.shifeng.op.mall.controller;

import com.shifeng.entity.mall.MallSpecialSaleSku;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.mall.service.MallSpecialSaleSkuService;
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
 * 特卖商品(mall_special_sale_sku)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-22 16:46:48 
 */ 
@Controller
@RequestMapping(value="/mallspecialsalesku")
public class MallSpecialSaleSkuController{
	
	@Resource(name="mallspecialsaleskuServiceImpl")
	private MallSpecialSaleSkuService mallspecialsaleskuServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallSpecialSaleSkuList")
	public ModelAndView goMallSpecialSaleSkuList(ModelAndView mv,String pid) throws Exception{
		mv.addObject("pid",pid);
		mv.setViewName("mall/mallspecialsaleskuList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param mallspecialsalesku
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallSpecialSaleSku")
	@ResponseBody
	public Map<String,Object> findAllMallSpecialSaleSku(Page page,MallSpecialSaleSku mallspecialsalesku) throws Exception{
		if(mallspecialsalesku==null){
			mallspecialsalesku = new MallSpecialSaleSku();
		}
		page.setT(mallspecialsalesku);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallSpecialSaleSku> mallspecialsaleskus = mallspecialsaleskuServiceImpl.findAllMallSpecialSaleSku(page);
		map.put("mallspecialsaleskus", mallspecialsaleskus);
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
	@RequestMapping(value="/goMallSpecialSaleSkuEdit")
	@ResponseBody
	public ModelAndView goMallSpecialSaleSkuEdit(ModelAndView mv,String id,String pid) throws Exception{
		mv.addObject("id", id);
		mv.addObject("pid", pid);
		mv.setViewName("mall/mallspecialsaleskuEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallSpecialSaleSkuById")
	@ResponseBody
	public Map<String,Object> findMallSpecialSaleSkuById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallSpecialSaleSku mallspecialsalesku = mallspecialsaleskuServiceImpl.findMallSpecialSaleSkuById(id);
		map.put("mallspecialsalesku",mallspecialsalesku);
		return map;
	}
	
	/**
	 * 新增
	 * @param mallspecialsalesku
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallSpecialSaleSku")
	@ResponseBody
	public Map<String,Object> saveMallSpecialSaleSku(MallSpecialSaleSku mallspecialsalesku,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {

			mallspecialsaleskuServiceImpl.saveMallSpecialSaleSku(mallspecialsalesku);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, e.getMessage());
		}
		return map;
	}


	/**
	 * 修改
	 * @param mallspecialsalesku
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallSpecialSaleSku")
	@ResponseBody
	public Map<String,Object> updateMallSpecialSaleSku(MallSpecialSaleSku mallspecialsalesku,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			mallspecialsaleskuServiceImpl.updateMallSpecialSaleSku(mallspecialsalesku);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, e.getMessage());
		}
		return map;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteMallSpecialSaleSku")
	@ResponseBody
 	public Map<String,Object> deleteMallSpecialSaleSku(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			mallspecialsaleskuServiceImpl.deleteMallSpecialSaleSku(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
