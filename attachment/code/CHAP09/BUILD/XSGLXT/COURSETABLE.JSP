<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>CourseTable.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
	</head>
	<body><f:view><h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
		<h:outputText value="请先登录"/></h:outputLink><!-- 对未登录者的处理 -->
	<h:panelGrid styleClass="panel" rendered="#{LoginBean.login}"><!-- 设置该模块页面的整体样式 -->
	<h:outputText value="无课程信息" styleClass="noinfo" rendered="#{CourseTableBean.size==0}"/>
	<h:outputText value="课程表" styleClass="tablehead" rendered="#{CourseTableBean.size!=0}"/>
	<h:dataTable value="#{CourseTableBean.courTable}" var="coursetime" rendered="#{CourseTableBean.size!=0}"
	columnClasses="evencol1,oddcol1" styleClass="tablestyle" headerClass="headerClazz">
		<h:column>
			<f:facet name="header">
				<h:outputText value=""/>
			</f:facet>
			<h:outputText value="#{coursetime.zero}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="星期一"/>
			</f:facet>
			<h:outputText value="#{coursetime.one}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="星期二"/>
			</f:facet>
			<h:outputText value="#{coursetime.two}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="星期三"/>
			</f:facet>
			<h:outputText value="#{coursetime.three}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="星期四"/>
			</f:facet>
			<h:outputText value="#{coursetime.four}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="星期五"/>
			</f:facet>
			<h:outputText value="#{coursetime.five}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="星期六"/>
			</f:facet>
			<h:outputText value="#{coursetime.six}"/>
		</h:column><h:column>
			<f:facet name="header">
				<h:outputText value="星期日"/>
			</f:facet>
			<h:outputText value="#{coursetime.seven}"/>
		</h:column>
	</h:dataTable>
	<hr/>
	<h:form>
	<h:dataTable value="#{CourseTableBean.myCourseMsgItem}" 
				 var="mycoursemsg" rendered="#{CourseTableBean.size!=0}"
				rowClasses="evenRow,oddRow" styleClass="panelstyle" headerClass="headerClazz">
		<h:column><f:facet name="header">
				<h:outputText value="课程编号"/></f:facet><!-- 课程编号列 -->
			<h:outputText value="#{mycoursemsg.courNo}"/></h:column>
		<h:column><f:facet name="header">
				<h:outputText value="课程名称"/></f:facet><!-- 课程名称列 -->
			<h:outputText value="#{mycoursemsg.courName}"/> </h:column>
		<h:column><f:facet name="header">
				<h:outputText value="星期几"/></f:facet><!-- 星期几列 -->
			<h:outputText value="#{mycoursemsg.day}"/> </h:column>
		<h:column><f:facet name="header">
				<h:outputText value="第几讲"/></f:facet><!-- 讲次列 -->
			<h:outputText value="#{mycoursemsg.times}"/> </h:column>
		<h:column><f:facet name="header">
				<h:outputText value="任课教师"/></f:facet><!-- 任课教师列 -->
			<h:outputText value="#{mycoursemsg.teacher}"/></h:column>
		<h:column><f:facet name="header">
				<h:outputText value="课程学分"/></f:facet><!-- 学分列 -->
			<h:outputText value="#{mycoursemsg.xuefen}"/> </h:column>
		<h:column rendered="#{CourseTableBean.onchosing}">
			<f:facet name="header"><h:outputText value="^_^"/></f:facet><!-- 删除列 -->
			<h:commandLink action="#{CourseTableBean.delete}"><!-- 绑定到后台方法 -->
                    <h:graphicImage value="images/delete.png" style="border:0"/><h:outputText value="删除"/></h:commandLink><!-- 删除标签 -->
            </h:column></h:dataTable></h:form></h:panelGrid></f:view></body>
</html>