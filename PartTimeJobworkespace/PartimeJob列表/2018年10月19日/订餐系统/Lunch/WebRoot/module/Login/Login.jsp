<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session.removeAttribute("roomid");
%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>网上订餐系统</title>
  <link rel="stylesheet" href="${path }/resource/css/bootstrap.css"/>
  <link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
  <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<script src="${path }/resource/js/distpicker.data.js"></script>
	<script src="${path }/resource/js/distpicker.js"></script>
	<script src="${path }/resource/js/main.js"></script>
 <script type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
  <style>
  	body{
  	width:100%;
  	height:100%;
  	background:url(${path }/resource/img/1.jpg) no-repeat center top;
  	margin:0px auto;
  	}
  	#bg{
  		width:100%;
  		height:100%;
  		margin:0px auto;
  	}
		#t1{
			width:300px;
			height: 200px;
			margin:200px auto;
			border: 1px solid black;
			background: white;
			z-index:1;
		}
		.table tr td{
			width:40px;
		}
		.datediv{
 			float:left;
 		}
		#t2{
			text-align: right;
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
  </style>
  
  <script type="text/javascript">
     	var state;
     	var flag=0;
		function checkinfo(obj,Type){
			 state=true;
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
				}else{
					$.ajax({
						url:"${path}/dc/CheckUsername",
						data:{"username":Value},
						type:"post",
						dataType:"text",
						success:function(data){
							if(data=="true"){
								$(obj).parent().next().find("span").html("用户名已经存在").addClass("span");
								$(obj).addClass("fStyle");
								$("#sss").attr("disabled","disabled");
								//alert("用户名已经存在");
							}else{
								$(obj).parent().next().find("span").html("<img src='${path }/resource/img/4.jpg'>");
								$(obj).addClass("dStyle");
								$("#sss").removeAttr("disabled","disabled");
							}
						}
					});
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
		checkinfo("#customeruser",'user');
		checkinfo("#customername",'name');
		checkinfo("#pwd",'pwd');
		checkinfo("#repwd",'repwd');
		checkinfo("#customerphone",'phone');
		checkinfo("#customeradd",'add');
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
  		$("#submituser").click(function(){
  			$.ajax({
  				url:"${path}/dc/Login",
  				data:$("#form1").serialize(),
  				type:"post",
  				dateType:"text",
  				success:function(data){
  					//alert(data);
  					if(data=="success"){
  						window.location.href="${path}/module/Login/Menu.jsp";
  					}else if(data=="pwderror"){
  						alert("密码错误！");
  					}
  					else{
  						alert("请先注册！");
  					}
  				}
  			});
  		});
  	});
  </script>
  </head>
 <body>
 	<div id="bg">
	<div id="t1">
		<form action="${path}/dc/Login" method ="post" id="form1" class="form">
			<table class="table table-hover">
				<tr>
					<td>登录界面</td>
				</tr>
				<tr>
					<td><input type="text" id="username"class="form-control" name="username" placeholder="请输入用户名" value="${customeruser }"></td>
				</tr>
				<tr>
					<td><input type="password" id="userpwd" class="form-control" name="userpwd"placeholder="请输入密码"></td>
				</tr>
				<tr>
					<td id="t2">
						<input type="button" value="登录" id="submituser"class="btn btn-danger" >
						<input type="button" value="注册" id="registeruser" class="btn btn-danger" data-target="#myModal99" data-toggle="modal">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="modal fade" id="myModal99" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
						<h4 class="modal-title" id="myModalLabel" style="color: blue;text-align:center;">
              				<span>注册界面:</span>
            			</h4>
				</div>
				<div class="modal-body">
					<form action="${path }/dc/Register" id="dd" method="post">
						<table class="table">
							<tr>
								<td>姓名:</td>
								<td><input type="text" id="customername" name="customername" class="form-control"onblur="checkinfo(this,'name')"></td>
								<td><span></span></td>
							</tr>
							<tr>
								<td>用户名:</td>
								<td><input type="text" id="customeruser"name="customeruser" class="form-control"onblur="checkinfo(this,'user')"></td>
								<td><span></span></td>
							</tr>
							<tr>
								<td>密码:</td>
								<td><input type="password" id="pwd" name="pwd"class="form-control"onblur="checkinfo(this,'pwd')"></td>
								<td><span></span></td>
							</tr>
							<tr>
								<td>确认密码:</td>
								<td><input type="password" id="repwd" class="form-control"onblur="checkinfo(this,'repwd')"></td>
								<td><span></span></td>
							</tr>
							<tr>
								<td>出生年月:</td>
								<td>
									<input class="Wdate form" type="text" name="birthday"onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"> 
								</td>
								<td><span ></span></td>
							</tr>
							<tr>
								<td>性别:</td>
								<td colspan="2">
									<input type="radio" name="sex" value='0' checked="checked">男&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="sex" value='1'>女
								</td>
								
							</tr>
							<tr>
								<td>手机号:</td>
								<td><input type="text" id="customerphone" name="customerphone"class="form-control" onblur="checkinfo(this,'phone')"></td>
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
							          			<select class="form-control"  name="province" id="province1" data-province="${oneemp.customer_province }"></select>
							       		 	</div>
							       		 	<span class="input-group-addon">省</span>
						       		 	</div>
						       		 </div>
						       		<div class="datediv">
						       		 	<div class="input-group">
							        		<div class="form-group">
							         			 <label class="sr-only" for="city1">City</label>
							          			<select class="form-control" name="city" id="city1" data-city="${oneemp.city }"></select>
							       			 </div>
							       			 <span class="input-group-addon">市</span>
						       			 </div>
						       		</div>
						       		<div class="datediv">
						       			 <div class="input-group">
							        		<div class="form-group">
							          			<label class="sr-only" for="district1">District</label>
							          			<select class="form-control"name="district" id="district1" data-district="${oneemp.district }"></select>
							       		 	</div>
							       		 	<span class="input-group-addon">县</span>
						       		 	</div>
						       		</div>
						       		</div>
								</td>
							</tr>
							<tr>
								<td>详细地址:</td>
								<td><input type="text" id="customeradd"name="customeradd" class="form-control"onblur="checkinfo(this,'add')"></td>
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
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">关闭 </button>
				</div>
			</div>
		</div>
	</div>
 	</div>
</body>
</html>