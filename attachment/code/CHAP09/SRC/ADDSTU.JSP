<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>AddStu.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
		<script type="text/javascript" src="images/teacher.js"></script> 
	</head>
<body><f:view><h:outputLink value="Login.jsp" target="_parent" rendered="#{!LoginBean.login}">
	<h:outputText value="请先登录"/></h:outputLink><!-- 如果没有登录则给出登录信息 -->
<h:form id="stuform" onsubmit="return stucheck();" rendered="#{LoginBean.login}"><!-- 提交前进行JavaScript验证 -->
<h:panelGrid styleClass="panel"><!-- 设置表单的整体位置 -->
	<h:outputText value="新生报到表" styleClass="tablehead"/>
	<h:panelGrid columns="3"  columnClasses="evenColumn,oddColumn,oddColumn"
	 styleClass="panelstyle"><!-- 设置表格的显示样式 -->
		<h:outputText value="学  号："  /><!-- 提示输入学号的标签 -->
		<h:inputText id="sno" value="#{AddStuBean.sno}" required="true"><!--  输入学号处 -->
			<f:validateLength maximum="12" minimum="8"/><!-- 对输入学号长度的验证 -->
		</h:inputText><h:message for="sno" style="color:red"/><!-- 错误信息输出 -->
		<h:outputText value="姓  名："/><!-- 提示输入姓名的标签 -->
		<h:inputText value="#{AddStuBean.sname}" id="sname" required="true"/><!-- 姓名为必填项 -->
		<h:message for="sname" style="color:red"/><!-- 错误信息输出 -->
		<h:outputText value="性  别："/><!-- 用于提示选择性别的标签 -->
		<h:selectOneRadio value="#{AddStuBean.sgender}" layout="lineDirection" id="gender" >
			<f:selectItem itemLabel="男" itemValue="男"/><f:selectItem itemLabel="女" itemValue="女"/>
		</h:selectOneRadio><!-- 选择性别的单选按钮组  -->
		<h:message for="gender" style="color:red"/><!-- 错误信息处理 -->
		<h:outputText value="出生日期："/><h:panelGroup><!-- 提示选则出生日期的标签 -->
			<h:selectOneMenu id="biryear" value="#{AddStuBean.biryear}" onchange="updateDate();"><!-- 更新日 -->
				<f:selectItems value="#{AddStuBean.biryearList}"/></h:selectOneMenu>
			<h:selectOneMenu id="birmonth" value="#{AddStuBean.birmonth}" onchange="updateDate();"><!-- 更新日 -->
				<f:selectItems value="#{AddStuBean.birmonthList}"/></h:selectOneMenu>
			<h:selectOneMenu id="birday" value="#{AddStuBean.birday}"><f:selectItems value="#{AddStuBean.birdayList}"/>
			</h:selectOneMenu></h:panelGroup><h:outputText value=""/>
		<h:outputText value="籍 贯："/><!-- 提示输入籍贯的标签 -->
		<h:inputText value="#{AddStuBean.nativeplace}" id="nativeplace" size="50" required="true"/>
		<h:message for="nativeplace" style="color:red"/><!-- 错误信息输出 -->
		<h:outputText value="学  院："/><h:outputText value="#{AddStuBean.coll}"/><h:outputText value=""/>
		<h:outputText value="专  业："/><!-- 提示选择专业的标签 -->
		<h:selectOneMenu value="#{AddStuBean.deptid}" onfocus="stucheck();" onchange="this.form.submit();" 
		 valueChangeListener="#{AddStuBean.updateClass}"><!-- 更新班级列表 -->
			<f:selectItems value="#{AddStuBean.deptList}"/></h:selectOneMenu><h:outputText value=""/>
		<h:outputText value="班  级："/><h:selectOneMenu value="#{AddStuBean.classid}">
			<f:selectItems value="#{AddStuBean.classList}"/></h:selectOneMenu><h:outputText value=""/>
		<h:outputText value="政治面貌："/><h:selectOneMenu value="#{AddStuBean.mianmao}">
			<f:selectItems value="#{AddStuBean.mianmaoList}"/></h:selectOneMenu>
		<h:outputText value=""/><h:outputText value="入学时间："/><!-- 提示选择入学时间 -->
		<h:panelGroup><h:selectOneMenu id="comeyear" value="#{AddStuBean.comeyear}" onchange="updateDate1();"><!-- 更新日 -->
				<f:selectItems value="#{AddStuBean.comeyearList}"/></h:selectOneMenu>
			<h:selectOneMenu id="comemonth" value="#{AddStuBean.comemonth}" onchange="updateDate1();"><!-- 更新日 -->
				<f:selectItems value="#{AddStuBean.comemonthList}"/></h:selectOneMenu>
			<h:selectOneMenu id="comeday" value="#{AddStuBean.comeday}">
				<f:selectItems value="#{AddStuBean.comedayList}"/></h:selectOneMenu>
		</h:panelGroup><h:outputText value=""/><h:outputText value=""/>
		<h:panelGrid columns="1" style="text-align:center;width=60%;">
			<h:commandButton image="images/tijiao1.gif" 
					onmouseover="this.src='images/tijiao2.gif'" onmouseout="this.src='images/tijiao1.gif'" 
					onmousedown="this.src='images/tijiao3.gif'" onmouseup="this.src='images/tijiao2.gif'" 
			action="#{AddStuBean.addStu}"/><!-- 提交按钮 -->
		</h:panelGrid><h:inputText id="msg" value="#{AddStuBean.msg}" style="display:none"/><!-- 处理结果的输出 -->
	</h:panelGrid></h:panelGrid></h:form></f:view>
		<script language="JavaScript">
			function alertmsg()
			{

				var msg=document.getElementById("stuform:msg").value;
				if(msg!="")
				{
					alert(msg);	
				}
				
			}
			window.onload=alertmsg;
		</script>	
	</body>
</html>