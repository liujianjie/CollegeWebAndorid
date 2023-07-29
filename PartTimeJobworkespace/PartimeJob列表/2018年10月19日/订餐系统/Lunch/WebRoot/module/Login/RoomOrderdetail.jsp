<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	//response.setHeader("refresh","60"); 
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>订单详情</title>
  <!--   <meta  http-equiv="refresh"content="10;url="> -->
<!-- 10表示间隔10秒刷新一次  -->
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
			 $.ajax({
				url:"${path}/car_showMenu.action",
				data:{"orderid":$("#orderid").val()},
				type:"post",
				dataType:"json",
				success:function(data){
				var datalist=new Array();
				//console.log(data);
				$("#tbody").html('');
				for(var i=0;i<data.length;i++){
					var map=data[i];
					var orderdetailid=map.order_detail_id;
					var mealname=map.meal_name;
					var count=map.count;
					var price=map.meal_price;
					$("#"+orderdetailid).remove();
					$("#tbody").append("<tr><td>"+(i+1)+"</td>"+
					"<td>"+orderdetailid+"</td>"+
			 		"<td>"+mealname+"</td>"
			 		+"<td>"+count+"</td>"
			 		+"<td> ￥"+price+"元</td>"+
			 		"<td>已上桌</td></tr>");
				}
				var num=$("#tbody").find("tr").length;
				if(num==${detailcount})	{
					$("#button").removeAttr("disabled");
				}
				}
			});
			//
			//alert($("#tbody").find("tr").length);
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
	color:green;
	text-align:center;
	background: url('${path}/resource/img/1.png') repeat;
}
#content{
	width:1200px;
	margin:0 auto;
	
}
#contentbody{
	
	width:1000px;
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
table{
		background:rgba(255,255,255,0.8);
		color:black;
		font-family:"隶书";
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
					<c:when test="${(roominfo[0].room_id!='') and (roominfo[0].room_id!=null)}">
						<a href=""style="color:white;font-size: 20px;">${roominfo[0].room_number}${roominfo[0].room_type}</a>
						&nbsp;
					</c:when>
				</c:choose>
			</div>
			<div class="logo wow bounceInDown animated logintop" data-wow-delay="0.4s" >
				<a href=""style=" margin-left:400px;float: left;"><img src="${path }/resource/img/logo.png" alt="" /></a>
				<ul style="list-style: none;float: left;">
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
 	<div id="contenttitle">
 	<input type="hidden" value="${orderid }" id="orderid">
	     <h1 >订单详情:${orderid }</h1>
		 <h3>房间编号：${roomid }</h3>
	 </div>
	 <script type="text/javascript">
	 function pushmeal(){
	 //alert(1);
				 $.ajax({
				url:"${path}/car_pushfoodcount.action",
				data:{"orderid":$("#orderid").val()},
				type:"post",
				dataType:"text",
				success:function(data){
				//alert(1);
					if(data=='true'){
					window.location.reload();
					}
				}
				})
			}
	</script>
	 <div id="contentbody">
	 <p> 个数：${detailcount }</p>
	 <input type="button" value="催菜" class="btn btn-danger" onclick="pushmeal()">
	 <table class="table">
	 	<thead>
	 		<tr>
	 		<th>序号</th>
	 		<th>详情编号</th>
	 		<th>商品</th>
	 		<th>数量</th>
	 		<th>单价</th>
	 		<th>状态</th>
	 		</tr>
	 	</thead>
	 	<tbody id="tby">
	 	<c:forEach items="${roomMealDeatil }" var="map" varStatus="i">
	 	<tr id="${map.order_detail_id }">
	 		<td>${i.count }</td>
	 		<td>${map.order_detail_id }</td>
	 		<td>${map.meal_name}</td>
	 		<td>${map.count}</td>
	 		<td>￥${map.meal_price }元</td>
	 		<td>
	 			<c:choose>
	 				<c:when test="${map.state eq 0 }">未做</c:when>
	 				<c:when test="${map.state eq 1 }">完成</c:when>
	 				<c:when test="${map.state eq 2 }">正在做</c:when>
	 			</c:choose>
	 		</td>
	 	</tr>
	 	</c:forEach>
	 	<tr>
	 		<td colspan="7"><hr style="border:1px solid red"><br></td>
	 	</tr>
	 	</tbody>
	 </table>
	 <table class="table">
	 <caption><h1>已上桌</h1></caption>
	 	<thead>
	 		<tr>
	 		<td>序号</td>
	 		<th>详情编号</th>
	 		<th>商品</th>
	 		<th>数量</th>
	 		<th>单价</th>
	 		<th>状态</th>
	 		</tr>
	 	</thead>
	 	<tbody id="tbody">
	
	 	
	 	</tbody>
	 </table>
	 </div>
	 <script type="text/javascript">
	 	function payinfo(){
	 		//window.location.href="${path}/car_OneroomOrder.action?orderid=${orderid }&roomid=${roomid }";
	 		alert("已通知");
	 	}
	 </script>
	 <div id="contentfooter">
	 	
	 	<!--  <input type="button"id="button" value="通知结账" class="btn btn-primary"  onclick="payinfo()"> -->
	 <!-- 按钮触发模态框 -->
	 	<!-- <button class="btn btn-primary btn-lg" id="button"data-toggle="modal" data-target="#myModal" disabled="disabled">结账</button> -->
	 </div>
<!-- 模态框（Modal） -->
 <%-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">订单编号:${orderid } <span>请到前台支付，总共￥${money }元</span></h4>
            </div>
            <div class="modal-body"> 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                 <button type="button" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> --%>
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
