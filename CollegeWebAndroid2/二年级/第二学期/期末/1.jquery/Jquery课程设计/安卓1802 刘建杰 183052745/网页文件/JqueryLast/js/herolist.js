$(function() {
	
	// 用ajax获取英雄数据
	// 根据type来分英雄，0是全部，1是战士，2是法师，3是刺客
	// 封装成方法
	// tag 0是查询，1是添加，2是删除 没用
	var curtype = 0;
	function getHeroList(ty, na, tg){
		curtype = ty;
		$.ajax(
		{   
		   url:'php/lol_hero_list_get.php',
		   type: 'GET',
		   data: {type:ty,name:na, tag:tg},
		   success:function(data,stutas,xhr){
				var iso = data.status;
				if(iso == "error"){
					alert(data.info);
					return;
				}
				var $lidiv = "";
				if(data.data.length == 0){
					$('.herotxul').html("未搜索到符合条件的英雄，请重新输入");
				}
				else{
					// 英雄列表显示
					$('.herotxul').show();
					// 添加div隐藏
					$('.addherodiv').hide();
					for(var i = 0; i < data.data.length; i++){
						var himg = data.data[i].champion_icon;
						var hname = data.data[i].champion_name;
						// 组成
						$lidiv += '<li><a><img onclick="test(\''+hname+'\')" src="'+himg+'"/></a><a class="heronamea as">'+hname+'</a><a class="dela as">删除</a></li>';
					}
					$('.herotxul').html($lidiv);
					$('.dela').hide();
				}
		   }
		}
		)
	}
	// 获取默认所有英雄
	getHeroList(0, '', 0);
	
	// 切换选择不同英雄类型 start-------------------
	$(".selitem").click(function(){
		$(this).addClass("selcuritem").siblings().removeClass("selcuritem");
		// 根据下标，不同，访问不同类型英雄
		var idx = $(this).index();
		switch(idx){
			case 0:
				getHeroList(0, '', 0);
			break;
			case 1:
				getHeroList(1, '', 0);
			break;
			case 2:
				getHeroList(2, '', 0);
			break;
			case 3:
				getHeroList(3, '', 0);
			break;
			case 4:
				getHeroList(4, '', 0);
			break;
			case 5:
				getHeroList(5, '', 0);
			break;
			case 6:
				getHeroList(6, '', 0);
			break;
		}
	});
	// 切换选择不同英雄类型  end-------------------
	
	// 放到文本框上，清空内容，离开恢复
	$('#findinput').blur(function(){
			$(this).val("请输入您要搜索的英雄名");
		}
	);
	$('#findinput').focus(function(){
			$(this).val("");
		}
	);
	// 监听输入的英雄名，后台查找出来
	$('#findinput').keyup(function(){
		var val = $(this).val();
		getHeroList(curtype, val, 0);
	});
	
	$('.addherodiv').hide();
	$('.maheroli').toggle();
	// 管理英雄的按钮
	// 点击管理英雄
	$('.maheroa').click(function(){
		$('.maheroli').toggle();
	});
	// 删除英雄按钮
	$('#delherobt').click(function(){
		$('.dela').toggle();
	});
	// 添加英雄按钮
	$('#addherobt').click(function(){
		$('.herotxul').hide();
		$('.addherodiv').show();
	});
	
	// 删除标签
	$('.herotxul').on("click",".dela", function(){
		var heroname = $(this).parent("li").find(".heronamea").html();
		var is = confirm("确定删除英雄："+heroname+"？");
		if(is){
			$.ajax(
			{   
			   url:'php/lol_del_hero.php',
			   type: 'GET',
			   data: {name:heroname},
			   success:function(data,stutas,xhr){
			   		console.log(data);
					var iso = data.status;
					if(iso == "error"){
						alert(data.info);
						return;
					}else if(iso == "success"){
						// 重新读取列表
						getHeroList(curtype, '', 0);
					}
			   }
			}
			)
		}
	});
		
});

