function checkInfo(){
	var start = document.mf_book.tstart.value.trim();
	var end = document.mf_book.tend.value.trim();
	//var pattern = /^\d{4}-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2]\d)|(3[0-1]))$/;
	if(start==""){
		showErrMsg("出发城市不能为空！","tstart");
		return;
	}
	if(end==""){
		showErrMsg("目的城市不能为空！","tend");
		return;
	}
	if(start==end){
		showErrMsg("出发城市和终点城市不能相同！","tstart");
		return;
	}
	document.mf_book.submit();
	
}

function checkMsg(){
	var tname = document.mf_train.tname.value.trim();
	if(tname==""){
		showErrMsg("车次各称不能为空！","tname");
		return;
	}
	document.mf_train.submit();
}

function check(){
	var linkman = document.all.linkman.value.trim();
	var tamount = document.all.tamount.value.trim();
	var tdate = document.all.tdate.value.trim();
	var address = document.all.address.value.trim();
	var tel = document.all.tel.value.trim();
	var pattern = /^[1-9]\d*$/;
	var pattern1 = /^\d{4}-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2]\d)|(3[0-1]))$/;
	if(linkman==""){
		showErrMsg("联系人不能为空！","linkman");
		return;
	}
	if(tamount==""){
		showErrMsg("车票数量不能为空！","tamount");
		return;
	}
	if(!pattern.test(tamount)){
		showErrMsg("数量只能为数字，且不能为0！","tamount");
		return;
	}
	if(tdate==""){
		showErrMsg("车票日期不能为空！","tdate");
		return;
	}
	if(!pattern1.test(tdate)){
		showErrMsg("车票日期格式不对<YYYY-MM-DD>","tdate");
		return;
	}
	if(address==""){
		showErrMsg("联系人地址不能为空！","address");
		return;
	}
	if(tel==""){
		showErrMsg("联系电话不能为空！","tel");
		return;
	}
	document.mf_msg.submit();
}

function modify(){
	var linkman = document.all.linkman.value.trim();
	var tamount = document.all.tamount.value.trim();
	var tdate = document.all.tdate.value.trim();
	var address = document.all.address.value.trim();
	var tel = document.all.tel.value.trim();
	var pattern = /^[1-9]\d*$/;
	var pattern1 = /^\d{4}-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2]\d)|(3[0-1]))$/;
	if(linkman==""){
		showErrMsg("联系人不能为空！","linkman");
		return;
	}
	if(tamount==""){
		showErrMsg("车票数量不能为空！","tamount");
		return;
	}
	if(!pattern.test(tamount)){
		showErrMsg("数量只能为数字，且不能为0！","tamount");
		return;
	}
	if(tdate==""){
		showErrMsg("车票日期不能为空！","tdate");
		return;
	}
	if(!pattern1.test(tdate)){
		showErrMsg("车票日期格式不对<YYYY-MM-DD>","tdate");
		return;
	}
	if(address==""){
		showErrMsg("联系人地址不能为空！","address");
		return;
	}
	if(tel==""){
		showErrMsg("联系电话不能为空！","tel");
		return;
	}
	document.mf_mod.submit();

}

