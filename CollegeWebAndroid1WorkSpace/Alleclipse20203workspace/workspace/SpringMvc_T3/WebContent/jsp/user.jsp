<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/deleteUsers" method = "post">
		<p><input name="ids" value="1" type="checkbox"/>tom</p>
		<p><input name="ids" value="2" type="checkbox"/>jack</p>
		<p><input name="ids" value="3" type="checkbox"/>lucy</p>
		<p><input type="submit" value="删除"/>
	</form>
</body>
</html>