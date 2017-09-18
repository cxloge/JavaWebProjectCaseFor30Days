function check() {
	var uname = document.getElementById("mf_reg:uname").value.trim();
	var firstPwd = document.getElementById("mf_reg:firstPwd").value.trim();
	var secondPwd = document.getElementById("mf_reg:secondPwd").value.trim();
	var uemail = document.getElementById("mf_reg:uemail").value.trim();
	var reg = /^\w+@\w+.\w+(.\w+)?$/;
	if(uname=="") {
		showErrMsg("用户名不能为空！","mf_reg:uname");
		return false;
	}
	else if(firstPwd=="") {
		showErrMsg("密码不能为空！","mf_reg:firstPwd");
		return false;
	}
	else if(firstPwd.length<6) {
		showErrMsg("密码长度不能小于6！","mf_reg:firstPwd");
		return false;
	}
	else if(secondPwd=="") {
		showErrMsg("密码不能为空！","mf_reg:secondPwd");
		return false;
	}
	else if(secondPwd.length<6) {
		showErrMsg("密码长度不能小于6！","mf_reg:secondPwd");
		return false;
	}
	else if(firstPwd!=secondPwd) {
		showErrMsg("两次密码输入不一致！","mf_reg:firstPwd");
		return false;
	}
	else if(uemail=="") {
		showErrMsg("E-mail不能为空！","mf_reg:uemail");
		return false;
	}
	else if(!reg.test(uemail)) {
		showErrMsg("E-mail格式不正确！","mf_reg:uemail");
		return false;
	}
	else {
		return true;
	}
}