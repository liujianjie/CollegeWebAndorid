<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML> 
<head>

<title></title>

</head>

<body>
<form action="jieshou?method=test" method="post">
<textarea rows="20" cols="50" ><%=application.getAttribute("message") %></textarea><br>
<input type="text" name="message">
<input type="submit" value="发送 ">
</form> 
</body>
</html>
