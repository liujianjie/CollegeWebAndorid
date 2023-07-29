<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="textml;charset=UTF-8">
	<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css"/>
</head>
<body>
<form name="Form1" action="${pageContext.request.contextPath}/BookEditServlet?id=${book.id}" method="post">
	<table  cellSpacing="0" cellPadding="0" width="100%" align="center" border="1" bordercolor="#40B9B5">
		<tr height="45">
			<td class="ta_01" align="center" bgColor=#40B9B5 colSpan="2">
				<b>修改商品</b>
			</td>
		</tr>
		<tr height="45">
			<td align="center" width="50%">商品名称：</td>
			<td width="50%">
				<input type="text" name="name" maxlength="25" value="${book.name}"/> 
			</td>
		</tr>
		<tr height="45">
			<td align="center" >商品价格：</td>
			<td>
				<input type="text" name="price" maxlength="25" value="${book.price}"/> 
			</td>
		</tr>
		<tr height="45" align="center">
			<td colspan="2">
				<input type="submit" value="确定">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="清除">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="返回" onclick="history.go(-1)">
			</td>
		</tr>
	</table>
</form>
</body>
</html>