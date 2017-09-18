<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>管理员首页</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/admin.css"/>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="AdminMenu.jsp" %><br/><br/><br/>
				<h:panelGroup style="font-weight:blod;font-size:30px;">
					<h:outputText value="#{AdminLoginBean.aname}" />
					<h:outputText value="，欢迎进入迅捷管理系统！"/>
				</h:panelGroup>
				<br/><br/><br/>
				<h:panelGroup>
					<h:outputText value="当前有#{AdminIndexBean.lookHouseCount}个人请求查看房源信息！" style="font-size:18px;"/>
					<br/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LookUserApply.jsp">
						<h:outputText value="【点击查看】"/>
					</h:outputLink>
				</h:panelGroup>
				<br/><br/>
				<h:panelGroup>
					<h:outputText value="当前有#{AdminIndexBean.lookQuestionCount}个人向你咨询问题！" style="font-size:18px;"/>
					<br/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/LookAllQuestion.jsp">
						<h:outputText value="【点击查看】"/>
					</h:outputLink>
				</h:panelGroup>
			</div>
		</body>
	</html>
</f:view>