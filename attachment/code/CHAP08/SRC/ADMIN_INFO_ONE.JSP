<%@ page contentType="text/html;charset=gbk"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
	</head>
	<body>
		<div id="Menu">
			<%@ include file="adm_left_menu.jsp" %>
		</div>
		<div id="info_table">
		<%
		   	String message = (String)request.getAttribute("message");
		   	if(message!=null){
		%><br><br><br><br>
			<center><%= message %></center>
		<%
		   	}
		%>
		</div>
	</body>
</html>