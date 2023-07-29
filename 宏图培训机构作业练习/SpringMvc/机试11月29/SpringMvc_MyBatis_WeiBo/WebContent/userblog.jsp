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
	<div>&nbsp;</div>
	<table align="center" width="90%" >
		<tr><td><b>我的微博,<a href="addblog.jsp" target="center">添加微博</a>,<a href="${pageContext.request.contextPath }/bloglist.do?cpage=1" target="_top">首页</a></b></td></tr>
	</table>
	<div>&nbsp;</div>
	<table align="center" width="90%" cellspacing="1.5" bgcolor="back">
		<tr height="35" align="center" bgcolor="white">	
			<td width="12%">序号</td>
			<td width="12%">昵称</td>
			<td width="42%">内容</td>
			<td width="22%">
				时间
			</td>
			<td width="12%">操作</td>
		</tr>
		<c:forEach items="${bloglist }" var="blog" varStatus="i">
			<tr height="35" align="center" bgcolor="white">	
				<td width="12%">${i.index+1 }</td>
				<td width="12%">${blog.users.u_nickname }</td>
				<td width="42%">${blog.b_content }</td>
				<td width="22%">
					<fmt:formatDate value="${blog.b_publishtime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td width="12%"><a href="${pageContext.request.contextPath }/delblog.do?id=${blog.b_id}">删除</a></td>
			</tr>
		</c:forEach>
		<tr align="center" height="30" bgcolor="white">
			<td colspan="5">
				共${totalcount }条数据，当前页:${currpage }/${totalpage }
				<a href="${pageContext.request.contextPath }/userblog.do?cpage=1" target="center">首页</a>
				<a href="${pageContext.request.contextPath }/userblog.do?cpage=${currpage-1 }" target="center">上一页</a>
				<a href="${pageContext.request.contextPath }/userblog.do?cpage=${currpage+1}" target="center">下一页</a>
				<a href="${pageContext.request.contextPath }/userblog.do?cpage=${totalpage}" target="center">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>