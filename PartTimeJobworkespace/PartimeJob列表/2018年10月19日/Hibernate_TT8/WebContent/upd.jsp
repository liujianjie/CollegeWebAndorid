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
	<form action="deptemp.do?method=upd" method="post">
	<input type="text" name="did" value="${dept.did }"/>
		部门名称：<input type="text" name="dname" value="${dept.dname }"/>
		<br/>
		上级部门ID：<input type="text" name="parentid" value="${dept.parentId }"/>
		
		
		<br/>
		<br/>
		<c:forEach items="${dept.employees }" var="emp" varStatus="ind">
		员工${ind.index+1 } <input type="text" name="eid" value="${emp.eid }"/>
		<br/>
		姓名：<input type="text" name="ename" value="${emp.ename }"/>
		<br/>
		性别：<input type="text" name="sex" value="${emp.sex }"/>
		
		<br/>
		<br/>
		<br/>
		</c:forEach>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>