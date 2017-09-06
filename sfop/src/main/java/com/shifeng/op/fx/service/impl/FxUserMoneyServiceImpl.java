package com.shifeng.op.fx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.fx.FxUserMoney;
import com.shifeng.op.fx.service.FxUserMoneyService;
import com.shifeng.plugin.page.Page;

/** 
 * 用户余额(fx_user_money)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */  
@Service("fxusermoneyServiceImpl")
public class FxUserMoneyServiceImpl implements FxUserMoneyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxUserMoney> findAllFxUserMoney(Page page) throws Exception{
		return (List<FxUserMoney>) dao.findForList("fxusermoneyMapper.findAllFxUserMoneyPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public FxUserMoney findFxUserMoneyById(String id) throws Exception{
		return (FxUserMoney) dao.findForObject("fxusermoneyMapper.findFxUserMoneyById", id);
	}
	
	/**
	 * 新增
	 * @param fxusermoney
	 * @throws Exception
	 */
	public void saveFxUserMoney(FxUserMoney fxusermoney) throws Exception{
		dao.save("fxusermoneyMapper.saveFxUserMoney", fxusermoney);
	}
	
	/**
	 * 修改
	 * @param fxusermoney
	 * @throws Exception
	 */
	public void updateFxUserMoney(FxUserMoney fxusermoney) throws Exception{
		dao.update("fxusermoneyMapper.updateFxUserMoney", fxusermoney);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxUserMoney(String id) throws Exception{
		dao.delete("fxusermoneyMapper.deleteFxUserMoney", id);
	}
	
}
