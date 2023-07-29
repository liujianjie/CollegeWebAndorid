<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int row = Integer.valueOf(request.getParameter("row"));
	    int col = Integer.valueOf(request.getParameter("col"));
	%>
	<p>row:<%=row %></p>
	<p>col:<%=col %></p>
	<table border="1">
		<%
			for(int i = 1; i <= row; i++){
		%>
			<tr>
			<%
				for(int j = 1; j <= col; j++){
			%>
				<td><%=i %>*<%=j %>=<%=i*j %></td>
			<%			
				}
			%>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>