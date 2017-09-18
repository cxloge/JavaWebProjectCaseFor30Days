<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>我的预约</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<h:outputText value="#{MyApplyInfoBean.initList}" style="display:none;"/>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>我的预约" />
				</p>
				<h:form>
				<h:dataTable value="#{MyApplyInfoBean.myApplyList}" var="ai" width="100%" rowClasses="evenRow,oddRow" columnClasses="perCol,perCol,perCol" style="font-size:12px;" rendered="#{MyApplyInfoBean.showObj}">								
			        <h:column>
			        	<f:facet name="header">
								<h:outputText value="物业地址/名称"/>
            			</f:facet>
			        	<h:commandLink value="#{ai.location}" action="#{MyApplyInfoBean.showDetail}"/>
			        </h:column>			        
			        <h:column>
			        	<f:facet name="header">
								<h:outputText value="信息类型"/>
            			</f:facet>  
			            <h:outputText value="#{ai.msgtype}"/>
			        </h:column>
			        <h:column>
			        	<f:facet name="header">
								<h:outputText value="户型"/>
            			</f:facet>  
			            <h:outputText value="#{ai.type}"/>
			        </h:column>
			        <h:column>
			        	<f:facet name="header">
								<h:outputText value="是否批准"/>
            			</f:facet>  
			            <h:outputText value="#{ai.agree}"/>
			        </h:column>
			       	<h:column>
			        	<f:facet name="header">
								<h:outputText value="删除"/>
            			</f:facet>  
			            <h:commandButton image="/images/del.gif" action="#{MyApplyInfoBean.deleteObj}"/>
			        </h:column>
			    </h:dataTable>
			    <h:outputText value="暂无信息！" rendered="#{!MyApplyInfoBean.showObj}"/>
			    </h:form>				
			</div>
		</body>
	</html>
</f:view>