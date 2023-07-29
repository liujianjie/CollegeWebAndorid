<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zuxia.model.CustomerInfo"%>
<%@page import="com.zuxia.model.CustomerDetailInfo"%>
<%@page import="com.zuxia.util.DateTimeUtil"%>
<%
CustomerInfo customer = (CustomerInfo)request.getAttribute("customer");
if(null==customer){
	response.sendRedirect("../servlet/CustomerManage");
	return;
}
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
<title>查看/修改客户信息</title>
<link style="text/csss" rel="stylesheet" href="admin/css/add_skin.css">
<link style="text/csss" rel="stylesheet" href="admin/css/common.css">
<style type="text/css">
.name_td{width:180px;}
.long_input_text{width:300px;}
#number_span{padding:3px 10px 3px 10px;font-size:120%;border:1px solid #ADAEB0;background-color:#fff;color:#ADAEB0;font-weight:bold;}
</style>
</head>
<body>
<form action="servlet/CustomerManage?op=update" method="post">
	<input type="hidden" name="id" value="<%=customer.getId()%>" />
	<div class="opDiv">
			<div class="titlebar">查看/修改客户信息</div>
	</div>
	<table class="addTable">
		<tr>
			<td class="name_td">客户编号:</td>
			<td><span id="number_span"><%=customer.getId()%></span></td>
		</tr>
		<tr>
			<td class="name_td">客户账号/邮箱:</td>
			<td><input type="text" name="email" class="long_input_text" value="<%=customer.getEmail()%>" /></td>
		</tr>
		<tr>
			<td class="name_td">注册时间</td>
			<td><%=DateTimeUtil.convertDate(customer.getRegisterTime())%></td>
		</tr>
		<tr>
			<td class="name_td">收货人姓名:</td>
			<td>
				<input type="text" maxlength="20" name="name" value="<%=detail.getName()%>" />
			</td>
		</tr>
		<tr>
			<td class="name_td">固定电话:</td>
			<td>
				<input type="text" maxlength="20" name="telphone" value="<%=detail.getTelphone()%>" />
			</td>
		</tr>
		<tr>
			<td class="name_td">移动电话:</td>
			<td>
				<input type="text" maxlength="20" name="movePhone" value="<%=detail.getMovePhone()%>" />
			</td>
		</tr>
		<tr>
			<td class="name_td">收货地址:</td>
			<td>
				<input type="text" name="address" class="long_input_text" value="<%=detail.getAddress()%>" />
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2" class="btn_td">
				<input class="btn61_21" type="submit" value="提交表单" />&nbsp;&nbsp;
				<input class="btn61_21" type="reset" value="重置表单" />&nbsp;&nbsp;
				<input class="btn61_21" type="button" onclick="window.history.go(-1);" value="返回" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>