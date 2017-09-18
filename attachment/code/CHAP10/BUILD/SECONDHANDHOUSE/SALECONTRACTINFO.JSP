<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>填写房屋买卖合同</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<link type="text/css" rel="stylesheet" href="css/admin.css"/>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/contract.js"></script>
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
					<h:outputText value=">>填写房屋买卖合同"/>
				</p><br/>
				<div style="border:1px solid green;width:85%;padding:10px;">
					<h:form id="mf" onsubmit="JavaScript:return checkSaleContract();">
						<h:panelGrid columns="2">
							<h:outputText value="出售方：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="first" value="#{SaleContractInfoBean.first}" required="true"/>
								<h:message for="first" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="求购方：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="second" value="#{SaleContractInfoBean.second}" required="true"/>
								<h:message for="second" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="出售方身份证号：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="firstcardid" value="#{SaleContractInfoBean.firstCardId}"/>
								<h:message for="firstcardid" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="求购方身份证号：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="secondcardid" value="#{SaleContractInfoBean.secondCardId}"/>
								<h:message for="secondcardid" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="房源位置：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="location" value="#{SaleContractInfoBean.location}"/>
								<h:message for="location" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="房屋面积（平方米）：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="housearea" value="#{SaleContractInfoBean.houseArea}"/>
								<h:message for="housearea" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="房屋售价(万元)：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="houseprice" value="#{SaleContractInfoBean.housePrice}"/>
								<h:message for="houseprice" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="出售方代理人：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="firstagent" value="#{SaleContractInfoBean.firstAgent}"/>
								<h:message for="firstagent" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="求购方代理人：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="secondagent" value="#{SaleContractInfoBean.secondAgent}"/>
								<h:message for="secondagent" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="出售方联系电话：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="firsttel" value="#{SaleContractInfoBean.firstTel}"/>
								<h:message for="firsttel" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="求购方联系电话：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:panelGroup>
								<h:inputText id="secondtel" value="#{SaleContractInfoBean.secondTel}"/>
								<h:message for="secondtel" style="color:red;"/>
							</h:panelGroup>
							<h:outputText value="合同状态：" style="font-size:14px;width:100%;text-align:right;"/>
							<h:selectOneMenu value="#{SaleContractInfoBean.state}">
								<f:selectItem itemLabel="合同已签定" itemValue="合同已签定"/>
								<f:selectItem itemLabel="买方已付款" itemValue="买方已付款"/>
								<f:selectItem itemLabel="卖方已过户" itemValue="卖方已过户"/>
								<f:selectItem itemLabel="履行完毕" itemValue="履行完毕"/>
							</h:selectOneMenu>					
						</h:panelGrid><br/>
						<h:panelGroup>
							<h:commandButton styleClass="btn" value="生成合同" action="#{SaleContractInfoBean.insertContract}"/>&nbsp;&nbsp;
							<h:commandButton styleClass="btn" value="重置" type="reset"/>
						</h:panelGroup>
					</h:form><br/>
				</div>
				<%@ include file="Tip.jsp" %>
			</div>
		</body>
	</html>
</f:view>