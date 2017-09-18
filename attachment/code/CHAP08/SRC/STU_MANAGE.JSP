<%@ page contentType="text/html;charset=gbk"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript" src="images/add_stu.js"></script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="stum_left_menu.jsp" %>
		</div>		
		<div id="info_table"><br>			
			<div id="stuInfo"><br><br><font size="3">添加学生<br><br>
				<form name="addStu" action="ManageServlet" method="post">
					<table border="0" align="center">
						<tr>
							<td align="right">学号：</td>
							<td><input type="text" name="stuNO"></td>
						</tr>
						<tr>
							<td align="right">姓名：</td>
							<td><input type="text" name="stuName"></td>
						</tr>
						<tr>
							<td align="right">年龄：</td>
							<td><input type="text" name="age"></td>							
						</tr>
						<tr>
							<td align="right">性别：</td>
							<td>
								<input type="radio" name="gender" value="男" checked="true">男
								<input type="radio" name="gender" value="女">女
							</td>
						</tr>
						<tr>
							<td align="right">班级：</td>
							<td><input type="text" name="stuClass"></td>
						</tr>
						<tr>
							<td align="right">系别：</td>
							<td><input type="text" name="dep"></td>
						</tr>
						<tr>
							<td><input type="hidden" name="action" value="add_stu"></td>
							<td>
								<!-- <input type="button" value="添加" onclick="checkAddStu()"> -->
								<img src="images/tja.gif" id="tj" onclick="checkAddStu()" 
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
				<li>输入学生信息请认真填写</li><br><br>
				<li>学号和年龄应为数字组成，不得包含其他字符</li><br><br>
				<li>添加学生后，学生的借书权限默认为可以借书</li><br><br>
				<li>添加学生时，学生的登录密码默认为学生学号</li><br><br>				
			</div>
		</div>
	</body>
</html>