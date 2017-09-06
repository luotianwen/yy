package com.shifeng.webapi.service.homepage;

import java.util.List;

import com.shifeng.webapi.dto.homepage.AdDTO;

/**
 * 首页广告
 * @author WinZhong
 *
 */
public interface AdService {
	
	/**
	 * 获取广告列表
	 * @return
	 */
	List<AdDTO> getAdList();

}
