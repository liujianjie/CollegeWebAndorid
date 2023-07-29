<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>团团赚后台管理系统</title>

<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<!--[if lt IE 8]>
    <script>
        alert('H+已不支持IE6-8，请使用谷歌、火狐等浏览器\n或360、QQ等国产浏览器的极速模式浏览本页面！');
    </script>
    <![endif]-->

<link href="${pageContext.request.contextPath}/backgroundSystem/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/backgroundSystem/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/backgroundSystem/css/animate.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/backgroundSystem/css/style.min.css?v=3.2.0" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/backgroundSystem/img/profile_small.jpg" type="image/x-icon">
<!-- 文件 -->
	<link href="${pageContext.request.contextPath}/backgroundSystem/css/fileUpload.css?v=3.2.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg">
	<%
		Object user = session.getAttribute("backuser");
		if (user == null) {
			response.sendRedirect("login.jsp");
		}
	%>
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
						<span><img alt="image" class="img-circle" id="touxiang"
							src="${pageContext.request.contextPath }/${backuser.b_touxiang}" style="width:70px;height:70px" /></span> <a
							data-toggle="dropdown" class="dropdown-toggle" href="index.jsp#">
							<span class="clear"> <span class="block m-t-xs"><strong
									class="font-bold">${backuser.b_username}</strong></span> <span
								class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
						</span>
						</a>
						<ul class="dropdown-menu animated fadeInRight m-t-xs">
							<li><a  href="#updateFace" data-toggle="modal">修改头像</a></li>
							<li><a class="J_menuItem" href="${pageContext.request.contextPath }/backuser/toalert.action?id=${backuser.b_id}&v=3.0">个人资料</a></li>
							<li><a class="J_menuItem" href="contacts.jsp">联系我们</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">信箱</a></li>
							<li class="divider"></li>
							<li><a href="javascript:void(0);"
								onclick="location.href='<%=path%>/backlogin/exitLogin.action'">安全退出</a></li>
						</ul>
					</div>
					<div class="logo-element">赚</div>
				</li>
				<li><a href="index.jsp#"> <i class="fa fa-home"></i> <span
						class="nav-label">主页</span>
				</a></li>
				<c:if test="${fn:contains(qxlist,'1') }">
					<li><a href="layouts.jsp"><i class="fa fa-columns"></i> <span
							class="nav-label">人员管理</span> <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath }/backuser/toadd.action">添加人员</a></li>
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath }/backuser/userlist.action?cpage=1&v=whm">人员信息</a></li>
							<li><a class="J_menuItem"
								href="${pageContext.request.contextPath }/userper/userlist.action?cpage=1&v=whm">权限管理</a></li>
						</ul>
					</li>
				</c:if>


				<c:if test="${fn:contains(qxlist,'2') }">
					<li><a href="index.jsp#"> <i class="fa fa fa-bar-chart-o"></i>
							<span class="nav-label">网站会员</span> <span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="<%=path%>/user/selectAllTtzUser.action">注册会员管理</a></li>
							<li><a class="J_menuItem" href="">会员认证管理</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">会员信息修改</a></li>
						</ul></li>
				</c:if>

				<c:if test="${fn:contains(qxlist,'3') }">
					<li><a href="mailbox.jsp"><i class="fa fa-envelope"></i> <span
							class="nav-label">财务管理 </span><span class="fa arrow"></span> </a> <!-- 						<span class="label label-warning pull-right">16</span></a> -->
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="mailbox.jsp">提现管理</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">银行卡管理</a></li>
							<li><a class="J_menuItem" href="<%=path%>/moneyrecord/TopupMoner.action">充值记录</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">手续费记录</a></li>
							<li><a class="J_menuItem" href="<%=path%>/moneyrecord/TradingRecord.action">交易记录</a></li>
						</ul></li>
				</c:if>

				<c:if test="${fn:contains(qxlist,'4') }">
					<li><a href="index.jsp#"><i class="fa fa-desktop"></i> <span
							class="nav-label">借贷管理</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="mailbox.jsp">投资管理</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">借贷管理</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">资金异常记录</a></li>
						</ul></li>
				</c:if>

				<c:if test="${fn:contains(qxlist,'5') }">
					<li><a href="index.jsp#"><i class="fa fa-desktop"></i> <span
							class="nav-label">设置项</span><span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="mailbox.jsp">认证项设置</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">信用额度设置</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">费率设置</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">银行设置</a></li>
							<li><a class="J_menuItem" href="mailbox.jsp">筹款期限设置</a></li>
						</ul></li>
				</c:if>

				<li><a href="index.jsp#"><i class="fa fa-table"></i> <span
						class="nav-label">表格</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem" href="table_basic.jsp">基本表格</a></li>
						<li><a class="J_menuItem" href="table_data_tables.jsp">DataTables</a>
						</li>
						<li><a class="J_menuItem" href="table_jqgrid.jsp">jqGrid</a>
						</li>
						<li><a class="J_menuItem" href="table_foo_table.jsp">Foo
								Tables</a></li>
					</ul></li>
				<li><a href="index.jsp#"><i class="fa fa-picture-o"></i> <span
						class="nav-label">相册</span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem" href="basic_gallery.jsp">基本图库</a></li>
						<li><a class="J_menuItem" href="carousel.jsp">图片切换</a></li>
						<li><a class="J_menuItem" href="layerphotos.jsp">layer相册</a>
						</li>
						<li><a class="J_menuItem" href="blueimp.jsp">Blueimp相册</a></li>
					</ul></li>
				<li><a class="J_menuItem" href="css_animation.jsp"><i
						class="fa fa-magic"></i> <span class="nav-label">CSS动画</span></a></li>
				<li><a href="index.jsp#"><i class="fa fa-cutlery"></i> <span
						class="nav-label">工具 </span><span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem" href="form_builder.jsp">表单构建器</a></li>
					</ul></li>

			</ul>
		</div>
		</nav>
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
						href="index.jsp#"><i class="fa fa-bars"></i> </a>
					<form role="search" class="navbar-form-custom" method="post"
						action="search_results.jsp">
						<div class="form-group">
							<input type="text" placeholder="请输入您需要查找的内容 …"
								class="form-control" name="top-search" id="top-search">
						</div>
					</form>
				</div>
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown"><a class="dropdown-toggle count-info"
						data-toggle="dropdown" href="index.jsp#"> <i
							class="fa fa-envelope"></i> <span class="label label-warning">16</span>
					</a>
						<ul class="dropdown-menu dropdown-messages">
							<li class="m-t-xs">
								<div class="dropdown-messages-box">
									<a href="profile.jsp" class="pull-left"> <img alt="image"
										class="img-circle" src="img/a7.jpg">
									</a>
									<div class="media-body">
										<small class="pull-right">46小时前</small> <strong>小四</strong>
										这个在日本投降书上签字的军官，建国后一定是个不小的干部吧？ <br> <small
											class="text-muted">3天前 2014.11.8</small>
									</div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="dropdown-messages-box">
									<a href="profile.jsp" class="pull-left"> <img alt="image"
										class="img-circle" src="img/a4.jpg">
									</a>
									<div class="media-body ">
										<small class="pull-right text-navy">25小时前</small> <strong>国民岳父</strong>
										如何看待“男子不满自己爱犬被称为狗，刺伤路人”？——这人比犬还凶 <br> <small
											class="text-muted">昨天</small>
									</div>
								</div>
							</li>
							<li class="divider"></li>
							<li>
								<div class="text-center link-block">
									<a class="J_menuItem" href="mailbox.jsp"> <i
										class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
									</a>
								</div>
							</li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle count-info"
						data-toggle="dropdown" href="index.jsp#"> <i
							class="fa fa-bell"></i> <span class="label label-primary">8</span>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li><a href="mailbox.jsp">
									<div>
										<i class="fa fa-envelope fa-fw"></i> 您有16条未读消息 <span
											class="pull-right text-muted small">4分钟前</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="profile.jsp">
									<div>
										<i class="fa fa-qq fa-fw"></i> 3条新回复 <span
											class="pull-right text-muted small">12分钟钱</span>
									</div>
							</a></li>
							<li class="divider"></li>
							<li>
								<div class="text-center link-block">
									<a class="J_menuItem" href="notifications.jsp"> <strong>查看所有
									</strong> <i class="fa fa-angle-right"></i>
									</a>
								</div>
							</li>
						</ul></li>
					<li class="hidden-xs"><a href="index_v1.jsp"
						class="J_menuItem" data-index="0"><i
							class="fa fa-cart-arrow-down"></i> 购买</a></li>
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
				<a href="login.jsp" class="roll-nav roll-right J_tabExit"><i
					class="fa fa fa-sign-out"></i> 退出</a>
			</div>
			<!--右侧窗口  -->
			<div class="row J_mainContent" id="content-main">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="index_v3.jsp" frameborder="0" data-id="index_v1.jsp" seamless></iframe>
			</div>
			<div class="footer">
				<div class="pull-right">
					&copy; 2014-2015 <a href="../../index.jsp" target="_blank">zihan's
						blog</a>
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
		<!--右侧边栏开始-->
		<div id="right-sidebar">
			<div class="sidebar-container">

				<ul class="nav nav-tabs navs-3">

					<li class="active"><a data-toggle="tab" href="index.jsp#tab-1">
							通知 </a></li>
					<li><a data-toggle="tab" href="index.jsp#tab-2"> 项目进度 </a></li>
					<li class=""><a data-toggle="tab" href="index.jsp#tab-3">
							<i class="fa fa-gear"></i>
					</a></li>
				</ul>

				<div class="tab-content">


					<div id="tab-1" class="tab-pane active">

						<div class="sidebar-title">
							<h3>
								<i class="fa fa-comments-o"></i> 最新通知
							</h3>
							<small><i class="fa fa-tim"></i> 您当前有10条未读信息</small>
						</div>

						<div>

							<div class="sidebar-message">
								<a href="index.jsp#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar"
											src="img/a1.jpg">

										<div class="m-t-xs">
											<i class="fa fa-star text-warning"></i> <i
												class="fa fa-star text-warning"></i>
										</div>
									</div>
									<div class="media-body">

										据天津日报报道：瑞海公司董事长于学伟，副董事长董社轩等10人在13日上午已被控制。 <br> <small
											class="text-muted">今天 4:21</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="index.jsp#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar"
											src="img/a2.jpg">
									</div>
									<div class="media-body">
										HCY48之音乐大魔王会员专属皮肤已上线，快来一键换装拥有他，宣告你对华晨宇的爱吧！ <br> <small
											class="text-muted">昨天 2:45</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="index.jsp#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar"
											src="img/a3.jpg">

										<div class="m-t-xs">
											<i class="fa fa-star text-warning"></i> <i
												class="fa fa-star text-warning"></i> <i
												class="fa fa-star text-warning"></i>
										</div>
									</div>
									<div class="media-body">
										写的好！与您分享 <br> <small class="text-muted">昨天 1:10</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="index.jsp#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar"
											src="img/a4.jpg">
									</div>

									<div class="media-body">
										国外极限小子的炼成！这还是亲生的吗！！ <br> <small class="text-muted">昨天
											8:37</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="index.jsp#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar"
											src="img/a8.jpg">
									</div>
									<div class="media-body">

										一只流浪狗被收留后，为了减轻主人的负担，坚持自己觅食，甚至......有些东西，可能她比我们更懂。 <br> <small
											class="text-muted">今天 4:21</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="index.jsp#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar"
											src="img/a7.jpg">
									</div>
									<div class="media-body">
										这哥们的新视频又来了，创意杠杠滴，帅炸了！ <br> <small class="text-muted">昨天
											2:45</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="index.jsp#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar"
											src="img/a3.jpg">

										<div class="m-t-xs">
											<i class="fa fa-star text-warning"></i> <i
												class="fa fa-star text-warning"></i> <i
												class="fa fa-star text-warning"></i>
										</div>
									</div>
									<div class="media-body">
										最近在补追此剧，特别喜欢这段表白。 <br> <small class="text-muted">昨天
											1:10</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="index.jsp#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar"
											src="img/a4.jpg">
									</div>
									<div class="media-body">
										我发起了一个投票 【你认为下午大盘会翻红吗？】 <br> <small class="text-muted">星期一
											8:37</small>
									</div>
								</a>
							</div>
						</div>

					</div>

					<div id="tab-2" class="tab-pane">

						<div class="sidebar-title">
							<h3>
								<i class="fa fa-cube"></i> 最新任务
							</h3>
							<small><i class="fa fa-tim"></i> 您当前有14个任务，10个已完成</small>
						</div>

						<ul class="sidebar-list">
							<li><a href="index.jsp#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>市场调研</h4> 按要求接收教材；

									<div class="small">已完成： 22%</div>
									<div class="progress progress-mini">
										<div style="width: 22%;"
											class="progress-bar progress-bar-warning"></div>
									</div>
									<div class="small text-muted m-t-xs">项目截止： 4:00 -
										2015.10.01</div>
							</a></li>
							<li><a href="index.jsp#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>可行性报告研究报上级批准</h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的
									开发进度作出一个合理的比对

									<div class="small">已完成： 48%</div>
									<div class="progress progress-mini">
										<div style="width: 48%;" class="progress-bar"></div>
									</div>
							</a></li>
							<li><a href="index.jsp#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>立项阶段</h4> 东风商用车公司 采购综合综合查询分析系统项目进度阶段性报告武汉斯迪克科技有限公司

									<div class="small">已完成： 14%</div>
									<div class="progress progress-mini">
										<div style="width: 14%;"
											class="progress-bar progress-bar-info"></div>
									</div>
							</a></li>
							<li><a href="index.jsp#"> <span
									class="label label-primary pull-right">NEW</span>
									<h4>设计阶段</h4> <!--<div class="small pull-right m-t-xs">9小时以后</div>-->
									项目进度报告(Project Progress Report)
									<div class="small">已完成： 22%</div>
									<div class="small text-muted m-t-xs">项目截止： 4:00 -
										2015.10.01</div>
							</a></li>
							<li><a href="index.jsp#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>拆迁阶段</h4> 科研项目研究进展报告 项目编号: 项目名称: 项目负责人:

									<div class="small">已完成： 22%</div>
									<div class="progress progress-mini">
										<div style="width: 22%;"
											class="progress-bar progress-bar-warning"></div>
									</div>
									<div class="small text-muted m-t-xs">项目截止： 4:00 -
										2015.10.01</div>
							</a></li>
							<li><a href="index.jsp#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>建设阶段</h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的
									开发进度作出一个合理的比对

									<div class="small">已完成： 48%</div>
									<div class="progress progress-mini">
										<div style="width: 48%;" class="progress-bar"></div>
									</div>
							</a></li>
							<li><a href="index.jsp#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>获证开盘</h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的
									开发进度作出一个合理的比对

									<div class="small">已完成： 14%</div>
									<div class="progress progress-mini">
										<div style="width: 14%;"
											class="progress-bar progress-bar-info"></div>
									</div>
							</a></li>

						</ul>

					</div>

					<div id="tab-3" class="tab-pane">

						<div class="sidebar-title">
							<h3>
								<i class="fa fa-gears"></i> 设置
							</h3>
						</div>

						<div class="setings-item">
							<span> 显示通知 </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu"
										class="onoffswitch-checkbox" id="example"> <label
										class="onoffswitch-label" for="example"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> 隐藏聊天窗口 </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu" checked
										class="onoffswitch-checkbox" id="example2"> <label
										class="onoffswitch-label" for="example2"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> 清空历史记录 </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu"
										class="onoffswitch-checkbox" id="example3"> <label
										class="onoffswitch-label" for="example3"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> 显示聊天窗口 </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu"
										class="onoffswitch-checkbox" id="example4"> <label
										class="onoffswitch-label" for="example4"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> 显示在线用户 </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" checked name="collapsemenu"
										class="onoffswitch-checkbox" id="example5"> <label
										class="onoffswitch-label" for="example5"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> 全局搜索 </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" checked name="collapsemenu"
										class="onoffswitch-checkbox" id="example6"> <label
										class="onoffswitch-label" for="example6"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>
						<div class="setings-item">
							<span> 每日更新 </span>
							<div class="switch">
								<div class="onoffswitch">
									<input type="checkbox" name="collapsemenu"
										class="onoffswitch-checkbox" id="example7"> <label
										class="onoffswitch-label" for="example7"> <span
										class="onoffswitch-inner"></span> <span
										class="onoffswitch-switch"></span>
									</label>
								</div>
							</div>
						</div>

						<div class="sidebar-content">
							<h4>设置</h4>
							<div class="small">你可以从这里设置一些常用选项，当然啦，这个只是个演示的示例。</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<!--右侧边栏结束-->

	</div>

	<!-- 修改头像  -->
	<div id="updateFace" class="modal fade" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
            	<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">选择照片</h4>
                </div>
                <div class="modal-body">
                	<!-- 自动增长 -->
                	<form  class="form-horizontal m-t" >
						<!-- id -->
						<input type="hidden" id="backuserid" name="backuserid" value = "${backuser.b_id }">
						<div class="form-group"> 
							<div class="col-sm-7 control-label">
								<div class="uploader white">
									<input type="text" class="filename" readonly="readonly">
									<input type="button" class="button" value="上传..."> <input
											type="file" name="files" id="files" size="30"
											accept="image/*" onchange="have();">
								</div>
							</div>
							<div class="col-sm-2 control-label">
                    			<button id="sbt" data-dismiss="modal"  class="btn btn-primary" disabled="disabled" onclick="UpladFile();">提交</button>
                			</div>
						</div>
					</form>
				</div>
				
            </div>
        </div>
    </div>
	
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
	<!-- 不知道为什么 必须放在后面，好像 把上面的js 放到后面就行了，哦我知道了，这里使用了id而页面还没加载过-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/backgroundSystem/js/fileUpload.js"></script>
	
	
	<!-- 修改头像 -->
	<script>
		//按钮
		function have(){
			$("#sbt").attr("disabled",false);
		}
		function UpladFile() {
			var bkuserid = $("#backuserid").val();
            var fileObj = document.getElementById("files").files[0]; // 获取文件对象
            var FileController = "${pageContext.request.contextPath }/backuser/indexupdateFace.action";                    // 接收上传文件的后台地址 
            // FormData 对象
            var form = new FormData();
            form.append("author", "hooyes");                        // 可以增加表单数据
            form.append("files", fileObj);                           // 文件对象 files是name
            form.append("id", bkuserid); //还有id
            // XMLHttpRequest 对象
            var xhr = new XMLHttpRequest();
            xhr.open("post", FileController, true);
            xhr.onload = function (results) {
                //修改头像
                var src = "${pageContext.request.contextPath }/backgroundSystem/image/"+fileObj.name;
                $("#touxiang").attr("src",src); 
            };
            xhr.send(form);
        }
		
	</script>
	<!-- 修改头像结束 -->

</body>

</html>