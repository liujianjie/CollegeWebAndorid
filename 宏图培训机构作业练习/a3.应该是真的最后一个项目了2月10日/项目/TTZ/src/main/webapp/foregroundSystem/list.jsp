<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link href="<%=path%>/foregroundSystem/css/index.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/foregroundSystem/css/detail.css" rel="stylesheet"
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
</head>
<body>
	<jsp:include page="/foregroundSystem/header.jsp"></jsp:include>
	<!--列表-->
	<div class="page-filter wrap">
		<div class="breadcrumbs">
			<a href="index.jsp">首页</a>&gt;<span class="cur">散标投资列表</span>
		</div>
		<div class="invest-filter" data-target="sideMenu">
			<div class="filter-inner clearfix">
				<div class="filter-item">
					<div class="hd">
						<h3>筛选投资项目</h3>
						<label> <input id="filterMulti" name="multiple_choice"
							type="checkbox"> 多选
						</label>
					</div>
					<div class="bd">
						<dl>
							<dt>项目类型</dt>
							<dd>
								<ul>
									<li class="n1"><a
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}"
										id="post_type_"
										class="${map.borrow_type==null?'active':''}${map.borrow_type==''?'active':''}">不限</a></li>
									<li class="n2"><a
										class="${map.borrow_type=='1'?'active':'' }"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=1&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}"
										id="post_type_car">车易贷</a></li>
									<li class="n3"><a
										class="${map.borrow_type=='2'?'active':'' }"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=2&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}"
										id="post_type_house">房易贷</a></li>
									<li class="n4"><a
										class="${map.borrow_type=='3'?'active':''}"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=3&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}"
										id="post_type_bridge">信用贷款</a></li>
									<li class="n5"><a
										class="${map.borrow_type=='4'?'active':''}"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=4&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}"
										id="post_type_worth">债权贷</a></li>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>年利率</dt>
							<dd>
								<ul>
									<li class="n1"><a
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=${map.borrow_type}&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=&rateg="
										id="borrow_interestrate_"
										class="${map.ratel==''&&map.rateg==''?'active':''}">不限</a></li>
									<li class="n2"><a
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=${map.borrow_type}&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=&rateg=0.12"
										id="borrow_interestrate_1"
										class="${map.ratel==''&&map.rateg=='0.12'?'active':''}">12%以下</a></li>
									<li class="n3"><a
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=${map.borrow_type}&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=0.12&rateg=0.14"
										id="borrow_interestrate_2"
										class="${map.ratel=='0.12'&&map.rateg=='0.14'?'active':''}">12%-14%</a>
									</li>
									<li class="n4"><a
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=${map.borrow_type}&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=0.14&rateg=0.16"
										id="borrow_interestrate_3"
										class="${map.ratel=='0.14'&&map.rateg=='0.16'?'active':''}">14%-16%</a>
									</li>
									<li class="n5"><a
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrow_type=${map.borrow_type}&borrowqx=${map.borrowqx}&repayment=${map.repayment}&ratel=0.16&rateg="
										id="borrow_interestrate_4"
										class="${map.ratel=='0.16'&&map.rateg==''?'active':''}">16%及以上</a></li>
								</ul>
							</dd>
						</dl>
						<dl>
							<dt>期限</dt>
							<dd>
								<ul>
									<li class="n1"><a
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrowqx=&borrow_type=${map.borrow_type}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}"
										id="spread_month_"
										class="${map.borrowqx==null?'active':''}${map.borrowqx==''?'active':''}">不限</a></li>
									<li class="n3"><a id="spread_month_2"
										class="${map.borrowqx==1?'active':''}"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrowqx=1&borrow_type=${map.borrow_type}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}">
											1~6月</a></li>
									<li class="n4"><a id="spread_month_3"
										class="${map.borrowqx==6?'active':''}"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrowqx=6&borrow_type=${map.borrow_type}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}">
											6~12月</a></li>
									<li class="n5"><a id="spread_month_4"
										class="${map.borrowqx==12?'active':''}"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&borrowqx=12&borrow_type=${map.borrow_type}&repayment=${map.repayment}&ratel=${map.ratel}&rateg=${map.rateg}">
											12月及以上</a></li>
								</ul>
							</dd>
						</dl>
						<dl class="repayment">
							<dt>还款方式</dt>
							<dd>
								<ul>
									<!-- 1是等额本息 2是等额本金 -->
									<li class="n1"><a
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&repayment=&borrowqx=${map.borrowqx }&borrow_type=${map.borrow_type}&ratel=${map.ratel}&rateg=${map.rateg}"
										id="repay_style_"
										class="${map.repayment==null?'active':''}${map.repayment==''?'active':''}">
											不限</a></li>
									<li class="n2"><a id="repay_style_end"
										class="${map.repayment=='1'?'active':''}"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&repayment=1&borrowqx=${map.borrowqx }&borrow_type=${map.borrow_type}&ratel=${map.ratel}&rateg=${map.rateg}">
											等额本息</a></li>
									<li class="n2"><a id="repay_style_endmonth"
										class="${map.repayment=='2'?'active':''}"
										href="<%=path %>/Borrow/selMoreBorrowMoneySomeListWhere.action?cpage=1&repayment=2&borrowqx=${map.borrowqx }&borrow_type=${map.borrow_type}&ratel=${map.ratel}&rateg=${map.rateg}">
											等额本金</a></li>
								</ul>
							</dd>
						</dl>
					</div>
				</div>
				<div class="common-problem">
					<h3>常见问题</h3>
					<ul>
						<li><a href="#">什么是债权贷？</a></li>
						<li><a href="#">关于"债权贷"产品的说明</a></li>
						<li><a href="#">易贷网P2P理财收费标准</a></li>
						<li><a href="#">债权贷和房易贷、车易贷有什么区别？</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="invest-list mrt30 clearfix">
			<div class="hd">
				<h3>投资列表</h3>
				<div class="count">
					<ul>
						<li class="line">散标投资交易金额&nbsp;&nbsp;<span class="f20 bold">73.54亿元</span></li>
						<li>累计赚取收益&nbsp;&nbsp;<span class="f20 bold">2.52亿元</span></li>
					</ul>
				</div>
			</div>
			<div class="bd">
				<div class="invest-table clearfix">
					<div class="title clearfix">
						<ul>
							<li class="col-330">借款标题</li>
							<li class="col-180"><a
								href="javascript:url('order','account_up');" class="">借款金额</a></li>
							<li class="col-110"><a
								href="javascript:url('order','apr_up');" class="">年利率</a></li>
							<li class="col-150"><a
								href="javascript:url('order','period_up');" class="">借款期限</a></li>
							<li class="col-150">还款方式</li>
							<li class="col-120"><a
								href="javascript:url('order','scale_up');" class="">借款进度</a></li>
							<li class="col-120-t">操作</li>
						</ul>
					</div>
					<!------------投资列表-------------->
					<div class="item">
						<ul>
							<c:forEach items="${map.bomlist }" var="bor">
								<li class="col-330 col-t"><a href="infor.jsp"
									target="_blank"><c:if test="${bor.borrow_type=='车辆抵押' }">
											<i class="icon icon-che" title="车易贷"></i>
										</c:if> <c:if test="${bor.borrow_type=='房产抵押' }">
											<i class="icon icon-fang" title="房易贷"></i>
										</c:if> <c:if test="${bor.borrow_type=='信用贷款' }">
											<img style="width: 20px;height: 25px;"
												src="<%=path%>/foregroundSystem/images/xin2017.jpg">
										</c:if></a><a class="f18"
									href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}"
									title="${bor.borrow_bt }" target="_blank"> ${bor.borrow_bt }
								</a></li>
								<li class="col-180"><span class="f20 c-333">${bor.b_money }</span>元</li>
								<li class="col-110 relative"><span class="f20 c-orange">${fn:substring(bor.rate*100,0,4)}%
								</span></li>
								<li class="col-150"><span class="f20 c-333">${bor.borrowqx }</span>个月</li>
								<li class="col-150">${bor.repayment }</li>
								<li class="col-120">
									<div class="circle">
										<div class="left progress-bar">
											<div class="progress-bgPic progress-bfb10">
												<div class="show-bar">
													<fmt:formatNumber type="number"
														value="${bor.tb_money/bor.b_money}" pattern="0.0%" />
												</div>
											</div>
										</div>
									</div>
								</li>
								<li class="col-120-2"><c:if test="${bor.statu==2 }">
										<a class="ui-btn btn-gray"
											href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">投标
										</a>
									</c:if> <c:if test="${bor.statu==3 }">
										<a class="ui-btn btn-gray"
											href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">满标</a>
									</c:if> <c:if test="${bor.statu==4 }">
										<a class="ui-btn btn-gray"
											href="<%=path %>/Borrow/getBorrowMoney.action?id=${bor.b_id}">还款中</a>
									</c:if></li>
							</c:forEach>
						</ul>
					</div>
					<!------------投资列表-------------->
				</div>
				<!-- 没有条件的分页 -->
				<c:if test="${map.where==0 }">
					<div class="pagination clearfix mrt30">
						<span class="page"> <a
							href="javascript:location.href='${pageContext.request.contextPath}/Borrow/selMoreBorrowMoneySomeList.action?cpage=1'">首页</a>
							<a id="btn1" onclick="bomlist(this);">上一页</a>&nbsp; <c:if
								test="${map.currPage-3>0}">
								<a id="btn2" onclick="bomlist(this);">${map.currPage-3}</a>
							</c:if> <c:if test="${map.currPage-2>0}">
								<a id="btn3" onclick="bomlist(this);">${map.currPage-2}</a>
							</c:if> <c:if test="${map.currPage-1>0}">
								<a id="btn4" onclick="bomlist(this);">${map.currPage-1}</a>
							</c:if> <a id="btn5" onclick="bomlist(this);">${map.currPage}</a> <c:if
								test="${map.currPage+1<= map.totalPage}">
								<a id="btn6" onclick="bomlist(this);">${map.currPage+1}</a>
							</c:if> <c:if test="${map.currPage+2<= map.totalPage}">
								<a id="btn7" onclick="bomlist(this);">${map.currPage+2}</a>
							</c:if> <c:if test="${map.currPage+3<= map.totalPage}">
								<a id="btn8" onclick="bomlist(this);">${map.currPage+3}</a>
							</c:if> <a id="btn9" onclick="bomlist(this);">下一页</a> <a
							href="javascript:location.href='${pageContext.request.contextPath}/Borrow/selMoreBorrowMoneySomeList.action?cpage=1'">尾页</a>&nbsp;
							<em>共${map.totalCount }条数据,当前${map.currPage }/${map.totalPage }页&nbsp;</em>
							<input type="text" id="ids" value="${map.currPage }"
							style="width: 50px;height: 20px" /> <input type="button"
							value="跳转" onclick="tobomlist();"
							style="width: 50px;height: 25px" />
						</span>
					</div>
				</c:if>
				<!-- 有条件的查询 -->
				<c:if test="${map.where==1 }">
					<div class="pagination clearfix mrt30">
						<span class="page"> <a id="btn1"
							onclick="bomwherelist(this);">上一页</a>&nbsp; <c:if
								test="${map.currPage-3>0}">
								<a id="btn2" onclick="bomwherelist(this);">${map.currPage-3}</a>
							</c:if> <c:if test="${map.currPage-2>0}">
								<a id="btn3" onclick="bomwherelist(this);">${map.currPage-2}</a>
							</c:if> <c:if test="${map.currPage-1>0}">
								<a id="btn4" onclick="bomwherelist(this);">${map.currPage-1}</a>
							</c:if> <a id="btn5" onclick="bomwherelist(this);">${map.currPage}</a> <c:if
								test="${map.currPage+1<= map.totalPage}">
								<a id="btn6" onclick="bomwherelist(this);">${map.currPage+1}</a>
							</c:if> <c:if test="${map.currPage+2<= map.totalPage}">
								<a id="btn7" onclick="bomwherelist(this);">${map.currPage+2}</a>
							</c:if> <c:if test="${map.currPage+3<= map.totalPage}">
								<a id="btn8" onclick="bomwherelist(this);">${map.currPage+3}</a>
							</c:if> <a id="btn9" onclick="bomwherelist(this);">下一页</a> <em>共${map.totalCount }条数据,当前${map.currPage }/${map.totalPage }页&nbsp;</em>
							<input type="text" id="ids2" value="${map.currPage }"
							style="width: 50px;height: 20px" /> <input type="button"
							value="跳转" onclick="tobomwherelist();"
							style="width: 50px;height: 25px" />
						</span>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<!-- 分页 -->
	<script>
		function tobomlist() {
			var cur = $("#ids").val();
			if (!isNaN(cur)) {
				location.href = "selMoreBorrowMoneySomeList.action?cpage=" + cur;
			} else {
				alert("请输入正确的页码！");
			}
	
		}
		function tobomwherelist() {
			var cur = $("#ids2").val();
			//项目类型
			var borrow_type = '${map.borrow_type}';
			//期限
			var borrowqx = '${map.borrowqx}';
			//方式
			var repayment = '${map.repayment}';
			if (!isNaN(cur)) {
				location.href = "selMoreBorrowMoneySomeListWhere.action?cpage=" + cur + "&repayment=" + repayment + "&borrowqx=" + borrowqx + "&borrow_type=" + borrow_type + "";
			}
		}
		function bomlist(btn) {
			var id = btn.id;
			var currPage = parseInt('${map.currPage}'); //需要强转 不然为String 1+1=11
			if (id == "btn1" || id == "btn4") {
				location.href = "selMoreBorrowMoneySomeList.action?cpage=" + (currPage - 1);
			} else if (id == "btn2") {
				location.href = "selMoreBorrowMoneySomeList.action?cpage=" + (currPage - 3);
			} else if (id == "btn3") {
				location.href = "selMoreBorrowMoneySomeList.action?cpage=" + (currPage - 2);
			} else if (id == "btn5") {
				location.href = "selMoreBorrowMoneySomeList.action?cpage=" + (currPage);
			} else if (id == "btn7") {
				location.href = "selMoreBorrowMoneySomeList.action?cpage=" + (currPage + 2);
			} else if (id == "btn8") {
				location.href = "selMoreBorrowMoneySomeList.action?cpage=" + (currPage + 3);
			} else if (id == "btn9" || id == "btn6") {
				location.href = "selMoreBorrowMoneySomeList.action?cpage=" + (currPage + 1);
			}
		}
		//有条件的分页
		function bomwherelist(btn) {
			var id = btn.id;
			var currPage = parseInt('${map.currPage}'); //需要强转 不然为String 1+1=11
			//项目类型
			var borrow_type = '${map.borrow_type}';
			//期限
			var borrowqx = '${map.borrowqx}';
			//方式
			var repayment = '${map.repayment}';
			//利率
			var ratel = '${map.ratel}';
			var rateg = '${map.rateg}';
			if (id == "btn1" || id == "btn4") {
				location.href = "selMoreBorrowMoneySomeListWhere.action?cpage=" + (currPage - 1) + "&repayment=" + repayment + "&borrowqx=" + borrowqx + "&borrow_type=" + borrow_type + "&ratel=" + ratel + "&rateg=" + rateg + "";
			} else if (id == "btn2") {
				location.href = "selMoreBorrowMoneySomeListWhere.action?cpage=" + (currPage - 3) + "&repayment=" + repayment + "&borrowqx=" + borrowqx + "&borrow_type=" + borrow_type + "&ratel=" + ratel + "&rateg=" + rateg + "";
			} else if (id == "btn3") {
				location.href = "selMoreBorrowMoneySomeListWhere.action?cpage=" + (currPage - 2) + "&repayment=" + repayment + "&borrowqx=" + borrowqx + "&borrow_type=" + borrow_type + "&ratel=" + ratel + "&rateg=" + rateg + "";
			} else if (id == "btn5") {
				location.href = "selMoreBorrowMoneySomeListWhere.action?cpage=" + (currPage) + "&repayment=" + repayment + "&borrowqx=" + borrowqx + "&borrow_type=" + borrow_type + "&ratel=" + ratel + "&rateg=" + rateg + "";
			} else if (id == "btn7") {
				location.href = "selMoreBorrowMoneySomeListWhere.action?cpage=" + (currPage + 2) + "&repayment=" + repayment + "&borrowqx=" + borrowqx + "&borrow_type=" + borrow_type + "&ratel=" + ratel + "&rateg=" + rateg + "";
			} else if (id == "btn8") {
				location.href = "selMoreBorrowMoneySomeListWhere.action?cpage=" + (currPage + 3) + "&repayment=" + repayment + "&borrowqx=" + borrowqx + "&borrow_type=" + borrow_type + "&ratel=" + ratel + "&rateg=" + rateg + "";
			} else if (id == "btn9" || id == "btn6") {
				location.href = "selMoreBorrowMoneySomeListWhere.action?cpage=" + (currPage + 1) + "&repayment=" + repayment + "&borrowqx=" + borrowqx + "&borrow_type=" + borrow_type + "&ratel=" + ratel + "&rateg=" + rateg + "";
			}
		}
	</script>

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
</body>
</html>

