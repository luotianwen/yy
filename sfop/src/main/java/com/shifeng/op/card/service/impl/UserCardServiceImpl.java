package com.shifeng.op.card.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.card.UserCard;
import com.shifeng.op.card.service.UserCardService;
import com.shifeng.plugin.page.Page;

/** 
 * 用户世峰e卡(c_user_card)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-25 16:02:33 
 */  
@Service("usercardServiceImpl")
public class UserCardServiceImpl implements UserCardService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<UserCard> findAllUserCard(Page page) throws Exception{
		return (List<UserCard>) dao.findForList("usercardMapper.findAllUserCardPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public UserCard findUserCardById(String id) throws Exception{
		return (UserCard) dao.findForObject("usercardMapper.findUserCardById", id);
	}
	
	/**
	 * 新增
	 * @param usercard
	 * @throws Exception
	 */
	public void saveUserCard(UserCard usercard) throws Exception{
		dao.save("usercardMapper.saveUserCard", usercard);
	}
	
	/**
	 * 修改
	 * @param usercard
	 * @throws Exception
	 */
	public void updateUserCard(UserCard usercard) throws Exception{
		dao.update("usercardMapper.updateUserCard", usercard);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserCard(String id) throws Exception{
		dao.delete("usercardMapper.deleteUserCard", id);
	}
	
	/**
	 * 查询用户是否绑定e卡
	 * @param number
	 * @return
	 * @throws Exception
	 */
	public boolean findUserCardByCid(String id) throws Exception{
		int count = (int)dao.findForObject("usercardMapper.findUserCardByCid", id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
