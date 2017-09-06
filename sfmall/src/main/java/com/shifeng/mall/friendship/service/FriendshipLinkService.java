package com.shifeng.mall.friendship.service;

import com.shifeng.entity.system.FriendshipLink;

import java.util.List;

/**
 * Created by yongshi on 2017/5/18.
 */
public interface FriendshipLinkService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    public List<FriendshipLink> findAllFriendshipLink() throws Exception;


    /**
     * 新增
     * @param friendshiplink
     * @throws Exception
     */
    public void saveFriendshipLink(FriendshipLink friendshiplink) throws Exception;

}
