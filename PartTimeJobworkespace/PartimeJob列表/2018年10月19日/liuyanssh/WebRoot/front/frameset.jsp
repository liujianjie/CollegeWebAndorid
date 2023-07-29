<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<frameset rows="10%,*">
<frame src="top.jsp"></frame>
<frameset cols="13%,*">
<frame src="left.jsp"></frame>
 <frame src="main.jsp"  name="main"></frame>
</frameset>
</frameset>

</html>