<%@ page contentType="text/html;charset=gbk"%>
<jsp:useBean id="status" class="wyf.wyy.StatusBean" scope="session"/>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
	</head>
	<body>		
		<div id="Nav">		
			<ul>
				<li><a href="StudentServlet?action=cb">当前借阅</a></li>
				<li><a href="StudentServlet?action=bh">历史借阅</a></li>
				<li><a href="StudentServlet?action=lb">图书丢失</a></li>
				<li><a href="StudentServlet?action=fk">罚款记录</a></li>
				<li><a href="StudentServlet?action=cf">欠款状态</a></li>
				<li><a href="lost_card.jsp">读者挂失</a></li>				
			</ul>
		</div>
	</body>
</html>