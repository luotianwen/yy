package com.shifeng.op.shop.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.Shopinfo;
import com.shifeng.entity.shop.ShopinfoLog;
import com.shifeng.entity.user.SysUser;
import com.shifeng.op.dto.shop.ShopDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.shop.service.ShopinfoLogService;
import com.shifeng.op.shop.service.ShopinfoService;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.Const;
import com.shifeng.util.Tools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * 店铺表(s_shopinfo)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:22 
 */  
@Service("shopinfoServiceImpl")
public class ShopinfoServiceImpl implements ShopinfoService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	@Resource(name="shopinfologServiceImpl")
	private ShopinfoLogService shopinfologServiceImpl;
	@Resource(name="sysUserService")
	private SysUserService sysUserService;

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ShopDTO> findAllShopinfo(Page page) throws Exception{
		return (List<ShopDTO>) dao.findForList("shopinfoMapper.findAllShopinfoPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Shopinfo findShopinfoById(String id) throws Exception{
		return (Shopinfo) dao.findForObject("shopinfoMapper.findShopinfoById", id);
	}
	
	/**
	 * 新增
	 * @param shopinfo
	 * @throws Exception
	 */
	public void saveShopinfo(Shopinfo shopinfo) throws Exception{
		dao.save("shopinfoMapper.saveShopinfo", shopinfo);
	}
	
	/**
	 * 修改
	 * @param shopinfo
	 * @throws Exception
	 */
	public Map<String,Object> updateShopinfo(Shopinfo shopinfo,Map<String,Object> map) throws Exception{
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
		
		if(shopinfo.getSstate()==1) {
			Shopinfo shopinfo2 = this.findShopinfoById(shopinfo.getS_merchants_id()+"");
			ReqResponse<String> respons=sysUserService.checkAccountExists(shopinfo2.getAccount());
			if(respons.getCode()==0) {
				SysUser sysUser = new SysUser();
				sysUser.setAccount(shopinfo2.getAccount());
				sysUser.setName(shopinfo2.getAccount());
				sysUser.setPassword("123456");
				ReqResponse<Integer> id=sysUserService.addUser(sysUser);
				if(id.getCode()==0) {
					sysUser.setId(id.getData());
					sysUser.setIntegral(shopinfo.getS_merchants_id());
					dao.update("shopinfoMapper.insertSellerUser", sysUser);
				}else{
					map.put(Const.ERROR_INFO, id.getMsg());
					return map;
				}
			}else{
				map.put(Const.ERROR_INFO, respons.getMsg());
				return map;
			}
		}

		dao.update("shopinfoMapper.updateShopinfo", shopinfo);
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		
		return map;
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteShopinfo(String id) throws Exception{
		dao.delete("shopinfoMapper.deleteShopinfo", id);
	}

	public List<Shopinfo> findAllShopinfoByState() throws Exception {
		return (List<Shopinfo>) dao.findForList("shopinfoMapper.findAllShopinfoByState");
	}

	public void passShopinfo(int id, String note, Users user) throws Exception {
		//日志
		ShopinfoLog shopinfoLog=new ShopinfoLog();
		shopinfoLog.setNote(note);
		shopinfoLog.setUpdatename(user.getuName());
		shopinfoLog.setS_merchants_id(id);
		shopinfoLog.setState(1);
		shopinfoLog.setType(2);
		shopinfologServiceImpl.saveShopinfoLog(shopinfoLog);
		//品牌审核
		dao.update("brandMapper.updateBrandState", id);
        //状态
		Map map=new HashMap();
		map.put("s_merchants_id",id);
		map.put("fstate","1");
		map.put("updatename",user.getuName());
		map.put("next", 4);
		
		dao.update("shopinfoMapper.updateShopinfoState", map);
		dao.update("merchantssettledMapper.updateNext", map);
	}

	public void backShopinfo(int id, String note, Users user) throws Exception {
		ShopinfoLog shopinfoLog=new ShopinfoLog();
		shopinfoLog.setNote(note);
		shopinfoLog.setUpdatename(user.getuName());
		shopinfoLog.setS_merchants_id(id);
		shopinfoLog.setState(2);
		shopinfoLog.setType(2);
		shopinfologServiceImpl.saveShopinfoLog(shopinfoLog);
		Map map=new HashMap();
		map.put("s_merchants_id",id);
		map.put("fstate","2");
		map.put("updatename",user.getuName());
		dao.update("shopinfoMapper.updateShopinfoState", map);
	}

	@Override
	public List<ShopDTO> findAllPassShopinfo(Page page) throws Exception {
		return (List<ShopDTO>) dao.findForList("shopinfoMapper.findAllShopinfoByStatePage", page);
	}

	@Override
	public int updateAccount(String id, Users user) throws Exception {
		Shopinfo shopinfo=this.findShopinfoById(id) ;
		if(shopinfo!=null) {
			int pwd = 123456;
			sysUserService.updatePasswordByAccount(shopinfo.getAccount(), pwd + "", user.getuName());
			return pwd;
		}
		return 0;
	}

}
