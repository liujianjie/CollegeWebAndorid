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

<script>
	new WOW().init();
</script>
<style type="text/css">
  body{
	padding:0px;
	margin:30px;
	font-family: 'Open Sans', sans-serif;
	font-weight:bolder;
	color:white;
	background: url('${path}/resource/img/1.png') repeat;
}
#content{
	width:1200px;
	margin:0 auto;
	background:white;
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
		font-size:16px;
		color:black;
	}
  #tab{
      margin:0px auto;
      width:900px;
      line-height:30px;
  }
  </style>
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
				<span style="color:white;font-size: 20px;float: left;">订单信息&nbsp;&nbsp;    </span>
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
  <!-- 头部 -->
 <div id="content">
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
 	<div id="contenttitle">
	     <h1>【10店通用】南京大排档</h1>
		 <h3>价值100元的代金券1张，全场通用，可叠加使用，提供免费WiFi</h3>
	 </div>
	 <div id="contentbody">
	 	<div id="bodyleft">
	 		<a class="event-item" href="">${oneMenuMap.meal_name }</a>
		     <img src="${path }/resource/img/${oneMenuMap.meal_image}" alt="图片" width="380px" height="213px"/>
		    <h4>菜品介绍:<span>${oneMenuMap.meal_desc }</span></h4>
		    
		 </div>
<script type="text/javascript" src="${path}/resource/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
 <script type="text/javascript">
		 function buyMeal(id,name,price,mealid,roomid){
				 		if(id!=null&&id!=""&&id!="null"){
							if(${oneMenuMap.state=="盈余" }){
								window.location.href="${path}/card/InsertCard?meal="+name+"&price="+price+"&customerid="+id;
							}else{
						 		alert("抱歉，材料不足,请换购");
						 	}	 	
						}else{
							alert("请先登录");
							//layer.alert("请先登录",{icon: 5});
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
								<c:forEach begin="${1}" end="${1}" varStatus="i">
								<option  value="${i.count }">${i.count}</option>
								</c:forEach>
							</select>
						</td>
					  </tr>
					  <tr>
					     <td></td>
						 <td>
							 <a href="javascript:buyMeal('${UserMap.customer_id}','${oneMenuMap.meal_name }','${oneMenuMap.meal_price }','${oneMenuMap.meal_id }','${roomid }')">
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
	 <div>
	     <table id="tab"> 
			 	   <c:if test="${!empty qtt }">
			 	   <caption style="color:gray"><h4>菜品评论</h4></caption>
				 	    <!-- 2017-10-19 -->
				 	    <c:forEach items="${qtt }" var="qtt">
					 	      <tr>
						 	     <td>${qtt.customer_name }:${qtt.comment_content }</td>
						 	     <td>评分:
							  	 <c:if test="${ qtt.comment_grade > 0 }">
							  		<c:forEach begin="1" end="${qtt.comment_grade }">
							  			<img src="${path }/resource/img/star_red.png">
							  		</c:forEach>
							  		<c:forEach begin="1" end="${5-qtt.comment_grade }">
							  			<img src="${path }/resource/img/star.png">
							  		</c:forEach>
							  	 </c:if>
							     <c:if test="${qtt.comment_grade eq 0}">
							  		<c:forEach begin="1" end="${5-qtt.comment_grade }">
							  			<img src="${path }/resource/img/star.png">
							  		</c:forEach>
							  	</c:if>
							  	</td>
						 	     <td>评论时间:${qtt.comment_date }</td>
						 	 </tr>
						 	 <tr>
						 	     <td>店家回复:${qtt.comment_replay }</td>
						 	     <td></td>
						 	     <td>回复时间:${qtt.replay_time }</td>
					 	     </tr>
					 	     <tr>
					 	            <td colspan="3"><hr style="height:3px;border:none;border-top:1px dashed black;" /></td>
					 	     </tr>
				 	    </c:forEach>
				 	    <!-- 2017-10-19 -->
			 	   </c:if>
			 	   <c:if test="${empty qtt }">
			 	    <tr><td><h4>暂无相关评论</h4></td></tr>
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
