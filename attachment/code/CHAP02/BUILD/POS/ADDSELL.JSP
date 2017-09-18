<%@ page contentType="text/html;charset=gbk"
	import="wyf.zrk.UserBean,org.springframework.web.context.*,
	org.springframework.web.context.support.*,wyf.zrk.DButil,java.util.*"
 %>
<html>
  <head>
    <title>销售信息添加</title>
    <script language="JavaScript" src="script/trim.js"></script>
    <script language="JavaScript">
      function check(){
        var reg = /^\d+(\.\d+)?$/;								//用来匹配double型数据
        var etp = document.all.etotalprice.value.trim();		//得到价格
      	if(!reg.test(etp)){
      	  alert("采购总价格式不对,请重新输入!!!");
      	  return false;
      	}
      	if(document.all.eseller.value.trim()==""){
      	  alert("采购人不能为空!!!");
      	  return false;
      	}
      	if(document.all.cname.value.trim()==""){
      	  alert("客户不能为空,请添加客户!!!");
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
        <font color="#FFFFFF" size="5">销售信息管理</font>
        <font color="#FFFFFF" size="2">--销售添加</font>
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
	    <td align="center">客户姓名:</td>
	    <td>
      	  <select name="cname" id="cname">
      	  <% 
			//获取WebApplicationContext
			WebApplicationContext wac=
			   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			DButil db = (DButil)wac.getBean("DButil");
			List<String> cname = db.getConsumer();
			for(String name:cname){
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
	    <td align="center">销售总价:</td>
	    <td><input name="etotalprice" id="etotalprice"/></td>
	  </tr>
	  <tr bgcolor="white">
	    <td align="center">销&nbsp;售&nbsp;人:</td>
	    <td><input name="eseller" id="eseller"/></td>
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
	<input type="hidden" name="action" value="addSell"/>
	</form>
  </body>
</html>