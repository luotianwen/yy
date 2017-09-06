package com.shifeng.op.ali.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

@Service("aliOSS")
public class AliOSS {
	
	private Logger logger = Logger.getLogger(AliOSS.class);

	@Value("#{properties['AccessKeyID']}")
	String accessKeyID ; 
	@Value("#{properties['AccessKeySecret']}")
	String accessKeySecret ;
	@Value("#{properties['Endpoint']}")
	String endpoint ;
	// bucket名称
	@Value("#{properties['BucketName']}")
	String bucketName ;
	//图片访问url
	@Value("#{properties['ImgVisitURL']}")
	String imgVisitURL;
	//文件web直传回调验证url
	@Value("#{properties['CallbackUrl']}")
	String callBackUrl;
	
	
	public boolean upload(JSONObject stateJson, HttpServletRequest request) {
		OSSClient client = new OSSClient(endpoint,accessKeyID, accessKeySecret);
		String key = stateJson.getString("url");
	  try {
		FileInputStream fileInputStream = new FileInputStream(new File(request.getSession().getServletContext().getRealPath("/") + key));
		// 创建上传Object的Metadata
		ObjectMetadata meta = new ObjectMetadata();
		// 必须设置ContentLength
		meta.setContentLength(Integer.parseInt(String.valueOf(fileInputStream.available())));
		// 用户自定义文件名称
		meta.addUserMetadata("filename", key);
		// 上传Object.
		PutObjectResult result = client.putObject("malltest", key, fileInputStream,meta);
		logger.debug("文件同步到阿里云OSS成功， ETag： "+ result.getETag());
		return true;
	} catch (FileNotFoundException e) {
		logger.error("upload file to aliyun OSS object server occur FileNotFoundException.");
	} catch (NumberFormatException e) {
		logger.error("upload file to aliyun OSS object server occur NumberFormatException.");
	} catch (IOException e) {
		logger.error("upload file to aliyun OSS object server occur IOException.");
	}
	return false;
}

}
