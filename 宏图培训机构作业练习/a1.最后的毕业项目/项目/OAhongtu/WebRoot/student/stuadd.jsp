<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	</head>

	<body>
		<jsp:include page="common.jsp"></jsp:include>
		<jsp:include page="tou.jsp"></jsp:include>
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
								<a href="#">学生管理</a>
							</li>
							<li>
								<a href="#">学生信息管理</a>
							</li>
							
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-edit"></i>添加学生
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i> </a>
										<a href="#" class="btn btn-close btn-round btn-default"><i
											class="glyphicon glyphicon-remove"></i> </a>
									</div>
								</div>

								<div class="box-content">
									<div class="alert alert-info">
										<a href="stu/listsx?addtolist=1">返回</a>
									</div>
									<b>请选择需要添加多少个学生</b><select id="count" onchange="xydsg(this);" data-rel="chosen" style="width: 80px;">
															<c:forEach begin="1" end="30" var="xs" step="1">
																<option value="${xs }" ${xs==1?"selected":""}>
																	${xs }
																</option>
															</c:forEach>
														</select>
									<hr>
									<form name="frm" action="stu/add?addtolist=1" method="post" enctype="multipart/form-data" onsubmit="return yanzhen();">
										<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<tr>		
												<th>
													班级
												</th>
												<th>
													宿舍
												</th>						
												<th>
													姓名
												</th>
												<th>
													性别
												</th>
												<th>
													年龄
												</th>
												<th>
													生日
												</th>
												
												<th>
													家长姓名
												</th>
												<th>
													联系电话
												</th>
												<th>
													家长联系电话
												</th>
												<th>
													联系地址
												</th>
												
												<th>
													照片
												</th>
												<th>
													入学时间
												</th>
												
											</tr>
											<!-- 少了个在读学校Intensch 和状态 和id主键-->
											<tbody id="sp">
												<tr>
													<td>
														<select name="classids"
																data-rel="chosen" style="width:90px;">
															<c:forEach items="${clslist}" var="cls">
																<option value="${cls.CLASSID }">${cls.CLASSNAME }</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select name="hourids"
																data-rel="chosen" style="width: 70px;">
															<c:forEach items="${hrslist}" var="hrs">
																<option value="${hrs.HOURID }">${hrs.HOURNAME }</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<input type="text" name="intennames"
																class="form-control" 
																style="width: 80px" >
													</td>
													<td>
														<select name="intensexs"
																data-rel="chosen" style="width: 60px;">
															<option value="男" selected="selected">男</option>
															<option value="女">女</option>
														</select>
													</td>
														
													<td>
														<select name="intenages"
																data-rel="chosen" style="width: 60px;">
															
															<c:forEach begin="15" end="30" var="xs" step="1">
																<option value="${xs }">
																	${xs }
																</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<input type="text" name="intenbirs"
																class="form-control" 
																style="width: 100px" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});" >
													</td>
													<td>
														<input type="text" name="intenfats"
																class="form-control" 
																style="width: 80px" >
													</td>
													<td>
														<input type="text" name="intentels" id="stutel"
																class="form-control" 
																style="width: 115px" >
													</td>
													<td>
														<input type="text" name="intenfatels" id="fatel"
																class="form-control" 
																style="width: 115px" >
													</td>
													<td>
														<input type="text" name="intenaddrs"
																class="form-control" 
																style="width: 100px" >
													</td>
													<td>
														<input type="file" name="files"
																
																style="width: 75px" >
													</td>
													
													<td>
														<input type="text" name="intentimes"
																class="form-control" 
																style="width: 100px" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
													</td>
												</tr>
											</tbody>
											<tbody id="sp2">
												<tr>
													<td colspan="12">
														<button type="submit" class="btn btn-success" class="glyphicon glyphicon-zoom-in icon-white" >录入</button>
													</td>
												<tr>
													
											</tbody>
										</table>
										<div id="divs" style="text-align: center" style="width:800px;height:300px"></div>
									</form>
									
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
		<SCRIPT type="text/javascript">
			function xydsg(sel){
				var list=sel.value;
				$("#divs").html("<img src=img/ajax-loaders/ajax-loader-7.gif>");
				$("#sp").html("");
				$("#sp2").html("");
				//先消失 再出来
				document.getElementById("sp").style.display="none";
				$.post("stu/toadd",{},function(data){
					var clslist=data.clslist;
					var hrslist=data.hrslist;
					//tr
					for(var i=0;i<list;i++){
						var tr=$("<tr>",{
							"align":"center"
						});
						//获取班级
						var td1=$("<td>",{
							"align":"center"
						});
						
						var select=$("<select>",{
							"name":"classids",
							"class":"chosen",
							"style":"width:90px"
						});
						$.each(clslist,function(index,user){
							var option=$("<option>",{
								"value":user.CLASSID,
								"text":user.CLASSNAME
							});
							select.append(option);
						});
						td1.append(select);
						//宿舍
						var td2=$("<td>",{
						"align":"center"
						});
						var select2=$("<select>",{
							"name":"hourids",
							"data-rel":"chosen",
							"style":"width:90px"
						});
						$.each(hrslist,function(index,user){
							var option=$("<option>",{
								"value":user.HOURID,
								"text":user.HOURNAME
							});
							select2.append(option);
						});
						td2.append(select2);
						//姓名
						var td3=$("<td>",{
							"align":"center"
						});
						var input3=$("<input>",{
							"type":"text",
							"name":"intennames",
							"class":"form-control",
							"style":"width:80px"
						});
						td3.append(input3);
						
						//性别
						var td4=$("<td>",{
							"align":"center"
						});
						var select4=$("<select>",{
							"name":"intensexs",
							"class":"chosen",
							"style":"width:60px"
						});
						var option41=$("<option>",{
								"value":"男",
								"text":"男"
						});
						var option42=$("<option>",{
								"value":"女",
								"text":"女"
						});
						select4.append(option41);
						select4.append(option42);
						td4.append(select4);
						//年龄
						var td5=$("<td>",{
							"align":"center"
						});
						var select5=$("<select>",{
							"name":"intenages",
							"class":"chosen",
							"style":"width:60px"
						});
						for(var ii=15;ii<30;ii++){
							var option=$("<option>",{
								"value":ii,
								"text":ii
							});
							select5.append(option);
						}
						td5.append(select5);
						//生日
						var td6=$("<td>",{
							"align":"center"
						});
						var input6=$("<input>",{
							"type":"text",
							"name":"intenbirs",
							"class":"form-control",
							"style":"width:100px",
							"onclick":"WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});"
						});
						td6.append(input6);
						//家长姓名
						var td7=$("<td>",{
							"align":"center"
						});
						var input7=$("<input>",{
							"type":"text",
							"name":"intenfats",
							"class":"form-control",
							"style":"width:80px"
						});
						td7.append(input7);
						
						//联系电话
						var td8=$("<td>",{
							"align":"center"
						});
						var input8=$("<input>",{
							"type":"text",
							"name":"intentels",
							"class":"form-control",
							"id":"stutel"+i,
							"style":"width:115px"
						});
						td8.append(input8);
						
						//家长电话
						var td9=$("<td>",{
							"align":"center"
						});
						var input9=$("<input>",{
							"type":"text",
							"name":"intenfatels",
							"class":"form-control",
							"id":"fatel"+i,
							"style":"width:115px"
						});
						td9.append(input9);
						//联系地址
						var td10=$("<td>",{
							"align":"center"
						});
						var input10=$("<input>",{
							"type":"text",
							"name":"intenaddrs",
							"class":"form-control",
							"style":"width:100px"
						});
						td10.append(input10);
						//头像
						var td11=$("<td>",{
							"align":"center"
						});
						var input11=$("<input>",{
							"type":"file",
							"name":"files",
							"style":"width:75px"
						});
						td11.append(input11);
						//入校
						var td12=$("<td>",{
							"align":"center"
						});
						var input12=$("<input>",{
							"type":"text",
							"name":"intentimes",
							"style":"width:100px",
							"onclick":"WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});"
						});
						td12.append(input12);

						tr.append(td1);tr.append(td2);
						tr.append(td3);tr.append(td4);
						tr.append(td5);tr.append(td6);
						tr.append(td7);tr.append(td8);
						tr.append(td9);tr.append(td10);
						tr.append(td11);tr.append(td12);
						$("#sp").append(tr);
					}
					//做个小特效
					$("#sp").fadeIn(600);
					
					var tr2=$("<tr>",{
					
					});
					var td=$("<td>",{
						"colspan":"12",
						"align":"right"
					});
					var button=$("<button>",{
						"type":"submit",
						"class":"btn-success",
						"text":"添加",
						"style":"width:60px;height:30px"
					});
					td.append(button);
					tr2.append(td);
					$("#sp2").append(tr2);
					$("#divs").html("");
				},"json");
			}
			
			//验证开始
			function yanzhen(){
				//一开始的一个学生
				var stutel=document.getElementById("stutel").value;
				var fatel=document.getElementById("fatel").value;
				if(stutel.length!=11){
					alert("学生联系电话错误,请重新填写");
					document.getElementById("stutel").focus();
					return false;
				}else if(fatel.length!=11){
					alert("家长联系电话错误,请重新填写");
					document.getElementById("fatel").focus();
					return false;
				}
				return true;
			}
		</SCRIPT>
	</body>
</html>


