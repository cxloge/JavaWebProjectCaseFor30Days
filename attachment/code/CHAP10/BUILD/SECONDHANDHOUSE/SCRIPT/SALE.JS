function login() {
	var flag = document.getElementById("mf_login:flag").value.trim();
	if(flag=="false") {
		document.getElementById("mf_login:url").value="salepublish";
		document.getElementById("mf_login").submit();
		alert("请您先登录！");
		window.location.href="UserLogin.jsp";
	}
}

function check() {
	document.getElementById("mf_sale:msgtype").value="出售";
	var location = document.getElementById("mf_sale:location").value.trim();
	var detail = document.getElementById("mf_sale:detail").value.trim();
	var longitude = document.getElementById("mf_sale:longitude").value.trim();
	var latitude = document.getElementById("mf_sale:latitude").value.trim();
	var price = document.getElementById("mf_sale:price").value.trim();
	var linkman = document.getElementById("mf_sale:linkman").value.trim();
	var address = document.getElementById("mf_sale:address").value.trim();
	var tel = document.getElementById("mf_sale:tel").value.trim();
	var email = document.getElementById("mf_sale:email").value.trim();
	var area = document.getElementById("mf_sale:area").value.trim();
	var reg_double = /^\d+(.\d+)?$/;
	var reg_int = /^\d+$/;
	var reg_email = /^\w+@\w+.\w+(.\w+)?$/;
	var reg_degree = /^-?\d+(.\d+)?$/;
	if(location=="") {
		showErrMsg("房源地理位置不能为空！","mf_sale:location");
		return false;
	}
	else if(detail=="") {
		showErrMsg("房屋具体位置不能为空！","mf_sale:detail");
		return false;
	}
	else if(longitude=="") {
		showErrMsg("经度不能为空!","mf_sale:longitude");
		return false;
	}
	else if(!reg_degree.test(longitude)) {
		showErrMsg("经度格式不正确！","mf_sale:longitude");
		return false;
	}
	else if(latitude=="") {
		showErrMsg("纬度不能为空！","mf_sale:latitude");
		return false;
	}
	else if(!reg_degree.test(latitude)) {
		showErrMsg("纬度格式不正确！","mf_sale:latitude");
		return false;
	}
	else if(area=="") {
		showErrMsg("面积不能为空！","mf_sale:area");
		return false;
	}
	else if(!reg_double.test(area)) {
		showErrMsg("房屋面积只能为数字！","mf_sale:area");
		return false;
	}
	else if(price=="") {
		showErrMsg("价格不能为空！","mf_sale:price");
		return false;
	}
	else if(!reg_double.test(price)) {
		showErrMsg("价格格式不正确！","mf_sale:price");
		return false;
	}
	else if(linkman=="") {
		showErrMsg("联系人不能为空！","mf_sale:linkman");
		return false;
	}
	else if(address=="") {
		showErrMsg("联系人地址不能为空！","mf_sale:address");
		return false;
	}
	else if(tel=="") {
		showErrMsg("联系人电话不能为空！","mf_sale:tel");
		return false;
	}
	else if(email=="") {
		showErrMsg("E-mail不能为空！","mf_sale:email");
		return false;
	}
	else if(!reg_email.test(email)) {
		showErrMsg("E-mail格式不正确！","mf_sale:email");
		return false;
	}
	return true;
}



function qiuGouLogin() {
	var flag = document.getElementById("mf_login:flag").value.trim();
	if(flag=="false") {
		document.getElementById("mf_login:url").value="qiugoupublish";
		document.getElementById("mf_login").submit();
		alert("请您先登录！");
		window.location.href="UserLogin.jsp";
	}
}

function qiuGouCheck() {
	document.getElementById("mf_sale:msgtype").value="求购";
	var location = document.getElementById("mf_sale:location").value.trim();
	var detail = document.getElementById("mf_sale:detail").value.trim();
	var price = document.getElementById("mf_sale:price").value.trim();
	var linkman = document.getElementById("mf_sale:linkman").value.trim();
	var address = document.getElementById("mf_sale:address").value.trim();
	var tel = document.getElementById("mf_sale:tel").value.trim();
	var email = document.getElementById("mf_sale:email").value.trim();
	var area = document.getElementById("mf_sale:area").value.trim();
	var reg_double = /^\d+(.\d+)?$/;
	var reg_int = /^\d+$/;
	var reg_email = /^\w+@\w+.\w+(.\w+)?$/;
	var reg_degree = /^-?\d+(.\d+)?$/;
	if(location=="") {
		showErrMsg("房源地理位置不能为空！","mf_sale:location");
		return false;
	}
	else if(detail=="") {
		showErrMsg("房屋具体位置不能为空！","mf_sale:detail");
		return false;
	}
	else if(area=="") {
		showErrMsg("面积不能为空！","mf_sale:area");
		return false;
	}
	else if(!reg_double.test(area)) {
		showErrMsg("房屋面积只能为数字！","mf_sale:area");
		return false;
	}
	else if(price=="") {
		showErrMsg("价格不能为空！","mf_sale:price");
		return false;
	}
	else if(!reg_double.test(price)) {
		showErrMsg("价格格式不正确！","mf_sale:price");
		return false;
	}
	else if(linkman=="") {
		showErrMsg("联系人不能为空！","mf_sale:linkman");
		return false;
	}
	else if(address=="") {
		showErrMsg("联系人地址不能为空！","mf_sale:address");
		return false;
	}
	else if(tel=="") {
		showErrMsg("联系人电话不能为空！","mf_sale:tel");
		return false;
	}
	else if(email=="") {
		showErrMsg("E-mail不能为空！","mf_sale:email");
		return false;
	}
	else if(!reg_email.test(email)) {
		showErrMsg("E-mail格式不正确！","mf_sale:email");
		return false;
	}
	return true;
}






