<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>???????</title>
</head>
<body>
	<div >&nbsp;</div>
	<table align="center" width="80%" >
		<tr>
		<td>
			全部用户,<a href="${pageContext.request.contextPath }/useradd.jsp">添加用户</a>
		</td>
		</tr>
	</table>
	<div >&nbsp;</div>
	<table align="center" width="80%" cellspacing="1.5" bgcolor="back">
		<tr align="center" height="35" bgcolor="white">
			<td width="20%"><b>用户名</b></td>
			<td width="18%"><b>昵称</b></td>
			<td width="18%"><b>手机</b></td>
			<td width="25%"><b>住址</b></td>
			<td width="18%"><b>操作</b></td>
		</tr>
		<c:forEach items="${userlist }" var="user" varStatus="i">
			<tr align="center" height="60" bgcolor="white">	
				<td>
					<img src="${user.u_picpath }" height="50" width="70">
					<br>
					${user.u_username }
				</td>
				<td>${user.u_nickname }</td>
				<td>${user.u_mobile }</td>
				<td>${user.u_address }</td>
				<td><a href="${pageContext.request.contextPath }/userdel.do?id=${user.u_id}">删除</a></td>
			</tr>
		</c:forEach>
		<tr align="center" height="30" bgcolor="white">
			<td colspan="5" >
				共${totalcount }条数据，当前页:${currpage }/${totalpage }
				<a href="${pageContext.request.contextPath }/userlists.do?cpage=1" target="center">首页</a>
				<a href="${pageContext.request.contextPath }/userlists.do?cpage=${currpage-1 }" target="center">上一页</a>
				<a href="${pageContext.request.contextPath }/userlists.do?cpage=${currpage+1}" target="center">下一页</a>
				<a href="${pageContext.request.contextPath }/userlists.do?cpage=${totalpage}" target="center">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>