function checkAdChangePwd(){
	var oldPwd = document.adChangePwd.oldPwd.value;
	var newPwd = document.adChangePwd.newPwd.value;
	var newPwdAgain = document.adChangePwd.newPwdAgain.value;
	if(oldPwd==""){
		alert("旧密码为空！！！");
		adChangePwd.oldPwd.value="";
		adChangePwd.newPwd.value="";
		adChangePwd.newPwdAgain.value="";
		adChangePwd.oldPwd.focus();
		return;
	}
	if(oldPwd.trim().length<6){
		alert("旧密码不得包含空格且长度不得小于6位！！！");
		adChangePwd.oldPwd.value="";
		adChangePwd.oldPwd.focus();
		return;
	}
	if(newPwd==""){
		alert("新密码为空！！！");
		adChangePwd.newPwd.value="";
		adChangePwd.newPwdAgain.value="";
		adChangePwd.newPwd.focus();
		return;
	}
	if(newPwd.trim().length<6){
		alert("新密码不得包含空格且长度不得小于6位！！！");
		adChangePwd.newPwd.value="";
		adChangePwd.newPwdAgain.value="";
		adChangePwd.newPwd.focus();
		return;
	}
	if(newPwd!=newPwdAgain){
		alert("两次输入密码不一致！！！");
		adChangePwd.newPwd.value="";
		adChangePwd.newPwdAgain.value="";
		adChangePwd.newPwd.focus();
		return;
	}
	document.adChangePwd.submit();			   
}