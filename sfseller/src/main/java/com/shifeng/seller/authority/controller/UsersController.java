package com.shifeng.seller.authority.controller;

import com.shifeng.seller.authority.service.UsersService;
import com.shifeng.util.Const;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/user")
public class UsersController {

    
    @Resource(name="usersServiceImpl")
    UsersService usersService;

	
//    @Resource(name="avatarUploadOssImpl")
//    AvatarUploadOss avatarUploadOssImpl;
	
	private Logger logger = Logger.getLogger(this.getClass());
	



	
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
			map.clear();
			usersService.updateUserFrozenTypeByUid(userId);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
			map.put(Const.RESPONSE_STATE, 500);
			map.put(Const.ERROR_INFO, "更新失败");
		}
		return map;
	}


	
	
}
