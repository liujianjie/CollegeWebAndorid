<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>团团赚网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link href="<%=path%>/foregroundSystem/css/index.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
<%
	session.setAttribute("system", "前台系统");
%>
<style>
/*上下滚动*/
#scrollDiv {
	width: 400px;
	height: 30px;
	line-height: 30px;
	overflow: hidden;
}

#scrollDiv li {
	height: 30px;
	padding-left: 10px;
}
</style>
<script type="text/javascript">
	// 上下滚动
	function AutoScroll(obj) {
		$(obj).find("ul:first").animate({
			marginTop : "-25px"
		},
			500,
			function() {
				$(this).css({
					marginTop : "0px"
				}).find("li:first").appendTo(this);
			});
	}
	$(document).ready(function() {
		var myar = setInterval('AutoScroll("#scrollDiv")', 3000);
		$("#scrollDiv").hover(function() {
			clearInterval(myar);
		},
			function() {
				myar = setInterval('AutoScroll("#scrollDiv")', 3000)
			}); //当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始
	});
</script>
</head>
<body>
	<header>
	<div class="header-top min-width">
		<div class="container fn-clear">
			<strong class="fn-left">咨询热线：400-668-6698<span
				class="s-time">服务时间：9:00 - 18:00</span></strong>
			<ul class="header_contact">
				<li class="c_1"><a class="ico_head_weixin" id="wx"></a>
					<div class="ceng" id="weixin_xlgz" style="display: none;">
						<div class="cnr">
							<img src="images/code.png">
						</div>
						<b class="ar_up ar_top"></b> <b class="ar_up_in ar_top_in"></b>
					</div></li>
				<li class="c_2"><a href="#" target="_blank" title="官方QQ"
					alt="官方QQ"><b class="ico_head_QQ"></b></a></li>
				<li class="c_4"><a href="#" target="_blank" title="新浪微博"
					alt="新浪微博"><b class="ico_head_sina"></b></a></li>
			</ul>
			<c:if test="${user.username == null }">
				<ul class="fn-right header-top-ul">
					<li><a href="<%=path%>/Borrow/selBorrowMoneySomeList.action"
						class="app">返回首页</a></li>
					<li>
						<div class="">
							<a href="<%=path%>/foregroundSystem/register.jsp"
								class="c-orange" title="免费注册">免费注册</a>
						</div>
					</li>
					<li>
						<div class="">
							<a href="<%=path%>/foregroundSystem/login.jsp" class="js-login"
								title="登录">登录</a>
						</div>
					</li>
				</ul>
			</c:if>
			<c:if test="${user.username != null }">
				<ul class="fn-right header-top-ul">
					<li><a href="<%=path%>/Borrow/selBorrowMoneySomeList.action"
						class="app">返回首页</a></li>
					<li>
						<div class="">
							<a href="<%=path%>/SelHuiKuan.action" class="c-orange"
								title="我的账户">${user.username }</a>
						</div>
					</li>
					<li>
						<div class="">
							<a href="<%=path%>/user/remove.action" class="js-login"
								title="退出">退出</a>
						</div>
					</li>
				</ul>
			</c:if>
		</div>
	</div>
	<div class="header min-width">
		<div class="container">
			<div class="fn-left logo">
				<a class="" href="index.jsp"> <img src="images/logo.png"
					title="">
				</a>
			</div>
			<ul class="top-nav fn-clear">
				<li class="on"><a
					href="<%=path%>/Borrow/selBorrowMoneySomeList.action">首页</a></li>
				<li><a
					href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
					class="">我要投资</a></li>
				<li><a href="<%=path%>/foregroundSystem/borrow.jsp" class="">我要借款</a></li>
				<li><a href="<%=path%>/foregroundSystem/help.jsp">安全保障</a></li>
				<li class="top-nav-safe"><a href="<%=path%>/SelHuiKuan.action">我的账户</a></li>
				<li><a href="<%=path%>/foregroundSystem/jianjie.jsp">关于我们</a></li>
			</ul>
		</div>
	</div>
	</header>
	<!--banner-->
	<div class="flexslider">
		<ul class="slides">
			<li
				style="background-image: url(images/banner.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="#" target="_blank"></a></li>
			<li
				style="background-image: url(images/banner1.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="#" target="_blank"></a></li>
			<li
				style="background-image: url(images/banner2.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="#" target="_blank"></a></li>
			<li
				style="background-image: url(images/banner3.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="# " target="_blank"></a></li>
			<li
				style="background-image: url(images/banner4.jpg); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1; background-position: 50% 0px; background-repeat: no-repeat no-repeat;"
				class=""><a href="#" target="_blank"></a></li>
		</ul>
	</div>
	<script src="script/jquery.flexslider-min.js"></script>
	<script>
		$(function() {
			$('.flexslider').flexslider({
				directionNav : true,
				pauseOnAction : false
			});
			//产品列表滚动
			var pLength = $('.pListContentBox > li').length;
			var cishu = pLength - 4;
			var n = 0;
			$('.pListContentBox').css({
				'width' : pLength * 245 + 'px'
			});
			if (pLength > 4) {
				$('.pListRight').addClass('curr');
			}
			$('.pListRight').on('click', function() {
				if (cishu > 0) {
					//alert('1');
					n++;
					cishu--;
					$('.pListContentBox').animate({
						'left' : '-' + n * 244 + 'px'
					}, 500);
					if (cishu == 0) {
						$('.pListRight').removeClass('curr');
					}
					if (n > 0) {
						$('.pListLeft').addClass('curr');
					}
				}
			});
			$('.pListLeft').on('click', function() {
				if (n > 0) {
					n--;
					cishu++;
					$('.pListContentBox').animate({
						'left' : '-' + n * 244 + 'px'
					}, 500);
					if (n == 0) {
						$('.pListLeft').removeClass('curr');
					}
					if (cishu > 0) {
						$('.pListRight').addClass('curr');
					}
				}
			});
		//alert(pLength);
		});
	</script>
	<!--注册登陆模块-->
	<!--<div class="login_float">
  <div class="index_login">
    <div class="login_name">团团赚年化收益率</div>
    <div class="login_num">10<font>%</font>~17<font>%</font></div>
    <div class="login_info"> <span class="login_info1"><font>3~4倍</font>定期存款收益</span> <span class="login_info2"><font>30倍</font>活期存款收益</span> </div>
    <div class="clear"></div>
    <div class="login_btn"><a href="register.jsp">立即注册</a></div>
    <p class="login_reg">已有账号，<a href="login.jsp">立即登录</a></p>
  </div>
