<%@ page contentType="text/html;charset=gbk"
	import="java.util.*"
 %>
<% 
	List<String[]> list = (List<String[]>)request.getAttribute("list");
	String tname = (String)request.getAttribute("tname");
	System.out.println(tname);
	if(list==null||list.size()==0){
		response.sendRedirect("index.jsp");
	}
	else{
 %>
<html>
	<head>
		<title>ÏêÏ¸²éÑ¯</title>
		<link href="css/reg.css" type="text/css" rel="stylesheet"/>
		<link href="css/tablestyle.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">Ê×Ò³</a>>><b>ÏêÏ¸²éÑ¯</b>
			</p>
			<%@ include file="traindetail_base.jsp" %>
		</div>
		</div>
	</body>
</html>
<% 
	}
 %>