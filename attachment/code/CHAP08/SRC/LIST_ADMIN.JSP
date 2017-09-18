<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript">
			function confirmDel(){
			 return confirm("确定删除？？？");
			}
		</script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="adm_left_menu.jsp" %>
		</div>
		<div id="info_table">
		<%
		   	Vector<Vector<String>> v = (Vector<Vector<String>>)request.getAttribute("v");
		   	String url = "list_admin.jsp";			//换页使用
		   	if(v!=null&&v.size()!=0){
		%>
		<br/><br/><center><font size="4">管理员列表<br/><br/>
		<table border="0" bgcolor="black" width="90%" cellspacing="1" align="center">
			<th bgcolor="#D1D1E6">管理员名</th>
			<th bgcolor="#D1D1E6">管理员级别</th>
			<th bgcolor="#D1D1E6">删除</th>
			
		<%
				for(int i=0;i<v.size();i++){
					Vector<String> vtemp = v.get(i);
		%>
				<tr bgcolor=<%= i%2==0?"#F0F7FF":"#FFF8F0" %>>
					<td align="center"><%= vtemp.get(0) %></td>					
					<%
						if(vtemp.get(1).equals("1")){
					%>
						<td align="center">超级管理员</td>
						<td align="center">－－</td>
					<%
						}
						else{
					%>
						<td align="center">普通管理员</td>
						<td align="center">
							<a href="ManageServlet?action=delAdmin&mID=
							<%= vtemp.get(0) %>" onclick="return confirmDel()">
							<img src="images/del.gif" border="0" width="15" height="15"/>删除</a>
						</td>
			<%
					}
				}
			}
			%>

		</table>
		<%@ include file="navgation.jsp" %>
		</div>
	</body>
</html>