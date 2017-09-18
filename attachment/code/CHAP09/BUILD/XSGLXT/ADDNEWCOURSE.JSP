<%@ page contentType="text/html;charset=GBK"  %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>AddNewCourse.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
		<script type="text/javascript" src="images/teacher.js"></script> 
	</head>
	<body>
		<f:view>
			<h:form id="myform" onsubmit="return checkcourse();">
				<h:panelGrid columns="3">
					<h:outputText value="课程编号" styleClass="message"/>
					<h:inputText id="cno" value="#{AddNewCourseBean.cno}" required="true"/>
					<h:message for="cno" style="color:red"/>
					<h:outputText value="课程名称" styleClass="message"/>
					<h:inputText id="cname" value="#{AddNewCourseBean.cname}" required="true"/>
					<h:message for="cname" style="color:red"/>
					<h:outputText value="所属专业" styleClass="message"/>
					<h:selectOneMenu id="deptno" value="#{AddNewCourseBean.deptno}" required="true">
						<f:selectItems value="#{AddNewCourseBean.deptList}"/>
					</h:selectOneMenu>
					<h:message for="deptno" style="color:red"/>
					<h:outputText value="学分" styleClass="message"/>
					<h:inputText id="xuefen" value="#{AddNewCourseBean.xuefen}" required="true"/>
					<h:message for="xuefen" style="color:red"/>
					<h:inputText id="msg" value="#{AddNewCourseBean.result}" style="display:none"/>
					<h:commandButton value="提交" image="images/tijiao1.gif" 
					onmouseover="this.src='images/tijiao2.gif'" onmouseout="this.src='images/tijiao1.gif'" 
					onmousedown="this.src='images/tijiao3.gif'" onmouseup="this.src='images/tijiao2.gif'" 
					action="#{AddNewCourseBean.addCou}"/>
				</h:panelGrid>
			</h:form>
		</f:view>
		<script language="JavaScript">
			function alertmsg()
			{

				var msg=document.getElementById("myform:msg").value;
				if(msg!="")
				{
					alert(msg);	
				}
				
			}
			window.onload=alertmsg;
		</script>
	</body>
</html>