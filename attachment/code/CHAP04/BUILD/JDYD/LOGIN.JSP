<%@ page contentType="text/html;charset=GBK" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<html>
 <head>
  <title>A10酒店预定中心欢迎您</title>
  <link rel="stylesheet" type="text/css" href="script/main.css"/>
  <link rel="stylesheet" type="text/css" href="script/style.css"/>
  <script language="JavaScript" src="script/showMsg.js"></script>
  <script language="JavaScript" src="script/login.js"></script>
 </head>
 <body>
 <div class="MainBox">
 	<%@ include file="top.jsp" %>
 	<span style="margin-left:5px;">首页 >>  用户登录</span>
    <table class="RegBox" align="center" border="0" width="750">
    	<caption style="font-size:15px;margin-bottom:10px;">用户登录</caption>
       	<h:form id="loginform" onsubmit="return checkLogin();">
       	<tr>
       		<td align="right" width="150"><h:outputText value="输入验证码："/></td>
       		<td>
       			<h:inputText id="yzm" value="#{UserLogin.valCode}" styleClass="yzm" />
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
       		<td><h:inputText id="uname" value="#{UserLogin.uname}" styleClass="input"/>
       		<span class="message">请输入您在本酒店注册的用户名 
       				<h:outputLink value="reg.jsp" rendered="true" tabindex="100">
						<h:outputText value="没有用户名？点击立即注册"/>
					</h:outputLink>
       		</span></td>
       	</tr>
       	
       	<tr>
       		<td align="right"><h:outputText value="密   码："/></td>
       		<td><h:inputSecret id="pwd" value="#{UserLogin.pwd}" styleClass="input"/>
       		<span id="pwdMsg" class="message">请输入您的密码</span></td>
       	</tr>       	
       
       	<tr>
       		<td></td>
       		<td>
       			<input type="reset" value="请 空" class="button">
       			<h:commandButton value="登 录" action="#{UserLogin.loginUser}" styleClass="button"/>
       			<h:outputText value="#{UserLogin.message}" style="color:red;vertical-align:middle;"/>
       		</td>
       	</tr>
       	</h:form>
     </table>
     <%@ include file="qq.jsp" %>
 </body>
 </div>
</html>
</f:view>