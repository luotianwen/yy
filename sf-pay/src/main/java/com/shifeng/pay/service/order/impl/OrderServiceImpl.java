package com.shifeng.pay.service.order.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.common.OrderType;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInfoLog;
import com.shifeng.pay.entity.order.OrderPayInfo;
import com.shifeng.pay.entity.order.UnpaidOrderInfo;
import com.shifeng.pay.entity.pay.PayPaymentRecord;
import com.shifeng.pay.service.order.OrderService;

/**
 * 订单
 * @author WinZhong
 *
 */
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService{

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

	protected Logger logger = Logger.getLogger(this.getClass());
	

	
	/**
	 * 判断订单是否已支付
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @return
	 */
	public UnpaidOrderInfo isOrderNoDeal(String order_id,String order_type) throws Exception {
		UnpaidOrderInfo order = null;
		switch (order_type) {
		case OrderType.WARES://商品订单 (父订单)
			order = (UnpaidOrderInfo)dao.findForObject("wareOrderMapper.getParentUnpaidWaresOrderById", order_id);
			break;
		case OrderType.WARE://商品订单 (子订单)
			order = (UnpaidOrderInfo)dao.findForObject("wareOrderMapper.getUnpaidWareOrderById", order_id);
			break;
		case OrderType.SHOP://商家店铺入驻续费订单
			order = (UnpaidOrderInfo)dao.findForObject("UnpaidOrderMapper.getUnpaidShopOrderById", order_id);
			break;
		default:
			break;
		}
		
		return order;
	}
	


	/**
	 * 更新订单支付状态
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @param paymentRecord	订单支付流水信息
	 */
	public void updateOrderState(String order_id,String order_type,Object paymentRecord)  throws Exception {
	  boolean isSave = true;
	  PayPaymentRecord pp = new PayPaymentRecord(paymentRecord);
	  Map<String,String> map = new HashMap<String,String>();
	  map.put("order_id", order_id);
	  map.put("pay_serial_number", pp.getSerial_number());
	  switch (order_type) {
		case OrderType.WARES://商品订单 (父订单)
		 	dao.update("wareOrderMapper.updateParentOrderPayState", map);
		 	dao.update("wareOrderMapper.updateOrderPayStateByPerentId", map);
		 	//根据父订单ID获取子订单ID列表
		 	List<String> orderIdList = (List<String>)dao.findForList("wareOrderMapper.getOrderIdListByParentOrderId", order_id);
		 	if(orderIdList != null && orderIdList.size() > 0){
		 		for(String oid:orderIdList){
		 			saveMallOrderLog(oid);
		 		}
		 	}
			break;
		case OrderType.WARE://商品订单 (子订单)
			dao.update("wareOrderMapper.updateOrderPayState", map);
			saveMallOrderLog(order_id);
			break;
		case OrderType.SHOP://商家店铺入驻续费订单	
			dao.update("shopOrderMapper.updateOrderPayState", map);
		break;
		default:
			isSave = false;
			break;
	  }
		if(isSave){
			dao.save("payPaymentRecordMapper.savePayPaymentRecord",pp);
		}else {
			logger.error(order_type+"，订单类型错误，支付信息"+pp.toString());
		}
	  
	}
	
	/**
	 * 保存商城订单日志
	 * @param order_id
	 * @throws Exception 
	 */
	private void saveMallOrderLog(String order_id) throws Exception{
		 OrderInfoLog log= new OrderInfoLog();
		 log.setOrder_id(order_id);
		 log.setLog_content("您支付了订单，等待卖家处理");
		 log.setCreate_user_name("系统");
		 log.setLog_level(1);
		 //（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
		 log.setAfter_status(1);
		 log.setBefore_status(0);
		 dao.save("mallOrderInfologMapper.saveOrderInfoLog", log);
	}
	
	

	

	
	/**
	 * 获取订单支付信息
	 * @param order_id	订单id
	 * @param order_type	订单类型
	 * @return
	 */
	public OrderPayInfo getPayOrderInfo(String order_id,String order_type) throws Exception {
	    Map<String,String> map = new HashMap<String,String>();
	    map.put("order_id", order_id);
	    map.put("order_type",order_type);
	    OrderPayInfo orderPayInfo = (OrderPayInfo)dao.findForObject("payPaymentRecordMapper.getPayOrderInfo", map);
		return orderPayInfo;
	}
	
	

}
