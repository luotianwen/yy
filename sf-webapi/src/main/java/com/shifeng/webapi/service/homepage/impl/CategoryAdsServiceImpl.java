package com.shifeng.webapi.service.homepage.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.webapi.dto.homepage.CategoryAdsDTO;
import com.shifeng.webapi.service.homepage.CategoryAdsService;

/**
 * app类目广告
 * @author WinZhong
 *
 */
@Service("categoryAdsServiceImpl")
public class CategoryAdsServiceImpl implements CategoryAdsService{

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	

	
	/**
	 * 获取广告列表
	 * @return
	 */
	public List<CategoryAdsDTO> getAdsList() {
		try {
			List<CategoryAdsDTO> adList = (List<CategoryAdsDTO>)dao.findForList("sysCategoryadsMapper.getAdsList");
			return adList;
		} catch (Exception e) {
			logger.error("获取首页app类目广告异常：", e);
		}
		return null;
	}
	

}
