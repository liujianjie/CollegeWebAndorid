<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fnt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/style.css">
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/all.js"></script>
<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link href="<%=path%>/foregroundSystem/css/index.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/foregroundSystem/css/detail.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/foregroundSystem/css/user.css" />
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<script src="<%=path%>/foregroundSystem/script/ablumn.js"></script>
<script src="<%=path%>/foregroundSystem/script/plugins.js"></script>
<script src="<%=path%>/foregroundSystem/script/detail.js"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
<%
	session.setAttribute("system", "前台系统");
%>
</head>
<body>
	<header>
	<div class="header-top min-width">
		<div class="container fn-clear">
			<strong class="fn-left">咨询热线：400-668-6698<span
				class="s-time">服务时间：9:00 - 18:00</span></strong>
			<ul class="header_contact">
				<li class="c_1"><a class="ico_head_weixin" id="wx"></a>
					<div class="ceng" id="weixin_xlgz" style="display: none;">
						<div class="cnr">
							<img src="<%=path%>/foregroundSystem/images/code.png">
						</div>
						<b class="ar_up ar_top"></b> <b class="ar_up_in ar_top_in"></b>
					</div></li>
				<li class="c_2"><a href="#" target="_blank" title="官方QQ"
					alt="官方QQ"><b class="ico_head_QQ"></b></a></li>
				<li class="c_4"><a href="#" target="_blank" title="新浪微博"
					alt="新浪微博"><b class="ico_head_sina"></b></a></li>
			</ul>
			<c:if test="${user.username == null}">
				<ul class="fn-right header-top-ul">
					<li><a href="<%=path%>/Borrow/selBorrowMoneySomeList.action"
						class="app">返回首页</a></li>
					<li>
						<div class="">
							<a href="<%=path%>/foregroundSystem/register.jsp"
								class="c-orange" title="免费注册">免费注册</a>
						</div>
					</li>
					<li>
						<div class="">
							<a href="<%=path%>/foregroundSystem/login.jsp" class="js-login"
								title="登录">登录</a>
						</div>
					</li>
				</ul>
			</c:if>
			<c:if test="${user.username != null }">
				<ul class="fn-right header-top-ul">
					<li><a href="<%=path%>/Borrow/selBorrowMoneySomeList.action"
						class="app">返回首页</a></li>
					<li>
						<div class="">
							<a href="<%=path%>/SelHuiKuan.action" class="c-orange"
								title="我的账户">${user.username }</a>
						</div>
					</li>
					<li>
						<div class="">
							<a href="<%=path%>/user/remove.action" class="js-login"
								title="退出">退出</a>
						</div>
					</li>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="header min-width">
		<div class="container">
			<div class="fn-left logo">
				<a class="" href="<%=path%>/Borrow/selBorrowMoneySomeList.action">
					<img src="<%=path%>/foregroundSystem/images/logo.png" title="">
				</a>
			</div>
			<ul class="top-nav fn-clear">
				<li class="on"><a
					href="<%=path%>/Borrow/selBorrowMoneySomeList.action">首页</a></li>
				<li><a
					href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
					class="">我要投资</a></li>
				<li><a href="<%=path%>/foregroundSystem/borrow.jsp" class="">我要借款</a></li>
				<li><a href="<%=path%>/foregroundSystem/help.jsp">安全保障</a></li>
				<li class="top-nav-safe"><a href="<%=path%>/SelHuiKuan.action">我的账户</a></li>
				<li><a href="<%=path%>/foregroundSystem/jianjie.jsp">关于我们</a></li>
			</ul>
		</div>
	</div>
	</header>
	<!--信息详细-->
	<div class="item-detail wrap">
		<div class="breadcrumbs">
			<a href="<%=path%>/foregroundSystem/index.jsp">首页</a>&gt; <a href="#">散标投资列表</a>&gt;
			<span class="cur">项目详情</span>
		</div>
		<div class="item-detail-head clearfix" data-target="sideMenu">
			<div class="hd">
				<i class="icon icon-che" title="车易贷"></i> ${bor.borrow_bt}
			</div>
			<div class="bd clearfix">
				<div class="data">
					<ul>
						<li><span class="f16">借款金额</span><br> <span
							class="f30 c-333" id="account">${bor.b_money }</span>元</li>
						<li class="relative"><span class="f16">年利率</span><br> <span
							class="f30 c-orange">${fn:substring(bor.rate*100,0,4)}% </span></li>
						<li><span class="f16">到期时间</span><br> <span
							class="f30 c-333"> <fnt:formatDate value="${bor.yx_time }"
									pattern="yyyy-MM-dd"></fnt:formatDate></span></li>
						<li><span class="c-888">编号：</span>${fn:substring(bor.b_id, 1,12)}</li>
						<li><span class="c-888">发标日期：</span> <fnt:formatDate
								value="${bor.borrow_fbtime }" pattern="yyyy-MM-dd"></fnt:formatDate></li>
						<li><span class="c-888">剩余投标期限：</span> <c:if
								test="${bor.syday!=null }">
											${bor.syday }天 </c:if></li>
						<li><span class="c-888">方式：</span>无</li>
						<li><span class="c-888">需还本息：</span>无</li>
						<li><span class="c-888">用途：</span>${bor.borrow_yt }</li>
						<li class="colspan"><span class="c-888 fl">投标进度：</span> <br>
							<div class="progress-bar fl">
								<span style="width:${bor.tb_money/bor.b_money*100 }%"></span>
							</div> <span class="c-green">${bor.tb_money/bor.b_money*100 }%</span></li>
						<li><span class="c-888">投资范围：</span> <span id="account_range">
								50元~ 不限 </span></li>
					</ul>
				</div>
				<c:choose>
					<c:when test="${bor.statu==10 }">
						<div class="mod-right mod-status" style="height: 240px;">
							<div class="inner">
								<div class="text">
									还可投：<span class="f24 c-333"><font color="red">${bor.b_money-bor.tb_money }</font></span>&nbsp;元<br>
								</div>
								您的账户余额:&nbsp;&nbsp;<font color="blue" size="4">${empty user.money?'0': user.money}</font>&nbsp;&nbsp;元
								&nbsp;&nbsp; &nbsp;&nbsp;
								<c:choose>
									<c:when test="${user.zsname!=''}">
										<a href="<%=path%>/selBank.action" style="cursor: pointer;"><font
											color="green" size="3">充值</font></a>
									</c:when>
									<c:otherwise>
										<a href="javascript:void(0);"
											onclick="alert('您未登录或者没有绑定身份信息!');" style="cursor: pointer;"><font
											color="green" size="3">充值</font></a>
									</c:otherwise>
								</c:choose>
								<br>
								<div class="mt15">
									请输入金额： <input type="text" name="borrow_yt" id="je"
										onkeyup="yjsy(this.value);" style="width: 135px;">&nbsp;元&nbsp;&nbsp;<a
										href="javascript:void(0);" style="cursor: pointer;"
										onclick="qt();"><font color="green" size="3">全投</font></a>
								</div>
								<div class="mt15">
									预计总收益为:&nbsp;&nbsp;<font id="fontsy" size="3" color="green">以实际投标收益为准!</font>
								</div>
								<div class="mt15">
									本息为:&nbsp;&nbsp;&nbsp;&nbsp;<font id="fontbx" size="3"
										color="green">以实际投标本息为准!</font>
								</div>
								<div class="mt15">
									<c:choose>
										<c:when test="${user.zsname!=''&&user.zsname!=null }">
											<a href="#" class="bor_btn"
												onclick="showSpan('alert-checkOldMobile');">立即投资</a>
										</c:when>
										<c:otherwise>
											<a href="#" class="bor_btn"
												onclick="alert('您没有登陆或者未绑定个人信息');">立即投资</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</c:when>
					<c:when test="${bor.statu==11 }">
						<div class="mod-right mod-status">
							<div class="inner">
								<i class="icon icon-status icon-status3"></i>
							</div>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="item-detail-body clearfix mrt30 ui-tab">
			<div class="ui-tab-nav hd">
				<i class="icon-cur" style="left: 39px;"></i>
				<ul>
					<li class="nav_li active" id="nav_1"><a href="javascript:;">借款信息</a></li>
					<li class="nav_li" id="nav_2"><a href="javascript:;">投资记录</a>
						<i class="icon icon-num1" style="margin-left: -15px;"> <span
							id="tender_times">23</span> <em></em>
					</i></li>
					<!-- 					<li class="nav_li" id="nav_3"><a href="javascript:;">还款列表</a></li> -->
				</ul>
			</div>
			<div class="bd">
				<div class="ui-tab-item active" style="display: block;">
					<div class="borrow-info">
						<dl class="item">
							<dt>
								<h3>VIP团介绍</h3>
							</dt>
							<dd>
								<div class="text">
									<p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;">
									</p>
									<p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;">
										${bor.borrow_sm }</p>
								</div>
							</dd>
						</dl>
						<dl class="item">
							<dt>
								<h3>审核信息</h3>
							</dt>
							<dd>
								<div class="verify clearfix">
									<ul>
										<li><i class="icon icon-4"></i><br> 身份证</li>
										<li><i class="icon icon-5"></i><br> 户口本</li>
										<li><i class="icon icon-6"></i><br> 结婚证</li>
										<li><i class="icon icon-7"></i><br> 工作证明</li>
										<li><i class="icon icon-8"></i><br> 工资卡流水</li>
										<li><i class="icon icon-9"></i><br> 收入证明</li>
										<li><i class="icon icon-10"></i><br> 征信报告</li>
										<li><i class="icon icon-11"></i><br> 亲属调查</li>
										<li><i class="icon icon-19"></i><br> 行驶证</li>
										<li><i class="icon icon-20"></i><br> 车辆登记证</li>
										<li><i class="icon icon-21"></i><br> 车辆登记发票</li>
										<li><i class="icon icon-22"></i><br> 车辆交强险</li>
										<li><i class="icon icon-23"></i><br> 车辆商业保险</li>
										<li><i class="icon icon-24"></i><br> 车辆评估认证</li>
									</ul>
								</div>
							</dd>
						</dl>


					</div>
				</div>
				<div class="ui-tab-item" style="display: none;">
					<div class="repayment-list">

						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tbody>
								<tr>
									<th>投标人</th>
									<th>投标金额</th>
									<th>投标时间</th>
									<th>投标方式</th>
								</tr>
							</tbody>
							<tbody id="repayment_content">
								<c:forEach items="${Tenders}" var="ten">
									<tr>
										<td>${fn:substring(ten.zsname,0,1)}**</td>
										<td><span class="c-orange">￥ ${ten.tender_money}</span></td>
										<td><fnt:formatDate value="${ten.tender_time }"
												pattern="yyyy-MM-dd HH:mm:ss"></fnt:formatDate></td>
										<td>自投</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
				</div>
				<div class="ui-tab-item" style="display: none;">
					<div class="repayment-list">
						已还本息：<span class="c-orange">0.00元</span>&nbsp;&nbsp; 待还本息：<span
							class="c-orange">40,400.00元</span>&nbsp;&nbsp;(待还本息因算法不同可能会存误差，实际金额以到账金额为准！)
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<th>合约还款日期</th>
									<th>期数</th>
									<th>应还本金</th>
									<th>应还利息</th>
									<th>应还本息</th>
									<th>还款状态</th>
								</tr>
								<tr>
									<td>2015-10-13</td>
									<td>1</td>
									<td>40,000.00元</td>
									<td>400.00元</td>
									<td>40,400.00元</td>
									<td>还款中</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--网站底部-->
	<div id="footer" class="ft">
		<div class="ft-inner clearfix">
			<div class="ft-helper clearfix">
				<dl>
					<dt>关于我们</dt>
					<dd>
						<a href="jianjie.jsp">公司简介</a><a href="tuandui.jsp">管理团队</a><a
							href="wangzhangonggao.jsp">网站公告</a>
					</dd>
				</dl>
				<dl>
					<dt>相关业务</dt>
					<dd>
						<a href="list.jsp">我要投资</a><a href="borrow.jsp">我要借款</a>
					</dd>
				</dl>
				<dl>
					<dt>帮助中心</dt>
					<dd>
						<a href="help.jsp">新手入门</a><a href="pesonal_index.jsp">我的账户</a><a
							href="list.jsp">债权转让</a>
					</dd>
				</dl>
				<dl>
					<dt>联系我们</dt>
					<dd>
						<a href="lianxi.jsp">联系我们</a>
					</dd>
				</dl>
			</div>
			<div class="ft-service">
				<dl>
					<dd>
						<p>
							<strong>400-660-1268</strong><br> 工作日 9:00-22:00<br>
							官方交流群:<em>12345678</em><br> 工作日 9:00-22:00 / 周六 9:00-18:00<br>
						</p>
						<div class="ft-serv-handle clearfix">
							<a class="icon-hdSprite icon-ft-sina a-move a-moveHover"
								title="团团赚新浪微博" target="_blank" href="#"></a><a
								class="icon-hdSprite icon-ft-qqweibo a-move a-moveHover"
								title="团团赚腾讯微博" target="_blank" href="#"></a><a
								class="icon-ft-qun a-move a-moveHover" title="团团赚QQ群"
								target="_blank" href="#"></a><a
								class="icon-hdSprite icon-ft-email a-move a-moveHover mrn"
								title="阳光易贷email" target="_blank" href="mailto:xz@yirenbao.com"></a>
						</div>
					</dd>
				</dl>
			</div>
			<div class="ft-wap clearfix">
				<dl>
					<dt>官方二维码</dt>
					<dd>
						<span class="icon-ft-erweima"><img
							src="<%=path%>/foregroundSystem/images/code.png"
							style="display: inline;"></span>
					</dd>
				</dl>
			</div>
		</div>
		<div class="ft-record">
			<div class="ft-approve clearfix">
				<a class="icon-approve approve-0 fadeIn-2s" target="_blank" href="#"></a><a
					class="icon-approve approve-1 fadeIn-2s" target="_blank" href="#"></a><a
					class="icon-approve approve-2 fadeIn-2s" target="_blank" href="#"></a><a
					class="icon-approve approve-3 fadeIn-2s" target="_blank" href="#"></a>
			</div>
			<div class="ft-identity">
				©2015 团团赚 All rights reserved&nbsp;&nbsp;&nbsp;<span
					class="color-e6">|</span>&nbsp;&nbsp;&nbsp;安徽省团团赚投资管理有限公司&nbsp;&nbsp;&nbsp;<span
					class="color-e6">|</span>&nbsp;&nbsp;&nbsp;<a target="_blank"
					href="http://www.jspsucai.com">皖ICP备12345678号-1</a>
			</div>
			`
		</div>
	</div>
	<!-- 立即投资弹框 -->
	<div class="alert-450" id="alert-checkOldMobile" style="display:none;">
		<div class="alert-title">
			<h3>立即投资</h3>
			<span class="alert-close"
				onclick="displaySpan('alert-checkOldMobile')"></span>
		</div>
		<div class="alert-main">
			<form id="checkOldMobileForm" name="checkOldMobileForm" method="post"
				action="<%=path%>/Borrow/borrowVIPTZ.action"
				enctype="application/x-www-form-urlencoded">
				<ul>
					<li style="margin-top: 15px"><label class="txt-name">请选择支付方式:</label>
						<select id="selectcard" name="zffs">
							<option value="余额支付">余额支付</option>
							<c:forEach items="${ttzbs}" varStatus="" var="tba">
								<option value="${tba.bankcard },${tba.bkmoney}">${tba.banktype }
									${tba.bankcard }</option>
							</c:forEach>
					</select> <br /> <br /></li>
					<input type="hidden" name="tzje" id="tzje" />
					<input type="hidden" name="b_id" value="${bor.b_id}" />
					<li style="margin-top: 15px"><label class="txt-name">请输入支付密码:</label>
						<input type="text" id="mima" class="txt220" maxlength="30"
						style="width:250px" placeholder="请输入支付密码"
						onkeyup="yzmima(this.value);"> <br /> <br /></li>

					<li><span class="txt-right" style="display: none;" id="errors"><i
							class="error-icon"></i><i class="error-tip" id="errorsmsg"></i></span><br>
						<input type="button" value="确 认" class="btn-ok txt-right"
						onclick="tijiao();"></li>
				</ul>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		//<![CDATA[
		//投资金额不能空
		function showSpan(op) {
			var tzje = $('#je').val();
			var hktz = '${bor.b_money-bor.tb_money}';
			if (isNaN(tzje)) {
				alert("请输入数字!");
			} else if (parseFloat(tzje) > parseFloat(hktz)) {
				alert('投资金额不能大于可投资金额!');
			} else if (parseFloat(tzje) == "") {
				alert('投资金额不能为空!');
			} else if (parseFloat(tzje) < 50) {
				alert('投资金额不能小于50!');
			} else {
				//显示弹出框
				$("body").append("<div id='mask'></div>");
				$("#mask").addClass("mask").css("display", "block");
				$("#" + op).css("display", "block");
			}
		}
	
		function displaySpan(op) {
			$("#mask").css("display", "none");
			$("#" + op).css("display", "none");
		}
	
		//全投
		function qt() {
			if ('${user.money}' > '${bor.b_money-bor.tb_money}') {
				$('#je').val('${bor.b_money-bor.tb_money}');
			}
			if ('${user.money}' < '${bor.b_money-bor.tb_money}') {
				$('#je').val('${user.money}');
			}
		}
		//验证密码
		function yzmima(val) {
			if (val != '${user.zpwd}') {
				$("#errors").css("display", "");
				$("#errorsmsg").html("密码错误!");
			} else {
				$("#errors").css("display", "");
				$("#errorsmsg").html("密码输入正确!");
			}
		}
		function tijiao() {
			var aa = $("#selectcard").val(); //下拉框的值
			//alert(aa);
			var je = $('#je').val(); //投资金额
			var bb = aa.split(",")[1]; //银行卡余额
			var cc = '${user.money}'; //我的余额
			if (aa == '余额支付') {
				if (parseInt(cc) < parseInt(je)) { //余额小于投资金额
					$("#errors").css("display", "");
					$("#errorsmsg").html("余额不足!");
				} else { //可以投资
					if ($("#mima").val() != '${user.zpwd}') {
						$("#errors").css("display", "");
						$("#errorsmsg").html("密码错误!");
					} else if ($("#mima").val() == '') {
						$("#errors").css("display", "");
						$("#errorsmsg").html("请输入密码");
					} else {
						$('#tzje').val(je);
						$("#checkOldMobileForm").submit();
					}
				}
			} else if (aa != '余额支付') {
				//alert("不余额支付" + bb + je);
				if (parseInt(bb) < parseInt(je)) { //银行卡余额小于投资金额
					$("#errors").css("display", "");
					$("#errorsmsg").html("此银行卡余额不足!");
				} else { //可以投资
					if ($("#mima").val() != '${user.zpwd}') {
						$("#errors").css("display", "");
						$("#errorsmsg").html("密码错误!");
					} else if ($("#mima").val() == '') {
						$("#errors").css("display", "");
						$("#errorsmsg").html("请输入密码");
					} else {
						$('#tzje').val(je);
						$("#checkOldMobileForm").submit();
					}
				}
			}
		}
	</script>
</body>
</html>
