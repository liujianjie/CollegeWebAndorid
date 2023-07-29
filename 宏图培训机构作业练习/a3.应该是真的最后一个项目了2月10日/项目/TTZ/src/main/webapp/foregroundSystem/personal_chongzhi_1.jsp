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

<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/style.css">
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/all.js"></script>

<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/user.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/jquery.datetimepicker.css" />
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<script src="<%=path%>/foregroundSystem/script/user.js"
	type="text/javascript"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
<!--
遮罩层代码-->
<style type="text/css">
.mask {
	position: absolute;
	top: 0px;
	filter: alpha(opacity = 60);
	background-color: #777;
	z-index: 1002;
	left: 0px;
	opacity: 0.5;
	-moz-opacity: 0.5;
}
</style>
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
							<img src="<%=path%>/foregroundSystem/images/code.png">
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
				<a class="" href="index.html"> <img
					src="<%=path%>/foregroundSystem/images/logo.png"></a>
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
					<li><span><a
							style="font-size:14px;text-align:center;width:115px;padding-right:35px;"
							href="<%=path%>/Borrow/selBorrowMoney.action">借款记录</a></span></li>
					<li class=""><span><a
							href="${pageContext.request.contextPath}/bank/selbank.action"><i
								class="dot dot02"></i>银行卡管理</a> </span></li>
					<li class="pleft-cur"><span><a
							href="<%=path%>/selBank.action"><i class="dot dot03"></i>充值</a></span></li>
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
					$('.quick-tit').click(function() {
			
						$(this).addClass('pay-cur');
						$(this).siblings().removeClass('pay-cur');
						$('.quick-main').show();
						$('.online-main').hide();
			
						$(".pay-tipcon").hide();
						$(".pay-tipcon2").show();
			
					})
			
					$('.online-tit').click(function() {
			
						$(this).addClass('pay-cur');
						$(this).siblings().removeClass('pay-cur');
						$('.quick-main').hide();
						$('.online-main').show();
			
						$(".pay-tipcon2").hide();
						$(".pay-tipcon").show();
					})
				});
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
				//]]>
			</script>
			<script>
				//<![CDATA[
				function checkRecharge() {
					var moneyRegex = "^(([1-9]+[0-9]*)|((([1-9]+[0-9]*)|0)\\.[0-9]{1,2}))$";
					var money = $("#recharge\\:actualMoney").val();
					var nullFlag = (money == "") || money <= 0;
					var numberFlag = isNaN(money);
					//如果输入为空
					if (nullFlag) {
						var $span = "<em></em>请输入金额";
						$("#actualMoneyErrorDiv").jsp($span);
						return false;
					} else {
						$("#actualMoneyErrorDiv").jsp("");
					}
					//如果输入的不是数字
					if (numberFlag) {
						var $span = "<em></em>请输入数字</span>";
						$("#actualMoneyErrorDiv").jsp($span);
						return false;
					} else {
						$("#actualMoneyErrorDiv").jsp("");
					}
					//输入金额是否合法
					var moneyPattern = new RegExp(moneyRegex);
					var legalFlag = moneyPattern.test(money);
					if (!legalFlag) {
						var $span = "<em></em>金额必须大于0且为整数或小数，小数点后不超过2位</span>";
						$("#actualMoneyErrorDiv").jsp($span);
						return false;
					} else {
						$("#actualMoneyErrorDiv").jsp("");
					}
					return true;
				}
				function validateAgree() {
					var $checkname = $("#bank-check").children("b").hasClass("selected");
					if (!($checkname)) {
						return false;
					} else {
						return true;
					}
				}
				function getShowPayVal() {
					var rechargeFlag = checkRecharge();
					var agreeFlag = validateAgree();
					flag = rechargeFlag && agreeFlag;
					$("#recharge\\:rechargeWay").val($("#showpay").jsp());
					var bankProtocol = $("#bankProtocol").attr('class');
					if (!bankProtocol) {
						$("#bankProtocol_message").show();
						return false;
					}
					return flag;
				}
			
			
				function amount(th) {
					var regStrs = [
						[ '^0(\\d+)$', '$1' ], //禁止录入整数部分两位以上，但首位为0
						[ '[^\\d\\.]+$', '' ], //禁止录入任何非数字和点
						[ '\\.(\\d?)\\.+', '.$1' ], //禁止录入两个以上的点
						[ '^(\\d+\\.\\d{2}).+', '$1' ] //禁止录入小数点后两位以上
					];
					for (i = 0; i < regStrs.length; i++) {
						var reg = new RegExp(regStrs[i][0]);
						th.value = th.value.replace(reg, regStrs[i][1]);
					}
					if (th.value > 9999999.99) {
						th.value = th.value.substr(0, th.value.length - 1);
					}
				}
			
				//验证输入银行卡号的合法性
				function checkBankCardNo() {
					//$("#form\\:defaultBankName").text("");
					var cardNo = $("#form\\:bankCardNo").val();
					var reg = /^\d{16,19}$/g; // 以19位数字开头，以19位数字结尾 
					if (!reg.test(cardNo)) {
						//$(".info2-bank").css({"display":"none"});
						var $span = "<em></em>银行卡号输入错误";
						$("#bankCardError").jsp($span);
						return false;
					} else {
						//$(".info2-bank").css({"display":"block"});
						$("#bankCardError").jsp("");
					}
					return true;
				}
				function checkBank() {
					$("#form\\:defaultBankName").text("");
					var cardNo = $("#form\\:bankCardNo").val();
					var reg = /^\d{16,19}$/g; // 以19位数字开头，以19位数字结尾 
					if (!reg.test(cardNo)) {
						$(".info2-bank").css({
							"display" : "none"
						});
						return false;
					} else {
						$(".info2-bank").css({
							"display" : "block"
						});
					}
					return true;
				}
			
				function validateAgree2() {
					var $checkname = $("#bank-check2").children("b").hasClass("selected");
					if (!($checkname)) {
						showSpan('alert-tyht');
						return false;
					} else {
						return true;
					}
				}
			
				function checkRecharge1() {
					var moneyRegex = "^(([1-9]+[0-9]*)|((([1-9]+[0-9]*)|0)\\.[0-9]{1,2}))$";
					var money = $("#form\\:actualMoney1").val();
					var nullFlag = (money == "") || money <= 0;
					var numberFlag = isNaN(money);
					//如果输入为空
					if (nullFlag) {
						var $span = "<em></em>请输入充值金额";
						$(".quick-error").jsp($span);
						return false;
					} else {
						$(".quick-error").jsp("");
					}
					//如果输入的不是数字
					if (numberFlag) {
						var $span = "<em></em>请输入数字";
						$(".quick-error").jsp($span);
						return false;
					} else {
						$(".quick-error").jsp("");
					}
					//输入金额是否合法
					var moneyPattern = new RegExp(moneyRegex);
					var legalFlag = moneyPattern.test(money);
					if (!legalFlag) {
						var $span = "<em></em>金额必须大于0且为整数或小数，小数点后不超过2位";
						$(".quick-error").jsp($span);
						return false;
					} else {
						$(".quick-error").jsp("");
					}
			
					if (parseInt(money) > 50000) {
						var $span = "<em></em>充值金额超过50000元";
						$(".quick-error").jsp($span);
						return false;
					} else {
						$(".quick-error").jsp("");
					}
					return true;
				}
			
				function getShowPayVal1() {
					var rechargeFlag = checkRecharge1();
					var bankCardFlag = checkBankCardNo();
					var agreeFlag = validateAgree2();
					var payflag = rechargeFlag && bankCardFlag && agreeFlag;
					var defaultBankName = $("#form\\:defaultBankName").text();
					if (defaultBankName.replace(/(^\s*)|(\s*$)/g, "") == "此银行暂不支持") {
						var $span = "<em></em>此银行暂不支持";
						$(".quick-error3").jsp($span);
						return false;
					}
					/*$("#recharge\\:rechargeWay").val($("#showpay").jsp());
					var bankProtocol = $("#bankProtocol").attr('class');
					if(!bankProtocol)
					{
						$("#bankProtocol_message").show();
						 return false;
					}*/
					return payflag;
				}
			
				function checkRecharge2() {
					var moneyRegex = "^(([1-9]+[0-9]*)|((([1-9]+[0-9]*)|0)\\.[0-9]{1,2}))$";
					var money = $("#form2\\:actualMoney2").val();
					var nullFlag = (money == "") || money <= 0;
					var numberFlag = isNaN(money);
					//如果输入为空
					if (nullFlag) {
						var $span = "<em></em>请输入充值金额";
						$("#quick-error2").jsp($span);
						return false;
					} else {
						$("#quick-error2").jsp("");
					}
					//如果输入的不是数字
					if (numberFlag) {
						var $span = "<em></em>请输入数字";
						$("#quick-error2").jsp($span);
						return false;
					} else {
						$("#quick-error2").jsp("");
					}
					//输入金额是否合法
					var moneyPattern = new RegExp(moneyRegex);
					var legalFlag = moneyPattern.test(money);
					if (!legalFlag) {
						var $span = "<em></em>金额必须大于0且为整数或小数，小数点后不超过2位";
						$("#quick-error2").jsp($span);
						return false;
					} else {
						$("#quick-error2").jsp("");
					}
			
					if (parseInt(money) > 50000) {
						var $span = "<em></em>充值金额超过50000元";
						$("#quick-error2").jsp($span);
						return false;
					} else {
						$("#quick-error2").jsp("");
					}
					return true;
				}
			
				function getShowPayVal2() {
					var rechargeFlag = checkRecharge2();
					var agreeFlag = validateAgree2();
					var payflag = rechargeFlag && agreeFlag;
					/*$("#recharge\\:rechargeWay").val($("#showpay").jsp());
					var bankProtocol = $("#bankProtocol").attr('class');
					if(!bankProtocol)
					{
						$("#bankProtocol_message").show();
						 return false;
					}*/
					return payflag;
				}
			
				/* function showSpan(op){
					$("body").append("<div id='maskCommon'></div>");
					$("#maskCommon").addClass("mask1").css("display","block");
					$("#"+op).css("display","block");
				} */
			
				/* function displaySpan(op){
					$("#alert-ClickDialog").hide();
					$("#maskCommon").hide();
				} */
			
				$(document).ready(function() {
					if ("false" == 'true') {
						showSpan("alert-ClickDialog");
					}
					if ("false" == 'true') {
						showSpan("alert-unbindMsgDialog");
					}
				});
				//]]>
			</script>
			<div class="personal-main">
				<div class="personal-pay">
					<h3>
						<i>充值</i>
					</h3>
					<div class="quick-pay-wrap">
						<h4>
							<span class="quick-tit pay-cur"><em>余额充值</em></span>
							<!-- 							<span class="online-tit"><em>网银充值</em></span> -->
						</h4>
						<form id="form" name="form" method="post"
							action="<%=path%>/chongzhi.action">
							<div class="quick-main">
								<div class="fl quick-info">
									<div class="info-1">
										<span class="info-tit">充值金额</span> <span class="info1-input">
											<input id="form:actualMoney1" type="text" name="cz_money"
											class="pay-money-txt" maxlength="10"> <em>元</em>
										</span> <span class="quick-error"> </span>
									</div>
									<div class="info-tips">团团赚提醒您：祝您充值愉快！</div>
									<div class="info-2">
										<span class="info-tit">银行卡号</span> <select name="bank_id"
											style="margin-top: 25px;height: 35px">
											<option>--请选择卡号--</option>
											<c:forEach items="${ttzlist }" var="ttzlist">
												<option value="${ttzlist.bankcard }">${ttzlist.bankcard }</option>
											</c:forEach>
										</select>
									</div>
									<div class="bank-check" id="bank-check2">
										<b class="selected" id="bankProtocol1"></b><span
											class="bank-agree">我同意并接受<a href="#" target="_blank">《团团赚投资咨询与管理服务电子协议》</a></span>
										<span class="error" id="bankProtocol_message"
											style="display:none;margin-top:-3px;">请同意协议内容！</span>
									</div>
									<input type="button" onclick="alaxport();" name="" value="充值"
										class="btn-paycz"> <input type="reset" id="reset"
										style="display: none;">
								</div>
							</div>
						</form>
						<script type="text/javascript">
							function alaxport() {
								var ajaxCallUrl = "<%=path%>/chongzhi.action";
								$.ajax({
									cache : true,
									type : "POST",
									url : ajaxCallUrl,
									data : $('#form').serialize(), // 你的formid
									async : false,
									error : function(request) {
										alert("提交错误！");
									},
									success : function(data) {
										alert(data.statu);
										$("#reset").click();
									}
								});
							}
						</script>

						<div class="online-main" style="display:none;">
							<form id="recharge" name="recharge" method="post" action="#"
								target="_blank">
								<div class="online-mar">
									<div class="quick-info quick-info-width">
										<div class="info-1">
											<span class="info-tit">充值金额</span> <span class="info1-input">
												<input id="recharge:actualMoney" type="text"
												name="recharge:actualMoney" class="pay-money-txt"
												maxlength="10" onblur="checkRecharge()"
												onkeydown="amount(this);keyUpcheck()"
												onkeyup="amount(this);keyUpcheck()"> <em>元</em>
											</span> <span id="actualMoneyErrorDiv" class="quick-error2">
											</span>
										</div>
									</div>
								</div>
								<div>
									<span><font
										style=" color:#848484;font-weight:bold; margin-left:80px; height:32px; line-height:32px; font-size:12px;">团团赚提醒您：充值前，请核实您的可用支付额度！</font></span>
								</div>
								<div class="pay-bank" id="pay-bank">
									<h6>请选择充值银行</h6>
									<span id="showpay" style="display:none;">icbc</span>
									<ul id="paysSpan" style="height:150px;">

										<li><img src="foregroundSystem/images/bank1.png"
											property1="icbc" class="on"><em></em><i></i></li>
										<li><img src="foregroundSystem/images/bank4.png"
											property1="abc" class="on"><em></em></li>
										<li><img src="foregroundSystem/images/bank2.png"
											property1="boc"><em></em></li>
										<li><img src="foregroundSystem/images/bank3.png"
											property1="ccb"><em></em></li>
										<li><img src="foregroundSystem/images/bank5.png"
											property1="hxb"><em></em></li>
										<li><img src="foregroundSystem/images/bank6.png"
											property1="comm"><em></em></li>
										<li><img src="foregroundSystem/images/bank7.png"
											property1="cmb"><em></em></li>
										<li><img src="foregroundSystem/images/bank8.png"
											property1="ceb"><em></em></li>
										<li><img src="foregroundSystem/images/bank9.png"
											property1="cncb"><em></em></li>
										<li><img src="foregroundSystem/images/bank10.png"
											property1="cmsb"><em></em></li>
										<li><img src="foregroundSystem/images/bank11.png"
											property1="cgb"><em></em></li>
										<li><img src="foregroundSystem/images/bank12.png"
											property1="shb"><em></em></li>
										<li><img src="foregroundSystem/images/bank13.png"
											property1="bjb"><em></em></li>
										<li><img src="foregroundSystem/images/bank14.png"
											property1="rcb"><em></em></li>
										<li><img src="foregroundSystem/images/bank15.png"
											property1="cib"><em></em></li>
									</ul>
									<span class="pay-other"><span class="paytxt">选择其他银行卡</span><i
										class="paydown"></i></span>
								</div>
								<div class="pay-bankstate">
									<span class="bankstate-head"><i class="fl">请关注您的充值金额是否超限：</i><i
										class="fr" id="show-pay-hotLine">工商银行客服热线：95588</i></span>
									<table>
										<tbody>
											<tr>
												<td>单笔限额（元）</td>
												<td>每日限额（元）</td>
												<td>需要满足条件</td>
												<td>备注</td>
											</tr>
											<tr>
												<td width="15%">5000</td>
												<td width="15%">5000</td>
												<td width="20%">工银e支付</td>
												<td width="50%" rowspan="5">请到中国工商银行各营业网点办理成为个人网上银行客户并开通网上支付功能（静态密码用户进行网上支付如超过累计金额请直接到营业网点申领电子口令卡或USB
													Key）；</td>
											</tr>
											<tr>
												<td>500</td>
												<td>1000</td>
												<td>电子口令卡</td>
											</tr>
											<tr>
												<td>2000</td>
												<td>5000</td>
												<td>短信认证</td>
											</tr>
											<tr>
												<td>50万</td>
												<td>100万</td>
												<td>电子密码</td>
											</tr>
											<tr>
												<td>100万</td>
												<td>100万</td>
												<td>U盾</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="bank-check" id="bank-check">
									<b class="selected" id="bankProtocol"></b><span
										class="bank-agree">我同意并接受<a
										href="/node/Candyprivacypolicy/candyprivacypolicy_tzzxyglfwdzxy"
										target="_blank">《团团赚金融投资咨询与管理服务电子协议》</a></span> <span class="error"
										id="bankProtocol_message"
										style="display:none;margin-top:-3px;">请同意协议内容！</span>
								</div>
								<input type="submit" name="recharge:j_idt96" value="充值"
									class="btn-paycz" onclick="return getShowPayVal()"> <input
									type="hidden" name="javax.faces.ViewState"
									id="javax.faces.ViewState">
							</form>
						</div>
						<div class="pay-tipcon" style="display:none;">
							<b>充值提示：</b><br> 1．团团赚充值过程免费，不向用户收取任何手续费。<br>
							2．为了您的账户安全，请在充值前进行身份认证、手机绑定以及交易密码设置。<br>
							3．您的账户资金将通过丰付支付第三方平台进行充值。<br> 4．请注意您的银行卡充值限制，以免造成不便。<br>
							5．如果充值金额没有及时到账，请联系客服—400-999-8850
						</div>
						<div class="pay-tipcon2">
							<b>温馨提示：</b><br> 1. 投资人充值过程全程免费，不收取任何手续费。<br> 2.
							为防止套现，所充资金必须经投标回款后才能提现。<br> 3.
							使用快捷支付进行充值，可能会受到不同银行的限制，如需大额充值请使用网银充值进行操作。<br> 4.
							充值/提现必须为银行借记卡，不支持存折、信用卡充值。<br> 5.
							严禁利用充值功能进行信用卡套现、转账、洗钱等行为，一经发现，将封停账号30天。<br> 6.
							充值期间，请勿关闭浏览器，待充值成功并返回首页后，所充资金才能入账，如有疑问，请联系客服。<br> 7.
							充值需开通银行卡网上支付功能，如有疑问请咨询开户行客服。<br>
						</div>
					</div>
				</div>
				<div class="alert-450 alert-h220" id="alert-rechargeFailture"
					style="display:none;">
					<div class="alert-title">
						<h3>登录网上银行充值</h3>
						<span class="alert-close"
							onclick="displaySpan('alert-rechargeFailture')"></span>
					</div>
					<div class="alert-main">
						<form id="rechargeFailtureForm">
							<p class="msg1">
								<i class="no-icon"></i><i class="msgtxt">充值失败</i>您可以：<a href="#"><font
									color="#28A7E1">选择其他银行充值</font></a>或查看<a href="#"><font
									color="#28A7E1">充值帮助</font></a>
							</p>
						</form>
					</div>
				</div>
				<div class="clear"></div>
				<div class="alert-400 alert-h220" id="alert-ClickDialog"
					style="display:none;">
					<div class="alert-title">
						<h3>消息</h3>
					</div>
					<div class="alert-main">
						<p class="msg4"></p>
						<p class="msg-a">
							<a class="btn-ok btn-145"
								onclick="displaySpan('alert-ClickDialog')" href="#">关 闭</a>
						</p>
					</div>
				</div>
				<div class="alert-400 alert-h220" id="alert-unbindMsgDialog"
					style="display:none;">
					<div class="alert-title">
						<h3>消息</h3>
					</div>
					<div class="alert-main">
						<p class="msg4"></p>
						<p class="msg-a">
							<a class="btn-ok btn-145"
								onclick="displaySpan('alert-unbindMsgDialog')" href="#">关 闭</a>
						</p>
					</div>
				</div>
				<script type="text/javascript">
					$("#recharge\\:actualMoney").val("单笔大于0元");
					var value = "单笔大于0元";
					$("#recharge\\:actualMoney").focus(
						function() {
							$(this).css({
								"font-size" : "24px",
								"font-weight" : "bold",
								"font-family" : "Arial",
								"border" : "1px solid #0caffe"
							});
							if ($("#recharge\\:actualMoney").val() == value) {
								$("#recharge\\:actualMoney").val("")
								$(this).css({
									"font-size" : "24px",
									"font-weight" : "bold",
									"font-family" : "Arial"
								});
							}
						}).blur(
						function() {
							$(this).css("border", "1px solid #D0D0D0");
							if ($("#recharge\\:actualMoney").val() == "") {
								$("#recharge\\:actualMoney").val("单笔大于0元").css("color", "#D0D0D0");
								$(this).css({
									"color" : "#D0D0D0",
									"font-size" : "14px",
									"font-weight" : "normal"
								});
							}
						})
				
					$("#form\\:actualMoney1").val("单笔大于0元");
					$("#form\\:actualMoney1").focus(
						function() {
							$(this).css({
								"font-size" : "24px",
								"font-weight" : "bold",
								"font-family" : "Arial",
								"border" : "1px solid #0caffe",
								"height" : "38px"
							});
							if ($("#form\\:actualMoney1").val() == value) {
								$("#form\\:actualMoney1").val("");
								$(this).css({
									"font-size" : "24px",
									"font-weight" : "bold",
									"font-family" : "Arial",
									"height" : "38px"
								});
							}
						}).blur(
						function() {
							$(this).css("border", "1px solid #D0D0D0");
							if ($("#form\\:actualMoney1").val() == "") {
								$("#form\\:actualMoney1").val("单笔大于0元").css("color", "#D0D0D0");
								$(this).css({
									"color" : "#D0D0D0",
									"font-size" : "14px",
									"font-weight" : "normal",
									"height" : "38px"
								});
							}
						})
				
					$("#form2\\:actualMoney2").val("单笔大于0元");
					$("#form2\\:actualMoney2").focus(
						function() {
							$(this).css({
								"font-size" : "24px",
								"font-weight" : "bold",
								"font-family" : "Arial",
								"border" : "1px solid #0caffe",
								"height" : "38px"
							});
							if ($("#form2\\:actualMoney2").val() == value) {
								$("#form2\\:actualMoney2").val("")
								$(this).css({
									"font-size" : "24px",
									"font-weight" : "bold",
									"font-family" : "Arial",
									"height" : "38px"
								});
							}
						}).blur(
						function() {
							$(this).css("border", "1px solid #D0D0D0");
							if ($("#form2\\:actualMoney2").val() == "") {
								$("#form2\\:actualMoney2").val("单笔大于0元").css("color", "#D0D0D0");
								$(this).css({
									"color" : "#D0D0D0",
									"font-size" : "14px",
									"font-weight" : "normal",
									"height" : "38px"
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
				
					$("#form\\:bankCardNo").val("请输入银行卡号");
					var cardValue = "请输入银行卡号";
					$("#form\\:bankCardNo").focus(
						function() {
							$(this).css({
								"font-size" : "14px",
								"font-weight" : "bold",
								"font-family" : "Arial",
								"border" : "1px solid #0caffe",
								"color" : "rgb(75, 73, 72)"
							});
							if ($("#form\\:bankCardNo").val() == cardValue) {
								$("#form\\:bankCardNo").val("")
								$(this).css({
									"font-size" : "14px",
									"font-weight" : "bold",
									"font-family" : "Arial"
								});
							}
						}).blur(
						function() {
							$(this).css("border", "1px solid #D0D0D0");
							if ($("#form\\:bankCardNo").val() == "") {
								$("#form\\:bankCardNo").val("请输入银行卡号").css("color", "#D0D0D0");
								$(this).css({
									"color" : "#D0D0D0",
									"font-size" : "14px",
									"font-weight" : "normal"
								});
							}
						})
				</script>
				<div class="alert-450" id="alert-tyht" style="display:none;">
					<div class="alert-title">
						<h3>提示信息</h3>
						<span class="alert-close" onclick="displaySpan('alert-tyht')"></span>
					</div>
					<div class="alert-main"
						style="margin-bottom: 35px;margin-left: 25px;">
						<p class="msg4">你需要阅读并同意《团团赚金融投资咨询与管理服务电子协议》</p>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	< !--网站底部-->
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
	<script src="script/jquery.datetimepicker.js" type="text/javascript"></script>
	<script src="script/datepicker.js" type="text/javascript"></script>
</body>
</html>

