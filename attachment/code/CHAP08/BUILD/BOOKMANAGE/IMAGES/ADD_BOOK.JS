function checkAddBook(){
	var bNO = document.addBook.bNO.value;
	var bName = document.addBook.bName.value;
	var author = document.addBook.author.value;
	var publish = document.addBook.publish.value;
	var isbn = document.addBook.isbn.value;
	var price = document.addBook.price.value;
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
	document.addBook.submit();
}