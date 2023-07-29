<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link href="foregroundSystem/css/common.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="foregroundSystem/css/user.css" />
<script type="text/javascript"
	src="foregroundSystem/script/jquery.min.js"></script>
<script type="text/javascript" src="foregroundSystem/script/common.js"></script>
<script src="foregroundSystem/script/user.js" type="text/javascript"></script>
<script type="text/javascript"
	src="foregroundSystem/My97DatePicker/WdatePicker.js"></script>
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
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
							<img src="foregroundSystem/images/code.png">
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
				<a class="" href="<%=path%>/foregroundSystem/index.jsp"> <img
					src="foregroundSystem/images/logo.png" title="">
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
				<img src="foregroundSystem/images/clist1.jpg" width="1200"
					height="96">
			</div>
			<div id="personal-left" class="personal-left">
				<ul>
					<li><span><a href="<%=path%>/SelHuiKuan.action"><i
								class="dot dot1"></i>账户总览</a></span></li>
					<li class="pleft-cur"><span><a
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
				<div class="personal-money">
					<h3>
						<i>资金记录</i>
					</h3>
					<div class="money-choose">
						<form action="<%=path%>/mr_list.action" method="post">
							<span class="money-date2">查询时间</span>
							<div id="select-date" class="select-date">
								<input type="text" class="deposite-txt" name="sel_time"
									onclick="WdatePicker();" readonly="readonly" />
							</div>
							<input type="submit" value="筛选"
								class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-sx" />
							<button onclick="createExcel();" type="button" value="导出"
								class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-dc">
								<span class="ui-button-text ui-c">导出</span>
							</button>
							<input type="button" value="查看收益"
								onclick="location.href='<%=path %>/SelMoneyRecordByID.action?p_userid=${user.userid }'"
								class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-sx" />
						</form>
					</div>
					<div class="personal-moneylist">
						<div class="pmain-contitle">
							<span class="pmain-title1 fb">交易时间</span> <span
								class="pmain-title2 fb">交易类型</span> <span
								class="pmain-title3 fb">交易金额</span> <span
								class="pmain-title4 fb">余额</span> <span class="pmain-title5 fb">备注</span>
						</div>
						<ul>
							<c:forEach items="${mr_list}" var="list">
								<li><span class="pmain-title1 pmain-height"> <fmt:formatDate
											value="${list.m_happentime }" pattern="yyyy-MM-dd" />
								</span> <span class="pmain-title2 pmain-height"> ${list.m_jytype }</span>
									<span class="pmain-title3 pmain-height">${list.m_dsmoney }</span>
									<span class="pmain-title4 pmain-height">${list.m_kymoney }</span>
									<span class="pmain-title5 pmain-height">${list.m_remark }</span>
								</li>
								<!-- <div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;"> <img src="foregroundSystem/images/nondata.png" width="60" height="60"><br>
                <br>
                暂无资金记录</div>-->

								<!-- <div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;"> <img src="foregroundSystem/images/nondata.png" width="60" height="60"><br>
                <br>
                暂无资金记录</div>-->
							</c:forEach>
						</ul>
					</div>
					<div class="pmain-contitle">
						共 ${totalRow } 条 <a href="mr_list.action?cPage=1 ">首页</a> <a
							href="mr_list.action?cPage=${currPage-1 }">上一页</a> <a
							href="mr_list.action?cPage=1">1</a> <a
							href="mr_list.action?cPage=2">2</a> <a
							href="mr_list.action?cPage=3">3</a> <a
							href="mr_list.action?cPage=${currPage+1 }">下一页</a> <a
							href="mr_list.action?cPage=${totalPage }">末页</a>
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
							src="foregroundSystem/images/code.png" style="display: inline;"></span>
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

	<script type="text/javascript">
		function createExcel() {
			location.href = "createexcel.action"
		}
	</script>

</body>
</html>
