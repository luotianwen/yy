package com.shifeng.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件读取工具类
 * @author WinZhong
 *
 */
public class FileReaderUtil {

	
	/**
	 * 读取txt配置文件
	 * @param filePath
	 * @return
	 */
	public static List<String> readerTxt(String filePath) {
		List<String> list = null;
		try {
			/*System.out.println(filePath+"=========="+FileReaderUtil.class.getResource("/").getPath());
			System.out.println(filePath+"=========="+FileReaderUtil.class.getResource(filePath).getPath());
			 */
 			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FileReaderUtil.class.getResource(filePath).getPath())));
			list = new ArrayList<String>();
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if(!line.equals("") && line.indexOf("#") == -1){
					list.add(line.trim());
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		List<String> list =  readerTxt("/ipWhite.txt");
		for(String str:list){
			System.out.println(str);
		}
	}

}
