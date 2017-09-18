<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <link rel="stylesheet" type="text/css" href="script/style.css"/>
    <script language="JavaScript" src="script/addRes.js"></script>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="adminTop.jsp" %>
	  	<span style="margin-left:5px;margin-bottom:0px;">
	  		<h:outputText value="首页 >> 添加资源"></h:outputText>
	  	</span>
		<h:panelGroup rendered="#{ALBean.aid!=null&&ALBean.super}">
	  		<h:form id="addRes" onsubmit="return checkAddRes();">
			  	<table class="RegBox" align="center" border="0" width="470" style="margin-top:20;">
			  		<caption style="font-size:18px;margin-bottom:20px;">添加资源</caption>			  		
			  		<tr>
			  			<td align="right"><h:outputText value="资源名称："/></td>
			  			<td width="180">
			  				<h:inputText id="rname" value="#{ARBean.rname}" styleClass="input"/>			  				
			  			</td>
			  			<td><h:outputText value=" 请输入资源的名称"/></td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="资源规格："/></td>
			  			<td>
			  				<h:inputText id="rspec" value="#{ARBean.rspec}" styleClass="input"/>			  				
			  			</td>
			  			<td><h:outputText value=" 请输入资源的规格"/></td>
			  		</tr>
			  		
					<tr>
			  			<td align="right"><h:outputText value="资源分组："/></td>
			  			<td>
			  				<h:selectOneMenu value="#{ARBean.gid}" styleClass="input">
                    			<f:selectItems value="#{ARBean.typeList}"/>
                			</h:selectOneMenu>
			  			</td>
			  			<td><h:outputText value=" 选择资源所属分组"/></td>
			  		</tr>
			  							  		
					<tr>
			  			<td align="right"><h:outputText value="资源价格："/></td>
			  			<td>
			  				<h:inputText id="rprice" value="#{ARBean.rprice}" styleClass="input"/>
			  			</td>
			  			<td><h:outputText value=" 请输入资源预订的价格"/></td>
			  		</tr>
			  					  		
			  		<tr>
			  			<td align="right"><h:outputText value="资源描述："/></td>
			  			<td>
			  				<h:inputTextarea id="rdetail" value="#{ARBean.rdetail}" styleClass="input"/>			  				
			  			</td>
			  			<td align="left"><h:outputText value=" 请输入资源描述"/></td>
			  		</tr>
			  		
			  		<tr>
			  			<td align="right"><h:outputText value="资源描述："/></td>
			  			<td>
			  				<h:selectOneMenu value="#{ARBean.rstatus}" styleClass="input">
								<f:selectItem itemLabel="空闲" itemValue="空闲"/>
								<f:selectItem itemLabel="占用" itemValue="占用"/>
							</h:selectOneMenu>
			  			</td>
			  			<td align="left"><h:outputText value=" 请输入资源描述"/></td>
			  		</tr>

			  		<tr>
			  			<td>&nbsp;</td>
			  			<td align="center">
				  			<h:commandButton value="添加" styleClass="button" action="#{ARBean.addRes}"/>
							&nbsp;<h:commandButton value="重置" styleClass="button" type="reset"/>							
						</td>
						<td>&nbsp;<h:outputText value="#{ARBean.message}" style="color:red;vertical-align:middle;"/></td>
			  		</tr>
			  	</table>
		  	</h:form>
	  	</h:panelGroup>

  	</div>
  	</body>
 </html>
 </f:view>
 
