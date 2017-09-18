function check(){
	var uname = document.mf_login.uname.value.trim();
	var upwd = document.mf_login.upwd.value.trim();
	if(uname==""){
		showErrMsg("用户名不能为空！","uname");
		return;
	}
	if(upwd==""){
		showErrMsg("密码不能为空！","upwd");
		return;
	}
	document.mf_login.submit();
}

function zzcx(){
	var start = document.mf_zzcx.start.value.trim();
	var end = document.mf_zzcx.end.value.trim();
	if(start==""){
		showErrMsg("出发城市不能为空！","start");
		return;
	}
	if(end==""){
		showErrMsg("目的城市不能为空！","end");
		return;
	}
	if(start==end){
		showErrMsg("出发城市和终点城市不能相同！","start");
		return;
	}
	document.mf_zzcx.submit();
}

function czcx(){
	var station = document.mf_czcx.station.value.trim();
	if(station==""){
		showErrMsg("所查车站名称不能为空！","station");
		return;
	}
	document.mf_czcx.submit();
}

function train_search(){
	var train = document.mf_cccx.train.value.trim();
	if(train==""){
		showErrMsg("所查车次不能为空！","train");
		return;
	}
	document.mf_cccx.submit();
}
