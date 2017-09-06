package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.FriendshipLink;
import com.shifeng.op.system.service.FriendshipLinkService;
import com.shifeng.plugin.page.Page;

/** 
 * 友情链接(s_friendship_link)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-23 11:55:35 
 */  
@Service("friendshiplinkServiceImpl")
public class FriendshipLinkServiceImpl implements FriendshipLinkService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FriendshipLink> findAllFriendshipLink(Page page) throws Exception{
		return (List<FriendshipLink>) dao.findForList("friendshiplinkMapper.findAllFriendshipLinkPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public FriendshipLink findFriendshipLinkById(String id) throws Exception{
		return (FriendshipLink) dao.findForObject("friendshiplinkMapper.findFriendshipLinkById", id);
	}
	
	/**
	 * 新增
	 * @param friendshiplink
	 * @throws Exception
	 */
	public void saveFriendshipLink(FriendshipLink friendshiplink) throws Exception{
		dao.save("friendshiplinkMapper.saveFriendshipLink", friendshiplink);
	}
	
	/**
	 * 修改
	 * @param friendshiplink
	 * @throws Exception
	 */
	public void updateFriendshipLink(FriendshipLink friendshiplink) throws Exception{
		dao.update("friendshiplinkMapper.updateFriendshipLink", friendshiplink);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFriendshipLink(String id) throws Exception{
		dao.delete("friendshiplinkMapper.deleteFriendshipLink", id);
	}
	
}
