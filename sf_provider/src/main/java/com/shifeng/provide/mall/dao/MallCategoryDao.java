package com.shifeng.provide.mall.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.dto.mall.MallCategoryDTO;
import com.shifeng.dto.mall.MallFeedbackDTO;
import com.shifeng.response.ReqResponse;

@Service("mallCategoryDao")
public class MallCategoryDao {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;

	/**
	 * 添加反馈
	 * @param mallFeedback
	 * @return
	 * @throws Exception 
	 */
	public void addFeedback(MallFeedbackDTO mallFeedback, ReqResponse<String> req) throws Exception {
		mallFeedback.setFeedback_id(null);
		dao.save("mallfeedbackMapper.saveMallFeedback", mallFeedback);
		if(null != mallFeedback.getFeedback_id() && mallFeedback.getFeedback_id() > 0){
			if(null != mallFeedback.getImg_url() && mallFeedback.getImg_url().length > 0){
				dao.save("mallfeedbackimgMapper.saveMallFeedbackImg", mallFeedback);
			}
			req.setCode(0);
		}else{
			req.setCode(1);
			req.setMsg("添加反馈失败！");
		}
		
	}

	/**
	 * 获取分类列表
	 * @param req
	 * @throws Exception 
	 */
	public void getCategoryList(ReqResponse<List<MallCategoryDTO>> req) throws Exception {
		List<MallCategoryDTO> categoryList = (List<MallCategoryDTO>)dao.findForList("categoryMapper.findAllParentCategory");
		req.setData(categoryList);
	}

}
