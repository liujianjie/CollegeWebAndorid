<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登入-JERRY网</title>

  </head>
  <!-- 1500 * 700的大小 -->
  <body background="image/tomandjerryzhuce2.jpg">
  	
    <form action="index?method=yanzheng" onsubmit="return checkright()" name="frm" method="post">
    <table width="28%" align="right" border=0>
    	<tr align="center" height="450">
    		<td>
    			
    		</td>
    	</tr>
    	<tr align="center">
    		<td>
    			<font size="5" color="red">${msg }</font><br>
    			<font size="4" color="black">用户名</font>&nbsp;
    			<input type="text" name="uname" value="${uname }" style="width:150px;height:25px"><br>
    		</td>
    	</tr>
    	<tr align="center" height="50">
    		<td>
    			<br>
    			<font size="4" color="black">密码</font>&nbsp;&nbsp;&nbsp;
    			<input type="password" name="pwd" value="${pwd }" style="width:150px;height:25px"><br>
    		</td>
    	</tr>
    	<tr align="center">
    		<td>
    			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<input type="submit" value="确定" >&nbsp;
    			<input type="button" value="取消" onclick="location.href='qiantai_main/main.jsp'">&nbsp;
    			<input type="button" value="注册" onclick="location.href='qiantai_admin/zhuce.jsp'">
    		</td>
    	</tr>
    </table>
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
