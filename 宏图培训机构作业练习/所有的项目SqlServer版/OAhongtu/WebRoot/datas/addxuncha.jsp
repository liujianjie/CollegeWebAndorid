<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addxuncha.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css"
			href="TimePick/jquery.datetimepicker.css" />
		
   
  </head>
  
  <body>
    <jsp:include page="common.jsp"></jsp:include>
    <div class="ch-container">
			<div class="row">

				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">班级巡查</a>
							</li>
						</ul>
					</div>
   <form action="liulirong/addxuncha.action" method="post">
   
    <div class="row">
			<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-th-list"></i> 巡查管理
						</h2>

					</div>
					<div class="box-content">
						<div class="alert alert-info" style="
							    padding-top: 7px;
							    border-bottom-width: 0px;
							    padding-bottom: 7px;
							    
							    height: 52px;
							    
							    border-top-width: 1px;
							">
						<a class="btn btn-success" id="bt1"> <i
												class="glyphicon glyphicon-edit icon-white"></i> 8:00</a>
						<a class="btn btn-success" id="bt2"> <i
												class="glyphicon glyphicon-edit icon-white"></i>11:00</a>
						<a class="btn btn-success" id="bt3"> <i
												class="glyphicon glyphicon-edit icon-white"></i>14:00</a>
						<a class="btn btn-success" id="bt4"> <i
												class="glyphicon glyphicon-edit icon-white"></i>16:00</a>
						<a class="btn btn-success" id="bt5"> <i
												class="glyphicon glyphicon-edit icon-white"></i>19:00</a>
						<a class="btn btn-success" id="bt6"> <i
												class="glyphicon glyphicon-edit icon-white"></i>20:00</a>
						<a class="btn btn-success" href="datas/listxun.jsp" style="float: right;"> <i
												class="glyphicon glyphicon-zoom-in icon-white"></i>查看巡查</a>
						</div >
						巡查人：
						<div style="height:30px;width:170px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px">
							<input type="text" name="xname" value="${teacher.ename }" disabled="disabled" class="form-control" style="width:100px;height:30px;">
						</div>
						巡查时间：
						<div style="height:30px;width:170px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;">
							<input type="text" name="xdate" id="datetimepicker" class="form-control" style="width:120px;height:30px;">
						</div>
						<div id="tab" style="display:none;margin-top:10px">
							<table
							class="table table-bordered bootstrap-datatable">
							<thead>
								<tr>
									<td>
										时间
									</td>
									<td>
										班级
									</td>
									<td>
										应到人数
									</td>
									<td>
										实到人数
									</td>
									<td>
										教室卫生
									</td>
									<td>
										任课老师
									</td>
									<td>
										任课老师是否到岗
									</td>
									<td>
										学生违纪情况
									</td>
									<td>
										任课老师是否在做教学相关事情
									</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cla}" var="cla" varStatus="i">
									<tr>
										<td class="center">
										 <input type="text" name="xtime" id="tim${i.index+1 }" class="form-control" style="width:60px;height:25px;font-size:12px">
										</td>
										<td class="center">
										 <input type="text" name="cls" value="${cla.classname }" class="form-control" style="width:80px;height:25px">
										</td>
										<td class="center">
										 <input type="text" name="xcount" class="form-control" style="width:70px;height:25px">
										</td>
										<td class="center">
										 <input type="text" name="xnumber" class="form-control" style="width:70px;height:25px">
										</td>
										<td class="center">
											<select data-rel="chosen" name="xclean" style="width:63px;">
												<option value="优秀">优秀</option>
												<option value="良好">良好</option>
												<option value="及格">及格</option>	
												<option value="较差">较差</option>								
											</select>
										</td>
										<td class="center">
										<input type="text" name="xteach" class="form-control" style="width:70px;height:25px">	
										</td>
										<td class="center">
										<label class="radio-inline">
						                    <input type="radio" name="isteach" value="是"> 是
						                </label>
						                <label class="radio-inline">
						                    <input type="radio" name="isteach" value="否"> 否
						                </label>
										</td>
										<td class="center">
										<input type="text" name="xstudent" class="form-control" style="width:100px;height:25px">
										</td>
										<td class="center"> 
										<select data-rel="chosen" name="xdoteach"  style="width:222px;">
											<option value="是">是</option>
											<option value="否">否</option>
										</select>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
								<div class="control-group">
			                  		<button type="submit" class="btn btn-default" style="margin-left:950px">提交</button>
			           			</div>
					</div>
				</div>
			</div>
			
			<!--/span-->
		</div>
	</div>
	</form> 			
	</div>
	</div>
	</div>
    <script type="text/javascript">
    	$("#bt1").click(function(){
    		var tims=document.getElementsByName("cls");
    		for(var i=0;i<tims.length;i++){
    			$("#tim"+(i+1)).val($("#bt1").text()); 
				$("#tab").slideDown(2000);
    		}
    	});
    	$("#bt2").click(function(){
    		var tims=document.getElementsByName("cls");
    		for(var i=0;i<tims.length;i++){
    			$("#tim"+(i+1)).val($("#bt2").text()); 
				$("#tab").slideDown(2000);
    		}
    	});
    	$("#bt3").click(function(){
    		var tims=document.getElementsByName("cls");
    		for(var i=0;i<tims.length;i++){
    			$("#tim"+(i+1)).val($("#bt3").text()); 
				$("#tab").slideDown(2000);
    		}
    	});
    	$("#bt4").click(function(){
    		var tims=document.getElementsByName("cls");
    		for(var i=0;i<tims.length;i++){
    			$("#tim"+(i+1)).val($("#bt4").text()); 
				$("#tab").slideDown(2000);
    		}
    	});
    	$("#bt5").click(function(){
    		var tims=document.getElementsByName("cls");
    		for(var i=0;i<tims.length;i++){
    			$("#tim"+(i+1)).val($("#bt5").text()); 
				$("#tab").slideDown(2000);
    		}
    	});
    	$("#bt6").click(function(){
    		var tims=document.getElementsByName("cls");
    		for(var i=0;i<tims.length;i++){
    			$("#tim"+(i+1)).val($("#bt6").text()); 
				$("#tab").slideDown(2000);
    		}
    	});
    </script>
    <!-- 日期类型 -->
	    <script src="TimePick/jquery.js"></script>
		<script src="TimePick/jquery.datetimepicker.js"></script>
 		 <script type="text/javascript">
			$(function(){
				$('#datetimepicker').datetimepicker({
					lang:'ch',
					timepicker:false,
					format:'Y/m/d',
					formatDate:'Y/m/d',
					
				});
			});
			
		</script>
  </body>
</html>
