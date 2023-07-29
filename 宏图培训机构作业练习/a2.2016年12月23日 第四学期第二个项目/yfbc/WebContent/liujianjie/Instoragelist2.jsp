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
	<c:forEach items="${maps.warelist }" var="ware">
		<c:if test="${ware.whid==in.whid }">
			<input id="whinames" type="hidden" value="${ware.whiname } ">                                   		
		</c:if>
	</c:forEach>
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
           	<div class="col-sm-1"></div>
            <div class="col-sm-10">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>入库计划单列表</h5>
                    </div>
                    <div class="ibox-content">
                    	 <div class="col-sm-12">
							<div class="col-sm-2">
								<input type="text" id="starttime" value="${maps.starttime }"
										class="form-control" placeholder="请选择开始时间" onclick="WdatePicker();">
							</div>
							<div class="col-sm-1">
								——
							</div>
							<div class="col-sm-2">
								<input type="text" id="endtime" value="${maps.endtime }"
										class="form-control" placeholder="请选择结束时间" onclick="WdatePicker();">
							</div>
							<div class="col-sm-2">
								<button class="btn btn-primary" onclick="inlist()">搜索</button>
							</div>
							<div class="col-sm-2">
								<button type="button" class="btn btn-primary"
									onclick="location.href='${pageContext.request.contextPath}/instorage/toadd.do'">添加入库单</button>
							</div>
							<div class="col-sm-2">
								<button type="button" class="btn btn-primary"
									onclick="location.href='${pageContext.request.contextPath}/instorage/outs.do'">导出格式</button>
							</div>
						</div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>计划入库时间</th>
                                    <th>产品名称</th>
                                    <th>商品类型</th>
                                    <th>数量</th>
                                    <th>供应商</th>
                                    <th>收货人</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach items="${maps.inlist }" var="in" varStatus="var">
                                <tr height="50">
                                    <td>
                                    	<fmt:formatDate value="${in.arrivaldate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                                    </td>
                                    <td>${in.productname }
                                    	<input id="${var.index+1 }productname" type="text" style="display:none " value="${in.productname }">
                                    </td>
                                    <td>
                                    	${in.sku }
                                    </td>
                                    <td>${in.purchaseqty }
                                    	<input id="${var.index+1 }count" type="text" style="display:none " value="${in.purchaseqty }">
                                    </td>
                                    <td>${in.supplier }
                                    	<input id="${var.index+1 }supplier" type="text" style="display:none " value="${in.supplier }">
                                    </td>
                                    <td>${in.receivename }
                                    	<input id="${var.index+1 }receivename" type="text" style="display:none " value="${in.receivename }">
                                    	<!-- 供应商号码 收货人号码  状态 单位-->
                                    	<input id="${var.index+1 }unit" type="text" style="display:none " value="${in.unit }">
                                    	<input id="${var.index+1 }supplierno" type="text" style="display:none " value="${in.supplierno }">
                                    	<input id="${var.index+1 }receiveno" type="text" style="display:none " value="${in.receiveno }">
                                    	<input id="${var.index+1 }instate" type="text" style="display:none " value="${in.instate }">
                                    </td>
                                    <td class="text-navy">
                                    	<a id="${var.index+1 }" href="#modal-form" data-toggle="modal"
											class="btn btn-white btn-sm" onclick="fuzhi(this.id);"><i class="fa fa-folder"></i>
												详情
										</a> 
                                    	<c:if test="${in.instate==0 }">
											<a href="${pageContext.request.contextPath }/receiving/toadd.do?id=${in.inid}" class="btn btn-white btn-sm"><i
													class="fa fa-pencil"></i>
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
                    <h4 class="modal-title" id="productname">欧普led灯</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal m-t" id="signupForm">
						<div class="form-group">
							<label class="col-sm-5 control-label">产品数量：<span id="count"></span></label>
							<label class="col-sm-5 control-label">单位：<span id="unit"></span></label>
						</div>
						
						<div class="form-group">
							<label class="col-sm-5 control-label">供应商：<span id="supplier"></span></label>
							<label class="col-sm-5 control-label">供应商电话：<span id="supplierno"></span></label>
						</div>
						
						<div class="form-group">
							<label class="col-sm-5 control-label">收货人：<span id="receivename"></span></label>
							<label class="col-sm-5 control-label">收货人号码：<span id="receiveno"></span></label>
						</div>
						
						<div class="form-group">
							<label class="col-sm-5 control-label">仓库：<span id="whiname"></span></label>
							<label class="col-sm-5 control-label">状态：<span id="instate"></span></label>
						</div>
					</form>
                </div>
				<div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    	var whinames = $("#whinames").val();
    	function fuzhi(ids){
    		//获取各个字段数据
    		var instates = $("#"+ids+"instate").val();
    		if(instates==0){
    			$("#instate").html("未收货");
    		}else{
    			$("#instate").html("已收货");
    		}
    		var receiveno = $("#"+ids+"receiveno").val();
    		var supplierno = $("#"+ids+"supplierno").val();
    		var unit = $("#"+ids+"unit").val();
    		if(unit==1){
    			$("#unit").html("个");
    		}else if(unit==2){
    			$("#unit").html("件");
    		}else if(unit==0){
    			$("#unit").html("千克");
    		}
    		
    		var receivename = $("#"+ids+"receivename").val();
    		var supplier = $("#"+ids+"supplier").val();
    		var count = $("#"+ids+"count").val();
    		var productname = $("#"+ids+"productname").val();
    		var arrivaldate = $("#"+ids+"arrivaldate").val();
    		$("#receiveno").html(receiveno);
    		$("#supplierno").html(supplierno);
    		
    		$("#whiname").html(whiname);
    		$("#receivename").html(receivename);
    		$("#supplier").html(supplier);
    		$("#count").html(count);
    		$("#productname").html(productname);
    	}
    </script>

    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

	<!-- 条件查询 -->
	<script>
		function inlist(){
			var starttime = $("#starttime").val();
			var endtime = $("#endtime").val();
			if(starttime==''){
				starttime=999;
			}
			if(endtime==''){
				endtime=999;
			}
			location.href="list2ofwhere.do?cpage=1&starttime="+starttime+"&endtime="+endtime+"";
		}
	</script>

	<!-- 分页 -->
	<script>
		function userlist(btn) {
			var starttime = $("#starttime").val();
			var endtime = $("#endtime").val();
			if(starttime==''){
				starttime=999;
			}
			if(endtime==''){
				endtime=999;
			}
			var id=btn.id;
			var currPage='${maps.currPage}';
			if(id=="btn1"||id=="btn4"){
				location.href="list2ofwhere.do?cpage="+(currPage-1)+"&starttime="+starttime+"&endtime="+endtime+"&v=0";
			}else if(id=="btn2"){
				location.href="list2ofwhere.do?cpage="+(currPage-3)+"&starttime="+starttime+"&endtime="+endtime+"&v=0";
			}else if(id=="btn3"){
				location.href="list2ofwhere.do?cpage="+(currPage-2)+"&starttime="+starttime+"&endtime="+endtime+"&v=0";
			}else if(id=="btn5"){
				location.href="list2ofwhere.do?cpage="+(currPage)+"&starttime="+starttime+"&endtime="+endtime+"&v=0";
			}else if(id=="btn7"){
				location.href="list2ofwhere.do?cpage="+(currPage+2)+"&starttime="+starttime+"&endtime="+endtime+"&v=0";
			}else if(id=="btn8"){
				location.href="list2ofwhere.do?cpage="+(currPage+3)+"&starttime="+starttime+"&endtime="+endtime+"&v=0";
			}else if(id=="btn9"||id=="btn6"){
				location.href="list2ofwhere.do?cpage="+(currPage+1)+"&starttime="+starttime+"&endtime="+endtime+"&v=0";
			}
		}
	</script>

</body>

</html>