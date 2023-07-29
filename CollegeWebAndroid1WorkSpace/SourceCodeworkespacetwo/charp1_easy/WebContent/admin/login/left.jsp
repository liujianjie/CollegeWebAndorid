<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>left</title>
<link href="${pageContext.request.contextPath}
/admin/css/left.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<table width="100%" border="0">
		<tr>
			<td><a 
				target="mainFrame" class="left_list">管理用户</a></td>
		</tr>
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/BookSearchAllServlet?flag=1"
				target="mainFrame" class="left_list">管理商品</a></td>
		</tr>
		<tr>
			<td><a href="#" target="mainFrame" class="left_list">管理公告</a></td>
		</tr>
		<tr>
			<td><a href="#" target="mainFrame" class="left_list">运营分析</a></td>
		</tr>
	</table>

</body>
</html>