</div>-->
	<script type="text/javascript">
		var gaintop;
		$(function() {
			gaintop = $(".login_float").css("top");
			$(".login_float").css("top", -695);
			$(".login_float").show();
			$(".login_float").animate({
				top : gaintop,
				opacity : 1
			}, 800);
			$(".login_float").animate({
				top : '-=12px',
				opacity : 1
			}, 200);
			$(".login_float").animate({
				top : gaintop,
				opacity : 1
			}, 200);
			$(".login_float").animate({
				top : '-=6px',
				opacity : 1
			}, 200);
			$(".login_float").animate({
				top : gaintop,
				opacity : 1
			}, 200);
			$(".login_float").animate({
				top : '-=2px',
				opacity : 1
			}, 100);
			$(".login_float").animate({
				top : gaintop,
				opacity : 1
			}, 100);
		});
	</script>
	<div class="new-announcement">
		<div class="new-announcement-title">最新公告</div>
		<div class="new-announcement-content">
			<div id="scrollDiv">
				<ul style="margin-top: 0px;">
					<li><a class="black-link" href="公司公告详细.jsp" target="_blank">
							2015年9月8日还款公告</a></li>
					<li><a class="black-link" href="公司公告详细.jsp" target="_blank">
							2015年纪念抗日战争胜利放假公告</a></li>
				</ul>
			</div>
		</div>
		<a class="more" href="#">更多</a>
	</div>
	<div class="ipubs">
		<span class="o1">累计投资金额:<strong>${sumTenderMoney }</strong>元
		</span> <span class="o2">已还本息:<strong>${sumDetailMoney }</strong>元
		</span><span class="o2">余额:<strong>${sumUserMoney }</strong>元
		</span><span class="o4">注册人数:<strong>${UserCount }</strong>人
		</span>
	</div>
	<div class="feature">
		<a class="fea1" href="#"> <i></i>
			<h3>高收益</h3> <span>年化收益率最高达“20%<br> 50元起投，助您轻松获收益
		</span>
		</a> <a class="fea2" href="#"> <i></i>
			<h3>安全理财</h3> <span>100%本息保障<br> 实物质押，多重风控审核
		</span>
		</a> <a class="fea3" href="#"> <i></i>
			<h3>随时赎回</h3> <span>两步赎回您的资金<br> 最快当日到账
		</span>
		</a> <a class="fea4" href="#"> <i></i>
			<h3>随时随地理财</h3> <span>下载手机客户端<br> 随时随地轻松理财
		</span>
		</a>
	</div>
	<!--中间内容-->
	<div class="main clearfix mrt30" data-target="sideMenu">
		<div class="wrap">
			<div class="page-left fn-left">
				<div class="mod-borrow">
					<div class="hd">
						<h2 class="pngbg">
							<i class="icon icon-ttyx"></i>推荐项目
						</h2>
						<div class="fn-right f14 c-888">
							常规发标时间每天<span class="c-555">10:00，13:00和20:00</span>，其余时间根据需要随机发
						</div>
					</div>
					<div class="bd">
						<div class="des">
							<span class="fn-left">期限0-1月，期限短，收益见效快</span><a
								href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
								class="fn-right">查看更多&gt;&gt;</a>
						</div>
						<div class="borrow-list">
							<ul>
								<c:forEach items="${list1 }" var="bor">
									<li>
										<div class="title">
											<a href="#"> <c:if test="${bor.borrow_type=='车辆抵押' }">
													<i class="icon icon-che" title="车易贷"></i>
												</c:if> <c:if test="${bor.borrow_type=='房产抵押' }">
													<i class="icon icon-fang" title="房易贷"></i>
												</c:if> <c:if test="${bor.borrow_type=='信用贷款' }">
													<img style="width: 20px;height: 25px;"
														src="<%=path%>/foregroundSystem/images/xin2017.jpg">
												</c:if>
											</a> <a
												href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}"
												class="f18" title="${bor.borrow_bt }" target="_blank">${bor.borrow_bt }</a>
										</div>
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tbody>
												<tr>
													<td width="260">借款金额<span class="f24 c-333">${bor.b_money }</span>元
													</td>
													<td width="165">年利率<span class="f24 c-333">
															${fn:substring(bor.rate*100, 0, 4)}% </span></td>
													<td width="180" align="center">期限<span
														class="f24 c-orange">${bor.borrowqx }</span>月
													</td>
													<td><div class="circle">
															<div class="left progress-bar">
																<div class="progress-bgPic progress-bfb10">
																	<div class="show-bar">
																		<fmt:formatNumber type="number"
																			value="${bor.tb_money/bor.b_money}" pattern="0.0%" />
																	</div>
																</div>
															</div>
														</div></td>
													<td align="right"><c:if test="${bor.statu==2 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">投标</a>
														</c:if> <c:if test="${bor.statu==3 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">满标</a>
														</c:if> <c:if test="${bor.statu==4 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">还款中</a>
														</c:if></td>
												</tr>
											</tbody>
										</table>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="mod-borrow mrt20">
					<div class="hd">
						<h2 class="pngbg">
							<i class="icon icon-yyyz"></i>政信贷
						</h2>
						<div class="fn-right f14 c-888">
							参与人次：<span class="c-555">61.37万次</span>&nbsp;&nbsp;&nbsp;平均满标时间：<span
								class="c-555">1小时24分11秒</span>
						</div>
					</div>
					<div class="bd">
						<div class="des">
							<span class="fn-left">期限1-12月，收益更高</span><a
								href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
								class="fn-right">查看更多&gt;&gt;</a>
						</div>
						<div class="borrow-list">
							<ul>
								<c:forEach items="${list2 }" var="bor">
									<li>
										<div class="title">
											<a href="#"> <c:if test="${bor.borrow_type=='车辆抵押' }">
													<i class="icon icon-che" title="车易贷"></i>
												</c:if> <c:if test="${bor.borrow_type=='房产抵押' }">
													<i class="icon icon-fang" title="房易贷"></i>
												</c:if> <c:if test="${bor.borrow_type=='信用贷款' }">
													<img style="width: 20px;height: 25px;"
														src="<%=path%>/foregroundSystem/images/xin2017.jpg">
												</c:if>
											</a> <a
												href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}"
												class="f18" title="${bor.borrow_bt}" target="_blank">${bor.borrow_bt }</a>
										</div>
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tbody>
												<tr>
													<td width="260">借款金额<span class="f24 c-333">${bor.b_money }</span>元
													</td>
													<td width="165">年利率<span class="f24 c-orange relative">${fn:substring(bor.rate*100, 0, 4)}%
															<!--公益标 20150724 lj--> <!--公益标 20150724 lj-->
													</span></td>
													<td width="180" align="center">期限<span
														class="f24 c-333">${bor.borrowqx }</span>月
													</td>
													<td><div class="circle">
															<div class="left progress-bar">
																<div class="progress-bgPic progress-bfb10">
																	<div class="show-bar">
																		<fmt:formatNumber type="number"
																			value="${bor.tb_money/bor.b_money}" pattern="0.0%" />
																	</div>
																</div>
															</div>
														</div></td>
													<td align="right"><c:if test="${bor.statu==2 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">投标</a>
														</c:if> <c:if test="${bor.statu==3 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">满标</a>
														</c:if> <c:if test="${bor.statu==4 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">还款中</a>
														</c:if></td>
												</tr>
											</tbody>
										</table>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="mod-borrow mrt20">
					<div class="hd">
						<h2 class="pngbg">
							<i class="icon icon-nnyy"></i>实时变现
						</h2>
						<div class="fn-right f14 c-888">
							参与人次：<span class="c-555">8.35万次</span>&nbsp;&nbsp;&nbsp;平均满标时间：<span
								class="c-555">1小时41分19秒</span>
						</div>
					</div>
					<div class="bd">
						<div class="des">
							<span class="fn-left">期限12-60月，打理更加容易</span><a
								href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
								class="fn-right">查看更多&gt;&gt;</a>
						</div>
						<div class="borrow-list">
							<ul>
								<c:forEach items="${list3 }" var="bor">
									<li>
										<div class="title">
											<a href="#"> <c:if test="${bor.borrow_type=='车辆抵押' }">
													<i class="icon icon-che" title="车易贷"></i>
												</c:if> <c:if test="${bor.borrow_type=='房产抵押' }">
													<i class="icon icon-fang" title="房易贷"></i>
												</c:if> <c:if test="${bor.borrow_type=='信用贷款' }">
													<img style="width: 20px;height: 25px;"
														src="<%=path%>/foregroundSystem/images/xin2017.jpg">
												</c:if>
											</a> <a
												href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}"
												class="f18" title="${bor.borrow_bt }" target="_blank">${bor.borrow_bt }</a>
										</div>
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tbody>
												<tr>
													<td width="260">借款金额<span class="f24 c-333">${bor.b_money }</span>元
													</td>
													<td width="165">年利率<span class="f24 c-orange relative">${fn:substring(bor.rate*100, 0, 4)}%
															<!--公益标 20150724 lj--> <!--公益标 20150724 lj-->
													</span></td>
													<td width="180" align="center">期限<span
														class="f24 c-333">${bor.borrowqx }</span>月
													</td>
													<td><div class="circle">
															<div class="left progress-bar">
																<div class="progress-bgPic"
																	style="background-position: -610px -40px;">
																	<div class="show-bar">
																		<fmt:formatNumber type="number"
																			value="${bor.tb_money/bor.b_money}" pattern="0.0%" />
																	</div>
																</div>
															</div>
														</div></td>
													<td align="right"><c:if test="${bor.statu==2 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">投标</a>
														</c:if> <c:if test="${bor.statu==3 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">满标</a>
														</c:if> <c:if test="${bor.statu==4 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">还款中</a>
														</c:if></td>
												</tr>
											</tbody>
										</table>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="mod-borrow mrt20">
					<div class="hd">
						<h2 class="pngbg">
							<i class="icon icon-nnyy"></i>Vip团
						</h2>
						<div class="fn-right f14 c-888">
							参与人次：<span class="c-555">8.35万次</span>&nbsp;&nbsp;&nbsp;平均满标时间：<span
								class="c-555">1小时41分19秒</span>
						</div>
					</div>
					<div class="bd">
						<div class="des">
							<span class="fn-left">快捷投资，打理更加容易</span><a
								href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
								class="fn-right">查看更多&gt;&gt;</a>
						</div>
						<div class="borrow-list">
							<ul>
								<c:forEach items="${vip }" var="vip" varStatus="index">
									<li>
										<div class="title">
											<a href="#"> <img style="width: 20px;height: 20px;"
												src="<%=path%>/foregroundSystem/images/s27188837.jpg">
											</a><a
												href="<%=path %>/Borrow/getBorrowMoneyVIP.action?id=${vip.b_id}"
												class="f18" title="${vip.borrow_bt }" target="_blank"><font
												color="green" size="3"> ${vip.borrow_bt }</font></a>
										</div>
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tbody>
												<tr>
													<td width="260">满标金额<span class="f24 c-333">${vip.b_money }</span>元
													</td>
													<td width="165">平均年利率<span
														class="f24 c-orange relative">${fn:substring(vip.rate*100, 0, 4)}%
															<!--公益标 20150724 lj--> <!--公益标 20150724 lj-->
													</span></td>
													<td width="180" align="center">有效期限<span
														class="f24 c-333">${vip.syday }</span>天
													</td>
													<td><div class="circle">
															<div class="left progress-bar">
																<div class="progress-bgPic"
																	style="background-position: -610px -40px;">
																	<div class="show-bar">
																		<fmt:formatNumber type="number"
																			value="${vip.tb_money/vip.b_money}" pattern="0.0%" />
																	</div>
																</div>
															</div>
														</div></td>
													<td align="right"><c:choose>
															<c:when test="${vip.statu==11 }">
																<a class="ui-btn btn-gray" href="javascript:void(0);"
																	onclick="viptz('${vip.b_id}');">已结束</a>
															</c:when>
															<c:when test="${vip.statu==10 }">
																<a class="ui-btn btn-gray" href="javascript:void(0);"
																	onclick="viptz('${vip.b_id}');">投资</a>
															</c:when>
														</c:choose></td>
												</tr>
											</tbody>
										</table>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<!-- 债权转让 -->
				<div class="mod-borrow mrt20">
					<div class="hd">
						<h2 class="pngbg">
							<i class="icon icon-ssbx"></i>债权转让
						</h2>
						<div class="fn-right f14 c-888">
							参与人次：<span class="c-555">8.06万次</span> &nbsp;&nbsp;&nbsp;平均转让用时：<span
								class="c-555">03小时06分22秒</span>
						</div>
					</div>
					<div class="bd">
						<div class="des">
							<span class="fl">其他投资人折价转让，转让项目会随时更新，惊喜不断</span><a
								href="list.jsp" class="fn-right">查看更多&gt;&gt;</a>
						</div>
						<div class="borrow-list">
							<c:forEach items="${list5 }" var="bor">
								<ul>
									<li>
										<div class="title">
											<a href="#"> <c:if test="${bor.borrow_type=='车辆抵押' }">
													<i class="icon icon-che" title="车易贷"></i>
												</c:if> <c:if test="${bor.borrow_type=='房产抵押' }">
													<i class="icon icon-fang" title="房易贷"></i>
												</c:if> <c:if test="${bor.borrow_type=='信用贷款' }">
													<img style="width: 20px;height: 25px;"
														src="<%=path%>/foregroundSystem/images/xin2017.jpg">
												</c:if>
											</a> <a
												href="<%=path %>/Borrow/getBorrowMoneyZaiQuan.action?id=${bor.b_id}"
												class="f18" title="${bor.borrow_bt }" target="_blank">${bor.borrow_bt }</a>
										</div>
										<table width="100%" border="0" cellpadding="0" cellspacing="0">
											<tbody>
												<tr>
													<td width="260">借款金额<span class="f24 c-333">${bor.b_money }</span>元
													</td>
													<td width="165">年利率<span class="f24 c-orange relative">${fn:substring(bor.rate*100, 0, 4)}%
															<!--公益标 20150724 lj--> <!--公益标 20150724 lj-->
													</span></td>
													<td width="180" align="center">有效期限<span
														class="f24 c-333">${bor.syday }</span>天
													</td>
													<td><div class="circle">
															<div class="left progress-bar">
																<div class="progress-bgPic"
																	style="background-position: -610px -40px;">
																	<div class="show-bar">
																		<fmt:formatNumber type="number"
																			value="${bor.tb_money/bor.b_money}" pattern="0.0%"
																			maxFractionDigits="2" />
																	</div>
																</div>
															</div>
														</div></td>
													<td align="right"><c:if test="${bor.statu==12 }">
															<a class="ui-btn btn-gray"
																href="<%=path %>/Borrow/getBorrowMoneyZaiQuan.action?id=${bor.b_id}">购买</a>
														</c:if></td>
												</tr>
											</tbody>
										</table>
									</li>
								</ul>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="page-right fn-right" style="top: 0px;">
				<div class="mod-risk-tip">
					<i class="icon icon-tip"></i><a href="/bxbz/index.jsp"
						class="c-orange">收益与风险并存，请理性选择平台</a>
				</div>
				<div class="mod mod-notice mrt20">
					<div class="hd">
						<h3>网站公告</h3>
						<a
							href="${pageContext.request.contextPath}/notice/selnoticelist.action?cpage=1"
							class="fn-right">更多&gt;</a>
					</div>
					<div class="bd">
						<div class="article-list clearfix">
							<ul id="gonggaoul">

							</ul>
						</div>
					</div>
				</div>
				<div class="mod mod-rank clearfix ui-tab mrt20">
					<div class="hd">
						<h3>排行榜</h3>
						<div class="ui-tab-nav">
							<i class="icon icon-cur"></i>
							<ul>
								<li class="active"><a href="#">收益</a></li>
								<li><a href="#">投资</a></li>
							</ul>
							<a href="#" class="fn-right">更多&gt;</a>
						</div>
					</div>
					<div class="bd">
						<div class="ui-tab-cont">
							<div class="ui-tab-item active">
								<ul class="rank-list" id="sylist">

								</ul>
							</div>
							<div class="ui-tab-item">
								<ul class="rank-list" id="tzlist">

								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="mod mod-report ui-tab clearfix mrt20">
					<div class="hd">
						<div class="ui-tab-nav">
							<i class="icon icon-cur"></i>
							<ul>
								<li class="active"><a href="javascript:;">媒体报道</a></li>
								<li class=""><a href="javascript:;">理财知识</a></li>
							</ul>
						</div>
					</div>
					<div class="bd">
						<div class="ui-tab-cont">
							<div class="ui-tab-item active">
								<div class="headlines">
									<img src="images/news.jpg"> <a title="平台遭遇P2P滑稽抄袭"
										target="_blank" href="#">平台遭遇P2P滑稽抄袭</a><br> <span
										class="des">抄袭者居然把被抄袭者的名字一起抄下来，这样的乌龙抄袭你见过没...</span>
								</div>
								<div class="article-list">
									<ul>
										<li>[凤凰网]<a href="#" title="平台携手哈工大关爱毕节留守儿童"
											target="_blank">平台携手哈工大关爱毕节留守儿童</a></li>
										<li>[21CN财经]<a href="#" title="接受网贷之家专访" target="_blank">接受网贷之家专访</a></li>
										<li>[和讯网]<a href="#" title="受邀参加中国财经峰会 斩获行业最具品牌影响力等两项大奖"
											target="_blank">受邀参加中国财经峰会 斩获行业最具品牌影响力等两项大奖</a></li>
									</ul>
								</div>
							</div>
							<div class="ui-tab-item">
								<div class="article-list">
									<ul>
										<li>[<a href="#">P2P网贷</a>]<a href="#"
											title="随着互联网金融的快速发展，越来越多的人开始加入到p2p网贷投资行列，作为一种相对来说还比较新兴的理财产品"
											target="_blank"> 合肥p2p网贷哪家好，投资新人该如何选择p2p网贷平台</a></li>
										<li>[<a href="#">外汇</a>]<a href="#"
											title="投资者应知道，外汇交易市场是一个保证金交易市场，投资者可以利用外汇保证金交易进行更有收益空间的交易"
											target="_blank"> 什么是外汇保证金交易有哪些方式</a></li>
										<li>[<a href="#">外汇</a>]<a href="#"
											title="很多的投资者都听说过外汇保证金交易，他们都知道该交易方式可以让投资者有机会进行更有收益空间的交易"
											target="_blank"> 外汇保证金交易开户有什么样的具体优势呢？</a></li>
										<li>[<a href="#">保险理财</a>]<a href="#"
											title="保险理财因为其特殊性而对人员专业知识、道德标准以及人生阅历提出了较高要求。但是我国的保险业人才还存在很多问题"
											target="_blank"> 保险公司存在的人才需求问题</a></li>
										<li>[<a href="#">保险理财</a>]<a href="#"
											title="保险理财的专业人士缺乏已经成为我国保险公司个人理财业务发展的一大瓶颈，保险公司的员工要能够成为一个好的客户经理"
											target="_blank"> 保险理财产品销售人员需要具备的基本素质</a></li>
										<li>[<a href="#">外汇</a>]<a href="#"
											title="外货期货也叫货币期货，所谓期货自然与现货有着明显的区别，外汇期货除了价格表现形式上与现货有所差异之外，外汇期货交易是用一种货币按照汇率兑换成另一种货币的期货合约"
											target="_blank"> 什么是外汇期货及其套利形式介绍</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="mrt20 mod">
					<a href="#"><img src="images/pic_home_js.jpg" width="300"
						height="80" alt="收益计算器" class="pic"></a>
				</div>
			</div>
		</div>
	</div>
	<script src="script/index.js"></script>
	<div class="partners wrap clearfix mrb30">
		<div class="partners-inner ui-tab">
			<div class="hd">
				<div class="ui-tab-nav">
					<i class="icon icon-cur" style="left: 151px;"></i>
					<ul>
						<li class=""><a href="#">合作机构</a></li>
						<li class="active"><a href="#">友情链接</a></li>
					</ul>
				</div>
			</div>
			<div class="bd">
				<div class="ui-tab-cont">
					<div class="ui-tab-item active">
						<div class="img-scroll">
							<div class="container">
								<ul>
									<li><img src="images/logo_sbcvc.png" width="152"
										height="52" alt="软银"></li>
									<li><img src="images/logo_abc.png" width="152" height="52"
										alt="农业银行"></li>
									<li><img src="images/logo_wdzj.png" width="152"
										height="52" alt="网贷之家"></li>
									<li><img src="images/logo_baidu.png" width="152"
										height="52" alt="百度"></li>
									<li><img src="images/logo_aqb.png" width="152" height="52"
										alt="安全宝"></li>
									<li><img src="images/logo_gds.png" width="152" height="52"
										alt="万国数据"></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="ui-tab-item">
						<div class="links">
							<a target="_blank" href="http://www.jspsucai.com">网贷互联</a> <a
								target="_blank" href="http://www.jspsucai.com">北京证券网</a> <a
								target="_blank" href="http://www.jspsucai.com">易贷微理财</a> <a
								target="_blank" href="http://www.jspsucai.com">P2P</a> <a
								target="_blank" href="http://www.jspsucai.com">网贷中国</a> <a
								target="_blank" href="http://www.jspsucai.com">网贷帮手</a> <a
								target="_blank" href="https://www.okcoin.cn">比特币网</a> <a
								target="_blank" href="http://www.jspsucai.com">网贷110</a> <a
								target="_blank" href="http://www.jspsucai.com">招财猫理财</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--网站底部-->
	<div id="footer" class="ft">
		<div class="ft-inner clearfix">
			<div class="ft-helper clearfix">
				<dl>
					<dt>关于我们</dt>
					<dd>
						<a href="jianjie.jsp">公司简介</a><a href="tuandui.jsp">管理团队</a><a
							href="wangzhangonggao.jsp">网站公告</a>
					</dd>
				</dl>
				<dl>
					<dt>相关业务</dt>
					<dd>
						<a href="list.jsp">我要投资</a><a href="borrow.jsp">我要借款</a>
					</dd>
				</dl>
				<dl>
					<dt>帮助中心</dt>
					<dd>
						<a href="help.jsp">新手入门</a><a href="pesonal_index.jsp">我的账户</a><a
							href="list.jsp">债权转让</a>
					</dd>
				</dl>
				<dl>
					<dt>联系我们</dt>
					<dd>
						<a href="lianxi.jsp">联系我们</a>
					</dd>
				</dl>
			</div>
			<div class="ft-service">
				<dl>
					<dd>
						<p>
							<strong>400-660-1268</strong><br> 工作日 9:00-22:00<br>
							官方交流群:<em>12345678</em><br> 工作日 9:00-22:00 / 周六 9:00-18:00<br>
						</p>
						<div class="ft-serv-handle clearfix">
							<a class="icon-hdSprite icon-ft-sina a-move a-moveHover"
								title="团团赚新浪微博" target="_blank" href="#"></a><a
								class="icon-hdSprite icon-ft-qqweibo a-move a-moveHover"
								title="团团赚腾讯微博" target="_blank" href="#"></a><a
								class="icon-ft-qun a-move a-moveHover" title="团团赚QQ群"
								target="_blank" href="#"></a><a
								class="icon-hdSprite icon-ft-email a-move a-moveHover mrn"
								title="阳光易贷email" target="_blank" href="mailto:xz@yirenbao.com"></a>
						</div>
					</dd>
				</dl>
			</div>
			<div class="ft-wap clearfix">
				<dl>
					<dt>官方二维码</dt>
					<dd>
						<span class="icon-ft-erweima"><img
							src="<%=path%>/foregroundSystem/images/code.png"
							style="display: inline;"></span>
					</dd>
				</dl>
			</div>
		</div>
		<div class="ft-record">
			<div class="ft-approve clearfix">
				<a class="icon-approve approve-0 fadeIn-2s" target="_blank" href="#"></a><a
					class="icon-approve approve-1 fadeIn-2s" target="_blank" href="#"></a><a
					class="icon-approve approve-2 fadeIn-2s" target="_blank" href="#"></a><a
					class="icon-approve approve-3 fadeIn-2s" target="_blank" href="#"></a>
			</div>
			<div class="ft-identity">
				©2015 团团赚 All rights reserved&nbsp;&nbsp;&nbsp;<span
					class="color-e6">|</span>&nbsp;&nbsp;&nbsp;安徽省团团赚投资管理有限公司&nbsp;&nbsp;&nbsp;<span
					class="color-e6">|</span>&nbsp;&nbsp;&nbsp;<a target="_blank"
					href="http://www.jspsucai.com">皖ICP备12345678号-1</a>
			</div>
		</div>
	</div>

	<!-- 网站公告显示。。 -->
	<script>
	
		$.post("${pageContext.request.contextPath}/notice/selnoitcelistindex.action", {}, function(result) {
			var nlist = result.list;
			$.each(nlist, function(i, notic) { //不知道为什么一定要有i
				//日期处理
				var dates = new Date(notic.n_date);
				var months = dates.getMonth() + 1;
				var rq = (dates.getYear() + 1900) + "-" + months + "-" + dates.getDate();
	
				var li = $("<li>", {
				});
				var a = $("<a>", {
					"href" : "${pageContext.request.contextPath}/notice/getnoticeone.action?id=" + notic.n_id,
					"title" : notic.n_title,
					"text" : notic.n_title
				});
				var span = $("<span>", {
					"class" : "date",
					"text" : rq,
					"title" : rq + " " + dates.getHours() + ":" + dates.getMinutes()
				});
				li.append(a);
				li.append(span);
				$("#gonggaoul").append(li);
			});
	
		}, "json");
	
		$.post("<%=path%>/SumlistMoney.action", {}, function(data) {
	
			var sumlist = data.sumlistmoney;
	
			$.each(sumlist, function(index, bro1) {
				var n;
				if ((index + 1) == 1) {
					n = 1;
				} else if ((index + 1) == 2) {
					n = 2;
				} else if ((index + 1) == 3) {
					n = 3;
				} else if ((index + 1) == 4) {
					n = 4;
				} else if ((index + 1) == 5) {
					n = 5;
				}
				var li = $("<li>", {
				});
				var span = $("<span>", {
					"class" : "fl"
				});
				var em = $("<em>", {
					"class" : "n" + n,
					"text" : "0" + (index + 1) + "  "
				});
				var span2 = $("<span>", {
					"class" : "fr",
					"text" : bro1.mon
				});
				span.append(em);
				span.append(bro1.zsname.substring(0, 1) + "********  ￥");
				li.append(span);
				li.append(span2);
				$("#tzlist").append(li);
			});
		}, "json");
	
		$.post("<%=path%>/SumInterest.action", {}, function(data1) {
			var sysumlist = data1.suminterest;
	
			$.each(sysumlist, function(index1, bro2) {
				var s;
				if ((index1 + 1) == 1) {
					s = 1;
				} else if ((index1 + 1) == 2) {
					s = 2;
				} else if ((index1 + 1) == 3) {
					s = 3;
				} else if ((index1 + 1) == 4) {
					s = 4;
				} else if ((index1 + 1) == 5) {
					s = 5;
				}
	
				var sli = $("<li>", {
				});
				var sspan = $("<span>", {
					"class" : "f1"
				});
				var sem = $("<em>", {
					"class" : "n" + s,
					"text" : "0" + (index1 + 1) + "  "
				});
				var sspan2 = $("<span>", {
					"class" : "fr",
					"text" : bro2.mon
				});
				sspan.append(sem);
				sspan.append(bro2.zsname.substring(0, 1) + "********  ￥");
				sli.append(sspan);
				sli.append(sspan2);
				$("#sylist").append(sli);
			});
		}, "json");
	
		function viptz(val) {
			if ('${user.vip}' >= 1) {
				location.href = "<%=path%>/Borrow/getBorrowMoneyVIP.action?id=" + val;
			} else {
				alert("您还不是VIP用户,请在本平台多多投资哟!");
			}
		}
	</script>
</body>
</html>

