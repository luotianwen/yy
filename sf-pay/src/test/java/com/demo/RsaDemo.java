package com.demo;

import com.alipay.sign.RSA;

public class RsaDemo {
 
	
	public static String privateKey = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBANdOSDZjnyNq6yshQ6XJZjrFHLQV2PKn8TwnWa0Et5QBXE4T6+8g65wG7ySrPE8UK/tNxoztBFuy5D0xU4K4kTpd0ICtkUS5jCHA0FD+IBCybo4+y13iQyS4o5WqceKYhNAqXl0cEsEsTcgIlPClTDQ4Hu92981MewKi5BHlnmPhAgMBAAECgYEAyKMaiBSt58NrAvYspAHaUkn9RZRWZ0o5c2T4HFOY/0OFUP0fj+eNqAiOMg2gVdDma3k+3XTB6vH530xoFhkIuzQ4mEwOwV/zzPbePAq6sA/MUmvmfTSfhXkigpCLg++Engyxf+jVpaNxeeIM/Hdlf8HcqM/FjF4AN5hjO1X1MwECQQD/RnNBD2pyIkeMtaHQNVjXETEtO8nPqFHjj6jTpS2O4pQ0ul3zsPlViHQwBraGVt5KIF9/dXvhDVcbT+B8LHxlAkEA1+rHlg9gsHzpps+wjNuD+BXK0zeL6SuU9YFmFfxw6r8VdPAzXFYvJzkZR8sQc/4ooK338BJDUgYXzxhvrg27zQJBAPyHdPyng2XlA2LvS2PtYjVfjIZy3vHOUTQMqba1cJwpCPQgaVDpgb5bfpUEDwxWYxBxdgdg8WtxBvq9yhUM7QECQQCP7ILvxv5XhlwlAkoYCncUVkplsqADZDad04xd2XDXOVovIbHKufQifBAa6APmnaMtP+mGUFYphcA3Hn3LEoJ9AkEAncd56oXscIYYIzOC0RTvhzNqVDemn/9rma0+SThM5l6QJc+wQQJFHlhQ9ptNVjt/dbcuRuo1OsZQfGS2uxqmOg==";
	public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDXTkg2Y58jausrIUOlyWY6xRy0Fdjyp/E8J1mtBLeUAVxOE+vvIOucBu8kqzxPFCv7TcaM7QRbsuQ9MVOCuJE6XdCArZFEuYwhwNBQ/iAQsm6OPstd4kMkuKOVqnHimITQKl5dHBLBLE3ICJTwpUw0OB7vdvfNTHsCouQR5Z5j4QIDAQAB";	
	public static String input_charset = "utf-8";	
	public static void main(String[] args) throws Exception {
		 
		String sign = RSA.sign("晓风残月",publicKey, input_charset);
		System.out.println(sign);
		sign = RSA.decrypt(sign,privateKey,input_charset);
		System.out.println(sign);
	}
	

}
