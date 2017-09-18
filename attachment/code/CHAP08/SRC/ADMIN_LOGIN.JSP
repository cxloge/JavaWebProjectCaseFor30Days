<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*" %>
<html>
 <head>
 	<link href="images/div.css" type="text/css" rel=stylesheet>
 	<link href="images/globalstyle.css" type="text/css" rel=stylesheet>
	<script language="JavaScript" src="images/trim.js"></script>
	<script language="JavaScript" src="images/adminLogin.js"></script>
 </head>
 <body>
 	<div id="father">
 		<div id="loginform">
 			<%
 			 String adName = (String)session.getAttribute("adName"); //得到当前登陆的学生学号
             if(adName==null){
          	%>
            登陆管理系统
			<form name="login" action="ManageServlet" method="post">
				<table>
					<tr>
						<td align="right">用户名：</td>
						<td align="left"><input type="text" name="uname"/><br></td>
					</tr>
					<tr>
						<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
						<td align="left"><input type="password" name="pwd"><br></td>
					</tr>
					<tr>
						<td></td>						
						<td align="center">
						<input type="hidden" name="action" value="login">
						<!-- <input type="button" value="登陆" onclick="checkAdmin()"/> -->
						<img src="images/dla.gif" id="dl" onclick="checkAdmin()" 
							onmouseover="document.all.dl.src='images/dlb.gif'"
						 	onmouseout="document.all.dl.src='images/dla.gif'"
						  	onmousedown="document.all.dl.src='images/dlc.gif'"
						   	style="cursor:hand"/>&nbsp;&nbsp;&nbsp;&nbsp;						
						<!-- <input type="reset" value="重置"/> -->
						<img src="images/cza.gif" id="cz" onclick="reset()" 
							onmouseover="document.all.cz.src='images/czb.gif'"
						 	onmouseout="document.all.cz.src='images/cza.gif'"
						  	onmousedown="document.all.cz.src='images/czc.gif'"
						   	onmouseup="document.all.cz.src='images/czb.gif'"
						  	style="cursor:hand" >						
						</td>
					</tr>
					<%
						String message = (String)request.getAttribute("message");
						if(message!=null){
					%>
					<tr>
						<td colspan="2">
							<font color="red" size="2"><%= message %></font>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</form>
          	<%
             }
             else{
             	out.println(adName+"，您好！<br/><br/>欢迎进入管理端系统!!!");
             	out.println("<br/><br/><a href='ManageServlet?action=adManage' target=");
             	out.println("'bottomFrame'>【账号维护】</a>");
             	out.println("<a href='ManageServlet?action=logout'>【注销】</a>");
             }
 			%>
 		</div>
 		<div id="message">
 		 提示：
 		  <ul>
	 		  <li>管理员的用户名和密码由超级管理员设置</li><br><br>
	 		  <li>保存好密码，不要向任何人透露密码</li><br><br>
	 		  <li>登陆进入系统可修改密码</li><br><br>
	 		  <li>如果忘记密码请持有效证件到超级管理员处取回</li>
 		  </ul>
 		</div>
 	</div>
 </body>
</html>