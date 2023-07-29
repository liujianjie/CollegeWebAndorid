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
	href="${pageContext.request.contextPath}/foregroundSystem/css/style2.css" />
<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/user.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/foregroundSystem/css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/foregroundSystem/script/common.js"></script>
<script
	src="${pageContext.request.contextPath}/foregroundSystem/script/user.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<script src="<%=path%>/foregroundSystem/script/user.js"
	type="text/javascript"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
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
							<img src="images/code.png">
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
				<a class="" href="index.jsp"> <img src="images/logo.png"
					title="">
				</a>
			</div>
			<ul class="top-nav fn-clear">
				<li class="on"><a href="index.jsp">首页</a></li>
				<li><a href="list.jsp" class="">我要投资</a></li>
				<li><a href="borrow.jsp" class="">我要借款</a></li>
				<li><a href="help.jsp">安全保障</a></li>
				<li class="top-nav-safe"><a href="pesonal_index.jsp">我的账户</a></li>
				<li><a href="jianjie.jsp">关于我们</a></li>
			</ul>
		</div>
	</div>
	</header>
	<!--个人中心-->
	<div class="wrapper wbgcolor">
		<div class="w1200 personal">
			<div class="credit-ad">
				<img src="images/clist1.jpg" width="1200" height="96">
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
					<li class=""><span><a
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
					<li class="pleft-cur"><span><a
							href="<%=path%>/foregroundSystem/personal_zhanghushezhi.jsp"><i
								class="dot dot09"></i>账户设置</a></span></li>
					<li><span><a
							href="${pageContext.request.contextPath}/rengzheng/sel.action"><i
								class="dot dot09"></i>资料上传</a></span></li>
				</ul>
			</div>
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
				//]]>
			</script>
			<style type="text/css">
