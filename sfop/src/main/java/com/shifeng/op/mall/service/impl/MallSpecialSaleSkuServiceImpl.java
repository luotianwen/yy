package com.shifeng.op.mall.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallSpecialSale;
import com.shifeng.entity.mall.MallSpecialSaleSku;
import com.shifeng.entity.product.ProRules;
import com.shifeng.op.mall.service.MallSpecialSaleService;
import com.shifeng.op.mall.service.MallSpecialSaleSkuService;
import com.shifeng.plugin.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/** 
 * 特卖商品(mall_special_sale_sku)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-22 16:46:48 
 */  
@Service("mallspecialsaleskuServiceImpl")
public class MallSpecialSaleSkuServiceImpl implements MallSpecialSaleSkuService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	@Resource(name="mallspecialsaleServiceImpl")
	private MallSpecialSaleService mallspecialsaleServiceImpl;
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallSpecialSaleSku> findAllMallSpecialSaleSku(Page page) throws Exception{
		return (List<MallSpecialSaleSku>) dao.findForList("mallspecialsaleskuMapper.findAllMallSpecialSaleSkuPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallSpecialSaleSku findMallSpecialSaleSkuById(String id) throws Exception{
		return (MallSpecialSaleSku) dao.findForObject("mallspecialsaleskuMapper.findMallSpecialSaleSkuById", id);
	}
	private void mallSpecialSaleSkuInfo(MallSpecialSaleSku sku) throws Exception {
		MallSpecialSale mallspecialsale = mallspecialsaleServiceImpl.findMallSpecialSaleById(sku.getPid()+"");
		sku.setStarttime(mallspecialsale.getStarttime());
		sku.setEndtime(mallspecialsale.getEndtime());

	}
	/**
	 * 新增
	 * @param mallspecialsalesku
	 * @throws Exception
	 */

	public void saveMallSpecialSaleSku(MallSpecialSaleSku mallspecialsalesku) throws Exception{
		mallSpecialSaleSkuInfo(mallspecialsalesku);
		updateProRules(mallspecialsalesku);
		dao.save("mallspecialsaleskuMapper.saveMallSpecialSaleSku", mallspecialsalesku);
	}


	private void updateProRules(MallSpecialSaleSku mallspecialsalesku)throws Exception{
		//检测当前sku有没有活动
		ProRules p= (ProRules) dao.findForObject("prorulesMapper.findProRulesById",mallspecialsalesku.getSku());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(p.getEndtime()!=null&&p.getEndtime().getTime()>df.parse(mallspecialsalesku.getStarttime()).getTime()){
			throw new Exception(mallspecialsalesku.getSku()+"已存在活动");
		}

		ProRules p2=new ProRules();
		p2.setSku(Integer.parseInt(mallspecialsalesku.getSku()));
		p2.setEndtime(df.parse(mallspecialsalesku.getEndtime()));
		p2.setStarttime(df.parse(mallspecialsalesku.getStarttime()));
		p2.setActivitytype(2);
		p2.setActivityprice(mallspecialsalesku.getActivityprice());
		p2.setActivitystocks(mallspecialsalesku.getActivitystocks());

		dao.update("prorulesMapper.updateProRulesActivity",p2);
	}
	/**
	 * 修改
	 * @param mallspecialsalesku
	 * @throws Exception
	 */
	public void updateMallSpecialSaleSku(MallSpecialSaleSku mallspecialsalesku) throws Exception{
		mallSpecialSaleSkuInfo(mallspecialsalesku);
		MallSpecialSaleSku mallspecialsalesku2=findMallSpecialSaleSkuById(mallspecialsalesku.getId()+"");
		if(!mallspecialsalesku2.getSku().equals(mallspecialsalesku.getSku())) {
			dao.update("prorulesMapper.updateProRulesActivityEmpty", mallspecialsalesku2.getSku());
			updateProRules(mallspecialsalesku);
		}

		dao.update("mallspecialsaleskuMapper.updateMallSpecialSaleSku", mallspecialsalesku);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallSpecialSaleSku(String id) throws Exception{
		dao.delete("mallspecialsaleskuMapper.deleteMallSpecialSaleSku", id);
	}
	
}
