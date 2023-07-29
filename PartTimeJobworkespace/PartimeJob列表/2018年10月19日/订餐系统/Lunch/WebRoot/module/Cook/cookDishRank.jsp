<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cookDishRank.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		#lian,#lian2{float:left;width:45%;height:450px;overflow:scroll;}
		#re,#refew,#re2{float:left;width:55%;height:450px;overflow:scroll;}
		#d1{text-align:right}
		#fenye,#motai{text-align:center}
		#d2 tr,th{text-align:center}
		#d3 tr,th{text-align:center}
		#wancheng tr,th{text-align:center}
		#jieshu{float:left;width:100%}
	</style>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
  		$(document).ready(function(){
  			
  		});
  		function lian(obj){
  			var id=$(obj).parent().attr("id");
  			$.ajax({
  				url:"${path}/cook_cookFinishDish.action",
  				dataType:"json",
  				data:$("#"+id).serialize(),
  				type:"post",
  				success:function(data){
  				   window.location.href="${path}/cook_seeCookRank.action";
  				   $("#inform").submit();
  				}
  			});
  		}
  		function re(obj){
  			var id=$(obj).parent().attr("id");
  			$.ajax({
  				url:"${path}/cook_cookFinishRe.action",
  				dataType:"json",
  				data:$("#"+id).serialize(),
  				type:"post",
  				success:function(data){
		            window.location.href="${path}/cook_seeCookRank.action";
		            $("#inform").submit();
  				}
  			});
  		}
  		function refew(obj){
  			var id=$(obj).parent().attr("id");
  			$.ajax({
  				url:"${path}/cook_cookFewDish.action",
  				dataType:"json",
  				data:$("#"+id).serialize(),
  				type:"post",
  				success:function(data){
		            window.location.href="${path}/cook_seeCookRank.action";
		            $("#inform").submit();
  				}
  			});
  		}
  </script>
  </head>
  
  <body>
  <div style="font-size:40px;text-align:center">后厨做菜界面</div>
  <div id="d1">
  		<form method="post" action="${path }/cook_seeCookRank.action" id="inform">
  			做菜顺序:<select name="orderdate" class="form-control" style="width:190px;display:inline;">
  						<option value="">----------请选择---------</option>
  						<option value="1" 
  							<c:if test="${orderdate eq '1' }">selected="selected"</c:if>
  						>按订单顺序(人少)</option>
  						<option value="2" 
  							<c:if test="${orderdate eq '2' }">selected="selected"</c:if>
  						>综合排序加合菜(人多)</option>
  					</select>
  				<input type="submit" value="查询" class="btn btn-info"/>
  		</form>
  	</div>
  
  <!------------------------------- 未做的凉菜界面开始 ------------------------------>
  <!------------ 没有凉菜时展示的样子 ------------->
  <c:if test="${empty lianlist }">
		<div class="panel panel-primary" id="lian2">
		    <div class="panel-heading">
		        <h3 class="panel-title" style="font-size:30px;text-align:center">未做的凉菜</h3>
		    </div>
		    <div class="panel-body">
		        <br/><br/><br/><div style="font-size:30px;text-align:center">目前暂无凉菜可做</div>
		    </div>
		</div>
  	</c:if>
 
 <c:if test="${!empty lianlist }">
  		<div class="panel panel-primary" id="lian">
		    <div class="panel-heading">
		        <h3 class="panel-title" style="font-size:30px;text-align:center">未做的凉菜</h3>
		    </div>
		    <div class="panel-body">
		        <div>
			   		<table class="table table-bordered table-hover table-striped">
			   			<tr>
			   				<th>序号</th>
			   				<th>菜名</th>
			   				<th>数量</th>
			   				<th>状态</th>
			   				<th>操作</th>
			   			</tr>
			   			<c:forEach items="${lianlist }" var="list" varStatus="vars">
				   			<tr>
				   				<td>${vars.count }</td>
				   				<td>${list.meal_name }</td>
				   				<td>${list.count }</td>
				   				<td>
				   					<c:if test="${list.state eq 0 }"><span>未完成</span></c:if>
				   					<c:if test="${list.state eq 1 }"><span style="color:green">完成</span></c:if>
				   					<c:if test="${list.state eq 2 }"><span style="color:red">正在做.....</span></c:if>
				   				</td>
				   				<td>
			   					<c:if test="${list.state eq 0 or list.state eq 2 }">
			   						<c:if test="${list.state eq 2 }">
			   							<input type="button" value="完成" data-toggle="modal" data-target="#${list.order_detail_id}" class="btn btn-info" />
			   						</c:if>
			   						<c:if test="${list.state eq 0 }">
			   							<input type="button" value="开始做" data-toggle="modal" data-target="#${list.order_detail_id}" class="btn btn-danger" />
			   						</c:if>
			   						
					   				<!------------------------- 完成凉菜遮罩层开始 ------------------------>
									 <div id="motai">	
						    			<div class="modal fade" id="${list.order_detail_id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
														<h4 class="modal-title" id="myModalLabel">警告：</h4>
													</div>
													<div class="modal-body">
														<form method="post" id="${list.order_detail_id+1000 }">
															<c:if test="${list.state eq 0 }">
																<h3>请确认开始做<span style="color:red">${list.meal_name }</span>？</h3><br/><br/>
															</c:if>
															<c:if test="${list.state eq 2 }">
																<h3>请确认<span style="color:red">${list.meal_name }</span>已做完？</h3><br/><br/>
															</c:if>
															<input type="hidden" value="${list.state }" name="state"/>
															<input type="hidden" value="${list.order_detail_id}" name="orderdetailid"/>
															<input type="button" value="确认提交" onclick="lian(this)" class="btn btn-danger" />
															<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									 </div>
									<!-------------------------- 完成凉菜遮罩层结束---------------------------->
				   						
				   					</c:if>
				   				</td>
				   			</tr>
				   		</c:forEach>
				   	</table>
			  	</div>
		    </div>
		</div>
 </c:if>
