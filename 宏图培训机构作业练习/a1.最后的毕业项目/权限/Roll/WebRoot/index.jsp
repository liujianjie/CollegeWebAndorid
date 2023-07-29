<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<%
			List list = (List) request.getSession().getAttribute("rolllist");
		%>
		日常办公
		<br />
		<%
			if (list.contains("1")) {
		%>
		<a>部门管理</a>
		<%
			}
		%>


		<br />
		<%
			if (list.contains("2")) {
		%>
		<a>员工管理</a>
		<%
			}
		%>
		<br />
		<%
			if (list.contains("3")) {
		%>
		<a>请假申请</a>
		<%
			}
		%>
		<br />
		<%
			if (list.contains("4")) {
		%>
		<a>请假审批</a>
		<%
			}
		%>
		<br />
		教务管理
		<%
			if (list.contains("5")) {
		%>
		<a>课程管理</a>
		<%
			}
		%>
		<br />
		<%
			if (list.contains("6")) {
		%>
		<a>课程进度管理</a>
		<%
			}
		%>
		
		<%
			if (list.contains("100")) {
		%>
		<a href="user.jsp">权限管理</a>
		<%
			}
		%>
		
	</body>
</html>
