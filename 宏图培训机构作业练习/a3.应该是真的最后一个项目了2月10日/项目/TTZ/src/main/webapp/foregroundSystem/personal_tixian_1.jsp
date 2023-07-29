<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<link href="css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/user.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.datetimepicker.css" />
<script type="text/javascript" src="script/jquery.min.js"></script>
<script type="text/javascript" src="script/common.js"></script>
<script src="script/user.js" type="text/javascript"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">

</head>
<body onload="selbank();">
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
				<a class="" href="<%=path%>/Borrow/selBorrowMoneySomeList.action">
					<img src="images/logo.png" title="">
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
				<img src="images/clist1.jpg" width="1200" height="96">
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
					<li><span><a
							style="font-size:14px;text-align:center;width:115px;padding-right:35px;"
							href="<%=path%>/Borrow/selBorrowMoney.action">借款记录</a></span></li>
					<li class=""><span><a
							href="${pageContext.request.contextPath}/bank/selbank.action"><i
								class="dot dot02"></i>银行卡管理</a> </span></li>
					<li><span><a href="<%=path %>/selBank.action"><i
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
			<label id="typeValue" style="display:none;"> </label>
			<!-- 遮罩层 -->
			<div id="mask" class="mask"></div>
			<script>
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
				$(function() {
					if ('${user.zsname}' == '' || '${user.zsname}' == null) {
						$("#mask").css("height", $(document).height());
						$("#mask").css("width", $(document).width());
						$("#mask").show();
						if (confirm('您未绑定个人信息!')) {
							location.href = '<%=path%>/foregroundSystem/personal_zhanghushezhi.jsp';
						} else {
							location.href = '<%=path%>/foregroundSystem/personal_zhanghushezhi.jsp';
						}
					}
				});
				//]]>
			</script>
			<script type="text/javascript">
			
				function checkActualMoney(id) {
					var takemoney = ($("#form\\:actualMoney").val());
					var bankcard = $("#selbankcard").text();
					var actualMessage = $("#actualMoney_message");
					var nullFlag = takemoney == "";
					var numberFlag = isNaN(takemoney);
			
					if (nullFlag == true) {
						$(actualMessage).hide();
						$(actualMessage).text("请输入您要提现的金额");
						$(actualMessage).show();
			
					} else if (numberFlag == true) {
						$(actualMessage).hide();
						$(actualMessage).text("请输入数字！");
						$(actualMessage).show();
					} else if (takemoney < 2 || 500000 < takemoney) {
						$(actualMessage).hide();
						$(actualMessage).text("提现金额必须大于2.00 元，单笔不超过50 万");
						$(actualMessage).show();
					} else if (bankcard == "2333") {
						alert("请选择银行卡！");
						$(actualMessage).hide();
			
					} else {
						$.getJSON("<%=path%>/WithDraw/bankWithDraw.action", {
							userid : id,
							bankcard : bankcard,
							takeMoney : takemoney
						}, function(data) {
							var warm = data.warm;
							var money = data.money;
							alert(warm);
							$("#blance").html("");
							$("#blance").text(money);
							$("#form\\:actualMoney").val("")
						}, "json");
			
					}
			
				}
			</script>
			<script type="text/javascript">
				function checkWithDraw() {
					$(actualMessage).hide();
					$("#form\\:fee").html("");
					$("#form\\:cashFine").html("");
			
					var actualMoney = ($("#form\\:actualMoney").val());
					var actualMessage = $("#actualMoney_message");
					var numberFlag = isNaN(actualMoney);
					var bankcard = $("#selbankcard").text();
					var actualMessage = $("#actualMoney_message");
					var nullFlag = actualMoney == "";
			
					var submit = document.getElementById('checkhand');
					if (actualMoney > 0 && actualMoney * 0.001 <= 2) {
						$("#form\\:fee").text(2.00);
						$("#form\\:cashFine").text(actualMoney);
					} else if (actualMoney * 0.001 > 2 && actualMoney * 0.001 < 100) {
						$("#form\\:fee").text(actualMoney * 0.001);
						$("#form\\:cashFine").text(actualMoney);
					} else if (actualMoney * 0.001 > 100) {
						$("#form\\:fee").text(100);
						$("#form\\:cashFine").text(actualMoney);
					} else if (actualMoney == 0) {
						$("#form\\:fee").text("0.00");
						$("#form\\:cashFine").text("0.00");
					} else if (actualMoney > 500000) {
						$("#form\\:fee").text(0.001);
					}
			
					if (nullFlag == true) {
						$(actualMessage).hide();
						$(actualMessage).text("请输入您要提现的金额");
						$(actualMessage).show();
						submit.disabled = true;
					} else if (numberFlag == true) {
						$(actualMessage).hide();
						$(actualMessage).text("请输入数字！");
						$(actualMessage).show();
						submit.disabled = true;
					} else if (actualMoney < 2 || 500000 < actualMoney) {
						$(actualMessage).hide();
						$(actualMessage).text("提现金额必须大于2.00 元，单笔不超过50 万");
						$(actualMessage).show();
					} else {
						$(actualMessage).hide();
					}
			
				}
			</script>
			<div class="personal-main">
				<div class="personal-deposit">
					<h3>
						<i>提现</i>
					</h3>

					<div class="deposit-form"
						style="margin-top:0px;border-top:0px none;">
						<h6>请选择银行卡</h6>
						<div class="Withdrawals clearfix" id="selectbankcard">
							<div class="item" onclick="showSpan('alert-checkOldMobile')">

								<div class="img">
									<img src="images/addbank.jpg" style="width:100%"><span
										class="imgmid" style="display:none" id="selbankcard">2333</span>
								</div>
							</div>

						</div>
						<ul>
							<li><span class="deposit-formleft">可用金额</span> <span
								class="deposit-formright"> <i> <label id="blance">
											${user.money }</label>
								</i>元
							</span></li>
							<li><span class="deposit-formleft">提现金额</span> <span
								class="deposit-formright"> <input id="form:actualMoney"
									type="text" name="form:actualMoney" class="deposite-txt"
									maxlength="10" onkeyup="checkWithDraw();"> 元
							</span> <span id="actualMoneyErrorDiv"><span
									id="actualMoney_message" style="display:none" class="error"></span></span>
							</li>
							<li><span class="deposit-formleft">提现费用</span> <em id="txfy"
								class="markicon fl"></em> <span
								class="deposit-formright deposit-formright1"> <i> <label
										id="form:fee"> 0.00</label>
								</i>元
							</span> <span class="txarrow-show">提现金额的0.1%，最低不低于2元，最高100元封顶</span><span
								class="txicon-show"></span></li>
							<li><span class="deposit-formleft">实际到账金额</span> <em
								id="dzje" class="markicon fl"></em> <span
								class="deposit-formright deposit-formright1"> <i> <label
										id="form:cashFine"> 0.00</label>
								</i> 元
							</span> <span class="dzarrow-show">提现金额 - 提现费用</span><span
								class="dzicon-show"></span></li>
							<li><input type="submit" value="提现" id="checkhand"
								class="btn-depositok"
								onclick="checkActualMoney('${user.userid}')"></li>
						</ul>
					</div>

					<div class="deposit-tip" style="margin-top:100px">
						温馨提示：<br> 1、用户需在完成身份认证、开通丰付托管账户并绑定银行卡后，方可申请提现；<br>
						2、请务必在提现时使用持卡人与身份认证一致的银行卡号，且确保填写信息准确无误；<br>
						3、工作日当天16:00前提交的提现申请将在当天处理，默认为T+1到账；<br>
						4、提现金额单笔上限为50万元，单日累计总额不可超过100万元；<br>
						5、提现手续费为提现金额的0.1%，最低每笔2元，100元封顶，手续费由第三方托管账户收取，用户自行承担。<br>
						6、用户一次性提现完或当余额不足以支付手续费时，手续费将由第三方从用户提现金额中收取。<br>
					</div>
				</div>
			</div>
			<!-- 弹出层：选择银行卡 -->
			<div class="alert-800" id="alert-checkOldMobile"
				style="display:none;">
				<div class="alert-title">
					<h3>选择银行卡</h3>
					<span class="alert-close"
						onclick="displaySpan('alert-checkOldMobile')"></span>
				</div>
				<div class="alert-main">
					<form id="checkOldMobileForm" name="checkOldMobileForm"
						method="post" action="#"
						enctype="application/x-www-form-urlencoded">
						<input type="hidden" name="checkOldMobileForm"
							value="checkOldMobileForm">
						<ul id="banklist" style="float: left; margin-left: 20px;">

						</ul>
					</form>
				</div>
			</div>
			<script type="text/javascript">
				function selbank() {
					$.getJSON("<%=path%>/WithDraw/selUserBank.action", {}, function(data) {
						var ttzList = data.Ttzlist;
						$.each(ttzList, function(index, ttz) {
							var li = $("<li>", {
								"style" : "width:33.33%"
							});
							
							var div2 = $("<div>", {
								"class" : "item"
							});
							var div3 = $("<div>", {
								"class" : "card-num",
								"text" : ttz.bankcard
							});
							var div4 = $("<div>", {
								"class" : "img",
							});
							if (ttz.banktype == "工商银行") {
								var url = "images/bank1.png";
								var img = $("<img>", {
									"src" : url
								});
							} else if (ttz.banktype == "农业银行") {
								var url = "images/bank2.png";
								var img = $("<img>", {
									"src" : url
								});
							} else if (ttz.banktype == "招商银行") {
								var url = "images/bank3.png";
								var img = $("<img>", {
									"src" : url
								});
							} else if (ttz.banktype == "建设银行") {
								var url = "images/bank4.png";
								var img = $("<img>", {
									"src" : url
								});
							} else if (ttz.banktype == "中国银行") {
								var url = "images/bank5.png";
								var img = $("<img>", {
									"src" : url
								});
							} else if (ttz.banktype == "中国邮政") {
								var url = "images/bank6.png";
								var img = $("<img>", {
									"src" : url
								});
							} else if (ttz.banktype == "交通银行") {
								var url = "images/bank7.png";
								var img = $("<img>", {
									"src" : url
								});
							} else if (ttz.banktype == "农村信用社") {
								var url = "images/bank8.png";
								var img = $("<img>", {
									"src" :url
								});
							} else if (ttz.banktype == "民生银行") {
								var url = "images/bank9.png";
								var img = $("<img>", {
									"src" : url
								});
							}
			
							var div1 = $("<div>", {
								"class" : "Withdrawalss clearfix",
								"onclick" : "selectBank('" + ttz.bankcard + "','" + url + "');"
							});
							div4.append(img);
							div2.append(div3);
							div2.append(div4);
							div1.append(div2);
							li.append(div1);
			
							$("#banklist").append(li);
						});
					}, "json");
				}
				function selectBank(bank,url) {
				
					$("#selectbankcard").html("");
					var div1 = $("<div>", {
						"class" : "Withdrawalss clearfix",
						"onclick" : "showSpan('alert-checkOldMobile')"
					});
					var div2 = $("<div>", {
						"class" : "item"
					});
					var div3 = $("<div>", {
						"class" : "card-num",
						"id" : "selbankcard",
						"text" : bank
					});
					var div4 = $("<div>", {
						"class" : "img",
					});
			
					var img = $("<img>", {
						"src" : url
					});
			
					div4.append(img);
					div2.append(div3);
					div2.append(div4);
					div1.append(div2);
					$("#selectbankcard").append(div1);
					$("#mask").css("display", "none");
					$("#alert-checkOldMobile").css("display", "none");
				}
			</script>


			<script type="text/javascript">
				$("#form\\:actualMoney").focus(
					function() {
						$(this).css({
							"font-size" : "24px",
							"font-weight" : "bold",
							"font-family" : "Arial",
							"border" : "1px solid #0caffe"
						});
						if ($("#form\\:actualMoney").val() == value) {
							$("#form\\:actualMoney").val("")
							$(this).css({
								"font-size" : "24px",
								"font-weight" : "bold",
								"font-family" : "Arial"
							});
						}
					}).blur(
					function() {
						$(this).css("border", "1px solid #D0D0D0");
						if ($("#form\\:actualMoney").val() == "") {
							$(this).css({
								"color" : "#D0D0D0",
								"font-size" : "14px",
								"font-weight" : "normal"
							});
						}
					})
			
				function keyUpcheck() {
					$(this).css({
						"font-size" : "24px",
						"font-weight" : "bold",
						"font-family" : "Arial"
					});
				}
			</script>
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
						<a href="公司简介.html">公司简介</a><a href="管理团队.html">管理团队</a><a
							href="网站公告.html">网站公告</a>
					</dd>
				</dl>
				<dl>
					<dt>相关业务</dt>
					<dd>
						<a href="list.html">我要投资</a><a href="我要借款.html">我要借款</a>
					</dd>
				</dl>
				<dl>
					<dt>帮助中心</dt>
					<dd>
						<a href="帮助中心.html">新手入门</a><a href="个人中心首页.html">我的账户</a><a
							href="list.html">债权转让</a>
					</dd>
				</dl>
				<dl>
					<dt>联系我们</dt>
					<dd>
						<a href="联系我们.html">联系我们</a>
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
						<span class="icon-ft-erweima"><img src="images/code.png"
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
					href="http://www.htmlsucai.com">皖ICP备12345678号-1</a>
			</div>
		</div>
	</div>
	<script src="script/jquery.datetimepicker.js" type="text/javascript"></script>
	<script src="script/datepicker.js" type="text/javascript"></script>
	<script src="script/base_form.js"></script>
	<!-- Toastr script -->
	<script src="script/base_form.jstoastr.min.js"></script>
</body>
</html>
