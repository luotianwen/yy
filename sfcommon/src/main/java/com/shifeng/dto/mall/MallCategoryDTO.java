package com.shifeng.dto.mall;

import java.io.Serializable;
import java.util.List;

/**
 * 商城分类DTO
 * @author win
 *
 */
public class MallCategoryDTO implements Serializable {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = -3830974560982083627L;


  	//主键
   	 private Integer id;
  	//名称
   	 private String descript;
  	//url链接路径
   	 private String url;
  	//图片
   	 private String image;
 	//子分类列表
   	 private List<CategoryDTO> categoryList;
  
 	 
     /**
     *主键
 	* @return
     */ 
 	public Integer getId() {
 		return id;
 	}
     /**
     *主键
 	* @param type
     */ 
 	public void setId(Integer id) {
 		this.id = id;
 	}
     /**
     *父级编号
 	* @return
     */ 
     /**
     *名称
 	* @return
     */ 
 	public String getDescript() {
 		return descript;
 	}
     /**
     *名称
 	* @param type
     */ 
 	public void setDescript(String descript) {
 		this.descript = descript;
 	}
     /**
     *url链接路径
 	* @return
     */ 
 	public String getUrl() {
 		return url;
 	}
     /**
     *url链接路径
 	* @param type
     */ 
 	public void setUrl(String url) {
 		this.url = url;
 	}
  
     
     /**
     *图片
 	* @return
     */ 
 	public String getImage() {
 		return image;
 	}
     /**
     *图片
 	* @param type
     */ 
 	public void setImage(String image) {
 		this.image = image;
 	}
    
	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}
   
}