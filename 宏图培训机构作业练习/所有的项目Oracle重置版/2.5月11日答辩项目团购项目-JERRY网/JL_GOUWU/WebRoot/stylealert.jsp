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
	
	
	#nav ul {margin-top:70px; margin-left:85px;}/*ul是整体位置 li为单体位置*/
	
	#nav li {height:36px; background:url(../images/nav_icon.png) no-repeat 0 0; padding-left:50px; text-align:left; margin-bottom:50px;}
	
	#nav li a {font-size:24px; font-weight:bold; line-height:36px; text-decoration:none; color:#ffd600;}
	
	#nav li a:hover {color:green;}
	
	/*当前链接*/

	</style>
  </head>
  
  <body>
    <!-- #nav li a:hover {color:green;}是精华 -->
<div id="nav">

    <ul>

      <li id="nav_01" ><a href="main.html">首页</a></li>

      <li id="nav_02"><a href="#">介绍</a></li>

      <li id="nav_03"><a href="#">政务</a></li>

      <li id="nav_04"><a href="#">交易平台</a></li>

      <li id="nav_05"><a href="#">商贸</a></li>

      <li id="nav_06"><a href="#">物流</a></li>

    </ul>

  </div>


  </body>
</html>
