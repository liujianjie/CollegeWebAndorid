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
<script src="<%=basePath%>/js/jquery-2.1.4.min.js"></script>

<link href="<%=basePath%>css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="<%=basePath%>css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
<link href="<%=basePath%>css/iCheck/custom.css" rel="stylesheet">
<link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
<link href="<%=basePath%>css/style.min.css?v=3.2.0" rel="stylesheet">
<script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body>
	<div class="middle-box text-center loginscreen   animated fadeInDown">
			<div>
				<div>
					<h1 class="logo-name"></h1>
				</div>
				<h3>欢迎注册 </h3>
				<p>后台员工注册:</p>
				<form action="bkuser/bgregister.action" id="dd" method="post"
				class="form">
					<div class="form-group">
						<input type="text" class="form-control" name="staffUserName" placeholder="请输入用户名" required="">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="staffUserPwd" placeholder="请输入密码" required="">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="请再次输入密码" required="">
					</div>
					<div class="form-group" id = "departmenttd">
						
					</div>
					<div class="form-group" id = "depttdplace">
						
					</div>
					<div class="form-group text-left">
						<div class="checkbox i-checks">
							<label class="no-padding">
								<input type="checkbox"><i></i> 我同意注册协议</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary block full-width m-b"  onclick="sh();">注 册</button>
					<p class="text-muted text-center"><small>已经有账户了？</small><a href="back/bkLogin.jsp">点此登录</a>
					</p>

				</form>
			</div>
		</div>
	 <!-- 全局js -->
    <script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js?v=3.4.0"></script>
    <!-- iCheck -->
    <script src="<%=basePath%>js/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
	
	
	<script type="text/javascript">
		var deparid = 1;//默认1
		$(function(){
			$.ajax({
				  url:"<%=basePath%>bkuser/getDepartmentList.action",
				  type:"post",
				  data:"",
				  dataType:"json",
				  success:function(data){
				  	var list = data.list;
				  	var dptselectstr = '<select onchange="changedepar(this);" class="form-control" required="" name = "Department.departmentName" id="departmentName">';
				  	if(list.length > 0 ){
					  	for(var i in list){
							if(i == 1){
								deparid = zhi.departmentId;
							}
							var zhi = list[i];
							var id = zhi.departmentId;	
							var name = zhi.departmentName;
							dptselectstr += "<option id = '"+id+"'>"+name+"</option>";
						}
				  	}else{
						dptselectstr += "<option></option>";
					}
					dptselectstr+="</select>";
					$("#departmenttd").html(dptselectstr);
					//$("<option value='1'>1111</option>").appendTo("#Department.departmentName")//添加下拉框的option
				  }
			});
				$.ajax({
					  url:"<%=basePath%>bkdept/getDeptListBydeparid.action",
					  type:"post",
					  data:{"departmentId" : deparid},
					  dataType:"json",
					  success:function(data){
					  	var list = data;
					  	var dptselectstr = '<select name = "staDeptId" class="form-control" required="" id="staDeptId">';
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
			if(deparid < 0 || deparid != ""){
				$.ajax({
					  url:"<%=basePath%>bkdept/getDeptListBydeparid.action",
					  type:"post",
					  data:{"departmentId" : deparid},
					  dataType:"json",
					  success:function(data){
					  	var list = data;
					  	var dptselectstr = '<select name = "staDeptId" class="form-control" required="" id="BkloginUser.staDeptId">';
					  	if(list.length > 0 ){
							for(var i in list){
								var zhi = list[i];
								var id = zhi.deptId;	
								var name = zhi.deptName;
								dptselectstr += "<option value = '"+id+"'>"+name+"</option>";
							}
						}else{
							dptselectstr += "<option></option>";
						}
						dptselectstr+="</select>";
						$("#depttdplace").html(dptselectstr);
					  }
				});
			}
		}
	</script>
</body>
</html>
