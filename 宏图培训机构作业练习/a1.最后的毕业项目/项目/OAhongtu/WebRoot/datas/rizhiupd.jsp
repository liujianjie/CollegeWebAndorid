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

  </head>
  
  <body>
  <jsp:include page="common.jsp"></jsp:include>
  <form action="liulirong/rizhiupd.action" method="post">
       <div class="box-content">
       <input type="hidden" name="rizhi.rid" value="${rzhi.rid }">
           	<label class="control-label">时间</label>
			<div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:20px">
               <input type="text" class="form-control" name="rizhi.rdate" value="${rzhi.rdate }" placeholder="请输入时间" style="width:242px;" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
           </div>
       </div>
         <div class="box-content" style="height:130px">
	       	<label class="control-label">日志</label>
				<div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:20px">
	            <textarea rows="5" cols="70" name="rizhi.rdesc">${rzhi.rdesc }</textarea>
	         </div>
         </div>
         
           <div class="box-content" style="height:130px">
	       	<label class="control-label">问题</label>
				<div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:20px">
	            <textarea rows="5" cols="70" name="rizhi.rques">${rzhi.rques }</textarea>
	         </div>
         </div>
         
           <div class="box-content">
				<div class="control-group">
              		<button type="submit" class="btn btn-default">修改</button>
              	</div>
           </div>
                 
       </form>  
        <!-- 日期类型 -->
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  </body>
</html>
