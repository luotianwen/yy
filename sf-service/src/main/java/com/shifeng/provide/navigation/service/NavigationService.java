package com.shifeng.provide.navigation.service;


import com.shifeng.entity.category.Navigation;
import com.shifeng.response.ReqResponse;

import java.util.List;

public interface NavigationService {
    /**
     * 获取导航
     * @return
     * @throws Exception
     */
    ReqResponse<List<Navigation>> getNav();

}
