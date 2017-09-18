	String.prototype.trim=function()
{
  return this.replace(/(^\s*)|(\s*$)/g,"");
}
function reloadImage(){/*重新加载验证码图片*/
  	document.getElementById("adminLogin:pic").src='../yzm.jsp?'+Math.random();
}
	function checkAdminLogin(){
	
		var code = document.getElementById('adminLogin:yzm').value.trim();
		var aname = document.getElementById('adminLogin:aname').value.trim();
		var pwd = document.getElementById('adminLogin:apwd').value.trim();
	
	var reg = /^\w+$/;	
	if(code==""){
		alert("验证码不得为空。");
		return false;
	}
	if(code.length!=4){
		alert("验证码长度不正确。");
		return false;
	}
	if(!reg.test(code)){
		alert("请输入正确的验证码。");
		return false;
	}
	
	if(aname==""){
		alert("用户名不得为空。");	
		return false;
	}
	
	
	if(pwd.length<6||pwd==""){		
		"对不起，密码不得为空并长度不得小于6。";
		return false;
	}
	if(!reg.test(pwd)){
		alert("对不起，密码包含非法字符。");
		return false;
	}
		return true;
	}