<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>写通知</title>

<link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="css/plugins/summernote/summernote.css" rel="stylesheet">
<link href="css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min.css?v=3.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
<form action="addmsgs.do" method="post" enctype="multipart/form-data" id="msgform" class="form-horizontal m-t">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-3">
				<div class="ibox float-e-margins">
					<div class="ibox-content mailbox-content">
						<div class="file-manager">
							<a class="btn btn-block btn-primary compose-mail"
								href="mail_compose.jsp">写通知</a>
							<div class="space-25"></div>
							<<h5>文件夹</h5>
                            <ul class="folder-list m-b-md" style="padding: 0">
                                <li>
                                    <a href="findpagemsglist.do"> <i class="fa fa-inbox "></i> 通知列表 
                                    </a>
                                </li>
                                <li>
                                    <a href="mailbox.jsp"> <i class="fa fa-envelope-o"></i> 发送的通知</a>
                                </li>
                                <li>
                                    <a href="mailbox.jsp"> <i class="fa fa-file-text-o"></i> 草稿
                                    </a>
                                </li>
                                <li>
                                    <a href="mailbox.jsp"> <i class="fa fa-trash-o"></i> 垃圾箱</a>
                                </li>
                            </ul>
						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-9 animated fadeInRight">
				<div class="mail-box-header">
					<div class="pull-right tooltip-demo">
						
					</div>
					<h2>写通知</h2>
				</div>
				<div class="mail-box">


					<div class="mail-body">

						
							<div class="form-group">
								<label class="col-sm-2 control-label">发送人：</label>

								<div class="col-sm-10">
									<input type="text" name="msgpeople" class="form-control" value="${user.username }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">主题：</label>

								<div class="col-sm-10">
									<input type="text" name="msgtitle" class="form-control" >
								</div>
							</div>
						

					</div>

					<div class="mail-text " >

						<div class="summernote" >
							

						</div>
						<div class="clearfix"></div>
					</div>
					<div class="mail-body text-right tooltip-demo">
                         <input type="file" name="file">
                         <textarea name="msgcon" id="msgcon" style="display: none"></textarea>
						<a onclick="javascript:al1();"
						class="btn btn-sm btn-primary"
							data-toggle="tooltip" data-placement="top" title="Send"><i
							class="fa fa-reply"></i> 立即发送
							
						</a> 
						<a	href="findpagemsglist.do"
							class="btn btn-white btn-sm" data-toggle="tooltip"
							data-placement="top" ><i
							class="fa fa-times"></i> 放弃</a> 
							
						<a onclick="javascript:al();"
							class="btn btn-white btn-sm" data-toggle="tooltip"
							data-placement="top"><i
							class="fa fa-pencil"></i> 存为草稿</a>
					</div>
					<div class="clearfix"></div>



				</div>
			</div>
		</div>
		
	</div>
	<input type="hidden" name="statu" id="msgstatu">
	</form>
	<!-- 全局js -->
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/bootstrap.min.js?v=3.4.0"></script>



	<script src="js/content.min.js?v=1.0.0"></script>


	<script src="js/plugins/iCheck/icheck.min.js"></script>

	<script src="js/plugins/summernote/summernote.min.js"></script>
	<script src="js/plugins/summernote/summernote-zh-CN.js"></script>
	<script>
		$(document).ready(function() {
			$(".i-checks").iCheck({
				checkboxClass : "icheckbox_square-green",
				radioClass : "iradio_square-green",
			});
			$(".summernote").summernote({
				lang : "zh-CN"
			})
		});
		var edit = function() {
			$(".click2edit").summernote({
				focus : true
			})
		};
		var save = function() {
			var a = $(".click2edit").code();
			$(".click2edit").destroy()
		};
	</script>
	
	<script type="text/javascript">
		function al() {
			var s = $(".note-editable").html();
			$("#msgcon").val(s);
			$("#msgstatu").val("0");
			$("#msgform").submit();
			
		}
		
		function al1() {
			var s = $(".note-editable").html();
			$("#msgcon").val(s);
			$("#msgstatu").val("1");
			$("#msgform").submit();
			
		}
	</script>


</body>

</html>