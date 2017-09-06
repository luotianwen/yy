package com.shifeng.op.card.service;

import java.util.List;
import com.shifeng.entity.card.UserCard;
import com.shifeng.plugin.page.Page;

/** 
 * 用户世峰e卡(c_user_card)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 16:02:33 
 */  
public interface UserCardService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<UserCard> findAllUserCard(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public UserCard findUserCardById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param usercard
	 * @throws Exception
	 */
	public void updateUserCard(UserCard usercard) throws Exception;
	
	/**
	 * 新增
	 * @param usercard
	 * @throws Exception
	 */
	public void saveUserCard(UserCard usercard) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserCard(String id) throws Exception;
	
	/**
	 * 查询用户是否绑定e卡
	 * @param number
	 * @return
	 * @throws Exception
	 */
	public boolean findUserCardByCid(String id) throws Exception;
	
}
