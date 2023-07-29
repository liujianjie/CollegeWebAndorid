<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的信息</title>
<link type="text/css" href="css/main.css" rel="stylesheet">
</head>
<body>
<!--1.LOGO --> 
<%@include  file="logo.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp" %>
<br/><br/><br/><br/>

     <%
     String username=(String) request.getAttribute("name");
     if (name!=null) out.println(name+",您好");
     %>
 
 <br/><br/><br/><br/><br/><br/>
<!-- 底部版权栏 -->
<%@include file="copy.jsp" %>
</body>
</html>