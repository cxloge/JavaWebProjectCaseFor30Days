<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>ChosingCourse.jsp</title>
		<link style="text/css" rel="stylesheet" href="images/style.css">
		<script type="text/javascript" src="images/teacher.js"></script> 
	</head>
	<body>
		<f:view>
			<h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
				<h:outputText value="请先登录"/>
			</h:outputLink>
			<h:form styleClass="centers" rendered="#{LoginBean.login&&ChosingCourseBean.size!=0}"><!-- 设置整体表格居中 -->
				<h:commandButton image="images/stop1.gif" 
					onmouseover="this.src='images/stop2.gif'" onmouseout="this.src='images/stop1.gif'" 
					onmousedown="this.src='images/stop3.gif'" onmouseup="this.src='images/stop2.gif'" 
				action="#{ChosingCourseBean.stop}" onclick="return confirm('确认要停止选课吗?');" 
				rendered="#{LoginBean.login}"/></h:form>
			<h:panelGrid styleClass="panel">
			<h:outputText value="暂无可选课程信息" styleClass="tablehead" 
					rendered="#{LoginBean.login&&ChosingCourseBean.size==0}"/>
			<h:form rendered="#{LoginBean.login&&ChosingCourseBean.size!=0}">
				<h:outputText value="可选课程列表" styleClass="tablehead"/>
				<h:dataTable value="#{ChosingCourseBean.courseMsgItem}" var="coursemsg" 
				rowClasses="evenRow,oddRow" styleClass="panelstyle" headerClass="headerClazz">
					<h:column><f:facet name="header"><h:outputText value="课程名称"/><!-- 课程名称列 -->
						</f:facet><h:outputText value="#{coursemsg.courName}"/> </h:column>
					<h:column><f:facet name="header"><h:outputText value="上课周次"/><!-- 星期几上课 -->
						</f:facet><h:outputText value="#{coursemsg.day}"/> </h:column><!-- 值 -->
					<h:column><f:facet name="header"><h:outputText value="上课讲次"/><!-- 第几讲上课 -->
						</f:facet><h:outputText value="#{coursemsg.times}"/> </h:column><!-- 讲数 -->
					<h:column><f:facet name="header"><h:outputText value="任课教师"/><!-- 任课教师列 -->
						</f:facet><h:outputText value="#{coursemsg.teacher}"/></h:column><!-- 任课教师 -->
					<h:column><f:facet name="header"><h:outputText value="课程学分"/><!-- 课程学分列 -->
						</f:facet><h:outputText value="#{coursemsg.xuefen}"/> </h:column><!-- 学分值 -->
					<h:column><f:facet name="header"><h:outputText value="状态"/><!-- 课程状态列 -->
						</f:facet><!-- 控制状态的表单 -->
							<h:outputText value="可选" rendered="#{!coursemsg.state}"/>
			                <h:commandLink action="#{ChosingCourseBean.gongBu}" rendered="#{coursemsg.state}">
			                <h:outputText value="#{(coursemsg.state)?'公布':'已可选'}"/></h:commandLink>
					</h:column><h:column><f:facet name="header"><h:outputText value="^_^"/><!--  -->
						</f:facet>  <h:commandLink action="#{ChosingCourseBean.delete}">
								<h:graphicImage value="images/delete.png" style="border:0"/>
			                    <h:outputText value="删除"/></h:commandLink><!-- 删除课程的连接按钮 -->
			           </h:column></h:dataTable></h:form></h:panelGrid>
		</f:view>
	</body>
</html>