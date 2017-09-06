package com.shifeng.op.fx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.fx.FxUser;
import com.shifeng.op.fx.service.FxUserService;
import com.shifeng.plugin.page.Page;

/** 
 * 分销用户(fx_user)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */  
@Service("fxuserServiceImpl")
public class FxUserServiceImpl implements FxUserService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxUser> findAllFxUser(Page page) throws Exception{
		return (List<FxUser>) dao.findForList("fxuserMapper.findAllFxUserPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public FxUser findFxUserById(String id) throws Exception{
		return (FxUser) dao.findForObject("fxuserMapper.findFxUserById", id);
	}
	
	/**
	 * 新增
	 * @param fxuser
	 * @throws Exception
	 */
	public void saveFxUser(FxUser fxuser) throws Exception{
		dao.save("fxuserMapper.saveFxUser", fxuser);
	}
	
	/**
	 * 修改
	 * @param fxuser
	 * @throws Exception
	 */
	public void updateFxUser(FxUser fxuser) throws Exception{
		dao.update("fxuserMapper.updateFxUser", fxuser);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxUser(String id) throws Exception{
		dao.delete("fxuserMapper.deleteFxUser", id);
	}
	
}
