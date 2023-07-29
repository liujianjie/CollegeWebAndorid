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
    
    <title>My JSP 'openTable.jsp' starting page</title>
    
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
	#d1{text-align:right}
	.suoyou{
		float:left;
		weight:200px;
		height:210px;
		margin:10px;
		text-align:center;
	}
</style>

<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			$("div [class='suoyou']").each(function(){
				var roomid=$(this).find("input[class='Jiezhang']").val();
				$.ajax({
					url:"${path}/car_showCall.action",
					data:{"roomid":roomid},
					type:"post",
					dataType:"json",
					success:function(data){
						if(data.state=='true'){
							$("#Jie"+roomid).html("准备结账");
						}
					}
				})
			});
		});
		/* 开桌的点击事件 */
		function kai(obj){
			var roomid=$(obj).prev().val();
			$.ajax({
				url:"${path}/open_updateRoomType.action",
				data:{"roomid":roomid},
				dataType:"json",
				type:"post",
				success:function(data){
						window.location.href="${path}/open_openSeeTable.action";
				}
			});
		}
		/* 结束使用的点击事件 */
		function shi(obj){
			var roomid=$(obj).prev().val();
			$.ajax({
				url:"${path}/open_recoverRoomType.action",
				data:{"roomid":roomid},
				dataType:"json",
				type:"post",
				success:function(data){
						window.location.href="${path}/open_openSeeTable.action";
				}
			});
		}
		/* 结束打扫的点击事件 */
		function hui(obj){
			var roomid=$(obj).prev().val();
			$.ajax({
				url:"${path}/open_huifuRoomType.action",
				data:{"roomid":roomid},
				dataType:"json",
				type:"post",
				success:function(data){
						window.location.href="${path}/open_openSeeTable.action";
				}
			});
		}
		
		/*马岗岗的开桌链接结账 */
    	function chakan(roomid){
    			$.ajax({
						url:"${path}/emp_findOrderid.action",
						data:{"roomid":roomid},
						type:"post",
						dataType:"text",
						success:function(data){	
							window.location.href="${path}/car_Jiezhang.action?orderid="+data+"&roomid="+roomid+"&flag=1";
						}
				});
    	}
		
</script>
  </head>
  
  <body>
    <div style="font-size:40px;text-align:center">开桌</div>
    <div id="d1">
    	<form method="post" action="${path }/open_openSeeTable.action" id="inform">
    		房间名:<input type="text" value="${roomnumber }" name="roomnumber" class="form-control" style="width:155px;display:inline;" placeholder="请输入房间号"/>
    		<input type="submit" value="查询" class="btn btn-info"/>
    	</form>
    </div>
    <div id="d2">
    	<c:forEach items="${roomlist }" var="list" varStatus="vars">
    		<div class="suoyou">
    				<input class="Jiezhang" type="hidden" value="${list.room_id }"/>
    				<!--------------------- 遍历所有空闲的房间 --------------------------->
    				<c:if test="${list.room_state eq '空闲' }">
    					<img src="${path }/resource/img/开桌空闲.jpg"><br/>
		    			${list.room_number }${list.room_type }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人数:${list.peo_count }人<br/>
		    			
		    			<!--------------- 判断时间段是否被预定 ---------------->
		    			<c:forEach items="${reservelist }" var="room">
		    				<c:if test="${room.room_id eq list.room_id }">
		    					<span style="color:red;font-weight:bold;">${room.customer_name }${room.pre_customer }预定</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    				</c:if>
		    			</c:forEach>
		    			<input type="button" value="${list.room_state }" disabled="disabled" class="btn btn-primary"/>
		    			<input type="button" value="开桌" class="btn btn-primary" data-toggle="modal" data-target="#${list.room_id }"/>
		    			
				    		<!------------------ 开桌遮罩层 ------------------->
							
		    			<div class="modal fade" id="${list.room_id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabel">警告：</h4>
									</div>
									<div class="modal-body">
										<form method="post" id="${list.room_id+1000 }">
											<h3>确定要对<span style="color:red">${list.room_number }${list.room_type }</span>开桌吗？</h3><br/><br/>
											<input type="hidden" value="${list.room_id }" name="roomid"/>
											<input type="button" value="确认提交" onclick="kai(this)" class="btn btn-danger" />
											<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						
						<!------------------ 开桌遮罩层 ------------------->
		    			
    				</c:if>
    				
    				<!--------------------- 遍历所有使用中的房间 --------------------------->
    				<c:if test="${list.room_state eq '使用中' }">
    					<img src="${path }/resource/img/开桌使用中.jpg"><br/>
		    			${list.room_number }${list.room_type }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人数:${list.peo_count }人<br/>
		    			
		    			<!------------------ 给马岗岗留的接口 ----------------->
		    			<div>
		    			   <span style="color:red;font-weight:bold;" id="Jie${list.room_id}"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="button" value="结账" class="btn btn-warning" onclick="chakan(${list.room_id})">
						</div>
		       			<!------------------ 给马岗岗留的接口 ----------------->		
		    			
		    			<input type="button" value="${list.room_state }" disabled="disabled" class="btn btn-danger"/>
		    			<input type="button" value="结束使用"  class="btn btn-danger" data-toggle="modal" data-target="#${list.room_id }" />
		       	
		    			<!------------------ 关闭使用中启用打扫遮罩层 ------------------->
							
		    			<div class="modal fade" id="${list.room_id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabel">警告：</h4>
									</div>
									<div class="modal-body">
										<form method="post" id="${list.room_id+100 }">
											<h3>确定要对<span style="color:red">${list.room_number }${list.room_type }</span>开始打扫吗？</h3><br/><br/>
											<input type="hidden" value="${list.room_id }" name="roomid"/>
											<input type="button" value="确认提交" onclick="shi(this)" class="btn btn-danger" />
											<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						
						<!------------------ 关闭使用中启用打扫遮罩层------------------->
    				</c:if>
    				
    				
    				<!--------------------- 遍历所有打扫中的房间 --------------------------->
    				<c:if test="${list.room_state eq '打扫中' }">
    					<img src="${path }/resource/img/开桌打扫中.jpg"><br/>
		    			${list.room_number }${list.room_type }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人数:${list.peo_count }人<br/>
		    			<input type="button" value="${list.room_state }" disabled="disabled" class="btn btn-success"/>
		    			<input type="button" value="结束打扫"  class="btn btn-success" data-toggle="modal" data-target="#${list.room_id }" />
		    			
		    			<!------------------ 恢复空闲遮罩层 ------------------->
							
		    			<div class="modal fade" id="${list.room_id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabel">警告：</h4>
									</div>
									<div class="modal-body">
										<form method="post" id="${list.room_id+100 }">
											<h3>确定<span style="color:red">${list.room_number }${list.room_type }</span>打扫完了吗？</h3><br/><br/>
											<input type="hidden" value="${list.room_id }" name="roomid"/>
											<input type="button" value="确认提交" onclick="hui(this)" class="btn btn-danger" />
											<button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						
						<!------------------ 恢复空闲遮罩层------------------->
    				</c:if>
    				
    		</div>
    	</c:forEach>
    </div>
  </body>
</html>
