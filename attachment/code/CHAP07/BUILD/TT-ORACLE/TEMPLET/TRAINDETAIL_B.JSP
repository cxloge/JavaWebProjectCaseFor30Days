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
		<title>详细查询</title>
		<link href="css/reg.css" type="text/css" rel="stylesheet"/>
		<link href="css/tablestyle.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><a href="midstation.jsp">中转站查询</a>>><a href="trainsearch_a.jsp">车次查询<a>>><b>详细查询</b>
			</p>
			<%@ include file="traindetail_base.jsp" %>
		</div>
		</div>
	</body>
</html>
<% 
	}
 %>