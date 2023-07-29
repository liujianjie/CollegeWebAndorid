<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Huifu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path}/resource/js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="${path}/resource/css/bootstrap.min.css" />
	<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
	<style type="text/css">
	   #tab{width:1100px;
	   margin:120px 0px 0px 0px;
	   line-height:60px;
	   }
	   #tab td{
	    width:33.3%;
	    }
	</style>
	<script type="text/javascript">
	  $(document).ready(function(){
	     $("#sub").click(function(){
		     	$.ajax({
			     	url:"${path}/pl_updatePl.action",
			     	data:{"commentid":$("#commentid").val(),"commentreplay":$("#commentreplay").val()},
			     	type:"post",
			     	dataType:"json",
			     	success:function(data){
			     		if(data.state){
			     		   layer.alert(data.message, {icon: 6});
		                   setTimeout("window.location.href='${path}/pl_SelectPl.action'",1200);
				          }
			     		}
		     	});
	     });
	 });
	 function backup(){
	      window.location.href="${path}/pl_SelectPl.action";
	 }
	</script>
	<script language="javascript" type="text/javascript">
      $(document).ready(function(){
         $("#commentreplay").blur(function(){
              //非空校验
              var name=$(this).val();
              if(name==''||name==null){
                   $("#commentmessage").html("评论不能为空！");
	               $("#sub").attr("disabled","disabled");
	           }
           });
         	$("#commentreplay").keyup(function(){
		 	var len = $(this).val().length;
		 	var num = 20 - len;
		 	if(len>20){
		 	  $("#commentmessage").html("已经超过20个字");
		 	  $("#sub").attr("disabled","disabled");
		 	 }else{
		 	   $("#commentmessage").html("还能输入"+num+"字");
		 	   $("#sub").removeAttr("disabled");
		 	   }
		  });
   });
</script>
   </head>
  <body>
    <table id="tab" class="table table-bordered table-hover table-striped">
        <input type="hidden" name="commentid" id="commentid" value="${pmap.comment_id}"/>
        <tr align="center"><td colspan="3"><h3>回复菜品评论</h3></td></tr>
        <tr>
		<td align="center">菜品名称</td>
		<td colspan="2"><input type="text" readonly="readonly"  class="form-control" name="mealname" id="mealname" value="${pmap.meal_name}"/></td>
	    </tr>
	    <tr>
		<td align="center">评论人</td>
		<td colspan="2"><input type="text" readonly="readonly"  class="form-control" name="customername" id="customername" value="${pmap.customer_name}"/></td>
	    </tr>
	    <tr>
		<td align="center">评论内容</td>
		<td colspan="2"><textarea class="form-control" readonly="readonly"  name="commentcontent" id="commentcontent" value="${pmap.comment_content}" >${pmap.comment_content}</textarea></td>
	    </tr>
	    <tr class="alert alert-info">
		<td align="center">评论时间</td>
		<td colspan="2"><input type="text" readonly="readonly"  class="form-control" name="commentdate" id="commentdate" value="${pmap.comment_date}"/></td>
	    </tr>
	    <tr>
		<td align="center">回复内容</td>
		<td><textarea class="form-control" name="commentreplay" id="commentreplay" value="${pmap.comment_replay}" >${pmap.comment_replay}</textarea></td>
	    <td><span id="commentmessage"></span></td>
	    </tr>
	    <tr>
		<td align="center">回复时间</td>
		<td colspan="2"><input type="text" readonly="readonly" class="form-control" name="replaytime" id="replaytime" value="${pmap.replay_time}"/></td>
	    </tr>
	    <tr>
		<td colspan="3" align="center">
		<input type="button" value="保存" id="sub" class="btn btn-info "/>
		<input type="button" onclick="backup()" value="返回"  class="btn btn-primary "/>
		</td>
	    </tr>
    </table>
  </body>
</html>
