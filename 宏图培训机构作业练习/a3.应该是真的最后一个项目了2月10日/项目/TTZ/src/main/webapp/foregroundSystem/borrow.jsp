<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>我要借款</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/style.css">
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/all.js"></script>
<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link href="<%=path%>/foregroundSystem/css/index.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/Validform_v5.3.2_min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/style2.css">
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
	<div class="bor_banner01"></div>
	<!-- end banner -->
	<div class="bor_con_wper">
		<div class="bor_con px1000">
			<div class="bor_detail">
				<h2 class="bor_detail_tit">
					<span class="bor_decurspan" onclick="myReload(1);">房产抵押</span> <span
						onclick="myReload(2);">车辆抵押</span> <span onclick="myReload(3);">信用贷款</span>
					<span onclick="myReload(4);">零首付车贷</span>
				</h2>
				<div class="bor_detail_box">
					<div class="bor_det_one clearfix pt30 pb30">
						<div class="bor_det_onel fl">
							<p class="bor_p1">中兴财富平台的借款功能旨在帮助借款用户以 低成本获得借款。用户在需要资金时，可以将
								自有房产和车产作为抵押物，小油菜线下审核 通过后，根据抵押物的价值融资。</p>
							<p class="bor_p2">中兴财富平台的借款功能旨在帮助借款用户以 低成本获得借款。用户在需要资金时，可以将
								自有房产和车产作为抵押物，小油菜线下审核 通过后，根据抵押物的价值融资。</p>
							<h3 class="bor_onel_tit">
								<span>申请条件</span>
							</h3>
							<ul class="bor_onel_ul">
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic01.png" alt="">年满18周岁以上的公民
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic02.png" alt="">需要北京房产或车产抵押
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic03.png" alt="">个人或企业银行征信记录良好
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic04.png" alt="">
									无现有诉讼记录</li>

							</ul>
							<h3 class="bor_onel_tit">
								<span>提交资料</span>
							</h3>
							<ul class="bor_onel_ul">
								<li>&nbsp;<img
									src="<%=path%>/foregroundSystem/images/bor_pic05.png" alt="">省份证
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic06.png" alt="">申请资料</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic07.png" alt="">其他</li>
							</ul>
						</div>
						<!-- end l -->
						<div class="bor_det_oner fl">
							<form method="post" action="<%=path%>/Borrow/BorrowMoney.action"
								id="demoform1">
								<fieldset>
									<div>
										<label>申请人</label> <input type="text"
											style="padding-left: 20px;"
											value="${fn:substring(user.pname,0,1)}**" readonly="readonly"
											class="bor_inputbg04 input2"> <input type="hidden"
											name="tid" value="${user.userid }">
									</div>
									<div class="mt15">
										<label>*借款金额</label> <input type=""
											class="bor_inputbg04 input2" name="b_money"
											style="padding-left: 20px;" placeholder="请输入金额"
											datatype="n4-7" errormsg="范围在4~7位数之间！">
									</div>
									<div class="mt15">
										<label>*借款期限(月)</label> <input type=""
											class="bor_inputbg04 input2" name="borrowqx"
											style="padding-left: 20px;" placeholder="请输入借款期限"
											datatype="n1-2" errormsg="请输入1-2位数字">
									</div>
									<div class="mt15">
										<label>*借款类型</label> <input type="" value="房产抵押"
											style="padding-left: 20px;" name="borrow_type"
											readonly="readonly" class="bor_inputbg04 input2">
									</div>
									<div class="mt15 guarmethod clearfix">
										<label class="guarmethod_l fl">*担保方式</label>
									</div>
									<div class="mt15">
										<label>*房屋数量</label> <input type="text"
											class="bor_inputbg03 input2" name="dbw" datatype="n"
											errormsg="请输入房屋数量" style="padding-left: 20px;"
											placeholder="请输入房屋数量">
									</div>
									<div class="mt15">
										<label>*总价值</label> <input type="text"
											class="bor_inputbg04 input2" name="dbx" datatype="n"
											errormsg="请输入房屋总价值" style="padding-left: 20px;"
											placeholder="请输入房屋总价值">
									</div>
									<div class="mt15">
										<label>*还款方式</label> <select name="repayment"
											class="bor_inputbg04 input2">
											<option>--请选择还款方式--</option>
											<option value="等额本息">等额本息</option>
											<option value="等额本金">等额本金</option>
										</select>
									</div>
									<div class="mt15">
										<label>*借款用途</label> <input type="" name="borrow_yt"
											style="padding-left: 20px;" placeholder="请输入借款用途"
											datatype="*" errormsg="请输入借款用途" class="bor_inputbg04 input2">
									</div>
									<div class="mt15">
										<label>*借款描述</label>
										<textarea name="borrow_sm"
											style="padding-left: 20px;width: 250px" placeholder="请输入借款描述"
											datatype="*" errormsg="请输入借款描述"></textarea>
									</div>
									<div class="mt15">
										<label>*验证码</label> <input type="text" id="PictureCheckCode1"
											onblur="checkcode(1)" style="width:166px;padding-left: 20px;"
											class="input" name="yzm" data-msg="验证码" maxlength="4"
											tabindex="1" autocomplete="off" placeholder="请输入验证码">
										<img id="PictureCheck1" src="<%=path%>/Getcode.action"
											style="cursor:pointer;" onclick="myReload(1);" />
									</div>
									<div class="mt30">
										<label></label> <a href="#" class="bor_btn"
											onclick="$('#s1').click();alert('提交成功,请等待审核>即将跳转至我的账户!');">提交材料</a>
										<input type="submit" style="display: none;" id="s1">
									</div>
								</fieldset>
							</form>
						</div>
					</div>
					<!-- end 房产抵押 -->
					<div class="bor_det_one clearfix pt30 pb30" style="display:none;">
						<div class="bor_det_onel fl">
							<p class="bor_p1">中兴财富平台的借款功能旨在帮助借款用户以 低成本获得借款。用户在需要资金时，可以将
								自有房产和车产作为抵押物，小油菜线下审核 通过后，根据抵押物的价值融资。</p>
							<p class="bor_p2">中兴财富平台的借款功能旨在帮助借款用户以 低成本获得借款。用户在需要资金时，可以将
								自有房产和车产作为抵押物，小油菜线下审核 通过后，根据抵押物的价值融资。</p>
							<h3 class="bor_onel_tit">
								<span>申请条件</span>
							</h3>
							<ul class="bor_onel_ul">
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic01.png" alt="">年满18周岁以上的公民
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic02.png" alt="">需要北京房产或车产抵押
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic03.png" alt="">个人或企业银行征信记录良好
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic04.png" alt="">
									无现有诉讼记录</li>

							</ul>
							<h3 class="bor_onel_tit">
								<span>提交资料</span>
							</h3>
							<ul class="bor_onel_ul">
								<li>&nbsp;<img
									src="<%=path%>/foregroundSystem/images/bor_pic05.png" alt="">省份证
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic06.png" alt="">申请资料</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic07.png" alt="">其他</li>
							</ul>
						</div>
						<!-- end l -->
						<div class="bor_det_oner fl">
							<form method="post" action="<%=path%>/Borrow/BorrowMoney.action"
								id="demoform2">
								<fieldset>
									<div>
										<label>申请人</label> <input type="text"
											style="padding-left: 20px;"
											value="${fn:substring(user.pname,0,1)}**" readonly="readonly"
											class="bor_inputbg04 input2"> <input type="hidden"
											name="tid" value="${user.userid }">
									</div>
									<div class="mt15">
										<label>*借款金额</label> <input type="text"
											class="bor_inputbg04 input2" name="b_money"
											style="padding-left: 20px;" placeholder="请输入金额"
											datatype="n4-7" errormsg="范围在4~7位数之间！">
									</div>
									<div class="mt15">
										<label>*借款期限(月)</label> <input type="text"
											class="bor_inputbg04 input2" name="borrowqx"
											style="padding-left: 20px;" placeholder="请输入借款期限"
											datatype="n1-2" errormsg="请输入1-2位数字">
									</div>
									<div class="mt15">
										<label>*借款类型</label> <input type="" value="车辆抵押"
											class="bor_inputbg04 input2" style="padding-left: 20px;"
											name="borrow_type" readonly="readonly">
									</div>
									<div class="mt15 guarmethod clearfix">
										<label class="guarmethod_l fl">*担保方式</label>
									</div>
									<div class="mt15">
										<label>*车辆型号</label> <input type="text"
											class="bor_inputbg04 input2" name="dbw" datatype="*"
											style="padding-left: 20px;" placeholder="请输入车辆型号"
											errormsg="请输入车辆型号">
									</div>
									<div class="mt15">
										<label>*总价值</label> <input type="text"
											class="bor_inputbg04
										input2" name="dbx"
											style="padding-left: 20px;" datatype="*" placeholder="请输入总价值"
											errormsg="请输入总价值">
									</div>
									<div class="mt15">
										<label>*还款方式</label> <select name="repayment"
											class="bor_inputbg04 input2">
											<option>--请选择还款方式--</option>
											<option value="等额本息">等额本息</option>
											<option value="等额本金">等额本金</option>
										</select>
									</div>
									<div class="mt15">
										<label>*借款用途</label> <input type="" name="borrow_yt"
											style="padding-left: 20px;" placeholder="请输入借款用途"
											datatype="*" errormsg="请输入借款用途" class="bor_inputbg04 input2">
									</div>
									<div class="mt15">
										<label>*借款描述</label>
										<textarea name="borrow_sm"
											style="padding-left: 20px;width: 250px;"
											placeholder="请输入借款描述" datatype="*" errormsg="请输入借款描述"></textarea>
									</div>
									<div class="mt15">
										<label>*验证码</label> <input type="text" id="PictureCheckCode2"
											onblur="checkcode(2)" style="width:166px;padding-left: 20px;"
											class="input" name="yzm" data-msg="验证码" maxlength="4"
											tabindex="1" autocomplete="off" placeholder="请输入验证码">
										<img id="PictureCheck2" src="<%=path%>/Getcode.action"
											onclick="myReload(2);" style="cursor:pointer;" />

									</div>
									<div class="mt30">
										<label></label> <a href="#" class="bor_btn"
											onclick="$('#s2').click();alert('提交成功,请等待审核>即将跳转至我的账户!');">提交材料</a>
										<input type="submit" style="display: none;" id="s2">
									</div>
								</fieldset>
							</form>
						</div>
					</div>
					<!-- end  -->
					<div class="bor_det_one clearfix pt30 pb30" style="display:none;">
						<div class="bor_det_onel fl">
							<p class="bor_p1">中兴财富平台的借款功能旨在帮助借款用户以 低成本获得借款。用户在需要资金时，可以将
								自有房产和车产作为抵押物，小油菜线下审核 通过后，根据抵押物的价值融资。</p>
							<p class="bor_p2">中兴财富平台的借款功能旨在帮助借款用户以 低成本获得借款。用户在需要资金时，可以将
								自有房产和车产作为抵押物，小油菜线下审核 通过后，根据抵押物的价值融资。</p>
							<h3 class="bor_onel_tit">
								<span>申请条件</span>
							</h3>
							<ul class="bor_onel_ul">
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic01.png" alt="">年满18周岁以上的公民
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic02.png" alt="">需要北京房产或车产抵押
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic03.png" alt="">个人或企业银行征信记录良好
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic04.png" alt="">
									无现有诉讼记录</li>

							</ul>
							<h3 class="bor_onel_tit">
								<span>提交资料</span>
							</h3>
							<ul class="bor_onel_ul">
								<li>&nbsp;<img
									src="<%=path%>/foregroundSystem/images/bor_pic05.png" alt="">省份证
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic06.png" alt="">申请资料</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic07.png" alt="">其他</li>
							</ul>
						</div>
						<!-- end l -->
						<div class="bor_det_oner fl">
							<form method="post" action="<%=path%>/Borrow/BorrowMoney.action"
								id="demoform3">
								<fieldset>
									<div>
										<label>申请人</label> <input type="text"
											style="padding-left: 20px;"
											value="${fn:substring(user.pname,0,1)}**" readonly="readonly"
											class="bor_inputbg04 input2"> <input type="hidden"
											name="tid" value="${user.userid }">
									</div>
									<div class="mt15">
										<label>*借款金额</label> <input type=""
											class="bor_inputbg04 input2" name="b_money"
											style="padding-left: 20px;" placeholder="请输入金额"
											datatype="n4-7" errormsg="范围在4~7位数之间！">
									</div>
									<div class="mt15">
										<label>*借款期限(月)</label> <input type=""
											class="bor_inputbg04 input2" name="borrowqx"
											style="padding-left: 20px;" placeholder="请输入借款期限"
											datatype="n1-2" errormsg="请输入1-2位数字">
									</div>
									<div class="mt15">
										<label>*借款类型</label> <input type="" value="信用贷款"
											class="bor_inputbg04 input2" style="padding-left: 20px;"
											name="borrow_type" readonly="readonly">
									</div>
									<div class="mt15 guarmethod clearfix">
										<label class="guarmethod_l fl">*担保方式</label>
									</div>
									<div class="mt15">
										<label>*每月收入</label> <input type="text" name="dbw"
											style="padding-left: 20px;" class="bor_inputbg03 input2"
											placeholder="请输入每月收入" datatype="n" errormsg="请输入每月收入">
									</div>
									<div class="mt15">
										<label>*工作单位</label> <input type="text"
											class="bor_inputbg04 input2" name="dbx"
											style="padding-left: 20px;" placeholder="请输入工作单位"
											datatype="*" errormsg="请输入工作单位">
									</div>
									<div class="mt15">
										<label>*还款方式</label> <select name="repayment"
											class="bor_inputbg04 input2">
											<option>--请选择还款方式--</option>
											<option value="等额本息">等额本息</option>
											<option value="等额本金">等额本金</option>
										</select>
									</div>
									<div class="mt15">
										<label>*借款用途</label> <input type="text" name="borrow_yt"
											class="bor_inputbg04 input2" style="padding-left: 20px;"
											placeholder="请输入借款用途" datatype="*" errormsg="请输入借款用途">
									</div>
									<div class="mt15">
										<label>*借款描述</label>
										<textarea name="borrow_sm"
											style="padding-left: 20px;width: 250px;"
											placeholder="请输入借款描述" datatype="*" errormsg="请输入借款描述"></textarea>
									</div>
									<div class="mt15">
										<label>*验证码</label> <input type="text" id="PictureCheckCode3"
											onblur="checkcode(3)" style="width:166px;padding-left: 20px;"
											class="input" name="yzm" data-msg="验证码" maxlength="4"
											tabindex="1" autocomplete="off" placeholder="请输入验证码">
										<img id="PictureCheck3" src="<%=path%>/Getcode.action"
											onclick="myReload(3);" style="cursor:pointer;" />

									</div>
									<div class="mt30">
										<label></label> <a href="#" class="bor_btn"
											onclick="$('#s3').click();alert('提交成功,请等待审核>即将跳转至我的账户!');">提交材料</a>
										<input type="submit" style="display: none;" id="s3">
									</div>
								</fieldset>
							</form>
						</div>
					</div>
					<!-- end  -->
					<div class="bor_det_one clearfix pt30 pb30" style="display:none;">
						<div class="bor_det_onel fl">
							<p class="bor_p1">中兴财富平台的借款功能旨在帮助借款用户以 低成本获得借款。用户在需要资金时，可以将
								自有房产和车产作为抵押物，小油菜线下审核 通过后，根据抵押物的价值融资。</p>
							<p class="bor_p2">中兴财富平台的借款功能旨在帮助借款用户以 低成本获得借款。用户在需要资金时，可以将
								自有房产和车产作为抵押物，小油菜线下审核 通过后，根据抵押物的价值融资。</p>
							<h3 class="bor_onel_tit">
								<span>申请条件</span>
							</h3>
							<ul class="bor_onel_ul">
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic01.png" alt="">年满18周岁以上的公民
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic02.png" alt="">需要北京房产或车产抵押
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic03.png" alt="">个人或企业银行征信记录良好
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic04.png" alt="">
									无现有诉讼记录</li>

							</ul>
							<h3 class="bor_onel_tit">
								<span>提交资料</span>
							</h3>
							<ul class="bor_onel_ul">
								<li>&nbsp;<img
									src="<%=path%>/foregroundSystem/images/bor_pic05.png" alt="">省份证
								</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic06.png" alt="">申请资料</li>
								<li><img
									src="<%=path%>/foregroundSystem/images/bor_pic07.png" alt="">其他</li>
							</ul>
						</div>
						<!-- end l -->
						<div class="bor_det_oner fl">
							<form method="post" action="<%=path%>/Borrow/BorrowMoney.action"
								id="demoform4">
								<fieldset>
									<div>
										<label>申请人</label> <input type="text"
											style="padding-left: 20px;"
											value="${fn:substring(user.pname,0,1)}**" readonly="readonly"
											class="bor_inputbg03 input2"> <input type="hidden"
											name="tid" value="${user.userid }">
									</div>
									<div class="mt15">
										<label>*借款金额</label> <input type="text"
											class="bor_inputbg03 input2" name="b_money"
											style="padding-left: 20px;" placeholder="请输入金额"
											datatype="n4-7" errormsg="范围在4~7位数之间！">
									</div>
									<div class="mt15">
										<label>*借款期限(月)</label> <input type=""
											class="bor_inputbg03 input2" name="borrowqx"
											style="padding-left: 20px;" placeholder="请输入借款期限"
											datatype="n1-2" errormsg="请输入1-2位数字">
									</div>
									<div class="mt15">
										<label>*借款类型</label> <input type="" value="零首付车贷"
											style="padding-left: 20px;" name="borrow_type"
											class="bor_inputbg03 input2" readonly="readonly">
									</div>
									<div class="mt15 guarmethod clearfix">
										<label class="guarmethod_l fl">*担保方式</label>
									</div>
									<div class="mt15">
										<label>*每月收入</label> <input type="text" name="dbw"
											style="padding-left: 20px;" class="bor_inputbg03 input2"
											placeholder="请输入每月收入" datatype="n" errormsg="请输入每月收入">
									</div>
									<div class="mt15">
										<label>*工作单位</label> <input type="text"
											class="bor_inputbg04 input2" name="dbx"
											style="padding-left: 20px;" placeholder="请输入工作单位"
											datatype="*" errormsg="请输入工作单位">
									</div>
									<div class="mt15">
										<label>*还款方式</label> <select name="repayment"
											class="bor_inputbg03 input2">
											<option>--请选择还款方式--</option>
											<option value="等额本息">等额本息</option>
											<option value="等额本金">等额本金</option>
										</select>
									</div>
									<div class="mt15">
										<label>*借款用途</label> <input type="" name="borrow_yt"
											class="bor_inputbg03 input2" style="padding-left: 20px;"
											placeholder="请输入借款用途" datatype="*" errormsg="请输入借款用途">
									</div>
									<div class="mt15">
										<label>*借款描述</label>
										<textarea name="borrow_sm"
											style="padding-left: 20px;width: 250px;"
											placeholder="请输入借款描述" datatype="*" errormsg="请输入借款描述"></textarea>
									</div>
									<div class="mt15">
										<label>*验证码</label> <input type="text" id="PictureCheckCode4"
											placeholder="请输入验证码" onblur="checkcode(4);"
											style="width:166px;padding-left: 20px;" class="input"
											name="yzm" data-msg="验证码" maxlength="4" tabindex="1"
											autocomplete="off"> <img id="PictureCheck4"
											src="<%=path%>/Getcode.action" style="cursor:pointer;"
											onclick="myReload(4);" />
									</div>
									<div class="mt30">
										<label></label> <a href="#" class="bor_btn"
											onclick="$('#s4').click();alert('提交成功,请等待审核>即将跳转至我的账户!');">提交材料</a>
										<input type="submit" style="display: none;" id="s4">
									</div>
								</fieldset>
							</form>
						</div>
					</div>
					<!-- end  -->
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
	<!-- 遮罩层 -->
	<div id="mask" class="mask"></div>
	<script type="text/javascript">
		function checkcode(val) {
			var code = $("#PictureCheckCode" + val).val();
			var path = $("#path").val();
			$.post(path + "/getsession.action", {}, function(data) {
				if (data.session != code) {
					alert("验证码错误！");
					$("#PictureCheckCode").val("");
				}
			}, "json");
		}
		function myReload(val) {
			document.getElementById("PictureCheck" + val).src = document.getElementById("PictureCheck" + val).src + "?nocache=" + new Date().getTime();
		}
		//显示弹出框
		$(function() {
			if ('${user.username}' == '' && '${user.zsname}' == '') {
				$("#mask").css("height", $(document).height());
				$("#mask").css("width", $(document).width());
				$("#mask").show();
				if (confirm('您未登录!')) {
					location.href = '<%=path%>/foregroundSystem/login.jsp';
				} else {
					location.href = '<%=path%>/foregroundSystem/login.jsp';
				}
			}
			if ('${user.zsname}' == '' && '${user.username}' != '') {
				$("#mask").css("height", $(document).height());
				$("#mask").css("width", $(document).width());
				$("#mask").show();
				if (confirm('您未绑定个人信息!')) {
					location.href = '<%=path%>/foregroundSystem/personal_zhanghushezhi.jsp';
				} else {
					location.href = '<%=path%>/foregroundSystem/personal_zhanghushezhi.jsp';
				}
			}
			//表单验证功能
			$("#demoform1").Validform({
				tiptype : 4
			});
			$("#demoform2").Validform({
				tiptype : 4
			});
			$("#demoform3").Validform({
				tiptype : 4
			});
			$("#demoform4").Validform({
				tiptype : 4
			});
		});
	</script>


</body>
</html>

