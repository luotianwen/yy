package com.shifeng.op.authority.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.op.entity.authority.Arrays;
import com.shifeng.op.entity.authority.Roles;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.authority.service.ArraysService;
import com.shifeng.util.Const;
/** 
 * 系统分组表(arrays)实体类
 * @author 世峰户外商城 
 * @version Revision: 1.00 
 */ 
@Controller
@RequestMapping(value="/arrays")
public class ArraysController {
	
	@Resource(name="arraysServiceImpl")
	private ArraysService arraysServiceImpl;

	/**
	 * 跳转新增分组页面
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/goArrayAdd")
	@ResponseBody
	public ModelAndView goArrayAdd(ModelAndView mv){
		mv.setViewName("admin/authority/arrayAdd");
		return mv;
	}
	
	/**
	 * 方法描述：查询系统分组以及对应的角色
	 * 返回类型：ModelAndView
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getArrayList")
	public ModelAndView getArrayList(HttpSession session,@RequestParam(value="aId",required=false) String aId)throws Exception{
		ModelAndView mv = new ModelAndView();
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		// 根据当前用户身份查询不同角色分组
		List<Arrays> arrays = arraysServiceImpl.getArrayList(user);
		List<Roles> roles = null;
		// 避免删除该分组重新加载匹配不上分组ID问题
		boolean eq = true;
		// 匹配选中分组对应的角色信息
		if(!StringUtils.isEmpty(aId) && arrays.size()>0){
			int aLength = arrays.size();
			for(int i=0;i<aLength;i++){
				Arrays array = arrays.get(i);
				if(array.getaId().equals(aId)){// 匹配客户端选择的分组ID
					roles = array.getRoles();
					eq = false;
					break;
				}
			}
		}
		// 默认显示第一个分组的角色信息
		// eq:aId有值但是未匹配上（删除当前分组后刷新再次请求该方法保留了上次的分组ID出现的问题）
		if((eq || StringUtils.isEmpty(aId) ) && arrays.size()>0){
			roles = arrays.get(0).getRoles();
			aId = arrays.get(0).getaId();
		}
		mv.addObject("arrays", arrays);
		mv.addObject("roles", roles);
		mv.addObject("aId", aId);
		mv.setViewName("admin/authority/arrayList");
		return mv;
	}
	
	/**
	 * 方法描述：新增分组
	 * 返回类型：Map<String,Object>
	 * @param aName
	 * @return
	 */
	@RequestMapping(value="/insertArray")
	@ResponseBody
	public Map<String,Object> insertArray(HttpSession session,Arrays array){
		Map<String,Object> map = new HashMap<String,Object>();;
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		array.setaUpTime(new Date());
		array.setaUpUser(user.getuId());
		array.setaCreateUser(user.getuId());
		if(user.getuType() == 4){
			array.setaType(1);
		}else{
			array.setaType(2);
		}
		map.put("array", array);
		try {
			arraysServiceImpl.insertArray(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 方法描述：删除分组
	 * 返回类型：Map<String,Object>
	 * @param aId
	 * @return
	 */
	@RequestMapping(value="/deleteArray")
	@ResponseBody
	public Map<String,Object> deleteArray(@RequestParam(value="aId") String aId){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("aId", aId);
		try {
			arraysServiceImpl.deleteArray(map);
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "删除异常，请稍后重试!");
		}
		return map;
	}
 
	/**
	 * 方法描述：跳转更新分组页面
	 * 返回类型：ModelAndView
	 * @param aId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUpdateArrayView")
	public ModelAndView goUpdateArrayView(@RequestParam(value="aId") String aId) throws Exception{
		ModelAndView mv = new ModelAndView();
		Arrays array = arraysServiceImpl.getArrayById(aId);
		mv.addObject("array", array);
		mv.setViewName("admin/authority/arrayEdit");
		return mv;
		
	}
	
	/**
	 * 方法描述：修改
	 * 返回类型：Map<String,Object>
	 * @param session
	 * @param array
	 * @return
	 */
	@RequestMapping(value="/updateArray")
	@ResponseBody
	public Map<String,Object> updateArray(HttpSession session,Arrays array){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
			array.setaUpTime(new Date());
			array.setaUpUser(user.getuId());
			map.put("array", array);
			arraysServiceImpl.updateArray(map);
		} catch (Exception e) {
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "修改异常，请稍后重试!");
		}
		return map;
	}
}
