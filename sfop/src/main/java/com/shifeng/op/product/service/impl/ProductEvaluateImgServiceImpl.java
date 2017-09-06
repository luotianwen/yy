package com.shifeng.op.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.ProductEvaluateImg;
import com.shifeng.op.product.service.ProductEvaluateImgService;
import com.shifeng.plugin.page.Page;

/** 
 * 商品评价图片(p_product_evaluate_img)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:53 
 */  
@Service("productevaluateimgServiceImpl")
public class ProductEvaluateImgServiceImpl implements ProductEvaluateImgService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductEvaluateImg> findAllProductEvaluateImg(Page page) throws Exception{
		return (List<ProductEvaluateImg>) dao.findForList("productevaluateimgMapper.findAllProductEvaluateImgPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ProductEvaluateImg findProductEvaluateImgById(String id) throws Exception{
		return (ProductEvaluateImg) dao.findForObject("productevaluateimgMapper.findProductEvaluateImgById", id);
	}
	
	/**
	 * 新增
	 * @param productevaluateimg
	 * @throws Exception
	 */
	public void saveProductEvaluateImg(ProductEvaluateImg productevaluateimg) throws Exception{
		dao.save("productevaluateimgMapper.saveProductEvaluateImg", productevaluateimg);
	}
	
	/**
	 * 修改
	 * @param productevaluateimg
	 * @throws Exception
	 */
	public void updateProductEvaluateImg(ProductEvaluateImg productevaluateimg) throws Exception{
		dao.update("productevaluateimgMapper.updateProductEvaluateImg", productevaluateimg);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProductEvaluateImg(String id) throws Exception{
		dao.delete("productevaluateimgMapper.deleteProductEvaluateImg", id);
	}
	
}
