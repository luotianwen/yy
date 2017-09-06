package com.shifeng.provide.mall.service;

import java.util.List;

import com.shifeng.dto.mall.MallCategoryDTO;
import com.shifeng.response.ReqResponse;

/**
 * 商城分类
 * @author win
 *
 */
public interface MallCategoryService {
	
	/**
	 * 获取分类列表
	 * @return
	 */
	ReqResponse<List<MallCategoryDTO>> getCategoryList();

}
