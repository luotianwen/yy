package com.shifeng.provide.mall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.entity.mall.MallUsersSilverLog;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.card.dao.CardDao;
import com.shifeng.response.ReqResponse;

@Service("mallUsersSilverDao")
public class MallUsersSilverDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	@Resource(name = "cardDao")
	private CardDao cardDao;

	/**
	 * 获取我的银币
	 * @param user_id 用户id
	 * @return
	 * @throws Exception 
	 */
	public void getSilverCoin(String user_id, ReqResponse<MallUsersSilver> req) throws Exception {
		MallUsersSilver mallUsersSilver = (MallUsersSilver)dao.findForObject("malluserssilverMapper.findMallUsersSilverByUserId", user_id);
		if(null == mallUsersSilver){
			mallUsersSilver = new MallUsersSilver();
			mallUsersSilver.setAllsilver(0);
			mallUsersSilver.setLastsilver(0);
			mallUsersSilver.setSilver(0);
		}
		req.setData(mallUsersSilver);
		req.setCode(0);
	}

	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @param pageSize 每页条数
	 * @return
	 * @throws Exception 
	 */
	public void exchangeRecord(String user_id, int currentPage, Integer pageSize,ReqResponse<Page<String>> req) throws Exception {

		Page<String> page = new Page<String>();
		page.setT(user_id);
		page.setCurrentPage(currentPage);
		if(null != pageSize){
			page.setPageSize(pageSize);
		}
		List<MallUsersSilverLog> logList = (List<MallUsersSilverLog>)dao.findForList("malluserssilverlogMapper.getLogPage", page);
		page.setResultData(logList);
		req.setData(page);
		
	}

	/**
	 * 银币兑换
	 * @param user_id 用户id
	 * @return
	 * @throws Exception 
	 */
	public void updateExchange(String user_id, ReqResponse<String> req) throws Exception {
		//获取我的银币余额
		MallUsersSilver mallUsersSilver = (MallUsersSilver)dao.findForObject("malluserssilverMapper.findMallUsersSilverByUserId", user_id);
		if(null == mallUsersSilver || null == mallUsersSilver.getLastsilver() || 0 == mallUsersSilver.getLastsilver()){
			req.setCode(1);
			req.setMsg("可兑换银币为0");
		}else{
			//获取银币兑换比例
			Integer exchangeRatio = (Integer)dao.findForObject("syssliverMapper.getExchangeRatio");
			if(exchangeRatio == null || exchangeRatio == 0){
				req.setCode(1);
				req.setMsg("系统银币兑换比例为0，请联系管理员设置后方可兑换！");
			}else{
				//计算兑换金额
				int exchange_amount = mallUsersSilver.getLastsilver()/exchangeRatio;
				//保存兑换金额
				cardDao.silverCoinExchangeECard(user_id, exchange_amount, req);
				
				MallUsersSilverLog log = new MallUsersSilverLog();
				log.setLastsilver(mallUsersSilver.getLastsilver());
				log.setSilver(mallUsersSilver.getLastsilver());
				//1收入2兑换
				log.setType(2);
				log.setUid(user_id);
				//保存兑换日志
				dao.save("malluserssilverlogMapper.saveLog", log);
				//更新银币余额（扣除银币）
				dao.update("malluserssilverMapper.updateSilverDeduction", new String[]{user_id,mallUsersSilver.getLastsilver()+""});
			}
		}
		
	}

	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param type 1收入2兑换
	 * @param currentPage 当前页
	 * @return
	 * @throws Exception 
	 */
	public void exchangeRecord(String user_id, String type, int currentPage, Integer pageSize, ReqResponse<Page> req) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_id", user_id);
		map.put("type", type);
		Page page = new Page();
		page.setT(map);
		if(null != pageSize){
			page.setPageSize(pageSize);
		}
		page.setCurrentPage(currentPage);
		List<MallUsersSilverLog> logList = (List<MallUsersSilverLog>)dao.findForList("malluserssilverlogMapper.getNewLogPage", page);
		page.setResultData(logList);
		req.setData(page);
		
	}

}
