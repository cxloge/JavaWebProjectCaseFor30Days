<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>查看共享</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/viewShare.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
		<link href="css/sendFile.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript">
			function mouseovercolor(id)
	        {
	        	document.getElementById(id).className="mouseover";
	        }
	        function mouseoutcolor(id)
	        {
	        	document.getElementById(id).className="mouseout";
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
			<ul>
			<s:iterator value="shareTypeList" status="shareType" >
				<li><a href="viewShare.action?currenPage=1&shareType=<s:property value="typeNumber"/>"><s:property value="typeName"/></a></li>
			</s:iterator>
			</ul>
			<table width="100%" align=center cellpadding="0" cellspacing="0">
				<tr style="background-color:#c1d9f3;height:23">
					<th style="border-bottom:2px solid #154ba0;">文件名</th>
					<th style="border-bottom:2px solid #154ba0;">文件类型</th>
					<th style="border-bottom:2px solid #154ba0;">文件主题</th>
					<th style="border-bottom:2px solid #154ba0;">共享时间</th>
					<th style="border-bottom:2px solid #154ba0;">大小</th>
					<th style="border-bottom:2px solid #154ba0;">共享人</th>
					<th style="border-bottom:2px solid #154ba0;">下载</th>
				</tr>
			
			<s:iterator value="shareFileList" status="shareFile" >
			
			<tr id="file<s:property value='#shareFile.index'/>" style="height:23px;" 
					onmouseover="mouseovercolor('file<s:property value='#shareFile.index'/>')" 
					onmouseout="mouseoutcolor('file<s:property value='#shareFile.index'/>')">
					<td style="border-bottom:1px solid #a8cde4"><s:property value="realname"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="typename"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="title"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="time"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="size"/>K</td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="username"/></td>
					<td style="border-bottom:1px solid #a8cde4">
						<a href="loadShare.action?fileNumber=<s:property value="number"/>"><img alt="点击下载" src="images/download.gif">&nbsp下载</a>
					</td>
			</tr>
			</s:iterator>
			<tr style="background-color:#c1d9f3;height:23">
					<td colspan="7">
					<s:form action="viewShare" theme="simple" method="post" >
					<table width="100%" >
					<tr style="height:23px;">
						<td style="border-bottom:1px solid #a8cde4"></td>
						<td style="border-bottom:1px solid #a8cde4"></td>
						<td style="border-bottom:1px solid #a8cde4"></td>
						<td style="border-bottom:1px solid #a8cde4"></td>
						<td style="border-bottom:1px solid #a8cde4"></td>
						<td style="border-bottom:1px solid #a8cde4"></td>
						<td style="border-bottom:1px solid #a8cde4" align="right">
							<s:select onchange="this.form.submit();" name="pageSpan" 
							list="#{2:'2条/页',5:'5条/页',10:'10条/页',15:'15条/页',20:'20条/页',25:'25条/页'}"
							 listKey="key" listValue="value"/>
							<s:property value="currenPage"/>/<s:property value="maxPage"/>
							<s:if test="currenPage>1">
							<a href="viewShare.action?currenPage=<s:property value="currenPage-1"/>" style="text-decoration:none;color:#0f4097">上一页</a>
							</s:if>
							<s:if test="currenPage<maxPage">
							<a href="viewShare.action?currenPage=<s:property value="currenPage+1"/>" style="text-decoration:none;color:#0f4097">下一页</a>
							</s:if>
						</td>
					</tr>
					</table>
					</s:form>
					</td>
				</tr>
			</table>
		</div>
	</div>
	</body>
</html>
