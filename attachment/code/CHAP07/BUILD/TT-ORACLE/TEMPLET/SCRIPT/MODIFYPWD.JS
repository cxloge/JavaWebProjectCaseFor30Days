function check(){
	var aname = document.all.aname.value.trim();
	var first = document.all.first.value.trim();
	var second = document.all.second.value.trim();
	
	if(aname==""){
		showErrMsg("用户名不能为空！","aname");
		return;
	}
	if(first==""){
		showErrMsg("密码不能为空！","first");
		return;
	}
	if(second!=first){
		showErrMsg("两次密码输入不一致！","second");
		return;
	}
	document.mf_reset.submit();
}

function checkPwd(){

	var oldpwd = document.all.oldpwd.value.trim();
	var first = document.all.first.value.trim();
	var second = document.all.second.value.trim();
	
	if(oldpwd==""){
		showErrMsg("用户名不能为空！","oldpwd");
		return;
	}
	if(first==""){
		showErrMsg("密码不能为空！","first");
		return;
	}
	if(second!=first){
		showErrMsg("两次密码输入不一致！","second");
		return;
	}
	document.mf_pwd.submit();
}

