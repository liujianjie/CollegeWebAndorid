<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/findOrdersWithUser" method = "post">
		<p>订单编号:<input type="text" name="ordersId" /></p>
		<p>所属用户:<input type="text" name="user.username" /></p>
		<p><input type="submit" value="查询"/>
	</form>
</body>
</html>