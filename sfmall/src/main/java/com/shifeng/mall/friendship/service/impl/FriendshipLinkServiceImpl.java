package com.shifeng.mall.friendship.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.FriendshipLink;
import com.shifeng.mall.friendship.service.FriendshipLinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yongshi on 2017/5/18.
 */
@Service("friendshiplinkServiceImpl")
public class FriendshipLinkServiceImpl implements FriendshipLinkService {
    @Resource(name = "baseDaoImpl")
    private BaseDao dao;
    @Override
    public List<FriendshipLink> findAllFriendshipLink() throws Exception {
        return (List<FriendshipLink>) dao.findForList("friendshiplinkMapper.findAllFriendshipLink");

    }

    @Override
    public void saveFriendshipLink(FriendshipLink friendshiplink) throws Exception {
        dao.save("friendshiplinkMapper.saveFriendshipLink", friendshiplink);

    }
}
