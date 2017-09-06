package com.shifeng.op.card.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.card.UserCardOrder;
import com.shifeng.op.card.service.UserCardOrderService;
import com.shifeng.plugin.page.Page;

/** 
 * 用户世峰卡消费(c_user_card_order)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 16:02:33 
 */  
@Service("usercardorderServiceImpl")
public class UserCardOrderServiceImpl implements UserCardOrderService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<UserCardOrder> findAllUserCardOrder(Page page) throws Exception{
		return (List<UserCardOrder>) dao.findForList("usercardorderMapper.findAllUserCardOrderPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public UserCardOrder findUserCardOrderById(String id) throws Exception{
		return (UserCardOrder) dao.findForObject("usercardorderMapper.findUserCardOrderById", id);
	}
	
	/**
	 * 新增
	 * @param usercardorder
	 * @throws Exception
	 */
	public void saveUserCardOrder(UserCardOrder usercardorder) throws Exception{
		dao.save("usercardorderMapper.saveUserCardOrder", usercardorder);
	}
	
	/**
	 * 修改
	 * @param usercardorder
	 * @throws Exception
	 */
	public void updateUserCardOrder(UserCardOrder usercardorder) throws Exception{
		dao.update("usercardorderMapper.updateUserCardOrder", usercardorder);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserCardOrder(String id) throws Exception{
		dao.delete("usercardorderMapper.deleteUserCardOrder", id);
	}
	
}
