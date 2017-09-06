package com.shifeng.op.freight.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.freight.ExpressConfig;
import com.shifeng.op.freight.service.ExpressConfigService;
import com.shifeng.plugin.page.Page;

/** 
 * 快递配置(o_expressConfig)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:40:52 
 */  
@Service("expressConfigServiceImpl")
public class ExpressConfigServiceImpl implements ExpressConfigService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ExpressConfig> findAllExpressConfig(Page page) throws Exception{
		return (List<ExpressConfig>) dao.findForList("expressConfigMapper.findAllExpressConfigPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ExpressConfig findExpressConfigById(String id) throws Exception{
		return (ExpressConfig) dao.findForObject("expressConfigMapper.findExpressConfigById", id);
	}
	
	/**
	 * 新增
	 * @param expressConfig
	 * @throws Exception
	 */
	public void saveExpressConfig(ExpressConfig expressConfig) throws Exception{
		dao.save("expressConfigMapper.saveExpressConfig", expressConfig);
	}
	
	/**
	 * 修改
	 * @param expressConfig
	 * @throws Exception
	 */
	public void updateExpressConfig(ExpressConfig expressConfig) throws Exception{
		dao.update("expressConfigMapper.updateExpressConfig", expressConfig);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteExpressConfig(String id) throws Exception{
		dao.delete("expressConfigMapper.deleteExpressConfig", id);
	}
	
}
