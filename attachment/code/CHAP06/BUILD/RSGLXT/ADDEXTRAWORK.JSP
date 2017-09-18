<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/addextraword.css" rel="stylesheet" type="text/css"/>
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
			<div id="contain">
			<s:form theme="simple" method="post" action="addExtraWork">
			<table>
				<caption><h4>添加加班信息</h4></caption>
				<tr>
					<td>职工编号:</td>
					<td><s:textfield name="impId"/></td>
					<td>加班日期:</td>
					<td><s:datetimepicker name="workTime" toggleType="explode" value="today"/></td>
				</tr>
				<tr>
					<td colspan="4">
					<fieldset>
						<legend>加班原因:</legend>
						<s:textarea cols="70" rows="10" name="executes"></s:textarea>
					</fieldset>
					</td>
				</tr>
			</table>
			<s:submit value="提交" cssClass="tijiao"/>
			</s:form>
			<s:fielderror cssClass="fielderr"/>
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
	</div>
	</body>
</html>