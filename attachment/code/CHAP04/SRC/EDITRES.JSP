<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <link rel="stylesheet" type="text/css" href="script/style.css"/>
    <script language="JavaScript" src="script/eidtRes.js"></script>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="adminTop.jsp" %>
	  	<span style="margin-left:5px;margin-bottom:0px;">
	  		<h:outputText value="首页 >> 编辑资源"></h:outputText>
	  	</span>
		<h:panelGroup rendered="#{ALBean.aid!=null&&ALBean.super}">
	  		<h:form id="editRes" onsubmit="return checkEditRes();">
			  	<table class="RegBox" align="center" border="0" width="470" style="margin-top:20;">
			  		<caption style="font-size:18px;margin-bottom:20px;">编辑资源</caption>			  		
			  		<tr>
			  			<td align="right"><h:outputText value="资源名称："/></td>
			  			<td width="180">
			  				<h:inputText id="rname" value="#{ERBean.rname}" styleClass="input"/>			  				
			  			</td>
			  			<td><h:outputText value=" 请输入资源的名称"/></td>
			  		</tr>
			  		<tr>
			  			<td align="right"><h:outputText value="资源规格："/></td>
			  			<td>
			  				<h:inputText id="rspec" value="#{ERBean.rspec}" styleClass="input"/>			  				
			  			</td>
			  			<td><h:outputText value=" 请输入资源的规格"/></td>
			  		</tr>
			  		
					<tr>
			  			<td align="right"><h:outputText value="资源分组："/></td>
			  			<td>
			  				<h:selectOneMenu value="#{ERBean.gid}" styleClass="input">
                    			<f:selectItems value="#{ARBean.typeList}"/>
                			</h:selectOneMenu>
			  			</td>
			  			<td><h:outputText value=" 选择资源所属分组"/></td>
			  		</tr>
			  							  		
					<tr>
			  			<td align="right"><h:outputText value="资源价格："/></td>
			  			<td>
			  				<h:inputText id="rprice" value="#{ERBean.rprice}" styleClass="input"/>
			  			</td>
			  			<td><h:outputText value=" 请输入资源预订的价格"/></td>
			  		</tr>
			  					  		
			  		<tr>
			  			<td align="right"><h:outputText value="资源描述："/></td>
			  			<td>
			  				<h:inputTextarea id="rdetail" value="#{ERBean.rdetail}" styleClass="input"/>			  				
			  			</td>
			  			<td align="left"><h:outputText value=" 请输入资源描述"/></td>
			  		</tr>
			  		
			  		<tr>
			  			<td align="right"><h:outputText value="资源描述："/></td>
			  			<td>
			  				<h:selectOneMenu value="#{ERBean.rstatus}" styleClass="input">
								<f:selectItem itemLabel="空闲" itemValue="空闲"/>
								<f:selectItem itemLabel="占用" itemValue="占用"/>
							</h:selectOneMenu>
			  			</td>
			  			<td align="left"><h:outputText value=" 请输入资源描述"/></td>
			  		</tr>

			  		<tr>
			  			<td>&nbsp;</td>
			  			<td align="center">
				  			<h:commandButton value="保存" styleClass="button" action="#{ERBean.editRes}"/>
							&nbsp;<h:commandButton value="重置" styleClass="button" type="reset"/>							
						</td>
						<td>&nbsp;<h:outputText value="#{ERBean.message}" style="color:red;vertical-align:middle;"/></td>
			  		</tr>
			  	</table>
		  	</h:form>
	  	</h:panelGroup>
  	</div>
  	</body>
 </html>
 </f:view>
 
