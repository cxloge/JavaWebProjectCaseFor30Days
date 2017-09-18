<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%
	String msg = (String)request.getAttribute("msg");	//得到提示信息
%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
	<title>信息提示</title>
  </head>
  <body bgcolor="#EBF5FD">
    <center><br/><br/><br/><br/><br/><br/>
	<h1>
	  <%= msg %>
	  <p/><center><a href="JavaScript:history.back()">
	  <img border="0" src="img/back.jpg"/></a>
	</h1>
	</center>
  </body>
</html>