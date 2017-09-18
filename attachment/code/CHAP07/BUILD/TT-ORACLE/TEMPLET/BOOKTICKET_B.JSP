<%@ page contentType="text/html;charset=gbk"
	import="java.util.*"
 %>
<% 
	List<String[]> list = (List<String[]>)request.getAttribute("list");
	if(list==null||list.size()==0){
		response.sendRedirect("index.jsp");
	}
	else{
 %>
<html>
	<head>
		<title>车票预订</title>
		<link href="css/book.css" type="text/css" rel="stylesheet"/>
		<link href="css/tablestyle.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>车票预订</b>
			</p>
			<form action="ManageServlet" method="post">
			<table bgcolor="black" cellspacing="1" border="0" width="90%" align="center" class="default">
			<caption>由&nbsp;<%= session.getAttribute("start") %>&nbsp;到
				&nbsp;<%= session.getAttribute("end") %>&nbsp;的车次如下
			</caption>
			<thead>
				<tr bgcolor="#F9F3E6">
					<th>车次</th>
					<th>出发站</th>
					<th>开车时间</th>
					<th>到达站</th>
					<th>到达时间</th>
					<th>列车类型</th>
					<th>预订</th>
				</tr>
			</thead>
			<tbody>
			<% 
				for(int i=0;i<list.size();i++){
					String[] str = list.get(i);
			%>
				<tr>
					<td><a href="<%= request.getContextPath() %>/ManageServlet?action=cccx&train=<%= str[1] %>&flag=1"><%= str[1] %></a></td>
					<td><%= str[2] %></td>
					<td><%= str[3].substring(0,5) %></td>
					<td><%= str[4] %></td>
					<td><%= str[5].substring(0,5) %></td>
					<td><%= str[6] %></td>
					<td>
					<% 
						if(i==0){
							out.println("<input type='radio' name='tname' checked value="+str[1]+" />");
						}
						else{
							out.println("<input type='radio' name='tname' value="+str[1]+" />");
						}
					 %>
					</td>
				</tr>
			<% 
				}
			 %>
			</tbody>
			</table>
			<input type="hidden" name="action" value="book"/>
			<center><br/><input class="btn" type="submit" value="下一步"/><center>
			</form>
			<br/><br/><br/>
			<center>请在上面所给的车次中，选择你要乘坐的车次，即在该车次后面的预订栏中选中单选按钮！</center>
		</div>
		</div>
	</body>
</html>
<% 
	}
 %>