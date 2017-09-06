package com.shifeng.provide.navigation.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.category.Navigation;
import com.shifeng.provide.navigation.service.NavigationService;
import com.shifeng.response.ReqResponse;

import javax.annotation.Resource;
import java.util.List;

@Service(timeout=1200000)
public class NavigationServiceImpl  implements NavigationService{
    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    /**
     * 导航
     * @return
     * @throws Exception
     */
    @Override
    public ReqResponse<List<Navigation>> getNav()  {
        ReqResponse<List<Navigation>> req = new ReqResponse<List<Navigation>>();
        try {
            List<Navigation> list = (List<Navigation>) dao.findForList("navigationcategoryMapper.findAllNavigation");
            req.setData(list);
        }catch (Exception e){
            req.setCode(1);
        }
        return req;
    }


}
