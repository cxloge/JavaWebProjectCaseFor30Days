function checkOrder(){
	var start = document.getElementById('orderForm:start').value;
	var end = document.getElementById('orderForm:end').value;
	var reg = /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29))$/ 
if(!reg.test(start)){
	alert("开始时间格式不正确");
	return false;
}
if(!reg.test(end)){
	alert("结束时间格式不正确");
	return false;
}
	return true;
}