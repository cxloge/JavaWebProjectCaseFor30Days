<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>发送消息</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/sendFile.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
	</head>
	<body id="sendfile" onload="updateTree('li31');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent">
			
				<s:form onsubmit="return checksend();" theme="simple" action="sendMessage2" method="post">
					<table align="center" style="width:90%;" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">发送人:</td><td align="left" style="width:200px;border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;"><s:property value="msg.fromUName"/></td>
							<td align="right" style="border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;">发送时间:<s:property value="msg.time2"/></td>
						</tr>
						<tr>
							<td align="right" style="background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">消息主题:</td><td align="left" colspan="2" style="border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;"><s:property value="msg.info"/></td>
						</tr>
						<tr style="height:300px;">
							<td align="right" style="background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">消息内容:</td><td align="left" valign="top" colspan="2" style="border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;"><s:property value="msg.content"/></td>
						</tr>
						<tr>
							<td align="right" colspan="3"><a href="receiveMessage.action?currenPage=<s:property value="currenPage"/>" style="text-decoration:none;color:#154ba0">返回</a></td>
							
						</tr>
					</table>
				</s:form>


		</div>
	</div>

	</body>
</html>
