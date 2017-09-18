function checkEditStu(){
	var newNO = document.editStu.newNO.value;
	var stuName = document.editStu.stuName.value;
	var age = document.editStu.age.value;
	var stuCalss = document.editStu.stuClass.value;
	var dep = document.editStu.dep.value;
	if(newNO.trim()==""){
		alert("学号不能为空！！！");
		return;
	}
	var rex = /^\d*$/;
	if(!rex.test(newNO)){
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
		alert("班级不能为空！！！");
		return;
	}
	if(dep.trim()==""){
		alert("系别不能为空！！！");
		return;
	}
	document.editStu.submit();	
}