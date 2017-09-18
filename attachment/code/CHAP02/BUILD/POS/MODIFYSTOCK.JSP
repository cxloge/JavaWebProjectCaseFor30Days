<%@ page contentType="text/html;charset=gbk"
	import="wyf.zrk.StockInfo,wyf.zrk.StockDetail,java.util.*,wyf.zrk.DButil,
		org.springframework.web.context.*,org.springframework.web.context.support.*,
		wyf.zrk.ProviderInfo,wyf.zrk.GoodsInfo,wyf.zrk.UserBean"
 %>
<% 
	StockInfo si = (StockInfo)request.getAttribute("si");
	List<StockDetail> list = (List<StockDetail>)request.getAttribute("list");
	//获取WebApplicationContext
	WebApplicationContext wac=
	   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	DButil db = (DButil)wac.getBean("DButil");
	ProviderInfo pi = (ProviderInfo)db.getObject("ProviderInfo",si.getPid());
	String day = (si.getSdate().getYear()+1900)+"-"+(si.getSdate().getMonth()+1)
							+"-"+(si.getSdate().getDate());
 %>
<html>
  <head>
    <title>采购修改</title>
    <link rel=stylesheet href="css/general.css" type="text/css">
    <script language="JavaScript" src="script/trim.js"></script>
    <script language="JavaScript">
      function checkInfo(){
      	var date = document.all.sdate.value.trim();
      	reg = /^\d{4}-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2][0-9])|(3[0-1]))$/
      	if(!reg.test(date)){
      		alert("日期格式不对,应为yyyy-mm-dd");
      		return;
      	}
      	if(document.all.sbuyer.value.trim()==""){
      		alert("采购人不能为空!!!");
      		return;
      	}    	
      	document.all.mf.submit();
      }
      function checkDetail(myform,amount){
      	reg = /^[1-9][0-9]*$/
      	if(!reg.test(amount.trim())){
      		alert("商品数量格式不对!!!");
      		return;
      	}
      	myform.submit();
      }
    </script>
  </head>
  <body bgcolor="#EBF5FD">
 	<jsp:useBean id="userBean" class="wyf.zrk.UserBean" scope="session"/>
	<table width="100%" height="44" bgcolor="#206AB3">
      <tr align="center"><td>
        <font color="#FFFFFF" size="5">采购信息管理</font>
        <font color="#FFFFFF" size="2">--采购修改</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="ManageServlet?action=changePage&page=<%= userBean.getNowPage() %>&pagename=/stockmanage.jsp">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<hr color="black" size="1"/>
	<form method="post" action="ManageServlet" id="mf">
	<table width="100%" border="0" cellspacing="1" bgcolor="black">
	<caption>采购信息</caption>
	  <tr bgcolor="#D1F1FE" align="center">
	    <th>表单号</th>
	    <th>供应商</th>
	    <th>采购日期</th>
	  	<th>总价</th>
	  	<th>采购人</th>
	  </tr>
	  <tr bgcolor="white" align="center">
		<td><%= si.getSid() %></td>
		<td>
      	  <select name="pname">
      	  <% 
			List<String> pname = db.getProvider();
			for(String name:pname){
				name = new String(name.getBytes("ISO-8859-1"),"gbk");
  	   			String flag = "";
  	   			if(name.equals(new String(pi.getPname().getBytes("ISO-8859-1"),"gbk"))){
  	   				flag = "selected";
  	   			}
      	    %>
      	    	<option value="<%= name %>" <%= flag %>><%= name %></option>
      	    <% 
      	    	}
      	     %>
      	  </select>
		</td>
	     <td><input name="sdate" id="sdate" value="<%= day %>"/></td>
		<td><%= si.getStotalprice() %></td>
		<td><input name="sbuyer" id="sbuyer" value="<%= new String(si.getSbuyer().getBytes("ISO-8859-1"),"gbk") %>" /></td>
	  </tr>
	</table>
	<table align="center">
	  <tr>
	    <td><img border="0" src="img/xg.gif" id="xg" onclick="JavaScript:checkInfo()"
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
	  <input type="hidden" name="action" value="modifyStock"/>
	  <input type="hidden" name="sid" value="<%= si.getSid() %>"/>
	</table>
	</form>
	<% 
		if(!list.isEmpty()){
	 %>
	<table width="100%" border="0" cellspacing="1" bgcolor="black">
	<caption>采购明细</caption>
	  <tr bgcolor="#D1F1FE" align="center">
	    <th>商品名称</th>
	    <th>商品数量</th>
	    <th>商品单价</th>
	    <th>商品总价</th>
	    <th>修&nbsp;&nbsp;改</th>
	    <th>删&nbsp;&nbsp;除</th>
	  </tr>
	  <% 
	  	int i = 0;
	  	for(StockDetail sd:list){
		GoodsInfo gi = (GoodsInfo)db.getObject("GoodsInfo",sd.getGid());
		if(i%2==0){
			i++;
			out.println("<tr bgcolor='white' align='center'>");
		}
		else{
			i++;
			out.println("<tr bgcolor='#EBF5FD' align='center'>");
		}
	   %>
	   	<form id="mfd<%= i %>" method="post" action="ManageServlet">
	   	<input type="hidden" name="action" value="modifyStockDetail"/>
	   	<input type="hidden" name="sdid" value="<%= sd.getSdid() %>"/>
	  	<td><%= new String(gi.getGname().getBytes("ISO-8859-1"),"gbk") %></td>
	  	<td><input name="sdamount" id="amount<%= i %>" value="<%= sd.getSdamount() %>"/></td>
	  	<td><%= sd.getSdprice() %></td>
	  	<td><%= sd.getSdtotalprice() %></td>
	  	<td width="100"><a href="JavaScript:checkDetail(document.all.mfd<%= i %>,document.all.amount<%= i %>.value)"><img border="0" src="img/mod.gif" height="16" width="16"/>修改</a></td>
	  	<td width="100"><a href="JavaScript:delete_sure('ManageServlet?action=deleteStockDetail&sdid=<%= sd.getSdid() %>&sid=<%= sd.getSid() %>')"><img border="0" src="img/del.gif"/>删除</a></td>
	 	</form>
	  </tr> 
	  <% 
	  	}
	   %>
	</table>
	<% 
		}
	 %>
  </body>
</html>