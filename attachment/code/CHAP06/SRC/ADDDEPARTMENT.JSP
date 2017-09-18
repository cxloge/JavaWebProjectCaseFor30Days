<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/adddepart.css" rel="stylesheet" type="text/css"/>
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
		<div id="addcontain">
			<s:form theme="simple" action="addDepart" method="post">
				<table>
				<caption><h4>添加部门</h4></caption>
					<tr>
						<td class="info">部门编号:</td>
						<td><s:textfield name="departId" cssClass="infield"/></td>
						<td class="info">部门名称:</td>
						<td><s:textfield name="departName" cssClass="infield"/></td>
					</tr>
				</table>
				<fieldset>
					<legend>部门描述:</legend>
					<s:textarea cols="68" rows="10" name="departDescrip"></s:textarea>
				</fieldset>
				<s:submit value="添 加" cssClass="tianjia"/>
			</s:form>
			
		</div>
		<div style="margin-left:50px;">
			<s:fielderror cssClass="fielderr"/>
		</div>
		
		</div>
	</div>
	
	<s:if test="(read==false)">
	<script language="JavaScript">
	
		window.onload=alertResult;
		
		function alertResult()
		{
			alert("<s:property value="result"/>");
		}
		
	</script>
	</s:if>
	</body>
</html>