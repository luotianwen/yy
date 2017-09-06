package com.shifeng.provide.product.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.Product;

import org.apache.log4j.Logger;

/** 
 * 产品表(p_product) DAO
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-17 13:40:54 
 */  
@Service("productDao")
public class ProductDao{

	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 根据商品ID查询单个商品的详细信息
	 * @param product_id
	 * @return
	 */
	public Product getProduct(String product_id) {
		return null;
	}
	
	// updateRecoverProduct
}
