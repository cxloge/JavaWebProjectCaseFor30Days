<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*,wyf.hxl.ManageBean,wyf.hxl.DB"%>
<html><head>
<title>后台登录</title>
<script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function checkManLogin()
      {
        var mmname = document.all.mmname.value.trim();
        var mmpassword = document.all.mmpassword.value.trim();
        if(mmname=="")
        {
           alert("管理员名不能为空!!!");
      		 return;
        }
        if(mmpassword=="")
        {
           alert("密码不能为空!!!");
           return;
        } 
        document.anform.submit();   
      }
      </script>
 </head>     
<body style="background:url('img/top/bg.gif')">
<center>
<br/>
<table border="0" width="400" style="border:1px solid #6daafc">
  <tr>
    <td>
		<table border="0" width="100%">
		  <caption style="font-size:1.6em;font-weight:bold">管理员登录</caption>	  
			<form action="ManageServlet" name="anform"  method="post">
				<tr>
					<td align="right">请填写管理员名</td>
					<td><input name="mmname" type="text" id="mmname" size="15"/></td>
				</tr>
				<tr>
					<td align="right">请填写密码</td>
					<td><input name="mmpassword" type="password" id="mmpassword" size="15"/></td>
				</tr>
				<tr>
					<td align="right"><img border="0" id="dl"
						 onmousedown="document.all.dl.src='img/dlfh/dl1.png'" 
				    	 onmousemove="document.all.dl.src='img/dlfh/dl2.png'" 
				    	 onmouseout="document.all.dl.src='img/dlfh/dl3.png'" src="img/dlfh/dl1.png" onclick="checkManLogin()"
				    	 style="cursor:hand" />
						<input name="action" type="hidden" value="mandenglu"/>
					</td>
					<td><a href="javascript:history.back()"><img border="0" id="fh"
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