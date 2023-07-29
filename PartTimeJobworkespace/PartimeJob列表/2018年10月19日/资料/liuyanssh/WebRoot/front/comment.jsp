<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'class.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" type="text/css"></link>
  <script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script></head>
  <script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
  
  <body>
      <!-- 添加操作 -->
<!--         <button type='button' class='btn btn-primary add' data-toggle='modal' data-target='#myadd' >添加</button>
 -->       <table class="table table-striped">
	<caption>评论管理</caption>
	<thead>
		<tr>
			<th>评论编号</th>
			<th>评论内容</th>
			<th>评论人</th>
			<th>评论时间</th>
			<th>订单编号</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody id="mytbody">
		
	</tbody>
</table>
<!-- 分页信息 -->
共<span id="totalPage"></span>页，当前是第<span id="nowPage"></span>页，<a href="javascript:(0)" id="prePage">上一页</a>，<a href="javascript:(0)" id="nextPage">下一页</a>

   <!-- 模态框（Modal） -->

 
   <!-- 模态框（Modal） -->
<!--   开  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改
				</h4>
			</div>
			<div class="modal-body">
					<form class="form-horizontal" role="form" id="myform">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">评论编号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="plaid" 
									name="comment.commentId"  >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">评论内容</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="plname" 
									   placeholder="请输入内容" name="comment.evaluate" >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">评论人</label>
							<div class="col-sm-10">
								<select id="username" class="form-control" name="comment.user.userId"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">评论时间</label>
							<div class="col-sm-10">
								<select id="times" class="form-control" name="comment.outOrder.outOrderId"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">订单编号</label>
							<div class="col-sm-10">
								<select id="num" class="form-control" name="comment.outOrder.outOuderNum"></select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button  class="btn btn-default" id="update">确认修改</button>
							</div>
						</div>
					</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div>/.modal-content
	</div>/.modal
	</div>
 <div class="modal fade" id="myadd" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加
				</h4>
			</div>
			<div class="modal-body">
					<form class="form-horizontal" role="form" id="myform2">
						
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">班级名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="lastname" 
									   placeholder="请输入名称" name="tabClasses.classesName" >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">选择所在年级</label>
							<div class="col-sm-10">
								  <select id="selectgrade" class="form-control"name="tabClasses.tabGrade.tabGradeId"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">选择老师</label>
							<div class="col-sm-10">
								  <select id="selectteacherss" class="form-control" name="tabClasses.tabTeacher.tabTeacherId"></select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a  class="btn btn-default" id="add">确认添加</a>
							</div>
						</div>
					</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div>/.modal-content
	</div>/.modal
	</div>      关    -->
  </body>
