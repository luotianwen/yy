package com.shifeng.provide.mall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.MallCategoryDTO;
import com.shifeng.provide.mall.dao.MallCategoryDao;
import com.shifeng.provide.mall.service.MallCategoryService;
import com.shifeng.response.ReqResponse;

/**
 * 商城分类
 * @author win
 *
 */
@Service(timeout=1200000)
public class MallCategoryServiceImpl implements MallCategoryService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallCategoryDao")
	private MallCategoryDao mallCategoryDao;
	
	/**
	 * 获取分类列表
	 * @return
	 */
	public ReqResponse<List<MallCategoryDTO>> getCategoryList() {
		ReqResponse<List<MallCategoryDTO>> req = new ReqResponse<List<MallCategoryDTO>>();
		try {
			mallCategoryDao.getCategoryList(req);
			return req;
		} catch (Exception e) {
			logger.error("【获取分类列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取分类列表】异常");
			return req;
		}
	}

}
