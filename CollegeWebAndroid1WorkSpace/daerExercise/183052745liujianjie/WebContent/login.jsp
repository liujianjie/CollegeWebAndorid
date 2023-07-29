<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form  action="loginCheck.jsp" method="post">
	<div class="all" id= "all">
    	<div class="title">
        	登录
        </div>
        <div class="one">
        	<span>用户名：</span>
            <input type="text" name="username" value="" placeholder="请输入用户名" height="70"/>
        </div>
        <div class="two">
       	 	<span>密 码：</span>
            <input type="password" name="userpwd" value="" placeholder="请输入密码"/>
        </div>
        <div class="three">
       	 	<input type="submit" class="btn01" value="登录"/>  
			<input type="reset" class="btn02" value="清楚"/>             
        </div>
    </div>
    </form>
</body>
</html>