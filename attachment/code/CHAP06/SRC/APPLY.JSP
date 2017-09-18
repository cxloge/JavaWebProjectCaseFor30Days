<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/departListstyle.css" rel="stylesheet" type="text/css"/>

		<s:head/>
	</head>
	<body>
	<div id="container">
		<div id="tophead">
			<s:include value="Top.jsp"/>
		</div>
		<div id="leftcontent">
			<s:include value="LeftTree2.jsp"/>
		</div>
		<div id="maincontent">
		<s:form theme="simple" action="apply">
			<table align="center" style="color:#404040;font-size:14px;">
			<tr>
				<td>
				起始时间:<s:datetimepicker name="startTime" toggleType="explode" value=""/>
				</td>
				<td>
				终止时间:<s:datetimepicker name="endTime" toggleType="explode" value=""/>
				<s:submit value="确定"/>
				</td>
				
			</tr>
			<tr>
				<td colspan="2">
					<fieldset>
					<legend>请假原因</legend>
					<s:textarea cols="85" rows="15" name="execute">
					</s:textarea>
					</fieldset>
				</td>
			</tr>
			<tr>
			<td>
				<span style="color:red;font-size:14px;"><s:property value="result"/><s:fielderror cssClass="fielderr" /></span>
			</td>
			
			</tr>
			</table>
		</s:form>
	
		</div>
		
	</div>
	
	</body>
</html>