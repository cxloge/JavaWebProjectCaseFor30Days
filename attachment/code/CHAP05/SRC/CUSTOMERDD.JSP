<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*,wyf.hxl.DB"%>
<html>
  <head>
    <link href="script/style.css" rel="stylesheet" type="text/css"/>
    <script language="javascript" src="script/trim.js"></script>    
    <script language="javascript">
       function check(temp,mmf){
      	if(temp=="mod"){
      	
      		mmf.action.value="ordercx";
      	}
      	mmf.submit();
      }
   
    </script>
  </head>
 <body  style="background:url('img/top/bg.gif')">   
          <a href='CustomerServlet?action=modify2'><img src="img/left_green.png"/>单击这里返回</a>
	      <hr></hr>
	   
<table style="border:1px solid #6daafc" cellspacing="5" bgcolor="#d2e9ff">
	<tr>
		<td>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
				  <% 
	 	 String[] str=(String[])request.getAttribute("list");
			 %>
  					<td colspan="3" align="center" height="40" border="1">
  						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  						<b style="font-size:1.5em"><%= str[0]%>号订单</b>&nbsp;
  						<b style="font-size:1.2em">(<%= str[5] %>)</b>
  					</td>
				</tr>
				<tr>
				  <td width="350" align="left" height="20" border="0"><b>收货人姓名:</b><%= str[1] %></td>
				  <td width="350" align="left" height="20" border="0"><b>收货人地址:</b><%= str[2] %></td>
				  <td>&nbsp;</td>
				</tr>
				<tr>
				  <td width="350" align="left" height="20" border="0"><b>收货人电话:</b><%= str[3] %></td>
				  <td width="350" align="left" height="20" border="0"><b>订单总价格:</b>
				  ￥<%= (str[4].indexOf(".")==-1)?str[4]+".00":str[4]%>元</td>
				  <td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table width="100%" cellpadding="1" cellspacing="1" bgcolor="black">
	      		<form action="CustomerServlet" method="post">
				    <input id="aa" type="hidden" name="action" value="orderxiugai"/>
				    <input name="orderidname" type="hidden" value="<%= str[0]%>">
	      
	      <%
	      
	      String sql4 = "select goodsid,goodsname,gprice,orderamount,buytime from"
	      +" ordergoodsmeg where oid="+Integer.parseInt(str[0]);
	      	String sql2 = new String(sql4.getBytes(),"ISO-8859-1");
	      	Vector<String[]> vvv =(Vector<String[]>)DB.getMessage(sql2);
	      	if(vvv.size()==0)
	      	{
	      		out.println("没有相关信息！");
	      	}
	      	else
	      	{
	      	%>
	      	 
		      <tr>
		        <th bgcolor="#d2e9ff" width="200" align="center" height="30">商品ID</th>
			    <th bgcolor="#d2e9ff" width="200" align="center" height="30">商品名</th>
			    <th bgcolor="#d2e9ff" width="200" align="center" height="30">价格</th>
			    <th bgcolor="#d2e9ff" width="200" align="center" height="30">数量</th>
			    <th bgcolor="#d2e9ff" width="200" align="center" height="30">购买时间</th> 
		      </tr>
			<% 
			for(String[] str1:vvv)
			{
				
			%>	<tr align="center">
	       		<td bgcolor="#d2e9ff" bgcolor="white" width="200" align="center" height="20"><%= str1[0] %></td>
	       		<td bgcolor="#d2e9ff" width="200" align="center" height="20">
	       		<%= str1[1] %> </td>
	       		<td bgcolor="#d2e9ff" bgcolor="white" width="200" align="center" height="20">￥<%= (str1[2].indexOf(".")==-1)?str1[2]+".00":str1[2]%>元</td>
	       		<td bgcolor="#d2e9ff" width="200" align="center" height="20"><%= str1[3] %></td>
	       		<td bgcolor="#d2e9ff" bgcolor="white" width="200" align="center" height="20">
	       
	      
	       		<%= (str1[4].length()>19)?str1[4].substring(0,19):str1[4]%></td>
	
	      </tr>
          <% 
        	} 
       	} %>
       	</form>
       	</table>
       	<br/>
</td>
</tr>
</table>
  <table align="center">
  <tr>
  <%  if(str[5].trim().equals("未发送"))
  {%>
       	<td>
       	<a href="CustomerServlet?action=modify&oid=<%= str[0]%>">
	       	<img border="0" id="xg"
			 onmousedown="document.all.xg.src='img/other/xg1.png'" 
	    	 onmousemove="document.all.xg.src='img/other/xg2.png'" 
	    	 onmouseout="document.all.xg.src='img/other/xg3.png'"
	    	 src="img/other/xg1.png" style="cursor:hand" />
		</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
   		<a href="CustomerServlet?action=delete1&oid=<%= str[0]%>">
       		<img border="0" id="sc"
			 onmousedown="document.all.sc.src='img/other/sc1.png'" 
	    	 onmousemove="document.all.sc.src='img/other/sc2.png'" 
	    	 onmouseout="document.all.sc.src='img/other/sc3.png'"
	    	 src="img/other/sc1.png" style="cursor:hand" />
			</a>
		</td>
       	<% } %></tr>
  </table>
	        <hr></hr>
	        
	        <tr align="left"><td><a href='CustomerServlet?action=modify2'>
	        <img src="img/left_green.png"/>单击这里返回</a></td></tr>

  </body>
</html>