String.prototype.trim=function()
{
  return this.replace(/(^\s*)|(\s*$)/g,"");
}

function checkAddRes(){
		var rname = document.getElementById('addRes:rname').value.trim();
		var rspec = document.getElementById('addRes:rspec').value.trim();
		var rprice = document.getElementById('addRes:rprice').value.trim();
		var rdetail = document.getElementById('addRes:rdetail').value.trim();
		
		if(rname==""){
				alert("资源名称不得为空");
				return false;
		}
		if(rspec==""){
				alert("资源规格不得为空");
				return false;
		}
		if(rprice==""){
				alert("资源价格不得为空");
				return false;
		}
		var reg = /^\d+(\.\d+)?$/;
		if(!reg.test(rprice)){
			alert("资源价格格式不对");
			return false;
		}
		
		if(rdetail==""){
			alert("描述不得为空");
			return false;
		}	
		return true;
}