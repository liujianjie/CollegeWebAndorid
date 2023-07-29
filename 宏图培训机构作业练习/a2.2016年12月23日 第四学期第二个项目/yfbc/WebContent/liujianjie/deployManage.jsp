<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>H+ 后台主题UI框架 - 基础表格</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <!-- js -->
	<jsp:include page="PublicJsp.jsp"></jsp:include>
</head>

<body class="gray-bg">
	<br>
	<% Object user=session.getAttribute("user");%>
	<div class="wrapper wrapper-content animated fadeInRight">
	    <div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<button class="btn btn-primary btn-outline"
					href="#modal-form" data-toggle="modal">新增流程</button>
				<br>	
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>流程部署管理</h5>
					</div>
					<div class="ibox-content">
						 <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>流程名称</th>
                                    <th>部署时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${deploymentList }" var="de" varStatus="var">
                                <tr>
                                    <td>
                                    	${de.id }
                                    </td>
                                    <td>
                                  	  	${de.name }
                                    </td>
                                    <td>
                                    	<fmt:formatDate value="${de.deploymentTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                                    </td>
                                    <td>
                                    	<a href="${pageContext.request.contextPath }/activity/deletedeploy.do?id=${de.id}" class="btn btn-white btn-sm"><i
												class="fa fa-pencil"></i>
											删除
										</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
					</div>
				</div>
			</div>
	
			<div class="col-sm-1"></div>
		</div>
	</div>
	<form action="${pageContext.request.contextPath }/activity/adddeploy.do" method="post" method="post" enctype="multipart/form-data">
	<div id="modal-form" class="modal fade" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
            	<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">选择文件</h4>
                </div>
                <div class="modal-body">
					<div class="form-group">
						<label class="col-sm-3 control-label">选择zip文件:</label>
						<div class="col-sm-6">
							<input type="file" name="deployFile" class="form-control">
						</div>
					</div>
				</div>
				<div class="modal-footer">
                    <button id="subtn" class="btn btn-primary" type="submit" >上传</button>
                </div>
            </div>
        </div>
    </div>
	</form>

</body>

</html>