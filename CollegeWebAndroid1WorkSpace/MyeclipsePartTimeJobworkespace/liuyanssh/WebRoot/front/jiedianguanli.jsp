<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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

<link href="${pageContext.request.contextPath }/backgroundSystem/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/backgroundSystem/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <!-- Sweet Alert -->
    <link href="${pageContext.request.contextPath }/backgroundSystem/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath }/backgroundSystem/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/backgroundSystem/css/style.min.css?v=3.2.0" rel="stylesheet">
	
	<!-- check -->
	<link href="${pageContext.request.contextPath }/backgroundSystem/css/plugins/iCheck/custom.css" rel="stylesheet">    
        <!-- 全局js -->
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/content.min.js?v=1.0.0"></script>

    <!-- Sweet alert -->
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/plugins/sweetalert/sweetalert.min.js"></script>

	<!-- iCheck -->
    <script src="${pageContext.request.contextPath }/backgroundSystem/js/plugins/iCheck/icheck.min.js"></script>
</head>

<body class="gray-bg">
	<input type="hidden" name="deptId" id="deptId" value="${deptId }"/>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>权限分配</h5>
					</div>
					<div class="ibox-content">
						<!-- 隐藏域 用户id -->
						<input type="hidden" id="userid" name="userid" value="${userid }" />
						<table class="table table-hover" align="center">
							<thead>
								<tr height="50" align="center">
									<td width="30%"><b>模块名称</b></td>
									<td><b>子模块</b></td>
								</tr>
							</thead>
							<tbody id="tbody">
								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="1" class="i-checks"
										${fn:contains(userperlist,'1')?'checked':'' }>基本信息维护 
									</td>
									<td><input type="checkbox" id="" name="checks" value="2" class="i-checks"
										${fn:contains(userperlist,'2')?'checked':'' }>评论管理
										<input type="checkbox" id="" name="checks" value="3" class="i-checks"
										${fn:contains(userperlist,'3')?'checked':'' }>统计管理
									</td>
								</tr>

								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="4" class="i-checks"
										${fn:contains(userperlist,'4')?'checked':'' }>管理员管理 
									</td>
									<td><input type="checkbox" id="" name="checks" value="5" class="i-checks"
										${fn:contains(userperlist,'5')?'checked':'' }>职位管理
										<input type="checkbox" id="" name="checks" value="6" class="i-checks"
										${fn:contains(userperlist,'6')?'checked':'' }>部门管理
									</td>
								</tr>

								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="7" class="i-checks"
										${fn:contains(userperlist,'7')?'checked':'' }>用户管理
									</td>

									<td><input type="checkbox" id="" name="checks" value="8" class="i-checks"
										${fn:contains(userperlist,'8')?'checked':'' }>用户权限管理
								</tr>
								<tr>
									<td colspan="2">
										<button type="button" class="btn btn-primary" href="#modal-form" data-toggle="modal" onclick="updpers();">保存</button> 
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 弹出加载效果 -->
	<div id="modal-form" class="modal fade" aria-hidden="false">
        <div class="spiner-example">
            <div class="sk-spinner sk-spinner-chasing-dots">
                <div class="sk-dot1"></div>
                <div class="sk-dot2"></div>
            </div>
        </div>
         <!-- 关闭加载效果影藏 -->
    	<button id="btn1" style="display: none" class="btn btn-default" data-dismiss="modal">关闭</button>
    </div>
   
    <!-- 弹出 成功操作 -->
	<button id="btn2" style="display: none" class="btn btn-success btn-sm demo2">打开示例</button>
	<!-- 弹出失败操作 -->
	<button id="btn3" style="display: none" class="btn btn-success btn-sm demo3">打开示例</button>
	
	<!-- 多选宽 -->
	<script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
	
	<script>
		$(document).ready(function() {
			$(".demo1").click(function() {
				swal({
					title : "欢迎使用SweetAlert",
					text : "Sweet Alert 是一个替代传统的 JavaScript Alert 的漂亮提示效果。"
				})
			});$(".demo2").click(function() {
				swal({
					title : "修改成功",
					text : "",
					type : "success"
				})
			});$(".demo3").click(function() {
				swal({
					title : "修改失败",
					text : "请检查网络连接！",
					type : "warning",
				}, function() {
					swal("删除成功！", "您已经永久删除了这条信息。", "success")
				})
			});$(".demo4").click(function() {
				swal({
					title : "您确定要删除这条信息吗",
					text : "删除后将无法恢复，请谨慎操作！",
					type : "warning",
					showCancelButton : true,
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "是的，我要删除！",
					cancelButtonText : "让我再考虑一下…",
					closeOnConfirm : false,
					closeOnCancel : false
				}, function(a) {
					if (a) {
						swal("删除成功！", "您已经永久删除了这条信息。", "success")
					} else {
						swal("已取消", "您取消了删除操作！", "error")
					}
				})
			})
		});
	</script>


	<script>
		function updpers() {
			var deptId = $("#deptId").val();
			var checkssel = "";//字符串凭借
			var i=0; 
			$('input[name="checks"]:checked').each(function(){ 
				checkssel = checkssel+$(this).val()+",";
				i = i+1;
			});
			$.post("<%=basePath%>bkdept/saveDeptpermission.action", {
				deptId : deptId,
				checks : checkssel}, function(results) {
				if(results){//成功
					setTimeout("clickbtn();",1000);
				}else{//失败
					$("#btn1").click();//取消加载动画
					$("#btn3").click();
				}
			}, "json");
		}
		function clickbtn(){
			$("#btn1").click();//取消加载动画
			$("#btn2").click();
		}
	</script>
</body>

</html>

