<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <base href="<%=basePath%>">
    <title>My JSP 'UpdateFunction.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path}/resource/js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="${path}/resource/css/bootstrap.min.css" />
     <script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
     <style type="text/css">
        #form{
           margin:120px auto;
          }
          #tab td{
             width:33%;
          }
     </style>
    <script type="text/javascript">
        $(document).ready(function(){
          $("#functionname").blur(function(){
              var reg=/^[ ]+$/;
              var name=$("#functionname").val();
              //非空校验
              if(name==''||reg.test(name)){
                   $("#functionnameAct").html("不能为空！");
                   //layer.alert("不能为空！", {icon: 6});
	               $("#addBtn").attr("disabled","disabled");
	            }else{
	            //唯一性校验
	                $.ajax({
		               url:"${path}/fun_CheckFunction.action",
		               data:{"functionname":this.value,"functionid":$("#fun").val()},
		               type:"post",
		               dataType:"json",
		               success:function(data){
		                  if(data.state){
		                      	$("#functionnameAct").html(data.message);
		                      	$("#addBtn").attr("disabled","disabled");
		                   }else{
		                   		$("#functionnameAct").html(data.message);                     
		                      	$("#addBtn").removeAttr("disabled");
		                  }
	                    }
                    });
	            }
	           
    	});
             $("#addBtn").click(function(){
                  $.ajax({
                       url:"${path}/fun_InsertFunction.action",
		               data:$("#form").serialize(),
		               type:"post",
		               dataType:"json",
		               success:function(data){
		                   if(data.state){
		                      //修改
		                      layer.alert(data.message, {icon: 6});
		                      //alert(data.message);
			                  //window.location.href="${path}/fun_SelParentFunction.action?functionid=${parentid}";
			                  setTimeout("window.location.href='${path}/fun_SelParentFunction.action?functionid=${parentid}'",900);
                          }else{
                             //新增
                             layer.alert(data.message, {icon: 6});
                             alert(data.message);
		                     //window.location.href="${path}/fun_FindFunctionByid.action";
		                     setTimeout("window.location.href='${path}/fun_FindFunctionByid.action'",900);
                          }
		               }
                  });
             });
        });
    </script>
  </head>
  <body>
     <form id="form">
         <input type="hidden" name="functionid" id="fun" value="${map.function_id }">
	     <table id="tab" class="table table-bordered table-hover table-striped">
             <tr align="center">
               <td>功能名称:</td>
               <td><input class="form-control" name="functionname" id="functionname" value="${map.function_name}"/></td>
               <td><span id="functionnameAct"></span></td>
             </tr>
             <tr align="center">
               <td>功能介绍:</td>
               <td><input class="form-control" name="functiondec" id="functiondec" value="${map.function_dec}"/></td>
               <td><span></span></td>
             </tr>
             <tr align="center">
               <td>链接地址:</td>
               <td><input class="form-control" name="functionurl" id="functionurl" value="${map.function_url}"/></td>
             	<td><span></span></td>
             </tr>
             <tr align="center">
             <td>功能状态:</td>
             <td>
                <select name="state" id="state" class="form-control">
                   <c:forEach items="${statelist }" var="state">
                      <option value="${state.state}" <c:if test="${map.state==state.state }">selected='selected'</c:if> >
                           <c:if test="${state.state eq 0 }">启用</c:if>
	               			<c:if test="${state.state eq 1 }">禁用</c:if></option>
                   </c:forEach>
                </select>
             </td>
             <td><span></span></td>
             </tr>
             <tr align="center">
             <td>父级功能名称:</td>
             <td>
                <select name="functionparentid" id="functionid" class="form-control">
                   <option></option>
                   <c:forEach items="${list }" var="list">
                      <option value="${list.function_id}" <c:if test="${map.function_parent_id==list.function_id }">selected='selected'</c:if>
                      <c:if test="${parentid==list.function_id}">selected='selected'</c:if>  >    ${list.function_name}</option>
                   </c:forEach>
                </select>
             </td>
             <td><span></span></td>
             </tr>
             <tr align="center">
               <td colspan="3"><input class="btn btn-info" type="button" id="addBtn" value="保存"/>
               <input class="btn btn-primary" type="button" onclick="javascript:window.history.back(-1);" value="返回"/></td>
             </tr> 	     
	     </table>
	     </form>
  </body>
</html>
