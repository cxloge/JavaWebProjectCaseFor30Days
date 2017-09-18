<%@ page contentType="text/html;charset=gbk" 
	import="java.util.*"
%>
<%
	List<String[]> ls = (List<String[]>)request.getAttribute("list");
	if(session.getAttribute("admin")==null){
		out.println("<script language=\"JavaScript\"> alert(\"请您先登录！！！\");"
					+"window.location.href=\"adminlogin.jsp\"</script>");
	}
	else{
		String[] str = ls.get(0);
%>
<html>
	<head>
		<title>订单发送</title>
		<link href="css/admin.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div id="wrapper">
			<div id="branding"></div>
			<div id="content">
				<p id="con_title">
					<table border="0" bgcolor="#F9F3E6">
						<tr>
							<td width="80" align="center">
								<a href="<%= request.getContextPath() %>/ManageServlet?action=lookOrder&flag=3">&nbsp;所有订单</a>
							</td>
							<td width="2" align="center"><font color="#F57708" size="4">|</font></td>
							<td width="85" align="center">
								<a href="<%= request.getContextPath() %>/ManageServlet?action=lookOrder&flag=1">未处理订单</a>
							</td>
							<td width="2" align="center"><font color="#F57708" size="4">|</font></td>
							<td width="85" align="center">
								<a href="<%= request.getContextPath() %>/ManageServlet?action=lookOrder&flag=2">已处理订单</a>
							</td>
						</tr>
					</table>
				</p>
				<p id="con">
				<br/>
				<table width="90%" bgcolor="black" border="0" cellspacing="1" align="center">
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
				<% 
					if(str[9].equals("未处理")){
				 %>
				 <form>
				 <table align="center" border="0"><tr height="50" align="center">
				 	<td>
				 		<input type="button" class="btn" onclick="window.location.href='<%= request.getContextPath() %>/ManageServlet?action=sendOrder&oid=<%= str[0] %>&flag=1'" value="&nbsp;已订到票&nbsp;"/>
					</td>
					<td>
						<input type="button" class="btn" onclick="window.location.href='<%= request.getContextPath() %>/ManageServlet?action=sendOrder&oid=<%= str[0] %>&flag=2'" value="&nbsp未订到票&nbsp;" />
					</td>
				</tr></table>
				</form>
				<% 
					}
				 %>
				</p>
			</div>
			<fieldset class="login">
				<legend>导航</legend>
				<ul>
					<li><a href="<%= request.getContextPath() %>/ManageServlet?action=lookOrder&flag=1">订单管理</a></li>
					<li><a href="<%= request.getContextPath() %>/ManageServlet?action=lookAdmin">系统维护</a></li>
					<li><a href="modifypwd.jsp">修改密码</a></li>
					<li><a href="<%= request.getContextPath() %>/ManageServlet?action=adminLogout">退出登录</a></li>
				</ul>
			</fieldset>
 			
			<div id="footer">
				<p><i>欢迎光临本网站,如果您有什么疑问，请联系我们&nbsp;&nbsp;
					www.zhairuike@yahoo.com.cn
				</i></p>
			</div>			
		</div>
	</body>
</html>
<% 
	}
 %>