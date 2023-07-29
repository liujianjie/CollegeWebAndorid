<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>

	<script src="${path }/resource/js/distpicker.data.js"></script>
	<script src="${path }/resource/js/distpicker.js"></script>
	<script src="${path }/resource/js/main.js"></script>
 <script type="text/javascript">
 $(document).ready(function(){
    $("select[dizhi='toaddress']").change(function(){
   		var province=$("#province1").val();
   		var city=$("#city1").val();
   		var district=$("#district1").val();
   		$("#address").val(province+""+city+""+district);
   });
 	//部门
 $("#depart").change(function(){
 	$.ajax({
 		url:"${path}/EdeDuty_selectDuty.action",
 			data:{"departid":$("#depart").val()},
 			type:"post",
 			dataType:"json",
 			success:function(data){
 			$("#dutyname").html('');
 			console.log(data);
 				for(var i=0;i<data.length;i++){
 					var op=$("<option value='"+data[i].duty_id+"'>"+data[i].duty_name+"</option>");
 					$("#dutyname").append(op);
 				}
 			}
 	})
 });
 			
 });
 //
 var result=true;
 function checkEmpUser(){
 			$.ajax({
 			url:"${path}/dc/CheckEmpUser",
 			data:{"username":$("#username").val(),"accountid":$("#accountid").val()},
 			type:"post",
 			dataType:"text",
 			success:function(data){
 				//alert(6);
 				console.log(data+"username");
 				if(data=='false'){
 					$("#checkUserMess").hide();
 				}
 				else{
 					$("#checkUserMess").show();
 					result=false;
 				}
        }
 	});
 }
 
 </script>
 <style type="text/css">
 	tr{
 		width:100%;
 	}
 	tr>td>span{
 		color:red;
 	}
 	.datediv{
 		float:left;
 	}
 	.box0{
 		padding: 100px 100px 10px; text-align:center
 	}
 </style>
  </head>
  
  <body>
  
  <div class="box0">
    <form action="" method="post" id="form1" >
    <table class="table">
    <tr>
    	<td><input type="hidden" name="empid" value="${empid}"  class="form-control"><td>
        <td><input type="hidden" name="accountid" value="${oneemp.emp_account_id}" id="accountid" class="form-control"><td>
   </tr>
   <script>
 function CheckEmpName(){
 	var reg=/^.+$/;
 	var value=$("#empname").val();
 	if(!reg.test(value)){
 		$("#checkEmpnameMess").show();
 		state=false;
 	}
 	else{
 		$("#checkEmpnameMess").hide();
 		
 	}
 }
   </script>
    <tr>
    	<td class="input-group">
    		<span class="input-group-addon">员工名</span>
    		<input type="text" name="empname" value="${oneemp.emp_name}" id="empname"  class="form-control" onblur="CheckEmpName()">
    	</td>
    	<td><span id="checkEmpnameMess"style="display:none">员工名不能为空</span></td>
    </tr>
    <script></script>
    <tr>
    	<td>
    		<div class="input-group"> 
    			<span class="input-group-addon">性别</span>
    			<select  name="sex"  id="sex"  class="form-control">
    				<option value="0" 
    					<c:if test="${oneemp.sex eq 0}">selected='selected'</c:if>>
    					男</option>
    				<option value="1" 
    					<c:if test="${oneemp.sex eq 1}"> selected='selected'</c:if>>
    					女</option>
    			</select>
    		</div>
    	</td>
    	<td><span></span></td>
    </tr>
    
    <tr>
    	<td><!-- 部门 -->
    		<div class="input-group"> 
    			<span class="input-group-addon">部门</span>
    			<select  name="departid"  id="depart"  class="form-control" <c:if test="${(oneemp.emp_id eq userinfo.emp_id) or(oneemp.role_id eq 1)}">disabled="disabled"</c:if>>
    				<c:forEach items="${departinfo }" var="dep">
    					<option value="${dep.depart_id }" 
    					<c:if test="${dep.depart_id eq oneemp.depart_id }"> selected='selected'</c:if>>
    					${dep.depart_name }</option>
    				</c:forEach>
    			</select>
    		<!-- 职务 -->
    			<span class="input-group-addon">职务</span>
    			<select  name="dutyname"  id="dutyname"  class="form-control" <c:if test="${(oneemp.emp_id eq userinfo.emp_id) or(oneemp.role_id eq 1)}">disabled="disabled"</c:if>>
    				<%-- <c:forEach items="${dutyinfo }" var="df">
    					<option value="${df.duty_id }" 
    					<c:if test="${df.duty_id eq oneemp.duty_id }"> selected='selected'</c:if>>
    					${df.duty_name }</option>
    				</c:forEach> --%>
    			</select>
    		</div>
    	</td>
    	<td><span></span></td>
    </tr>
     <script>
 function CheckEmpAge(){
 	var reg=/^[1-4][0-9]$/;
 	var value=$("#age").val();
 	if(!reg.test(value)){
 		result=false;
 		$("#checkEmpAgeMess").show();
 	}
 	else{
 		$("#checkEmpAgeMess").hide();
 	}
 	//alert(result);
 }
   </script>
    <tr>
    	<td class="input-group">
    			<span class="input-group-addon">年龄</span>
    			<input type="text" name="age"  value="${oneemp.age}"id="age"  class="form-control" onblur="CheckEmpAge()">
    	</td>
    	<td><span id="checkEmpAgeMess" style="display:none">请输入正确年龄,或者年龄不符合</span></td>
    </tr>
