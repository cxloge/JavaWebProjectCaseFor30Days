function checkPublishMsg(){
	var mname = document.mf_publish.mname.value.trim();
	var mamount = document.mf_publish.mamount.value.trim();
	var mtickettime = document.mf_publish.mtickettime.value.trim();			//#日期
	var mstart = document.mf_publish.mstart.value.trim();					//#出发城市
	var mend = document.mf_publish.mend.value.trim();						//目的城市
	var mticketprice = document.mf_publish.mticketprice.value.trim();		//车票价格
	var mlinkman = document.mf_publish.mlinkman.value.trim();				//联系人
	var mtel = document.mf_publish.mtel.value.trim();						//联系电话
	var mmsg = document.mf_publish.mmsg.value.trim();						//发布信息
	var identify = document.mf_publish.identify.value.trim();				//验证码
	var pattern = /^\d{4}-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2]\d)|(3[0-1]))$/;
	var pattern1 = /^\d+(\.\d+)?$/;
	var pattern2 = /^\d+(-\d+)?$/;
	var pattern3 = /^0|([1-9]\d*)$/;
	var pattern4 = /^[0-9a-zA-Z]{4}$/;
	if(mname==""){
		showErrMsg("车次不能为空！","mname");
		return;
	}
	else if(mtickettime==""){
		showErrMsg("车票日期不能为空！","mtickettime");
		return;
	}
	else if(!pattern.test(mtickettime)){
		showErrMsg("日期格式不正确！","mtickettime");
		return;		
	}
	else if(mamount==""){
		showErrMsg("数量不能为空！","mamount");
		return;
	}
	else if(!pattern3.test(mamount)){
		showErrMsg("数量格式不对！","mamount")
		return;
	}
	else if(mstart==""){
		showErrMsg("出发城市不能为空！","mstart");
		return;
	}
	else if(mend==""){
		showErrMsg("目的城市不能为空！","mend");
		return;
	}
	else if(mticketprice!=""&&!pattern1.test(mticketprice)){
		showErrMsg("车票价格错误，只能为数字。","mticketprice");
		return;
	}
	else if(mlinkman==""){
		showErrMsg("联系人不能为空！","mlinkman");
		return;
	}
	else if(mtel==""){
		showErrMsg("联系电话不能为空！","mtel");
		return;
	}
	else if(!pattern2.test(mtel)){
		showErrMsg("联系电话格式不对！","mtel");
		return;
	}
	else if(identify==""){
		showErrMsg("验证码为空，请重新输入！","identify");
		return;
	}
	else if(!pattern4.test(identify)){
		showErrMsg("验证码错误！","identify");
		return;
	}
	document.mf_publish.submit();	
}