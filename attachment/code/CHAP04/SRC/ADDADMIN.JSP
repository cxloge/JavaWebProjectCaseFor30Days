<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <link rel="stylesheet" type="text/css" href="script/style.css"/>
    <script language="JavaScript" src="script/addAdmin.js"></script>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="adminTop.jsp" %>
	  	<span style="margin-left:5px;margin-bottom:0px;">
	  		<h:outputText value="首页 >> 添加管理员"></h:outputText>
	  		
	  	</span>
		<h:panelGroup rendered="#{ALBean.aid!=null&&ALBean.super}">
	  		<h:form id="addAdmin" onsubmit="return checkAddAdmin();">
			  	<table class="RegBox" align="center" border="0" width="520" style="margin-top:40;">
			  		<caption style="font-size:18px;margin-bottom:20px;">添加管理员</caption>			  		
			  		<tr>
			  			<td align="right"><h:outputText value="管理员名："/></td>
			  			<td width="180">
			  				<h:inputText id="aname" value="#{AABean.aname}" styleClass="input"/>			  				
			  			</td>
			  			<td><h:outputText value=" 请输入要添加的管理员名"/></td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="管理员密码："/></td>
			  			<td>
			  				<h:inputSecret id="pwd" value="#{AABean.pwd}" styleClass="input"/>			  				
			  			</td>
			  			<td><h:outputText value=" 请输该管理员名的密码"/></td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="确认密码："/></td>
			  			<td>
			  				<h:inputSecret id="rePwd" value="#{AABean.rePwd}" styleClass="input"/>			  				
			  			</td>
			  			<td align="left"><h:outputText value=" 再次输入密码"/></td>
			  		</tr>
			  		<tr>
			  			<td>&nbsp;</td>
			  			<td align="center">
				  			<h:commandButton value="添加" styleClass="button" action="#{AABean.addAdmin}"/>
							&nbsp;<h:commandButton value="重置" styleClass="button" type="reset"/>							
						</td>
						<td>&nbsp;<h:outputText value="#{AABean.message}" style="color:red;vertical-align:middle;"/></td>
			  		</tr>
			  	</table>
		  	</h:form>
	  	</h:panelGroup>

  	</div>
  	</body>
 </html>
 </f:view>