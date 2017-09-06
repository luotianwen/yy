package com.shifeng.provide.system.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.provide.system.service.SystemService;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统表以（sys_）开头的表
 */
public class SystemServiceImpl implements SystemService {

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    protected Logger logger = Logger.getLogger(this.getClass());
    @Override
    public List getAllProvince() throws Exception {

        return (List) dao.findForList("SystemMapper.getAllProvince");
    }

    @Override
    public List getAllCityByPid(String pid)throws Exception {
        return (List) dao.findForList("SystemMapper.getAllCityByPid",pid);
    }

    @Override
    public List getAllAreaByCid(String cid)throws Exception {
            return (List) dao.findForList("SystemMapper.getAllAreaByCid",cid);
    }

    @Override
    public String getProvinceNameById(String id) throws Exception {
        return (String) dao.findForObject("SystemMapper.getProvinceNameById",id);
    }

    @Override
    public String getCityNameByPid(String id) throws Exception {
        return (String) dao.findForObject("SystemMapper.getAllCityNameByPid",id);
    }

    @Override
    public String getAreaNameByCid(String id) throws Exception {
        return (String) dao.findForObject("SystemMapper.getAllAreaNameByCid",id);
    }
}
