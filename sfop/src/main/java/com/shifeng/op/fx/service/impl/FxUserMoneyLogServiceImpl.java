package com.shifeng.op.fx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.fx.FxUserMoneyLog;
import com.shifeng.op.fx.service.FxUserMoneyLogService;
import com.shifeng.plugin.page.Page;

/** 
 * 用户余额日志(fx_user_money_log)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */  
@Service("fxusermoneylogServiceImpl")
public class FxUserMoneyLogServiceImpl implements FxUserMoneyLogService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxUserMoneyLog> findAllFxUserMoneyLog(Page page) throws Exception{
		return (List<FxUserMoneyLog>) dao.findForList("fxusermoneylogMapper.findAllFxUserMoneyLogPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public FxUserMoneyLog findFxUserMoneyLogById(String id) throws Exception{
		return (FxUserMoneyLog) dao.findForObject("fxusermoneylogMapper.findFxUserMoneyLogById", id);
	}
	
	/**
	 * 新增
	 * @param fxusermoneylog
	 * @throws Exception
	 */
	public void saveFxUserMoneyLog(FxUserMoneyLog fxusermoneylog) throws Exception{
		dao.save("fxusermoneylogMapper.saveFxUserMoneyLog", fxusermoneylog);
	}
	
	/**
	 * 修改
	 * @param fxusermoneylog
	 * @throws Exception
	 */
	public void updateFxUserMoneyLog(FxUserMoneyLog fxusermoneylog) throws Exception{
		dao.update("fxusermoneylogMapper.updateFxUserMoneyLog", fxusermoneylog);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxUserMoneyLog(String id) throws Exception{
		dao.delete("fxusermoneylogMapper.deleteFxUserMoneyLog", id);
	}
	
}
