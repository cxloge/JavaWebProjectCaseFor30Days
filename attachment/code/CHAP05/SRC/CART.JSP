<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*"%>
<html>
  <head>
    <style>
      th
      {
        background:#d2e9ff;
      }
      td
      {
        background:#d2e9ff;
      }
    </style>
	<script language="javascript" src="script/trim.js"></script>	
    <link href="script/style.css" rel="stylesheet" type="text/css"/>
    <script language="javascript">
    	function checkNum(num)
    	{
    		var reg = /^[1-9][0-9]*$/;
    		if(reg.test(num.trim()))
    		{
    			return true;
    		}
    		else
    		{
    			alert("商品数量只能为数字且不能为0！！！");
    			return false;
    		}
    	}
    </script>
    <jsp:useBean id="handlePage" class="wyf.hxl.PaginationBean" scope="session"/>
  </head>
  <body style="background:url('img/top/bg.gif')">
<% 
if(handlePage.getCart().size()==0)
{
%>
<br/><br/>
<table style="background:url('img/top/bg.gif')" align="center">
	<tr>
		<td>
	    <img src="img/png-0405.png"/>
	  </td>
	  <td> 	
	    <b style="font-size:1.5em">购物车中没有商品，请先行购买！！！</b>
	  </td>
	</tr>
</table>
<%
}

else
{
%>
<table width="100%">
    <tr align="center">
        <td>

  <table border="0" width="70%" style="border:1px solid #6daafc" align="center">
  <tr>
    <td style="font-size:1.2em" align="center">
      购物车
    </td>
  </tr>
  <tr>
  <td>  

    <table border="0" width="100%" bgcolor="black" cellspacing="1">
     <tr>
     	<th>商品ID</th>
    	<th>商品名称</th>
    	<th>商品价格</th>
    	<th>商品数量</th>
    	<th>删除</th>
  	</tr>
	<% 
		Vector<String[]> vv = handlePage.getCartContent();
		for(String[] a:vv)
		{			
	%>
	   <tr>
		  <td><%= a[2] %></td>
		  <td><%= a[0] %></td>
		  <td  width="100">￥<%= a[1] %></td>
		  <form action="CustomerServlet" method="post"
  		     onsubmit="return checkNum(document.all.gnum<%= a[2] %>.value);">
			  <td width="100">
			    <input type="text" id="gnum<%= a[2] %>" name="gnum" value="<%= a[3] %>" size="5"/>
			    <input type="submit" value="修改"/>
			    <input type="hidden" name="goodsid" value="<%= a[2]%>"/>
			    <input type="hidden" name="action" value="change"/>
			  </td>	
		  </form>
		  <form action="CustomerServlet">
			  <td width="100" align="center">
			    <input type="submit" value="删除"/>
			    <input type="hidden" name="goodsid" value="<%= a[2]%>"/>
			    <input type="hidden" name="action" value="delete"/>
			  </td>	
		  </form>	  
		</tr>		
	<%
		}
	 %>
    </table>
    
    </td>
  </tr>
  <tr>
    <td>
      <table width="100%" border="0">
         <tr>
		     <td align="right" colspan="3"><b>商品价格总计:￥<%= handlePage.getAccount() %>元</b></td>
		     <td align="center">
		     <% 
		     	if(session.getAttribute("jieZhang")==null)
		     	{
		      %>
		      <form action="CustomerServlet">
	      	  <td width="100" align="center">
			    <input type="submit" value="结帐"/>
			    <input type="hidden" name="action" value="jiezhang"/>
			  </td>	
			  </form>
		      <% 
		      	}
		      %>
		     </td>
		   </tr>
      </table>
    </td>
  </tr>
</table> 
    <% 
	}
     %>    
    </center>
    <br/>
    <table align="left">
    	<tr>
	    	<td>
	    		<a href="pagination.jsp"><img src="img/left_green.png" border="0"/>继续购买</a>
	    	</td>
        </tr>
    </table>
    <script>
      <% 
         String msg=(String)request.getAttribute("msg");
         if(msg!=null)
         {
      %>
         alert('<%=msg%>');
      <%
         }
       %>
    </script>
  </body>
</html>