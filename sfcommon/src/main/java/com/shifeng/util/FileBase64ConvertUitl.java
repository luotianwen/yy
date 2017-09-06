package com.shifeng.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
 

/**
 * 文件与base64字符之间的互转工具类
 * @author WinZhong
 *
 */
public class FileBase64ConvertUitl {
	
	 
	/**
	 * base64字符串转化文件
	 * @param content Base64内容
	 * @param savePath  保存路径
	 * @param fileName  文件名字
	 * @return
	 * @throws IOException 
	 */
    public static boolean Base64TurnFile(String content,String savePath,String fileName) throws IOException{  
    		if (content == null){// 数据为空
    			return false;
    		}else{
    			// 检查目录
    	        File uploadDir = new File(savePath);
    			if (!uploadDir.exists()) {
    				uploadDir.mkdirs();
    			}
    			byte[] bs = Base64.decodeBase64(content);
    			FileOutputStream os = new FileOutputStream(savePath+"/"+fileName);
    			os.write(bs);
    			os.close();
    			return true;
    		}
    }
    
	 /**  
	  * 将文件转成base64 字符串  
	  * @param path文件路径  
	  * @return     
	  * @throws Exception  
	  */  
	  
	 @SuppressWarnings("restriction")
	public static String encodeBase64File(String path) throws Exception {  
	   File file = new File(path);  
	   FileInputStream inputFile = new FileInputStream(file);  
	   byte[] buffer = new byte[(int) file.length()];  
	   inputFile.read(buffer);  
	   inputFile.close();  
	   return Base64.encodeBase64String(buffer);  
	  
	 }  
	  
	 /**  
	  * 将base64字符解码保存文件  
	  * @param base64Code  
	  * @param targetPath  
	  * @throws Exception  
	  */  
	  
	 @SuppressWarnings("restriction")
	public static void decoderBase64File(String base64Code, String targetPath)  
	    throws Exception {  
	   byte[] buffer = Base64.decodeBase64(base64Code);  
	   FileOutputStream out = new FileOutputStream(targetPath);  
	   out.write(buffer);  
	   out.close();  
	  
	 }  
	  
	 /**  
	  * 将base64字符保存文本文件  
	  * @param base64Code  
	  * @param targetPath  
	  * @throws Exception  
	  */  
	  
	 public static void toFile(String base64Code, String targetPath)  
	    throws Exception {  
	  
	    byte[] buffer = base64Code.getBytes();  
	    FileOutputStream out = new FileOutputStream(targetPath);  
	    out.write(buffer);  
	    out.close();  
	  }  
	 
	 
	 public static void main(String[] args) {  
	     try {  
	        String base64Code = encodeBase64File("‪C:/Users/WinZhong/Desktop/1.jpg");  
	        System.out.println(base64Code);  
	        decoderBase64File(base64Code, "E:/2.jpg");  
	        toFile(base64Code, "E:/3.jpg");  
	     } catch (Exception e) {  
	        e.printStackTrace();  
	  
	     }  
	  
	 }  

}
