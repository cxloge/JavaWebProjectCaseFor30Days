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
	  		<h:outputText value="首页 >> 管理员列表"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">	  	
	  
	  	<h:dataTable value="#{AListBean.adminList}" var="res" 
      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
      		rendered="#{AListBean.maxPage>0&&ALBean.aid!=null&&ALBean.super}"
    	>
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="管理员编号"/>
	            </f:facet>
	            <h:outputText value="#{res.aid}"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="管理员名"/>
	            </f:facet>
	            <h:outputText value="#{res.aname}"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="级别"/>
	            </f:facet>
	            <h:outputText value="#{res.alevel}管理员"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="删除"/>
	            </f:facet>
	            <h:form>
		            <h:commandLink action="#{AListBean.delete}" rendered="#{!res.super}">
	                	<h:outputText value="删除"/>
	                	<h:graphicImage value="images/delete.png" style="vertical-align:middle;border:0"/>        
			        </h:commandLink>
			    </h:form>
			    <h:outputText value="-----" rendered="#{res.super}"/>
	        </h:column>
			
			
    </h:dataTable>
   
    <h:panelGroup rendered="#{AListBean.maxPage>0&&ALBean.aid!=null&&ALBean.super}">
	    <table class="nav" border="0" cellpadding="0" cellspacing="0">
	    	<tr>
	    		<td width="90">
	    			<h:outputText value="共#{AListBean.maxPage}页,第#{AListBean.curPage}页"></h:outputText>
	    		</td>
	    		<h:form rendered="#{AListBean.maxPage>0}">
	    		<td width="140">    			
			         <h:outputText value="分页系数：" /> 
			         <h:selectOneMenu value="#{AListBean.span}" onchange="this.form.submit();">
			           <f:selectItems value="#{AListBean.pageSpanList}"/>
			         </h:selectOneMenu>			   	
	    		</td>
	    		</h:form>
	    		
	    		<h:form rendered="#{AListBean.maxPage>1}">
	            <td width="80" align="center">
	                <h:selectOneMenu value="#{AListBean.curPage}" onchange="this.form.submit();">
	                    <f:selectItems value="#{AListBean.pageList}"/>
	                </h:selectOneMenu>
	            </td>
	            </h:form>
	            
	    		<h:form>
		    		<td width="60">
						<h:commandButton image="/images/pre.gif" action="#{AListBean.prePage}"
		                										rendered="#{AListBean.curPage>1}"/>		            	             	
		             </td>
	             </h:form>
	             
	             <h:form>
		             <td align="right" width="60">
		                <h:commandButton image="/images/next.gif" action="#{AListBean.nextPage}" 
		                								rendered="#{AListBean.maxPage>AListBean.curPage}"/>
		    		</td>
	    		</h:form>
	    	</tr>
	    </table>
    </h:panelGroup>
 
    </div>
  	</div>
  	</body>
 </html>
 </f:view>
 
