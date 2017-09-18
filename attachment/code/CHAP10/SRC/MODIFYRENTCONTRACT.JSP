<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
	<html>
		<head>
			<title>修改租赁合同</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<link type="text/css" rel="stylesheet" href="css/admin.css"/>
			<script type="text/javascript" src="script/adminlogin.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/allinfo.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="AdminMenu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					&nbsp;&nbsp;<h:outputText value="当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/AdminIndex.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>修改合同状态"/>
				</p><br/><br/><br/>
				<h:form id="mf">
					<h:outputText value="请选择合同状态："/>
					<h:selectOneMenu value="#{ModifyRentContractBean.state}">
						<f:selectItem itemLabel="合同已签定" itemValue="合同已签定"/>
						<f:selectItem itemLabel="买方已付款" itemValue="买方已付款"/>
						<f:selectItem itemLabel="卖方已过户" itemValue="卖方已过户"/>
						<f:selectItem itemLabel="履行完毕" itemValue="履行完毕"/>
					</h:selectOneMenu>&nbsp;&nbsp;
					<h:commandButton styleClass="btn" value="修改" action="#{ModifyRentContractBean.modify}"/>				
				</h:form>
			</div>
		</body>
	</html>
</f:view>