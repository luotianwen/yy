package com.shifeng.response;

import java.io.Serializable;

/**
 * 请求响应
 * @author WinZhong
 * @param <T>
 *
 */
public class ReqResponse<T> implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//响应代码CODE  成功返回0   默认0
	private int code = 0;
	//响应信息
	private String msg = "";
	//返回数据
	private T data;
	/**
	 * 响应代码CODE  成功返回0   默认0
	 * @return
	 */
	public int getCode() {
		return code;
	}
	/**
	 * 响应代码CODE  成功返回0   默认0
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * 响应信息
	 * @return
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 响应信息
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
 
	/**
	 * 返回数据
	 * @return
	 */
	public T getData() {
		return data;
	}
	/**
	 * 返回数据
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ReqResponse [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
