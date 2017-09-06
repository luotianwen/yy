package com.shifeng.provide.usercenter.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.usercenter.OrderStatusDTO;
import com.shifeng.dto.mall.usercenter.OrderStatusStatisticDTO;
import com.shifeng.dto.mall.usercenter.StatisticDTO;
import com.shifeng.response.ReqResponse;

@Service("mallUserCenterDao")
public class MallUserCenterDao{

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    protected Logger logger = Logger.getLogger(this.getClass());

    
	/**
	 * 获取用户中心数据统计
	 * @param user_id
	 * @return
	 * @throws Exception 
	 */
	public void getStatistic(String user_id, ReqResponse<StatisticDTO> req) throws Exception {
		OrderStatusStatisticDTO orderStatus = new OrderStatusStatisticDTO();
		//统计订单状态
		List<OrderStatusDTO> list = (List<OrderStatusDTO>)dao.findForList("mallOrderMapper.getOrderStatusStatistic", user_id);
		if(list != null && list.size() > 0){
			for(OrderStatusDTO order:list){
				//（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
				switch (order.getOrderStatus()) {
				case 0://0：等待付款
					orderStatus.setDaifukuan(order.getNum());
					break;
				case 1://1：等待发货
					orderStatus.setDaifahuo(order.getNum());
					break;
				case 2://2：等待收货
					orderStatus.setDaishouhuo(order.getNum());
					break;
				case 7://7：待退款
					orderStatus.setDaituikuan(order.getNum());
					break;
				default:
					break;
				}
			}
		}
		//统计售后
		Integer shouhou = (Integer)dao.findForObject("mallOrderServiceMapper.getOrderShouhouStatistic", user_id);
		//统计待评价
		Integer daipingjia = (Integer)dao.findForObject("mallOrderMapper.getOrderPingJiaStatistic", user_id);
		orderStatus.setShouhou(shouhou);
		orderStatus.setDaipingjia(daipingjia);
		//统计关注商品
		Integer followWare = (Integer)dao.findForObject("mallfollowWareMapper.getFollowWareStatistic", user_id);
		//统计关注店铺
		Integer followVender = (Integer)dao.findForObject("mallfollowVenderMapper.getFollowVenderStatistic", user_id);
		//统计积分
		Integer point = (Integer)dao.findForObject("SysUserMapper.getIntegral", user_id);
		StatisticDTO statistic = new StatisticDTO();
		statistic.setFollowVender(followVender);
		statistic.setFollowWare(followWare);
		statistic.setOrder(orderStatus);
		statistic.setPoint(point);
		
		req.setData(statistic);
		
	}

}
