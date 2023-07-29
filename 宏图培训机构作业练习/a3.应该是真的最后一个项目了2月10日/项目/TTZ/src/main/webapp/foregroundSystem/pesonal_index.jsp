<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	href="<%=path%>/foregroundSystem/css/user.css" />
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<script src="<%=path%>/foregroundSystem/script/user.js"
	type="text/javascript"></script>
<link href="<%=path%>/foregroundSystem/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/user.css" />
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/foregroundSystem/script/common.js"></script>
<script src="<%=path%>/foregroundSystem/script/user.js"
	type="text/javascript"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">

</head>
<body onload="load();">
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
				<a class="" href="<%=path%>/foregroundSystem/index.jsp"> <img
					src="<%=path%>/foregroundSystem/images/logo.png" title="">
				</a>
			</div>
			<ul class="top-nav fn-clear">
				<li><a href="<%=path%>/Borrow/selBorrowMoneySomeList.action">首页</a></li>
				<li><a
					href="<%=path%>/Borrow/selMoreBorrowMoneySomeList.action?cpage=1"
					class="">我要投资</a></li>
				<li><a href="<%=path%>/foregroundSystem/borrow.jsp" class="">我要借款</a></li>
				<li><a href="<%=path%>/foregroundSystem/help.jsp">安全保障</a></li>
				<li class="on"><a href="<%=path%>/SelHuiKuan.action">我的账户</a></li>
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
					<li class="pleft-cur"><span><a
							href="<%=path%>/SelHuiKuan.action"><i class="dot dot1"></i>账户总览</a></span></li>
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
				<link rel="stylesheet" type="text/css"
					href="<%=path%>/foregroundSystem/css/fileupload.less.css">
				<style type="text/css">
.ui-fileupload-choose {
	background: none;
	width: 90px;
	height: 90px;
	border: 0px none;
}

.ui-fileupload-choose input {
	width: 100%;
	height: 100%;
}

