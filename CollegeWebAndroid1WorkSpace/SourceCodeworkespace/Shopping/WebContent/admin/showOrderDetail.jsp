<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zuxia.model.OrderInfo"%>
<%@page import="com.zuxia.util.DateTimeUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.zuxia.model.OrderGoodsInfo"%>
<%@page import="com.zuxia.model.GoodsInfo"%>
<%@page import="com.zuxia.model.CustomerInfo"%>
<%@page import="com.zuxia.model.CustomerDetailInfo"%>
<%
OrderInfo order = (OrderInfo)request.getAttribute("order");
ArrayList<OrderGoodsInfo> orderGoodsList = order.getOrderDetails();
CustomerInfo customer = order.getCustomerInfo();
CustomerDetailInfo detail = customer.getDetailInfo();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
out.println("<base href=\""+basePath+"\">");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示订单详细信息</title>
<link style="text/csss" rel="stylesheet" href="admin/css/add_skin.css">
<link style="text/csss" rel="stylesheet" href="admin/css/data_manage.css">
<link style="text/csss" rel="stylesheet" href="admin/css/common.css">
<style type="text/css">
.name_td{width:120px;}
.addTable td{height:10px;}
#dataTable_div{height:200px;overflow-y:scroll;border-bottom:1px dashed #CBCCCE;}
</style>
</head>
<body>
	<div class="opDiv">
		<div class="titlebar">订单详细信息</div>
	</div>
	<table class="addTable">
		<tr>
			<td class="name_td">订单编号:</td>
			<td><%=order.getOrderId()%></td>
			<td class="name_td">订单状态:</td>
			<td><%=order.getStatus()==0?"未确认":"已确认"%></td>
			<td class="name_td">下单时间:</td>
			<td colspan="3"><%=DateTimeUtil.convertDate(order.getOrderTime())%></td>
		</tr>
		<tr>
			<td class="name_td">客户编号:</td>
			<td><%=customer.getId()%></td>
			<td class="name_td">客户账户/邮箱:</td>
			<td>
				<a href="servlet/CustomerManage?op=toEdit&id=<%=customer.getId()%>">
					<%=customer.getEmail()%></a>
			</td>
			<td class="name_td">注册时间:</td>
			<td><%=DateTimeUtil.convertDate(customer.getRegisterTime())%></td>
		</tr>
		<tr>
			<td class="name_td">收货人姓名:</td>
			<td><%=detail.getName()%></td>
			<td class="name_td">固定电话:</td>
			<td><%=detail.getTelphone()%></td>
			<td class="name_td">移动电话:</td>
			<td><%=detail.getMovePhone()%></td>
		</tr>
		<tr>
			<td class="name_td">收货地址:</td>
			<td colspan="5"><%=detail.getAddress()%></td>
		</tr>
	</table>
	<div id="dataTable_div">
		<table id="dataTable">
			<tr>
				<th>商品编号</th>
				<th>商品类别</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>商品折扣</th>
				<th>订购数量</th>
				<th>小计</th>
			</tr>
			<%
			GoodsInfo goods = null;
			OrderGoodsInfo orderGoods = null;
			double sumPrice = 0.0;
			double price = 0.0;
			for(int i=0;i<orderGoodsList.size();i++){
				orderGoods = orderGoodsList.get(i);
				goods = orderGoods.getGoodsInfo();
				price = orderGoods.getQuantity()*goods.getPrice()*goods.getDiscount()/10;
				sumPrice += price;
			%>
			<tr>
				<td><%=goods.getGoodsId()%></td>
				<td>
					<a href="servlet/GoodsTypeManage?op=toEdit&id=<%=goods.getGoodsType().getTypeId()%>">
						<%=goods.getGoodsType().getTypeName()%></a>
				</td>
				<td>
					<a href="servlet/GoodsManage?op=toEdit&id=<%=goods.getGoodsId()%>"><%=goods.getGoodsName()%></a>
				</td>
				<td>&yen;<%=goods.getPrice()%></td>
				<td><%=goods.getDiscount()==10?"-":goods.getDiscount()%></td>
				<td><%=orderGoods.getQuantity()%></td>
				<td><%=price%></td>
			</tr>
			<%}%>
			<tr>
				<td>总金额：</td>
				<td colspan="6">&yen;&nbsp;<%=sumPrice%></td>
			</tr>
		</table>
	</div>
	<div style="margin-top:20px;padding-right:20px;text-align: right;">
		<input class="btn61_21" type="button" onclick="window.history.back();" value="返回" />
	</div>
</body>
</html>