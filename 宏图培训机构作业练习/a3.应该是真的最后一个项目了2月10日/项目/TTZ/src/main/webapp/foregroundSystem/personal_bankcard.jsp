<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="${pageContext.request.contextPath}/foregroundSystem/css/common.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/foregroundSystem/css/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/foregroundSystem/css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/foregroundSystem/script/common.js"></script>
<script
	src="${pageContext.request.contextPath}/foregroundSystem/script/user.js"
	type="text/javascript"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
</head>
<script type="text/javascript">
	//<![CDATA[
	function showSpan(op) {
		$("#updateMonbileForm\\:updateMonbileFormauthCode").val("");
		if (op == 'alert-updateEmail') {
			var bool = $("#authenticationMobile").val();
			if (bool == 'true') {
				$("#alert-main").css("display", "none");
				$("#alert-main2").css("display", "block");
			}
		}
		$("body").append("<div id='mask'></div>");
		$("#mask").addClass("mask").css("display", "block");

		$("#" + op).css("display", "block");
	}

	function displaySpan(op) {
		clearInputValue();
		$("#mask").css("display", "none");
		$("#" + op).css("display", "none");
	}

	function displaySpan2() {
		$("#mask").css("display", "none");
		$("#alert-updateEmail").css("display", "none");

		$("body").append("<div id='mask'></div>");
		$("#mask").addClass("mask").css("display", "block");

		$("#alert-checkMobile").css("display", "block");
	}

	function clearInputValue() {
		$("#checkMonbileForm\\:mobileNumber").val("");
		$("#checkMonbileForm\\:authCode").val("");
		$("#checkMonbileForm\\:mobileNumber_message").remove();
		$("#checkMonbileForm\\:authCode_message").remove();

		//修改手机号-验证原手机号
		$("#checkOldMobileForm\\:checkOldMobileFormauthCode_message").remove();
		$("#checkOldMobileForm\\:checkOldMobileFormauthCode").val("");

		$("#updateMonbileForm\\:mobileNumber2").val("");
		$("#updateMonbileForm\\:updateMonbileFormauthCode").val("");
		$("#updateMonbileForm\\:mobileNumber2_message").remove();
		$("#updateMonbileForm\\:updateMonbileFormauthCode_message").remove();

		$("#changeEmailForm\\:newEmail").val("");
		$("#changeEmailForm\\:changeEmailFormauthCode").val("");
		$("#changeEmailForm\\:newEmail_message").remove();
		$("#changeEmailForm\\:changeEmailFormauthCode_message").remove();

		//修改密码提示消息
		$("#updatePassForm\\:oldPassword").val("");
		$("#updatePassForm\\:password").val("");
		$("#updatePassForm\\:repassword").val("");

		$("#updatePassForm\\:oldPassword_message").remove();
		$("#updatePassForm\\:password_message").remove();
		$("#repassword_message").remove();
	}
