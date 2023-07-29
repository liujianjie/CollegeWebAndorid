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
    
    <title>My JSP 'roomOrdesk.jsp' starting page</title>
    
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
	#d1,#d2{text-align:center}
	.suoyou{
		float:left;
		weight:200px;
		margin:7px;
		text-align:center;
	}
	#fenye{text-align:center}
</style>
  <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
  		function goTo(page){
  			$("#inform").attr("action","${path}/line_seeLineRoom.action?nowpage="+page);
  			$("#inform").submit();
  		}
  		function cancel(preid){
  			$.ajax({
  				url:"${path}/line_cancelRoom.action",
  				data:{"preid":preid},
  				dataType:"json",
  				type:"post",
  				success:function(data){
  					alert(data.message);
  					$("#inform").attr("action","${path}/line_seeLineRoom.action?nowpage="+"${page.nowpage }");
  					$("#inform").submit();
  				}
  			});
  		}
  </script>
  </head>

  <body>
    <div style="font-size:40px;text-align:center">房间预订表查询</div>
  <div id="d1">
  		<form method="post" id="inform" action="${path}/line_seeLineRoom.action">
  		
  			<!------------ 对订单类别进行分类查询 ------------->
  			订单类别：
  			<label class="btn btn-danger">
  				<input type="radio" name="preline" value="" <c:if test="${preline=='' }">checked="checked"</c:if> />查询所有
	  		</label>&nbsp;&nbsp;
    		<label class="btn btn-danger">
  				<input type="radio" name="preline" value="网上" <c:if test="${preline=='网上' }">checked="checked"</c:if> />网上预定
	  		</label>&nbsp;&nbsp;
	  		<label class="btn btn-danger">
	  			<input type="radio" name="preline" value="后台" <c:if test="${preline=='后台' }">checked="checked"</c:if> />后台预定
	  		</label>&nbsp;&nbsp;
	  		
	  		<!-------------- 对房间桌号类型进行查询 --------------->
	  		桌房类型：
			<label class="btn btn-warning">
  				<input type="radio" name="roomtype" value="" <c:if test="${roomtype=='' }">checked="checked"</c:if> />查询所有
	  		</label>&nbsp;&nbsp;
    		<label class="btn btn-warning">
  				<input type="radio" name="roomtype" value="包厢" <c:if test="${roomtype=='包厢' }">checked="checked"</c:if> />查询包厢
	  		</label>&nbsp;&nbsp;
	  		<label class="btn btn-warning">
	  			<input type="radio" name="roomtype" value="桌" <c:if test="${roomtype=='桌' }">checked="checked"</c:if> />查询桌号
	  		</label>
	  		<br/><br/>
		  		
	  		预订日期:<input name="predate" value="${predate }" type="text" onClick="WdatePicker({Date:'%y-%M-%d'})" class="form-control" style="width:125px;display:inline;" placeholder="请选择日期"/>
	  		时间段:<select name="preframe" class="form-control" style="width:135px;display:inline;">
   					<option value="">---请选择---</option>
   					<option <c:if test="${preframe=='11:00-14:00' }">selected="selected"</c:if> value="11:00-14:00">中午11:00-14:00</option>
				 	<option <c:if test="${preframe=='17:00-20:00' }">selected="selected"</c:if> value="17:00-20:00">晚上17:00-20:00</option>
   				</select>
   				
  			房间名:<input type="text" value="${roomnumber }" name="roomnumber" class="form-control" style="width:125px;display:inline;" placeholder="请输入房间信息"/>
  			顾客姓名:<input type="text" value="${customername }" name="customername" class="form-control" style="width:125px;display:inline;" placeholder="请输入顾客姓名"/>
  			顾客电话:<input type="text" value="${customerphone }" name="customerphone" class="form-control" style="width:125px;display:inline;" placeholder="请输入顾客电话"/>
  			<input type="submit" value="查询" class="btn btn-info"/>
  		</form>
  </div>
  <div id="">
    <table class="table table-bordered table-hover table-striped">
    	<tr>
    		<th>序号</th>
    		<th>顾客姓名</th>
    		<th>顾客电话</th>
    		<th>预订桌房号</th>
    		<th>就餐人数</th>
    		<th>预订日期</th>
    		<th>预订时间段</th>
    		<th>下单时间</th>
    		<th>订单类别</th>
    		<th>预订状态</th>
    		<th>操作</th>
    	</tr>
   		<c:forEach items="${roomlist }" var="room" varStatus="vars">
   			<tr>
   				<td>${vars.count }</td>
   				<td>${room.customer_name }${room.pre_customer }</td>
   				<td>${room.customer_phone }${room.pre_phone }</td>
   				<td>${room.room_number }${room.room_type }</td>
   				<td>${room.peo_count }人</td>
   				<td>${room.pre_date }</td>
   				<td>${room.pre_frame }</td>
   				<td>${room.pre_time }</td>
   				<td>${room.pre_line }</td>
   				<td>${room.pre_state }</td>
   				<td>
   					<c:if test="${room.pre_state eq '正常预订' }">
   						<input type="button" value="取消预订" class="btn btn-info" data-toggle="modal" data-target="#${room.room_id }"/>
	   			<!------------------------- 员工取消订单遮罩层 ---------------------------->
						<div class="suoyou">	
			    			<div class="modal fade" id="${room.room_id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
											<h4 class="modal-title" id="myModalLabel">警告：</h4>
										</div>
										<div class="modal-body">
												<h3>确定要将<span style="color:red">
												${room.customer_name }${room.pre_customer }&nbsp;&nbsp;&nbsp;${room.pre_date }日<br/><br/>
												${room.pre_frame }&nbsp;&nbsp;&nbsp;${room.room_number }${room.room_type }
												</span>的预定取消吗？</h3><br/><br/>
												<input type="button" value="确认提交" onclick="cancel('${room.pre_id }')" class="btn btn-danger" />
												<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
										</div>
									</div>
								</div>
							</div>
						</div>
				<!------------------------- 员工取消订单遮罩层 ---------------------------->
   					</c:if>
   				</td>
   			</tr>
   		</c:forEach>
    </table>
  </div>
   <c:if test="${empty roomlist }">
  			<br/><br/><br/><div style="font-size:30px;text-align:center">查询无结果！！！</div>
  	</c:if>
  	<div id="fenye">
	  		<ul class="pagination pagination-lg">
	  			<li><a>当前第${page.nowpage }页</a></li>
				<li><a href="javascript:goTo(1)">首页</a></li>
				
		    	<c:if test="${page.nowpage!=1&&page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.nowpage-1 })">上一页</a></li>
		  		</c:if>
		  		
		    	<c:if test="${page.nowpage!=page.sumpage&&page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.nowpage+1 })">下一页</a></li>
		  		</c:if>
		    	<c:if test="${page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.sumpage })">尾页</a></li>
		  			<li><a>总共${page.sumpage }页</a></li>
		  		</c:if>
		  		<c:if test="${page.sumpage==0 }">
		  			<li><a href="javascript:goTo(1)">尾页</a></li>
		  			<li><a>总共1页</a></li>
		  		</c:if>
		  		<li><a>共${page.sumcount }条记录</a></li>
			</ul><br>
  	</div>
  </body>
</html>