<!------------------------------- 未做的凉菜界面结束 ------------------------------>
  	
  	
  	
<!------------------------------- 未做的热菜界面开始(综合排序) ------------------------------>

	<!------------ 没有热菜时展示的样子 ------------->
	<c:if test="${empty relist and empty refewlist }">
		<div class="panel panel-primary" id="re2">
		    <div class="panel-heading">
		        <h3 class="panel-title" style="font-size:30px;text-align:center">未做的热菜</h3>
		    </div>
		    <div class="panel-body">
		        <br/><br/><br/><div style="font-size:30px;text-align:center">目前暂无热菜可做</div>
		    </div>
		</div>
  	</c:if>
  	
<c:if test="${!empty relist }">
	<div class="panel panel-primary" id="re">
	    <div class="panel-heading">
	        <h3 class="panel-title" style="font-size:30px;text-align:center">未做的热菜</h3>
	    </div>
	    <div class="panel-body">
	        <div id="d2">
		   		<table class="table table-bordered table-hover table-striped">
		   			<tr>
		   				<th>序号</th>
		   				<th>菜名</th>
		   				<th>数量</th>
		   				<th>能否合菜</th>
		   				<th>状态</th>
		   				<th>操作</th>
		   			</tr>
		   			<c:forEach items="${relist }" var="list" varStatus="vars">
			   			<tr>
			   				<td>${vars.count }</td>
			   				<td>${list.meal_name }</td>
			   				<td>${list.cook_count }</td>
			   				<td>${list.meal_compose }</td>
			   				<td>
			   					<c:if test="${list.state2 eq 0 }"><span>未完成</span></c:if>
				   				<c:if test="${list.state2 eq 1 }"><span style="color:green">完成</span></c:if>
				   				<c:if test="${list.state2 eq 2 }"><span style="color:red">正在做.....</span></c:if>
			   				</td>
			   				<td>
			   					<c:if test="${list.state2 eq 0 or list.state2 eq 2 }">
			   						<c:if test="${list.state2 eq 2 }">
			   							<input type="button" value="完成" data-toggle="modal" data-target="#${list.cook_id}b" class="btn btn-info" />
			   						</c:if>
			   						<c:if test="${list.state2 eq 0 }">
			   							<input type="button" value="开始做" data-toggle="modal" data-target="#${list.cook_id}b" class="btn btn-danger" />
			   						</c:if>
			   						
				   				<!------------------------- 完成热菜遮罩层开始 ------------------------>
								 <div id="motai">	
					    			<div class="modal fade" id="${list.cook_id}b" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
													<h4 class="modal-title" id="myModalLabel">警告：</h4>
												</div>
												<div class="modal-body">
													<form method="post" id="${list.cook_id }a">
														<c:if test="${list.state2 eq 0 }">
															<h3>请确认开始做<span style="color:red">${list.meal_name }</span>？</h3><br/><br/>
														</c:if>
														<c:if test="${list.state2 eq 2 }">
															<h3>请确认<span style="color:red">${list.meal_name }</span>已做完？</h3><br/><br/>
														</c:if>
														<input type="hidden" value="${list.state2 }" name="state"/>
														<input type="hidden" value="${list.cook_id }" name="cookid"/>
														<input type="button" value="确认提交" onclick="re(this)" class="btn btn-danger" />
														<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
													</form>
												</div>
											</div>
										</div>
									</div>
								 </div>
								<!-------------------------- 完成热菜遮罩层结束---------------------------->
			   						
			   					</c:if>
			   				</td>
			   			</tr>
		   			</c:forEach>
		   		</table>
		   	</div>
	    </div>
	</div>
 </c:if>
