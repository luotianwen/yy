package com.shifeng.op.entity.users;

/**
 * 项目名：compass-data
 * 类描述：用户基本信息
 */
public class UserInfo extends Users{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	//分组ID
	private String aId;
	//角色名字
	private String rName;
	
	
	public String getSex(){
		if(uSex == 1){
			return "男";
		}else if(uSex == 2){	
			return "女";
		}else{
			return "保密";
		}
	}

	public String getaId() {
		return aId;
	}


	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}



 
	
}
