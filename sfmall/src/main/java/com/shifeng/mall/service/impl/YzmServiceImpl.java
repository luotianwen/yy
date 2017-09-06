package com.shifeng.mall.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.mall.service.YzmService;
import com.shifeng.provide.ali.service.AliService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;

@Service("yzmServiceImpl")
public class YzmServiceImpl implements YzmService{
	@Resource(name = "aliService")
	private AliService aliService;
	
	/**
	 * 短信验证码发送间隔时间
	 */
	static final Integer POST_YZM_INTERVAL_TIME = 60;
	
	/**
	 * 短信验证码有效期
	 */
	static final Integer YZM_VALID_MINUTE = 10;
	
	/**
	 * 短信接收时间
	 */
	public static String SMS_USERID_INTERVAL_TIME_KEY ="SMS:USERID:INTERVAL:%s";
	
	/**
	 * 短信发送次数
	 */
	public static String SMS_USERID_COUNT_KEY ="SMS:USERID:COUNT:%s";
	
	/**
	 * 短信验证码
	 */
	public static String SMS_USERID_YZM_KEY ="SMS:USERID:YZM:%s";
	
	/**
	 * 发送短信手机
	 */
	public static String SMS_USERID_PHONE_KEY ="SMS:USERID:PHONE:%s";
	
	/**
	 * 注册短信接收时间
	 */
	public static String SMS_REG_INTERVAL_TIME_KEY ="SMS:REG:INTERVAL:%s";
	
	/**
	 * 注册短信发送次数
	 */
	public static String SMS_REG_COUNT_KEY ="SMS:REG:COUNT:%s";
	
	/**
	 * 注册短信验证码
	 */
	public static String SMS_REG_YZM_KEY ="SMS:REG:YZM:%s";
	
	/**
	 * 注册发送短信手机
	 */
	public static String SMS_REG_PHONE_KEY ="SMS:REG:PHONE:%s";
	
	/**
	 * 找回密码短信接收时间
	 */
	public static String SMS_FORGET_INTERVAL_TIME_KEY ="SMS:FORGET:INTERVAL:%s";
	
	/**
	 * 找回密码短信发送次数
	 */
	public static String SMS_FORGET_COUNT_KEY ="SMS:FORGET:COUNT:%s";
	
	/**
	 * 找回密码短信验证码
	 */
	public static String SMS_FORGET_YZM_KEY ="SMS:FORGET:YZM:%s";
	
	/**
	 * 找回密码短信手机
	 */
	public static String SMS_FORGET_PHONE_KEY ="SMS:FORGET:PHONE:%s";
	
	/**
	 * 修改密码短信接收时间
	 */
	public static String SMS_PASS_INTERVAL_TIME_KEY ="SMS:PASS:INTERVAL:%s";
	
	/**
	 * 修改密码短信发送次数
	 */
	public static String SMS_PASS_COUNT_KEY ="SMS:PASS:COUNT:%s";
	
	/**
	 * 修改密码短信验证码
	 */
	public static String SMS_PASS_YZM_KEY ="SMS:PASS:YZM:%s";
	
	/**
	 * 修改密码短信手机
	 */
	public static String SMS_PASS_PHONE_KEY ="SMS:PASS:PHONE:%s";
	
	/**
	 * 修改手机短信接收时间
	 */
	public static String SMS_PHONE_INTERVAL_TIME_KEY ="SMS:PHONE:INTERVAL:%s";
	
	/**
	 * 修改手机短信发送次数
	 */
	public static String SMS_PHONE_COUNT_KEY ="SMS:PHONE:COUNT:%s";
	
	/**
	 * 修改手机短信验证码
	 */
	public static String SMS_PHONE_YZM_KEY ="SMS:PHONE:YZM:%s";
	
	/**
	 * 修改手机短信手机
	 */
	public static String SMS_PHONE_PHONE_KEY ="SMS:PHONE:PHONE:%s";
	
	/**
	 * 修改手机是否验证
	 */
	public static String SMS_PHONE_CHECK_KEY ="SMS:PHONE:CHECK:%s";
	
	/**
	 * 修改手机新手机号短信接收时间
	 */
	public static String SMS_NEWPHONE_INTERVAL_TIME_KEY ="SMS:NEWPHONE:INTERVAL:%s";
	
	/**
	 * 修改手机新手机号短信发送次数
	 */
	public static String SMS_NEWPHONE_COUNT_KEY ="SMS:NEWPHONE:COUNT:%s";
	
	/**
	 * 修改手机新手机号短信验证码
	 */
	public static String SMS_NEWPHONE_YZM_KEY ="SMS:NEWPHONE:YZM:%s";
	
	/**
	 * 修改手机新手机号短信手机
	 */
	public static String SMS_NEWPHONE_PHONE_KEY ="SMS:NEWPHONE:NEWPHONE:%s";
	
