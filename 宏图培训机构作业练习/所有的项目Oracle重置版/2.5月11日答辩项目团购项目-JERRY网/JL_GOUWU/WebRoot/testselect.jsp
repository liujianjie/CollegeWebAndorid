<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testselect.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.drop{
			position: relative;
    		display: inline-block;
		}

		.dropbtn {
		    background-color:#00cc99;
			font-family:"微软雅黑";
		    color: white;
		    padding: 18px;
		    font-size: 16px;
		    border: none;
		    cursor: pointer;
		    margin-top: 16px;
		}
		
		
		.dropdown {
		    display: none;
		 	position: absolute;
			background-color: #f9f9f9;
			min-width: 160px;
			box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		}
		.dropdown a {
		   	color: black;
		    padding: 12px 16px;
		    text-decoration: none;
		    display: block;
		}	
		.dropdown a:hover {
			background-color: #f1f1f1;
		}
		
		
		.drop:hover .dropdown{
   			display: block;
		}

		.drop:hover .dropbtn {
  			background-color: #00ffff;
		}

	</style>
  </head>
  
  <body>
  	<!-- 实现下拉得有两个div，一个div来显示它的表面意思，一个保存值并实现 -->
    <div class="drop">
    	<button class="dropbtn" style="width:100%">实现下拉</button>
    	<div class="dropdown">
    		<a href="#">美食</a>
    		<a href="#">电影</a>
    		<a href="#">KTV</a>
    		<a href="#">休闲娱乐</a>
    		<a href="#">生活服务</a>
    		<a href="#">购物</a>
    	</div>
    </div>
  
  </body>
</html>
