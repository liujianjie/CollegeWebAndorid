// JavaScript Document
$(function(){
	//添加项目
	$('span.list-add-show').click(function(){
		 $('#div1').removeClass('list-hide');
		});
	//取消
	$('.list-add-cancel').click(function(){
		$('#div1').addClass('list-hide');
		});
	//添加
	$('.list-add-add').click(function(){
		var $li=$('<li class="list-option"><input class="list-input" type="text"><span class="list-btn"><span class="list-up">[上移]</span><span class="list-down">[下移]</span><span class="list-del">[删除]</span></span></li>');
		$('.list-ul').append($li);
		$('input.list-input:last').val($('input.list-add-input').val());
		$('input.list-add-input').val('');		
		});
	
	});