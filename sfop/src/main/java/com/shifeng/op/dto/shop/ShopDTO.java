package com.shifeng.op.dto.shop;

import com.shifeng.entity.shop.Shopinfo;

/**
 * Created by yongshi on 2017/3/1.
 */
public class ShopDTO extends Shopinfo {
    //负责人姓名
    private String head_name;
    //负责人手机号
    private String head_phone;
    //负责人邮箱
    private String head_email;
    //公司名称
    private String msName;
    private int type;
    private int cooperation;
    //支付状态
    private String pay_status;
    
    public int getCooperation() {
        return cooperation;
    }

    public void setCooperation(int cooperation) {
        this.cooperation = cooperation;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHead_name() {
        return head_name;
    }

    public void setHead_name(String head_name) {
        this.head_name = head_name;
    }

    public String getHead_phone() {
        return head_phone;
    }

    public void setHead_phone(String head_phone) {
        this.head_phone = head_phone;
    }

    public String getHead_email() {
        return head_email;
    }

    public void setHead_email(String head_email) {
        this.head_email = head_email;
    }

    public String getMsName() {
        return msName;
    }

    public void setMsName(String msName) {
        this.msName = msName;
    }

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
    
}
