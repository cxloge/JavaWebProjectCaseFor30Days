<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>管理员登录</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/login.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<div style="font-size:5px;vertical-align:middle;border:1px solid #A8C29F;position:absolute;top:40%;left:25%;width:500px;height:200px;text-align:center;">
					<div style="background-color:#F7AE31;">
						<h:outputText value="迅捷管理员登录" style="text-align:center;font-size:18px;font-weight:bold;"/>
					</div><br/><br/>
					<div style="float:left;">
						<h:graphicImage value="/images/login.png" />
					</div>
					<div style="float:left;">
						<h:form id="mf" onsubmit="return adminLogin();">
							<h:panelGrid columns="3" style="font-size:14px;vertical-align:middle;">
								<h:outputText value="用户名："/>
								<h:inputText id="aname" value="#{AdminLoginBean.aname}" required="true" style="height:20px;width:150px;"/>
								<h:message for="aname" style="color:red"/>
								<h:outputText value="密 码：" />
								<h:inputSecret id="apwd" value="#{AdminLoginBean.apwd}" required="true"  style="height:20px;width:150px;"/>
								<h:message for="apwd" style="color:red"/>
								<h:outputText value="验证码：" />
								<h:inputText id="ayzm" value="#{AdminLoginBean.yzm}" required="true" style="height:20px;width:150px;"/>
								<h:message for="ayzm" style="color:red"/>
							</h:panelGrid>
							<h:panelGrid columns="1" style="text-align:center;">
								<h:graphicImage alt="看不清，点击换一张" id="yzm" value="yzm.jsp" onclick="JavaScript:loadImg();" style="cursor:hand;"/>
								<h:panelGroup>
									<h:commandButton value="登录" styleClass="btn" action="#{AdminLoginBean.login}"/>&nbsp;&nbsp;						
									<h:commandButton value="重置" styleClass="btn" type="reset"/>
								</h:panelGroup>
							</h:panelGrid>
							<h:inputText id="errMsg" value="#{AdminLoginBean.errMsg}" style="display:none"/>
						</h:form>
					</div>
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
		</body>
	</html>
</f:view>