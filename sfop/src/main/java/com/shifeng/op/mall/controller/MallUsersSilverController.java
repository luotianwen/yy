package com.shifeng.op.mall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.op.mall.service.MallUsersSilverService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 我的银币(mall_users_silver)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */ 
@Controller
@RequestMapping(value="/malluserssilver")
public class MallUsersSilverController{
	
	@Resource(name="malluserssilverServiceImpl")
	private MallUsersSilverService malluserssilverServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goMallUsersSilverList")
	public ModelAndView goMallUsersSilverList(ModelAndView mv) throws Exception{
		mv.setViewName("mall/malluserssilverList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param malluserssilver
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllMallUsersSilver")
	@ResponseBody
	public Map<String,Object> findAllMallUsersSilver(Page page,MallUsersSilver malluserssilver) throws Exception{
		if(malluserssilver==null){
			malluserssilver = new MallUsersSilver();
		}
		page.setT(malluserssilver);
		Map<String,Object> map = new HashMap<String,Object>();
		List<MallUsersSilver> malluserssilvers = malluserssilverServiceImpl.findAllMallUsersSilver(page);
		map.put("malluserssilvers", malluserssilvers);
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
	@RequestMapping(value="/goMallUsersSilverEdit")
	@ResponseBody
	public ModelAndView goMallUsersSilverEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("mall/malluserssilverEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findMallUsersSilverById")
	@ResponseBody
	public Map<String,Object> findMallUsersSilverById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		MallUsersSilver malluserssilver = malluserssilverServiceImpl.findMallUsersSilverById(id);
		map.put("malluserssilver",malluserssilver);
		return map;
	}
	
	/**
	 * 新增
	 * @param malluserssilver
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveMallUsersSilver")
	@ResponseBody
	public Map<String,Object> saveMallUsersSilver(MallUsersSilver malluserssilver,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			malluserssilverServiceImpl.saveMallUsersSilver(malluserssilver);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param malluserssilver
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateMallUsersSilver")
	@ResponseBody
	public Map<String,Object> updateMallUsersSilver(MallUsersSilver malluserssilver,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			malluserssilverServiceImpl.updateMallUsersSilver(malluserssilver);
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
	@RequestMapping(value="/deleteMallUsersSilver")
	@ResponseBody
 	public Map<String,Object> deleteMallUsersSilver(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			malluserssilverServiceImpl.deleteMallUsersSilver(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
