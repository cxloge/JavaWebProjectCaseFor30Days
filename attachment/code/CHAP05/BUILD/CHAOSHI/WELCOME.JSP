<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*"%>
<html>
<head>
<link href="script/div.css" type="text/css" rel=stylesheet>
</head>
<body style="background:url('img/top/bg.gif')">
<center>
<table>
<br><br><br><br><br><br><br><br><br>
<tr CLASS="welcome">
<td><img  src="img/png-1610.png" border="0"></td>
<td><font color="red" size="33"><i><b>欢迎进入远洋网络购物后台管理系统</b></i></font></td>
</tr>
</table>
</center>
</body>
<% 
   String msg=(String)request.getAttribute("msg");
   if(msg!=null)
   {
%>
        <script>
      		alert("<%=msg%>");
      	</script>    
<%
   }
%>
</html>