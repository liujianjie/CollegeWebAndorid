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
<title>关于我们</title>
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
	 <div class="slider-bottom ">
		<div id="fh5co-about" data-section="about">
			
			<div class="fh5co-2col fh5co-text" >
				<h2 class="heading to-animate" align="center">关于我们</h2>
				<p class="to-animate">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;For the delicacy, we have a firm belief, we popularize healthy ingredients, 
					guide the quality of life: the wonderful food taste is worth pondering, but only to eat healthy to eat be
					tter. Help people to eat safe, healthy, beautiful, beautiful days of social responsibility; our cultural
					 heritage delicacy. Transfer positive energy: delicacy delicacy is a kind of cultural heritage, need, de
					 sire and innovation.</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				We are adhering to the "real thing to do a good job of each product, sincere service to every customer" business philosophy,
				 and "mission to bring happiness to the customer". Let the customer in the meal to feel more pleasure, we have been in the 
				 pursuit of product standardization efforts and dining environment, fine, warm. No matter is the product materials, cooking
				  methods, or eating utensils and on-site service, excellence, dare not neglect the slightest heart. Our main product "Shaanxi
				   thirteen hamburger" because of its authentic origin, taste crisp refreshing and much love. The customer product standardization,
				    cooking equipment standardization, standardization of operation for the restaurant chain. The delicacy store quality, on-site 
				    service, to provide good protection of health restaurant. In fact, the Chinese can do the same as the standard, and the taste 
				    is more excellent, also has the richly endowed by nature culture connotation. "Delicacy bring people happiness!", this sentence 
				    is our ultimate goal. We hope that through our unremitting efforts, let each Chinese to Chinese traditional delicacy proud
				  </p>
				<p class="text-center to-animate"><a href="${path }/module/Login/Contact.jsp" class="btn btn-primary btn-outline">Get in touch</a></p>
			</div>
			<div class="fh5co-2col fh5co-bg to-animate-2">
				<div style="width:33%;float:left"><img src=" ${path }/resource/img/p4.jpg"  /></div>
				<div style="width:33%;float:left"><img src=" ${path }/resource/img/p5.jpg"  /></div>
				<div style="width:33%;float:left"><img src=" ${path }/resource/img/p6.jpg"  /></div>
				
				
				
				
			</div>
			<p class="to-animate">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					对于美食，我们有着坚定的信念——我们普及健康食材，引导品质生活方式：食物的美妙味感固然值得玩味，但只有吃的健康，才算吃的美好。帮助人
					们吃的安全、健康、美好，是美天的社会责 任；我们传承美食文化，传递美食正能量：美食是一种文化，需要传承，渴望创新。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				我们秉承“真材实料做好
					每一份产品，真心实意服务每一位顾客”的经营理念，以及“把快乐带给顾客”的工作使命。让顾客在用餐时感受到更多的愉悦感，我们一直在努力追求产品和用餐
					环境的标准化、精细化、温馨化。无论是产品用料、烹制手法、还是饮食用具和现场服务，都精益求精，不敢有丝毫怠慢之心。我们
					的主打产品“陕十三肉夹馍”因其出身正宗、口感酥爽而备受顾客喜爱。产品生产标准化、烹饪设备标准化、餐厅操作标准化，为连锁门店的美食品质、现场服务、
					餐厅卫生提供了良好的保障。事实证明，中餐一样可以做到标准化，而且在口感方面更为出色，还具有得天独厚的文化内涵。“美食带给人们幸福！”，这句话是我们追
					求的终极目标。我们希望通过我们的不懈努力，让每个中国人都以中国传统美食为荣。
				  </p>
		</div>

		<div>
			<div class="container">
				<div class="row to-animate">

					<div class="flexslider">
						<img src=" ${path }/resource/img/icons1.png" style="float:left;height:340px" />
						<ul class="slides" style="list-style:none;">					
							<li>
								<blockquote>
									<p>&ldquo;Cooking is an art, but all art requires knowing something about the techniques and materials&rdquo;</p>
									<p class="quote-author">&mdash; Nathan Myhrvold</p>
								</blockquote>
							</li>
							<li>
								<blockquote>
									<p>&ldquo;Give a man food, and he can eat for a day. Give a man a job, and he can only eat for 30 minutes on break.&rdquo;</p>
									<p class="quote-author">&mdash; Lev L. Spiro</p>
								</blockquote>
							</li>
							<li>
								<blockquote>
									<p>&ldquo;Find something you’re passionate about and keep tremendously interested in it.&rdquo;</p>
									<p class="quote-author">&mdash; Julia Child</p>
								</blockquote>
							</li>
							<li>
								<blockquote>
									<p>&ldquo;Never work before breakfast; if you have to work before breakfast, eat your breakfast first.&rdquo;</p>
									<p class="quote-author">&mdash; Josh Billings</p>
								</blockquote>
							</li>
							
							
						</ul>
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
