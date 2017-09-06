package com.shifeng.provide.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
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
import com.shifeng.provide.mall.dao.MallOrderDao;
import com.shifeng.provide.mall.service.MallOrderService;
import com.shifeng.response.ReqResponse;

/**
 * 商城订单Service接口实现
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class MallOrderServiceImpl implements MallOrderService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallOrderDao")
	private MallOrderDao mallOrderDao;
	
	

	
	/**
	 * 获取订单预览信息
	 */
	public ReqResponse<List<OrderPreviewInfoDTO>> getOrderPreviewInfo(List<OrderWareDTO>  products) {

		ReqResponse<List<OrderPreviewInfoDTO>> req = new ReqResponse<List<OrderPreviewInfoDTO>>();
		try {
			if(products == null || products.size() == 0){
				return req;
			}
			mallOrderDao.getOrderPreviewInfo(products,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取订单预览信息】出错：", e);
			req.setCode(1);
			req.setMsg("【获取订单预览信息】异常");
			return req;
		}
	}
	

	
	/**
	 * 订单结算
	 * @param orderSettlementInfo
	 * @return
	 */
	public ReqResponse<OrderPayConfirmDTO> settlement(String user_id,OrderSettlementDTO  orderSettlementInfo) {
		ReqResponse<OrderPayConfirmDTO> req = new ReqResponse<OrderPayConfirmDTO>();
		try {
			mallOrderDao.saveSettlement(user_id,orderSettlementInfo,req);
			return req;
		} catch (Exception e) {
			if(req.getCode() != 1500){
				req.setCode(1);
				req.setMsg("【订单结算】异常");
				logger.error("【订单结算】出错：", e);
			}
			return req;
		}
	}
	


	/**
	 * 获取待支付订单信息
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param type 订单类型（1：父订单；2：子订单）
	 * @return
	 */
	public ReqResponse<UnpaidOrderInfo> getUnpaidOrderInfo(String user_id, String order_id,int type) {
		ReqResponse<UnpaidOrderInfo> req = new ReqResponse<UnpaidOrderInfo>();
		try {
			mallOrderDao.getUnpaidOrderInfo(user_id,order_id,type,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取待支付订单信息】出错：", e);
			req.setCode(1);
			req.setMsg("【获取待支付订单信息】异常");
			return req;
		}
	}

	
	
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
	public ReqResponse<Page> getOrderList(String user_id, String order_id,Integer status,Integer comment,int currentPage) {
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallOrderDao.getOrderList(user_id,order_id,status,comment,currentPage,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取用户订单信息列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取用户订单信息列表】异常");
			return req;
		}
	}
	
	/**
	 * 获取用户售后订单信息列表
	 * List<OrderServiceDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page> getRepairOrderList(String user_id,int currentPage) {
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallOrderDao.getRepairOrderList(user_id,currentPage,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取用户售后订单信息列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取用户售后订单信息列表】异常");
			return req;
		}
	}
	
	
	
	/**
	 * 获取用户订单信详情
	 * @param user_id	用户ID
	 * @param order_id	订单id【可为空】
	 * @return
	 */
	public ReqResponse<OrderInfoDTO> getOrderInfo(String user_id, String order_id) {
		ReqResponse<OrderInfoDTO> req = new ReqResponse<OrderInfoDTO>();
		try {
			mallOrderDao.getOrderInfo(user_id,order_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取用户订单信详情】出错：", e);
			req.setCode(1);
			req.setMsg("【获取用户订单信详情】异常");
			return req;
		}
	}
	
	/**
	 * 取消订单
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	取消订单原因ID
	 * @return
	 */
	public ReqResponse<String> cancelOrder(String user_id, String order_id,int reason) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallOrderDao.updateCancelOrder(user_id,order_id,reason,req);
			return req;
		} catch (Exception e) {
			logger.error("【取消订单】出错：", e);
			req.setCode(1);
			req.setMsg("【取消订单】异常");
			return req;
		}
	}
	
	/**
	 * 订单退款
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	订单退款原因ID
	 * @return
	 */
	public ReqResponse<String> orderRefund(String user_id, String order_id,int reason) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallOrderDao.updateOrderRefund(user_id,order_id,reason,req);
			return req;
		} catch (Exception e) {
			logger.error("【订单退款】出错：", e);
			req.setCode(1);
			req.setMsg("【订单退款】异常");
			return req;
		}
	}
	
	/**
	 * 订单确认收货
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 */
	public ReqResponse<String> orderConfirm(String user_id, String order_id) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallOrderDao.updateOrderConfirm(user_id,order_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【订单确认收货】出错：", e);
			req.setCode(1);
			req.setMsg("【订单确认收货】异常");
			return req;
		}
	}
	

	
	
	/**
	 * 添加订单评论
	 * @param orderComment	评论信息DTO
	 * @return
	 */
	public ReqResponse<String> commentOrder(OrderShopCommentDTO orderComment) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallOrderDao.addCommentOrder(orderComment,req);
			return req;
		} catch (Exception e) {
			logger.error("【添加订单评论】出错：", e);
			req.setCode(1);
			req.setMsg("【添加订单评论】异常");
			return req;
		}
	}
	
	

	
	
	/**
	 * 查询订单快递列表
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 */
	public ReqResponse<List<OrderExpressDetailDTO>> getOrderExpress(String user_id,String order_id) {
		ReqResponse<List<OrderExpressDetailDTO>> req = new ReqResponse<List<OrderExpressDetailDTO>>();
		try {
			mallOrderDao.getOrderExpress(user_id,order_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【 查询订单快递列表】出错：", e);
			req.setCode(1);
			req.setMsg("【 查询订单快递列表】异常");
			return req;
		}
	}
	
	


	/**
	 * 申请售后
	 * @param serviceApply
	 * @return
	 */
	public ReqResponse<String> serviceApply(ServiceApplyDTO serviceApply) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallOrderDao.addServiceApply(serviceApply,req);
			return req;
		} catch (Exception e) {
			logger.error("【申请售后】出错：", e);
			req.setCode(1);
			req.setMsg("【申请售后】异常");
			return req;
		}
	}
	

	
	/**
	 * 获取售后服务单明细 
	 * @param user_id 用户ID
	 * @param serviceNumber 售后服务单号
	 * @param req
	 * @throws Exception
	 */
	public ReqResponse<OrderServiceDetailDTO> getRepairOrderDetail(String user_id, String serviceNumber) {
		ReqResponse<OrderServiceDetailDTO> req = new ReqResponse<OrderServiceDetailDTO>();
		try {
			mallOrderDao.getRepairOrderDetail(user_id,serviceNumber,req);
			return req;
		} catch (Exception e) {
			logger.error("【 获取售后服务单明细 】出错：", e);
			req.setCode(1);
			req.setMsg("【获取售后服务单明细 】异常");
			return req;
		}
	}
	

	

	
	/**
	 * 获取售后商品列表
	 * List<OrderServiceWareDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page> getOrderServiceWareList(String user_id,int currentPage) {
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallOrderDao.getOrderServiceWareList(user_id,currentPage,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取售后商品列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取售后商品列表】异常");
			return req;
		}
	}
	
	/**
	 * 查询订单日志
	 * @param order_id	订单id
	 * @return
	 */
	public ReqResponse<List<OrderInfoLogDTO>> getOrderInfoLogs(String order_id) {
		ReqResponse<List<OrderInfoLogDTO>> req = new ReqResponse<List<OrderInfoLogDTO>>();
		try {
			mallOrderDao.getOrderInfoLogs(order_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【 查询订单日志】出错：", e);
			req.setCode(1);
			req.setMsg("【 查询订单日志】异常");
			return req;
		}
	}
	
}
