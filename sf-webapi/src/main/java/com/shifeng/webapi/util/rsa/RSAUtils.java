package com.shifeng.webapi.util.rsa;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
/**
 * 
 * @author WinZhong
 *
 */
public class RSAUtils {

    /**
     * 默认私钥
     */
	public static String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM8JeqbneXbdySba9krpovLXLhUG9L7NWbeVlZwWYXUWNWaky/rOpWuS2BpT1wluhIIa7dd2vc1MhNorplUj/YOL2lp+9wrefaFJJTB8m+PYAnsEUbv13hxjQQW74R/3GvKg+6gYswynD4pGkfB3oUVldG2VbEYqZdy78zHZ9IMfAgMBAAECgYBpov2I8ayBIPLEt45ZdNJms7JYmj8Ap8hyKom2pZi+ZEGFCOrnIs82jytia4rZziEgPVtDx9taSAO1SfZJlN6BeCfO6H2BV/Iya1G42lexpgiIAdEVu8bZGaYkBnlfnqGy1vljlKBRdEltqwOnVCHEfkErFSPhBidMltZEmNugOQJBAO3fkXAeOrD9PzR8eyVJ4hniC0fk+/FpLmEmteuSEnb7dm0ZW2JgvWZvdItStt4SygKCzAkMQYuBfzo05pr2OEUCQQDe0FtZXVm5jSKA6PQ1n483DC/O2fhdWcSj90/wa+oEINoYVj/GHbbOkEDQgxsSBsOYXj971NH+OfVTmnRBwV4TAkEAmytO1UNy58ebdmKJdk6W5ml1EGYID3ecYJV+8HduAh2RKCP1X9xZULv923COh5jcG/00meZbz2QfGVou4AEjvQJAD5oNW3OS7dA5I0esmfijQZqD2nsezgKUJ1sQ6OfVihZ2zw9zBb9c5pfpQfB8O8XnekrXLSeY0LFkQUdmbphIqwJBALNaOMkNzGXZ8oRfhOuT+Un0fc53SC5s1bYZ88kdKiP3I8JkDIL1CC6N4pJ65maNGl9GWd/zE0G9unquIcrlbeE=";  
	
	/**
	 * 默认公钥
	 */
	private static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPCXqm53l23ckm2vZK6aLy1y4VBvS+zVm3lZWcFmF1FjVmpMv6zqVrktgaU9cJboSCGu3Xdr3NTITaK6ZVI/2Di9pafvcK3n2hSSUwfJvj2AJ7BFG79d4cY0EFu+Ef9xryoPuoGLMMpw+KRpHwd6FFZXRtlWxGKmXcu/Mx2fSDHwIDAQAB";  
	
	/** RSA最大加密明文大小 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/** RSA最大解密密文大小 */
	private static final int MAX_DECRYPT_BLOCK = 128;

	/** 加密算法RSA */
	private static final String KEY_ALGORITHM = "RSA";    
	
	/** 
     * 私钥 
     */  
    private static RSAPrivateKey privateKey;  
  
    /** 
     * 公钥 
     */  
    private static RSAPublicKey publicKey;  
    
    /** 
     * 获取私钥 
     * @return 当前的私钥对象 
     */  
    private static RSAPrivateKey getPrivateKey() {  
    	if(privateKey == null){
    		try {
				privateKey = loadPrivateKey(PRIVATE_KEY);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
        return privateKey;  
    }  
  
    /** 
     * 获取公钥 
     * @return 当前的公钥对象 
     */  
    private static RSAPublicKey getPublicKey() {
    	if(publicKey == null){
    		try {
    			publicKey = loadPublicKey(PUBLIC_KEY);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
        return publicKey;  
    }  
     
	
	
	public static void main(String[] args) throws Exception {
	 
		System.out.println(decryptByPrivateKey("P+6vIaeNt+8+Mj25ZXElEtxmJW1Mo8S2w39B2eG1/4XX9qpod7aV/LqLLJDHGEhYyD/cy/DBUaT7pSEMHugqpzxPeQ7aqg8pWEtTpa89QjrM/oedQmyE6ezViawbke24KIyFZtijuxvmfHmZ0EhP4hvgCkIpFz7U7/YjCE3WGdY="));
	}

 
	/**
	 * 公钥加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String data) throws Exception {
		getPublicKey();
		byte[] dataByte = data.getBytes();
		//byte[] keyBytes = Base64Utils.decode(PUBLIC_KEY);
		//X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		//KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		//Key publicK = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		// Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		int inputLen = dataByte.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(dataByte, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(dataByte, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return Base64Utils.encode(encryptedData);
	}

	/**
	 * 私钥解密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPrivateKey(String data) throws Exception {
		getPrivateKey();
		byte[] encryptedData = Base64Utils.decode(data);
		//byte[] keyBytes = Base64Utils.decode(PRIVATE_KEY);
		//PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		//KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		//Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		// Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher
						.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher
						.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return new String(decryptedData);
	}

 

	/**
	 * 从字符串中加载公钥
	 * @param publicKeyStr 公钥数据字符串
	 * @throws Exception 加载公钥时产生的异常
	 */
	private static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception {
		try {
			byte[] buffer = Base64Utils.decode(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("公钥非法");
		} catch (NullPointerException e) {
			throw new Exception("公钥数据为空");
		}
	}

	/**
	 * 从字符串中加载私钥<br>
	 * 加载时使用的是PKCS8EncodedKeySpec（PKCS#8编码的Key指令）。
	 * @param privateKeyStr
	 * @return
	 * @throws Exception
	 */
	private static RSAPrivateKey loadPrivateKey(String privateKeyStr)
			throws Exception {
		try {
			byte[] buffer = Base64Utils.decode(privateKeyStr);
			// X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("私钥非法");
		} catch (NullPointerException e) {
			throw new Exception("私钥数据为空");
		}
	}

	public static String getPRIVATE_KEY() {
		return PRIVATE_KEY;
	}

	public static void setPRIVATE_KEY(String pRIVATE_KEY) {
		PRIVATE_KEY = pRIVATE_KEY;
	}

	public static String getPUBLIC_KEY() {
		return PUBLIC_KEY;
	}

	public static void setPUBLIC_KEY(String pUBLIC_KEY) {
		PUBLIC_KEY = pUBLIC_KEY;
	}
	
	
	
 

	 
}