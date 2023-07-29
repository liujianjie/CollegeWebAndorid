<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'iframe.jsp' starting page</title>

	<style>
		#size{ min-height: 200px; _height: 200px; }
		.test_box {  
		 	width: 400px;
		    min-height: 120px;
		    max-height: 300px;
		    _height: 120px;  
		  	margin-left: auto; 
		    margin-right: auto; 
		    padding: 3px;
		    outline: 0; 
		    border: 1px solid #a0b3d6;
		    font-size: 12px;
		    word-wrap: break-word;
		    overflow-x: hidden; 
		    overflow-y: auto;
		    _overflow-y: visible;}
	</style>
  </head>
  
  <body>
    HTML代码：

<div class="test_box" contenteditable="true"><br /></div> 
  </body>
</html>