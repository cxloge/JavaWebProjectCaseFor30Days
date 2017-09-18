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
	  		<h:outputText value="首页 >> 用户管理"></h:outputText>	  		
	  	</span>
	  	<div style="text-align:center;">
	  	<h:panelGroup rendered="#{ALBean.aid!=null}">	  	
	  	<table border="0" cellpadding="0" cellspacing="0" width="85%">
	  		<tr><h:form>
	  			<td align="right">	
	  					<h:outputText value="请输入用户名："/>  				
	  					<h:inputText value="#{ULBean.uname}"styleClass="input"/>
	  					<h:commandButton value="搜索" styleClass="an"/>	  				
	  			</td></h:form>
	  		</tr>
	  	</table>
	  	</h:panelGroup>
	  	<h:outputText value="没有用户信息可显示" rendered="#{ULBean.size<=0}"/>
	  	<h:dataTable value="#{ULBean.userList}" var="res" 
      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
      		rendered="#{ULBean.maxPage>0&&ALBean.aid!=null}"
    	>
        <h:column>
            <f:facet name="header">
                <h:outputText value="用户名"/>
            </f:facet>
            <h:outputText value="#{res.uname}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="性别"/>
            </f:facet>
            <h:outputText value="#{res.ugender}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="电子邮件"/>
            </f:facet>
            <h:outputText value="#{res.uemail}"/>
        </h:column>
        
        <h:column>
            <f:facet name="header">
                <h:outputText value="电话号码"/>
            </f:facet>
            <h:outputText value="#{res.uphone}"/>
        </h:column>              
        
         <h:column>
            <f:facet name="header">
                <h:outputText value="删除"/>
            </f:facet>
             <h:form>
                <h:commandLink action="#{ULBean.delete}">
                    <h:outputText value="删除"/> 
                    <h:graphicImage value="images/delete.png" style="vertical-align:middle;border:0"/>                          
                </h:commandLink>
             </h:form>
        </h:column>
        
    </h:dataTable>

	<h:panelGroup rendered="#{ULBean.maxPage>0&&ALBean.aid!=null}">
	    <table class="nav" border="0" cellpadding="0" cellspacing="0">
	    	<tr>
	    		<td width="90">
	    			共<h:outputText value="#{ULBean.maxPage}"></h:outputText>页,
	    			第<h:outputText value="#{ULBean.curPage}"></h:outputText>页
	    		</td>
	    		<h:form rendered="#{ULBean.maxPage>0}">
		    		<td width="140">    			
				         <h:outputText value="分页系数：" /> 
				         <h:selectOneMenu value="#{ULBean.span}" onchange="this.form.submit();">
				           <f:selectItems value="#{ULBean.pageSpanList}"/>
				         </h:selectOneMenu>			   	
		    		</td>
	    		</h:form>
	    		
	    		<h:form rendered="#{ULBean.maxPage>1}">
		            <td width="80" align="center">
		                <h:selectOneMenu value="#{ULBean.curPage}" onchange="this.form.submit();">
		                    <f:selectItems value="#{ULBean.pageList}"/>
		                </h:selectOneMenu>
		            </td>
	            </h:form>
	    		
	    		<h:form>
		    		<td width="60">    			
			    		<h:commandButton image="/images/pre.gif" action="#{ULBean.prePage}"
		                			  rendered="#{ULBean.curPage>1}"/>			            	
		            	             	
		             </td>
	             </h:form>
	             
	             <h:form>
		             <td align="right" width="60">
			    		<h:commandButton image="/images/next.gif" action="#{ULBean.nextPage}"
		                			 rendered="#{ULBean.maxPage>ULBean.curPage}"/>		                
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