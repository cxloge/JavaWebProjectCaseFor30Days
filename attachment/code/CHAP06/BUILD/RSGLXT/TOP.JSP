<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head>
		<title>top.jsp</title>
		<link href="images/topstyle.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="images/top.js"></script>
		<script language="JavaScript">
			window.onload=realtime;
		</script>
	</head>
	<body>
		<div id="container">
			<div id="mainHead">
				<h1><i><s:text name="top.title"/></i></h1>
			</div>
			<div id="simpleinfo">
				<p><span><s:text name="top.info"/></span><span id="time"></span><a href="zhuXiao.action">ÍË³öµÇÂ¼</a></p>
			</div>
		</div>
	</body>
</html>