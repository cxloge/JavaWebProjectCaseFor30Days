<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*" %>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript" src="images/edit_book.js"></script>		
	</head>
	<body>
	<% 
		Vector<Vector<String>> vtemp = 
				(Vector<Vector<String>>)request.getAttribute("v");
		Vector<String> v = vtemp.get(0);	//得到图书信息
	 %>
		<div id="Menu">
			<%@ include file="book_left_menu.jsp" %>
		</div>
		<div id="info_table">
			<div id="stuInfo"><br><br><font size="3">修改图书信息<br><br>
				<form name="editBook" action="ManageServlet" method="post">
					<table border="0" align="center">
						<tr>
							<td align="right">图书编号：</td>
							<td><input type="text" name="newNO" value="<%=v.get(0)%>"></td>
						</tr>
						<tr>
							<td align="right">图书名称：</td>
							<td><input type="text" name="bName" value="<%=v.get(1)%>"></td>
						</tr>
						<tr>
							<td align="right">作者：</td>
							<td><input type="text" name="author" value="<%=v.get(2)%>"></td>							
						</tr>
						<tr>
							<td align="right">出版社：</td>
							<td><input type="text" name="publish" value="<%=v.get(3)%>"></td>
						</tr>
						<tr>
							<td align="right">ISBN号：</td>
							<td><input type="text" name="isbn" value="<%=v.get(4)%>"></td>
						</tr>
						<tr>
							<td align="right">价格：</td>
							<td><input type="text" name="price" value="<%=v.get(6)%>"></td>
						</tr>
						<tr>
							<td><input type="hidden" name="action" value="save_book">
							<input type="hidden" name="bNO" value="<%=v.get(0)%>"></td>
							<td>
								<!--<input type="button" value="保存" onclick="checkEditBook()">  -->
								<img src="images/bca.gif" id="bc" onclick="checkEditBook()" 
									onmouseover="document.all.bc.src='images/bcb.gif'"
								 	onmouseout="document.all.bc.src='images/bca.gif'"
								  	onmousedown="document.all.bc.src='images/bcc.gif'"
								   	style="cursor:hand"/>&nbsp;&nbsp;&nbsp;&nbsp;
								<!-- <input type="reset" value="重置"> -->
								<img src="images/cza.gif" id="cz" onclick="reset()" 
									onmouseover="document.all.cz.src='images/czb.gif'"
								 	onmouseout="document.all.cz.src='images/cza.gif'"
								  	onmousedown="document.all.cz.src='images/czc.gif'"
								   	onmouseup="document.all.cz.src='images/czb.gif'"
								  	style="cursor:hand" >	
							</td>
						</tr>
						<tr>
						<% 
							String message = (String)request.getAttribute("message");
							if(message!=null){
						%><br>
							<td colspan="2"><center><font color="red" size="2.5">
								<%= message %></center></td>
						<%
							}
						%>
						</tr>						
					</table>
				</form>
			</div>
			<div id="message">提示：<br><br>
				<li>输入图书信息请认真填写</li><br><br>
				<li>图书编号和ISBN号应为数字组成，不得包含其他字符</li><br><br>
				<li>添加图书后，图书的购进时间默认为当前日期，状态为在馆</li><br><br>					
			</div>
		</div>
	</body>
</html>