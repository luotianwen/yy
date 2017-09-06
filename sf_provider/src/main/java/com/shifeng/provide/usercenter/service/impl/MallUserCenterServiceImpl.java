package com.shifeng.provide.usercenter.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.usercenter.StatisticDTO;
import com.shifeng.provide.usercenter.dao.MallUserCenterDao;
import com.shifeng.provide.usercenter.service.MallUserCenterService;
import com.shifeng.response.ReqResponse;

/**
 * 商城用户中心
 * @author Win
 *
 */
@Service(timeout=1200000)
public class MallUserCenterServiceImpl implements MallUserCenterService{
	
	@Resource(name = "mallUserCenterDao")
	private MallUserCenterDao mallUserCenterDao;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 获取用户中心数据统计
	 * @param user_id
	 * @return
	 */
	public ReqResponse<StatisticDTO> getStatistic(String user_id) {
		ReqResponse<StatisticDTO> req = new ReqResponse<StatisticDTO>();
		try {
			mallUserCenterDao.getStatistic(user_id, req);
		} catch (Exception e) {
			logger.error("【获取用户中心数据统计】出错：", e);
			req.setCode(1);
			req.setMsg("获取用户中心数据统计异常");
		}
		return req;
	}

}
