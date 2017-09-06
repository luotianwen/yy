package com.shifeng.op.authority.service;

import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.shifeng.op.entity.menu.Menus;
import com.shifeng.op.entity.menu.ZTree;
import com.shifeng.plugin.page.Page;

@Service("menusService")
public interface MenusService {

	/**
	 * 方法描述：获取菜单集合
	 * 返回类型：List<Menus>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Menus> getMenuList(Page page) throws Exception;

	/**
	 * 方法描述：跳转菜单获取父菜单集合
	 * 返回类型：List<Menus>
	 * @return
	 * @throws Exception
	 */
	public List<Menus> goMenuAddGetParentList() throws Exception;

	/**
	 * 方法描述：根据ID获取菜单集合
	 * 返回类型：List<Menus>
	 * @param mParentId
	 * @return
	 * @throws Exception
	 */
	public List<Menus> getMenuListById(String mParentId) throws Exception;
	/**
	 * 方法描述：保存菜单
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void saveMenu(String uId,Menus menu,Map<String, Object> map) throws Exception;
	
	/**
	 * 方法描述：删除菜单
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void deleteMenu(String mId, String tp, Map<String, Object> map) throws Exception;
	
	/**
	 * 方法描述：根据菜单ID获取菜单
	 * 返回类型：Menus
	 * @param mId
	 * @return
	 * @throws Exception
	 */
	public Menus getMenuBymId(String mId)throws Exception;
	
	/**
	 * 方法描述：更新菜单
	 * 返回类型：Map<String,Object>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	void updateMenu(String uId,Menus menu,Map<String, Object> map) throws Exception;
	
	/**
	 * 方法描述：根据角色获取菜单集合
	 * 返回类型：List<ZTree>
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	public List<ZTree> getRoleMenus(String rId) throws Exception;
	
	/**
	 * 方法描述：获取用户对应的菜单集合
	 * 返回类型：List<Menus>
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	public List<Menus> getUserMenuList(String rId) throws Exception;


}
