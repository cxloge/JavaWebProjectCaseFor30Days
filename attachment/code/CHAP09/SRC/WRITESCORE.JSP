<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>WriteScore.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
		<script type="text/javascript" src="images/teacher.js"></script> 
		
	</head>
	<body><f:view><h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
		<h:outputText value="请先登录"/></h:outputLink><!-- 提示先登录的信息 -->
	<h:form id="myform" rendered="#{LoginBean.login&&WriteScoreBean.courseSize!=0}" styleClass="centers"><!-- 设置下拉列表框的样式 -->
		<div class="topform">
			<h:graphicImage styleClass="gbicon" value="images/opration.gif" />
			<h:outputText value="请选择您要操作的课程：" styleClass="topformmsg"/>
			<h:selectOneMenu value="#{WriteScoreBean.courseNo}" onchange="this.form.submit();" styleClass="selecttype">
	        <f:selectItems value="#{WriteScoreBean.courseItem}"/></h:selectOneMenu>
	        <h:commandButton image="images/gongbu1.gif" 
					onmouseover="this.src='images/gongbu2.gif'" onmouseout="this.src='images/gongbu1.gif'" 
					onmousedown="this.src='images/gongbu3.gif'" onmouseup="this.src='images/gongbu2.gif'" 
	    			 action="#{WriteScoreBean.gongbu}" styleClass="gongbustyle"/>
	    	<h:commandButton image="images/gongbu.gif" action="#{WriteScoreBean.gongbu}" styleClass="gbicon1" alt="公布该科成绩"/>
	    	
		</div>
		
	     
	    </h:form><!-- 输出操作结果 -->
	 <h:panelGrid styleClass="panel">
	 <h:inputText id="result" value="#{WriteScoreBean.result}" style="display:none"/>
	 <h:form id="scoreform" onsubmit="return checkss();" rendered="#{LoginBean.login&&WriteScoreBean.courseSize!=0}"><!-- 设置数据表格居中显示 -->
	 <h:dataTable  value="#{WriteScoreBean.gradeList}" var="gradeitem" 
	            rowClasses="evenRow,oddRow" styleClass="panelstyle" headerClass="headerClazz">
			<h:column><f:facet name="header"><h:outputText value="课程编号"/><!-- 课程编号列 -->
				</f:facet><h:outputText value="#{gradeitem.courseNo}"/> </h:column><!-- 课程编号值 -->
			<h:column><f:facet name="header"><h:outputText value="课程名称"/><!-- 课程名称列 -->
				</f:facet><h:outputText value="#{gradeitem.courseName}"/> </h:column><!-- 课程名称 -->
			<h:column><f:facet name="header"><h:outputText value="学号"/><!-- 学号列 -->
				</f:facet><h:outputText value="#{gradeitem.stuNo}"/> </h:column><!-- 学号 -->
			<h:column><f:facet name="header"><h:outputText value="姓名"/><!-- 姓名列 -->
				</f:facet><h:outputText value="#{gradeitem.stuName}"/> </h:column><!-- 姓名 -->
			<h:column><f:facet name="header"><h:outputText value="课程学分"/><!-- 课程学分列 -->
				</f:facet><h:outputText value="#{gradeitem.xuefen}"/> </h:column><!-- 学分 -->
			<h:column><f:facet name="header"><h:outputText value="分数"/><!-- 分数列 -->
				</f:facet><h:panelGroup>
					<h:inputText value="#{gradeitem.score}" id="score" onchange="checkscore(this);" converter="MyConveter">
						<f:validateDoubleRange maximum="100.0" minimum="0.0"/></h:inputText>
					<h:message for="score" style="color:red"/><!-- 错误信息输出 -->
				</h:panelGroup></h:column></h:dataTable>
				<h:commandButton image="images/submit1.gif" 
					onmouseover="this.src='images/submit2.gif'" onmouseout="this.src='images/submit1.gif'" 
					onmousedown="this.src='images/submit3.gif'" onmouseup="this.src='images/submit2.gif'" 
				 action="#{WriteScoreBean.saveScore}"/>
				</h:form>
			
				</h:panelGrid>
					<h:outputText rendered="#{LoginBean.login&&WriteScoreBean.courseSize==0}" value="没有相应的可操作课程信息" styleClass="noinfo"/>
				</f:view>
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
		</body>
</html>