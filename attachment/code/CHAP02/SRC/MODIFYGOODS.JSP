<%@ page contentType="text/html;charset=gbk" 
	import="wyf.zrk.UserBean,org.springframework.web.context.*,
	org.springframework.web.context.support.*,wyf.zrk.DButil,java.util.*,
	wyf.zrk.GoodsInfo,wyf.zrk.GoodsClassInfo"
%>
<html>
  <head>
    <title>查看/修改商品</title>
     <script language="JavaScript" src="script/trim.js"></script>
     <script language="JavaScript">
       function check(){
       	 var gunit = document.all.gunit.value.trim();		//得到商品单位
       	 var gpin = document.all.gpin.value.trim();			//得到商品进价
       	 var gpout = document.all.gpout.value.trim();		//得到商品售价
       	 var gamount = document.all.gamount.value.trim();	//得到商品数量
       	 if(gunit==""){										//商品单位为空
       	 	alert("商品单位不可以为空!!!");
       	 	return;
       	 }
       	 var reg = /^([1-9][0-9]*(\.?[0-9]+)?)|(0\.[0-9]+)$/;//定义正则式
       	 if(!reg.test(gpin)){								//当进价格式不对时
       	 	alert("商品进价格式不对!!!");
       	 	return;
       	 }
       	 if(!reg.test(gpout)){								//当售价格式不对时
       	 	alert("商品售价格式不对!!!");
       	 	return;
       	 }
       	 var reg1 = /^[0-9]*$/;								//定义正则式,只匹配整数(除0外)
       	 if(!reg1.test(gamount)){							//库存格式错误
       	 	alert("商品数量格式不对!!!");
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
        <font color="#FFFFFF" size="5">商品资料管理</font>
        <font color="#FFFFFF" size="2">--商品修改</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="javascript:history.back()">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<hr color="black" size="1"/>
	<% 
		GoodsInfo gi = (GoodsInfo)request.getAttribute("object");
	 %>
	<form action="ManageServlet" method="post" id="mf">
	<table width="80%" border="0" cellspacing="1" bgcolor="black" align="center">	
	  <tr bgcolor="white">
	    <td align="center">商品名称:</td>
	    <td><%= new String(gi.getGname().getBytes("ISO-8859-1"),"gbk") %></td>
	  </tr>
	  <tr bgcolor="white">
	  	<td align="center">商品类别:</td>
	  	<td>
      	  <select name="gcname">
      	  <% 
			//获取WebApplicationContext
			WebApplicationContext wac=
			   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			DButil db = (DButil)wac.getBean("DButil");
			List<String> gcname = db.getGoodsClass();
			GoodsClassInfo gci = (GoodsClassInfo)db.getObject("GoodsClassInfo",gi.getGcid());
			for(String name:gcname){
				name = new String(name.getBytes("ISO-8859-1"),"gbk");
  	   			String flag = "";
  	   			if(name.equals(new String(gci.getGcname().getBytes("ISO-8859-1"),"gbk"))){
  	   				flag = "selected";
  	   			}
      	    %>
      	    	<option value="<%= name %>" <%= flag %>><%= name %></option>
      	    <% 
      	    	}
      	     %>
      	  </select>
	  	</td>
	  </tr>
	  <tr bgcolor="white">
	  	<td align="center">计量单位:</td>
	  	<td><input name="gunit" id="gunit" 
	  		value="<%= new String(gi.getGunit().getBytes("ISO-8859-1"),"gbk") %>"/></td>
	  </tr>
	  <tr bgcolor="white">
	  	<td align="center">进&nbsp;&nbsp;&nbsp;&nbsp;价:</td>
	  	<td><input name="gpin" id="gpin" value="<%= gi.getGpin() %>"/></td>
	  </tr>
	  <tr bgcolor="white">
	  	<td align="center">售&nbsp;&nbsp;&nbsp;&nbsp;价:</td>
	  	<td><input name="gpout" id="gpout" value="<%= gi.getGpout() %>"/></td>
	  </tr>
	  <tr bgcolor="white">
	  	<td align="center">商品数量:</td>
	  	<td><input name="gamount" id="gamount" value="<%= gi.getGamount() %>"/></td>
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
	<input type="hidden" name="action" value="modifyGoods"/>
	<input type="hidden" name="gid" value="<%= gi.getGid() %>"/>
	<input type="hidden" name="gname" value="<%= new String(gi.getGname().getBytes("ISO-8859-1"),"gbk") %>"/>
	</form>
  </body>
</html>