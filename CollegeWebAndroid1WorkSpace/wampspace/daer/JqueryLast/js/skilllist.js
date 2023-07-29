$(function() {
	// 获取所有的技能
	function getSkillList(){
		$.ajax(
		{   
		   url:'php/lol_skill_list_get.php',
		   type: 'GET',
		   data: {},
		   success:function(data,stutas,xhr){
				var iso = data.status;
				if(iso == "error"){
					alert(data.info);
					return;
				}
				var $lidiv = "";
				for(var i = 0; i < data.data.length; i++){
					var himg = data.data[i].icon;
					var hname = data.data[i].name;
					// 组成
					if(i == 0){
						$lidiv += '<li class="current"><img src="'+himg+'"/><span class="sbor"></span><a class="as">'+hname+'</a></li>';
					}else{
						$lidiv += '<li><img src="'+himg+'"/><span class="sbor"></span><a class="as">'+hname+'</a></li>';
					}
				}
				$('.skillul').html($lidiv);
		   	}
		}
		)
	}
	// 获取默认所有技能
	getSkillList();

	// 获取单个的技能的详情
	function getSkillInfo(na, himg){
		$.ajax(
		{   
		   url:'php/lol_skilldetail_list_get.php',
		   type: 'GET',
		   data: {name:na},
		   success:function(data,stutas,xhr){
		   		console.log(data);
				var iso = data.status;
				if(iso == "error"){
					alert(data.info);
					return;
				}
				var ndata = data.data;
				var simg = ndata.showimg;
				var info = ndata.info;
				$('.skillheaddiv img').attr("src", himg);
				$('.skillheaddiv h4').html(na);
				$('.skillmiddiv').html(info);
				$('.skilltaildiv img').attr("src", simg);
		   	}
		}
		)
	}
	// 点击技能图像
	$('.skillul').on("click","li",function(){
		// 1.获取名称，获取这个名称的详细信息
		var name =$(this).find("a").text();
		getSkillInfo(name, $(this).find("img").attr("src"));
		// 3.让兄弟取消选中的样式，自己选中的样式
		$(this).addClass("current").siblings().removeClass("current");
	});
});

