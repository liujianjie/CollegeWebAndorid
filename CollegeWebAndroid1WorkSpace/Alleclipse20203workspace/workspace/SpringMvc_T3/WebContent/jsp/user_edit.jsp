<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/editUsers" method = "post" id="formid">
		<p><input name="users[0].id" value="1" type="checkbox"/><input name="users[0].username" type="text" value="tom"></p>
		<p><input name="users[1].id" value="2" type="checkbox"/><input name="users[1].username" type="text" value="Jack"></p>
		<p><input type="submit" value="修改"/>
	</form>
</body>
</html>