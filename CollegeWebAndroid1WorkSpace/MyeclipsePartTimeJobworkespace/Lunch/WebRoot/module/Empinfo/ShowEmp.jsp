<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工表</title>
    
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
 <style type="text/css">
	#box{
		width:100%;
	}
	table{
		text-align:center;
	}
	th,td{
		text-align:center;
	}
	.input-group{
		width:200px;
		padding:20px;
		float:left;
	}
	.hidden{
		display:none;
	}
</style>
<script type="text/javascript">
function goTo(i){
			$("#form1").attr("action","${path }/dc/ShowAllEmp?nowpage="+i);
			$("#form1").submit();
}
</script>
   	<script>
	function ChangeState(obj){
		$.ajax({
			url:"${path}/dc/ChangeEmpState",
			data:{"empid":obj},
			type:"post",
			dataType:"text",
			success:function(data){
			console.log(data);
				 if(data=="0"){
					$("input[value='"+obj+"']").next().attr("value","禁用");
					$("input[value='"+obj+"']").prev().find("input").css("display","block");
				}
				else{
					$("input[value='"+obj+"']").next().attr("value","启用");
					$("input[value='"+obj+"']").prev().find("input").css("display","none");
				} 
			}
		});
	}
   	</script>
   	</head>
  <body>
  <%-- <div>
    	<h2>创建模态框（Modal）</h2>
<!-- 按钮触发模态框 -->
					<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal${mapemp.emp_id }">开始演示模态框</button>
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal${mapemp.emp_id }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					    <div class="modal-dialog">
					        <div class="modal-content">
					            <div class="modal-header">
					                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					                <h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
					            </div>
					            <div class="modal-body">在这里添加一些文本</div>
					            <div class="modal-footer">
					                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					                <button type="button" class="btn btn-primary">提交更改</button>
					            </div>
					        </div><!-- /.modal-content -->
					    </div><!-- /.modal -->
					</div>
<!-- 结束模态框 -->
</div> --%>
  <div >
  <form action="${path }/dc/ShowAllEmp" method="post" id="form1" class="bs-example bs-example-form" role="form">
   <div class="input-group" style="margin-left:120px">
 		<span class="input-group-addon">员工名</span>
  		<input type="text" name="empname" value="${map.empname }" class="form-control" style="width:200px"> 
  </div>
  <div class="input-group">
  	   <span class="input-group-addon">员工用户名</span>
  		<input type="text" name="empuser" value="${map.empuser }" class="form-control" style="width:200px">
  </div>
  <div class="input-group" style="float:left">
  	<input type="submit" value="查询" class="btn btn-info">
  </div>
  </form>
  </div>
  <div id="box">
  	
   <table  class="table table-bordered table-hover table-striped" >
   <caption><input type="button" value="新增" class="btn btn-primary" onclick="window.location.href='${path}/dc/ChangeEmp'"></caption>
   <thead>
   		<tr>
   			<th>序号</th>
   			<th>员工编号</th>
   			<th>员工名</th>
   			<th>职务</th>
   			<th>性别</th>
   			<th>年龄</th>
   			<th>手机号</th>
   			<th>用户名</th>
   			<th class="hidden">密码</th>
   			<th>入职时间</th>
   			<th>员工角色授权</th>
   			<th>操作</th>
   		</tr>
   	</thead>
   	<tbody>
   		<c:forEach items="${emplist }" var="mapemp" varStatus="var">
   			<tr>
   				<td>${var.count }</td>
   				<td>${mapemp.emp_id }</td>
   				<td>${mapemp.emp_name }</td>
   				<td>${mapemp.duty_name }</td>
   				<td><c:if test="${mapemp.sex eq 0 }">男</c:if><c:if test="${mapemp.sex eq 1 }">女</c:if></td>
   				<td>${mapemp.age }</td>
   				<td>${mapemp.phone }</td>
   				<td>${mapemp.emp_user }</td>
   				<td class="hidden">${mapemp.emp_password }</td>
   				<td>${mapemp.hiredate }</td>
   				<td>
   				 <a class="btn btn-primary" data-toggle="modal" 
   				 data-target="#myModal" href="${path }/dc/EmpChanRo?empaccountid=${mapemp.emp_account_id  }&empname=${mapemp.emp_name }">员工角色授权</a>
   				</td>
   				<td style="width:140px;">
   					<span>
   						<input type="button" style="float:left"
   						<c:if test="${mapemp.state eq 1 }"> style="display:block"</c:if>
   						<c:if test="${mapemp.state eq 0 }"> style="display:none"</c:if>
   						value="修改" class="btn  btn-info" onclick="window.location.href='${path }/dc/ChangeEmp?empid=${mapemp.emp_id}'">
   					</span>
   						<input type="hidden" value="${mapemp.emp_id}" style="float:left">
   						<input type="button"  style="float:left"
   						<c:if test="${mapemp.state eq 1 }"> value="禁用"</c:if>
   						<c:if test="${mapemp.state eq 0 }"> value="启用"</c:if>
   						 onclick="ChangeState(${mapemp.emp_id})" class="btn btn-warning"/>
   				</td>
   			</tr>
   		</c:forEach>
   	</tbody>
   	<tfoot>
   		<tr>
   			<td colspan="12" id="pagenum">
  				<a href="javascript:goTo(1)">首页</a>
  			 	<c:if test="${page.nowpage!=1 }">
  		   		<a href="javascript:goTo(${page.nowpage-1 })">上一页</a>
  				</c:if>
  				<c:if test="${page.nowpage!=page.sumpage and page.sumpage!=0}">
  		 		<a href="javascript:goTo(${page.nowpage+1 })">下一页</a>
  				</c:if>
  				 <a href="javascript:goTo(${page.sumpage})">尾页</a>
  		 		<span>当前${page.nowpage }页</span>
  				<%-- <a href="javascript:goTo($('#topage').val())">转到</a>
  				<input type="text" id="topage" value="${page.nowpage }" style="width:30px;">页 --%>
  		 		<span>共${page.sumpage }页</sapn>
  	 			<span id="lastspan">共${page.sumcount }条记录</span>
  			</td>
   		</tr>
   	</tfoot>
   </table>
   </div>
   <div class="modal fade" id="myModal" tabindex="-3" role="dialog" aria-labelledby="myModalLabel"aria-hidden="true">
		 <div class="modal-dialog">
		   <div class="modal-content">
			 
			</div>
			<div class="modal-footer">
				<!-- <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button> -->
			</div>
		 </div>
	 </div>			
  </body>
</html>
