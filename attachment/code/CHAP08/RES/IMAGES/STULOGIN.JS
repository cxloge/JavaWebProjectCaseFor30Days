function checkUser(){
    var uname = document.login.uname.value;//得到输入的登录名
    var pwd = document.login.pwd.value;    //得到输入的密码   
	if(uname.trim()==""){				   //用户名为空的情况	
		alert("请填写用户名！！！");		   //弹出提示对话框
        login.uname.focus();			   //用户名文本框得到输入焦点
        return;					   		   //返回	
	}
	if(pwd==""){			   			   //密码为空的情况
		alert("请填写密码！！！");	       //弹出提示对话框
		login.pwd.value="";				   //将密码框清空
        login.pwd.focus();				   //密码文本框得到输入焦点
        return;					   		   //返回
	}
	if(pwd.trim().length<6){
    	alert("密码不能包含空格且长度不得小于6位！！！");
    	login.pwd.value="";					//将密码框清空
    	login.pwd.focus();					//密码框得到输入焦点
    	return;								//返回
	}
	document.login.submit();			   //提交登陆表单
}