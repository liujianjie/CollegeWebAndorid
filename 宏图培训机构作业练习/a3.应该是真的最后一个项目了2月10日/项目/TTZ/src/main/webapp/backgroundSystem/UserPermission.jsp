<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

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
										${fn:contains(userperlist,'1')?'checked':'' }>人员管理 
									</td>
									<td><input type="checkbox" id="" name="checks" value="2" class="i-checks"
										${fn:contains(userperlist,'2')?'checked':'' }>添加人员
										<input type="checkbox" id="" name="checks" value="3" class="i-checks"
										${fn:contains(userperlist,'3')?'checked':'' }>人员信息
										<input type="checkbox" id="" name="checks" value="4" class="i-checks"
										${fn:contains(userperlist,'4')?'checked':'' }>权限管理
										<input type="checkbox" id="" name="checks" value="5" class="i-checks"
										${fn:contains(userperlist,'5')?'checked':'' }>岗位管理
									</td>
								</tr>

								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="6" class="i-checks"
										${fn:contains(userperlist,'6')?'checked':'' }>网站会员 
									</td>
									<td><input type="checkbox" id="" name="checks" value="7" class="i-checks"
										${fn:contains(userperlist,'7')?'checked':'' }>注册会员管理
										<input type="checkbox" id="" name="checks" value="8" class="i-checks"
										${fn:contains(userperlist,'8')?'checked':'' }>会员认证管理
										<input type="checkbox" id="" name="checks" value="9" class="i-checks"
										${fn:contains(userperlist,'9')?'checked':'' }>基本资料认证
										<input type="checkbox" id="" name="checks" value="10" class="i-checks"
										${fn:contains(userperlist,'10')?'checked':'' }>新用户认证资料
										<input type="checkbox" id="" name="checks" value="11" class="i-checks"
										${fn:contains(userperlist,'11')?'checked':'' }>认证资料统计
										
									</td>
								</tr>

								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="12" class="i-checks"
										${fn:contains(userperlist,'12')?'checked':'' }>财务管理 
									</td>

									<td><input type="checkbox" id="" name="checks" value="13" class="i-checks"
										${fn:contains(userperlist,'13')?'checked':'' }>提现管理 <input
										type="checkbox" id="" name="checks" value="14" class="i-checks"
										${fn:contains(userperlist,'14')?'checked':'' }>银行卡管理 <input
										type="checkbox" id="" name="checks" value="15" class="i-checks"
										${fn:contains(userperlist,'15')?'checked':'' }>充值记录 <input
										type="checkbox" id="" name="checks" value="16" class="i-checks"
										${fn:contains(userperlist,'16')?'checked':'' }>手续费记录 <input
										type="checkbox" id="" name="checks" value="17" class="i-checks"
										${fn:contains(userperlist,'17')?'checked':'' }>交易记录</td>
								</tr>

								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="18" class="i-checks"
										${fn:contains(userperlist,'18')?'checked':'' }>借贷管理 
									</td>

									<td><input type="checkbox" id="" name="checks" value="19" class="i-checks"
										${fn:contains(userperlist,'19')?'checked':'' }>投资管理 <input
										type="checkbox" id="" name="checks" value="20" class="i-checks"
										${fn:contains(userperlist,'20')?'checked':'' }>借贷管理 

									</td>
								</tr>
								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="21" class="i-checks"
										${fn:contains(userperlist,'21')?'checked':'' }>&nbsp;设&nbsp;置&nbsp;项
									</td>

									<td><input type="checkbox" id="" name="checks" value="22" class="i-checks"
										${fn:contains(userperlist,'22')?'checked':'' }>费率设置 <input
										type="checkbox" id="" name="checks" value="23" class="i-checks"
										${fn:contains(userperlist,'23')?'checked':'' }>筹款期限设置 
									</td>
								</tr>
								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="24" class="i-checks"
										${fn:contains(userperlist,'24')?'checked':'' }>审核事项
									</td>

									<td><input type="checkbox" id="" name="checks" value="25" class="i-checks"
										${fn:contains(userperlist,'25')?'checked':'' }>借款审核 <input
										type="checkbox" id="" name="checks" value="26" class="i-checks"
										${fn:contains(userperlist,'26')?'checked':'' }>放款审核
									</td>
								</tr>
								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="27" class="i-checks"
										${fn:contains(userperlist,'27')?'checked':'' }>网站管理 
									</td>

									<td><input type="checkbox" id="" name="checks" value="28" class="i-checks"
										${fn:contains(userperlist,'28')?'checked':'' }>网站公告 

									</td>
								</tr>
								<tr height="50" align="center">
									<td><input type="checkbox" id="" name="checks" value="29" class="i-checks"
										${fn:contains(userperlist,'29')?'checked':'' }>团团转VIP团 
									</td>

									<td><input type="checkbox" id="" name="checks" value="30" class="i-checks"
										${fn:contains(userperlist,'30')?'checked':'' }>发布vip团 <input
										type="checkbox" id="" name="checks" value="31" class="i-checks"
										${fn:contains(userperlist,'31')?'checked':'' }>vip团信息 
									</td>
								</tr>
								<tr height="50" align="center">
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
			var userid = $("#userid").val();
			var a="";//字符串凭借
			var i=0; 
			$('input[name="checks"]:checked').each(function(){ 
				a = a+$(this).val()+",";
				i=i+1;
			});
			$.post("${pageContext.request.contextPath }/userper/saveuserpermission.action", {
				userid : userid,
				checks : a}, function(results) {
				var i = results.result;
				if(i==1){//成功
					setTimeout("clickbtn();",1000);
				}
				if(i==0){//失败
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
