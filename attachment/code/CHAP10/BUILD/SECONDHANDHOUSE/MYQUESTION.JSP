<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>我的问题</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<h:outputText value="#{MyQuestionBean.initList}" style="display:none;"/>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>我的问题" />
				</p><br/>
				<div style="border:1px solid #F7A608;width:95%;padding:10px;">
				<h:outputText value="暂无问题！" rendered="#{!MyQuestionBean.flag}"/>
					<h:form rendered="#{MyQuestionBean.flag}">
						<h:dataTable value="#{MyQuestionBean.questionList}" var="qi" width="100%" rowClasses="evenRow,oddRow" style="font-size:12px;">								
					        <h:column>
								<f:facet name="header">
									<h:outputText value="问题标题"/>
            					</f:facet>
					        	<h:commandLink value="#{qi.q_title}" action="#{MyQuestionBean.getSelectObj}"/>
					        </h:column>
					        <h:column>
					        	<f:facet name="header">
									<h:outputText value="是否回答"/>
            					</f:facet>
            					<h:outputText value="#{qi.q_flag}"/>
					        </h:column>
					        <h:column>
					        	<f:facet name="header">
									<h:outputText value="查看"/>
            					</f:facet>
            					<h:commandButton image="/images/mod.gif" action="#{MyQuestionBean.getSelectObj}"/>
					        </h:column>
					        <h:column>
					        	<f:facet name="header">
									<h:outputText value="删除"/>
            					</f:facet>
            					<h:commandButton image="/images/del.gif" action="#{MyQuestionBean.deleteSelectObj}"/>
					        </h:column>
					    </h:dataTable>
					</h:form>
				</div>
			</div>
		</body>
	</html>
</f:view>