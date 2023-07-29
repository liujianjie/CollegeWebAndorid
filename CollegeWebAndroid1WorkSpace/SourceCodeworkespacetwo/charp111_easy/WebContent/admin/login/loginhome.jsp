<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.box1{background:url(loginbg.gif) no-repeat 4px 5px}
body {margin:0px;}
</style>


</head>
<body >
<div align="center">
<img src="${pageContext.request.contextPath}/admin/images/logintitle.gif">
</div>



<div class="box1" align="center" >

<form action="/charp111_easy/admin/login/home.jsp"  method="post">
<h1>请登录</h1>
&nbsp;&nbsp;&nbsp;用户名:<input type ="text" name="username"/><br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type ="password" name="password"/><br>

<br>
<br>
<br>

<input type ="submit" value="登录"/>
<input type ="reset" value="取消"/>


</form>
</div>

</body>
</html>