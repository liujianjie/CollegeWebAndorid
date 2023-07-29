//全局变量
var reg = new RegExp(/\w+@[a-z0-9]+\.[a-z]*/);
var pmdreg = new RegExp(/[a-z0-9]{8}/);



// 1.1登录的方法
function checkLoginSubm(){
	
	var psd = document.loginfrm.loginpassword.value;
	var email = document.loginfrm.loginemail.value;
	
	if(email == ""){
　　　　alert("邮箱不能为空");
　　　　return false;
　　}else if(!reg.test(email)){ 
　　　　alert("Please enter the correct mailbox format");
　　　　return false;
　　}
	
	if(psd == ""){
		alert("密码不能为空");
		document.getElementById("loginpassword").focus();
		return false;
	} if(!pmdreg.test(psd) || psd.length < 6 || psd.length > 10){ 
		alert("密码长度请大于6位并且小于10位，并且必须是字符或者数字a~z 0~9");
		document.getElementById("loginpassword").focus();
		return false;
　　}
	
	var cookiepwd = gckPersonalInfoByFname("password");
	var cookieemail = gckPersonalInfoByFname("email");
	
	if(cookieemail == ""){
		alert("这个邮箱还没有注册过，请先注册");
		return false;
	}
	if(email != cookieemail){
		alert("这个邮箱还没有注册过，请先注册或者重新输入邮箱");
		document.getElementById("loginemail").focus();
		return false;
	}
	if(psd != cookiepwd){
		alert("密码错误");
		document.getElementById("loginpassword").focus();
		return false;
	}
	setText();
	return true;
}


// 2.1注册的方法
function checkFormSubm(){
	var username = document.registerfrm.Username.value;
	var password = document.registerfrm.password.value;
	var name = document.registerfrm.Name.value;
	var email = document.registerfrm.email.value;
	var birthdate = document.registerfrm.birthdate.value;
	var picture = document.registerfrm.profilepicture.value;
	var Address = document.registerfrm.Address.value;
	var checkboxs = document.getElementsByName("agree");

	if(username == ""){
		alert("用户名不能为空");
		document.getElementById("Username").focus();
		return false;
	}
	if(password == ""){
		alert("密码不能为空");
		document.getElementById("password").focus();
		return false;
	} 
	if(!pmdreg.test(password) || password.length < 6 || password.length > 10){ 
		alert("密码长度请大于6位并且小于10位，并且必须是字符或者数字a~z 0~9");
		document.getElementById("password").focus();
		return false;
　　}
	if(name == ""){
		alert("姓名不能为空");
		document.getElementById("Name").focus();
		return false;
	}
	
	if(email == ""){
　　　　alert("邮箱不能为空");
		document.getElementById("email").focus();
　　　　return false;
　　} 

	if(!reg.test(email)){ 
　　　　alert("邮箱格式错误");
		document.getElementById("email").focus();
　　　　return false;
　　}
	var checkemail = gckPersonalInfoByFname("email");
	if(email == checkemail){
		alert("当前邮箱已经注册，请重新输入");
		document.getElementById("email").focus();
		return false;
	}

	if(birthdate == ""){
		alert("出生年月不能为空");
		document.getElementById("birthdate").focus();
		return false;
	}
	if(!picture){
		alert("头像不能为空");
		document.getElementById("profilepicture").focus();
		return false;
	}
	if(Address == ""){
		alert("地址不能为空");
		document.getElementById("Address").focus();
		return false;
	}
	
	if(checkboxs[0].checked == false){
		alert("您需要先同意协议");
		document.getElementById("agree").focus();
		return false;
	}
	var Days = 30;
	var exdate = new Date();
	exdate.setTime(exdate.getTime() + Days*24*60*60*1000);//一月

	document.cookie="Username=" + escape(username) + ",Name=" + escape(name) + ",password=" + escape(password)+ ",birthdate=" + escape(birthdate) +",email=" + escape(email) + ",profilepicture=" + escape(picture) +",Address=" + escape(Address) +";expires=" + exdate.toGMTString();
	document.cookie="target=1;expires="+exdate.toGMTString();//做标记用的
	
	var bl = confirm("注册成功，是否到登录界面");
	if(bl){
		location.href="Login.html"
	}
	return true;
}

// 3.1主界面的切换图片

