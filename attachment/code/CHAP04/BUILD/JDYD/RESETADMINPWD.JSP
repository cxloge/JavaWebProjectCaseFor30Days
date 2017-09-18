<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <link rel="stylesheet" type="text/css" href="script/style.css"/>
    <script language="JavaScript" src="script/resetAdminPwd.js"></script>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="adminTop.jsp" %>
	  	<span style="margin-left:5px;margin-bottom:0px;">
	  		<h:outputText value="首页 >> 密码重置"></h:outputText>
	  		
	  	</span>
		<h:panelGroup rendered="#{ALBean.aid!=null&&ALBean.super}">
	  		<h:form id="resetPwd" onsubmit="return checkResetPwd();">
			  	<table class="RegBox" align="center" border="0" width="520" style="margin-top:40;"
			  	 cellpadding="0" cellspacing="0">
			  		<caption style="font-size:18px;margin-bottom:20px;">重置管理员密码</caption>			  		
			  		<tr>
			  			<td align="right"><h:outputText value="管理员名："/></td>
			  			<td width="180">
			  				<h:inputText id="aname" value="#{RPBean.aname}" styleClass="input"/>			  				
			  			</td>
			  			<td><h:outputText value=" 要重置密码的管理员名"/></td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="新密码："/></td>
			  			<td>
			  				<h:inputSecret id="pwd" value="#{RPBean.newPwd}" styleClass="input"/>			  				
			  			</td>
			  			<td><h:outputText value=" 请输该管理员名的密码"/></td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="确认密码："/></td>
			  			<td>
			  				<h:inputSecret id="rePwd" value="#{RPBean.reNewPwd}" styleClass="input"/>			  				
			  			</td>
			  			<td align="left"><h:outputText value=" 再次输入密码"/></td>
			  		</tr>
			  		<tr>
			  			<td>&nbsp;</td>
			  			<td align="center">
				  			<h:commandButton value="提交" styleClass="button" action="#{RPBean.reset}"/>
							&nbsp;<h:commandButton value="重置" styleClass="button" type="reset"/>							
						</td>
						<td>&nbsp;<h:outputText value="#{RPBean.message}" style="color:red;vertical-align:middle;"/></td>
			  		</tr>
			  	</table>
		  	</h:form>
	  	</h:panelGroup>

  	</div>
  	</body>
 </html>
 </f:view>
 
