function checkRentContract() {
	var first = document.getElementById("mf:first").value.trim();
	var second = document.getElementById("mf:second").value.trim();
	var beginTime = document.getElementById("mf:beginTime").value.trim();
	var endTime = document.getElementById("mf:endTime").value.trim();
	var price = document.getElementById("mf:price").value.trim();
	var firstTel = document.getElementById("mf:firstTel").value.trim();
	var secondTel = document.getElementById("mf:secondTel").value.trim();
	var address = document.getElementById("mf:address").value.trim();
	var pattern = /^\d{4}-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2]\d)|(3[0-1]))$/;
	var doublePat = /^\d+(.\d+)?$/;
	var telPat = /^(\d{4}-)?\d+$/;

	if(first=="") {
		showErrMsg("租赁方不能为空！","mf:first");
		return false;
	}
	else if(second=="") {
		showErrMsg("承租方不能为空！","mf:second");
		return false;
	}
	else if(beginTime=="") {
		showErrMsg("起始日期不能为空！","mf:beginTime");
		return false;
	}
	else if(!pattern.test(beginTime)) {
		showErrMsg("日期格式应为yyyy-mm-dd。","mf:beginTime");
		return false;
	}
	else if(endTime=="") {
		showErrMsg("终止日期不能为空！","mf:endTime");
		return false;
	}
	else if(!pattern.test(endTime)) {
		showErrMsg("日期格式应为yyyy-mm-dd。","mf:endTime");
		return false;
	}
	else if(price=="") {
		showErrMsg("价格不能为空！","mf:price");
		return false;
	}
	else if(!doublePat.test(price)) {
		showErrMsg("价格只能为数字！","mf:price");
		return false;
	}
	else if(firstTel=="") {
		showErrMsg("租赁方电话不能为空！","mf:firstTel");
		return false;
	}
	else if(!telPat.test(firstTel)) {
		showErrMsg("租赁方电话格式不对！","mf:firstTel");
		return false;
	}
	else if(secondTel=="") {
		showErrMsg("承租方电话不能为空！","mf:secondTel");
		return false;
	}
	else if(!telPat.test(secondTel)) {
		showErrMsg("承租方电话格式不对！","mf:secondTel");
		return false;
	}
	else if(address=="") {
		showErrMsg("地址不能为空！","mf:address");
		return false;
	}
	else {
		return true;
	}
}

function checkSaleContract() {
	var first = document.getElementById("mf:first").value.trim();
	var second = document.getElementById("mf:second").value.trim();
	var firstcardid = document.getElementById("mf:firstcardid").value.trim();
	var secondcardid = document.getElementById("mf:secondcardid").value.trim();
	var location = document.getElementById("mf:location").value.trim();
	var houseprice = document.getElementById("mf:houseprice").value.trim();
	var housearea = document.getElementById("mf:housearea").value.trim();
	var firsttel = document.getElementById("mf:firsttel").value.trim();
	var secondtel = document.getElementById("mf:secondtel").value.trim();
	var cardPat = /^\d{18}$/;
	var doublePat = /^\d+(.\d+)?$/;
	var telPat = /^(\d{4}-)?\d+$/;
	if(first=="") {
		showErrMsg("出售方不能为空！","mf:first");
		return false;
	}
	else if(second=="") {
		showErrMsg("求购方不能为空！","mf:second");
		return false;
	}
	else if(firstcardid=="") {
		showErrMsg("出售方身份证号不能为空！","mf:firstcardid");
		return false;
	}
	else if(!cardPat.test(firstcardid)) {
		showErrMsg("出售方身份证格式错误！","mf:firstcardid");
		return false;
	}
	else if(secondcardid=="") {
		showErrMsg("求购方身份证号不能为空！","mf:secondcardid");
		return false;
	}
	else if(!cardPat.test(secondcardid)) {
		showErrMsg("求购方身份证格式错误！","mf:secondcardid");
		return false;
	}
	else if(location=="") {
		showErrMsg("房源位置不能为空！","mf:location");
		return false;
	}
	else if(housearea=="") {
		showErrMsg("房屋面积不能为空！","mf:housearea");
		return false;
	}
	else if(!doublePat.test(housearea)) {
		showErrMsg("房屋面积只能为数字！","mf:housearea");
		return false;
	}
	else if(houseprice=="") {
		showErrMsg("房屋价格不能为空！","mf:houseprice");
		return false;
	}
	else if(!doublePat.test(houseprice)) {
		showErrMsg("房屋价格只能为数字！","mf:houseprice");
		return false;
	}
	else if(firsttel=="") {
		showErrMsg("出售方电话不能为空！","mf:firsttel");
		return false;
	}
	else if(!telPat.test(firsttel)) {
		showErrMsg("出售方电话格式不对！","mf:firsttel");
		return false;
	}
	else if(secondtel=="") {
		showErrMsg("求购方电话不能不空！","mf:secondtel");
		return false;
	}
	else if(!telPat.test(secondtel)) {
		showErrMsg("求购方电话格式不对！","mf:secondtel");
		return false;
	}
	else {
		return true;
	}
}
