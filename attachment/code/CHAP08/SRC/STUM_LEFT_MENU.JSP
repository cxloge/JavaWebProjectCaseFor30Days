<%@ page contentType="text/html;charset=gbk"%>
<jsp:useBean id="status" class="wyf.wyy.StatusBean" scope="session"/>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
	</head>
	<body>		
		<div id="Nav">		
			<ul>
				<li><a href="stu_manage.jsp">添加学生</a></li>
				<li><a href="ManageServlet?action=list_stu">学生列表</a></li>		
			</ul>
		</div>
	</body>
</html>