<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加</title>
</head>
<body>
	微博内容:
	<form action="${pageContext.request.contextPath }/addblog.do" method="post">
		<textarea rows="5" cols="30" name="tex">
		
		</textarea>
		<br>
		<input type="submit" value="提交"><input type="button" value="返回" onclick="javascript:history.back()">
	</form>
</body>
</html>