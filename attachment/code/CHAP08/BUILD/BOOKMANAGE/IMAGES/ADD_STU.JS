function checkAddStu(){
	var stuNO = document.addStu.stuNO.value;
	var stuName = document.addStu.stuName.value;
	var age = document.addStu.age.value;
	var stuCalss = document.addStu.stuClass.value;
	var dep = document.addStu.dep.value;
	if(stuNO.trim()==""){
		alert("学号不能为空！！！");
		return;
	}
	var rex = /^\d*$/;
	if(!rex.test(stuNO)){
		alert("学号只能由数字组成！！！");
		return;
	}
	if(stuName.trim()==""){
		alert("姓名不能为空！！！");
		return;
	}	
	if(age.trim()==""){
		alert("年龄不能为空！！！");
		return;
	}
	var reg = /^\d{1,2}$/;
	if(!reg.test(age)){
		alert("年龄格式不对！！！");
		return;
	}
	if(stuCalss.trim()==""){
		alert("系别不能为空！！！");
		return;
	}	
	if(dep.trim()==""){
		alert("系别不能为空！！！");
		return;
	}
	document.addStu.submit();	
}