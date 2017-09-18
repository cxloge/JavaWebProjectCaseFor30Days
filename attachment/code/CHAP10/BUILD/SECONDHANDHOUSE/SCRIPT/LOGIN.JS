function loadImg(){
	var now = new Date().getTime();
	document.getElementById('mf:yzm').src="yzm.jsp?flag="+now;
}

function check(){
	var uname = document.getElementById('mf:uname').value;
	var upwd = document.getElementById('mf:upwd').value;
	var uyzm = document.getElementById('mf:uyzm').value;
	if(uname.trim()==""){
		showErrMsg("用户名不能为空！","mf:uname");
		return false;
	}
	if(upwd.trim()==""){
		showErrMsg("密码不能为空！","mf:upwd");
		return false;
	}
	if(uyzm.trim()==""){
		showErrMsg("验证码不能为空！","mf:uyzm");
		return false;
	}
	if(uyzm.length!=4){
		showErrMsg("验证码错误！","mf:uyzm");
		return false;
	}
	return true;
}

function adminLogin() {
	var aname = document.getElementById("mf:aname").value;
	var apwd = document.getElementById("mf:apwd").value;
	var ayzm = document.getElementById("mf:ayzm").value;

	if(aname=="") {
		showErrMsg("用户名不能为空！","mf:aname");
		return false;
	}
	if(apwd=="") {
		showErrMsg("密码不能为空！","mf:apwd");
		return false;
	}
	if(ayzm=="") {
		showErrMsg("验证码不能为空！","mf:ayzm");
		return false;
	}
	if(ayzm.length!=4) {
		showErrMsg("验证码错误！","mf:ayzm");
		return false;
	}
	return true;
}



