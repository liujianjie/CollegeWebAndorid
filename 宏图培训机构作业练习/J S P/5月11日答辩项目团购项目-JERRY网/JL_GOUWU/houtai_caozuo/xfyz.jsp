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
    
    <title>My JSP 'xfyz.jsp' starting page</title>
    
  </head>
  
  <body>
  <br><br><br>
    <form action="index?method=xfyz&orderid=${orderid }" method="post" >
    	<table width="50%" border=0 align="center">
    		<tr height="50" align="center">
    			<td colspan="2">
    				<font size="5">消费码存在</font>
    			</td>
    		</tr>
    		<tr height="50" align="center">
    			<td>
    				<font size="3">消费码:</font>
    				<c:if test="${statu==1}">
    					<font size=4 color="red">未消费</font>
    				</c:if>
    				<c:if test="${statu==2}">
    					<font size=4 color="red">已消费</font>
    				</c:if>
    			</td>
    		</tr>
    		<tr height="50">
    			<td align="center" colspan="2">
    				<c:if test="${statu==1}">
    					<input type="submit" value="现在消费">
    					<a href="houtai_caozuo/goxfyz.jsp">返回</a>
    				</c:if>
    				<c:if test="${statu==2}">
    					<a href="houtai_caozuo/goxfyz.jsp">返回</a>
    				</c:if>
    			</td>
    		</tr>
    	</table>
  		<br><br>
  		
  	</form>
  </body>
</html>
