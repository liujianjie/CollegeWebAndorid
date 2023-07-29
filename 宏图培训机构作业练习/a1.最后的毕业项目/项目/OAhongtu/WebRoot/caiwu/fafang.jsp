<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 工资发放页面 -->

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


<style>



.ipt{
	width: 80px;
	font: 15px Arial;
	outline: 0; /*输入框被点击时外边框不显示蓝色*/
}

#year {
	width: 50px;
	font: 15px Arial;
	outline: 0; /*输入框被点击时外边框不显示蓝色*/
}
#month {
	width: 50px;
	font: 15px Arial;
	outline: 0; /*输入框被点击时外边框不显示蓝色*/
}



.txt {
	color: #0099ff;
	border-bottom: 1px solid #7d7d7d; /* 下划线效果 */
	border-top: 0px;
	border-left: 0px;
	border-right: 0px;
	background-color: transparent; /* 背景色透明 */
}
</style>

	
	
<script type="text/javascript">

	//加载
	function jiazai(){
	
		$("#div1").html("");
	
		var year=$("#year").val();
		var month=$("#month").val();
		if(year==""){
			alert("请填写年份！");
			return;
		}
		if(isNaN(year)){
			alert("年份必须是数字！");
			return;
		}
		if(year%1!=0){
			alert("年份必须是整数！");
			return;
		}
		var num1=0;
		for(var i=2016;i<2026;i++){
			if(i==parseInt(year)){
				num1=1;
			}
		}
		if(num1==0){
			alert("请填写合理的年份！");
			return;
		}
		
		if(month==""){
			alert("请填写月份！");
			return;
		}
		if(isNaN(month)){
			alert("月份必须是数字！");
			return;
		}
		if(month%1!=0){
			alert("月份必须是整数！");
			return;
		}
		var num2=0;
		for(var i=1;i<13;i++){
			if(i==parseInt(month)){
				num2=1;
			}
		}
		if(num2==0){
			alert("月份必须是1~12之间的数字！");
			return;
		}
	
		//alert("进来了");
		$.post("lcy/json!fafanglist.action",{year:year,month:month},function(data){
			
			var list=data.list_jiesuan;
			//alert(list.length);
			if(list.length==0){
				alert("没有数据,亲");
				return;
			}
			
			var table=$("<table>",{
				
				"class":"table table-striped table-bordered bootstrap-datatable datatable responsive"
				
			});
				
				var tr1=$("<tr>");
			
				var th1=$("<th>",{
					"text":"部门",
					"rowspan":"2",
					
					
				});
				var th2=$("<th>",{
					"text":"员工",
					"rowspan":"2"
				});
				var th3=$("<th>",{
					"text":"职务",
					"rowspan":"2"
				});
				var th4=$("<th>",{
					"html":"底薪(&yen;)",
					"rowspan":"2"
				});
				
				var th5=$("<th>",{
					"text":"考核天数",
					"rowspan":"2"
				});
				
				var th6=$("<th>",{
					"text":"缺勤天数",
					"colspan":"2"
				});
				
				
				var tr2=$("<tr>");
				var th61=$("<th>",{
					"text":"病事假",
				});
				var th62=$("<th>",{
					"text":"未出勤",
				});
				
				var th7=$("<th>",{
					"text":"其他扣款",
					"colspan":"2"
				});
				var th71=$("<th>",{
					"text":"违纪罚款",
				});
				var th72=$("<th>",{
					"text":"迟到罚款",
				});
				
				
				var th8=$("<th>",{
					"text":"其他工资",
					"rowspan":"2"
				});
				
				var th10=$("<th>",{
					"html":"工资(&yen;)",
					"rowspan":"2"
				});
				
				var th9=$("<th>",{
					"text":"时间",
					"rowspan":"2"
				});
				
				var th13=$("<th>",{
					"text":"结算人",
					"rowspan":"2"
				});
				
				var th12=$("<th>",{
					"text":"状态",
					"rowspan":"2"
				});
				
				
				
				var th11=$("<th>",{
					"text":"操作",
					"rowspan":"2"
				});
				
				
				tr1.append(th1);
				tr1.append(th2);
				tr1.append(th3);
				tr1.append(th4);
				tr1.append(th5);
				
				tr1.append(th6);
				tr2.append(th61);
				tr2.append(th62);
				
				tr1.append(th7);
				tr2.append(th71);
				tr2.append(th72);
				
				tr1.append(th8);
				tr1.append(th10);
				tr1.append(th9);
				
				tr1.append(th13);
				tr1.append(th12);
				
				tr1.append(th11);
				
				
				table.append(tr1);
				table.append(tr2);
				
				$.each(list,function(index,obj){
				
					var tr=$("<tr>");
					
					var td1=$("<td>",{
						
						"text":obj.DNAME
					});
					var td2=$("<td>",{
						"text":obj.ENAME
					});
					var td3=$("<td>",{
						"text":obj.JWORK
					});
					var td4=$("<td>",{
						
						"text":obj.DIXIN
					});
					
				
					var td5=$("<td>",{
						"text":obj.KAOHE_N
					});
				
					
					
					var td61=$("<td>",{
						"text":obj.BINGSHIJIA_N
					});
					
					
					var td62=$("<td>",{
						"text":obj.WEICHUQIN_N
					});
					
					
					var td71=$("<td>",{
						"text":obj.WEIJI_F
					});
					
				
					var td72=$("<td>",{
						"text":obj.CHIDAO_F
					});
					
				
					var td8=$("<td>",{
						"text":obj.OTHER_SALARY
					});
					
					var td10=$("<td>",{
						"text":obj.TOTAL_SALARY
					});
					
					var td9=$("<td>",{
						"text":obj.YEAR+"/"+obj.MONTH
					});
					
					var td13=$("<td>",{
						"text":obj.PERSON
					});
					
					var td12=$("<td>",{
						"id":"td@"+obj.EMPID+","+obj.YEAR+","+obj.MONTH,
						"text":obj.STATUS
					});
					
					var td11=$("<td>");
					if((obj.STATUS)=="未发放"){
						var a=$("<a>",{
							"id":obj.EMPID+","+obj.YEAR+","+obj.MONTH,
							"class":"btn btn-success",
							"text":"发放",
							"href":'javascript:void(0)',
							"onclick":"fafang(this);"
						});
						
						var a2=$("<a>",{
						"id":"a2@"+obj.EMPID+","+obj.YEAR+","+obj.MONTH,
						"text":"修改",
						"class":"btn btn-info",
						"href":'javascript:void(0)'
						});
						
						td11.append(a);
						td11.append(a2);
					}
				
					
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					tr.append(td5);
					
					tr.append(td61);
					tr.append(td62);
					
					tr.append(td71);
					tr.append(td72);
					
					tr.append(td8);
					tr.append(td10);
					tr.append(td9);
					
					tr.append(td13);
					tr.append(td12);
					
					tr.append(td11);
					
					
					table.append(tr);
				});
			
				$("#div1").html(table);
		},"json");
		
	}
	
	
	//发放
	function fafang(a){
		//alert("进了发放");
		var id=a.id;
		//alert(id);
		$.post("lcy/json!updFafang",{id:id},function(data){
			sta=data.sta;
			
			if(sta==1){
				document.getElementById("td@"+id).innerText="";
				document.getElementById("td@"+id).innerText="已发放";
				a.style.display="none";
				document.getElementById("a2@"+id).style.display="none";
			}
		},"json");
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
								<a href="index.jsp" target="_blank">主页</a>
							</li>
							<li>
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>
				
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i> 发放工资
									</h2>
								</div>
								<div class="box-content" style="height: 900px">
									
									<div style="height: 10px;"></div>
									
									<div>
										<input id="year" type="text"  name="" class="txt" />
										<b>年</b>
										<input id="month" type="text"  name="" class="txt" />
										<b>月</b>&nbsp;&nbsp;
										<b>工资结算情况</b>
									
										&nbsp;&nbsp;
										<input type="button" value="查看" style="font-family:'Microsoft YaHei' " onclick="jiazai();">
									
									</div>
									
									
									<div style="height: 10px;"></div>
									
									
									<div id="div1">
									
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