//4.1个人信息修改
function rightPersonInfo(){

	gCkSetPInfo("rightPerInfo");// 右边
	
}
function checkModifyForm(){

	var saveusername = gckPersonalInfoByFname("Username");
	var savename = gckPersonalInfoByFname("Name");
	var saveemail = gckPersonalInfoByFname("email");
	var savebirthdate = gckPersonalInfoByFname("birthdate");
	var saveAddress = gckPersonalInfoByFname("Address");

	var password = gckPersonalInfoByFname("password");
	var picture = gckPersonalInfoByFname("profilepicture");

	var username = document.rightPerInfofrm.rtUsername.value;
	var name = document.rightPerInfofrm.rtName.value;
	var email = document.rightPerInfofrm.rtemail.value;
	var birthdate = document.rightPerInfofrm.rtbirthday.value;
	var Address = document.rightPerInfofrm.rtaddress.value;
	
	if(username == ""){
		alert("username can not be empty");
		document.getElementById("rtUsername").focus();
		document.getElementById("rtUsername").value = saveusername;
		return false;
	}
	if(name == ""){
		alert("name can not be empty");
		document.getElementById("rtName").focus();
		document.getElementById("rtName").value = savename;
		return false;
	}
	if(email == ""){
　　　　alert("email can not be empty");
		document.getElementById("rtemail").focus();
		document.getElementById("rtemail").value = saveemail;
　　　　return false;
　　}else if(!reg.test(email)){ 
　　　　alert("Please enter the correct mailbox format");
		document.getElementById("rtemail").focus();
　　　　return false;
　　}
	if(birthdate == ""){
		alert("birthdate can not be empty");
		document.getElementById("rtbirthday").focus();
		document.getElementById("rtbirthday").value = savebirthdate;
		return false;
	}
	if(Address == ""){
		alert("Address can not be empty");
		document.getElementById("rtaddress").focus();
		document.getElementById("rtaddress").value = saveAddress;
		return false;
	}
	var Days = 30;
	var exdate = new Date();
	exdate.setTime(exdate.getTime() + Days*24*60*60*1000);//一月

	document.cookie="Username=" + escape(username) + ",Name=" + escape(name) + ",password=" + escape(password)+ ",birthdate=" + escape(birthdate) +",email=" + escape(email) + ",profilepicture=" + escape(picture) +",Address=" + escape(Address) +";expires=" + exdate.toGMTString();
	document.cookie="target=1;expires="+exdate.toGMTString();//做标记用的

	alert("Modify Succuss");
	gCkSetPInfo("leftPerInfo");
	
	return true;
}
// 5.1评论


