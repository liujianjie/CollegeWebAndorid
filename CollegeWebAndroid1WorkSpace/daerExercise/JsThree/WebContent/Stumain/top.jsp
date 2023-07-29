<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		ul{list-style:none;}
		ul li{float:left;padding:0 10px; text-align:center;line-height:14px;font-family:"微软雅黑"}
		a{text-decoration: none; color:#000;display: block;;padding:0 10px;}
		a:hover{background-color:#930;color:#fff;height:14px}
		.my{float:none; background-color:#ccc;font-size: 15px;}
		.my a:hover{color:#00f; background-color:#999;}
		.my_ul{display: none;}
		ul li:hover .my_ul{display: block;}
	</style>
</head>
<body style="background-image: url(../images/top2.jpg);background-repeat:no-repeat;">
	<div style="position:fixed; top:0px;left:310px;width:100%;height:50px;"	>
		<ul>
			<li>
				<a href="#" style="height:20px;">基本信息管理</a>
				<ul class="my_ul">
					<li class="my"><a href="../Dept/depadd.jsp" target="main" style="height:20px">部门信息添加</a></li>
					<li class="my"><a href="../Dept/depManger.jsp" target="main" style="height:20px">部门信息管理</a></li>
				</ul>
			</li>
			<li>
				<a href="#" style="height:20px;">学生信息管理</a>
				<ul class="my_ul">
					<li class="my"><a href="../Student/lookstu.jsp" target="main" style="height:20px">学生信息查询</a>
					<li class="my"><a href="../Student/addstu.jsp" target="main" style="height:20px">学生信息添加</a>
					<li class="my"><a href="../Student/updatestu.jsp" target="main" style="height:20px">学生信息修改</a>
					<li class="my"><a href="../Student/delstu.jsp" target="main" style="height:20px">学生信息删除</a>
				</ul>
			</li>
			<li>
				<a href="#" style="height:20px">系统操作</a>
			</li>
		</ul>
	</div>
</body>
</html>