package com.shifeng.dto.mall.ware;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品评论回复DTO
 * @author WinZhong
 *
 */
public class WareCommentRepayDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//回复时间
  	 private Date rdate;
 	//回复人名称
  	 private String rName;
 	//回复内容
  	 private String rcontent;



    /**
    *回复时间
	* @return
    */ 
	public Date getRdate() {
		return rdate;
	}
    /**
    *回复时间
	* @param rdate
    */ 
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
    /**
    *回复人名称
	* @return
    */ 
	public String getRName() {
		return rName;
	}
    /**
    *回复人名称
	* @param rName
    */ 
	public void setRName(String rName) {
		this.rName = rName;
	}
    /**
    *回复内容
	* @return
    */ 
	public String getRcontent() {
		return rcontent;
	}
    /**
    *回复内容
	* @param rcontent
    */ 
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	
}
