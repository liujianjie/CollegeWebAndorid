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
<link rel="icon" href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	mce_href="<%=path%>/foregroundSystem/images/s27188837.jpg"
	type="image/x-icon">
</head>
<body>

	<div class="pmain-profile">
		<div class="pmain-connent">
			<div id="pmain-contab" class="pmain-contab">
				<ul>
					<li id="pmain-contab1" class="on">借款类型1</li>
					<li id="pmain-contab2">借款类型2</li>
					<li id="pmain-contab3">借款类型3</li>
					<li class="li-other"></li>
				</ul>
			</div>
			<div class="pmain-conmain" id="pmain-conmain">
				<div class="pmain-conmain1">
					<div class="pmain-contitle">
						<span class="pmain-titletype">编号</span><span
							class="pmain-titletype">标题</span><span class="pmain-titletype">借款金额</span><span
							class="pmain-titletype">年利率</span><span class="pmain-titletype">状态</span><span
							class="pmain-titletype">操作</span>
					</div>
					<ul style="float:center;">
						<c:forEach items="${map.bomlist }" var="bom" varStatus="v">
							<li><span class="pmain-titletype">${v.index+1 }</span><span
								class="pmain-titletype">${bom.borrow_bt }</span><span
								class="pmain-titletype">${bom.b_money }</span><span
								class="pmain-titletype">${bom.rate }</span><span
								class="pmain-titletype">${bom.statu }</span><span
								class="pmain-titletype">查看详情</span></li>
						</c:forEach>
						<!--<div style=" width:
								760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
								 <img src="images/nondata.png" width="60" height="60"><br><br>
								   暂无回款计划</div>-->
					</ul>
					<div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
				</div>
				<div class="pmain-conmain2" style=" display:none;">
					<div class="pmain-contitle">
						<span class="pmain-titledate">交易时间</span><span class="pmain-w100">类型</span><span
							class="pmain-w120">交易金额</span><span class="pmain-w120">余额</span><span
							class="pmain-w200">备注</span>
					</div>
					<ul style="float:left;">
						<li><span class="pmain-titledate">2015-10-20</span><span
							class="pmain-w100">债权转让</span><span
							class="pmain-w120 pmain-money">10.00</span><span
							class="pmain-w120 pmain-money">10.00</span><span
							class="pmain-w200">备注</span></li>
						<!--<div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
								 <img src="images/nondata.png" width="60" height="60"><br><br>
								   暂无资金记录</div>-->
					</ul>
					<div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
				</div>
				<div class="pmain-conmain3" style=" display:none;">
					<div class="pmain-contitle">
						<span class="pmain-titledate">交易时间</span><span class="pmain-w210">投标类型</span><span
							class="pmain-w80">状态</span><span class="pmain-whb200">投标金额</span><span
							class="pmain-whb110">总收益</span>
					</div>
					<ul style="float:left;">
						<c:forEach items="${list }" var="list">
							<li><span class="pmain-titledate"><fmt:formatDate
										value="${list.tender_time }" pattern="yyyy-MM-dd" /></span><span
								class="pmain-w210">${list.tender_type }</span><span
								class="pmain-w80 pmain-money">${list.tender_statu }</span><span
								class="pmain-whb200 pmain-money">${list.tender_money }</span><span
								class="pmain-whb110">${list.tender_interest}</span></li>
							<!--	<div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
								    <img src="images/nondata.png" width="60" height="60"><br><br>
								   暂无投资记录</div>-->
						</c:forEach>
					</ul>
					<div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
