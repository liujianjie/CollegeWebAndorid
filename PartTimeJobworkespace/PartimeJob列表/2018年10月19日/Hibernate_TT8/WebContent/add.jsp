<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="deptemp.do?method=add" method="post">
		部门名称：<input type="text" name="dname"/>
		<br/>
		上级部门ID：<input type="text" name="parentid"/>
		
		
		<br/>
		<br/>
		员工1
		<br/>
		姓名：<input type="text" name="ename"/>
		<br/>
		性别：<input type="text" name="sex"/>
		
		<br/>
		员工2
		<br/>
		姓名：<input type="text" name="ename"/>
		<br/>
		性别：<input type="text" name="sex"/>
		
		<br/>
		<input type="submit" value="添加"/>
	</form>
</body>
</html>