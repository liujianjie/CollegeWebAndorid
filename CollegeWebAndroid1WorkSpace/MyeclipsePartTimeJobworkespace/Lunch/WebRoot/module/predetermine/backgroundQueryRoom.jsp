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
    
    <title>My JSP 'backgroundQueryRoom.jsp' starting page</title>
    
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
				margin-left:16px;
			}
		#d1{text-align:center;font-size:20px}
	</style>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				
			});
			function dianhua(obj){
				var id=$(obj).next().next().attr("id");
				var value=$(obj).val();
				var phoneReg=/^(13|15|18)\d{9}$/;
				var id2=$(obj).next().next().next().next().next().next().attr("id");
				if(!phoneReg.test(value)){
					$("#"+id).html("电话号码不规则");
					$("#"+id2).attr("disabled","disabled");
				}else{
					$("#"+id).html("");
					$("#"+id2).removeAttr("disabled");
				}
			}
			function reserve(obj){
				/* 通过找父的id来进行序列化 */
				var id=$(obj).parent().attr("id");
				$.ajax({
					url:"${path}/pre_empInsertPredeterMine.action",
					type:"post",
					dataType:"json",
					data:$("#"+id).serialize(),
					success:function(data){
						if(data.state){
							alert(data.message);
							window.location.href="${path}/pre_empSelectRoom.action";
							$("#yuding").submit();
						}else{
							alert(data.message);
						}
					}
				});
			}
			
	</script>
  </head>
  
  <body>
   <div style="font-size:40px;text-align:center">员工后台预订</div>
   <div id="d1">
  		<form action="${path }/pre_empSelectRoom.action" method="post" id="yuding">
			<!-- 桌号类型: -->
				<label class="btn btn-danger">
	  				<input type="radio" name="roomtype" value="" <c:if test="${roomtype=='' }">checked="checked"</c:if> />查询所有
		  		</label>
	    		<label class="btn btn-danger">
	  				<input type="radio" name="roomtype" value="包厢" <c:if test="${roomtype=='包厢' }">checked="checked"</c:if> />查询包厢
		  		</label>
		  		<label class="btn btn-danger">
		  			<input type="radio" name="roomtype" value="桌" <c:if test="${roomtype=='桌' }">checked="checked"</c:if> />查询桌号
		  		</label>  		
  		
    		预订日期:<input id="predate" name="predate" value="${predate }" type="text" onClick="WdatePicker({minDate:'%y-%M-%d'})" class="form-control" style="width:135px;display:inline;" placeholder="请选择日期"/>
    		
    		选择时间段:<select name="preframe" id="preframe" class="form-control" style="width:135px;display:inline;">
    					<option value="">---请选择---</option>
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
   <div id="d2">
  		<c:forEach items="${listRoom }" var="list" varStatus="vars">
    		<div class="suoyue">
    			<img src="${path }/resource/img/预订.jpg"><br/>
    			${list.room_number }${list.room_type }&nbsp;&nbsp;人数:${list.peo_count }人&nbsp;&nbsp;
    			<input type="button" value="预订" data-toggle="modal" data-target="#${list.room_id }" class="btn btn-danger"/><br>
    			
					<!------------------ 遮罩层开始 ------------------->
					
    			<div class="modal fade" id="${list.room_id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
								<h4 class="modal-title" id="myModalLabel">添加顾客预订</h4>
							</div>
							<div class="modal-body">
								<form method="post" id="${list.room_id+1000 }">
									预订日期：&nbsp;&nbsp;<input type="text" value="${predate }" name="predate" readonly="readonly" class="form-control" style="width:185px;display:inline;"/><br/>
									预订间段：&nbsp;&nbsp;<input type="text" value="${preframe }" name="preframe" readonly="readonly" class="form-control" style="width:185px;display:inline;"/><br/>
									就餐人数：&nbsp;&nbsp;<input type="text" value="${list.peo_count }人" readonly="readonly" class="form-control" style="width:185px;display:inline;"/><br/>
									预定桌号：&nbsp;&nbsp;<input type="text" value="${list.room_number }${list.room_type }" readonly="readonly" class="form-control" style="width:185px;display:inline;"/><br/>
									顾客姓名：&nbsp;&nbsp;<input type="text" name="precustomer" class="form-control" style="width:185px;display:inline;"/><br/>
									顾客电话：&nbsp;&nbsp;<input type="text" onblur="dianhua(this)" name="prephone" class="form-control" style="width:185px;display:inline;"/>
									<br/><span id="${list.room_id }a" style="color:red"></span><br/><br/>
									
									<!-- 此处有房间id -->
									<input type="hidden" value="${list.room_id }" name="roomid"/>
									<input type="button" value="确认提交" onclick="reserve(this)" class="btn btn-danger" id="${list.room_id }b"/>
									<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				
				<!------------------ 遮罩层 结束------------------->
				
    	   </div>
      </c:forEach>
      
      	<!---------------- 循序遍历被预订的桌房信息 ------------------>
      	<c:forEach items="${reserveRoom }" var="list" varStatus="vars">
      		<div class="suoyue">
      			<img src="${path }/resource/img/被预订.jpg"><br/>
    			${list.room_number }${list.room_type }&nbsp;&nbsp;人数:${list.peo_count }人&nbsp;&nbsp;
    			<input type="button" value="被预订" disabled="disabled" class="btn btn-info"/><br>
      		</div>
      	</c:forEach>
      	
      	<!------------- 当查询的时间超过当天当前系统时间，就显示提示信息 --------------->
   		<c:if test="${empty listRoom}">
   			<img src="${path }/resource/img/抱歉1.jpg">
   		</c:if>
   </div>
  </body>
</html>
