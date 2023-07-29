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
    <table width="35%" align="center" bgcolor="black" cellspacing="1.5">
    	<tr bgcolor="white" height="50">
    		<th>
    			编号
    		</th>
    		<th>
    			类型
    		</th>
    	</tr>
    	<c:forEach items="${list}" var="list">
    		<tr align="center" bgcolor="white" height="40"> 
					<td>${list.mold_id }</td>
					<td>${list.mold }</td>
			</tr>
    	</c:forEach>
    </table>
  </body>
</html>
