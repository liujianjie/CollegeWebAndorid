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
    <title>用户注册-JERRY网</title>
    
	<style>
    	/* per */
    	body{
			background: url(image/qiantaibackground.jpg) bottom center no-repeat #efeff4 ;

		    background-size: 100% 100%;
		
		    width: 100%;
		
		    height: 100%;
		    background-attachment:fixed;
		    overflow:hidden
		}
		.title{
			font-family:"微软雅黑";
			font-size:25px;
		}
	
		table{
			margin:170px 20% 200px auto;
			border-radius:20px;
			border:3px solid #F00;
			background:#FFF;
			padding:10px;
		}
		table tr td{
			padding:8px;
		}
		.btn01,.btn02,.btn03{
			width:60px;
			height:25px;
			border-radius:3px;
			border:1px solid #6b5d50;
			margin-left:10px;
		}
		.btn01{
			background:#3bb7ea;
		}
		.btn02{
			background:#fb8c16;
		}
		
		.btn03{
			background:#DA424E;
		}
		.errorClass {background: url(image/error.png) no-repeat; color: #f40000; font-size: 10pt; border:1px solid #ffb8b8; background-color: #fef2f2; padding: 8px 8px 8px 35px;}
	</style>
  </head>

<body>
	<form onsubmit="return checkyixie()" action="index?method=checkuname" method="post" name="frm" >
	  <table>
		<tr>
		  <td colspan="2" align="center" class="title">新用户注册</td>
		</tr>
		<tr>
		  <td>用户名称</td>
		  <td><input type="text" name="uname" value="${uname}" placeholder="请输入用户名称"></td>
		</tr>
		<tr>
		  <td>手机号码</td>
		  <td><input type="text" name="phone" value="${phone}" placeholder="请输入电话"></td>
		</tr>
		<tr>
		  <td>出生年月</td>
		  <td>
		  	<input type="text" name="year" value="${year}" size=3 placeholder="请输入年"/>
			<input type="text" name="month" value="${month}" size=3 placeholder="请输入月"/>
			<input type="text" name="day" value="${day}" size=3 placeholder="请输入日"/>
		  </td>
		</tr>
		<tr>
		  <td>登录密码</td>
		  <td><input type="password" name="pwd1" value="${pwd}" placeholder="请输入密码"></td>
		</tr>
		<tr>
		  <td>确认密码</td>
		  <td><input type="password" name="pwd2" value="${pwd}" placeholder="请确认密码"></td>
		</tr>
		<c:if test="${cunzai!=null}">
			<tr>
			  <td colspan="2" align="center">
			  	<label class="errorClass" id="loginnameError">${cunzai }</label>
			  </td>
			</tr>
		</c:if>
		
		<tr>
		  <td colspan="2" align="center">
			<input type="submit" class="btn01" value="注册" >
			<input type="button" class="btn02" value="登录" onclick="location.href='qiantai_admin/login.jsp'">
			<input type="button" class="btn03" value="首页" onclick="location.href='qiantai_main/main.jsp'">
		  </td>
		</tr>
	  </table>
	</form>
	<script>
    	function checkyixie(){  		
    		var phone=document.frm.phone.value;
    		var user=document.frm.uname.value;
    		var birthdate=document.frm.year.value;
    		var year=document.frm.year.value;
    		var month=document.frm.month.value;
    		var day=document.frm.day.value;
    		var pwd1=document.frm.pwd1.value;
    		var pwd2=document.frm.pwd2.value;
    		if(phone==""||phone.length<11){
				alert("电话输入不正确");
				document.frm.phone.focus();
				return false;
			}
			else if(user=="" || user.length < 3 || user.length > 10){
				alert("用户名为空，字符为3~10个");
				document.frm.uname.focus();
				return false;
			}
			else if( year==""||year<1900||year>2019|| isNaN(year) ){
				alert("请输入正确的年份");
				document.frm.year.focus();
				return false;
			}
			else if(month==""||month>12||isNaN(month)){
				alert("请输入正确的月份");
				document.frm.month.focus();
				return false;
			}
			else if(day==""||day>31||isNaN(day)){
				alert("请输入正确的天");
				document.frm.day.focus();
				return false;
			}
			else if(pwd1==""||pwd1.trim()==""){
				alert("密码不能为空");
				document.frm.pwd1.focus();
				return false;
			}
			else if(pwd2==""||pwd1!=pwd2){
				alert("两次密码不一致");
				document.frm.pwd2.focus();
				return false;
			}
    		return true;
    	}
    
    </script>
</body>
</html>
