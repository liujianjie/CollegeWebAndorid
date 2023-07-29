<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加学生</title>
</head>
<body>
	<form action="stu.do?method=add" method="post">
	<table width="70%" cellspacing="1.5" bgcolor="purple" align="center">
		<tr bgcolor="white">	
			<td align="center">学生姓名</td>
			<Td><input type="text" name="stu_name"></Td>
		</tr>
		<tr bgcolor="white" >	
			<td align="center">学生年龄</td>
			<Td><input type="text" name="stu_age"></Td>
		</tr>
		<tr bgcolor="white" >	
			<td align="center">学生性别</td>
			<Td>
				<input type="radio" name="stu_sex" checked value="男">男
				<input type="radio" name="stu_sex" value="女">女
			</Td>
		</tr>
		<tr bgcolor="white" >	
			<td align="center">学生说明</td>
			<Td><textarea rows="5" cols="30" name="stu_desc"></textarea></Td>
		</tr>
		<tr bgcolor="white" >	
			<td align="center">学生爱好</td>
			<Td>
				<input type="checkbox" name="aihao" value="打篮球">打篮球
				<input type="checkbox" name="aihao" value="看书">看书
				<input type="checkbox" name="aihao" value="玩游戏">玩游戏
				<input type="checkbox" name="aihao" value="散步">散步
				<input type="checkbox" name="aihao" value="逛街">逛街
				<input type="checkbox" name="aihao" value="游泳">游泳
			</Td>
		</tr>
		<tr bgcolor="white" >	
			<td align="center">所在城市</td>
			<Td>
				<select name="stu_city">
					<option value="赣州">赣州</option>
					<option value="南昌">南昌</option>
					<option value="兴国">兴国</option>
					<option value="于都">于都</option>
					<option value="信丰">信丰</option>
					<option value="定南">定南</option>
				</select>
			</Td>
		</tr>
		<tr bgcolor="white">	
			<td colspan="2">
				<input type="submit" value="提交">
				<input type="button" value="取消" onclick="history.back()">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
