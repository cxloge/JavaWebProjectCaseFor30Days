<%@ page contentType="text/html;charset=gbk" 
	import="wyf.zrk.UserBean,wyf.zrk.AdminInfo,java.util.*,
	org.springframework.web.context.*,org.springframework.web.context.support.*,
	wyf.zrk.DButil"
%>
<% 
	//获取WebApplicationContext
	WebApplicationContext wac=
	   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	DButil db = (DButil)wac.getBean("DButil");
 %>
<html>
  <head>
    <title>密码重置</title>
    <script language="JavaScript" src="script/trim.js"></script>
    <script language="JavaScript">
      function check(){
      	if(document.all.aname.value.trim()==""){
      	  alert("管理员名称不能为空!!!");
      	  return false;
      	}
      	if(document.all.apwd.value.trim()==""){
      	  alert("密码不能为空!!!");
      	  return false;
      	}
      	if(document.all.apwd.value.trim()!=document.all.fpwd.value.trim()){
      	  alert("两次密码输入不一致!!!");
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
        <font color="#FFFFFF" size="5">管理员管理</font>
        <font color="#FFFFFF" size="2">--密码重置</font>
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
	    <td align="center">管理员名称:</td>
	    <td>
      	  <select name="aname">
      	  <% 
			List<String> aname = db.getAdmin();
			for(String name:aname){
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
	    <td align="center">新&nbsp;密&nbsp;码:</td>
	    <td><input type="password" name="apwd" id="apwd"/></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">确认密码:</td>
	    <td><input type="password" name="fpwd" id="fpwd"/></td>
	  </tr>
	</table>
	<table align="center">
	  <tr>
	    <td><img border="0" src="img/xg.gif" id="xg" onclick="JavaScript:check()"
          	  style="cursor:hand"
          	  onmouseover="document.all.xg.src='img/xga.gif'"
          	  onmouseout="document.all.xg.src='img/xg.gif'"
          	  onmouseup="document.all.xg.src='img/xga.gif'"        	
          	  onmousedown="document.all.xg.src='img/xgb.gif'"/></td>
	    <td><img border="0" src="img/cze.gif" id="cz" onclick="JavaScript:document.all.mf.reset()"
          	  style="cursor:hand"
          	  onmouseover="document.all.cz.src='img/czd.gif'"
          	  onmouseout="document.all.cz.src='img/cze.gif'"
          	  onmouseup="document.all.cz.src='img/czd.gif'"        	
          	  onmousedown="document.all.cz.src='img/czc.gif'"/></td>
	  </tr>
	</table>
	<input type="hidden" name="action" value="resetApwd"/>
	</form>
  </body>
</html>