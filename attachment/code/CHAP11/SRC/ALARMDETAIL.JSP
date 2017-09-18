<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>紧急报警</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/sendFile.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
	</head>
	<body id="sendfile" onload="updateTree('li81');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent">
			<table width="90%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					
					<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">报&nbsp警&nbsp人：</td>
					<td style="border-bottom:#c1d9f3 solid 1px;"><s:property value="alarm.fromuserName"/></td>
					<td align="right" style="border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;">报警时间：<s:property value="alarm.time"/></td>
				</tr>
				<tr>
					<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">报警部门：</td>
					<td colspan="2" style="border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;"><s:property value="alarm.deptName"/></td>
				</tr>
				<tr>
					<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">主&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp题：</td>
					<td colspan="2" style="border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;"><s:property value="alarm.title"/></td>
				</tr>
				
				<tr>
					<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">详细信息：</td>
					<td valign="top" colspan="2" style="height:300px;border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;"><s:property value="alarm.detail"/></td>
				</tr>
				<tr>
					<td colspan="2"></td>
					<td align="right"><a href="viewAlarm.action?currenPage=<s:property value="currenPage"/>">返回</a></td>
				</tr>
			</table>
		
		</div>
	</div>
		<script language="JavaScript">
			var result="<s:property value="result"/>";
			if(result!="")
			{
				alert(result);
			}
		</script>
	</body>
</html>
