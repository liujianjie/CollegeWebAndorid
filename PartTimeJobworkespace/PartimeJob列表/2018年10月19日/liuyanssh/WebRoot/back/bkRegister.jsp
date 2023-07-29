<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	request.setAttribute("path", path);
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台管理用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="${path }/js/jquery-2.1.4.min.js"></script>


</head>

<body>

	<div id="box">
		<h2 class="modal-title" style="color: yellow;text-align:center;">
			<span>后台员工注册:</span>
		</h2>
		<div class="state">
			<form action="bkuser/bgregister.action" id="dd" method="post"
				class="form">
				<table class="table" align = "center" width = "70%">
					<tr>
						<td>用户名:</td>
						<td><input type="text" id="" name="staffUserName"
							class="form-control" onblur="checkinfo(this,'name')"></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" id="pwd" name="staffUserPwd"
							class="form-control" onblur="checkinfo(this,'pwd')""></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><input type="password" id="repwd" class="form-control"
							onblur="checkinfo(this,'repwd')"></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td>部门:</td>
						<td id = "departmenttd">
							
						</td>
					</tr>
					<tr>
						<td>职位:</td>
						<td id = "depttdplace">
	
						</td>
					</tr>
					<tr>
						<td></td>
						<td><center>
								<input type="submit" onclick="sh()" id="sss" value="确认"
									class="btn btn-primary">
							</center></td>
						<td></td>
					</tr>
				</table>

			</form>
		</div>
	</div>
	<script type="text/javascript">
		var deparid = 1;//默认1
		$(function(){
			$.ajax({
				  url:"bkuser/getDepartmentList.action",
				  type:"post",
				  data:"",
				  dataType:"json",
				  success:function(data){
				  	var list = data.list;
				  	var dptselectstr = '<select onchange="changedepar(this);"  name = "Department.departmentName" id="departmentName">';
					for(var i in list){
						if(i == 1){
							deparid = zhi.departmentId;
						}
						var zhi = list[i];
						var id = zhi.departmentId;	
						var name = zhi.departmentName;
						dptselectstr += "<option id = '"+id+"'>"+name+"</option>";
					}
					dptselectstr+="</select>";
					$("#departmenttd").html(dptselectstr);
					//$("<option value='1'>1111</option>").appendTo("#Department.departmentName")//添加下拉框的option
				  }
			});
				$.ajax({
					  url:"bkdept/getDeptListBydeparid.action",
					  type:"post",
					  data:{"departmentId" : deparid},
					  dataType:"json",
					  success:function(data){
					  	var list = data;
					  	var dptselectstr = '<select name = "staDeptId" id="BkloginUser.staDeptId">';
						for(var i in list){
							var zhi = list[i];
							var id = zhi.deptId;	
							var name = zhi.deptName;
							dptselectstr += "<option value = '"+id+"'>"+name+"</option>";
						}
						dptselectstr+="</select>";
						$("#depttdplace").html(dptselectstr);
						//$("<option value='1'>1111</option>").appendTo("#Department.departmentName")//添加下拉框的option
					  }
				});
		});
		function changedepar(sel){
			deparid = $("#departmentName option:selected").attr("id");
			if(deparid != -1){
				$.ajax({
					  url:"bkdept/getDeptListBydeparid.action",
					  type:"post",
					  data:{"departmentId" : deparid},
					  dataType:"json",
					  success:function(data){
					  	var list = data;
					  	var dptselectstr = '<select name = "staDeptId" id="BkloginUser.staDeptId">';
						for(var i in list){
							var zhi = list[i];
							var id = zhi.deptId;	
							var name = zhi.deptName;
							dptselectstr += "<option value = '"+id+"'>"+name+"</option>";
						}
						dptselectstr+="</select>";
						$("#depttdplace").html(dptselectstr);
						//$("<option value='1'>1111</option>").appendTo("#Department.departmentName")//添加下拉框的option
					  }
				});
			}
		}
	</script>
</body>
</html>
