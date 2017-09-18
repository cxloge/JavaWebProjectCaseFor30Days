<%@ page contentType="text/html;charset=gbk"
	import="wyf.zrk.ConsumerInfo"
 %>
<% 
	ConsumerInfo ci = (ConsumerInfo)request.getAttribute("object");
 %>
<html>
  <head>
    <title>查看客户</title>
  </head>
  <body bgcolor="#EBF5FD">
 	<jsp:useBean id="userBean" class="wyf.zrk.UserBean" scope="session"/>
	<table width="100%" height="44" bgcolor="#206AB3">
      <tr align="center"><td>
        <font color="#FFFFFF" size="5">客户资料管理</font>
        <font color="#FFFFFF" size="2">--客户查看</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="javascript:history.back()">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<hr color="black" size="1" width="100%"/>	
	<table width="80%" border="0" cellspacing="1" bgcolor="black" align="center">	
	  <tr bgcolor="white">
	    <td align="center">客户名称:</td>
	    <td><%= new String(ci.getCname().getBytes("ISO-8859-1"),"gbk") %></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">联&nbsp;系&nbsp;人:</td>
	    <td><%= new String(ci.getClinkman().getBytes("ISO-8859-1"),"gbk") %></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">公司地址:</td>
	    <td><%= new String(ci.getCaddress().getBytes("ISO-8859-1"),"gbk") %></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">公司电话:</td>
	    <td><%= new String(ci.getCtel().getBytes("ISO-8859-1"),"gbk") %></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">E-mail:</td>
	    <td><%= new String(ci.getCemail().getBytes("ISO-8859-1"),"gbk") %></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
	    <td><%= new String(ci.getCremark().getBytes("ISO-8859-1"),"gbk") %></td>
	  </tr>
	</table>	
  </body>
</html>