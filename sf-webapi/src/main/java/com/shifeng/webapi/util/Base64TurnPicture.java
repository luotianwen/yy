package com.shifeng.webapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.shifeng.util.DateUtil;
import com.shifeng.util.FileBase64ConvertUitl;
import com.shifeng.util.UuidUtil;
import com.shifeng.webapi.ali.AliyunOSSFactory;
import com.shifeng.webapi.ali.AliyunOSSProperties;
/**
 * 
 * @author WinZhong
 *
 */
public class Base64TurnPicture {
	

	protected static Logger logger = Logger.getLogger(Base64TurnPicture.class);
	
	/**
	 * 
	 * @param request
	 * @param base64Content
	 * @return
	 */
	public static String turn(HttpServletRequest request,String base64Content){
		//访问地址
		String visitURL = null;
		try {
			ServletContext application = request.getSession().getServletContext();
			String day = DateUtil.getDays();
			//文件访问路径
			String url = "upload/img/"+day+"/";
			String fileName = UuidUtil.get32UUID()+".jpg";  
			//文件保存路径
			String savePath = application.getRealPath("/") + url ;
			FileBase64ConvertUitl.Base64TurnFile(base64Content, savePath, fileName);
			visitURL = url+fileName;
			//文件同步上传到阿里云
			OSSClient client = AliyunOSSFactory.getOSSClient();
			File uploadedFile = new File(savePath + fileName); 
			//oss文件路径
			String ossURL = "img/"+day+"/";
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
			visitURL = AliyunOSSProperties.imgVisitURL+ossURL+fileName;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (OSSException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return visitURL;
	}

}
