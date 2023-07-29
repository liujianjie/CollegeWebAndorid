<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rizhi.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css"
			href="TimePick/jquery.datetimepicker.css" />

<link rel="stylesheet"
			href="kindeditor-4.1.10/themes/default/default.css" />
		<script charset="utf-8" src="kindeditor-4.1.10/kindeditor-min.js"></script>
		<script type="text/javascript">
		var editor;
		KindEditor.ready(function(k){
			 editor=k.create("#kind_editor", {
				items : [
							'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
							'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
							'insertunorderedlist', '|', 'emoticons']
					});
					
			editor=k.create("#kind_editor1", {
				items : [
							'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
							'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
							'insertunorderedlist', '|', 'emoticons']
					});
		});
</script>
  </head>
  
  <body>
  <jsp:include page="common.jsp"></jsp:include>
<div class="ch-container">
			<div class="row">

				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>
					<!-- content starts -->
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner" style="height: 550px;">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-edit"></i> 添加工作日志
									</h2>

								</div>
								<div class="box-content">
								
								
  <form action="liulirong/addrizhi.action" method="post">
       <div class="box-content">
           	<label class="control-label">时间：</label>
			<div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:20px">
               <input type="text" class="form-control" name="rizhi.rdate" placeholder="请输入时间" style="width:242px;" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
           </div>
       </div>
         <div class="box-content" style="height:130px">
	       	<label class="control-label">日志：</label>
				<div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:20px">
	            <textarea rows="5" cols="70" name="rizhi.rdesc" placeholder="请输入内容" id="kind_editor"></textarea>
	         </div>
         </div>
         <br/><br/>
           <div class="box-content" style="height:130px">
	       	<label class="control-label">问题：</label>
				<div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:20px">
	            <textarea rows="5" cols="70" name="rizhi.rques" placeholder="请输入问题" id="kind_editor1"></textarea>
	         </div>
         </div>
         
           <div class="box-content">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 320px; margin-top: 60px;">
													<b>添 加</b>
												</button>
											</div>
										</div>
                 
       </form>  
       	</div>
							</div>
						</div>
						<!--/span-->

					</div>
					<!--/row-->
        <!-- 日期类型 -->
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  </body>
</html>
