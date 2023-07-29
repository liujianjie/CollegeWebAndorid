<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>奖惩历史记录</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description" content="">

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
	<br>
	<button class="btn btn-primary btn-outline"
		onclick="location.href='tosel.do'">新建记录</button>

	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>奖惩记录</h5>
					</div>
					<div class="ibox-content">
					<!-- 							表格上方start -->
							<div class="col-sm-12">
							<form action=""></form>
							<div class="col-sm-2">
								<select class="form-control m-b" id="positionid">
									<option value="">岗位</option>
									<c:forEach items="${posList }" var="pos">
									<c:if test="${pos.id ==positionid}">
											<option value="${pos.id }" selected>${pos.pname}</option>
										</c:if>
										<c:if test="${pos.id !=positionid}">
											<option value="${pos.id }">${pos.pname }</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<select class="form-control m-b" id="warehouseid">
									<option value="">仓库</option>
									<c:forEach items="${warehouseList }" var="warehouse">
										<c:if test="${warehouse.whid==warehouseid}">
											<option value="${warehouse.whid}" selected>${warehouse.whiname }</option>
										</c:if>
										<c:if test="${warehouse.whid!=warehouseid}">
											<option value="${warehouse.whid }">${warehouse.whiname }</option>
										</c:if>
										
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<input type="text" id="year" name="year" value="${year }"
									class="form-control" placeholder="请输入年份">
							</div>
							<div class="col-sm-2">
								<select class="form-control" id="month" name="month">
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
										<button class="btn btn-primary" onclick="getRpvolist();">搜索</button>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<div class="row"></div>
							</div>
						</div>
						<!-- 							表格上方end -->
						<!-- 						表格数据start	 -->
						<table class="table table-hover">
							<thead>
								<tr>
									<th>姓名</th>
									<th>奖励工资</th>
									<th>奖励原因</th>
									<th>处罚金额</th>
									<th>处罚原因</th>
									<th>记录时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="tbody">
								<c:forEach items="${rpvolist}" var="rpvo" >
									<tr>
										<td>${rpvo.username}</td>
										<td>${rpvo.rp.bonus}</td>
										<td>${rpvo.rp.bonus_cause}</td>
										<td>${rpvo.rp.fine}</td>
										<td>${rpvo.rp.fine_cause}</td>
										<td><fmt:formatDate value="${rpvo.rp.recordtime}"
												pattern="yyyy-MM-dd"></fmt:formatDate></td>
										<td class="project-actions">...</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- 						表格数据end	 -->
					</div>
					<!-- 		start 页脚	 -->
			<div class="col-sm-1"></div>
			<div class="btn-group col-sm-8">
				共${totalRow }条记录 ${currPage }/${totalPage }页

				<div class="col-sm-2">
					<input type="text" id="pageCount" value="${pageCount }" class="form-control" />
				</div>
				<a><button type="button" id="btn1" onclick="rplist(this);" class="btn btn-white">
					<i class="fa fa-chevron-left"></i>
				</button></a>
				<c:if test="${currPage-3>0}">
					<a><button id="btn2" onclick="rplist(this);" class="btn btn-white">${currPage-3}</button></a>
				</c:if>
				<c:if test="${currPage-2>0}">
					<a><button id="btn3" onclick="rplist(this);" class="btn btn-white">${currPage-2}</button></a>
				</c:if>
				<c:if test="${currPage-1>0}">
					<a><button id="btn4" onclick="rplist(this);" class="btn btn-white">${currPage-1}</button></a>
				</c:if>
				<a><button id="btn5" onclick="rplist(this);" class="btn btn-white  active">${currPage}</button></a>
				<c:if test="${currPage+1<=totalPage}">
					<a><button id="btn6" onclick="rplist(this);" class="btn btn-white">${currPage+1}</button></a>
				</c:if>
				<c:if test="${currPage+2<=totalPage}">
					<a><button id="btn7" onclick="rplist(this);" class="btn btn-white">${currPage+2}</button></a>
				</c:if>
				<c:if test="${currPage+3<=totalPage}">
					<a><button id="btn8" onclick="rplist(this);" class="btn btn-white">${currPage+3}</button></a>
				</c:if>
				<a><button type="button" id="btn9" onclick="rplist(this);" class="btn btn-white">
					<i class="fa fa-chevron-right"></i>
				</button></a>
			</div>
			<!-- 		end 页脚	 -->
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>


	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>

