<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addxuncha.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
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
   <form action="liulirong/roomupd.action" method="post">
    <div class="row">
			<div class="box col-md-12">
				<div class="box-inner" style="height:370px;">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-edit"></i> 修改宿舍巡查信息
						</h2>

					</div>
					<div class="box-content">
						<input type="hidden" name="sr.srid" value="${rs.srid }"/>
						<label for="exampleInputEmail1">&nbsp;&nbsp;巡查时间：</label>
						<div style="height:30px;width:215px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;">
							<input type="text" name="sr.srdate" value="${rs.srdate }" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});" class="form-control" style="width:190px;height:30px;">
						</div>
						<label for="exampleInputEmail1">寝室：</label>
						<div style="height:30px;width:170px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;">
							<select data-rel="chosen" name="sr.rooms" style="width:120px;">
							  <c:forEach items="${room}" var="r">
								<option value="${r.hourid }" ${r.hourid==rs.rooms?'selected':'' }>${r.hourname }</option>
							  </c:forEach>						
							</select>
						</div>  
						 
						<label for="exampleInputEmail1">卫生状况：</label>
						<div style="height:30px;width:170px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;">
							<select data-rel="chosen" name="sr.srclean"  style="width:120px;">
								<option value="优秀" ${rs.srclean=='优秀'?'selected':'' }>优秀</option>
								<option value="良好" ${rs.srclean=='良好'?'selected':'' }>良好</option>
								<option value="及格" ${rs.srclean=='及格'?'selected':'' }>及格</option>	
								<option value="较差" ${rs.srclean=='较差'?'selected':'' }>较差</option>								
							</select>
						</div>
						
						<div class="box-content" style="height:130px">
					       <label for="exampleInputEmail1" style="magin-bottom:18px;"> 情况说明：</label>
							 <div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:20px">
					            <textarea rows="9" cols="88" name="sr.srdesc" id="kind_editor">${rs.srdesc }</textarea>
					         </div>
				        </div>
				        
				         <div class="box-content">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 310px;margin-top:90px;">
													<b>修 改</b>
												</button>
											</div>
										</div>
			           
				</div>
			</div>
			
		</div>
	</form> 		
	</div>
	</div>
	</div>	
   
   <!-- 日期类型 -->
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  </body>
</html>
