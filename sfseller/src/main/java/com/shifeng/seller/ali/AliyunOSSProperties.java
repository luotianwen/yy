package com.shifeng.seller.ali;

/**
 * 
 * @author WinZhong
 *
 */
public class AliyunOSSProperties {
	/**
	 * Access Key ID
	 */
	public static String accessKeyID ; 
	public static String accessKeySecret ;
	public static String endpoint ;
	// bucket名称
	public static String bucketName ;
	//图片访问url
	public static String imgVisitURL;
	//文件web直传回调验证url
	public static String callBackUrl;
	public static String getAccessKeyID() {
		return accessKeyID;
	}
	public static void setAccessKeyID(String accessKeyID) {
		AliyunOSSProperties.accessKeyID = accessKeyID;
	}
	public static String getAccessKeySecret() {
		return accessKeySecret;
	}
	public static void setAccessKeySecret(String accessKeySecret) {
		AliyunOSSProperties.accessKeySecret = accessKeySecret;
	}
	public static String getEndpoint() {
		return endpoint;
	}
	public static void setEndpoint(String endpoint) {
		AliyunOSSProperties.endpoint = endpoint;
	}
	public static String getBucketName() {
		return bucketName;
	}
	public static void setBucketName(String bucketName) {
		AliyunOSSProperties.bucketName = bucketName;
	}
	public static String getImgVisitURL() {
		return imgVisitURL;
	}
	public static void setImgVisitURL(String imgVisitURL) {
		AliyunOSSProperties.imgVisitURL = imgVisitURL;
	}
	public static String getCallBackUrl() {
		return callBackUrl;
	}
	public static void setCallBackUrl(String callBackUrl) {
		AliyunOSSProperties.callBackUrl = callBackUrl;
	}
	
	
	
	
	
	
	
	
}
