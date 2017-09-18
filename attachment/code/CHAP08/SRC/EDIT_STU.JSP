<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*" %>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript" src="images/edit_stu.js"></script>		
	</head>
	<body>
	<% 
		Vector<String> stu = (Vector<String>)request.getAttribute("student");
	 %>
		<div id="Menu">
			<%@ include file="stum_left_menu.jsp" %>
		</div>
		<div id="info_table">
			<div id="stuInfo"><br><br><font size="3">修改学生信息<br><br>
				<form name="editStu" action="ManageServlet" method="post">
				<table border="0">
				<tr>
					<td align="right">学号：</td>
					<td>
						<input type="text" name="newNO" value="<%=stu.get(0)%>">
					</td>
				</tr>
				<tr>
					<td align="right">姓名：</td>
					<td>
						<input type="text" name="stuName" value="<%=stu.get(1)%>">
					</td>
				</tr>
				<tr>
					<td align="right">年龄：</td>
					<td>
						<input type="text" name="age" value="<%=stu.get(2)%>">
					</td>
				</tr>
				<tr>
					<td align="right">性别：</td>
					<td>
					<%
						if(stu.get(3).equals("男")){
					%>
						<input type="radio" name="gender" value="男" checked="true">男
						<input type="radio" name="gender" value="女">女
					<%
						}
						else{
					%>
						<input type="radio" name="gender" value="男">男
						<input type="radio" name="gender" value="女" checked="true">女
					<%
						}
					 %>
						
					</td>
				</tr>
				<tr>
					<td align="right">班级：</td>
					<td>
						<input type="text" name="stuClass" value="<%=stu.get(4)%>">
					</td>
				</tr>
				<tr>
					<td align="right">系别：</td>
					<td>
						<input type="text" name="dep" value="<%=stu.get(5)%>">
					</td>
				</tr>
				<tr>
					<td align="right">借书权限：</td>
					<td>
						<select name="per">
					<% 
								if(stu.get(6).equals("1")){
					%>
								<option value="1" selected>可以借书</option>
								<option value="0">不可借书</option>
					<%
								}
								else{
					%>
								<option value="1">可以借书</option>
								<option value="0" selected>不可借书</option>
					<%
								}
					%>								
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" name="action" value="save_stu">
						<input type="hidden" name="stuNO" value="<%=stu.get(0)%>">						
					</td>					
					<td>
						<!-- <input type="button" value="保存" onclick="checkEditStu()"> -->
						<img src="images/bca.gif" id="bc" onclick="checkEditStu()" 
								onmouseover="document.all.bc.src='images/bcb.gif'"
							 	onmouseout="document.all.bc.src='images/bca.gif'"
							  	onmousedown="document.all.bc.src='images/bcc.gif'"
							   	style="cursor:hand"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<!--<input type="reset" value="重置">  -->
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
				<li>修改学生信息请认真填写</li><br><br>
				<li>学号和年龄应为数字组成，不得包含其他字符</li><br><br>
				<li>学生密码可查看而不能修改</li><br><br>
				<li>如果该生违规，则可以修改学生的借书权限</li><br><br>				
			</div>
		</div>
	</body>
</html>