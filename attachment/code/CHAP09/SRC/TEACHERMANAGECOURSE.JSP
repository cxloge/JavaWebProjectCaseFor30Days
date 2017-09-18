<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>TeacherManageCourse.jsp</title>
		<link style="text/css" rel="stylesheet" href="images/style.css">
		<script type="text/javascript" src="images/teacher.js"></script> 
	</head>
	<body>
		<f:view>
			<h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
				<h:outputText value="请先登录"/>
			</h:outputLink>
			<h:panelGrid styleClass="panel" columns="1" rendered="#{LoginBean.login}"><!-- 是该区域居中显示 -->
			<h:outputText value="学院现有课程列表" styleClass="tablehead"/>
			<h:dataTable value="#{TeacherManageCourseBean.courseItemList}" var="course" 
			 	rowClasses="evenRow,oddRow" styleClass="panelstyle" headerClass="headerClazz" ><!-- 设置表格样式 -->
				<h:column><f:facet name="header"><h:outputText value="课程编号"/></f:facet><!-- 课程编号列 -->        
			        <h:outputText value="#{course.courseNo}"/></h:column><!-- 课程编号值 -->
				<h:column><f:facet name="header"><h:outputText value="课程名称"/><!-- 课程名称列 -->
			        </f:facet><h:outputText value="#{course.courseName}"/></h:column><!-- 课程名称值 -->
				<h:column><f:facet name="header"><h:outputText value="课程学分"/><!-- 课程学分列 -->
			        </f:facet><h:outputText value="#{course.xuefen}"/></h:column><!-- 课程学分值 -->
				<h:column><f:facet name="header"><h:outputText value="所属学院"/><!-- 所属学院列 -->
			        </f:facet><h:outputText value="#{course.collName}"/></h:column><!-- 学院名字 -->
				<h:column><f:facet name="header"><h:outputText value="所属专业"/><!-- 所属专业列 -->
			        </f:facet><h:outputText value="#{course.deptName}"/></h:column><!-- 专业名字 -->
			</h:dataTable>
			
			</h:panelGrid>
			
			<hr/>
			<h:form rendered="#{LoginBean.login}" id="manageform" onsubmit="return coursemsgcheck();">
			<h:panelGrid styleClass="panel" columns="1" >
			
			<h:panelGrid columns="3"><!-- 三个一行且居中显示 -->
				<h:outputText value="请输入您要操作的课程的课程号：" styleClass="message"/><!-- 提示输入课程号的标签 -->
				<h:inputText value="#{TeacherManageCourseBean.courseNo}" id="courseNo"/><!-- 用于输入课程号 -->
				<h:message for="courseNo" style="color:red"/><!-- 错误提示信息 -->
				<h:outputText value="请输入该课程的任课老师：" styleClass="message"/><!-- 提示输入任课老师名字 -->
				<h:inputText value="#{TeacherManageCourseBean.teacher}" id="teacher"/><!-- 用于输入任课老师 -->
				<h:message for="teacher" style="color:red"/><!-- 错误信息输出 -->
				<h:outputText value="请选择该课程的上课时间：" styleClass="message"/><!-- 提示选择上课时间 -->
				<h:panelGroup><h:selectOneMenu value="#{TeacherManageCourseBean.day}"><!-- 星期几上 -->
						<f:selectItems value="#{TeacherManageCourseBean.dayItem}"/></h:selectOneMenu>
					<h:selectOneMenu value="#{TeacherManageCourseBean.times}"><!-- 第几讲上 -->
						<f:selectItems value="#{TeacherManageCourseBean.timesItem}"/></h:selectOneMenu>
				</h:panelGroup><h:outputText value=""/>
				<h:commandButton image="images/add1.gif" 
					onmouseover="this.src='images/add2.gif'" onmouseout="this.src='images/add1.gif'" 
					onmousedown="this.src='images/add3.gif'" onmouseup="this.src='images/add2.gif'" 
				action="#{TeacherManageCourseBean.addToDB}"/><!-- 提交按钮 -->
				<h:inputText id="result" value="#{TeacherManageCourseBean.result}" style="display:none"/><!-- 操作结果 -->
			</h:panelGrid></h:panelGrid>
			</h:form>
			
		</f:view>
		<script language="JavaScript">
			function alertmsg()
			{
				var msg=document.getElementById("manageform:result").value;
				if(msg!="")
				{
					alert(msg);	
				}
				
			}
			
			window.onload=alertmsg;
		</script>
	</body>
</html>