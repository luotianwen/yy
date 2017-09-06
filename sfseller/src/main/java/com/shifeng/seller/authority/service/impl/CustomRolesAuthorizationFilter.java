package com.shifeng.seller.authority.service.impl;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * 项目名：compass-data
 * 类描述：自定义多角色对应同一URL过滤器，用来判断当前用户是否是roleOrFilter["xx,xx"]中的某个角色
 */
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {
		Subject subject = getSubject(req, resp);
		String[] rolesArray = (String[]) mappedValue;

		if (rolesArray == null || rolesArray.length == 0) { //没有角色限制，有权限访问
			return true;
		}
		for (int i = 0; i < rolesArray.length; i++) {
			if (subject.hasRole(rolesArray[i])) { //若当前用户是rolesArray中的任何一个，则有权限访问
				return true;
			}
		}

		return false;
	}

}
