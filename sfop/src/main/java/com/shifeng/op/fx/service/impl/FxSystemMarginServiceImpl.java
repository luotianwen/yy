package com.shifeng.op.fx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.fx.FxSystemMargin;
import com.shifeng.op.fx.service.FxSystemMarginService;
import com.shifeng.plugin.page.Page;

/** 
 * 系统分销利率设置(fx_system_margin)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */  
@Service("fxsystemmarginServiceImpl")
public class FxSystemMarginServiceImpl implements FxSystemMarginService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxSystemMargin> findAllFxSystemMargin(Page page) throws Exception{
		return (List<FxSystemMargin>) dao.findForList("fxsystemmarginMapper.findAllFxSystemMarginPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public FxSystemMargin findFxSystemMarginById(String id) throws Exception{
		return (FxSystemMargin) dao.findForObject("fxsystemmarginMapper.findFxSystemMarginById", id);
	}
	public int countFxSystemMargin(FxSystemMargin fxsystemmargin) throws Exception{
		return (int)dao.findForObject("fxsystemmarginMapper.findFxSystemMargin", fxsystemmargin);
	}
	/**
	 * 新增
	 * @param fxsystemmargin
	 * @throws Exception
	 */
	public void saveFxSystemMargin(FxSystemMargin fxsystemmargin) throws Exception{


		dao.save("fxsystemmarginMapper.saveFxSystemMargin", fxsystemmargin);
	}
	
	/**
	 * 修改
	 * @param fxsystemmargin
	 * @throws Exception
	 */
	public void updateFxSystemMargin(FxSystemMargin fxsystemmargin) throws Exception{
		dao.update("fxsystemmarginMapper.updateFxSystemMargin", fxsystemmargin);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxSystemMargin(String id) throws Exception{
		dao.delete("fxsystemmarginMapper.deleteFxSystemMargin", id);
	}
	
}
