<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 查看邮件</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			 <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-content mailbox-content">
                        <div class="file-manager">
                            <a class="btn btn-block btn-primary compose-mail" href="mail_compose.jsp">写通知</a>
                            <div class="space-25"></div>
                            <h5>文件夹</h5>
                            <ul class="folder-list m-b-md" style="padding: 0">
                                <li>
                                    <a href="findpagemsglist.do"> <i class="fa fa-inbox "></i> 通知列表 
                                    </a>
                                </li>
                                <li>
                                    <a href="findpagemsgmylist.do?msgstatu=1&v=whm"> <i class="fa fa-envelope-o"></i> 发送的通知</a>
                                </li>
                                <li>
                                    <a href="findpagemsgmylist.do?msgstatu=0&v=whm"> <i class="fa fa-file-text-o"></i> 草稿 
                                    </a>
                                </li>
                                <li>
                                    <a href="findpagemsgmylist.do?msgstatu=2&v=whm"> <i class="fa fa-trash-o"></i> 垃圾箱</a>
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
						<c:if test="${msg.msgstatu eq '0'}">
							 <a href="tijiao.do?id=${msg.id }&msgstatu=2&v=whm" class="btn btn-white btn-sm"
								data-toggle="tooltip" data-placement="top" title="标为垃圾邮件"><i
								class="fa fa-trash-o"></i> </a>
						</c:if>
					</div>
					<h2>查看通知</h2>
					<div class="mail-tools tooltip-demo m-t-md">


						<h3>
							<span class="font-noraml">主题： </span>${msg.msgtitle }
						</h3>
						<h5>
							<span class="pull-right font-noraml"><fmt:formatDate
									value="${msg.msgtime }" pattern="yyyy-MM-dd hh:mm:ss" /></span> <span
								class="font-noraml">发件人： </span>${msg.msgpeople }
						</h5>
					</div>
				</div>
				<div class="mail-box">


					<div class="mail-body">${msg.msgcon }</div>
					<div class="mail-attachment">
						<p>
							<span><i class="fa fa-paperclip"></i> 附件 - </span>

						</p>
						<c:if test="${msg.msgfile != null && msg.msgfile != ' ' }">
							<div class="attachment">
								<div class="file-box">
								<form action="download2.do" method="post"  id="forms">
									<div class="file">
									<input name="filename" value="${msg.msgfile }" type="hidden" />
										 
										<a	onclick="formss();"> <span class="corner"></span>

											<div class="icon">
												<i class="fa fa-file"></i>
											</div>
											<div class="file-name">${msg.msgfile }</div>
										</a>
									</div>
								</form>
								</div>

								<div class="clearfix"></div>
							</div>
							</c:if>
					</div>
					<div class="mail-body text-right tooltip-demo">
						<c:if test="${msg.msgstatu eq '2'}">
							<button title="" data-placement="top" data-toggle="tooltip"
							data-original-title="删除通知" class="btn btn-sm btn-white" onclick="javascript:location.href='del.do?id=${msg.id}&v=whm'">
							<i class="fa fa-trash-o" ></i> 删除
						</button>
						</c:if>
						<c:if test="${msg.msgstatu eq '0' }">
							<button title="" 
							 class="btn btn-sm btn-white" onclick="javascript:location.href='tijiao.do?id=${msg.id}&msgstatu=1&v=whm'">
							<i class="fa fa-trash-o" ></i> 立即发送
						</button>
						</c:if>
						
					</div>
					<div class="clearfix"></div>


				</div>
			</div>
		</div>
	</div>


	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>



	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>


	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});
		});
	</script>

	<script type="text/javascript">
		function formss() {
			$("#forms").submit();
		}
	</script>


</body>

</html>