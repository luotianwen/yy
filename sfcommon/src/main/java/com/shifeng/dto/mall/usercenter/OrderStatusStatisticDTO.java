package com.shifeng.dto.mall.usercenter;

import java.io.Serializable;

/**
 * 订单状态统计DTO
 * @author Win
 *
 */
public class OrderStatusStatisticDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//待付款
	private int daifukuan = 0;	
	//待发货
	private int daifahuo = 0;	
	//待收货
	private int daishouhuo = 0;	
	//待评价
	private int daipingjia = 0;	
	//待退款
	private int daituikuan = 0;	
	//售后
	private int shouhou = 0;
	
	
	public int getDaifukuan() {
		return daifukuan;
	}
	public void setDaifukuan(int daifukuan) {
		this.daifukuan = daifukuan;
	}
	public int getDaifahuo() {
		return daifahuo;
	}
	public void setDaifahuo(int daifahuo) {
		this.daifahuo = daifahuo;
	}
	public int getDaishouhuo() {
		return daishouhuo;
	}
	public void setDaishouhuo(int daishouhuo) {
		this.daishouhuo = daishouhuo;
	}
	public int getDaipingjia() {
		return daipingjia;
	}
	public void setDaipingjia(int daipingjia) {
		this.daipingjia = daipingjia;
	}
	public int getShouhou() {
		return shouhou;
	}
	public void setShouhou(int shouhou) {
		this.shouhou = shouhou;
	}
	
	
	public int getDaituikuan() {
		return daituikuan;
	}
	public void setDaituikuan(int daituikuan) {
		this.daituikuan = daituikuan;
	}
	@Override
	public String toString() {
		return "OrderStatusStatisticDTO [daifukuan=" + daifukuan + ", daifahuo=" + daifahuo + ", daishouhuo="
				+ daishouhuo + ", daipingjia=" + daipingjia + ", daituikuan=" + daituikuan + ", shouhou=" + shouhou
				+ "]";
	}
	
	
	

}