<!------------------------------- 未做的热菜界面结束 (综合排序)------------------------------>		
  	

<!------------------------------- 未做的热菜界面开始 (人少的排序)------------------------------>
	<c:if test="${!empty refewlist }">
		<div class="panel panel-primary" id="refew">
		    <div class="panel-heading">
		        <h3 class="panel-title" style="font-size:30px;text-align:center">未做的热菜</h3>
		    </div>
		    <div class="panel-body">
		        <div id="d3">
					<table class="table table-bordered table-hover table-striped">
			   			<tr>
			   				<th>序号</th>
			   				<th>菜名</th>
			   				<th>数量</th>
			   				<th>能否合菜</th>
			   				<th>状态</th>
			   				<th>操作</th>
			   			</tr>
			   			<c:forEach items="${refewlist }" var="list" varStatus="vars">
				   			<tr>
				   				<td>${vars.count }</td>
				   				<td>${list.meal_name }</td>
				   				<td>${list.count }</td>
				   				<td>${list.meal_compose }</td>
				   				<td>
				   					<c:if test="${list.state eq 0 }"><span>未完成</span></c:if>
					   				<c:if test="${list.state eq 1 }"><span style="color:green">完成</span></c:if>
					   				<c:if test="${list.state eq 2 }"><span style="color:red">正在做.....</span></c:if>
				   				</td>
				   				<td>
				   					<c:if test="${list.state eq 0 or list.state eq 2 }">
				   						<c:if test="${list.state eq 2 }">
				   							<input type="button" value="完成" data-toggle="modal" data-target="#${list.cook_id}c" class="btn btn-info" />
				   						</c:if>
				   						<c:if test="${list.state eq 0 }">
				   							<input type="button" value="开始做" data-toggle="modal" data-target="#${list.cook_id}c" class="btn btn-danger" />
				   						</c:if>
				   						
					   				<!------------------------- 完成热菜(人少)遮罩层开始 ------------------------>
									 <div id="motai">	
						    			<div class="modal fade" id="${list.cook_id}c" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
														<h4 class="modal-title" id="myModalLabel">警告：</h4>
													</div>
													<div class="modal-body">
														<form method="post" id="${list.cook_id }d">
															<c:if test="${list.state eq 0 }">
																<h3>请确认开始做<span style="color:red">${list.meal_name }</span>？</h3><br/><br/>
															</c:if>
															<c:if test="${list.state eq 2 }">
																<h3>请确认<span style="color:red">${list.meal_name }</span>已做完？</h3><br/><br/>
															</c:if>
															<input type="hidden" value="${list.state }" name="state"/>
															<input type="hidden" value="${list.cook_id }" name="cookid"/>
															<input type="button" value="确认提交" onclick="refew(this)" class="btn btn-danger" />
															<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									 </div>
									<!-------------------------- 完成热菜(人少)遮罩层结束---------------------------->
				   						
				   					</c:if>
				   				</td>
				   			</tr>
				   		</c:forEach>
				   	</table>
				</div>
		    </div>
		</div>
	</c:if>	
