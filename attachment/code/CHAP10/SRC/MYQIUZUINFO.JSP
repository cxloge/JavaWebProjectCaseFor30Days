<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
		<head>
			<title>求租信息</title>
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
				<h:outputText value="#{MyQiuZuInfoBean.initList}" style="display:none;"/>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>求租信息" />
				</p>
				<h:outputText value="暂无信息！" rendered="#{!MyQiuZuInfoBean.flag}" style="color:red;font-size:25px;"/>
				<div>
					<h:form rendered="#{MyQiuZuInfoBean.flag}">
						<h:dataTable value="#{MyQiuZuInfoBean.rentList}" var="ri" width="100%" rowClasses="evenRow,oddRow" columnClasses="moreCol,moreCol,moreCol,moreCol,moreCol,moreCol,moreCol" style="font-size:12px;">								
					        <h:column>
								<f:facet name="header">
									<h:outputText value="物业地址/名称"/>
            					</f:facet>     
					        	<h:commandLink value="#{ri.r_location}" action="#{MyQiuZuInfoBean.getSelectObj}"/>
					        </h:column>
					        <h:column>
								<f:facet name="header">
									<h:outputText value="户型"/>
            					</f:facet>  
					            <h:outputText value="#{ri.r_type}"/>
					        </h:column>
					        <h:column>
								<f:facet name="header">
									<h:outputText value="楼层"/>
            					</f:facet>
					            <h:outputText value="#{ri.r_high}"/>
					        </h:column>
					        <h:column>
					        	<f:facet name="header">
									<h:outputText value="建筑面积(m2)"/>
            					</f:facet>
					            <h:outputText value="#{ri.r_area}"/>
					        </h:column>
					        <h:column>
					        	<f:facet name="header">
									<h:outputText value="月租(元)"/>
            					</f:facet>
					        	<h:outputText value="#{ri.r_price}"/>
					        </h:column>
					        <h:column>
					        	<f:facet name="header">
									<h:outputText value="修改"/>
            					</f:facet>
            					<h:commandButton image="/images/mod.gif" action="#{MyQiuZuInfoBean.modifyRentObj}"/>
					        </h:column>
					        <h:column>
					        	<f:facet name="header">
									<h:outputText value="删除"/>
            					</f:facet>
            					<h:commandButton image="/images/del.gif" action="#{MyQiuZuInfoBean.deleteRentObj}"/>
					        </h:column>
					    </h:dataTable>
					</h:form>
				</div>			
			</div>
		</body>
	</html>
</f:view>