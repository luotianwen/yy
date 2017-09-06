package com.shifeng.dto.express;

/**
 * 快递跟踪信息DTO
 * @author Win
 *
 */
public class ExpressTraceDTO {
	
	/**
	 * 每条跟踪信息的时间
	 */
	private String time;
	/**
	 * 每条跟综信息的描述
	 */
	private String context;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "ExpressTraceDTO [time=" + time + ", context=" + context + "]";
	}
	
	
	

}
