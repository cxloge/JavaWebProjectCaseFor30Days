<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
	<html>
		<head>
			<title>添加管理员</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<link type="text/css" rel="stylesheet" href="css/admin.css"/>
			<script type="text/javascript" src="script/adminlogin.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/addadmin.js"></script>
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
					<h:outputText value=">>添加管理员"/>
				</p>
				<h:outputText value="请您先登录！！！" style="color:red;text-align:center;font-size:18px;" rendered="#{!AdminLoginBean.flag}" />
				<h:panelGroup rendered="#{AdminLoginBean.flag}" >
					<div style="font-size:5px;vertical-align:middle;border:1px solid #A8C29F;position:absolute;top:40%;left:25%;width:500px;height:230px;text-align:center;">
						<div style="background-color:#F7AE31;">
							<h:outputText value="添加管理员" style="text-align:center;font-size:18px;font-weight:bold;"/>
						</div><br/><br/>
						<div style="float:left;">
							<h:graphicImage value="/images/admin.png" />
						</div>
						<div style="float:left;">
							<h:form id="mf" onsubmit="JavaScript:return checkAdmin();">
								<h:panelGrid columns="2" style="font-size:14px;text-align:center;">
									<h:outputText value="用  户  名：" style="text-align:right;width:100%;"/>
									<h:panelGroup>
										<h:inputText id="aname" value="#{AddAdminBean.aname}" style="height:20px;width:150px;" required="true"/>
										<h:message for="aname" style="color:red;"/>
									</h:panelGroup>
									<h:outputText value="密    码：" style="text-align:right;width:100%;"/>
									<h:panelGroup>
										<h:inputSecret id="firstPwd" value="#{AddAdminBean.firstPwd}" style="height:20px;width:150px;" required="true"/>
										<h:message for="firstPwd" style="color:red;"/>
									</h:panelGroup>
									<h:outputText value="再次输入密码：" style="text-align:right;width:100%;"/>
									<h:panelGroup>
										<h:inputSecret id="secondPwd" value="#{AddAdminBean.secondPwd}" style="height:20px;width:150px;" required="true" />
										<h:message for="secondPwd" style="color:red;" />
									</h:panelGroup>									
									<h:outputText value="性  别：" style="text-align:right;width:100%;"/>
									<h:panelGroup style="text-align:left;">
										<h:selectOneRadio layout="lineDirection" id="agender" value="#{AddAdminBean.agender}">
											<f:selectItem itemLabel="男 " itemValue="男" />
											<f:selectItem itemLabel="女" itemValue="女" />
										</h:selectOneRadio>
									</h:panelGroup>
								</h:panelGrid>
								<h:panelGroup>
									<h:commandButton value="添加" styleClass="btn" action="#{AddAdminBean.add}" />&nbsp;&nbsp;
									<h:commandButton value="重置" styleClass="btn" type="reset" />
								</h:panelGroup>
								<h:inputText id="errMsg" value="#{AddAdminBean.errMsg}" style="display:none"/>
							</h:form>
						</div>
					</div>
					<%@ include file="Tip.jsp" %>
					<script type="text/javascript">
						function showMsg(){
							var msg = document.getElementById("mf:errMsg").value;
							if(msg.trim()!=""){
								alert(msg);
								document.getElementById("mf:errMsg").value="";
							}
						}
						window.onload=showMsg;
					</script>
				</h:panelGroup>
			</div>
		</body>
	</html>
</f:view>