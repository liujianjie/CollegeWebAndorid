<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.dc.dao.EmpShop.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String roomid = request.getParameter("roomid");
if(roomid!=null&&!roomid.isEmpty()){
 session.removeAttribute("roomid");
 session.setAttribute("roomid", roomid);
 //session.removeAttribute("roomShopinfo");
 }
empShopDAO dao=new empShopDAOImpl();
List roominfo=dao.selectroominfo(roomid);
session.setAttribute("roominfo", roominfo);
String orderid=request.getParameter("orderid");
request.setAttribute("Addorderid", orderid);
session.setAttribute("orderid",orderid);

%>

<!DOCTYPE html>
<html>
<head>
<title>主页</title>
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
			//
			$.ajax({
		 	url:"${path}/emp_CheckRoom.action",
		 	data:{"roomid":$("#roomid").val()},
		 	dataType:"text",
		 	type:"post",
		 	success:function(data){
		 		if(data=="使用中"){
		 			console.log("已经开桌");
		 		}else{
		 			alert("不可操作");
		 			window.location.href="${path}/index.jsp";
		 		}
		 	}
		 })
		 //
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
					<c:when test="${(roominfo[0]!='') and (roominfo[0]!=null)}">
						<a href=""style="color:white;font-size: 20px;">${roominfo[0].room_number}${roominfo[0].room_type}</a>
						&nbsp;
						<a href="${path }/module/BgMenu/BgMenu.jsp"style="color:white;font-size: 20px;">退出</a>
					</c:when>
				</c:choose>
			</div>
			<div class="logo wow bounceInDown animated logintop" data-wow-delay="0.4s" >
				<a href=""style=" margin-left:400px;float: left;"><img src="${path }/resource/img/logo.png" alt="" /></a>
				<ul style="list-style: none;float: left;">
					<li><a href="${path }/car_showRoomdetail.action?orderid=${orderid }&roomid=${roomid}"style="color:white;font-size: 20px;">您的订单</a></li>
					<li><a href="${path}/emp_ToEmpshop.action?Addorderid=${orderid}&roomid=${roomid}"style="color:white;font-size: 20px;">我的购物车</a></li>
				</ul>	
			</div>
			<div class="header-right wow fadeInLeft animated" data-wow-delay="0.5s">
				<div class="social-icons">
					<li><a href=""><i class="twitter"></i></a></li>
					<li><a href=""><i class="facebook"></i></a></li>
					<li><a href=""><i class="rss"></i></a></li>
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
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="container">
	<div class="main-content ">
	<div class="about-banner wow fadeInUp animated" data-wow-delay="0.4s">
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
<script type="text/javascript">
		 function buyMeal(mealid,roomid,Addorderid,state){
			if(state=="盈余"){ 
			 $.ajax({
			 	url:"${path}/emp_InsetTableEmpshop.action",
			 	data:{"roomid":roomid,"mealid":mealid,"mealcount":"1","Addorderid":Addorderid},
			 	dataType:"text",
			 	type:"post",
			 	success:function(data){
			 		if(data=='true'){
			 			alert("添加成功");
			 		}else{
			 			alert("添加失败");
			 		}
			 	}
			 });
			 //异步
			}else{
				alert("抱歉，库存不足请换购");
			}	
		}
</script>
<input type="hidden" value="${roomid }" id="roomid">
<div class="slider-bottom text-center">
		<div class="events-info">
			<h3 class="wow fadeInLeft animated" data-wow-delay="0.4s">菜品展示</h3>
			<div class="border"></div>
			<p class="wow fadeInUpBig animated animated" data-wow-delay="0.4s">选择菜单，选择喜欢的菜品</p>
		</div>
		<div class="event-grids"id="showMenu">
			<c:forEach items="${menuList }" var="menu" varStatus="mc">
			
				<div class="col-md-4 event-grid wow bounceIn animated" data-wow-delay="0.4s">
					<a class="event-item" href="${path}/dc/ShowMenu?mealid=${menu.meal_id}">${menu.meal_name }</a>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&Addorderid=${Addorderid }"><img src="${path }/resource/img/${menu.meal_image}" alt="图片" width="370px" height="213px"/></a>
					<input type="button" value="单价：￥${menu.meal_price }元" class="btn btn-active"/>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&Addorderid=${Addorderid }"><input type="button" value="查看详情" class="btn btn-info"/></a>
					<a href="javascript:buyMeal('${menu.meal_id }','${roomid }','${Addorderid }','${menu.state }')"><input type="button" value="添加购物车" class="btn btn-danger"/></a>
				</div>
				<c:if test="${mc.count%3 eq 0}"><div class="clearfix"></div></c:if>
			
			</c:forEach>
			<div class="clearfix"></div>
		</div>
