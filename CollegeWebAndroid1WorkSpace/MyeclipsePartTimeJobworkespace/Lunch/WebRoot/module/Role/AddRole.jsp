<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddRole.jsp' starting page</title>
    
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
          #table td{
          	width: 33%;
          } 
     </style>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#rolename").blur(function(){
              var reg=/^[ ]+$/;
              var name=$("#rolename").val();
              //非空校验
              if(name==''||reg.test(name)){
                   $("#rolenameWrong").html("不能为空！");
	               $("#addBtn").attr("disabled","disabled");
	            }else{
	            //唯一性校验
	                $.ajax({
		               url:"${path}/role_Checkrole.action",
		               data:{"rolename":this.value,"roleid":$("#roleid").val()},
		               type:"post",
		               dataType:"json",
		               success:function(data){
		                  if(data.state){
		                      	$("#rolenameWrong").html(data.message);
		                      	$("#addBtn").attr("disabled","disabled");
		                   }else{
		                   		$("#rolenameWrong").html(data.message);                     
		                      	$("#addBtn").removeAttr("disabled");
		                  }
	                    }
                    });
	            }
	           
    	});
             $("#addBtn").click(function(){
                  $.ajax({
                       url:"${path}/dc/InsertRole",
		               data:$("#form").serialize(),
		               type:"post",
		               dataType:"json",
		               success:function(data){
		                   if(data.state){
		                      layer.alert(data.message, {icon: 6});
		                      setTimeout("window.location.href='${path}/dc/FindRole'",900);
                          }else{
                             layer.alert(data.message, {icon: 5});
                             setTimeout("window.location.href='${path}/dc/FindRoleByid'",900);
                          }
		               }
                  });
             });
        });
        function btn(){
           window.location.href="${path}/dc/FindRole";
        }
    </script>
  </head>
  <body>
     <form id="form">
         <input type="hidden" name="roleid" id="roleid" value="${rolemap.role_id }">
	     <table  id="table" class="table">
             <tr align="center">
               <td>角色名称:</td>
               <td><input class="form-control" style="width:300px;display:inline;"   name="rolename" id="rolename"  value="${rolemap.role_name}"/></td>
               <td><span id="rolenameWrong" ></span><td>
             </tr>
             <tr align="center">
               <td>角色等级:</td>
               <td>
               		<c:if test="${!empty rolelevel }">
	               		<select class="form-control" style="width:300px;display:inline;" name="rolelevel" id="rolelevel"/>
                    	<c:forEach items="${rolelevel }" var="map">
	               			<option <c:if test="${rolemap.role_level eq map.role_level }">selected="selected"</c:if> >${map.role_level }</option>
                    	</c:forEach>               		
	               		</select>
               		</c:if>
               </td>
               <td><span></span></td>
             </tr>
             <tr align="center">
               <td>状态:</td>
               <td>
               		<c:if test="${!empty state }">
	               		<select class="form-control" style="width:300px;display:inline;" name="state" id="state"/>
                    	<c:forEach items="${state }" var="son">
	               			<option value="${son.state}" <c:if test="${rolemap.state eq son.state }">selected="selected"</c:if> >
	               			<c:if test="${son.state eq 0 }">启用</c:if>
	               			<c:if test="${son.state eq 1 }">禁用</c:if></option>
                    	</c:forEach>               		
	               		</select>
               		</c:if>
               </td>
               <td><span id="stateWrong" ></span></td>
             </tr>
             <tr align="center">
               <td colspan="3"><input class="btn btn-info" type="button" id="addBtn" value="保存"/>
               <input class="btn btn-primary" type="button" onclick="btn()" value="返回"/></td>
             </tr> 	     
	     </table>
	     </form>
  </body>
</html>
