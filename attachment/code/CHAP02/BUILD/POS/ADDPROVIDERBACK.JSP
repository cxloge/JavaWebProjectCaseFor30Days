<%@ page contentType="text/html;charset=gbk" 
	import="org.springframework.web.context.*,
	org.springframework.web.context.support.*,wyf.zrk.DButil,
	java.util.*,wyf.zrk.UserBean"
%>
<html>
  <head>
    <title>采购退货添加</title>
    <script language="JavaScript" src="script/trim.js"></script>
    <script>
      function check(){
      	if(document.all.sid.value.trim()==""){
      		alert("采购ID不能为空!!!");
      		return false;
      	}
      	document.all.mf.submit();
      }
    </script>
  </head>
  <body>
   <body bgcolor="#EBF5FD">
 	<jsp:useBean id="userBean" class="wyf.zrk.UserBean" scope="session"/>
	<table width="100%" height="44" bgcolor="#206AB3">
      <tr align="center"><td>
        <font color="#FFFFFF" size="5">采购退货管理</font>
        <font color="#FFFFFF" size="2">--退货添加</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="javascript:history.back()">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<hr color="black" size="1"/>
    <br/><br/><br/><br/><br/>
    <form action="ManageServlet" method="post" id="mf">
    <center>
      请选择要退货的表单号:
  	  <select name="sid" id="sid">
  	  <% 
		//获取WebApplicationContext
		WebApplicationContext wac=
		   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DButil db = (DButil)wac.getBean("DButil");
		String hql = "select si.sid from StockInfo as si";
		List<String> sid = (List<String>)db.getInfo(hql);
		for(String name:sid){
			name = new String(name.getBytes("ISO-8859-1"),"gbk");
  	    %>
  	    	<option value="<%= name %>"><%= name %></option>
  	    <% 
  	    	}
  	     %>
  	  </select>
    <br/><br/><img border="0" src="img/xg.gif" id="xg" onclick="JavaScript:check()"
          	  style="cursor:hand"
          	  onmouseover="document.all.xg.src='img/xga.gif'"
          	  onmouseout="document.all.xg.src='img/xg.gif'"
          	  onmouseup="document.all.xg.src='img/xga.gif'"        	
          	  onmousedown="document.all.xg.src='img/xgb.gif'"/>
	    <img border="0" src="img/cze.gif" id="cz" onclick="JavaScript:document.all.mf.reset()"
          	  style="cursor:hand"
          	  onmouseover="document.all.cz.src='img/czd.gif'"
          	  onmouseout="document.all.cz.src='img/cze.gif'"
          	  onmouseup="document.all.cz.src='img/czd.gif'"        	
          	  onmousedown="document.all.cz.src='img/czc.gif'"/>
    <input type="hidden" name="action" value="addProviderBack"/>
    </center>
    </form>
  </body>
</html>