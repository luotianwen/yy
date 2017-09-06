package com.shifeng.provide.mall.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.MallUserAddressDTO;
import com.shifeng.dto.mall.comments.OrderShopCommentDTO;
import com.shifeng.dto.mall.comments.OrderWareCommentDTO;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.order.OrderExpressDetailDTO;
import com.shifeng.dto.mall.order.OrderInfoDTO;
import com.shifeng.dto.mall.order.OrderInfoLogDTO;
import com.shifeng.dto.mall.order.OrderPayConfirmDTO;
import com.shifeng.dto.mall.order.OrderPreviewInfoDTO;
import com.shifeng.dto.mall.order.OrderPreviewWareInfoDTO;
import com.shifeng.dto.mall.order.OrderServiceDTO;
import com.shifeng.dto.mall.order.OrderServiceDetailDTO;
import com.shifeng.dto.mall.order.OrderSettlementDTO;
import com.shifeng.dto.mall.order.OrderSettlementShopDTO;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.dto.mall.order.ServiceApplyDTO;
import com.shifeng.dto.mall.order.service.OrderServiceWareDTO;
import com.shifeng.entity.mall.UnpaidOrderInfo;
import com.shifeng.entity.order.OrderDetailInfo;
import com.shifeng.entity.order.OrderInfo;
import com.shifeng.entity.order.OrderInfoLog;
import com.shifeng.entity.order.OrderInfoServiceLog;
import com.shifeng.entity.order.PorderInfo;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.entity.ware.WareSKU;
import com.shifeng.provide.mall.MallFxOrderService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.IdWorker;
import com.shifeng.util.StringReplaceUtil;

/**
 * 
 * @author WinZhong
 *
 */
