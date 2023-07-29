let rigthTool = $('.rigthTool');
let goTop = $('.goTop');
$(window).scroll(function(){
  let wscrolls = $(window).scrollTop();
  // console.log(wscrolls);
  if(wscrolls > 580){
    let topNum = wscrolls+60;
    rigthTool.css('top', topNum+'px');
  } else{
    goTop.hide();
  }
  if(wscrolls > 948){
    goTop.show();
  }
})
goTop.click(function() {
  $(window).scrollTop(0);
  rigthTool.css('top', '640px');
})