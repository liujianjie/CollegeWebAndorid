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
		<caption>职位管理</caption>
		<thead>
			<tr>
				<th>职位编号</th>
				<th>职位名称</th>
				<th>所属部门</th>
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
<script>
	var gradeinfo;
	var teacherinfo;
	//页面加载时同时加载年级信息
	$(function() {
		getCla(1);
		getGradeInfo();
		getTeacherInfo();

	})
	
	function add(){
		var paths = "<%=basePath%>front/deptadd.jsp";
		location.href = paths;
	}
	
	function getCla(nowPage) {
		$.ajax({
			url : "<%=basePath%>bkdept/getAlldept.action",
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
					tr += "<td>" + datalist[i].deptId + "</td>"
					tr += "<td>" + datalist[i].deptName + "</td>"
					tr += "<td>" + datalist[i].departmentName + "</td>"
					tr += "<td><button type='button' value='"+datalist[i].deptId+"' class='btn btn-primary update' data-toggle='modal' data-target='#myModal' id='" + datalist[i].deptId + "' onclick='toupdate(this);'>修改</button>";
					tr += "<button type='button' class='btn btn-primary del' data-toggle='button' id='" + datalist[i].deptId + "'> 删除</button>";
					tr += "<button type='button' class='btn btn-primary' data-toggle='button' id='" + datalist[i].deptId + "' onclick='gojiedian(this);'> 权限</button></td>";
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
		location.href = "bkdept/toupdatedept.action?deptId="+btid;
	}
	
	function gojiedian(bt){
		var btid = bt.id;
		location.href = "bkdept/toPremiss.action?deptId="+btid;
	}

	//删除
	$("#mytbody").on("click", ".del", function() {
		if (confirm("确定删除?")) {
			$.ajax({
				url : "<%=basePath%>delCla.action",
				type : "post",
				dataType : "text",
				data : {
					"tabClasses.tabClassesId" : this.id
				},
				success : function(data) {
					//删除成功后,重新加载当前页面数据（table）
					var nowPage = parseInt($("#nowPage").html());

					getCla(nowPage);
				}
			})
		} else {
			return false;
		}
	})

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

</html>