@Service("mallOrderDao")
public class MallOrderDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	@Resource(name = "mallFreightDao")
	private MallFreightDao mallFreightDao;

	@Resource(name = "mallFxOrderService")
	private MallFxOrderService mallFxOrderService;

	/**
	 * 获取订单预览信息
	 * @param products
	 * @param req
	 * @throws Exception 
	 */
	public void getOrderPreviewInfo(List<OrderWareDTO> products, ReqResponse<List<OrderPreviewInfoDTO>> req) throws Exception {
		//预览店铺信息
		List<OrderPreviewInfoDTO> shopList = (List<OrderPreviewInfoDTO>)dao.findForList("mallOrderMapper.getPreviewShop", products);
		//预览商品信息
		List<OrderPreviewWareInfoDTO> wareList = (List<OrderPreviewWareInfoDTO>)dao.findForList("mallOrderMapper.getPreviewWare", products);
		if(shopList != null && shopList.size() != 0){
			Map<String,Integer> map = new HashMap<String,Integer>();
			for(OrderWareDTO p:products){
				map.put(p.getSku(), p.getPcount());
			}
			for(OrderPreviewInfoDTO shop:shopList){
				List<OrderPreviewWareInfoDTO> wares = new ArrayList<OrderPreviewWareInfoDTO>();
				for(OrderPreviewWareInfoDTO ware:wareList){
					if(shop.getShopid().intValue() == ware.getShopid().intValue()){
						ware.setNumber(map.get(ware.getSku()));
						wares.add(ware);
					}
				}
				shop.setWareList(wares); 
			}
			
		}
		req.setData(shopList);
		
	}

	/**
	 * 订单结算
	 * @param orderSettlementInfo
	 * @param req
	 * @throws Exception 
	 */
	public void saveSettlement(String user_id,OrderSettlementDTO orderSettlementInfo, ReqResponse<OrderPayConfirmDTO> req) throws Exception {
		 //父订单ID
		 String perentId = IdWorker.getId()+"";
		 //提交时间
		 Date subTime = new Date();
		 //获取收货地址
		 MallUserAddressDTO mallUserAddress = (MallUserAddressDTO)dao.findForObject("malluseraddressMapper.getAddressById", 
				 new String[]{user_id,orderSettlementInfo.getAddressId()+""});
		 //详细地址
		 String address = mallUserAddress.getProvinceName()+mallUserAddress.getCityName()+mallUserAddress.getAreaName()+mallUserAddress.getAddress();

		 //父订单
		 PorderInfo porderInfo = new PorderInfo();
		 porderInfo.setPerentId(perentId);
		 porderInfo.setSubTime(subTime);
		 porderInfo.setUserId(user_id);
		 porderInfo.setReceiveName(mallUserAddress.getContacts());
		 porderInfo.setPhoneNumber(mallUserAddress.getPhone());
		 porderInfo.setAddress(address);
		 
		 //订单总金额
		 double p_order_total_price = 0.00;
	 	 //商家优惠金额
	  	 double p_seller_discount = 0.00;
	 	 //订单货款金额（订单总金额-商家优惠金额）
	  	 double p_order_seller_price = 0.00;
	 	 //商品总金额
	  	 double p_totalMoney = 0.00;
	 	 //用户应付金额
	  	 double p_order_payment = 0.00;
	 	 //商品的运费
	  	 double p_freight_price = 0.00;
		 
	  	 //待删除的购物车
	  	 List<Integer> delCartList = new ArrayList<Integer>();
	  	 //购买正常
	  	 boolean normal = true;
	  	 
		 for(OrderSettlementShopDTO shop:orderSettlementInfo.getShops()){
			 if(!normal){//购买是否正常
				 break;
			 }
			 Map<String,Integer> wareMap = new HashMap<String,Integer>();
			 for(OrderWareDTO p:shop.getWares()){
				 wareMap.put(p.getSku(), p.getPcount());
				 if(null != p.getCartId() && p.getCartId() != 0){
					 System.out.println("购物车ID："+p.getCartId());
					 delCartList.add(p.getCartId());
				 }
			 }
			 ReqResponse<List<MallShopWareFreight>> freightReq = new ReqResponse<List<MallShopWareFreight>>();
			 //计算运费
			 mallFreightDao.getWareFreights(shop.getWares(), orderSettlementInfo.getAddressId()+"", freightReq);
			 List<MallShopWareFreight> shopWareFreightList = freightReq.getData();
			 //运费
		  	 double freight = 0.00;
		  	 if(freightReq.getCode() == 0 && shopWareFreightList != null && shopWareFreightList.size() > 0){
		  		freight = shopWareFreightList.get(0).getFreight();
		  	 }else{
		  		req.setCode(1);
		  		req.setMsg("运费错误");
		  		break;
		  	 }
			 //获取购买商品信息
			 List<WareSKU> skus = (List<WareSKU>)dao.findForList("mallWareMapper.getSettlementWareSku", shop.getWares());
			 //创建订单信息
			 OrderInfo orderInfo = new OrderInfo();
			 orderInfo.setOrderId(IdWorker.getId()+"");
			 orderInfo.setPerentId(perentId);
			 orderInfo.setSellerId(shop.getShopid());
			 orderInfo.setUserId(user_id);
			 orderInfo.setSubTime(subTime);
			 orderInfo.setReceiveName(mallUserAddress.getContacts());
			 orderInfo.setPhoneNumber(mallUserAddress.getPhone());
			 orderInfo.setAddress(address);
			 //是否结算(1：是；2：否)
			 orderInfo.setIsSettlement(2);
			 //订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
			 orderInfo.setOrderStatus(0);
			 orderInfo.setRemark(shop.getRemark());
			 
			 //订单总金额
			 double order_total_price = 0.00;
		 	 //商家优惠金额
		  	 double seller_discount = 0.00;
		 	 //订单货款金额（订单总金额-商家优惠金额）
		  	 double order_seller_price = 0.00;
		 	 //商品总金额
		  	 double totalMoney = 0.00;
		 	 //用户应付金额
		  	 double order_payment = 0.00;
		 	 //商品的运费
		  	 double freight_price = 0.00;
		  	 
		  	 //发票内容
		  	 StringBuffer content = new StringBuffer(); 
			 
			 //订单明细列表
			 List<OrderDetailInfo> orderDetailList = new ArrayList<OrderDetailInfo>();
			 for(WareSKU sku:skus){
				 System.out.println(sku.toString());
				 System.out.println("****getActivitytype******"+sku.getActivitytype());
				 //购买数量
				 int buy_num = wareMap.get(sku.getSku());
				 int stocks = sku.getStocks();
				 if(buy_num>stocks){
					 normal = false; 
					 req.setCode(1500);
					 req.setMsg("订单商品库存不足");
				 }
				 if(!normal){//购买是否正常
					 Integer c = null;
					 //此处故意出错，使已更改的数据回滚
					 c = c+1;
					 
					 //break;
				 }
				 //商品实际购买价格
				 Double price = sku.getPrice();
/*				//活动类型 0正常1秒杀2特价3团购4一元购
				 Integer activitytype = sku.getActivitytype();
				 if(activitytype != null && activitytype > 0){
					//活动价格
					 price = sku.getActivityprice();
				 }*/
				 //订单明细
				 OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
				 orderDetailInfo.setOrderId(orderInfo.getOrderId());
				 orderDetailInfo.setPid(sku.getId());
				 orderDetailInfo.setSku(sku.getSku());
				 orderDetailInfo.setProductNumber(sku.getNumber());
				 orderDetailInfo.setProductName(sku.getpName());
				 orderDetailInfo.setProductImage(sku.getColorPic());
				 orderDetailInfo.setCategory(sku.getCid());
				 orderDetailInfo.setProductStatus(sku.getActivitytype());
				 orderDetailInfo.setInitialPrice(sku.getMarketprice());
				 orderDetailInfo.setSoldPrice(price);
				 orderDetailInfo.setDiscount(sku.getMarketprice()-price);
				 orderDetailInfo.setQuantity(buy_num);
				 orderDetailInfo.setTotalMoney(orderDetailInfo.getSoldPrice()*orderDetailInfo.getQuantity());
				 orderDetailInfo.setColor(sku.getColorName());
				 orderDetailInfo.setColorid(sku.getColorid());
				 orderDetailInfo.setSpecification(sku.getSpecName());
				 orderDetailInfo.setSpecid(sku.getSpecid());
				 orderDetailInfo.setPerentId(perentId);
				 orderDetailList.add(orderDetailInfo);
 				 
				 content.append(sku.getpName());
				 content.append("  ");
				 content.append("x");
				 content.append(orderDetailInfo.getQuantity());
				 content.append("\r\n");
				 
				 //计算订单总金额
				 p_order_total_price += sku.getMarketprice()*orderDetailInfo.getQuantity();
			 	 //商品总金额
				 p_totalMoney += sku.getMarketprice()*orderDetailInfo.getQuantity();
			 	 //商家优惠金额
				 p_seller_discount +=  orderDetailInfo.getDiscount()*orderDetailInfo.getQuantity();
				 //用户应付金额
				 p_order_payment += orderDetailInfo.getTotalMoney();
				 

				 //计算订单总金额
				 order_total_price += sku.getMarketprice()*orderDetailInfo.getQuantity();
			 	 //商品总金额
				 totalMoney += sku.getMarketprice()*orderDetailInfo.getQuantity();
			 	 //商家优惠金额
				 seller_discount +=  orderDetailInfo.getDiscount()*orderDetailInfo.getQuantity();
				 //用户应付金额
				 order_payment += orderDetailInfo.getTotalMoney();
				 
				 /***************更新商品库存****************/
				 Map<String,Object> map = new HashMap<String,Object>();
				 map.put("buy_num", buy_num);
				 map.put("sku", sku.getSku());
				 dao.update("mallWareMapper.updateSkuStockFoeBuy", map);
				 dao.update("mallWareMapper.updateProductTimeFoeBuy", sku.getId());
				 
				 /**************订单日志******************/
				 OrderInfoLog log= new OrderInfoLog();
				 log.setOrder_id(orderInfo.getOrderId());
				 log.setLog_content("您提交了订单，等待支付");
				 log.setCreate_user_id(user_id);
				 log.setCreate_user_name("客户");
				 log.setLog_level(1);
				 log.setAfter_status(0);
				 dao.save("mallOrderInfologMapper.saveOrderInfoLog", log);
			 }
			 p_order_total_price += freight;
			 //商品的运费
			 p_freight_price += freight;
			 
			 order_total_price += freight;
			 //商品的运费
			 freight_price += freight;
			 
		 	 //订单货款金额（订单总金额-商家优惠金额）
			 order_seller_price = order_total_price - seller_discount;
			 orderInfo.setOrder_total_price(order_total_price);
			 orderInfo.setSeller_discount(seller_discount);
			 orderInfo.setOrder_seller_price(order_seller_price);
			 orderInfo.setTotalMoney(totalMoney);
			 orderInfo.setOrder_payment(order_payment+freight_price);
			 orderInfo.setFreight_price(freight_price);
			 
			 
			 
			 /**保存订单明细*/
			 dao.save("mallOrderDetailMapper.saveOrderDetail", orderDetailList);
			 /**保存订单*/
			 dao.save("mallOrderMapper.saveOrderInfo", orderInfo);
			 if(Objects.equal(2, shop.getNotPutInvoice())){//是否开发票(1：不开发票；2：开发票)
				 Map<String,Object> map = new HashMap<String,Object>();
				 map.put("user_id", user_id);
				 map.put("orderId", orderInfo.getOrderId());
				 map.put("postName", mallUserAddress.getContacts());
				 map.put("postPhone", mallUserAddress.getPhone());
				 map.put("postAddress", address);
				 map.put("totalMoneyLower", orderInfo.getOrder_payment());
				 map.put("type", shop.getInvoiceType());
				 
				//发票类型(1：普通发票；2：增值票)   发票抬头类型(1：个人；2：单位)  
				 if(Objects.equal(2, shop.getInvoiceType()) && shop.getInvoiceId() != null){
					 map.put("invoiceId", shop.getInvoiceId());
					 /**保存发票信息*/
					 dao.save("mallOrderInvoiceMapper.saveOrderInvoice", map);
				 }else{
					 if(Objects.equal(2, shop.getInvoiceTitleType())){
						 map.put("paymentsUnit", shop.getInvoiceTitle());
					 }else{
						 map.put("paymentsUnit", "个人");
					 }
					 map.put("content", content.toString());
					 /**保存发票信息*/
					 dao.save("mallOrderInvoiceMapper.saveOrderInvoice1", map);
				 }
				 

			 }
			 
		 }
		 
		 if(normal){
		 	 //订单货款金额（订单总金额-商家优惠金额）
			 p_order_seller_price = p_order_total_price - p_seller_discount;
			 porderInfo.setOrder_total_price(p_order_total_price);
			 porderInfo.setSeller_discount(p_seller_discount);
			 porderInfo.setOrder_seller_price(p_order_seller_price);
			 porderInfo.setTotalMoney(p_totalMoney);
			 porderInfo.setOrder_payment(p_order_payment+p_freight_price);
			 porderInfo.setFreight_price(p_freight_price);
			 //订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
			 porderInfo.setOrderStatus(0);
			 /**保存父订单*/
			 dao.save("mallPorderMapper.savePorder", porderInfo);
			 
			 if(delCartList.size() > 0){//如果商品来自购物车，则删除购物车商品
				 Map<String,Object> map = new HashMap<String,Object>();
				 map.put("user_id", user_id);
				 map.put("skus", delCartList);
				 /**删除购物车商品*/
				 dao.delete("mallcartMapper.deleteMyCartWareByCartId", map);
			 }
			 
			 OrderPayConfirmDTO orderPayConfirm = new OrderPayConfirmDTO();
			 orderPayConfirm.setOrder_total_price(p_order_total_price);
			 orderPayConfirm.setSeller_discount(p_seller_discount);
			 orderPayConfirm.setOrder_seller_price(p_order_seller_price);
			 orderPayConfirm.setTotalMoney(p_totalMoney);
			 orderPayConfirm.setOrder_payment(p_order_payment);
			 orderPayConfirm.setFreight_price(p_freight_price+p_freight_price);
			 orderPayConfirm.setOrderId(perentId);
			 req.setData(orderPayConfirm);
		 }else{
			 
		 }


		 /**====================缺少分销订单返现，待添加========================*/
		 mallFxOrderService.addFxOrder(user_id,perentId);
		 
		 
		 /**=============================================================*/
	}

	/**
	 * 获取待支付订单信息
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param type 订单类型（1：父订单；2：子订单）
	 * @return
	 * @throws Exception 
	 */
	public void getUnpaidOrderInfo(String user_id, String order_id,int type, ReqResponse<UnpaidOrderInfo> req) throws Exception {

		 Map<String,String> map = new HashMap<String,String>();
		 map.put("user_id", user_id);
		 map.put("order_id", order_id);
		 UnpaidOrderInfo order = null;
		 if(type == 1){
			  order = (UnpaidOrderInfo)dao.findForObject("mallPorderMapper.getUnpaidWareOrderById", map);
		 }else{
			 order = (UnpaidOrderInfo)dao.findForObject("mallOrderMapper.getUnpaidWareOrderById", map);
		 }
		 req.setData(order);
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
	 * @throws Exception 
	 */
	public void getOrderList(String user_id, String order_id,Integer status,Integer comment,int currentPage,ReqResponse<Page> req) throws Exception {
		Page page = new Page<>();
		page.setCurrentPage(currentPage);
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); 
		if(StringUtils.isNotBlank(order_id)){
			map.put("order_id", order_id); 
		}
		if(status != null){
			map.put("status", status+""); 
		}
		if(comment != null && comment == 2){
			map.put("comment", comment+""); 
		}
		page.setT(map);
		List<OrderInfoDTO> orderList = (List<OrderInfoDTO>)dao.findForList("mallOrderMapper.getOrderPageList", page);
		page.setResultData(orderList);
		req.setData(page);
	}
	


	/**
	 * 获取用户售后订单信息列表
	 * List<OrderServiceDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 * @throws Exception 
	 */
	public void getRepairOrderList(String user_id, int currentPage, ReqResponse<Page> req) throws Exception {
		Page page = new Page<>();
		page.setCurrentPage(currentPage);
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); page.setT(map);
		List<OrderServiceDTO> orderList = (List<OrderServiceDTO>)dao.findForList("mallOrderServiceMapper.getRepairOrderPageList", page);
		page.setResultData(orderList);
		req.setData(page);
		
	}
	
	/**
	 * 获取用户订单信详情
	 * @param user_id	用户ID
	 * @param order_id	订单id【可为空】
	 * @return
	 * @throws Exception 
	 */
	public void getOrderInfo(String user_id, String order_id,ReqResponse<OrderInfoDTO> req) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); 
		map.put("order_id", order_id); 
		OrderInfoDTO order = (OrderInfoDTO)dao.findForObject("mallOrderMapper.getOrderInfo", map);
		req.setData(order);
	}
	
	/**
	 * 取消订单
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	取消订单原因ID
	 * @return
	 * @throws Exception 
	 */
	public void updateCancelOrder(String user_id, String order_id,int reason,ReqResponse<String> req) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); 
		map.put("order_id", order_id); 
		map.put("reason", reason+""); 
		//获取订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
		//int orderStatus = (int)dao.findForObject("", map);
		//取消订单，只能取消订单状态等于0的订单
		int row = (int)dao.update("mallOrderMapper.updateOrderStatusForCancel", map);
		if(row == 0){//取消失败
			req.setCode(1);
			req.setMsg("订单取消失败");
		}else{
			//结算分销订单
			mallFxOrderService.settlementFxOrder(user_id, order_id, 4);
		}
	}
	
	/**
	 * 订单退款
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @param reason	订单退款原因ID
	 * @return
	 * @throws Exception 
	 */
	public void updateOrderRefund(String user_id, String order_id,int reason,ReqResponse<String> req) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); 
		map.put("order_id", order_id); 
		map.put("reason", reason+""); 
		//获取订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
		//int orderStatus = (int)dao.findForObject("", map);
		//订单退款，状态等于1的订单
		int row = (int)dao.update("mallOrderMapper.updateOrderStatusForRefund", map);
		if(row == 0){//退款失败
			req.setCode(1);
			req.setMsg("订单退款失败");
		}else{
			//结算分销订单
			mallFxOrderService.settlementFxOrder(user_id, order_id, 4);
		}
	}
	
	/**
	 * 订单确认收货
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 * @throws Exception 
	 */
	public void updateOrderConfirm(String user_id, String order_id,ReqResponse<String> req) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); 
		map.put("order_id", order_id); 
		//获取订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
		//int orderStatus = (int)dao.findForObject("", map);
		//订单确认收货， 状态等于2的订单
		int row = (int)dao.update("mallOrderMapper.updateOrderStatusForConfirm", map);
		if(row == 0){//订单确认收货失败
			req.setCode(1);
			req.setMsg("订单确认收货失败");
		}else{
			//结算分销订单
			mallFxOrderService.settlementFxOrder(user_id, order_id, 3);
		}
	}

	
	/**
	 * 添加订单评论
	 * @param orderComment	评论信息DTO
	 * @return
	 * @throws Exception 
	 */
	public void addCommentOrder(OrderShopCommentDTO orderComment, ReqResponse<String> req) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", orderComment.getUserId()); 
		map.put("order_id", orderComment.getOrderid()); 
		//获取订单评论状态
		int commentState = (int)dao.findForObject("mallOrderMapper.getOrderCommentState", map);
		if(commentState == 2){
			 //根据订单ID获取店铺ID
			int shopid = (int)dao.findForObject("mallOrderMapper.getOrderShopID", map);
			if(shopid == 0){
				req.setCode(1);
				req.setMsg("未获取到店铺ID");
			}else{
				//是否匿名
				if(orderComment.getAnonymous() == 1){
					orderComment.setReceiveName(StringReplaceUtil.userNameReplaceWithStar(orderComment.getReceiveName()));
				}
				orderComment.setShopid(shopid);
				/************保存店铺评论***************/
				dao.save("mallShopevaluateMapper.saveShopEvaluate", orderComment);
				List<OrderWareCommentDTO> wareComments = orderComment.getWareComments();
				for(OrderWareCommentDTO ware:wareComments){
					ware.setOrderid(orderComment.getOrderid());
					ware.setReceiveName(orderComment.getReceiveName());
					ware.setShopid(orderComment.getShopid());
					ware.setUserId(orderComment.getUserId());
					/************保存商品评论*************/
					dao.save("mallProductevaluateMapper.saveProductEvaluate", ware);
					if(ware.getImgs() != null && ware.getImgs().size() > 0){
						/***************保存评论图片********************/
						dao.save("mallProductevaluateimgMapper.saveProductEvaluateImg", ware);
					}
				}
				/***************修改订单评论状态****************/
				dao.update("mallOrderMapper.updateOrderCommentState", map);
				dao.update("mallOrderDetailMapper.updateOrderWareCommentState", orderComment.getOrderid());
			}
		}else{
			req.setCode(1);
			req.setMsg("该笔订单已评论");
		}

	}

	/**
	 * 查询订单快递列表
	 * @param user_id	用户ID
	 * @param order_id	订单id
	 * @return
	 * @throws Exception 
	 */
	public void getOrderExpress(String user_id,String order_id, ReqResponse<List<OrderExpressDetailDTO>> req) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); 
		map.put("order_id", order_id); 
		List<OrderExpressDetailDTO> eList = (List<OrderExpressDetailDTO>)dao.findForList("mallOrderExpressMapper.getOrderExpressList", map);
		System.out.println("======================================"+eList);
		req.setData(eList);
	}

	
	/**
	 * 申请售后
	 * @param serviceApply
	 * @return
	 * @throws Exception 
	 */
	public void addServiceApply(ServiceApplyDTO serviceApply, ReqResponse<String> req) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", serviceApply.getUserId()); 
		map.put("order_id", serviceApply.getOrder_id()); 
		map.put("sku", serviceApply.getWareId()); 
		/***************获取订单商品售后状态****************/
		//0正常 1退货2换货3维修9售后关闭
		Integer sstatus = (Integer)dao.findForObject("mallOrderDetailMapper.getOrderWareEstatus", map);
		if(sstatus != null && sstatus == 0){
			//
			Integer row = (Integer)dao.findForObject("mallOrderServiceMapper.getRepairOrderCount", map);
			if(row == null || row == 0){
				/***************保存申请售后****************/
				dao.save("mallOrderServiceMapper.saveOrderService", serviceApply);
				if(serviceApply.getId() != null && serviceApply.getId() > 0){
					//申请日志
					OrderInfoServiceLog log = new OrderInfoServiceLog();
					log.setOosid(serviceApply.getId());
					log.setInfo("您的服务单已申请成功，待售后审核中");
					log.setType("1");
					log.setOpid(serviceApply.getUserId());
					log.setOpname("客户");
					/***************保存申请售后log****************/
					dao.save("mallOrderServicelogMapper.saveOrderServiceLog", log);
					if(serviceApply.getImgs() != null && serviceApply.getImgs().size( )> 0){
						/***************保存申请售后图片****************/
						dao.save("mallOrderServiceimgMapper.saveOrderServiceImg", serviceApply);
					}
					/***************更新订单售后状态****************/
					map.put("sstatus", serviceApply.getApplyType()); 
					dao.update("mallOrderDetailMapper.updateOrderShouHouState", map);
				}else{
					req.setCode(1);
					req.setData("售后申请失败");
				}
			}else{
				req.setCode(1);
				req.setData("订单已申请售后");
			}
		}
		
		
		
		
		
		
	}
	
	
	/**
	 * 获取售后服务单明细 
	 * @param user_id 用户ID
	 * @param serviceNumber 售后服务单号
	 * @param req
	 * @throws Exception
	 */
	public void getRepairOrderDetail(String user_id, String serviceNumber, ReqResponse<OrderServiceDetailDTO> req) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); 
		map.put("serviceNumber", serviceNumber); 
		OrderServiceDetailDTO order = (OrderServiceDetailDTO)dao.findForObject("mallOrderServiceMapper.getRepairOrderDetail", map);
		 
		req.setData(order);
		
	}

	/**
	 * 获取售后商品列表
	 * List<OrderServiceWareDTO>
	 * @param user_id	用户ID
	 * @param currentPage 当前页
	 * @return
	 * @throws Exception 
	 */
	public void getOrderServiceWareList(String user_id, int currentPage, ReqResponse<Page> req) throws Exception {
		Page page = new Page<>();
		page.setCurrentPage(currentPage);
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id); 
		page.setT(map);
		List<OrderServiceWareDTO> orderList = (List<OrderServiceWareDTO>)dao.findForList("mallOrderServiceMapper.getOrderServiceWareList", page);
		page.setResultData(orderList);
		req.setData(page); 
		
	}
	
	/**
	 * 查询订单日志
	 * @param order_id	订单id
	 * @return
	 * @throws Exception 
	 */
	public void getOrderInfoLogs(String order_id, ReqResponse<List<OrderInfoLogDTO>> req) throws Exception {
		List<OrderInfoLogDTO> eList = (List<OrderInfoLogDTO>)dao.findForList("mallOrderInfologMapper.findOrderInfoLogById", order_id);
		req.setData(eList);
	}
	
	
}
