package com.shifeng.webapi.controller.user;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Objects;
import com.shifeng.dto.login.JointLoginDTO;
import com.shifeng.entity.user.JointLogin;
import com.shifeng.entity.user.SysUser;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.provide.weixin.service.WeiXinService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;
import com.shifeng.util.MD5Util;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.dto.UserDTO;
import com.shifeng.webapi.util.rsa.RSAUtils;

@Controller
public class LoginController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "sysUserService")
	protected SysUserService userService;
	
	@Value("#{properties['weixin.appid']}")
	private String appid;
	@Value("#{properties['weixin.secret']}")
	private String secret;
	
	@Resource(name = "weiXinService")
	protected WeiXinService weiXinService;
	
	/**
	 * 用户登录
	 * @param version	版本号
	 * @param ticket	
	 * @param account	账户名/手机号/邮箱
	 * @param password	密码
	 * @param sign	md5(version+ ticket + account+ password)
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public ReqResponse<UserDTO> login(String version,String ticket,String account,String password,String sign){
		ReqResponse<UserDTO> req = new ReqResponse<UserDTO>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"login", req)){
    		return req;
    	}
		try {
			//验证版本号
			switch (version) {
			case ApiVersion.V_1_0_0:
						//验证签名
						if(this.verifySign(sign, version+ ticket + account+ password,req)){
							//解密密码
							password = RSAUtils.decryptByPrivateKey(password);
							logger.info("解密后密码:"+password);
							ReqResponse<SysUser> result = userService.checkPassword(account, password);
							if(result.getCode() == 0){
								SysUser sysUser = result.getData();
								UserDTO user = new UserDTO(sysUser);
								String token = MD5Util.hexSALT(user.getId()+"");
								user.setToken(token);
								
								

								String key = String.format(Constant.USER_ID_TOKEN_KEY, token);
								//计算当天到24点还剩下多少秒
								Long s = DateUtil.currentDayResidueTime()/1000;
								//token写入redis缓存
								RedisTool.set(key, user.getId()+"");
								//设置过期时间
								RedisTool.expire(key, s.intValue());
								
								key = String.format(Constant.USER_TOKEN_KEY, token);
								//sysUser写入redis缓存
								RedisTool.set(key, JSON.toJSONString(sysUser));
								//设置过期时间
								RedisTool.expire(key, s.intValue());
								
								
								
								/*String key = String.format(Constant.USER_TOKEN_KEY, token);
								//计算当天到24点还剩下多少秒+10800秒
								Long s = DateUtil.currentDayResidueTime()/1000+1*60*60*3;
								//token写入redis缓存
								RedisTool.set(key, user.getId()+"");
								//设置过期时间
								RedisTool.expire(key, s.intValue());*/
								req.setCode(0);
								req.setData(user);
							}else{
								req.setCode(ErrorMsg.ACCOUNT_PASSWORD_ERROR.getCode());
								req.setMsg(ErrorMsg.ACCOUNT_PASSWORD_ERROR.getMsg());
							}
						}else{
							req.setCode(ErrorMsg.INVALID_SIGN.getCode());
							req.setMsg(ErrorMsg.INVALID_SIGN.getMsg());
						}
				break;

			default:
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
			}
			
		} catch (Exception e) {
			logger.info("用户登录出错：",e);
			req.setCode(ErrorMsg.SYSTEM_ERROR.getCode());
			req.setMsg(ErrorMsg.SYSTEM_ERROR.getMsg());
		}
		return req;
	}
	
	/**
	 * 微信登录
	 * @param version 版本号
	 * @param ticket 
	 * @param code微信返回的code
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/wxlogin")
	@ResponseBody
	public ReqResponse<UserDTO> wxlogin(String version,String ticket,String code,String sign){
		ReqResponse<UserDTO> req = new ReqResponse<UserDTO>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"wxlogin", req)){
    		return req;
    	}
		try {
			//验证版本号
			switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(Objects.equal(sign, MD5Util.hex(version+ ticket + code))){
					ReqResponse<JointLoginDTO> user = weiXinService.login(appid, secret, code);
					if(user.getCode() == 0){
						JointLoginDTO jointLoginDTO = user.getData();
						JointLogin jointLogin = jointLoginDTO.getJointLogin();
						UserDTO loginUser = new UserDTO(jointLoginDTO.getUser());
						loginUser.setOpenid(jointLogin.getOpenid());
						loginUser.setLoginType(jointLogin.getLoginType());
						String token = MD5Util.hexSALT(loginUser.getId()+"");
						loginUser.setToken(token);
						String key = String.format(Constant.USER_ID_TOKEN_KEY, token);
						String openid_key = String.format(Constant.WX_OPENID_TOKEN_KEY, token);
						
						//计算当天到24点还剩下多少秒
						Long s = DateUtil.currentDayResidueTime()/1000;
						//token写入redis缓存
						RedisTool.set(key, loginUser.getId()+"");
						//设置过期时间
						RedisTool.expire(key, s.intValue());
						
						//openid写入redis缓存
						RedisTool.set(openid_key, jointLogin.getOpenid());
						//设置过期时间
						RedisTool.expire(openid_key, s.intValue());
						
						key = String.format(Constant.USER_TOKEN_KEY, token);
						//token写入redis缓存
						RedisTool.set(key, JSON.toJSONString(loginUser));
						//设置过期时间
						RedisTool.expire(key, s.intValue());
						
						req.setCode(0);
						req.setData(loginUser);
					}else{
						req.setCode(10003);
						req.setMsg("登录出错");
					}
				}
				
				break;
			default:
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
			}
		} catch (Exception e) {
			logger.info("微信用户登录出错：",e);
			req.setCode(ErrorMsg.SYSTEM_ERROR.getCode());
			req.setMsg(ErrorMsg.SYSTEM_ERROR.getMsg());
		}
		
		
		
		return req;
	}
	
}
