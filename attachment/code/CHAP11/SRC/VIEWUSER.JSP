<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>员工列表</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/viewAlarm.css" rel="stylesheet" type="text/css"/>
		
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
	<body id="sendfile" onload="updateTree('li51');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent" style="background-color:#eff5fb;">
			<ul>
			<s:iterator value="deptList" status="dept" >
				<li><a href="viewUser.action?currenPage=1&deptNumber=<s:property value="deptNumber"/>"><s:property value="deptName"/></a></li>
			</s:iterator>
			</ul>
			<table width="100%" align=center cellpadding="0" cellspacing="0">
				<tr style="background-color:#c1d9f3;height:23">
					<th style="border-bottom:2px solid #154ba0;">用户名</th>
					<th style="border-bottom:2px solid #154ba0;">真实姓名</th>
					<th style="border-bottom:2px solid #154ba0;">性别</th>
					<th style="border-bottom:2px solid #154ba0;">部门</th>
					<th style="border-bottom:2px solid #154ba0;">职位</th>
					<th style="border-bottom:2px solid #154ba0;">电话</th>
					<th style="border-bottom:2px solid #154ba0;">详情</th>
				</tr>
			
			<s:iterator value="userList" status="user" >
			
			<tr id="user<s:property value='#user.index'/>" style="height:23px;" 
					onmouseover="mouseovercolor('user<s:property value='#user.index'/>')" 
					onmouseout="mouseoutcolor('user<s:property value='#user.index'/>')">
					<td style="border-bottom:1px solid #a8cde4"><s:property value="userName"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="realName"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="gender"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="deptName"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="roleName"/></td>
					<td style="border-bottom:1px solid #a8cde4"><s:property value="phone"/></td>
					<td style="border-bottom:1px solid #a8cde4">
						<a href="userDetail.action?userNumber=<s:property value="userNumber"/>" target="blank">查看</a>
					</td>
				
			</tr>
			</s:iterator>
			<tr style="background-color:#c1d9f3;height:23">
					<td colspan="8">
					<s:form action="viewUser" theme="simple" method="post" >
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
							<a href="viewUser.action?currenPage=<s:property value="currenPage-1"/>" style="text-decoration:none;color:#0f4097">上一页</a>
							</s:if>
							<s:if test="currenPage<maxPage">
							<a href="viewUser.action?currenPage=<s:property value="currenPage+1"/>" style="text-decoration:none;color:#0f4097">下一页</a>
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
