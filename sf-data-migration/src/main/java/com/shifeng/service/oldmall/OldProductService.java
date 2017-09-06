package com.shifeng.service.oldmall;

import java.util.List;

import com.shifeng.entity.ProductImgs;
import com.shifeng.entity.mall.Product;
import com.shifeng.entity.oldmall.OldProduct;
import com.shifeng.plugin.page.Page;

public interface OldProductService {

	/**
	 * 根据sku查找商品
	 * @param sku
	 * @return
	 * @throws Exception
	 */
	Product findBysku(String sku)throws Exception;
	
	/**
	 * 获取商品
	 * @return
	 */
	 List<OldProduct> getProduct(Page page);
		
	/**
	 * 获取商品图片
	 * @return
	 */
	 List<ProductImgs> getProductImages(Page page);
	
}
