<%@ page contentType="text/html;charset=gbk"
	import="java.util.*"
 %>
<html>
	<head>
		<title>信息管理</title>
 		<link href="css/reg.css" type="text/css" rel="stylesheet"/>
 		<link href="css/tablestyle.css" type="text/css" rel="stylesheet" />
 		<script language="JavaScript" src="script/trim.js"></script>
 		<script language="JavaScript" src="script/changepage.js"></script>
	</head>
	<% 
		List<String[]> list = (List<String[]>)session.getAttribute("list");
	 %>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>信息管理</b>
			</p>
			<% 
				if(list==null){
					response.sendRedirect(request.getContextPath()+"/ManageServlet?action=getTicketMsg&type=3");
				}
				else if(list.size()==0){
			%>
					<h1><center>暂无信息！！！</center></h1>
			<%
				}
				else{				
					int totalpage = (Integer)session.getAttribute("totalpage");
					int nowpage = (Integer)session.getAttribute("nowpage");
			 %>
			<table width="90%" class="default" border="0" cellspacing="1" align="center">
			<caption>我的信息</caption>
			<thead>
				<tr>
					<th>序号</th>
					<th>内容概述</th>
					<th>详细信息</th>
					<th>删除信息</th>
				</tr>
			</thead>
			<tbody>
				<% 
					for(int i=0;i<list.size();i++){
						String[] str = list.get(i);
						String type = (str[0].equals("1"))?"转让":"求购";
						StringBuffer mtitle = new StringBuffer();
						mtitle.append(type);						
						String[] dd = str[1].split("-");
						mtitle.append(dd[0]);
						mtitle.append("年");
						mtitle.append(dd[1]);
						mtitle.append("月");
						mtitle.append(dd[2]);
						mtitle.append("日");						
						mtitle.append(str[2]);
						mtitle.append("次列车车票");
				%>
					<tr>
					<td width="50px"><%= ((Integer)session.getAttribute("nowpage")-1)*2+i+1 %></td>
					<td>[<%= type %>]&nbsp;&nbsp;
						<a href="<%= request.getContextPath() %>/ManageServlet?action=lookdetail&mid=<%= str[3] %>&flag=1">
						<%= mtitle.toString() %></a></td>
					<td><a href="<%= request.getContextPath() %>/ManageServlet?action=lookdetail&mid=<%= str[3] %>&flag=1">详细信息</a></td>
					<td><a href="<%= request.getContextPath() %>/ManageServlet?action=delMsg&mid=<%= str[3] %>">删除信息</a></td>
				</tr>			
				<%
					}
				 %>				
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
			      <a href="<%= request.getContextPath() %>/ManageServlet?action=changePage&pagename=/messagemanage.jsp&page=<%= nowpage-1 %>"><img src="images/pre.gif" border="0"/></a>
			      <% 
			      	}
			      	if(nowpage<totalpage){
			       %>	       
			      <a href="<%= request.getContextPath() %>/ManageServlet?action=changePage&pagename=/messagemanage.jsp&page=<%= nowpage+1 %>"><img src="images/next.gif" border="0"/></a>
			      <% 
			      	}
			      	else{
			      		out.println("<img src='images/next.gif' style='visibility:hidden'/>");
			      	}
			       %>
			      <font size="2">第<input name="page" id="page" size="2" value="<%= nowpage %>" onfocus="document.all.page.value=''"/>页</font>
			      <input type="hidden" name="action" value="changePage" />
			      <input type="hidden" name="pagename" value="/messagemanage.jsp"/>
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
		</div>
		</div>
	</body>
</html>