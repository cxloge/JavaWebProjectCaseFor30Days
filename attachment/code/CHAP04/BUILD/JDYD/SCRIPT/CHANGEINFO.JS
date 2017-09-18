String.prototype.trim=function()
{
  return this.replace(/(^\s*)|(\s*$)/g,"");
}

function checkEmail(){/*验证email地址*/
	var reg2 = /^([0-9a-zA-Z]+[_.0-9a-zA-Z]+)@([a-zA-Z0-9]+[.])+([a-zA-Z]{2,3})$/;
	var email = document.getElementById('changeInfo:email').value.trim();
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
	var phone = document.getElementById('changeInfo:phone').value.trim();
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

function checkInfo(){/*修改资料提交表单时*/
	if(!checkEmail()){
		showMsg("电子邮件格式不对，请核对输入。","changeInfo:email");
		return false;
	}
	if(!checkPhone()){
		showMsg("电话号码格式不对，请核对输入。","changeInfo:phone");
		return false;
	}
	return true;
} 