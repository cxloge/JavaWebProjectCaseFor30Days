<%@ page contentType="text/html;charset=gbk"  %>
<%
	if(session.getAttribute("admin")==null){
		response.sendRedirect("adminlogin.jsp");
	}
%>
<html>
	<head>		
		<title>主页</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	</head>
	<frameset cols="22%,*" > 
		<frame frameborder="0" name="leftFrame" scrolling="NO" noresize src="tree.jsp">
		<frame frameborder="0" name="mainFrame" noresize src="main.jsp">
	</frameset>
	<body>
	</body>
</html>