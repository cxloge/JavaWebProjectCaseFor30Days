<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>新用户注册</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/reg.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="images/logo_pic.gif"/>
				<%@ include file="Menu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value="  当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>会员注册" />
				</p>
				<div>
					<h:form id="mf_reg" onsubmit="JavaScript:return check();">
						<div style="font-size:5px;vertical-align:middle;border:1px solid #A8C29F;position:absolute;width:600px;height:200px;top:40%;left:20%;text-align:center;">
							<div style="background-color:#F7AE31;">
								<h:outputText value="会员注册" style="text-align:center;font-size:18px;font-weight:bold;"/>
							</div><br/><br/>						
							<h:panelGrid columns="3">						
								<h:outputText value="用户名：" style="text-align:right;width:100%;"/>
								<h:panelGroup>
									<h:inputText id="uname" value="#{RegisterBean.uname}" style="height:20px;width:150px;"/>
									<h:message for="uname" style="color:red;" />
								</h:panelGroup>
								<h:outputText value="只能由字母(a-z)、数字(0-9)、下划线(_)或汉字构成" style="font-size:12px;color:#909090"/>
								<h:outputText value="密  码：" style="text-align:right;width:100%;"/>
								<h:panelGroup>
									<h:inputSecret id="firstPwd" value="#{RegisterBean.firstPwd}" style="height:20px;width:150px;"/>
									<h:message for="firstPwd" style="color:red;"/>
								</h:panelGroup>
								<h:outputText value="密码要至少6位以上，且不能包含空格，英文字母区分大小写" style="font-size:12px;color:#909090"/>
								<h:outputText value="确认密码：" style="text-align:right;width:100%;"/>
								<h:panelGroup>
									<h:inputSecret id="secondPwd" value="#{RegisterBean.secondPwd}" style="height:20px;width:150px;"/>
									<h:message for="secondPwd" style="color:red;"/>
								</h:panelGroup>
								<h:outputText value="密码要至少6位以上，且不能包含空格，英文字母区分大小写" style="font-size:12px;color:#909090"/>
								<h:outputText value="性  别：" style="text-align:right;width:100%;"/>
								<h:panelGroup style="text-align:left;">
									<h:selectOneRadio layout="lineDirection" id="ugender" value="#{RegisterBean.ugender}">
										<f:selectItem itemLabel="男 " itemValue="男" />
										<f:selectItem itemLabel="女" itemValue="女" />
									</h:selectOneRadio>
								</h:panelGroup>
								<h:outputText value="性别一旦确定，不可更改" style="font-size:12px;color:#909090"/>
								<h:outputText value="E-mail：" style="text-align:right;width:100%;"/>
								<h:inputText id="uemail" value="#{RegisterBean.uemail}" style="height:20px;width:150px;" />
								<h:outputText value="请输入有效的电子邮件地址，以确保能收到信息" style="font-size:12px;color:#909090"/>
							</h:panelGrid>
							<h:panelGroup style="padding:20px;">
								<h:commandButton value="注册" styleClass="btn" action="#{RegisterBean.register}" />&nbsp;&nbsp;
								<h:commandButton value="重置" styleClass="btn" type="reset"/>
							</h:panelGroup><br/><br/>
							<h:inputText id="errMsg" value="#{RegisterBean.errMsg}" style="display:none"/>
						</div>
					</h:form>				
				</div>
				<%@ include file="Tip.jsp" %>
			</div>
			<script type="text/javascript">
				function showMsg(){
					var msg = document.getElementById("mf_reg:errMsg").value;
					if(msg.trim()!=""){
						alert(msg);
					}
				}
				window.onload=showMsg;
			</script>
		</body>
	</html>
</f:view>