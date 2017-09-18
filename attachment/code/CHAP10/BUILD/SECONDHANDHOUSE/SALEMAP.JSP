<%@ page contentType="text/html;charset=gbk" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>

<html>
	<head>
		<title>²é¿´´óÍ¼</title>
		<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAA0DBHEJH01_0VNMudvDaa6xTnXSjFu29eJd6cbMAcBwfCDrkn8RTOtwnL4wJ4A6GZWdE82cQ6geLv4Q" type="text/javascript"></script>
		<script src="http://www.google.com/jsapi?key=ABQIAAAA0DBHEJH01_0VNMudvDaa6xTnXSjFu29eJd6cbMAcBwfCDrkn8RTOtwnL4wJ4A6GZWdE82cQ6geLv4Q" type="text/javascript"></script>
		<script src="script/map.js" type="text/javascript"></script>
	</head>
	<body onload="load()">
		<h:form id="mf_map" style="display:none;">
			<h:inputText id="longitude" value="#{ShowSaleMsgBean.longitude}"/>
			<h:inputText id="latitude" value="#{ShowSaleMsgBean.latitude}"/>
		</h:form>
		<center>
			<div id="MapDiv" style="height:550px;width:100%;border:solid 1px #000000;"></div>		
		</center>
	</body>
</html>
</f:view>