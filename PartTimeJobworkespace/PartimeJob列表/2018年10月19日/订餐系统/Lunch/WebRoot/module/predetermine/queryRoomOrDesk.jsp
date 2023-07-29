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
    
    <title>My JSP 'queryRoomOrDesk.jsp' starting page</title>
    
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
	#d22 table tr th,td{text-align:center}
	#d23,#d21,#d3 {text-align:center}
	#21 b{font-size:10px}
	th,td{width:160px}
	#fenye{text-align:center}
</style>
<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
  	$(function(){
  		
  	});
  	function goTo(page){
  		$("#inform").attr("action","${path}/dc/QueryRoomOrDesk?nowpage="+page);
  		$("#inform").submit();
  	}
  	$(document).ready(function(){
  		$("#zhuo").blur(function(){
  			$.ajax({
  				url:"${path}/dc/CheckRoomNumber",
  				data:{"roomnumber":this.value},
  				dataType:"json",
  				type:"post",
  				success:function(data){
  					if(data.state='true'){
  						layer.alert(data.message);
  					}else{
  						layer.alert(data.message);
  					}
  				}
  			});
  		});
  		$("#tijiao").click(function(){
  			$.ajax({
  				url:"${path}/dc/InsertRoom",
  				data:$("#inform2").serialize(),
  				type:"post",
  				dataType:"json",
  				success:function(data){
  					if(data.state=='true'){
  						layer.alert(data.message, {icon: 6});
  						setTimeout("window.location.href='${path}/dc/QueryRoomOrDesk'",1200);
  					}else{
  						layer.alert(data.message, {icon: 5});
  					}
  				}
  			});
  		});
  	});
  </script>
  
  </head>
  
  <body>
  	 <!--------------------    遮罩层新增房间桌号的div开始    ------------------------>
    
   	<div id="xinzen">
   		<input type="button" value="新增房间桌号" class="btn btn-danger" data-target="#myModal" data-toggle="modal">
   	</div>
   	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">         
            </button>
					<h4 class="modal-title" id="myModalLabel">
              	<span style="color: blue;">添加房间桌号:</span>
            </h4>
				</div>
				<div class="modal-body">
					<div id="d3">
						<form action="${path }/dc/InsertRoom" method="post" id="inform2">
							
							请输入桌号类型：<select name="roomtype" class="form-control" style="width:155px;display:inline;">
												<option value="">-----请选择-----</option>
												<option value="包厢">包厢</option>
												<option value="桌">桌</option>
										   </select><br/><br/>
							请输入房间或桌号：<input type="text" name="roomnumber" id="zhuo" class="form-control" style="width:155px;display:inline;"/><br/>(举个例子-------包厢:A101,桌:1号)<br/>
							请输入桌号人数：<select name="peocount" class="form-control" style="width:155px;display:inline;">
											<option value="">-----请选择-----</option>
											<c:forEach begin="${6 }" end="${10 }" var="list" varStatus="vars">
								  				<option value="${vars.count+5 }">${vars.count+5 }人</option>
								  			</c:forEach>
										</select><br/><br/>
							<input value="提交" type="button" class="btn btn-danger" id="tijiao"/>
							<button type="button" class="btn btn-primary" data-dismiss="modal">关闭 </button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!---------------------------  遮罩层新增房间桌号的div结束   --------------------------->
  
    <div id="d2">
    	<div id="d21">
    		<div style="font-size:40px;text-align:center">桌房基础表信息</div>
    		<form id="inform" action="${path }/dc/QueryRoomOrDesk" method="post">
    			
    			房间名:<input type="text" value="${query.roomnumber }" name="roomnumber" class="form-control" style="width:155px;display:inline;" placeholder="请输入房间名"/>
    			
    			桌房类型：<select name="type" class="form-control" style="width:95px;display:inline;">
    							<option value=""    <c:if test="${query.type=='' }">selected="selected"</c:if> >全部</option>
    							<option value="包厢" <c:if test="${query.type=='包厢' }">selected="selected"</c:if> >包厢</option>
    							<option value="桌"   <c:if test="${query.type=='桌' }">selected="selected"</c:if> >桌</option>
    					  </select>
    					  
		  		桌房状态：<select name="state" class="form-control" style="width:95px;display:inline;">
    							<option value=""    <c:if test="${query.state=='' }">selected="selected"</c:if> >全部</option>
    							<option value="空闲" <c:if test="${query.state=='空闲' }">selected="selected"</c:if> >空闲</option>
    							<option value="使用中"   <c:if test="${query.state=='使用中' }">selected="selected"</c:if> >使用中</option>
    					  </select>
		  		
		  	   选择人数:<select name="peocount" class="form-control" style="width:95px;display:inline;">
			  	   		<option value="" 
			  	   			<c:if test="${empty query.peocount }">selected='selected'</c:if>
			  	   		>全部</option>
			  			<c:forEach begin="${6 }" end="${10 }" var="list" varStatus="vars">
			  				<option value="${vars.count+5 }" 
			  					<c:if test="${vars.count+5 eq query.peocount }">selected='selected'</c:if> 
			  				>${vars.count+5 }人</option>
			  			</c:forEach>
		  			</select>
		  		
	  			<input type="submit" value="查询" id="chaxun" class="btn btn-info"/>
    		</form>
    	</div>
    	<div id="d22">
	    	<table class="table table-bordered table-hover table-striped">
	    		<tr>
	    			<th>序号</th>
	    			<th>订桌号</th>
	    			<th>类型</th>
	    			<th>可坐人数</th>
	    			<th>房间状态</th>
	    		</tr>
	    		<c:if test="${!empty roomList }">
	    			<c:forEach items="${roomList }" var="list" varStatus="vars" >
	    				<tr>
	    					<td>${vars.count }</td>
	    					<td>${list.room_number }</td>
	    					<td>${list.room_type }</td>
	    					<td>${list.peo_count }人</td>
	    					<td>${list.room_state }</td>
	    				</tr>
	    			</c:forEach>
	    		</c:if>
	    	</table>
    	</div>
    	<c:if test="${empty roomList }">
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
    </div>
    
  </body>
</html>
