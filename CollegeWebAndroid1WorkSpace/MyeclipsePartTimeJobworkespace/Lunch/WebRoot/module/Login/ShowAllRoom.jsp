<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(session.getAttribute("roomid")!=null&&!session.getAttribute("roomid").equals("")){
	String roomid = session.getAttribute("roomid").toString();
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css"/>
  <link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
  <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<script src="${path }/resource/js/distpicker.data.js"></script>
<script src="${path }/resource/js/jquery.min.js"></script>
	<script src="${path }/resource/js/distpicker.js"></script>
	<script src="${path }/resource/js/main.js"></script>
 <script type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
 <link href="${path }/resource/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${path }/resource/css/style.css" rel="stylesheet" type="text/css" media="all" />
 
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
			//找orderID
			
			
		});
	</script>
	<!--Animation-->
<script src="${path }/resource/js/wow.min.js"></script>
<link href="${path }/resource/css/animate.css" rel='stylesheet' type='text/css' /> 
 <script type="text/javascript">
 function addMeal(roomid){
    	$.ajax({
				url:"${path}/emp_findOrderid.action",
				data:{"roomid":roomid},
				type:"post",
				dataType:"text",
				success:function(data){	
				if(data!=''&&data!="null"){
    					window.location.href="${path}/module/BgMenu/BgMenu.jsp?orderid="+data+"&roomid="+roomid+"&flag=1";
					}else{
					alert("不可加菜");
					}
				}
			});
			
 }
 function removeMeal(roomid){
    	$.ajax({
				url:"${path}/emp_findOrderid.action",
				data:{"roomid":roomid},
				type:"post",
				dataType:"text",
				success:function(data){	
					if(data!=''&&data!="null"){
    					window.location.href="${path}/car_OneroomOrder.action?orderid="+data+"&roomid="+roomid+"&flag=1";
    					//window.location.href="${path}/car_showRemovecookDe.action?orderid="+data+"&roomid="+roomid+"&flag=1";
    					//window.location.href="${path}/car_showRemovecookDe.action?orderid="+data+"&roomid="+roomid+"&flag=1";
					}else{
						alert("不可退菜");
					}
				}
			});
    	}
    	//
    	function shangMeal(roomid){
    	$.ajax({
				url:"${path}/emp_findOrderid.action",
				data:{"roomid":roomid},
				type:"post",
				dataType:"text",
				success:function(data){	
					if(data!=''&&data!="null"){
    					window.location.href="${path}/car_OneroomOrder.action?orderid="+data+"&roomid="+roomid+"&flag=1";
    					//window.location.href="${path}/car_showRemovecookDe.action?orderid="+data+"&roomid="+roomid+"&flag=1";
					}else{
						alert("没菜上桌");
					}
				}
			});
    	}
    	//
   function Tongzhi(roomid){
   		$.ajax({
				url:"${path}/emp_callOrder.action",
				data:{"roomid":roomid},
				type:"post",
				dataType:"text",
				success:function(data){	
				if(data!=''&&data!="null"){
					alert("已经通知");
					}else{
						alert("无菜可通知");
					}
				}
			});
   }
    </script>
 <style type="text/css">
  body{
	padding:0px;
	margin:30px;
	font-family: 'Open Sans', sans-serif;
	font-weight:bolder;
	color:white;
	text-align:center;
	background: url('${path}/resource/img/1.png') repeat;
}
#content{
	width:1000px;
	margin:0 auto;
	height:1200px;
}

.roomtree {	
			width:900px;
			margin:0 auto;
			text-align:left;
			line-height: 60px;
			font-size: 20px;
			font-family:"楷体";
			font-weight: 1600;
}
.roomtree ul li{
    width:150px;
	float:left;
	list-style:none;
	border:1px solid white;
	border-radius:12px;
	margin:10px;
	background:white;
}

  </style>
  </head>
  <body>
  <div class="header">
		<div class="container">
			<div class="logo wow bounceInDown animated" data-wow-delay="0.4s">
				<a href="index.html"><img src="${path }/resource/img/logo.png" alt="" /></a>
			</div>
			<div class="logo wow bounceInDown animated logintop" data-wow-delay="0.4s" >
			</div>
			<div class="logo wow bounceInDown animated logintop" data-wow-delay="0.4s" >
				<a href=""style=" margin-left:400px;float: left;"><img src="${path }/resource/img/logo.png" alt="" /></a>
				<ul style="list-style: none;float: left;">
					<li><a href="${path }/one_updatecustomer.action?customerid=${UserMap.customer_id }"style="color:white;font-size: 20px;"></a></li>
					<li><a href="${path }/o_findMyOrder.action?customerid=${UserMap.customer_id }"style="color:white;font-size: 20px;"></a></li>
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
							}(document, 'script', 'facebook-jssdk'));</script>
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
  <!-- 头部 -->
 <div id="content">
    
    <div class="roomtree">
    	<ul>
    	<c:forEach items="${allRoomlist }" var="room">
    		<li>
    			<span>
    			 <a  href="${path }/emp_SetRoom.action" onclick="window.open('${path}/module/BgMenu/BgMenu.jsp?roomid=${room.room_id}','_blank')">${room.room_number }${room.room_type }</a><br>
    				<%-- <a href="${path }/emp_SetRoom.action" onclick="window.open('${path}/module/Login/Menu.jsp?roomid=${room.room_id}','_blank')">${room.room_number }${room.room_type }</a> --%>
    			</span>
    			<span>
    			<input type="button" value="通知结账" class="btn btn-danger"onclick="Tongzhi(${room.room_id})">
    			<input type="button" value="加菜" class="btn btn-info"onclick="addMeal(${room.room_id})">
    			<input type="button" value="退菜" class="btn btn-danger"onclick="removeMeal(${room.room_id})">
    			<input type="button" value="上桌" class="btn btn-danger"onclick="shangMeal(${room.room_id})">
    			</span>
    		</li>
   		 </c:forEach>
    	</ul>
    </div>
  </div>
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

