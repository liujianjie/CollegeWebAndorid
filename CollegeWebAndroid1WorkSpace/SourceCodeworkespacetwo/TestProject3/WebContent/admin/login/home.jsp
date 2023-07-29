<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="70,*,43" border="0" framespacing="0">

	<frame src="${pageContext.request.contextPath}/admin/login/top.jsp"
		name="topFrame" scrolling="NO" noresize>
	<frameset cols="159,*" border="0" framespacing="0">
	<frame src="${pageContext.request.contextPath}/admin/login/left.jsp"
			name="leftFrame" noresize scrolling="YES">
	<frame src="${pageContext.request.contextPath}/admin/login/welcome.jsp"
			name="mainFrame">
	</frameset>
	<frame src="${pageContext.request.contextPath}/admin/login/bottom.jsp"
		name="bottomFrame" scrolling="NO" noresize>
</frameset>
</html>