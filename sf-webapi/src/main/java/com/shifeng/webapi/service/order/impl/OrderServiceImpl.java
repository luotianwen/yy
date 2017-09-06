package com.shifeng.webapi.service.order.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

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
import com.shifeng.provide.express.ExpressService;
import com.shifeng.provide.mall.service.MallOrderService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.service.order.OrderService;

/**
 * 
 * @author WinZhong
 *
 */
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService{

    @Resource(name = "mallOrderService")
    private MallOrderService mallOrderService;

    @Resource(name = "expressService")
    private ExpressService expressService;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 获取订单预览信息
	 * @return
	 */
	public List<OrderPreviewInfoDTO> getOrderPreviewInfo(List<OrderWareDTO>  products) {
		try {
			ReqResponse<List<OrderPreviewInfoDTO>> result = mallOrderService.getOrderPreviewInfo(products);
			if(result.getCode() == 0){
				System.out.println(result.getData());
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【添加购物车商品】出错：", e);
		}
		return null;
	}
	

	
	/**
	 * 订单结算
	 * @param orderSettlementInfo
	 * @return
	 */
	public OrderPayConfirmDTO settlement(String user_id,OrderSettlementDTO orderSettlementInfo,ReqResponse<OrderPayConfirmDTO> req) {
		try {
			ReqResponse<OrderPayConfirmDTO> result = mallOrderService.settlement(user_id,orderSettlementInfo);
			if(result.getCode() == 0){
				return result.getData();
			}
			if(result.getCode() == 1500){//库存不足
				req.setMsg(result.getMsg());
			}else{
				req.setMsg(ErrorMsg.FAIL.getMsg());
			}
			logger.error("【订单结算】异常："+ result.getMsg());
		} catch (Exception e) {
			logger.error("【订单结算】出错：", e);
		}
		return null;
	}
	

	
	/**
	 * 获取待支付订单信息
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param type 订单类型（1：父订单；2：子订单）
	 * @return
	 */
	public UnpaidOrderInfo getUnpaidOrderInfo(String user_id,String order_id,int type) {
		try {
			ReqResponse<UnpaidOrderInfo> result = mallOrderService.getUnpaidOrderInfo(user_id,order_id,type);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取待支付订单信息】出错：", e);
		}
		return null;
	}
	
	

	
	
	
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
	public Page getOrderList(String user_id, String order_id,Integer status,Integer comment,int currentPage) {
		try {
			ReqResponse<Page> result = mallOrderService.getOrderList(user_id, order_id, status,comment, currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取用户订单信息列表】出错：", e);
		}
		return null;
	}
	
	
	/**
	 * 获取用户售后订单信息列表
	 * List<OrderServiceDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 */
	public Page getRepairOrderList(String user_id,int currentPage) {
		try {
			ReqResponse<Page> result = mallOrderService.getRepairOrderList(user_id,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取用户售后订单信息列表】出错：", e);
		}
		return null;
	}
	
	/**
	 * 获取用户订单信详情
	 * @param user_id	用户ID
	 * @param order_id	订单id【可为空】
	 * @return
	 */
	public OrderInfoDTO getOrderInfo(String user_id, String order_id) {
		try {
			ReqResponse<OrderInfoDTO> result = mallOrderService.getOrderInfo(user_id, order_id);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取用户订单信详情】出错：", e);
		}
		return null;
	}
	
	/**
	 * 取消订单
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	取消订单原因ID
	 * @return
	 */
	public boolean cancelOrder(String user_id, String order_id,int reason) {
		try {
			ReqResponse<String> result = mallOrderService.cancelOrder(user_id, order_id,reason);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【取消订单】出错：", e);
		}
		return false;
	}
	
	/**
	 * 订单退款
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	订单退款原因ID
	 * @return
	 */
	public boolean orderRefund(String user_id, String order_id,int reason) {
		try {
			ReqResponse<String> result = mallOrderService.orderRefund(user_id, order_id,reason);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【订单退款】出错：", e);
		}
		return false;
	}
	
	/**
	 * 订单确认收货
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 */
	public boolean orderConfirm(String user_id, String order_id) {
		try {
			ReqResponse<String> result = mallOrderService.orderConfirm(user_id, order_id);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【订单确认收货】出错：", e);
		}
		return false;
	}
	


	/**
	 * 订单物流跟踪
	 * @param expressCode 快递代码
	 * @param expressNumber	快递单号
	 * @return
	 */
	public List<ExpressTraceDTO> getExpressTrace(String expressCode, String expressNumber) {
		try {
			ReqResponse<List<ExpressTraceDTO>> result = expressService.getExpressTrace(expressCode, expressNumber);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【订单物流跟踪】出错：", e);
		}
		return null;
	}
	


	/**
	 * 查询订单快递列表
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 */
	public List<OrderExpressDetailDTO> getOrderExpress(String user_id,String order_id) {
		try {
			ReqResponse<List<OrderExpressDetailDTO>> result = mallOrderService.getOrderExpress(user_id,order_id);
			if(result.getCode() == 0){
				List<OrderExpressDetailDTO> list = result.getData();
				if(list != null && list.size() > 0){
					for(OrderExpressDetailDTO e:list){
						ReqResponse<List<ExpressTraceDTO>> tReq = expressService.getExpressTrace(e.getExpressCode(), e.getExpressNumber());
						if(tReq.getCode() == 0){
							List<ExpressTraceDTO> et = tReq.getData();
							e.setExpressTraceList(et);
						}
					}
				}
				return list;
			}
		} catch (Exception e) {
			logger.error("【查询订单快递列表】出错：", e);
		}
		return null;
	}
	

	/**
	 * 评论订单
	 * @param orderComment
	 * @return
	 */
	public boolean commentOrder(OrderShopCommentDTO orderComment) {
		try {
			ReqResponse<String> result = mallOrderService.commentOrder(orderComment);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【评论订单】出错：", e);
		}
		return false;
	}
	


	/**
	 * 申请售后
	 * @param serviceApply
	 * @return
	 */
	public boolean serviceApply(ServiceApplyDTO serviceApply) {
		try {
			ReqResponse<String> result = mallOrderService.serviceApply(serviceApply);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【申请售后】出错：", e);
		}
		return false;
	}
	

	
	/**
	 * 获取售后服务单明细 
	 * @param user_id 用户ID
	 * @param serviceNumber 售后服务单号
	 * @return
	 */
	public OrderServiceDetailDTO getRepairOrderDetail(String user_id, String serviceNumber) {
		try {
			ReqResponse<OrderServiceDetailDTO> result = mallOrderService.getRepairOrderDetail(user_id,serviceNumber);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取售后服务单明细 】出错：", e);
		}
		return null;
	}
	


	/**
	 * 获取售后商品列表
	 * List<OrderServiceWareDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 */
	public Page getRepairOrderWareList(String user_id, int currentPage) {
		try {
			ReqResponse<Page> result = mallOrderService.getOrderServiceWareList(user_id,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取售后商品列表】出错：", e);
		}
		return null;
	}

}
