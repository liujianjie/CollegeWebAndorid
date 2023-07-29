<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>左</title>
</head>
<body>
<br/><br/>
	<div align="center">
		<a href="${pageContext.request.contextPath }/userblog.do?cpage=1" target="center">微博管理</a>
	</div>
	<br/><br/>
	<div align="center">
		<c:if test="${user.u_supper==1 }">
			<a href="${pageContext.request.contextPath }/userlists.do?cpage=1" target="center">用户管理</a>
		</c:if>
		<c:if test="${user.u_supper==0 }">
			<a href="useralert.jsp" target="center">用户管理</a>
		</c:if>
	</div>
</body>
</html>