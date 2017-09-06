package com.shifeng.op.authority.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.op.authority.service.AuthorizationService;
import com.shifeng.util.Const;
/** 
 * 系统权限表(authorization)实体类
 * @author 世峰户外商城 
 * @version Revision: 1.00 
 */ 
@Controller
@RequestMapping(value="/authorization")
public class AuthorizationController {
	
	@Resource(name="authorizationServiceImpl")
	private AuthorizationService authorizationServiceImpl;


	/**
	 * 方法描述：绑定该角色菜单资源
	 * 返回类型：Map<String,Object>
	 * @param rId
	 * @return
	 */
	@RequestMapping(value="/linkRoleMenus")
	@ResponseBody
	public Map<String,Object> linkRoleMenus(@RequestParam String rId,@RequestParam String ids){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		try {
			authorizationServiceImpl.savelinkRoleMenus(rId,ids,map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, map.get(Const.ERROR_INFO)==null?"保存数据异常，请稍后重试!!!":map.get(Const.ERROR_INFO));
		}
		return map;
	}
}
