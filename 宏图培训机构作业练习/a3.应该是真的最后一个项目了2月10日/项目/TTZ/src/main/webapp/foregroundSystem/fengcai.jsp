<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link href="<%=path%>/foregroundSystem/css/about.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
</head>
<body>
	<jsp:include page="/foregroundSystem/header.jsp"></jsp:include>
	<!--关于我们-->
	<!--关于我们-->
	<div class="bg">
		<div class="contain" id="tabs" style="margin:0 auto;">
			<div class="text-nav">
				<ul class="clearfix">
					<li><a class="text-link"
						href="${pageContext.request.contextPath}/notice/selnoticelist.action?cpage=1">网站公告</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/jianjie.jsp">公司简介</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/tuandui.jsp">管理团队</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/huoban.jsp">合作伙伴</a></li>
					<li class="selected"><a class="text-link"
						href="<%=path%>/foregroundSystem/fengcai.jsp">团队风采</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/zhengce.jsp">法律政策</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/shemgming.jsp">法律声明</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/shuoming.jsp">资费说明</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/zhaoxiannashi.jsp">招贤纳士</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/lianxi.jsp">联系我们</a></li>
				</ul>
			</div>
			<div class="text-box">
				<div class="text-content" id="text-content">
					<ul class="r-list">
						<li class="clearfix"><a href=""> <img
								src="<%=path%>/foregroundSystem/images/2015062506.jpg"
								width="300" height="171">
						</a>
							<div class="record">
								<h5>
									<a href="#">服务民生</a>
								</h5>
								<p class="text">
									设立公益书友会，斥资购买图书并向市民免费开放，这也和2015年政府工作报告提出要“倡导全民阅读
									，建设书香社会”的号召不谋而合。公益书友会将是一个交流互动的乐园，书友会将不定期举办多种活动，发挥石狮首家互联网金融公司的所长，帮助市民了解金融法规、投资理财等相关知识，为发展普惠金融做出自己的贡献。
								</p>
								<p class="time">活动时间：2015年6月</p>
							</div></li>
						<li class="clearfix"><a href=""> <img
								src="<%=path%>/foregroundSystem/images/2015062506.jpg"
								width="300" height="171">
						</a>
							<div class="record">
								<h5>
									<a href="#">服务民生</a>
								</h5>
								<p class="text">
									设立公益书友会，斥资购买图书并向市民免费开放，这也和2015年政府工作报告提出要“倡导全民阅读
									，建设书香社会”的号召不谋而合。公益书友会将是一个交流互动的乐园，书友会将不定期举办多种活动，发挥石狮首家互联网金融公司的所长，帮助市民了解金融法规、投资理财等相关知识，为发展普惠金融做出自己的贡献。
								</p>
								<p class="time">活动时间：2015年6月</p>
							</div></li>
						<li class="clearfix"><a href=""> <img
								src="<%=path%>/foregroundSystem/images/2015062506.jpg"
								width="300" height="171">
						</a>
							<div class="record">
								<h5>
									<a href="#">服务民生</a>
								</h5>
								<p class="text">
									设立公益书友会，斥资购买图书并向市民免费开放，这也和2015年政府工作报告提出要“倡导全民阅读
									，建设书香社会”的号召不谋而合。公益书友会将是一个交流互动的乐园，书友会将不定期举办多种活动，发挥石狮首家互联网金融公司的所长，帮助市民了解金融法规、投资理财等相关知识，为发展普惠金融做出自己的贡献。
								</p>
								<p class="time">活动时间：2015年6月</p>
							</div></li>
					</ul>
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
		</div>
	</div>
</body>
</html>
