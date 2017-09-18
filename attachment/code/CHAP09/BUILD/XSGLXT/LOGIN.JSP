<%@ page contentType="text/html;charset=GBK"%>			   <!-- 设置网页的编码为GBK -->
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %><!-- 引入JSF核心标记库 -->
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %><!-- 引入JSF关于HTML的标记库-->
<html><head><title>登陆页面</title>
<link type="text/css" rel="stylesheet" href="images/style.css"><!-- 引入外部css样式表 -->
<script type="text/javascript" src="images/teacher.js"></script>
</head><body topMargin=90;background-image:url(images/bg.gif);><f:view><!-- 使用JSF标签库生成登录表单-->
	<h:form id="myform" onsubmit="return checkLogin();"><h:panelGrid styleClass="panel">	
		<h:panelGrid columns="1" style= "background-image:url(images/aaa.JPG); height:389;width=641;">
		<h:outputText value="华北城市大学学生管理系统" styleClass="pname"/>
			<h:panelGrid columns="2"  style="text-align:right;width=80%;">
				<h:panelGrid columns="2" width="70%" ><h:outputText value="用户名："/>
					<h:inputText id="uid" value="#{LoginBean.uid}" required="true"/>
					<h:outputText value="密    码："/>
					<h:inputSecret id="pwd" value="#{LoginBean.pwd}" required="true"/>
					<h:outputText value="类    型："/>
					<h:selectOneRadio layout="lineDirection" value="#{LoginBean.type}">
						<f:selectItem itemLabel="普通学生" itemValue="student"/>
						<f:selectItem itemLabel="教职工" itemValue="teacher"/>
					</h:selectOneRadio><h:outputText value=""/>
					<h:panelGroup><h:message for="uid" style="color:red"/>
					<h:message for="pwd" styleClass="msg"/></h:panelGroup></h:panelGrid>
				<h:commandButton image="images/login1.gif" 
					onmouseover="this.src='images/login2.gif'" onmouseout="this.src='images/login1.gif'" 
					onmousedown="this.src='images/login3.gif'" onmouseup="this.src='images/login2.gif'" 
				action="#{LoginBean.verify}"/>	
			</h:panelGrid></h:panelGrid></h:panelGrid></h:form>	</f:view></body></html>