package com.shifeng.dto.mall.ware;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品评论DTO
 * @author WinZhong
 *
 */
public class WareCommentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


 	//id
  	 private Integer id;
 	//颜色名称
  	 private String colorName;
 	//规格名称
  	 private String specName;
 	//买家姓名
  	 private String receiveName;
   	//商品评分 (默认5分)
   	 private Integer score;
 	//内容
  	 private String content;
 	//创建时间
  	 private Date cdate;
 	//回复数量
  	 private Integer replycount;
  	 //评论图片列表
  	 private List<String> commentImgs;
  	 //评论回复列表
  	 private List<WareCommentRepayDTO> repayList;

     /**
      *id
  	* @return
      */ 
  	public Integer getId() {
  		return id;
  	}
      /**
      *id
  	* @param id
      */ 
  	public void setId(Integer id) {
  		this.id = id;
  	}
    /**
    *颜色名称
	* @return
    */ 
	public String getColorName() {
		return colorName;
	}
    /**
    *颜色名称
	* @param colorName
    */ 
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
    
    /**
    *规格名称
	* @return
    */ 
	public String getSpecName() {
		return specName;
	}
    /**
    *规格名称
	* @param specName
    */ 
	public void setSpecName(String specName) {
		this.specName = specName;
	}
   
    /**
    *买家姓名
	* @return
    */ 
	public String getReceiveName() {
		return receiveName;
	}
    /**
    *买家姓名
	* @param receiveName
    */ 
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
    
    
    /**
    *内容
	* @return
    */ 
	public String getContent() {
		return content;
	}
    /**
    *内容
	* @param content
    */ 
	public void setContent(String content) {
		this.content = content;
	}
    /**
    *创建时间
	* @return
    */ 
	public Date getCdate() {
		return cdate;
	}
    /**
    *创建时间
	* @param cdate
    */ 
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
    /**
    *回复数量
	* @return
    */ 
	public Integer getReplycount() {
		return replycount;
	}
    /**
    *回复数量
	* @param replycount
    */ 
	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}
	/**
	 * 评论图片列表
	 * @return
	 */
	public List<String> getCommentImgs() {
		return commentImgs;
	}
	/**
	 * 评论图片列表
	 * @param commentImgs
	 */
	public void setCommentImgs(List<String> commentImgs) {
		this.commentImgs = commentImgs;
	}
	/**
	 * 评论回复列表
	 * @return
	 */
	public List<WareCommentRepayDTO> getRepayList() {
		return repayList;
	}
	/**
	 * 评论回复列表
	 * @param repayList
	 */
	public void setRepayList(List<WareCommentRepayDTO> repayList) {
		this.repayList = repayList;
	}


	/**
	 * 商品评分
	 * @return
	 */
    public Integer getScore() {
    		return score;
	}
    /**
     * 商品评分
     * @param score
     */
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "WareCommentDTO [id=" + id + ", colorName=" + colorName + ", specName=" + specName + ", receiveName="
				+ receiveName + ", score=" + score + ", content=" + content + ", cdate=" + cdate + ", replycount="
				+ replycount + ", commentImgs=" + commentImgs + ", repayList=" + repayList + "]";
	}
	
}

