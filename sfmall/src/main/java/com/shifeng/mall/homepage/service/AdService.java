package com.shifeng.mall.homepage.service;


import com.shifeng.mall.homepage.dto.AdDTO;

import java.util.List;

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
