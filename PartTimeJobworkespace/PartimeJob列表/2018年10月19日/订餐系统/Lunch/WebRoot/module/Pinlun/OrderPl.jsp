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
<title>主页</title>
<link href="${path }/resource/css/bootstrap.css" rel='stylesheet' type='text/css' />
<script src="${path }/resource/js/jquery.js"></script>
<link href="${path }/resource/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="My Recipes Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<script src="${path }/resource/js/responsiveslides.min.js"></script>
<link rel="stylesheet" href="${path}/resource/css/bootstrap.min.css" />
<script type="text/javascript" src="${path }/resource/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${path }/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
 <script>
    $(function () {
      
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
  #center{
      border:1px solid white;
      width:960px;
      height:260px;
      margin:0px auto;
   }
   #aleft{ 
      width:320px;
      height:260px;
      float:left;
   }
   #aright{
      color:green;
      font-family:"微软简综艺";
      font-size:80px;
      margin:5% auto;
   }
   #tab td{ width:33.3%;}
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
		<div id="center">
		  <div id="aleft">
		   <img src="${path }/resource/img/haha.jpg" alt="" width="310px" height="250px" />
		   </div>
		   <div id="aright">你已成功收货！</div>
		</div>
</div>
<div>
    <div align="center"><h2>订单详情</h2></div>
   <table id="tab" class="table">
      <tr align="center">
         <td>菜品</td>
         <td>数量</td>
         <td>单价</td>
      </tr>
      <c:if test="${!empty list }">
         <c:forEach items="${list }" var="son">
            <tr align="center">
               <td>${son.meal_name }</td>
               <td>${son.count }</td>
               <td>${son.meal_price }</td>
            </tr>
         </c:forEach>
      </c:if>
   </table>
   	<div>
	  <hr style="height:1px;border:none;border-top:1px dashed  #0066CC;" />
 	</div>
</div>
<div>
   <div align="center"><h2>相关评论</h2></div>
   <table id="tab" class="table">
       <c:if test="${!empty plist }"> 
		 <c:forEach items="${plist }" var="qtt">
		   <tr>
		     <td colspan="3"><h3>菜品:${qtt.meal_name }</h3></td>
		   </tr>
		       <c:forEach items="${qtt.comments }" var="aa">
		           	<tr>
				  	<td>${aa.customer_name } : ${aa.comment_content }</td>
				  	<td>评分:
				  	<c:if test="${ aa.comment_grade > 0 }">
				  		<c:forEach begin="1" end="${aa.comment_grade }">
				  			<img src="${path }/resource/img/star_red.png">
				  		</c:forEach>
				  		<c:forEach begin="1" end="${5-aa.comment_grade }">
				  			<img src="${path }/resource/img/star.png">
				  		</c:forEach>
				  	</c:if>
				   <c:if test="${aa.comment_grade eq 0}">
				  		<c:forEach begin="1" end="${5-aa.comment_grade }">
				  			<img src="${path }/resource/img/star.png">
				  		</c:forEach>
				  	</c:if>
				  	</td>
				  	<td>评论时间:${aa.comment_date }</td>
					</tr>
					<tr>
				   	<td>店家回复:${aa.comment_replay }</td>
				   	<td></td>
			       	<td>回复时间:${aa.replay_time }</td>
					</tr>
		       </c:forEach>
		       <tr align="center">
		          <td colspan="3">
	                  <a class="btn btn-info" data-toggle="modal" data-target="#myModal" 
	                  href="${path }/module/Pinlun/com_CustomerPl.action?mealid=${qtt.meal_id }&orderid=${orderid}" >
	                                              追加评论
	                   </a>
	              </td>
		       </tr>
		    <tr>
			 <td colspan="3"><hr style="height:3px;border:none;border-top:1px dashed  #0066CC;" /></td>
			</tr>
			</c:forEach>		 	   
		 </c:if>
		  <c:if test="${empty plist }">
			<c:if test="${!empty meal }"> 
			 <c:forEach items="${meal }" var="meal">
			   <tr>
			     <td colspan="3">菜品:${meal.meal_name }</td>
			   </tr>
			   <tr align="center">
		          <td colspan="3">
	                  <a class="btn btn-info" data-toggle="modal" data-target="#myModal" 
	                  href="${path }/module/Pinlun/com_CustomerPl.action?mealid=${qtt.meal_id }&orderid=${orderid}" >
	                                              追加评论
	                   </a>
	              </td>
		       </tr>
			    <tr>
				 <td colspan="3"><hr style="height:3px;border:none;border-top:1px dashed  #0066CC;" /></td>
				</tr>
				</c:forEach>		 	   
			 </c:if>
		</c:if>
   </table>
</div>
</div>
	<div class="footer">
		<div class="container">
			<p class="wow bounceInLeft animated" data-wow-delay="0.4s">金色小组 &copy; 2018  所有QY74第2组成员  | 设计 &nbsp;<a href="http://w3layouts.com" target="target_blank">就是我们</a></p>
		</div>
	</div>
    <div class="modal fade" id="myModal" data-backdrop="false" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"aria-hidden="true">
		 <div class="modal-dialog">
			 <div class="modal-content">
			 </div>
		 </div>
	 </div>	
   <a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>	
</body>
</html>
					
					
					