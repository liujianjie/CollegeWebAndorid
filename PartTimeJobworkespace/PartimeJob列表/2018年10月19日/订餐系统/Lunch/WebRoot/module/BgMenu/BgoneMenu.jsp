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
		});
	</script>
	<!--Animation-->
<script src="${path }/resource/js/wow.min.js"></script>
<link href="${path }/resource/css/animate.css" rel='stylesheet' type='text/css' /> 
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
	width:1200px;
	margin:0 auto;
	
}
#contentbody{
	
	width:900px;
	height:400px;
	margin:0 auto;
	
	background:rgba(255,255,225,1);
}
#bodyleft{
	margin-top:20px;
	width:380px;
	height:380px;
	font-size:20px;
	color:black;
	font-family:"隶书";
	float:left;
 }
 #bodyleft img{
 	
 }
#bodyright{
 	
 	float:left;
 	width:510px;
 	height:100%;
}

table{
		background:rgba(255,255,255,0.8);
		font-size:20px;
		color:black;
		font-family:"隶书";
	}
  #tab{
      margin:0px auto;
      width:900px;
      line-height:40px;
  }
  </style>
  </head>
  <body>
  <div class="header">
		<div class="container">
			<div class="logo wow bounceInDown animated" data-wow-delay="0.4s">
				<a href=""><img src="${path }/resource/img/logo.png" alt="" /></a>
			</div>
			<div class="logo wow bounceInDown animated logintop" data-wow-delay="0.4s" >
				<c:choose>
					<c:when test="${(roominfo!='') and (roominfo!=null) and (!empty roominfo)}">
						<a href=""style="color:white;font-size: 20px;">${roominfo[0].room_number}${roominfo[0].room_type}</a>
						&nbsp;
					</c:when>
				</c:choose>
			</div>
			<div class="logo wow bounceInDown animated logintop" data-wow-delay="0.4s" >
				<a href="index.html"style=" margin-left:400px;float: left;"><img src="${path }/resource/img/logo.png" alt="" /></a>
				<ul style="list-style: none;float: left;">
					<li><a href="${path }/car_showRoomdetail.action?orderid=${BgOrderid }&roomid=${roomid}"style="color:white;font-size: 20px;">您的订单</a></li>
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
 <div class="about-banner wow fadeInUp animated" data-wow-delay="0.4s">
	<div class="top-menu navigation wow rollIn animated" data-wow-delay="0.4s">
	<span class="menu"> </span>
						<ul>
							<li><a href="${path}/module/BgMenu/BgMenu.jsp?orderid=${Addorderid }">首页</a></li>
							<li><a href="${path}/module/BgMenu/BgMenu.jsp?orderid=${Addorderid }">菜单</a></li>
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
 	<div id="contenttitle">
	     <h1>【10店通用】南京大排档</h1>
		 <h3>价值100元的代金券1张，全场通用，可叠加使用，提供免费WiFi</h3>
	 </div>
	 <div id="contentbody">
	 	<div id="bodyleft">
	 		<a class="event-item" href="">${oneMenuMap.meal_name }</a>
		     <img src="${path }/resource/img/${oneMenuMap.meal_image}" alt="图片" width="370px" height="213px"/>
		    <h4>菜品介绍:<span>${oneMenuMap.meal_desc }</span></h4>
		    
		 </div>
 <script type="text/javascript">
 //${path}/emp_InsetTableEmpshop.action?mealid="+mealid+"&mealcount="+$("#mealcount").val()+"&roomid="+roomid+"&Addorderid="+Addorderid
		 function buyMeal(id,name,price,mealid,roomid,Addorderid){
		// alert(Addorderid);
		 if(${oneMenuMap.state=="盈余" }){
		 $.ajax({
		 	url:"${path}/emp_InsetTableEmpshop.action",
		 	data:{"roomid":roomid,"mealid":mealid,"mealcount":$("#mealcount").val(),"Addorderid":Addorderid},
		 	dataType:"text",
		 	type:"post",
		 	success:function(data){
		 		if(data=='true'){
		 			alert("添加成功");
		 			window.location.href="${path}/emp_ToEmpshop.action?Addorderid="+Addorderid+"&roomid="+roomid;
		 		}else{
		 			alert("添加失败");
		 		}
		 	}
		 });
		 //异步
		 }else{
		 	alert("抱歉，材料不足,请换购");
		 }
		 }
</script>
		 <div id="bodyright">
		   <table class="table">
			       <thead>
				       <tr>
					      <td><span>单价:</span></td>
						  <td>￥<span>${oneMenuMap.meal_price }元</span></td>  
					   </tr>
				   </thead>
				   <tbody>
				      <tr>
					     <td colspan="2">
							 <span id="">已售255</span>&nbsp;
							 <span> 7.2分 </span>&nbsp;
							 <span>类别:${oneMenuMap.meal_type}
							 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							 		材料:${oneMenuMap.state }
							 </span>
						 </td>
					  </tr>
					  <tr>
					     <td><span>有效期:</span></td>
					     <td>截止到2017.10.31<span>不可用日期</span>周六至周日，法定节假日不可用</td>
					  </tr>
					  <tr>
					     <td><span>数量:</span></td>
					     <td><select name="mealcount" id="mealcount" class="btn btn-default drospandown-toggle   btn-lg" data-toggle="drospandown">
								<c:forEach begin="${1}" end="${10}" varStatus="i">
								<option  value="${i.count }">${i.count}</option>
								</c:forEach>
							</select>
						</td>
					  </tr>
					  <tr>
					     <td></td>
						 <td>
							 <a href="javascript:buyMeal('${UserMap.customer_id}','${oneMenuMap.meal_name }','${oneMenuMap.meal_price }','${oneMenuMap.meal_id }','${roomid }','${Addorderid }')">
							 <button tyspane="button"class="btn btn-primary btn-lg">
							 √立即抢购</button></a>
							 <span>☆收藏(50)</span>
						     <img src="${path }/resource/img/02.jpg"/><a href="">分享</a>	
						 </td>
					  </tr>
				   </tbody>
				   <tfoot>
				       <tr>
					      <td><span>服务承诺:</span></td>
						  <td>
						    
							 <span id=""><a href="">随时退</a></span>
						
							 <span id=""><a href="">及时退</a></span>
							 
							 <span id=""><a href="">真实评价</a></span>
						  </td>
					   </tr>
				   </tfoot>
			  </table>
		 </div>
	 </div>
	 <div style="backgroundcolor:white">
	     <table id="tab"> 
			 	   <c:if test="${!empty qtt }">
			 	   <caption style="color:gray"><h2>菜品评论</h2></caption>
				 	    <c:forEach items="${qtt }" var="qtt">
					 	      <tr>
						 	     <td>${qtt.customer_name }:${qtt.comment_content }</td>
						 	     <td>评论时间:${qtt.comment_date }</td>
						 	 </tr>
						 	 <tr>
						 	     <td>店家回复:${qtt.comment_replay }</td>
						 	     <td>回复时间:${qtt.replay_time }</td>
					 	     </tr>
					 	     <tr>
					 	            <td colspan="3"><hr style="height:3px;border:none;border-top:1px dashed black;" /></td>
					 	     </tr>
				 	    </c:forEach>
			 	   </c:if>
			 	   <c:if test="${empty qtt }">
			 	    <tr><td><h2>暂无相关评论</h2></td></tr>
			 	   </c:if>
	 	     </table>
	 </div>
	 <div id="contentfooter">
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
