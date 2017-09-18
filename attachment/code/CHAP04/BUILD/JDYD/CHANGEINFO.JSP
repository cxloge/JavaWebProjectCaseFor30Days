<%@ page contentType="text/html;charset=GBK" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<html>
 <head>
  <title>A10酒店预定中心欢迎您</title>
  <link rel="stylesheet" type="text/css" href="script/main.css"/>
  <link rel="stylesheet" type="text/css" href="script/reg.css"/>  
  <link rel="stylesheet" type="text/css" href="script/style.css"/>
  <script language="JavaScript" src="script/changeInfo.js"></script>  
  <script language="JavaScript" src="script/showMsg.js"></script>
 </head>
 <body>
 <div class="MainBox">
 	<%@ include file="top.jsp" %>
 	<span style="margin-left:5px;">首页 >>  修改资料</span>
    <table class="RegBox" align="center" border="0" width="550">
    	<caption style="font-size:15px;margin-bottom:10px;">修改资料</caption>
       	<h:form id="changeInfo" onsubmit="return checkInfo();">
       	
       	<tr>
       		<td align="right" width="150"><h:outputText value="用户名："/></td>
       		<td><h:outputText value="#{UserLogin.uname}"/></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="性   别："/></td>
       		<td style="font-size:13px;">
       			<h:selectOneRadio layout="lineDirection" value="#{UCIBean.gender}" style="font-size:13px;">
					<f:selectItem itemLabel="男" itemValue="男"/>
					<f:selectItem itemLabel="女" itemValue="女"/>
				</h:selectOneRadio>      		
       		</td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="电子邮件："/></td>
       		<td><h:inputText id="email" value="#{UCIBean.email}" styleClass="input" onblur="checkEmail()"/>
       		<span id="emailMsg" class="message">输入您的电子邮件地址</span></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="电话号码："/></td>
       		<td><h:inputText id="phone" value="#{UCIBean.phone}" styleClass="input" onblur="checkPhone()"/>
       		<span id="phoneMsg" class="message">输入您的电话号码</span></td>
       	</tr>
       	<tr>
       		<td></td>
       		<td>
       			<input type="reset" value="重 置" class="button">
       			<h:commandButton value="修 改" action="#{UCIBean.changeInfo}" styleClass="button"/>
       			<h:outputText value="#{UCIBean.message}" style="color:red;vertical-align:middle;"/>
       		</td>
       	</tr>
       	</h:form>
     </table>
     <%@ include file="qq.jsp" %>
 </body>
 </div>
</html>
</f:view>