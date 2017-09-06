package com.shifeng.provide.sysuser.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.user.SysUser;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.MD5Util;

@Service("sysUserDao")
public class SysUserDao {

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    protected Logger logger = Logger.getLogger(this.getClass());

    /**
     * 根据用户id修改用户状态
     *
     * @param userId       用户id
     * @param state        状态(1正常 2冻结)
     * @param operatorName 修改人名称
     * @param req（响应信息）
     * @throws Exception
     */
    public void updateUserState(int userId, int state, String operatorName, ReqResponse<String> req) throws Exception {
        if (state == 1 || state == 2) {
            int rows = (int) dao.update("SysUserMapper.updateUserState", new String[]{userId + "", state + "", operatorName});
            if (rows == 0) {
                req.setCode(1);
                req.setMsg("修改用户状态失败");
            } else {
                req.setCode(0);
                req.setMsg("修改用户状态成功");
            }
        } else {
            req.setCode(1);
            req.setMsg("用户状态错误");
        }
    }

    /**
     * 根据用户账号（账户名/手机号/邮箱）验证密码
     *
     * @param account   账号
     * @param password  密码
     * @param req（响应信息）
     * @throws Exception
     */
    public void checkPassword(String account, String password, ReqResponse<SysUser> req) throws Exception {
        //MD5加密密码
        password = MD5Util.hex(password);
        SysUser user = (SysUser) dao.findForObject("SysUserMapper.userLogin", new String[]{account, password});
        if (StringUtils.isEmpty(user)) {
            req.setCode(1);
            req.setMsg("密码验证失败");
        } else {
            req.setCode(0);
            req.setMsg("密码验证成功");
            req.setData(user);
        }
    }

    /**
     * 检测账号（账户名/手机号/邮箱）是否存在
     *
     * @param account   账号
     * @param req（响应信息）
     * @return
     */
    public void checkAccountExists(String account, ReqResponse<String> req) throws Exception {
        SysUser user = (SysUser) dao.findForObject("SysUserMapper.checkAccount", account);
        if (StringUtils.isEmpty(user)) {
            req.setCode(0);
            req.setMsg("账号可用");
        } else {
            req.setCode(1);
            req.setMsg("账号已存在");
        }
    }

    /**
     * 根据用户账号（账户名/手机号/邮箱）修改密码
     *
     * @param account      账号
     * @param password     密码
     * @param newPassword  新密码
     * @param operatorName 修改人名称
     * @param req（响应信息）
     * @throws Exception
     */
    public void updatePassword(String account, String password, String newPassword, String operatorName, ReqResponse<String> req) throws Exception {
        //MD5加密密码
        password = MD5Util.hex(password);
        newPassword = MD5Util.hex(newPassword);
        //验证账号密码是否匹配
        SysUser user = (SysUser) dao.findForObject("SysUserMapper.userLogin", new String[]{account, password});
        if (StringUtils.isEmpty(user)) {
            req.setCode(1);
            req.setMsg("原密码不正确");
        } else {
            int rows = (int) dao.update("SysUserMapper.updatePassword", new String[]{account, newPassword, operatorName, password});
            if (rows == 0) {
                req.setCode(1);
                req.setMsg("密码修改失败");
            } else {
                req.setCode(0);
                req.setMsg("密码修改成功");
            }
        }
    }


    /**
     * 添加用户
     *
     * @param sysUser   用户实体
     * @param req（响应信息）
     */
    public void addUser(SysUser sysUser, ReqResponse<Integer> req) throws Exception {
        //MD5加密密码
        sysUser.setPassword(MD5Util.hex(sysUser.getPassword()));
        SysUser user = (SysUser) dao.findForObject("SysUserMapper.checkAccount", sysUser.getAccount());
        if (StringUtils.isEmpty(user)) {//验证用户名唯一
            user = (SysUser) dao.findForObject("SysUserMapper.checkAccount", sysUser.getPhone());
            if (StringUtils.isEmpty(user)) {//验证手机号唯一
                /*user = (SysUser)dao.findForObject("SysUserMapper.checkAccount", sysUser.getEmail());
				if(StringUtils.isEmpty(user)){//验证邮箱唯一
*/
                dao.save("SysUserMapper.addUser", sysUser);
                if (sysUser.getId() > 0) {
                	//添加到商城用户
                	dao.save("mallusersMapper.addMallUser", new String[]{sysUser.getId()+"",sysUser.getName()});
                    req.setCode(0);
                    req.setData(sysUser.getId());
                    req.setMsg("添加用户成功");
                } else {
                    req.setCode(1);
                    req.setMsg("添加用户失败");
                }
				/*}else{
					 req.setCode(1);
					 req.setMsg("邮箱已被使用");
				}*/
            } else {
                req.setCode(1);
                req.setMsg("手机号已被使用");
            }
        } else {
            req.setCode(1);
            req.setMsg("用户名已被使用");
        }

    }