</div>
<div class="slider-bottom text-center">
		<div class="events-info">
			<h3 class="wow fadeInLeft animated" data-wow-delay="0.4s">热菜</h3>
			<div class="border"></div>
			<p class="wow fadeInUpBig animated animated" data-wow-delay="0.4s">选择喜欢的热菜</p>
		</div>
		<div class="event-grids"id="showMenu">
			<c:forEach items="${menuList }" var="menu" varStatus="mc">
			<c:if test="${menu.meal_type eq '热菜'}">
				<div class="col-md-4 event-grid wow bounceIn animated" data-wow-delay="0.4s">
					<a class="event-item" href="${path}/module/Login/Menu.jsp">${menu.meal_name }</a>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&Addorderid=${Addorderid }"><img src="${path }/resource/img/${menu.meal_image}" alt="图片" width="370px" height="213px"/></a>
					<input type="button" value="单价：￥${menu.meal_price }元" class="btn btn-active"/>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&Addorderid=${Addorderid }"><input type="button" value="查看详情" class="btn btn-info"/></a>
					<a href="javascript:buyMeal('${menu.meal_id }','${roomid }','${Addorderid }','${menu.state }')"><input type="button" value="添加购物车" class="btn btn-danger"/></a>
				</div>
				<c:if test="${mc.count%6 eq 0}"><div class="clearfix"></div></c:if>
				</c:if>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
</div>
<div class="slider-bottom text-center">
		<div class="events-info">
			<h3 class="wow fadeInLeft animated" data-wow-delay="0.4s">凉菜</h3>
			<div class="border"></div>
			<p class="wow fadeInUpBig animated animated" data-wow-delay="0.4s">选择喜欢的凉菜</p>
		</div>
		<div class="event-grids"id="showMenu">
			<c:forEach items="${menuList }" var="menu" varStatus="mc">
			<c:if test="${menu.meal_type eq '凉菜'}">
				<div class="col-md-4 event-grid wow bounceIn animated" data-wow-delay="0.4s">
					<a class="event-item" href="${path}/module/Login/Menu.jsp">${menu.meal_name }</a>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&Addorderid=${Addorderid }"><img src="${path }/resource/img/${menu.meal_image}" alt="图片" width="370px" height="213px"/></a>
					<input type="button" value="单价：￥${menu.meal_price }元" class="btn btn-active"/>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&Addorderid=${Addorderid }"><input type="button" value="查看详情" class="btn btn-info"/></a>
					<a href="javascript:buyMeal('${menu.meal_id }','${roomid }','${Addorderid }','${menu.state }')"><input type="button" value="添加购物车" class="btn btn-danger"/></a>
				</div>
				<c:if test="${mc.count%6 eq 0}"><div class="clearfix"></div></c:if> 
			</c:if>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
</div>
<div class="slider-bottom text-center">
		<div class="events-info">
			<h3 class="wow fadeInLeft animated" data-wow-delay="0.4s">酒水</h3>
			<div class="border"></div>
			<p class="wow fadeInUpBig animated animated" data-wow-delay="0.4s">选择喜欢的酒水</p>
		</div>
		<div class="event-grids"id="showMenu">
			<c:forEach items="${menuList }" var="menu" varStatus="mc">
			<c:if test="${menu.meal_type eq '酒水'}">
				<div class="col-md-4 event-grid wow bounceIn animated" data-wow-delay="0.4s">
					<a class="event-item" href="${path}/module/Login/Menu.jsp">${menu.meal_name }</a>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&Addorderid=${Addorderid }"><img src="${path }/resource/img/${menu.meal_image}" alt="图片" width="370px" height="213px"/></a>
					<input type="button" value="单价：￥${menu.meal_price }元" class="btn btn-active"/>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&Addorderid=${Addorderid }"><input type="button" value="查看详情" class="btn btn-info"/></a>
					<a href="javascript:buyMeal('${menu.meal_id }','${roomid }','${Addorderid }','${menu.state }')"><input type="button" value="添加购物车" class="btn btn-danger"/></a>
				</div>
				<c:if test="${mc.count%6 eq 0}"><div class="clearfix"></div></c:if> 
			</c:if>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
