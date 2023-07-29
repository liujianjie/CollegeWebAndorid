<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 这是许玉畅写的代码 实现了下拉 我把其中重要的代码（样式）分割在了testselect。jsp中 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<style>
.body2 {
	margin-right: 160px;
	margin-left: 160px;
}
ul.line {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	padding-top: 6px;
	padding-bottom: 6px;
	background-color: #00cc99;
}

li {
	float: left;
}

a.line:link,:visited {
	font-weight: bold;
	color: white;
	background-color: #00cc99;
	text-align: center;
	padding: 20px;
	text-decoration: none;
}

a.line:hover,:active {
	background-color: #00ffff;
}
.dropbtn {
    background-color:#00cc99;
	font-family:"微软雅黑";
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
    margin-top: 16px;
}

.dropdown {

    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
   display: block;
}

.dropdown:hover .dropbtn {
  background-color: #00ffff;
}
</style>
		<title>【魅团】纳美克星超级团购</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="common/mt_main.css">

	</head>

	<body>
		<div class="top">
			<ul>
				<li style="margin-left: 120">
					<a href="" class="top">☆收藏魅团</a>
				</li>
				<li style="margin-left: 10">
					<a href="common/login.jsp" class="top"><font color="#ff9900">登录</font>
					</a>
				</li>
				<li style="margin-left: 10">
					<a href="common/register.jsp" class="top">注册</a>
				</li>
			</ul>
		</div>
		<div class="body2">
			<div class="img">
			<a href="meituan.main.jsp">
				<img src="images/8774235d5db056c805bdd7aeda8b9c8f47722.jpg"
					width="100%" height="80" />
			</a>		
			</div>
			<div class="serch">
				<ul class="serch">
					<li style="width: 33%; margin-top: 0">
					<a href="index?method=prolisttt">
						<img src="images/meituan.png" />
						</a>
					</li>
					<li style="margin-top: 30px">
						<input type="text" name="serch" size="60"
							style="height: 40px; border: 2px solid #009999"
							placeholder="请输入商品名称、地址等" />
						<input type="submit"
							style="width: 60; height: 40; background: #009999; color: white; font-family: 微软雅黑"
							value="搜索" />
					</li>
				</ul>
			</div>
			<div class="dropdown">
	  			<button class="dropbtn" style="width:100%">全部分类</button>
	  			<div class="dropdown-content">
				   	<a href="index?method=prolistt&t_id=8">美食</a>
				    <a href="index?method=prolistt&t_id=9">酒店/客栈</a>
				    <a href="index?method=prolistt&t_id=10">电影/在线选座</a>
				    <a href="index?method=prolistt&t_id=11">KTV</a>
				    <a href="index?method=prolistt&t_id=12">休闲娱乐</a>
				    <a href="index?method=prolistt&t_id=13">周边游/旅游</a>
				    <a href="index?method=prolistt&t_id=14">生活服务</a>
	  			</div>
			</div>
			<div class="bar" style="margin-top: 16">
				<ul class="line" style="height: 29">
					<li>
						<a href="index?method=prolisttt" class="line">主页</a>
					</li>
					<li>
						<a href="index?method=prolisttt" class="line">今日新单</a>
					</li>
					<li>
						<a href="index?method=prolisttt" class="line">购物</a>
					</li>
					<li>
						<a href="index?method=prolisttt" class="line">身边外卖</a>
					</li>
					<li>
						<a href="index?method=prolisttt" class="line">名店抢购</a>
					</li>
				</ul>
			</div>
			<ul style="list-style-type:none">
			<c:forEach items="${list8}" var="p">
				<li style="width:33%;float:left">
					<table>
						<tr>
							<td colspan="2">
							<a href="index?method=toproduct&p_id=${p.p_id }" target="_blank">	<img src="images/${p.p_img }" width="95%" height=" 150"/></a>
							</td>
						</tr>
						<tr>
							<td>
								<b>${p.p_name }</b>
							</td>
							<td rowspan="2">
								<font color="#ff9966" size="4"><b>￥${p.p_price }</b>
								</font>
							</td>
						</tr>
						<tr>
							<td>
								<font size="4" color="#a8a8a8">${p.description}</font>
							</td>
						</tr>
						<tr>
							<td colspan="2" width="60">
								&nbsp;
							</td>
						</tr>
					</table>
				</li>
			</c:forEach>
		</ul>
		</div>	
	</body>
</html>
