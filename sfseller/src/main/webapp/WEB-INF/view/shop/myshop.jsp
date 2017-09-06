<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- content starts -->
<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2><i class="glyphicon glyphicon-th"></i> 店铺管理</h2>
			</div>
			<div class="box-content">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active">
						<a href="#info" data-toggle="tab">商家信息</a>
					</li>
					<li>
						<a href="#custom" data-toggle="tab">公司资质</a>
					</li>
					<li>
						<a href="#messages" data-toggle="tab">经营资质</a>
					</li>
					<li>
						<a href="#linkman" data-toggle="tab">联系信息</a>
					</li>
				</ul>

				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="info">
						<div class="form-info">
							<h4>商家信息</h4>
							<dl class="dl-horizontal">
								<dt>公司名称：</dt>
								<dd>${merchantsSettled.name}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>商家编号：</dt>
								<dd>${merchantsSettled.id}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>店铺名称：</dt>
								<dd>${shopinfo.name}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>店铺域名：</dt>
								<dd>${merchantsSettled.website}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>店铺类型：</dt>
								<dd>
									<c:if test="${shopinfo.grade==1 }">
										【官方旗舰店】
									</c:if>
									<c:if test="${shopinfo.grade==2 }">
										【(品牌)授权专卖店】
									</c:if>
									<c:if test="${shopinfo.grade==3 }">
										【品牌专营店】
									</c:if>
								</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>合作模式：</dt>
								<dd>
									<c:if test="${merchantsSettled.cooperation==1 }">
										代销
									</c:if>
									<c:if test="${merchantsSettled.cooperation==2 }">
										入驻
									</c:if>
								</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>主账号：</dt>
								<dd>${shopinfo.account}</dd>
							</dl>
							<h4>公司地址及税务信息</h4>
							<dl class="dl-horizontal">
								<dt>纳税类型税码：</dt>
								<dd>${merchantsSettled.taxpayerCoding}%</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>纳税人类型：</dt>
								<dd>
									<c:if test="${merchantsSettled.taxpayerType==1 }">
										一般纳税人
									</c:if>
									<c:if test="${merchantsSettled.taxpayerType==2 }">
										小规模纳税人
									</c:if>
									<c:if test="${merchantsSettled.taxpayerType==3 }">
										非增值税纳税人
									</c:if>
								</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>企业类型：</dt>
								<dd>
									<c:if test="${merchantsSettled.type==1 }">
										生产厂商
									</c:if>
									<c:if test="${merchantsSettled.type==2 }">
										品牌商
									</c:if>
									<c:if test="${merchantsSettled.type==3 }">
										中国总代
									</c:if>
									<c:if test="${merchantsSettled.type==4 }">
										地区总代
									</c:if>
									<c:if test="${merchantsSettled.type==5 }">
										代运营商
									</c:if>
									<c:if test="${merchantsSettled.type==6 }">
										经销商
									</c:if>
								</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>公司联系地址：</dt>
								<dd>${merchantsSettled.companyArea}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>公司详细地址：</dt>
								<dd>${merchantsSettled.companyAddress}</dd>
							</dl>
							<h4>结算银行信息</h4>
							<dl class="dl-horizontal">
								<dt>开户名：</dt>
								<dd>${merchantsSettled.bankName}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>开户行支行名称：</dt>
								<dd>${merchantsSettled.bankBranchName}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>开户银行支行所在地：</dt>
								<dd>${merchantsSettled.locationBankbranch}</dd>
							</dl>
							<dl class="dl-horizontal">
								<dt>银行账号：</dt>
								<dd>${merchantsSettled.bankNum}</dd>
							</dl>
							<!-- <dl class="dl-horizontal">
								<dt>开户行支行联行号：</dt>
								<dd></dd>
							</dl> -->
							<dl class="dl-horizontal">
								<dt>银行开户许可证电子版：</dt>
								<dd>
									<a target="_blank" href="${merchantsSettled.bank_image }">查看</a>
								</dd>
							</dl>
						</div>
					</div>
					<div class="tab-pane fade" id="custom">
						<div class="form-info">
							<c:if test="${merchantsSettled.isThree==1 }">
								<h4>三证合一</h4>
								<dl class="dl-horizontal">
									<dt>三证合一电子版：</dt>
									<dd>
										<a target="_blank" href="${merchantsSettled.threeInOneImage }">查看</a>
									</dd>
								</dl>
							</c:if>
							<c:if test="${merchantsSettled.isThree==2 }">
								<h4>公司营业执照信息（副本）</h4>
								<dl class="dl-horizontal">
									<dt>公司名称：</dt>
									<dd>${merchantsSettled.name }</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>注册号（营业执照号）：</dt>
									<dd>12131321313123231</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>法定代表人姓名：</dt>
									<dd>${merchantsSettled.legalRepresentative }</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>身份证号：</dt>
									<dd>${merchantsSettled.id_number }</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>法人身份证电子版：</dt>
									<dd>
										<a target="_blank" href="${merchantsSettled.corporate_front_card }">查看</a>
									</dd>
								</dl>
								<%--<dl class="dl-horizontal">
									<dt>注册所在地：</dt>
									<dd>北京通州区潞城镇</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>详细地址：</dt>
									<dd>潞城镇五星路00号</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>成立日期：</dt>
									<dd>2011-04-27</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>营业期限：</dt>
									<dd>从2011-04-27至2031-04-26</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>注册资本：</dt>
									<dd>100万元</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>经营范围：</dt>
									<dd>一般经营项目：体育用品，一般经营项目：体育用品一般经营项目：体育用品一般经营项目：体育用品一般经营项目：体 育用品一般经营项目：体育用品
									</dd>
								</dl>--%>
								<dl class="dl-horizontal">
									<dt>营业执照副本电子版：</dt>
									<dd>
										<a target="_blank" href="${merchantsSettled.licenseImage }">查看</a>
									</dd>
								</dl>
								<%--<h4>公司组织机构代码证</h4>
								<dl class="dl-horizontal">
									<dt>组织机构代码：</dt>
									<dd>57317074-4</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>组织机构代码证有效期：</dt>
									<dd>从2015-02-21至2030-02-20</dd>
								</dl>--%>
								<dl class="dl-horizontal">
									<dt>组织机构代码证电子版：</dt>
									<dd>
										<a target="_blank" href="${merchantsSettled.organizationImage }">查看</a>
									</dd>
								</dl>
								<h4>公司税务登记证</h4>
								<%--<dl class="dl-horizontal">
									<dt>纳税人识别号：</dt>
									<dd>12312311235545</dd>
								</dl>--%>
								<dl class="dl-horizontal">
									<dt>税务登记证电子版：</dt>
									<dd>
										<a target="_blank" href="${merchantsSettled.taxImage }">查看</a>
									</dd>
								</dl>
								<%--<dl class="dl-horizontal">
									<dt>一般纳税人资格证电子版：</dt>
									<dd>
										<a href="#">查看</a>
									</dd>
								</dl>--%>
							</c:if>
						</div>
					</div>
					<div class="tab-pane fade" id="messages">
						<div class="form-info">
							<h4>经营类目</h4>
							<dl class="dl-horizontal">
								<dt>主营类目：</dt>
								<dd>运动户外</dd>
							</dl>
							<div class="box-content">
								<table class="table table-bordered table-striped table-condensed">
									<thead>
										<tr>
											<th>序号</th>
											<th>一级类目</th>
											<th>二级类目</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${shopCategorys }" var="item" varStatus="sta">
											<tr>
												<td>${sta.index+1 }</td>
												<td class="center">${item.parentname }</td>
												<td class="center">${item.categoryName }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</div>
							<h4>店铺类型</h4>
							<dl class="dl-horizontal">
								<dt>店铺类型：</dt>
								<dd>
									<c:if test="${shopinfo.grade==1 }">
										【官方旗舰店】
									</c:if>
									<c:if test="${shopinfo.grade==2 }">
										【(品牌)授权专卖店】
									</c:if>
									<c:if test="${shopinfo.grade==3 }">
										【品牌专营店】
									</c:if>
								</dd>
							</dl>
							<%--<dl class="dl-horizontal">
								<dt>服务类商标注册证：</dt>
								<dd>京东授权书.jpg
									<a href="#" style="margin-right:30px;">查看</a> 商标注册证CCF20121108.jpg
									<a href="#">查看</a>
								</dd>
							</dl>

							<h4>经营类目资质</h4>
							<div class="box-content">
								<table class="table table-bordered table-striped table-condensed">
									<thead>
										<tr>
											<th>类目名称</th>
											<th>资质名称</th>
											<th>电子版</th>
											<th>到期日</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>运动户外</td>
											<td class="center">3C安全认证证书</td>
											<td class="center">毛巾质检1.jpg
												<a href="#">查看</a><br>毛巾质检1.jpg
												<a href="#">查看</a><br>毛巾质检1.jpg
												<a href="#">查看</a>
											</td>
											<td class="center">永久 </td>
										</tr>

									</tbody>
								</table>

							</div>--%>
						</div>
					</div>
					<div class="tab-pane fade" id="linkman">
						<div class="form-info">
							<h4>公司负责人</h4>
							<div class="row">
								<div class="box col-md-6">
									<dl class="dl-horizontal">
										<dt>姓名：</dt>
										<dd>${merchantsSettled.head_name }</dd>
									</dl>
									<dl class="dl-horizontal">
										<dt>手机：</dt>
										<dd>${merchantsSettled.head_phone }</dd>
									</dl>
									<dl class="dl-horizontal">
										<dt>电子邮件：</dt>
										<dd>${merchantsSettled.head_email }</dd>
									</dl>
								</div>
							</div>
							
							<c:forEach items="${storeSupervisors }" var="item">
								<c:if test="${item.type==1 }">
									<h4>店铺负责人</h4>
								</c:if>
								<c:if test="${item.type==2 }">
									<h4>运营联系人</h4>
								</c:if>
								<c:if test="${item.type==3 }">
									<h4>售后联系人</h4>
								</c:if>
								<c:if test="${item.type==4 }">
									<h4>财务联系人</h4>
								</c:if>
								<c:if test="${item.type==5 }">
									<h4>技术负责人</h4>
								</c:if>
								<div class="row">
									<div class="box col-md-6">
										<dl class="dl-horizontal">
											<dt>姓名：</dt>
											<dd>${item.name }</dd>
										</dl>
										<dl class="dl-horizontal">
											<dt>电子邮件：</dt>
											<dd>${item.email }</dd>
										</dl>
										<dl class="dl-horizontal">
											<dt>座机：</dt>
											<dd>${item.landline }</dd>
										</dl>
									</div>
									<div class="box col-md-6">
										<dl class="dl-horizontal">
											<dt>手机：</dt>
											<dd>${item.phone }</dd>
										</dl>
										<dl class="dl-horizontal">
											<dt>QQ：</dt>
											<dd>${item.qq }</dd>
										</dl>
									</div>
								</div>
							</c:forEach>
							
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</div>
