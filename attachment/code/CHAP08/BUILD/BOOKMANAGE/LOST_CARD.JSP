<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<script language="JavaScript" src="images/trim.js"></script>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<link href="images/globalstyle.css" type="text/css" rel=stylesheet>
		<script language="JavaScript">
			function checkPwd(){
				var pwd = document.card.pwd.value;
				if(pwd==""){
					alert("密码不能为空！！！");
					return;
				}
				if(pwd.trim()<6){
					alert("密码不能包含空格且长度不得小与6位");
					return;
				}
				document.card.submit();
			}
		</script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="stu_left_menu.jsp" %>
		</div>
		<div id="info_table">
			<center><br><br><font color="red">挂失后图书证不可使用，需要管理员才能解除挂失状态。</font>
			<br/><br/>确定要挂失吗？
			请输入密码：
			<table border="0">		
			<form name="card" action="StudentServlet" method="post">
				<tr>
					<td><input type="password" name="pwd"/></td>
					<td>
						<img src="images/qda.gif" id="qd" onclick="checkPwd()" 
							onmouseover="document.all.qd.src='images/qdb.gif'"
						 	onmouseout="document.all.qd.src='images/qda.gif'"
						  	onmousedown="document.all.qd.src='images/qdc.gif'"
						   	style="cursor:hand"/>
						<input type="hidden" name="action" value="gs">
					</td>
				</tr>		
			</form>
			</table>
			<% 
				String message = (String)request.getAttribute("message");
				String stuName = (String)session.getAttribute("stuName");
				if(message!=null){
			%>
				<%= stuName %>，借阅证<%= message %>
			<%
				}
			%>
			</center>
		</div> 
	</body>
</html>