<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="stylesheet" href="css/layout.css" type="text/css" />
<style type="text/css">
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background-color: #42413C;
	background:url(image/1.jpg);
	background-position:center;
	margin: 0;
	padding: 0;
	color: #000;
}
</style>
<script type="text/javascript" src="js/autoplay.js"></script>

</head>

<body>

<div class="container">
  <div class="header"><a href="#">
  	<table cellspacing="0" class="headtable">
		<tr>
			<td width="284">
				<a href="#">
					<img src="image/nba.jpg" width="200" height="80" border="0" /> 
				</a>
			</td>
			<td width="653" style="text-align:right">
				<c:if test="${systemusersession!=null }">
					当前用户:${systemusersession.userName }
				</c:if>
				<c:if test="${systemusersession==null }">
				 <a href="login.html">登录</a>
				| <a href="register.html">注册</a>	
				</c:if>
			</td>			
		</tr>
	</table>
  <!-- end .header --></div>
  <div class="content">
  	<!-- 1.网上球队列表  start -->
    <div id="divmenu">
		<a href="#">首页</a> 
		<a href="#">球队</a> 
		<a href="#">球员</a> 
		<a href="#">排名</a>
		<a href="systemuser?method=userlist">用户管理</a>  
		<a href="#" style="color:#FFFF00">我的球队</a>		
</div>
	<div id="divsearch">
<form action="#" id="searchform">
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td style="text-align:right; padding-right:220px">
				Search 
				<input type="text" name="textfield" class="inputtable" id="textfield" value="请输入球队名/球员名"
				onmouseover="this.focus();"
				onclick="my_click(this, 'textfield');"
				onBlur="my_blur(this, 'textfield');"/> 
				<a href="#">
				<img src="images/serchbutton.gif" border="0" style="margin-bottom:-4px" onclick="search()"/> 
				</a>
			</td>
		</tr>
	</table>
</form>
</div>
<!-- 网上球队列表  end -->

<!-- 2.首页轮播图  start -->
	<div>
    	<table width="50%" align="center" bgcolor="black" cellspacing="1.5">
    	<tr bgcolor="white" height="50">
    		<th>
    			编号
    		</th>
    		<th>
    			姓名
    		</th>
    		<th>
    			登录密码
    		</th>
    		<th>
    			操作
    		</th>
    	</tr>
    	<c:forEach items="${systemuserlist}" var="list">
    		<tr align="center" bgcolor="white" height="40"> 
					<td>${list.userId }</td>
					<td>${list.userName }</td>
					<td>${list.userPassword }</td>
					<td>
						<a href="systemuser?method=toupdate&id=${list.userId }">修改</a>
						<a href="systemuser?method=delete&id=${list.userId }" onclick="return confirm('确定吗？')">删除</a>
					</td>
			</tr>
    	</c:forEach>
    </table>
	</div>
	<!-- 2.首页轮播图  end -->
    
    <!-- 3.公告板和本周热点  start -->
    <div id="divcontent">
		<table width="900px" border="0" cellspacing="0">
			<tr>
				<td width="497">
				
					<img src="images/billboard.gif" width="497" height="38" />
					<table cellspacing="0" class="ctl">
						<tr>
							<td width="485" height="29">
                            <font face="仿宋">
                            尊敬的球队经纪人， 　　<br />
　　为了让大家能更便捷得管理球队，3月25日起，当日达业务关小黑屋回炉升级！    <br /><br /> 具体开放时间请留意公告，感谢大家的支持与理解，祝大家的球队越来越好！<br />
        3月23日<br />
        NBA网上系统管理部<br />
                            </td>
						</tr>
					</table>
				</td>
				<td style="padding:5px 15px 10px 40px">
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td>
								<img src="images/hottitle.gif" width="126" height="35" />
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0">
						<tr>						
							<td style="width:80; text-align:center">
								<a href="#">
								<img src="images/a.jpg" width="102" height="130" border="0" />
								</a>
								<br /> 
							</td>		
							<td style="width:80; text-align:center">
								<a href="#">
								<img src="images/b.jpg" width="102" height="130" border="0" />
								</a>
								<br /> 
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
    <!-- 3.公告板和本周热点  end -->	
    
    <!-- end .content --></div>
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
            <span class="gray">©2018 NBA Players Information Management System. All Rights Reserved.</span></p>
    </blockquote>
  </div>
</div>
</body>
</html>
