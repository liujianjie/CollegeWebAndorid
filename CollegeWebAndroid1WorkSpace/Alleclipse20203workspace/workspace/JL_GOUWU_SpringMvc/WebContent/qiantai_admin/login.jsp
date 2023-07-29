<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登入-JERRY网</title>
     <style>

    	body{
			background: url(image/qiantaibackground.jpg) bottom center no-repeat #efeff4 ;

		    background-size: 100% 100%;
		
		    width: 100%;
		
		    height: 100%;
		    background-attachment:fixed;
		    overflow:hidden
		}
    </style>
	<style>
		.all{
			width:320px;
			height:180px;
			padding:10px;
			margin:200px 20% 200px auto;
			border-radius:20px;
			border:3px solid #F00;
			background:#FFF
		}
		.title,.one,.two,.three{
			margin-top:15px;
			text-align:center;
		}
		.title,.one,.two{
			font-family:"微软雅黑";
		}
		.one input,.two input{
			padding-left:5px;
		}
		.title{
			font-size:18px;
		}
		.btn01,.btn02{
			width:60px;
			height:25px;
			border-radius:3px;
			border:1px solid #6b5d50;
			margin-left:30px;
		}
		.btn01{
			background:#3bb7ea;
		}
		.btn02{
			background:#fb8c16;
		}
		.btn03{
			background:#a69426;
		}
		.errorClass {background: url(image/error.png) no-repeat; color: #f40000; font-size: 10pt; border:1px solid #ffb8b8; background-color: #fef2f2; padding: 8px 8px 8px 35px;}
	</style>
  </head>

<body>
	<form action="index/yanzheng" onsubmit="return checkright()" name="frm" method="post">
	<div class="all" id= "all">
	    	<div class="title">
	        	<c:if test="${msg!=null}">
					<label class="errorClass"
						id="loginnameError">${msg }</label>
				</c:if>
				<c:if test="${msg==null}">欢迎回来
				</c:if>
	        </div>
	        <div class="one">
	        	<span>用户名:</span>
	            <input type="text" name="uname" value="${uname }" placeholder="请输入邮箱" height="70">
	        </div>
	        <div class="two">
	       	 	<span>密 码：</span>
	       	 	<input type="password" name="pwd" value="${pwd }" placeholder="请输入密码">
	        </div>
	        <div class="three">
	       	 	<input type="submit" class="btn01" value="登录"/> 
	       	 	<input type="button" class="btn02" value="注册"  onclick="location.href='qiantai_admin/zhuce.jsp'"/>            
	        </div>
	    </div>
    </form>
	   <script>
	
    	document.frm.uname.focus();
    	function checkright(){
    		var uname=document.frm.uname.value;
    		if(uname==""||uname.trim()==""){
    			alert("用户名不能为空");
    			document.frm.uname.focus();
    			return false;
    		}
    		var pwd=document.frm.pwd.value;
    		if(pwd==""||pwd.trim()==""){
    			alert("密码不能为空");
    			document.frm.uname.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
</body>
</html>
