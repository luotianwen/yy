package com.shifeng.op.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.baidu.ueditor.ActionEnter;
import com.shifeng.op.ali.AliyunOSSFactory;
import com.shifeng.op.ali.AliyunOSSProperties;
import com.shifeng.util.UuidUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/upload")
public class UploadController {
	private Logger logger = Logger.getLogger(UploadController.class);

	/**
	 * ueditor上传服务
	 * @param request
	 * @param response
	 */
	  @RequestMapping(value = "/ue")
	    public void config(HttpServletRequest request, HttpServletResponse response) {
	        response.setContentType("application/json");
	        String rootPath = request.getSession().getServletContext().getRealPath("/");
	        try {
	            String exec = new ActionEnter(request, rootPath).exec();
	            PrintWriter writer = response.getWriter();
	            writer.write(exec);
	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	  /**
	   * 批量文件上传
	   * @param files
	   * @param request
	   * @return
	   * @throws Exception
	   */
		@RequestMapping(value = "/file")  
		@ResponseBody
	    public Object upload(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request) throws Exception {  
			//type 类型 1本地返回网络路径 2阿里云返回网络路径 3本地返回本地路径
			String type=request.getParameter("type");
			if(StringUtils.isEmpty(type)){
				type="2";
			}
			Map<String, Object> map = new HashMap<String, Object>();
			 map.put("state", "REEOR");
	        if (files == null || files.length == 0) {
	            map.put("msg","请选择文件。");
	            return map;  
	        }
	        ServletContext application = request.getSession().getServletContext();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	        String ymd = sdf.format(new Date());
	        //文件访问路径
	        String url = "upload/image/"+ymd+"/";
	        //文件保存路径
	        String savePath = application.getRealPath("/") + url;
	        // 检查目录
	        File uploadDir = new File(savePath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
	        if (!uploadDir.isDirectory()) {
	            map.put("msg","上传目录不存在。");
	            return map;  
	        }
	        // 检查目录写权限
	        if (!uploadDir.canWrite()) {
	            map.put("msg","上传目录没有写权限。");
	            return map;  
	        }
	        //上传文件访问URL列表
	        List<String> urlList = new ArrayList<String>();
	        for (MultipartFile mf : files) {
				if(!mf.isEmpty()){
					String fileName = mf.getOriginalFilename();
					//获取文件后缀
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					String newFileName = UuidUtil.get32UUID() + "." + fileExt;
					if(type.equals("1")) {
						File uploadedFile = new File(savePath, newFileName);
						if (!uploadedFile.exists()) {
							uploadedFile.mkdirs();
						}
						mf.transferTo(uploadedFile);
						urlList.add(url+newFileName);
					}
					else if(type.equals("2")) {
						//文件同步上传到阿里云
						OSSClient client = AliyunOSSFactory.getOSSClient();
						try {
							InputStream fileInputStream = mf.getInputStream();
							// 创建上传Object的Metadata
							ObjectMetadata meta = new ObjectMetadata();
							// 必须设置ContentLength
							meta.setContentLength(Integer.parseInt(String.valueOf(fileInputStream.available())));
							// 用户自定义文件名称
							meta.addUserMetadata("filename", url + newFileName);
							// 上传Object.
							PutObjectResult result = client.putObject(AliyunOSSProperties.bucketName, url + newFileName, fileInputStream, meta);
							logger.debug("文件同步到阿里云OSS成功， ETag： " + result.getETag());
							urlList.add(AliyunOSSProperties.imgVisitURL + url + newFileName);
						} catch (FileNotFoundException e) {
							logger.error("upload file to aliyun OSS object server occur FileNotFoundException.", e);
							urlList.add(url + newFileName);
						} catch (NumberFormatException e) {
							logger.error("upload file to aliyun OSS object server occur NumberFormatException.", e);
							urlList.add(url + newFileName);
						} catch (IOException e) {
							logger.error("upload file to aliyun OSS object server occur IOException.", e);
							urlList.add(url + newFileName);
						}
					}
                    else if(type.equals("3")) {
						File uploadedFile = new File(savePath, newFileName);
						if (!uploadedFile.exists()) {
							uploadedFile.mkdirs();
						}
						mf.transferTo(uploadedFile);
						urlList.add(uploadedFile.getAbsolutePath());
					}
				}
			}
	        map.put("state", "SUCCESS");
	        map.put("url",urlList);
	        return map;  
	    } 
	
}
