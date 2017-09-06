package com.shifeng.provide.mall.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.freight.MallShopWareFreight;
import com.shifeng.dto.mall.freight.MallWareFreight;
import com.shifeng.dto.mall.order.OrderWareDTO;
import com.shifeng.response.ReqResponse;

/**
 * 商城运费模板
 * @author WinZhong
 *
 */
@Service("mallFreightDao")
public class MallFreightDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 获取商品运费
	 * @param wareList 商品列表
	 * @param cityId 到达城市ID
	 * @param req
	 * @throws Exception 
	 */
	public void getWareFreights(List<OrderWareDTO> wareList,String cityId, ReqResponse<List<MallShopWareFreight>> req) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cityId", cityId);
		map.put("wareList", wareList);
		//查询商品运费模板
		List<MallWareFreight> wareFreights = (List<MallWareFreight>)dao.findForList("freightMapper.getWareFreights", map);
		Map<String,Integer> wareMap = new HashMap<String,Integer>();
		for(OrderWareDTO p:wareList){
			wareMap.put(p.getSku(), p.getPcount());
		}
		List<MallShopWareFreight> shopWareFreightList = new ArrayList<MallShopWareFreight>();
		double totalFreight = 0.00;
		Integer shopId = null;
		for(MallWareFreight mallWareFreight:wareFreights){
			if(shopId == null){
				shopId = mallWareFreight.getShopId();
				totalFreight = calculateFreight(mallWareFreight,wareMap.get(mallWareFreight.getSku()));
			}else if(shopId != mallWareFreight.getShopId()){
				MallShopWareFreight shopWareFreight = new MallShopWareFreight();
				shopWareFreight.setFreight(totalFreight);
				shopWareFreight.setShopid(shopId);
				shopWareFreightList.add(shopWareFreight);
				
				totalFreight = calculateFreight(mallWareFreight,wareMap.get(mallWareFreight.getSku()));
				shopId = mallWareFreight.getShopId();
			}else{//同店铺运费合计
				totalFreight += calculateFreight(mallWareFreight,wareMap.get(mallWareFreight.getSku()));
			}
			
		}
		MallShopWareFreight shopWareFreight = new MallShopWareFreight();
		shopWareFreight.setFreight(totalFreight);
		shopWareFreight.setShopid(shopId);
		shopWareFreightList.add(shopWareFreight);
		
		req.setData(shopWareFreightList);
		
		
	}
	
	
	/**
	 * 计算运费
	 * @param mallWareFreight
	 * @return
	 */
	private double calculateFreight(MallWareFreight mallWareFreight,int pcount){
		//是否包邮1是2否
		if(mallWareFreight.getIsFree() != null && mallWareFreight.getIsFree() == 1){
			return 0.00;
		}else{
			
			if(mallWareFreight.getFreight_detail_id() == null || mallWareFreight.getFreight_detail_id() == 0){
				//使用默认运费模板
				return getTotalFreight(mallWareFreight.getRuleType(), mallWareFreight.getDefaultFirstUnit(), mallWareFreight.getDefaultFirstMoney(),
						mallWareFreight.getDefaultLastUnit(), mallWareFreight.getDefaultLastMoney(), mallWareFreight.getWeight(),pcount);
				
			}else{
				//使用指定运费模板
				return getTotalFreight(mallWareFreight.getRuleType(), mallWareFreight.getFirstunit(), mallWareFreight.getFirstfee(),
						mallWareFreight.getAddunit(), mallWareFreight.getAddfee(), mallWareFreight.getWeight(),pcount);
				
			}
			
			
		}
	}
	
	/**
	 * 计算总运费
	 * @param ruleType 计费规则
	 * @param firstunit	首重
	 * @param firstfee	首重金额
	 * @param addunit	每增加重量
	 * @param addfee	每增加重量金额
	 * @param weight	货物重量
	 * @param weight	商品数量
	 * @return
	 */
	private double getTotalFreight(Integer ruleType,double firstunit,double firstfee,double addunit,double addfee,double weight,int pcount){
		//运费，单位：元 
		double totalFreight = firstfee;
		
		//计费规则(1按件数;2按重量)
		if(ruleType == 1){//1按件数
			//超过件数
			if(pcount>firstunit){
				int excess = (int) (pcount-firstunit);
				//超重件数
				int frequency = (int) (excess%addunit==0?excess/addunit:excess/addunit+1);
				totalFreight = totalFreight+addfee*frequency;
			}
			
		}else if(ruleType == 2){//2按重量
			weight = weight*pcount;
			//是否超重
			if(weight>firstunit){
				//超重重量
				double overweight = weight-firstunit;
				//超重指数
				int frequency = (int) (overweight%addunit==0?overweight/addunit:overweight/addunit+1);
				totalFreight = totalFreight+addfee*frequency;
			}
		}
		
		
		return totalFreight;
	}
	
	

}
