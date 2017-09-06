package com.shifeng.provide.distributor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.fx.FxUserDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.distributor.dao.DistributorDao;
import com.shifeng.provide.distributor.service.DistributorService;
import com.shifeng.provide.sysuser.dao.SysUserDao;
import com.shifeng.response.ReqResponse;

/**
 * 分销用户接口服务
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class DistributorServiceImpl implements DistributorService{

	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "sysUserDao")
	private SysUserDao sysUserDao;

	@Resource(name = "distributorDao")
	private DistributorDao distributorDao;
	
	
	/**
	 * 检测分销用户手机号是否存在
	 * @param phone  手机号
	 * @return
	 */
	public ReqResponse<String> isPhoneExists(String phone) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.checkAccountExists(phone, req);
			return req;
		} catch (Exception e) {
			logger.error("【检测分销用户手机号是否存在】出错：", e);
			req.setCode(1);
			req.setMsg("【检测分销用户手机号是否存在】异常");
			return req;
		}
	}
	

	/**
	 * 激活分销用户账号，即设置账户密码
	 * @param phone  	手机号
	 * @param password  密码
	 * @return
	 */
	public ReqResponse<String> activation(String phone,String password) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.updatePasswordByPhone(phone, password,req);
		} catch (Exception e) {
			logger.error("【根据用户账号（账户名）修改密码】出错：", e);
			req.setCode(1);
			req.setMsg("激活分销用户账号异常");
		}
		try {
			distributorDao.updateActivationGiveSilverCoin(phone);
		} catch (Exception e) {
			logger.error("【用户激活给邀请者赠送银币】出错：", e);
		}
		return req;
	}

	
	/**
	 * 添加我的分销商
	 * @param user_id	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @return
	 */
	public ReqResponse<String> addDistributor(String user_id,String name,String phone,String remark) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			distributorDao.addDistributor(user_id,name,phone,remark,req);
			return req;
		} catch (Exception e) {
			logger.error("【添加我的分销商】出错：", e);
			req.setCode(1);
			req.setMsg("【添加我的分销商】异常");
			return req;
		}
	}

	
	/**
	 * 删除我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 */
	public ReqResponse<String> deleteDistributor(String user_id,String recommended_userid) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			distributorDao.deleteDistributor(user_id,recommended_userid,req);
			return req;
		} catch (Exception e) {
			logger.error("【删除我的分销商】出错：", e);
			req.setCode(1);
			req.setMsg("【删除我的分销商】异常");
			return req;
		}
	}

	
	/**
	 * 修改我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @return
	 */
	public ReqResponse<String> updateDistributor(String user_id,String recommended_userid,String name,String remark) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			distributorDao.updateDistributor(user_id,recommended_userid,name,remark,req);
			return req;
		} catch (Exception e) {
			logger.error("【删除我的分销商】出错：", e);
			req.setCode(1);
			req.setMsg("【删除我的分销商】异常");
			return req;
		}
	}

	
	/**
	 * 获取我的分销商列表
	 * @param page	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page> getDistributorList(String user_id,String name,String phone,int currentPage){
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			distributorDao.getDistributorList(user_id,name,phone,currentPage,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的分销商列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的分销商列表】异常");
			return req;
		}
	}

	
	/**
	 * 获取我的分销商详情
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 */
	public ReqResponse<FxUserDTO> getDistributorById(String user_id,String recommended_userid) {
		ReqResponse<FxUserDTO> req = new ReqResponse<FxUserDTO>();
		try {
			distributorDao.getDistributorById(user_id,recommended_userid,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的分销商详情】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的分销商详情】异常");
			return req;
		}
	}
	

}
