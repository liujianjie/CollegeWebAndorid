<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 2.网站菜单列表 -->
<div id="divmenu"> 

  <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=1">计算机</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=2">文学</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=3">历史</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=4">传记</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=5">青春</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=6">社科</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=7">心理</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=8">经济</a>
  <a href="${pageContext.request.contextPath}/FindAllBooksServlet?catalog=9">管理</a>
</div>
</body>
</html>