<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*,wyf.hxl.PaginationBean,wyf.hxl.DB" %>
<% 
	session.setAttribute("fromWhere","mmcz");
	String user=(String)session.getAttribute("user");
	if(user==null)
	{
		response.sendRedirect("customermanage.jsp");
	}
	else
	{
 %>
<html>
  <head>
    <title>密码重置</title>
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function check()
      {
      	var apwd = document.addform.apwd.value.trim();
      	var secpwd = document.addform.secpwd.value.trim();
      	if(apwd==""||apwd.length<6)
      	{
      		alert("密码不合法,长度不得小于6!!!");
      		return;
      	}
      	if(secpwd!=apwd)
      	{
      		alert("两次密码输入不一至!!!");
      		return;
      	}
      	document.addform.submit();
      }
    </script>
  </head>
<body style="background:url('img/top/bg.gif')">
<center>
<table border="0" width="400" style="border:1px solid #6daafc">
  <tr>
    <td>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
	  	<caption style="font-size:1.6em;font-weight:bold">密码重置</caption>
             <form action="CustomerServlet" method="post" name="addform">
                <tr>
                  <td align="right">请输入用户名</td>
                  <td>
                  	<input value="<%=user%>" disabled/>
                  </td>
                </tr>
                <tr>
                  <td align="right">请输入新密码</td>
                  <td><input type="password" name="apwd"/></td>
                </tr>
                <tr>
                  <td align="right">请再次输入新密码</td>
                  <td><input type="password" name="secpwd"/></td>
                </tr>
                <tr>
                  <td align="right">
                    <input type="hidden" name="action" value="resetpwd"/>
                    <input type="button" value="提交" onclick="check()"/>
                  </td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <td><input type="reset" value="重置"/></td>
                </tr>
                <tr>
	                <td colspan="2">
	                	&nbsp;&nbsp;
	                </td>
                </tr>
            </form>
    	</table>
    </td>
  </tr>
</table>
</center>
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
<% 
 	}
%>