<%@ page contentType="text/html;charset=gbk"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript">
			function checkReturn(){
				var bNO = document.rebook.bNO.value;
				var reg = /^\d*$/;
				if(bNO.trim()==""){
					alert("图书编号不得为空！！！");
					return;
				}
				if(!reg.test(bNO)){
					alert("图书编号号格式不对");
					return;
				}				
				document.rebook.submit();
			}
		</script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="borrow_left_menu.jsp" %>
		</div>		
		<div id="info_table">
			<center><br><br><font size="4">图书归还</center>
			<form name="rebook" action="ManageServlet" method="post">
				<input type="hidden" name="action" value="return_book">
				<table align="center">
					<tr>
						<td align="right">请输入图书编号：</td>
						<td><input type="text" name="bNO"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right">
						<!-- <input type="button" value="提交" onclick="checkReturn()"> -->	
						<img src="images/tjaa.gif" id="tja" onclick="checkReturn()" 
							onmouseover="document.all.tja.src='images/tjbb.gif'"
						 	onmouseout="document.all.tja.src='images/tjaa.gif'"
						  	onmousedown="document.all.tja.src='images/tjcc.gif'"
						   	style="cursor:hand"/>
						</td>
					</tr>
					<% 
						String message = (String)request.getAttribute("message");
						if(message!=null){
					%>
					<tr>
						<td colspan="2"><center><font color="red" size="3">
							<%= message %></center>
						</font></td>
					</tr>
					<%
						}
					 %>
				</table>
			</form>
		</div>
	</body>
</html>