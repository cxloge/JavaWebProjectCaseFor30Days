<%@ page contentType="text/html;charset=GBK" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<html>
 <head>
  <title>A10酒店预定中心欢迎您</title>
  <link rel="stylesheet" type="text/css" href="script/main.css"/>
  <link rel="stylesheet" type="text/css" href="script/style.css"/>
  <script language="JavaScript" src="script/changePwd.js"></script>  
  <script language="JavaScript" src="script/showMsg.js"></script>
 </head>
 <body>
 <div class="MainBox">
 	<%@ include file="top.jsp" %>
 	<span style="margin-left:5px;">首页 >>  修改密码</span>
    <table class="RegBox" align="center" border="0" width="550">
    	<caption style="font-size:15px;margin-bottom:10px;">修改密码</caption>    	
       	<h:form id="changePwd" onsubmit="return checkPwd();">
       	
       	<tr>
       		<td align="right" width="100"><h:outputText value="密   码："/></td>
       		<td><h:inputSecret id="oldPwd" value="#{UCPBean.oldPwd}" styleClass="input" onblur="checkOldPwd()"/>
       		<span id="pwdMsg" class="message">请输入您用户名当前的密码</span></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="确认密码："/></td>
       		<td><h:inputSecret id="newPwd" value="#{UCPBean.newPwd}" styleClass="input" onblur="checkNewPwd()"/>
       		<span id="pwdMsg2" class="message">请输入您要设置的新密码</span></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="确认密码："/></td>
       		<td><h:inputSecret id="reNewPwd" value="#{UCPBean.reNewPwd}" styleClass="input" onblur="checkReNewPwd()"/>
       		<span id="pwdMsg3" class="message">请再次输入您设置的新密码</span></td>
       	</tr>
       	
       	<tr>
       		<td></td>
       		<td>
       			<input type="reset" value="重 置" class="button">
       			<h:commandButton value="修 改" action="#{UCPBean.changePwd}" styleClass="button"/>
       			<h:outputText value="#{UCPBean.message}" style="color:red;vertical-align:middle;"/>
       		</td>
       	</tr>
       	</h:form>
     </table>
     <%@ include file="qq.jsp" %>
 </body>
 </div>
</html>
</f:view>