package com.shifeng.op.authority.service.impl;

import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;


import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.shifeng.op.authority.service.FilterChainDefinitionsService;

/**
 * 项目名：compass-data
 * 类描述：用作动态更新权限资源配置
 */
public abstract class AbstractFilterChainDefinitionsService implements FilterChainDefinitionsService {

	// 系统默认节点，利用spring单独进行配置注入，用作更新保存原始资源对象
	private String definitions = "";
	// shiro权限管理bean
	@Autowired
	private ShiroFilterFactoryBean shiroFilterFactoryBean;

	/**
	 * 方法描述：加载系统初始资源和第三方资源库
	 * 实现接口：@see FilterChainDefinitionsService#intiPermission()
	 */
	@PostConstruct
	public void intiPermission() {
		shiroFilterFactoryBean.setFilterChainDefinitionMap(obtainPermission());
	}

	/**
	 * 方法描述：更新权限
	 * 实现接口：@see FilterChainDefinitionsService#updatePermission()
	 * @throws Exception 
	 */
	public void updatePermission() throws Exception {

		synchronized (shiroFilterFactoryBean) {

			AbstractShiroFilter shiroFilter = null;

			shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();

			// 获取过滤管理器
			PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
			DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

			// 清空初始权限配置
			manager.getFilterChains().clear();
			shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();

			// 重新构建生成(加载原始资源和第三方资源)
			shiroFilterFactoryBean.setFilterChainDefinitionMap(obtainPermission());
			
			Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
			for (Entry<String, String> entry : chains.entrySet()) {
				String url = entry.getKey();
				String chainDefinition = entry.getValue().trim().replace(" ", "");
				manager.createChain(url, chainDefinition);
			}

		}
	}

	/**
	 * 方法描述：读取配置资源
	 * 返回类型：Section
	 * @return
	 */
	private Section obtainPermission() {
		Ini ini = new Ini();
		ini.load(definitions); // 加载资源文件节点串
		Section section = ini.getSection("urls"); // 使用默认节点
		if (CollectionUtils.isEmpty(section)) {
			section = ini.getSection(Ini.DEFAULT_SECTION_NAME); // 如不存在默认节点切割,则使用空字符转换
		}
		
		Map<String, String> permissionMap = initOtherPermission();// 获取第三方资源配置
		if (permissionMap != null && !permissionMap.isEmpty()) {
			section.putAll(permissionMap);
		}
		return section;
	}

	/**
	 * 方法描述：子类重新该方法读取数据库资源配置
	 * 实现接口：@see FilterChainDefinitionsService#initOtherPermission()
	 * @return
	 */
	public abstract Map<String, String> initOtherPermission();  
	
	public String getDefinitions() {
		return definitions;
	}

	public void setDefinitions(String definitions) {
		this.definitions = definitions;
	}
	
}
