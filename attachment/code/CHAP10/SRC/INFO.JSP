<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>信息提示</title>
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
				<h:form id="mf">
					<h:inputText id="url" value="#{InfoBean.url}" style="display:none;"/>
				</h:form>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>信息提示" />
				</p>
				<br/><br/><br/>
				<h:outputText value="#{InfoBean.msg}" style="font-size:24px;" /><br/><br/><br/>
				<div id="content" style="background-color:gray;width:600px;"></div>
				<script language="JavaScript">
					var count = 4;
					function waitTime(){
						if(count!=1){
							count--;
							document.all.content.innerHTML="系统将会在"+count+"秒后自动返回！！！";
						}
						else{
							var url = document.getElementById("mf:url").value;
							window.location.href=url;
						}
						setTimeout("waitTime()",1000);
					}
					waitTime();
				</script>
			</div>
		</body>
	</html>
</f:view>