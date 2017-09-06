package com.shifeng.provide.mall.dao;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.MallFollowWareDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * 关注的商品(mall_followWare) DAO
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
@Service("mallfollowWareDao")
public class MallFollowWareDao{

	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 根据用户ID获取用户关注商品列表
	 * @param user_id
	 * @param currentPage
	 * @param req
	 * @throws Exception 
	 */
	public void getFollowWareList(String user_id, int currentPage, ReqResponse<Page> req) throws Exception {
		Page<String> page = new Page<String>();
		page.setPageSize(20);
		page.setT(user_id);
		page.setCurrentPage(currentPage);
		List<MallFollowWareDTO> followWareList = (List<MallFollowWareDTO>)dao.findForList("mallfollowWareMapper.getFollowWareListPage", page);
		page.setResultData(followWareList);
		req.setData(page);
		req.setCode(0);
		
	}

	/**
	 * 添加关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 * @throws Exception 
	 */
	public void addFollowWare(String user_id, int sku, ReqResponse<String> req) throws Exception {
		int row = (int)dao.findForObject("mallfollowWareMapper.isFollowWare", new String[]{user_id,sku+""});
		if(row == 0){
		  dao.save("mallfollowWareMapper.addFollowWare", new String[]{user_id,sku+""});
		}else{
			req.setCode(1);
			req.setData("已关注该商品");
		}
	}
	/**
	 * 添加关注商品
	 * @param user_id
	 * @param skus 商品sku
	 * @return
	 * @throws Exception
	 */
	public void addFollowWare(String user_id, int[] skus, ReqResponse<String> req) throws Exception {
		if(skus == null){
			req.setCode(1);
			req.setMsg("商品sku不能为空");
		}else{
			for (int i = 0; i <skus.length ; i++) {
				int sku=skus[i];
				int row = (int)dao.findForObject("mallfollowWareMapper.isFollowWare", new String[]{user_id,sku+""});
				if(row == 0){
					dao.save("mallfollowWareMapper.addFollowWare", new String[]{user_id,sku+""});
				}
			}
		}

	}
	/**
	 * 是否已关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 * @throws Exception 
	 */
	public void isFollowWare(String user_id, int sku, ReqResponse<Boolean> req) throws Exception {

		int row = (int)dao.findForObject("mallfollowWareMapper.isFollowWare", new String[]{user_id,sku+""});
		if(row > 0){
			req.setData(true);
		}else{
			req.setData(false);
		}
		req.setCode(0);
	}

	/**
	 * 根据用户ID删除用户关注的商品
	 * @param user_id
	 * @param sku  关注sku，多个英文逗号隔开
	 * @return
	 * @throws Exception 
	 */
	public void deleteFollowWare(String user_id, String sku, ReqResponse<String> req) throws Exception {
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("user_id", user_id);
		 map.put("skus", sku.split(","));
		 dao.delete("mallfollowWareMapper.deleteFollowWare", map);
		
	}
	
}
