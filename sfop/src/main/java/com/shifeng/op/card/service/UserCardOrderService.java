package com.shifeng.op.card.service;

import java.util.List;
import com.shifeng.entity.card.UserCardOrder;
import com.shifeng.plugin.page.Page;

/** 
 * 用户世峰卡消费(c_user_card_order)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 16:02:33 
 */  
public interface UserCardOrderService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<UserCardOrder> findAllUserCardOrder(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public UserCardOrder findUserCardOrderById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param usercardorder
	 * @throws Exception
	 */
	public void updateUserCardOrder(UserCardOrder usercardorder) throws Exception;
	
	/**
	 * 新增
	 * @param usercardorder
	 * @throws Exception
	 */
	public void saveUserCardOrder(UserCardOrder usercardorder) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserCardOrder(String id) throws Exception;
	
}
