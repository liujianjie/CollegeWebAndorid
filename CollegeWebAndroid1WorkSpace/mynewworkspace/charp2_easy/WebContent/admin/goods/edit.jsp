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
<form name="Form1" action="${pageContext.request.contextPath}/EditBooksServlet?id=${book.id}" method="post">
	<table cellSpacing="1" cellPadding="5" width="100%" align="center" 
	  bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
				<strong>修改商品</strong>
			</td>
		</tr>
		<tr>
			<td class="ta_01" align="center" bgColor="#f5fafe" >商品名称：</td>
			<td class="ta_01" colSpan="4" bgColor="#ffffff" >
				<input type="text" name="name" class="bg" maxlength="15" value="${book.name}"/> 
			</td>
		</tr>
		<tr>
			<td class="ta_01" align="center" bgColor="#f5fafe" >商品价格：</td>
			<td class="ta_01" colSpan="3" bgColor="#ffffff" >
				<textarea name="price" cols="30" rows="3" style="WIDTH: 96%" >${book.price}</textarea>
			</td>
		</tr>
		<tr>
			<td class="sep1" align="center" colSpan="4" >
				<img src="${pageContext.request.contextPath}/images/shim.gif">
			</td>
		</tr>
		<tr>
			<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
				<input type="submit" class="button_ok" value="确定">
				<font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
				<input type="reset" class="button_cancel" value="重置">
				<font face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
				<input type="button" class="button_ok" value="返回" onclick="history.go(-1)">
				<span id="Labell"></span>
			</td>
		</tr>
	</table>
</form>
</body>
</html>