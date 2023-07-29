<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>仓库管理系统--登录</title>
    <meta name="keywords" content="仓库管理系统">
    <meta name="description" content="对仓库进行系统管理。">
	
	
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
  
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=3.2.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <h3>仓库管理系统</h3>

            <form class="m-t" role="form" action="user/login.do" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="用户名" required="required" value="刘宗龙">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="密码">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            </form>
        </div>
    </div>

  
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>

   

</body>

</html>