<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>奖惩管理</title>
<meta name="keywords" content="">
<meta name="description">

<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-0">
				<button class="btn btn-primary"
					onclick="location.href='javascript:history.go(-1);'">返回</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>奖惩记录</h5>
						</div>
						<div class="ibox-content">
							<!-- 							表格上方start -->
							<div class="col-sm-12">
							
							<div class="col-sm-2">
								<select class="form-control m-b" id="positionid">
									<option value="">岗位</option>
									<c:forEach items="${posList }" var="pos">
										<option value="${pos.id }">${pos.pname }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<select class="form-control m-b" id="warehouseid">
									<option value="">仓库</option>
									<c:forEach items="${warehouseList }" var="warehouse">
										<option value="${warehouse.whid }">${warehouse.whiname }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<input type="text" id="year" name="year" value="${year }"
									class="form-control" placeholder="请输入年份">
							</div>
							<div class="col-sm-2">
								<select class="form-control" id="m" name="m">
									<option>月份</option>
									<c:forEach begin="1" end="12" varStatus="mm">
										<c:if test="${mm.index==month}">
											<option value="${mm.index }" selected>${mm.index }</option>
										</c:if>
										<c:if test="${mm.index!=month}">
											<option value="${mm.index }">${mm.index }</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<div class="row">
									<div class="col-sm-8 col-sm-offset-0">
										<button class="btn btn-primary" onclick="getUser();">搜索</button>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="row"></div>
							</div>
						</div>
						<!-- 							表格上方end -->
						<!-- 						表格数据start	 -->
						<table class="table table-hover" id="tab">
							<thead>
								<tr>
									<th>用户姓名</th>
									<th>岗位</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="tbody">
							</tbody>
						</table>
						<!-- 						表格数据end	 -->
					</div>
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
	</div>

	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>

	<script type="text/javascript">
		/*查询用户list  start*/
		function getUser(){
			var positionid=$("#positionid");
			var warehouseid=$("#warehouseid");
			$.post("seluser.do",{"positionid":positionid.val(),"warehouseid":warehouseid.val()},function(data){
				var uservolist=data.uservolist;
				var str="";
				$.each(uservolist,function(index,uservo){
					var tr="<tr>";
					tr+="<td>"+uservo.users.username+"</td>";
					tr+="<td><input type='hidden' id=userid_"+(index+1)+" value="+uservo.users.id+">"+uservo.pname+"</td>";
					tr+="<td><button type='button' id=btn'"+(index+1)+"' class='btn btn-primary btn-sm' onclick='toadd("+(index+1)+")'>编辑</button></td>";
					tr+="</tr>";
					str+=tr;
				});
				$("#tbody").html(str);
			},"json");
		}
		/*查询用户list  end*/
		function toadd(index){
			var userid=$("#userid_"+index).val();
			location.href="toadd.do?userid="+userid;
		}
	</script>
</html>