<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="textml;charset=UTF-8">
	<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript">
		function addNotice() {
			window.location.href = "${pageContext.request.contextPath}/admin/goods/add.jsp";
		}
	</script>
	
</head>
<body>
<br/>
<form id="Form1" name="Form1" action="" method="post">
	<table cellSpacing="1" cellPadding="0" width="100%" align="center" 
	  bgColor="#f5fafe" border="0">
		<tbody>
		  	<tr>
		  		<td class="ta_01" align="center" bgColor="#afd1f3">
		  			<strong>图书列表</strong>
		  		</td>
		  	</tr>
		  	<tr>
			  	<td class="ta_01" align="right">
			  		<button type="button" id="add" name="add" value="&#28155;&#21152;"
			  				class="button_add" onclick="addNotice()">
			  			&#28155;&#21152;
			  		</button>
			  	</td>
		  	</tr>
		  	
			<tr>
		  		<td class="ta_01" align="center" bgColor="#f5fafe">
		  			<table cellspacing="0" 
				  			cellpadding="1" 
				  			rules="all"
				  			bordercolor="gray" 
				  			border="1" 
				  			id="DataGrid1"
				  			style="BORDER-RIGHT:gray 1px solid;
				  			BORDER-TOP:gray 1px solid;
				  			BORDER-LEFT:gray 1px solid;
				  			WIDTH:100%;
				  			WORD-BREAK:break-all;
				  			BORDER-BOTTOM:gray 1px solid;
				  			BORDER-COLLAPSE:collapse;
				  			BACKGROUND-COLOR:#f5fafe;
				  			WORD-WRAP:break-word">
				  			
			  			<tr style="FONT-WEIGHT:bold; FONT-SIZE:12pt; HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
			  				<td align="center" width="12%">图书编号</td>
			  				<td align="center" width="12%">图书名</td>
			  				<td align="center" width="24%">图书价格</td>
			  				<td align="center" width="8%">图书图片</td>
			  				<td align="center" width="8%">编辑</td>
			  				<td align="center" width="8%">删除</td>
			  			</tr>
	  			
				  		<c:forEach items="${books}" var="book">
				  		
					  	<tr>
					  		<td style="CURSOR:hand; HEIGHT:22px" align="center" width="23%">${book.id}</td>
					  		<td style="CURSOR:hand; HEIGHT:22px" align="center" width="18%">${book.name}</td>
					  		<td style="CURSOR:hand; HEIGHT:22px" align="center" width="8%">${book.price}</td>		
					  		<td style="CURSOR:hand; HEIGHT:22px" align="center" width="8%">
					  		<img width="80" height="80" src="${pageContext.request.contextPath}/bookimage/${book.pic}"></td>	
					  		<td style="CURSOR:hand; HEIGHT:22px" align="center" width="8%">
						  		<a href="${pageContext.request.contextPath}/FindByIdGoodsServlet?id=${book.id}">
						  			<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR:hand">
						  		</a>			
					  		</td>
					  		
					  		<td style="CURSOR:hand; HEIGHT:22px" align="center" width="8%">
				  				<a href="${pageContext.request.contextPath}/DeleGoodsServlet?id=${book.id}">
				  				<img src="${pageContext.request.contextPath}/images/i_del.gif"
				  					width="16" height="16" border="0" style="CURSOR:hand">
				  				</a>
				  			</td>	
				  			
				  		</tr>
				  		
				  		</c:forEach>
				  		
	  				</table>
	  				
	  			</td>
			</tr>
		</tbody>
	</table>
</form> 			
</body>
</html>