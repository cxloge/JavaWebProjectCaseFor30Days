String.prototype.trim=function()
{
  return this.replace(/(^\s*)|(\s*$)/g,"");
}
function checkOldPwd(){/*验证密码*/
	var reg = /^\w+$/;
	var pwd = document.getElementById('changePwd:oldPwd').value.trim();
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
function checkNewPwd(){/*验证密码*/
	var reg = /^\w+$/;
	var pwd = document.getElementById('changePwd:newPwd').value.trim();
	if(pwd.length<6||pwd==""){
		document.all.pwdMsg2.innerHTML="<img src='images/check_error.gif'/>"+
																"对不起，密码不得为空并长度不得小于6。";
		return false;
	}
	if(!reg.test(pwd)){
		document.all.pwdMsg2.innerHTML="<img src='images/check_error.gif'/>"+
												  									"对不起，密码包含非法字符。";
		return false;
	}
	document.all.pwdMsg2.innerHTML="<img src='images/check_right.gif'/>";
	return true;
}

function checkReNewPwd(){/*验证确认密码是否正确*/
	var reg = /^\w+$/;
	var pwd = document.getElementById('changePwd:newPwd').value.trim();
	var pwd2 = document.getElementById('changePwd:reNewPwd').value.trim();
	if(pwd2.length<6||pwd2==""){
		document.all.pwdMsg3.innerHTML="<img src='images/check_error.gif'/>"+
										"对不起，密码不得为空并长度不得小于6。";
		return false;
	}
	if(!reg.test(pwd2)){
		document.all.pwdMsg3.innerHTML="<img src='images/check_error.gif'/>"+
												 "对不起，密码包含非法字符。";
		return false;
	}
	if(pwd!=pwd2){
		document.all.pwdMsg3.innerHTML="<img src='images/check_error.gif'/>"+
											"两次密码输入不一直，请核对后输入。";
		return false;
	}
	document.all.pwdMsg3.innerHTML="<img src='images/check_right.gif'/>";
	return true;
}

function checkPwd(){
	if(!checkOldPwd()){
		showMsg("旧密码输入不正确，请重新输入","changePwd:oldPwd");
		return false;
	}
	if(!checkNewPwd()){
		showMsg("新密码输入不正确，请重新输入","changePwd:newPwd");
		return false;
	}
	if(!checkReNewPwd()){
		showMsg("确认密码输入不正确，请重新输入","changePwd:reNewPwd");
		return false;
	}
	return true;
}

