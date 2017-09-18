<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*,wyf.hxl.ManageBean,wyf.hxl.DB"%>
<html><head>
<title>管理员添加</title>
<% 
   String chaoji=(String)session.getAttribute("chaoji");
   if(chaoji==null)
   {
     request.setAttribute("msg", "对不起，只有超级管理员才\\n可以使用此项功能，请登陆！");
%>
     <jsp:forward page="dl.jsp"/>
<%
   }
%>
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function checkMname()
      {
      	var flag = false;
      	var mname = document.aform.mname.value;
      	if(mname.trim()=="")
      	{
      		document.all.minfo.innerHTML =
      				"<font color='red' size='2px'>此项为必填项，请设置管理员名。</font>";
      	}
      	else
      	{
      		flag = true;
			document.all.minfo.innerHTML =
					"<font size='2px'>管理员名可以由小写英文字母、中文、数字组成。</font>";
      	}
      	return flag;
      }
       function checkMpassword()
      {
      	var flag = false;
      	var mpassword = document.aform.mpassword.value;
      	var zzs=/^[a-z0-9A-Z]{6,15}$/;
      	if(mpassword.trim()=="")
      	{
      		document.all.mpinfo.innerHTML =
      				"<font color='red' size='2px'>此项为必填项，请设置你的密码。</font>";
      	}
      	else if(!zzs.test(mpassword))
      	{
      		document.all.mpinfo.innerHTML = 
      				"<font color='red' size='2px'>您设置的密码有误，请重新设置你的密码。</font>";
      	}
      	else
      	{
      		flag = true;
			    document.all.mpinfo.innerHTML =
					"<font size='2px'>密码可以由英文字母、数字组成，要大于6位小于15位。</font>";
      	}
      	return flag;
      }
      function checkMpw()
      {
      	var flag = false;
      	var mpassword = document.aform.mpassword.value;
      	var mpw = document.aform.mpw.value;
      	if(mpw.trim()=="")
      	{
      		document.all.mpsinfo.innerHTML =
      				"<font color='red' size='2px'>此项为必填项，请设置你的密码。</font>";
      	}
      	else if(mpw.trim()!=mpassword.trim())
      	{
      		document.all.mpsinfo.innerHTML = 
      				"<font color='red' size='2px'>您设置的密码有误，请重新设置你的密码。</font>";
      	}
      	else
      	{
      		flag = true;
			document.all.mpsinfo.innerHTML =
					"<font size='2px'>密码可以由英文字母、数字组成，要大于6位小于15位。</font>";
      	}
      	return flag;
      }

      function checkTJ()
      {
      	var flag1 = checkMname();
      	var flag2 = checkMpassword();
      	var flag3 = checkMpw();
      	if(flag1&&flag2&&flag3)
      	{
      		document.aform.submit();
      	}
      }
      </script>
</head>     
<body style="background:url('img/top/bg.gif')">
<br><br>
<table border="0" width="700" style="border:1px solid #6daafc" align="center">
  <tr>
    <td>
		<table border="0" align="center">
			<caption style="font-size:1.5em;font-weight:bold">添加管理员</caption>
			<tr>
			<td>			
			<form action="ManageServlet" name="aform" method="post">
				<table border="0">
				<tr>
					<td align="right">请填写管理员名</td>
					<td><input name="mname" type="text" id="mname" onblur="checkMname"/></td>
					<td id="minfo"><font color="blue" size="2px">管理员名可以由小写英文字母、中文、数字组成。</font></td>
				</tr>
				<tr>
					<td align="right">请填写密码</td>
					<td><input name="mpassword" type="password" id="mpassword" onblur="checkMpassword"/></td>
					<td id="mpinfo"><font color="blue" size="2px">密码可以由小写英文字母、数字组成，要大于6位小于15位。</font></td>
				</tr>
				<tr>
					<td align="right">请再次输入密码</td>
					<td><input name="mpw" type="password" id="mpw" onblur="checkMpw"/></td>
					<td id="mpsinfo"><font color="blue" size="2px">密码可以由小写英文字母、数字组成，要大于6位小于15位。</font></td>
				</tr>
				<tr>
					<td align="right">请选择管理员权限</td>
					<td><select  name="quanxian" id="quanxian" style="width:155;">
								<option selected value="普通">普通
						        <option value="超级">超级
						</select></td>
					<td id="qxinfo"><font color="blue" size="2px">权限可以为'普通'或'超级'！</font></td>
				</tr>
				</table>
				<table border="0" align="center">
				<tr align="center">
					<td><input name="tianjia" type="button" value="添加" onclick="checkTJ()"/>
					<input name="action" type="hidden" value="tianjia"/></td>
					<td>
						<input type="reset" id="zhuce" name="zhuce" value="重置"/>
					</td>
				</tr>
				</table>
			</form>
			</td>
			</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>

<%
   String msg=(String)request.getAttribute("msg");
   if(msg!=null)
   {
%>
   <script>
     alert('<%=msg%>');
   </script>
<%
   }
%>