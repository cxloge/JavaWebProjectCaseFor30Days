<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>StudentChangePwd.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
		<script type="text/javascript" src="images/teacher.js"></script> 
	</head>
	<body>
		<f:view>
			<h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
				<h:outputText value="请先登录"/>
			</h:outputLink>
			<h:form id="myform"
				onsubmit="return check('myform:oldpwd','请输入旧密码')&&check('myform:newpwd','请输入新密码')
			              &&check('myform:renewpwd','请再次输入新密码')&&checknewpwd('myform:newpwd')&&pwd();">
				<h:panelGrid columns="3" rendered="#{LoginBean.login}">
					<h:outputText value="我的旧密码：" styleClass="message"/>
					<h:inputSecret id="oldpwd" value="#{StudentChangePwdBean.oldpwd}" required="true"/>
					<h:message for="oldpwd" styleClass="msg"/>
					
					<h:outputText value="请输入新密码：" styleClass="message"/>
					<h:inputSecret id="newpwd" value="#{StudentChangePwdBean.newpwd}" required="true">
						<f:validateLength maximum="12" minimum="6"/>
					</h:inputSecret>
					<h:panelGroup>
						<h:message for="newpwd" styleClass="msg"/>
						<h:outputText value="密码可由大小写英文字母、数字组成，长度6－12位。" styleClass="info"/>
					</h:panelGroup>
					
					<h:outputText value="请再次输入新密码：" styleClass="message"/>
					<h:inputSecret id="renewpwd" value="#{StudentChangePwdBean.renewpwd}" required="true">
						<f:validateLength maximum="12" minimum="6"/>
					</h:inputSecret>
					<h:panelGroup>
						<h:message for="renewpwd" styleClass="msg"/>
						<h:outputText value="#{StudentChangePwdBean.different}" styleClass="msg"/>
					</h:panelGroup>
					<h:outputText value=""/>
					<h:commandButton value="确定" image="images/ok1.gif" 
					onmouseover="this.src='images/ok2.gif'" onmouseout="this.src='images/ok1.gif'" 
					onmousedown="this.src='images/ok3.gif'" onmouseup="this.src='images/ok2.gif'" 
					action="#{StudentChangePwdBean.changePwd}"/>
					<h:inputText id="result" value="#{StudentChangePwdBean.result}" style="display:none"/>
				</h:panelGrid>
			</h:form>
			<script language="JavaScript">
			function alertmsg()
			{
				var msg=document.getElementById("myform:result").value;
				if(msg!="")
				{
					alert(msg);	
				}
				
			}
			
			window.onload=alertmsg;
		</script>
		</f:view>
	</body>
</html>