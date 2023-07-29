<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>聊天窗口</title>

<meta name="keywords" content="">
<meta name="description" content="">

<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">

		<div class="row">
			<div class="col-sm-12">

				<div class="ibox chat-view">

					<div class="ibox-title">
						<small class="pull-right text-muted"><input type="button" class="btn btn-primary btn-sm" value="刷新消息" onclick="javascript:remessage();">
							</small> 聊天窗口<span id="chatname"></span>
					</div>


					<div class="ibox-content">

						<div class="row">

							<div class="col-md-9 ">
								<div class="chat-discussion" id="chatss" >
									<div class='chat-message'>
										<img class='message-avatar avatar-right' src="${pageContext.request.contextPath}/${user.picpath }">
									<div class='message-right message' >
									<a class='message-author'>${user.username} </a>
										<span class='date-left'>刚刚 </span> 
									<span class='message-content'>请选择联系人 </span>
									</div>
							</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="chat-users">
									<div class="users-list">
										<c:forEach items="${users }" var="user">
											<a
												onclick="javascript:selmessage('${user.id}','${user.username}');">
												<div class="chat-user">
													<span class="pull-right"><input type="checkbox" style="display:none"></span>
													<img class="chat-avatar"
														src="${pageContext.request.contextPath}/${user.picpath }"
														alt="">
													<div class="chat-user-name">
														${user.username }
													</div>
												</div>
											</a>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="chat-message-form">
									<input type="hidden" id="heid">
									<input type="hidden" id="path" value="${pageContext.request.contextPath}">
									<div class="form-group">
										<textarea class="form-control message-input" id="messages"
											name="message" placeholder="输入消息内容，500字以内"></textarea>
									</div>
									<div class="col-sm-12 col-sm-offset-10">
										<br>
										<button class="btn btn-primary btn-sm" type="button"
											onclick="insert();">&nbsp;&nbsp;&nbsp;发送&nbsp;&nbsp;&nbsp;</button>
										<br>
									</div>

								</div>
							</div>
						</div>
					</div>
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

	<script type="text/javascript">
		function insert() {
			var chtext = $("#messages").val();
			var heid = $("#heid").val();
			var path = $("#path").val();
			$.post("insert.do", {
				heid : heid,
				chtext : chtext
			}, function(result) {
				var str = $("#chatss").html();
				var user = result.user;
				
				
				
				
						str+="<div class='chat-message'>"
							+"		<img class='message-avatar avatar-right' src='"+path+"/"+user.picpath+"'>"
							+"		<div class='message-right message'>"
							+"			<a class='message-author'> "+user.username+"</a>" 
							+"			<span class='date-left'> 刚刚</span> "
							+"			<span class='message-content'>"+chtext+" </span>"
							+"		</div>"
							+"</div>"
						
					
					$("#messages").val("");
					$("#chatss").html(str);
					
				

			}, "json");
		}

		function selmessage(id, username) {
			$("#chatss").html("");
			$("#heid").val(id);
			var path = $("#path").val();
			$("#chatname").html("(" + username + ")");
			$.post("sel.do", {
				heid : id,
			}, function(result) {
				var list = result.list;
				var myid = result.myid;
				var str = "";
				$.each(list,function(index,chat){
					
					if(chat.setid != myid){
					str+="<div class='chat-message'>"
						+"		<img class='message-avatar avatar-left' src='"+path+"/"+chat.setuser.picpath+"'>"
						+"		<div class='message-left message'>"
						+"			<a class='message-author'> "+chat.setuser.username+"</a>" 
						+"			<span class='date-right'>"+chat.date+"</span> "
						+"			<span class='message-content'>"+chat.chtext+" </span>"
						+"		</div>"
						+"</div>"
					}else{
						str+="<div class='chat-message'>"
							+"		<img class='message-avatar avatar-right' src='"+path+"/"+chat.setuser.picpath+"'>"
							+"		<div class='message-right message'>"
							+"			<a class='message-author'> "+chat.setuser.username+"</a>" 
							+"			<span class='date-left'> "+chat.date+"</span> "
							+"			<span class='message-content'>"+chat.chtext+" </span>"
							+"		</div>"
							+"</div>"
						
					}
					
					$("#chatss").html(str);
				});

			}, "json");
			
		}
		
		function remessage() {
			$("#chatss").html("");
			var heid=$("#heid").val();
			var path = $("#path").val();
			$.post("sel.do", {
				heid : heid,
			}, function(result) {
				var list = result.list;
				var myid = result.myid;
				var str = "";
				$.each(list,function(index,chat){
					
					if(chat.setid != myid){
					str+="<div class='chat-message'>"
						+"		<img class='message-avatar avatar-left' src='"+path+"/"+chat.setuser.picpath+"'>"
						+"		<div class='message-left message'>"
						+"			<a class='message-author'> "+chat.setuser.username+"</a>" 
						+"			<span class='date-right'>"+chat.date+"</span> "
						+"			<span class='message-content'>"+chat.chtext+" </span>"
						+"		</div>"
						+"</div>"
					}else{
						str+="<div class='chat-message'>"
							+"		<img class='message-avatar avatar-right' src='"+path+"/"+chat.setuser.picpath+"'>"
							+"		<div class='message-right message'>"
							+"			<a class='message-author'> "+chat.setuser.username+"</a>" 
							+"			<span class='date-left'> "+chat.date+"</span> "
							+"			<span class='message-content'>"+chat.chtext+" </span>"
							+"		</div>"
							+"</div>"
						
					}
					
					$("#chatss").html(str);
				});

			}, "json");
			
		}
	</script>

</body>

</html>