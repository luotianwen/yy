package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 口碑客分佣创建
 *
 * @author auto create
 * @since 1.0, 2017-02-07 10:39:55
 */
public class KoubeiAdvertCommissionMissionCreateModel extends AlipayObject {

	private static final long serialVersionUID = 2175488471951415849L;

	/**
	 * PERCENTAGE_CLAUSE：百分比结算条款
QUOTA_CLAUSE：定额结算条款
MISSION_CLAIM_CLAUSE：专属认领人条款
	 */
	@ApiListField("commission_clause")
	@ApiField("kb_advert_commission_clause")
	private List<KbAdvertCommissionClause> commissionClause;

	/**
	 * 主键ID
	 */
	@ApiField("identify")
	private String identify;

	/**
	 * 主键类型
activity_id：运营活动ID
voucher：商品ID
	 */
	@ApiField("identify_type")
	private String identifyType;

	/**
	 * 分佣任务名称
	 */
	@ApiField("name")
	private String name;

	/**
	 * 操作人id，必须和operator_type配对出现，不填时默认是商户
	 */
	@ApiField("operator_id")
	private String operatorId;

	/**
	 * 操作人类型,有以下值可填：MERCHANT（外部商户），默认不需要填这个字段，默认为MERCHANT
	 */
	@ApiField("operator_type")
	private String operatorType;

	public List<KbAdvertCommissionClause> getCommissionClause() {
		return this.commissionClause;
	}
	public void setCommissionClause(List<KbAdvertCommissionClause> commissionClause) {
		this.commissionClause = commissionClause;
	}

	public String getIdentify() {
		return this.identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getIdentifyType() {
		return this.identifyType;
	}
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getOperatorId() {
		return this.operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorType() {
		return this.operatorType;
	}
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

}
