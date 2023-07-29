<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 工资结算页面 -->

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
		$.post("lcy/json!selectSalary2.action",{y:year,m:month},function(data){
			var n=data.n;
			if(n==1){
				alert("此月已经结算，亲");
				return;
			}
			 var list=data.salary_list;
			//alert(list.length);
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
				
				var th9=$("<th>",{
					"text":"时间",
					"rowspan":"2"
				});
				
				var th10=$("<th>",{
					"html":"工资(&yen;)",
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
				tr1.append(th9);
				tr1.append(th10);
				
				tr1.append(th11);
				
				table.append(tr1);
				table.append(tr2);
				
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
					var td4=$("<td>",{
						"id":"td@"+obj.SALARY_EID+","+year+","+month,
						"text":obj.SALARY_MONEY
					});
					
					var input5=$("<input>",{
					
						"width":"50px",
						"id":"ipt_k@"+obj.SALARY_EID+","+year+","+month
					});
					var td5=$("<td>");
					td5.append(input5);
					td5.append("天");
					
					
					var input61=$("<input>",{
						"value":"0",
						"width":"50px",
						"id":"ipt1@"+obj.SALARY_EID+","+year+","+month
					});
					var td61=$("<td>");
					td61.append(input61);
					td61.append("天");
					
					var input62=$("<input>",{
						"value":"0",
						"width":"50px",
						"id":"ipt2@"+obj.SALARY_EID+","+year+","+month
					});
					var td62=$("<td>");
					td62.append(input62);
					td62.append("天");
					
					var input71=$("<input>",{
						"value":"0",
						"width":"50px",
						"id":"ipt3@"+obj.SALARY_EID+","+year+","+month
					});
					var td71=$("<td>");
					td71.append("&yen;");
					td71.append(input71);
					
					var input72=$("<input>",{
						"value":"0",
						"width":"50px",
						"id":"ipt4@"+obj.SALARY_EID+","+year+","+month
					});
					var td72=$("<td>");
					td72.append("&yen;");
					td72.append(input72);
					
					
					var input8=$("<input>",{
						"value":"0",
						"width":"50px",
						"id":"ipt5@"+obj.SALARY_EID+","+year+","+month
					});
					var td8=$("<td>");
					td8.append("&yen;");
					td8.append(input8);
					
					
					
					var td9=$("<td>",{
						"text":year+"/"+month
					});
					
					var input10=$("<input>",{
						"class":"form-control",
						"readonly":"true",
						"width":"100px",
						"id":"ipt10@"+obj.SALARY_EID+","+year+","+month
					});
					var td10=$("<td>");
					td10.append(input10);
					
					
					
					var a=$("<a>",{
						"class":"btn btn-success",
						"id":obj.SALARY_EID+","+year+","+month,
						"text":"结算",
						"href":'javascript:void(0)',
						"onclick":"tijiao(this);"
					});
					var td11=$("<td>");
					td11.append(a);
					
					
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
					tr.append(td9);
					tr.append(td10);
					
					tr.append(td11);
					
					table.append(tr);
				});
			
				$("#div1").html(table);
		},"json");
		
	}
	
	//结算
	function tijiao(a){
		
		//alert(${teacher});
		if(${teacher==null}){
			alert("请先登录！");
			return;
		}
		
		var y=$("#year").val();
		var m=$("#month").val();
		
		var id=a.id;
		//alert(id);
		
		var IDK="ipt_k@"+id;
		var ipt_k=document.getElementById(IDK).value;
		
		if(ipt_k==""){
		    alert("考核天数必填！");
			return;
		}
		if(isNaN(ipt_k)){
			alert("考核天数必须是数字！");
			return;
		}
		
		if(ipt_k%1!=0){
			alert("考核天数必须是整数");
			return;
		}
		if(parseInt(ipt_k)<15){
			alert("请填写合理的考核天数！");
			return;
		}
		
		var ID1="ipt1@"+id;
		//alert("文本框的ID1: "+ID1);
		var ipt1=document.getElementById(ID1).value;
		//alert(ipt1);
		if(isNaN(ipt1)){
			alert("病事假天数必须是数字！");
			return;
		}
		if(ipt1%1!=0){
			alert("病事假天数必须是整数");
			return;
		}
		
		if(parseInt(ipt1)>parseInt(ipt_k)){
			alert("请填写合理的病事假天数！");
			return;
		}
		
		
		var ID2="ipt2@"+id;
		//alert("文本框的ID2: "+ID2);
		var ipt2=document.getElementById(ID2).value;
		//alert(ipt2);
		if(isNaN(ipt2)){
			alert("未出勤天数必须是数字！");
			return;
		}
		if(ipt2%1!=0){
			alert("未出勤天数必须是整数");
			return;
		}
		if(parseInt(ipt2)>parseInt(ipt_k)){
			
			alert("请填写合理的未出勤天数！");
			return;
		}
		
		var sum1=parseInt(ipt1)+parseInt(ipt2);
		if(sum1>parseInt(ipt_k)){
			alert("请填写合理的病事假和未出勤天数！");
			return;
		}
		
		//获取底薪
		var dx=document.getElementById("td@"+id).innerText;
		//alert("底薪："+dx);
		
		var ID3="ipt3@"+id;
		//alert("文本框的ID3: "+ID3);
		var ipt3=document.getElementById(ID3).value;
		//alert(ipt3);
		if(isNaN(ipt3)){
			alert("违纪罚款必须是数字！");
			return;
		}
		if(parseFloat(ipt3)>parseFloat(dx)){
			alert("请填写合理的违纪罚款！");
			return;
		}
		
		
		var ID4="ipt4@"+id;
		//alert("文本框的ID4: "+ID4);
		var ipt4=document.getElementById(ID4).value;
		//alert(ipt4);
		if(isNaN(ipt4)){
			alert("迟到罚款必须是数字！");
			return;
		}
		if(parseFloat(ipt4)>parseFloat(dx)){
			alert("请填写合理的迟到罚款！");
			return;
		}
		
		var sum2=parseFloat(ipt3)+parseFloat(ipt4);
		//alert("sum: "+sum);
		if(sum2>parseFloat(dx)){
			alert("请填写合理的违纪罚款和迟到罚款！");
			return;
		}
		
		var ID5="ipt5@"+id;
		//alert("文本框的ID5: "+ID5);
		var ipt5=document.getElementById(ID5).value;
		//alert(ipt5);
		if(isNaN(ipt5)){
			alert("其他工资必须是数字！");
			return;
		}
		
		$.post("lcy/json!count_salary",{id:id,y:y,m:m,ipt_k:ipt_k,ipt1:ipt1,ipt2:ipt2,ipt3:ipt3,ipt4:ipt4,ipt5:ipt5},function(data){
			document.getElementById("ipt10@"+id).value="";
			ft=data.ft;
			sta2=data.sta2;
			if(sta2==1){
				document.getElementById("ipt10@"+id).value=ft;
				a.style.display="none";
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
										<i class="glyphicon glyphicon-user"></i> 结算工资
									</h2>

	
								</div>
								<div class="box-content" style="height: 1200px">
								
									<div style="height: 10px;"></div>
								
									<div>
										<input id="year" type="text"  name="" class="txt" />
										<b>年</b>
										<input id="month" type="text"  name="" class="txt" />
										<b>月</b>&nbsp;&nbsp;
										<b>员工工资</b>
									
										&nbsp;&nbsp;
										<input type="button" value="结算" style="font-family:'Microsoft YaHei' " onclick="jiazai();">
								   </div>
								   
								   <div style="height: 10px;"></div>
								   
								   <div id="div1">
								   
								   </div>
									
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


	

	</body>
</html>
