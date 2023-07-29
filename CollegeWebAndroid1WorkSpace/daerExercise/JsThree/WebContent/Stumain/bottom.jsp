<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url(../images/bg.jpg);background-repeat:no-repeat;">
	<div style="height:34px;width: 100%;background-color: #33ccff;">
		<font style="color:white;font-size:14px;padding-left:12px;font-weight:bold;line-height: 40px">
			当前页面：学生信息管理系统--&gt;登录页面
		</font>
	</div>
	
	<div style="height:450px">
		<%
			String name = (String)session.getAttribute("name");
			String type = (String)session.getAttribute("type");
			String usertype = null;
			if("0".equals(type)){
				usertype = "学生";
			}else if("1".equals(type)){
				usertype = "教师";
			}else if("2".equals(type)){
				usertype = "管理员";
			}
		%>
		<br>
		<br>
		<font style="font-weight:bold;height:25px;color:red">欢迎您!</font>
		<br>
		<br>
		用户账号<font color="blue"><b>【<%=name %>】</b></font>
		用户身份<font color="blue"><b>【<%=usertype %>】</b></font>
	</div>
</body>
</html>