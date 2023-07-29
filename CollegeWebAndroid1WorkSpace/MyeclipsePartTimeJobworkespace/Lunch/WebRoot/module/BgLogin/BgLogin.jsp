<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
  <title>后台登录</title>
  <style>
  	#da{
  		background:url(${path }/resource/img/hou0.jpg) no-repeat center;
  		width:100%;
  		margin:0 auto;
  		height:100%;
  		border:1px solid white;
  	}
	#d{
		background: rgba(0,0,0,0.8);
		width:290px;
		height: 200px;
		margin: 14% auto;
	}
	table tr:hover{
		background: rgba(0,0,0,0.95);
	}
  </style>
   <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
			$(document).ready(function(){
				var width=document.body.scrollWidth;
				var height=document.body.scrollHeight;
				$("#da").css({"width":width+"px","height":height+"px"});
				$("#denglu").click(function(){
					$.ajax({
						url:"${path}/dc/BgLogin",
						data:$("#form1").serialize(),
						type:"post",
						dataType:"json",
						success:function(data){
							//alert(data.state);
							if(data.state){
								window.location.href="${path}"+data.message;
							}else{
								alert("用户名或密码错误");
							}
						}
					});
				});
				
});

  </script>
 </head>
 <body>
 <div id="da">
	 <div id="d">
	 	<form action="${path}/dc/BgLogin" method="post" id="form1">
	 		<table class="table ">
	 			<tr>
	 				<td colspan="2" style="color: yellow;font-size: 140%;text-align: center;">管理员登录</td>
	 			</tr>
	 			<tr>
	 				<td><input type="text" id="yong" name="username" class="form-control" placeholder="请输入用户名"></td>
	 				<td><span class="gou"></span></td>
	 			</tr>
	 			<tr>
	 				<td><input type="password" id="mima" name="pwd" class="form-control" placeholder="请输入密码"></td>
	 				<td width="30px"><span class="gou"></span></td>
	 			</tr>
	 			<tr>
	 				<td colspan="2" style="text-align: right;"><input type="button" id="denglu" class="btn btn-danger" value="登录"></td>
	 			</tr>
	 		</table>
	 	</form>
	 </div>
 </div>
 </body>
</html>

