package com.shifeng.pay.service.order.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.common.OrderType;
import com.shifeng.dao.BaseDao;
import com.shifeng.pay.entity.order.UnpaidOrderInfo;
import com.shifeng.pay.service.order.UnpaidOrderService;

/**
 * 未支付订单Service
 * @author WinZhong
 *
 */
@Service("unpaidOrderServiceImpl")
public class UnpaidOrderServiceImpl implements UnpaidOrderService{

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 获取待支付订单信息
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @return
	 */
	public UnpaidOrderInfo getUnpaidOrderInfo(String order_id,String order_type) {
		UnpaidOrderInfo orderInfo = null;
		switch (order_type) {
		case OrderType.WARES://商品订单 (父订单)
			orderInfo = getUnpaidWaresOrderInfo(order_id);
			break;
		case OrderType.WARE://商品订单 (子订单)
			orderInfo = getUnpaidWareOrderInfo(order_id);
			break;
		case OrderType.SHOP://商家店铺入驻续费订单
			orderInfo = getUnpaidShopOrderInfo(order_id);
			break;
		default:
			logger.error("获取待支付订单(订单号："+order_id+"   订单类型："+order_type+")信息出错：订单类型不匹配");
			break;
		}
		if(orderInfo != null){
			orderInfo.setOrder_type(order_type);
		}
		return orderInfo;
	}

	
	/**
	 * 获取商品订单 (父订单)
	 * @param order_id
	 * @return
	 */
	private UnpaidOrderInfo getUnpaidWaresOrderInfo(String order_id){
		try {
			List<UnpaidOrderInfo> orderList = (List<UnpaidOrderInfo>)dao.findForList("UnpaidOrderMapper.getUnpaidWaresOrderById", order_id);
			if(orderList != null && orderList.size()>0){
				UnpaidOrderInfo orderInfo = orderList.get(0);
				orderInfo.setOrder_id(order_id);
				if(orderList.size()>1){
					orderInfo.setOrder_name(orderInfo.getOrder_name()+"  等多件");
				}
				orderInfo.setOrder_body(orderInfo.getOrder_name());
				//orderInfo.setTotal_fee(order.get("total_fee").toString());
				return orderInfo;
			}
		} catch (Exception e) {
			logger.error("获取商品 (父订单)待支付订单(订单号："+order_id+"   订单类型：wares)信息出错：", e);
		}
		return null;
	}
	
	/**
	 * 获取商品订单 (子订单)
	 * @param order_id
	 * @return
	 */
	private UnpaidOrderInfo getUnpaidWareOrderInfo(String order_id){
		try {
			List<UnpaidOrderInfo> orderList = (List<UnpaidOrderInfo>)dao.findForList("UnpaidOrderMapper.getUnpaidWareOrderById", order_id);
			if(orderList != null && orderList.size()>0){
				UnpaidOrderInfo orderInfo = orderList.get(0);
				orderInfo.setOrder_id(order_id);
				if(orderList.size()>1){
					orderInfo.setOrder_name(orderInfo.getOrder_name()+"  等多件");
				}
				orderInfo.setOrder_body(orderInfo.getOrder_name());
				//orderInfo.setTotal_fee(order.get("total_fee").toString());
				return orderInfo;
			}
		} catch (Exception e) {
			logger.error("获取商品 (子订单)待支付订单(订单号："+order_id+"   订单类型：ware)信息出错：", e);
		}
		return null;
	}
	
	/**
	 * 获取商家店铺入驻续费订单
	 * @param order_id
	 * @return
	 */
	private UnpaidOrderInfo getUnpaidShopOrderInfo(String order_id){
		try {
			UnpaidOrderInfo orderInfo = (UnpaidOrderInfo)dao.findForObject("UnpaidOrderMapper.getUnpaidShopOrderById", order_id);
			return orderInfo;
		} catch (Exception e) {
			logger.error("获取商家店铺入驻续费待支付订单(订单号："+order_id+"   订单类型：shop)信息出错：", e);
		}
		return null;
	}
	
	
	

}
