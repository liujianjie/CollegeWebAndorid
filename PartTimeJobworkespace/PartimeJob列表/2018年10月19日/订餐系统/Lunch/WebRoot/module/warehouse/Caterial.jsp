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
    
    <title>My JSP 'Caterial.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
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
					data:{"caterialname":this.value,"caterialid":$("#caterialid").val()},
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
		                  		}else{
		                  			alert(data.message);
		                  		}
		               		}
		            	});
		         	});
			
			
				 /* 新增今日需求校验 */
	       
		       $("#demand").blur(function(){
		       		var number=/^([1-9][0-9]*)$/;
		       		var value=$(this).val();
		       		if(!number.test(value)){
		       			$("#mand").html("请输入数字不能以0开头");
		       			$("#addBtn").attr("disabled","disabled");
		       		}else{
		       			$("mand").html("");
		       			$("#addBtn").removeAttr("disabled");
		       		}
		       }); 
				
			 	
				/* 新增今日余量 */
	        	 /* $("#margin").blur(function(){
			   		var num=/^([1-9][0-9]*)$/;
			   		var value=$(this).val();
			   		if(!num.test(value)){
			   			$("#margi").html("请输入数字不能以0开头");
			   			$("#addBtn").attr("disabled","disabled");
			   		}else{
			   			$("#margi").html("");
			   			$("addBtn").removeAttr("disabled");
			   			}
			   		});
				
				 */
					
		});		
		
			 function goTo(page){
		          $("#searchForm").attr("action","${path }/dc/Caterial?nowpage="+page);
		          $("#searchForm").submit();
		       }  
       
	      
       		
        
   
		  
  
	</script>
  </head>
  
  <body class="table table-striped">
	    
			<form action="${path}/dc/Caterial" method="post" id="searchForm"/>
				材料名称<input type="text" name="caterialname" value="${cailiao.caterialname}" class="form-control" style="width:125px;display:inline;"/>
				<input class="btn btn-success" type="submit" value="查询"/>  
			</form>
			<!---------------------------------- 新增材料模态框开始  -------------------------------->
	
	  		<!-- 按钮触发模态框 -->
				<button class="btn btn-success" data-toggle="modal" data-target="#myModal">
					新增
				</button>
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">
									新增材料表
								</h4>
							</div> 
				    	
								<form role="form" id="form" method="post">
								  <div class="form-group">
								    <label for=""></label>
								    <input type="hidden" name="caterialid" id="caterialid" value="${caterial.caterial_id }" class="form-control" id="name" placeholder="">
								  </div>
								  <div class="form-group">
								    <input type="hidden" name="empid" id="empid" value="${userinfo.emp_id}" class="form-control" placeholder="">
								  </div>
								   <div class="form-group">
								    <label for="name">材料名称:</label>
								    <input type="text" name="caterialname" id="caterialname" value="${caterial.caterial_name}" class="form-control" placeholder="请输入材料名称">
								  	<span id="add"></span>
								  </div>
								   <div class="form-group">
								    <label for="name">材料数量:</label>
								    <input type="text" name="demand" id="demand" value="${caterial.demand}" class="form-control" placeholder="请输入每天需求的数量">
								    <span id="mand"></span>
								  </div>
								   <div class="form-group">
								    <label for="name">单位:</label>
								    <select name="unit" id="unit" class="form-control" >
									    <c:if test="${!empty type }">
									        <c:forEach items="${type }" var="li">
									          <option value="${li.unit }">${li.unit }</option>
									        </c:forEach>
									    </c:if>
								    </select>
								  </div>
								  <input type="button" id="addBtn" value="保存" class="btn btn-success">
									<button type="button" class="btn btn-danger" data-dismiss="modal">关闭
									</button>
								</form>
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
				</div>
	    	
	    	
	    	
	    	
	    <!---------------------------------- 新增材料模态框结束  -------------------------------->
			<script type="text/javascript">
			   function updateState(obj){
			   var caterialname=$(obj).prev().val();
			   		$.ajax({
                       url:"${path}/caterial_updatestate.action",
		               data:{"caterialname":caterialname},
		               type:"post",
		               dataType:"json",
		               success:function(data){
		                   if(data.state){
		                      layer.alert(data.message, {icon: 6});//在点击材料不足还是在当前页?nowpage=${page.nowpage}
		                      setTimeout("window.location.href='${path}/dc/Caterial?nowpage=${page.nowpage }'",900);
                          }
		               }
                  });
			   }
			</script>
		
	    
	    	<div class="table table-bordered">
	    		<table class="table table-striped">
			    	<tr>
			    		<th>材料名称</th>
			    		<th>每天需求量</th>
			    		<th>单位</th>
			    		<th>剩余量</th>
			    	    <th>操作</th>
			    	</tr>
		     		<c:if test="${!empty liao}"> 
		    			<c:forEach items="${liao }" var="cat" varStatus="vars">
		    				<tr>
		    					<td>${cat.caterial_name }</td>
		    					<td>${cat.demand } </td>	
		    					<td>${cat.unit }</td>
		    				    <td>${cat.state }</td>
		    					<td>
		    					<c:if test="${(cat.caterial_state eq 1) or (cat.caterial_state eq 2) }">
		    					<input type="hidden" value="${cat.caterial_name }" id="${cat.caterial_name }"/>
		    					<input type="button" value="补充材料" onclick="updateState(this)" class="btn btn-info"/>
								</c:if>
								</td>
		    				</tr>
		    			</c:forEach>
		    	 	</c:if> 
		    	 	 <td colspan="12" id="pagenum" style="text-align: center">
		    	 	 	<c:if test="${!empty liao}"> 
			  				<a href="javascript:goTo(1)">首页</a>
			  			 	<c:if test="${page.nowpage!=1 }">
			  		   		<a href="javascript:goTo(${page.nowpage-1 })">上一页</a>
			  				</c:if>
			  				<c:if test="${page.nowpage!=page.sumpage }">
			  		 		<a href="javascript:goTo(${page.nowpage+1 })">下一页</a>
			  				</c:if>
			  				 <a href="javascript:goTo(${page.sumpage})">尾页</a>
			  		 		<span>当前${page.nowpage }页</span>
			  				<%-- <a href="javascript:goTo($('#topage').val())">转到</a>
			  				<input type="text" id="topage" value="${page.nowpage }" style="width:30px;">页 --%>
		  				</c:if>
		  		 		<span>共${page.sumpage }页</sapn>
		  	 			<span id="lastspan">共${page.sumcount }条记录</span>
		  			</td>
		  	</table>
	    </div>
  </body>
    
</html>
