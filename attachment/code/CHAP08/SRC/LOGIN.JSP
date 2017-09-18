<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*" %>
<html>
 <head>
 	<link href="images/div.css" type="text/css" rel=stylesheet>
	<link href="images/globalstyle.css" type="text/css" rel=stylesheet>
	<script language="JavaScript" src="images/trim.js"></script>
	<script language="JavaScript" src="images/stuLogin.js"></script>
 </head>
 <body>
 	<div id="father">
 		<div id="loginform">
 			<%
 			 String stuName= (String)session.getAttribute("stuName"); //得到当前登陆的学生学号
             if(stuName==null){
          	%>
            登陆我的图书馆
			<form name="login" action="StudentServlet" method="post">
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
						<td>
						<input type="hidden" name="action" value="login">
						<!-- <input type="button" value="登陆" onclick="checkUser()"/> -->
						<img src="images/dla.gif" id="dl" onclick="checkUser()" 
							onmouseover="document.all.dl.src='images/dlb.gif'"
						 	onmouseout="document.all.dl.src='images/dla.gif'"
						  	onmousedown="document.all.dl.src='images/dlc.gif'"
						  	style="cursor:hand" >&nbsp;&nbsp;&nbsp;&nbsp;					
						<!--	<input type="reset" value="重置"/></td>  -->
						<img src="images/cza.gif" id="cz" onclick="reset()" 
							onmouseover="document.all.cz.src='images/czb.gif'"
						 	onmouseout="document.all.cz.src='images/cza.gif'"
						  	onmousedown="document.all.cz.src='images/czc.gif'"
						   	onmouseup="document.all.cz.src='images/czb.gif'"
						  	style="cursor:hand" >
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
             	out.println(stuName+"，您好！<br/><br/>欢迎来到图书馆!!!");
             	out.println("<br/><br/><a href='StudentServlet?action=stuInfo' target='bottomFrame'>【查看/修改个人信息】</a>");
             	out.println("<a href='StudentServlet?action=logout'>【注销】</a>");             	
             }
 			%>
 		</div>
 		<div id="message">
 		 提示：
 		  <ul>
	 		  <li>读者登陆用户名为学生证号</li>
	 		  <li>新生的初始密码有以下两种情况：
	 		  	<ol>
		 		  	<li>您的学生证号</li>
		 		  	<li>借书证上的条形号</li>
		 		</ol>
	 		  </li>
	 		  <li>登陆进入系统可修改密码</li>
	 		  <li>保存好密码，如果忘记密码请持学生证到管理处取回</li>
 		  </ul>
 		</div>
 	</div>
 </body>
</html>