package com.shifeng.mall.settled.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.ShopCategory;
import com.shifeng.entity.shop.ShopinfoLog;
import com.shifeng.entity.shop.ShopinfoPay;
import com.shifeng.mall.entity.user.Users;
import com.shifeng.mall.settled.dto.ProgressDTO;
import com.shifeng.mall.settled.dto.ShopCategoryDTO;
import com.shifeng.mall.settled.dto.ShopDTO;
import com.shifeng.mall.settled.service.MerchantsSettledService;
import com.shifeng.util.IdWorker;
import com.shifeng.util.redis.RedisTool;

/** 
 * 入驻基本信息填写(s_merchants_settled)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:21 
 */  
@Service("merchantssettledServiceImpl")
public class MerchantsSettledServiceImpl implements MerchantsSettledService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	/*@Resource(name="shopinfologServiceImpl")
	private ShopinfoLogService shopinfologServiceImpl;*/

	/**
	 * 根据ID查询
	 */
	public ShopDTO findMerchantsSettledByUserId(String id) throws Exception{
		return (ShopDTO) dao.findForObject("merchantssettledMapper.findMerchantsSettledByUserId", id);
	}

	@Override
	public ShopDTO findShopByUserId(String id) throws Exception {
		return (ShopDTO) dao.findForObject("merchantssettledMapper.findShopByUserId", id);
	}

	@Override
	public void updateMerchantssettled(ShopDTO shopDTO, Users user) throws Exception {
		shopDTO.setUserId(Integer.parseInt(user.getuId()));
		dao.update("merchantssettledMapper.updateMerchantsSettled", shopDTO);
	}

	public void check_in_2_save(ShopDTO shopDTO) throws Exception{
		//是否有旧数据
		int countShop = (int) dao.findForObject("shopinfoMapper.findShopInfoCount", shopDTO.getUserId()+"");
		//修改店铺信息
		if(countShop>0){
			dao.update("shopinfoMapper.updateShopinfo", shopDTO);
		}else{
			dao.save("shopinfoMapper.saveShopinfo", shopDTO);
		}
		
		//是否有旧数据
		int countStore = (int) dao.findForObject("storesupervisorMapper.findStoresupervisorCount", shopDTO.getS_merchants_id()+"");
		//修改店铺负责人
		if(countStore>0){
			dao.update("storesupervisorMapper.updateStoreSupervisor", shopDTO);
		}else{
			dao.save("storesupervisorMapper.saveStoreSupervisor", shopDTO);
		}
		
		//删除之前类目
		dao.delete("shopcategoryMapper.deleteShopCategory", shopDTO.getS_merchants_id()+"");
		
		if(!StringUtils.isEmpty(shopDTO.getC_category_id())){
			//类目id
			String[] c_category_id = shopDTO.getC_category_id().split(",");
			//类目名称
			String[] categoryName = shopDTO.getCategoryName().split(",");
			//类目保证金标准（元）
			String[] deposit = shopDTO.getDeposit().split(",");
			//平台使用费
			String[] platformfee = shopDTO.getPlatformfee().split(",");
			//扣点
			String[] points = shopDTO.getPoints().split(",");
			//代销店铺扣点
			String[] consignmentpoints = shopDTO.getConsignmentpoints().split(",");
			
			List<ShopCategory> shopCategorys = new ArrayList<ShopCategory>();
			for(int i=0,len=c_category_id.length;i<len;i++){
				ShopCategory shopCategory = new ShopCategory();

				//入驻id
				shopCategory.setS_merchants_id(Integer.valueOf(shopDTO.getS_merchants_id()));
				//类目id
				shopCategory.setC_category_id(Integer.valueOf(c_category_id[i]));
			 	//类目名称
				shopCategory.setCategoryName(categoryName[i]);
				//类目保证金标准（元）
				if(!StringUtils.isEmpty(deposit[i])){
					shopCategory.setDeposit(Double.valueOf(deposit[i]));
				}
			  	//平台使用费
			  	if(!StringUtils.isEmpty(platformfee[i])){
			  		shopCategory.setPlatformfee(Double.valueOf(platformfee[i]));
			  	}
			 	//扣点
			  	if(!StringUtils.isEmpty(points[i])){
			  		shopCategory.setPoints(Double.valueOf(points[i]));
			  	}
			  	//代销店铺扣点
			  	if(!StringUtils.isEmpty(consignmentpoints[i])){
			  		shopCategory.setConsignmentpoints(Double.valueOf(consignmentpoints[i]));
			  	}
			  	
			  	shopCategorys.add(shopCategory);
			}
			shopDTO.setShopCategorys(shopCategorys);
			//新增新类目
			dao.save("shopcategoryMapper.saveShopCategory", shopDTO);
		}
		
		//修改当前步骤
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", shopDTO.getS_merchants_id());
		map.put("next", "3");
		dao.update("merchantssettledMapper.updateNext",map);
	}
	
	/**
	 * 查询店铺类目
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryDTO> findShopCategory(String userId) throws Exception{
		return (List<ShopCategoryDTO>)dao.findForList("shopcategoryMapper.findShopCategory", userId);
	}
	
	/**
	 * 查询店铺订单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<ShopinfoPay> findShopinfoPay(String userId) throws Exception{
		return (List<ShopinfoPay>)dao.findForList("shopinfopayMapper.findShopinfoPay", userId);
	}
	
	/**
	 * 新增订单
	 * @param userId
	 * @throws Exception
	 */
	public void saveOrder(Users user,Map<String,Object> map) throws Exception{
		List<ShopCategory> list = (List<ShopCategory>)dao.findForList("shopcategoryMapper.findShopCategory", user.getuId());
		
		//保证金
		double deposit = 0;
		//平台使用费
		double platformfee = 0;
		
		for(int i=0,len=list.size();i<len;i++){
			if(deposit<list.get(i).getDeposit()){
				deposit = list.get(i).getDeposit();
			}
			if(platformfee<list.get(i).getPlatformfee()){
				platformfee = list.get(i).getPlatformfee();
			}
		}
		
		Date date = new Date();
		
		List<ShopinfoPay> shopinfoPays = new ArrayList<ShopinfoPay>();
		ShopinfoPay paydeposit = new ShopinfoPay();
		//入驻id
		paydeposit.setS_merchants_id(list.get(0).getS_merchants_id());
	 	//用户id
		paydeposit.setUserid(Integer.valueOf(user.getuId()));
	 	//订单id
		paydeposit.setOrderId("B"+IdWorker.getId());
	 	//支付金额
		paydeposit.setPayAmount(deposit);
	 	//说明
		paydeposit.setNote("平台保证金");
	 	//状态
		paydeposit.setStatus(0);
		//提交时间
		paydeposit.setSubTime(date);
	 	//备注
		paydeposit.setRemark("无");
		shopinfoPays.add(paydeposit);
		
		ShopinfoPay payplatformfee = new ShopinfoPay();
		//入驻id
		payplatformfee.setS_merchants_id(list.get(0).getS_merchants_id());
	 	//用户id
		payplatformfee.setUserid(Integer.valueOf(user.getuId()));
	 	//订单id
		payplatformfee.setOrderId("P"+IdWorker.getId());
	 	//支付金额
		payplatformfee.setPayAmount(platformfee);
	 	//说明
		payplatformfee.setNote("平台使用费");
	 	//状态
		payplatformfee.setStatus(0);
		//提交时间
		payplatformfee.setSubTime(date);
	 	//备注
		payplatformfee.setRemark("无");
		shopinfoPays.add(payplatformfee);
		
		map.put("shopinfoPays", shopinfoPays);
		
		dao.findForList("shopinfopayMapper.saveShopinfoPay", map);
	}
	
	/**
	 * 修改入驻步骤
	 * @param user
	 * @throws Exception
	 */
	public void updateNext(String id,String next) throws Exception{
		//修改当前步骤
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("next", next);
		dao.update("merchantssettledMapper.updateNext", map);
	}
	
	/**
	 * 查询当前步骤
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int findNext(String userId) throws Exception{
		String count = (String)dao.findForObject("merchantssettledMapper.findNext", userId);
		if(StringUtils.isEmpty(count)){
			return 0;
		}else{
			return Integer.valueOf(count);
		}
	}
	
	/**
	 * 查询审核日志
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<ShopinfoLog> findShopInfoLog(String userId) throws Exception{
		return (List<ShopinfoLog>) dao.findForList("shopinfologMapper.findShopInfoLog", userId);
	}
	
	/**
	 * 审核进度
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public ProgressDTO findProgress(String userId) throws Exception{
		return (ProgressDTO) dao.findForObject("merchantssettledMapper.findProgress", userId);
	}
	
	
}
