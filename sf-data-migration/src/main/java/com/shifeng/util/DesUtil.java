package com.shifeng.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;

/**
 * Des 加密解密工具类
 * @author WinZhong
 *
 */
public class DesUtil {

	   private static String DESkey = "response";
	   //private final byte[] DESkey = "response".getBytes("UTF-8");// 设置密钥，略去
	   private static final byte[] DESIV = {0x12, 0x34, 0x56, 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF};// 设置向量，略去

	   private static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现
	   private static Key key = null;

	   static{
		       try {
				DESKeySpec keySpec = new DESKeySpec(DESkey.getBytes("UTF-8"));// 设置密钥参数
				   iv = new IvParameterSpec(DESIV);// 设置向量
				   SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
				   key = keyFactory.generateSecret(keySpec);// 得到密钥对象
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }

	   public static String encode(String data) throws Exception {
	       Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
	       enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
	       byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
	       BASE64Encoder base64Encoder = new BASE64Encoder();
	       return base64Encoder.encode(pasByte);
	   }

	   public static String decode(String data) throws Exception {
	       Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
	       deCipher.init(Cipher.DECRYPT_MODE, key, iv);
	       BASE64Decoder base64Decoder = new BASE64Decoder();

	       byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));

	       return new String(pasByte, "UTF-8");
	   }
	   public static void main(String[] args) {
	       try {
	           String test = "11";
	        
	           System.out.println("加密前的字符："+test);
	           System.out.println("加密后的字符："+DesUtil.encode(test));
	    	   System.out.println("解密后的字符："+DesUtil.decode(DesUtil.encode(test)));
	    	   //aSQyLnnxV0E=|yH4tTYSTeDA=   FUfd1PRqrvw=|CuzcdIpDWyOr2riEyBlhow==945
	    	   System.out.println("解密后的字符："+DesUtil.decode("yH4tTYSTeDA="));
	    	   System.out.println(MD5Util.hex("2000"));
	           System.out.println("解密后的字符："+DesUtil.decode("CuzcdIpDWyOr2riEyBlhow=="));
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }

	public static String getDESkey() {
		return DESkey;
	}

	public static void setDESkey(String dESkey) {
		DESkey = dESkey;
	}
	   
	   
}
