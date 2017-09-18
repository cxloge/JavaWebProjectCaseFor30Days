<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>上传共享</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
		<script language="JavaScript">
			String.prototype.trim = function()
			{
			  return this.replace(/(^\s*)|(\s*$)/g, "");
			}
	        function checkUpload()
	        {
	        	var title=document.getElementById("title").value;
	        	if(title.trim()=="")
	        	{
	        		alert("文件标题不能为空");
	        		return false;
	        	}
	        	if(title.trim().length>25)
	        	{
	        		alert("文件标题不能过长!!!");
	        		return false;
	        	}
	        	var shareFile=document.getElementById("shareFile").value;
	        	if(shareFile.trim()=="")
	        	{
	        		alert("请选择文件");
	        		return false;
	        	}
	        	var info=document.getElementById("info").value;
	        	if(info.trim()=="")
	        	{
	        		alert("请填写文件详情");
	        		return false;
	        	}
	        	if(info.trim().length>100)
	        	{
	        		alert("文件详情不能过长!!!");
	        		return false;
	        	}
	        	return true;
	        	
	        }
	        
		</script>
	</head>
	<body id="sendfile" onload="updateTree('li21');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent" style="background-color:#eff5fb;">
		<s:form onsubmit="return checkUpload();" theme="simple" action="uploadShare2" method="post" enctype="multipart/form-data">
		
			<table width="100%">
				<tr>
					<td style="width:70px;" rowspan="5" align="center"><img src="images/share.jpg"></td>
					<td><a></a></td>
					<td></td>
				</tr>
				<tr>
					<td align="right">文件类别：</td>
					<td ><s:select name="type" list="typeList" listKey="typeNumber" listValue="typeName"/></td>
				</tr>
				<tr>
					<td align="right">文件标题：</td>
					<td ><s:textfield id="title" name="title" cssStyle="line-height:25px;width:425px;height:25px;"/></td>
				</tr>
				<tr>
					<td align="right">选择文件：</td>
					<td ><s:file id="shareFile" name="shareFile" size="50" onkeydown="return false;"  cssStyle="line-height:25px;width:425px;height:25px;"/></td>
				</tr>
				<tr>
					<td align="right">文件详情：</td>
					<td ><s:textarea id="info" name="info" cssStyle="width:425px;height:200px;"/></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><s:submit value="上传"/>&nbsp&nbsp<s:reset value="取消"/></td>
				</tr>
			</table>
		</s:form>
		</div>
	</div>
	</body>
</html>
