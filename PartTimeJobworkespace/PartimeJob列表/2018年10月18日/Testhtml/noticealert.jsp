<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>添加公告</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="${pageContext.request.contextPath}/backgroundSystem/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/backgroundSystem/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/backgroundSystem/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/backgroundSystem/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/backgroundSystem/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/backgroundSystem/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/backgroundSystem/css/style.min.css?v=3.2.0" rel="stylesheet">
</head>

<body class="gray-bg">
	<form action="${pageContext.request.contextPath}/notice/noticealert.action" method="post"
	 enctype="multipart/form-data" id="ggform" class="form-horizontal m-t">
	 <input type="hidden" name="n_id" value="${notice.n_id }">
	 <textarea id="n_body" name="n_body" style="display: none"></textarea>
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
				<div class="col-sm-12">
					<div class="col-sm-2"></div>
						<div class="col-sm-8">
			                <div class="mail-box-header">
			                    <div class="pull-right tooltip-demo">
			                        <a href="javascript:history.go(-1)" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="top" title="放弃"><i class="fa fa-times"></i> 放弃</a>
			                    </div>
			                    <h2>
			                    修改公告
			                </h2><h4><font color="red">${msg }</font></h4>
			                </div>
			                <div class="mail-box">
			                    <div class="mail-body">
			                    	<div class="form-group">
										<label class="col-sm-2 control-label">发送人：</label>
			
										<div class="col-sm-3"> 
											<input type="text" id="n_author" name="n_author" class="form-control" value="${notice.n_author }">
										</div>
										
										<label class="col-sm-2 control-label">浏览次数：</label>
			
										<div class="col-sm-3">
											<input type="text" id="n_count" name="n_count" class="form-control" value="${notice.n_count }">
											
											<input type="hidden" id="n_date" name="n_date" class="form-control" value="<fmt:formatDate value="${notice.n_date }" pattern="yyyy-MM-dd HH:mm:ss"/>" 
												/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">主题：</label>
			
										<div class="col-sm-8">
											<input type="text" id="n_title" name="n_title" class="form-control" value="${notice.n_title }">
										</div>
									</div>
			                    </div>
			
			                    <div class="mail-text h-200" >
			                        <div class="summernote" >
										${notice.n_body }
			                        </div>
			                        <div class="clearfix"></div>
			                    </div>
			                    <div class="mail-body text-right tooltip-demo">
			                        <a onclick="sends();" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Send"><i class="fa fa-reply"></i> 发送</a>
			                        <a href="javascript:history.go(-1)" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Discard email"><i class="fa fa-times"></i> 放弃</a>
			                    </div>
			                    <div class="clearfix"></div>
			                </div>
			             </div>
		            </div>
		       </div>
		   </div>
    </form>
    <!-- 添加 -->
    <script>
    	function sends(){
    		var n_author = $("#n_author").val();
			var n_title = $("#n_title").val();
			var n_count = $("#n_count").val();
			var s = $(".note-editable").html();
			if(n_author==''){
				alert("发布人不能为空");
			}else if(n_title==''){
				alert("标题不能为空");
			}else if(n_count==''){
				alert("浏览次数不能为空");
			}else if(s=='<p><br></p>'||s.trim()==''){
				alert("公告内容不能为空");
			}else{
				$("#n_body").val(s);
				$("#ggform").submit();
			}
    	}
    </script>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/backgroundSystem/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>
    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/backgroundSystem/js/content.min.js?v=1.0.0"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/iCheck/icheck.min.js"></script>
    <!-- SUMMERNOTE -->
    <script src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/summernote/summernote.min.js"></script>
    <script src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/summernote/summernote-zh-CN.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",});$(".summernote").summernote({lang:"zh-CN"})});var edit=function(){$(".click2edit").summernote({focus:true})};var save=function(){var a=$(".click2edit").code();$(".click2edit").destroy()};
    </script>
    <!-- layerDate plugin javascript -->
    <script src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/layer/laydate/laydate.js"></script>
    <script>
        laydate({elem:"#hello",event:"focus"});var start={elem:"#start",format:"YYYY/MM/DD hh:mm:ss",min:laydate.now(),max:"2099-06-16 23:59:59",istime:true,istoday:false,choose:function(a){end.min=a;end.start=a}};var end={elem:"#end",format:"YYYY/MM/DD hh:mm:ss",min:laydate.now(),max:"2099-06-16 23:59:59",istime:true,istoday:false,choose:function(a){start.max=a}};laydate(start);laydate(end);
    </script>
    

    <script type="${pageContext.request.contextPath}/backgroundSystem/text/javascript" src="../../../tajs.qq.com/stats@sId=9051096.jsp" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>