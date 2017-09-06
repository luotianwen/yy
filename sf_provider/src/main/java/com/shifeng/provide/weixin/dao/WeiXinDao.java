package com.shifeng.provide.weixin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.common.base.Objects;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.user.JointLogin;
import com.shifeng.entity.user.SysUser;
import com.shifeng.response.ReqResponse;

@Service("weiXinDao")
public class WeiXinDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 更新微信用户登录信息
	 * @param jointLogin
	 * @param user
	 * @throws Exception 
	 */
	public void updateLoginInfo(JointLogin jointLogin,SysUser user) throws Exception{
		//查询是否有过登录记录
		List<JointLogin> jlList = (List<JointLogin>)dao.findForList("jointLoginMapper.findJointLoginById", jointLogin);
		if(StringUtils.isEmpty(jlList) || jlList.size() == 0){//没有登录过
			dao.save("SysUserMapper.addJointUser", user);
			jointLogin.setUserId(user.getId()+"");
			dao.save("jointLoginMapper.saveJointLogin", jointLogin);
		}else{
			
			
			user.setId(Integer.valueOf(jlList.get(0).getUserId()));
			//判断是否有多个应用
			if(jlList.size() == 1){//单个更新
				dao.update("jointLoginMapper.updateJointLogin", jointLogin);
			}else{//多个保存或更新
				jointLogin.setUserId(jlList.get(0).getUserId());
				boolean isSave = true;
				for(JointLogin jl : jlList){
					if(Objects.equal(jl.getUnionid(), jointLogin.getUnionid())){//判断是否登录过
						isSave = false;
						break;
					}
				}
				if(isSave){
					dao.save("jointLoginMapper.saveJointLogin", jointLogin);
				}else{
					dao.update("jointLoginMapper.updateJointLogin", jointLogin);
				}
			}
			//同步第三方用户信息
			dao.update("SysUserMapper.updateJointUser", user);
			user = (SysUser)dao.findForObject("SysUserMapper.findUserById", user.getId()+"");
		}
	}
	
	
}
