<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head><meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
		<title><s:text name="mainmanage.title"/></title>
		<link href="images/style.css" rel="stylesheet" type="text/css"/>
		<link href="images/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="images/addimp.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="images/manage.js"></script>
		<s:head/>
	</head>
	<body>
	<div id="container">
		<div id="tophead">
			<s:include value="Top.jsp"/>
		</div>
		<div id="leftcontent">
			<s:include value="LeftTree.jsp"/>
		</div>
		<div id="maincontent">
			<div id="ftdiv">
			<s:form onsubmit="return addimpcheck();" theme="simple" action="addImpleey" method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>注册新员工</legend>
					
					<table width="500">
						<tr>
							<td style="width:80px;">职工编号:</td>
							<td><s:textfield name="impId" id="impId" cssClass="inputarea"/><span id="impIderr" class="fielderr"></span></td>
				
						</tr>
						<tr>
							<td>职工姓名:</td>
							<td><s:textfield name="impName" id="impName" cssClass="inputarea"/><span id="impNameerr" class="fielderr"></span></td>
						</tr>
						<tr>
							<td>职工性别:</td>
							<td><s:radio name="impGender" list="genderList" listKey="key" listValue="value"/></td>
						</tr>
						<tr>
							<td>出生日期:</td>
							<td><s:datetimepicker name="impBirth" id="impBirth" label="" toggleType="explode" value="today" cssClass="timepick"/><span id="impBirtherr" class="fielderr"></span></td>
						</tr>
						<tr>
							<td>个人邮箱:</td>
							<td><s:textfield name="impEmail" id="impBirth" cssClass="inputarea"/><span id="impEmailerr" class="fielderr"></span></td>
						</tr>
						<tr>
							<td>个人电话:</td>
							<td><s:textfield name="impTel" id="impTel" cssClass="inputarea"/><span id="impTelerr" class="fielderr"></span></td>
						</tr>
						<tr>
							<td>所属部门:</td>
							<td>
								<s:select name="departId" list="departList" listKey="key" listValue="value"/>
							</td>
						</tr>
						<tr>
							<td>职 位:</td>
							<td><s:textfield name="impRoll" id="impRoll" cssClass="inputarea"/><span id="impRollerr" class="fielderr"></span></td>
						</tr>
						<tr>
							<td>薪 资:</td>
							<td><s:textfield id="impSalary" name="impSalary"/><span id="impSalaryerr" class="fielderr"></span></td>
						</tr>
						<tr>
							<td>上传头像:</td>
							<td><input type="file" name="pic" class="infile"/></td>
						</tr>
					</table>
					</fieldset>
					<fieldset>
					<legend>个人简历</legend>
					<span id="impBioerr" class="fielderr"></span>
					<p><s:textarea cols="68" rows="15" id="impBio" name="impBio"></s:textarea></p>
					</fieldset>
					<s:submit value="提 交" cssClass="tijiao" onmouseover="this.className='tijiaoover';" onmouseout="this.className='tijiao';"/>
				</s:form>
				<s:fielderror cssClass="fielderr"/>
				<script language="JavaScript">
					result="<s:property value="result"/>";
					if(result!="")
					{
						alert(result);
					}
				</script>
			</div>
			
		</div>
	</div>
	</body>
</html>