package com.shifeng.mall.settled.dto;

public class ProgressDTO {
	//入驻步骤
	private Integer next;
	//初审状态
	private Integer state;
	//复审状态
	private Integer fstate;
	
	public Integer getNext() {
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getFstate() {
		return fstate;
	}
	public void setFstate(Integer fstate) {
		this.fstate = fstate;
	}

	
}
