package com.shifeng.op.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.Images;
import com.shifeng.op.product.service.ImagesService;
import com.shifeng.plugin.page.Page;

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
	public List<Images> findAllImages(Page page) throws Exception{
		return (List<Images>) dao.findForList("imagesMapper.findAllImagesPage", page);
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
	public void saveImages(Images images) throws Exception{
		dao.save("imagesMapper.saveImages", images);
	}
	
	/**
	 * 修改
	 * @param images
	 * @throws Exception
	 */
	public void updateImages(Images images) throws Exception{
		dao.update("imagesMapper.updateImages", images);
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
