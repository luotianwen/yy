package com.shifeng.webapi.service.homepage;

import java.util.List;

import com.shifeng.webapi.dto.homepage.CategoryAdsDTO;

/**
 * app类目广告
 * @author WinZhong
 *
 */
public interface CategoryAdsService {
	
	/**
	 * 获取广告列表
	 * @return
	 */
	List<CategoryAdsDTO> getAdsList();

}
