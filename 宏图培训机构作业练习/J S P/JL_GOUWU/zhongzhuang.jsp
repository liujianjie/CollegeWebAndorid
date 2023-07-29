<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhongzhuang.jsp' starting page</title>
  <style>
    	a{text-decoration: none}
    </style>
  </head>
  
  <body>
    <br><br>
  	<div align="center">
    	<font size="6" color="#95361A ">页面出了点小问题</font>
    	<br><br>
    	<a href="qiantai_main/main.jsp"><font color="#008080">返回首页</font></a>
    	<br>
    	<hr width="50%">
    	<br>
    	<span id="sp">5</span>秒后自动返回主页面
    </div>
    <script>
    	setInterval("time()",1000);
    	var i=5;
    	function time(){
    		i--;
    		document.getElementById("sp").innerHTML=i;
    		if(i==0){
    			location.href="qiantai_main/main.jsp";
    		}
    	}
    	
    
    </script>
  </body>
</html>
