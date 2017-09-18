<%@ page contentType="text/html;charset=gbk"
	import="java.util.*"
 %>
<% 
	List<String> list = (List<String>)session.getAttribute("mid");
	if(list==null||list.size()==0){
		response.sendRedirect("index.jsp");
	}
	else{
 %>
<html>
	<head>
		<title>车次查询</title>
		<link href="css/reg.css" type="text/css" rel="stylesheet"/>
		<link href="css/tablestyle.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>中转站查询</b>
			</p>			
			<table border="0" cellspacing="1" bgcolor="#F7B770" width="80%" height="50px" align="center">
				<tr bgcolor="#FDF1E4">
					<td align="center">
						<img src="images/warning.gif" border="0" />
						<font size="2">
							由&nbsp;<%= session.getAttribute("start") %>&nbsp;
							到&nbsp;<%= session.getAttribute("end") %>&nbsp;没有直达的车次，
							您可以选择如下中转站来安排您的行程。
						</font>
					</td>
				</tr>
			</table><br/><br/>			
			<table class="default" cellspacing="1" border="0" align="center">
			<thead>
				<tr>
					<th>中转站</th>
					<th>出发站</th>
					<th>到达站</th>
				</tr>
			</thead>
			<tbody>
			<% 
				for(int i=0;i<list.size();i++){
			%>
				<tr>
					<td><a href="<%= request.getContextPath() %>/ManageServlet?action=midSearch&mid=<%= list.get(i) %>"><%= list.get(i) %></a></td>
					<td><%= session.getAttribute("start") %></td>
					<td><%= session.getAttribute("end") %></td>
				</tr>
			<% 
				}
			 %>
			</tbody>
			</table>
		</div>
		</div>
	</body>
</html>
<% 
	}
 %>