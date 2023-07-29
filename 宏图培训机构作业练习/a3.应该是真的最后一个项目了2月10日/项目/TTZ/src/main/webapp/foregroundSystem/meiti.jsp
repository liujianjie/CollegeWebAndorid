<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<div class="bg">
		<div class="contain" id="tabs" style="margin:0 auto;">
			<div class="text-nav">
				<ul class="clearfix">
					<li class="selected"><a class="text-link"
						href="${pageContext.request.contextPath}/notice/selnoticelist.action?cpage=1">网站公告</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/jianjie.jsp">公司简介</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/tuandui.jsp">管理团队</a></li>
					<li><a class="text-link"
						href="<%=path%>/foregroundSystem/huoban.jsp">合作伙伴</a></li>
					<li><a class="text-link"
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
				<!-- 单一的 -->
				<c:if test="${one==1 }">
					<div class="text-content" id="text-content">
						<header class="article-header">
						<div class="article-title">
							<a href="#">${notice.n_title }</a>
						</div>
						<div class="article-meta">
							<span class="item">作者：<a rel="category tag">
									${notice.n_author } </a></span> <span class="item">发布时间：<a
								rel="category tag"> <fmt:formatDate
										value="${notice.n_date }" pattern="yyyy-MM-dd HH:mm:ss" />
							</a></span> <span class="item post-views">阅读(${notice.n_count })</span>
						</div>
						</header>
						<article class="article-content">
						<p style="text-align: center;">
							<br>
						</p>

						<p
							style="padding-top: 10px; list-style-type: none; margin-top: 0px; margin-bottom: 0px; outline: invert none medium; list-style-image: none; text-indent: 2em; color: rgb(51, 51, 51); font-family: ''; font-size: 14px; font-style: normal; font-variant: normal; line-height: 25.2000007629395px; white-space: normal;">
							${notice.n_body }
						<p></p>
						</article>
					</div>
				</c:if>

				<!-- 不是单个的 -->
				<c:if test="${one==0 }">
					<div class="text-content" id="text-content">
						<h1 class="title">网站公告</h1>
						<ul class="clearfix mt20 new-list">
							<c:forEach items="${map.nolist }" var="notice">
								<li class="clearfix list-item"><a
									href="${pageContext.request.contextPath}/notice/getnoticeone.action?id=${notice.n_id}">
										${notice.n_title }</a> <span> <fmt:formatDate
											value="${notice.n_date }" pattern="yyyy-MM-dd HH:mm:ss" />
								</span></li>
							</c:forEach>
						</ul>
						<div class="page">
							<span class="all">共有${map.totalCount }条信息,当前页${map.currPage }/${map.totalPage }页</span><span
								class="count"></span>
							<div class="fr pages">
								<a class="last" href="selnoticelist.action?cpage=1">首页</a> <a
									id="btn1" onclick="nolist(this);" class="next">上一页</a>
								<c:if test="${map.currPage-3>0}">
									<span><a id="btn2" onclick="nolist(this);">${map.currPage-3}</a></span>
								</c:if>
								<c:if test="${map.currPage-2>0}">
									<span><a id="btn3" onclick="nolist(this);">${map.currPage-2}</a></span>
								</c:if>
								<c:if test="${map.currPage-1>0}">
									<span><a id="btn4" onclick="nolist(this);">${map.currPage-1}</a></span>
								</c:if>
								<span class="currents"><a id="btn5"
									onclick="nolist(this);">${map.currPage}</a></span>
								<c:if test="${map.currPage+1<=map.totalPage}">
									<span><a id="btn6" onclick="nolist(this);">${map.currPage+1}</a></span>
								</c:if>
								<c:if test="${map.currPage+2<=map.totalPage}">
									<span><a id="btn7" onclick="nolist(this);">${map.currPage+2}</a></span>
								</c:if>
								<c:if test="${map.currPage+3<=map.totalPage}">
									<span><a id="btn8" onclick="nolist(this);">${map.currPage+3}</a></span>
								</c:if>
								<a id="btn9" onclick="nolist(this);" class="next">下一页</a> <a
									class="last"
									href="selnoticelist.action?cpage=${map.totalPage }">尾页</a> <input
									type="text" id="ids" value="${map.currPage }"
									style="width: 50px;height: 20px" /> <input type="button"
									value="跳转" onclick="tonolist();"
									style="width: 50px;height: 25px" />
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function tonolist() {
			var cur = $("#ids").val();
			if (!isNaN(cur)) {
				location.href = "selnoticelist.action?cpage=" + cur;
			} else {
				alert("请输入正确的页码！");
			}
	
		}
		function nolist(btn) {
			var id = btn.id;
			var currPage = parseInt('${map.currPage}'); //需要强转 不然为String 1+1=11
			if (id == "btn1" || id == "btn4") {
				location.href = "selnoticelist.action?cpage=" + (currPage - 1) + "";
			} else if (id == "btn2") {
				location.href = "selnoticelist.action?cpage=" + (currPage - 3) + "";
			} else if (id == "btn3") {
				location.href = "selnoticelist.action?cpage=" + (currPage - 2) + "";
			} else if (id == "btn5") {
				location.href = "selnoticelist.action?cpage=" + (currPage) + "";
			} else if (id == "btn7") {
				location.href = "selnoticelist.action?cpage=" + (currPage + 2) + "";
			} else if (id == "btn8") {
				location.href = "selnoticelist.action?cpage=" + (currPage + 3) + "";
			} else if (id == "btn9" || id == "btn6") {
				location.href = "selnoticelist.action?cpage=" + (currPage + 1) + "";
			}
		}
	</script>

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
