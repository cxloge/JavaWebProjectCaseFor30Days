<%@ page contentType="text/html;charset=gbk" 
    import="java.util.*,wyf.zrk.GoodsInfo,wyf.zrk.UserBean,
    wyf.zrk.DButil,org.springframework.web.context.*,
    org.springframework.web.context.support.*,wyf.zrk.GoodsClassInfo"
%>    
<% 
	List<GoodsInfo> goodslist = (List<GoodsInfo>)request.getAttribute("goodslist");
 %>
<html>
  <head>
    <title>商品管理</title>
	<link rel=stylesheet href="css/general.css" type="text/css">
    <script language="JavaScript" src="script/trim.js"></script>
    <script language="JavaScript">
      function check(){
      	var key = document.all.key.value.trim();
      	if(key==""){
			alert("关键字为空,请重新输入!!!");
			return;
      	}
      	document.all.smf.submit();
      }
      function checkPage(temp){
      	var page = document.all.page.value.trim();
  		var reg = /^[1-9][0-9]*$/;
		if((reg.test(page.trim()))&&(page<=temp)){
			document.all.mf.submit();
		}
		else{
			alert("输入不合法,请重新输入!!!");
			return;
		}
      }
    </script>
  </head>
  <body bgcolor="#EBF5FD">
  	<jsp:useBean id="userBean" class="wyf.zrk.UserBean" scope="session"/>
	<table width="100%" height="44" bgcolor="#206AB3">
      <tr align="center"><td><font color="#FFFFFF" size="5">商品资料管理</font></td></tr>
	</table>	
	<table>
	<form action="ManageServlet" method="post" id="smf">
	  <tr>
	    <td>
		<table height="42" style="background:url(img/goods_sear.jpg) no-repeat">
		  <tr>
		    <td>
		      &nbsp;<img src="img/log.gif" border="0" style="cursor:hand" onclick="document.all.key.focus()"/>
		    </td>
		    <td>
		      <input name="key" id="key" value="请输入要搜索的商品名称" style="border:0"
		      		 size="28"	onfocus="document.all.key.value=''"/>		    
		    </td>
		    <td width="86" align="right">
		    <img src="img/sear.jpg" id="mg" border="0"
		      style="cursor:hand"
		      onclick="JavaScript:check()"
		      onmousedown="document.all.mg.src='img/sear1.jpg'"
		      onmouseup="document.all.mg.src='img/sear.jpg'"/>
		    </td>
		    <td width="80" align="center">
 		      <input type="radio" name="myradio" value="name" checked="true"><font size="2" color="white">按名称</font>
	     	</td>
	     	<td width="80">
	     	  <input type="radio" name="myradio" value="class"><font size="2" color="white">按类别</font>
		    </td>
	    	<td width="80">
	    	  <a href="addgoods.jsp" target="mainFrame"><font size="2" color="white">添加商品</font></a>
	    	</td> 
		  </tr>
		</table>
	    </td>	    
		<td>
	      <input type="hidden" name="action" value="search" />
	      <input type="hidden" name="type" value="goodsinfo"/>
	    </td>	   
	  </tr>
	</form>
	</table>
	<hr size="1" width="100%" color="black"/>
	<% 
		if(goodslist.isEmpty()){
			out.println("<br/><br/><br/><center><h2>没有搜索到你要的商品!!!</h2></center>");
		}
		else{
	 %>
	<table width="100%" border="0" cellspacing="1" bgcolor="black">
	  <tr bgcolor="#D1F1FE" align="center">
	    <th>商品名称</th>
	    <th>类别</th>
	    <th>进价</th>
	  	<th>售价</th>
	  	<th>单位</th>
	  	<th>数量</th>
	  	<th>查看/修改</th>
	  	<th>删除</th>
	  </tr>
	<%
		//获取WebApplicationContext
		WebApplicationContext wac=
		   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		DButil db = (DButil)wac.getBean("DButil");
		int i = 0;
		for(GoodsInfo gi:goodslist){
		String gname = gi.getGname();
		String gcid = gi.getGcid();
		GoodsClassInfo gci = (GoodsClassInfo)db.getObject("GoodsClassInfo",gcid);
		int gamount = gi.getGamount();
		String gunit = gi.getGunit();
		double gpin = gi.getGpin();
		double gpout = gi.getGpout();
		if(i%2==0){
			i++;
			out.println("<tr bgcolor='white' align='center'>");
		}
		else{
			i++;
			out.println("<tr bgcolor='#EBF5FD' align='center'>");
		}
	 %>
	    <td><%= new String(gname.getBytes("ISO-8859-1"),"gbk") %></td>
	    <td><%= new String((gci.getGcname()).getBytes("ISO-8859-1"),"gbk") %></td>
	    <td>￥<%= gpin %></td>
	    <td>￥<%= gpout %></td>
	    <td><%= new String(gunit.getBytes("ISO-8859-1"),"gbk") %></td>
	    <td><%= gamount %></td>
	    <td width="120"><a href="ManageServlet?action=lookGoods&gid=<%= gi.getGid() %>" target="mainFrame"><img border="0" src="img/mod.gif" height="16" width="16"/>查看/修改</a></td>
	    <td width="100"><a href="JavaScript:delete_sure('ManageServlet?action=deleteGoods&gid=<%= gi.getGid()%>')" target="mainFrame"><img border="0" src="img/del.gif"/>删除</a></td>
	  </tr>
	<%
		}
	 %>
	</table>	
	<table width="100%">
	<form method="post" id="mf" action="ManageServlet">
	  <tr>
	    <td align="left">
	      <font size="2">共<%= userBean.getTotalPage() %>页&nbsp;&nbsp;当前页:<%= userBean.getNowPage() %></font>
	    </td>
	    <td align="right">
	      <% 
	      	if(userBean.getNowPage()>1){
	       %>
	      <a href="ManageServlet?action=changePage&pagename=/goodsmanage.jsp&page=<%= userBean.getNowPage()-1 %>" target="mainFrame"><img src="img/prev.gif" border="0"/></a>
	      <% 
	      	}
	      	if(userBean.getNowPage()<userBean.getTotalPage()){
	       %>	       
	      <a href="ManageServlet?action=changePage&pagename=/goodsmanage.jsp&page=<%= userBean.getNowPage()+1 %>" target="mainFrame"><img src="img/next.gif" border="0"/></a>
	      <% 
	      	}
	      	else{
	      		out.println("<img src='img/next.gif' style='visibility:hidden'/>");
	      	}
	       %>
	      <font size="2">第<input name="page" id="page" value="<%= userBean.getNowPage() %>" size="2" onfocus="document.all.page.value=''"/>页</font>
	      <input type="hidden" name="action" value="changePage" />
	      <input type="hidden" name="pagename" value="/goodsmanage.jsp"/>	    
	    </td>
	    <td width="10">
	      <img src="img/go.gif" border="0" style="cursor:hand" onclick="JavaScript:checkPage(<%= userBean.getTotalPage() %>)">
	    </td>
	  </tr>	
	</form>
	</table>
	<% 
		}
	 %>
  </body>
</html>