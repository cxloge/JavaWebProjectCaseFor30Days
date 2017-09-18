<%@ page contentType="text/html;charset=gbk" 
	import="wyf.zrk.GoodsClassInfo"
%>
 <html>
   <head>
     <title>查看/修改类加</title>
     <script language="JavaScript" src="script/trim.js"></script>
     <script language="JavaScript">
       function check(){
       	 var gcname = document.all.gcname.value.trim();
       	 if(gcname==""){
       	 	alert("类别名称不能为空!!!");
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
        <font color="#FFFFFF" size="5">商品类别管理</font>
        <font color="#FFFFFF" size="2">--类别修改</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="javascript:history.back()">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<% 
		GoodsClassInfo gci = (GoodsClassInfo)request.getAttribute("object");
	 %>
	<hr color="black" size="1"/>
	<form action="ManageServlet" method="post" id="mf">
	<table width="80%" border="0" cellspacing="1" bgcolor="black" align="center">	
	  <tr bgcolor="white">
	    <td align="center">类别名称:</td>
	    <td><input size="20" name="gcname" id="gcname" 
	    		value="<%= new String(gci.getGcname().getBytes("ISO-8859-1"),"gbk") %>"/></td>
	  </tr>	
	</table>
	<br/>
	<table align="left" width="70%">
	  <tr>
	    <td align="right"><img border="0" src="img/xg.gif" id="xg" onclick="JavaScript:check()"
          	  style="cursor:hand"
          	  onmouseover="document.all.xg.src='img/xga.gif'"
          	  onmouseout="document.all.xg.src='img/xg.gif'"
          	  onmouseup="document.all.xg.src='img/xga.gif'"        	
          	  onmousedown="document.all.xg.src='img/xgb.gif'"/></td>
	    <td align="left"><img border="0" src="img/cze.gif" id="cz" onclick="JavaScript:document.all.mf.reset()"
          	  style="cursor:hand"
          	  onmouseover="document.all.cz.src='img/czd.gif'"
          	  onmouseout="document.all.cz.src='img/cze.gif'"
          	  onmouseup="document.all.cz.src='img/czd.gif'"        	
          	  onmousedown="document.all.cz.src='img/czc.gif'"/></td>
	  </tr>
	</table>
	<input type="hidden" name="action" value="modifyGoodsClass"/>
	<input type="hidden" name="gcid" value="<%= gci.getGcid() %>"/>
	</form>
   </body>
 </html>