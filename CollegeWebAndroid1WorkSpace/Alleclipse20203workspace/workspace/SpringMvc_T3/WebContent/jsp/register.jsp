<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/registerUser" method = "post">
		<p>用户名:<input type="text" name="username" /></p>
		<p>密码:<input type="text" name="password" /></p>
		<p><input type="submit" value="注册"/>
	</form>
</body>
</html>