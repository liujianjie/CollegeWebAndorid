<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" href="css/main.css" rel="stylesheet" />
<link type="text/css" href="css/autoplay.css" rel="stylesheet" />
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body>
	<!--1.LOGO -->
	<%@include file="head.jsp"%>
	<!-- 2.网站菜单列表 -->
	<%@include file="nav.jsp"%>
	<!-- 网站首页轮播图 -->

	<div align="center">
		<h1>新会员注册</h1>
		<br />
		<form action="${pageContext.request.contextPath}/RegisterServlet"
			method="post">
			<table width="400px" border="0" cellspacing="2">
				<tr>
					<td style="text-align: right">会员名</td>
					<td><input type="text" name="username" />${errorMessage}</td>
				</tr>
				<tr>
					<td style="text-align: right">密码</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td style="text-align: right">确认密码</td>
					<td><input type="password" name="checkpassword" /></td>
				</tr>
				<tr>
					<td style="text-align: right">性别</td>
					<td><input type="radio" name="sex" value="男" checked="checked" />男
						&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; <input type="radio"
						name="sex" value="女" />女</td>
				</tr>
				<tr>
					<td style="text-align: right">生日</td>
					<td><input type="text" name="birthday" /></td>
				</tr>
				<tr>
					<td style="text-align: right">邮箱</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td style="text-align: right">地址</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td style="text-align: right">角色</td>
					<td><input type="radio" name="role" value="1" />管理员 <input
						type="radio" name="role" value="0" checked="checked" />普通用户</td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="注册" />
						<input type="reset" value="清除" /></td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<!-- 底部版权栏 -->
	<%@include file="foot.jsp"%>
</body>
</html>