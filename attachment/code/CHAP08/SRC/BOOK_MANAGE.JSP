<%@ page contentType="text/html;charset=gbk"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript" src="images/add_book.js"></script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="book_left_menu.jsp" %>
		</div>		
		<div id="info_table"><br>			
			<div id="stuInfo"><br><br><font size="3">添加图书<br><br>
				<form name="addBook" action="ManageServlet" method="post">
					<table border="0" align="center">
						<tr>
							<td align="right">图书编号</td>
							<td><input type="text" name="bNO"></td>
						</tr>
						<tr>
							<td align="right">图书名称</td>
							<td><input type="text" name="bName"></td>
						</tr>
						<tr>
							<td align="right">作者：</td>
							<td><input type="text" name="author"></td>							
						</tr>
						<tr>
							<td align="right">出版社</td>
							<td><input type="text" name="publish"></td>
						</tr>
						<tr>
							<td align="right">ISBN号</td>
							<td><input type="text" name="isbn"></td>
						</tr>
						<tr>
							<td align="right">价格</td>
							<td><input type="text" name="price"></td>
						</tr>
						<tr>
							<td><input type="hidden" name="action" value="add_book"></td>
							<td>
								<!-- <input type="button" value="添加" onclick="checkAddBook()"> -->
								<img src="images/tja.gif" id="tj" onclick="checkAddBook()" 
									onmouseover="document.all.tj.src='images/tjb.gif'"
								 	onmouseout="document.all.tj.src='images/tja.gif'"
								  	onmousedown="document.all.tj.src='images/tjc.gif'"
								   	style="cursor:hand"/>&nbsp;&nbsp;&nbsp;&nbsp;
								<!-- <input type="reset" value="重置"> -->
								<img src="images/qka.gif" id="qk" onclick="reset()" 
									onmouseover="document.all.qk.src='images/qkb.gif'"
								 	onmouseout="document.all.qk.src='images/qka.gif'"
								  	onmousedown="document.all.qk.src='images/qkc.gif'"
								   	onmouseup="document.all.qk.src='images/qkb.gif'"
								  	style="cursor:hand" >
							</td>
						</tr>
					</table>
				</form>
			<% 
				String message = (String)request.getAttribute("message");
				if(message!=null){
			%>
				<center><font color="red" size="3"><%= message %></font></center>
			<%
				}
			 %>
			</div>
			<div id="message">提示：<br><br>
				<li>输入图书信息请认真填写</li><br><br>
				<li>图书编号和ISBN号应为数字组成，不得包含其他字符</li><br><br>
				<li>添加图书后，图书的购进时间默认为当前日期，状态为在馆</li><br><br>				
			</div>
		</div>
	</body>
</html>