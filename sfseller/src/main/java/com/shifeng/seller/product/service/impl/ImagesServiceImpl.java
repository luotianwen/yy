package com.shifeng.seller.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.Images;
import com.shifeng.seller.product.service.ImagesService;

/** 
 * 商品图片表(p_images)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
@Service("imagesServiceImpl")
public class ImagesServiceImpl implements ImagesService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Images> findAllImages(String id) throws Exception{
		return (List<Images>) dao.findForList("imagesMapper.findAllImages", id);
	}
	
	/**
	 * 根据ID查询
	 */
	public Images findImagesById(String id) throws Exception{
		return (Images) dao.findForObject("imagesMapper.findImagesById", id);
	}
	
	/**
	 * 新增
	 * @param images
	 * @throws Exception
	 */
	public void saveImages(List<Images> images,String userName,int pid) throws Exception{
		if(images!=null){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("images", images);
			map.put("userName", userName);
			map.put("pid", pid);
			dao.save("imagesMapper.saveImages", map);
		}
	}
	
	/**
	 * 修改
	 * @param images
	 * @throws Exception
	 */
	public void updateImages(List<Images> images,String userName,int pid) throws Exception{
		String id = "";
		for(int i=0,len=images.size();i<len;i++){
			Images image = images.get(i);
			if(image!=null){
				image.setPid(pid);
				image.setUpdatename(userName);
				image.setSort(i);
				if(i==0){
					image.setIsmain("1");
				}else{
					image.setIsmain("2");
				}
				
				if(image.getId()!=null){
					dao.update("imagesMapper.updateImages", image);
				}else{
				    dao.save("imagesMapper.saveImage", image);
				}
				if(StringUtils.isEmpty(id)){
					id = image.getId()+"";
				}else{
					id += ","+image.getId();
				}
			}
		}
		
		if(!StringUtils.isEmpty(id)){
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", id);
			map.put("pid", pid+"");
			dao.delete("imagesMapper.deleteImages", map);
		}
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteImages(String id) throws Exception{
		dao.delete("imagesMapper.deleteImages", id);
	}
	
}
