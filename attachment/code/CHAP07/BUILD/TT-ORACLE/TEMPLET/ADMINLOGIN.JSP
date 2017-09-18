<%@ page contentType="text/html;charset=gbk" %>

<html>
	<head>
		<title>管理员登录</title>
		<link href="css/reg.css" type="text/css" rel="stylesheet"/>
		<script language="JavaScript" src="script/trim.js"></script>
 		<script language="JavaScript" src="script/login.js"></script>
		<script language="JavaScript" src="script/general.js"></script>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400">
			<br/><br/><br/><br/><center>
			<form action="ManageServlet" method="post" name="mf_login">
			<fieldset style="width:70%">
				<legend>管理员登录</legend>
				<br/><br/><br/>
				<table width="80%" border="0">
					<tr>
						<td align="right">用户名：</td>
						<td align="left"><input name="aname" id="aname" /></td>
					</tr>
					<tr>
						<td align="right">&nbsp;密码：&nbsp;</td>
						<td align="left"><input type="password" name="apwd" id="apwd" /></td>
					</tr>
					<tr>
						<td align="right">验证码：</td>
						<td align="left"><input name="identify" id="identify" />
				<span>&nbsp;&nbsp;&nbsp;&nbsp;<img id="yzm" src="yzm.jsp" valign="center"/></span></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><a href="JavaScript:loadImg()"><font size="2">看不清楚？点击再换一个</font></a></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="hidden" name="action" value="adminLogin" />
							<input type="button" value="&nbsp;登录&nbsp;" class="btn" onclick="JavaScript:check()" />
							<input type="reset" value="&nbsp;重置&nbsp;" class="btn" />
						</td>
					</tr>
				</table>
				<br/><br/><br/>
			</fieldset>
			</form>
			</center>
			<%@ include file="tip.jsp" %>
		</div>
		</div>
	</body>
</html>