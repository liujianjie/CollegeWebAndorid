<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link href="css/degin.css" rel="stylesheet"> 
</head>
<body>
	<p>欢迎进入购物登录页面</p>
	<div class="centerdiv">
		<form action="logincheck.jsp" method="post" class="back">
			<h2>用  户  名:<input type="text" class="input" name="user" placeholder="请输入用户名"/></h2>
			<h2>密        码:<input type="password" class="input" name="pass" placeholder="请输入密码"/></h2>
			<input type="submit" value="登录"/>&nbsp;<input type="reset" value="重置"/>
			&nbsp;<input type="button" onclick="javascript:location.href='register.jsp'" value="重新注册"/>
		</form>
	
	</div>
</body>
</html>