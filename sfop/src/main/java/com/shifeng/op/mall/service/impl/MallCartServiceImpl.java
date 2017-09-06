package com.shifeng.op.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallCart;
import com.shifeng.op.mall.service.MallCartService;
import com.shifeng.plugin.page.Page;

/** 
 * 购物车(mall_cart)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */  
@Service("mallcartServiceImpl")
public class MallCartServiceImpl implements MallCartService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallCart> findAllMallCart(Page page) throws Exception{
		return (List<MallCart>) dao.findForList("mallcartMapper.findAllMallCartPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallCart findMallCartById(String id) throws Exception{
		return (MallCart) dao.findForObject("mallcartMapper.findMallCartById", id);
	}
	
	/**
	 * 新增
	 * @param mallcart
	 * @throws Exception
	 */
	public void saveMallCart(MallCart mallcart) throws Exception{
		dao.save("mallcartMapper.saveMallCart", mallcart);
	}
	
	/**
	 * 修改
	 * @param mallcart
	 * @throws Exception
	 */
	public void updateMallCart(MallCart mallcart) throws Exception{
		dao.update("mallcartMapper.updateMallCart", mallcart);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallCart(String id) throws Exception{
		dao.delete("mallcartMapper.deleteMallCart", id);
	}
	
}
