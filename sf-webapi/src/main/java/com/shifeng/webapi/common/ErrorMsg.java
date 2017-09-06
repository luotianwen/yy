package com.shifeng.webapi.common;

/**
 * 错误信息定义
 * @author WinZhong
 *
 */
public enum  ErrorMsg {
	
	/**
	 * 限制时间内调用次数过多
	 */
	APP_CALL_LIMITED(2,"限制时间内调用次数过多")
	/**
	 * 系统处理错误
	 */
	,SYSTEM_ERROR(43,"系统处理错误")
	/**
	 * 无效的签名
	 */
	,INVALID_SIGN(12,"无效的签名")
	/**
	 * 无效调用
	 */
	,INVALID_GET_PROGRAM(50,"无效调用")
	/**
	 * 不支持的版本号
	 */
	,UNSUPPORTED_VERSION(5,"不支持的版本号")
	/**
	 * 用户名或密码错误
	 */
	,ACCOUNT_PASSWORD_ERROR(10001,"用户名或密码错误")
	/**
	 * 用户未登录
	 */
	,USER_NO_LOGIN(10004,"用户未登录")
	/**
	 * 修改失败
	 */
	,MODIFY_FAILED(10005,"修改失败")
	/**
	 * 失败
	 */
	,FAIL(15000,"失败")
	/**
	 * 验证码错误
	 */
	,AUTHCODE_ERROR(14000,"验证码错误")
	;
	
	//错误码
    private int code;  
    //错误描述
	private String msg;
      
    private ErrorMsg(int code,String msg)  
    {  
        this.code=code;  
        this.msg=msg;  
    }  
      
    /**
     * 错误描述
     * @return
     */
    public String getMsg()  
    {  
        return this.msg;  
    }  
    /**
     * 错误码
     * @return
     */
    public int getCode() {  
      return this.code;  
  }  

}
