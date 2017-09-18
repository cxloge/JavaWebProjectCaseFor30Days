<%@ page contentType="text/html;charset=gbk"
	import="wyf.zrk.ProviderInfo"
 %>
<% 
	ProviderInfo pi = (ProviderInfo)request.getAttribute("object");
 %>
<html>
  <head>
    <title>查看供应商</title>
     <script language="JavaScript" src="script/trim.js"></script>
     <script language="JavaScript">
       function check(){
         if(document.all.plinkman.value.trim()==""){
         	alert("联系人不能为空!!!");
         	return;
         }
         if(document.all.paddress.value.trim()==""){
         	alert("公司地址不能为空!!!");
         	return;
         }
         if(document.all.ptel.value.trim()==""){
         	alert("公司电话不能为空!!!");
         	return;
         }
       	 document.all.mf.submit();
       }
     </script>
  </head>
  <body bgcolor="#EBF5FD">
 	<jsp:useBean id="userBean" class="wyf.zrk.UserBean" scope="session"/>
	<table width="100%" height="44" bgcolor="#206AB3">
      <tr align="center"><td>
        <font color="#FFFFFF" size="5">供应商资料管理</font>
        <font color="#FFFFFF" size="2">--供应商修改</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="javascript:history.back()">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<hr color="black" size="1" width="100%"/>
	<form action="ManageServlet" method="post" id="mf">
	<table width="80%" border="0" cellspacing="1" bgcolor="black" align="center">	
	  <tr bgcolor="white">
	    <td align="center">供应商名称:</td>
	    <td><%= new String(pi.getPname().getBytes("ISO-8859-1"),"gbk") %></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">联&nbsp;系&nbsp;人:</td>
	    <td><input name="plinkman" id="plinkman"
	    	 value="<%= new String(pi.getPlinkman().getBytes("ISO-8859-1"),"gbk") %>"/></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">公司地址:</td>
	    <td><input name="paddress" id="paddress"
	    	 value="<%= new String(pi.getPaddress().getBytes("ISO-8859-1"),"gbk") %>"/></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">公司电话:</td>
	    <td><input name="ptel" id="ptel"
	    	 value="<%= new String(pi.getPtel().getBytes("ISO-8859-1"),"gbk") %>"/></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">E-mail:</td>
	    <td><input name="pemail" id="pemail"
	    	 value="<%= new String(pi.getPemail().getBytes("ISO-8859-1"),"gbk") %>"/></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
	    <td><input name="premark" id="premark" size="50"
	    	 value="<%= new String(pi.getPremark().getBytes("ISO-8859-1"),"gbk") %>"/></td>
	  </tr>
	</table>
	<table align="left" width="70%">
	  <tr>
	    <td align="right">
	    	  <img border="0" src="img/xg.gif" id="xg" onclick="JavaScript:check()"
          	  style="cursor:hand"
          	  onmouseover="document.all.xg.src='img/xga.gif'"
          	  onmouseout="document.all.xg.src='img/xg.gif'"
          	  onmouseup="document.all.xg.src='img/xga.gif'"        	
          	  onmousedown="document.all.xg.src='img/xgb.gif'"/></td>
	    <td align="left">
	    	  <img border="0" src="img/cze.gif" id="cz" onclick="JavaScript:document.all.mf.reset()"
          	  style="cursor:hand"
          	  onmouseover="document.all.cz.src='img/czd.gif'"
          	  onmouseout="document.all.cz.src='img/cze.gif'"
          	  onmouseup="document.all.cz.src='img/czd.gif'"        	
          	  onmousedown="document.all.cz.src='img/czc.gif'"/></td>
	  </tr>
	</table>
	<input type="hidden" name="action" value="modifyProvider"/>
	<input type="hidden" name="pid" value="<%= pi.getPid() %>"/>
	<input type="hidden" name="pname" value="<%= new String(pi.getPname().getBytes("ISO-8859-1"),"gbk") %>"/>
	</form>
  </body>
</html>