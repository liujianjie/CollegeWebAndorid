<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'CustomerPl.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
  </style>
  </head>
  <script type="text/javascript">
    function add(commentcontent,mealid,orderid){
             $.ajax({
			     	url:"${path}/com_insertPl.action",
			     	data:{"commentcontent":commentcontent,"mealid":mealid,"orderid":orderid,"check":check},
			     	type:"post",
			     	dataType:"json",
			     	success:function(data){
			     		if(data.state){
			     		    layer.alert(data.message, {icon: 6});
		                    setTimeout("window.location.href='${path}/com_FindOrder.action?orderid=${orderid}'",1200);
				          }
			     		}
		     	});
        }
</script>
 <script language="javascript" type="text/javascript">
      $(document).ready(function(){
         $("#commentcontent").blur(function(){
              //非空校验
              var name=$(this).val();
              if(name==''||name==null){
                   $("#commentmessage").html("评论不能为空！");
	               $("#addBtn").attr("disabled","disabled");
	           }
           });
         	$("#commentcontent").keyup(function(){
		 	var len = $(this).val().length;
		 	var num = 20 - len;
		 	if(len>20){
		 	 $("#commentmessage").html("已经超过20个字");
		 	  $("#addBtn").attr("disabled","disabled");
		 	 }else{
		 	   $("#commentmessage").html("还能输入"+num+"字");
		 	   $("#addBtn").removeAttr("disabled");
		 	   }
		  });
   });
</script>
  <body>
   <table id="tab" class="table">
		   <tr>
		     <td colspan="2"><h4>菜品:${map.meal_name }</h4></td>
		   </tr>
		   <tr>
            <td>
	         	我的评分:<a href="javascript:click(1)"><img src="${path }/resource/img/star.png" id="star1"  onMouseOver="over(1)" onMouseOut="out(1)"/></a>
				<a href="javascript:click(2)"><img src="${path }/resource/img/star.png" id="star2" onMouseOver="over(2)" onMouseOut="out(2)" /></a>
				<a href="javascript:click(3)"><img src="${path }/resource/img/star.png" id="star3" onMouseOver="over(3)" onMouseOut="out(3)" /></a>
				<a href="javascript:click(4)"><img src="${path }/resource/img/star.png" id="star4" onMouseOver="over(4)" onMouseOut="out(4)"/></a>
				<a href="javascript:click(5)"><img src="${path }/resource/img/star.png" id="star5" onMouseOver="over(5)" onMouseOut="out(5)"/></a>
			</td>
			<td><span id="message"></span></td>
			<tr>
			<td>我的评论：
			<textarea class="form-control" name="commentcontent" id="commentcontent" ></textarea>
			</td>
			<td><span id="commentmessage"></span></td>
			</tr>
			<tr align="center">
			<td colspan="2">
			   <input type="button" id="addBtn" onclick="add($('#commentcontent').val(),${map.meal_id},${orderid})" value="评论" class="btn btn-info" />
			   <input type="button" onclick="del()" value="返回" class="btn btn-info" />
			</td>
			</tr>
   </table>
   <script type="text/javascript">
     function del(){
        window.location.href="${path}/com_FindOrder.action?orderid="+${orderid};
     }
   </script>
<script type="text/javascript">
var check = 0;//该变量是记录当前选择的评分(全局)
/*over()是鼠标移过事件的处理方法*/
function over(param){
	if(param == 1){ 
		$("#star1").attr("src","${path }/resource/img/star_red.png");//第一颗星星亮起来，下面以此类推
		$("#message").html("差");//设置提示语，下面以此类推
	}else if(param == 2){
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star_red.png");
		$("#message").html("一般");
	}else if(param == 3){
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star_red.png");
		$("#star3").attr("src","${path }/resource/img/star_red.png");
		$("#message").html("好");
	}else if(param == 4){
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star_red.png");
		$("#star3").attr("src","${path }/resource/img/star_red.png");
		$("#star4").attr("src","${path }/resource/img/star_red.png");
		$("#message").html("满意");
	}else if(param == 5){
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star_red.png");
		$("#star3").attr("src","${path }/resource/img/star_red.png");
		$("#star4").attr("src","${path }/resource/img/star_red.png");
		$("#star5").attr("src","${path }/resource/img/star_red.png");
		$("#message").html("非常满意");
	}
}
/*out 方法是鼠标移除事件的处理方法，当鼠标移出时，恢复到我的打分情况*/
function out(){
	$(this).parent().find();
	if(check == 1){//打分是1，设置第一颗星星亮，其他星星暗，其他情况以此类推
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star.png");
		$("#star3").attr("src","${path }/resource/img/star.png");
		$("#star4").attr("src","${path }/resource/img/star.png");
		$("#star5").attr("src","${path }/resource/img/star.png");
		$("#message").html("");
	}else if(check == 2){
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star_red.png");
		$("#star3").attr("src","${path }/resource/img/star.png");
		$("#star4").attr("src","${path }/resource/img/star.png");
		$("#star5").attr("src","${path }/resource/img/star.png");
		$("#message").html("");
	}else if(check == 3){
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star_red.png");
		$("#star3").attr("src","${path }/resource/img/star_red.png");
		$("#star4").attr("src","${path }/resource/img/star.png");
		$("#star5").attr("src","${path }/resource/img/star.png");
		$("#message").html("");
	}else if(check == 4){
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star_red.png");
		$("#star3").attr("src","${path }/resource/img/star_red.png");
		$("#star4").attr("src","${path }/resource/img/star_red.png");
		$("#star5").attr("src","${path }/resource/img/star.png");
		$("#message").html("");
	}else if(check == 5){
		$("#star1").attr("src","${path }/resource/img/star_red.png");
		$("#star2").attr("src","${path }/resource/img/star_red.png");
		$("#star3").attr("src","${path }/resource/img/star_red.png");
		$("#star4").attr("src","${path }/resource/img/star_red.png");
		$("#star5").attr("src","${path }/resource/img/star_red.png");
		$("#message").html("");
	}else if(check == 0){
		$("#star1").attr("src","${path }/resource/img/star.png");
		$("#star2").attr("src","${path }/resource/img/star.png");
		$("#star3").attr("src","${path }/resource/img/star.png");
		$("#star4").attr("src","${path }/resource/img/star.png");
		$("#star5").attr("src","${path }/resource/img/star.png");
		$("#message").html("");
	}
}
/*click()点击事件处理，记录打分*/
 function click(param){
	check = param;//记录当前打分
	//alert(check);
	out();//设置星星数
} 
</script>
  </body>
</html>
