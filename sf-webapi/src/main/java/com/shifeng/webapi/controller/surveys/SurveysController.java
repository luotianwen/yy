package com.shifeng.webapi.controller.surveys;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shifeng.dto.mall.MallFeedbackDTO;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.common.ApiVersion;
import com.shifeng.webapi.common.ErrorMsg;
import com.shifeng.webapi.controller.BaseController;
import com.shifeng.webapi.service.mall.SurveysService;
import com.shifeng.webapi.util.Base64TurnPicture;

/**
 * 用户反馈调查API接口
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/surveys")
public class SurveysController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "surveysServiceImpl")
	protected SurveysService surveysService;
	
	
	
	
	/**
	 * 意见反馈
	 * @param version
	 * @param ticket
	 * @param token
	 * @param type 反馈类型
	 * @param content 反馈内容
	 * @param imgs	图片集合
	 * @param sign (version+ticket+type+content)
	 * @return
	 */
	@RequestMapping(value = "/feedback")
	@ResponseBody
	public ReqResponse<String> feedback(HttpServletRequest request,String version,String ticket,String token,/*String[] imgs,*/Integer type,String content,String sign){
		ReqResponse<String> req = new ReqResponse<String>();		
		if(StringUtils.isNotEmpty(token)){
			ticket = token;
			//是否能继续获取访问
			if(!this.isGoOnVisit(ticket, "surveys/feedback", req)){
				return req;
			}
		}else{
			//访问检查  验证ticket有效性以及接口调用频次
			if(!this.visitInspect(ticket, "surveys/feedback", req)){
				return req;
			}
		}
		//验证版本号
		switch (version) {
			case ApiVersion.V_1_0_0:
				//验证签名
				if(this.verifySign(sign, version+ ticket+type+content,req)){
					MallFeedbackDTO mallFeedback = new MallFeedbackDTO();
					if(this.checkLogin(token)){//是否登录
						mallFeedback.setUser_id(this.user_id);
					}
					mallFeedback.setFeedback_content(content);
					mallFeedback.setFeedback_type(type);
					String[] imgs = this.getParameterValues("imgs[]");
					if(null != imgs && imgs.length > 0){//判断是否上传有图片
						String[] img_url = new String[imgs.length];
						for(int i =0;i<imgs.length;i++){
							img_url[i] = Base64TurnPicture.turn(request, imgs[i]);
						}
						mallFeedback.setImg_url(img_url);
					}
					boolean bl = surveysService.addFeedback(mallFeedback);; 
					if(!bl){
						req.setCode(ErrorMsg.FAIL.getCode());
						req.setMsg(ErrorMsg.FAIL.getMsg());
					}
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
