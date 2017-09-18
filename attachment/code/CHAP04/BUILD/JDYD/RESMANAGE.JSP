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
	  		<h:outputText value="首页 >> 资源列表"></h:outputText>	  		
	  	</span>
	  	<div style="text-align:center;">
	  	<h:panelGroup rendered="#{ALBean.aid!=null&&ALBean.super}">	  	
	  	<table border="0" cellpadding="0" cellspacing="0" width="85%">
	  		<tr><h:form>
	  			<td align="right">	
	  					<h:outputText value="请输入资源名称："/>  				
	  					<h:inputText value="#{RMBean.rname}"styleClass="input"/>
	  					<h:commandButton value="搜索" action="#{RMBean.search}" styleClass="an"/>	  				
	  			</td></h:form>
	  		</tr>
	  	</table>	  	
	  	</h:panelGroup>
	  	<h:outputText value="没有资源可显示" rendered="#{RMBean.size<=0}"/>
	  	<h:dataTable value="#{RMBean.resList}" var="res" 
      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
      		rendered="#{RMBean.maxPage>0&&ALBean.aid!=null&&ALBean.super}"
    	>
        <h:column>
            <f:facet name="header">
                <h:outputText value="名称"/>
            </f:facet>
            <h:outputText value="#{res.rname}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="规格"/>
            </f:facet>
            <h:outputText value="#{res.rspec}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="价格"/>
            </f:facet>
            <h:outputText value="#{res.rprice}￥"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="描述"/>
            </f:facet>
            <h:outputText value="#{res.rdetail}"/>
        </h:column>              
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="状态"/>
            </f:facet>
             <h:form>
                <h:commandLink action="#{RMBean.resStatus}" target="_blank">
                    <h:outputText value="查看"/>
                    <h:graphicImage value="images/detail.png" style="vertical-align:middle;border:0"/>                   
                </h:commandLink>
             </h:form>
        </h:column>
        
         <h:column>
            <f:facet name="header">
                <h:outputText value="删除"/>
            </f:facet>
             <h:form>
                <h:commandLink action="#{RMBean.delete}">
                    <h:outputText value="删除"/>
                    <h:graphicImage value="images/delete.png" style="vertical-align:middle;border:0"/>                      
                </h:commandLink>
             </h:form>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="编辑"/>
            </f:facet>
             <h:form>
                <h:commandLink action="#{RMBean.edit}" target="_blank">
                    <h:outputText value="编辑"/>
                    <h:graphicImage value="images/edit.png" style="width:15;height:15;svertical-align:middle;border:0"/>  
                </h:commandLink>
             </h:form>
        </h:column>
    </h:dataTable>

	<h:panelGroup rendered="#{RMBean.maxPage>0&&ALBean.aid!=null&&ALBean.super}">
    <table class="nav" border="0" cellpadding="0" cellspacing="0">
    	<tr>
    		<td width="90">
    			共<h:outputText value="#{RMBean.maxPage}"></h:outputText>页,
    			第<h:outputText value="#{RMBean.curPage}"></h:outputText>页
    		</td>
    		<h:form rendered="#{RMBean.maxPage>0}">
    		<td width="140">    			
		         <h:outputText value="分页系数：" /> 
		         <h:selectOneMenu value="#{RMBean.span}" onchange="this.form.submit();">
		           <f:selectItems value="#{RMBean.pageSpanList}"/>
		         </h:selectOneMenu>			   	
    		</td>
    		</h:form>
    		
    		<h:form rendered="#{RMBean.maxPage>1}">
            <td width="80" align="center">
                <h:selectOneMenu value="#{RMBean.curPage}" onchange="this.form.submit();">
                    <f:selectItems value="#{RMBean.pageList}"/>
                </h:selectOneMenu>
            </td>
            </h:form>
            
            <h:form>
            <td width="150" align="center">
            	<h:outputText value="资源类别：" /> 
                <h:selectOneMenu value="#{RMBean.type}" onchange="this.form.submit();">
                    <f:selectItems value="#{RMBean.typeList}"/>
                </h:selectOneMenu>
            </td>
            </h:form>
    		
    		<h:form>
    		<td width="60">    			
            	<h:commandButton image="/images/pre.gif" action="#{RMBean.prePage}"
		                			 rendered="#{RMBean.curPage>1}"/>             	
             </td>
             </h:form>
             
             <h:form>
             <td align="right" width="60">
			    <h:commandButton image="/images/next.gif" action="#{RMBean.nextPage}"
		                			 rendered="#{RMBean.maxPage>RMBean.curPage}"/>
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