package com.shifeng.op.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shifeng.entity.product.Images;
import com.shifeng.op.product.service.ImagesService;
import com.shifeng.plugin.page.Page;
import com.shifeng.util.Const;
import com.shifeng.op.entity.users.Users;


/** 
 * 商品图片表(p_images)Controller
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */ 
@Controller
@RequestMapping(value="/images")
public class ImagesController{
	
	@Resource(name="imagesServiceImpl")
	private ImagesService imagesServiceImpl;

	/**
	 * 列表页面
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goImagesList")
	public ModelAndView goImagesList(ModelAndView mv) throws Exception{
		mv.setViewName("product/imagesList");
		return mv;
	}
	 
	 
	/**
	 * 查询所有
	 * @param page
	 * @param images
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findAllImages")
	@ResponseBody
	public Map<String,Object> findAllImages(Page page,Images images) throws Exception{
		if(images==null){
			images = new Images();
		}
		page.setT(images);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Images> imagess = imagesServiceImpl.findAllImages(page);
		map.put("imagess", imagess);
		map.put("page", page);
		return map;
	}
 
 
	/**
	 * 跳转编辑页面
	 * @param mv
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goImagesEdit")
	@ResponseBody
	public ModelAndView goImagesEdit(ModelAndView mv,String id) throws Exception{
		mv.addObject("id", id);
		mv.setViewName("product/imagesEdit");
		return mv;
	}
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findImagesById")
	@ResponseBody
	public Map<String,Object> findImagesById(String id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Images images = imagesServiceImpl.findImagesById(id);
		map.put("images",images);
		return map;
	}
	
	/**
	 * 新增
	 * @param images
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveImages")
	@ResponseBody
	public Map<String,Object> saveImages(Images images,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			imagesServiceImpl.saveImages(images);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 修改
	 * @param images
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateImages")
	@ResponseBody
	public Map<String,Object> updateImages(Images images,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		Users user = (Users) session.getAttribute(Const.OP_SESSION_USER);
		try {
			imagesServiceImpl.updateImages(images);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteImages")
	@ResponseBody
 	public Map<String,Object> deleteImages(String id) throws Exception{
 		Map<String,Object> map = new HashMap<String,Object>();
		map.put(Const.RESPONSE_STATE, 500);
		try {
			imagesServiceImpl.deleteImages(id);
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Const.ERROR_INFO, "保存异常，请稍后重试!!!");
		}
		return map;
 	}
 
}
