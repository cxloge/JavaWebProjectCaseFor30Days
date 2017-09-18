<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>职工详细信息</title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/impdetail.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="images/manage.js"></script>
	</head>
	<body>
	<div id="container1">
		<div id="infohead"><s:property value="imp.impName"/>的详细信息</div>
		<div id="pic">
			<div style="height:175;width:200px;">
			<img id="personpic" src="<s:property value="imp.impPic"/>" onload="changePic('personpic');">
			</div>
			
			<span><s:property value="imp.impName"/>的头像</span>
		</div>
	
		<div id="info">
			<table>
				<tr class="evenrow">
					<td>职工编号：</td>
					<td><s:property value="imp.impId"/></td>
				</tr>
				<tr class="oddrow">
					<td>职工姓名：</td>
					<td><s:property value="imp.impName"/></td>
				</tr>
				<tr class="evenrow">
					<td>职工性别：</td>
					<td><s:property value="imp.impGender"/></td>
				</tr>
				<tr class="oddrow">
					<td>出生日期：</td>
					<td><s:property value="imp.impBirth"/></td>
				</tr>
				<tr class="evenrow">
					<td>个人邮箱：</td>
					<td><s:property value="imp.impEmail"/></td>
				</tr>
				<tr class="oddrow">
				 	<td>个人电话：</td>
					<td><s:property value="imp.impTel"/></td>
				</tr>
				<tr class="evenrow">
					<td>所属部门：</td>
					<td><s:property value="imp.departName"/></td>
				</tr>
				<tr class="oddrow">
					<td>职  位：</td>
					<td><s:property value="imp.impRoll"/></td>
				</tr>
				<tr class="evenrow">
					<td>薪  资：</td>
					<td><s:property value="imp.impSalary"/></td>
				</tr>
			</table>
		</div>
		<div style="clear:both;"></div>
		<div id="jianli">
			<fieldset>
				<legend>个人简历</legend>
				
				<p><s:property value="imp.impBio"/></p>
			</fieldset>
		</div>
	</div>
	</body>
</html>