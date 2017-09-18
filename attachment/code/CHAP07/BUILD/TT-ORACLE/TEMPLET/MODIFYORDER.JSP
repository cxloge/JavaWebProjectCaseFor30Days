<%@ page contentType="text/html;charset=gbk" 
	import="wyf.zrk.TicketItem"
%>
<% 
	List<String[]> ls = (List<String[]>)request.getAttribute("list");
	if(session.getAttribute("user")==null){
		out.println("<script language=\"JavaScript\"> alert(\"请您先登录！！！\");"
					+"window.location.href=\"index.jsp\"</script>");
	}
	else{
		if(ls==null||ls.size()==0){
			out.println("<script language=\"JavaScript\"> alert(\"系统错误！！！\");"
				+"window.location.href=\"index.jsp\"</script>");
		}
		else{
			String[] str = ls.get(0);
%>
<html>
	<head>
		<title>预订详细</title>
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
				<a href="index.jsp">首页</a>>><a href="myorder.jsp">我的预订</a>>><b>预订修改</b>
			</p>
			<br/><br/><br/>
			<form action="ManageServlet" method="post" name="mf_mod">
			<table width="80%" bgcolor="black" border="0" cellspacing="1">
			<caption>我的预订 【&nbsp;<%= str[9] %>&nbsp;】</caption>
				<tr bgcolor="#EDF2F7" align="center">
					<th>预订状态</th>
					<td><%= str[9] %></td>
					<th>车次</th>
					<td><%= str[1] %></td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<th>出发站</th>
					<td><%= str[2] %></td>
					<th>目的站</th>
					<td><%= str[3] %></td>
				</tr>
				<tr bgcolor="#EDF2F7" align="center">
					<th>车票日期</th>
					<td><input name="tdate" id="tdate" value="<%= str[8] %>"  onmouseout="calshow=false"
						onclick="JavaScript:showCalendar('tdate');this.blur();"/></td>
					<th>车票数量</th>
					<td><input name="tamount" id="tamount" value="<%= str[7] %>" /></td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<th>联系人</th>
					<td><input id="linkman" name="linkman" value="<%= str[4] %>" /></td>
					<th>联系地址</th>
					<td><input name="address" id="address" value="<%= str[5] %>" /></td>
				</tr>
				<tr bgcolor="#EDF2F7" align="center">
					<th>联系电话</th>
					<td><input id="tel" name="tel" value="<%= str[6] %>" /></td>
					<th></th>
					<td></td>
				</tr>
			</table>
				<input type="hidden" name="action" value="modifyOrder" />
				<input type="hidden" name="oid" value="<%= str[0] %>" />
				<input type="button" class="btn" value="&nbsp;修&nbsp;改&nbsp;" onclick="JavaScript:modify()" />&nbsp;&nbsp;&nbsp;
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
	}
 %>