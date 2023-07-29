<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Moldlist.jsp' starting page</title>
    <style>
  		a{text-decoration: none}
  	</style>

  </head>
  
  <body>
    <table width="50%" align="center" bgcolor="black" cellspacing="1.5">
    	<tr bgcolor="white" height="50">
    		<th>
    			编号
    		</th>
    		<th>
    			分类名
    		</th>
    		<th>
    			归属类型
    		</th>
    		<th>
    			操作
    		</th>
    	</tr>
    	<c:forEach items="${list}" var="list">
    		<tr align="center" bgcolor="white" height="40"> 
					<td>${list.bottom_id }</td>
					<td>${list.bottom }</td>
					<td>${list.mold }</td>
					<td>
						<a href="bottom?method=goalert&id=${list.bottom_id }">修改</a>
						<a href="bottom?method=del&id=${list.bottom_id }" onclick="return confirm('一旦删除该分类下的商品都会删除，确定删除此分类吗？')">删除</a>
					</td>
			</tr>
    	</c:forEach>
    </table>
  </body>
</html>
