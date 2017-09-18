<%@ page contentType="text/html;charset=gbk"
	import="wyf.zrk.UserBean,org.springframework.web.context.*,
	org.springframework.web.context.support.*,wyf.zrk.DButil,java.util.*"
 %>
<html>
  <head>
    <title>采购信息添加</title>
    <script language="JavaScript" src="script/trim.js"></script>
    <script language="JavaScript">
      function check(){
        var reg = /^\d+(\.\d+)?$/;
        var stp = document.all.stp.value.trim();
      	if(!reg.test(stp)){
      	  alert("采购总价格式不对,请重新输入!!!");
      	  return false;
      	}
      	if(document.all.sbuyer.value.trim()==""){
      	  alert("采购人不能为空!!!");
      	  return false;
      	}
      	if(document.all.pname.value.trim()==""){
      	  alert("供应商不能为空,请添加供应商!!!");
      	  return false;
      	}
      	document.all.mf.submit();
      }
    </script>
  </head>
   <body bgcolor="#EBF5FD">
 	<jsp:useBean id="userBean" class="wyf.zrk.UserBean" scope="session"/>
	<table width="100%" height="44" bgcolor="#206AB3">
      <tr align="center"><td>
        <font color="#FFFFFF" size="5">采购信息管理</font>
        <font color="#FFFFFF" size="2">--采购添加</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="javascript:history.back()">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<hr color="black" size="1"/>	
	<form action="ManageServlet" method="post" id="mf">
	<table width="80%" border="0" cellspacing="1" bgcolor="black" align="center">
	  <tr bgcolor="white">
	    <td align="center">供&nbsp;应&nbsp;商:</td>
	    <td>
      	  <select name="pname" id="pname">
      	  <% 
			//获取WebApplicationContext
			WebApplicationContext wac=
			   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			DButil db = (DButil)wac.getBean("DButil");
			List<String> pname = db.getProvider();
			for(String name:pname){
				name = new String(name.getBytes("ISO-8859-1"),"gbk");
      	    %>
      	    	<option value="<%= name %>"><%= name %></option>
      	    <% 
      	    	}
      	     %>
      	  </select>
	    </td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">采购总价:</td>
	    <td><input name="stp" id="stp"/></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">采&nbsp;购&nbsp;人:</td>
	    <td><input name="sbuyer" id="sbuyer"/></td>
	  </tr>
	</table>
	<table align="center">
	  <tr>
	    <td align="right">
	    <img border="0" src="img/xg.gif" id="xg" onclick="JavaScript:check()"
          	  style="cursor:hand"
          	  onmouseover="document.all.xg.src='img/xga.gif'"
          	  onmouseout="document.all.xg.src='img/xg.gif'"
          	  onmouseup="document.all.xg.src='img/xga.gif'"        	
          	  onmousedown="document.all.xg.src='img/xgb.gif'"/>
	    </td>
	    <td align="left">
	    <img border="0" src="img/cze.gif" id="cz" onclick="JavaScript:document.all.mf.reset()"
          	  style="cursor:hand"
          	  onmouseover="document.all.cz.src='img/czd.gif'"
          	  onmouseout="document.all.cz.src='img/cze.gif'"
          	  onmouseup="document.all.cz.src='img/czd.gif'"        	
          	  onmousedown="document.all.cz.src='img/czc.gif'"/>
	    </td>
	  </tr>
	</table>
	<input type="hidden" name="action" value="addStock"/>
	</form>
  </body>
</html>