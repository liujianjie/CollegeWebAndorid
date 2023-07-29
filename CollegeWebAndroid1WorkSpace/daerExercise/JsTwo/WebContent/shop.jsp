<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link href="css/degin.css" rel="stylesheet"> 
</head>
<body>
	<p>欢迎进入商品列表页面</p>
	<form action="account.jsp" method="post">
		<table width="40%">
			<tr align="center">
				<td>编号</td>
				<td>商品图片</td>
				<td>单价</td>
				<td>数量</td>
			</tr>
			<tr align="center">
				<td>1</td>
				<td><img src="img/apple.jpg" width="100" height="100"/></td>
				<td>￥5.0</td>
				<td><input type="text" name="applec" style="width:40px"></td>
			</tr>
			<tr align="center">
				<td>2</td>
				<td><img src="img/bana.jpg" width="100" height="100"/></td>
				<td>￥4.0</td>
				<td><input type="text" name="banac" style="width:40px"></td>
			</tr>
			<tr align="center">
				<td>1</td>
				<td><img src="img/water.jpg" width="100" height="100"/></td>
				<td>￥6.0</td>
				<td><input type="text" name="waterc" style="width:40px"></td>
			</tr>
			<tr align="center">
				<td colspan="4"><input type="submit" value="结账"/>&nbsp;<input type="reset" value="重置"/></td>
			</tr>
		</table>
	</form>
</body>
</html>