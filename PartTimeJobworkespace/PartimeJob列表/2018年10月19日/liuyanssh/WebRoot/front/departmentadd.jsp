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
					添加部门
				</h4>
			</div>
			<div class="modal-body">
					<form class="form-horizontal" role="form" id="myform">
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">部门名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" 
									   placeholder="请输入名称" id = "departmentName" name="department.departmentName" >
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button  class="btn btn-default" id="" onclick = "add();">添加</button>
							</div>
						</div>
					</form>
			</div>
			
		</div>
	</div>
	
</body>
<script>
	function add(){
		$.ajax({
			url : "bkdepartment/addDepartment.action",
			type : "post",
			dataType : "json",
			data : $("#myform").serialize(),
			success : function(data) {
				if(data){
					var paths = "<%=basePath%>front/departmentlist.jsp";
					window.location.href = paths;
				}else{
					alert("存在错误");
				}
			}
		});
	}

</script>
</html>

