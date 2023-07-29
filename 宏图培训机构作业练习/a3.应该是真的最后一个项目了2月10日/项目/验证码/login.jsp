<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>团团赚网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="${pageContext.request.contextPath}/foregroundSystem/css/common.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/foregroundSystem/css/register.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/foregroundSystem/script/common.js"></script>
<script
	src="${pageContext.request.contextPath}/foregroundSystem/script/login.js"
	type="text/javascript"></script>
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
	<!--注册-->
	<div class="wrap">
		<form id="LonginForm" name="LonginForm" action="" method="post">
			<div class="tdbModule loginPage">
				<div class="registerTitle">用户登录</div>
				<div class="registerCont">
					<input type="hidden" value="${pageContext.request.contextPath}"
						id="path">
					<ul>

						<li class="error"><span id="errors" style="display: none"><span>用户名或密码错误</span></span>
						</li>

						<li><span class="dis">用户名：</span><input class="input"
							type="text" name="username" id="username" maxlength="24"
							tabindex="1" autocomplete="off"> <a href="#" class="blue">注册用户</a></li>

						<li><span class="dis">密码：</span><input class="input"
							type="password" name="pwd" id="pwd" maxlength="24" tabindex="1"
							autocomplete="off"> <a href="#" id="pawHide" class="blue">忘记密码</a></li>
						<li><span class="dis">验证码：</span><input type="text"
							id="PictureCheckCode" onblur="checkcode()" style="width:166px;"
							class="input" name="yzm" data-msg="验证码" maxlength="4"
							tabindex="1" autocomplete="off"> <img id="PictureCheck"
							src="<%=path%>/Getcode.action" onclick="myReload();" /> <a
							href="javascript:void(0);" onclick="myReload();" class="blue">看不清？换一张</a></li>
						<li class="btn"><input type="button" class="radius1"
							value="立即登录" id="submitBtn" onclick="login()"></li>
					</ul>
				</div>
			</div>
		</form>
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
	<script type="text/javascript">
		function checkcode() {
			var code = $("#PictureCheckCode").val();
			var path = $("#path").val();
	
			$.post(path + "/getsession.action", {}, function(data) {
				if (data.session != code) {
					alert(data.session + "验证码错误！");
					$("#PictureCheckCode").val("");
				}
			}, "json");
	
		}
		function myReload() {
			document.getElementById("PictureCheck").src = document.getElementById("PictureCheck").src + "?nocache=" + new Date().getTime();
		}
	</script>
	<script type="text/javascript">
	
		//按键登录   支持火狐
		document.onkeydown = function(event) {
			e = event ? event : (window.event ? window.event : null);
			var currKey = 0;
			currKey = e.keyCode || e.which || e.charCode;
			if (currKey == 13) {
				login();
			}
		};
	
		function login() {
			var path = $("#path").val();
			var username = $("#username").val();
			var pwd = $("#pwd").val();
			var PictureCheckCode = $("#PictureCheckCode").val();
			$.post(path + "/user/login.action", {
				username : username,
				pwd : pwd
			}, function(date) {
				var boo = date.boolean;
				if (boo) {
					location.href = "${pageContext.request.contextPath }/Borrow/selBorrowMoneySomeList.action";
				} else {
					$("#errors").css("display", "block");
					setTimeout('$("#errors").css("display","none")', 3000);
				}
			}, "json");
		}
	</script>
</body>
</html>

