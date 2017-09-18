function loadImg(){
	var now = new Date().getTime();
	document.all.yzm.src="yzm.jsp?flag="+now;
}

var flag;
var req;
var isIE=navigator.appName=="Microsoft Internet Explorer";

function validateUname(){
   var uname = document.all.uname.value.trim();
   var uri="ManageServlet?action=checkUname&uname="+escape(escape(uname));
   //初始化XMLHttpRequest对象
   if(window.XMLHttpRequest){//IE之外的浏览器
      req=new XMLHttpRequest();
   }
   else{
      try{
          req=new ActiveXObject("Msxml2.XMLHTTP");
      }
      catch(e){
         try{
             req=new ActiveXObject("Microsoft.XMLHTTP");
     	 }
         catch(e){
           alert("不能创建XMLHttpRequest对象！！！");
           return;
        }
      }
   }
   //发送请求
   req.open("GET",uri,true);
   req.onreadystatechange=function() {
	  if(req.readyState==4){
	     if(req.status==200){
	        var msg=req.responseText;
			if(msg.trim()=="ok"){
				document.all.uname_explain.innerHTML="<font size=\"4\" color=\"#6FEF39\">&nbsp;&nbsp;&nbsp;√</font>";
				flag=true;
		    }
		    else if(msg.trim()=="no"){
		    	document.all.uname_explain.className="reg_error";
		        document.all.uname_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;用户名已被占用";
		        flag=false;
		    }
	     }
	  }
   }
   req.send(null);
}


function checkUname(){
	document.all.reg_name.className="";
	var uname = document.all.uname.value.trim();
	var pattern = /^\w+$/;
	if(uname==""){
		document.all.uname_explain.className="reg_error";
		document.all.uname_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;用户名不可以为空，请输入";
		return false;
	}
	else if(!pattern.test(uname)){
		document.all.uname_explain.className="reg_error";
		document.all.uname_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;格式不正确，请输入正确的格式";
		return false;
	}
	else{
		document.all.uname_explain.innerHTML="正在检测用户名...";
		validateUname();
		return true;
	}
	//alert("check name");
}

function checkOldUpwd(){
	document.all.reg_old.className="";
	var pwd = document.all.upwd_old.value.trim();
	var pattern = /^\w+$/;
	if(pwd.length<6){
		document.all.upwd_old_explain.className="reg_error";
		document.all.upwd_old_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;密码长度不能小于6";
		return false;
	}
	else if(!pattern.test(pwd)){
		document.all.upwd_old_explain.className="reg_error";
		document.all.upwd_old_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;密码输入不合法，请重新输入";
		return false;
	}
	else{
		document.all.upwd_old_explain.innerHTML="<font size=\"4\" color=\"#6FEF39\">&nbsp;&nbsp;&nbsp;√</font>";
		return true;
	}
}

function checkUpwd(){
	document.all.reg_first.className="";
	var pwd = document.all.upwd_first.value.trim();
	var pattern = /^\w+$/;
	if(pwd.length<6){
		document.all.upwd_first_explain.className="reg_error";
		document.all.upwd_first_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;密码长度不能小于6";
		return false;
	}
	else if(!pattern.test(pwd)){
		document.all.upwd_first_explain.className="reg_error";
		document.all.upwd_first_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;密码输入不合法，请重新输入";
		return false;
	}
	else{
		document.all.upwd_first_explain.innerHTML="<font size=\"4\" color=\"#6FEF39\">&nbsp;&nbsp;&nbsp;√</font>";
		return true;
	}
}

function checkSecUpwd(){
	document.all.reg_second.className="";
	var pwd = document.all.upwd_second.value.trim();
	var pwd_first = document.all.upwd_first.value.trim();
	if(pwd.length<6){
		document.all.upwd_second_explain.className="reg_error";
		document.all.upwd_second_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;密码长度不能小于6";
		return false;
	}
	else if(pwd!=pwd_first){
		document.all.upwd_second_explain.className="reg_error";
		document.all.upwd_second_explain.innerHTML="<img src='images/error.gif'/>&nbsp;&nbsp;两次密码输入不一致，请重新输入";
		return false;
	}
	else{
		document.all.upwd_second_explain.innerHTML="<font size=\"4\" color=\"#6FEF39\">&nbsp;&nbsp;&nbsp;√</font>";
		return true;
	}
}

function check_submit(){
	var yzm = document.mf_reg.identify.value;
	var pattern = /^[0-9a-zA-Z]{4}$/;
	if(yzm.trim()==""){
		alert("请输入验证码！！！");
		return;
	}
	else if(!pattern.test(yzm.trim())){
		alert("验证码格式不正确！！！");
		return;
	}
	if(checkUname()&&flag&&checkUpwd()&&checkSecUpwd()){
		document.mf_reg.submit();
	}
}

function check_modify(){
	var yzm = document.mf_reg.identify.value;
	var pattern = /^[0-9a-zA-Z]{4}$/;
	if(yzm.trim()==""){
		alert("请输入验证码！！！");
		return;
	}
	else if(!pattern.test(yzm.trim())){
		alert("验证码格式不正确！！！");
		return;
	}
	if(checkOldUpwd()&&checkUpwd()&&checkSecUpwd()){
		document.mf_reg.submit();
	}
}