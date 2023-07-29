<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		int score = 0;
		String name = request.getParameter("uname");
		String strClass = request.getParameter("class");
		String strinfo = strClass + ", 姓名："+name+",  ";
		
		String str1 = request.getParameter("1");
		String str2 = request.getParameter("2");
		String[] str3 = request.getParameterValues("3");
		
		if(str1 != null && "D".equals(str1)){
			score++;
		}
		
		if(str2 != null && "B".equals(str2)){
			score++;
		}
		
		if(str3 != null){
			for(int i = 0; i < str3.length; i++){
				if(str3[i].equals("A") || str3[i].equals("F")){
					score++;
				}
			}
		}
	%>
	<%=strinfo %>
	<h3>你的成绩是：<%=score * 25 %></h3>
</body>
</html>