<script>
 function CheckPhone(){
 	var reg=/^((13)|(15)|(18))[0-9]{9}$/;
 	var value=$("#phone").val();
 	if(!reg.test(value)){
 		result=false;
 		$("#checkPhoneMess").show();
 	}
 	else{
 		$("#checkPhoneMess").hide();
 	}
 	//alert(result);
 }
   </script>
    <tr>
    	<td class="input-group">
    			<span class="input-group-addon">手机号</span>
    			<input type="text" name="phone"  value="${oneemp.phone}" id="phone"  onblur="CheckPhone()" class="form-control">
    	</td>
    	<td><span id="checkPhoneMess" style="display:none">请输入正确手机号</span></td>
    </tr>
    <tr>
   		<td class="input-group">
   			<span class="input-group-addon">用户名</span>
   			<input type="text" name="username" value="${oneemp.emp_user}" id="username" onblur="checkEmpUser()" class="form-control">
   		</td>
   		<td><span id="checkUserMess" style="display:none">用户名已经存在</span></td>
    </tr>
<script>
 function CheckPwd(){
 	var reg=/^\w{4,12}$/;
 	var value=$("#pwd").val();
 	if(!reg.test(value)){
 		result=false;
 		$("#checkPwdMess").show();
 	}
 	else{
 		$("#checkPwdMess").hide();
 	}
 	//alert(result);
 }
   </script>
    <tr>
    	<td class="input-group">
    		<span class="input-group-addon">密码</span>
    		<input type="password"  name="pwd"  value="${oneemp.emp_password}" id="pwd"  onblur="CheckPwd()"class="form-control">
    	</td>
    	<td><span id="checkPwdMess" style="display:none">密码最长度为12,最少4个,字母数字</span></td>
    </tr>
   <script>
 function CheckRePwd(){
 	var val=$("#pwd").val();
 	var value=$("#repwd").val();
 	if(val!=value){
 		result=false;
 		$("#CheckRePwdMess").show();
 	}
 	else{
 		$("#CheckRePwdMess").hide();
 	}
 	//alert(result);
 }
   </script> 
    <tr>
    	<td class="input-group">
    		<span class="input-group-addon">确认密码</span>
    		<input type="password"  name="repwd"  value="${oneemp.emp_password}" id="repwd" onblur="CheckRePwd()" class="form-control">
    	</td>
    	<td><span id="CheckRePwdMess" style="display:none">密码错误，重新确认</span></td>
    </tr>
    <tr>
    	<td >
    	<div class="datediv">
    	 <div class="input-group ">
    	 	<% Map map=(Map)request.getAttribute("oneemp"); 
    	 	if(map!=null&&!map.isEmpty()){
    	 	 	String date=map.get("hiredate").toString();
    	 		String Year=date.substring(0, 4);
    	 		String Month=date.substring(5, 7);
    	 		String Day=date.substring(8, 10);
    	 		request.setAttribute("Year", Year);
    	 		request.setAttribute("Month", Month);
    	 		request.setAttribute("Day", Day);
    	 		}
    	 		else{
    	 		request.setAttribute("Day", 1);
    	 		}
    	 	%>
    	 	<input type="hidden" id="DAY"value="${Day }"/>
    		<span class="input-group-addon">入职时间 </span>
    		<select type="text"  name="year"  id="year"  class="form-control">
    			<c:forEach  begin="${1980 }" end="${2017 }" varStatus="i">
    				<option value="${i.count+1979 }" 
    				 <c:if test="${Year eq (i.count+1979) }">selected='selected'</c:if>>${i.count+1979 }</option>
    			</c:forEach>
    		</select>
    		<span class="input-group-addon">年</span>
    		</div>
    	</div>
    	<div class="datediv">
    		<div class="input-group">
    		<select type="text"  name="month"  id="month"  class="form-control">
    			<c:forEach  begin="${0 }" end="${11 }" varStatus="i">
    				<option value="${i.count+0 }"
    				<c:if test="${Month eq (i.count+0) }">selected='selected'</c:if>
    				>${i.count+0 }</option>
    			</c:forEach>
    		</select>
    			<span class="input-group-addon">月</span>
    		</div>
    	</div>
    	<script>
    	function YearDay(){
    		var year=parseInt($("#year").val());
    		var month=parseInt($("#month").val());
    		var Day=$("#DAY").val();
    		//alert(Day);
    		console.log((year+1)+(month+1));
    		var days;
    		if(month==1||month==3||month==5||month==8||month==10||month==12){
    			days=31;
    		}
    		else if(month==4||month==6||month==9||month==11){
    			days=31;
    		}
    		else if(year%4==0 && (year%100 !=0 || year%400 == 0)){
    			days=28;
    		}
    		else{
    			days=29;
    		}
    		for(var i=1;i<days+1;i++){
    		if(i<=Day){
    			$("#today").before("<option value='"+i+"'>"+i+"</option>");
    		}else{
    			$("#day").append("<option value='"+i+"'>"+i+"</option>");
    		}
    	}
    	}
    	</script>
    	<div class="datediv">
    		<div class="input-group">
    		<select type="text"  name="day"  id="day"  class="form-control" onfocus="YearDay()">
    				<option  id="today" value="${Day }">${Day }</option>
    			
    		</select>
    		<span class="input-group-addon">日</span>
    		</div>
    	</div>
    	</td>
    	<td><span></span></td>
    </tr>
    <tr>
    	<td> 
    		<div data-toggle="distpicker">
    		<div class="datediv">
    			<div class="input-group">
	    			<span class="input-group-addon">住址</span>
	        		<div class="form-group">
	          			<label class="sr-only" for="province1">Province</label>
	          			<select dizhi="toaddress" class="form-control"  name="province" id="province1" data-province="${oneemp.province }"></select>
	       		 	</div>
	       		 	<span class="input-group-addon">省</span>
       		 	</div>
       		 </div>
       		<div class="datediv">
       		 	<div class="input-group">
	        		<div class="form-group">
	         			 <label class="sr-only" for="city1">City</label>
	          			<select dizhi="toaddress" class="form-control" name="city" id="city1" data-city="${oneemp.city }"></select>
	       			 </div>
	       			 <span class="input-group-addon">市</span>
       			 </div>
       		</div>
       		<div class="datediv">
       			 <div class="input-group">
	        		<div class="form-group">
	          			<label class="sr-only" for="district1">District</label>
	          			<select dizhi="toaddress" class="form-control"name="district" id="district1" data-district="${oneemp.district }"></select>
	       		 	</div>
	       		 	<span class="input-group-addon">县</span>
       		 	</div>
       		</div>
      		</div>
    	</td>
    	<td><span></span></td>
    </tr>
    <script>

    //员工修改或提交
