package com.shifeng.provide.mall.service;

import java.util.List;

import com.shifeng.dto.mall.comments.OrderShopCommentDTO;
import com.shifeng.dto.mall.order.OrderExpressDetailDTO;
import com.shifeng.dto.mall.order.OrderInfoDTO;
import com.shifeng.dto.mall.order.OrderInfoLogDTO;
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
 * 商城订单Service接口
 * @author WinZhong
 *
 */
public interface MallOrderService {
	
	

	
	/**
	 * 获取订单预览信息
	 * @return
	 */
	ReqResponse<List<OrderPreviewInfoDTO>> getOrderPreviewInfo(List<OrderWareDTO>  products);
	
	/**
	 * 订单结算
	 * @param orderSettlementInfo
	 * @return
	 */
	ReqResponse<OrderPayConfirmDTO> settlement(String user_id,OrderSettlementDTO  orderSettlementInfo);

	/**
	 * 获取待支付订单信息
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param type 订单类型（1：父订单；2：子订单）
	 * @return
	 */
	ReqResponse<UnpaidOrderInfo> getUnpaidOrderInfo(String user_id, String order_id,int type);
	
	/**
	 * 获取用户订单信息列表
	 * List<OrderInfoDTO>
	 * @param user_id	用户ID
	 * @param order_id	订单id【可为空】
	 * @param status	订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）【可为空】
	 * @param comment 查看未评价订单(2未评价)【可为空】
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> getOrderList(String user_id, String order_id,Integer status,Integer comment,int currentPage);
	
	
	
	/**
	 * 获取用户售后订单信息列表
	 * List<OrderServiceDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> getRepairOrderList(String user_id,int currentPage);
	
	/**
	 * 获取用户订单信详情
	 * @param user_id	用户ID
	 * @param order_id	订单id【可为空】
	 * @return
	 */
	ReqResponse<OrderInfoDTO> getOrderInfo(String user_id, String order_id);
	
	/**
	 * 取消订单
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	取消订单原因ID
	 * @return
	 */
	ReqResponse<String> cancelOrder(String user_id, String order_id,int reason);
	
	/**
	 * 订单退款
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	订单退款原因ID
	 * @return
	 */
	ReqResponse<String> orderRefund(String user_id, String order_id,int reason);
	
	/**
	 * 订单确认收货
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 */
	ReqResponse<String> orderConfirm(String user_id, String order_id);
	
	
	/**
	 * 添加订单评论
	 * @param orderComment	评论信息DTO
	 * @return
	 */
	ReqResponse<String> commentOrder(OrderShopCommentDTO orderComment);
	
	
	/**
	 * 查询订单快递列表
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 */
	ReqResponse<List<OrderExpressDetailDTO>> getOrderExpress(String user_id,String order_id);

	/**
	 * 申请售后
	 * @param serviceApply
	 * @return
	 */
	ReqResponse<String> serviceApply(ServiceApplyDTO serviceApply);
	
	/**
	 * 获取售后服务单明细 
	 * @param user_id 用户ID
	 * @param serviceNumber 售后服务单号
	 * @param req
	 * @throws Exception
	 */
	ReqResponse<OrderServiceDetailDTO> getRepairOrderDetail(String user_id, String serviceNumber);
	

	
	/**
	 * 获取售后商品列表
	 * List<OrderServiceWareDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> getOrderServiceWareList(String user_id,int currentPage);
	
	
	/**
	 * 查询订单日志
	 * @param order_id	订单id
	 * @return
	 */
	public ReqResponse<List<OrderInfoLogDTO>> getOrderInfoLogs(String order_id);
	
}
