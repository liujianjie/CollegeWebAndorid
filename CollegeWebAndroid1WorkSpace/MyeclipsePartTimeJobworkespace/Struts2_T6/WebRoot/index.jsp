<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
    <table cellspacing="1.5" bgcolor="purple" width="60%" align="center">
    	<tr bgcolor="white">
    		<th>姓名</th>
    		<th>性别</th>
    		<th>状态</th>
    	</tr>
    	<s:iterator value="#list" var="user">
    		<tr bgcolor="white" align="center">
	    		<td><s:property value="#user.uname"/> </td>
	    		<td><s:property value="#user.uname"/></td>
	    		<td>
	    			<s:if test="#user.state==1">在线</s:if>
	    			<s:elseif test="#user.state==0">离线</s:elseif>
	    			<s:else>不存在</s:else>
	    		</td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>


