<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<link href="images/globalstyle.css" type="text/css" rel=stylesheet>
		<script language="JavaScript" src="images/trim.js"></script>
		<script language="JavaScript">
			function confirmDel(){
			 return confirm("确定删除？？？");
			}			
			function textclear(){
			 document.search.key.value="";
			}
			function checkSearch(){
			 var key = document.search.key.value;
			 if(key.trim()==""){
			   alert("关键字不能为空！！！");
			   return;
			 }
			 document.search.submit();
			}
		</script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="book_left_menu.jsp" %>
		</div>		
		<div id="info_table">
		<%
		   	Vector<Vector<String>> v = (Vector<Vector<String>>)request.getAttribute("v");
		   	String message = (String)request.getAttribute("message");
		   	String url = "list_book.jsp";
		%>
			<br/><center><font size="5">图书列表</center>					
			<table border="0" align="center" width="90%" height="40"
					style="background:url(images/sb.jpg) no-repeat">
				<form name="search" action="ManageServlet" method="post">
				<td align="left">请选择查询条件
				<select name="condition">
					<option value="BookNO">按图书编号</option>
					<option value="BookName">按图书名称</option>
					<option value="Publish">按出版社</option>
					<option value="Author">按作者</option>
					<option value="BookIsbn">按ISBN号</option>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="key" value="请输入关键字" 
						onfocus="textclear()" size="25" style="border:0">
				<input type="hidden" name="action" value="search_book">
				</td>
				<td width="39%">
				  <img src="images/sstp.jpg" id="mg" border="0"
				      style="cursor:hand"
				      onclick="checkSearch()"
				      onmousedown="document.all.mg.src='images/ssax.jpg'"
				      onmouseup="document.all.mg.src='images/sstp.jpg'"
				      onmouseout="document.all.mg.src='images/sstp.jpg'"/>				       
				 <!--<input type="button" value="查询" onclick="checkSearch()">-->		
				</td>
				</tr></form>
			</table>		
			<% 
				if(v!=null&&v.size()!=0){
			%>					   	
			<table border="0" bgcolor="black" align="center" cellspacing="1" width="90%" style="font-size:13px">
				<th bgcolor="#D1D1E6">编号</th>
				<th bgcolor="#D1D1E6">名称</th>
				<th bgcolor="#D1D1E6">作者</th>
				<th bgcolor="#D1D1E6">出版社</th>
				<th bgcolor="#D1D1E6">ISBN号</th>
				<!--<th bgcolor="#D1D1E6">购进时间</th>-->
				<th bgcolor="#D1D1E6">价格</th>
				<th bgcolor="#D1D1E6">状态</th>
				<th bgcolor="#D1D1E6" width="60">删除</th>
				<th bgcolor="#D1D1E6" width="60">修改</th>
				<%
					for(int i=0;i<v.size();i++){
						Vector<String> vtemp = v.get(i);
				%>
					<tr bgcolor=<%= i%2==0?"#F0F7FF":"#FFF8F0" %>>
						<td align="center"><%= vtemp.get(0) %></td>
						<td align="center"><%= vtemp.get(1) %></td>
						<td align="center"><%= vtemp.get(2) %></td>
						<td align="center"><%= vtemp.get(3) %></td>
						<td align="center"><%= vtemp.get(4) %></td>
						<!--<td align="center"><%= vtemp.get(5) %></td>-->					
						<td align="center"><%= vtemp.get(6) %></td>
						<%
							int condition = Integer.parseInt(vtemp.get(7));
							switch(condition){
								case 0:
						%>
							<td align="center">在馆</td>
						<%
								break;
								case 1:
						%>
							<td align="center">借出</td>
						<%
								break;
								case 2:
						%>
							<td align="center">借出并被预约</td>
						<%
								break;
								case 3:
						%>
							<td align="center">丢失</td>
						<%
								break;
							}
						%>
						<td align="center">
							<a href="ManageServlet?action=delBook&bNO=<%=vtemp.get(0)%>" 
									onclick="return confirmDel()">
									<img src="images/del.gif" border="0" width="15" height="15"/>删除</a>
						</td>
						<td align="center">
							<a href="ManageServlet?action=editBook&bNO=<%=vtemp.get(0)%>">
								<img src="images/edit.gif" border="0"/>修改</a>
						</td>
						</tr>
					<%
					    }
					%>
			</table>
			<%@ include file="navgation.jsp" %>
		<%
		   	}
		   	else{
				if(message==null&&v.size()==0){
		%>
			<br><br><br><center>没有图书记录可显示	
		<%
				}
			}
			if(message!=null&&v==null){
		%>
			<br><br><br><center><%= message %>
		<%
			}
		%>
		</div>
	</body>
</html>