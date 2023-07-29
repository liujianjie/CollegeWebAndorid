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
					修改职位
				</h4>
			</div>
			<div class="modal-body">
					<form class="form-horizontal" role="form" id="myform">
						<input type = "hidden" value = "${deptId }" id = "deptId" name="deptId">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">职位编号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="plaid" readOnly="true"
									value = "${deptId }"  >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">职位名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"  
									   placeholder="请输入内容"  id = "deptName" name="deptName" >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">所在部门</label>
							<div class="col-sm-10" id = "departmentshowplace">
								
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10" >
								<button  class="btn btn-default" id="update" onclick = "updatedept();">确认修改</button>
							</div>
						</div>
					</form>
			</div>
			
		</div>
	</div>
</body>
<script>
	var departId = 1;
	$(function() {
		getAlldept();
		getCla(1);
	})
	function updatedept(){
		var dname = $("#deptName").val();
		if(dname == ""){
			alert("不能为空值");
			$("#deptName").focus();
		}else{
			var id = $("#deptId").val();
			$.ajax({
				url : "bkdept/updatedept.action",
				type : "post",
				data : $("#myform").serialize(),
				dataType : "text",
				success : function(data) {
					var paths = "<%=basePath%>front/deptlist.jsp";
					window.location.href = paths;
				}
			});
		}
	}
	function getAlldept(){
		$.ajax({
			  url:"bkdepartment/getDepartmentMore.action",
			  type:"post",
			  data:"",
			  dataType:"json",
			  success:function(data){
			  	var list = data;
			  	var dptselectstr = '<select  name = "departmentId" id="departmentId">';
				for(var i in list){
					var zhi = list[i];
					var id = zhi.departmentId;	
					var name = zhi.departmentName;
					dptselectstr += "<option value='"+id+"'>"+name+"</option>";
				}
				dptselectstr+="</select>";
				$("#departmentshowplace").html(dptselectstr);
				$("#departmentId").find("option[value = '"+departId+"']").attr("selected","selected");
			  }
		});
	}
	function getCla(nowPage) {
		$.ajax({
			url : "bkdept/getDeptOne.action",
			type : "post",
			dataType : "json",
			data : {
				"deptId" : ${deptId}
			},
			success : function(data) {
				var name = data.deptName;
				if(name != ""){
					$("#deptName").val(name);
					departId = data.department.departmentId;
				}
			}
		});
	}
</script>
</html>
