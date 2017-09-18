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
	  		<h:outputText value="首页 >> 订单管理"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">
	  	<h:panelGroup rendered="#{ALBean.aid!=null}">	  	
	  	<table border="0" cellpadding="0" cellspacing="0" width="85%">
	  		<tr><h:form>
	  			<td align="right">	
	  					<h:outputText value="请输入订单编号："/>  				
	  					<h:inputText value="#{OLBean.oid}"styleClass="input"/>
	  					<h:commandButton value="搜索" styleClass="an"/>	  				
	  			</td></h:form>
	  		</tr>
	  	</table>
	  	</h:panelGroup>
	  	
	  	
	  	<h:outputText value="订单中没有记录" rendered="#{OLBean.maxPage<=0}"/>
	  
	  	<h:dataTable value="#{OLBean.orderList}" var="res" 
      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
      		rendered="#{OLBean.maxPage>0&&ALBean.aid!=null}"
    	>
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="订单编号"/>
	            </f:facet>
	            <h:outputText value="#{res.OId}"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="提交人"/>
	            </f:facet>
	            <h:outputText value="#{res.uname}"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="提交时间"/>
	            </f:facet>
	            <h:outputText value="#{res.OTime}"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="订单状态"/>
	            </f:facet>
	            <h:outputText value="#{res.OStatus}"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="备注"/>
	            </f:facet>
	            <h:outputText value="#{res.ODetail}"/>
	        </h:column>
			
			<h:column>
	            <f:facet name="header">
	                <h:outputText value="查看详情"/>
	            </f:facet>
	            <h:form>
	                <h:commandLink action="#{OLBean.detail}" target="_blank">
	                    <h:outputText value="查看"/>
	                    <h:graphicImage value="images/detail.png" style="vertical-align:middle;border:0"/>	                    	
	                </h:commandLink>
	            </h:form>
	        </h:column>
    </h:dataTable>
   
    <h:panelGroup rendered="#{OLBean.maxPage>0&&ALBean.aid!=null}">
	    <table class="nav" border="0" cellpadding="0" cellspacing="0">
	    	<tr>
	    		<td width="90">
	    			<h:outputText value="共#{OLBean.maxPage}页,第#{OLBean.curPage}页"></h:outputText>
	    		</td>
	    		<h:form rendered="#{OLBean.maxPage>0}">
	    		<td width="140">    			
			         <h:outputText value="分页系数：" /> 
			         <h:selectOneMenu value="#{OLBean.span}" onchange="this.form.submit();">
			           <f:selectItems value="#{OLBean.pageSpanList}"/>
			         </h:selectOneMenu>			   	
	    		</td>
	    		</h:form>
	    		
	    		<h:form rendered="#{OLBean.maxPage>1}">
	            <td width="80" align="center">
	                <h:selectOneMenu value="#{OLBean.curPage}" onchange="this.form.submit();">
	                    <f:selectItems value="#{OLBean.pageList}"/>
	                </h:selectOneMenu>
	            </td>
	            </h:form>
	            
	    		<h:form>
		    		<td width="60">    			
		         		<h:commandButton image="/images/pre.gif" action="#{OLBean.prePage}"
		                			 							rendered="#{OLBean.curPage>1}"/>
		            	            	
		             </td>
	             </h:form>
	             
	             <h:form>
		             <td align="right" width="60">             
		             <h:commandButton image="/images/next.gif" action="#{OLBean.nextPage}"
		                			 rendered="#{OLBean.maxPage>OLBean.curPage}"/>
		    		</td>
	    		</h:form>
	    	</tr>
	    </table>
    </h:panelGroup>
    
    
    
    </div>
  	</div>
		<div id="calendar"
		style="position:absolute;height:140px;width:160px;visibility:hidden;border:1px inset #003399;" 
		onmouseover="calshow=true" onmouseout="calshow=false">
		</div>
  	</body>
 </html>
 </f:view>
 
