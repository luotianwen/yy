package com.shifeng.mall.friendship.controller;

import com.shifeng.entity.system.FriendshipLink;
import com.shifeng.mall.controller.BaseController;
import com.shifeng.mall.entity.user.Users;
import com.shifeng.mall.friendship.service.FriendshipLinkService;
import com.shifeng.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongshi on 2017/5/18.
 */
@Controller
@RequestMapping("/link")
public class FriendshipLinkController extends BaseController {

    @Resource(name="friendshiplinkServiceImpl")
    private FriendshipLinkService friendshiplinkServiceImpl;

    /**
     * 列表页面
     * @param mv
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/friendshipLink")
    public ModelAndView friendshipLink(ModelAndView mv) throws Exception{
        List<FriendshipLink> list= friendshiplinkServiceImpl.findAllFriendshipLink();
        mv.addObject("list",list);
        mv.setViewName(basePath + "system/friendshipLink.btl");
        return mv;
    }
    /**
     * 新增
     * @param friendshiplink
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/saveFriendshipLink")
    @ResponseBody
    public Map<String,Object> saveFriendshipLink(FriendshipLink friendshiplink, HttpSession session) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Const.RESPONSE_STATE, 500);
        Users user = (Users) session.getAttribute(Const.MALL_SESSION_USER);
        if(user==null){
            map.put(Const.ERROR_INFO, "还未登录！请登录");
            return map;
        }
        try {
            friendshiplink.setUpdatename(user.getuName());
            friendshiplinkServiceImpl.saveFriendshipLink(friendshiplink);
            map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
        }
        return map;
    }
}
