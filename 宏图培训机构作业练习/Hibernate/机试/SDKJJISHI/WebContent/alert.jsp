<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改学生信息</title>
</head>
<body>
	<form action="stu.do?method=alert" method="post" name="frm">
	<input type="hidden" value="${student.stu_id }">
	<table width="70%" cellspacing="1.5" bgcolor="purple" align="center">
		<tr bgcolor="white">	
			<td align="center">学生姓名</td>
			<Td><input type="text" name="stu_name" value="${student.stu_name }"></Td>
		</tr>
		<tr bgcolor="white" >	
			<td align="center">学生年龄</td>
			<Td><input type="text" name="stu_age" value="${student.stu_age }"></Td>
		</tr>
		<tr bgcolor="white" >	
			<td align="center">学生性别</td>
			<Td>
				<input type="radio" name="stu_sex" value="男" ${student.stu_sex=='男'?'checked':'' }>男
				<input type="radio" name="stu_sex" value="女" ${student.stu_sex=='女'?'checked':'' }>女
			</Td>
		</tr>
		<tr bgcolor="white" >	
			<td align="center">学生说明</td>
			<Td><textarea rows="5" cols="30" name="stu_desc" >${student.stu_desc }</textarea></Td>
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
					<option value="赣州" ${student.stu_city=='赣州'?'selected':'' }>赣州</option>
					<option value="南昌" ${student.stu_city=='南昌'?'selected':'' }>南昌</option>
					<option value="兴国" ${student.stu_city=='兴国'?'selected':'' }>兴国</option>
					<option value="于都" ${student.stu_city=='于都'?'selected':'' }>于都</option>
					<option value="信丰" ${student.stu_city=='信丰'?'selected':'' }>信丰</option>
					<option value="定南" ${student.stu_city=='定南'?'selected':'' }>定南</option>
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
	<script type="text/javascript">
		var favo='${student.stu_aihao}'
		alert(favo);
		var favos=favo.split(" ");//分割陈数组
		var chks=document.frm.aihao;
		for(var i=0;i<chks.length;i++){
			var ck=chks[i].value;
			for(var j=0;j<favos.length;j++){
				if(ck==favos[j]){
					chks[i].checked=true;
					break;
				}
			}
			
		}
	</script>
</body>
</html>
