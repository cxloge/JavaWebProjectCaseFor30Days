<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>StudentWelcome.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
	</head>
	<body>
		<f:view>
		<h:panelGrid style="valign:middle;height:100%">
			<h:panelGrid columns="2" styleClass="welcome" style="valign:middle;text-align:center">

				
				<h:graphicImage value="images/wel.png" style="position:relative;margin-top:10px;"/>
				<h:panelGroup>
					<h:outputText value="»¶Ó­ÄúµÇÂ¼£º"/>
					<h:outputText value="#{PersonalMsgBean.sname}" />
					
				</h:panelGroup>
			</h:panelGrid>	
		</h:panelGrid>
		</f:view>
	</body>
</html>