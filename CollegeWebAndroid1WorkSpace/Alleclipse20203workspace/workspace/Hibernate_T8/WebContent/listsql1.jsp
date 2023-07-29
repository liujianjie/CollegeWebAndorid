<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>员工列表</title>
</head>
<body>
	<table width="70%" cellspacing="1.5" align="center" bgcolor="purple">
		<tr bgcolor="white" height="30">
			<th>员工姓名</th>
			<th>员工性别</th>
			<th>所属部门</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="emp">
			<tr align="center" bgcolor="white">
				<c:forEach items="${emp }" var="ee" varStatus="ind">
					<c:if test="${ind.index+1!=4 }">
						<td>
							${ee}	
						</td>
					</c:if>
					
				</c:forEach>
				<td>
					修改
					删除
				</td>
			</tr>
		</c:forEach>
		<tr bgcolor="white">
			<td colspan="4">
				当前页:<font color="red">${currPage }</font>/<font color="red">${totalPage }</font>,
				共${rowCount }条数据
				<a href="page.do?method=hibernatebysql&currpage=1">首页</a>
				<a href="page.do?method=hibernatebysql&currpage=${currPage-1 }">上一页</a>
				<a href="page.do?method=hibernatebysql&currpage=${currPage+1 }">下一页</a>
				<a href="page.do?method=hibernatebysql&currpage=${totalPage }">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>