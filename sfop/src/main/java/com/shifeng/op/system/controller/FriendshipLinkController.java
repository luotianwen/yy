package com.shifeng.op.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.system.FriendshipLink;
import com.shifeng.op.system.service.FriendshipLinkService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 友情链接(s_friendship_link)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-23 11:55:35 
 */ 
@Controller
@RequestMapping(value="/friendshiplink")
public class FriendshipLinkController{
	
	@Resource(name="friendshiplinkServiceImpl")
	private FriendshipLinkService friendshiplinkServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goFriendshipLinkList")
	public ModelAndView goFriendshipLinkList(ModelAndView mv) throws Exception{
		mv.setViewName("system/friendshiplinkList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param friendshiplink
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllFriendshipLink")
	@ResponseBody
	public Map<String,Object> findAllFriendshipLink(Page page,FriendshipLink friendshiplink) throws Exception{
		if(friendshiplink==null){
			friendshiplink = new FriendshipLink();
		}
		page.setT(friendshiplink);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FriendshipLink> friendshiplinks = friendshiplinkServiceImpl.findAllFriendshipLink(page);
		map.put("friendshiplinks", friendshiplinks);
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
	@RequestMapping(value="/goFriendshipLinkEdit")
	@ResponseBody
	public ModelAndView goFriendshipLinkEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("system/friendshiplinkEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findFriendshipLinkById")
	@ResponseBody
	public Map<String,Object> findFriendshipLinkById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		FriendshipLink friendshiplink = friendshiplinkServiceImpl.findFriendshipLinkById(id);
		map.put("friendshiplink", friendshiplink);
		return map;
	}
	
	/**
	 * 新增
	 * @param friendshiplink
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveFriendshipLink")
	@ResponseBody
	public Map<String,Object> saveFriendshipLink(FriendshipLink friendshiplink,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			friendshiplink.setUpdatename(user.getuName());
			friendshiplinkServiceImpl.saveFriendshipLink(friendshiplink);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param friendshiplink
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateFriendshipLink")
	@ResponseBody
	public Map<String,Object> updateFriendshipLink(FriendshipLink friendshiplink,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			friendshiplink.setUpdatename(user.getuName());
			friendshiplinkServiceImpl.updateFriendshipLink(friendshiplink);
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
	@RequestMapping(value="/deleteFriendshipLink")
	@ResponseBody
 	public Map<String,Object> deleteFriendshipLink(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			friendshiplinkServiceImpl.deleteFriendshipLink(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
