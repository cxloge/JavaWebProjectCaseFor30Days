<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>用户注册</title>
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function checkCname()
      {
      	var flag = false;
      	var cname = document.aform.cname.value;
      	if(cname.trim()=="")
      	{
      		document.all.uinfo.innerHTML =
      				"<font color='red' size='2px'>此项为必填项，请设置你的用户名。</font>";
      	}
      	else
      	{
      		flag = true;
			document.all.uinfo.innerHTML =
					"<font size='2px'>用户名可以由小写英文字母、中文、数字组成。</font>";
      	}
      	return flag;
      }
       function checkCpw()
      {
      	var flag = false;
      	var cpassword = document.aform.cpassword.value;
      	var zzs=/^[a-z0-9A-Z]{6,15}$/;
      	if(cpassword.trim()=="")
      	{
      		document.all.pinfo.innerHTML =
      				"<font color='red' size='2px'>此项为必填项，请设置你的密码。</font>";
      	}
      	else if(!zzs.test(cpassword))
      	{
      		document.all.pinfo.innerHTML = 
      				"<font color='red' size='2px'>您设置的密码有误，请重新设置你的密码。</font>";
      	}
      	else
      	{
      		flag = true;
			document.all.pinfo.innerHTML =
					"<font size='2px'>密码可以由英文字母、数字组成，要大于6位小于15位。</font>";
      	}
      	return flag;
      }
      function checkSpw()
      {
      	var flag = false;
      	var cpassword = document.aform.cpassword.value;
      	var spw = document.aform.spw.value;
      	if(spw.trim()=="")
      	{
      		document.all.spinfo.innerHTML =
      				"<font color='red' size='2px'>此项为必填项，请设置你的密码。</font>";
      	}
      	else if(spw.trim()!=cpassword.trim())
      	{
      		document.all.spinfo.innerHTML = 
      				"<font color='red' size='2px'>您设置的密码有误，请重新设置你的密码。</font>";
      	}
      	else
      	{
      		flag = true;
			document.all.spinfo.innerHTML =
					"<font size='2px'>密码可以由英文字母、数字组成，要大于6位小于15位。</font>";
      	}
      	return flag;
      }
      function checkEmail()
      {
      	var flag = false;
      	var email = document.aform.email.value;
      	var zzs=/^\w{1,6}@[a-z0-9]{1,8}\.(com)|( cn)$/;
      	if(email.trim()=="")
      	{
      		document.all.einfo.innerHTML =
      				"<font color='red' size='2px'>此项为必填项，请填写您的E-mail地址。</font>";
      	}
      	else if(!zzs.test(email))
      	{
      		document.all.einfo.innerHTML =
      				"<font color='red' size='2px'>格式有误，请重新填写您的E-mail地址。</font>";
      	}
      	else
      	{
      		flag = true;
			document.all.einfo.innerHTML =
					"<font size='2px'>请输入符合格式的邮箱地址。</font>";
      	}
      	return flag;
      }
      function checkSub()
      {
      	var flag1 = checkCname();
      	var flag2 = checkCpw();
      	var flag3 = checkSpw();
      	var flag4 = checkEmail();
      	if(flag1&&flag2&&flag3&&flag4)
      	{
      		document.aform.submit();
      	}
      }
      </script>
 </head>     
<body style="background:url('img/top/bg.gif')">

<% 
   String user=(String)session.getAttribute("user");
   boolean loginFlag=false; //false表示没有登录
   if(user !=null)
   {
      loginFlag=true;
   }
%>

<center>
<table border="0" width="700" style="border:1px solid #6daafc">
  <tr>
    <td>
		<table border="0">
		    <caption style="font-size:1.6em;font-weight:bold">用户注册</caption>
		    <form action="CustomerServlet" name="aform" method="post">
				<tr>
					<td align="right" width="150">请填写用户名</td>
					<td><input name="cname" type="text" id="cname" onblur="checkCname" <%=loginFlag?"disabled":""%>/></td>
					<td id="uinfo" width="400"><font color="blue" size="2px">用户名可以由小写英文字母、中文、数字组成。</font></td>
				</tr>
				<tr>
					<td align="right" width="150">请填写密码</td>
					<td><input name="cpassword" type="password" id="cpassword" onblur="checkCpw" <%=loginFlag?"disabled":""%>/></td>
					<td id="pinfo" width="400"><font color="blue" size="2px">密码可以由小写英文字母、数字组成，要大于6位小于15位。</font></td>
				</tr>
				<tr>
					<td align="right" width="150">请再次输入密码</td>
					<td><input name="spw" type="password" id="spw" onblur="checkSpw" <%=loginFlag?"disabled":""%>/></td>
					<td id="spinfo" width="400"><font color="blue" size="2px">密码可以由小写英文字母、数字组成，要大于6位小于15位。</font></td>
				</tr>
				<tr>
					<td align="right" width="150">请输入E-mail</td>
					<td>
					  <input 
					    name="email" 
					    type="text" id="email" 
					    onblur="checkEmail" <%=loginFlag?"disabled":""%>
					    value="<%=(request.getParameter("email")!=null)?request.getParameter("email"):""%>"
					   />
					</td>
					<td id="einfo" width="400"><font color="blue" size="2px">请输入符合格式的邮箱地址。</font></td>
				</tr>
				</table>
				<table border="0">
				<tr align="center">
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><img border="0" id="zc"
						 onmousedown="document.all.zc.src='img/dlfh/zc1.png'" 
				    	 onmousemove="document.all.zc.src='img/dlfh/zc2.png'" 
				    	 onmouseout="document.all.zc.src='img/dlfh/zc3.png'"
				    	 src="img/dlfh/zc1.png" onclick="<%=(loginFlag)?"":"checkSub()"%>" style="cursor:hand"/>
						<input name="action" type="hidden" value="zhuce"/>
					</td>
					<td><a href="pagination.jsp"><img border="0" id="fh"
						 onmousedown="document.all.fh.src='img/dlfh/fh1.png'" 
				    	 onmousemove="document.all.fh.src='img/dlfh/fh2.png'" 
				    	 onmouseout="document.all.fh.src='img/dlfh/fh3.png'"
				    	 src="img/dlfh/fh1.png" style="cursor:hand" /></a>
				    </td>
				</tr>
			</form>
		</table>
    </td>
  </tr>
</table>
</center>
</body>
<script>
  <% 
    if(loginFlag)
    {
  %>
     alert("已经登录的情况下不可以注册新用户，\n请注销后再执行此操作！");
  <%
    }
   %>
</script>
<script>
   <% 
     String msg=(String)request.getAttribute("msg");
     if(msg!=null)
     {
   %>
     alert('<%=msg%>');
   <%     
     }
   %>
</script>
</html>
