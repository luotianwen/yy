package com.shifeng.provide.mall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.MallSpecialSaleSkuDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/**
 * 商城特卖sku
 * @author WinZhong
 *
 */
@Service("mallSpecialSaleSkuDao")
public class MallSpecialSaleSkuDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	
	/**
	 * 获取特卖商品列表
	 * @param cid 分类ID
	 * @param sort 排序（0：综合；1：价格从低到高；2：价格从高到低；3：折扣从低到高；4：折扣从高到低）
	 * @return
	 * @throws Exception 
	 */
	public void getSpecialSaleSku(String cid,String sort,int currentPage,ReqResponse<Page> req) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cid", cid);
		map.put("sort", sort);
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setT(map);
		List<MallSpecialSaleSkuDTO> sList = (List<MallSpecialSaleSkuDTO>)dao.findForList("mallSpecialSaleSkuMapper.getSpecialSaleSkuPage", page);
		page.setResultData(sList);
		req.setData(page);
		
	}
	
	
	

}
