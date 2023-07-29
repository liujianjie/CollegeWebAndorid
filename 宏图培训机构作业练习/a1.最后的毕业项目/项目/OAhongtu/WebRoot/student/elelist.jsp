<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
		<!-- json获取表格list -->
		<script>
			
			function tables(id,ename){
				$.post("hourse/elelist",{eid:id,eename:ename},function(data){
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
						"text":"序号"					
					});
					var th2=$("<th>",{
						"text":"单元名称"					
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
							"text":index+1
						});
						var td2=$("<td>",{
							"class":"center"
						});
						//共存的课程 span and div
						var span=$("<span>",{
							"id":user.EID,
							"text":user.ENAME,
							"ondblclick":"start(this);"
						});
						var div=$("<div>",{
							"class":"control-group",
							"style":"height: 30px; width: 0px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: 0px"
						});
						var input=$("<input>",{
							"onblur":"end(this);",
							"id":"t"+user.EID,
							"type":"text",
							"class":"form-control",
							"value":user.ENAME,
							"style":"width: 80px;display: none"
						});
						div.append(input);
						var td3=$("<td>",{
							"class":"center"
						});
						var a1=$("<a>",{
							"class":"btn btn-primary",
							"id":"b"+user.EID,
							"onclick":"chu(this);",
							"text":"编辑"
						});
						var i1=$("<i>",{
							"class":"glyphicon glyphicon-edit icon-white"
						});
						var a2=$("<a>",{
							"class":"btn btn-danger",
							"href":"hourse/eledel?ele.eid="+user.EID,
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
			
		</script>
	</head>

	<body>
	<jsp:include page="common.jsp"></jsp:include>
	<div class="ch-container">
    <div class="row"> 

				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
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

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i>
										宿舍单元信息
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info">
										<a class="btn btn-success" href="student/eleadd.jsp"> <i
											class="glyphicon glyphicon-pencil"></i> 添加单元 </a> 
									</div>
									<div id="div" style="text-align: center"  style="width:800px;height:300px"></div>
									
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
		
		<SCRIPT type="text/javascript">
			//双击sapn
			function start(span){
				var id=span.id;
				
				span.style.display="none";
				document.getElementById("t"+id).style.display="inline";
				
				document.getElementById("t"+id).select();
			}
			//点击编辑
			function chu(a){
				var id=a.id;
				var id=id.substring(id.indexOf("b")+1,id.length)
				document.getElementById(id).style.display="none";
				document.getElementById("t"+id).style.display="inline";
				document.getElementById("t"+id).select();
			}
			
			function end(text){
				var ID=text.id;
				var id=ID.substring(ID.indexOf("t")+1,ID.length);
				//判断是影藏还是修改
				var spanename=document.getElementById(id).innerText;
				if(spanename!=text.value){//跳转
					tables(id,text.value);
				}else{
					//影藏
					text.style.display="none";
					document.getElementById(id).style.display="inline";
				}
			}
			$("#div").html("<img src=img/ajax-loaders/ajax-loader-7.gif style=margin-left:50px;>");
			tables(0,"");
		</SCRIPT>

	</body>
</html>
