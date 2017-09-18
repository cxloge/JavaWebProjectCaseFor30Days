<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>待批申请</title>
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
			<table cellpadding="0" cellspacing="0" border="1"  style="margin:30 auto;border-color:#154ba0;" align="center">
				<tr style="height:30px;">
					<td align="center" style="width:150px;">主题</td>
					<td align="center" style="width:200px;">一级审批状态</td>
					<s:if test="type==2">
					<td align="center" style="width:200px;">二级审批状态</td>
					</s:if>
					<td align="center" style="width:150px;">公文状态</td>
				</tr>
				<tr>
					<td align="center">
						<s:property value="topic"/>
					</td>
					<td align="center">
						<table width="80%">
							<s:iterator value="firstList" status="docdept" >
								<tr style="height:30px;">
									<td>
										<s:property value="deptName"/>
									</td>
									<td>
										<s:if test="deptState==0">
											<img src="images/weishenpi.gif"><span style="color:#ffb637;">未审批</span>
										</s:if>
										<s:else>
											<s:if test="deptState==1">
												<img src="images/shenpichenggong.gif"><span style="color:#298a00;">审批通过</span>
											</s:if>
											<s:else>
												<img src="images/shenpishibai.gif"><span style="color:#f00;">审批失败</span>
											</s:else>
										</s:else>
									</td>
								</tr>
							</s:iterator>
						</table>
					</td>
					<s:if test="type==2">
					<td align="center">
						<table width="80%">
							<s:iterator value="secondList" status="docdept2" >
								<tr style="height:30px;">
									<td>
										<s:property value="deptName"/>
									</td>
									<td>
										<s:if test="deptState==0">
											<img src="images/weishenpi.gif"><span style="color:#ffb637;">未审批</span>
										</s:if>
										<s:else>
											<s:if test="deptState==1">
												<img src="images/shenpichenggong.gif"><span style="color:#298a00;">审批通过</span>
											</s:if>
											<s:else>
												<img src="images/shenpishibai.gif"><span style="color:#f00;">审批失败</span>
											</s:else>
										</s:else>
									</td>
								</tr>
							</s:iterator>
						</table>
					</td>
					</s:if>
					<td align="center">
						<s:if test="state==0">
							正在审批中
						</s:if>
						<s:else>
							<s:if test="state==1">
								审批成功
							</s:if>
							<s:else>
								审批失败
							</s:else>
						</s:else>
					</td>
				</tr>
			</table>
		</div>
	</div>
	</body>
</html>
