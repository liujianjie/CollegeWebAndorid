<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<jsp:include page="PublicJsp.jsp"></jsp:include>
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>H+ 后台主题UI框架 - 基础表格</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
	<!-- js -->
	<jsp:include page="PublicJsp.jsp"></jsp:include>

</head>

<body class="gray-bg">
	<%
		Object user = session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("login.jsp");
		}
	%>	
	<!-- 还有时间要选择 -->
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<button type="button" class="btn btn-primary dim" onclick="location.href='javascript:history.go(-1);'">返回</button>
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>新建入库计划单</h5>
					</div>
					<div class="ibox-content">
						<form id="signupForm" action="${pageContext.request.contextPath}/instorage/add.do" method="post" enctype="multipart/form-data" class="form-horizontal m-t" >
							<div class="form-group">
								<label class="col-sm-4 control-label">请选择xls文件：</label>
								<div class="col-sm-6">
									<div class="uploader white">
										<input type="text" class="filename" readonly="readonly">
										<input type="button" class="button" value="上传..."> <input
												type="file" name="files" id="files" size="30"
												accept=".xls, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel">
										
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">仓库名称：</label>
								<div class="col-sm-5">
									<select class="form-control m-b" name="whid" id="whid">
						    			<c:forEach items="${warelist }" var="war">
						    				<c:if test="${war.whid==user.warehouseid }">
						    					<option value="${war.whid }">${war.whiname }</option>
						    				</c:if>
						    			</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-8">
									<button class="btn btn-primary" type="submit">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
    <script>
		$.validator.setDefaults({
			highlight : function(a) {
				$(a).closest(".form-group").removeClass("has-success")
						.addClass("has-error")
			},
			success : function(a) {
				a.closest(".form-group").removeClass("has-error").addClass(
						"has-success")
			},
			errorElement : "span",
			errorPlacement : function(a, b) {
				if (b.is(":radio") || b.is(":checkbox")) {
					a.appendTo(b.parent().parent().parent())
				} else {
					a.appendTo(b.parent())
				}
			},
			errorClass : "help-block m-b-none",
			validClass : "help-block m-b-none"
		});
		$().ready(function() {
			$("#commentForm").validate();
			var a = "<i class='fa fa-times-circle'></i> ";

			$("#signupForm").validate({
				rules : {
					whid : "required",
					files　: "required"
				},
				messages : {
					whid : a + "请选择仓库",
					files : a + "请选择excel文件"
				}
			});
		});
	</script>

</body>
</html>