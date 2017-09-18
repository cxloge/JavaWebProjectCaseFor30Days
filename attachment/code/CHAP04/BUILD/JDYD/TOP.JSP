<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
	<html>
		<head>
			<link rel="stylesheet" type="text/css" href="script/main.css"/>
			<script language="JavaScript" src="script/showMenu.js"></script>
		</head>
		<body>		
			<div style="width:100%;height:90;border:0px solid red;padding:0 0;margin-bottom:4px;">
			  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
			  		<tr>
			  			<td align="center" width="50">
			  				<img src="images/logo.gif" border="0" width="80" height="80">
			  			</td>
			  			<td width="230" valign="bottom">
			  				<font color="#C08B4B" size="10" face="隶书" >A10  酒店</font>  				
			  			</td>
			  			<td valign="bottom">
			  				<font color="#C08B4B" size="6" style="font-family:Courier;">----预定中心欢迎您</font>
			  			</td>
			  		</tr>
			  	</table>
			  	<ul>
					<li class="first">
						<h:outputLink value="index.jsp" rendered="true">
							<h:outputText value="首页"/>
						</h:outputLink>
					</li>
					<li>
						<h:outputLink value="login.jsp" rendered="#{UserLogin.usid==null}">
							<h:outputText value="登录"/>
						</h:outputLink>
					</li>
					<li>
						<h:outputLink value="reg.jsp" rendered="#{UserLogin.usid==null}">
							<h:outputText value="注册"/>
						</h:outputLink>
					</li>
					<li>
						<h:form id="Info"><h:commandLink value="修改资料" action="#{UCIBean.initial}" rendered="#{UserLogin.usid!=null}">
						</h:commandLink></h:form>						
					</li>
					<li>
						<h:outputLink value="changePwd.jsp" rendered="#{UserLogin.usid!=null}">
							<h:outputText value="修改密码"/>
						</h:outputLink>
					</li>										
					<li><a href="#" id="order" onmouseover="showMenu('order','OMENU')" onmouseout="hideMenu('OMENU')"><h:outputText value="订单处理"/></a></li>
					<li>					
						<h:form>
							<h:commandLink value="在线预定" action="#{RLBean.toOrderPage}">
							</h:commandLink>
						</h:form>
					</li>
					<!--<li><a href="#"><h:outputText value="查看资源"/></a></li>-->
					<li>
						<h:form id="logout"><h:commandLink value="注销" action="#{UserLogin.userLogout}" rendered="#{UserLogin.usid!=null}">
						</h:commandLink></h:form>
					</li>					
				</ul>
			</div>
			<div class="hidmenu" id="OMENU" style="position:absolute;visibility:hidden;" 
			 onmouseover="showMenu('order','OMENU')" onmouseout="hideMenu('OMENU')">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<h:outputLink value="nowOrder.jsp">
							<h:outputText value="当前订单"/>
						</h:outputLink>
					</td>
				</tr>
				<h:panelGroup rendered="#{UserLogin.usid!=null}">
				<tr>
					<td>
						<h:outputLink value="myOrder.jsp">
							<h:outputText value="我的订单"/>
						</h:outputLink>
					</td>
				</tr>
				</h:panelGroup>
			</table>
			</div>
		</body>
	</html>