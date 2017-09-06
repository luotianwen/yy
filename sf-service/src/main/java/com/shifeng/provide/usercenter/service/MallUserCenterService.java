package com.shifeng.provide.usercenter.service;

import com.shifeng.dto.mall.usercenter.StatisticDTO;
import com.shifeng.response.ReqResponse;

/**
 * 商城用户中心
 * @author Win
 *
 */
public interface MallUserCenterService {
	
	/**
	 * 获取用户中心数据统计
	 * @param user_id
	 * @return
	 */
	ReqResponse<StatisticDTO> getStatistic(String user_id);

}
