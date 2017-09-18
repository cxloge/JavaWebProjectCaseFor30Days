<%@ page contentType="text/html;charset=gbk"%>
<table align="center" width="90%">
	<tr align="left" width="30%">
		<td width="100">
<% 
		int curPage = status.getCurPage();			//得到当前页
		int total = status.getTotal();				//得到总页数
		if(curPage>1){
%>
		<a href="StudentServlet?action=changePage&curPage=<%= curPage-1 %>&url=<%= url %>"><<上一页</a>
<%
		}
%>
		</td>
	<form action="StudentServlet" method="post">
		<td align="center" width="30%">
			<select name="curPage" onchange="this.form.submit()">
<%
				for(int i=1;i<=total;i++){
					if(i==curPage){
%>
					<option value="<%= i %>" selected>第<%= i %>页</option>
<%
					}
					else{
%>
					<option value="<%= i %>">第<%= i %>页</option>
<%
					}
%>							
<%
				}
%>		
	 			<input type="hidden" name="action" value="changePage">
	 			<input type="hidden" name="url" value="<%= url %>">
			</select>						
		</td>
		<td align="right" width="30%">
<%
		if(curPage<total){
%>
		<a href="StudentServlet?action=changePage&curPage=<%= curPage+1 %>&url=<%= url %>">下一页>></a>
<%
		}
%>
		</td>
	</form>
	</tr>
</table>