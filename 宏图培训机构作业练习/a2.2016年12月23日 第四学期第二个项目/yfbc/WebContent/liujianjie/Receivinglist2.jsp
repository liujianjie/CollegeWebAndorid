<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	 <!-- js -->
	<jsp:include page="PublicJsp.jsp"></jsp:include>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>H+ 后台主题UI框架 - 基础表格</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">	
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>收货列表</h5>
					</div>
					<div class="ibox-content">
						<div class="col-sm-12">
							<div class="col-sm-2">
								<select class="form-control" id="unit" name="unit">
									<option>单位</option>
									<option value="0" ${maps.unit==0?'selected':'' }>个</option>
									<option value="1" ${maps.unit==1?'selected':'' }>件</option>
									<option value="2" ${maps.unit==2?'selected':'' }>千克</option>
								</select>
							</div>
							<div class="col-sm-2">
								<select class="form-control" id="sku" name="sku">
									<option>货物类型</option>
									<c:forEach items="${maps.goodslist }" var="goods">
										<option value="${goods.tid}" ${goods.tid==maps.sku?'selected':'' }>${goods.tname }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<button class="btn btn-primary" onclick="recelist()">搜索</button>
							</div>
						</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th >入库时间</th>
									<th >仓库</th>
									<th >货物名称</th>
									<th >货物型号</th>
									<th >数量</th>
									<th >单位</th>
									<th >坏货数量</th>
									<th >操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${maps.relist }" var="rec" varStatus="var">
									<tr height="50">
										<td><fmt:formatDate value="${rec.receivedate }"
												pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
										<td><c:forEach items="${maps.warelist }" var="ware">
												<c:if test="${ware.whid==rec.whid }">
	                                    			${ware.whiname }
	                                    		</c:if>
											</c:forEach>
											<input id="${var.index+1 }reid" type="text" style="display:none " value="${rec.reid }">
											<input id="${var.index+1 }inid" type="text" style="display:none " value="${rec.inid }">
											<input id="${var.index+1 }whid" type="text" style="display:none " value="${rec.whid }">
										</td>
										<td>
											${rec.productname}
										</td>
										<td><c:forEach items="${maps.goodslist }" var="goods">
												<c:if test="${goods.tid==rec.sku }">
                                    				${goods.tname }
                                    			</c:if>
											</c:forEach>
											<input id="${var.index+1 }sku" type="hidden" value="${rec.sku }">
										</td>
										<td>${rec.purchaseqty }
											<input id="${var.index+1 }size" type="hidden"  value="${rec.purchaseqty }">
										</td>
										<td>
											<c:if test="${rec.unit==0 }">
												个
											</c:if>
											<c:if test="${rec.unit==1 }">
												件
											</c:if>
											<c:if test="${rec.unit==2 }">
												千克
											</c:if>
											<input id="${var.index+1 }unit" type="text" style="display:none " value="${rec.unit }">
										</td>
										<td>${rec.shortqty }</td>
										<!-- 如果是越库则要拣货 -->
										<td class="text-navy">
											<c:if test="${rec.putstate==0 }">
												<a id="${var.index+1 }" onclick="getrack(this.id);" data-toggle="modal"
													class="btn btn-primary" href="#modal-form">
													摆货
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
		 <div class="row">
			<div class="btn-group col-sm-8"></div>
			<div class="btn-group col-sm-4">
				共${maps.totalcount }条记录 ${maps.currPage }/${maps.totalPage }页
				
				<a><button type="button" id="btn1" onclick="userlist(this);" class="btn btn-white">
					<i class="fa fa-chevron-left"></i>
				</button></a>
				<c:if test="${maps.currPage-3>0}">
					<a><button id="btn2" onclick="userlist(this);" class="btn btn-white">${maps.currPage-3}</button></a>
				</c:if>
				<c:if test="${maps.currPage-2>0}">
					<a><button id="btn3" onclick="userlist(this);" class="btn btn-white">${maps.currPage-2}</button></a>
				</c:if>
				<c:if test="${maps.currPage-1>0}">
					<a><button id="btn4" onclick="userlist(this);" class="btn btn-white">${maps.currPage-1}</button></a>
				</c:if>
				<a><button id="btn5" onclick="userlist(this);" class="btn btn-white  active">${maps.currPage}</button></a>
				<c:if test="${maps.currPage+1<= maps.totalPage}">
					<a><button id="btn6" onclick="userlist(this);" class="btn btn-white">${maps.currPage+1}</button></a>
				</c:if>
				<c:if test="${maps.currPage+2<= maps.totalPage}">
					<a><button id="btn7" onclick="userlist(this);" class="btn btn-white">${maps.currPage+2}</button></a>
				</c:if>
				<c:if test="${maps.currPage+3<= maps.totalPage}">
					<a><button id="btn8" onclick="userlist(this);" class="btn btn-white">${maps.currPage+3}</button></a>
				</c:if>
				<a><button type="button" id="btn9" onclick="userlist(this);" class="btn btn-white">
					<i class="fa fa-chevron-right"></i>
				</button></a>
			</div>
			<!-- 		end 页脚	 -->
		</div>
	</div>

	<div id="modal-form" class="modal fade" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
            	<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">进行摆货</h4>
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
		//仓库id 摆货字段
		var whid;
		
		function getrack(ids){//获取这个仓库的货架
			//获取到id 就可以获取到这行数据的仓库id
			whid = $("#"+ids+"whid").val();
			//还有物品的单位也要获取到来
			var unit = $("#"+ids+"unit").val();
			//还有物品的类型也要获取到来
			var sku = $("#"+ids+"sku").val();
			//这个物品需要多少大小获取
			size = $("#"+ids+"size").val();
			//计划入库id 收货id 
			reid = $("#"+ids+"reid").val();
			inid = $("#"+ids+"inid").val();
				
			$.post("racklist.do",{whid:whid,unit:unit,sku:sku},function(result){
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
		//点击按钮修改货架大小和添加摆货表数据还有修改收货状态 有没有摆货
		function putaway(){
			//计划id 收货id 货架id	占用大小
			$.post("addputaway.do",{inid:inid,reid:reid,sheid:sheid,whid:whid,size:size},function(result){
				var bln = result.bln;
				if(bln==1){
					alert("摆货成功");
					//重新加载
					location.href="${pageContext.request.contextPath}/receiving/list.do?cpage=1";
					//还要一个收货的摆货状态
				}else{
					alert("摆货失败");
				}
			},"json");
		}
	</script>
<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});
		});
	</script>
	<!-- 条件查询 -->
	<script>
		function recelist(){
			var unit = $("#unit").val();
			var sku = $("#sku").val();
			if(unit=='单位'){
				unit=999;
			}
			if(sku=='货物类型'){
				sku=999;
			}
			location.href="list2ofwhere.do?cpage=1&unit="+unit+"&sku="+sku+"";
		}
	</script>
	
	<!-- 分页 -->
	<script>
		function userlist(btn) {
			var unit = $("#unit").val();
			var sku = $("#sku").val();
			if(unit=='单位'){
				unit=999;
			}
			if(sku=='货物类型'){
				sku=999;
			}
			var id=btn.id;
			var currPage='${maps.currPage}';
			if(id=="btn1"||id=="btn4"){
				location.href="list2ofwhere.do?cpage="+(currPage-1)+"&unit="+unit+"&sku="+sku+"&v=0";
			}else if(id=="btn2"){
				location.href="list2ofwhere.do?cpage="+(currPage-3)+"&unit="+unit+"&sku="+sku+"&v=0";
			}else if(id=="btn3"){
				location.href="list2ofwhere.do?cpage="+(currPage-2)+"&unit="+unit+"&sku="+sku+"&v=0";
			}else if(id=="btn5"){
				location.href="list2ofwhere.do?cpage="+(currPage)+"&unit="+unit+"&sku="+sku+"&v=0";
			}else if(id=="btn7"){
				location.href="list2ofwhere.do?cpage="+(currPage+2)+"&unit="+unit+"&sku="+sku+"&v=0";
			}else if(id=="btn8"){
				location.href="list2ofwhere.do?cpage="+(currPage+3)+"&unit="+unit+"&sku="+sku+"&v=0";
			}else if(id=="btn9"||id=="btn6"){
				location.href="list2ofwhere.do?cpage="+(currPage+1)+"&unit="+unit+"&sku="+sku+"&v=0";
			}
		}
	</script>

</body>

</html>