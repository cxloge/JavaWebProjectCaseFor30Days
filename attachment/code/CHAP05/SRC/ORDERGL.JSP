<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*,wyf.hxl.DB"%>
<html>
  <head>
    <title></title>
   <jsp:useBean id="spSearch" class="wyf.hxl.ManageBean" scope="session"/>
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
  
		function qingchu()
	    {  
	        document.all.searchorder.value="";
	    }
		function checkSearch()
		{ 
			var flag=document.searchs.searchorder.value;
			if(flag.trim()=="")
			{	
				alert("请输入要查找商品的关键字！！");
				return;
			}
			var reg = /^[0-9]+$/;
			if(!reg.test(flag.trim()))
			{
				alert("请输入数字！！");
				return;}
			document.searchs.submit();
		}
		function check(temp,mmf){
      	if(temp=="mod"){
      	
      		mmf.action.value="orderxiugai";
      	}
      	mmf.submit();
      	}
    </script>
  </head>
<body  style="background:url('img/top/bg.gif')">   
	<form action="ManageServlet" name="searchs" method="post" target="mainFrame">

 			<table width="100%" border="0" height="42" style="background:url(img/top/search.gif) no-repeat">
	      	<tr>
	      	  <td width="198">&nbsp;<input name="searchorder" id="searchorder"
	      	   value="请输入订单号" onclick="qingchu()" size="11" style="border:0" /></td>
	      	  <td align="center"><input name="action" type="hidden" value="searchorder">
	      	  <td><img id="sear" src="img/top/bt.gif" onclick="checkSearch()" style="cursor:hand" 
	      	  		 onmousedown="Javascript:document.all.sear.src='img/top/bt1.gif'"
	      	  		 onmouseup="Javascript:document.all.sear.src='img/top/bt.gif'"/>
	      	  </td>
	      	</tr>	      	
	      </table>
	</form>  	
	<%	
		Vector<String[]> vv = (Vector<String[]>)request.getAttribute("vv");
	    int i=0;	
	    for(String[] str:vv)
		{
			i++;
	%>	 
	
<table style="border:1px solid #6daafc" cellspacing="5" bgcolor="#e3fcff">
<tr>
<td>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
  <td colspan="3" bgcolor="#e3fcff" align="center" height="40" border="0">
  <b style="font-size:1.5em"><%= str[0]%>号订单</b>

  </td>
</tr>
<tr><td bgcolor="#e3fcff" width="250" align="center" height="20"><b>发订单人:</b><%= str[1] %></td>
		      <td bgcolor="#e3fcff" width="250" align="center" height="20"><b>收货人姓名:</b><%= str[2] %><b>收货人地址:</b></td>
		      <td bgcolor="#e3fcff"  height="20" width="250"><%= str[3] %></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
 <td bgcolor="#e3fcff" width="250" align="center" height="20"><b>收货人电话:</b><%= str[4] %></td>
		      <td bgcolor="#e3fcff" width="250" align="center" height="20"><b>总价格:</b>
		      ￥<%= (str[5].indexOf(".")==-1)?str[5]+".00":str[5]%>元</td>
		      <td bgcolor="#e3fcff" width="250" align="center" height="20"><b>订单状态:</b>
		      <font color="red"><%= str[6] %></font></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
</table>
<table border="1" bgcolor="black" cellpadding="1" cellspacing="1">
<form action="ManageServlet" method="post" name="mf<%= i %>">
	      <% 
	     	 String sql4 = "select goodsid,goodsname,gprice,orderamount,buytime from"
		      	+" ordergoodsmeg where oid="+Integer.parseInt(str[0]);
		     String sql2 = new String(sql4.getBytes(),"ISO-8859-1");
		     Vector<String[]> vvv = DB.getMessage(sql2);
		 
	      	if(vvv.size()==0)
	      	{
	      		out.println("没有相关信息！");
	      	}
	      	else
	      	{%>
	      	 
		      <tr>
		        <th bgcolor="#e3fcff" width="200" align="center" height="30">商品ID</th>
			    <th bgcolor="#e3fcff" width="200" align="center" height="30">商品名</th>
			    <th bgcolor="#e3fcff" width="200" align="center" height="30">价格</th>
			    <th bgcolor="#e3fcff" width="200" align="center" height="30">数量</th>
			    <th bgcolor="#e3fcff" width="200" align="center" height="30">购买时间</th> 
		      </tr>
			<% 
				for(String[] str1:vvv)
				{%>	<tr align="center">
	       		<td bgcolor="#e3fcff" width="200" align="center" height="20"><%= str1[0] %></td>
	       		<td bgcolor="#e3fcff" width="200"><%= str1[1] %></td>
	       		<td bgcolor="#e3fcff" width="200">￥<%= (str1[2].indexOf(".")==-1)?str1[2]+".00":str1[2]%>元</td>
	       		<td bgcolor="#e3fcff" width="200"><%= str1[3] %></td>
	       		<td bgcolor="#e3fcff" width="200"><%= (str1[4].length()>19)?str1[4].substring(0,19):str1[4] %></td>
	
	      </tr>
          <% 
       			} 
       		
       		} %>	   
</form>
</table>
</td>
</tr>
</table>
	
	    
	   	 <form action="ManageServlet" method="post" name="mf<%= i %>">
		    
	      <table width="90%" cellpadding="1" cellspacing="1" bgcolor="black">
	      <tr>
	      	  <td colspan="6" bgcolor="white" align="center" height="40">
	      	  <font color="red" size="4"><i><b><%= str[0]%>号订单信息表</b></i>
	      	  </td>
	      </tr>
	      <tr>
	      	  <td bgcolor="white" width="250" align="center" height="20"><b>发订单人</b></td>
		      <td bgcolor="white"  height="20" width="250"><%= str[1] %></td>
		      <td bgcolor="white" width="250" align="center" height="20"><b>收货人姓名</b></td>
		      <td bgcolor="white" height="20" width="250"><%= str[2] %></td>
		      <td bgcolor="white" width="250" align="center" height="20"><b>收货人地址</b></td>
		      <td bgcolor="white"  height="20" width="250"><%= str[3] %></td>
	      </tr>
	      <tr>
		      <td bgcolor="white" width="250" align="center" height="20"><b>收货人电话</b></td>
		      <td bgcolor="white" height="20" width="250"><%= str[4] %></td>
		      <td bgcolor="white" width="250" align="center" height="20"><b>总价格</b></td>
		      <td bgcolor="white" height="20" width="250">￥<%= (str[5].indexOf(".")==-1)?str[5]+".00":str[5]%>元</td>
		      <td bgcolor="white" width="250" align="center" height="20"><b>订单状态</b></td>
		      <td bgcolor="white"  height="20" width="250"><font color="red"><%= str[6] %></font></td>
	      </tr>
	      <% 
	     	 String sql4 = "select goodsid,goodsname,gprice,orderamount,buytime from"
		      	+" ordergoodsmeg where oid="+Integer.parseInt(str[0]);
		     String sql2 = new String(sql4.getBytes(),"ISO-8859-1");
		     Vector<String[]> vvv = DB.getMessage(sql2);
		 
	      	if(vvv.size()==0)
	      	{
	      		out.println("没有相关信息！");
	      	}
	      	else
	      	{%>
		      <tr>
		        <th bgcolor="white" width="200" align="center" height="30">商品ID</th>
			    <th bgcolor="white" width="200" align="center" height="30" colspan="2">商品名</th>
			    <th bgcolor="white" width="200" align="center" height="30">价格</th>
			    <th bgcolor="white" width="200" align="center" height="30">数量</th>
			    <th bgcolor="white" width="200" align="center" height="30">购买时间</th> 
		      </tr>
			<% 
			for(String[] str1:vvv)
			{%>	<tr align="center">
	       		<td bgcolor="white" width="200" align="center" height="20"><%= str1[0] %></td>
	       		<td bgcolor="white" colspan="2"><%= str1[1] %></td>
	       		<td bgcolor="white">￥<%= (str1[2].indexOf(".")==-1)?str1[2]+".00":str1[2]%>元</td>
	       		<td bgcolor="white"><%= str1[3] %></td>
	       		<td bgcolor="white"><%= (str1[4].length()>19)?str1[4].substring(1,19):str1[4] %></td>
	
	      </tr>
          <% 
       		} 
       		
       	} %>	   
        </table></form>
  <table align="center">
  <tr>
    <% if(str[6].trim().equals("未发送")) {%>

       	<td width="100" align="center" height="20">
       	<a href="ManageServlet?action=orderxiugai&oid=<%= str[0]%>" onclick="checkxg()"><img border="0" id="fh"
						 onmousedown="document.all.fh.src='img/dlfh/fsdd1.png'" 
				    	 onmousemove="document.all.fh.src='img/dlfh/fsdd2.png'" 
				    	 onmouseout="document.all.fh.src='img/dlfh/fsdd3.png'"
				    	 src="img/dlfh/fsdd1.png" style="cursor:hand" /></a></td>		
  </table></form>
   	
        <% }%>
           <hr color="black" size="2"/> 
           <%
    } 

	int showPage=spSearch.getShowPage();
	int totolPage=spSearch.getTotolPage();
 %>
<table><tr>
<td>
 <% if(showPage>1) {%><br>
<form action="ManageServlet" name="formm" method="post">
 
    <img src="img/top/prev.gif" style="cursor:hand" onclick="JavaScript:document.formm.submit()">
    <input name="action" type="hidden" value="qian"/>
</form><% } %></td><td>
<form action="ManageServlet" method="post">
      <td align="center" width="200">
      	  <select onchange="this.form.submit()" name="huan" >
      	   <% 
      	   		for(int ii=1;ii<=totolPage;ii++)
      	   		{
      	   			String flag = "";
      	   			if(ii==showPage)
      	   			{
      	   				flag = "selected";
      	   			}
      	    %>
      	    	<option value="<%=ii%>" <%= flag %>>第<%= ii %>页</option>
      	    <% 
      	    	}
      	     %>
      	  </select>
      	  <input name="action" type="hidden" value="huan"/>
      	</td>
      	</form></td><td>
<% if(showPage<totolPage){ %><br>
<form action="ManageServlet" name="form1" method="post">

    <img src="img/top/next.gif" style="cursor:hand" onclick="JavaScript:document.form1.submit()">
    <input name="action" type="hidden" value="xia"/>

</form><% } %>
</td></tr></table>
  </body>
</html>