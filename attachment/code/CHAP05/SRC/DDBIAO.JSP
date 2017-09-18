<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*,wyf.hxl.DB"%>
<html>
  <head>
    <title></title>
    <script language="javascript" src="script/trim.js"></script>
    <link href="script/style.css" rel="stylesheet" type="text/css"/>
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
	        
	     <%  
	      	Vector<String[]> vv=(Vector<String[]>)request.getAttribute("list");
	      	String cname=(String)request.getAttribute("use");
	      	System.out.println(cname);
	      	int i=0;
	      	%>
	      	<table width="100%">		      	
		      	<tr align="left">
		      	    <td>
		      	      <a href="pagination.jsp"><img src="img/left_green.png"/>继续购买</a>
		      	    </td>
		      	    <form action="CustomerServlet">				
					<td align="center">			<% System.out.println(session.getAttribute("wdddpx")); %>		  
				      按订单时间排列 
				      <input 
				        type="radio" 
				        name="action" 
				        value="paixus"
				        <%=(session.getAttribute("wdddpx")==null)?"checked":(session.getAttribute("wdddpx").equals("asc"))?"checked":""%> 
				        onclick="this.form.submit();"
				      >升序
				      <input 
				         type="radio" 
				         name="action" 
				         value="paixu" 
				         <%=(session.getAttribute("wdddpx")==null)?"":(session.getAttribute("wdddpx").equals("desc"))?"checked":""%>
				         onclick="this.form.submit();"
				      >降序
				      <input type="hidden" name="user" value="<%= cname%>">
					</td>	
					</form>	
					<td width="200">&nbsp;</td>		
				</tr>				
			</table>
		      <hr></hr>
<table border="0" align="center" width="900">
   <tr>
      <td>
      	<table width="100%" cellpadding="1" cellspacing="1" bgcolor="black" border="0" align="center">
      	<caption style="font-size:1.6em;font-weight:bold">订单信息</caption>
      	<tr bgcolor="#d2e9ff">
      	  <th width="55" align="center" height="30">订单号</th>
      	  <th width="70" align="center" height="30">状态</th>
      	  <th width="100" align="center" height="30">收货人姓名</th>
      	  <th width="190" align="center" height="30">收货人地址</th>
      	  <th width="100" align="center" height="30">收货人电话</b></font></th>
      	  <th width="100" align="center" height="30">总价格</th>
      	  <th align="center" height="30">预订时间</th>
      	  <th width="70" align="center" height="30">查看明细</th>
        </tr>
      	<%	
	     for(String[] str:vv)
		{
		i++;		   
		 %>	     
	    <input id="aa" type="hidden" name="action" value="orderxiugai"/>
	    <input name="orderidname" type="hidden" value="<%= str[0]%>">
      
      <tr bgcolor="<%=(i%2==0)?"#d2e9ff":"#e4f0ff"%>">	  
      	  <td align="center" height="20"><%= str[0]%></td>
      	  <td align="center" height="20"><%= str[5] %></td>
	      <td height="20"><%= str[1] %></td>
	      <td height="20"><%= str[2] %></td>
	      <td height="20"><%= str[3] %></td>
	      <td align="center" height="20">￥<%= (str[4].indexOf(".")==-1)?str[4]+".00":str[4]%>元</td>
	      <td align="center" height="20"><%= (str[6].length()>19)?str[6].substring(0,19):str[6]%></td>
	      <form action="CustomerServlet">
		      <td align="center" height="20">			      
			      <input type="hidden" name="oid" value="<%= str[0]%>"/>
			      <input type="hidden" name="action" value="modify1"/>
			      <input type="submit" value="查看"/>
		      </td>
	      </form>
      </tr> 
	    <% 
	   	}
	    %>
  </table>
</td>
</tr>
</table>
<hr></hr>
<a href="pagination.jsp"><img src="img/left_green.png"/>继续购买</a>
</body>
</html>