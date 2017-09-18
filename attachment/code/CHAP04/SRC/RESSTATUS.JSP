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
	  	<%@ include file="adminTop.jsp" %>
	  	<span style="margin-left:5px;margin-bottom:0px;">
	  		<h:outputText value="首页 >> #{RMBean.rname}资源状态"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">
	  	<h:outputText value="该资源目前没有订单，可以预订" rendered="#{RMBean.size<=0}"/>
	  	<h:dataTable value="#{RMBean.orderList}" var="res" style="margin-top:20px;" 
      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
      		footerClass="ordersFooter"
      		rendered="#{RMBean.size>0}"
    	>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="开始时间"/>
            </f:facet>
            <h:outputText value="#{res.start}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="结束时间"/>
            </f:facet>
                    <h:outputText value="#{res.end}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="状态"/>
            </f:facet>
            <h:outputText value="#{res.status}"/>
        </h:column>
    </h:dataTable>
    </div>
  	</div>
  	</body>
 </html>
 </f:view>