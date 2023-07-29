<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String roomid = request.getParameter("roomid");
if(roomid!=null&&!roomid.isEmpty()){
 session.removeAttribute("roomShopinfo");
  session.removeAttribute("roomid");
 session.setAttribute("roomid", roomid);
 }
%>

<!DOCTYPE html>
<html>
<head>
<title>联系我们</title>
<link href="${path }/resource/css/bootstrap.css" rel='stylesheet' type='text/css' />
<script src="${path }/resource/js/jquery.min.js"></script>
<link href="${path }/resource/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="My Recipes Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<script src="${path }/resource/js/responsiveslides.min.js"></script>
<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
		})
	</script>
 <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
  <script type="text/javascript" src="${path }/resource/js/move-top.js"></script>
<script type="text/javascript" src="${path }/resource/js/easing.js"></script>
  <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
	<!--Animation-->
<script src="${path }/resource/js/wow.min.js"></script>
<link href="${path }/resource/css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
</head>
<body>
    <!-- header-section-starts -->
	<div class="header">
		<div class="container">
			<div class="logo wow bounceInDown animated" data-wow-delay="0.4s">
				<a href=""><img src="${path }/resource/img/logo.png" alt="" /></a>
			</div>
			<div class="logo wow bounceInDown animated logintop" data-wow-delay="0.4s" >
				<c:choose>
					<c:when test="${(UserMap.customer_id!='') and (UserMap!=null)}">
						<img src="${path }/resource/img/99.png"  alt="" />
						<a href="${path }/one_updatecustomer.action?customerid=${UserMap.customer_id }"style="color:white;font-size: 20px;">${UserMap.customer_account_name}</a>
						&nbsp;
						<a href="${path }/m_menuback.action"style="color:white;font-size: 20px;">退出</a>
					</c:when>
					<c:otherwise>
						<a href="${path }/module/Login/Login.jsp"style="color:white;font-size: 20px;">登录</a>
						&nbsp;
						<a href="${path }/module/Login/Register.jsp"style="color:white;font-size: 20px;">注册</a>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="header-right wow fadeInLeft animated" data-wow-delay="0.4s" >
				
				<a href="${path }/card/SelectCard?customerid=${UserMap.customer_id }"style="text-decoration:none;float: left;">
					<span style="color:white;font-size: 20px;">购物车 </span>
					<img src="${path }/resource/img/card.jpg" width="100px" height="70px" alt="" />
				</a>
				<img src="${path }/resource/img/154.png"  alt="" style="float:left" />
				<span style="color:white;font-size: 20px;float: left;">订单信息&nbsp;&nbsp;</span>
				<ul style="list-style: none;float: left;margin-top:20px">
					<li><a href="${path }/o_findMyOrder.action?customerid=${UserMap.customer_id }"style="color:white;font-size: 20px;">我的订单</a></li>
					<li><a href="${path}/pre_seeCustomerRoom.action?customerid=${UserMap.customer_id }"style="color:white;font-size: 20px;">预定信息</a></li>
				</ul>	
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="container">
	<div class="main-content ">
	<div class="about-banner wow fadeInUp animated" data-wow-delay="0.4s">
	<div class="top-menu navigation wow rollIn animated" data-wow-delay="0.4s">
	<span class="menu"> </span>
						<ul>
							<li><a href="${path}/module/Login/Menu.jsp">首页</a></li>
							<li><a href="${path}/module/Login/About.jsp">关于我们</a></li>
							<li><a href="${path}/module/Login/Menu.jsp">菜单</a></li>
							<li><a href="${path }/module/Login/roomPre.jsp">房间预定</a></li>
							<li><a href="${path}/module/Login/Contact.jsp">联系我们</a></li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<!-- script-for-menu -->
						<script>
							$("span.menu").click(function(){
								$(".top-menu ul").slideToggle("slow" , function(){
								});
							});
						</script>
						<!-- script-for-menu -->
	</div>
	<!-- events -->
	 <div class="slider-bottom text-center">
		<div class="gtco-section">
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-6 animate-box">
					<h3>Get In Touch</h3>
					<form action="#">
						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="name">Name</label>
								<input type="text" id="name" class="form-control" placeholder="Your firstname">
							</div>
							
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="email">Email</label>
								<input type="text" id="email" class="form-control" placeholder="Your email address">
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="message">Message</label>
								<textarea name="message" id="message" cols="30" rows="10" class="form-control" placeholder="Write us something"></textarea>
							</div>
						</div>
						<div class="form-group">
							<input type="submit" value="Send Message" class="btn btn-primary">
						</div>

					</form>		
				</div>
				<div style="float:left">
					<img src="${path }/resource/img/tastebg.jpg" alt="图片" width="550px" height="450px"/>

				</div>
				
			</div>
		</div>
	</div>
	</div>

<!-- //events -->

	</div>
			</div>
	
	<!-- footer-section-starts -->
	<div class="footer">
		<div class="container">
			<p class="wow bounceInLeft animated" data-wow-delay="0.4s">金色小组 &copy; 2018  所有QY74第2组成员  | 设计 &nbsp;<a href="http://w3layouts.com" target="target_blank">就是我们</a></p>
		</div>
	</div>
	<!-- footer-section-ends -->

	<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>
