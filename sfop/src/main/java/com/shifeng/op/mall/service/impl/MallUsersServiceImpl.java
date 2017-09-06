package com.shifeng.op.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallUsers;
import com.shifeng.op.mall.service.MallUsersService;
import com.shifeng.plugin.page.Page;

/** 
 * 前台用户表(mall_users)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */  
@Service("mallusersServiceImpl")
public class MallUsersServiceImpl implements MallUsersService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallUsers> findAllMallUsers(Page page) throws Exception{
		return (List<MallUsers>) dao.findForList("mallusersMapper.findAllMallUsersPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallUsers findMallUsersById(String id) throws Exception{
		return (MallUsers) dao.findForObject("mallusersMapper.findMallUsersById", id);
	}
	
	/**
	 * 新增
	 * @param mallusers
	 * @throws Exception
	 */
	public void saveMallUsers(MallUsers mallusers) throws Exception{
		dao.save("mallusersMapper.saveMallUsers", mallusers);
	}
	
	/**
	 * 修改
	 * @param mallusers
	 * @throws Exception
	 */
	public void updateMallUsers(MallUsers mallusers) throws Exception{
		dao.update("mallusersMapper.updateMallUsers", mallusers);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallUsers(String id) throws Exception{
		dao.delete("mallusersMapper.deleteMallUsers", id);
	}
	
}
