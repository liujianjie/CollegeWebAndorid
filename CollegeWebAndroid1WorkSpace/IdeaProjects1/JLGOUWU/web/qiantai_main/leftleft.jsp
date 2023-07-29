<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'leftleft.jsp' starting page</title>
	<style>
		.topshouye{
			border-style:solid; 
			border-width:1px;
			border-top-color:#008080;
			border-bottom-color:#008080;
			border-right-color:#008080;
			border-left-color:#008080;
			background-color:#008080;
			height:48px;
			width:70px;
			
		}

	</style>
  </head>
  
  <body style="margin:0px;padding:0px">
  	<table width="100%" bgcolor="#008080" border=0 style="margin-top: 1px;">
		<tr align="center">
			<td width="100">
				<div class="topshouye">
				&nbsp;
				</div>
			</td>
		</tr>
	</table>

	<img src="image/left2.png">
	
	
  </body>
</html>
