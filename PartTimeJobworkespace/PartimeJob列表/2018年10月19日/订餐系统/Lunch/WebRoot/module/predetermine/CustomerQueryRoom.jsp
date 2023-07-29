<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%  
	String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间  
	request.setAttribute("datetime",datetime);
	String time=new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()); //获取系统小时  
	request.setAttribute("time",time);
%>

<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CustomerQueryRoom.jsp' starting page</title>
    
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
		.suoyue{
			float:left;
			weight:203px;
			margin:8px;
			text-align:center;
			color:blue;
		}
		#d1{text-align:center;font-size:20px}
		#yuding{margin:0 auto;width:1100px}
	</style>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				$("#fanhui").click(function(){
					window.open("${path}/module/Login/Menu.jsp","_top");
				});
			});
			function reserve(obj){
				var id=$(obj).parent().attr("id");
				var customerid=$(obj).prev().prev().val();
				$.ajax({
						url:"${path}/pre_addPredeterMine.action",
						data:$("#"+id).serialize(),
						dataType:"json",
						type:"post",
						success:function(data){
							if(data.state){
								alert(data.message);
								window.location.href="${path}/pre_seeCustomerRoom.action?customerid="+customerid;
							}else{
								alert(data.message);
							}
						}
				});
			}
	</script>
  </head>
  
  <body>
  <input type="image" value="返回" src="${path }/resource/img/返回.jpg" id="fanhui"/>
   <div style="font-size:40px;text-align:center"><img src="${path }/resource/img/预订桌房号.jpg"><br/></div>
  	<div id="d1">
  		<form action="${path }/pre_selectRoom.action" method="post" id="inform">
			<!-- 桌号类型: -->
				<label class="btn btn-warning">
	  				<input type="radio" name="roomtype" value="" <c:if test="${roomtype=='' }">checked="checked"</c:if> />查询所有
		  		</label>
	    		<label class="btn btn-warning">
	  				<input type="radio" name="roomtype" value="包厢" <c:if test="${roomtype=='包厢' }">checked="checked"</c:if> />查询包厢
		  		</label>
		  		<label class="btn btn-warning">
		  			<input type="radio" name="roomtype" value="桌" <c:if test="${roomtype=='桌' }">checked="checked"</c:if> />查询桌号
		  		</label>  		
  		
    		预订日期:<input id="predate" name="predate" value="${predate }" type="text" onClick="WdatePicker({minDate:'%y-%M-%d'})" class="form-control" style="width:135px;display:inline;" placeholder="请选择日期"/>
    		
    		选择时间段:<select name="preframe" id="preframe" class="form-control" style="width:155px;display:inline;">
    					<option value="">------请选择-----</option>
					 	<option <c:if test="${preframe=='11:00-14:00' }">selected="selected"</c:if> value="11:00-14:00">中午11:00-14:00</option>
					 	<option <c:if test="${preframe=='17:00-20:00' }">selected="selected"</c:if> value="17:00-20:00">晚上17:00-20:00</option>
    				</select>
    		
    		就餐人数:<select name="peocount" class="form-control" style="width:95px;display:inline;">
    					<option value="" 
		  	   				<c:if test="${empty peocount }">selected='selected'</c:if>
		  	   			>全部</option>
    					<c:forEach begin="${6 }" end="${10 }"  varStatus="vars">
    						<option value="${vars.count+5 }"
    							<c:if test="${peocount eq vars.count+5 }">selected='selected'</c:if> 
    						>${vars.count+5 }人</option>
    					</c:forEach>
    			   </select>
    			   
    			<input type="submit" value="预订查询" class="btn btn-info"/>
    	</form>
   </div>

	<div id="yuding">
	    	<c:forEach items="${listRoom }" var="list" varStatus="vars">
	    		<div class="suoyue">
	    			<img src="${path }/resource/img/餐桌图.jpg"><br/>
	    			${list.room_number }${list.room_type }&nbsp;&nbsp;人数:${list.peo_count }人&nbsp;&nbsp;
	    			<input type="button" value="预订" data-toggle="modal" data-target="#${list.room_id }" class="btn btn-info"/><br>
	    			<!------------------ 遮罩层 开始------------------->
					
	    			<div class="modal fade" id="${list.room_id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
									<h4 class="modal-title" id="myModalLabel">确认您的预订信息</h4>
								</div>
								<div class="modal-body">
									<form method="post" id="${list.room_id+1000 }">
										<!---------- session中有顾客id，将预订按钮显示出来 ----------->
										 <c:if test="${!empty UserMap.customer_id }">
											预订日期：&nbsp;&nbsp;<input type="text" value="${predate }" name="predate" readonly="readonly" class="form-control" style="width:185px;display:inline;"/><br/><br/>
											预订间段：&nbsp;&nbsp;<input type="text" value="${preframe }" name="preframe" readonly="readonly" class="form-control" style="width:185px;display:inline;"/><br/><br/>
											就餐人数：&nbsp;&nbsp;<input type="text" value="${list.peo_count }人" readonly="readonly" class="form-control" style="width:185px;display:inline;"/><br/><br/>
											预定桌号：&nbsp;&nbsp;<input type="text" value="${list.room_number }${list.room_type }" readonly="readonly" class="form-control" style="width:185px;display:inline;"/><br/><br/>
											
											<!-- 此处有前台登录顾客的接口 -->
											<input type="hidden" value="${UserMap.customer_id }" name="customerid"/>
											<input type="hidden" value="${list.room_id }" name="roomid"/>
											<input type="button" value="确认提交" onclick="reserve(this)" class="btn btn-warning" />
										 </c:if>
										 <!---------- session中没有顾客id，就提示请先登录 ----------->
										 <c:if test="${empty UserMap.customer_id }">
										 	<h3>很抱歉，请先登录！！！</h3><br/><br/>
										 </c:if>
										 
											<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					
					<!------------------ 遮罩层结束 ------------------->
	    		</div>
	    		
	    	</c:forEach>
	    
	    	<!------------- 当查询的时间超过当天当前系统时间，就显示提示信息 --------------->
    		<c:if test="${empty listRoom}">
    			<img src="${path }/resource/img/抱歉1.jpg">
    		</c:if>
	</div>

  </body>
</html>
