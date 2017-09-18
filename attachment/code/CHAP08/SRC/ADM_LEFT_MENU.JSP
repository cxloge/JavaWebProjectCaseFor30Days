<%@ page contentType="text/html;charset=gbk"%>
<jsp:useBean id="status" class="wyf.wyy.StatusBean" scope="session"/>
<html>
	<head>
		<link href="images/div.css" type="text/css" rel=stylesheet>
	</head>
	<body>		
		<div id="Nav">		
			<ul>
				<li><a href="admin_manage.jsp">修改密码</a></li><!-- cp changePWD -->
				<li><a href="ManageServlet?action=befor_aa">添加管理员</a></li><!-- aa addAdmin -->
				<li><a href="ManageServlet?action=befor_rp">重置密码</a></li><!-- reset admin_pwd -->
				<li><a href="ManageServlet?action=befor_la">管理员列表</a></li>			
			</ul>
		</div>
	</body>
</html>