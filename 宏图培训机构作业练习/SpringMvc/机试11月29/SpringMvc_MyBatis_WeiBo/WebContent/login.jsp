<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>微博登录</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				var uname = $("#unames").val();
				var pwd = $("#pwds").val();
				$.post("${pageContext.request.contextPath }/login.do",{"uname":uname,"pwd":pwd},function(result){
					//登录失败
					if(result=='0'){
						$("#span").html("用户名或者密码错误");						
					}else{
						//location
						location.href="${pageContext.request.contextPath }/bloglist.do?cpage=1";
					}
				},"json")				
				
			});
		});
	</script>
</head>
<body>
	<p>用户：<input type="text" id="unames" ></p>
	<p>密码：<input type="password" id="pwds"></p>
	<p><input type="button" value="登录" id="btn"><span id="span"></span></p>
</body>
</html>