</html>
<script>
var gradeinfo;
var teacherinfo;
    //页面加载时同时加载年级信息
    $(function(){
          getCla(1);
          getGradeInfo();
         getTeacherInfo();
      
    })
    //得到所有的年级分页信息
    function getCla(nowPage){
          $.ajax({
              url:"getAllComment.action",
              type:"post",
              dataType:"json",
              data:{"page.nowPage":nowPage},
              success:function(data){
              var datalist=data.list;
              //每次加载之前清空当前页面数据
                $("#mytbody").html("");
                  var tr="";
                  for(var i=0;i<datalist.length;i++){
                     tr+="<tr>"
                     tr+="<td>"+datalist[i].commentId+"</td>" 
                      tr+="<td>"+datalist[i].evaluate+"</td>" 
                       tr+="<td>"+datalist[i].userName+"</td>" 
                        tr+="<td>"+datalist[i].outCreateDate+"</td>" 
                          tr+="<td>"+datalist[i].outOuderNum+"</td>" 
                       tr+="<td><button type='button' class='btn btn-primary update' data-toggle='modal' data-target='#myModal' id='"+datalist[i].commentId+"'>回复</button><button type='button' class='btn btn-primary del' data-toggle='button' id='"+datalist[i].commentId+"'> 删除</button></td>" 
                     tr+="</tr>"
                  }
                  $("#mytbody").append(tr);
                  
                  $("#totalPage").html(data.totalPage);
                  $("#nowPage").html(data.nowPage)
              }
           
           
           })
        
    }
    //得到年级信息
    function getGradeInfo(){
      $.ajax({
           url:"getAllGrade.action",
           type:"post",
           data:{},
           dataType:"json",
           success:function(data){
           gradeinfo=data;
             var option="";
            for(var i=0;i<data.length;i++){
                option+="<option value='"+data[i].tabGradeId+"'>"+data[i].username+"</option>";
              } 
              $("#selectgrade").append(option);
           }
        
      })
    }
    //得到老师信息
    function getTeacherInfo(){
        $.ajax({
           url:"getAllTeacher.action",
           type:"post",
           data:{},
           dataType:"json",
           success:function(data){
           teacherinfo=data;
             var option="";
            for(var i=0;i<data.length;i++){
                option+="<option value='"+data[i].tabTeacherId+"'>"+data[i].times+"</option>";
              } 
              $("#selectteacherss").append(option);
           }
        
      })
    }
    
    
    //事件绑定，得到一个班级详情
   $("#mytbody").on("click",".update",function(){
        $.ajax({
           url:"getOneCla.action",
              type:"post",
              dataType:"json",
              data:{"tabClasses.tabClassesId":this.id},
              success:function(data){
                 $("#plaid").val(data.tabClassesId);
                 $("#plname").val(data.classesName);
                 var option="";
                 var option2="";
                 //每次加载前先清空下拉框的值
                 $("#times").html("");
                  $("#username").html("");
                 for(var i=0;i<gradeinfo.length;i++){
                     
                     if(gradeinfo[i].tabGradeId==data.tabGradeId){
                    
                         option+="<option selected='selected' value='"+gradeinfo[i].tabGradeId+"'>"+gradeinfo[i].username+"</option>";
                     }else{
                         option+="<option value='"+gradeinfo[i].tabGradeId+"'>"+gradeinfo[i].username+"</option>";
                     }
                    
                 }
                  $("#username").append(option);
                  
                  
                   for(var i=0;i<teacherinfo.length;i++){
                     
                     if(teacherinfo[i].tabTeacherId==data.tabTeacherId){
                    
                         option2+="<option selected='selected' value='"+teacherinfo[i].tabTeacherId+"'>"+teacherinfo[i].times+"</option>";
                     }else{
                         option2+="<option value='"+teacherinfo[i].tabTeacherId+"'>"+teacherinfo[i].times+"</option>";
                     }
                    
                 }
                  $("#times").append(option2);
              }  
          
        })
   })
 //修改  
  $("#update").click(function(){
     if(confirm("确认修改?")){
            $.ajax({
           url:"updateCla.action",
              type:"post",
              dataType:"text",
              data:$("#myform").serialize(),
              success:function(data){
                // 重新加载  
               getCla(nowPage);
              }  
          
        })
     }else{
         return false;
     }
  })
  
  //删除
  $("#mytbody").on("click",".del",function(){
    if(confirm("确定删除?")){
           $.ajax({
           url:"delCla.action",
              type:"post",
              dataType:"text",
              data:{"tabClasses.tabClassesId":this.id},
              success:function(data){
              //删除成功后,重新加载当前页面数据（table）
              var nowPage=parseInt($("#nowPage").html());
      
                   getCla(nowPage);
              }  
          
        })
    }else{
       return false;
    }
  })
  
  
  //添加 班级
  $("#add").click(function(){
       $.ajax({
           url:"addCla.action",
              type:"post",
              dataType:"text",
              data:$("#myform2").serialize(),
              success:function(data){
              //删除成功后,重新加载页面数据（table）
                $('#myadd').modal('hide')
                  //删除成功后,重新加载当前页面数据（table）
              var nowPage=parseInt($("#nowPage").html());
      
                   getCla(nowPage);
                    
              }  
          
        })
  })
  
     //点击上一页时事件  
    $("#prePage").click(function(){
       var prePage=parseInt($("#nowPage").html())-1;
       if(prePage<1){alert("当前已经是首页");prePage=1}
       //重新加载上一页数据
      getCla(prePage);
    })
    //点击下一页时事件
     $("#nextPage").click(function(){
        var nextPage=parseInt($("#nowPage").html())+1;
         var totalPage=parseInt($("#totalPage").html())
         if(nextPage>totalPage){alert("当前已经是最后一页");nextPage=totalPage}
         //重新加载下一页数据
       getCla(nextPage);
    })
</script>
