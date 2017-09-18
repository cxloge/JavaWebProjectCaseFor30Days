function checkPage(temp){
	var page = document.all.page.value.trim();
	var reg = /^[1-9][0-9]*$/;
	if((reg.test(page.trim()))&&(page<=temp)){
		document.all.myform.submit();
	}
	else{
		alert("输入不合法,请重新输入!!!");
		return;
	}
}