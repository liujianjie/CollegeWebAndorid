<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" href="css/main.css" rel="stylesheet"/>
 <link type="text/css" href="css/autoplay.css" rel="stylesheet"/> 
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body>
<!--1.LOGO --> 
<%@include  file="head.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp"  %>
<!-- 网站首页轮播图 -->

<div align="center">
 <h1>新会员注册</h1><br/>
 <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
	  <table width="400px" border="0" cellspacing="2">
		   <tr>
		    <td style="text-align:right">会员名</td>
		    <td><input type="text" name="username" />${errorMessage}</td>
		   </tr>
		   <tr>
		    <td style="text-align:right">密码</td>
		    <td><input type="password" name="password" /></td>
		   </tr>
		  
		   <tr>
		    <td style="text-align:right">重复密码</td>
		    <td><input type="password" name="repassword" /></td>
		   </tr>
		    <tr>
		    <td style="text-align:right">性别</td>
		    <td><input type="radio" name="sex" value="男" checked="checked" />男
		        &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;  &nbsp;
		        <input type="radio" name="sex" value="女" />女</td>
		   </tr>
		    <tr>
		    <td style="text-align:right">生日</td>
		    <td><input type="text" name="birthday" />(YYYY-MM-DD)</td>
		   </tr>
		   <tr>
		    <td style="text-align:right">联系电话</td>
		    <td><input type="text" name="telephone" /></td>
		   </tr>
		    <tr>
		    <td style="text-align:right">邮箱</td>
		    <td><input type="text" name="email" /></td>
		   </tr>
		   
		   <tr>
		    <td style="text-align:right">角色</td>
		    <td><input type="radio" name="role" value="1"/>管理员
				<input type="radio" name="role" value="0"/>普通用户
			</td>
		   </tr>
		   
		   <tr>
		    <td style="text-align:right">个人介绍</td>
		    <td><textarea name="introduce" cols="40s" rows="5" /></textarea></td>
		   </tr>   
		    <tr>
		       <td colspan="2" align="center">
		       <!-- 6.提交按钮控件 -->
		       <input type="submit" value="注册" />
		       <!-- 7.重置按钮控件，单击后会清空当前from -->
		       <input type="reset" value="重填" />
		       </td>
		     </tr>
	  </table>
 </form>
 </div>
 <br>
 <!-- 底部版权栏 -->
	<%@include  file="foot.jsp"  %>
</body>
</html>