<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
	<head>
		<title>查看租赁合同</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<link type="text/css" rel="stylesheet" href="css/admin.css"/>
			<script type="text/javascript" src="script/adminlogin.js"></script>
			<script type="text/javascript" src="script/trim.js"></script>
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/allinfo.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
	</head>
	<body>
		<div id="wrapper">
			<h:graphicImage value="/images/logo_pic.gif" />
			<%@ include file="AdminMenu.jsp" %>
			<h:outputText value="#{LookRentContractBean.initList}" style="display:none;"/>
			<p style="text-align:left;padding-top:10px;">
				&nbsp;&nbsp;<h:outputText value="当前位置："/>
				<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/AdminIndex.jsp">
					<h:outputText value="首页" />
				</h:outputLink>
				<h:outputText value=">>查看租赁合同"/>
			</p><br/>
			<div style="width:95%;border:1px solid green;padding:5px;">
				<h:form rendered="#{LookRentContractBean.flag}">
				<h:dataTable value="#{LookRentContractBean.objList}" var="cri" width="100%" rowClasses="evenRow,oddRow" columnClasses="moreCol,moreCol,moreCol,moreCol,moreCol,moreCol,moreCol" style="font-size:12px;">								
			        <h:column>
						<f:facet name="header">
							<h:outputText value="合同ID"/>
    					</f:facet>     
			        	<h:outputText value="#{cri.cr_id}"/>
			        </h:column>
			        <h:column>
						<f:facet name="header">
							<h:outputText value="租赁方"/>
    					</f:facet>     
			        	<h:outputText value="#{cri.cr_first}"/>
			        </h:column>
			        <h:column>
						<f:facet name="header">
							<h:outputText value="承租方"/>
    					</f:facet>     
			        	<h:outputText value="#{cri.cr_second}"/>
			        </h:column>
			        <h:column>
						<f:facet name="header">
							<h:outputText value="起始日期"/>
    					</f:facet>     
			        	<h:outputText value="#{cri.cr_begintime}">
			        		<f:convertDateTime dateStyle="short"/>
			        	</h:outputText>
			        </h:column>
			        <h:column>
						<f:facet name="header">
							<h:outputText value="终止日期"/>
    					</f:facet>     
			        	<h:outputText value="#{cri.cr_endtime}">
			      		  	<f:convertDateTime dateStyle="short"/>
			        	</h:outputText>
			        </h:column>
			        <h:column>
						<f:facet name="header">
							<h:outputText value="合同状态"/>
    					</f:facet>     
			        	<h:outputText value="#{cri.cr_state}"/>
			        </h:column>				        
			        <h:column>
						<f:facet name="header">
							<h:outputText value="修改合同状态"/>
    					</f:facet>
			        	<h:commandLink value="修改" action="#{LookRentContractBean.modifyState}"/>
			        </h:column>
			    </h:dataTable>
			    </h:form>
			    <h:panelGrid columns="4" style="width:100%;" rendered="#{LookRentContractBean.flag}">
			    	<h:panelGroup>
			    		<h:outputText value="当前页：第#{LookRentContractBean.nowPage}页" style="font-size:12px;"/>&nbsp;&nbsp;
			    		<h:outputText value="共#{LookRentContractBean.totalPage}页" style="font-size:12px;"/>
					</h:panelGroup>
					<h:form>
						<h:commandButton image="/images/pre.gif" action="#{LookRentContractBean.prePage}" rendered="#{LookRentContractBean.nowPage>1}"/>
						<h:outputText value="" rendered="#{LookRentContractBean.nowPage==1}"/>
					</h:form>
					<h:form>
						<h:commandButton image="/images/next.gif" action="#{LookRentContractBean.nextPage}" rendered="#{LookRentContractBean.nowPage<LookRentContractBean.totalPage}"/>
						<h:outputText value="" rendered="#{LookRentContractBean.nowPage==LookRentContractBean.totalPage}"/>
					</h:form>
					<h:form id="mf" onsubmit="JavaScript:return checkPage();">
						<h:outputText value="第" style="font-size:12px;"/>
						<h:inputText id="page" value="#{LookRentContractBean.nowPage}" style="width:20px;" onclick="JavaScript:clearPage();"/>
						<h:message for="page" style="color:red;"/>
						<h:outputText value="页" style="font-size:12px;"/>
						<h:inputText value="#{LookRentContractBean.totalPage}" id="totalPage" style="display:none;"/>
						<h:commandButton image="/images/go.gif"/>
					</h:form>
			    </h:panelGrid>
				<h:outputText value="暂无合同！" rendered="#{!LookRentContractBean.flag}"/>
			</div>
			<%@ include file="Tip.jsp" %>
		</div>
	</body>
</html>
</f:view>