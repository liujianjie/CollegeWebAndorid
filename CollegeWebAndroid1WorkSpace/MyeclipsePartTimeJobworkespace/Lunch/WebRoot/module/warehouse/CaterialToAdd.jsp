<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'InsertCaterial.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
		$(document).ready(function(){
		   $("#demand").ajaxStart(function(){
            console.log("异步开始了");
         }); 
		  	$("#caterialname").blur(function(){
				$.ajax({
					url:"${path}/dc/CheckUserName2",
					data:{"caterialname":this.value,"caterialid":$("#catid").val()},
					type:"post",
					dataType:"json",
					success:function(data){
						if(data.state){
							$("#add").html("菜品名称已存在");
							$("#addBtn").attr("disabled","disabled");
						}else{
							$("#add").html("菜品名称没有问题");
							$("#addBtn").removeAttr("disabled");
						}
					}
				});
				
			});  
			 $("#addBtn").click(function(){
		            	$.ajax({
		               		url:"${path}/dc/InsertCaterial",
		               		data:$("#form").serialize(),
		               		type:"post",
		               		dataType:"json",
		               		success:function(data){
		                  		if(data.state=='true'){
		                     		alert(data.message);
		                     		window.location.href="${path}/dc/Caterial";
		                  		}
		               		}
		            	});
		         	});
				});
    
	</script>
  </head>
  
  <body  class="table table-striped">
    <form id="form" method="post" class="table table-striped">
  		<input type="hidden" name="catid" id="catid" value="${caterial.caterial_id }" class="table table-striped"/><br/>
    	材料名称:<input type="text" name="caterialname" id="caterialname" value="${caterial.caterial_name}" class="table table-striped"/>
    			 <span id="add"></span><br/> 
    	每天需求:<input type="text" name="demand" id="demand" value="${caterial.demand}" class="table table-striped"/><br/>
    	备用量:<input type="text" name="margin" id="margin" value="${caterial.margin}" class="table table-striped"/><br/>
    	<input type="button" id="addBtn" value="保存" class="btn btn-success">
    </form> 
    
    
    
<%-- <form class="form-horizontal" role="form" id="form" method="post">
	<input type="text" name="catid" id="catid" value="${caterial.caterial_id }" class="table table-striped"/><br/>
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">材料名称:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="catname" id="catname" value="${caterial.caterial_name}" placeholder="请输入材料名称">
      <span id="add"></span><br/>
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">每天需求</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="demand" id="demand" value="${caterial.demand}" placeholder="请输入需求数量">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">备用量</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="margin" id="margin" value="${caterial.demand}" placeholder="请输入备用数量">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     <input type="button" id="addBtn" value="保存" class="btn btn-success">
    </div>
  </div>
  
</form> --%>
    
  </body>
</html>
