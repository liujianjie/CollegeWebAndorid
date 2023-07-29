//播放动画计时
var timer;

window.onload = function(){
//	设置动画按钮的点击事件：播放动画
	document.getElementById("cymbal").onclick = function(){startAnimation("cymbal",13)}
	document.getElementById("drink").onclick = function(){startAnimation("drink",81)}
	document.getElementById("eat").onclick = function(){startAnimation("eat",40)}
	document.getElementById("fart").onclick = function(){startAnimation("fart",28)}
	document.getElementById("pie").onclick = function(){startAnimation("pie",24)}
	document.getElementById("scratch").onclick = function(){startAnimation("scratch",56)}
}

//播放动画的方法:动画名,图片总数
function startAnimation(name,count){
//避免当一个动画没有执行完成之前就点击了另一个动画时会产生的错误
clearInterval(timer);
//当前图片的索引
var index = 0;

//播放动画的img元素
var img = document.getElementById("cat");

//计时器,用于切换图片
timer = setInterval(function(){
//	如果index + 1小于count
	if(++index < count){
//		切换路径 = 调用拼接图片名的方法：动画名，当前图片索引
		img.src = getImageName(name,index);
	}else{
//		清楚计时器
		clearInterval(timer);
	}
},80);
}

//根据动画名和图片索引返回图片名
function getImageName(name,index){
	return "Animations"+"/"+name+"/"+name+"_"+getIndex(index)+".jpg";
}

//实现%02d功能,如：1输出01,12输出12
function getIndex(index){
	//若小于10,拼接字符串
	if(index<10){
		return "0"+index;
	}else{
		//若大于10,直接返回
		return index;
	}
}