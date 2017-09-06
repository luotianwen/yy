package com.shifeng.webapi.service.order;

import java.util.List;

import com.shifeng.dto.express.ExpressTraceDTO;
import com.shifeng.dto.mall.comments.OrderShopCommentDTO;
import com.shifeng.dto.mall.order.OrderExpressDetailDTO;
import com.shifeng.dto.mall.order.OrderInfoDTO;
import com.shifeng.dto.mall.order.OrderPayConfirmDTO;
import com.shifeng.dto.mall.order.OrderPreviewInfoDTO;
import com.shifeng.dto.mall.order.OrderServiceDetailDTO;
import com.shifeng.dto.mall.order.OrderSettlementDTO;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.dto.mall.order.ServiceApplyDTO;
import com.shifeng.entity.mall.UnpaidOrderInfo;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/**
 * 
 * @author WinZhong
 *
 */
public interface OrderService {
	
	/**
	 * 获取订单预览信息
	 * @return
	 */
	List<OrderPreviewInfoDTO> getOrderPreviewInfo(List<OrderWareDTO>  products);
	
	/**
	 * 订单结算
	 * @param orderSettlementInfo
	 * @return
	 */
	OrderPayConfirmDTO settlement(String user_id,OrderSettlementDTO  orderSettlementInfo,ReqResponse<OrderPayConfirmDTO> req);
	
	/**
	 * 获取待支付订单信息
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param type 订单类型（1：父订单；2：子订单）
	 * @return
	 */
	UnpaidOrderInfo getUnpaidOrderInfo(String user_id,String order_id,int type);
	
	
	
	/**
	 * 获取用户订单信息列表
	 * List<OrderInfoDTO>
	 * @param user_id	用户ID
	 * @param order_id	订单id【可为空】
	 * @param status	订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；）【可为空】
	 * @param comment 查看未评价订单(2未评价)【可为空】
	 * @param currentPage 当前页
	 * @return
	 */
	Page getOrderList(String user_id, String order_id,Integer status,Integer comment,int currentPage);
	
	
	/**
	 * 获取用户售后订单信息列表
	 * List<OrderServiceDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 */
	Page getRepairOrderList(String user_id,int currentPage);
	
	/**
	 * 获取用户订单信详情
	 * @param user_id	用户ID
	 * @param order_id	订单id【可为空】
	 * @return
	 */
	OrderInfoDTO getOrderInfo(String user_id, String order_id);
	
	/**
	 * 取消订单
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	取消订单原因ID
	 * @return
	 */
	boolean cancelOrder(String user_id, String order_id,int reason);
	
	/**
	 * 订单退款
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	订单退款原因ID
	 * @return
	 */
	boolean orderRefund(String user_id, String order_id,int reason);
	
	/**
	 * 订单确认收货
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 */
	boolean orderConfirm(String user_id, String order_id);

	/**
	 * 订单物流跟踪
	 * @param expressCode 快递代码
	 * @param expressNumber	快递单号
	 * @return
	 */
	List<ExpressTraceDTO> getExpressTrace(String expressCode, String expressNumber);

	/**
	 * 查询订单快递列表
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 */
	List<OrderExpressDetailDTO> getOrderExpress(String user_id,String order_id);
	


	/**
	 * 评论订单
	 * @param orderShopComment
	 * @return
	 */
	boolean commentOrder(OrderShopCommentDTO orderComment);

	/**
	 * 申请售后
	 * @param serviceApply
	 * @return
	 */
	boolean serviceApply(ServiceApplyDTO serviceApply);
	
	/**
	 * 获取售后服务单明细 
	 * @param user_id 用户ID
	 * @param serviceNumber 售后服务单号
	 * @return
	 */
	OrderServiceDetailDTO getRepairOrderDetail(String user_id, String serviceNumber);

    /**
     * 获取售后商品列表
     * @param user_id
     * @param currentPage
     * @return
     */
	Page getRepairOrderWareList(String user_id, int currentPage);

}
