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
<title>订单详情</title>
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
<script type="text/javascript" src="${path }/resource/js/jquery-

1.8.3.min.js"></script>
<script 

type="text/javascript"src="${path}/resource/layer/layer.js"></script>
	<script>
		$(document).ready(function(){
		
		$("#qrsh").click(function(){
				$.ajax({
					url:"${path }/o_qrsh.action",
					type:"post",
					data:{"orderid":"${list[0].order_id}"},
					dataType:"json",
					success:function(data){
						//alert(data.message);
						//window.location.href="${path }/com_FindOrder.action?orderid=${list1[0].order_id}";
						layer.alert(data.message, {icon: 6});
						setTimeout("window.location.href='${path }/com_FindOrder.action?orderid=${list1[0].order_id}'",900);
					}
				})
				
			}); 
			$("#cancel").click(function(){
				$.ajax({
					url:"${path }/o_qxdd.action",
					type:"post",
					data:{"orderid":"${list[0].order_id}"},
					dataType:"json",
					success:function(data){
						/* alert(data.message);
						window.location.href="${path }/o_findMyOrder.action?customerid=${list1[0].customer_id}"; */
						layer.alert(data.message, {icon: 6});
						setTimeout("window.location.href='${path }/o_findMyOrder.action?customerid=${list1[0].customer_id}'",900);
					}
				})
			});
			$("#lxwm").click(function(){
				//alert('在线电话\n55-6677889');
				layer.alert('在线电话\n55-6677889', {icon: 6});
			})
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
<div class="slider-bottom ">
		<div class="events-info" align="center">
			<h3 class="wow fadeInLeft animated" data-wow-delay="0.4s">订单详情</h3>
		</div>
		<div class="event-grids"id="showMenu">
			<div class="table-responsive">
		    	<table class="table" >
		    		<tr ><td>商品</td><td align="center">单价</td><td align="center">数量</td></tr>
		    		<c:if test="${!empty list }">
		    			<c:forEach items="${list}" var="map">
		    				<tr>
			    				<td width="33%" >			    					
			    					<a href="${path}/dc/ShowMenu?mealid=${map.meal_id}"><img src="${path }/resource/img/${map.meal_image}" alt="图片" style="width:70px;height:50px"/>
			    					${map.meal_name }</a><br/>${map.meal_desc }
			    					
			    				</td>
			    				<td width="33%" align="center" style="vertical-align:middle">${map.price }</td>
			    				<td width="33%" align="center" style="vertical-align:middle">${map.count }</td>
		    				</tr>
		    			</c:forEach>
		    		</c:if>
		    		<tr align="center"><td colspan="3">合计:￥${list1[0].money }</td></tr> 
		    	</table>
		    </div>
		   	<div>
		   	      <hr style="height:1px;border:none;border-top:1px solider #0066CC;" /> 
		   	   
		   	</div>
		    <div>    
		    		<h3 class="wow fadeInLeft animated" data-wow-delay="0.4s" align="center">配送信息</h3>
		    		<span>&nbsp;</span>
		    	<table class="table" >
		    		<tr><td align="center" width="65%">顾客姓名</td><td width="35%">${list1[0].customer_name }</td></tr>
		    		<tr><td align="center" width="65%">联系方式</td><td width="35%">${list1[0].customer_phone }</td></tr>
		    		<tr><td align="center" width="65%">配送地址</td><td width="35%">${list1[0].customer_add }</td></tr>
		    		<tr>
		    			<td align="center" width="65%">订单备注</td>
		    			<td width="35%"><c:if test="${empty list1[0].order_content }">无</c:if> ${list1[0].order_content }</td>
		    		</tr>
		    	</table>
		    </div>
		    <c:if test="${list1[0].state==3||list1[0].state==4}">
		    	<div align="center">配送人：${list1[0].emp_name }&nbsp;&nbsp;${list1[0].phone }</div>
		    </c:if>
		    <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
		    <div align="center">
		    	
		    	<c:if test="${list1[0].state==0}">
		    		<input type="button" id="cancel" value="取消订单" class="btn btn-danger">
		    	</c:if>
		    	<c:if test="${list1[0].state==3}">
		    		<input type="button" id="qrsh" value="确认收货" class="btn btn-warning">
		    	</c:if>
		    	<input type="button" id="lxwm" value="联系我们" class="btn btn-info">
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
