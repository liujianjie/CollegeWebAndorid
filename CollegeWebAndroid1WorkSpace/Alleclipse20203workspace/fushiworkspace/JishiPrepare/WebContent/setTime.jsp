<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置工作与不工作时间</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/setWorkAndNoWorkTime" method="post">
		<p>是否工作：工作<input type="radio" name="type" value="0">， 不工作<input type="radio" name="type" value="1"></p>
		<p>
			设置天：
			<select name="day">
				<option value="1">周一</option>
				<option value="2">周二</option>
				<option value="3">周三</option>
				<option value="4">周四</option>
				<option value="5">周五</option>
				<option value="6">周六</option>
				<option value="7">周七</option>
				<option value="8">每周</option>
			</select>
		</p>
		<p>设置开始时间：小时 <input type="text" name="starthour">，分钟 <input type="text" name="startmin"></p>
		<p>设置结束时间：小时<input type="text" name="endhour">，分钟 <input type="text" name="endmin"></p>
		<p><input type="submit" value="提交"/></p>
	</form>
</body>
</html>