	/**
	 * 修改手机旧手机号
	 */
	public static String SMS_NEWPHONE_OLDPHONE_KEY ="SMS:NEWPHONE:OLDPHONE:%s";
	
	
	/**
	 * 发送验证码
	 * @param map
	 * @param userId 用户ID
	 * @param phone 手机号
	 */
	public void validateYzmTime(Map<String,String> map,String userId,String phone){
		String time_key = String.format(SMS_USERID_INTERVAL_TIME_KEY, userId);
		String time = RedisTool.get(time_key);
		
		if(!StringUtils.isEmpty(time)){
			map.put(Const.ERROR_INFO, "短信发送间隔为"+POST_YZM_INTERVAL_TIME+"秒，请稍后重试!!!");
			return;
		}
		
		String count_key = String.format(SMS_USERID_COUNT_KEY, userId);
		String count = RedisTool.get(count_key);
		if(!StringUtils.isEmpty(count)&&Integer.valueOf(count)==3){
			map.put(Const.ERROR_INFO, "商家入驻一天最多发送3次验证码！");
			return;
		}
		
		//上次发送短信时间
		RedisTool.incr(time_key);
		RedisTool.expire(time_key, POST_YZM_INTERVAL_TIME);
		//发送短信次数
		RedisTool.incr(count_key);
		RedisTool.expire(count_key, 24*60*60);
		
		// 生成4位数字验证码
		int yzm = (int) (Math.random() * 8999) + 1000;
		ReqResponse<Integer> req = aliService.sendSMS(phone, "{\"code\":\""+yzm+"\",\"product\":\"商家入驻\"}", "SMS_16340212");
		if(req.getCode()==0){
			String yzm_key = String.format(SMS_USERID_YZM_KEY, userId);
			RedisTool.set(yzm_key,yzm+"");
			RedisTool.expire(yzm_key,30*60);
			
			String phone_key = String.format(SMS_USERID_PHONE_KEY, userId);
			RedisTool.set(phone_key,phone+"");
			RedisTool.expire(phone_key,30*60);
			
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "短信发送失败！");
		}
	}
	
	/**
	 * 验证验证码
	 * @param map
	 * @param userId 用户ID
	 * @param phone 手机号
	 * @param yzm 验证码
	 */
	public void verifyYzm(Map<String,String> map,String userId,String phone,String yzm){
		String yzm_key = String.format(SMS_USERID_YZM_KEY, userId);
		String r_yzm = RedisTool.get(yzm_key);
		
		boolean bool = true;
		//验证码是否失效
		if(StringUtils.isEmpty(r_yzm)){
			bool = false;
		}else{
			//验证码是否正确
			if(!yzm.equals(r_yzm)){
				bool = false;
			}else{
				String phone_key = String.format(SMS_USERID_PHONE_KEY, userId);
				String r_phone = RedisTool.get(phone_key);
				//接受短信手机与当前手机是否一致
				if(!phone.equals(r_phone)){
					bool = false;
				}
			}
		}
		
		if(bool){
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		}
		
	}
	
	/**
	 * 注册/找回密码发送验证码
	 * @param map
	 * @param userId 用户ID
	 * @param phone 手机号
	 * @param type 类型(1:注册;2:找回密码;3:修改密码;4:修改手机[旧手机号];5:修改手机[新手机号])
	 */
	public void postYzmTime(Map<String,String> map,String phone,int type){
		String time_key = "";
		String count_key = "";
		String yzm_key = "";
		String phone_key = "";
		String content = "";
		
		if(type==1){
			time_key = String.format(SMS_REG_INTERVAL_TIME_KEY, phone);
			count_key = String.format(SMS_REG_COUNT_KEY, phone);
			yzm_key = String.format(SMS_REG_YZM_KEY, phone);
			phone_key = String.format(SMS_REG_PHONE_KEY, phone);
			content = "注册";
		}else if(type==2){
			time_key = String.format(SMS_FORGET_INTERVAL_TIME_KEY, phone);
			count_key = String.format(SMS_FORGET_COUNT_KEY, phone);
			yzm_key = String.format(SMS_FORGET_YZM_KEY, phone);
			phone_key = String.format(SMS_FORGET_PHONE_KEY, phone);
			content = "找回密码";
		}else if(type==3){
			time_key = String.format(SMS_PASS_INTERVAL_TIME_KEY, phone);
			count_key = String.format(SMS_PASS_COUNT_KEY, phone);
			yzm_key = String.format(SMS_PASS_YZM_KEY, phone);
			phone_key = String.format(SMS_PASS_PHONE_KEY, phone);
			content = "修改密码";
		}else if(type==4){
			time_key = String.format(SMS_PHONE_INTERVAL_TIME_KEY, phone);
			count_key = String.format(SMS_PHONE_COUNT_KEY, phone);
			yzm_key = String.format(SMS_PHONE_YZM_KEY, phone);
			phone_key = String.format(SMS_PHONE_PHONE_KEY, phone);
			content = "修改手机号";
		}else if(type==5){
			time_key = String.format(SMS_NEWPHONE_INTERVAL_TIME_KEY, phone);
			count_key = String.format(SMS_NEWPHONE_COUNT_KEY, phone);
			yzm_key = String.format(SMS_NEWPHONE_YZM_KEY, phone);
			phone_key = String.format(SMS_NEWPHONE_PHONE_KEY, phone);
			content = "修改手机号";
		}
		
		
		String time = RedisTool.get(time_key);
		
		if(!StringUtils.isEmpty(time)){
			map.put(Const.ERROR_INFO, "短信发送间隔为"+POST_YZM_INTERVAL_TIME+"秒，请稍后重试!!!");
			return;
		}
		
		String count = RedisTool.get(count_key);
		if(!StringUtils.isEmpty(count)&&Integer.valueOf(count)==3){
			map.put(Const.ERROR_INFO, "用户"+content+"一天最多发送3次验证码！");
			return;
		}
		
		//上次发送短信时间
		RedisTool.incr(time_key);
		RedisTool.expire(time_key, POST_YZM_INTERVAL_TIME);
		//发送短信次数
		RedisTool.incr(count_key);
		RedisTool.expire(count_key, 24*60*60);
		
		// 生成4位数字验证码
		int yzm = (int) (Math.random() * 8999) + 1000;
		ReqResponse<Integer> req = aliService.sendSMS(phone, "{\"code\":\""+yzm+"\",\"type\":\""+content+"\"}", "SMS_66610137");
		if(req.getCode()==0){
			RedisTool.set(yzm_key,yzm+"");
			RedisTool.expire(yzm_key,YZM_VALID_MINUTE*60);
			
			RedisTool.set(phone_key,phone+"");
			RedisTool.expire(phone_key,YZM_VALID_MINUTE*60);
			
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		}else{
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "短信发送失败！");
		}
	}
	
	/**
	 * 注册/找回密码验证验证码
	 * @param userId 用户ID
	 * @param phone 手机号
	 * @param yzm 验证码
	 * @param type 类型(1:注册;2:找回密码;3:修改密码;4:修改手机[旧手机号];5:修改手机[新手机号])
	 */
	public boolean postYzm(String phone,String yzm,int type){
		String yzm_key = "";
		String phone_key = "";
		if(type==1){
			yzm_key = String.format(SMS_REG_YZM_KEY, phone);
			phone_key = String.format(SMS_REG_PHONE_KEY, phone);
		}else if(type==2){
			yzm_key = String.format(SMS_FORGET_YZM_KEY, phone);
			phone_key = String.format(SMS_FORGET_PHONE_KEY, phone);
		}else if(type==3){
			yzm_key = String.format(SMS_PASS_YZM_KEY, phone);
			phone_key = String.format(SMS_PASS_PHONE_KEY, phone);
		}else if(type==4){
			yzm_key = String.format(SMS_PHONE_YZM_KEY, phone);
			phone_key = String.format(SMS_PHONE_PHONE_KEY, phone);
		}else if(type==5){
			yzm_key = String.format(SMS_NEWPHONE_YZM_KEY, phone);
			phone_key = String.format(SMS_NEWPHONE_PHONE_KEY, phone);
		}
		
		String r_yzm = RedisTool.get(yzm_key);
		
		boolean bool = true;
		//验证码是否失效
		if(StringUtils.isEmpty(r_yzm)){
			bool = false;
		}else{
			//验证码是否正确
			if(!yzm.equals(r_yzm)){
				bool = false;
			}else{
				String r_phone = RedisTool.get(phone_key);
				//接受短信手机与当前手机是否一致
				if(!phone.equals(r_phone)){
					bool = false;
				}
			}
		}
		
		if(bool){
			if(type==4){
				String check = String.format(SMS_PHONE_CHECK_KEY, phone);
				RedisTool.incr(check);
				RedisTool.expire(check, 30*60);
			}
			RedisTool.del(yzm_key);
		}
		
		return bool;
		
	}
	
	/**
	 * 是否通过旧手机验证
	 * @param phone
	 */
	public boolean check_oldphone(String phone){
		String check = String.format(SMS_PHONE_CHECK_KEY, phone);
		if(!StringUtils.isEmpty(check)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 缓存记录两次手机号码
	 * @param phone
	 * @param newPhone
	 */
	public void setPhone(String phone,String newPhone){
		String key = String.format(SMS_NEWPHONE_OLDPHONE_KEY, phone);
		RedisTool.set(key,newPhone);
		RedisTool.expire(key,YZM_VALID_MINUTE*60);
	}
	
	/**
	 * 验证新手机号码是否一致
	 * @param phone
	 * @param newPhone
	 */
	public boolean verifyPhone(String phone,String newPhone){
		String key = String.format(SMS_NEWPHONE_OLDPHONE_KEY, phone);
		
		String setPhone = RedisTool.get(key);
		if(newPhone.equals(setPhone)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 入驻信息保存，删除验证码缓存
	 */
	public void delSettled(String userId){
		String yzm_key = String.format(SMS_USERID_YZM_KEY, userId);
		RedisTool.del(yzm_key);
	}
	
}
