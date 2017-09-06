package com.shifeng.webapi.controller.fx;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.dto.fx.FxTotalDTO;
import com.shifeng.dto.fx.FxUserDTO;
import com.shifeng.dto.fx.FxUserMoneyDTO;
import com.shifeng.dto.fx.order.FxTotalOrderDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.fx.FxService;
import com.shifeng.webapi.service.fx.FxUserService;
import com.shifeng.webapi.service.user.RegisterService;
import com.shifeng.webapi.util.VerifiersUtil;

/**
 * 我的分销API接口
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/Myfx")
public class MyFxUserController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "fxUserServiceImpl")
	protected FxUserService fxUserService;
	
	@Resource(name = "fxServiceImpl")
	protected FxService FxService;
	
	@Resource(name = "registerServiceImpl")
	protected RegisterService registerService;

	/**
	 * 检测手机号是否存在
	 * @param version	版本号
	 * @param token	
	 * @param phone	手机号
	 * @param sign	md5(version+ token + phone)
	 * @return
	 */
/*	@RequestMapping(value = "/checkPhoneExists")
	@ResponseBody
	public ReqResponse<String> checkPhoneExists(String version,String token,String phone,String sign){
		ReqResponse<String> req = new ReqResponse<String>();

		//访问权限验证
		if(!this.checkLogin(token,"Myfx/checkPhoneExists", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + phone,req)){
					boolean bl = fxUserService.isPhoneExists(phone);
					if(bl){
						req.setCode(10002);
						req.setMsg("账户已存在");
						req.setData(phone);
					}else{
						req.setCode(0);
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		return req;
	}*/
	
	 
	/**
	 * 添加我的分销用户
	 * @param version	版本号
	 * @param token	
	 * @param phone	手机号
	 * @param sign	md5(version+ token + phone)
	 * @return
	 */
	@RequestMapping(value = "/addFxUser")
	@ResponseBody
	public ReqResponse<String> addFxUser(String version,String token,String name,String phone,String remark,String sign){
		ReqResponse<String> req = new ReqResponse<String>();

		//访问权限验证
		if(!this.checkLogin(token,"Myfx/addFxUser", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + name + phone + remark,req)){
					boolean bl = VerifiersUtil.validatePhone(phone);
					if(bl){
						bl = fxUserService.isPhoneExists(phone);
						if(!bl){
							req.setCode(10002);
							req.setMsg("账户已存在");
							req.setData(phone);
						}else{
							bl = fxUserService.addDistributor(this.user_id, name, phone, remark);
							if(!bl){
								req.setCode(10002);
								req.setMsg("账户已存在");
								req.setData(phone);
							}else{
								req.setCode(0);
							}
						}
					}else{
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("手机号格式不正确");
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		return req;
	}
	
	

	
	 
	/**
	 * 删除我的分销用户
	 * @param version	版本号
	 * @param token	
	 * @param recommended_userid 被推荐用户id
	 * @param sign	md5(version+ token + recommended_userid)
	 * @return
	 */
	@RequestMapping(value = "/deleteFxUser")
	@ResponseBody
	public ReqResponse<String> deleteFxUser(String version,String token,String recommended_userid,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/deleteFxUser", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + recommended_userid,req)){
						boolean bl = fxUserService.deleteDistributor(this.user_id, recommended_userid);
						if(!bl){
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg(ErrorMsg.FAIL.getMsg());
						}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}	

	
	

	
	 
	/**
	 * 修改我的分销商
	 * @param version	版本号
	 * @param token	
	 * @param recommended_userid 被推荐用户id
	 * @param sign	md5(version+ token + recommended_userid+name+remark)
	 * @return
	 */
	@RequestMapping(value = "/editFxUser")
	@ResponseBody
	public ReqResponse<String> editFxUser(String version,String token,String recommended_userid,String name,String remark,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/editFxUser", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + recommended_userid+name+remark,req)){
						boolean bl = fxUserService.updateDistributor(this.user_id, recommended_userid,name,remark);
						if(!bl){
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg(ErrorMsg.FAIL.getMsg());
						}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}	
	
	


	
	 
	/**
	 * 获取我的分销商列表
	 * @param version
	 * @param token
	 * @param name
	 * @param phone
	 * @param currentPage
	 * @param sign (version+ token + name + phone + currentPage)name/phone为空不参加签名
	 * @return
	 */
	@RequestMapping(value = "/getFxUserList")
	@ResponseBody
	public ReqResponse<Page> getFxUserList(String version,String token,String name,String phone,Integer currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/getFxUserList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				StringBuffer content = new StringBuffer();
				content.append(version+ token);
				if(!StringUtils.isBlank(name)){
					content.append(name);
				}
				if(!StringUtils.isBlank(phone)){
					content.append(phone);
				}
				content.append(currentPage);
				//验证签名
				if(this.verifySign(sign, content.toString(),req)){
					if(null == currentPage){
						currentPage =1;
					}
						Page page = fxUserService.getDistributorList(this.user_id, name,phone,currentPage);
						req.setData(page);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}	
	
	/**
	 * 获取我的分销商详情
	 * @param version	版本号
	 * @param token	
	 * @param recommended_userid 被推荐用户id
	 * @param sign	md5(version+ token + recommended_userid)
	 * @return
	 */
	@RequestMapping(value = "/getFxUserInfo")
	@ResponseBody
	public ReqResponse<FxUserDTO> getFxUserInfo(String version,String token,String recommended_userid,String sign){
		ReqResponse<FxUserDTO> req = new ReqResponse<FxUserDTO>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/getFxUserInfo", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token + recommended_userid,req)){
					 FxUserDTO fxUser = fxUserService.getDistributorById(this.user_id, recommended_userid);
					 req.setData(fxUser);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}	
	
	/**
	 * 获取我的分销商列表
	 * @param version
	 * @param token
	 * @param day	（0：全部订单；1：今日订单；2：昨天订单；3：本周订单；4：本月订单）
	 * @param recommended_userid 我的分销用户id
	 * @param currentPage
	 * @param sign (version+ token + day+ recommended_userid + currentPage)  day/recommended_userid 为空不参加签名
	 * @return
	 */
	@RequestMapping(value = "/getMyFxOrderList")
	@ResponseBody
	public ReqResponse<Page> getMyFxOrderList(String version,String token,String day,String recommended_userid,Integer currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/getMyFxOrderList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				StringBuffer content = new StringBuffer();
				content.append(version+ token);
				if(StringUtils.isNotBlank(day)){
					content.append(day);
				}
				if(StringUtils.isNotBlank(recommended_userid)){
					content.append(recommended_userid);
				}
				content.append(currentPage);
				//验证签名
				if(this.verifySign(sign, content.toString(),req)){
					if(null == currentPage){
						currentPage =1;
					}
					Page page = FxService.getMyFxOrderList(this.user_id, day,recommended_userid,currentPage);
					req.setData(page);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	
	/**
	 * 获取我的分销总计
	 * @param version
	 * @param token
	 * @param sign (version+ token)
	 * @return
	 */
	@RequestMapping(value = "/getMyFxTotal")
	@ResponseBody
	public ReqResponse<FxTotalDTO> getMyFxTotal(String version,String token,String sign){
		ReqResponse<FxTotalDTO> req = new ReqResponse<FxTotalDTO>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/getMyFxTotal", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token,req)){
					FxTotalDTO total = FxService.getFxTotal(this.user_id);
					req.setData(total);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	
	/**
	 * 获取我的分销订单总计
	 * @param version
	 * @param token
	 * @param sign (version+ token)
	 * @return
	 */
	@RequestMapping(value = "/getMyFxOrderTotal")
	@ResponseBody
	public ReqResponse<FxTotalOrderDTO> getMyFxOrderTotal(String version,String token,String sign){
		ReqResponse<FxTotalOrderDTO> req = new ReqResponse<FxTotalOrderDTO>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/getMyFxOrderTotal", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token,req)){
					FxTotalOrderDTO total = FxService.getOrderTotal(this.user_id);
					req.setData(total);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	

	
	
	/**
	 * 获取我的分销佣金
	 * @param version
	 * @param token
	 * @param sign (version+ token)
	 * @return
	 */
	@RequestMapping(value = "/getMyFxCommission")
	@ResponseBody
	public ReqResponse<FxUserMoneyDTO> getMyFxCommission(String version,String token,String sign){
		ReqResponse<FxUserMoneyDTO> req = new ReqResponse<FxUserMoneyDTO>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/getMyFxCommission", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ token,req)){
					FxUserMoneyDTO total = FxService.getMyFxCommission(this.user_id);
					req.setData(total);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	

	
	
	/**
	 * 分销佣金提现
	 * @param version
	 * @param token
	 * @param money 提现金额
	 * @param sign (version+ token+money)
	 * @return
	 */
	@RequestMapping(value = "/commissionWithdrawal")
	@ResponseBody
	public ReqResponse<String> commissionWithdrawal(String version,String token,String money,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//访问权限验证
		if(!this.checkLogin(token,"Myfx/commissionWithdrawal", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+money,req)){
					try {
						boolean bl = FxService.exchange(user_id,Double.parseDouble(money),1,req);//默认世峰E卡
						if(!bl){
							req.setCode(ErrorMsg.FAIL.getCode());
							req.setMsg(ErrorMsg.FAIL.getMsg());
						}
					} catch (NumberFormatException e) {
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg("提现金额错误");
					}
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
	/**
	 *  获取我的分销提现列表
	 * @param version
	 * @param token
	 * @param type 1收入2支出
	 * @param currentPage 当前页
	 * @param sign (version+token+type+currentPage)
	 * @return
	 */
	@RequestMapping(value = "/getMyFxExchangeList")
	@ResponseBody
	public ReqResponse<Page> getMyFxExchangeList(String version,String token,String type,Integer currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
		//登录验证
		if(!checkLogin(token, "Myfx/getMyFxExchangeList", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token+type+currentPage,req)){
					if(null == currentPage){
						currentPage = 1;
					}
					Page page = FxService.getMyFxExchangeList(user_id,type,currentPage);
					req.setData(page);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		return req;
	}
	
}
