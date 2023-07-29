<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
		<title>宏图软件办公系统</title>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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
		<link rel="shortcut icon" href="img/5.png" />
		<script>
				function sub(){
				
					document.getElementById("frm").submit();
				}
		</script>
		
		<!-- json获取表格list -->
		<script>
			function tables(cid,cname){
				$.post("chenru/list",{couid:cid,couname:cname},function(data){
					var list=data.list;
					
					//创建表table
					var table=$("<table>",{
						"class":"table table-striped table-bordered bootstrap-datatable datatable responsive",
						"id":"tabProduct"
					});	
					var thead=$("<thead>",{
					});
					var tr1=$("<tr>",{
					});
					var th1=$("<th>",{
						"text":"课程编号"					
					});
					var th2=$("<th>",{
						"text":"课程名称"					
					});
					var th3=$("<th>",{
						"text":"操作",
						"width":"33%"					
					});
					tr1.append(th1);
					tr1.append(th2);
					tr1.append(th3);
					thead.append(tr1);
					table.append(thead);
					var tbody=$("<tbody>",{
					});
					$.each(list,function(index,user){
						var tr=$("<tr>",{
						});
						var td1=$("<td>",{
							"class":"center",
							"text":user.couid				
						});
						var td2=$("<td>",{
							"class":"center"
						});
						//共存的课程 span and div
						var span=$("<span>",{
							"id":user.couid,
							"text":user.couname,
							"ondblclick":"start(this);"
						});
						var div=$("<div>",{
							"class":"control-group",
							"style":"height: 30px; width: 0px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: 0px"
						});
						var input=$("<input>",{
							"onblur":"end(this);",
							"id":"t"+user.couid,
							"type":"text",
							"class":"form-control",
							"value":user.couname,
							"style":"width: 80px;display: none"
						});
						div.append(input);
						var td3=$("<td>",{
							"class":"center"
						});
						var a1=$("<a>",{
							"class":"btn btn-primary",
							"id":"b"+user.couid,
							"onclick":"chu(this);",
							"text":"编辑"
						});
						var i1=$("<i>",{
							"class":"glyphicon glyphicon-edit icon-white"
						});
						var a2=$("<a>",{
							"class":"btn btn-danger",
							"href":"chenru/delcourse.action?course.couid="+user.couid,
							"text":"删除"
						});
						var i2=$("<i>",{
							"class":"glyphicon glyphicon-trash icon-white"
						});
						a1.append(i1);
						a2.append(i2);
						td2.append(span);
						td2.append(div);
						td3.append(a1);
						td3.append(a2);
						tr.append(td1);
						tr.append(td2);
						tr.append(td3);
						tbody.append(tr);
					});
					table.append(tbody);
					$("#div").html(table);	
				},"json");
			}
			tables(0,"");
		</script>
		
	</head>

	<body>

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
								<a href="#">课程管理</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 课程管理
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<form role="form" action="chenru/couadd.action" method="post"
											id="frm">
											<div style="float: right;">
												<label for="cname">
													课程名称：
												</label>
												<div class="form-group"
													style="height: 40px; width: 200px; display: inline-block; margin-bottom: 0; vertical-align: middle;">
													<input type="text" class="form-control"
														name="course.couname" placeholder="请输入课程名称" />
												</div>
												<a class="btn btn-success" href="#" onclick="sub();"> <i
											class="glyphicon glyphicon-pencil"></i>添加课程 </a>
											</div>
										</form>
									</div>

									<span id="div"></span>
<!--										<table-->
<!--											class="table table-striped table-bordered bootstrap-datatable datatable responsive"-->
<!--											id="tabProduct">-->
<!--											<thead>-->
<!--												<tr>-->
<!--													<th Name="Num">-->
<!--														课程编号-->
<!--													</th>-->
<!--													<th Name="Amount">-->
<!--														课程名称-->
<!--													</th>-->
<!--													<th width="33%">-->
<!--														操作-->
<!--													</th>-->
<!--												</tr>-->
<!--											</thead>-->
<!--											<tbody>-->
<!--												<c:forEach items="${list}" var="course">-->
<!--													<tr>-->
<!--														<td>-->
<!--															${course.couid}-->
<!--														</td>-->
<!--														<td class="center">-->
<!--															${course.couname }-->
<!--														</td>-->
<!--														<td class="center">-->
<!--															<a class="btn btn-info"-->
<!--																href="chenru/toupdcou.action?course.couid=${course.couid }">-->
<!--																<i class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>-->
<!--															<a class="btn btn-danger"-->
<!--																href="chenru/delcourse.action?course.couid=${course.couid }">-->
<!--																<i class="glyphicon glyphicon-trash icon-white"></i> 删除-->
<!--															</a>-->
<!--														</td>-->
<!--													</tr>-->
<!--												</c:forEach>-->
<!--											</tbody>-->
<!--										</table>-->
<!--									</form>-->
								</div>
							</div>
						</div>
						<!--/span-->

					</div>

				</div>
				<!--/row-->

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
		<!-- 可编辑表格 -->
		<script>
			//双击span
			function start(sp){
				var id=sp.id;
				//隐藏span 出现div
				sp.style.display="none";
				
				document.getElementById("t"+id).style.display="inline";
				document.getElementById("t"+id).focus();
			}
			//离开text
			function end(tex){
				var Id=tex.id;
				var id=Id.substring(Id.indexOf("t")+1,Id.length);
				var zhi=document.getElementById(id).innerText;
				
				if(tex.value!=zhi){//修改
					//tex.style.display="none";
					//根据id获取值 只有课程名变了把他放在form中 用request获取
					tables(id,tex.value);
				}else{//不修改
					//隐藏tex 出现span
					tex.style.display="none";
				
					document.getElementById(id).style.display="inline";
				}
			}
			function chu(bj){
				var Id=bj.id;
				var id=Id.substring(Id.indexOf("b")+1,Id.length);
				document.getElementById(id).style.display="none";	
				document.getElementById("t"+id).style.display="inline";	
				document.getElementById("t"+id).focus();
			}
			$("#div").html("<img src=img/ajax-loaders/ajax-loader-7.gif style=margin-left:400px;>");
			tables(0,"");
		</script>
		<!-- 可编辑表格 -->
	</body>
</html>
