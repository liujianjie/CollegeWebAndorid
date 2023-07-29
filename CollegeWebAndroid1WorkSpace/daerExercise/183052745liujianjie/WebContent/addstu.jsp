<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- usebean实例化数据库公共类 -->
	<jsp:useBean id="db" class="DB.DBUtil"></jsp:useBean>
	<form action="addstu.jsp" method="post">
		<table>
		  	<tr>
		      <td colspan="2" align="center" class="title">学生信息添加</td>
		    </tr>
		    <tr>
		      <td>学号</td>
		      <td><input type="text" name="id"/></td>
		    </tr>
		    <tr>
		      <td>姓名</td>
		      <td><input type="text" name="name"/></td>
		    </tr>
		    <tr>
		      <td>地址</td>
		      <td><input type="text" name="address"/></td>
		    </tr>
		    <tr>
		      <td>生日</td>
		      <td><input type="text" name="birthday"/></td>
		    </tr>
		    <tr>
		      <td colspan="2" align="center">
		        <input type="submit" class="btn01" value="添加">
		        <input type="reset" class="btn02" value="清除">
		      </td>
		    </tr>
	  	</table>	
	</form>
	
	<!-- 同一个页面进行添加操作 -->
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		if(id != null && name != null && address != null && birthday != null &&
				!id.equals("") && !name.equals("") && !address.equals("") && !birthday.equals("")){
			String sql = "insert into student(id, name, address, birthday)"+ 
					"values('"+id+"','"+name+"','"+address+"','"+birthday+"')";
			int c = db.udpate(sql);
			// 如果增加了一条 c是1
			if(c > 0){
				// 去增加成功页面
				response.sendRedirect("addSuc.jsp");
			}else{
				// 输出添加失败
	%>
			数据添加失败，请重新输入
	<% 
			}
		}
	%>
</body>
</html>