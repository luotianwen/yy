package com.shifeng.webapi.service.homepage;

import java.util.List;

import com.shifeng.webapi.dto.homepage.BannerDTO;

/**
 * APP首页Banner
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
