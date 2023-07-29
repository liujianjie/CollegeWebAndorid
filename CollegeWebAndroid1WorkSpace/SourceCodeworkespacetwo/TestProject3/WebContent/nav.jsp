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
<div id="divmenus"> 

  <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
  <a href="${pageContext.request.contextPath}/BookSearchAllServlet?catalog=1">计算机</a>
  <a href="${pageContext.request.contextPath}/BookSearchAllServlet?catalog=2">艺术</a>
  <a href="${pageContext.request.contextPath}/BookSearchAllServlet?catalog=3">外语</a>
  <a href="${pageContext.request.contextPath}/BookSearchAllServlet?catalog=4">哲学</a>
</div>
</body>
</html>