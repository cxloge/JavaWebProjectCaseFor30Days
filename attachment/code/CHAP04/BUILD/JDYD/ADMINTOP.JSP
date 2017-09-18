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
		  			<td width="290" valign="bottom">
		  				<font color="#C08B4B" size="10" face="隶书" >A10国际酒店</font>  				
		  			</td>
		  			<td valign="bottom">
		  				<font color="#C08B4B" size="6" style="font-family:Courier;">----预定管理中心欢迎您</font>
		  			</td>
		  		</tr>
		  	</table>
		  	<ul>
				<li class="first">
					<h:outputLink value="adminIndex.jsp" rendered="true">
						<h:outputText value="登录"/>
					</h:outputLink>
				</li>
				
				<li>
					<h:outputLink value="adminChangePwd.jsp" rendered="#{ALBean.aid!=null}">
						<h:outputText value="修改密码"/>
					</h:outputLink>
				</li>
				
				<li>					
					<h:outputLink value="#" id="admin" onmouseover="showMenu('admin','AMENU')" 
						onmouseout="hideMenu('AMENU')" rendered="#{ALBean.aid!=null&&ALBean.super}">
						<h:outputText value="管理员管理"/>
					</h:outputLink>
				</li>
				
				<li>
					<h:form>
		                <h:commandLink action="#{GLBean.initialGroup}" rendered="#{ALBean.aid!=null&&ALBean.super}">
		                    <h:outputText value="分组管理"/>	                    	
		                </h:commandLink>
		            </h:form>
				</li>
				
				<li>					
					<h:outputLink value="#" id="resMenu" onmouseover="showMenu('resMenu','RMENU')" 
						onmouseout="hideMenu('RMENU')" rendered="#{ALBean.aid!=null&&ALBean.super}">
						<h:outputText value="资源管理"/>
					</h:outputLink>
				</li>
				
				<li>
					<h:outputLink value="userManage.jsp" rendered="#{ALBean.aid!=null}">
						<h:outputText value="用户管理"/>
					</h:outputLink>
				</li>
				
				<li>					
					<h:outputLink value="orderManage.jsp" rendered="#{ALBean.aid!=null}">
						<h:outputText value="订单管理"/>
					</h:outputLink>
				</li>								
				
				<li>
					<h:form id="logout"><h:commandLink value="注销" action="#{ALBean.adminLogout}" rendered="#{ALBean.aid!=null}">
					</h:commandLink></h:form>
				</li>
			</ul>
		</div>
		<!--管理员管理下拉菜单-->
		<div class="hidmenu" id="AMENU" style="position:absolute;visibility:hidden;" 
			 onmouseover="showMenu('admin','AMENU')" onmouseout="hideMenu('AMENU')">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<h:outputLink value="addAdmin.jsp">
							<h:outputText value="添加管理员"/>
						</h:outputLink>
					</td>
				</tr>
				<tr>
					<td>
						<h:outputLink value="adminList.jsp">
							<h:outputText value="管理员列表"/>
						</h:outputLink>
					</td>
				</tr>
				<tr>
					<td>
						<h:outputLink value="resetAdminPwd.jsp">
							<h:outputText value="重置密码"/>
						</h:outputLink>
					</td>
				</tr>
			</table>
		</div>
		
		<!--资源管理下拉菜单-->
		<div class="hidmenu" id="RMENU" style="position:absolute;visibility:hidden;" 
			 onmouseover="showMenu('resMenu','RMENU')" onmouseout="hideMenu('RMENU')">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<h:form>
						<td>						
							<h:commandLink value="资源列表" action="#{RMBean.toResPage}">
							</h:commandLink>						
						</td>
					</h:form>
				</tr>
				<tr>
					<td>
						<h:outputLink value="addRes.jsp">
							<h:outputText value="添加资源"/>
						</h:outputLink>
					</td>
				</tr>			
			</table>
		</div>
		

	</body>
</html>