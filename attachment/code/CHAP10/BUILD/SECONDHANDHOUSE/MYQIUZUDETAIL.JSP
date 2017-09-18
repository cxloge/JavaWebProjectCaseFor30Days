<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
		<head>
			<title>求租信息明细</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>求租信息明细" />
				</p><br/><br/>
				<p style="font-size:20px;">
					<h:outputText value="#{MyRentDetailBean.msgtype}信息明细"/>
				</p>
				<h:panelGrid columns="2" style="border:1px solid gray;width:80%;">
					<h:panelGroup>
						<h:outputText value="信息类型："/>
						<h:outputText value="#{MyRentDetailBean.msgtype}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="地理位置："/>
						<h:outputText value="#{MyRentDetailBean.location}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="具体位置："/>
						<h:outputText value="#{MyRentDetailBean.detail}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="物业："/>
						<h:outputText value="#{MyRentDetailBean.wuye}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="户型："/>
						<h:outputText value="#{MyRentDetailBean.type}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="面积："/>
						<h:outputText value="#{MyRentDetailBean.area}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="楼层"/>
						<h:outputText value="#{MyRentDetailBean.high}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="价格："/>
						<h:outputText value="#{MyRentDetailBean.price}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="联系人："/>
						<h:outputText value="#{MyRentDetailBean.linkman}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="联系人地址："/>
						<h:outputText value="#{MyRentDetailBean.address}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="电话："/>
						<h:outputText value="#{MyRentDetailBean.tel}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="E-mail:"/>
						<h:outputText value="#{MyRentDetailBean.email}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="发布时间："/>
						<h:outputText value="#{MyRentDetailBean.publishtime}"/>
					</h:panelGroup>
					<h:panelGroup>
						<h:outputText value="备注："/>
						<h:outputText value="#{MyRentDetailBean.remark}"/>
					</h:panelGroup>
				</h:panelGrid>
			</div>
		</body>
	</html>
</f:view>