<%@ page contentType="text/html;charset=gbk"
	import="wyf.zrk.ConsumerBack,wyf.zrk.ConsumerBackDetail,java.util.*,wyf.zrk.DButil,
		org.springframework.web.context.*,org.springframework.web.context.support.*,
		wyf.zrk.ConsumerInfo,wyf.zrk.GoodsInfo"
 %>
<% 
	ConsumerBack cb = (ConsumerBack)request.getAttribute("cb");
	List<ConsumerBackDetail> list = (List<ConsumerBackDetail>)request.getAttribute("list");
	//获取WebApplicationContext
	WebApplicationContext wac=
	   WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	DButil db = (DButil)wac.getBean("DButil");
	ConsumerInfo ci = (ConsumerInfo)db.getObject("ConsumerInfo",cb.getCid());
 %>
<html>
  <head>
    <title>退货修改</title>  
    <link rel=stylesheet href="css/general.css" type="text/css">
    <script language="JavaScript" src="script/trim.js"></script>
    <script language="JavaScript">
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
        <font color="#FFFFFF" size="5">客户退货管理</font>
        <font color="#FFFFFF" size="2">--退货修改</font>
      </td></tr>
	</table>
	<table>
	  <tr><td><a href="JavaScript:history.back()">
	    <img border="0" src="img/back.jpg"/></a>
	  </td></tr>
	</table>
	<hr color="black" size="1"/>
	<table width="100%" border="0" cellspacing="1" bgcolor="black">
	<caption>退货信息</caption>
	  <tr bgcolor="#D1F1FE" align="center">
	    <th>表单号</th>
	    <th>客户名称</th>
	    <th>销售表号</th>
	  	<th>退货时间</th>	
	  </tr>
	  <tr bgcolor="white" align="center">
	     <td><%= cb.getCbid() %></td>
	     <td><%= new String(ci.getCname().getBytes("ISO-8859-1"),"gbk") %></td>
	     <td><%= cb.getEid() %></td>
	     <td><%= (cb.getCbdate().getYear()+1900)+"-"+
	     		(cb.getCbdate().getMonth()+1)+"-"+(cb.getCbdate().getDate()) %></td>
	  </tr>
	</table>
	<% 
		if(!list.isEmpty()){
	 %>
	<table width="100%" border="0" cellspacing="1" bgcolor="black">
	<caption>退货明细</caption>
	  <tr bgcolor="#D1F1FE" align="center">
	    <th>商品名称</th>
	    <th>商品数量</th>
	    <th>商品售价</th>
	    <th>商品总价</th>
	    <th>修改</th>
	    <th>删除</th>
	  </tr>
	  <% 
	  	int i = 0;
	  	for(ConsumerBackDetail cbd:list){
		GoodsInfo gi = (GoodsInfo)db.getObject("GoodsInfo",cbd.getGid());
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
	   	<input type="hidden" name="action" value="modifyConsumerBackDetail"/>
	   	<input type="hidden" name="cbdid" value="<%= cbd.getCbdid() %>"/>
	  	<td><%= new String(gi.getGname().getBytes("ISO-8859-1"),"gbk") %></td>
	  	<td><input name="cbdamount" id="amount<%= i %>" value="<%= cbd.getCbdamount() %>"/></td>
	  	<td><%= cbd.getCbdprice() %></td>
	  	<td><%= cbd.getCbdtotalprice() %></td>
	  	<td width="100"><a href="JavaScript:checkDetail(document.all.mfd<%= i %>,document.all.amount<%= i %>.value)"><img border="0" src="img/mod.gif" height="16" width="16"/>修改</a></td>
	  	<td width="100"><a href="JavaScript:delete_sure('ManageServlet?action=deleteConsumerBackDetail&cbdid=<%= cbd.getCbdid() %>&cbid=<%= cbd.getCbid() %>')"><img border="0" src="img/del.gif"/>删除</a></td>
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