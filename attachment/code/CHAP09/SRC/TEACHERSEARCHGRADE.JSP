<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>TeacherSearchGrade.jsp</title>
		<link style="text/css" rel="stylesheet" href="images/style.css">
		<script type="text/javascript" src="images/teacher.js"></script>
	</head>
	<body><f:view>
		<h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
			<h:outputText value="请先登录"/></h:outputLink><!-- 没有登录时的提示信息 -->
		<h:form id="searchform"  onsubmit="return checksno();" rendered="#{LoginBean.login}" styleClass="centers">
			<div class="topsearch">
				<h:graphicImage styleClass="iconstyle" value="images/icon.jpg" />
				<h:inputText onfocus="clearinput();" id="search" styleClass="inputtype" value="#{TeacherSearchGradeBean.sno}" required="true"/>
				<h:commandButton image="images/sea1.png" 
				onmouseover="this.src='images/sea2.png'" onmouseout="this.src='images/sea1.png'" 
					onmousedown="this.src='images/sea3.png'" onmouseup="this.src='images/sea2.png'" 
				action="#{TeacherSearchGradeBean.search}" styleClass="searchbutton"/>
				</div>
		
			<h:message for="search" style="color:red"/><!-- 错误信息输出 -->
		<!-- 没有该学生的提示信息 -->
		</h:form><h:panelGrid styleClass="panel" rendered="#{LoginBean.login}"><!-- 下面正式开始数据表格 -->
		<h:dataTable value="#{TeacherSearchGradeBean.gradeList}" var="grade" 
		       rendered="#{TeacherSearchGradeBean.cansee&&TeacherSearchGradeBean.size>0}"rowClasses="evenRow,oddRow" 
		       styleClass="panelstyle" headerClass="headerClazz"><!-- 对数据表个进行样式的设置 -->
			<h:column><f:facet name="header"><h:outputText value="课程名"/></f:facet><!-- 表头 -->
				<h:outputText value="#{grade.courseName}"/></h:column><!-- 数据 -->
			<h:column><f:facet name="header"><h:outputText value="分数"/></f:facet><!-- 表头 -->
				<h:outputText value="#{grade.score}"/></h:column><!-- 数据 -->
			<h:column><f:facet name="header"><h:outputText value="学分"/></f:facet><!-- 表头 -->
				<h:outputText value="#{grade.xuefen}"/></h:column><!-- 数据 -->
		</h:dataTable>
			<h:outputText value="#{TeacherSearchGradeBean.result}" styleClass="noinfo" />
		</h:panelGrid></f:view></body>
		<script language="JavaScript">
			function initialinput()
			{
				var com=document.getElementById("searchform:search");
				var sno=com.value;
				
				if(sno.trim()=="")
				{
					com.value="请输入要查询的学生的学号";
				}
			}
			function clearinput()
			{
				var com=document.getElementById("searchform:search");
				var sno=com.value;
			
				if(sno=="请输入要查询的学生的学号")
				{
					com.value="";
				}
			}
			window.onload=initialinput();
		</script>
</html>