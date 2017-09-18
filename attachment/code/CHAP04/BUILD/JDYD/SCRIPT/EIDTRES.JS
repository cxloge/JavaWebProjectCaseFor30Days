String.prototype.trim=function()
{
  return this.replace(/(^\s*)|(\s*$)/g,"");
}

function checkEditRes(){
		var rname = document.getElementById('editRes:rname').value.trim();
		var rspec = document.getElementById('editRes:rspec').value.trim();
		var rprice = document.getElementById('editRes:rprice').value.trim();
		var rdetail = document.getElementById('editRes:rdetail').value.trim();
		
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