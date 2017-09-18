<%@ page contentType="text/html;charset=gbk" 
	import="wyf.zrk.TicketItem"
%>

<% 
	TicketItem ti = (TicketItem)request.getAttribute("ti");
	if(ti==null){
		response.sendRedirect("index.jsp");
	}
	else{
 %>
<html>
	<head>
		<title>信息修改</title>		
 		<link href="css/book.css" type="text/css" rel="stylesheet"/>
 		<script language="JavaScript" src="script/trim.js"></script>
		<script language="JavaScript" src="script/general.js"></script>
		<script language="JavaScript" src="script/book.js"></script>
		<script language="javascript" src="script/calendar.js"></script>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>车票预订</b>
			</p>
			<form action="ManageServlet" method="post" name="mf_msg">
			<table border="0" bgcolor="black" width="80%" cellspacing="1">
				<tr bgcolor="#EDF2F7" align="center">
					<th>车次：</th>
					<td><%= ti.getTname() %></td>
					<th>车票数量：</th>
					<td><input name="tamount" value="<%= ti.getTamount() %>"/></td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<th>出发站：</th>
					<td><%= ti.getTstart() %></td>
					<th>目的站：</th>
					<td><%= ti.getTend() %></td>
				</tr>
				<tr bgcolor="#EDF2F7" align="center">
					<th>车票日期：</th>
					<td><input name="tdate" value="<%= ti.getTdate() %>" onmouseout="calshow=false"
						onclick="JavaScript:showCalendar('tdate');this.blur();" /></td>
					<th>联系人：</th>
					<td><input name="linkman" value="<%= ti.getLinkman() %>" /></td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<th>联系人地址：</th>
					<td><input name="address" value="<%= ti.getAddress() %>" /></td>
					<th>联系电话：</th>
					<td><input name="tel" value="<%= ti.getTel() %>" /></td>
				</tr>
			</table><br/>
			<input type="hidden" name="action" value="modify" />
			<input type="button" class="btn" value="&nbsp;修&nbsp;改&nbsp;" onclick="JavaScript:check()" />&nbsp;&nbsp;&nbsp;
			<input type="reset" class="btn" value="&nbsp;重&nbsp;置&nbsp;" />
			</form><br/><br/>
			<table border="0" cellspacing="1" bgcolor="#F7B770" width="80%" height="50px">
				<tr bgcolor="#FDF1E4">
					<td align="center">
						<img src="images/warning.gif" border="0" />
						<font size="2">注：请填写正确且有效的信息，以确保您能及时地、准确地预订到您所需车次的车票，
						但车次、出发站、目的站一旦填写，不可修改。</font>
					</td>
				</tr>
			</table>
			<%@ include file="calendar.jsp" %>
		</div>
		<%@ include file="tip.jsp" %>
		</div>	
	</body>
</html> 
 <% 
 	}
  %>