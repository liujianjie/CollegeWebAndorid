<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>车辆信息修改</title>
<meta name="keywords" content="">
<meta name="description">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js">
</script> 
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-0">
				<button class="btn btn-outline btn-primary dim" onclick="location.href='javascript:history.go(-1);'"><i class="fa fa-reply"></i> 返回</button>
			</div>
			<div class="col-sm-12">
			<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>修改车辆信息</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="signupForm" action="updcars.do" method="post" >
								
								<div class="form-group">
								<input type="hidden" value="${cars.id }" name="id"/>
									<label class="col-sm-3 control-label">车辆型号名称：</label>
									<div class="col-sm-6">
										<input id="carsname" name="carsname" class="form-control"
											type="text" value="${cars.carsname }"> <span class="help-block m-b-none"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">车辆载重：</label>
									<div class="col-sm-6">
										<input id="carsweight" name="carsweight" class="form-control"
											type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${cars.carsweight }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">车辆容积：</label>
									<div class="col-sm-6">
										<input id="carscubage" name="carscubage" class="form-control"
											type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${cars.carscubage }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">车牌号：</label>
									<div class="col-sm-6">
										<input id="carsnum" name="carsnum" class="form-control"
											type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${cars.carsnum }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">发动机号：</label>
									<div class="col-sm-6">
										<input id="carsenginenum" name="carsenginenum" class="form-control"
											type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${cars.carsenginenum }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">保险单号：</label>
									<div class="col-sm-6">
										<input id="carsinsurancenum" name="carsinsurancenum" class="form-control"
											type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${cars.carsinsurancenum }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">购买日期：</label>
									<div class="col-sm-6">
										<input id="carsbuydate" name="carsbuydate" class="form-control"
											onclick="WdatePicker();" value="<fmt:formatDate value="${cars.carsbuydate}" pattern="YYYY-MM-dd"/>"
											type="text" readonly="readonly"aria-required="true" aria-invalid="false"
											class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">隶属仓库：</label>
									<div class="col-sm-6">
										 <select class="form-control m-b" name="warehouseid">
										 	<option>--请选择仓库--</option>
										 	<c:forEach items="${warehouses }" var="warehouse">
	                                        	<option value="${warehouse.whid }"${warehouse.whid == cars.warehouseid ?'selected':''}>${warehouse.whiname }</option>
	                                        </c:forEach>
                                   		 </select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">车辆状态：</label>
									<div class="col-sm-6">
										<select class="form-control m-b" name="carsisvacancy">
												<option>--请选择车辆状态--</option>
												<option value="0" ${0== cars.carsisvacancy ?'selected':''} >空闲</option>
	                                        	<option value="1" ${1== cars.carsisvacancy ?'selected':''}>在途</option>
	                                       		<option value="0" ${2== cars.carsisvacancy ?'selected':''}>维修</option>
                                   		 </select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-8">
									<button class="btn btn-primary" type="submit">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>
									<button class="btn btn-success" type="reset">&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>

	<!-- 自定义js -->
	<script src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>

	<!-- jQuery Validation plugin javascript-->
	<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/validate/messages_zh.min.js"></script>
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
		
	</script>


</body>

</html>