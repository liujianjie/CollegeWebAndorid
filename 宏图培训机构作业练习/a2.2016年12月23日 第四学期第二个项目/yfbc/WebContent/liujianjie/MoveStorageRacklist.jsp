<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<jsp:include page="PublicJsp.jsp"></jsp:include>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>H+ 后台主题UI框架 - 基础表格</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">


</head>

<body class="gray-bg">
	<br>
	<% Object user=session.getAttribute("user");%>
	<div class="wrapper wrapper-content animated fadeInRight">
	    <div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="col-sm-2">
					<select class="form-control m-b" id="rackid" onchange="getgoods(this.value);">
						<c:forEach items="${maps.racklist }" var="rack">
							<option value="${rack.rid }">${rack.rname }</option>
						</c:forEach>
					</select>
				</div>
				<input type="hidden" value="${whiname }" id="mowhiname">
				<input type="hidden" value="${user.id }" id="mouser">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>货物列表</h5>
					</div>
					<div class="ibox-content">
						<table class="table table-hover" align="center">
							<thead  align="center">
								<tr>
									<th>货物名称</th>
									<th>货物型号</th>
									<th>数量</th>
									<th>单位</th>
									<th>入库时间</th>
									<th>是否还在货架</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id = "tbody" >
								<c:forEach items="${maps.list }" var="put" varStatus="var">
									<tr height="50">
										<td>${put.rece.productname}
											<input type="hidden" id="${var.index }ptid" value="${put.ptid }"/>
										</td>
										<td>
											<c:forEach items="${maps.goodslist }" var="goods">
												<c:if test="${goods.tid==put.rece.sku}">
                                    				${goods.tname }
                                    			</c:if>
											</c:forEach>
										</td>
										<td>${put.rece.purchaseqty}</td>
										<td><c:if test="${put.rece.unit==0 }">
											个
										</c:if> <c:if test="${put.rece.unit==1 }">
											件
										</c:if> <c:if test="${put.rece.unit==2 }">
											千克
										</c:if></td>
										<td><fmt:formatDate value="${put.rece.receivedate }"
												pattern="yyyy-MM-dd HH-mm-ss"></fmt:formatDate></td>
										<td>
											<c:if test="${put.ptbln==0 }">
												<span class="label label-default">不存在</span>
											</c:if> 
											<c:if test="${put.ptbln==1 }">
												<span class="label label-primary">存在</span>
											</c:if> 
										</td>
										<td>
											<c:if test="${put.ptbln==1 }">
												<a id="${var.index}" onclick="fuzhi(this.id);" data-toggle="modal"
													class="btn btn-white btn-sm"
														href="#modal-form">
													<i class="fa fa-folder"></i>
												 	移库
												</a>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	
			<div class="col-sm-1"></div>
		</div>
	</div>
	
	<div id="modal-form" class="modal fade" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
            	<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">选择需要移到哪个仓库</h4>
                </div>
                <div class="modal-body">
                	<!-- 自动增长 -->
					<form class="form-horizontal m-t" id="signupForm">
						<div class="form-group">
		                	<label class="col-sm-4 control-label">仓库名称：</label>
							<div class="col-sm-6">
								<select class="form-control m-b" id="whid" name="whid" onchange="checksubtn();">
									<option></option>
					    			<c:forEach items="${maps.warelist }" var="war">
					    				<c:if test="${war.whiname != whiname }">
					    					<option value="${war.whiname},${war.userid}">${war.whiname }</option>
					    				</c:if>
					    			</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
		                	<label class="col-sm-4 control-label">选择车辆：</label>
							<div class="col-sm-6">
								<select class="form-control m-b" id="carsid" name="carsid" onchange="checksubtn();">
									<option></option>
					    			<c:forEach items="${maps.carsinfoslist }" var="car">
					    				<option value="${car.id }">${car.carsname }</option>
					    			</c:forEach>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
                    <button id="subtn" class="btn btn-primary" data-dismiss="modal" disabled="disabled" type="button" onclick="addmovestorage();">提交</button>
                </div>
            </div>
        </div>
    </div>

    <script>
      	//货架id 初始值 
        var rid = $("#rackid").val();
        
        function getgoods(a){
        	rid=a;
        	$("#tbody").html("");
        	$.post("getgoodslist.do",{rid:a},function(result){
				var list = result.list;
				var goodslist = result.goodslist;
				$.each(list,function(index,put){
					var input=$("<input>",{
						"type":"hidden",
						"value":put.ptid,
						"id":index+"ptid"
					})
					var tr = $("<tr>",{
						"height":50
					});
					var td = $("<td>",{
						"text":put.rece.productname
					});
					var skuname = "";
					$.each(goodslist,function(index,goods){
						if(goods.tid==put.rece.sku){
							skuname = goods.tname;
						}
					});
					var td2 = $("<td>",{
						"text":skuname
					});
					var td3 = $("<td>",{
						"text":put.rece.purchaseqty
					});
					var units = put.rece.unit;
					var unitname = "";
					if(units==0){
						unitname="个";
					}else if(units==1){
						unitname="件";
					}else if(units==2){
						unitname="千克";	
					}
					var td4 = $("<td>",{
						"text":unitname
					});
					var td7 = $("<td>",{
						"text":put.rece.receivedate
					});
					var shifou = "";
					(put.ptbln==0)?shifou="不存在":shifou="存在";
					var td5 = $("<td>",{
					});
					var span;
					if(shifou=="存在"){
						span = $("<span>",{
							"class":"label label-primary",
							"text":shifou
						});
					}else{
						span = $("<span>",{
							"class":"label label-default",
							"text":shifou
						});
					}
					td5.append(span);
					var td8 = $("<td>",{
						
					});
					if(put.ptbln==1){
						var a = $("<a>",{
							"class":"btn btn-primary",
							"href":"#modal-form",
							"data-toggle":"modal",
							"text":"移库",
							"id":index,
							"onclick":"fuzhi(this.id);"
							
						});
						td8.append(a);
					}
					tr.append(input);
					tr.append(td);tr.append(td2);
					tr.append(td3);tr.append(td4);
					tr.append(td7);
					tr.append(td5);tr.append(td8);
					$("#tbody").append(tr);
				});
			},"json");
        }
		function checksubtn(){
			if($("#whid").val()==""||$("#carsid").val()==""){
				$("#subtn").attr("disabled",true);
			}else{
				$("#subtn").attr("disabled",false);
			}
		}
		var ptid;//putaway的id
		var touser;//目标用户
		var towhiname;//目标仓库
		var mouser=$("#mouser").val();//移动用户
		var mowhiname=$("#mowhiname").val();//移动仓库
		var carsid;//车辆
		
		function fuzhi(index){
			ptid = $("#"+index+"ptid").val();
		}
		
		function addmovestorage(){
			var bln = confirm("你确定要发起移货操作?");
			if(bln){
				var userwhiname = $("#whid").val();
				towhiname = userwhiname.substring(0,userwhiname.indexOf(","));
				touser = userwhiname.substring(userwhiname.indexOf(",")+1,userwhiname.length);
				carsid = $("#carsid").val();//车辆
				//默认选中第一个下拉框 为了刷新
				$("#carsid option:first").attr("selected","selected");  
				$.post("add.do",{mouser:mouser,mowhiname:mowhiname,ptid:ptid,touser:touser,towhiname:towhiname,carsid:carsid},function(result){
					var bln = result.bln;
					if(bln==1){
						alert("发起移货成功,请在移库货物列表中查看进度");
						//修改车辆下拉框那个数量  就是其中那个途中不能存在了 刷新
						$("#carsid option[value="+carsid+"]").remove(); 
						getgoods(rid);
					}else{
						alert("发起移货失败");
					}
				},"json");
			}
		}	
		
		
	</script>

</body>

</html>