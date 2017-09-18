    	String.prototype.trim=function()
		{
		  return this.replace(/(^\s*)|(\s*$)/g,"");
		}
    	function checkAdminChangePwd(){
    	
    		var oldPwd = document.getElementById('adminChangePwd:oldPwd').value.trim();
    		var newPwd = document.getElementById('adminChangePwd:newPwd').value.trim();
    		var reNewPwd = document.getElementById('adminChangePwd:reNewPwd').value.trim();
			
			var reg = /^\w+$/;
			if(oldPwd.length<6||oldPwd==""){
				alert("对不起，旧密码不得为空并长度不得小于6。");
				return false;
			}
			if(!reg.test(oldPwd)){
				alert("对不起，旧密码包含非法字符。");
				return false;
			}
			
			if(newPwd.length<6||newPwd==""){
				alert("对不起，新密码不得为空并长度不得小于6。");
				return false;
			}
			if(!reg.test(newPwd)){
				alert("对不起，密码包含非法字符。");
				return false;
			}
			
			if(reNewPwd.length<6||reNewPwd==""){
				alert("对不起，确认新密码不得为空并长度不得小于6。");
				return false;
			}
			if(!reg.test(reNewPwd)){
				alert("对不起，确认新密码包含非法字符。");
				return false;
			}
			if(reNewPwd!=newPwd){
				alert("两次密码输入不一直，请核对后输入。");
				return false;
			}
			return true;
    	}