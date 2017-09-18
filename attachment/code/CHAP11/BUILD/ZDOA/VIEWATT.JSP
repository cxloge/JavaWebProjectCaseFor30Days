<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>考勤记录</title>
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
	<body onload="updateTree('li91');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent">
			<table width="100%" align=center cellpadding="0" cellspacing="0">
				<tr style="background-color:#c1d9f3;height:23">
					<td align="center" style="border-bottom:2px solid #154ba0;">日期</td>
					<td align="center" style="border-bottom:2px solid #154ba0;">姓名</td>
					<td align="center" style="border-bottom:2px solid #154ba0;">部门</td>
					<td align="center" style="border-bottom:2px solid #154ba0;">考勤状态</td>
					<td align="center" style="border-bottom:2px solid #154ba0;">考勤IP</td>
				</tr>
			
			<s:iterator value="attList" status="att">
			
			<tr id="att<s:property value='#att.index'/>" style="height:23px;" 
					onmouseover="mouseovercolor('att<s:property value='#att.index'/>')" 
					onmouseout="mouseoutcolor('att<s:property value='#att.index'/>')">
					<td align="center" style="border-bottom:1px solid #a8cde4"><s:property value="attTime"/></td>
					<td align="center" style="border-bottom:1px solid #a8cde4"><s:property value="attName"/></td>
					<td align="center" style="border-bottom:1px solid #a8cde4"><s:property value="deptName"/></td>
					<td align="center" style="border-bottom:1px solid #a8cde4">
						<s:if test="startState==2">
							<span style="color:#154ba0"><s:property value="startTime"/></span>
						</s:if>
						<s:else>
							<span style="color:#f00"><s:property value="startTime"/></span>
						</s:else>
						 &nbsp | &nbsp 
						 <s:if test="endState==2">
							<span style="color:#154ba0"><s:property value="endTime"/></span>
						</s:if>
						<s:else>
							<span style="color:#f00"><s:property value="endTime"/></span>
						</s:else>
					</td>
					<td align="center" style="border-bottom:1px solid #a8cde4"><s:property value="startIp"/> &nbsp | &nbsp <s:property value="endIp"/></td>
			</tr>
			</s:iterator>
			<tr style="background-color:#c1d9f3;height:23">
					<td colspan="7">
					<s:form action="viewAtt" theme="simple" method="post" >
					<table width="100%" >
					<tr style="height:23px;">
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
							<a href="viewAtt.action?currenPage=<s:property value="currenPage-1"/>" style="text-decoration:none;color:#0f4097">上一页</a>
							</s:if>
							<s:if test="currenPage<maxPage">
							<a href="viewAtt.action?currenPage=<s:property value="currenPage+1"/>" style="text-decoration:none;color:#0f4097">下一页</a>
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
