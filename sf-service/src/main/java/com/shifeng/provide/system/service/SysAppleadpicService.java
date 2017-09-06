package com.shifeng.provide.system.service;

import java.util.List;

import com.shifeng.response.ReqResponse;

/**
 * app引导页
 * @author WinZhong
 *
 */
public interface SysAppleadpicService {
	
	/**
	 * 获取引导页
	 * @return
	 */
	ReqResponse<List<String>> getSysAppleadpic();

}
