<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 修改底薪页面 -->

<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
		<meta charset="utf-8">
		<title>Free HTML5 Bootstrap Admin Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description"
			content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
		<meta name="author" content="Muhammad Usman">

		<!-- The styles -->
		<link id="bs-css" href="css/bootstrap-cerulean.min.css"
			rel="stylesheet">

		<link href="css/charisma-app.css" rel="stylesheet">
		<link href='bower_components/fullcalendar/dist/fullcalendar.css'
			rel='stylesheet'>
		<link href='bower_components/fullcalendar/dist/fullcalendar.print.css'
			rel='stylesheet' media='print'>
		<link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
		<link href='bower_components/colorbox/example3/colorbox.css'
			rel='stylesheet'>
		<link href='bower_components/responsive-tables/responsive-tables.css'
			rel='stylesheet'>
		<link
			href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
			rel='stylesheet'>
		<link href='css/jquery.noty.css' rel='stylesheet'>
		<link href='css/noty_theme_default.css' rel='stylesheet'>
		<link href='css/elfinder.min.css' rel='stylesheet'>
		<link href='css/elfinder.theme.css' rel='stylesheet'>
		<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
		<link href='css/uploadify.css' rel='stylesheet'>
		<link href='css/animate.min.css' rel='stylesheet'>

		<!-- jQuery -->
		<script src="bower_components/jquery/jquery.min.js"></script>

		<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

		<!-- The fav icon -->
		<link rel="shortcut icon" href="img/favicon.ico">

<script type="text/javascript">

 	$(function(){
 		$.post("lcy/json!selDixin",{},function(data){
 			//alert("加载中..");
 			list=data.dixin_list;
 			//alert(list.length);
 			
 			var table=$("<table>",{
 				"class":"table table-striped table-bordered bootstrap-datatable datatable responsive"
 			});
 			var tr=$("<tr>");
 			var th1=$("<th>",{
 				"text":"部门"
 			});
 			var th2=$("<th>",{
 				"text":"员工姓名"
 			});
 			var th3=$("<th>",{
 				"text":"职务"
 			});
 			var th4=$("<th>",{
 				"text":"底薪"
 			});
 			var th5=$("<th>",{
 				"text":"操作"
 			});
 			tr.append(th1);
 			tr.append(th2);
 			tr.append(th3);
 			tr.append(th4);
 			tr.append(th5);
 			
 			table.append(tr);
 			
 			$.each(list,function(index,obj){
 			
 				var tr=$("<tr>");
	 			var td1=$("<td>",{
	 				"text":obj.SALARY_DNAME
	 			});
	 			var td2=$("<td>",{
	 				"text":obj.SALARY_ENAME
	 			});
	 			var td3=$("<td>",{
	 				"text":obj.SALARY_JWORK
	 			});
	 			
	 			
	 			var span=$("<span>",{
	 				"id":"s"+obj.SALARY_EID,
	 				"text":obj.SALARY_MONEY
	 				//"style":"border:1px solid green;"
	 			});
	 			var input=$("<input>",{
	 				"id":"i"+obj.SALARY_EID,
	 				"style":"display:none;width:60px;",
	 				"onblur":"isXiugai(this);",
	 				"value":obj.SALARY_MONEY
	 			});
	 			var td4=$("<td>");
	 			td4.append(span);
	 			td4.append(input);
	 			
	 			
	 			var a=$("<a>",{
	 				"id":obj.SALARY_EID,
	 				"class":"btn btn-primary",
	 				"text":"修改",
	 				"onclick":"xiugai(this);"
	 			});
	 			var td5=$("<td>");
	 			td5.append(a);
	 			
	 			tr.append(td1);
	 			tr.append(td2);
	 			tr.append(td3);
	 			tr.append(td4);
	 			tr.append(td5);
	 			
	 			table.append(tr);
 			});
 			
 			$("#div1").html(table);
 			
 		},"json");
 	});
 	
 	//编辑底薪
 	function xiugai(a){
 		//alert("有用");
 		var id=a.id;
 		document.getElementById("s"+id).style.display="none";
 		document.getElementById("i"+id).style.display="inline";
 		document.getElementById("i"+id).focus();
 	}
 	
 	//是否修改底薪
 	function isXiugai(ipt){
 		var val=ipt.value;
 		if(val==""){
 			alert("请填写底薪");
 			return;
 		}
 		//alert("失去焦点");
 		//Id.substring(Id.indexOf("t")+1,Id.length);
 		var ID=ipt.id;
 		var id=ID.substring(ID.indexOf("i")+1,ID.length);
 		//alert("员工id是:"+id);
 		var zhi=document.getElementById("s"+id).innerText;
 		//alert("span的值： "+zhi);
 		
 		if(val!=zhi){	//值被修改
 			$.post("lcy/json!updDixin",{eid:id,dixin:val},function(data){
 				var sta3=data.sta3;
 				//alert("sta3: "+sta3);
 				if(sta3==1){
 					//alert("修改成功");
 					document.getElementById("s"+id).innerText=val;
 					document.getElementById("i"+id).style.display="none";
 					document.getElementById("s"+id).style.display="inline";
 				}else{
 					alert("修改失败");
 				}
 				
 			},"json");
 		
 		}else{
 		
 			document.getElementById("i"+id).style.display="none";
 			document.getElementById("s"+id).style.display="inline";
 		}
 	}
</script>

	</head>

	<body>

		<div class="ch-container">
			<div class="row">

				<noscript>
					<div class="alert alert-block col-md-12">
						<h4 class="alert-heading">
							Warning!
						</h4>

						<p>
							You need to have
							<a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
							enabled to use this site.
						</p>
					</div>
				</noscript>

				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp" target="_blank">主页</a>
							</li>
							<li>
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>
					
				
					<div class="row" >
						<div class="box col-md-12">
							<div class="box-inner" style="height: 1200px;">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i>修改员工底薪
									</h2>
								</div>
								<div class="box-content" >
									
									<div id="div1" >
									
									</div>
									
									
								</div>
								
								
							</div>
						</div>

					</div>
					<!--/row-->
					
					
					
					
				</div>
				

				<!-- content ends -->
			</div>
			<!--/#content.col-md-0-->
		</div>
		<!--/fluid-row-->



		<!-- external javascript -->

		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

		<!-- library for cookie management -->
		<script src="js/jquery.cookie.js"></script>
		<!-- calender plugin -->
		<script src='bower_components/moment/min/moment.min.js'></script>
		<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
		<!-- data table plugin -->
		<script src='js/jquery.dataTables.min.js'></script>

		<!-- select or dropdown enhancer -->
		<script src="bower_components/chosen/chosen.jquery.min.js"></script>
		<!-- plugin for gallery image view -->
		<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
		<!-- notification plugin -->
		<script src="js/jquery.noty.js"></script>
		<!-- library for making tables responsive -->
		<script src="bower_components/responsive-tables/responsive-tables.js"></script>
		<!-- tour plugin -->
		<script
			src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
		<!-- star rating plugin -->
		<script src="js/jquery.raty.min.js"></script>
		<!-- for iOS style toggle switch -->
		<script src="js/jquery.iphone.toggle.js"></script>
		<!-- autogrowing textarea plugin -->
		<script src="js/jquery.autogrow-textarea.js"></script>
		<!-- multiple file upload plugin -->
		<script src="js/jquery.uploadify-3.1.min.js"></script>
		<!-- history.js for cross-browser state change on ajax -->
		<script src="js/jquery.history.js"></script>
		<!-- application script for Charisma demo -->
		<script src="js/charisma.js"></script>



	</body>
</html>
