package com.shifeng.demo;

import java.io.File;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

public class OSSDemo {

	public static void main(String[] args) {
		String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
		String accessKeyId = "AMssVyP3vE1I86bu";
		String accessKeySecret = "7nWHV8gcTYVtV02J5XajZcs3jba8bm";
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 上传文件
		PutObjectResult result = ossClient.putObject("malltest", "test.jpg", new File("C:/Users/WinZhong/Desktop/logo.jpg"));
		System.out.println( result.getETag());
		// 关闭client
		ossClient.shutdown();

	}

}
