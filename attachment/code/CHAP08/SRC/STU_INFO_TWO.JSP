<%@ page contentType="text/html;charset=gbk"%>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
		<link href="images/globalstyle.css" type="text/css" rel=stylesheet>		
	</head>
	<body>
		<div id="father">
		<%
		   	String message = (String)request.getAttribute("message");
		   	if(message!=null){
		%>
			<br><br><br><br><br><br><br><br>
			<center><%= message %></center>
		<%
		   	}
		%>
		</div>
	</body>
</html>