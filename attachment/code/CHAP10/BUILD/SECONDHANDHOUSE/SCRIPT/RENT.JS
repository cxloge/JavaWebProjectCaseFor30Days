function check() {
	document.getElementById("mf_rent:msgtype").value = "出租";
	var location = document.getElementById("mf_rent:location").value.trim();
	var detail = document.getElementById("mf_rent:detail").value.trim();
	var longitude = document.getElementById("mf_rent:longitude").value.trim();
	var latitude = document.getElementById("mf_rent:latitude").value.trim();
	var lease = document.getElementById("mf_rent:lease").value.trim();
	var price = document.getElementById("mf_rent:price").value.trim();
	var linkman = document.getElementById("mf_rent:linkman").value.trim();
	var address = document.getElementById("mf_rent:address").value.trim();
	var tel = document.getElementById("mf_rent:tel").value.trim();
	var email = document.getElementById("mf_rent:email").value.trim();
	var area = document.getElementById("mf_rent:area").value.trim();
	var reg_double = /^\d+(.\d+)?$/;
	var reg_int = /^\d+$/;
	var reg_email = /^\w+@\w+.\w+(.\w+)?$/;
	var reg_degree = /^-?\d+(.\d+)?$/;
	if(location=="") {
		showErrMsg("房源地理位置不能为空！","mf_rent:location");
		return false;
	}
	else if(detail=="") {
		showErrMsg("房屋具体位置不能为空！","mf_rent:detail");
		return false;
	}
	else if(longitude=="") {
		showErrMsg("经度不能为空!","mf_rent:longitude");
		return false;
	}
	else if(!reg_degree.test(longitude)) {
		showErrMsg("经度格式不正确！","mf_rent:longitude");
		return false;
	}
	else if(latitude=="") {
		showErrMsg("纬度不能为空！","mf_rent:latitude");
		return false;
	}
	else if(!reg_degree.test(latitude)) {
		showErrMsg("纬度格式不正确！","mf_rent:latitude");
		return false;
	}
	else if(area=="") {
		showErrMsg("面积不能为空！","mf_rent:area");
		return false;
	}
	else if(!reg_double.test(area)) {
		showErrMsg("房屋面积只能为数字！","mf_rent:area");
		return false;
	}
	else if(lease=="") {
		showErrMsg("租期不能为空！","mf_rent:lease");
		return false;
	}
	else if(!reg_int.test(lease)) {
		showErrMsg("租期只能为整数！","mf_rent:lease");
		return false;
	}
	else if(price=="") {
		showErrMsg("价格不能为空！","mf_rent:price");
		return false;
	}
	else if(!reg_double.test(price)) {
		showErrMsg("价格格式不正确！","mf_rent:price");
		return false;
	}
	else if(linkman=="") {
		showErrMsg("联系人不能为空！","mf_rent:linkman");
		return false;
	}
	else if(address=="") {
		showErrMsg("联系人地址不能为空！","mf_rent:address");
		return false;
	}
	else if(tel=="") {
		showErrMsg("联系人电话不能为空！","mf_rent:tel");
		return false;
	}
	else if(email=="") {
		showErrMsg("E-mail不能为空！","mf_rent:email");
		return false;
	}
	else if(!reg_email.test(email)) {
		showErrMsg("E-mail格式不正确！","mf_rent:email");
		return false;
	}
	return true;
}

function login() {
	var flag = document.getElementById("mf_login:flag").value;
	if(flag=="false") {
		document.getElementById("mf_login:url").value="rentpublish";
		document.getElementById("mf_login").submit();
		alert("请您先登录！");
		window.location.href="UserLogin.jsp";
	}
}


function qiuZuCheck() {
	document.getElementById("mf_rent:msgtype").value = "求租";
	var location = document.getElementById("mf_rent:location").value.trim();
	var detail = document.getElementById("mf_rent:detail").value.trim();
	var lease = document.getElementById("mf_rent:lease").value.trim();
	var price = document.getElementById("mf_rent:price").value.trim();
	var linkman = document.getElementById("mf_rent:linkman").value.trim();
	var address = document.getElementById("mf_rent:address").value.trim();
	var tel = document.getElementById("mf_rent:tel").value.trim();
	var email = document.getElementById("mf_rent:email").value.trim();
	var area = document.getElementById("mf_rent:area").value.trim();
	var reg_double = /^\d+(.\d+)?$/;
	var reg_int = /^\d+$/;
	var reg_email = /^\w+@\w+.\w+(.\w+)?$/;
	var reg_degree = /^-?\d+(.\d+)?$/;
	if(location=="") {
		showErrMsg("房源地理位置不能为空！","mf_rent:location");
		return false;
	}
	else if(detail=="") {
		showErrMsg("房屋具体位置不能为空！","mf_rent:detail");
		return false;
	}
	else if(area=="") {
		showErrMsg("面积不能为空！","mf_rent:area");
		return false;
	}
	else if(!reg_double.test(area)) {
		showErrMsg("房屋面积只能为数字！","mf_rent:area");
		return false;
	}
	else if(lease=="") {
		showErrMsg("租期不能为空！","mf_rent:lease");
		return false;
	}
	else if(!reg_int.test(lease)) {
		showErrMsg("租期只能为整数！","mf_rent:lease");
		return false;
	}
	else if(price=="") {
		showErrMsg("价格不能为空！","mf_rent:price");
		return false;
	}
	else if(!reg_double.test(price)) {
		showErrMsg("价格格式不正确！","mf_rent:price");
		return false;
	}
	else if(linkman=="") {
		showErrMsg("联系人不能为空！","mf_rent:linkman");
		return false;
	}
	else if(address=="") {
		showErrMsg("联系人地址不能为空！","mf_rent:address");
		return false;
	}
	else if(tel=="") {
		showErrMsg("联系人电话不能为空！","mf_rent:tel");
		return false;
	}
	else if(email=="") {
		showErrMsg("E-mail不能为空！","mf_rent:email");
		return false;
	}
	else if(!reg_email.test(email)) {
		showErrMsg("E-mail格式不正确！","mf_rent:email");
		return false;
	}
	return true;
}

function qiuZuLogin() {
	var flag = document.getElementById("mf_login:flag").value;
	if(flag=="false") {
		document.getElementById("mf_login:url").value="qiuzupublish";
		document.getElementById("mf_login").submit();
		alert("请您先登录！");
		window.location.href="UserLogin.jsp";
	}
}