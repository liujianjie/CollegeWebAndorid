<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>物流仓库管理系统-主页</title>


<!--[if lt IE 8]>
    <script>
        alert('H+已不支持IE6-8，请使用谷歌、火狐等浏览器\n或360、QQ等国产浏览器的极速模式浏览本页面！');
    </script>
    <![endif]-->

<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min.css?v=3.2.0" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/fileUpload.css?v=3.2.0"
	rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg">
	<%
		Object user = session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<input type="hidden" value="${user.id }" id="userid">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
		<div class="nav-close">
			<i class="fa fa-times-circle"></i>
		</div>
		<div class="sidebar-collapse">
			<ul class="nav" id="side-menu">
				<li class="nav-header">
					<div class="dropdown profile-element">
						<span><img alt="image" class="img-circle"
							src="${user.picpath}" style="width: 70px; height: 70px" /></span> <a
							data-toggle="dropdown" class="dropdown-toggle" href="index.jsp#">
							<span class="clear"> <span class="block m-t-xs"><strong
									class="font-bold">${user.username}</strong></span> <span
								class="text-muted text-xs block">${pname }<b
									class="caret"></b></span>
						</span>
						</a>
						<ul class="dropdown-menu animated fadeInRight m-t-xs">
							<li><a data-toggle="modal" href="index.jsp#updateFace">修改头像</a></li>
							<li><a class="J_menuItem" href="user/toinfo.do?id=${user.id }">个人资料</a></li>
							<li><a class="J_menuItem" href="user/userlist.do?pageCount=9&currPage=1&v=0">联系我们</a></li>
							<li><a class="J_menuItem" href="chat/tochat.do">聊天信息</a></li>
							<li class="divider"></li>
							<li><a href="user/logout.do">安全退出</a></li>
						</ul>
					</div>
					<div class="logo-element">WHM</div>
				</li>
				<li><a href="index.jsp#"> <i class="fa fa-home"></i> <span
						class="nav-label">主页</span>
				</a></li>
				<li><a class="J_menuItem"><i class="fa fa-columns"></i> <span
						class="nav-label">仓库管理</span> <span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<c:if test="${pname == '超级管理员' }">
							<li><a class="J_menuItem"
								href="Warehouse/list.do?currPage=1&v=hh">仓库列表</a></li>
						</c:if>
						<c:if test="${pname == '仓库管理员' }">
							<li><a class="J_menuItem" href="Warehouse/list2.do">仓库列表</a></li>
						</c:if>
						<!-- 注意别覆盖了！！！ -->
						<li><a class="J_menuItem">入库管理<span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<li>
									<c:if test="${pname == '仓库管理员' }">
										<a class="J_menuItem" href="instorage/list2.do?cpage=1&v=whm">计划入库</a>
									</c:if>
									<c:if test="${pname == '超级管理员' }">
										<a class="J_menuItem" href="instorage/list.do?cpage=1&v=whm">计划入库</a>
									</c:if>
								</li>
								<li>
									<c:if test="${pname == '仓库管理员' }">
										<a class="J_menuItem" href="receiving/list2.do?cpage=1&v=whm">收货列表</a>
									</c:if>
									<c:if test="${pname == '超级管理员' }">
										<a class="J_menuItem" href="receiving/list.do?cpage=1&v=whm">收货列表</a>
									</c:if>
								</li>
							</ul></li>
						<li><a class="J_menuItem">出库管理<span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<c:if test="${pname == '超级管理员' }">
									<li><a class="J_menuItem"
										href="outstorage/list.do?currPage=1&v=whm">出库计划</a></li>
								</c:if>
								<c:if test="${pname == '仓库管理员' }">
									<li><a class="J_menuItem"
										href="outstorage/list2.do?currPage=1&v=whm">出库计划</a></li>
								</c:if>
								<c:if test="${pname == '超级管理员' }">
									<li><a class="J_menuItem"
										href="Delivery/list.do?currPage=1&v=whm">出库单</a></li>
								</c:if>

								<c:if test="${pname == '仓库管理员' }">
									<li><a class="J_menuItem"
										href="Delivery/list2.do?currPage=1&v=whm">出库单</a></li>
								</c:if>
							</ul></li>
						<li><a class="J_menuItem">移库管理<span class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<c:if test="${pname == '仓库管理员' }">
									<li><a class="J_menuItem"
										href="movestorage/goodslist.do?userid=${user.id }&v=whm">仓库货物</a>
									</li>
									<li><a class="J_menuItem"
										href="movestorage/list.do?userid=${user.id }&cpage=1&v=whm">移货单</a></li>
									<li><a class="J_menuItem" 
										href="movestorage/listto.do?userid=${user.id }&v=whm">待办任务<span id="movestoragecount" class="label label-warning pull-right"></span></a>
									</li>
								</c:if>
								<c:if test="${pname == '超级管理员' }">
									<li><a class="J_menuItem"
										href="movestorage/list2.do?&cpage=1&v=whm">移货单</a></li>
								</c:if>
							</ul></li>              
					</ul></li>
				<c:if test="${pname == '仓库管理员' || pname == '超级管理员'}">
					<li><a class="J_menuItem"><i class="fa fa-bars"></i> <span
							class="nav-label">流程管理</span> <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="activity/listdeploy.do">流程部署管理</a></li>
							<li><a class="J_menuItem" href="activity/listpro.do">流程定义管理</a></li>
						</ul></li>
				</c:if>

				<li><a href="index.jsp#"> <i class="fa fa-bus"></i> <span
						class="nav-label">车辆管理</span> <span class="fa arrow"></span>
				</a>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem"
							href="hjx/selcars.do?pageCount=9&currPage=1&v=0">车辆列表</a></li>
						<li><a class="J_menuItem"
							href="hjx/selcars_dis.do?pageCount=9&currPage=1&v=0">车辆分配</a></li>
						<li><a class="J_menuItem"
							href="hjx/selcars_att.do?pageCount=9&currPage=1&v=0">车辆出勤</a></li>
					<!-- <li><a class="J_menuItem" href="hjx/selcars_rep.do?pageCount=9&currPage=1&v=0">车辆报修</a></li> -->	
					</ul></li>
				<c:if test="${pname == '仓库管理员' || pname == '超级管理员'}">
					<li><a href="index.jsp#"><i class="fa fa-jpy"></i> <span
							class="nav-label">财务管理 </span><span class="fa arrow"></span> </a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="salary/salarylist.do?pageCount=9&currPage=1&v=0">工资列表</a></li>
							<li><a class="J_menuItem"
								href="rewards_penalties/selrewards_penaltieslist.do?currPage=1&pageCount=9&v=0">奖惩记录</a></li>
							<li><a class="J_menuItem" href="income/incomelist.do?pageCount=9&currPage=1&v=0">收入</a></li>
							<li><a class="J_menuItem" href="expend/expendlist.do?pageCount=9&currPage=1&v=0">支出</a></li>
						</ul></li>
				</c:if>

				<li><a href="index.jsp#"><i class="fa fa-edit"></i> <span
						class="nav-label">待办任务</span></a>
				<li><a href="index.jsp#"><i class="fa fa-envelope"></i><span
						class="nav-label">消息管理</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem" href="chat/tochat.do">聊天消息</a></li>
						<li><a class="J_menuItem" href="findpagemsglist.do">通知管理</a></li>

					</ul></li>

				<c:if test="${pname == '仓库管理员' || pname == '超级管理员'}">
					<li><a href="index.jsp#"><i class="fa fa-flask"></i> <span
							class="nav-label">权限管理</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">

							<li><a class="J_menuItem"
								href="user/userlist.do?pageCount=9&currPage=1&v=0">用户管理</span></a></li>
							<li><a class="J_menuItem" href="user/toadd.do">添加用户 </a></li>
							<li><a class="J_menuItem"
								href="hjx/selposi.do?pageCount=9&currPage=1&v=0">岗位管理</a></li>
						</ul></li>
				</c:if>
		</div>
		</nav>
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<input type="hidden" id="path"
					value="${pageContext.request.contextPath}">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
						href="index.jsp#"><i class="fa fa-bars"></i> </a>
					<form role="search" class="navbar-form-custom" method="post"
						action="search_results.jsp">
						<div class="form-group"></div>
					</form>
				</div>
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle count-info"
						data-toggle="dropdown"  > <i
							class="fa fa-envelope"></i> <span class="label label-warning" id="sizes"></span>
					</a>

						<ul class="dropdown-menu dropdown-messages" id="xul">
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle count-info"
						data-toggle="dropdown" href="index.jsp#"> <i
							class="fa fa-bell"></i> <span class="label label-primary" id="xxx"></span>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li><a class="J_menuItem" href="movestorage/listto.do?userid=${user.id }&v=whm">
									<div>
										<i class="fa fa-envelope fa-fw"></i><span id="xxxx"> 您有16条未读消息</span> <span
											class="pull-right text-muted small">刚刚</span>
									</div>
							</a></li>
							<li class="divider"></li>
							
							<li>
								<div class="text-center link-block">
									<a class="J_menuItem" href="movestorage/listto.do?userid=${user.id }&v=whm"> <strong>查看所有
									</strong> <i class="fa fa-angle-right"></i>
									</a>
								</div>
							</li>
						</ul></li>
					<li class="dropdown hidden-xs"><a class="right-sidebar-toggle"
						aria-expanded="false"> <i class="fa fa-tasks"></i>
					</a></li>
				</ul>
				</nav>
			</div>
			<div class="row content-tabs">
				<button class="roll-nav roll-left J_tabLeft">
					<i class="fa fa-backward"></i>
				</button>
				<nav class="page-tabs J_menuTabs">
				<div class="page-tabs-content">
					<a href="javascript:;" class="active J_menuTab"
						data-id="index_v1.jsp">首页</a>
				</div>
				</nav>
				<button class="roll-nav roll-right J_tabRight">
					<i class="fa fa-forward"></i>
				</button>
				<div class="btn-group roll-nav roll-right">
					<button class="dropdown J_tabClose" data-toggle="dropdown">
						关闭操作<span class="caret"></span>

					</button>
					<ul role="menu" class="dropdown-menu dropdown-menu-right">
						<li class="J_tabShowActive"><a>定位当前选项卡</a></li>
						<li class="divider"></li>
						<li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
						<li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
					</ul>
				</div>
				<a href="user/logout.do" class="roll-nav roll-right J_tabExit"><i
					class="fa fa fa-sign-out"></i> 退出</a>
			</div>
			<div class="row J_mainContent" id="content-main">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="index_v2.jsp" frameborder="0" data-id="index_v1.jsp" seamless></iframe>
			</div>
			<div class="footer">
				<div class="pull-right">
					&copy; 2016-2017 <a href="" target="_blank">ht1504 yfbc</a>
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
		<!--右侧边栏开始-->
		<div id="right-sidebar">
			<div class="sidebar-container">

				<div class="tab-content">


					<div id="tab-1" class="tab-pane active">

						<div class="sidebar-title">
							<h3>
								<i class="fa fa-comments-o"></i> 最新通知
							</h3>

						</div>

						<div id="mail">

							
							
						</div>
					</div>
				</div>
			</div>
			<!--右侧边栏结束-->

		</div>

		<!-- 弹出form表单 start-->
		<div id="updateFace" class="modal fade" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<div class="row">
							<div class="col-sm-12">
								<div class="ibox float-e-margins">
									<div class="ibox-title">
										<h5>选择图片</h5>
									</div>
									<div class="ibox-content">
										<form class="form-horizontal m-t" id="signupForm"
											action="${pageContext.request.contextPath}/user/updateFace.do"
											method="post" enctype="multipart/form-data">
											<div class="uploader white">
												<input type="text" class="filename" readonly="readonly">
												<input type="button" class="button" value="上传..."> <input
													type="file" name="file" size="30" accept="image/*">
											</div>
											<div class="form-group">
												<div class="col-sm-8 col-sm-offset-8">
													<button class="btn btn-primary" type="submit">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>
												</div>
											</div>
											<input type="hidden" value="${user.id}" name="userid" />
										</form>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 弹出form表单 end-->



		<!-- 全局js -->
		<script src="js/jquery-2.1.1.min.js"></script>
		<script src="js/bootstrap.min.js?v=3.4.0"></script>
		<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
		<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
		<script src="js/plugins/layer/layer.min.js"></script>

		<!-- 自定义js -->
		<script src="js/hplus.min.js?v=3.2.0"></script>
		<script type="text/javascript" src="js/contabs.min.js"></script>

		<!-- 第三方插件 -->
		<script src="js/plugins/pace/pace.min.js"></script>

		<!-- ajax访问后台 查询 移库操作的代办任务数量 -->
		<script type="text/javascript">
			$(function() {
				var userid = $("#userid").val();
				$.post("movestorage/getmovestoragecount.do", {
					userid : userid
				}, function(result) {
					var i = result.movestoragecount;
					$("#movestoragecount").html(i);
					$("#xxx").html(i);
					$("#xxxx").html("您有"+i+"条代办任务");
				}, "json");
				
				var path = $("#path").val();
				
				$.post("chat/selindex.do", {}, function(result) {
					var list = result.list;
					var size = result.size;
					var str = "";
					$.each(list,function(index,chat){
					str+="<li class='m-t-xs'>"
						+"	<div class='dropdown-messages-box'>"
						+"		<a href='' class='pull-left'> <img alt='image' class='img-circle' src='"+path+"/"+chat.setuser.picpath+"'>"
						+"		</a>"
						+"		<div class='media-body'>"
						+"			 <span class='text-info'>"+chat.setuser.username+"</span>"
						+"			"+chat.chtext+" <br> <small class='text-muted'>"+chat.date+"</small>"
						+"		</div>"
						+"	</div>"
						+"</li>"
						+"<li class='divider'></li>";
					});
					str+="<li>"
						+"	<div class='text-center link-block'>"
						+"	<a class='J_menuItem' href='chat/tochat.do' target='iframe0'> <i class='fa fa-envelope'></i> <strong> 查看所有消息</strong>"
						+"	</a>"
						+"	</div>"
						+"	</li>";
					
					$("#xul").html(str);
					$("#sizes").html(size);
				}, "json");
				
				$.post("ajaxmsg.do", {}, function(result) {
					var list = result.msg
				var str = "";
				$.each(list,function(index,msg){
				str+="<div class='sidebar-message'>"
					+"		<a  href='todetil.do?id="+msg.id+"' target='iframe0'>"
					+"		<div class='pull-left text-cente'>"
					+"			<img alt='image' class='img-circle message-avatar' src='"+path+"/"+msg.user.picpath+"'>"
					+"		</div>"
					+"		<div class='media-body'>"
					+"			"+msg.msgtitle+" <br> <small class='text-muted'>"+msg.date+"</small>"
					+"		</div>"
					+"	</a>"
					+"</div>";
				});
				$("#mail").html(str);
				}, "json");
			});
			
			
		</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/fileUpload.js">
		</script>
		
</body>

</html>