    public void updatePasswordByAccount(String account, String password, String operatorName, ReqResponse<String> req) throws Exception {
        //MD5加密密码
        password = MD5Util.hex(password);
        int rows = (int) dao.update("SysUserMapper.updatePasswordByAccount", new String[]{account, password, operatorName});
        if (rows == 0) {
            req.setCode(1);
            req.setMsg("密码修改失败");
        } else {
            req.setCode(0);
            req.setMsg("密码修改成功");
        }
    }

	/**
	 * 根据用户id修改用户头像
	 * @param user_id 用户id
	 * @param headimgurl 头像URL地址
	 * @return
	 * @throws Exception 
	 */
	public void updateHeadImg(String user_id, String headimgurl, ReqResponse<String> req) throws Exception {

        int rows = (int) dao.update("SysUserMapper.updateHeadImg", new String[]{user_id, headimgurl});
        if (rows == 0) {
            req.setCode(1);
            req.setMsg("头像修改失败");
        } else {
            req.setCode(0);
            req.setMsg("头像修改成功");
        }
		
	}

	/**
	 * 根据用户id修改用户基本信息（该接口仅支持修改昵称、性别、生日登基本用户信息，不支持修改用户密码 、头像操作）
	 * @param sysUser  用户实体
	 * @return
	 * @throws Exception 
	 */
	public void updateUserInfo(SysUser sysUser, ReqResponse<String> req) throws Exception {

        int rows = (int) dao.update("SysUserMapper.updateUserInfo", sysUser);
        if (rows == 0) {
            req.setCode(1);
            req.setMsg("基本信息修改失败");
        } else {
            req.setCode(0);
            req.setMsg("基本信息修改成功");
            //同步修改昵称
            if(org.apache.commons.lang.StringUtils.isNotBlank(sysUser.getName())){
            	dao.update("mallusersMapper.updateName", new String[]{sysUser.getId()+"",sysUser.getName()});
            }
        }
		
	}

	/**
	 * 根据用户手机号修改密码
	 * @param phone  手机号
	 * @param password  密码
	 * @return
	 * @throws Exception 
	 */
	public void updatePasswordByPhone(String phone, String password, ReqResponse<String> req) throws Exception {
		 //MD5加密密码
        password = MD5Util.hex(password);
        int rows = (int) dao.update("SysUserMapper.updatePasswordByPhone", new String[]{phone, password});
        if (rows == 0) {
            req.setCode(1);
            req.setMsg("密码修改失败");
        } else {
            req.setCode(0);
            req.setMsg("密码修改成功");
        }
		
	}

	/**
	 * 用户绑定手机号
	 * @param user_id  用户ID
	 * @param phone  手机号
	 * @return true 修改成功  false 修改失败
	 * @throws Exception 
	 */
	public void updateBindPhone(String user_id, String phone, ReqResponse<String> req) throws Exception {
		SysUser user = (SysUser) dao.findForObject("SysUserMapper.checkAccount", phone);
        if (StringUtils.isEmpty(user)) {
        	Map<String,String> map = new HashMap<String,String>();
   		 	map.put("user_id", user_id);
   		 	map.put("phone", phone);
   		 	int rows = (int) dao.update("SysUserMapper.updateBindPhone", map);
   	        if (rows == 0) {
   	            req.setCode(1);
   	            req.setMsg("绑定手机号失败");
   	        } else {
   	            req.setCode(0);
   	            req.setMsg("绑定手机号成功");
   	        }
        } else {
            req.setCode(1);
            req.setMsg("该手机号已被其他用户使用");
        }

		
	}
	
	/**
	 * 用户修改手机号
	 * @param phone 手机号
	 * @param newPhone 新手机号
	 * @param req
	 * @throws Exception
	 */
	public void updatePhone(String phone,String newPhone,ReqResponse<String> req) throws Exception {
		SysUser user = (SysUser) dao.findForObject("SysUserMapper.checkAccount", newPhone);
        if(StringUtils.isEmpty(user)) {
        	 int rows = (int) dao.update("SysUserMapper.updatePhone", new String[]{phone, newPhone});
             if (rows == 0) {
                 req.setCode(1);
                 req.setMsg("手机号修改失败");
             } else {
                 req.setCode(0);
                 req.setMsg("手机号修改成功");
             }
        } else {
            req.setCode(1);
            req.setMsg("该手机号已被其他用户使用");
        }
       
	}
	
	
}
