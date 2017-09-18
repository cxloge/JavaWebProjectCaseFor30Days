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
	  		<h:outputText value="我的订单"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">
	  	<h:outputText value="您的订单中没有记录" rendered="#{MOBean.maxPage<=0}"/>
	  
	  	<h:dataTable value="#{MOBean.myOrderList}" var="res" 
      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
      		footerClass="ordersFooter"
      		rendered="#{MOBean.maxPage>0}"
    	>
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="订单编号"/>
	            </f:facet>
	            <h:outputText value="#{res.OId}"/>
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
	                <h:outputText value="撤销订单"/>
	            </f:facet>
	           	<h:form rendered="#{res.flag}">
	                <h:commandLink action="#{MOBean.cancle}">
	                    <h:outputText value="撤销"/>
	                </h:commandLink>
	            </h:form>
	            <h:outputText value="------" rendered="#{!res.flag}"/>
	        </h:column>
			
			<h:column>
	            <f:facet name="header">
	                <h:outputText value="查看详情"/>
	            </f:facet>
	            <h:form>
	                <h:commandLink action="#{MOBean.detail}" target="_blank">
	                    <h:outputText value="查看"/>	                    	
	                    <h:graphicImage value="images/detail.png" style="vertical-align:middle;border:0"/>
	                </h:commandLink>
	            </h:form>
	        </h:column>
    </h:dataTable>
   
    <h:panelGroup rendered="#{MOBean.maxPage>0}">
	    <table class="nav" border="0" cellpadding="0" cellspacing="0">
	    	<tr>
	    		<td width="90">
	    			<h:outputText value="共#{MOBean.maxPage}页,第#{MOBean.curPage}页"></h:outputText>
	    		</td>
	    		<h:form rendered="#{MOBean.maxPage>0}">
	    		<td width="140">    			
			         <h:outputText value="分页系数：" /> 
			         <h:selectOneMenu value="#{MOBean.span}" onchange="this.form.submit();">
			           <f:selectItems value="#{MOBean.pageSpanList}"/>
			         </h:selectOneMenu>			   	
	    		</td>
	    		</h:form>
	    		
	    		<h:form rendered="#{MOBean.maxPage>1}">
	            <td width="80" align="center">
	                <h:selectOneMenu value="#{MOBean.curPage}" onchange="this.form.submit();">
	                    <f:selectItems value="#{MOBean.pageList}"/>
	                </h:selectOneMenu>
	            </td>
	            </h:form>
	            
	    		<h:form>
		    		<td width="60">
		            	<h:commandButton image="/images/pre.gif" action="#{MOBean.prePage}"
                								 rendered="#{MOBean.curPage>1}"/>             	
		             </td>
	             </h:form>
	             
	             <h:form>
		             <td align="right" width="60">
		                <h:commandButton image="/images/next.gif" action="#{MOBean.nextPage}"
                								 rendered="#{MOBean.maxPage>MOBean.curPage}"/>
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
 
