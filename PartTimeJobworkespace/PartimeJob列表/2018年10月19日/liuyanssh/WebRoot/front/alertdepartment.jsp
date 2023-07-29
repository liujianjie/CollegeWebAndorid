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
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改部门
				</h4>
			</div>
			<div class="modal-body">
					<form class="form-horizontal" role="form" id="myform">
						<input type = "hidden" value = "${departmentId }" id = "departmentId" name="department.departmentId">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">部门编号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="plaid" readOnly="true"
									value = "${departmentId }"  >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">部门名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" 
									   placeholder="请输入内容" id = "departmentName" name="department.departmentName" >
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button  class="btn btn-default" id="" onclick = "updatedepartments();">确认修改</button>
							</div>
						</div>
					</form>
			</div>
			
		</div>
	</div>
	
</body>
<script>
	$(function() {
		getCla(1);

	})
	function getCla(nowPage) {
		$.ajax({
			url : "bkdepartment/getDepartmentOne.action",
			type : "post",
			dataType : "json",
			data : {
				"departmentId" : ${departmentId}
			},
			success : function(data) {
				var name = data.departmentName;
				if(name != ""){
					$("#departmentName").val(name);
				}
			}
		});
	}
	function updatedepartments(){
		var dname = $("#departmentName").val();
		if(dname == ""){
			alert("不能为空值");
			$("#departmentName").focus();
		}else{
			var id = $("#departmentId").val();
			$.ajax({
				url : "bkdepartment/updatedepartment.action",
				type : "post",
				data : {"department.departmentId":id,"department.departmentName":dname},
				dataType : "text",
				success : function(data) {
					var paths = "<%=basePath%>front/departmentlist.jsp";
					window.location.href = paths;
				}
			});
		}
	}
</script>
</html>

