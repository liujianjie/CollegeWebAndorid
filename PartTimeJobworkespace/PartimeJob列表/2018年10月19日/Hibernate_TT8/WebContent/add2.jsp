<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="deptemp.do?method=add2" method="post">
		部门名称：<select name="did">
			<c:forEach items="${deptlist }" var="dept">
				<option value="${dept.did }">${dept.dname }</option>
			</c:forEach>
		</select>
		
		
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