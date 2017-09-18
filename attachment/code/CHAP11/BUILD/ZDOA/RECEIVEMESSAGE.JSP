<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>接收消息</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/sendFile.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
		<script language="JavaScript" src="javascript/update.js"></script>
		<script language="JavaScript">
			String.prototype.trim = function()
			{
			  return this.replace(/(^\s*)|(\s*$)/g, "");
			}
			function updateTree(id)
			{
				document.getElementById(id).style.display="block";
			}
			function mouseovercolor(id)
	        {
	        	document.getElementById(id).className="mouseover";
	        }
	        function mouseoutcolor(id)
	        {
	        	document.getElementById(id).className="mouseout";
	        }
	        function checkall(form)
	        {
	        	if(document.getElementById("all-1").checked==true)
	        	{
	        		for (var i=0;i<form.elements.length;i++){
						var e = form.elements[i];

						if (e.name=='delList' )
						{
							e.checked =true;
						}
						
					}

	        	}
	        	else
	        	{
	        		for (var i=0;i<form.elements.length;i++){
						var e = form.elements[i];

						if (e.name=='delList' )
						{
							e.checked =false;
						}
						
						}
	        	}
	        }
		</script>
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
		<s:form action="delMessage" theme="simple" method="post" id="delform">
			<s:hidden name="currenPage"/>
			<table width="100%" align=center cellpadding="0" cellspacing="0">
				<tr style="background-color:#c1d9f3;height:23">
					<th style="border-bottom:2px solid #154ba0;">
						&nbsp&nbsp<s:checkboxlist id="all" name="all" list="#{'all':''}" listKey="key" listValue="value" onclick="checkall(this.form);"/>
					</th>
					<th style="border-bottom:2px solid #154ba0;">发送人</th>
					<th style="border-bottom:2px solid #154ba0">消息主题</th>
					<th style="border-bottom:2px solid #154ba0">发送时间</th>
					<th style="border-bottom:2px solid #154ba0">查看</th>
				</tr>
				
				<s:iterator value="messageList" status="msg" >
				<tr id="msg<s:property value='#msg.index'/>" style="height:23px;" 
					onmouseover="mouseovercolor('msg<s:property value='#msg.index'/>')" 
					onmouseout="mouseoutcolor('msg<s:property value='#msg.index'/>')">
					<td style="border-bottom:1px solid #a8cde4">
						&nbsp&nbsp<s:checkboxlist name="delList" list="#msg" listKey="number" listValue="''"/>
					</td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="fromUName"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="info"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="time2"/></td>
					<td style="border-bottom:1px solid #a8cde4">
						<a href="msgDetail.action?msgNumber=<s:property value="number"/>&currenPage=<s:property value="currenPage"/>"><img alt="点击查看消息详细信息" src="images/download.gif">&nbsp查看</a>
					</td>
				</tr>
				</s:iterator>
				</s:form>
				<tr style="background-color:#c1d9f3;height:23">
					<td colspan="5">
					<s:form action="receiveMessage" theme="simple" method="post" >
					<table width="100%" >
					<tr style="height:23px;">
						<td style="border-bottom:1px solid #a8cde4">&nbsp<s:submit onclick="document.getElementById('delform').submit();return false;" value="删除"/></td>
						<td style="border-bottom:1px solid #a8cde4"></td>
						<td style="border-bottom:1px solid #a8cde4"></td>
						<td style="border-bottom:1px solid #a8cde4" align="right">
							<s:select onchange="this.form.submit();" name="pageSpan" 
							list="#{2:'2条/页',5:'5条/页',10:'10条/页',15:'15条/页',20:'20条/页',25:'25条/页'}"
							 listKey="key" listValue="value"/>
							<s:property value="currenPage"/>/<s:property value="maxPage"/>
							<s:if test="currenPage>1">
							<a href="receiveMessage.action?currenPage=<s:property value="currenPage-1"/>" style="text-decoration:none;color:#0f4097">上一页</a>
							</s:if>
							<s:if test="currenPage<maxPage">
							<a href="receiveMessage.action?currenPage=<s:property value="currenPage+1"/>" style="text-decoration:none;color:#0f4097">下一页</a>
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