<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html>
	<head>
		<title>Teacher.jsp</title>
		<link type="text/css" rel="stylesheet" href="images/style.css">
	</head>
		<f:view><frameset rows="15%,*" frameborder="0" bordercolor="#D2e9ff" >
		<frame src="Teachertop.jsp" noresize="true"><frameset cols="24%,*" >  <!-- 上面显示的页面 -->
			<frame name="leftFrame"  src="TeacherTree.jsp" noresize="true">   <!-- 左边显示的页面 -->
			<frame name="mainFrame"  src="TeacherWelcome.jsp" noresize="true"><!-- 右边显示的页面 -->
		</frameset><noframes><body>                           <!-- 浏览器不支持frameset时的处理 -->
		<p>很抱歉！这是一个分帧页面，但由于你的浏览器不支持，所以不能浏览！ </p>
		<p>Sorry!This page uses frames,but your browser doesn't support them .</body>
		</noframes></frameset></f:view>
		
</html><table  ></table>