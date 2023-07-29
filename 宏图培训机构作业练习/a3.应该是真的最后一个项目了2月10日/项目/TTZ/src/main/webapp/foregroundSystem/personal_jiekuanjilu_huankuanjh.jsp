<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>p2p网贷平台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/foregroundSystem/css/user.css" />
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<script src="<%=path%>/foregroundSystem/script/user.js"
	type="text/javascript"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
<%
	Date nowDate = new Date();
	nowDate.setDate(30);
	request.setAttribute("date", nowDate);
%>
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
			<c:if test="${user.username == null}">
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
				<a class="" href="index.jsp"> <img
					src="<%=path%>/foregroundSystem/images/logo.png" title="">
				</a>
			</div>
			<ul class="top-nav fn-clear">
				<li><a href="<%=path%>/Borrow/selBorrowMoneySomeList.action">首页</a></li>
				<li><a
					href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
					class="">我要投资</a></li>
				<li class="on"><a href="<%=path%>/foregroundSystem/borrow.jsp"
					class="">我要借款</a></li>
				<li><a href="<%=path%>/foregroundSystem/help.jsp">安全保障</a></li>
				<li class="top-nav-safe"><a href="<%=path%>/SelHuiKuan.action">我的账户</a></li>
				<li><a href="<%=path%>/foregroundSystem/jianjie.jsp">关于我们</a></li>
			</ul>
		</div>
	</div>
	</header>
	<!--个人中心-->
	<div class="wrapper wbgcolor">
		<div class="w1200 personal">
			<div class="credit-ad">
				<img src="<%=path%>/foregroundSystem/images/clist1.jpg" width="1200"
					height="96">
			</div>
			<div id="personal-left" class="personal-left">
				<ul>
					<li><span><a href="<%=path%>/SelHuiKuan.action"><i
								class="dot dot1"></i>账户总览</a></span></li>
					<li><span><a
							style="font-size:14px;text-align:center;width:115px;padding-right:35px;"
							href="<%=path%>/mr_list.action">资金记录</a></span></li>
					<li><span><a
							style="font-size:14px;text-align:center;width:115px;padding-right:35px;"
							href="<%=path%>/TenderRecordList.action">投资记录</a></span></li>
					<li class="pleft-cur"><span><a
							style="font-size:14px;text-align:center;width:115px;padding-right:35px;"
							href="<%=path%>/Borrow/selBorrowMoney.action">借款记录</a></span></li>
					<li class=""><span><a
							href="${pageContext.request.contextPath}/bank/selbank.action"><i
								class="dot dot02"></i>银行卡管理</a> </span></li>
					<li><span><a href="<%=path%>/selBank.action"><i
								class="dot dot03"></i>充值</a></span></li>
					<li class=""><span><a
							href="<%=path%>/foregroundSystem/personal_tixian_1.jsp"><i
								class="dot dot04"></i>提现</a></span></li>
					<li style="position:relative;"><span> <a
							href="<%=path%>/foregroundSystem/personal_xitongxiaoxi.jsp"><i
								class="dot dot08"></i>系统信息 </a>
					</span></li>
					<li><span><a
							href="<%=path%>/foregroundSystem/personal_zhanghushezhi.jsp"><i
								class="dot dot09"></i>账户设置</a></span></li>
					<li><span><a
							href="${pageContext.request.contextPath}/rengzheng/sel.action"><i
								class="dot dot09"></i>资料上传</a></span></li>
				</ul>
			</div>
			<div class="personal-main">
				<div class="personal-investnote">
					<h3>
						<i>还款计划</i>
					</h3>
					<div class="investnote-money">
						<span><b class="fb">累计还款</b><br> <i>${ljhk} </i> 元 </span> <span><b
							class="fb">还需还款</b><br> <i>${yhk} </i> 元 </span>
					</div>
					<form id="form" name="form" method="post" action="">
						<script type="text/javascript">clearPage = function() {
								PrimeFaces.ab({
									source : 'form:j_idt82',
									formId : 'form',
									process : 'form:j_idt82',
									params : arguments[0]
								});
							}
						</script>
						<span id="form:dataTable">

							<div class="investnote-list" id="jiekuan">
								<div class="investnote-contitle">
									<span class="investnote-w1 fb">期数</span> <span
										class="investnote-w2 fb" style="width: 200px;">还款本息</span> <span
										class="investnote-w3 fb" style="width: 60px;">还款本金</span> <span
										class="investnote-hbw4 fb">状态</span> <span
										class="investnote-hbw5 fb" style="width: 110px;">还款日期</span> <span
										class="investnote-hbw6 fb">操作</span>
								</div>
								<ul>
									<c:forEach items="${dets }" var="det">
										<li><span class="investnote-w1">第${det.periods }期
										</span> <span class="investnote-w2">${det.repay_capital}</span> <span
											class="investnote-w3"> ${det.repay_corpus}</span> <span
											class="investnote-hbw4"> <c:choose>
													<c:when test="${det.repay_status==0 }">
														<font color="red">未还款</font>
													</c:when>
													<c:when test="${det.repay_status==1 }">
														<font color="blue">已还款</font>
													</c:when>
												</c:choose>
										</span> <span class="investnote-hbw5"><fmt:formatDate
													value="${det.repay_date }" pattern="yyyy-MM-dd" /></span> <span
											class="investnote-hbw6"> <c:choose>
													<c:when test="${det.repay_status==0 }">
														<a href="javascript:void(0);"
															onclick="showSpan('alert-hk');$('#repay_money').val('${det.repay_capital}');$('#b_id').val('${det.b_id}');$('#repay_id').val('${det.repay_id}');$('#hkqs').val('${det.periods}');"><font
															color="green">还款</font></a>
													</c:when>
													<c:when test="${det.repay_status==1 }">
														<font color="blue">已还款</font>
													</c:when>
												</c:choose></span></li>
									</c:forEach>
								</ul>
							</div>
						</span>
					</form>
				</div>
			</div>
			<div class="clear"></div>
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

	<!-- 还款弹框 -->
	<div class="alert-450" id="alert-hk" style="display:none;">
		<div class="alert-title">
			<h3>还款支付</h3>
			<span class="alert-close" onclick="displaySpan('alert-hk')"></span>
		</div>
		<div class="alert-main">
			<form id="checkOldMobileForm" name="checkOldMobileForm" method="post"
				action="<%=path%>/Borrow/Tohuankuan.action"
				enctype="application/x-www-form-urlencoded">
				<ul>
					<li style="margin-top: 15px"><label class="txt-name">请选择支付方式:</label>
						<select id="selectcard" name="zffs">
							<option value="余额支付">余额支付</option>
							<c:forEach items="${ttzbs}" varStatus="" var="tba">
								<option value="${tba.bankcard },${tba.bkmoney}">${tba.banktype }
									${tba.bankcard }</option>
							</c:forEach>
					</select> <br /> <br /></li>
					<input type="hidden" name="repay_money" id="repay_money" />
					<input type="hidden" name="b_id" id="b_id" />
					<input type="hidden" name="repay_id" id="repay_id" />
					<input type="hidden" name="hkqs" id="hkqs" />
					<li style="margin-top: 15px"><label class="txt-name">请输入支付密码:</label>
						<input type="text" id="mima" class="txt220" maxlength="30"
						style="width:250px" placeholder="请输入支付密码"
						onkeyup="yzmima(this.value);"> <br /> <br /></li>
					<li><span class="txt-right" style="display: none;" id="errors"><i
							class="error-icon"></i><i class="error-tip" id="errorsmsg"></i></span><br>
						<input type="button" value="确 认" class="btn-ok txt-right"
						onclick="tijiao();"></li>
				</ul>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		//<![CDATA[
		function showSpan(op) {
			$("body").append("<div id='mask'></div>");
			$("#mask").addClass("mask").css("display", "block");
			$("#" + op).css("display", "block");
		}
	
		function displaySpan(op) {
			$("#mask").css("display", "none");
			$("#" + op).css("display", "none");
		}
	
		//验证密码
		function yzmima(val) {
			if (val != '${user.zpwd}') {
				$("#errors").css("display", "");
				$("#errorsmsg").html("密码错误!");
			} else {
				$("#errors").css("display", "");
				$("#errorsmsg").html("密码输入正确!");
			}
		}
	
		function tijiao() {
			var aa = $("#selectcard").val(); //下拉框的值
			var je = $('#repay_money').val(); //要支付的金额
			var bb = aa.split(",")[1]; //银行卡余额
			var cc = '${user.money}'; //我的余额
			if (aa == '余额支付') {
				if (parseInt(cc) < parseInt(je)) { //余额小于要支付的金额
					$("#errors").css("display", "");
					$("#errorsmsg").html("余额不足!");
				} else { //可以投资
					if ($("#mima").val() != '${user.zpwd}') {
						$("#errors").css("display", "");
						$("#errorsmsg").html("密码错误!");
					} else if ($("#mima").val() == '') {
						$("#errors").css("display", "");
						$("#errorsmsg").html("请输入密码");
					} else {
						$("#checkOldMobileForm").submit();
					}
				}
			} else if (aa != '余额支付') {
				//alert("不余额支付" + bb + je);
				if (parseInt(bb) < parseInt(je)) { //银行卡余额小于投资金额
					$("#errors").css("display", "");
					$("#errorsmsg").html("此银行卡余额不足!");
				} else { //可以投资
					if ($("#mima").val() != '${user.zpwd}') {
						$("#errors").css("display", "");
						$("#errorsmsg").html("密码错误!");
					} else if ($("#mima").val() == '') {
						$("#errors").css("display", "");
						$("#errorsmsg").html("请输入密码");
					} else {
						$("#checkOldMobileForm").submit();
					}
				}
			}
		}
	</script>
</body>
</html>
