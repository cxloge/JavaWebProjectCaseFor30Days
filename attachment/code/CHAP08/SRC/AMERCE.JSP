<%@ page contentType="text/html;charset=gbk"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript">
			function checkAmer(){
				var stuNO = document.amerce.stuNO.value;
				var reg = /^\d*$/;
				if(stuNO.trim()==""){
					alert("学生学号不得为空！！！");
					return;
				}
				if(!reg.test(stuNO)){
					alert("学号格式不对");
					return;
				}				
				document.amerce.submit();
			}
		</script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="borrow_left_menu.jsp" %>
		</div>		
		<div id="info_table">
			<center><br><br><font size="4">罚款缴纳</center>
			<form name="amerce" action="ManageServlet" method="post">
				<input type="hidden" name="action" value="get_amer_list">
				<table align="center">
					<tr>
						<td align="right">请输入学生学号：</td>
						<td><input type="text" name="stuNO"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right">
						<!-- <input type="button" value="查询" onclick="checkAmer()"> -->	
						<img src="images/tjaa.gif" id="tja" onclick="checkAmer()" 
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