function addOrChangeEmp(){
			result=true;
 			checkEmpUser();
 			CheckEmpName();
 			CheckEmpAge();
 			CheckPhone();
 			CheckPwd();
 			CheckRePwd();
 			//alert(result+"1");
 	if(result==true){
 			$.ajax({
 				url:"${path}/dc/ChangeOrAddEmp",
 				data:$("#form1").serialize(),
 				type:"post",
 				dataType:"text",
 				success:function(data){
  						alert(data);
  						window.location.href="${path}/dc/ShowAllEmp";
 				}
 			})
 	}
 	else{
 		alert("请再次检查");
 	}
 }
    </script>
    <tr>
   		<td class="input-group">
   			<span class="input-group-addon">详细地址</span>
   			<input type="text" name="address" value="${oneemp.address}" id="address" class="form-control">
   		</td>
   		<td><span id="checkAddrMess" style="display:none"></span></td>
    </tr>
    <tr>
    	<td colspan="2"><input type="button" 
    	<c:if test="${!empty oneemp.emp_account_id }">value="修改"</c:if>
    	<c:if test="${empty oneemp.emp_account_id }">value="新增"</c:if>
    	 id="addBtn" onclick="addOrChangeEmp()" class="btn btn-warning"><br>
    	 </td>
    </tr>
    </form>
    </table>
    </div>
  </body>
</html>
