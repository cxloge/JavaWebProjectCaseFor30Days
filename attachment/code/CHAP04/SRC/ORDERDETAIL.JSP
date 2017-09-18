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
	  		<h:outputText value="#{MOBean.orderId}号订单详情"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">
	  		<h:form>
			  	<h:dataTable value="#{MOBean.orderDetail}" var="res" 
		      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
		      		rendered="#{MOBean.size>0}"	
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
			        
			        <h:column>
			            <f:facet name="header">
			                <h:outputText value="删除"/>
			            </f:facet>            
			            <h:commandLink action="#{MOBean.delete}" rendered="#{res.flag}">
			                <h:outputText value="删除"/>
			                <h:graphicImage value="images/delete.png" style="vertical-align:middle;border:0"/>  
			            </h:commandLink>
			            <h:outputText value="------" rendered="#{!res.flag}"/>
			        </h:column>
	    		</h:dataTable>
    		</h:form>
    		<center><h:outputText value="该订单信息已经全部撤销" rendered="#{MOBean.size==0}"></h:outputText></center>	
    	</div>
  	</div>
  </body>
 </html>
 </f:view>