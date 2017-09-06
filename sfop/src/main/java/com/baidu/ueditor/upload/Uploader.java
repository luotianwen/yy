package com.baidu.ueditor.upload;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.baidu.ueditor.define.State;
import com.shifeng.op.ali.AliyunOSSFactory;
import com.shifeng.op.ali.AliyunOSSProperties;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Uploader {
	private Logger logger = Logger.getLogger(Uploader.class);
	private HttpServletRequest request = null;
	private Map<String, Object> conf = null;
	public Uploader(HttpServletRequest request, Map<String, Object> conf) {
		this.request = request;
		this.conf = conf;
	}

	public final State doExec() {
		String filedName = (String) this.conf.get("fieldName");
		State state = null;

		if ("true".equals(this.conf.get("isBase64"))) {
			state = Base64Uploader.save(this.request.getParameter(filedName),this.conf);
		} else {
			state = BinaryUploader.save(this.request, this.conf);

			//文件同步上传到阿里云
			JSONObject stateJson = new JSONObject(state.toJSONString());
			OSSClient client = AliyunOSSFactory.getOSSClient();
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
				PutObjectResult result = client.putObject(AliyunOSSProperties.bucketName, key, fileInputStream,meta);
				logger.debug("文件同步到阿里云OSS成功， ETag： "+ result.getETag());
				state.putInfo("url", AliyunOSSProperties.imgVisitURL+stateJson.getString("url"));
			} catch (FileNotFoundException e) {
				logger.error("upload file to aliyun OSS object server occur FileNotFoundException.",e);
			} catch (NumberFormatException e) {
				logger.error("upload file to aliyun OSS object server occur NumberFormatException.",e);
			} catch (IOException e) {
				logger.error("upload file to aliyun OSS object server occur IOException.",e);
			}
			

			
		}

		return state;
	}
}
