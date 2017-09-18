<%@ page  contentType="text/html;charset=GBK" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>ExtraWorkDetail.jsp</title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/editdepartstyle.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div id="contain">
		<s:form theme="simple">
		<table>
			<caption>加班详细信息</caption>
			<tr>
				<td class="tdtitle">职工编号</td>
				<td class="tddata"><s:property value="extraWork.impId"/></td>
				<td class="tdtitle">职工姓名</td>
				<td class="tddata"><s:property value="extraWork.impName"/></td>
			</tr>
			<tr>
				<td class="tdtitle">所属部门</td>
				<td class="tddata"><s:property value="extraWork.departName"/></td>
				<td  class="tdtitle">加班日期</td>
				<td class="tddata"><s:property value="extraWork.workTime"/></td>
			</tr>
		</table>
		<fieldset>
			<legend>加班原因</legend>
			<s:property value="extraWork.executes"/>
		</fieldset><br>
		</s:form>
	</div>
	</body>
</html>