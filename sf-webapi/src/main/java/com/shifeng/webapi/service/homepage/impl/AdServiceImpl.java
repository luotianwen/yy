package com.shifeng.webapi.service.homepage.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.webapi.dto.homepage.AdDTO;
import com.shifeng.webapi.service.homepage.AdService;

/**
 * 首页广告
 * @author WinZhong
 *
 */
@Service("adServiceImpl")
public class AdServiceImpl implements AdService{

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	

	
	/**
	 * 获取广告列表
	 * @return
	 */
	public List<AdDTO> getAdList() {
		try {
			List<AdDTO> adList = (List<AdDTO>)dao.findForList("adMapper.getAdList");
			return adList;
		} catch (Exception e) {
			logger.error("获取app首页广告异常：", e);
		}
		return null;
	}
	

}
