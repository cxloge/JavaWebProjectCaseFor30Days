<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>登陆失败</title>
	</head>
	<body>
		<f:view>
			<font color="red" size="6">
			<h:outputText value="用户名或密码错误!!!"/>
			</font>
			<br>
			<a href="faces/Login.jsp">重新登陆</a>
		</f:view>
	</body>
</html>