<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>紧急报警</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/sendFile.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
		<script language="JavaScript">
			String.prototype.trim = function()
			{
			  return this.replace(/(^\s*)|(\s*$)/g, "");
			}
			function checkalarm()
			{
				var title=document.getElementById("title").value.trim();
				if(title=="")
				{
					alert("主题不能为空");
					return false;
				}
				if(title.length>40)
				{
					alert("主题太长，请尽量简练");
					return false;
				}
				var deptNumber=document.getElementById("deptlist").value.trim();
				if(deptNumber=="")
				{
					alert("请选择部门");
					return false;
				}
				var detail=document.getElementById("detail").value;
				if(detail=="")
				{
					alert("内容不能为空");
					return false;
				}
				if(detail.length>1000)
				{
					alert("内容太长，请尽量简要");
					return false;
				}
				return true;
			}
		</script>
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
		<s:form onsubmit="return checkalarm();" theme="simple" action="sendAlarm" method="post">
			<table>
				<tr>
					<td>主&nbsp&nbsp&nbsp&nbsp题：</td>
					<td><s:textfield id="title" name="title" cssStyle="width:500px"/></td>
				</tr>
				<tr>
					<td>报警部门：</td>
					<td><s:select name="deptNumber" id="deptlist" list="deptList" listKey="deptNumber" listValue="deptName"/> </td>
				</tr>
				<tr>
					<td>详细信息：</td>
					<td><s:textarea id="detail" name="detail" cssStyle="width:500px;height:300px;"/></td>
				</tr>
				<tr>
					<td></td>
					<td><s:submit value="提交"/>&nbsp&nbsp&nbsp&nbsp<s:reset value="取消"/></td>
				</tr>
			</table>
		</s:form>
		
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
