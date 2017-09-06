package com.shifeng.seller.authority.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.shifeng.seller.dto.shiro.ShiroDTO;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;

/**
 * 项目名：compass-data
 * 类描述：继承自抽象实现类，利用Spring注入该父类的原始系统资源节点，此类加载第三方资源
 */
public class LoadingDBChainDefinitions extends AbstractFilterChainDefinitionsService {
	
	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 方法描述：加载数据库资源配置
	 * 实现接口：@see AbstractFilterChainDefinitionsService#initOtherPermission()
	 * @return
	 */
	@Override
	public Map<String, String> initOtherPermission() {
		Map<String,String> map = new HashMap<String,String>();

		return map;
	}
}
