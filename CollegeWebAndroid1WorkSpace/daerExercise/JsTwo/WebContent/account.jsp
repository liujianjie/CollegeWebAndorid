<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结账页面</title>
<link href="css/degin.css" rel="stylesheet"> 
</head>
<body>	
	<%
		request.setCharacterEncoding("UTF-8");
		int applec = Integer.valueOf(request.getParameter("applec"));
		int banac = Integer.valueOf(request.getParameter("banac"));
		int waterc = Integer.valueOf(request.getParameter("waterc"));
		int sum = applec * 5 + banac * 4 + waterc * 6;
		String name = String.valueOf(session.getAttribute("name"));
	%>
	<h3>尊敬的用户：</h3>
	<p style="text-align:left"><%=name %>,你的购物清单如下：</p>
	<table>
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
			<td><input type="text" name="applec" style="width:40px" disabled value="<%=applec%>"></td>
		</tr>
		<tr align="center">
			<td>2</td>
			<td><img src="img/bana.jpg" width="100" height="100"/></td>
			<td>￥4.0</td>
			<td><input type="text" name="banac" style="width:40px" disabled value="<%=banac%>"></td>
		</tr>
		<tr align="center">
			<td>1</td>
			<td><img src="img/water.jpg" width="100" height="100"/></td>
			<td>￥6.0</td>
			<td><input type="text" name="waterc" style="width:40px" disabled value="<%=waterc%>"></td>
		</tr>
		<tr align="center">
			<td colspan="4"><p>您这次购物共计：<%=sum %>元</p></td>
		</tr>
	</table>
	
</body>
</html>