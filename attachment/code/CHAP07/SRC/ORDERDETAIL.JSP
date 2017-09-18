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
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><a href="myorder.jsp">我的预订</a>>><b>预订详细</b>
			</p>
			<br/><br/><br/>
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
					<td><%= str[8] %></td>
					<th>车票数量</th>
					<td><%= str[7] %></td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<th>联系人</th>
					<td><%= str[4] %></td>
					<th>联系地址</th>
					<td><%= str[5] %></td>
				</tr>
				<tr bgcolor="#EDF2F7" align="center">
					<th>联系电话</th>
					<td><%= str[6] %></td>
					<th></th>
					<td></td>
				</tr>
			</table>			
		</div>
		</div>
	</body>
</html>
<%
		}
	}
 %>





