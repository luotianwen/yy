package com.shifeng.mall.settled.dto;

import java.util.List;

import com.shifeng.entity.shop.MerchantsSettled;
import com.shifeng.entity.shop.ShopCategory;
import com.shifeng.entity.shop.StoreSupervisor;


/**
 * Created by yongshi on 2017/3/4.
 */
public class ShopDTO  extends MerchantsSettled{
    private Integer s_merchants_id;
    //登录帐号
    private String account;
    //登录密码
    private String password;
    //店铺类型
    private Integer grade;

	//店铺logo
    private String logo;
    //客服电话
    private String fax;
    //邮箱
    private String email;
    //邮编
    private String postcode;
    //在线客服QQ
    private String qq;
    //注册日期
    private String rtime;
    //状态
    private Integer sstate=4;

    //结束时间
    private String endtime;


    //最后修改人
    private String updatename;
    //备注
    private String remark;
    //复审状态
    private Integer fstate=3;
    //当前步骤
    private Integer next=1;

	//负责人
    private List<StoreSupervisor> storeSupervisors;
    //产品类目
    private List<ShopCategory> shopCategorys;
    
    /**
     * 新增类目信息
     */
	//类目id
	private String c_category_id;
	//类目名称
	private String categoryName;
	//类目保证金标准（元）
	private String deposit;
	//平台使用费
	private String platformfee;
	//扣点
	private String points;
	//代销店铺扣点
	private String consignmentpoints;
    
    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getS_merchants_id() {
        return s_merchants_id;
    }

    public void setS_merchants_id(Integer s_merchants_id) {
        this.s_merchants_id = s_merchants_id;
    }


    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public Integer getSstate() {
        return sstate;
    }

    public void setSstate(Integer sstate) {
        this.sstate = sstate;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFstate() {
        return fstate;
    }

    public void setFstate(Integer fstate) {
        this.fstate = fstate;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

	public List<StoreSupervisor> getStoreSupervisors() {
		return storeSupervisors;
	}

	public void setStoreSupervisors(List<StoreSupervisor> storeSupervisors) {
		this.storeSupervisors = storeSupervisors;
	}

	public List<ShopCategory> getShopCategorys() {
		return shopCategorys;
	}

	public void setShopCategorys(List<ShopCategory> shopCategorys) {
		this.shopCategorys = shopCategorys;
	}

	public String getC_category_id() {
		return c_category_id;
	}

	public void setC_category_id(String c_category_id) {
		this.c_category_id = c_category_id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPlatformfee() {
		return platformfee;
	}

	public void setPlatformfee(String platformfee) {
		this.platformfee = platformfee;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getConsignmentpoints() {
		return consignmentpoints;
	}

	public void setConsignmentpoints(String consignmentpoints) {
		this.consignmentpoints = consignmentpoints;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	
	
}
