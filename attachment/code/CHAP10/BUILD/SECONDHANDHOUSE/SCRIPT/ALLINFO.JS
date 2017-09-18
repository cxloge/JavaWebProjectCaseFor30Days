function checkPage() {
	var total = document.getElementById("mf:totalPage").value.trim();
	var page = document.getElementById("mf:page").value.trim();
	var reg = /^[1-9]\d*$/;
	if(page=="") {
		showErrMsg("要跳转页面不能为空！","mf:page");
		return false;
	}
	else if(!reg.test(page)) {
		showErrMsg("页面输入不合法！","mf:page");
		return false;
	}
	else if(page>total) {
		showErrMsg("页面输入不合法！","mf:page");
		return false;
	}
	return true;
}

function clearPage() {
	document.getElementById("mf:page").value = "";
}