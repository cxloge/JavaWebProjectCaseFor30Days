<%@ page contentType="text/html;charset=gbk" 
	import="wyf.zrk.TicketItem"
%>

<% 
	TicketItem ti = (TicketItem)session.getAttribute("ti");
	if(ti==null){
		response.sendRedirect("index.jsp");
	}
	else{
 %>
<html>
	<head>
		<title>信息核对</title>		
 		<link href="css/book.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>车票预订</b>
			</p>
			<table border="0" cellspacing="1" bgcolor="#F7B770" width="80%" height="50px">
				<tr bgcolor="#FDF1E4">
					<td align="center">
						<img src="images/warning.gif" border="0" />
						<font size="2">请核对您的各项信息，以确保您能及时地、准确地预订到您所需车次的车票。</font>
					</td>
				</tr>
			</table><br/><br/>
			<table border="0" bgcolor="black" width="80%" cellspacing="1">
				<tr bgcolor="#EDF2F7" align="center">
					<th>车次：</th>
					<td><%= ti.getTname() %></td>
					<th>车票数量：</th>
					<td><%= ti.getTamount() %></td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<th>出发站：</th>
					<td><%= ti.getTstart() %></td>
					<th>目的站：</th>
					<td><%= ti.getTend() %></td>
				</tr>
				<tr bgcolor="#EDF2F7" align="center">
					<th>车票日期：</th>
					<td><%= ti.getTdate() %></td>
					<th>联系人：</th>
					<td><%= ti.getLinkman() %></td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<th>联系人地址：</th>
					<td><%= ti.getAddress() %></td>
					<th>联系电话：</th>
					<td><%= ti.getTel() %></td>
				</tr>
			</table>
			<p align="center">
			<form>
				<input type="button" class="btn" onclick="window.location.href='<%= request.getContextPath() %>/ManageServlet?action=look'" value="&nbsp;修改&nbsp;"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="btn" onclick="window.location.href='<%= request.getContextPath() %>/ManageServlet?action=subOrder'" value="&nbsp;确认&nbsp;"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="btn" onclick="window.location.href='<%= request.getContextPath() %>/ManageServlet?action=delete'" value="&nbsp;取消&nbsp;"/>&nbsp;&nbsp;&nbsp;&nbsp;
			</form>
			</p>
		</div>
		</div>
	</body>
</html> 
 <% 
 	}
  %>