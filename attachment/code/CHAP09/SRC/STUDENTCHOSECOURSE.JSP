<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>StudentChangePwd.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
	</head>
	<body><f:view>
	<h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
		<h:outputText value="请先登录"/></h:outputLink><!-- 对未登录用户的处理 -->
	<h:panelGrid styleClass="panel"><!-- 设置该页面元素的整体位置 -->
	<h:form rendered="#{LoginBean.login}">
	<h:outputText value="暂无可选课程信息" styleClass="noinfo" rendered="#{StudentChoseCourseBean.size==0}"/>
	<h:outputText value="可选课程列表" styleClass="tablehead" rendered="#{StudentChoseCourseBean.size!=0}"/>
	<h:dataTable value="#{StudentChoseCourseBean.courseMsgItem}" 
	 var="coursemsg" rendered="#{StudentChoseCourseBean.size!=0}"
			 rowClasses="evenRow,oddRow" styleClass="panelstyle" headerClass="headerClazz">
		<h:column><f:facet name="header">
				<h:outputText value="课程编号"/></f:facet><!-- 课程编号列 -->
			<h:outputText value="#{coursemsg.courNo}"/></h:column>
		<h:column><f:facet name="header">
				<h:outputText value="课程名称"/></f:facet><!-- 课程名称列 -->
			<h:outputText value="#{coursemsg.courName}"/> </h:column>
		<h:column><f:facet name="header">
				<h:outputText value="星期几"/></f:facet><!-- 星期几列 -->
			<h:outputText value="#{coursemsg.day}"/> </h:column>
		<h:column><f:facet name="header">
				<h:outputText value="第几讲"/></f:facet><!-- 第几讲列 -->
			<h:outputText value="#{coursemsg.times}"/> </h:column>
		<h:column><f:facet name="header">
				<h:outputText value="任课教师"/></f:facet><!-- 任课教师列 -->
			<h:outputText value="#{coursemsg.teacher}"/> </h:column>
		<h:column><f:facet name="header">
				<h:outputText value="课程学分"/></f:facet><!-- 课程学分列 -->
			<h:outputText value="#{coursemsg.xuefen}"/> </h:column>
		<h:column><f:facet name="header">
				<h:outputText value="^_^"/></f:facet><!-- 选课列 -->
			<h:commandLink action="#{StudentChoseCourseBean.chose}">
	                <h:outputText value="选课"/></h:commandLink><!-- 选课连接 -->
		</h:column></h:dataTable></h:form></h:panelGrid>
	<h:inputText id="result" value="#{StudentChoseCourseBean.result}" style="display:none"
	 styleClass="centers"/></f:view>
	 <script language="JavaScript">
			function alertmsg()
			{
				var msg=document.getElementById("result").value;
				if(msg!="")
				{
					alert(msg);	
				}
				
			}
			
			window.onload=alertmsg;
		</script>
	 </body><!-- 点击选课后的提示信息 -->
</html>