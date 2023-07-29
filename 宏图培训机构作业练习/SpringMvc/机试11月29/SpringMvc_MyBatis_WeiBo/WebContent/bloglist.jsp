<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>微博主页</title>
</head>
<body>
	<div>&nbsp;</div>
	<table align="center" width="80%" >
		<tr><td><b>全部微博，按时间排序</b></td></tr>
	</table>
	<div>&nbsp;</div>
	<table align="center" width="80%" cellspacing="1.5" bgcolor="back" >
		<tr height="35" align="center" bgcolor="white">	
			<td width="15%">
				<b>序号</b>
			</td>
			<td width="15%"><b>昵称</b></td>
			<td width="45%"><b>内容</b></td>
			<td width="25%">
				<b>发布时间</b>
			</td>
		</tr>
		<c:forEach items="${bloglist }" var="blog" varStatus="i">
			<tr height="35" align="center" bgcolor="white">	
				<td width="15%">${i.index+1 }
					
				</td>
				<td width="15%">${blog.users.u_nickname }</td>
				<td width="45%">${blog.b_content }</td>
				<td width="25%">
					<fmt:formatDate value="${blog.b_publishtime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
		</c:forEach>
		<tr align="center" height="30" bgcolor="white">
			<td colspan="4">
				共${bltotalcount }条数据，当前页:${blcurrpage }/${bltotalpage }
				<a href="${pageContext.request.contextPath }/bloglist.do?cpage=1" target="_top">首页</a>
				<a href="${pageContext.request.contextPath }/bloglist.do?cpage=${blcurrpage-1 }" target="_top">上一页</a>
				<a href="${pageContext.request.contextPath }/bloglist.do?cpage=${blcurrpage+1}" target="_top">下一页</a>
				<a href="${pageContext.request.contextPath }/bloglist.do?cpage=${bltotalpage}" target="_top">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>