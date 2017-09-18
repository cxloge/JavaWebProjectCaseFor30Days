function modifyAdminPwd() {
	var oldPwd = document.getElementById("mf:oldPwd").value.trim();
	var firstPwd = document.getElementById("mf:firstPwd").value.trim();
	var secondPwd = document.getElementById("mf:secondPwd").value.trim();
	if(oldPwd=="") {
		showErrMsg("旧口令不能为空！","mf:oldPwd");
		return false;
	}
	if(firstPwd=="") {
		showErrMsg("新口令不能为空！","mf:firstPwd");
		return false;
	}
	if(firstPwd.length<6) {
		showErrMsg("新密码长度不能少于6位！","mf:firstPwd");
	}
	if(secondPwd=="") {
		showErrMsg("新口令不能为空！","mf:secondPwd");
		return false;
	}
	if(firstPwd!=secondPwd) {
		showErrMsg("两次密码输入不一致！","mf:firstPwd");
		return false;
	}
	return true;
}