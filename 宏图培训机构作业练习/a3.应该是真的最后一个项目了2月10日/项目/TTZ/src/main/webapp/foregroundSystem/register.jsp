<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="${pageContext.request.contextPath}/foregroundSystem/css/common.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/foregroundSystem/css/register.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/foregroundSystem/css/style2.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/foregroundSystem/script/common.js"></script>
<script src="script/login.js"
	type="${pageContext.request.contextPath}/foregroundSystem/text/javascript"></script>
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
			<ul class="fn-right header-top-ul">
				<li><a href="<%=path%>/Borrow/selBorrowMoneySomeList.action"
					class="app">返回首页</a></li>
				<li>
					<div class="">
						<a href="<%=path%>/foregroundSystem/register.jsp" class="c-orange"
							title="免费注册">免费注册</a>
					</div>
				</li>
				<li>
					<div class="">
						<a href="<%=path%>/foregroundSystem/login.jsp" class="js-login"
							title="登录">登录</a>
					</div>
				</li>
			</ul>
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
	<!--注册-->
	<div class="wrap">
		<div class="tdbModule register">
			<div class="registerTitle">注册账户</div>
			<div class="registerLc1">
				<p class="p1">填写账户信息</p>
				<p class="p2">验证手机信息</p>
				<p class="p3">注册成功</p>
			</div>
			<div class="registerCont">
				<form method="post"
					action="${pageContext.request.contextPath}/user/zhuce.action"
					id="myform">
					<input type="hidden" value="${pageContext.request.contextPath}"
						id="path">
					<ul>
						<li><span class="dis">用户名:</span> <input type="text"
							name="username" id="userName" class="input _userName"
							maxlength="24" tabindex="1"
							datatype="/^[0-9a-zA-Z\u4e00-\u9fa5_]{2,16}$/" nullmsg="请输入用户名！"
							errormsg="用户名范围在2~16位之间！不支持符号!"
							ajaxurl="<%=path%>/user/YanZhengUsername.action"
							placeholder="请在这里输入用户名" style="padding-left: 10px;"></li>
						<li><span class="dis">密码:</span> <input type="password"
							name="pwd" id="pwd" class="input _password" maxlength="24"
							tabindex="1" datatype="*6-16" nullmsg="请设置密码！"
							errormsg="密码范围在6~16位之间！" placeholder="6-24个字符，英文、数字组成，区分大小写"
							style="padding-left: 10px;"></li>
						<li><span class="dis">确认密码:</span> <input type="password"
							name="repeatPwd" id="repeatPassword"
							class="input _repeatPassword" maxlength="24" tabindex="1"
							datatype="*" recheck="pwd" nullmsg="请再输入一次密码！"
							errormsg="您两次输入的账号密码不一致！" placeholder="请再次输入密码"
							style="padding-left: 10px;"></li>
						<li><span class="dis">验证码:</span> <input type="text"
							id="PictureCheckCode" onblur="checkcode();"
							class="input input1 _yanzhengma" name="yzm" maxlength="4"
							tabindex="1" placeholder="请输入验证码" datatype="*" errormsg="请输入验证码!"
							nullmsg="请输入验证码!" style="padding-left: 10px;"><img
							id="PictureCheck" src="<%=path%>/Getcode.action"
							onclick="myReload();" />&nbsp;&nbsp;&nbsp;<a
							href="javascript:void(0);" style="cursor:pointer;"
							onclick="myReload();"><font color="blue">看不清？换一张</font></a></li>
						<li class="telNumber"><span class="dis">手机号码:</span> <input
							type="text" class="input _phoneNum" id="phone" name="tel"
							tabindex="1" maxlength="11"
							datatype="/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/"
							placeholder="请输入您的常用电话" style="padding-left: 10px;"
							nullmsg="请输入您的常用电话！"></li>
						<li class="agree"><input name="protocol" id="protocol"
							type="checkbox" value="" checked="checked"> 我同意《<a
							href="#" target="_black">团团赚注册协议</a>》 <span id="protocolAlt"
							data-info="请查看协议">请查看协议</span></li>
						<li class="btn"><a href="javascript:void(0);"
							onclick="submit();" class="radius1 _ajaxSubmit">立即注册</a></li>
					</ul>
				</form>
			</div>
		</div>
	</div>

	<div id="footer" class="ft">
		<div class="ft-inner clearfix">
			<div class="ft-helper clearfix">
				<dl>
					<dt>关于我们</dt>
					<dd>
						<a href="<%=path%>/foregroundSystem/jianjie.jsp">公司简介</a><a
							href="<%=path%>/foregroundSystem/tuandui.jsp">管理团队</a><a
							href="<%=path%>/foregroundSystem/wangzhangonggao.jsp">网站公告</a>
					</dd>
				</dl>
				<dl>
					<dt>相关业务</dt>
					<dd>
						<a href="<%=path%>/foregroundSystem/list.jsp">我要投资</a><a
							href="<%=path%>/foregroundSystem/borrow.jsp">我要借款</a>
					</dd>
				</dl>
				<dl>
					<dt>帮助中心</dt>
					<dd>
						<a href="<%=path%>/foregroundSystem/help.jsp">新手入门</a><a
							href="<%=path%>/foregroundSystem/pesonal_index.jsp">我的账户</a><a
							href="<%=path%>/foregroundSystem/list.jsp">债权转让</a>
					</dd>
				</dl>
				<dl>
					<dt>联系我们</dt>
					<dd>
						<a href="<%=path%>/foregroundSystem/lianxi.jsp">联系我们</a>
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
	<script
		src="${pageContext.request.contextPath}/foregroundSystem/script/Validform_v5.3.2_min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		function checkcode() {
			var code = $("#PictureCheckCode").val();
			var path = $("#path").val();
	
			$.post(path + "/getsession.action", {}, function(data) {
				if (data.session != code) {
					alert("验证码错误！");
					$("#PictureCheckCode").val("");
				}
			}, "json");
		}
		function myReload() {
			document.getElementById("PictureCheck").src = document.getElementById("PictureCheck").src + "?nocache=" + new Date().getTime();
		}
		var demo = $("#myform").Validform({
			tiptype : 4
		});
	</script>
	<script type="text/javascript">
		function submit() {
			$("#myform").submit();
		}
	</script>

</body>
</html>

