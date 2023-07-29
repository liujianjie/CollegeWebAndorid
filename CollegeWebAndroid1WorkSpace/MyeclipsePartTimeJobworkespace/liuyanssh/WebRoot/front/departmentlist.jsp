<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'class.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"
	type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
</head>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>

<body>
	<!-- 添加操作 -->
	<!--         <button type='button' class='btn btn-primary add' data-toggle='modal' data-target='#myadd' >添加</button>
 -->
 	<button type='button' class='btn btn-primary del' data-toggle='button' onclick = "add();">添加</button>
	<table class="table table-striped">
		<caption>部门管理</caption>
		<thead>
			<tr>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="mytbody">

		</tbody>
	</table>
	<!-- 分页信息 -->
	共
	<span id="totalPage"></span>页，当前是第
	<span id="nowPage"></span>页，
	<a href="javascript:(0)" id="prePage">上一页</a>，
	<a href="javascript:(0)" id="nextPage">下一页</a>

	
</body>
</html>
<script>
	var gradeinfo;
	var teacherinfo;
	//页面加载时同时加载年级信息
	$(function() {
		getCla(1);
		getGradeInfo();
		getTeacherInfo();

	})
	
	function getCla(nowPage) {
		$.ajax({
			url : "<%=basePath%>bkdepartment/getAlldepartment.action",
			type : "post",
			dataType : "json",
			data : {
				"page.nowPage" : nowPage
			},
			success : function(data) {
				var datalist = data.list;
				//每次加载之前清空当前页面数据
				$("#mytbody").html("");
				var tr = "";
				for (var i = 0; i < datalist.length; i++) {
					tr += "<tr>"
					tr += "<td>" + datalist[i].departmentId + "</td>"
					tr += "<td>" + datalist[i].departmentName + "</td>"
					tr += "<td><button type='button' value='"+datalist[i].departmentId+"' class='btn btn-primary update' data-toggle='modal' data-target='#myModal' id='" + datalist[i].departmentId + "' onclick='toupdate(this);'>修改</button>";
					tr += "<button type='button' value='"+datalist[i].departmentName+"' class='btn btn-primary del' data-toggle='button' id='" + datalist[i].departmentId + "' onclick = 'del(this);'> 删除</button></td>";
					tr += "</tr>"
				}
				$("#mytbody").append(tr);

				$("#totalPage").html(data.totalPage);
				$("#nowPage").html(data.nowPage)
			}
		})

	}
	function toupdate(bt){
		var btid = bt.id;
		location.href = "bkdepartment/toupdatedepart.action?departmentId="+btid;
	}
	function add(){
		var paths = "<%=basePath%>front/departmentadd.jsp";
		location.href = paths;
	}

	//删除
	function del(bt){
		if (confirm("确定删除?")) {
			$.ajax({
				url : "<%=basePath%>bkdepartment/delDepartmentOne.action",
				type : "post",
				dataType : "text",
				data : {
					"department.departmentId" : bt.id,
					"departmentId" : bt.id,
					"department.departmentName":bt.value,
				},
				success : function(data) {
					alert(data);
					//删除成功后,重新加载当前页面数据（table）
					var nowPage = parseInt($("#nowPage").html());
					getCla(nowPage);
				}
			});
		} else {
			return false;
		}
	}

	//点击上一页时事件  
	$("#prePage").click(function() {
		var prePage = parseInt($("#nowPage").html()) - 1;
		if (prePage < 1) {
			alert("当前已经是首页");
			prePage = 1
		}
		//重新加载上一页数据
		getCla(prePage);
	})
	//点击下一页时事件
	$("#nextPage").click(function() {
		var nextPage = parseInt($("#nowPage").html()) + 1;
		var totalPage = parseInt($("#totalPage").html())
		if (nextPage > totalPage) {
			alert("当前已经是最后一页");
			nextPage = totalPage
		}
		//重新加载下一页数据
		getCla(nextPage);
	})
</script>
