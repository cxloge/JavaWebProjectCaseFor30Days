<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <link rel="stylesheet" type="text/css" href="script/style.css"/>
    <script language="JavaScript">
    	String.prototype.trim=function()
		{
		  return this.replace(/(^\s*)|(\s*$)/g,"");
		}
    	function checkAddGroup(){
    		var gname = document.getElementById('addGroup:gname').value.trim();
    		if(gname==""){
    			alert("分组名称不得为空");
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="adminTop.jsp" %>
	  	<span style="margin-left:5px;margin-bottom:0px;">
	  		<h:outputText value="首页 >> 分组管理"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">	  	
		
		  	<h:dataTable value="#{GLBean.groupList}" var="res" 
	      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
	      		rendered="#{GLBean.size>0&&ALBean.aid!=null}"
	    	>
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="分组编号"/>
	            </f:facet>
	            <h:outputText value="#{res.gid}"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="分组名称"/>
	            </f:facet>	            	
	            <h:outputText value="#{res.gname}"/>
	        </h:column>
	        
	        <h:column>
	            <f:facet name="header">
	                <h:outputText value="删除分组"/>
	            </f:facet>
				<h:form>
					<h:commandLink action="#{GLBean.delete}">
					    <h:outputText value="删除"/>
					    <h:graphicImage value="images/delete.png" style="vertical-align:middle;border:0"/>        
					</h:commandLink>
				</h:form>
	        </h:column>
	    </h:dataTable>
    
    <h:form id="addGroup" onsubmit="return checkAddGroup();" rendered="#{ALBean.aid!=null}">
    	<h:outputText value="请输入分组名：" style="font-size:14px;"/>
    	<h:inputText id="gname" value="#{GLBean.gname}" styleClass="input"/>&nbsp;&nbsp;&nbsp;
    	<h:commandButton value="添加分组" action="#{GLBean.addGroup}" styleClass="an"/>&nbsp;&nbsp;&nbsp;
    	<h:outputText value="#{GLBean.message}" style="color:red;vertical-align:middle;"/>
    </h:form>
    <h:outputText value="没有分组信息！！！" rendered="#{GLBean.size<=0&&ALBean.aid!=null}"/>
    </div>
  	</div>
  	</body>
 </html>
 </f:view>