.txt235 {
	height: 38px;
	border: 1px solid #ccc;
}
</style>
			<script type="text/javascript">
				//<![CDATA[
				$(function() {
					var type = getUrlParam();
					if (type == '2') {
						showSpan('alert-updateMobile'); //绑定手机号
					} else if (type == '3') {
						showSpan('alert-activeEmail'); //激活邮箱
					} else if (type == '4') {
						showSpan('alert-activeEmailMsg'); //激活邮箱后提醒
					} else if (type == '5') {
						showSpan('alert-checkOldMobile');
					} else if (type == '6') {
						showSpan('alert-updateEmail');
					}
					//修改手机时，不显示原手机号
					document.getElementById("updateMonbileForm:mobileNumber2").value = '';
					//进度条样式
					if ($.browser.mozilla) {
						$("i[class='grzxbg level3']").css(
							{
								backgroundPosition : "0px -550px",
								border : "none",
								margin : "37px 0px 0px 20px",
								height : "17px"
							}
						);
					} else {
						$("i[class='grzxbg level3']").css(
							{
								border : "none",
								margin : "37px 0px 0px 20px",
								height : "17px"
							}
						);
						$("i[class='grzxbg level3']").css({
							"background-position-x" : "0px",
							"background-position-y" : "-550px"
						});
					}
					//$("#activeEmail\\:activeEmailemail").attr({"readOnly":"true"});
					"";
				});
				//]]>
			</script>
			<div class="personal-main">
				<div class="personal-zhsz">
					<input type="hidden" value="${pageContext.request.contextPath}"
						id="path">
					<h3>
						<i>账户设置</i>
					</h3>
					<div class="personal-level">
						<span class="wzd">您的账户完整度</span><i class="grzxbg level3"
							style="border: none; margin: 37px 0px 0px 20px; height: 17px; background-position: 0px -550px;"></i><span
							class="state">[中]</span> <i id="zhwzd" class="markicon fl mt35"></i><span
							class="arrow-personal">请尽快完成账户安全设置，以确保您的账户安全</span><span
							class="grzxbg icon-personal"></span>
					</div>
					<ul>
						<li><i class="grzxbg p-right"></i><span class="zhsz-span1">手机号</span><span
							class="zhsz-span2">${user.tel }</span><span class="zhsz-span3"><a
								href="javascript:void(0)"
								onclick="showSpan('alert-checkOldMobile')">更改</a></span></li>
						<li><c:choose>
								<c:when test="${user.zsname == null || user.zsname eq '' }">
									<i class="grzxbg p-danger"></i>
								</c:when>
								<c:otherwise>
									<i class="grzxbg p-right"></i>
								</c:otherwise>
							</c:choose> <span class="zhsz-span1">身份认证</span><span class="zhsz-span2">
								<c:choose>
									<c:when test="${user.zsname == null || user.zsname eq '' }">
								未认证
								</c:when>
									<c:otherwise>
								${user.zsname }
								</c:otherwise>
								</c:choose>


						</span> <c:choose>
								<c:when test="${user.zsname == null || user.zsname eq '' }">
									<span class="zhsz-span3"><a href="#"
										onclick="showSpan('alert-updateUser')">认证</a></span>
								</c:when>
							</c:choose></li>

						<li><c:choose>
								<c:when test="${user.zpwd == null || user.zpwd eq '' }">
									<i class="grzxbg p-danger"></i>
								</c:when>
								<c:otherwise>
									<i class="grzxbg p-right"></i>
								</c:otherwise>
							</c:choose> <span class="zhsz-span1">支付密码</span> <span class="zhsz-span2">
								<c:if test="${user.zpwd == null || user.zpwd eq ''  }">
							未设置
						</c:if> <c:if test="${user.zpwd != null && user.zpwd != ''  }">
							******
						</c:if>
						</span> <span class="zhsz-span3"> <c:if
									test="${user.zpwd == null || user.zpwd eq ''  }">
									<a href="#" onclick="showSpan('alert-updateEmail')">设置</a>
								</c:if>
						</span></li>
						<li><i class="grzxbg p-right"></i> <span class="zhsz-span1">电子邮箱</span>
							<span class="zhsz-span2"> <c:if
									test="${user.email == null || user.email eq '' }">
							未绑定
							</c:if> <c:if test="${user.email != null && user.email != '' }">
							${user.email }
							</c:if>
						</span> <span class="zhsz-span3"> <a href="#"
								onclick="showSpan('alert-updateEmail2')">更改</a>
						</span></li>
						<li><i class="grzxbg p-right"></i><span class="zhsz-span1">登录密码</span><span
							class="zhsz-span2">******</span><span class="zhsz-span3"><a
								href="javascript:void(0)" onclick="showSpan('alert-updatePass')">更改</a></span></li>
					</ul>
				</div>
			</div>




			<div class="alert-450" id="alert-checkOldMobile"
				style="display:none;">
				<div class="alert-title">
					<h3>修改手机</h3>
					<span class="alert-close"
						onclick="displaySpan('alert-checkOldMobile')"></span>
				</div>
				<div class="alert-main">
					<form id="checkOldMobileForm" name="checkOldMobileForm"
						method="post" action="#"
						enctype="application/x-www-form-urlencoded">
						<input type="hidden" name="checkOldMobileForm"
							value="checkOldMobileForm">
						<ul>
							<li><label class="txt-name">原手机号</label> <label
								id="checkOldMobileForm:oldMobileNumber" class="txt240">
									${user.tel }</label></li>
							<li><label class="txt-name">新手机号：</label> <input id="tel"
								type="text" name="tel" style="width: 250px" maxlength="20"
								placeholder="请输入正确的手机号">
							<li><span class="txt-right" id="error1"
								style="display:none;"><i class="error-icon"></i><i
									class="error-tip">手机号错误请重新输入</i></span><br> <input type="button"
								name="checkOldMobileForm:j_idt129" value="确 认"
								class="btn-ok txt-right" onclick="updatetel()"></li>
						</ul>

					</form>
				</div>
			</div>



			<div class="alert-450" id="alert-updateEmail" style="display:none;">
				<div class="alert-title">
					<h3>设置支付密码</h3>
					<span class="alert-close"
						onclick="displaySpan('alert-updateEmail')"></span>
				</div>
				<div class="alert-main" id="alert-main">
					<form id="signupForm" name="changeEmailForm" method="post"
						action="${pageContext.request.contextPath}/user/updatezpwd.action">
						<ul>
							<li><label class="txt-name">支付密码</label> <input id="zpwd"
								type="password" name="zpwd" class="txt235" placeholder="请输入支付密码"
								datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！">
								<div id="newEmailErrorDiv" class="alert-error120"></div></li>

							<li><label class="txt-name">确认密码</label> <input id="rzpwd"
								type="password" name="rzpwd" class="txt235"
								placeholder="请再次输入支付密码" datatype="*" recheck="zpwd"
								nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！">
								<div id="newEmailErrorDiv" class="alert-error120"></div></li>

							<li><input type="submit" name="changeEmailForm:j_idt150"
								value="确　认" class="btn-ok txt-right"></li>
						</ul>

					</form>
				</div>

			</div>


			<div class="alert-450" id="alert-updateEmail2" style="display:none;">
				<div class="alert-title">
					<h3>设置邮箱</h3>
					<span class="alert-close"
						onclick="displaySpan('alert-updateEmail2')"></span>
				</div>
				<div class="alert-main" id="alert-main">
					<form id="signupForms" name="changeEmailForm" method="post"
						action="${pageContext.request.contextPath}/user/updateemail.action">
						<ul>
							<li><label class="txt-name">邮箱：</label> <input id="email"
								type="text" name="email" class="txt235" placeholder="请输入邮箱"
								datatype="/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/"
								nullmsg="请设置邮箱">
								<div id="newEmailErrorDiv" class="alert-error120"></div></li>

							<li><input type="submit" name="changeEmailForm:j_idt150"
								value="确　认" class="btn-ok txt-right"></li>
						</ul>
					</form>
				</div>

			</div>


			<div class="alert-450" id="alert-updatePass" style="display: none;">
				<div class="alert-title">
					<h3>修改密码</h3>
					<span class="alert-close" onclick="displaySpan('alert-updatePass')"></span>
				</div>
				<div class="alert-main">
					<form id="signupFormss" method="post"
						action="${pageContext.request.contextPath}/user/updatepwd.action"
						onsubmit=" return chrckpwd();">
						<input type="hidden" name="updatePassForm" value="updatePassForm">
						<ul>
							<li><label class="txt-name">请输入原密码</label> <input id="pwd"
								type="password" name="pwd" value="" maxlength="20"
								class="txt235" datatype="*">
								<div id="oldPasswordErrorDiv" class="alert-error120"></div></li>
							<li style="margin-top: 20px"><label class="txt-name">请输入新密码</label>
								<input id="newpwd" type="password" name="newpwd" value=""
								maxlength="20" class="txt235" datatype="*">
								<div id="passwordErrorDiv" class="alert-error120"></div></li>
							<li style="margin-top: 20px"><label class="txt-name">请确认新密码</label>
								<input id="rnewpwd" type="password"
								name="updatePassForm:repassword" value="" maxlength="20"
								class="txt235" datatype="*" recheck="newpwd">
								<div id="repasswordErrorDiv" class="alert-error120"></div></li>
							<li><span class="txt-right" id="error3"
								style="display:none;"><i class="error-icon"></i><i
									class="error-tip">原密码错误请重新输入</i></span><br> <input type="submit"
								name="updatePassForm:j_idt174" value="确 认"
								class="btn-ok btn-235 txt-right"></li>
						</ul>
						<input type="hidden" value="${user.pwd }" id="sessionpwd">
					</form>
				</div>
			</div>

			<div class="alert-450" id="alert-updateUser" style="display: none;">
				<div class="alert-title">
					<h3>身份认证</h3>
					<span class="alert-close" onclick="displaySpan('alert-updateUser')"></span>
				</div>
				<div class="alert-main">
					<form id="updatePassForm" name="updatePassForm" method="post"
						action="" enctype="application/x-www-form-urlencoded">
						<input type="hidden" name="updatePassForm" value="updatePassForm">
						<ul>
							<li><label class="txt-name">真实姓名：</label> <input id="zsname"
								type="text" name="zsname" value="" maxlength="20" class="txt235">
								<div id="oldPasswordErrorDiv" class="alert-error120"></div></li>
							<li style="margin-top: 20px"><label class="txt-name">身份证号：</label>
								<input id="pcard" type="text" name="pcard" value=""
								maxlength="20" class="txt235">
								<div id="passwordErrorDiv" class="alert-error120"></div></li>

							<li style="margin-top: 20px"><span class="txt-right"
								id="error2" style="display:none;"><i class="error-icon"></i><i
									class="error-tip">信息错误请重新输入</i></span><br> <input type="button"
								name="updatePassForm:j_idt174" value="确 认"
								class="btn-ok btn-235 txt-right" onclick="updatezsname();"></li>
						</ul>
					</form>
				</div>
			</div>

			<div class="clear"></div>
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
		</div>
	</div>
