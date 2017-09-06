package com.shifeng.webapi.controller.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;
import com.shifeng.util.FileBase64ConvertUitl;
import com.shifeng.util.UuidUtil;
import com.shifeng.webapi.ali.AliyunOSSFactory;
import com.shifeng.webapi.ali.AliyunOSSProperties;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;

/**
 * 上传接口
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController extends BaseController {

	
	
	/**
	 * 上传图片
	 * @param version
	 * @param token
	 * @param imgstr  Base64图片
	 * @param sign
	 * @return
	 */
	@RequestMapping(value = "/imgs")
	@ResponseBody
	public ReqResponse<String> imgs(HttpServletRequest request,String version,String token,String imgstr,String sign){
		ReqResponse<String> req = new ReqResponse<String>();
		//登录验证
				if(!checkLogin(token, "upload/imgs", req)){
					return req;
				}
				//验证版本号
				switch (version) {
					case ApiVersion.V_1_0_0:

						//验证签名
						if(this.verifySign(sign, version+token+imgstr,req)){
							
							
			    			  try {
			    				ServletContext application = request.getSession().getServletContext();
			    				String day = DateUtil.getDays();
			    				//oss文件路径
			    				String ossURL = "img/"+day+"/";
			  					//文件访问路径
			  			        String url = "upload/"+ossURL;
			  			        String fileName = UuidUtil.get32UUID()+".jpg";  
			  					//文件保存路径
			  			        String savePath = application.getRealPath("/") + url ;
			  					FileBase64ConvertUitl.Base64TurnFile(imgstr, savePath, fileName);
			  					
			  					//文件同步上传到阿里云
			  	                
			  	                OSSClient client = AliyunOSSFactory.getOSSClient();
			    				  
			    				File uploadedFile = new File(savePath + fileName); 
			    				
			    				  
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
			    				String imgURL = AliyunOSSProperties.imgVisitURL+ossURL+fileName;
			    				req.setData(imgURL);
								 
			    			} catch (FileNotFoundException e) {
			    				logger.error("upload file to aliyun OSS object server occur FileNotFoundException.",e);
								req.setCode(ErrorMsg.FAIL.getCode());
								req.setMsg(ErrorMsg.FAIL.getMsg());
			    			} catch (NumberFormatException e) {
			    				logger.error("upload file to aliyun OSS object server occur NumberFormatException.",e);
								req.setCode(ErrorMsg.FAIL.getCode());
								req.setMsg(ErrorMsg.FAIL.getMsg());
			    			} catch (IOException e) {
			    				logger.error("upload file to aliyun OSS object server occur IOException.",e);
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
	};	
	
	
	
	
	
}