// 公共方法开始
// 1.菜单
function outMenuLoginAndRegister(menu){
	var liNode = menu.parentNode;
	var ulNode = liNode.parentNode;
	// 删掉最后一个
	ulNode.removeChild(liNode);
	var a1 = document.createElement("a");
	var a2 = document.createElement("a");
	var li1 = document.createElement("li");
	var li2 = document.createElement("li");

	a1.textContent = "登录";
	a1.onclick = function(){
		location.href="Login.html"
	}
	a2.textContent = "注册";
	a2.onclick = function(){
		location.href="register.html"
	}
	li1.appendChild(a1);
	li2.appendChild(a2);
	ulNode.appendChild(li1);
	ulNode.appendChild(li2);
} 
// 2.设置左边信息
function gCkSetPInfo(mark){
	var c_end = document.cookie.indexOf(";",0);
	if(c_end != -1){
		//var myCookie = document.cookie.replace(/(?:(?:^|.*;\s*)Name\s*\=\s*([^;]*).*$)|^.*$/, "$1");
		//var allCookies = document.cookie;
		var allCookies = unescape(document.cookie.substring(0, c_end));
		var valSplitArray = allCookies.split(",");
		if(mark == "leftPerInfo"){
			var personalStr = "";
			for(var i in valSplitArray){
				var val = valSplitArray[i];
				var c_middle = val.indexOf("=");
				var c_name = unescape(val.substring(0,c_middle));
				var c_val = unescape(val.substring(c_middle + 1,val.length));
				if(c_name == "Username"){
					document.getElementById("LeftUsername").innerHTML = c_val;
				}
				if(c_name == "Name"){
					personalStr += "<p>Name:"+c_val+"</p>";
				}
				if(c_name == "birthdate"){
					personalStr += "<p>Birthdate:"+c_val+"</p>";
				}
				if(c_name == "Address"){
					personalStr += "<p>Address:"+c_val+"</p>";
				}
				if(c_name == "profilepicture"){
					document.getElementById("LeftProfilePicture").src = c_val;
				}
			}
			document.getElementById("LeftPersonalInfoPlace").innerHTML = personalStr;
		}else if(mark == "rightPerInfo"){
			for(var i in valSplitArray){
				var val = valSplitArray[i];
				var c_middle = val.indexOf("=");
				var c_name = unescape(val.substring(0,c_middle));
				var c_val = unescape(val.substring(c_middle + 1,val.length));
				if(c_name == "Username"){
					document.getElementById("rtUsername").value = c_val;
				}
				if(c_name == "Name"){
					document.getElementById("rtName").value = c_val;
				}
				if(c_name == "email"){
					document.getElementById("rtemail").value = c_val;
				}
				if(c_name == "Address"){
					document.getElementById("rtaddress").value = c_val;
				}
				if(c_name == "birthdate"){
					document.getElementById("rtbirthday").value = c_val;
				}
			}
		}
	}
}
// 3.perference 和 弹出子界面
function addMyPreferences(){
	var content = '<dd>Weekend<img src = "images/X.png" align = "right"></dd>';
	var dd = document.createElement("dd");
	var input = document.createElement("input");
	var span = document.createElement("span");
	var ddimg = document.createElement("img");
	var dlplace = document.getElementById("needAddPlace");
	
	input.type = "text";
	input.onblur = function(){
		var val = input.value;
		if(val.trim() == ""){
			dlplace.removeChild(dd);
		}else{
			span.innerHTML = val;
			dd.appendChild(span);
			dd.removeChild(input);
		}
	}
	input.onkeypress = function(e){
		//var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
		if (eCode == 13){// 按下回车
			input.blur();// 调用失去焦点 即运行那段代码
		}
	}
	
	ddimg.onclick = function(){
		dlplace.removeChild(dd);
	}
	ddimg.src = "images/X.png";
	ddimg.align = "right";

	dd.appendChild(input);
	dd.appendChild(ddimg);

	dlplace.appendChild(dd);

	input.focus();
	
}
function removeSelf(node){
	var parentnode = node.parentNode;
	var parentparentnode = parentnode.parentNode;
	parentparentnode.removeChild(parentnode);
}
function openAddtionalWindow(Opinion){
	var openUrl = "PopupOpinions.html";//弹出窗口的url
	var iWidth=800; //弹出窗口的宽度;
	var iHeight=600; //弹出窗口的高度;
	var iTop = (window.screen.availHeight-30-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	var popup = window.open(openUrl,"","height="+iHeight+", width="+iWidth+", top="+iTop+", left="+iLeft+",scrollbars = yes");
	
	//传入值进去

	var parentDd = Opinion.parentNode;
	var DdText = parentDd.textContent ;
	var infos = DdText.split(",");
	var fullname = "";
	var city = "";
	var state = "";
	for(var val in infos){
		if(val == 0){
			fullname = infos[val];
		}
		if(val == 1){
			city = infos[val];
		}
		if(val == 2){
			state = infos[val];
		}
	}

	var id = Opinion.id;
	if(id == 'res'){
		document.getElementById("type").value = "<dd id = 'fullname'>名  称:"+fullname+"</dd><dd id = 'address'>地址:"+city +","+state+"</dd><dd id = 'number of phone'>联系电话:0707-567345</dd><dd id = 'the type of food served'>餐厅种类:Hot Pot</dd>";

		document.getElementById("imgsrc").value = "images/r_1.jpg";

		document.getElementById("review").value = "我的评论:味道不得不夸耀这家商店的服务。 我看一般侍应生的服务。 两个人去吃火锅，担心我们不能吃。 我们提醒我们，商店太多，无法感谢客人。 在炎热的夏天，我也支持大火。 于是我送了一盘羊肉和冰。 其实味道也很好吃。 特殊的防锈效果很好。 我选择了骨头汤。 它不是那种绿色的水煮蔬菜！ 强烈建议您尝尝这家商店所提供的服务!!";
	}
	if(id == 'hotel'){
		document.getElementById("type").value = "<dd id = 'fullname'>名  称:"+fullname+"</dd><dd id = 'address'>地:"+city +","+state+"</dd><dd id = 'number of phone'>联系电:0707-454547345</dd>";

		document.getElementById("imgsrc").value = "images/h_2.jpg";

		document.getElementById("review").value = "我的评论:1.酒店的健康状况令人担忧。在家具，电视机上，茶几是灰色的，床底下有烟蒂。我真的不知道它是否已经清洗过。 2.优势：1：我住在豪华特大号床间。整个装饰真的很温暖。很有家的感觉！ 2：豪华房：大厅，房间仍处于连通状态！方便朋友前来参观，尤其是对于商务人士。此外，可以双向观看电视，人性化！ 3：榻榻米茶道感觉很好。特别是当我和日本客人在一起时，我感到很满意！ 4：温馨提醒，热水浴时间不应超过15-20分钟。 5：早餐也很丰富（四星级酒店）";
	}
	if(id == 'res2'){
	document.getElementById("type").value = "<dd id = 'fullname'>名  称:"+fullname+"</dd><dd id = 'address'>地址:"+city +","+state+"</dd><dd id = 'number of phone'>联系电话:0707-567345</dd><dd id = 'the type of food served'>餐厅种类:Hot Pot</dd>";

		document.getElementById("imgsrc").value = "images/r_2.jpg";

		document.getElementById("review").value = "我的评论:同事推荐的这道菜又大又实惠。 每次必须命令绍兴做到最好时，它们三个才又脆又嫩。 新鲜的酱排骨，头部超大，每个几乎和一个bun头一样大，肉非常脆.";
	
	}
	popup.focus();
}

// 获取 cokie信息
window.onload=function(){
	
	if (document.cookie.length > 0 ){
		var username = gckPersonalInfoByFname("Username");
		if(username != ""){
			gCkSetPInfo("leftPerInfo");
			gCkSetPInfo("rightPerInfo");// 右边
		}
	}
}
// 获取coke 
function gckPersonalInfoByFname(f_name){
	var c_end = document.cookie.indexOf(";",0);
	if(c_end != -1){
		var valstr = unescape(document.cookie.substring(0, c_end));
		var valSplitArray = valstr.split(",");
		for(var i in valSplitArray){
			var val = valSplitArray[i];
			var c_middle = val.indexOf("=");
			var c_name = unescape(val.substring(0,c_middle));
			var c_val = unescape(val.substring(c_middle + 1,val.length));
			if(c_name == f_name){
				return c_val;
			}
		}
	}
	return "";
}
