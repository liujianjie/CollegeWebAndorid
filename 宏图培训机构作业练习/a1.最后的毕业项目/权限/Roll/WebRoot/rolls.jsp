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

		<title>My JSP 'rolls.jsp' starting page</title>

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
	<form action="roll?method=manageroll" method="post">
		<%
			List list=(List)	request.getAttribute("listss");
		%>
		<input type="hidden" name="rolluid" value="${rolluid }">
		<input type="checkbox" value="1" name="inp" <%if(list.contains("1")){%>checked="checked"<%} %>>
		部门管理
		<br />
		<input type="checkbox" value="2"  name="inp" <%if(list.contains("2")){%>checked="checked"<%} %>>
		员工管理
		<br />
		<input type="checkbox" value="3" name="inp" <%if(list.contains("3")){%>checked="checked"<%} %>>
		请假管理
		<br />
		<input type="checkbox" value="4" name="inp" <%if(list.contains("4")){%>checked="checked"<%} %>>
		请假审批管理
		<br />
		<input type="checkbox" value="5" name="inp" <%if(list.contains("5")){%>checked="checked"<%} %>>
		课程管理
		<br />
		<input type="checkbox" value="6" name="inp" <%if(list.contains("6")){%>checked="checked"<%} %>>
		课程进度管理
		<br />
		<input type="checkbox" value="100" name="inp" <%if(list.contains("100")){%>checked="checked"<%} %>>
		权限管理
		<br />
		<input type="submit" value="保存">
		</form>
	</body>
</html>
