<%@page contentType="text/html;charset=GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view> 
 <html>
  <head>
    <title>A10酒店预定中心欢迎您</title>
    <link rel="stylesheet" type="text/css" href="script/main.css"/>
    <link rel="stylesheet" type="text/css" href="script/style.css"/>
    <script language="JavaScript" src="script/calendar.js"></script>
    <script language="JavaScript" src="script/addToOrder.js">

    </script>
  </head>
  <body>
  	<div class="MainBox">
	  	<%@ include file="top.jsp" %>
	  	<span style="margin-left:5px;margin-bottom:0px;">
	  		<h:outputText value="首页 >> "></h:outputText>
	  		<h:outputText value="#{RLBean.typeName}列表"></h:outputText>
	  	</span>
	  	<div style="text-align:center;">	  	
	  	<h:dataTable value="#{RLBean.resList}" var="res" 
      		styleClass="orders" headerClass="ordersHeader" rowClasses="evenRow,oddRow"
      		rendered="#{RLBean.maxPage>0}"
    	>
        <h:column>
            <f:facet name="header">
                <h:outputText value="资源名称"/>
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
                <h:outputText value="价格/时段"/>
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
                <h:outputText value="资源状态"/>
            </f:facet>
             <h:form>
                <h:commandLink action="#{RLBean.resStatus}" target="_blank">
                    <h:outputText value="查看"/>
                    <h:graphicImage value="images/detail.png" style="vertical-align:middle;border:0"/>                   
                </h:commandLink>                
             </h:form>
        </h:column>
    </h:dataTable>

    <table class="nav" border="0" cellpadding="0" cellspacing="0">
    	<tr>
    		<td width="90">
    			共<h:outputText value="#{RLBean.maxPage}"></h:outputText>页,
    			第<h:outputText value="#{RLBean.curPage}"></h:outputText>页
    		</td>
    		<h:form rendered="#{RLBean.maxPage>0}">
    		<td width="140">    			
		         <h:outputText value="分页系数：" /> 
		         <h:selectOneMenu value="#{RLBean.span}" onchange="this.form.submit();">
		           <f:selectItems value="#{RLBean.pageSpanList}"/>
		         </h:selectOneMenu>			   	
    		</td>
    		</h:form>
    		
    		<h:form rendered="#{RLBean.maxPage>1}">
            <td width="80" align="center">
                <h:selectOneMenu value="#{RLBean.curPage}" onchange="this.form.submit();">
                    <f:selectItems value="#{RLBean.pageList}"/>
                </h:selectOneMenu>
            </td>
            </h:form>
            
            <h:form>
            <td width="150" align="center">
            	<h:outputText value="资源类别：" /> 
                <h:selectOneMenu value="#{RLBean.type}" onchange="this.form.submit();">
                    <f:selectItems value="#{RLBean.typeList}"/>
                </h:selectOneMenu>
            </td>
            </h:form>
    		
    		<h:form>
    		<td width="60">
            	<h:commandButton image="/images/pre.gif" action="#{RLBean.prePage}" 
            													rendered="#{RLBean.curPage>1}"/>            	
             </td>
             </h:form>
             
             <h:form>
             <td align="right" width="60">
                <h:commandButton image="/images/next.gif" action="#{RLBean.nextPage}"
                								 rendered="#{RLBean.maxPage>RLBean.curPage}"/>
    		</td>
    		</h:form>
    	</tr>
    </table>
    
    <table width="87%" border="0" style="font-size:13px;margin-top:20px;border:1px solid black;">
    	<th colspan="2" style="font-size:15px;" align="center">开始预订</th>
    	<h:form id="orderForm" onsubmit="return checkOrder();">
	    	<tr>
	    		<td width="70">
	    			<h:outputText value="资源编号：" />
	    		</td>
	    		<td>
	    			<h:selectOneMenu value="#{OIBean.rid}">
	                    <f:selectItems value="#{RLBean.ridList}"/>
	                </h:selectOneMenu>
	                <h:outputText value="  ----类别：#{RLBean.typeName}"></h:outputText>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>
	    			<h:outputText value="开始时间：" />
	    		</td>
	    		<td>
	    			<h:inputText id="start" value="#{OIBean.start}" styleClass="input" onclick="showCalendar('orderForm:start');" />
	    			<h:outputText value="  时间格式为 yyyy-mm-dd，如2009-02-14代表2009年2月14日"></h:outputText>
	    		</td>
	    	</tr>
	    	
	    	<tr>
	    		<td>
	    			<h:outputText value="结束时间：" />
	    		</td>
	    		<td>
	    			<h:inputText id="end" value="#{OIBean.end}" styleClass="input" onclick="showCalendar('orderForm:end');"/>
	    			<h:outputText value="  预订结束的时间，请认真填写"></h:outputText>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td></td>
	    		<td align="left">
	    			<input type="reset" value="重 置" class="button"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    			<h:commandButton value="添加到订单" action="#{OIBean.addToOrder}" styleClass="button"/>
	    		</td>
	    	</tr>
    	</h:form>
    </table>
    </div>
  	</div>
		<div id="calendar"
		style="position:absolute;height:140px;width:160px;visibility:hidden;border:1px inset #003399;" 
		onmouseover="calshow=true" onmouseout="calshow=false">
		</div>
  	</body>
 </html>
 </f:view>