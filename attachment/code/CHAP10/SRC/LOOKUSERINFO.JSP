<%@ page contentType="text/html;charset=gbk" %>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
	<html>
		<head>
			<title>资料查看</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value="  当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>资料查看" />
				</p>
				<h:outputText value="请您先登录！！！" style="color:red;text-align:center;font-size:18px;" rendered="#{!UserLoginBean.flag}" />
				<h:panelGroup rendered="#{UserLoginBean.flag}" >
					<div style="font-size:5px;vertical-align:middle;border:1px solid #A8C29F;position:absolute;top:40%;left:25%;width:500px;height:200px;text-align:center;">
						<div style="background-color:#F7AE31;">
							<h:outputText value="用户资料" style="text-align:center;font-size:18px;font-weight:bold;"/>
						</div><br/><br/>
						<div style="float:left;">
							<h:graphicImage value="/images/look.png" />
						</div>
						<div style="float:left;padding-top:20px;">
							<h:panelGrid columns="2" style="font-size:14px;text-align:left;">
								<h:outputText value="用户名："/>
								<h:outputText value="#{LookUserInfoBean.uname}" style="text-align:left;" />
								<h:outputText value="口令："/>
								<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/ModifyUserPwd.jsp" title="密码修改">
									<h:outputText value="******" />
								</h:outputLink>
								<h:outputText value="性 别：" />
								<h:outputText value="#{LookUserInfoBean.ugender}" />
								<h:outputText value="E-mail：" />
								<h:outputText value="#{LookUserInfoBean.uemail}" />
							</h:panelGrid>
						</div>
					</div>
				</h:panelGroup>
				<%@ include file="Tip.jsp" %>
			</div>
		</body>
	</html>
</f:view>