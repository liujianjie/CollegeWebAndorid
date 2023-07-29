	//普通的弹框
//	alert("我进来了");

	/*将内容打印到body中*/
	document.write("欢迎你使用 javascript");

	//对话框
	function test2(){
		if(confirm("是否要退出")){
			window.close();//关闭网页
		}else{
			alert("那你点个毛");
		}
	}

	function test(){
		alert("脚本弹出框")
	}  

	//变量 没有数据类型之分
	var a=10;
	var b="呵呵";
	var c=false;
//	alert(c);
//	alert(a+""+b);//字符串拼接

	//方法参数 和 返回值 参数不用数据类型
	function ff(a,b){
		var sum=a+b;
		return sum
	}
	var sum=ff(1,4);//调用
//	alert(sum);

	//三目运算符 判断 
	if(a>5){
		alert("我大于5");
	}
//	alert(a>5?"我tm是王者":"我才是");

	//返回数据类型 number,boolean,string,null
//	alert(typeof(a));
	
	//一维数组
	arrs=new Array(111,222,333);
//	arrs[0]=3;
//	arrs[1]=2;
//	arrs[2]=1;
//	arrs.sort();	//排序
//	alert(arrs[2]);

	//多维数组
	arrss=new Array(5,5);
	arrss[0,0]=00;
	arrss[0,1]=01;
	arrss[0,2]=02;
	arrss[0,3]=03;
	arrss[0,4]=04;
//	alert(arrss[0,4]);
	
	//eval函数
	var s="alert('呵呵');";
	alert(s);
	eval(s);

	//isNaN函数
	var n=9;
	alert(isNaN(n));//是数字就返回false 不是就返回true
	
	//return
	function test3(){
		if(n>6){
			alert("王者骚");
			return;
		}
		alert("青铜渣");
	}
	test3();