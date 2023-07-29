<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<script type="text/javascript">
		function createXML(){
			try{
				return new ActiveXObject("Msxm12.XMLHTTP");
			}catch(e){}
			
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){}
			
			try{
				return new XMLHttpRequest();
			}catch(e){}
			
			alert("你的浏览器不支持AJAX");
			return null;
		}
		
		function getNum(){

			var xr=createXML();
			var uname=document.getElementById("text").value;
			xr.open("get","sjwd?name="+uname,"true");
			xr.send("null");
			
			xr.onreadystatechange=function(){
				if(xr.readyState==4){
					if(xr.status==200){
						var text=xr.responseText;
						if(text=="有"){
							document.getElementById("ft").innerHTML="此名称已注册";
						}
						if(text=="没有"){
							document.getElementById("ft").innerHTML="欢迎你，"+uname;
						}
						
						
					}
				}
				
			}
			
		}
	
	</script>

  </head>
  
  <body>
    <h1>XMLHttpRequest对象的创建和使用</h1>
    <br>
    <hr>
    <br>
    <br>
    <font size="4">输入内容：</font><input type="text" id="text"/> <Input type="button" value="发送到服务器" onclick="getNum()">
    <br><br><br>
    <font size="4" id="ft"></font>
  </body>
</html>
