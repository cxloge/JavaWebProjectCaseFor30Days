<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*;"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript" src="images/stuChangePwd.js"></script>
	</head>
	<body>
		<% Vector<String> stu = (Vector<String>)request.getAttribute("student"); %>
		<div id="father">
			<div id="stuInfo">
				<%= stu.get(1) %>，您好，您的个人信息如下：
				<ul>
				<table><!-- 显示学生信息表格 -->
					<tr>
						<td align="right">学号：</td>
						<td align="left"><%= stu.get(0) %></td>
					</tr>
					<tr>
						<td align="right">姓名：</td>
						<td align="left"><%= stu.get(1) %></td>
					</tr>
					<tr>
						<td align="right">年龄：</td>
						<td align="left"><%= stu.get(2) %></td>
					</tr>
					<tr>
						<td align="right">性别：</td>
						<td align="left"><%= stu.get(3) %></td>
					</tr>
					<tr>
						<td align="right">班级：</td>
						<td align="left"><%= stu.get(4) %></td>
					</tr>
					<tr>
						<td align="right">学院：</td>
						<td align="left"><%= stu.get(5) %></td>
					</tr>
					<tr>
						<td align="right">权限：</td>
						<td align="left">
						<%	
							if(stu.get(6).equals("1")){
						%>
							 <font color="red" size="3">可以借书</font>
						<%
							}
							else{
						%>
							 <font color="red" size="3">不可借书</font>
						<%
							}
						%>
						</td>
					</tr>
				</table></ul>
				<table><!-- 修改密码表单 -->
					<form name="stuChangePwd" action="StudentServlet" method="post">
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
								<!-- <input type="button" value="修改" onclick="checkStuChangePwd()"/> -->
								<img src="images/xga.gif" id="xg" onclick="checkStuChangePwd()" 
									onmouseover="document.all.xg.src='images/xgb.gif'"
								 	onmouseout="document.all.xg.src='images/xga.gif'"
								  	onmousedown="document.all.xg.src='images/xgc.gif'"
								   	style="cursor:hand"/>&nbsp;&nbsp;
								<input type="hidden" name="action" value="stuChangePwd"/>
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
								<font color="red" size="2"><%= message %></font>
							</td>
						</tr>
						<%
							}
						%>					
					</form>
				</table>
			</div>
			<div id="message">
			  在这里您可以查看自己的基本资料，并可以修改密码，密码格式应满足以下要求：
	 		  <ul>
		 		  <li>密码位数不能小于6位</li>
		 		  <li>密码只能是字母和数字组合</li>
		 		  <li>最好不要使用您的生日、电话号码等作为密码</li>		      
	 		  </ul>
	 		  温馨提示：请保存好您的密码，如果忘记密码请持学生证去管理处查询。
			</div>
		</div>
	</body>
</html>