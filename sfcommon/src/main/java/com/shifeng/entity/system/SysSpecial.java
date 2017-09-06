package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * 专题页名称(sys_special)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
public class SysSpecial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//专题页名称
  	 private String title;
 	//页面名称(html)
  	 private String name;
 	//语言脚本代码
  	 private String script;
 	//内容
  	 private String content;
 	//状态
  	 private Integer state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;



	 
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
    *专题页名称
	* @return
    */ 
	public String getTitle() {
		return title;
	}
    /**
    *专题页名称
	* @param title
    */ 
	public void setTitle(String title) {
		this.title = title;
	}
    /**
    *页面名称(html)
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *页面名称(html)
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *语言脚本代码
	* @return
    */ 
	public String getScript() {
		return script;
	}
    /**
    *语言脚本代码
	* @param script
    */ 
	public void setScript(String script) {
		this.script = script;
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
    *状态
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *最后修改时间
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后修改时间
	* @param lasttime
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *最后修改人
	* @return
    */ 
	public String getUpdatename() {
		return updatename;
	}
    /**
    *最后修改人
	* @param updatename
    */ 
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
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
	
}
