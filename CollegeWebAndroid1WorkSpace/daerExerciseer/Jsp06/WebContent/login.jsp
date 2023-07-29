<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP程序网上考试系统</h3>
	<hr>
	<form action="welcome.jsp" method="post">
		请输入姓名：<input type="text" name="uname"/>
		请选择班级：
		<select name="class">
			<option value="安卓1801">安卓1801</option>
			<option value="安卓1802">安卓1802</option>
			<option value="安卓1803">安卓1803</option>
			<option value="安卓1804">安卓1804</option>
		</select>
		<br>
		1.在家里你最无聊的时刻()<br>
		<input type="radio" name="1" value="A"/>早上<br>
		<input type="radio" name="1" value="B"/>中午<br>
		<input type="radio" name="1" value="C"/>晚上<br>
		<input type="radio" name="1" value="D"/>深夜<br>
		
		2.你的身高()<br>
		<input type="radio" name="2" value="A"/>160<br>
		<input type="radio" name="2" value="B"/>170<br>
		<input type="radio" name="2" value="C"/>180<br>
		<input type="radio" name="2" value="D"/>190<br>
		
		3.在家里你是什么多了()<br>
		<input type="checkbox" name="3" value="A"/>胖多了<br>
		<input type="checkbox" name="3" value="B"/>睡多了<br>
		<input type="checkbox" name="3" value="C"/>闲多了<br>
		<input type="checkbox" name="3" value="D"/>自由多了<br>
		<input type="checkbox" name="3" value="E"/>被爸妈嫌弃多了<br>
		<input type="checkbox" name="3" value="F"/>知识多了<br><br><br><br>
		
		<input type="submit" value="提交"/>
	</form>
</body>
</html>