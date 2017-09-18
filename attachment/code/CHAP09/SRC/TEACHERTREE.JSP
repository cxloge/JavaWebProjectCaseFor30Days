<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>Tree.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
	</head>
	<body>
		<f:view>
		<h:form id="treeform" >
		<h:panelGrid columns="2" id="root" rendered="true" >
			<h:commandButton image="#{(TeacherTreeBean.root1)?'images/-.png':'images/+.png'}" 
			    id="com" value="submit" action="#{TeacherTreeBean.clickCom}"/><!-- 引进图片按钮 -->
			<h:outputLink value="TeacherWelcome.jsp" target="mainFrame" ><!-- 引进图片按钮 -->
				<h:outputText value="学生管理系统" styleClass="treefont"/></h:outputLink>		<!-- 设置超链接文本 -->
			<h:outputText value="" rendered="#{TeacherTreeBean.root1}"/>
			<h:panelGrid columns="2" id="root1" rendered="#{TeacherTreeBean.root1}">
				<h:commandButton image="#{(TeacherTreeBean.root11)?'images/-.png':'images/+.png'}" 
			        value="submit" action="#{TeacherTreeBean.clickRoot11}"/><!-- 引进图片按钮 -->
				<h:outputLink value="#"><h:outputText value="系统操作选项" styleClass="treefont"/></h:outputLink>
				<h:outputText value="" rendered="#{TeacherTreeBean.root11}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root11}"><!-- 引进图片按钮 -->
					<h:graphicImage value="images/star.gif"/><!-- 引进图片按钮 -->
					<h:outputLink value="TeacherChangePwd.jsp" target="mainFrame">
						<h:outputText value="修改密码" styleClass="treefont"/></h:outputLink><!-- 设置超链接文本 -->
				</h:panelGrid>
				<h:outputText value="" rendered="#{TeacherTreeBean.root11}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root11}">
					<h:graphicImage value="images/star.gif"/>    <!-- 引进图片按钮 -->
					<h:commandLink value="重新登录" action="#{TeacherTreeBean.reLogin}" target="_parent" styleClass="treefont"/>
						
				</h:panelGrid>
			</h:panelGrid>
			<h:outputText value="" rendered="#{TeacherTreeBean.root1}"/>
			<h:panelGrid columns="2" id="root2" rendered="#{TeacherTreeBean.root1}">
				<h:commandButton image="#{(TeacherTreeBean.root21)?'images/-.png':'images/+.png'}" 
			        value="submit" action="#{TeacherTreeBean.clickRoot21}"/>
				<h:outputLink value="#">
					<h:outputText value="学生信息管理" styleClass="treefont"/>
				</h:outputLink>
				<h:outputText value="" rendered="#{TeacherTreeBean.root21}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root21}">
					<h:graphicImage value="images/star.gif" onclick=""/>
					<h:outputLink value="AddStu.jsp" target="mainFrame">
						<h:outputText value="添加新学生" styleClass="treefont"/>
					</h:outputLink>
				</h:panelGrid>
				<h:outputText value="" rendered="#{TeacherTreeBean.root21}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root21}">
					<h:graphicImage value="images/star.gif"/>
					<h:outputLink value="TeacherSearchMsg.jsp" target="mainFrame">
						<h:outputText value="学生基本信息查询" styleClass="treefont"/>
					</h:outputLink>
				</h:panelGrid>
				
				<h:outputText value="" rendered="#{TeacherTreeBean.root21}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root21}">
					<h:graphicImage value="images/star.gif"/>
					<h:outputLink value="TeacherSearchGrade.jsp" target="mainFrame">
						<h:outputText value="学生成绩查询" styleClass="treefont"/>
					</h:outputLink>
				</h:panelGrid>
			</h:panelGrid>
			<h:outputText value="" rendered="#{TeacherTreeBean.root1}"/>
			<h:panelGrid columns="2" id="root3" rendered="#{TeacherTreeBean.root1}">
				<h:commandButton image="#{(TeacherTreeBean.root31)?'images/-.png':'images/+.png'}" 
			        value="submit" action="#{TeacherTreeBean.clickRoot31}"/>
				<h:outputLink value="#">
					<h:outputText value="课程信息管理" styleClass="treefont"/>
				</h:outputLink>
				<h:outputText value="" rendered="#{TeacherTreeBean.root31}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root31}">
					<h:graphicImage value="images/star.gif" onclick=""/>
					<h:outputLink value="TeacherManageCourse.jsp" target="mainFrame">
						<h:outputText value="选课信息管理" styleClass="treefont"/>
					</h:outputLink>
				</h:panelGrid>
				
				<h:outputText value="" rendered="#{TeacherTreeBean.root31}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root31}">
					<h:graphicImage value="images/star.gif" onclick=""/>
					<h:outputLink value="ChosingCourse.jsp" target="mainFrame">
						<h:outputText value="可选课程列表" styleClass="treefont"/>
					</h:outputLink>
				</h:panelGrid>
				
				<h:outputText value="" rendered="#{TeacherTreeBean.root31}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root31}">
					<h:graphicImage value="images/star.gif" onclick=""/>
					<h:outputLink value="WriteScore.jsp" target="mainFrame">
						<h:outputText value="课程成绩录入" styleClass="treefont"/>
					</h:outputLink>
				</h:panelGrid>
				
				<h:outputText value="" rendered="#{TeacherTreeBean.root31}"/>
				<h:panelGrid columns="2" rendered="#{TeacherTreeBean.root31}">
					<h:graphicImage value="images/star.gif" onclick=""/>
					<h:outputLink value="AddNewCourse.jsp" target="mainFrame">
						<h:outputText value="添加新课程" styleClass="treefont"/>
					</h:outputLink>
				</h:panelGrid>	
			</h:panelGrid>
		</h:panelGrid>
		</h:form>
		</f:view>
	</body>
</html>