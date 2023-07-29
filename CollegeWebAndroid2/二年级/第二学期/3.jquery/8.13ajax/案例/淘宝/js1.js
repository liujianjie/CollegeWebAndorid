// JavaScript Document
$(function()
	{
		
	var timer=null;
    var l=$('.banner .img li').length-1;
    var w=$('.banner .img li').width();
    var i=0;
	 //1.控制左右两个按钮
	   //右键单击事件
	  $('.btn>.next').click(function()
    {
        if(i>l-1) 
        {
            i=0;
            $('.img').css('left','0');
        }
        i++;
        $('.img').stop().animate({'left':-w*i},500);
		 $('.tab li').removeClass('active').eq(i).addClass('active');
		  if(i==l)
        {
            $('.tab li').first().addClass('active');
        }
			});
	  //左键单击事件
	  $('.btn>.prev').click(function(){
		
		if(i<=0){  $('.img').css('left',-l*w); i=l; }
		i--;
		 $('.img').stop().animate({left:-w*i},1000);
		$('.tab li').removeClass('active').eq(i).addClass('active');
		  if(i==l)
        {
          $('.tab li').first().addClass('active');	}
		
		});
	//2.轮播效果
	timer=setInterval(function(){
		$('.btn>.next').trigger('click');		
		},2000);
	//3.鼠标移入停，移出动,向前向后按钮出现
	 $('.banner').mouseenter(function(){
		 clearInterval(timer);
		 $('.btn').show(500);
		 }).mouseleave(function(){
		timer=setInterval(function(){ 
		$('.btn>.next').trigger('click');
		},2000);	
		$('.btn').hide(500);		
			});
	//4.提示点提示点的变化
	  $('.tab li').click(function(){
		  $(this).addClass('active').siblings().removeClass('active');
		  var j=$(this).index()
	$('.img').stop().animate({left:-j*w},1000);		
		  });		
		
		});
