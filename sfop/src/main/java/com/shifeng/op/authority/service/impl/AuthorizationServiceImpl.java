package com.shifeng.op.authority.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.op.entity.authority.Authorization;
import com.shifeng.op.authority.service.AuthorizationService;
import com.shifeng.op.authority.service.FilterChainDefinitionsService;
import com.shifeng.util.Const;


@Service("authorizationServiceImpl")
public class AuthorizationServiceImpl implements AuthorizationService{
	
	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	// shiro缓存
	@Resource(name="filterChainDefinitionsService")
	private FilterChainDefinitionsService abstractFilterChainDefinitionsService;
		
	/**
	 * 方法描述：绑定角色资源
	 * 实现接口：@see com.op.service.menu.MenusService#linkRoleMenus(java.util.Map)
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void savelinkRoleMenus(String rId,String mIds,Map<String, Object> map) throws Exception {
		// 删除历史信息
		map.put(Const.ERROR_INFO, "删除历史信息异常，请稍后重试!!!");
		dao.delete("authorizationMapper.deleteAuthorizationByRid", rId);
		// 保存新的数据
		if(!StringUtils.isEmpty(mIds)){
			List<Authorization> list = new ArrayList<Authorization>();
			String[] ids = mIds.split(",");
			int idsLength = ids.length;
			for(int i=0;i<idsLength;i++){
				Authorization auth = new Authorization();
				auth.setrId(rId);
				auth.setmId(ids[i]);
				list.add(auth);
			}
			
			map.put(Const.ERROR_INFO, "保存数据异常，请稍后重试!!!");
			dao.save("authorizationMapper.saveAuthorizations", list);
			
			map.put(Const.ERROR_INFO, "刷新权限异常，请稍后重试!!!");
			// 保存权限成功刷新缓存
			abstractFilterChainDefinitionsService.updatePermission();
		}
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}
}
