<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    
    <title>My JSP 'alertemp.jsp' starting page</title>

  </head>
  
  <body>
  <form action="bottom/alert" method="post" > 
  	<input type="hidden" name="id" value="${bot.bottom_id}"/>
    	<h1 align="center">修改分类</h1>
    	
    	请修改你的分类:<input type="text" name="uname" value="${bot.bottom }">
    	<br>
    	<br>
    	请选择你要选择的类型:
    	<select name="select">
    		<c:forEach items="${list}" var="l">
    			<option value="${l.mold_id }" <c:if test="${l.mold_id eq bot.mold_id }">selected</c:if>>
    				${l.mold }	
    			</option>			
    			<c:out value="${l.mold}"></c:out>
			</c:forEach>
    	</select>
    	
    	<br/>
    	<input type="submit" value="确定"/>
    </form>
  </body>
</html>
