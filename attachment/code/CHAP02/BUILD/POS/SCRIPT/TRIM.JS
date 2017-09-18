//为String类注射Trim方法
String.prototype.trim = function()
{
return this.replace(/(^\s*)|(\s*$)/g, "");
}
function delete_sure(url){
	if(confirm("确认要删除吗?")){
		document.location.href=url;
	}
}