<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
<style>
		#topziti{font-size:13px}
		a{text-decoration: none;color: black}
		.toptablestyle{
			border-style:solid; 
			border-width:1px;
			border-top-color:#ebebeb;
			border-bottom-color:#f8f8f8;
			border-right-color:#f8f8f8;
			border-left-color:#f8f8f8;
			background-color:#f8f8f8;
			height:0px;
			width:1470px;
		}
	</style>
	
  </head>
  
  <body>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"> 
<table align="center" width="100%" border=0 bgcolor="#f8f8f8" >
	
	<tr height="35">
		<td align="right" width="14%" id="topziti">
				<a href="javascript:void(0);" onclick="AddFavorite('http://blog.csdn.net/linlin2294592017','我的博客');">
                   				<font color="#4b4b4b">收藏Jerry网</font></a>
		</td>
		<td align="left" width="40%" id="topziti">
							&nbsp;&nbsp;
							<a><font color="red">登录&nbsp;</font></a>
							<a><font color="#4b4b4b">注册</font></a>
		</td>
		<td align="left" width="5%" id="topziti">

							<a><font color="#4b4b4b">我的订单</font></a>

		</td>
		<td align="left" width="5%" id="topziti">
							<a><font color="#4b4b4b">我的Jerry |</font></a>
		</td>
		<td align="left" width="5%" id="topziti">

							<a><font color="#4b4b4b">最近浏览 |</font></a>
		</td>
		<td align="left" width="5%" id="topziti">
							<a href="qiantai_sel/GoodsGouWuChe.jsp" target="_blank"><font color="#4b4b4b">购物车<font color="red">${chartcount }</font>件 |</a>

		</td>
		<td align="left" width="5%" id="topziti">
							<a><font color="#4b4b4b">联系客服 |</font></a>
		</td>
		<td align="left" width="5%" id="topziti">
							<a><font color="#4b4b4b">多来看看我</font></a>

		</td>
		<td align="left" width="8%">
	
							<a><font color="#4b4b4b"></font></a>

		</td>
	</tr>
</table>
	<!-- 为了顶层的颜色深一点 -->
	<div class="toptablestyle">

	</div>
  </body>
</html>
