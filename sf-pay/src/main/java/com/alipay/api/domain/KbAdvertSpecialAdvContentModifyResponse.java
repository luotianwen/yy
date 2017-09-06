package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 口碑广告系统创建特殊广告内容返回模型
 *
 * @author auto create
 * @since 1.0, 2017-01-17 10:33:46
 */
public class KbAdvertSpecialAdvContentModifyResponse extends AlipayObject {

	private static final long serialVersionUID = 6362882814341787533L;

	/**
	 * 修改广告内容的结果码；
Success：修改成功；
PASSWORD_RED_EXIST：口令已存在；
ITEM_INVALID：商品无效或者已过期；
CREATE_PASSWORD_MORE_THEN_MAX：口令超过限定最多数量；
ADV_REPEAT_PASSWORD_RED：当前广告已存在口令，不能再次创建；
PASSWORD_RED_INVALID：口令校验失败；
CONTRACT_INVALID：合同已失效，不能创建口令；
NOT_SUPPORT_ERROR：非代金券不支持创建口令；
	 */
	@ApiField("code")
	private String code;

	/**
	 * 广告内容类型；
当该值是passwordRed时，code的值表示修改口令红包的结果码；
	 */
	@ApiField("content_type")
	private String contentType;

	/**
	 * 修改结果描述
	 */
	@ApiField("msg")
	private String msg;

	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getContentType() {
		return this.contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getMsg() {
		return this.msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
