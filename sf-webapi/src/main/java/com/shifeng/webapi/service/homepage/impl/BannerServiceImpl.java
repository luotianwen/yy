package com.shifeng.webapi.service.homepage.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.webapi.dto.homepage.BannerDTO;
import com.shifeng.webapi.service.homepage.BannerService;

/**
 * APP首页Banner
 * @author WinZhong
 *
 */
@Service("bannerServiceImpl")
public class BannerServiceImpl implements BannerService{

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	

	
	/**
	 * 获取Banner列表
	 * @return
	 */
	public List<BannerDTO> getBannerList() {
		try {
			List<BannerDTO> bannerList = (List<BannerDTO>)dao.findForList("sysbannerMapper.getBannerList");
			return bannerList;
		} catch (Exception e) {
			logger.error("获取PP首页Banner异常：", e);
		}
		return null;
	}
	
	

}
