String.prototype.trim=function()
{
  return this.replace(/(^\s*)|(\s*$)/g,"");
}
function reloadImage(){/*重新加载验证码图片*/
  	document.getElementById("loginform:pic").src='../yzm.jsp?'+Math.random();
}
function checkLogin(){/*验证验证码是否是4为数字和字母的组合*/
	var reg = /^\w+$/;
	var code = document.getElementById("loginform:yzm").value.trim();
	if(code==""){
		showMsg("验证码不得为空。","loginform:yzm");	
		return false;
	}
	if(code.length!=4){
		showMsg("验证码长度不正确。","loginform:yzm");	
		return false;
	}	
	if(!reg.test(code)){
		showMsg("请输入正确的验证码。","loginform:yzm");	
		return false;
	}
	
	var uname = document.getElementById("loginform:uname").value.trim();
	if(uname==""){
		showMsg("用户名不得为空。","loginform:uname");	
		return false;
	}
	if(uname.length<3){
		showMsg("用户名长度不得小于3。","loginform:uname");	
		return false;
	}
	var pwd = document.getElementById("loginform:pwd").value.trim();
	if(pwd==""){
		showMsg("密码不得为空。","loginform:pwd");	
		return false;
	}
	if(pwd.length<6){
		showMsg("密码长度不得小于6。","loginform:pwd");	
		return false;
	}
	return true;
}