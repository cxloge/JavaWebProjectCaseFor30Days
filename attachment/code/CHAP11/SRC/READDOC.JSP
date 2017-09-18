<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>待批公文</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
	</head>
	<body id="sendfile" onload="updateTree('li41');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent">
			<table width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
				<tr style="height:25px;">
					<td style="width:60px;color:#154ba0;background-color:#a8cde4;font-size:14px;">主题：</td>
					<td style="border-bottom:1px solid #154ba0;font-size:14px;"><s:property value="topic"/></td>
				</tr>
				<tr style="height:300px;">
					<td style="color:#154ba0;background-color:#a8cde4;font-size:14px;">内容：</td>
					<td valign="top" style="border-bottom:1px solid #154ba0;font-size:14px;text-indent:2em;"><s:property value="content"/></td>
				</tr>
				<tr style="height:25px;">
					<td></td>
					<td><s:property value="canRead"/>
					<s:if test="canRead==1">
						&nbsp&nbsp&nbsp
						<a href="opDoc.action?docnum=<s:property value="docnum"/>&type=1" style="border:3px outset #a8cde4;background-color:#a8cde4;text-decoration:none;color:#154ba0;font-size:14px;">&nbsp&nbsp同  意&nbsp&nbsp</a>
						&nbsp&nbsp&nbsp&nbsp&nbsp
						<a href="opDoc.action?docnum=<s:property value="docnum"/>&type=2" style="border:3px outset #a8cde4;background-color:#a8cde4;text-decoration:none;color:#154ba0;font-size:14px;">&nbsp&nbsp拒  绝&nbsp&nbsp</a>
					</s:if>
					<s:else>
						<span style="color:red">由于一级审批尚未通过，所以暂时不能够进行审批</span>
					</s:else>
					</td>
				</tr>
			</table>
		</div>
	</div>
	</body>
</html>
