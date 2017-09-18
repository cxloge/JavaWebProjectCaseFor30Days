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
    	function checkOrder(){
    		var detail = document.getElementById('orderForm:detail').value.trim();
    		if(detail==""){
    			alert("备注不得为空！！！");
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
	  		<h:outputText value="首页 >> "></h:outputText>
	  		<h:outputText value="#{AOBean.orderId}号订单详情"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">
		  	<h:dataTable value="#{AOBean.orderDetail}" var="res" 
	      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
	      		rendered="#{AOBean.size>0&&ALBean.aid!=null}"
	    	>
		        <h:column>
		            <f:facet name="header">
		                <h:outputText value="资源名称"/>
		            </f:facet>
		            <h:outputText value="#{res.rname}"/>
		        </h:column>
		        
		        <h:column>
		            <f:facet name="header">
		                <h:outputText value="所属分组"/>
		            </f:facet>
		            <h:outputText value="#{res.gname}"/>
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
    		</h:dataTable>
    		
    		<h:panelGroup rendered="#{ALBean.aid!=null}">
			    <table width="87%" border="0" style="font-size:13px;margin-top:20px;border:1px solid black;">
			    <th colspan="2" style="font-size:15px;" align="center">订单处理</th>
			    <h:form id="orderForm" onsubmit="return checkOrder();">
			    	<tr>
			    		<td width="130">&nbsp;</td>
			    		<td align="left">
			    			<h:outputText value="订单状态：" />
			    			<h:selectOneMenu value="#{AOBean.status}" styleClass="input">
			                    <f:selectItem itemLabel="预订中" itemValue="预订中"/>
			                     <f:selectItem itemLabel="预订成功" itemValue="预订成功"/>
			                      <f:selectItem itemLabel="预订失败" itemValue="预订失败"/>
			                </h:selectOneMenu>			     
			                <h:outputText value="  请选择订单处理结果"></h:outputText>           
			    		</td>
			    			
			    	</tr>
			    	
			    	<tr>
			    		<td>&nbsp;</td>
			    		<td>
			    			<h:outputText value="订单备注：" />
			    			<h:inputText id="detail" value="#{AOBean.detail}" styleClass="input"/>
			    			<h:outputText value="  输入备注，或者失败原因"></h:outputText>			    			
			    		</td>
			    	</tr>
			    	
			    	<tr>
			    		<td>&nbsp;</td>
			    		<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    			<h:commandButton value="处理订单" styleClass="button" action="#{AOBean.deal}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    			<h:commandButton type="reset" value="重置" styleClass="button"/>
			    			<h:outputText value="#{AOBean.message}" style="color:red;vertical-align:middle;"/>
			    		</td>
			    	</tr>
			    	</h:form>
			    </table>
    		</h:panelGroup>
    	</div>
  	</div>
  </body>
 </html>
 </f:view>