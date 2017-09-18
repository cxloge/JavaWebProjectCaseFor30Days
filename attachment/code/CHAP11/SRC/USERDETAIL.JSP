<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>员工明细</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<style>
		 .jd{
		         position:absolute;
		         visibility:hidden;
	        }
	     
	     .Blur {
	     	filter: Alpha(opacity=20);
				  -moz-opacity:0.2;
				  opacity:0.2;
		 
	      }	
	     .NoBlur{}
     </style>
		<script language="JavaScript" src="javascript/position.js"></script>
		<script language="JavaScript">
			function showtable()
			{
				var tab=document.getElementById("dcdetail");
				pos=getElementPos("maincontent");
				tab.style.top=pos.y+15;
                tab.style.left=pos.x+15;
				tab.style.visibility="visible";
				document.getElementById("maincontent").className="Blur";
			}
			function closetable()
			{
				var tab=document.getElementById("dcdetail");
				tab.style.visibility="hidden";
				document.getElementById("maincontent").className="NoBlur";
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
		<div id="maincontent">
		  <table align="center" border="0" cellpadding="0" cellspacing="0" width="99%" style="font-size:14px;color:#154ba0;background-color:#eff5fb;">
		  	<caption style="text-align:center;margin:0 auto;font-size:20px;background-color:#eff5fb;border-bottom:1px solid #154ba0;">
		  		<s:property value="user.realName"/>的个人基本信息
		  	</caption>
			<tr style="height:40px;">
				<td style="width:80px;border-bottom:1px solid #154ba0;">用户名：</td>
				<td style="width:200px;border-bottom:1px solid #154ba0;"><s:property value="user.userName"/></td>
				<td style="width:80px;border-bottom:1px solid #154ba0;">真实姓名：</td>
				<td style="width:200px;border-bottom:1px solid #154ba0;border-right:1px solid #154ba0;"><s:property value="user.realName"/></td>
				<td rowspan="5" valign="top" align="center">
					<img id="pic" onload="changePic('pic');" src="<s:property value="user.imgpath"/>">
					<br><br>
					<s:submit value="更改头像" onclick="showtable();" theme="simple"/>
				</td>
			</tr>
			<tr style="height:40px;">
				<td style="border-bottom:1px solid #154ba0;">性别：</td>
				<td style="border-bottom:1px solid #154ba0;"><s:property value="user.gender"/></td>
				<td style="border-bottom:1px solid #154ba0;">生日：</td>
				<td style="border-bottom:1px solid #154ba0;border-right:1px solid #154ba0;"><s:property value="user.birth"/></td>
			</tr>
			<tr style="height:40px;">
				<td style="border-bottom:1px solid #154ba0;">所属部门：</td>
				<td style="border-bottom:1px solid #154ba0;"><s:property value="user.deptName"/></td>
				<td style="border-bottom:1px solid #154ba0;">所属组：</td>
				<td style="border-bottom:1px solid #154ba0;border-right:1px solid #154ba0;"><s:property value="user.groupName"/></td>
			</tr>
			<tr style="height:40px;">
				<td style="border-bottom:1px solid #154ba0;">职位：</td>
				<td style="border-bottom:1px solid #154ba0;"><s:property value="user.roleName"/></td>
				<td style="border-bottom:1px solid #154ba0;">电子邮箱：</td>
				<td style="border-bottom:1px solid #154ba0;border-right:1px solid #154ba0;"><s:property value="user.email"/></td>
			</tr>
			<tr style="height:40px;">
				<td style="border-bottom:2px solid #154ba0;">电话：</td>
				<td style="border-bottom:2px solid #154ba0;"><s:property value="user.phone"/></td>
				<td style="border-bottom:2px solid #154ba0;">基本薪资：</td>
				<td style="border-bottom:2px solid #154ba0;border-right:1px solid #154ba0;"><s:property value="user.salary"/></td>
			</tr>
			<tr style="height:200px;">
				<td style="border-right:1px solid #154ba0;">个人简历：</td>
				<td style="border-right:1px solid #154ba0;" colspan="3" valign="top"><s:property value="user.jianli"/></td>
			</tr>
		</table>
		</div>
	</div>
	
	<table cellpadding="0" cellspacing="0" style="border:6px solid #a8cde4;height:200px;width:500px;font-size:14px;color:#154ba0;background-color:#eff5fb;"  class="jd" id="dcdetail">
		<tr style="height:20px;background-color:#a8cde4">
			<td align="left">更改头像</td>
			<td align="right" valign="top" style="border-bottom:0px;">
			<img id="closeimg"
                 src="images/close2.gif" 
                 onclick="closetable()"
                 onmouseover="document.all.closeimg.src='images/close_g.gif'"
                 onmouseout="document.all.closeimg.src='images/close2.gif'">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table style="width:100%;border:0px;color:#154ba0">
				<tr>
					<td>请选择头像：</td>
				</tr>
				<tr>
				<s:form action="changepic" method="post" enctype="multipart/form-data" theme="simple">
					<td>
						<s:hidden name="oldpic" value="%{user.imgpath}"/>
						<s:hidden name="userNumber" value="%{user.userNumber}"/>
						<s:file name="pic" cssStyle="width:400px" /><br><s:submit value="提交"/>
					</td>
				</s:form>
				</tr>
				</table>
			</td>
		</tr>
	</table>
	<script language="JavaScript">
			var result="<s:property value="result"/>";
			if(result!="")
			{
				alert(result);
			}
		</script>
	</body>
</html>
