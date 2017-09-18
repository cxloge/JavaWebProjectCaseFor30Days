<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*,wyf.hxl.PaginationBean,wyf.hxl.DB" %>

<html>
<head>
<title>用户登录</title>
	<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">  
      function checkLogin()
      {
        var zname = document.all.zname.value.trim();
        var zpassword = document.all.zpassword.value.trim();
        if(zname=="")
        {
           	alert("用户名不能为空!!!");
      		return;
        }
        if(zpassword=="")
        {
           alert("密码不能为空!!!");
           return;
        }
        document.anform.submit();
      }
   </script>
   <%
     String userStr=(String)session.getAttribute("user");
     if(userStr!=null)
     {
       request.setAttribute("msg","请您注销后再登录其他用户名！");
   %>
      <jsp:forward page="pagination.jsp"/>
   <%
     }
   %>   
 </head>
<body style="background:url('img/top/bg.gif')"><center>
<table border="0" width="400" style="border:1px solid #6daafc">
  <tr>
    <td>
		<table border="0" width="100%">
		  <caption style="font-size:1.6em;font-weight:bold">用户登录</caption>
		  <form action="CustomerServlet" name="anform"  method="post">
			<tr>
				<td align="right" width="150">请填写用户名</td>
				<td width="250"><input name="zname" type="text" id="zname" size="25"/></td>
			</tr>
			<tr>
				<td align="right" width="150">请填写密码</td>
				<td width="250"><input name="zpassword" type="password" id="zpassword" size="25"/></td>
			</tr>
			</table>
			<table border="0" align="center">
			<tr align="center">
				<td align="right"><img border="0" id="dl"
					 onmousedown="document.all.dl.src='img/dlfh/dl1.png'" 
			    	 onmousemove="document.all.dl.src='img/dlfh/dl2.png'" 
			    	 onmouseout="document.all.dl.src='img/dlfh/dl3.png'"
			    	 src="img/dlfh/dl1.png" onclick="checkLogin()" style="cursor:hand" />
					 <input name="action" type="hidden" value="denglu"/>
				</td>
				<td align="left"><a href="javascript:history.back()"><img border="0" id="fh"
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
 </body>
</html>