<!------------------------------- 未做的热菜界面结束 (人少的排序)------------------------------>


  <!--------------------------------------- 已完成菜品 ----------------------------------->
 <div id="jieshu">	
  <div class="panel panel-primary">
	    <div class="panel-heading">
	        <h3 class="panel-title" style="font-size:40px;text-align:center">已完成菜品</h3>
	    </div>
	    <div class="panel-body">
	       	<div id="wancheng">
		  		<table class="table table-bordered table-hover table-striped">
		   			<tr>
		   				<th>序号</th>
		   				<th>外卖姓名或桌号</th>
		   				<th>菜的类型</th>
		   				<th>菜名</th>
		   				<th>数量</th>
		   				<th>下单时间</th>
		   				<th>菜的完成状态</th>
		   			</tr>
		   			<c:forEach items="${finishlist }" var="list" varStatus="vars">
			   			<tr>
			   				<td>${vars.count }</td>
			   				<td>${list.customer_name }${list.room_number }${list.room_type }</td>
			   				<td>${list.meal_type }</td>
			   				<td>${list.meal_name }</td>
			   				<td>${list.count }</td>
			   				<td>${list.order_date }</td>
			   				<td>
			   					<span style="color:green">√&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;完成</span>
			   				</td>
			   			</tr>
			   		</c:forEach>
			   	</table>
			   	<c:if test="${empty finishlist }">
			  		<div style="font-size:30px;text-align:center">目前暂无做成的菜</div>
			  	</c:if>
		  	</div>
	    </div>
  </div>
 </div> 
  <!--------------------------------------- 已完成菜品结束 ----------------------------------->
  
  
  	<!-- ------------------------------------测试综合加合菜的排序--------------------------------- -->
  	
  	<%-- <div>
  		<table class="table table-bordered table-hover table-striped">
   			<tr>
   				<th>cook_id</th>
   				<th>菜名</th>
   				<th>能否合菜</th>
   				<th>cook_count</th>
   				<th>order_id</th>
   				<th>order_detail_id</th>
   				<th>状态</th>
   			</tr>
   			-------------------------人多时排序-----------------------------
   			<c:forEach items="${relist }" var="list" varStatus="vars">
	   			<tr>
	   				<td>${list.cook_id }</td>
	   				<td>${list.meal_name}</td>
	   				<td>${list.meal_compose }</td>
	   				<td>${list.cook_count }</td>
	   				<td>${list.order_id }</td>
	   				<td>${list.order_detail_id }</td>
	   				<td>${list.state2 }</td>
	   			</tr>
	   		</c:forEach>
	   		-- ---------------------人少时排序----------------- -
	   		<c:forEach items="${refewlist }" var="list" varStatus="vars">
	   			<tr>
	   				<td>${list.cook_id }</td>
	   				<td>${list.meal_name}</td>
	   				<td>${list.meal_compose }</td>
	   				<td>${list.cook_count }</td>
	   				<td>${list.order_id }</td>
	   				<td>${list.order_detail_id }</td>
	   				<td>${list.state2 }</td>
	   			</tr>
	   		</c:forEach>
	   	</table>
  	</div> --%>
  	
  </body>
</html>