.ui-icon {
	background: none;
	width: 0px;
	height: 0px;
}
</style>
				<div class="pmain-profile">
					<div class="pmain-welcome">
						<span class="fl"><span id="outLogin">您好，</span>${user.username }!
							喝一杯茶，让心情放松一下~</span>
					</div>
					<div class="pmain-user">
						<div class="user-head">
							<span class="head-img">
								<form id="myform" method="post"
									action="${pageContext.request.contextPath}/user/uploadhead.action"
									enctype="multipart/form-data">
									<input type="hidden" value="${pageContext.request.contextPath}" 
										id="path"> <img src="<%=path%>/upload/${user.head}"
										style="width:88px;height:88px;z-index:0;" id="head"> <i
										class="headframe" style="z-index:0;" onclick="filelode();"></i>
									<input type="file" id="files" name="files" style="display:none" onchange="showimg();">
								</form>
							</span> <span class="head-icon">
								<button id="shangchuan" style="display: none;margin-left: 20px"
									onclick="submitform();">上传</button>
							</span>
						</div>
						<div class="user-info user-info1">
							<ul>
								<li>用户名<span>${user.username }</span></li>
								<li>安全级别<span><i class="safe-level"><i
											class="onlevel" style="width:40%;"></i></i></span> <a href="#">[低]</a></li>
							</ul>
						</div>
					</div>
					<div class="pmain-money">
						<ul>
							<li class="none"><span><em>账户总额</em><i id="zhze"
									class="markicon"></i><span class="arrow-show1"
									style="display:none;">可用余额</span><span class="icon-show1"
									style="display:none;"></span></span> <span class="truemoney"><i
									class="f26 fb">${user.money } </i> 元</span></li>
							<li><span><em>我的积分</em><i id="dsbx" class="markicon"></i><span
									class="arrow-show2" style="display:none;">投资的越多,积分越多!</span><span
									class="icon-show2" style="display:none;"></span></span> <span
								class="truemoney"><i class="f26 fb">${user.jifen } </i>分</span></li>
							<li><span><em>VIP等级</em><i id="ljsy" class="markicon"></i><span
									class="arrow-show3" style="display: none;">积分越多,VIP的等级越高!</span><span
									class="icon-show3" style="display: none;"></span></span> <span
								class="truemoney"><i class="f26 fb c-pink">${user.vip}
								</i> 级</span></li>
						</ul>
					</div>
				</div>
				<script type="text/javascript">
					//<![CDATA[
					$(function() {
						$("#clickHeadImage").click(function() {
							$(this).find('span').removeClass('ui-state-hover');
							document.getElementById("userPhotoUploadForm:shangchuan-btn_input").click();
						});
						var safeLevel = "低";
						if (safeLevel == "高") {
							$(".pmain-user .user-info li .safe-level .onlevel").css("background-color", "#f1483c");
						}
				
						$("#clickHeadImage span").hover(function() {
							$(this).removeClass('ui-state-hover');
						});
						var myDate = new Date();
						var h = myDate.getHours();
						if (h > 11 && h < 19) {
							$("#outLogin").html("下午好，");
						} else if (h > 18) {
							$("#outLogin").html("晚上好，");
						} else {
							$("#outLogin").html("上午好，");
						}
					});
					//]]>    
					function load() {
						if ('${statu}' == 1) {
							$('#pmain-contab1').attr('class', 'on');
							$('#bb').attr('style', 'display:none');
							$('#cc').attr('style', 'display:none');
							$('#aa').show();
						} else if ('${statu}' == 2) {
							$('#pmain-contab2').attr('class', 'on');
							$('#bb').show();
							$('#cc').attr('style', 'display:none');
							$('#aa').attr('style', 'display:none');
						} else if ('${statu}' == 3) {
							$('#pmain-contab3').attr('class', 'on');
							$('#bb').attr('style', 'display:none');
							$('#aa').attr('style', 'display:none');
							$('#cc').show();
						}
				
					}
					function filelode() {
						$("#files").click();
						$("#shangchuan").css("display", "block");
					}
					function submitform() {
						$("#myform").submit();
					}
				
					function showimg() {
						var $file = $("#files");
						var fileObj = $file[0];
						var windowURL = window.URL || window.webkitURL;
						var dataURL;
						var $img = $("#head");
				
						if (fileObj && fileObj.files && fileObj.files[0]) {
							dataURL = windowURL.createObjectURL(fileObj.files[0]);
							$img.attr('src', dataURL);
						} else {
							dataURL = $file.val();
							var imgObj = document.getElementById("head");
							// 两个坑:
							// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
							// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
							imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
							imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
				
						}
					}
				</script>
				<div class="pmain-connent">
					<div id="pmain-contab" class="pmain-contab">
						<ul>
							<li id="pmain-contab1"
								onclick="location.href='<%=path%>/SelHuiKuan.action'">回款记录</li>
							<li id="pmain-contab2"
								onclick="location.href='<%=path%>/SelMoneyRecord.action'">资金记录</li>
							<li id="pmain-contab3"
								onclick="location.href='<%=path%>/TouZiJilu.action'">投资记录</li>
							<li class="li-other"></li>
						</ul>
					</div>
					<div id="aa" class="pmain-conmain">
						<div class="pmain-conmain1">
							<div class="pmain-contitle">
								<span class="pmain-titledate">回款时间</span><span
									style="margin-left: 130px;">项目</span><span
									style="margin-left: 130px;">类型</span><span
									style="margin-left: 130px;">回款金额</span>
							</div>
							<ul style="float:left;">
								<c:forEach items="${list }" var="li">
									<li><span class="pmain-titledate"> <fmt:formatDate
												value="${li.tender_time }" pattern="yyyy-MM-dd" />
									</span><span style="margin-left: 130px;"> <c:forEach
												items="${listb }" var="lis">
													${lis.borrow_yt }
									</c:forEach>
									</span><span style="margin-left: 130px;">${li.tender_type }</span><span
										style="margin-left: 130px;">${li.tender_money }</span></li>
								</c:forEach>

								<c:if test="${empty list}">
									<div
										style=" width:
										760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
										<img src="<%=path%>/foregroundSystem/images/nondata.png"
											width="60" height="60"><br> <br> 暂无回款计划
									</div>
								</c:if>
							</ul>
							<div class="pmain-contitle" align="center">
								第${currPage }页/共 ${totalRow } 条 &nbsp;&nbsp;&nbsp;<a
									href="SelHuiKuan.action?currPage=1 ">首页</a> &nbsp;&nbsp;&nbsp;<a
									href="SelHuiKuan.action?currPage=${currPage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;<a
									href="SelHuiKuan.action?currPage=${currPage+1 }">下一页</a>&nbsp;&nbsp;&nbsp;
								<a href="SelHuiKuan.action?currPage=${totalPage }">末页</a>
							</div>
						</div>
						<div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
					</div>
					<div id="bb" class="pmain-conmain">
						<div class="pmain-conmain1">
							<div class="pmain-contitle">
								<span class="pmain-titledate" style="width: 200px;">交易时间</span><span
									class="pmain-w100" style="width: 100px;">类型</span><span
									class="pmain-w120" style="width: 100px;">交易金额</span><span
									class="pmain-w120" style="width: 152px;">余额</span><span
									class="pmain-w200" style="margin-left: 100px">备注</span>
							</div>
							<ul style="float:left;">
								<c:forEach items="${mlist }" var="m">
									<li><span class="pmain-titledate" style="width: 200px;">
											<fmt:formatDate value="${m.m_happentime }"
												pattern="yyyy-MM-dd" />
									</span><span class="pmain-w100" style="width: 100px;">${m.m_jytype }</span><span
										class="pmain-w120" style="width: 100px;"><font
											style="color: #eaa580">${m.m_yxmoney }</font></span><span
										class="pmain-w120" style="margin-left: 60px;"><font
											style="color: #eaa580">${m.m_kymoney }</font></span><span
										style="margin-left: 60px;">${m.m_remark }</span></li>
								</c:forEach>
								<c:if test="${empty mlist}">
									<div
										style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
										<img src="<%=path%>/foregroundSystem/images/nondata.png"
											width="60" height="60"><br> <br> 暂无资金记录
									</div>
								</c:if>
								<div class="pmain-contitle" align="center">
									第${currPage }页/共 ${totalRow } 条&nbsp;&nbsp;&nbsp; <a
										href="SelMoneyRecord.action?currPage=1 ">首页</a>&nbsp;&nbsp;&nbsp;
									<a href="SelMoneyRecord.action?currPage=${currPage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;<a
										href="SelMoneyRecord.action?currPage=${currPage+1 }">下一页</a>&nbsp;&nbsp;&nbsp;
									<a href="SelMoneyRecord.action?currPage=${totalPage }">末页</a>
								</div>
							</ul>
						</div>
						<div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
					</div>
					<div id="cc" class="pmain-conmain">
						<div class="pmain-conmain1">
							<div class="pmain-contitle">
								<span class="pmain-titledate">交易时间</span><span
									style="margin-left: 110px;">投标类型</span><span
									style="margin-left: 110px;">状态</span><span
									style="margin-left: 110px;">投标金额</span><span
									style="margin-left: 110px;">总收益</span>
							</div>
							<ul style="float:left;">
								<c:forEach items="${tlist }" var="tlist">
									<li><span class="pmain-titledate"><fmt:formatDate
												value="${tlist.tender_time }" pattern="yyyy-MM-dd" /></span><span
										style="margin-left: 110px;">${tlist.tender_type }</span><span
										style="margin-left: 130px;"> <c:if
												test="${tlist.tender_statu==0 }">
												<font style="color: #62e39f">投标中</font>
											</c:if> <c:if test="${tlist.tender_statu==1 }">
												<font style="color: #62e39f">收益中</font>
											</c:if> <c:if test="${tlist.tender_statu==2 }">
												<font style="color: #62e39f">已完成</font>
											</c:if> <c:if test="${tlist.tender_statu==3 }">
												<font style="color: #62e39f">回款中</font>
											</c:if> <c:if test="${tlist.tender_statu==4 }">
												<font style="color: #62e39f">已回款</font>
											</c:if>
									</span><span style="margin-left: 110px;width: 180px"><font
											style="color: #62e39f">${tlist.tender_money }</font></span><span>${tlist.tender_interest}</span></li>
								</c:forEach>
								<c:if test="${empty tlist}">
									<div
										style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
										<img src="<%=path%>/foregroundSystem/images/nondata.png"
											width="60" height="60"><br> <br> 暂无投资记录
									</div>
								</c:if>

								<div class="pmain-contitle" align="center">
									第${currPage }页/共 ${totalRow }条&nbsp;&nbsp;&nbsp; <a
										href="TouZiJilu.action?currPage=1 ">首页</a>&nbsp;&nbsp;&nbsp; <a
										href="TouZiJilu.action?currPage=${currPage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;<a
										href="TouZiJilu.action?currPage=${currPage+1 }">下一页</a>&nbsp;&nbsp;&nbsp;<a
										href="TouZiJilu.action?currPage=${totalPage }">末页</a>
								</div>

							</ul>
						</div>
						<div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
					</div>

				</div>
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
						<a href="<%=path%>/foregroundSystem/jianjie.jsp">公司简介</a><a
							href="<%=path%>/foregroundSystem/tuandui.jsp">管理团队</a><a
							href="<%=path%>/foregroundSystem/wangzhangonggao.jsp">网站公告</a>
					</dd>
				</dl>
				<dl>
					<dt>相关业务</dt>
					<dd>
						<a href="<%=path%>/foregroundSystem/list.jsp">我要投资</a><a
							href="<%=path%>/foregroundSystem/borrow.jsp">我要借款</a>
					</dd>
				</dl>
				<dl>
					<dt>帮助中心</dt>
					<dd>
						<a href="<%=path%>/foregroundSystem/help.jsp">新手入门</a><a
							href="<%=path%>/foregroundSystem/pesonal_index.jsp">我的账户</a><a
							href="<%=path%>/foregroundSystem/list.jsp">债权转让</a>
					</dd>
				</dl>
				<dl>
					<dt>联系我们</dt>
					<dd>
						<a href="<%=path%>/foregroundSystem/lianxi.jsp">联系我们</a>
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

