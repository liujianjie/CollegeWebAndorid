<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册-JERRY网</title>

  </head>
  
  <body background="image/tomandjerryzhuce3.jpg" >
  	<br><br><br><br><br><br><br><br><br><br>
  	<form onsubmit="return checkyixie()" action="index?method=checkuname" method="post" name="frm" >
  	<table border="0" width="35%" align="center">
  		<tr height=40>
			<td align="right">
				用户名:<!-- 先记着 不能同名 -->
			</td>
			<td width="25">
				<input type="text" name="uname" style="width:320px;height:35px" value="${uname}" onblur="checkuname()">
				<br><font color="red">${cunzai }</font>
				
			</td>
		</tr>
		<tr height=40>
			<td align="right">
				手机号:
			</td>
			<td>
				<input type="text" name="phone" value="${phone}" style="width:320px;height:35px">
			</td>
		</tr>
		
		<tr height=40>
			<td align="right">
				出生年月:
			</td>
			<td>
				<input type="text" name="year" value="${year}" size=3 style="height:35px"/>年
  				<input type="text" name="month" value="${month}" size=3 style="height:35px"/>月
  				<input type="text" name="day" value="${day}" size=3 style="height:35px"/>日
			</td>
		</tr>
    	<tr height=40>
			<td align="right">
				创建密码:
			</td>
			<td>
				<input type="password" name="pwd1" value="${pwd}" style="width:320px;height:35px">
			</td>
		</tr>
    	<tr height=40>
			<td align="right">
				确认密码:
			</td>
			<td>
				<input type="password" name="pwd2" value="${pwd}" style="width:320px;height:35px">
			</td>
		</tr>
  		<tr align="center" height=40>
  			<td colspan="2">
  				<input type="submit" value="提交" style="width:70px;height:35px">
  				<input type="button" value="取消" style="width:70px;height:35px" onclick="location.href='qiantai_main/main.jsp'">
  			</td>
   		</tr>
  
  	</table>
  	</form>
    <script>
    	function checkuname(){
    		document.frm.submit();
    	}
    	function checkyixie(){  		
    		var phone=document.frm.phone.value;
    		var user=document.frm.uname.value;
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
			else if(user==""||user.trim()<11){
				alert("请输入用户名");
				document.frm.uname.focus();
				return false;
			}
			else if(year==""||year.length<4||year<1900||year>2016||isNaN(year)){
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
			}else{
				return true;
			}
    	}
    
    </script>
  </body>
</html>