</div>
<%-- <div class="special-offers-section">
				<div class="special-offers-section-head text-center wow fadeInRight animated" data-wow-delay="0.4s">
					<h4>预订桌</h4>
				</div>
				<div class="special-offers-section-grids">
				 <div class="m_3"><span class="middle-dotted-line"> </span> </div>
					  <ul id="flexiselDemo3" id="showRoom">
					  <c:forEach  items="${roomlist }" var="room" >
						 <li id="clone">
							<div class="offer wow fadeInUp animated" data-wow-delay="0.6s">
								<div class="offer-image">	
									<a href="${path }/module/Login/roomPre.jsp"><img src="${path }/resource/img/p1.jpg" class="img-responsive" alt=""/></a>
								</div>
								<div class="offer-text">
									<a href="${path }/module/Login/roomPre.jsp"><h4>${room.room_number }</h4></a>
									<p>${room.room_state } </p>
									<a href="${path }/module/Login/roomPre.jsp"><input type="button" value="预订"></a>
								</div>
								<div class="clearfix"></div>
						</li> 
						</c:forEach>
					 </ul>
				 <script type="text/javascript">
					$(window).load(function() {
						
						$("#flexiselDemo3").flexisel({
							visibleItems: 3,
							animationSpeed: 1000,
							autoPlay: true,
							autoPlaySpeed: 3000,    		
							pauseOnHover: true,
							enableResponsiveBreakpoints: true,
							responsiveBreakpoints: { 
								portrait: { 
									changePoint:480,
									visibleItems: 1
								}, 
								landscape: { 
									changePoint:640,
									visibleItems: 2
								},
								tablet: { 
									changePoint:768,
									visibleItems: 2
								}
							}
						});
						
					});
				    </script>
				    <script type="text/javascript" src="${path }/resource/js/jquery.flexisel.js"></script>
			</div>
		</div> --%>
<div class="slider-bottom text-center">
		<div class="events-info wow fadeInUpBig animated" data-wow-delay="0.4s">
			<h3>最新资讯</h3>
			<div class="border"></div>
			<p>最新饭店套餐公布了，有最好吃的， 最好喝的，最新 打折优惠，赶紧来吧</p>
		</div>
		<div class="event-grids">
			<div class="col-md-6 event-grid wow bounceIn animated" data-wow-delay="0.4s">
				<a class="event-item" href="">香肠套餐</a>
				<a href=""><img src="${path }/resource/img/9.jpg" alt=""/></a>
			</div>
			<div class="col-md-6 event-grid wow bounceIn animated" data-wow-delay="0.4s">
				<a  class="event-item" href="">咖啡套餐</a>
				<a href=""><img src="${path }/resource/img/10.jpg" alt=""/></a>
			</div>
			<div class="clearfix"></div>
		</div>
</div>
<!-- //events -->

	</div>
			</div>
	<!-- footer-section-starts -->
	<div class="footer">
		<div class="container">
		<%-- <p>orderid:${Addorderid }</p> --%>
			<p class="wow bounceInLeft animated" data-wow-delay="0.4s">金色小组 &copy; 2018  所有QY74第2组成员  | 设计 &nbsp;<a href="http://w3layouts.com" target="target_blank">就是我们</a></p>
		</div>
	</div>
	<!-- footer-section-ends -->
	<script type="text/javascript">
						$(document).ready(function() {
							/*
							var defaults = {
					  			containerID: 'toTop', // fading element id
								containerHoverID: 'toTopHover', // fading element hover id
								scrollSpeed: 1200,
								easingType: 'linear' 
					 		};
							*/
							
							$().UItoTop({ easingType: 'easeOutQuart' });
							
						});
					</script>
				<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>
