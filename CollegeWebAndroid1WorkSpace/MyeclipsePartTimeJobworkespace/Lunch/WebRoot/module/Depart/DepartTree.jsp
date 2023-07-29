<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FunctionTree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link id="bootstrap_221" rel="stylesheet" type="text/css" class="library" href="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/css/bootstrap.min.css">
	<script id="jquery_172" type="text/javascript" class="library" src="http://sandbox.runjs.cn/js/sandbox/jquery/jquery-1.7.2.min.js"></script>
	<script id="bootstrap_221" type="text/javascript" class="library" src="http://sandbox.runjs.cn/js/sandbox/bootstrap-2.2.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${path }/resource/css/my.css">
   <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
   <script type="text/javascript">
		function toggli(obj){
			$(obj).parent().find(" > ul").toggle();
		} 
	</script> 
	 <style type="text/css">
	    .tree {
		    width:300px;
			float:left;
			height:100%;
		 }
		 .tree span{
			line-height: 20px;
			font-size: 20px;
			font-family: "楷体";
			font-weight: 600;
		 }
		 #conifr{
		   width:70%;
		   height:820px;
		 }
		 iframe {
		 padding-top:20px;
		border-top:1px solid #DDDDDD;
		border-left:1px solid #DDDDDD;
		border-right:1px solid #DDDDDD;
}
	</style>
	<script type="text/javascript">
	$(document).ready(function(){
	
	     	$.ajax({
	    		url:"${path}/depart_DepartTrees.action",
	    		type:"post",
	    		data:null,
	    		dataType:"json",
	    		success:function(data){
	    		   console.log(data);
	    		    var ul=$("<ul ></ul>");
	    		    var span=$("<li><span  onclick='toggli(this)'class='badge badge-success'>"+
	    		    ""+
	    		    "<i class='icon-folder-open'></i><a href='${path}/depart/SelectDepart' target='conifr' style='color:black'>部门列表</a></span></li>");
	    		     for(var i = 0;i<data.length;i++){	
		    		  	var departname = data[i].depart_name;
		    			var departid=data[i].depart_id;
		    			//var sons = data[i].sons;
		    			//if(sons!=null&&sons.length>0){
		    				var li =$("<ul class='ull'></ul>");
		    				var li1 =$("<li onclick='add(this)'><span class='badge badge-warning' onclick='toggli(this)' ><i class='icon-calendar'></i>"
		    				+"<a style='color:black' href='${path }/depart/UpdateDepart?departid="+departid+"' target='conifr'>"+departname+"</a></span></li>");
			    			/* for(var j=0;j<sons.length;j++){
			    			    var ul2=$("<ul class='ull'></ul>");
		    					var li2 =$("<li><span class='badge badge-important'><i class='icon-leaf'></i>"
		    					+"<a href='${path}/duty/UpdateDuty?dutyid="+sons[j].duty_id+"' target='conifr' style='color:black'>"+sons[j].duty_name+"</a></span></li>");
		    					ul2.append(li2);
		    					li1.append(ul2);
			    			}  */
			    			li.append(li1); 
			    			//}     
		    				span.append(li);
		    				ul.append(span);
		    		} 
		    		$(".tree").append(ul);
		    		$(".ull").hide(); 
	    		}
	    	});
	  });
	</script>
  </head>
  <body style="height:100%;width:100%;overflow-x: hidden;">
  	<div>
		<div class="tree">
        
		</div>	
		<iframe id="conifr" name="conifr" src="">
	          
        </iframe>
	</div>
  </body>
</html>
