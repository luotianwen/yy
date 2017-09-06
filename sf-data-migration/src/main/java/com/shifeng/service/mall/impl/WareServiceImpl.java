package com.shifeng.service.mall.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.service.mall.WareService;
@Service("wareService")
public class WareServiceImpl implements WareService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 更新商品主图
	 * @param pid
	 * @param colorName
	 * @param imgPath
	 */
	public void updateMainPic(String pid,String colorName,String imgPath) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("pid", pid);
		map.put("colorName", colorName);
		map.put("imgPath", imgPath);
		try {
			dao.update("productMapper.updateMainPic", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
