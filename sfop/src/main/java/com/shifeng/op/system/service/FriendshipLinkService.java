package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.FriendshipLink;
import com.shifeng.plugin.page.Page;

/** 
 * 友情链接(s_friendship_link)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-23 11:55:35 
 */  
public interface FriendshipLinkService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FriendshipLink> findAllFriendshipLink(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public FriendshipLink findFriendshipLinkById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param friendshiplink
	 * @throws Exception
	 */
	public void updateFriendshipLink(FriendshipLink friendshiplink) throws Exception;
	
	/**
	 * 新增
	 * @param friendshiplink
	 * @throws Exception
	 */
	public void saveFriendshipLink(FriendshipLink friendshiplink) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFriendshipLink(String id) throws Exception;
	
}
