package com.shifeng.op.fx.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.fx.FxProduct;
import com.shifeng.op.fx.service.FxProductService;
import com.shifeng.plugin.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
 * 商品分销价格(fx_product)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-09 10:31:56 
 */  
@Service("fxproductServiceImpl")
public class FxProductServiceImpl implements FxProductService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxProduct> findAllFxProduct(Page page) throws Exception{
		return (List<FxProduct>) dao.findForList("fxproductMapper.findAllFxProductPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public FxProduct findFxProductById(String id) throws Exception{
		return (FxProduct) dao.findForObject("fxproductMapper.findFxProductById", id);
	}
	
	/**
	 * 新增
	 * @param fxproduct
	 * @throws Exception
	 */
	public void saveFxProduct(FxProduct fxproduct) throws Exception{
		dao.save("fxproductMapper.saveFxProduct", fxproduct);
	}
	
	/**
	 * 修改
	 * @param fxproduct
	 * @throws Exception
	 */
	public void updateFxProduct(FxProduct fxproduct) throws Exception{
		dao.update("fxproductMapper.updateFxProduct", fxproduct);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxProduct(String id) throws Exception{
		dao.delete("fxproductMapper.deleteFxProduct", id);
	}

	@Override
	public void updateFxProductBySnumber(String sku, double costprice) throws Exception {
		List<FxProduct> fxproducts= (List<FxProduct>) dao.findForList("fxproductMapper.findFxProductById",sku);
		for (FxProduct fxproduct2:fxproducts
				) {
			if(null!=fxproduct2.getSku2()){
				fxproduct2.setCostprice(costprice);
				fxproduct2.setMargin(fxproduct2.getPrice()-costprice);
				fxproduct2.setMarginrate(fxproduct2.getMargin()/fxproduct2.getPrice());
				if(null!=fxproduct2.getDistributionrate()){
					fxproduct2.setCommission(fxproduct2.getDistributionrate()*fxproduct2.getPrice());
					fxproduct2.setLastmarginrate(fxproduct2.getMarginrate()-fxproduct2.getDistributionrate());
				}
				dao.update("fxproductMapper.updateFxProduct", fxproduct2);
			}
			else{
				fxproduct2.setCostprice(costprice);
				fxproduct2.setMargin(fxproduct2.getPrice()-costprice);
				fxproduct2.setMarginrate(fxproduct2.getMargin()/fxproduct2.getPrice());
				dao.update("fxproductMapper.saveFxProduct", fxproduct2);
			}
		}
	}

}
