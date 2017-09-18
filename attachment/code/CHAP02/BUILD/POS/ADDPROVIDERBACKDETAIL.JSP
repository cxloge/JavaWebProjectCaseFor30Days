<%@ page contentType="text/html;charset=gbk"
	import="wyf.zrk.ProviderBack,wyf.zrk.ProviderBackDetail,java.util.*,wyf.zrk.DButil,
		org.springframework.web.context.*,org.springframework.web.context.support.*,
		wyf.zrk.ProviderInfo,wyf.zrk.GoodsInfo"
 %>
<% 
	ProviderBack pb = (ProviderBack)request.getAttribute("pb");
	List<ProviderBackDetail> list = (List<ProviderBackDetail>)request.getAttribute("list");
	//获取WebApplicationContext
	WebApplicationContext wac=
	   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	DButil db = (DButil)wac.getBean("DButil");
	ProviderInfo pi = (ProviderInfo)db.getObject("ProviderInfo",pb.getPid());
 %>
<html>
  <head>
    <title>明细添加</title>
    <script language="JavaScript" src="script/trim.js"></script>
    <script>
      function check(){
      	if(document.all.gname.value.trim()==""){
      		alert("商品名称不能为空,请添加商品!!!");
      		return false;
      	}
      	var reg = /^[1-9][0-9]*$/;
      	if(!reg.test(document.all.pbdamount.value.trim())){
      	  	alert("数量格式不对,请重新输入!!!");
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
        <font color="#FFFFFF" size="5">采购退货管理</font>
        <font color="#FFFFFF" size="2">--明细添加</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="ManageServlet?action=changePage&page=<%= userBean.getNowPage() %>&pagename=/providerbackmanage.jsp">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<hr color="black" size="1"/>
	<table width="100%" border="0" cellspacing="1" bgcolor="black">
	<caption>退货信息</caption>
	  <tr bgcolor="#D1F1FE" align="center">
	    <th>表单号</th>
	    <th>供应商</th>
	    <th>采购表号</th>
	  	<th>退货时间</th>	
	  </tr>
	  <tr bgcolor="white" align="center">
	     <td><%= pb.getPbid() %></td>
	     <td><%= new String(pi.getPname().getBytes("ISO-8859-1"),"gbk") %></td>
	     <td><%= pb.getSid() %></td>
	     <td><%= (pb.getPbdate().getYear()+1900)+"-"+
	     		(pb.getPbdate().getMonth()+1)+"-"+(pb.getPbdate().getDate()) %></td>
	  </tr>
	</table>
	<form method="post" action="ManageServlet" id="mf">
	<font color="red" size="3">请在下表添加退货商品及数量.</font>
	<table width="100%" border="0" cellspacing="1" bgcolor="black">
	<caption>退货明细</caption>
	  <tr bgcolor="#D1F1FE" align="center">
	    <th>商品名称</th>
	    <th>商品数量</th>
	    <th>添加</th>
	  </tr>
	  <% 
	  	int i = 0;
	  	for(ProviderBackDetail pbd:list){
		GoodsInfo gi = (GoodsInfo)db.getObject("GoodsInfo",pbd.getGid());
		if(i%2==0){
			i++;
			out.println("<tr bgcolor='white' align='center'>");
		}
		else{
			i++;
			out.println("<tr bgcolor='#EBF5FD' align='center'>");
		}
	   %>
	  	<td><%= new String(gi.getGname().getBytes("ISO-8859-1"),"gbk") %></td>
	  	<td><%= pbd.getPbdamount() %></td>
	  	<td>--</td>
	  </tr> 
	  <% 
	  	}
	   %>
	  <tr bgcolor="white" align="center">
	    <td>
      	  <select name="gname" id="gname">
      	  <% 
      	  	String hql = "select gi.gname from GoodsInfo as gi "+
      	  			"where gi.gid in(select sd.gid from StockDetail "+
      	  			"as sd where sd.sid='"+pb.getSid()+"')";
			List<String> gname = (List<String>)db.getInfo(hql);
			for(String name:gname){
				name = new String(name.getBytes("ISO-8859-1"),"gbk");
      	    %>
      	    	<option value="<%= name %>"><%= name %></option>
      	    <% 
      	    	}
      	     %>
      	  </select>
	    </td>
	    <td><input name="pbdamount" id="pbdamount"/></td>
	    <td><img border="0" src="img/tj.gif" id="tj" onclick="JavaScript:check()"
          	  style="cursor:hand"
          	  onmouseover="document.all.tj.src='img/tja.gif'"
          	  onmouseout="document.all.tj.src='img/tj.gif'"
          	  onmouseup="document.all.tj.src='img/tja.gif'"        	
          	  onmousedown="document.all.tj.src='img/tjb.gif'"/></td>
	  </tr>
	  <input type="hidden" name="action" value="addProviderBackDetail"/>
	  <input type="hidden" name="pbid" value="<%= pb.getPbid() %>"/>
	</table>
	</form>
  </body>
</html>