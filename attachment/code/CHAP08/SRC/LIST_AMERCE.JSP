<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<link href="images/globalstyle.css" type="text/css" rel=stylesheet>
		<script language="JavaScript">
			function handIn(sb){
			 	if(confirm("确定交纳？？？")){
			 		sb.submit();
			 	}
			}		
		</script>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="borrow_left_menu.jsp" %>
		</div>		
		<div id="info_table">
		<%
			String stuName = (String)request.getAttribute("stuName");
		   	Vector<Vector<String>> va = (Vector<Vector<String>>)request.getAttribute("va");
		   	Vector<Vector<String>> vb = (Vector<Vector<String>>)request.getAttribute("vb");
		   	String message = (String)request.getAttribute("message");
		   	System.out.println(message);
		   	if((va!=null&&va.size()!=0)||(vb!=null&&vb.size()!=0)){
		%>
		<%= stuName %>，您当前欠款记录如下：<br/><br/>
			<table border="0" bgcolor="black" align="center" cellspacing="1" width="90%">
				<tr bgcolor="white">
					<td align="center" colspan="5">以下是应缴罚款</td>
				</tr>
				<th bgcolor="#D1D1E6">欠款书名</th>
				<th bgcolor="#D1D1E6">欠款项目</th>
				<th bgcolor="#D1D1E6">借出日期</th>
				<th bgcolor="#D1D1E6">应还日期</th>				
				<th bgcolor="#D1D1E6">欠款金额</th>
				<%
					double totala = 0.0;			//记录未交罚款的总额
					for(int i=0;i<va.size();i++){
						Vector<String> vtemp = va.get(i);
				%>
					<tr bgcolor=<%= i%2==0?"#F0F7FF":"#FFF8F0" %>>
						<td align="left"><%= vtemp.get(0) %></td>
						<td align="center"><%= vtemp.get(1) %></td>
						<td align="center"><%= vtemp.get(2) %></td>
						<td align="center"><%= vtemp.get(3) %></td>
						<form name="jnfk<%=i%>" action="ManageServlet" method="post">
							<input type="hidden" name="action" value="amerce">							
						<td align="right"><span style="vertical-align:middle">
							<%= vtemp.get(4) %></span>
							<input type="hidden" name="AmerceNO" value="<%=vtemp.get(5)%>">
							<!-- <input type="submit" value="缴纳"> -->
							<img src="images/jna.gif" id="jn<%=i%>" onclick="handIn(document.all.jnfk<%=i%>)" 
								onmouseover="document.all.jn<%=i%>.src='images/jnb.gif'"
							 	onmouseout="document.all.jn<%=i%>.src='images/jna.gif'"
							  	onmousedown="document.all.jn<%=i%>.src='images/jnc.gif'"
							   	style="cursor:hand"/>								
						</td>
						</form>
					</tr>
				<% 
					totala = totala+Double.parseDouble(vtemp.get(4));
					totala = Math.round(totala*100)/100.0;
				    }
				%>
					<tr bgcolor="white">
						<td colspan="4" align="right">金额总计</td>
						<td>
							<font color="red" size="2.5"/><%= totala %>￥
						</td>
					</tr>
					<tr bgcolor="white">
						<td align="center" colspan="5">
							以下是当前借阅超期罚款请通知该生还书</td>
					</tr>					
				<%
					double totalb = 0.0;			//记录未交罚款的总额
					for(int i=0;i<vb.size();i++){
						Vector<String> vtemp = vb.get(i);
				%>
					<tr bgcolor=<%= i%2==0?"#F0F7FF":"#FFF8F0" %>>
						<td align="center"><%= vtemp.get(0) %></td>
						<td align="center"><%= vtemp.get(1) %></td>
						<td align="center"><%= vtemp.get(2) %></td>
						<td align="center"><%= vtemp.get(3) %></td>
						<td align="center"><%= vtemp.get(4) %></td>
					</tr>
				<% 
					totalb = totalb+Double.parseDouble(vtemp.get(4));
					totalb = Math.round(totalb*100)/100.0;
				    }
				%>
					<tr bgcolor="white">
						<td colspan="4" align="right">金额总计</td>
						<td>
							<font color="red" size="2.5"/><%= totalb %>￥
						</td>
					</tr>
			</table>
		<%
		   	}
		   	else{
				if(message==null){
		%>
			<br><br><br><center><font size="3">该生没有欠款	
		<%
				}
			}
			if(message!=null){
		%>
			<br><br><br><center><font size="3"><%= message %>
		<%
			}
		%>	
		</div>
	</body>
</html>