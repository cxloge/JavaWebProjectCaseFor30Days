<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <script language="JavaScript" src="script/adminLogin.js"></script>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="adminTop.jsp" %>	  	
	  	<span style="margin-left:5px;">
	  		<h:outputText value="首页 >> 管理登录"></h:outputText>	  	
	  	</span>
	  	<h:panelGroup rendered="#{ALBean.aid!=null}">
		  	<div style="margin-top:100;text-align:center;">
		  		<h:outputText value="#{ALBean.aname}，欢迎进入预订管理中心" />
		  	</div>
	  	</h:panelGroup>
	  	<h:panelGroup rendered="#{ALBean.aid==null}">
	  		<h:form id="adminLogin" onsubmit="return checkAdminLogin();">
			  	<table class="RegBox" align="center" border="0" width="520" style="margin-top:40;">
			  		<caption style="font-size:18px;margin-bottom:20px;">管理登录</caption>
			  		<tr>
			  			<td align="right" width="150"><h:outputText value="输入验证码："/></td>
			       		<td>
			       			<h:inputText id="yzm" value="#{ALBean.valCode}" styleClass="yzm" />
			       			<a href="javascript:reloadImage();" title="看不清？点击换一张^_^" tabindex="100">
			       				<h:graphicImage value="/yzm.jsp" id="pic" style="vertical-align:middle;border:0"/>
							</a>
							<a href="javascript:reloadImage();" tabindex="200">
				 				<font color="#bc2931" size="2" face="宋体" title="不区分大小写">看不清楚？换张图片</font>
				 			</a>
			       		</td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="管理员名："/></td>
			  			<td>
			  				<h:inputText id="aname" value="#{ALBean.aname}" styleClass="input"/>
			  				<h:outputText value=" 请输入要登录的管理员名"/>
			  			</td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="管理员密码："/></td>
			  			<td>
			  				<h:inputSecret id="apwd" value="#{ALBean.apwd}" styleClass="input"/>
			  				<h:outputText value=" 请输入您的密码"/>
			  			</td>
			  		</tr>
			  		<tr>
			  			<td align="center" colspan="2">
				  			<h:commandButton value="登录" styleClass="button" action="#{ALBean.loginAdmin}"/>
							&nbsp;<h:commandButton value="重置" styleClass="button" type="reset"/>
							<h:outputText value="#{ALBean.message}" style="color:red;vertical-align:middle;"/>
						</td>
			  		</tr>
			  	</table>
		  	</h:form>
	  	</h:panelGroup>
  	</div>
  	</body>
 </html>
 </f:view>