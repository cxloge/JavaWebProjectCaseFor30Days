function checkAdmin() {
	var aname = document.getElementById("mf:aname").value.trim();
	var firstPwd = document.getElementById("mf:firstPwd").value.trim();
	var secondPwd = document.getElementById("mf:secondPwd").value.trim();

	if(aname=="") {
		showErrMsg("用户名不能为空！","mf:aname");
		return false;
	}
	else if(firstPwd=="") {
		showErrMsg("密码不能为空！","mf:firstPwd");
		return false;
	}
	else if(firstPwd.length<6) {
		showErrMsg("密码长度不能小于6！","mf:firstPwd");
		return false;
	}
	else if(secondPwd=="") {
		showErrMsg("密码不能为空！","mf:secondPwd");
		return false;
	}
	else if(firstPwd!=secondPwd) {
		showErrMsg("两次密码输入不一致！","mf:firstPwd");
		return false;
	}
	return true;
}