<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/qiandao.css" rel="stylesheet" type="text/css"/>
		<s:head/>
	</head>
	<body>
	<div id="container">
		<div id="tophead">
			<s:include value="Top.jsp"/>
		</div>
		<div id="leftcontent">
			<s:include value="LeftTree.jsp"/>
		</div>
		<div id="maincontent">
			<s:form theme="simple" method="post" action="qianDaoOp">
				<span class="choseinfo">请选择日期：</span>
				<s:datetimepicker name="opDate" toggleType="explode" value="today"/>
				<s:submit value="生成签到表" cssClass="shengcheng"/>
				<s:fielderror cssClass="fielderr"/>
			</s:form>
			
		</div>
	</div>
	</body>
</html>