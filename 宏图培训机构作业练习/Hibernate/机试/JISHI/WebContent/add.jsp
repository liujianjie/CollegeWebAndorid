<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加</title>
	<script type="text/javascript">
		function add() {
			var td=document.getElementById("it");
			var br=document.createElement("br");
			var input=document.createElement("input");
			var input2=document.createElement("input");
			var input3=document.createElement("input");
			var button=document.createElement("input");
			
			input.name="jl_starttime";
			input.type="text";
			
			input2.name="jl_endtime";
			input2.type="text";
			
			input3.name="jl_school";
			input3.type="text";
			
			button.value="删除";
			button.type="button";
			
			button.onclick=function(){
				td.removeChild(br);
				td.removeChild(input);
				td.removeChild(input2);
				td.removeChild(input3);
				td.removeChild(button);	
			}
			td.appendChild(br);
			td.appendChild(input);
			td.appendChild(input2);
			td.appendChild(input3);
			td.appendChild(button);
		}
	
	</script>
</head>
<body>
	<form action="stu.do?method=add" method="post">
	<table bgcolor="purple" cellspacing="1.5" width="60%" align="center">
		<tr bgcolor="white">
			<td align="center">学生姓名：</td>
			<td><input type="text" name="stu_name"></td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">年龄：</td>
			<td><input type="text" name="stu_age"></td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">性别：</td>
			<td><input type="text" name="stu_sex"></td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">说明：</td>
			<td><textarea rows="5" cols="30" name="stu_desc"></textarea> </td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">经历</td>
			<td id="it">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所在学校<br>
				<input type="text" name="jl_starttime"><input type="text" name="jl_endtime"><input type="text" name="jl_school"><input type="button" value="添加" onclick="add()">
			</td>
		</tr>
		<tr bgcolor="white" >
			
			<td colspan="2">
				<input type="submit" value="提交">
				<input type="button" value="取消" onclick="history.back()">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>