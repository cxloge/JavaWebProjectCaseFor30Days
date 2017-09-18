function check() {
	var oldPwd = document.getElementById("mf:oldPwd").value;
	var firstPwd = document.getElementById("mf:firstPwd").value;
	var secondPwd = document.getElementById("mf:secondPwd").value;
	if(oldPwd.trim()=="") {
		showErrMsg("旧口令不能为空！","mf:oldPwd");
		return false;
	}
	if(firstPwd.trim()=="") {
		showErrMsg("新口令不能为空！","mf:firstPwd");
		return false;
	}
	if(secondPwd.trim()=="") {
		showErrMsg("新口令不能为空！","mf:secondPwd");
		return false;
	}
	if(firstPwd.trim()!=secondPwd.trim()) {
		showErrMsg("两次输入不一致！","mf:firstPwd");
		return false;
	}
	return true;
}