<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <link rel="stylesheet" type="text/css" href="script/style.css"/>
    <script language="JavaScript" src="script/adminChangePwd.js"></script>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="adminTop.jsp" %>	  	
	  	<span style="margin-left:5px;">
	  		<h:outputText value="首页 >> 修改密码"></h:outputText>	  	
	  	</span>
	  	<h:panelGroup rendered="#{ALBean.aid!=null}">
	  		<h:form id="adminChangePwd" onsubmit="return checkAdminChangePwd();">
			  	<table class="RegBox" align="center" border="0" width="500" style="margin-top:40;"
			  	 cellpadding="0" cellspacing="0">
			  		<caption style="font-size:18px;margin-bottom:20px;">修改密码</caption>			  		
			  		<tr>
			  			<td align="right"><h:outputText value="旧密码："/></td>
			  			<td>
			  				<h:inputSecret id="oldPwd" value="#{ACPBean.oldPwd}" styleClass="input"/>
			  				<h:outputText value=" 请输入要您的当前密码"/>
			  			</td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="新密码："/></td>
			  			<td>
			  				<h:inputSecret id="newPwd" value="#{ACPBean.newPwd}" styleClass="input"/>
			  				<h:outputText value=" 请输入您的新密码"/>
			  			</td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="确认新密码："/></td>
			  			<td>
			  				<h:inputSecret id="reNewPwd" value="#{ACPBean.reNewPwd}" styleClass="input"/>
			  				<h:outputText value=" 请再次输入您的新密码"/>
			  			</td>
			  		</tr>			  		
			  		<tr>
			  			<td></td>
			  			<td>
				  			<h:commandButton value="修改" styleClass="button" action="#{ACPBean.changePwd}"/>
							&nbsp;<h:commandButton value="重置" styleClass="button" type="reset"/>
							<h:outputText value="#{ACPBean.message}" style="color:red;vertical-align:middle;"/>
						</td>
			  		</tr>
			  	</table>
		  	</h:form>
	  	</h:panelGroup>
  	</div>
  	</body>
 </html>
 </f:view>