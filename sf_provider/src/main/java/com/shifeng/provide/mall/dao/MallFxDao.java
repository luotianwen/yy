package com.shifeng.provide.mall.dao;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.fx.FxTotalDTO;
import com.shifeng.dto.fx.FxUserMoneyDTO;
import com.shifeng.dto.fx.order.FxOrderDTO;
import com.shifeng.dto.fx.order.FxTotalOrderDTO;
import com.shifeng.dto.fx.order.FxTotalOrderDetailedDTO;
import com.shifeng.entity.fx.FxUserMoney;
import com.shifeng.entity.fx.FxUserMoneyLog;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.card.dao.CardDao;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;

/**
 * 商城分销
 * @author Win
 *
 */
@Service("mallFxDao")
public class MallFxDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	@Resource(name = "cardDao")
	private CardDao cardDao;
	
	/**
	 * 获取我的订单列表
	 * @paramuser_id 用户ID
	 * @param day	（0：全部订单；1：今日订单；2：昨天订单；3：本周订单；4：本月订单）
	 * @param recommended_userid 我推荐的用户ID
	 * @param currentPage 当前页
	 * @return
	 * @throws Exception 
	 */
	public void  getMyFxOrderList(String user_id,String day,String recommended_userid,int currentPage,ReqResponse<Page> req) throws Exception {
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
		Page page = new Page();
		page.setCurrentPage(currentPage);
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id);
		if(StringUtils.isBlank(day)){
			map.put("day", "0");
		}else{
			map.put("day", day);
		}
		if(!StringUtils.isBlank(recommended_userid)){
			map.put("recommended_userid", recommended_userid);
		}
		if(Objects.equals(day, "1")){
			map.put("start_time", DateUtil.getYYYY_MM_DD());
		}if(Objects.equals(day, "2")){
			map.put("start_time", DateUtil.YYYY_MM_DDgetBeforDay(1));
		}else if(Objects.equals(day, "3")){
			map.put("start_time", sdfDay.format(DateUtil.getTimesWeekmorning()));
			map.put("end_time",sdfDay.format(DateUtil.getTimesWeeknight()));
		}else if(Objects.equals(day, "4")){
			map.put("start_time", sdfDay.format(DateUtil.getTimesMonthmorning()));
			map.put("end_time", sdfDay.format(DateUtil.getTimesMonthnight()));
		}
		System.out.println(map);
		page.setT(map);
		List<FxOrderDTO> orderList = (List<FxOrderDTO>)dao.findForList("fxorderMapper.getMyFxOrderPageList", page); 
		
		page.setResultData(orderList);
		req.setData(page);
	}
	
	/**
	 * 获取我的分销总计
	 * @param user_id
	 * @return
	 * @throws Exception 
	 */
	public void getFxTotal(String user_id,ReqResponse<FxTotalDTO> req) throws Exception {
		FxTotalDTO total = new FxTotalDTO();
		FxUserMoneyDTO money = (FxUserMoneyDTO)dao.findForObject("fxusermoneyMapper.findFxUserMoney", user_id);
		if(money != null){
			total.setTotal_exchange(money.getMoney()); 
			total.setTotal_amount(money.getAllmoney());
		}
		int total_order = (int)dao.findForObject("fxorderMapper.getOrderCount", user_id);
		total.setTotal_order(total_order);
		req.setData(total);
	}


	/**
	 * 获取我的分销佣金
	 * @param user_id
	 * @return
	 * @throws Exception 
	 */
	public void getMyFxCommission(String user_id, ReqResponse<FxUserMoneyDTO> req) throws Exception {
		FxUserMoneyDTO money = (FxUserMoneyDTO)dao.findForObject("fxusermoneyMapper.findFxUserMoney", user_id);
		Double daishouyi = (Double)dao.findForObject("fxorderMapper.getOrderDaiShouYi", user_id);
		if(money == null){
			money = new FxUserMoneyDTO();
		}
		if(daishouyi == null){
			daishouyi = 0.00;
		}
		money.setPending_income(daishouyi);
		req.setData(money);
	}
	
	/**
	 * 分销佣金提现
	 * @param user_id 用户id
	 * @param money 提现金额
	 * @param type 提现类型（1：世峰E卡；2：支付宝；3：微信）
	 * @return
	 * @throws Exception 
	 */
	public void updateEexchange(String user_id,double money,int type,ReqResponse<String> req) throws Exception {
		FxUserMoneyDTO userMoney = (FxUserMoneyDTO)dao.findForObject("fxusermoneyMapper.findFxUserMoney", user_id);
		//可提现金额
		double pending_exchange = userMoney.getMoney();
		 
		if(pending_exchange < money){
			req.setCode(1);
			req.setMsg("可提现金额不足"+money);
		}else{
			
			FxUserMoneyLog log = new FxUserMoneyLog();
			log.setUid(user_id);
			log.setLastmoney(pending_exchange-money);
			log.setLog_type(2);
			log.setMoney(money);
			
			switch (type) {
				case 1://提现到世峰E卡
					//保存兑换金额 提现到世峰E卡
					cardDao.silverCoinExchangeECard(user_id, money, req);
					log.setRemarks("提现到世峰E卡"+req.getMsg());
					break;
				default:
					req.setCode(1);
					req.setMsg("不支持的提现方式");
					break;
			}
			/**更新可提现余额*/
			userMoney.setMoney(pending_exchange-money);
			userMoney.setCostmoney(userMoney.getCostmoney()+money);
			dao.update("fxusermoneyMapper.updateEexchange", userMoney);
			
			
			/**保存提现日志*/
			dao.save("fxusermoneylogMapper.saveFxUserMoneyLog", log);
			
			
			
		}
		
	}
	
	/**
	 * 获取我的分销提现总计
	 * @param user_id
	 * @return
	 */
	public void getFxExchangeTotal(String user_id,ReqResponse<FxTotalDTO> req) {
	}
	
	/**
	 * 获取我的分销提现列表
	 * @param user_id 用户ID
	 * @param type 1收入2支出
	 * @param currentPage 当前页
	 * @return
	 */
	public void getMyFxExchangeList(String user_id,String type,int currentPage,ReqResponse<Page> req) {
		Page page = new Page();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", user_id);
		map.put("type", type); 
		page.setT(map);
		
		
		req.setData(page);
	}

	/**
	 * 获取我的分销订单总计
	 * @param user_id
	 * @return
	 * @throws Exception 
	 */
	public void getOrderTotal(String user_id, ReqResponse<FxTotalOrderDTO> req) throws Exception {
		FxTotalOrderDTO totalOrder = new FxTotalOrderDTO();
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id);
		map.put("day", "1"); 
		map.put("start_time", DateUtil.getYYYY_MM_DD());
		FxTotalOrderDetailedDTO day = (FxTotalOrderDetailedDTO)dao.findForObject("fxorderMapper.getOrderTotal", map); 
		day.setRange(map.get("start_time").substring(5));
		totalOrder.setDay(day);
		
		map.put("day", "2"); 
		map.put("start_time", DateUtil.YYYY_MM_DDgetBeforDay(1));
		FxTotalOrderDetailedDTO yesterday = (FxTotalOrderDetailedDTO)dao.findForObject("fxorderMapper.getOrderTotal", map); 
		yesterday.setRange(map.get("start_time").substring(5));
		totalOrder.setYesterday(yesterday);
		
		map.put("day", "3"); 
		map.put("start_time", sdfDay.format(DateUtil.getTimesWeekmorning()));
		map.put("end_time", sdfDay.format(DateUtil.getTimesWeeknight()));
		FxTotalOrderDetailedDTO week = (FxTotalOrderDetailedDTO)dao.findForObject("fxorderMapper.getOrderTotal", map);
		week.setRange(map.get("start_time").substring(5)+"~"+map.get("end_time").substring(5));
		totalOrder.setWeek(week);
		
		req.setData(totalOrder);
		
	}
	
	
	/**
	 * 添加分销订单
	 * @param user_id
	 * @param perent_order_id
	 * @throws Exception 
	 */
	public void addFxOrder(String user_id,String perent_order_id) throws Exception{
		//获取用户上级用户ID
		String recommend_userid = (String)dao.findForObject("fxuserMapper.getShangjiID", user_id);
		if(StringUtils.isNotBlank(recommend_userid)){//判断用户是否有上级
			 Map<String,String> map = new HashMap<String,String>();
			 map.put("recommend_userid", recommend_userid);
			 map.put("recommended_userid", user_id);
			 map.put("order_id", perent_order_id);
			//计算订单分销佣金
			//double commission = (double)dao.findForObject("fxproductMapper.calculateCommission", perent_order_id);
			//保存分销订单
			dao.save("fxorderMapper.saveFxOrder", map);
		}
		
		
		
	}

	/**
	 * 结算分销订单
	 * @param user_id
	 * @param order_id
	 * @param orderStatus 订单状态（0：等待付款；1：等待发货；2：等待收货；3：交易成功；4：取消订单；5：交易关闭；6：退货；7：待退款）
	 * @throws Exception 
	 */
	public void updateSettlementFxOrder(String user_id, String order_id,int orderStatus) throws Exception {
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("recommended_userid", user_id);
		 map.put("orderid", order_id);
		 if(orderStatus == 4 || orderStatus == 6){
			 System.out.println("取消佣金取消佣金取消佣金取消佣金取消佣金取消佣金取消佣金取消佣金取消佣金");
			 //取消佣金
			 dao.update("fxorderMapper.updateOrderProfitStateForClose", map);
		 }else if(orderStatus == 3){
				//获取用户上级用户ID
				String recommend_userid = (String)dao.findForObject("fxuserMapper.getShangjiID", user_id);
				if(StringUtils.isNotBlank(recommend_userid)){//判断用户是否有上级

					 map.put("recommend_userid", recommend_userid);
					 FxUserMoneyDTO userMoney = (FxUserMoneyDTO)dao.findForObject("fxusermoneyMapper.findFxUserMoney", recommend_userid);
					 if(userMoney == null){
						 userMoney = new FxUserMoneyDTO();
						 //创建佣金账户
						 dao.save("fxusermoneyMapper.initUserMoney", recommend_userid);
					 }
					//获取分销订单佣金
					 double commission = (double)dao.findForObject("fxorderMapper.getOrderDaiShouYiByOrderId", map);
					 map.put("commission", commission);
					//更新分销订单结算状态
					 dao.update("fxorderMapper.updateOrderProfitStateForSettlement", map);
					//更新分销订单结算状态
					 dao.update("fxusermoneyMapper.updateCommission", map);
					//保存佣金变动日志
					FxUserMoneyLog log = new FxUserMoneyLog();
					log.setUid(recommend_userid);
					log.setLastmoney(userMoney.getMoney()+commission);
					log.setLog_type(1);
					log.setMoney(commission);
					dao.save("fxusermoneylogMapper.saveFxUserMoneyLog", log);

					 System.out.println("结算佣金结算佣金结算佣金结算佣金结算佣金结算佣金结算佣金结算佣金结算佣金结算佣金结算佣金结算佣金结算佣金");
				}
		 }
		
	}
	

}
