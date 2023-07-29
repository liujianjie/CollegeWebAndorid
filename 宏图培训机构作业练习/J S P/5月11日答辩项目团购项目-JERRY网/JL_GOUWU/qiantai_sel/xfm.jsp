<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>消费码</title>
	<style>
		a{text-decoration: none;color:#008080 }
		a:hover{color:#95361A}
	</style>
  </head>
  
  <body>
   	
   	
   	<br><br>
  	<div align="center">
    	<font size="6" color="#95361A ">下单成功,你的消费码为:${xfm },请自行到商店消费。</font>
    	<br><br>
    	<a href="index?method=selorders"><font color="#008080">查看订单</font></a>
   		<a href="qiantai_main/main.jsp"><font color="#008080">返回首页</font></a>
    	<br>
    	<hr width="50%">
    	<br>
    	<span id="sp">10</span>秒后自动返回主页面
    </div>
    <script>
    	setInterval("time()",1000);
    	var i=10;
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
