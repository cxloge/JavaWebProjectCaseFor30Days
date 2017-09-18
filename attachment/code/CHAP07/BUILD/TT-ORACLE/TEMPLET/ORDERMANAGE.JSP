<%@ page contentType="text/html;charset=gbk" 
	import="java.util.*"
%>
<%
	List<String[]> ls = (List<String[]>)session.getAttribute("list");
	if(session.getAttribute("admin")==null){
		out.println("<script language=\"JavaScript\"> alert(\"请您先登录！！！\");"
					+"window.location.href=\"adminlogin.jsp\"</script>");
	}
	else{
%>
<html>
	<head>
		<title>订单管理</title>
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
							<th width="80%">预订信息</th>
							<th>状态</th>
						</tr>
						</thead>
						<tbody>
					<% 
						for(int i=0;i<size;i++){
							String[] str = ls.get(i);
					%>
						<tr>
							<td><a href="<%= request.getContextPath() %>/ManageServlet?action=getOrderDetail&oid=<%= str[0] %>&url=/sendorder.jsp">
								预订<%= str[1] %>由<%= str[2] %>到<%= str[3] %>的<%= str[4] %>次列车
							</a></td>
							<td><%= str[5] %></td>
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
					      <a href="<%= request.getContextPath() %>/ManageServlet?action=changePage&pagename=/ordermanage.jsp&page=<%= nowpage-1 %>"><img src="images/pre.gif" border="0"/></a>
					      <% 
					      	}
					      	if(nowpage<totalpage){
					       %>	       
					      <a href="<%= request.getContextPath() %>/ManageServlet?action=changePage&pagename=/ordermanage.jsp&page=<%= nowpage+1 %>"><img src="images/next.gif" border="0"/></a>
					      <% 
					      	}
					      	else{
					      		out.println("<img src='images/next.gif' style='visibility:hidden'/>");
					      	}
					       %>
					      <font size="2">第<input name="page" id="page" size="2" value="<%= nowpage %>" onfocus="document.all.page.value=''"/>页</font>
					      <input type="hidden" name="action" value="changePage" />
					      <input type="hidden" name="pagename" value="/ordermanage.jsp"/>
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