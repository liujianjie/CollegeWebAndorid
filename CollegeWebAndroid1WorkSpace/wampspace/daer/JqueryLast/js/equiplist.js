$(function() {
	
	// 用ajax获取英雄数据
	// 根据type来分装备，0是全部，1是防御，2是攻击，3是法术, 4是移动速度，5是消耗品
	// 封装成方法
	var curtype = "";
	function getEquipList(ty, na, tg){
		curtype = ty;
		$.ajax(
		{   
		   url:'php/lol_equip_list_get.php',
		   type: 'GET',
		   data: {type:ty,name:na,tag:tg},
		   success:function(data,stutas,xhr){
		   		console.log(data);
				var iso = data.status;
				if(iso == "error"){
					alert(data.info);
					return;
				}
				var $lidiv = "";
				var ndata = "";
				if(tg == 0){
					ndata = data.data[0];
				}else if(tg == 2){
					ndata = data.data;
				}
				
				if(ndata.length == 0){
					$('.herotxul').html("未搜索到符合条件的装备，请重新输入");
				}
				else{
					for(var i = 0; i < ndata.length; i++){
						var himg = ndata[i].iconPath;
						var hname = ndata[i].name;
						// 组成
						$lidiv += '<li class="course_lists" onclick="test(\''+hname+'\')"><a><img src="'+himg+'"/></a><a class="as">'+hname+'</a></li>';
					}
					$('.herotxul').html($lidiv);
				}
		   }
		}
		)
	}
	// 获取所有
	getEquipList('', '', 0);
	
	// 获取单个装备
	function getEquipOne(na){
		$.ajax(
		{   
		   url:'php/lol_equip_list_get.php',
		   type: 'GET',
		   data: {name:na,tag:1},
		   success:function(data,stutas,xhr){
		   		console.log(data);
				var iso = data.status;
				if(iso == "error"){
					alert(data.info);
					return;
				}
				var $lidiv = "";
				var ndata = data.data[0];
				var img = ndata.iconPath;
				var des = ndata.description;
				var pri = ndata.price;
				var $ht = $('#hint');
				$ht.find("img").attr("src", img);
				$ht.find("h4").html(na);
				$ht.find(".cons").html("售价或合成费用:"+pri);
				$ht.find(".hintsddiv").html(des);
		   }
		}
		)
	}
	
	// 切换选择不同装备类型 start-------------------
	$(".selitem").click(function(){
		$(this).addClass("selcuritem").siblings().removeClass("selcuritem");
		// 根据下标，不同，访问不同类型英雄
		var idx = $(this).index();
		switch(idx){
			case 0:
				// 所有
				getEquipList('', '', 0);
			break;
			case 1:
				getEquipList('Health', '', 2);
			break;
			case 2:
				getEquipList('Damage', '', 2);
			break;
			case 3:
				getEquipList('Mana', '', 2);
			break;
			case 4:
				getEquipList('Boots', '', 2);
			break;
			case 5:
				getEquipList('Consumable', '', 2);
			break;
		}
	});
	// 切换选择不同装备类型  end-------------------
	
	// 放到文本框上，清空内容，离开恢复
	$('#findinput').blur(function(){
			$(this).val("请输入您要搜索的英雄名");
		}
	);
	$('#findinput').focus(function(){
			$(this).val("");
		}
	);
	// 监听输入的装备，后台查找出来
	$('#findinput').keyup(function(){
		var val = $(this).val();
		getEquipList(curtype, val, 2);
	});
	
	// 鼠标放在图片上 显示详细
	$('.herotxul').on("mouseenter", "li", function(e){
		// 显示
		$('#hint').show();
		// 给定位
		$('#hint').css({
			"top" : (e.pageY + 10)+"px",
			"left": (e.pageX + 10)+"px"
		});
		//获取值
		getEquipOne($(this).find(".as").text());
	});
	$('.herotxul').on("mouseleave", "li", function(e){
		$('#hint').hide();
	});
	// 默认隐藏
	$('#hint').hide();
});

