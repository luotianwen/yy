package com.shifeng.provide.mall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.MallCartShopDTO;
import com.shifeng.response.ReqResponse;

/**
 * 商城购物车
 * @author WinZhong
 *
 */
@Service("mallCartDao")
public class MallCartDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 添加购物车商品
	 * @param user_id
	 * @param sku
	 * @param pcount 商品数量 
	 * @return
	 * @throws Exception 
	 */
	public void addCartWare(String user_id,String sku,int pcount,ReqResponse<String> req) throws Exception {
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("user_id", user_id);
		 map.put("sku", sku);
		 map.put("pcount", pcount);
		int count  = (int)dao.findForObject("mallcartMapper.isAddMyCartBysku", map);
		if(count > 0){//修改购物车商品数量
			dao.update("mallcartMapper.updateMyCartSkuNumbers", map);
		}else{//添加新商品到购物车
			
			//获取我的购物车商品数量
			count = (int)dao.findForObject("mallcartMapper.getMyCartNumber", user_id);
			if(count <= 80){
				dao.save("mallcartMapper.addCartWare", map);
			}else{
				req.setCode(80);
				req.setMsg("购物车数量超过最大限制");
			}
			
		}
		
	}

	/**
	 * 删除购物车商品
	 * @param user_id
	 * @param skus 多个英文逗号分开 
	 * @return
	 * @throws Exception 
	 */
	public void deleteCartWare(String user_id,String skus,ReqResponse<String> req) throws Exception {
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("user_id", user_id);
		 map.put("skus", skus.split(","));
		 dao.delete("mallcartMapper.deleteMyCartWare", map);
	}

	/**
	 * 修改购物车商品数量
	 * @param user_id
	 * @param sku
	 * @return
	 * @throws Exception 
	 */
	public void updateCartWare(String user_id,String sku,int wareNumber,ReqResponse<String> req) throws Exception {
		if(0 == wareNumber){
			wareNumber = 1;
		}
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("user_id", user_id);
		 map.put("sku", sku);
		 map.put("pcount", wareNumber);
		dao.update("mallcartMapper.updateMyCartSkuNumbers", map);
	}

	/**
	 * 获取我的购物车商品列表
	 * @param user_id
	 * @param req
	 * @throws Exception 
	 */
	public void getCartWareList(String user_id, ReqResponse<List<MallCartShopDTO>> req) throws Exception {
		List<MallCartShopDTO> careWareList = (List<MallCartShopDTO>)dao.findForList("mallcartMapper.getMyCartList", user_id);
		req.setData(careWareList);
	}
	
	
	
}
