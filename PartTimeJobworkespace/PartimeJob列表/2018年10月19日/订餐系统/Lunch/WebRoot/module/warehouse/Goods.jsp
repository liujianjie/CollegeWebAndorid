<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  
    <title>My JSP 'Goods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		$(document).ready(function(){
         	  $("#mealprice").ajaxStart(function(){
            console.log("异步开始了");
         }); 
		  	$("#mealname").blur(function(){
				$.ajax({
					url:"${path}/dc/CheckUserName",
					data:{"mealname":this.value,"mealid":$("#mealid").val()},
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
			
				function doUpload() {  
			     var formData = new FormData($( "#uploadFormAct" )[0]);  
			     $.ajax({  
			         url: "${path }/Prcute_Upload.action" ,  
			         type: "POST",  
			         data: formData,  
			         async: false,  
			         cache: false,  
			         contentType: false,  
			         processData: false,  
			         success: function (returndata) {  
			             //alert(returndata); 
			         $("input[name='filenameFileName']").removeAttr("value");
			         $("input[name='filenameFileName']").attr("value",returndata);
			         },  
			           error: function (returndata) {  
			             // alert(returndata);  
			            }  
			      });  
    		} 
			  
			 
			 $("#addBtn").click(function(){
			 			var imageurl=doUpload();
		            	$.ajax({
		               		url:"${path}/dc/InsertGoods",
		               		data:{"mealid":$("#mealid").val(),"mealtype":$("#mealtype").val(),"mealname":$("#mealname").val(),"mealbudget":$("#mealbudget").val(),"mealprice":$("#mealprice").val(),"mealdesc":$("#mealdesc").val(),"mealimage":$("input[name='filenameFileName']").val()},
		               		type:"post",
		               		dataType:"json",
		               		success:function(data){
		                  		if(data.state=='true'){
		                     		alert(data.message);
		                     		window.location.href="${path}/dc/Goods";
		                  		}else{
		                  			alert(data.message);
		                  		}
		               		}
		            	});
		         	});	 
    		
		         //新增现金价格校验	 
			   $("#mealprice").blur(function(){
			        	var number=/^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$/;
			        	var value=$(this).val();
			        	if(!number.test(value)){
			        		$("#priceWrong").html("输入的现金格式不正确");
			        		$("#addBtn").attr("disabled","disabled");
			        		
			        		 
			        	}else{
			        		$("#priceWrong").html("");
			        		$("#addBtn").removeAttr("disabled");
			        		
			        	}
			        });  
			        $("#mealbudget").blur(function(){
			        	var number=/^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$/;
			        	var value=$(this).val();
			        	if(!number.test(value)){
			        		$("#budgetWrong").html("输入的现金格式不正确");
			        		$("#addBtn").attr("disabled","disabled");
			        		
			        		 
			        	}else{
			        		$("#budgetWrong").html("");
			        		$("#addBtn").removeAttr("disabled");
			        		
			        	}
			        });  
		 		/* 上传图片正则表达式  */
		      /*   $("#uploadFormAct").change(function(){
    				var f=$("#uploadFormAct").val();
    				if(f==""){
        				$("#filename").html("图片格式不正确");
			        	$("#addBtn").attr("disabled","disabled");
    				}else if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(f)){
      					$("#filename").html("");
			       	 	$("#addBtn").removeAttr("disabled");
    				}
				});  */
		       
		       
		     /*   $("#uploadFormAct").change(function(){
				    var f=$("#uploadFormAct").val();
				    if(f==""){
				        alert("请上传图片");
				        return false;
				    }else if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(f)){
				      alert("图片类型必须是.gif,jpeg,jpg,png中的一种")
				      return false;
				    }
				}) */
				
				
			  function xiugai(obj){
				        $.ajax({
				          url:"${path}/dc/InsertGoods",
				          data:$(obj).serialize(),
				          dataType:"json",
				          type:"post",
				          success:function(data){
				              if(data.state=='true'){
				                 alert(data.message);
				                 window.location.href="${path}/dc/Goods";
				              }
				          }
				        });
		     	}  
			 
			 
			 
		});  
		   function goTo(page){
         	 		$("#searchForm").attr("action","${path}/dc/Goods?nowpage="+page);
         	 		
          			$("#searchForm").submit();
       		}  
		  
			 
			
    			
    		
		         	 
		        
			           
			       
		      
		     function del(roleid,page,state){
				$.ajax({
					url:"${path}/dc/UpdateState",
					data:{"roleid":roleid,"state":state},
					dataType:"json",
					type:"post",
					success:function(data){
						if(data.result){
						     layer.alert(data.message, {icon: 6});
		                      setTimeout("goTo("+page+")",900);
						}else{
						    layer.alert(data.message, {icon: 6});
		                     setTimeout("goTo("+page+")",900);
						}
					}
				});
		}  
		        
		function update(roleid){
	  	   window.location.href="${path}/dc/FindRoleByid?roleid="+roleid;
	  	}	
     	
     function checkFileExt(ths){  
		    if (ths.value == "") {  
		        alert("请上传图片");  
		        return false;  
		    } else {  
		        if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG|JPEG)$/.test(ths.value)) {  
		            alert("图片类型必须是.gif,jpeg,jpg,png中的一种");  
		            ths.value = "";  
		            return false;  
		        }  
		    }  
		    return true;  
		}  
       
	</script>
  </head>
  	
  <body class="table table-striped">
	 <form action="${path}/dc/Goods" method="post" id="searchForm">
		   	菜品名称<input type="text" name="mealname" value="${shangpin.mealname}" class="form-control" style="width:125px;display:inline;"/>&nbsp;&nbsp;&nbsp;
		   	菜品价格<input type="text" name="mealprice" value="${shangpin.mealprice}" class="form-control" style="width:125px;display:inline;"/>&nbsp;&nbsp;&nbsp;
		   <button class="btn btn-success" type="submit" class="btn" >查询</button>
	 </form>
	      	  <!---------------------------------- 新增商品模态框开始  -------------------------------->
	    	
	   
			<!-- 按钮触发模态框 -->
			<button class="btn btn-success" data-toggle="modal"  data-target="#myModal">
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
								新增菜品表
							</h4>
						</div>
						<div class="modal-body">
							<form role="form" id="form" method="post" class="table table-striped" action="${path }/upload_pictureinfo.action" enctype="multipart/form-data">
								  <div class="form-group">
									    <label for="name"></label>
									    <input type="hidden" class="form-control" id="mealid" name="mealid" value="${goods.meal_id }" placeholder="">
								  </div>
								  <div class="form-group">
								    <label for="name">菜品类型:</label>
								    <select name="mealtype" id="mealtype" class="form-control" >
									    <c:if test="${!empty type }">
									        <c:forEach items="${type }" var="type">
									          <option value="${type.meal_type }">${type.meal_type }</option>
									        </c:forEach>
									    </c:if>
								    </select>
								  </div>
								  <div class="form-group">
									    <label for="name">菜品名称:</label>
									    <input type="text" class="form-control" name="mealname" id="mealname" value="${goods.meal_name}" placeholder="请输入菜品名称">
									  	<span id="add"></span><br/>
								  </div>
								  <div class="form-group">
									    <label for="name">菜品价格:</label>
									  	<input id="mealprice" type="text" class="form-control" name="mealprice" value="${goods.meal_price}"  placeholder="请输入菜品价格"> <span id="priceWrong"></span>
								  </div>
								  <div class="form-group">
									    <label for="name">菜品预算:</label>
									  	<input id="mealbudget" type="text" class="form-control" name="mealbudget" value="${goods.meal_budget}"  placeholder="请输入菜品预算"> <span id="budgetWrong"></span>
								  </div>
								  <div class="form-group">
									    <label for="name">菜品介绍:</label>
									    <input type="text" class="form-control" name="mealdesc" id="mealdesc" value="${goods.meal_desc }" placeholder="请输入菜品介绍"><span id="desc"></span>
								  </div>
							</form>
							<form action="" id="uploadFormAct" >
						       <!--  指定文件名 --> <input type="hidden" name="filenameFileName" value= "" />     
						    	<input type="file" name="filename" onchange="checkFileExt(this.value)"/><span id="filename"></span>
						    	<!-- <input type="button"  id="fileBtn" onclick="doUpload()" value="文件上传"/> -->
							</form>
							  <input type="button" id="addBtn" value="保存" class="btn btn-success">
							  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						
	
	
						</div>
						
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div>
	    	
	    	<!---------------------------------- 新增商品模态框结束  -------------------------------->  
	 	 
			    <div id="content" class="table table-bordered">
			    	<table class="table table-striped">
				    	<tr>
				    		<th>菜品类型</th>
				    		<th>菜品名称</th>
				    		<th>菜品价格</th>
				    		<th>菜品介绍</th>	
				    		<th>菜品图片</th>
				    		<th>菜品状态</th>
				    		<th>操作</th>
				    	</tr>
			    	
				    	<c:if test="${!empty list}" >
				    		<c:forEach items="${list }" var="goods" varStatus="vars">
				    			<tr>
				    				<td>${goods.meal_type }</td>
				    				<td>${goods.meal_name}</td>
				    				<td>${goods.meal_price}</td>
				    				<td>${goods.meal_desc}</td>
				    				<td><%-- ${goods.meal_image} --%>
				    					<img src="${path }/resource/img/${goods.meal_image}" width="50" height="40">
				    				</td>
				    				<td>${goods.state}</td>
				    			  	<td>
										<a class="btn btn-success"  href="${path }/dc/Cai?mealid=${goods.meal_id}&mealname=${goods.meal_name}">菜品材料</a>
				    				
				    				<%-- 
				    				<!----------------------- 修改菜品模态框开始 ---------------------->
				    				
				    				<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalxiugai">修改</button>
										<!-- 模态框（Modal） -->
										<div class="modal fade" id="myModalxiugai" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										    <div class="modal-dialog">
										        <div class="modal-content">
										            <div class="modal-header">
										                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										                <h4 class="modal-title" id="myModalLabel">修改菜品表</h4>
										            </div>
										            <div class="modal-body">
										            
										            
										            	<form role="form" id="form" method="post" class="table table-striped" action="${path }/upload_pictureinfo.action" enctype="multipart/form-data">
															  <div class="form-group">
																    <label for="name"></label>
																    <input type="text" class="form-control" name="mealid" value="${goods.meal_id }" placeholder="">
															  </div>
															  <div class="form-group">
															    <label for="name">菜品类型:</label>
															    <select name="mealtype" id="mealtype" class="form-control" >
																    <c:if test="${!empty type }">
																        <c:forEach items="${type }" var="type">
																          <option value="${type.meal_type }">${type.meal_type }</option>
																        </c:forEach>
																    </c:if>
															    </select>
															  </div>
															  <div class="form-group">
																    <label for="name">菜品名称:</label>
																    <input type="text" class="form-control" name="mealname" value="${goods.meal_name}" placeholder="请输入菜品名称">
																  	<span id="add"></span><br/>
															  </div>
															  <div class="form-group">
																    <label for="name">菜品价格:</label>
																  	<input id="mealprice" type="text" class="form-control" name="mealprice" value="${goods.meal_price}"  placeholder="请输入菜品价格"> <span id="priceWrong"></span>
															  </div>
															  <div class="form-group">
																    <label for="name">菜品介绍:</label>
																    <input type="text" class="form-control" name="mealdesc" value="${goods.meal_desc }" placeholder="请输入菜品介绍"><span id="desc"></span>
															  </div>
														</form>
														<form action="" id="uploadFormAct" >
													       <!--  指定文件名 --> <input type="hidden" name="filenameFileName" value= ""/>     
													    	<input type="file" name="filename"/><span id="filename"></span>
													    	<!-- <input type="button"  id="fileBtn" onclick="doUpload()" value="文件上传"/> -->
														</form>
														  <input type="button" id="addBtn" value="保存" class="btn btn-success">
														  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
													
										           
										            </div>
										            
										        </div><!-- /.modal-content -->
										    </div><!-- /.modal -->
										</div>
				    				
				    				
				    				
				    				<!----------------------- 修改菜品模态框结束 ----------------------> --%>
				    				</td> 
				    			</tr>
				    		</c:forEach>
				    	</c:if>
			    
			    		<td colspan="12" id="pagenum" style="text-align: center">
			    			<c:if test="${!empty list}"><!--查询错误时不会显示页数  -->
				  				<a href="javascript:goTo(1)">首页</a>
				  			 	<c:if test="${page.nowpage!=1 }">
				  		   		<a href="javascript:goTo(${page.nowpage-1 })">上一页</a>
				  				</c:if>
				  				<c:if test="${page.nowpage!=page.sumpage }">
				  		 		<a href="javascript:goTo(${page.nowpage+1 })">下一页</a>
				  				</c:if>
				  				 <a href="javascript:goTo(${page.sumpage})">尾页</a>
			  				 
				  		 		<%-- <span>当前${page.nowpage }页</span>
				  				<a href="javascript:goTo($('#topage').val())">转到</a> --%>
				  				<%-- <input type="text" id="topage" value="${page.nowpage }" style="width:30px;">页 --%>
			  				</c:if>
			  		 		<span>共${page.sumpage }页</sapn>
			  	 			<span id="lastspan">共${page.sumcount }条记录</span>
			  			</td>
			    </table>
	    </div>
  </body>

</html>
