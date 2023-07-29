<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'class.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"
	type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
</head>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>

<body>
	<!-- 添加操作 -->
	<!--         <button type='button' class='btn btn-primary add' data-toggle='modal' data-target='#myadd' >添加</button>
 -->
	<table class="table table-striped">
		<caption>评论管理</caption>
		<thead>
			<tr>
				<th>评论编号</th>
				<th>评论内容</th>
				<th>评论人</th>
				<th>评论时间</th>
				<th>订单编号</th>
				<th>回复</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="mytbody">

		</tbody>
	</table>
	<!-- 分页信息 -->
	共
	<span id="totalPage"></span>页，当前是第
	<span id="nowPage"></span>页，
	<a href="javascript:(0)" id="prePage">上一页</a>，
	<a href="javascript:(0)" id="nextPage">下一页</a>

	<!-- 模态框（Modal） -->


	<!-- 模态框（Modal） -->
	<!--   开  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改
				</h4>
			</div>
			<div class="modal-body">
					<form class="form-horizontal" role="form" id="myform">
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">评论编号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="plaid" 
									name="comment.commentId"  >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">评论内容</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="plname" 
									   placeholder="请输入内容" name="comment.evaluate" >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">评论人</label>
							<div class="col-sm-10">
								<select id="username" class="form-control" name="comment.user.userId"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">评论时间</label>
							<div class="col-sm-10">
								<select id="times" class="form-control" name="comment.outOrder.outOrderId"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">订单编号</label>
							<div class="col-sm-10">
								<select id="num" class="form-control" name="comment.outOrder.outOuderNum"></select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button  class="btn btn-default" id="update">确认修改</button>
							</div>
						</div>
					</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div>/.modal-content
	</div>/.modal
	</div>
 <div class="modal fade" id="myadd" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加
				</h4>
			</div>
			<div class="modal-body">
					<form class="form-horizontal" role="form" id="myform2">
						
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">班级名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="lastname" 
									   placeholder="请输入名称" name="tabClasses.classesName" >
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">选择所在年级</label>
							<div class="col-sm-10">
								  <select id="selectgrade" class="form-control"name="tabClasses.tabGrade.tabGradeId"></select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">选择老师</label>
							<div class="col-sm-10">
								  <select id="selectteacherss" class="form-control" name="tabClasses.tabTeacher.tabTeacherId"></select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a  class="btn btn-default" id="add">确认添加</a>
							</div>
						</div>
					</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div>/.modal-content
	</div>/.modal
	</div>      关    -->
</body>
</html>
<script>
	var gradeinfo;
	var teacherinfo;
	//页面加载时同时加载年级信息
	$(function() {
		getCla(1);
		getGradeInfo();
		getTeacherInfo();

	})
	//得到所有的评论分页信息
	function getCla(nowPage) {
		
		$.ajax({
			url : "<%=basePath%>bkcomment/getAllComment.action",
			type : "post",
			dataType : "json",
			data : {
				"page.nowPage" : nowPage
			},
			success : function(data) {
				var datalist = data.list;
				//每次加载之前清空当前页面数据
				$("#mytbody").html("");
				var tr = "";
				for (var i = 0; i < datalist.length; i++) {
					var dt = new Date(datalist[i].outCreateDate);
					tr += "<tr>"
					tr += "<td>" + datalist[i].commentId + "</td>"
					tr += "<td>" + datalist[i].evaluate + "</td>"
					tr += "<td>" + datalist[i].userName + "</td>"
					tr += "<td>" + dt.Format("yyyy-MM-dd hh:mm:ss")+ "</td>"
					tr += "<td>" + datalist[i].outOuderNum + "</td>"
					tr += "<td>" + datalist[i].replay + "</td>"
					if(datalist[i].replay == ""){
						tr += "<td><button type='button' class='btn btn-primary update' data-toggle='modal' data-target='#myModal' id='" + datalist[i].commentId + "' onclick='Replay(this);'>回复</button>";
					}else{
						tr += "<td><button type='button' value='"+datalist[i].replay+"' class='btn btn-primary update' data-toggle='modal' data-target='#myModal' id='" + datalist[i].commentId + "' onclick='Replay(this);'>修改</button>";
					}
					tr += "<button type='button' class='btn btn-primary del' data-toggle='button' id='" + datalist[i].commentId + "'> 删除</button></td>";
					tr += "</tr>"
				}
				$("#mytbody").append(tr);

				$("#totalPage").html(data.totalPage);
				$("#nowPage").html(data.nowPage)
			}
		})

	}
	// 回复
	function Replay(bt) {
		var btid = bt.id;
		var ry = prompt('Please enter your replay:', bt.value);
		if(ry == ""){
			ry = bt.value;
		}
		$.ajax({
			url : "bkcomment/updateComment.action",
			type : "post",
			data : {
				"comment.commentId" : btid,
				"comment.replay" : ry,
			},
			dataType : "json",
			success : function(data) {
				if (data) {
					getCla(1);
				}
			}
		});

	}

	//删除
	$("#mytbody").on("click", ".del", function() {
		if (confirm("确定删除?")) {
			$.ajax({
				url : "bkcomment/delComment.action",
				type : "post",
				dataType : "text",
				data : {
					"commentId" : this.id
				},
				success : function(data) {
					//删除成功后,重新加载当前页面数据（table）
					var nowPage = parseInt($("#nowPage").html());
					getCla(nowPage);
				}
			})
		} else {
			return false;
		}
	})


	//点击上一页时事件  
	$("#prePage").click(function() {
		var prePage = parseInt($("#nowPage").html()) - 1;
		if (prePage < 1) {
			alert("当前已经是首页");
			prePage = 1
		}
		//重新加载上一页数据
		getCla(prePage);
	})
	//点击下一页时事件
	$("#nextPage").click(function() {
		var nextPage = parseInt($("#nowPage").html()) + 1;
		var totalPage = parseInt($("#totalPage").html())
		if (nextPage > totalPage) {
			alert("当前已经是最后一页");
			nextPage = totalPage
		}
		//重新加载下一页数据
		getCla(nextPage);
	});
	
	Date.prototype.Format = function(fmt)   
	{ 
	//author:wangweizhen
	  var o = {   
	    "M+" : this.getMonth()+1,                 //月份   
	    "d+" : this.getDate(),                    //日
	    "h+" : this.getHours(),                   //小时   
	    "m+" : this.getMinutes(),                 //分   
	    "s+" : this.getSeconds(),                 //秒   
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
	    "S"  : this.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	    if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;   
	}; 

</script>
