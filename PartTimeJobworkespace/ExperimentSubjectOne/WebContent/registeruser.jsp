<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户界面</title>
<style type="text/css">
body {
	background-image:url(image/5.jpg);
	background-position:center;
	
	 margin: 0;
    padding: 0;
    background: url(image/5.jpg);
    repeat: no-repeat;
    background-attachment:fixed;
    filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='image/5.jpg', sizingMethod='scale');
    -ms-filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='image/5.jpg', sizingMethod='scale');
    background-size: cover;
    -moz-background-size: cover;
    -webkit-background-size: cover;
	}
.header{
	
}
.header_logo{
	float:left;
	_display:inline;
	width:250px;
	height:100px;
	margin-top:14px;
	margin-left:17px;
	text-indent:-9999em;
	background-size:200px 100px;
	background-repeat:no-repeat;
	background-position:left center;
	background-image:url(image/nba.jpg);
	_background-image:url(image/nba.jpg);
	}
.header_link{
	overflow:hidden;
	margin-top:35px;
	padding-right:17px;
	line-height:30px;
	text-align:right;
	color:#0A0A0A;
	font-family:华文行楷;
	font-size:60px;
	}
	
</style>

<script type="text/javascript" src="js/register.js"></script>
</head>

<body>
	<div class="container">
		<div class="header">
        	<p class="header_logo" href="/">登录界面</p>
        	<div class="header_link">
        		<p>球员信息管理系统</p>
            <!-- end .header --></div>
    	<!-- end .header --></div>
        
        <div class="content">
        	<div id="divcontent" align="center">
			<form action="systemuser?method=register" method="post" onsubmit="return checkForm();">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding: 30px"  ><h1>新用户注册</h1>
						<table width="79%" height="350px" border="0" cellspacing="2" class="upline"  bgcolor="white">
							<tr>
								<td width="21%" style="text-align: right">用户名：</td>
								<td width="30%"><input type="text" class="textinput"  id="username" name="username" onkeyup="checkUsername();"/>
								</td>
								<td colspan="2"><span id="usernameMsg"></span><font color="#262626">字母下划线1到10位, 不能是数字</font></td>
							</tr>
							<tr>
								<td style="text-align: right">密码：</td>
								<td><input type="password" class="textinput"  id="password" name="password" onkeyup="checkPassword();"/></td>
								<td width="46%"><span id="passwordMsg"></span><font color="#262626">密码请设置6-16位字符</font></td>
							</tr>
							<tr>
								<td style="text-align: right">重复密码：</td>
								<td>
								<input type="password" class="textinput"  id="repassword" name="repassword" onkeyup="checkConfirm();"/>
								</td>
								<td><span id="confirmMsg"></span>&nbsp;</td>
							</tr>
<!-- 							<tr> -->
<!-- 								<td style="text-align: right">性别：</td> -->
<!-- 								<td colspan="2">&nbsp;&nbsp; -->
<!--                                 <input type="radio" name="gender" value="男" checked="checked" /> 男 -->
<!-- 									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<!-- 									<input type="radio" name="gender" value="女" /> 女 -->
<!-- 								</td> -->
<!-- 								<td width="3%">&nbsp;</td> -->
<!-- 							</tr> -->
<!-- 							<tr> -->
<!-- 								<td style="text-align: right">联系电话：</td> -->
<!-- 								<td colspan="2"> -->
<!-- 								<input type="text" class="textinput" -->
<!-- 									style="width: 350px" name="telephone" /> -->
<!-- 								</td> -->
<!-- 								<td>&nbsp;</td> -->
<!-- 							</tr> -->
<!-- 							<tr> -->
<!-- 								<td style="text-align: right">个人介绍：</td> -->
<!-- 								<td colspan="2"> -->
<!-- 								<textarea class="textarea" name="introduce"></textarea> -->
<!-- 								</td> -->
<!-- 								<td>&nbsp;</td> -->
<!-- 							</tr> -->
							
						</table>
                       
						<table width="79%" border="0" cellspacing="0" >
							<tr>
								<td style="padding-top: 20px; text-align: center">
								  <input type="image" src="image/signup.gif" name="submit" border="0"/>
								</td>
						  </tr>
					  </table>
                      </form>
                      </div>
                      
        <!-- end .content --></div>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
		
		<div class="footer">
			
          <blockquote>
            <p><a href="" target="_blank">关于我们</a>
              &nbsp;|&nbsp;
              <a href="">服务条款</a>
              &nbsp;|&nbsp;
              <a href="" target="_blank">客服中心</a
            >&nbsp;|&nbsp;
              <a href="" target="_blank">联系我们</a>
              &nbsp;|&nbsp;
              <a href="" target="_blank">帮助中心</a>
              &nbsp;|&nbsp;
              <span class="gray">©2018 NBA Players Information Management System. All Rights Reserved.</span>
            </p>
          </blockquote>
        <!-- end .footer --></div>
<!-- end .container --></div>

</body>
</html>
