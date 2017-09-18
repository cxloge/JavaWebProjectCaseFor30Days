<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>待批公文</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/sendFile.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
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
	<body id="sendfile" onload="updateTree('li41');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent" style="background-color:#eff5fb;">
			<table width="100%" align=center cellpadding="0" cellspacing="0">
				<tr style="background-color:#c1d9f3;height:23">
					<th style="border-bottom:2px solid #154ba0;">公文发送者</th>
					<th style="border-bottom:2px solid #154ba0;">所属部门</th>
					<th style="border-bottom:2px solid #154ba0;">主题</th>
					<th style="border-bottom:2px solid #154ba0;">发送时间</th>
					<th style="border-bottom:2px solid #154ba0;">进度</th>
				</tr>
			
			<s:iterator value="docList" status="doc" >
			
			<tr id="doc<s:property value='#doc.index'/>" style="height:23px;" 
					onmouseover="mouseovercolor('doc<s:property value='#doc.index'/>')" 
					onmouseout="mouseoutcolor('doc<s:property value='#doc.index'/>')">
					<td style="border-bottom:1px solid #a8cde4"><s:property value="fromuser"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="deptname"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="title"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="doctime"/></td>
					<td style="border-bottom:1px solid #a8cde4">
						<a href="docPro.action?docnum=<s:property value="docnum"/>">查看</a>
					</td>
				
			</tr>
			</s:iterator>
			<tr style="background-color:#c1d9f3;height:23">
					<td colspan="8">
					<s:form action="myDoc" theme="simple" method="post" >
					<table width="100%" >
					<tr style="height:23px;">
						<td style="border-bottom:1px solid #a8cde4"></td>
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
							<a href="myDoc.action?currenPage=<s:property value="currenPage-1"/>" style="text-decoration:none;color:#0f4097">上一页</a>
							</s:if>
							<s:if test="currenPage<maxPage">
							<a href="myDoc.action?currenPage=<s:property value="currenPage+1"/>" style="text-decoration:none;color:#0f4097">下一页</a>
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
