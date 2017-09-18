<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript" src="images/adChangePwd.js"></script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="adm_left_menu.jsp" %>
		</div>
		<div id="info_table">
			<div id="ad_manage"><font size="4"><center>修改密码
			<form name="adChangePwd" action="ManageServlet" method="post">
			<table>
				<tr>
					<td align="right">请输入旧密码：</td>
					<td align="left">
						<input name="oldPwd" type="password" size="20">
					</td>
				</tr>
				<tr>
					<td align="right">请输入新密码：</td>
					<td align="left">
						<input name="newPwd" type="password" size="20">
					</td>
				</tr>
				<tr>
					<td align="right">再次输入新密码：</td>
					<td align="left">
						<input name="newPwdAgain" type="password" size="20">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<!--<input type="button" value="修改" onclick="checkAdChangePwd()"/>  -->
						<img src="images/xga.gif" id="xg" onclick="checkAdChangePwd()" 
								onmouseover="document.all.xg.src='images/xgb.gif'"
							 	onmouseout="document.all.xg.src='images/xga.gif'"
							  	onmousedown="document.all.xg.src='images/xgc.gif'"
							   	style="cursor:hand"/>&nbsp;&nbsp;
						<input type="hidden" name="action" value="adChangePwd"/>						
						<!-- <input type="reset" value="清空"/> -->
						<img src="images/qka.gif" id="qk" onclick="reset()" 
								onmouseover="document.all.qk.src='images/qkb.gif'"
							 	onmouseout="document.all.qk.src='images/qka.gif'"
							  	onmousedown="document.all.qk.src='images/qkc.gif'"
							   	onmouseup="document.all.qk.src='images/qkb.gif'"
							  	style="cursor:hand" >
					</td>
				</tr>
				<%
					String message = (String)request.getAttribute("message");
					if(message!=null){
				%>
				<tr>
					<td colspan="10">
						<font color="red" size="2">
							<center><%= message %></center></font>
					</td>
				</tr>
				<%
					}
				%>		
			</table>
			</form>
			</div>
		</div>
	</body>
</html>