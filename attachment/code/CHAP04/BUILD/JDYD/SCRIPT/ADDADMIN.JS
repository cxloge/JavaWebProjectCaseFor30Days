		String.prototype.trim=function()
		{
		  return this.replace(/(^\s*)|(\s*$)/g,"");
		}
    function checkAddAdmin(){
  		var aname = document.getElementById('addAdmin:aname').value.trim();
  		var pwd = document.getElementById('addAdmin:pwd').value.trim();
  		var rePwd = document.getElementById('addAdmin:rePwd').value.trim();
  		var reg = /^\w+$/;
  		if(aname==""){
  			alert("管理员名不得为空");
  			return false;
  		}
  		if(aname.length<3){
  			alert("管理员名长度不得小于3位");
  			return false;
  		}
    		
  		if(pwd.length<6||pwd==""){
			alert("对不起，密码不得为空并长度不得小于6。");
			return false;
			}
			if(!reg.test(pwd)){
				alert("对不起，密码包含非法字符。");
				return false;
			}
			
			if(rePwd.length<6||rePwd==""){
				alert("对不起，确认密码不得为空并长度不得小于6。");
				return false;
			}
			if(!reg.test(rePwd)){
				alert("对不起，确认密码包含非法字符。");
				return false;
			}
			if(rePwd!=pwd){
				alert("两次密码输入不一直，请核对后输入。");
				return false;
			}
    		return true;
    	}