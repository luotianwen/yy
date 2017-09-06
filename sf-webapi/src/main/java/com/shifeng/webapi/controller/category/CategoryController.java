package com.shifeng.webapi.controller.category;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shifeng.dto.mall.MallCategoryDTO;
import com.shifeng.entity.category.Navigation;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.category.CategoryService;

/**
 * 分类
 * @author win
 *
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "categoryServiceImpl")
	protected CategoryService categoryService;
	
	/**
	 * 获取分类列表
	 * @param version
	 * @param ticket
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public ReqResponse<List<MallCategoryDTO>> list(String version,String ticket,String sign){
		ReqResponse<List<MallCategoryDTO>> req = new ReqResponse<List<MallCategoryDTO>>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"category/list", req)){
    		return req;
    	}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket,req)){
					req.setData(categoryService.getCategoryList());
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
	}	
	

	
	/**
	 * 获取分类导航列表
	 * @param version
	 * @param ticket
	 * @return
	 */
	@RequestMapping(value="/getCategoryNavigation")
	@ResponseBody
	public ReqResponse<List<Navigation>> getCategoryNavigation(String version,String ticket,String sign) throws Exception{
		ReqResponse<List<Navigation>> req = new ReqResponse<List<Navigation>>();
    	//验证ticket
    	if(!this.visitInspect(ticket,"category/getCategoryNavigation", req)){
    		return req;
    	}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ticket,req)){
					List<Navigation> navigationList = categoryService.getCategoryNavigation();
					req.setData(navigationList);
				}
				break;
			default://不支持的版本号
				req.setCode(ErrorMsg.UNSUPPORTED_VERSION.getCode());
				req.setMsg(ErrorMsg.UNSUPPORTED_VERSION.getMsg());
				break;
		}
		
		
		return req;
		
	}

}
