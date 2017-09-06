package com.shifeng.op.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.SysSpecial;
import com.shifeng.op.system.service.SysSpecialService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.util.redis.RedisTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
 * 专题页名称(sys_special)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
@Service("sysspecialServiceImpl")
public class SysSpecialServiceImpl implements SysSpecialService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SysSpecial> findAllSysSpecial(Page page) throws Exception{
		return (List<SysSpecial>) dao.findForList("sysspecialMapper.findAllSysSpecialPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public SysSpecial findSysSpecialById(String id) throws Exception{
		return (SysSpecial) dao.findForObject("sysspecialMapper.findSysSpecialById", id);
	}
	
	/**
	 * 新增
	 * @param sysspecial
	 * @throws Exception
	 */
	public void saveSysSpecial(SysSpecial sysspecial) throws Exception{

		dao.save("sysspecialMapper.saveSysSpecial", sysspecial);
	}
	
	/**
	 * 修改
	 * @param sysspecial
	 * @throws Exception
	 */
	public void updateSysSpecial(SysSpecial sysspecial) throws Exception{
		String key=String.format(Const.SPECIAL_DETAIL_CACHE,sysspecial.getId());
		dao.update("sysspecialMapper.updateSysSpecial", sysspecial);
		String str= JSON.toJSONString(sysspecial);
		RedisTool.set(key,str);
		RedisTool.set(String.format(Const.SPECIAL_CACHE_FLAG,sysspecial.getId()),"1");
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSysSpecial(String id) throws Exception{
		dao.delete("sysspecialMapper.deleteSysSpecial", id);
	}
	
}