</body>
<script
	src="${pageContext.request.contextPath}/foregroundSystem/script/Validform_v5.3.2_min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function updatetel() {
		var tel = $("#tel").val();
		var path = $("#path").val();
		if (tel == null || tel == "") {
			$("#error1").css("display", "block");
			setTimeout("$('#error1').css('display','none')", 3000);
		} else {
			$.post(path + "/user/updatetel.action", {
				tel : tel
			}, function(date) {
				if (date.boolean) {
					location.href = path + "/foregroundSystem/personal_zhanghushezhi.jsp"
				} else {
					$("#error1").css("display", "block");
					setTimeout("$('#error1').css('display','none')", 3000);
				}
			}, "json");
		}
	}

	function updatezsname() {
		var zsname = $("#zsname").val();
		var pcard = $("#pcard").val();
		var path = $("#path").val();
		alert(zsname + "\t" + pcard);
		if (zsname == "" || pcard == "") {
			$("#error2").css("display", "block");
		} else {
			$.post(path + "/user/updatezsname.action", {
				zsname : zsname,
				pcard : pcard
			}, function(date) {
				if (date.boolean) {
					location.href = path + "/foregroundSystem/personal_zhanghushezhi.jsp";
				} else {
					$("#error2").css("display", "block");
					setTimeout("$('#error2').css('display','none')", 3000);
				}
			}, "json");
		}
	}
	$("#signupForm").Validform({
		tiptype : 5
	});
	$("#signupForms").Validform({
		tiptype : 5
	});
	$("#signupFormss").Validform({
		tiptype : 5
	});

	function chrckpwd() {
		var pwd = $("#pwd").val();
		var newpwd = $("#newpwd").val();
		var sessionpwd = $("#sessionpwd").val();

		if (pwd != sessionpwd) {
			$("#error3").css("display", "block");
			setTimeout("$('#error3').css('display','none');", 3000);
			return false;
		} else {
			return true;
		}
	}
</script>
</html>
