package com.shifeng.op.authority.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.shifeng.op.entity.users.UserInfo;
import com.shifeng.plugin.page.Page;
import com.shifeng.op.authority.service.RolesService;
import com.shifeng.op.authority.service.UsersService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.op.entity.users.Users;
import com.shifeng.op.authority.service.ArraysService;
import com.shifeng.util.Const;
import com.shifeng.util.MD5Util;

/**
 * 
*    
* 项目名称：compass-data   
* 类名称：TestUserController   
* 类描述：   会员管理
* 修改备注：   
* @version    
*
 */
@Controller
@RequestMapping(value="/user")
public class UsersController {

    
    @Resource(name="usersServiceImpl")
    UsersService usersService;

	@Resource(name="rolesServiceImpl")
	private RolesService rolesServiceImpl;
	
	@Resource(name="arraysServiceImpl")
	private ArraysService arraysServiceImpl;
	

	
	private Logger logger = Logger.getLogger(this.getClass());
	
    /**
     * 获取系统用户列表
     * @param page
     * @param users
     * @return
     * @throws Exception
     */
	@RequestMapping(value="sysList")
	public ModelAndView sysList()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/user/sysUser");
		return mv;
	}

	@RequestMapping(value="sysUserList")
	@ResponseBody
	public Map<String,Object> sysUserList(Page<Users> page, Users users)throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		page.setT(users);
		List<Users> usersList = usersService.getSysListPage(page);
		map.put("usersList", usersList);
		map.put("page", page);
		return map;
	}
	
    
	/**
	 * 根据用户ID 获取系统用户详细信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goEditSysUser/{userId}")
	public ModelAndView goEditSysUser(@PathVariable("userId") String userId)throws Exception{ 
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("userId", userId);
		mv.setViewName("admin/user/editSysUser");
		return mv;
	}	

	/**
	 * 去新增系统用户页面
	 * @return
	 * @throws Exception
	 */ 
	@RequestMapping(value="goAddSysUser")
	public ModelAndView goAddSysUser()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/user/editSysUser");
		return mv;
	}
	
	@RequestMapping("/findUserById")
	@ResponseBody
	public Map<String,Object> findUserById(String userId)throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		//获取系统用户信息
		UserInfo user = usersService.findSysUserById(userId);
		map.put("user", user);
		
		//获取分组
		List<Map<String,Object>> arrays = arraysServiceImpl.getSysArrayList();
		map.put("arrays", arrays);
		if(user!=null){
			if(!StringUtils.isEmpty(user.getaId())){
				//获取角色
				List<Map<String,Object>> roles = rolesServiceImpl.getSysUserRoleByaId(user.getaId()) ;
				map.put("roles", roles);
			}else{
				map.put("roles", null);
			}
		}else{
			map.put("roles", null);
		}
		
		return map;
	}
	
	/**
	 * 新增系统用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addSysUser")
	@ResponseBody
	public Map<String,Object> addSysUser(UserInfo user,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			Users user2 = (Users)SecurityUtils.getSubject().getSession().getAttribute(Const.OP_SESSION_USER);
			map.put("newPassword", request.getParameter("newPassword"));
			map.put("user", user);
			usersService.saveSysUser(map,user2);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "保存异常!!!");
		}
		return map;
	}
	
	/**
	 * 更改用户冻结状态
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="userFrozen/{userId}")
	@ResponseBody
	public Map<String,Object> userFrozen(@PathVariable("userId") String userId){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			Users user2 = (Users)SecurityUtils.getSubject().getSession().getAttribute(Const.OP_SESSION_USER);
			map.clear();
			usersService.updateUserFrozenTypeByUid(userId,user2);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "更新异常");
		}
		return map;
	}


	
	/**
	 * 删除系统用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="delSysUser/{userId}")
	@ResponseBody
	public Map<String,Object> delSysUser(@PathVariable("userId") String userId){
		Map<String,Object> map = new HashMap<String,Object>();;
		try {
			map.clear();
			Users user = (Users)SecurityUtils.getSubject().getSession().getAttribute(Const.OP_SESSION_USER);
			usersService.deleteSysUser(userId,user);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "删除异常!!!");
		}
		return map;
	}	
	


	
	/**
	 * 跳转修改系统用户密码页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="sysUserPassword")
	public ModelAndView sysUserPassword(ModelAndView mv)throws Exception{ 
		mv.setViewName("admin/user/sysUserPassword");
		return mv;
	}	
	
	/**
	 * 修改系统用户密码页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateSysUserPassword")
	@ResponseBody
	public Map<String,Object> updateSysUserPassword(ModelAndView mv,HttpServletRequest request)throws Exception{ 
		Map<String,Object> map = new HashMap<String,Object>();
		String uPassword = request.getParameter("uPassword");
		String newPassword = request.getParameter("newPassword");
		String checkPassword = request.getParameter("checkPassword");
		Users user = (Users)SecurityUtils.getSubject().getSession().getAttribute(Const.OP_SESSION_USER);
		//判断原密码是否正确
		if(user.getuPassword().equals(MD5Util.hex(uPassword))){
			if(newPassword.equals(checkPassword)){
				map.put("newPassword",MD5Util.hex(newPassword));
				map.put("uPassword", MD5Util.hex(uPassword));
				map.put("userId", user.getuId());
				try {
					usersService.updateSysUserPassword(map,uPassword,newPassword,user);
					user.setuPassword(map.get("newPassword").toString());
					map.clear();				
					map.put("msg", "密码修改成功");
					map.put("result", "true");
				} catch (Exception e) {
					map.clear();				
					map.put("msg", "密码修改失败");
					map.put("result", "err");
				}
			}else{
				map.put("msg", "新密码两次输入不一致");
				map.put("result", "err");
			}
		}else{
			map.put("msg", "原密码输入错误！");
			map.put("result", "err");
		}
		return map;
	}		
	
	
}
