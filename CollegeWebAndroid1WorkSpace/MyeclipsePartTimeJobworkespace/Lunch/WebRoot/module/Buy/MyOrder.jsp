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
<title>我的订单</title>
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
		function chakan(obj){
			
			var value=Number($(obj).next().val());
			window.location.href="${path }/o_MyOrderdetail.action?orderid="+value;
		}
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
			<%-- <div class="header-right wow fadeInLeft animated" data-wow-delay="0.5s">
				<div class="social-icons">
					<li><a href="${path}/module/Login/Menu.jsp"><i class="twitter"></i></a></li>
					<li><a href="${path}/module/Login/Menu.jsp"><i class="facebook"></i></a></li>
					<li><a href="${path}/module/Login/Menu.jsp"><i class="rss"></i></a></li>
					<li><div class="facebook"><div id="fb-root"></div>
						<div id="fb-root"></div>
						</div></li>
							<script>(function(d, s, id) {
							  var js, fjs = d.getElementsByTagName(s)[0];
							  if (d.getElementById(id)) return;
							  js = d.createElement(s); js.id = id;
							  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
							  fjs.parentNode.insertBefore(js, fjs);
							}(document, 'script', 'facebook-jssdk'));
							</script>
					<div class="fb-like" data-href="https://www.facebook.com/w3layouts" data-layout="button_count" data-action="like" data-show-faces="true" data-share="false"></div>
				</div>
				<div class="search">
						<form>
							<input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}"/>
							<input type="submit" value="">
						</form>
				</div>
			</div> --%>
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
		<div class="events-info">
			<h3 class="wow fadeInLeft animated" data-wow-delay="0.4s">我的订单</h3>
		</div>
		<div class="event-grids"id="showMenu">
			<table class="table table-striped ">
    		<c:if test="${!empty list }">
    			<c:forEach items="${list }" var="map">
    				<tr class="alert alert-info">   			
		    			<td>${map.order_date }</td>
		    			<td>订单编号${map.order_id }</td>
		    			<td>金额:￥${map.money}</td>
		    			<td>订单状态:
		    				<c:choose>
		    					<c:when test="${map.state==0 }">等待中</c:when>
			    				<c:when test="${map.state==1 }">已接单</c:when>
			    				<c:when test="${map.state==2 }">已打包</c:when>
			    				<c:when test="${map.state==3 }">配送中</c:when>
			    				<c:when test="${map.state==4 }">已完成</c:when>
			    				<c:when test="${map.state==5 }">已取消</c:when>
		    				</c:choose>
		    			</td>
		    			<td>
		    				<input type="button" value="查看"  class="btn btn-info" onclick="chakan(this)"/>
		  					<input type="hidden" value="${map.order_id }">
		    			</td>
		    		</tr>
    			</c:forEach>
    		</c:if>
    		
    		
    	</table>
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
