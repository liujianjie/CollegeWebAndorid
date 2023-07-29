<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - FooTable</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link href="../backgroundSystem/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link href="../backgroundSystem/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link href="../backgroundSystem/css/plugins/footable/footable.core.css"
	rel="stylesheet">

<link href="../backgroundSystem/css/animate.min.css" rel="stylesheet">
<link href="../backgroundSystem/css/style.min.css?v=3.2.0"
	rel="stylesheet">
<link href="../backgroundSystem/css/plugins/switchery/switchery.css" rel="stylesheet">
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>前台用户上传资料表</h5>

						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="table_foo_table.jsp#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="table_foo_table.jsp#">选项 01</a></li>
								<li><a href="table_foo_table.jsp#">选项 02</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
					<div class="col-sm-3">
						<input type="text" class="form-control input-sm m-b-xs " id="filter"
                                   placeholder="输入信息搜索">
                          </div>
						<table class="footable table table-stripped" data-filter=#filter
							data-page-size="8">
							<thead>
								<tr>
									<th data-toggle="true">编号</th>
									<th>用户ID</th>
									<th>用户名</th>
									<th>真实姓名</th>
									<th>证件种类</th>
									<th>图片状态</th>
									<th>上传时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="ren" varStatus="index">
								<input type="hidden" name="userid" value="${ttz.tid }">
									<tr>
										<td>${index.index+1 }</td>
										<td>${ren.ttzuser.userid }</td>
										<td>${ren.ttzuser.username}</td>
										<td>${ren.ttzuser.zsname}</td>
										<td>${ren.rtype }</td>
										<td>
											<c:if test="${ren.rimage != '' && ren.rimage != null }">
												已上传
											</c:if>
											<c:if test="${ren.rimage == '' || ren.rimage == null }">
												未上传
											</c:if>
										</td>
										<td><fmt:formatDate value="${ren.rdate }" pattern="YYYY-MM-DD hh:mm:ss"/></td>
										<td><a data-toggle="modal" data-target="#myModal" onclick="showimage('${pageContext.request.contextPath}/upload/${ren.rimage}')"><i
												class="fa fa-check text-navy" ></i>查看图片</a></td>
									</tr>
								</c:forEach>

							</tbody>
							<tfoot>
								<tr>
									<td colspan="8">
										<ul class="pagination pull-right"></ul>
									</td>
								</tr>
							</tfoot>
						</table>

					</div>
				</div>
			</div>
		</div>
		
		
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">查看图片</h4>
                </div>
                <div class="modal-body">
                    <div class="input-group colorpicker-component demo demo-auto">
                        <img id="imageshow" src="${pageContext.request.contextPath}/upload/null.jpg">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
		<!-- 全局js -->
		<script src="../backgroundSystem/js/jquery-2.1.1.min.js"></script>
		<script src="../backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>
		<script
			src="../backgroundSystem/js/plugins/footable/footable.all.min.js"></script>

		<!-- 自定义js -->
		<script src="../backgroundSystem/js/content.min.js?v=1.0.0"></script>
		 <script src="../backgroundSystem/js/plugins/switchery/switchery.js"></script>
		<script>
			$(document).ready(function() {
				$('.footable').footable();
				$('.footable2').footable();
			});
		</script>

		<script type="text/javascript">
			function submits(index){
				$("#form"+index).submit();
			}
			function showimage(img){
			
				$("#imageshow").attr("src",img);
			}
		</script>
</body>

</html>