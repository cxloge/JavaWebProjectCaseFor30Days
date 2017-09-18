function checkAddAdmin(){
	var adID = document.addAdmin.adID.value;
	var adPwd = document.addAdmin.adPwd.value;
	if(adID.trim()==""){
		alert("管理员名不得为空！！！");
		addAdmin.adID.value="";
		addAdmin.adPwd.value="";
		addAdmin.adID.focus();
		return;
	}
	if(adID.trim().length<3){
		alert("管理员名不得包含空格且长度不得小于3位！！！");
		addAdmin.adID.value="";
		addAdmin.adPwd.value="";
		addAdmin.adID.focus();
		return;
	}
	if(adPwd==""){
		alert("管理员密码为空！！！");
		addAdmin.adPwd.value="";	
		addAdmin.adPwd.focus();
		return;
	}
	if(adPwd.trim().length<6){
		alert("管理员密码不得包含空格且长度不得小于6位！！！");
		addAdmin.adPwd.value="";
		addAdmin.adPwd.focus();
		return;
	}
	document.addAdmin.submit();
}