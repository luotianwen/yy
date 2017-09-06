package com.shifeng.mall.homepage.service.impl;


import com.shifeng.dao.BaseDao;
import com.shifeng.mall.homepage.dto.BannerDTO;
import com.shifeng.mall.homepage.service.BannerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * APP首页Banner
 * @author WinZhong
 *
 */
@Service("bannerServiceImpl")
public class BannerServiceImpl implements BannerService {

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
