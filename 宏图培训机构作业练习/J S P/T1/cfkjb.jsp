<%@page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
	<head><title>¾Å¾Å³Ë·¨¿Ú¾÷±í</title></head>
	<body>
		<table border="1" align="center">
			<%
				for(int i=1;i<10;i++){
				%>	
				<tr>
					<%
						for(int j=1;j<=i;j++){
							%>
							<td>
							<%out.print(j+"*"+i+"="+(i*j));
							%>
							</td>
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