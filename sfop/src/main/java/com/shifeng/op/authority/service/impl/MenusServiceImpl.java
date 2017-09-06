package com.shifeng.op.authority.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.op.entity.menu.Menus;
import com.shifeng.op.entity.menu.ZTree;
import com.shifeng.plugin.page.Page;
import com.shifeng.op.authority.service.MenusService;
import com.shifeng.util.Const;



@Service("menusServiceImpl")
public class MenusServiceImpl implements MenusService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 方法描述：查询主菜单列表
	 * 实现接口：@see com.op.service.menu.MenusService#getMenuListById(java.lang.String)
	 * @param mParentId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Menus> getMenuList(Page page) throws Exception {
		return (List<Menus>) dao.findForList("menusMapper.getMenuList",page);
	}

	/**
	 * 方法描述：查询子菜单
	 * 实现接口：@see com.op.service.menu.MenusService#getMenuListById(java.lang.String)
	 * @param mParentId
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<Menus> getMenuListById(String mParentId) throws Exception {
		return (List<Menus>) dao.findForList("menusMapper.getMenuListById", mParentId);
	}

	/**
	 * 方法描述：添加菜单功能，查询顶级菜单
	 * 实现接口：@see com.op.service.menu.MenusService#goMenuAddGetParentList()
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Menus> goMenuAddGetParentList() throws Exception {
		
		return (List<Menus>) dao.findForList("menusMapper.goMenuAddGetParentList", null);
	}

	/**
	 * 方法描述：保存菜单
	 * 实现接口：@see com.op.service.menu.MenusService#saveMenu(com.op.entity.menu.Menus)
	 * @param menu
	 * @return
	 */
	@Override
	public void saveMenu(String uId,Menus menu,Map<String,Object> map)  throws Exception{
		// 保存
		//menu.setmId(UuidUti.get32UUID());
		menu.setmLastUpTime(new Date());
		menu.setmLastUpUser(uId);
		dao.save("menusMapper.saveMenu", menu);
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	/**
	 * 方法描述：删除
	 * 实现接口：@see com.op.service.menu.MenusService#deleteMenu(java.util.Map)
	 * @description
	 * 	check：判断该菜单是否关联了角色
	 *  delete：删除菜单表、删除对应的角色
	 * @param map
	 * @return
	 */
	@Override
	public void deleteMenu(String mId,String tp,Map<String, Object> map)  throws Exception{
		// 判断该菜单是否绑定角色
		int roleNum = (int) dao.findForObject("authorizationMapper.checkMenusForRoleByMid", mId);
		if(roleNum > 0){
			map.put(Const.ERROR_INFO, "该菜单已经关联了角色，请前往[组织管理菜单]解除角色的菜单关联，再进行删除菜单操作!");
			return;
		}
		if(tp.equals("main")){
			dao.delete("menusMapper.deleteMenuMain", mId);
		}else{
			dao.delete("menusMapper.deleteMenuChildren", mId);
		}
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	/**
	 * 方法描述：跳转菜单编辑页面
	 * 实现接口：@see com.op.service.menu.MenusService#getMenuBymId(java.lang.String)
	 * @param mId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Menus getMenuBymId(String mId) throws Exception {
		// TODO Auto-generated method stub
		return (Menus) dao.findForObject("menusMapper.getMenuBymId", mId);
	}

	/**
	 * 方法描述：更改菜单
	 * 实现接口：@see com.op.service.menu.MenusService#updateMenu(java.util.Map)
	 * @param map
	 * @return
	 */
	@Override
	public void updateMenu(String uId,Menus menu,Map<String, Object> map) throws Exception{
		// 保存
		menu.setmLastUpTime(new Date());
		menu.setmLastUpUser(uId);
		dao.update("menusMapper.updateMenu", menu);
		
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}

	/**
	 * 方法描述：封装菜单节点
	 * 实现接口：@see com.op.service.menu.MenusService#getRoleMenus(java.lang.String)
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ZTree> getRoleMenus(String rId) throws Exception {
		// 查询所有菜单
		List<Menus> menus = (List<Menus>) dao.findForList("menusMapper.findAllMenus", null);
		// 查询该角色对应的菜单
		List<String> mIds = (List<String>) dao.findForList("authorizationMapper.findMenusByRId", rId);
		// 树形菜单对象
		List<ZTree> ztrees = new ArrayList<ZTree>();
		
		// 匹配资源，封装树形对象
		int menusLength = menus.size();
		for(int i=0;i<menusLength;i++){
			ZTree ztree = new ZTree();
			Menus menu = menus.get(i);
			ztree.setId(menu.getmId());
			ztree.setpId(menu.getmParentId());
			ztree.setName(menu.getmName());
			
			for(int j=0;j<mIds.size();j++){// 匹配是否已经关联
				String mId = mIds.get(j);
				if(menu.getmId().equals(mId)){
					ztree.setChecked(true);
					mIds.remove(j);// 匹配则移除，优化匹配效率
					break;
				}
			}
			
			ztrees.add(ztree);
		}
		return ztrees;
	}

	/**
	 * 方法描述：查询该角色拥有菜单集合
	 * 实现接口：@see com.op.service.menu.MenusService#getUserMenuList(java.lang.String)
	 * @param rId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Menus> getUserMenuList(String rId) throws Exception {
		List<Menus> list = (List<Menus>) dao.findForList("menusMapper.findLoginUserMenus", rId);
		return list;
	}

	
}
