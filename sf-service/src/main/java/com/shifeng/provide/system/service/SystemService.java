package com.shifeng.provide.system.service;

import java.util.List;

/**
 * 系统表以（sys_）开头的表
 */
public interface SystemService {
    /**
     * 获取所有省份
     */
    public List  getAllProvince() throws Exception;

    /**
     * 获取市通过省份id
     */
    public List getAllCityByPid(String pid)throws Exception;

    /**
     * 获取区通过市id
     */
    public List getAllAreaByCid(String cid)throws Exception;

    public String getProvinceNameById(String id)throws Exception;
    public String getCityNameByPid(String id)throws Exception;
    public String getAreaNameByCid(String id)throws Exception;
}
