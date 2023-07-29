<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<!-- 代办的收货商品 -->
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
	<!-- 我的仓库 -->
	<input id="whid" type="hidden" value="${warehouse.whid }">
	<input id="userid" type="hidden" value="${user.id }">
	<div class="wrapper wrapper-content animated fadeInRight">
	    <div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>移货列表</h5>
					</div>
					<div class="ibox-content">
						<table class="table table-hover" align="center">
							<thead>
								<tr>
									<th>源仓库</th>
									<th>车辆</th>
									<th>货物名称</th>
									<th>货物型号</th>
									<th>数量</th>
									<th>单位</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id = "tbody">
								<c:forEach items="${maps.movelist }" var="move" varStatus="var">
									<tr height="50">
										<td>${move.mowhiname}</td>
										<td>
											<c:forEach items="${maps.carsinfoslist }" var="cars">
												<c:if test="${cars.id==move.carsid }">
													${cars.carsname }
												</c:if>
											</c:forEach>
										</td>
										<td>${move.ptay3.rece.productname}
										</td>
										<td>
											<c:forEach items="${maps.goodslist }" var="goods">
												<c:if test="${goods.tid==move.ptay3.rece.sku}">
                                    				${goods.tname }
                                    			</c:if>
											</c:forEach>
										</td>
										<td>${move.ptay3.rece.purchaseqty}</td>
										<td><c:if test="${move.ptay3.rece.unit==0 }">
											个
											</c:if> <c:if test="${move.ptay3.rece.unit==1 }">
												件
											</c:if> <c:if test="${move.ptay3.rece.unit==2 }">
												千克
											</c:if>
										<input id="${var.index+1 }unit" type="hidden" value="${move.ptay3.rece.unit }">
										<input id="${var.index+1 }size" type="hidden" value="${move.ptay3.rece.purchaseqty }">
										<input id="${var.index+1 }sku" type="hidden" value="${move.ptay3.rece.sku }">
										<input id="${var.index+1 }reid" type="hidden" value="${move.ptay3.rece.reid }">
										<input id="${var.index+1 }inid" type="hidden" value="${move.ptay3.rece.inid }">
										<input id="${var.index+1 }moid" type="hidden" value="${move.moid }">
										<input id="${var.index+1 }proid" type="hidden" value="${move.processInstanceId }">
										</td>
										<td>
											<c:if test="${move.mostate==1 }">
											 	<span class="label label-primary">移货中</span>
											</c:if>
										</td>
										<td>
											<c:if test="${move.mostate==1 }">
												<a id="${var.index+1 }" onclick="getrack(this.id);" data-toggle="modal"
													class="btn btn-white btn-sm" href="#modal-form">
													<i class="fa fa-folder"></i>
													收货
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
                    <h4 class="modal-title" id="myModalLabel">选择货架进行摆货</h4>
                </div>
                <div class="modal-body">
                	<!-- 自动增长 -->
					<form class="form-horizontal m-t" id="signupForm">
					<!-- <div class="input-group colorpicker-component demo demo-auto">这个是一开始设的大小 -->
						<div class="form-group">
							<label class="col-sm-4 control-label">货架名称：</label>
							
							<div class="col-sm-5" id="racks">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">剩余大小：</label>
<!-- 							<div class="col-sm-1"> -->
								<span id="shengyu" class="col-sm-1"></span>
<!-- 							</div> -->
							<label class="col-sm-3 control-label">需要大小：</label>
<!-- 							<div class="col-sm-1"> -->
								<span id="need" class="col-sm-1"></span>
<!-- 							</div> -->
						</div>
					</form>
				</div>
				<div class="modal-footer">
                    <button id="subtn" class="btn btn-primary" data-dismiss="modal" type="button" onclick="putaway();">提交</button>
                </div>
            </div>
        </div>
    </div>
	
	<!-- 获取货架 -->
	<script type="text/javascript">
		//用户id
		var userid = $("#userid").val();
		//全局的剩余大小 数组 和货架id 
		var rsurplus,rackid;
		//全局的需要多少大小
		var size;
		//收货id
		var reid;
		//入库计划id
		var inid;
		//保存货架id
		var sheid;
		//仓库id 根据用户固定的
		var whid;
		//移库moid 流程id
		var moid,proid;
		
		function getrack(ids){//获取这个仓库的货架 单位 状态 为条件
			//仓库id
			whid = $("#whid").val();
			//还有物品的单位也要获取到来
			var unit = $("#"+ids+"unit").val();
			//这个物品需要多少大小获取
			size = $("#"+ids+"size").val();
			//还有物品的类型也要获取到来
			var sku = $("#"+ids+"sku").val();
			//计划入库id 收货id 
			reid = $("#"+ids+"reid").val();
			inid = $("#"+ids+"inid").val();
			//移库moid 流程id
			moid = $("#"+ids+"moid").val();;
			proid = $("#"+ids+"proid").val();;
				
			$.post("${pageContext.request.contextPath}/receiving/racklist.do",{whid:whid,unit:unit,sku:sku},function(result){
				var racklists = result.racklist;
				//定义一个数组来存货架列表的数据 剩余大小list 
				rsurplus = new Array(racklists.length);
				rackid = new Array(racklists.length);
				$.each(racklists,function(index,rack){
					str+="<option value='"+rack.rid+"'>"+rack.rname+"</option>";
					rsurplus[index] = rack.rsurplus; 
					rackid[index] = rack.rid;
				});
				//下拉框				
				var str = "<select id='rid' onchange='states();' class='form-control m-b' name='rid' >";
				$.each(racklists,function(index,rack){
					str+="<option value='"+rack.rid+"'>"+rack.rname+"</option>";
				});
				str+="</select>"
				$("#racks").html(str);
				//获取剩余大小的大小赋给值
				if(rsurplus[0]!=null){
					$("#shengyu").html(rsurplus[0]);
				}else{
					$("#shengyu").html("");
				}
				//这个物品需要多大
				$("#need").html(size);
				if(size<=rsurplus[0]){
					$("#subtn").attr("disabled",false);
				}else{
					$("#subtn").attr("disabled",true);
				}
				sheid = rackid[0];
 			},"json");
		}
		function states(){
			//获取下标
			var index = $("#rid").get(0).selectedIndex;
			//赋值给剩余大小
			$("#shengyu").html(rsurplus[index]);
			if(size<=rsurplus[index]){
				$("#subtn").attr("disabled",false);
			}else{
				$("#subtn").attr("disabled",true);
			}
			sheid = rackid[index];
		}
		//点击按钮修改货架大小和添加摆货表数据还有修改审核状态
		function putaway(){
			//计划id 收货id 货架id	占用大小 移库moid 和 流程id 完成任务
			whid = $("#whid").val();
			userid = $("#userid").val();
			$.post("${pageContext.request.contextPath}/movestorage/updateto.do",{inid:inid,reid:reid,sheid:sheid,whid:whid,size:size,moid:moid,proid:proid},function(result){
				var bln = result.bln;
				if(bln==1){
					alert("收货成功");
					//重新加载
					location.href="${pageContext.request.contextPath}/movestorage/listto.do?userid="+userid;
				
				}else{
					alert("收货失败");
				}
			},"json");
		}
	</script>

</body>

</html>