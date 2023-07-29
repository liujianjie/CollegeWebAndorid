<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息</title>
    
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
	color:green;
	text-align:center;
	background: url('${path}/resource/img/1.png') repeat;
}
.table tr td{
			width:40px;
		}
.datediv{
 			float:left;
 		}
.fStyle{
			border:1px solid red;
			
		}
.dStyle{
			border:1px solid #7EB4EA;
			
		}
.span{
			color:red;
		}
#box{ 	
		width:1000px;
		height:500px;
		margin:0 auto;
		}
table{
		background:rgba(255,255,255,0.1);
	}
  </style>
   <script type="text/javascript">
   		$().ready(function(){
   			$("select[dizhi='toaddress']").change(function(){
	   		var province=$("#province1").val();
	   		var city=$("#city1").val();
	   		var district=$("#district1").val();
	   		$("#customeradd").val(province+city+district);
	   });
   		})
     	var state=true;
     	var flag=0;
     	function checkCustomername(){
     		$.ajax({
						url:"${path}/dc/CheckUsername",
						data:{"username":$("#customeruser").val(),"customerid":$("#cusid").val()},
						type:"post",
						dataType:"text",
						success:function(data){
							if(data=="true"){
								$("#customeruser").parent().next().find("span").html("用户名已经存在").addClass("span");
								$("#customeruser").addClass("fStyle");
								$("#sss").attr("disabled","disabled");
								state=false;
							}else{
								$("#customeruser").parent().next().find("span").html("<img src='${path }/resource/img/4.jpg'>");
								$("#customeruser").addClass("dStyle");
								$("#sss").removeAttr("disabled","disabled");
							}
						}
					});
     	}
     	function chencrepwd(){
     		var pwd=$("#pwd").val();
     		var repwd=$("#repwd").val();
     		if(pwd!=repwd){
     			$("#repwd").parent().next().find("span").html("重复密码错误").addClass("span");
				$("#repwd").addClass("fStyle");
				state=false;
				}else{
				$("#repwd").parent().next().find("span").html('');
				}
     	}
		function checkinfo(obj,Type){
			var Value=$(obj).val();
			var regname=/^.+$/;
			var regpwd=/^\w{4,12}$/;
			var regrepwd=$("#pwd").val();
			var regphone=/^((15)|(13)|(18))[0-9]{9}$/;
			if(Type=='name'&&!regname.test(Value)){
				$(obj).parent().next().find("span").html("姓名不能为空").addClass("span");
				$(obj).addClass("fStyle");
				state=false;
				flag=1;
			}else if(Type=='user'){
				if(!regname.test(Value)){
					$(obj).parent().next().find("span").html("用户名不能为空").addClass("span");
					$(obj).addClass("fStyle");
					 state=false;
				}
				
			}else if(Type=='pwd'&&!regpwd.test(Value)){
				$(obj).parent().next().find("span").html("密码长度4到12，字母数字").addClass("span");
				$(obj).addClass("fStyle");
				state=false;
				
			}else if(Type=='repwd'&&!regrepwd==Value){
				$(obj).parent().next().find("span").html("重复密码错误").addClass("span");
				$(obj).addClass("fStyle");
				state=false;
			}else if (Type=='phone'&&!regphone.test(Value)){
				$(obj).parent().next().find("span").html("电话格式错误").addClass("span");
				$(obj).addClass("fStyle");
				state=false;
			}else if(Type=='add'&&!regname.test(Value)){
				$(obj).parent().next().find("span").html("地址不为空").addClass("span");
				$(obj).addClass("fStyle");
				state=false;
			}
			else{
				$(obj).parent().next().find("span").html("<img src='${path }/resource/img/4.jpg'>");
				$(obj).addClass("dStyle");
			}
		}
		function sh(){
		state=true;
		checkCustomername()
		checkinfo("#customeruser",'user');
		checkinfo("#customername",'name');
		checkinfo("#pwd",'pwd');
		checkinfo("#repwd",'repwd');
		checkinfo("#customerphone",'phone');
		checkinfo("#customeradd",'add');
		chencrepwd();
		alert("请确认");
			if(state){
				$("#dd").submit();
				}else{
					alert("失败");
				}
		}
  </script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		var id=$("#cusid").val();
  		if(id!=null&&id!=''){
  			$("#dd").find("input").attr("disabled","disabled");
  		}
  	});
  	function removeattr(){
  		$("#dd").find("input").removeAttr("disabled");
  	}
  </script>
  </head>
  
  <body>
  <div class="header">
		<div class="container">
			<div class="logo wow bounceInDown animated" data-wow-delay="0.4s">
				<a href="index.html"><img src="${path }/resource/img/logo.png" alt="" /></a>
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
			
			<div class="clearfix"></div>
		</div>
	</div>
  <!-- 头部 -->
  
  <div id="box">
	 <h2 class="modal-title"  style="color: yellow;text-align:center;">
      <span>用户信息:</span>
		<span><input type="button" value="修改信息" onclick="removeattr()" class="btn btn-primary"></span>
     </h2>
	<div class="state">
	<form action="${path }/dc/Register" id="dd" method="post" class="form">
	<table class="table">
		<tr>
			<td>姓名:<input type="hidden" id="cusid" name="customerid"value="${onecustomerlist.customer_id }"></td>
			<td><input type="text" id="customername" name="customername" class="form-control"onblur="checkinfo(this,'name')"value="${onecustomerlist.customer_name }"></td>
			<td><span></span></td>
		</tr>
		<tr>
			<td>用户名:</td>
			<td><input type="text" id="customeruser"name="customeruser" class="form-control"onblur="checkCustomername()" value="${onecustomerlist.customer_account_name }"></td>
			<td><span></span></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" id="pwd" name="pwd"class="form-control"onblur="checkinfo(this,'pwd')" value="${onecustomerlist.customer_pwd }"></td>
			<td><span></span></td>
		</tr>
		<tr>
			<td>确认密码:</td>
			<td><input type="password" id="repwd" class="form-control"onblur="checkinfo(this,'repwd')" value="${onecustomerlist.customer_pwd }"></td>
			<td><span></span></td>
		</tr>
		<tr>
			<td>出生年月:</td>
			<td>
				<input class="Wdate form" type="text" name="birthday"onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" value="${onecustomerlist.customer_birthday }"> 
			</td>
			<td><span ></span></td>
		</tr>
		<tr>
			<td>性别:</td>
			<td colspan="2">
				<input type="radio" name="sex" value='0' <c:if test="${onecustomerlist.sex eq 0 }">checked="checked"</c:if>>男&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="sex" value='1'<c:if test="${onecustomerlist.sex eq 1 }">checked="checked"</c:if>>女
			</td>					
		</tr>
		<tr>
			<td>手机号:</td>
			<td><input type="text" id="customerphone" name="customerphone"class="form-control" onblur="checkinfo(this,'phone')" value="${onecustomerlist.customer_phone }"></td>
			<td><span ></span></td>
		</tr>
		<tr>
			<td> 收货住址</td>
			<td colspan="2">
			<div data-toggle="distpicker">
				<div class="datediv">
				<div class="input-group">
					<div class="form-group">
						<label class="sr-only" for="province1">Province</label>
						 <select class="form-control" dizhi='toaddress' name="province" id="province1" data-province="${onecustomerlist.customer_province }"></select>
					</div>
					<span class="input-group-addon">省</span>
				</div>
				</div>
				<div class="datediv">
					<div class="input-group">
						<div class="form-group">
							 <label class="sr-only" for="city1">City</label>
							  <select class="form-control" dizhi='toaddress' name="city" id="city1" data-city="${onecustomerlist.customer_city }"></select>
						</div>
						 <span class="input-group-addon">市</span>
					</div>
				</div>
				<div class="datediv">
					<div class="input-group">
						<div class="form-group">
							  <label class="sr-only" for="district1">District</label>
							  <select class="form-control" dizhi='toaddress' name="district" id="district1" data-district="${onecustomerlist.customer_district }"></select>
						</div>
						<span class="input-group-addon">县</span>
					</div>
				</div>
			</div>
			</td>
		</tr>
		<tr>
						<td>详细地址:</td>
						<td><input type="text" id="customeradd"name="customeradd" class="form-control"onblur="checkinfo(this,'add')" value="${onecustomerlist.customer_add }"></td>
						<td><span ></span></td>
		</tr>
		<tr>
						<td></td>
						<td><center><input type="button" onclick="sh()" id="sss" value="确认" class="btn btn-primary"></center></td>
						<td></td>
		</tr>
	</table>
	
	</form>
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
