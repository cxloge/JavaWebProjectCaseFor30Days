function loadImg(){
	var now = new Date().getTime();
	document.all.yzm.src="yzm.jsp?flag="+now;
}

function check(){
	var aname = document.all.aname.value.trim();
	var apwd = document.all.apwd.value.trim();
	var identify = document.all.identify.value.trim();
	if(aname==""){
		showErrMsg("用户名不能为空！！！","aname");
		return;
	}
	if(apwd==""){
		showErrMsg("密码不能为空！！！","apwd");
		return;
	}
	if(identify==""){
		showErrMsg("验证码不能为空！！！","identify");
		return;
	}
	document.mf_login.submit();
}