</script>
<body>

	<header>
	<div class="header-top min-width">
		<div class="container fn-clear">
			<strong class="fn-left">咨询热线：400-848-6698<span
				class="s-time">服务时间：9:00 - 18:00</span></strong>
			<ul class="header_contact">
				<li class="c_1"><a class="ico_head_weixin" id="wx"></a>
					<div class="ceng" id="weixin_xlgz" style="display: none;">
						<div class="cnr">
							<img
								src="${pageContext.request.contextPath}/foregroundSystem/images/code.png">
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
				<a class="" href="/"> <img
					src="${pageContext.request.contextPath}/foregroundSystem/images/logo.png"
					title="">
				</a>
			</div>
			<ul class="top-nav fn-clear">
				<li><a href="<%=path%>/Borrow/selBorrowMoneySomeList.action">首页</a></li>
				<li><a
					href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
					class="">我要投资</a></li>
				<li class="on"><a href="<%=path%>/foregroundSystem/borrow.jsp"
					class="">我要借款</a></li>
				<li><a href="<%=path%>/foregroundSystem/help.jsp">安全保障</a></li>
				<li class="top-nav-safe"><a href="<%=path%>/SelHuiKuan.action">我的账户</a></li>
				<li><a href="<%=path%>/foregroundSystem/jianjie.jsp">关于我们</a></li>
			</ul>
		</div>
	</div>

	</header>
	<!--个人中心-->
	<div class="wrapper wbgcolor">
		<div class="w1200 personal">
			<div class="credit-ad">
				<img
					src="${pageContext.request.contextPath}/foregroundSystem/images/clist1.jpg"
					width="1200" height="96">
			</div>
			<div id="personal-left" class="personal-left">
				<ul>
					<li><span><a href="<%=path%>/SelHuiKuan.action"><i
								class="dot dot1"></i>账户总览</a></span></li>
					<li><span><a
							style="font-size:14px;text-align:center;width:115px;padding-right:35px;"
							href="<%=path%>/mr_list.action">资金记录</a></span></li>
					<li><span><a
							style="font-size:14px;text-align:center;width:115px;padding-right:35px;"
							href="<%=path%>/TenderRecordList.action">投资记录</a></span></li>
					<li><span><a
							style="font-size:14px;text-align:center;width:115px;padding-right:35px;"
							href="<%=path%>/Borrow/selBorrowMoney.action">借款记录</a></span></li>
					<li class="pleft-cur"><span><a
							href="${pageContext.request.contextPath}/bank/selbank.action"><i
								class="dot dot02"></i>银行卡管理</a> </span></li>
					<li><span><a href="<%=path%>/selBank.action"><i
								class="dot dot03"></i>充值</a></span></li>
					<li class=""><span><a
							href="<%=path%>/foregroundSystem/personal_tixian_1.jsp"><i
								class="dot dot04"></i>提现</a></span></li>
					<li style="position:relative;"><span> <a
							href="<%=path%>/foregroundSystem/personal_xitongxiaoxi.jsp"><i
								class="dot dot08"></i>系统信息 </a>
					</span></li>
					<li><span><a
							href="<%=path%>/foregroundSystem/personal_zhanghushezhi.jsp"><i
								class="dot dot09"></i>账户设置</a></span></li>
					<li><span><a
							href="${pageContext.request.contextPath}/rengzheng/sel.action"><i
								class="dot dot09"></i>资料上传</a></span></li>
				</ul>
			</div>
			<div class="personal-main">
				<div class="personal-pay">
					<h3>
						<i>银行卡管理</i>
					</h3>
					<div>
						<ul style="margin-top:40px;list-style: none;padding-left: 50px">
							<c:forEach items="${banklist }" var="bank">
								<c:choose>
									<c:when test="${bank.banktype == '建设银行' }">
										<li style="float: left;padding: 40px">
											<div class="Withdrawalss clearfix">
												<div class="item"
													style="float:left; width:228px; height:128px; margin:10px 15px 10px 0; border:1px solid #e0e0e0;-webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; text-align:center; cursor:pointer;">
													<div class="card-num"
														style="height:32px; line-height:32px; border-bottom:1px solid #e0e0e0; background:#f5f5f5;">${bank.bankcard }</div>
													<div class="img"
														style="height:95px; vertical-align:middle;">
														<img
															src="${pageContext.request.contextPath}/foregroundSystem/images/bank4.jpg" />
													</div>
												</div>
											</div>
										</li>
									</c:when>

									<c:when test="${bank.banktype == '工商银行' }">
										<li style="float: left;padding: 40px">
											<div class="Withdrawalss clearfix">
												<div class="item"
													style="float:left; width:228px; height:128px; margin:10px 15px 10px 0; border:1px solid #e0e0e0;-webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; text-align:center; cursor:pointer;">
													<div class="card-num"
														style="height:32px; line-height:32px; border-bottom:1px solid #e0e0e0; background:#f5f5f5;">${bank.bankcard }</div>
													<div class="img"
														style="height:95px; vertical-align:middle;">
														<img
															src="${pageContext.request.contextPath}/foregroundSystem/images/bank1.png" />
													</div>
												</div>
											</div>
										</li>
									</c:when>

									<c:when test="${bank.banktype == '农业银行' }">
										<li style="float: left;padding: 40px">
											<div class="Withdrawalss clearfix">
												<div class="item"
													style="float:left; width:228px; height:128px; margin:10px 15px 10px 0; border:1px solid #e0e0e0;-webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; text-align:center; cursor:pointer;">
													<div class="card-num"
														style="height:32px; line-height:32px; border-bottom:1px solid #e0e0e0; background:#f5f5f5;">${bank.bankcard }</div>
													<div class="img"
														style="height:95px; vertical-align:middle;">
														<img
															src="${pageContext.request.contextPath}/foregroundSystem/images/bank2.png" />
													</div>
												</div>
											</div>
										</li>
									</c:when>
									<c:when test="${bank.banktype == '招商银行' }">
										<li style="float: left;padding: 40px">
											<div class="Withdrawalss clearfix">
												<div class="item"
													style="float:left; width:228px; height:128px; margin:10px 15px 10px 0; border:1px solid #e0e0e0;-webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; text-align:center; cursor:pointer;">
													<div class="card-num"
														style="height:32px; line-height:32px; border-bottom:1px solid #e0e0e0; background:#f5f5f5;">${bank.bankcard }</div>
													<div class="img"
														style="height:95px; vertical-align:middle;">
														<img
															src="${pageContext.request.contextPath}/foregroundSystem/images/bank3.png" />
													</div>
												</div>
											</div>
										</li>
									</c:when>
								</c:choose>
							</c:forEach>

							<li style="float: left;padding: 40px"><img alt="点击添加"
								src="${pageContext.request.contextPath}/foregroundSystem/images/bank.png"
								style="width:228px; height:128px;"
								onclick="showSpan('alert-checkOldMobile')"></li>
						</ul>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

		<div class="alert-450" id="alert-checkOldMobile" style="display:none;">
			<div class="alert-title">
				<h3>绑定银行卡</h3>
				<span class="alert-close"
					onclick="displaySpan('alert-checkOldMobile')"></span>
			</div>
			<div class="alert-main">
				<form id="checkOldMobileForm" name="checkOldMobileForm"
					method="post" action="#"
					enctype="application/x-www-form-urlencoded">
					<input type="hidden" value="${pageContext.request.contextPath}"
						id="path">
					<ul>
						<li style="margin-top: 15px"><label class="txt-name">身份证号：</label>
							<input type="text" id="pcard" class="txt220" maxlength="30"
							style="width:250px" placeholder="请输身份证号"></li>
						<li style="margin-top: 15px"><label class="txt-name">银行卡号：</label>
							<input type="text" id="bankcard" class="txt220" maxlength="30"
							style="width:250px" placeholder="请输入银行卡号"><br /> <br /></li>

						<li><span class="txt-right" style="display: none;"
							id="errors"><i class="error-icon"></i><i class="error-tip">你输入的信息有误重新输入</i></span><br>
							<input type="button" value="确 认" class="btn-ok txt-right"
							onclick="bankcards();"></li>
					</ul>

				</form>
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
					<a class="icon-approve approve-0 fadeIn-2s" target="_blank"
						href="#"></a><a class="icon-approve approve-1 fadeIn-2s"
						target="_blank" href="#"></a><a
						class="icon-approve approve-2 fadeIn-2s" target="_blank" href="#"></a><a
						class="icon-approve approve-3 fadeIn-2s" target="_blank" href="#"></a>
				</div>
				<div class="ft-identity">
					©2015 团团赚 All rights reserved&nbsp;&nbsp;&nbsp;<span
						class="color-e6">|</span>&nbsp;&nbsp;&nbsp;安徽省团团赚投资管理有限公司&nbsp;&nbsp;&nbsp;<span
						class="color-e6">|</span>&nbsp;&nbsp;&nbsp;<a target="_blank"
						href="http://www.jspsucai.com">皖ICP备12345678号-1</a>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			function bankcards() {
				var pcard = $("#pcard").val();
				var bankcard = $("#bankcard").val();
				var path = $("#path").val();
				$.post(path + "/bank/add.action", {
					pcard : pcard,
					bankcard : bankcard
				}, function(data) {
					if (data.boolean) {
						location.href = path + "/bank/selbank.action";
					} else {
						$("#errors").css("display", "block");
					}
				}, "json");
			}
		</script>
</body>
</html>

