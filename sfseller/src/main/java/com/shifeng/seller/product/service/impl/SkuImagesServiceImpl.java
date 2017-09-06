package com.shifeng.seller.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.SkuImages;
import com.shifeng.seller.product.dto.SkuImagesDTO;
import com.shifeng.seller.product.service.SkuImagesService;

/** 
 * sku图片表(p_sku_images)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 16:57:54 
 */  
@Service("skuimagesServiceImpl")
public class SkuImagesServiceImpl implements SkuImagesService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<SkuImages> findAllSkuImages(String id) throws Exception{
		return (List<SkuImages>) dao.findForList("skuimagesMapper.findAllSkuImages", id);
	}
	
	/**
	 * 查询SKU颜色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SkuImages> findAllColorId(String id) throws Exception{
		return (List<SkuImages>) dao.findForList("skuimagesMapper.findAllColorId", id);
	}
	
	/**
	 * 根据ID查询
	 */
	public SkuImages findSkuImagesById(String id) throws Exception{
		return (SkuImages) dao.findForObject("skuimagesMapper.findSkuImagesById", id);
	}
	
	/**
	 * 新增
	 * @param skuimages
	 * @throws Exception
	 */
	public void saveSkuImages(List<SkuImagesDTO> skuimages,String userName,int pid,Map<Integer,Integer> mcolor) throws Exception{
		if(skuimages!=null){
			for(int i=0,len=skuimages.size();i<len;i++){
			  	SkuImagesDTO dto = skuimages.get(i);
			  	
			  	dto.setColorid(mcolor.get(dto.getColorid()));
			  	dto.setPid(pid);
			  	dto.setUpdatename(userName);
			  	
				dao.save("skuimagesMapper.saveSkuImages", dto);
			}
		}
	}
	
	/**
	 * 修改
	 * @param skuimages
	 * @throws Exception
	 */
	public void updateSkuImages(List<SkuImagesDTO> skuimages,String userName,int pid,Map<Integer,Integer> mcolor) throws Exception{
		if(skuimages!=null){
			Map<String,String> map = new HashMap<String,String>();
			map.put("pid", pid+"");
			dao.delete("skuimagesMapper.deleteSkuImages", map);
			for(int i=0,len=skuimages.size();i<len;i++){
				if(skuimages.get(i)!=null){
					for(int j=0,lenj=skuimages.get(i).getSkuImages().size();j<lenj;j++){
						SkuImages skuimage = skuimages.get(i).getSkuImages().get(j);
						
						skuimage.setPid(pid);
						skuimage.setUpdatename(userName);
						skuimage.setSort(i);
						skuimage.setColorid(mcolor.get(skuimages.get(i).getColorid()));
						
						if(j==0){
							skuimage.setIsmain(1);
						}else{
							skuimage.setIsmain(2);
						}
						
						dao.save("skuimagesMapper.saveSkuImage", skuimage);
					}
					
				}
			}
		}
		
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSkuImages(String id) throws Exception{
		dao.delete("skuimagesMapper.deleteSkuImages", id);
	}
	
}
