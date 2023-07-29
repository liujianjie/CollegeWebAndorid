<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tou.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<!-- topbar starts -->
		<div class="navbar navbar-default" role="navigation">

			<div class="navbar-inner">
				<button type="button" class="navbar-toggle pull-left animated flip">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"> <img
						alt="Charisma Logo" src="img/5.png" class="hidden-xs" /> <span>HONGTU</span>
				</a>

				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<button class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<i class="glyphicon glyphicon-user"></i><span
							class="hidden-sm hidden-xs">
								<c:choose>
									<c:when test="${login == '0' }"> ${teacher.ename } </c:when>
									<c:when test="${login == '1' }"> ${stu.intenname } </c:when>
								</c:choose>
							</span>
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li>
							<a href="#">Profile</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="login.jsp">退出</a>
						</li>
					</ul>
				</div>
				<!-- user dropdown ends -->

				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container animated tada">
					<button class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<i class="glyphicon glyphicon-tint"></i><span
							class="hidden-sm hidden-xs"> 皮肤</span>
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" id="themes">
						<li>
							<a class="ajax-link" data-value="classic" href="index.jsp"><i
								class="whitespace"></i> Classic</a>
						</li>
						<li>
							<a class="ajax-link" data-value="cerulean" href="index.jsp"><i
								class="whitespace"></i> Cerulean</a>
						</li>
						<li>
							<a class="ajax-link" data-value="cyborg" href=""><i
								class="whitespace"></i> Cyborg</a>
						</li>
						<li>
							<a class="ajax-link" data-value="simplex" href="#"><i
								class="whitespace"></i> Simplex</a>
						</li>
						<li>
							<a class="ajax-link" data-value="darkly" href="index.jsp"><i
								class="whitespace"></i> Darkly黑色</a>
						</li>
						<li>
							<a class="ajax-link" data-value="lumen" href="#"><i
								class="whitespace"></i> Lumen</a>
						</li>
						<li>
							<a class="ajax-link" data-value="slate" href=""><i
								class="whitespace"></i> Slate</a>
						</li>
						<li>
							<a class="ajax-link" data-value="spacelab" href="/index.jsp"><i
								class="whitespace"></i> Spacelab</a>
						</li>
						<li>
							<a class="ajax-link" data-value="united" href="/index.jsp"><i
								class="whitespace"></i> United</a>
						</li>
					</ul>
				</div>
<!--				 theme selector ends -->
<!---->
<!--				<ul class="collapse navbar-collapse nav navbar-nav top-menu">-->
<!--					-->
<!--					<li>-->
<!--						<form class="navbar-search pull-left">-->
<!--							<input placeholder="搜一搜"-->
<!--								class="search-query form-control col-md-10" name="query"-->
<!--								type="text">-->
<!--						</form>-->
<!--					</li>-->
<!--				</ul>-->

			</div>
		</div>
		<!-- topbar ends -->
  </body>
</html>
