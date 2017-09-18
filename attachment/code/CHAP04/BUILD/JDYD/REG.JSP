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
  <script language="JavaScript" src="script/reg.js"></script>  
  <script language="JavaScript" src="script/showMsg.js"></script>
 </head>
 <body>
 <div class="MainBox">
 	<%@ include file="top.jsp" %>
 	<span style="margin-left:5px;">首页 >>  新用户注册</span>
    <table class="RegBox" align="center" border="0" width="750">
    	<caption style="font-size:15px;margin-bottom:10px;">新用户注册</caption>    	
       	<h:form id="regform" onsubmit="return checkReg();">
       	<tr>
       		<td align="right" width="150"><h:outputText value="输入验证码："/></td>
       		<td>
       			<h:inputText id="yzm" value="#{RegBean.valCode}" styleClass="yzm" onblur="checkValCode()"/>
       			<a href="javascript:reloadImage();" title="看不清？点击换一张^_^" tabindex="100">
       				<h:graphicImage value="/yzm.jsp" id="pic" style="vertical-align:middle;border:0"/>
				</a>
				<a href="javascript:reloadImage();" tabindex="200">
	 				<font color="#bc2931" size="2" face="宋体" title="不区分大小写">看不清楚？换张图片</font>
	 			</a>
	 			<span id="codeMsg" class="message"></span>
       		</td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="用户名："/></td>
       		<td><h:inputText id="uname" value="#{RegBean.uname}" styleClass="input" onblur="checkUname()"/>
       		<span id="unameMsg" class="message">用户名可以由英文字母、数字等字符组成，长度不得小于3位。</span></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="密   码："/></td>
       		<td><h:inputSecret id="pwd" value="#{RegBean.pwd}" styleClass="input" onblur="checkPwd()"/>
       		<span id="pwdMsg" class="message">密码可以由大小写英文字母、数字组成，长度不得小于6位。</span></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="确认密码："/></td>
       		<td><h:inputSecret id="rePwd" value="#{RegBean.rePwd}" styleClass="input" onblur="checkPwd2()"/>
       		<span id="pwdMsg2" class="message">重新输入您的密码</span></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="性   别："/></td>
       		<td style="font-size:13px;">
       			<h:selectOneRadio layout="lineDirection" value="#{RegBean.gender}" style="font-size:13px;">
					<f:selectItem itemLabel="男" itemValue="男"/>
					<f:selectItem itemLabel="女" itemValue="女"/>
				</h:selectOneRadio>
       		</td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="电子邮件："/></td>
       		<td><h:inputText id="email" value="#{RegBean.email}" styleClass="input" onblur="checkEmail()"/>
       		<span id="emailMsg" class="message">输入您的电子邮件地址</span></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="电话号码："/></td>
       		<td><h:inputText id="phone" value="#{RegBean.phone}" styleClass="input" onblur="checkPhone()"/>
       		<span id="phoneMsg" class="message">输入您的电话号码</span></td>
       	</tr>
       	<tr>
       		<td></td>
       		<td>
       			<input type="reset" value="重 置" class="button">
       			<h:commandButton value="注 册" action="#{RegBean.userReg}" styleClass="button"/>
       			<h:outputText value="#{RegBean.message}" style="color:red;vertical-align:middle;"/>
       		</td>
       	</tr>
       	</h:form>
     </table>
     <%@ include file="qq.jsp" %>
 </body>
 </div>
</html>
</f:view>