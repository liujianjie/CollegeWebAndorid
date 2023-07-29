<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>工资历史记录</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css"
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
		onclick="location.href='toaddsalary.do'">添加工资数据</button>

	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>工资列表</h5>
					</div>
					<div class="ibox-content">
						<!-- 							表格上方start -->
							<div class="col-sm-12">
								<div class="col-sm-2">
									<input type="text" id="year" name="year" value="${year }"
										class="form-control" placeholder="请输入年份">
								</div>
								<div class="col-sm-2">
									<select class="form-control" id="month">
										<option>月份</option>
										<c:forEach begin="1" end="12" varStatus="mm">
											<c:if test="${mm.index==month}">
												<option value="${mm.index }" selected>${mm.index }
												</option>
											</c:if>
											<c:if test="${mm.index!=month}">
												<option value="${mm.index }">${mm.index }</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-2">
									<button class="btn btn-primary" onclick="salarylist2()">搜索</button>
								</div>
							</div>
							<!-- 							表格上方end -->
						<table class="table table-hover">
							<thead>
								<tr>
									<th>姓名</th>
									<th>职位</th>
									<th>基本工资</th>
									<th>提成工资</th>
									<th>奖励工资</th>
									<th>处罚金额</th>
									<th>实发工资</th>
									<th>添加时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${salaryVoList}" var="salaryVo" >
									<tr>
										<td>${salaryVo.username}</td>
										<td>${salaryVo.positionname}</td>
										<td>${salaryVo.salary.basesal}</td>
										<td>${salaryVo.salary.deduction_wage}</td>
										<td>${salaryVo.salary.bonus}</td>
										<td>${salaryVo.salary.fine}</td>
										<td>${salaryVo.salary.sfgz}</td>
										<td><fmt:formatDate value="${salaryVo.salary.time}"
												pattern="yyyy-MM-dd"></fmt:formatDate></td>
										<td class="project-actions">...</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- 		start 页脚	 -->
			<div class="col-sm-1"></div>
			<div class="btn-group col-sm-8">
				共${totalRow }条记录 ${currPage }/${totalPage }页

				<div class="col-sm-2">
					<input type="text" id="pageCount" value="${pageCount }" class="form-control" />
				</div>
				<a><button type="button" id="btn1" onclick="salarylist(this);" class="btn btn-white">
					<i class="fa fa-chevron-left"></i>
				</button></a>
				<c:if test="${currPage-3>0}">
					<a><button id="btn2" onclick="salarylist(this);" class="btn btn-white">${currPage-3}</button></a>
				</c:if>
				<c:if test="${currPage-2>0}">
					<a><button id="btn3" onclick="salarylist(this);" class="btn btn-white">${currPage-2}</button></a>
				</c:if>
				<c:if test="${currPage-1>0}">
					<a><button id="btn4" onclick="salarylist(this);" class="btn btn-white">${currPage-1}</button></a>
				</c:if>
				<a><button id="btn5" onclick="salarylist(this);" class="btn btn-white  active">${currPage}</button></a>
				<c:if test="${currPage+1<=totalPage}">
					<a><button id="btn6" onclick="salarylist(this);" class="btn btn-white">${currPage+1}</button></a>
				</c:if>
				<c:if test="${currPage+2<=totalPage}">
					<a><button id="btn7" onclick="salarylist(this);" class="btn btn-white">${currPage+2}</button></a>
				</c:if>
				<c:if test="${currPage+3<=totalPage}">
					<a><button id="btn8" onclick="salarylist(this);" class="btn btn-white">${currPage+3}</button></a>
				</c:if>
				<a><button type="button" id="btn9" onclick="salarylist(this);" class="btn btn-white">
					<i class="fa fa-chevron-right"></i>
				</button></a>
			</div>
			<!-- 		end 页脚	 -->
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
<!-- 		柱状图 start-->
		<div class="row">
		<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>柱状图</h5>
					</div>
					<div class="ibox-content">
						<!-- 							表格上方start -->
						<div class="col-sm-12">
							<div class="col-sm-2">
								<input type="text" id="year2" name="year2" value="2016"
									class="form-control" placeholder="请输入年份">
							</div>
							<div class="col-sm-2">
								<button class="btn btn-primary" onclick="selchart()">搜索</button>
							</div>
						</div>
						<!-- 							表格上方end -->
						<div class="echarts" id="echarts-bar-chart"></div>
					</div>
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
		<!-- 		柱状图 end-->
	</div>


	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>
<!-- ECharts -->
	<script
		src="${pageContext.request.contextPath}/js/plugins/echarts/echarts-all.js"></script>

	<!-- iCheck -->
	<script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
<script>
	
		function salarylist(btn) {
			var id=btn.id;
			var pageCount=document.getElementById("pageCount").value;
			var currPage=${currPage};
			var year =document.getElementById("year").value;
			var month =document.getElementById("month").value;
			var url="salarylist.do?pageCount="+pageCount+"&currPage=";
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
			location.href=url+"&year="+year+"&month="+month+"&v=0";
		}
		function salarylist2() {
			var pageCount=document.getElementById("pageCount").value;
			var currPage=${currPage};
			var year =document.getElementById("year").value;
			var month =document.getElementById("month").value;
			location.href="salarylist.do?pageCount="+pageCount+"&currPage="+currPage+"&year="+year+"&month="+month;
		}
	</script>
	<script>
		function selchart() {
			var year = document.getElementById("year2").value;
			var month = document.getElementById("month").value;
			$.post("${pageContext.request.contextPath}/salary/selchart.do", {
				"year" : year
			}, function(data) {
				console.log(data);
				var list = [];
				list[0] = data.month1;
				list[1] = data.month2;
				list[2] = data.month3;
				list[3] = data.month4;
				list[4] = data.month5;
				list[5] = data.month6;
				list[6] = data.month7;
				list[7] = data.month8;
				list[8] = data.month9;
				list[9] = data.month10;
				list[10] = data.month11;
				list[11] = data.month12;
				createChart(year + "年每月发放工资", list);
			}, "json");

		}

		function createChart(charttitle, list) {
			var i = echarts.init(document.getElementById("echarts-bar-chart"));
			var q = {
				title : {
					text : charttitle
				},
				tooltip : {
					trigger : "axis"
				},
				legend : {
					data : [ "月发放工资总额" ]
				},
				grid : {
					x : 30,
					x2 : 40,
					y2 : 24
				},
				calculable : true,
				xAxis : [ {
					type : "category",
					data : [ "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月",
							"9月", "10月", "11月", "12月" ]
				} ],
				yAxis : [ {
					type : "value"
				} ],
				series : [ {
					name : "工资总额",
					type : "bar",
					data : [ list[0], list[1], list[2], list[3], list[4],
							list[5], list[6], list[7], list[8], list[9],
							list[10], list[11] ]
				} ]
			};
			i.setOption(q);
			window.onresize = i.resize;
		}
	</script>
	<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});
		});
	</script>


</body>

</html>