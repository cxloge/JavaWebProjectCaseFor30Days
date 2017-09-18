<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
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
		<%= stuName %>，您当前欠款记录如下：<br/><br/>
			<table border="0" bgcolor="black" align="center" cellspacing="1" width="90%">
				<th bgcolor="#D1D1E6">欠款书名</th>
				<th bgcolor="#D1D1E6">欠款项目</th>
				<th bgcolor="#D1D1E6">借出日期</th>
				<th bgcolor="#D1D1E6">应还日期</th>				
				<th bgcolor="#D1D1E6">欠款金额</th>
				<%
					double total = 0.0;			//记录未交罚款的总额
					for(int i=0;i<v.size();i++){
						Vector<String> vtemp = v.get(i);
				%>
					<tr bgcolor=<%= i%2==0?"#F0F7FF":"#FFF8F0" %>>
						<td><%= vtemp.get(0) %></td>
						<td><%= vtemp.get(1) %></td>
						<td><%= vtemp.get(2) %></td>
						<td><%= vtemp.get(3) %></td>
						<td><%= vtemp.get(4) %></td>
					</tr>
				<% 
					total = total+Double.parseDouble(vtemp.get(4));
					total = Math.round(total*100)/100.0;
				    }
				%>
					<tr bgcolor="white">
						<td colspan="4" align="right">金额总计</td>
						<td>
							<font color="red" size="2.5"/><%= total %>￥
						</td>
					</tr>
			</table>
		<%
		   	}
		   	else{
		%><br><br>
			<center><font color="red" size="3">
				<%= stuName %>您当前没有欠款。
			</font></center>			   
		<%
		   	}
		%>		
		</div>
	</body>
</html>