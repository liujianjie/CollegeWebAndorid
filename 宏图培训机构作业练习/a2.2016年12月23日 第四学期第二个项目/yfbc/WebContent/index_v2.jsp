<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 主页</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

<!-- Gritter -->
<link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min.css?v=3.2.0" rel="stylesheet">

</head>

<body class="gray-bg" onload="selchat();">
	<%
		Object user = session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<input type="hidden" value="${user.id }" id="userid">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>个人资料</h5>
					</div>
					<div class="ibox-content">
<!-- 						<div class="ibox-content profile-content"> -->
							<h5><strong>电话：<span id="phone"></span></strong></h5>
							<h5><strong>性别：<span id="sex"></span></strong></h5>
							<h5><strong>住址：<i class="fa fa-map-marker"></i><span id="address"></span></strong></h5>
<!-- 						</div> -->
					</div>
				</div>
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>最新通知</h5>
						<div class="ibox-tools">
							
						</div>
					</div>
					<div class="ibox-content no-padding" id="newmsg">
						<ul class="list-group">
							<li class="list-group-item">
								<p>
									<a class="text-info" href="index.jsp#">#感谢有你#</a>
									感谢你们一路的相伴，未来也请让我为你们撑腰，我们会更好
								</p> <small class="block text-muted"><i
									class="fa fa-clock-o"></i> 1分钟前</small>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>最新聊天消息</h5>
						<input type="hidden" id="path" value="${pageContext.request.contextPath}">
					</div>
					<div class="ibox-content">

						<div>
							<div class="feed-activity-list" id="chatlist">
								
							</div>
							<button class="btn btn-primary btn-block m-t" onclick="javascript:selchatAll();">
								<i class="fa fa-arrow-down"></i> 加载更多
							</button>
						</div>

					</div>
				</div>
				<input type="hidden" value="${user.id }" id="userid">
			</div>
			<div class="col-sm-4">
				<div class="ibox float-e-margins">
					<div class="ibox-content ibox-heading">
						<h3>最近三个月收入支出情况</h3>
					</div>
					<div class="ibox-content timeline" id="shouru">
						
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- 全局js -->
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/bootstrap.min.js?v=3.4.0"></script>



	<!-- Flot -->
	<script src="js/plugins/flot/jquery.flot.js"></script>
	<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script src="js/plugins/flot/jquery.flot.spline.js"></script>
	<script src="js/plugins/flot/jquery.flot.resize.js"></script>
	<script src="js/plugins/flot/jquery.flot.pie.js"></script>

	<!-- Peity -->
	<script src="js/plugins/peity/jquery.peity.min.js"></script>
	<script src="js/demo/peity-demo.min.js"></script>

	<!-- 自定义js -->
	<script src="js/content.min.js?v=1.0.0"></script>


	<!-- jQuery UI -->
	<script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>

	<!-- GITTER -->
	<script src="js/plugins/gritter/jquery.gritter.min.js"></script>

	<!-- EayPIE -->
	<script src="js/plugins/easypiechart/jquery.easypiechart.js"></script>

	<!-- Sparkline -->
	<script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

	<!-- Sparkline demo data  -->
	<script src="js/demo/sparkline-demo.min.js"></script>

	<script>
		$(document)
				.ready(
						function() {
							var userid = $("#userid").val();
							var i;
							$.post("movestorage/getmovestoragecount.do", {
								userid : userid
							}, function(result) {
							 i = result.movestoragecount;
							}, "json");
							WinMove();
							setTimeout(
									function() {
										$.gritter
												.add({
													title : "您有"+i+"条代办任务",
													text : "请前往<a href='movestorage/listto.do?userid="+userid+"&v=whm' class='text-warning'>代办任务</a>查看今日任务",
													time : 10000
												})
									}, 2000);

						});
		
		function selchat() {
			var path = $("#path").val();
			$.post("chat/selindex.do", {}, function(result) {
				var list = result.list;
				var str = "";
				$.each(list,function(index,chat){
					str+="<div class='feed-element'>"
						+"	<a href='profile.jsp' class='pull-left'> "
						+"		<img alt='image' class='img-circle' src='"+path+"/"+chat.setuser.picpath+"'>"
						+"	</a>"
						+"	<div class='media-body '>"
						+"		<strong>"+chat.setuser.username+"</strong> <br> <small class='text-muted'>"+chat.date
						+"		</small>"
						+"		<div class='well'>"+chat.chtext+"</div>"
						+"	</div>"
						+"</div>"
					
				});
				$("#chatlist").html(str);
			}, "json");
		}
		
		function selchatAll() {
			var path = $("#path").val();
			$.post("chat/selindexall.do", {}, function(result) {
				var list = result.list;
				var str = "";
				$.each(list,function(index,chat){
					str+="<div class='feed-element'>"
						+"	<a href='profile.jsp' class='pull-left'> "
						+"		<img alt='image' class='img-circle' src='"+path+"/"+chat.setuser.picpath+"'>"
						+"	</a>"
						+"	<div class='media-body '>"
						+"		<strong>"+chat.setuser.username+"</strong> <br> <small class='text-muted'>"+chat.date
						+"		</small>"
						+"		<div class='well'>"+chat.chtext+"</div>"
						+"	</div>"
						+"</div>"
					
				});
				$("#chatlist").html(str);
			}, "json");
		}
		
		$(function(){
			var path = $("#path").val();
			$.post("ajaxmsg2.do", {}, function(result) {
				var list = result.msg
			var str = "";
			$.each(list,function(index,msg){
			str+="<ul class='list-group'>"
				+"		<li class='list-group-item'>"
				+"			<p>"
				+"				<a class='text-info' href='index.jsp#'>#"+msg.msgpeople+"#</a>"
				+"<form action='download2.do' method='post'  id='forms'>"
				+"<input name='filename' value='"+msg.msgfile+"' type='hidden' />"
				+msg.msgtitle+"&nbsp;&nbsp;&nbsp;&copy;附件:<a onclick='formss();'>"+msg.msgfile+"</a>"
				+"</form>"
				+"		<br><div class='well'>"+msg.msgcon+"</div>"
				+"			</p> <small class='block text-muted'><i class='fa fa-clock-o'></i> "+msg.date+"</small>"
				+"		</li>"
				+"	</ul>"
			});
			$("#newmsg").html(str);
			}, "json");
		});
		
		$(function(){
			
			//查询最新三个月的收入支出数据（总支出，总收入）
			$.post("salary/showindex.do",{},function(data){
				var showindexlist=data.showindexlist;
				var str="";
				$.each(showindexlist,function(index,showindex){
					str+="<div class='timeline-item'>";
					str+="	<div class='row'>";
					str+="		<div class='col-xs-3 date'>";
					str+="		"+showindex.time+" <br />";
					str+="		</div>";
					str+="		<div class='col-xs-7 content'>";
					str+=" 			<p class='m-b-xs'><strong>收入</strong></p>";
					str+="			<p>"+showindex.income+"</p>";
					str+=" 			<p class='m-b-xs'><strong>支出</strong></p>";
					str+="			<p>"+showindex.expend+"</p>";
					str+="		</div>";
					str+="	</div>";
					str+="</div>";
				});
				$("#shouru").html(str);
			},"json");
		});
	</script>
	
	<script type="text/javascript">
		function formss() {
			$("#forms").submit();
		}
	</script>
<!-- 个人资料 -->
	<script type="text/javascript">
		$(function() {
			var userid = $("#userid").val();
			$.post("user/userxq.do",{userid : userid},function(result) {
				var user = result.user;
				$("#phone").html(user.mobile);
				$("#sex").html(user.sex);
				$("#address").html(user.address);
				
			}, "json");
		});
	
	</script>

</body>

</html>