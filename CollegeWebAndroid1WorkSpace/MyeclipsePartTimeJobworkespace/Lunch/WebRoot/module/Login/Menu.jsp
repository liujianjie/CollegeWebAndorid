<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

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
<style>

.u-flyer {
	display: block;
	width: 20px;
	height: 20px;
	border-radius:20px;
}

</style>
<script src="${path }/resource/js/responsiveslides.min.js"></script>
<script type="text/javascript"src="${path}/resource/layer/layer.js"></script>
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
					<span style="color:white;font-size: 20px;" >购物车 </span>
					<img src="${path }/resource/img/card.jpg" id="end" width="100px" height="70px" alt="" />
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
<script type="text/javascript">
		 function buyMeal(id,name,price,state){
		 	
				 		 if(id!=null&&id!=""){
				 			if(state=="盈余"){
					 			$.ajax({
					 				url:"${path}/card/InsertCard",
					 				data:{"meal":name,"price":price,"customerid":id},
					 				type:"post",
					 				dataType:"json",
					 				success:function(data){
					 					alert(1);
					 				}
					 			})
					 		}else{
					 			layer.alert("抱歉，库存不足请换购", {icon: 5});
					 		}
							
						}else{
							layer.alert("请先登录", {icon: 5});
							
						} 
		 }
</script>
<div class="slider-bottom text-center">
		<div class="events-info">
			<h3 class="wow fadeInLeft animated" data-wow-delay="0.4s">菜品展示</h3>
			<div class="border"></div>
			<p class="wow fadeInUpBig animated animated" data-wow-delay="0.4s">选择菜单，选择喜欢的菜品</p>
		</div>
		<div class="event-grids"id="showMenu">
			<c:forEach items="${menuList }" var="menu" varStatus="mc">		
				<div class="col-md-4 event-grid wow bounceIn animated" data-wow-delay="0.4s">
					<a class="event-item" href="${path}/module/Login/Menu.jsp">${menu.meal_name }</a>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}"><img src="${path }/resource/img/${menu.meal_image}" alt="图片" width="370px" height="213px"/></a>
					<input type="button" value="单价：￥${menu.meal_price }元" class="btn btn-active"/>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}" ><input type="button" value="查看详情"  class="btn btn-info"/></a>
		
					<a class="div" href="javascript:buyMeal('${UserMap.customer_id}','${menu.meal_name }','${menu.meal_price }','${menu.state }')"><input type="button" value="添加购物车" class="btn btn-danger"/></a>
					
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
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}"><img src="${path }/resource/img/${menu.meal_image}" alt="图片" width="370px" height="213px"/></a>
					<input type="button" value="单价：￥${menu.meal_price }元" class="btn btn-active"/>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}"><input type="button" value="查看详情" class="btn btn-info"/></a>
					<a class="div" href="javascript:buyMeal('${UserMap.customer_id}','${menu.meal_name }','${menu.meal_price }','${menu.state }')"><input type="button" value="添加购物车" class="btn btn-danger"/></a>
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
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}"><img src="${path }/resource/img/${menu.meal_image}" alt="图片" width="370px" height="213px"/></a>
					<input type="button" value="单价：￥${menu.meal_price }元" class="btn btn-active"/>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}"><input type="button" value="查看详情" class="btn btn-info"/></a>
					<a class="div" href="javascript:buyMeal('${UserMap.customer_id}','${menu.meal_name }','${menu.meal_price }','${menu.state }')"><input type="button" value="添加购物车" class="btn btn-danger"/></a>
				</div>
				<c:if test="${mc.count%12 eq 0}"><div class="clearfix"></div></c:if> 
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
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}"><img src="${path }/resource/img/${menu.meal_image}" alt="图片" width="370px" height="213px"/></a>
					<input type="button" value="单价：￥${menu.meal_price }元" class="btn btn-active"/>
					<a href="${path}/dc/ShowMenu?mealid=${menu.meal_id}"><input type="button" value="查看详情" class="btn btn-info"/></a>
					<a class="div" href="javascript:buyMeal('${UserMap.customer_id}','${menu.meal_name }','${menu.meal_price }','${menu.state }')"><input type="button" value="添加购物车" class="btn btn-danger"/></a>
				</div>
				<c:if test="${mc.count%6 eq 0}"><div class="clearfix"></div></c:if> 
			</c:if>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
</div>
<script src="${path }/resource/js/jquery.js"></script>
<script src="${path }/resource/js/requestAnimationFrame.js"></script>
<script src="${path }/resource/js/jquery_002.js"></script> 

<script>
$('.div').on('click', addProduct);
function addProduct(event) {
var offset = $('#end').offset(), flyer = $('<img class="u-flyer" src="${path }/resource/img/profile-80_1.jpg"/>');
flyer.fly({
    start: {
        left: event.clientX,
        top: event.clientY,
       
    },
    end: {
        left: offset.left,
        top: offset.top,
        width: 0,
		height: 0
    }
});
}
</script> 
<div class="slider-bottom text-center">
		<div class="events-info wow fadeInUpBig animated" data-wow-delay="0.4s">
			<h3>最新资讯</h3>
			<div class="border"></div>
			<p>最新饭店套餐公布了，有最好吃的， 最好喝的，最新 打折优惠，赶紧来吧</p>
		</div>
		<div class="event-grids">
			<div class="col-md-6 event-grid wow bounceIn animated" data-wow-delay="0.4s">
				<a class="event-item" href="">香肠套餐</a>
				<a href="${path}/module/Login/Menu.jsp"><img src="${path }/resource/img/9.jpg" alt=""/></a>
			</div>
			<div class="col-md-6 event-grid wow bounceIn animated" data-wow-delay="0.4s">
				<a  class="event-item" href="">咖啡套餐</a>
				<a href="${path}/module/Login/Menu.jsp"><img src="${path }/resource/img/10.jpg" alt=""/></a>
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
