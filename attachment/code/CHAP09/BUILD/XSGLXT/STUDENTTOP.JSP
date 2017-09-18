<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>Studenttop.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
	</head>
	<body>
		<f:view>
			<h:panelGrid columns="2" styleClass="top">
				<h:panelGroup>
					<h:graphicImage value="images/baina.gif" styleClass="pic"/>
					<h:outputText value="华北城市大学学生管理系统学生端" />
				</h:panelGroup>		
			</h:panelGrid>
		</f:view>
	</body>
</html>