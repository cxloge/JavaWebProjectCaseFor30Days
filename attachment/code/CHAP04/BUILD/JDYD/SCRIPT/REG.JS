String.prototype.trim=function()
{
  return this.replace(/(^\s*)|(\s*$)/g,"");
}
function reloadImage(){/*重新加载验证码图片*/
  	document.getElementById("regform:pic").src='../yzm.jsp?'+Math.random();
}
function checkValCode(){/*验证验证码是否是4为数字和字母的组合*/
	var reg = /^\w+$/;
	var code = document.getElementById("regform:yzm").value.trim();
	if(code==""){
		document.all.codeMsg.innerHTML="<img src='images/check_error.gif'/>验证码不得为空。";
		return false;
	}
	if(code.length!=4){
		document.all.codeMsg.innerHTML="<img src='images/check_error.gif'/>验证码长度不正确。";
		return false;
	}
	if(!reg.test(code)){
		document.all.codeMsg.innerHTML="<img src='images/check_error.gif'/>请输入正确的验证码。";
		return false;
	}
	return true;
}

function checkUname(){/*验证用户名*/		  		
	var uname = document.getElementById('regform:uname').value.trim();
	if(uname.length<3){
		document.all.unameMsg.innerHTML="<img src='images/check_error.gif'/>"+
					"对不起，您输入的用户名长度小于3个字符, 请输入一个较长的用户名。";
		return false;
	}
	document.all.unameMsg.innerHTML="<img src='images/check_right.gif'/>";
	return true;
}

function checkPwd(){/*验证密码*/
	var reg = /^\w+$/;
	var pwd = document.getElementById('regform:pwd').value.trim();
	if(pwd.length<6||pwd==""){
		document.all.pwdMsg.innerHTML="<img src='images/check_error.gif'/>"+
																"对不起，密码不得为空并长度不得小于6。";
		return false;
	}
	if(!reg.test(pwd)){
		document.all.pwdMsg.innerHTML="<img src='images/check_error.gif'/>"+
												  									"对不起，密码包含非法字符。";
		return false;
	}
	document.all.pwdMsg.innerHTML="<img src='images/check_right.gif'/>";
	return true;
}

function checkPwd2(){/*验证确认密码是否正确*/
	var reg = /^\w+$/;
	var pwd = document.getElementById('regform:pwd').value.trim();
	var pwd2 = document.getElementById('regform:rePwd').value.trim();
	if(pwd2.length<6||pwd2==""){
		document.all.pwdMsg2.innerHTML="<img src='images/check_error.gif'/>"+
										"对不起，密码不得为空并长度不得小于6。";
		return false;
	}
	if(!reg.test(pwd2)){
		document.all.pwdMsg2.innerHTML="<img src='images/check_error.gif'/>"+
												 "对不起，密码包含非法字符。";
		return false;
	}
	if(pwd!=pwd2){
		document.all.pwdMsg2.innerHTML="<img src='images/check_error.gif'/>"+
											"两次密码输入不一直，请核对后输入。";
		return false;
	}
	document.all.pwdMsg2.innerHTML="<img src='images/check_right.gif'/>";
	return true;
}

function checkEmail(){/*验证email地址*/
	var reg2 = /^([0-9a-zA-Z]+[_.0-9a-zA-Z]+)@([a-zA-Z0-9]+[.])+([a-zA-Z]{2,3})$/;
	var email = document.getElementById('regform:email').value.trim();
	if(email==""){
		document.all.emailMsg.innerHTML="<img src='images/check_error.gif'/>"+
													"邮箱不得为空，请重新填写。";
		return false;
	}
	if(!reg2.test(email)){
		document.all.emailMsg.innerHTML="<img src='images/check_error.gif'/>"+
													"邮箱地址无效，请重新填写。";
		return false;
	}
	document.all.emailMsg.innerHTML="<img src='images/check_right.gif'/>";
	return true;
}

function checkPhone(){
	var reg = /\d/;
	var phone = document.getElementById('regform:phone').value.trim();
	if(phone==""){
		document.all.phoneMsg.innerHTML="<img src='images/check_error.gif'/>"+
													"电话号码为空，请重新填写。";
		 return false;
	}
	if(phone.length<11){
		document.all.phoneMsg.innerHTML="<img src='images/check_error.gif'/>"+
													"电话号码长度不正确，请重新填写。";
		return false;													
	}
	if(!reg.test(phone)){
		document.all.phoneMsg.innerHTML="<img src='images/check_error.gif'/>"+
													"电话号码格式不对，请重新填写。";
		return false;
	}
	document.all.phoneMsg.innerHTML="<img src='images/check_right.gif'/>";
	return true;
}

function checkReg(){/*注册提交表单时*/
	if(!checkValCode()){
		showMsg("验证码输入错误，请核对输入。","regform:yzm");	
		return false;	
	}
	if(!checkUname){
		showMsg("用户名不符合要求，请核对输入。","regform:uname");	
		return false;	
	}
	if(!checkPwd()){
		showMsg("密码不符合要求，请核对输入。","regform:pwd");
		return false;
	}
	if(!checkPwd2()){
		showMsg("密码不符合要求，请核对输入。","regform:rePwd");
		return false;
	}
	if(!checkEmail()){
		showMsg("电子邮件格式不对，请核对输入。","regform:email");
		return false;
	}
	if(!checkPhone()){
		showMsg("电话号码格式不对，请核对输入。","regform:phone");
		return false;
	}
	return true;
} 