<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <link rel="stylesheet" type="text/css" href="script/style.css"/>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="top.jsp" %>
	  	<span style="margin-left:5px;margin-bottom:0px;">
	  		<h:outputText value="首页 >> "></h:outputText>
	  		<h:outputText value="当前订单列表"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">
	  	<h:outputText value="当前订单中没有记录！！！" rendered="#{OIBean.size<=0&&!OIBean.submit}"/>
	  	<h:outputText value="#{OIBean.message}" rendered="#{OIBean.size<=0&&OIBean.submit}"/>
	  	<h:form>
	  	<h:dataTable value="#{OIBean.orderList}" var="res" 
      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
      		footerClass="ordersFooter"
      		rendered="#{OIBean.size>0}"
    	>
        <h:column>
            <f:facet name="header">
                <h:outputText value="资源名称"/>
            </f:facet>
            <h:outputText value="#{res.rname}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="开始时间"/>
            </f:facet>
            <h:outputText value="#{res.start}"/>
            <f:facet name="footer">

                	<h:commandButton value="清空订单" action="#{OIBean.removeAll}" styleClass="button"/>

            </f:facet>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="结束时间"/>
            </f:facet>
                    <h:outputText value="#{res.end}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="^_^"/>
            </f:facet>
            
                <h:commandLink actionListener="#{OIBean.remove}">
                    <h:outputText value="删除"/>
                </h:commandLink>
            
            <f:facet name="footer">
                <h:commandButton value="提交订单" action="#{OIBean.submitOrder}" styleClass="button"/>
            </f:facet>
        </h:column>

    </h:dataTable>
    </h:form>
    </div>
  	</div>
		<div id="calendar"
		style="position:absolute;height:140px;width:160px;visibility:hidden;border:1px inset #003399;" 
		onmouseover="calshow=true" onmouseout="calshow=false">
		</div>
  	</body>
 </html>
 </f:view>