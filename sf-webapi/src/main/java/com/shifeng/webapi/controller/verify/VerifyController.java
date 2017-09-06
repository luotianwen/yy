package com.shifeng.webapi.controller.verify;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.common.base.Objects;
import com.shifeng.util.redis.RedisTool;
import com.shifeng.webapi.common.Constant;
import com.shifeng.webapi.controller.BaseController;

/**
 * 验证
 * @author WinZhong
 *
 */
@Controller
@RequestMapping(value = "/verify")
public class VerifyController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;
	
	 
  //https://reg.jd.com/validate/validateAuthCode?r=0.011445881585637752    uuid:dcc8df4e-b976-476d-80e3-8e782bef46fd  authCode:yst8
	//https://authcode.jd.com/verify/image?a=0&acid=90d42d42-8be7-4b33-9d64-e15995abbda3&uid=90d42d42-8be7-4b33-9d64-e15995abbda3&srcid=reg&is=5e4363c24e5971b3a689b14be76db6f8&yys=1488249860747
	/**
	 * 生产图片验证码
	 * @param version	版本号
	 * @param ticket
	 * @param itype	验证码类型
	 * @param request
	 * @param response
	 * @param timestamp	时间戳，防止浏览器缓存
	 * @throws IOException
	 */
    @GetMapping(value = "/image.jpg")
	public void notice(@RequestParam(value = "version", required = true) String version,@RequestParam(value = "ticket", required = true) String ticket
			,@RequestParam(value = "itype", required = true) String itype,HttpServletRequest request, HttpServletResponse response,String timestamp) throws IOException{
		response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
		// 验证版本号
/*		switch (version) {
			case ApiVersion.V_1_0_0:
				break;
			default:
				break;
		}*/

		//是否能继续获取访问
        if(this.isGoOnVisit(ticket, "image")){
			//验证ticket
	        String key = String.format(Constant.TICKET_KEY, ticket);
			String rTicket = RedisTool.get(key);
			if(Objects.equal(ticket, rTicket)){
					 //验证码
			        String authcode= captchaProducer.createText();
			        key = String.format(Constant.AUTHCODE_KEY,ticket, itype);
			        //验证码写入redis缓存
					RedisTool.set(key, authcode);
					//设置过期时间 单位：秒
					RedisTool.expire(key, Constant.AUTHCODE_VALID_TIME);
			        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, authcode);
			        logger.info("===ticket:"+ticket+"===itype:"+itype+"===验证码：" + authcode);
			        BufferedImage bi = captchaProducer.createImage(authcode);
			        ServletOutputStream out = response.getOutputStream();
			        ImageIO.write(bi, "jpg", out);
			        try {
			            out.flush();
			        } finally {
			            out.close();
			        }
			}
        }
	}
	
}
