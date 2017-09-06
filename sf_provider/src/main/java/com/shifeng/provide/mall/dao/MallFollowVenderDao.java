package com.shifeng.provide.mall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.MallFollowVenderDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/** 
 * 关注的店铺(mall_followVender) DAO
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
@Service("mallfollowVenderDao")
public class MallFollowVenderDao{

	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 根据用户ID获取用户关注店铺列表
	 * @param user_id
	 * @param currentPage
	 * @param req
	 * @throws Exception 
	 */
	public void getFollowVenderList(String user_id, int currentPage, ReqResponse<Page> req) throws Exception {
		Page<String> page = new Page<String>();
		page.setPageSize(20);
		page.setT(user_id);
		page.setCurrentPage(currentPage);
		List<MallFollowVenderDTO> followVenderList = (List<MallFollowVenderDTO>)dao.findForList("mallfollowVenderMapper.getFollowVenderListPage", page);
		page.setResultData(followVenderList);
		req.setData(page);
		req.setCode(0);
		
	}

	/**
	 * 添加关注店铺
	 * @param user_id
	 * @param shop_id 店铺shop_id
	 * @return
	 * @throws Exception 
	 */
	public void addFollowVender(String user_id, int shop_id, ReqResponse<String> req) throws Exception {
		int row = (int)dao.findForObject("mallfollowVenderMapper.isFollowVender", new String[]{user_id,shop_id+""});
		if(row == 0){
		  dao.save("mallfollowVenderMapper.addFollowVender", new String[]{user_id,shop_id+""});
		}else{
			req.setCode(1);
			req.setData("已关注该店铺");
		}
	}

	/**
	 * 是否已关注店铺
	 * @param user_id
	 * @param shop_id 店铺shop_id
	 * @return
	 * @throws Exception 
	 */
	public void isFollowVender(String user_id, int shop_id, ReqResponse<Boolean> req) throws Exception {

		int row = (int)dao.findForObject("mallfollowVenderMapper.isFollowVender", new String[]{user_id,shop_id+""});
		if(row > 0){
			req.setData(true);
		}else{
			req.setData(false);
		}
		req.setCode(0);
	}

	/**
	 * 根据用户ID删除用户关注的店铺
	 * @param user_id
	 * @param shopId  关注shopId，多个英文逗号隔开
	 * @return
	 * @throws Exception 
	 */
	public void deleteFollowVender(String user_id, String shopId, ReqResponse<String> req) throws Exception {
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("user_id", user_id);
		 map.put("shopIds", shopId.split(","));
		 dao.delete("mallfollowVenderMapper.deleteFollowVender", map);
		
	}
	
}
