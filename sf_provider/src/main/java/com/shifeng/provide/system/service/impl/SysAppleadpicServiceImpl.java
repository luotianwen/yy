package com.shifeng.provide.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysAppleadpic;
import com.shifeng.provide.system.service.SysAppleadpicService;
import com.shifeng.response.ReqResponse;
	
public class SysAppleadpicServiceImpl implements SysAppleadpicService {

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

	protected Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 获取引导页
	 * @return
	 */
	public ReqResponse<List<String>> getSysAppleadpic() {
		ReqResponse<List<String>> req = new ReqResponse<List<String>>();
		try {
			List<String> list = (List<String>)dao.findForList("sysappleadpicMapper.getSysAppleadpic");
			req.setCode(0);
			req.setData(list);
		} catch (Exception e) {
			logger.error("获取引导页出错：", e);
			req.setCode(1);
			req.setMsg("获取引导页异常");
		}
		
		return req;
	}
	
	

}
