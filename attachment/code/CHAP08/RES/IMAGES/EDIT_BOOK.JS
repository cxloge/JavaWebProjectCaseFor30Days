function checkEditBook(){
	var bNO = document.editBook.newNO.value;
	var bName = document.editBook.bName.value;
	var author = document.editBook.author.value;
	var publish = document.editBook.publish.value;
	var isbn = document.editBook.isbn.value;
	var price = document.editBook.price.value;
	if(bNO.trim()==""){
		alert("图书编号不得为空！！！");
		return;
	}
	var reg = /^\d*$/;
	if(!reg.test(bNO)){
		alert("图书编号格式不正确！！！");
		return;
	}
	if(bName.trim()==""){
		alert("图书名称不能为空！！！");
		return;
	}
	if(author.trim()==""){
		alert("作者不能为空！！！");
		return;
	}
	if(publish.trim()==""){
		alert("出版社不能为空！！！");
		return;
	}
	if(isbn.trim()==""){
		alert("ISBN号不能为空！！！");
		return;
	}
	if(!reg.test(isbn)){
		alert("ISBN号格式不正确！！！");
		return;
	}
	if(price.trim()==""){
		alert("图书价格不能为空！！！");
		return;
	}
	var rex = /^\d{1,3}(\.\d{1,2})?$/;
	if(!rex.test(price)){
		alert("价格格式不对！！！");
		return;
	}
	document.editBook.submit();
}