<!-- iCheck -->
	<script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
	<script>
		function rplist(btn) {
			var id=btn.id;
			var pageCount=document.getElementById("pageCount").value;
			var currPage=${currPage};
			var positionid =document.getElementById("positionid").value;
			var warehouseid =document.getElementById("warehouseid").value;
			var year =document.getElementById("year").value;
			var month =document.getElementById("month").value;
			var url="selrewards_penaltieslist.do?pageCount="+pageCount+"&currPage=";
			if(id=="btn1"||id=="btn4"){
				url+=(currPage-1);
			}else if(id=="btn2"){
				url+=(currPage-3);
			}else if(id=="btn3"){
				url+=(currPage-2);
			}else if(id=="btn5"){
				url+=currPage;
			}else if(id=="btn7"){
				url+=(currPage+2);
			}else if(id=="btn8"){
				url+=(currPage+3);
			}else if(id=="btn9"||id=="btn6"){
				url+=(currPage+1);
			}
			location.href=url+"&positionid="+positionid+"&warehouseid="+warehouseid+"&year="+year+"&month="+month+"&v=0";
		}
	</script>
	<script>
	/*
	时间格式化工具
	把Long类型的yyyy-MM-dd日期还原yyyy-MM-dd格式日期 
*/
function dateFormatUtil(longTypeDate){
	var dateTypeDate = "";
	var date = new Date();
	date.setTime(longTypeDate);
	dateTypeDate += date.getFullYear();   //年
	dateTypeDate += "-" + getMonth(date); //月 
	dateTypeDate += "-" + getDay(date);   //日
	return dateTypeDate;
}

//返回 01-12 的月份值 
function getMonth(date){
	var month = "";
	month = date.getMonth() + 1; //getMonth()得到的月份是0-11
	if(month<10){
		month = "0" + month;
	}
	return month;
}

//返回01-30的日期
function getDay(date){
	var day = "";
	day = date.getDate();
	if(day<10){
		day = "0" + day;
	}
	return day;
}
	
	/*查询用户list  start*/
		function getRpvolist(){
			var pageCount=document.getElementById("pageCount").value;
			var currPage=${currPage};
			var positionid =$("#positionid").val();
			var warehouseid =$("#warehouseid").val();
			var year =document.getElementById("year").value;
			var month =$("#month").val();
			$.post("getjson.do",{
				"positionid":positionid,
				"warehouseid":warehouseid,
				"pageCount":pageCount,
				"currPage":currPage,
				"year":year,
				"month":month
				},function(data){
				var rpvolist=data.rpvolist;
				var str="";
				$.each(rpvolist,function(index,rpvo){
					var time=dateFormatUtil(rpvo.rp.recordtime);
					if(rpvo.rp.bonus_cause==null){
						rpvo.rp.bonus_cause="";
					}
					if(rpvo.rp.fine_cause==null){
						rpvo.rp.fine_cause="";
					}
					var tr="<tr>";
					tr+="<td>"+rpvo.username+"</td>";
					tr+="<td>"+rpvo.rp.bonus+"</td>";
					tr+="<td>"+rpvo.rp.bonus_cause+"</td>";
					tr+="<td>"+rpvo.rp.fine+"</td>";
					tr+="<td>"+rpvo.rp.fine_cause+"</td>";
					tr+="<td>"+time+"</td>";
					tr+="<td class='project-actions'>...</td>";
					tr+="</tr>";
					str+=tr;
				});
				$("#tbody").html(str);
			},"json");
		}
		/*查询用户list  end*/
		
	</script>
</body>

</html>