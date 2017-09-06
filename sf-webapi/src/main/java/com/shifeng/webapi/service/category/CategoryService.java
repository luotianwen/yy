package com.shifeng.webapi.service.category;

import java.util.List;

import com.shifeng.dto.mall.MallCategoryDTO;
import com.shifeng.entity.category.Navigation;
import com.shifeng.response.ReqResponse;

public interface CategoryService {
	
	/**
	 * 获取分类列表
	 * @return
	 */
	List<MallCategoryDTO> getCategoryList();
	
    /**
     * 获取分类导航
     * @return
     * @throws Exception
     */
    List<Navigation> getCategoryNavigation();

}
