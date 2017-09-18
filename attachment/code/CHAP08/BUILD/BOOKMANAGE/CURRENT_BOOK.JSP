<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<script language="JavaScript">
			function confirmLost(sb){
			  if(confirm("确定挂失？？？")){
			  	sb.submit();
			  }
			}
			function confirmXuJie(sb){
			  if(confirm("确定续借？？？")){
			  	sb.submit();
			  }
			}
		</script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="stu_left_menu.jsp" %>
		</div>		
		<div id="info_table">
		<%
			String stuName = (String)session.getAttribute("stuName");
		   	Vector<Vector<String>> v = (Vector<Vector<String>>)request.getAttribute("v");
		   	if(v!=null&&v.size()!=0){
		%>
		<%= stuName %>，您当前借阅书籍列表如下：<br/><br/>
			<table border="0" bgcolor="black" align="center" cellspacing="1" width="100%">
				<th bgcolor="#D1D1E6">编号</th>
				<th bgcolor="#D1D1E6">名称</th>
				<th bgcolor="#D1D1E6">作者</th>
				<th bgcolor="#D1D1E6">出版社</th>
				<th bgcolor="#D1D1E6">借出日期</th>
				<th bgcolor="#D1D1E6">应还日期</th>				
				<th bgcolor="#D1D1E6">续借</th>
				<th bgcolor="#D1D1E6">挂失</th>
				<%
					for(int i=0;i<v.size();i++){
						Vector<String> vtemp = v.get(i);
				%>
					<tr bgcolor=<%= i%2==0?"#F0F7FF":"#FFF8F0" %>>
						<td><%= vtemp.get(0) %></td>
						<td><%= vtemp.get(1) %></td>
						<td><%= vtemp.get(2) %></td>
						<td><%= vtemp.get(3) %></td>
						<td><%= vtemp.get(4) %></td>
						<td><%= vtemp.get(5) %></td>					
						<form id="xjts<%=i%>" action="StudentServlet" method="post">
							<input type="hidden" name="action" value="xujie"/>
							<input type="hidden" name="borrowNO" value="<%=vtemp.get(6)%>"/>						
							<td align="center">
							<!-- <input type="submit" value="续借"/> -->	
							<img src="images/xja.gif" id="xj<%=i%>" onclick="confirmXuJie(document.all.xjts<%=i%>)" 
								onmouseover="document.all.xj<%=i%>.src='images/xjb.gif'"
							 	onmouseout="document.all.xj<%=i%>.src='images/xja.gif'"
							  	onmousedown="document.all.xj<%=i%>.src='images/xjc.gif'"
							   	style="cursor:hand"/>	
							</td>
						</form>
						<form id="gsts<%=i%>" action="StudentServlet" method="post">
							<input type="hidden" name="action" value="guashi"/>
							<input type="hidden" name="loseNO" value="<%=vtemp.get(6)%>"/>
							<td align="center">
							<!-- <input type="submit" value="挂失"/> -->
							<img src="images/gsa.gif" id="gs<%=i%>" onclick="confirmLost(document.all.gsts<%=i%>)" 
								onmouseover="document.all.gs<%=i%>.src='images/gsb.gif'"
							 	onmouseout="document.all.gs<%=i%>.src='images/gsa.gif'"
							  	onmousedown="document.all.gs<%=i%>.src='images/gsc.gif'"
							   	style="cursor:hand"/>		
							</td>
						</form>
					</tr>
				<%
				    }
				%>
			</table>
		<%
		   	}
		   	else{
		%><br><br>
			<center><font color="red" size="3">
				<%= stuName %>，您当前还没有借阅书籍。
			</font></center>
		<% 
			}
		 %>
		</div>
	</body>
</html>