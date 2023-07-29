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
    
    <title>My JSP 'Bottomadd.jsp' starting page</title>
    

  </head>
  
  <body>
	<form action="bottom?method=add" method="post" > 
    	<h1 align="center">添加分类</h1>
    	
    	请输入你要添加的分类:<input type="text" name="uname">
    	<br>
    	<br>
    	请选择你要选择的类型:
    	<select name="select">
    		<c:forEach items="${list}" var="list">
    			<option value="${list.mold_id }">
    				${list.mold }	
    			</option>			
			</c:forEach>
    	</select>
    	<br/>
    	<input type="submit" value="确定"/>
    </form>
  </body>
</html>
