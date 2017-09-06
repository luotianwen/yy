package com.shifeng.provide.mall;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.shifeng.dto.fx.FxTotalDTO;
import com.shifeng.dto.fx.FxUserMoneyDTO;
import com.shifeng.dto.fx.order.FxTotalOrderDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.dao.MallFxDao;
import com.shifeng.provide.mall.service.MallFxService;
import com.shifeng.response.ReqResponse;

/**
 * 商城分销订单
 * @author Win
 *
 */
@Service("mallFxOrderService")
public class MallFxOrderService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallFxDao")
	private MallFxDao mallFxDao;
	
	/**
	 * 添加分销订单
	 * @param user_id
	 * @param perent_order_id
	 */
	@Async("fxOrderExecutor")
	public void addFxOrder(String user_id,String perent_order_id){
		try {
			mallFxDao.addFxOrder(user_id,perent_order_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	/**
	 * 结算分销订单
	 * @param user_id
	 * @param order_id
	 * @param orderStatus 订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
	 */
	@Async("fxOrderExecutor")
	public void settlementFxOrder(String user_id,String order_id,int orderStatus){
		try {
			mallFxDao.updateSettlementFxOrder(user_id,order_id,orderStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 
	

}
