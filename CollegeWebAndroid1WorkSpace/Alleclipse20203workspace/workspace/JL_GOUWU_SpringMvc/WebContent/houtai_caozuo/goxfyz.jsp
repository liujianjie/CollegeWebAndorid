<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xfyz.jsp' starting page</title>

  </head>
  
  <body>
	<c:if test="${msg!=null}">
		<h2 align="center">${msg }</h2><br></br>
	</c:if>
  	<form action="index/goxfyz" method="post" >
  		<font size="3">请输入消费验证码:</font><input type="text" name="yzm" style="width:150px;heigth:80px">
  		<br><br>
  		<input type="submit" value="验证">
  	</form>
  </body>
</html>
