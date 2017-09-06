package com.shifeng.provide.distributor.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.fx.FxUserDTO;
import com.shifeng.entity.fx.FxUser;
import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.entity.mall.MallUsersSilverLog;
import com.shifeng.entity.user.SysUser;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.async.SmsService;
import com.shifeng.response.ReqResponse;
import com.shifeng.util.DateUtil;

@Service("distributorDao")
public class DistributorDao {

    @Resource(name = "baseDaoImpl")
    private BaseDao dao;

    @Resource(name = "smsService")
    private SmsService smsService;

    private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 添加我的分销商
	 * @param user_id	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @param req
	 * @return
	 * @throws Exception 
	 */
	public void addDistributor(String user_id, String name, String phone, String remark, ReqResponse<String> req) throws Exception {
		 
		SysUser sysUser = new SysUser();
		sysUser.setPhone(phone);
		sysUser.setName(phone.substring(0, 3)+"*****"+phone.substring(8));
		
		SysUser user = (SysUser) dao.findForObject("SysUserMapper.checkAccount", sysUser.getPhone());
        if (user == null) {//验证手机号唯一
        	dao.save("SysUserMapper.addUser", sysUser);
            if (sysUser.getId() > 0) {
            	FxUser fxUser = new FxUser();
            	fxUser.setRecommend_userid(user_id);
            	fxUser.setRecommended_userid(sysUser.getId()+"");  
            	fxUser.setName(name);
            	fxUser.setRemark(""+remark);
            	//保存我的分销商
            	dao.save("fxuserMapper.saveFxUser", fxUser);
            	//设置分销商为商城用户
            	dao.save("mallusersMapper.addMallUser", new String[]{sysUser.getId()+"",sysUser.getName()});
                req.setCode(0);
                req.setData(sysUser.getId()+"");
                req.setMsg("添加我的分销商成功");
                smsService.sendSMS(phone, "{\"money\":\""+100+"\",\"name\":\""+phone+"\",\"year\":\""+DateUtil.sdfTime.format(DateUtil.beforeOrAfterNumberDay(new Date(), 60))+"\"}", "SMS_63275427");
            } else {
                req.setCode(1);
                req.setMsg("添加我的分销商失败");
            }
        } else {
            req.setCode(1);
            req.setMsg("手机号已被使用");
        }
		
	}

	/**
	 * 删除我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 * @throws Exception 
	 */
	public void deleteDistributor(String user_id, String recommended_userid, ReqResponse<String> req) throws Exception {

		int rows = (int) dao.update("fxuserMapper.deleteFxUser", new String[]{user_id,recommended_userid});
         if (rows == 0) {
             req.setCode(1);
             req.setMsg("删除我的分销商失败");
         } else {
             req.setCode(0);
             req.setMsg("删除我的分销商成功");
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
	 * @throws Exception 
	 */
	public void updateDistributor(String user_id, String recommended_userid, String name, String remark,
			ReqResponse<String> req) throws Exception {

    	FxUser fxUser = new FxUser();
    	fxUser.setRecommend_userid(user_id);
    	fxUser.setRecommended_userid(recommended_userid);
    	fxUser.setName(name);
    	fxUser.setRemark(remark);
    	
    	int rows = (int) dao.update("fxuserMapper.updateFxUser", fxUser);
        if (rows == 0) {
            req.setCode(1);
            req.setMsg("修改我的分销商失败");
        } else {
            req.setCode(0);
            req.setMsg("修改我的分销商成功");
        }
    	
		
	}
 
	
	/**
	 * 获取我的分销商列表
	 * @param page	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param currentPage 当前页
	 * @return
	 * @throws Exception 
	 */
	public void getDistributorList(String user_id, String name, String phone, int currentPage,
			ReqResponse<Page> req) throws Exception {
		FxUserDTO fxUser = new FxUserDTO();
    	fxUser.setRecommend_userid(user_id);
    	fxUser.setName(name);
    	fxUser.setPhone(phone);
		Page page = new Page();
		page.setT(fxUser);
		page.setCurrentPage(currentPage);
		List<FxUserDTO> fxUsers = (List<FxUserDTO>)dao.findForList("fxuserMapper.getDistributorList", page);
		page.setResultData(fxUsers);
		req.setData(page);
		req.setCode(0);
	}

	/**
	 * 获取我的分销商详情
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 * @throws Exception 
	 */
	public void getDistributorById(String user_id, String recommended_userid, ReqResponse<FxUserDTO> req) throws Exception {

		FxUserDTO fxUser = (FxUserDTO)dao.findForObject("fxuserMapper.findFxRecommendedUserById", new String[]{user_id,recommended_userid});
		req.setData(fxUser);
		req.setCode(0);
	}
	
	/**
	 * 用户激活给邀请者赠送银币
	 * @param phone 激活用户手机号
	 * @throws Exception 
	 */
	public void updateActivationGiveSilverCoin(String phone) throws Exception{
		//根据被推荐用户手机号获取推荐用户ID
		Integer recommend_userid = (Integer)dao.findForObject("fxuserMapper.findRecommendUserId", phone);
        if (null != recommend_userid && recommend_userid > 0) {
        	//获取赠送银币数量
           Integer number = (Integer)dao.findForObject("syssliverMapper.getActivationGiveSilverCoin");
           if(null != number && number > 0){
        	    //获取我的银币余额
       			MallUsersSilver mallUsersSilver = (MallUsersSilver)dao.findForObject("malluserssilverMapper.findMallUsersSilverByUserId", recommend_userid);
				//日志
       			MallUsersSilverLog log = new MallUsersSilverLog();
				log.setLastsilver(mallUsersSilver.getLastsilver());
				log.setSilver(number);
				//1收入2兑换
				log.setType(1);
				log.setUid(mallUsersSilver.getUid());
				//保存兑换日志
				dao.save("malluserssilverlogMapper.saveLog", log);
				 //给邀请者赠送银币
				dao.update("malluserssilverMapper.updateSilverAdd", new String[]{mallUsersSilver.getUid(),number+""});
        	   
           }
        }
		
	}
    
    
    
    
    
    

}
