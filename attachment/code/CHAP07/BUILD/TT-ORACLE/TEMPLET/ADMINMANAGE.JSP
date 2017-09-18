<%@ page contentType="text/html;charset=gbk" 
	import="java.util.*"
%>
<%
	List<String[]> ls = (List<String[]>)session.getAttribute("list");
	if(session.getAttribute("admin")==null||session.getAttribute("level")==null){
		out.println("<script language=\"JavaScript\"> alert(\"请您先登录！！！\");"
					+"window.location.href=\"adminlogin.jsp\"</script>");
	}
	else if(!((String)session.getAttribute("level")).equals("超级")){
		out.println("<script language=\"JavaScript\"> alert(\"您没有足够的权限！！！\");"
					+"window.location.href=\"ManageServlet?action=lookOrder&flag=3\"</script>");
	}
	else{
%>
<html>
	<head>
		<title>管理员管理</title>
		<link href="css/admin.css" type="text/css" rel="stylesheet" />
		<link href="css/tablestyle.css" type="text/css" rel="stylesheet" />
		<script language="JavaScript" src="script/trim.js"></script>
 		<script language="JavaScript" src="script/changepage.js"></script>
	</head>
	<body>
		<div id="wrapper">
			<div id="branding"></div>
			<div id="content">
				<p id="con_title">
					<table border="0" bgcolor="#F9F3E6">
						<tr>
							<td width="100" align="center">
								<a href="addadmin.jsp">&nbsp;管理员添加</a>
							</td>
							<td width="2" align="center"><font color="#F57708" size="4">|</font></td>
							<td width="100" align="center">
								<a href="<%= request.getContextPath() %>/ManageServlet?action=lookAdmin">&nbsp;管理员删除</a>
							</td>
							<td width="2" align="center"><font color="#F57708" size="4">|</font></td>
							<td width="100" align="center">
								<a href="resetpwd.jsp">密码重置</a>
							</td>
						</tr>
					</table>
				</p>
				<p id="con">
					<br/>
				<% 
					int size=ls.size();
					if(size==0){
				%>
					<table border="0" align="center"><tr><td><h1>暂无信息！！！</h1></td></tr></table>
				<%
					}
					else{
						int totalpage = (Integer)session.getAttribute("totalpage");
						int nowpage = (Integer)session.getAttribute("nowpage");
				 %>
					<table width="90%" border="0" cellspacing="1" align="center" class="default">
						<thead>
						<tr>
							<th width="34%">用户名</th>
							<th width="33%">级别</th>
							<th width="33%">删除</th>
						</tr>
						</thead>
						<tbody>
					<% 
						for(int i=0;i<size;i++){
							String[] str = ls.get(i);
					%>
						<tr>
							<td><%= str[1] %></td>
							<td><%= str[2] %></td>
							<% 
								if(str[2].equals("超级")){
									out.println("<td>--</td>");
								}
								else{
							 %>
							<td><img src="images/del.gif" /><a href="<%= request.getContextPath() %>/ManageServlet?action=delAdmin&aid=<%= str[0] %>">删除</a></td>
							<% 
								}
							 %>
						</tr>
					<% 
						}
					 %>
					</tbody>
					</table>
					<table width="90%" align="center">
					<form method="post" action="ManageServlet" name="myform" id="myform">
					  <tr height="50px">
					    <td align="left">
					      <font size="2">共<%= totalpage %>页&nbsp;&nbsp;当前页:<%= nowpage %></font>
					    </td>
					    <td align="right">
					      <% 
					      	if(nowpage>1){
					       %>
					      <a href="<%= request.getContextPath() %>/ManageServlet?action=changePage&pagename=/adminmanage.jsp&page=<%= nowpage-1 %>"><img src="images/pre.gif" border="0"/></a>
					      <% 
					      	}
					      	if(nowpage<totalpage){
					       %>	       
					      <a href="<%= request.getContextPath() %>/ManageServlet?action=changePage&pagename=/adminmanage.jsp&page=<%= nowpage+1 %>"><img src="images/next.gif" border="0"/></a>
					      <% 
					      	}
					      	else{
					      		out.println("<img src='images/next.gif' style='visibility:hidden'/>");
					      	}
					       %>
					      <font size="2">第<input name="page" id="page" size="2" value="<%= nowpage %>" onfocus="document.all.page.value=''"/>页</font>
					      <input type="hidden" name="action" value="changePage" />
					      <input type="hidden" name="pagename" value="/adminmanage.jsp"/>
					    </td>
					    <td width="10">
					      <img src="images/go.gif" border="0" style="cursor:hand" onclick="JavaScript:checkPage(<%= totalpage %>)">
					    </td>
					  </tr>	
					</form>
					</table>
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