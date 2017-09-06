package com.shifeng.dto.fx;

import java.io.Serializable;

/**
 * 
 * @author WinZhong
 *
 */
public class FxUserDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//推荐用户id
  	 private String recommend_userid;
 	//被推荐用户id
  	 private String recommended_userid;
 	//被推荐用户姓名
  	 private String name;
 	//手机号
  	 private String phone;
 	//备注
  	 private String remark;



	 
    /**
    *推荐用户id
	* @return
    */ 
	public String getRecommend_userid() {
		return recommend_userid;
	}
    /**
    *推荐用户id
	* @param recommend_userid
    */ 
	public void setRecommend_userid(String recommend_userid) {
		this.recommend_userid = recommend_userid;
	}
    /**
    *被推荐用户id
	* @return
    */ 
	public String getRecommended_userid() {
		return recommended_userid;
	}
    /**
    *被推荐用户id
	* @param recommended_userid
    */ 
	public void setRecommended_userid(String recommended_userid) {
		this.recommended_userid = recommended_userid;
	}
   
	/**
	 * 被推荐用户姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 被推荐用户姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 手机号
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 手机号
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
    *备注
	* @return
    */ 
	public String getRemark() {
		return remark;
	}
    /**
    *备注
	* @param remark
    */ 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "FxUserDTO [recommend_userid=" + recommend_userid + ", recommended_userid=" + recommended_userid
				+ ", name=" + name + ", phone=" + phone + ", remark=" + remark + "]";
	}
	
	
	
}
