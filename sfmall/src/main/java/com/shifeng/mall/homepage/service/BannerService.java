package com.shifeng.mall.homepage.service;


import com.shifeng.mall.homepage.dto.BannerDTO;

import java.util.List;

/**
 * pc首页Banner
 * @author WinZhong
 *
 */
public interface BannerService {
	
	/**
	 * 获取Banner列表
	 * @return
	 */
	List<BannerDTO> getBannerList();

}
