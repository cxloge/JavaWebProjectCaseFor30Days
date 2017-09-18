<table class="default" align="center" border="0" bgcolor="black" width="90%" cellspacing="1">
	<caption>
		<%= tname %>次列车所经过车站如下&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%= request.getContextPath() %>/ManageServlet?action=book&tname=<%= tname %>">[&nbsp;预订&nbsp;]</a>
	</caption>
	<thead>
	<tr>
		<th>车站</th>
		<th>到站时间</th>
		<th>开车时间</th>
	</tr>
	</thead>
	<tbody>
<% 
	for(int i=0;i<list.size();i++){
		String[] str = list.get(i);
%>
	<tr>
		<td><%= str[0] %></td>
		<td><%= (str[1].length()>6)?str[1].substring(0,5):str[1] %></td>
		<td><%= (str[2].length()>6)?str[2].substring(0,5):str[2] %></td>
	</tr>
<% 
	}
 %>
</tbody>
</table>