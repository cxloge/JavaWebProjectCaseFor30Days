<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>PersonalMsg.jsp</title>
		<link style="text/css" rel="stylesheet" href="images/style.css">
	</head>
	<body>
		<f:view>
			<h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
				<h:outputText value="请先登录"/>
			</h:outputLink>
			<h:panelGrid styleClass="panel" rendered="#{LoginBean.login}">
			<h:outputText value="个人信息表" styleClass="tablehead"/>
			<h:panelGrid columns="2" columnClasses="evenColumn,oddColumn" styleClass="panelstyle">
				<h:outputText value="学号:"/>	<h:outputText value="#{PersonalMsgBean.sno}"/>
				<h:outputText value="姓名:"/>	<h:outputText value="#{PersonalMsgBean.sname}"/>
				<h:outputText value="性别:"/>	<h:outputText value="#{PersonalMsgBean.sgender}"/>
				<h:outputText value="出生日期:"/><h:outputText value="#{PersonalMsgBean.birth}"/>
				<h:outputText value="籍贯:"/>	<h:outputText value="#{PersonalMsgBean.nativeplace}"/>
				<h:outputText value="学院:"/>	<h:outputText value="#{PersonalMsgBean.coll}"/>
				<h:outputText value="专业:"/>	<h:outputText value="#{PersonalMsgBean.dept}"/>
				<h:outputText value="班级:"/>	<h:outputText value="#{PersonalMsgBean.classes}"/>
				<h:outputText value="政治面貌:"/><h:outputText value="#{PersonalMsgBean.mianmao}"/>
				<h:outputText value="入学时间:"/><h:outputText value="#{PersonalMsgBean.comedate}"/>
			</h:panelGrid>
			</h:panelGrid>
		</f:view>
	</body>
</html>