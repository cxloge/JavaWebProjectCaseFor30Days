<%@ page contentType="text/html;charset=gbk"
	import="java.util.*"
 %>
 
<html>
	<head>
		<title>出发站及目的站选择</title>
		<link href="css/book.css" type="text/css" rel="stylesheet"/>
		<link href="css/tablestyle.css" type="text/css" rel="stylesheet" />
	</head>
	<% 
		List<String[]> ls = (List<String[]>)session.getAttribute("stationlist");
		if(ls==null||ls.size()==0){
			response.sendRedirect("index.jsp");
		}
		else{
	 %>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>车票预订</b>
			</p>
			<br/>
			<form action="ManageServlet" method="post">
			<table class="default" align="center" border="0" cellspacing="1" width="60%">
				<caption><font size="4"><b>请在下面选择你的出发站及目的站：</b></font></br></caption>
				<thead>
				<tr bgcolor="#F9F3E6">
					<th>出发站</th>
					<th>目的站</th>
				</tr>
				</thead>
				<tbody>
			<% 
				for(int i=0;i<ls.size();i++){
					String[] str = ls.get(i);
			%>
				<tr>
			<% 
				if(i==0){
			 %>
					<td><input type="radio" name="tstart" checked="true" value="<%= str[0] %>"/><span style="width:80px"><%= str[0] %></span></td>
					<td><input type="radio" name="tend" checked="true" value="<%= str[0] %>"/><span style="width:80px"><%= str[0] %></span></td>
			<% 
				}
				else{
				
			 %>
			 		<td><input type="radio" name="tstart" value="<%= str[0] %>"/><span style="width:80px"><%= str[0] %></span></td>
					<td><input type="radio" name="tend" value="<%= str[0] %>"/><span style="width:80px"><%= str[0] %></span></td>
			 <% 
			 	}
			  %>
				</tr>
			<%
				}
			 %>
			</tbody>
			</table>
				<input type="hidden" name="action" value="saveStation"/>
				<center><br/><input class="btn" type="submit" value="下一步"/><center>
				<br/><br/><br/>
			</form>
		</div>
		</div>
	</body>
	<% 
		}
	 %>
</html>