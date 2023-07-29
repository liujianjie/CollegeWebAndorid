<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="textml;charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<br />
	<p style="text-align:center;height: 45px;background:#40B9B5;margin:0" ><b>图书列表</b></p>
	<table width="100%" cellpadding="0" cellspacing="0"
		bordercolor="#40B9B5" border="1">

		<tr align="center" height="45" >
			<td width="10%">图书序号</td>
			<td width="25%">图书名称</td>
			<td width="20%">图书图片</td>
			<td width="10%">图书价格</td>
			<td width="15%">操作(编辑/删除)</td>
		</tr>

		<c:forEach items="${books}" var="book">

			<tr align="center">
				<td>${book.id}</td>
				<td>${book.name}</td>
				
				<td><img width="80" height="80"
					src="${pageContext.request.contextPath}/bookimage/${book.pic}"></td>
				<td>${book.price}</td>
				<td>
					<a href="${pageContext.request.contextPath}/FindByIdGoodsServlet?id=${book.id}">
					<img src="${pageContext.request.contextPath}/images/i_edit.gif">
					</a>
					<a href="${pageContext.request.contextPath}/DeleGoodsServlet?id=${book.id}" onclick="return confirm('确定删除吗？')">
					<img src="${pageContext.request.contextPath}/images/i_del.gif" >
					</a>
				</td>

			</tr>

		</c:forEach>

	</table>
</body>
</html>