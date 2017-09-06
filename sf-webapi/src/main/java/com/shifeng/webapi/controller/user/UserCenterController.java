package com.shifeng.webapi.controller.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.shifeng.dto.mall.usercenter.StatisticDTO;
import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.entity.user.SysUser;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.FileBase64ConvertUitl;
import com.shifeng.webapi.ali.AliyunOSSFactory;
import com.shifeng.webapi.ali.AliyunOSSProperties;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.user.MySilverService;
import com.shifeng.webapi.service.user.UserCenterService;

/**
 * 用户中心接口api
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/usercenter")
public class UserCenterController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "userCenterServiceImpl")
	protected UserCenterService userCenterService;
	
	@Resource(name = "mySilverServiceImpl")
	protected MySilverService mySilverService;
	
	 
	/**
	 * 修改用户头像
	 * @param version
	 * @param token
	 * @param headimg
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/modifyHeadImg")
	@ResponseBody
	public ReqResponse<String> modifyHeadImg(HttpServletRequest request,String version,String token,String headimg,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "usercenter/modifyHeadImg", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:

				//验证签名
				if(this.verifySign(sign, version+token+headimg,req)){
					
					
	    			  try {
	    				ServletContext application = request.getSession().getServletContext();
	  					//文件访问路径
	  			        String url = "upload/HeadImg/"+user_id+"/";
	  			        String fileName = token+".jpg";  
	  					//文件保存路径
	  			        String savePath = application.getRealPath("/") + url ;
	  					FileBase64ConvertUitl.Base64TurnFile(headimg, savePath, fileName);
	  					
	  					//文件同步上传到阿里云
	  	                
	  	                OSSClient client = AliyunOSSFactory.getOSSClient();
	    				  
	    				File uploadedFile = new File(savePath + fileName); 
	    				
	    				//oss文件路径
	    				String ossURL = "avatar/"+user_id+"/";
	    				  
	    				FileInputStream fileInputStream = new FileInputStream(uploadedFile);
	    				// 创建上传Object的Metadata
	    				ObjectMetadata meta = new ObjectMetadata();
	    				// 必须设置ContentLength
	    				meta.setContentLength(Integer.parseInt(String.valueOf(fileInputStream.available())));
	    				// 用户自定义文件名称
	    				meta.addUserMetadata("filename", ossURL+fileName);
	    				// 上传Object.
	    				PutObjectResult result = client.putObject(AliyunOSSProperties.bucketName, ossURL+fileName, fileInputStream,meta);
	    				logger.debug("文件同步到阿里云OSS成功， ETag： "+ result.getETag());
	    				String headimgurl = AliyunOSSProperties.imgVisitURL+ossURL+fileName;
	    				boolean bl = userCenterService.updateHeadImg(user_id, headimgurl);
						if(bl){
							req.setCode(0);
							req.setData(headimgurl);
						}else{//修改失败
							req.setCode(ErrorMsg.MODIFY_FAILED.getCode());
							req.setMsg(ErrorMsg.MODIFY_FAILED.getMsg());
						}
	    			} catch (FileNotFoundException e) {
	    				logger.error("upload file to aliyun OSS object server occur FileNotFoundException.",e);//修改失败
						req.setCode(ErrorMsg.MODIFY_FAILED.getCode());
						req.setMsg(ErrorMsg.MODIFY_FAILED.getMsg());
	    			} catch (NumberFormatException e) {
	    				logger.error("upload file to aliyun OSS object server occur NumberFormatException.",e);//修改失败
						req.setCode(ErrorMsg.MODIFY_FAILED.getCode());
						req.setMsg(ErrorMsg.MODIFY_FAILED.getMsg());
	    			} catch (IOException e) {
	    				logger.error("upload file to aliyun OSS object server occur IOException.",e);//修改失败
						req.setCode(ErrorMsg.MODIFY_FAILED.getCode());
						req.setMsg(ErrorMsg.MODIFY_FAILED.getMsg());
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
	 * 修改用户头像
	 * @param version
	 * @param token
	 * @param headimgurl
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/modifyHeadImg1")
	@ResponseBody
	public ReqResponse<?> modifyHeadImg1(String version,String token,String headimgurl,String sign){
		ReqResponse<?> req = new ReqResponse<Object>();
		//登录验证
		if(!checkLogin(token, "usercenter/modifyHeadImg1", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:

				//验证签名
				if(this.verifySign(sign, version+token+headimgurl,req)){
					
					
					 //文件同步上传到阿里云
	                
	                /*  OSSClient client = AliyunOSSFactory.getOSSClient();
	    			  try {
	    				FileInputStream fileInputStream = new FileInputStream(uploadedFile);
	    				// 创建上传Object的Metadata
	    				ObjectMetadata meta = new ObjectMetadata();
	    				// 必须设置ContentLength
	    				meta.setContentLength(Integer.parseInt(String.valueOf(fileInputStream.available())));
	    				// 用户自定义文件名称
	    				meta.addUserMetadata("filename", url+newFileName);
	    				// 上传Object.
	    				PutObjectResult result = client.putObject(AliyunOSSProperties.bucketName, url+newFileName, fileInputStream,meta);
	    				logger.debug("文件同步到阿里云OSS成功， ETag： "+ result.getETag());
	    				 urlList.add(AliyunOSSProperties.imgVisitURL+url+newFileName);
	    			} catch (FileNotFoundException e) {
	    				logger.error("upload file to aliyun OSS object server occur FileNotFoundException.",e);
	    				 urlList.add(url+newFileName);
	    			} catch (NumberFormatException e) {
	    				logger.error("upload file to aliyun OSS object server occur NumberFormatException.",e);
	    				 urlList.add(url+newFileName);
	    			} catch (IOException e) {
	    				logger.error("upload file to aliyun OSS object server occur IOException.",e);
	    				 urlList.add(url+newFileName);
	    			}*/
					
					

					boolean bl = userCenterService.updateHeadImg(user_id, headimgurl);
					if(bl){
						
					}else{//修改失败
						req.setCode(ErrorMsg.MODIFY_FAILED.getCode());
						req.setMsg(ErrorMsg.MODIFY_FAILED.getMsg());
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
	 * 修改用户基本信息
	 * @param version
	 * @param token
	 * @param name
	 * @param sex
	 * @param birthday
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/modifyInfo")
	@ResponseBody
	public ReqResponse<?> modifyInfo(String version,String token,String name,String sex,String birthday,String sign){
		ReqResponse<?> req = new ReqResponse<Object>();
		//登录验证
		if(!checkLogin(token, "usercenter/modifyInfo", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				String str = name;
				if(!StringUtils.isNotBlank(str)){
					str = sex;
				}
				if(!StringUtils.isNotBlank(str)){
					str = birthday;
				}

				//验证签名
				if(this.verifySign(sign, version+token+str,req)){
					SysUser sysUser = new SysUser();
					sysUser.setId(Integer.parseInt(user_id));
					sysUser.setName(name);
					sysUser.setSex(sex);
					sysUser.setBirthday(birthday);
					boolean bl = userCenterService.updateUserInfo(sysUser);
					if(bl){
						
					}else{//修改失败
						req.setCode(ErrorMsg.MODIFY_FAILED.getCode());
						req.setMsg(ErrorMsg.MODIFY_FAILED.getMsg());
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
	 * 获取我的银币
	 * @param version
	 * @param token
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/mySilver")
	@ResponseBody
	public ReqResponse<MallUsersSilver> mySilver(String version,String token,String sign){
		ReqResponse<MallUsersSilver> req = new ReqResponse<MallUsersSilver>();
		//登录验证
		if(!checkLogin(token, "usercenter/mySilver", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token,req)){
					MallUsersSilver silver = mySilverService.getSilverCoin(user_id);
					req.setData(silver);
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
	 * 获取我的银币兑换记录
	 * @param version
	 * @param token
	 * @param type 1收入2兑换
	 * @param currentPage 当前页
	 * @param sign (version+token+type+currentPage)
	 * @return
	 */
	@RequestMapping(value = "/mySilver/exchangeRecord")
	@ResponseBody
	public ReqResponse<Page> exchangeRecord(String version,String token,String type,Integer currentPage,String sign){
		ReqResponse<Page> req = new ReqResponse<Page>();
		//登录验证
		if(!checkLogin(token, "mySilver/exchangeRecord", req)){
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
					Page silver = mySilverService.exchangeRecord(user_id,type,currentPage);
					req.setData(silver);
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
	 * 我的银币兑换
	 * @param version
	 * @param token
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/mySilver/exchange")
	@ResponseBody
	public ReqResponse<String> exchange(String version,String token,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
		if(!checkLogin(token, "mySilver/exchange", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token,req)){
					boolean bl = mySilverService.exchange(user_id,req);
				    if(bl){
				    	req.setCode(0);
					}else{//修改失败
						req.setCode(ErrorMsg.MODIFY_FAILED.getCode());
						req.setMsg(ErrorMsg.MODIFY_FAILED.getMsg());
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
	 * 我的统计
	 * @param version
	 * @param token
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/getStatistic")
	@ResponseBody
	public ReqResponse<StatisticDTO> getStatistic(String version,String token,String sign){
		ReqResponse<StatisticDTO> req = new ReqResponse<StatisticDTO>();
		//登录验证
		if(!checkLogin(token, "usercenter/getStatistic", req)){
			return req;
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+token,req)){
					StatisticDTO statistic = userCenterService.getStatistic(user_id);
					req.setData(statistic);
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
