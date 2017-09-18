function checkRent() {
	var linkman = document.getElementById("mf_lookdetail:linkman").value.trim();
	var tel = document.getElementById("mf_lookdetail:tel").value.trim();
	var email = document.getElementById("mf_lookdetail:email").value.trim();
	var reg = /^\w+@\w+.\w+(.\w+)?$/;
	if(linkman=="") {
		showErrMsg("联系人不能为空！","mf_lookdetail:linkman");
		return false;
	}
	else if(tel=="") {
		showErrMsg("联系电话不能为空！","mf_lookdetail:tel");
		return false;
	}
	else if(email=="") {
		showErrMsg("E-mail不能为空！","mf_lookdetail:email");
		return false;
	}
	else if(!reg.test(email)) {
		showErrMsg("E-mail格式不正确！","mf_lookdetail:email");
		return false;
	}
	return true;
}