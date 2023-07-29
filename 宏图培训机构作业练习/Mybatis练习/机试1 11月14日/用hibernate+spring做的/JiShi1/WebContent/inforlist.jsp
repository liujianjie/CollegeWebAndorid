<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>手机资讯</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<h1 align="center">手机资讯</h1>
	<br>
	<table width="70%" align="center" cellspacing="1.5" bgcolor="#00ff00" >
		<tr align="center" bgcolor="#ffffff" height="30">
			<td width="10%">序列</td>
			<td width="20%">标题</td>
			<td width="10%">回复/查看</td>
			<td width="15%">发表时间</td>
			<td width="15%">最新回复</td>
		</tr>
		<c:forEach items="${inforlist }" var="infor">
			<tr align="center" bgcolor="#ffffff" height="30">
				<td>${infor.inInforid }</td>
				<td><a href="infor/selxq?inforid=${infor.inInforid }">${infor.inTitle }</a></td>
				<td>${infor.inReplycount }/${infor.inViewcount }</td>
				<td>${infor.inReporttime }</td>
				<td>${infor.inLastposttime }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>