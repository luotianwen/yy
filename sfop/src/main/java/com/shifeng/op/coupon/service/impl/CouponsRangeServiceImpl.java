package com.shifeng.op.coupon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.coupon.CouponsRange;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.op.coupon.service.CouponsRangeService;
import com.shifeng.op.dto.category.CategoryDTO;
import com.shifeng.op.dto.coupons.ProductDTO;
import com.shifeng.plugin.page.Page;

/** 
 * 优惠券使用范围(c_coupons_range)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 15:44:55 
 */  
@Service("couponsrangeServiceImpl")
public class CouponsRangeServiceImpl implements CouponsRangeService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public Object findAllCouponsRange(String id,String scope) throws Exception{
		if("2".equals(scope)||"3".equals(scope)){
			return (List<ProductDTO>) dao.findForList("couponsrangeMapper.findAllCouponsRangeForProduct", id);
		}else if("4".equals(scope)||"5".equals(scope)){
			return (List<Shopinfo>) dao.findForList("couponsrangeMapper.findAllCouponsRangeForShop", id);
		}else if("6".equals(scope)||"7".equals(scope)){
			
		}
		return null;
	}
	
	/**
	 * 根据ID查询
	 */
	public CouponsRange findCouponsRangeById(String id) throws Exception{
		return (CouponsRange) dao.findForObject("couponsrangeMapper.findCouponsRangeById", id);
	}
	
	/**
	 * 新增
	 * @param couponsrange
	 * @throws Exception
	 */
	public void saveCouponsRange(CouponsRange couponsrange) throws Exception{
		dao.save("couponsrangeMapper.saveCouponsRange", couponsrange);
	}
	
	/**
	 * 修改
	 * @param couponsrange
	 * @throws Exception
	 */
	public void updateCouponsRange(CouponsRange couponsrange) throws Exception{
		dao.update("couponsrangeMapper.updateCouponsRange", couponsrange);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteCouponsRange(String id) throws Exception{
		dao.delete("couponsrangeMapper.deleteCouponsRange", id);
	}
	
	/**
	 * 优惠券使用范围(指定参加/不参加店铺)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Shopinfo> findShopForCoupons(Page page) throws Exception{
		return (List<Shopinfo>) dao.findForList("shopinfoMapper.findShopForCouponsPage", page);
	}
	
	/**
	 * 优惠券使用范围(指定参加/不参加分类)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<CategoryDTO> findAllCategoryForCoupons(String id) throws Exception{
		//查询所有分类
		List<CategoryDTO> category = (List<CategoryDTO>) dao.findForList("categoryMapper.findAllCategoryForNavigation");
		//查询该优惠券已关联分类
		List<String> couponsCategory = new ArrayList<String>();
		
		if(!StringUtils.isEmpty(id)){
			couponsCategory = (List<String>) dao.findForList("couponsrangeMapper.findNumberById", id);
		}
		
		if(category!=null){
			Collections.reverse(category);
			
			for(int i=0,len=category.size();i<len;i++){
				CategoryDTO categoryDTO = category.get(i);
				for(int j=0,jlen=couponsCategory.size();j<jlen;j++){
					if((categoryDTO.getId()+"").equals(couponsCategory.get(j))){
						categoryDTO.setChecked(true);
					}
				}
				if(category.get(i).getNodes()!=null){
					Collections.reverse(category.get(i).getNodes());
					for(int k=0,klen=category.get(i).getNodes().size();k<klen;k++){
						CategoryDTO kcategoryDTO = category.get(i).getNodes().get(k);
						for(int j=0,jlen=couponsCategory.size();j<jlen;j++){
							if((kcategoryDTO.getId()+"").equals(couponsCategory.get(j))){
								kcategoryDTO.setChecked(true);
							}
						}
					}
				}
			}
		}
		
		return category;
	}
	
}
