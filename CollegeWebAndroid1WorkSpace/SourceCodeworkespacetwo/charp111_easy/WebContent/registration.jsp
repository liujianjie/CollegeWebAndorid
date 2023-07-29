<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/main.css" rel="stylesheet">
</head>
<body>
<!--1.LOGO --> 
<%@include  file="logo.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp" %>
<br/><br/><br/><br/>
<div align="center">
<h1>新会员注册</h1><br/>
<form action="/charp111_easy/ShowUsers" method="post">
<table width="850" border=0 cellspacing="2">
<tr>
<td style="text-align:right">会员名</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td style="text-align:right">密码</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td style="text-align:right">重复密码</td>
<td><input type="password" name="repassword"/></td>
</tr>
<tr>
<td style="text-align:right">性别</td>
<td><input type="radio" name="gender" value="男" checked="checked"/>男
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="gender" value="女" />女
</td>
</tr>
<tr>
<td style="text-align:right">联系电话</td>
<td><input type="text" name="telephone"/></td>
</tr>
<tr>
<td style="text-align:right">个人介绍</td>
<td><textarea name="introduce" cols="60" rows="5"/></textarea></td>
</tr>
<tr>
<td colspan="1" style="text-align:center;padding-top:20px">
<input type="image" src="1.gif" name="submit" border=0/>
</td>
</tr>

</table>
</form>
</div>
<br/><br/><br/><br/><br/><br/>
<!-- 底部版权栏 -->
<%@include file="copy.jsp" %>

</body>
</html>