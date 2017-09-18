<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>申请查看房源列表</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/admin.css"/>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="AdminMenu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					&nbsp;&nbsp;<h:outputText value="当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/AdminIndex.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>申请查看房源列表"/>
				</p><br/>
				<h:outputText value="#{LookUserApplyBean.initList}" style="display:none;"/>
				<h:form rendered="#{LookUserApplyBean.flag}">
					<div style="width:95%;border:1px solid green;padding:2px;">
					<h:dataTable value="#{LookUserApplyBean.applyList}" var="ai" width="100%" rowClasses="evenRow,oddRow" columnClasses="perCol,perCol,perCol" style="font-size:12px;">								
				        <h:column>
				        	<f:facet name="header">
									<h:outputText value="房源位置"/>
	            			</f:facet>
				        	<h:commandLink value="#{ai.location}" action="#{LookUserApplyBean.getSelectObj}"/>
				        </h:column>
				        <h:column>
				        	<f:facet name="header">
									<h:outputText value="信息类型"/>
	            			</f:facet>  
				            <h:outputText value="#{ai.msgtype}"/>
				        </h:column>
				        <h:column>
				        	<f:facet name="header">
									<h:outputText value="详细信息"/>
	            			</f:facet>  
				            <h:commandButton image="/images/mod.gif" action="#{LookUserApplyBean.getSelectObj}"/>
				        </h:column>
				    </h:dataTable>
				    </div>
			    </h:form>
				<h:outputText value="暂无信息！" rendered="#{!LookUserApplyBean.flag}"/>
			</div>
		</body>
	</html>
</f:view>