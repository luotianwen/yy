package com.shifeng.op.mall.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.op.mall.service.MallUsersSilverService;
import com.shifeng.plugin.page.Page;

/** 
 * 我的银币(mall_users_silver)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */  
@Service("malluserssilverServiceImpl")
public class MallUsersSilverServiceImpl implements MallUsersSilverService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallUsersSilver> findAllMallUsersSilver(Page page) throws Exception{
		return (List<MallUsersSilver>) dao.findForList("malluserssilverMapper.findAllMallUsersSilverPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public MallUsersSilver findMallUsersSilverById(String id) throws Exception{
		return (MallUsersSilver) dao.findForObject("malluserssilverMapper.findMallUsersSilverById", id);
	}
	
	/**
	 * 新增
	 * @param malluserssilver
	 * @throws Exception
	 */
	public void saveMallUsersSilver(MallUsersSilver malluserssilver) throws Exception{
		dao.save("malluserssilverMapper.saveMallUsersSilver", malluserssilver);
	}
	
	/**
	 * 修改
	 * @param malluserssilver
	 * @throws Exception
	 */
	public void updateMallUsersSilver(MallUsersSilver malluserssilver) throws Exception{
		dao.update("malluserssilverMapper.updateMallUsersSilver", malluserssilver);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallUsersSilver(String id) throws Exception{
		dao.delete("malluserssilverMapper.deleteMallUsersSilver", id);
	}
	
}
