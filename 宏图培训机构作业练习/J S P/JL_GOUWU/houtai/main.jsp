<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>JERRY购物网后台</title>

  </head>
  
  <frameset rows="20%,*" frameborder="yes" border=1>
  	<frame src="houtai/top.jsp"/>
  	<frameset cols="15%,*" border=1>
  		<frame src="houtai/left.jsp"/>
  		<frame src="houtai/right.jsp" name="main">
  	</frameset>
  </frameset>
</html>
