<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*,wyf.hxl.DB"%> 
<jsp:useBean id="spSearch" class="wyf.hxl.ManageBean" scope="session"/>
<html>
  <head>
	<% 
	   String chaoji=(String)session.getAttribute("chaoji");
	   String putongF=(String)session.getAttribute("putong");
	   if(chaoji==null&&putongF==null)
	   {
	     request.setAttribute("msg", "对不起，只有管理员才可以\\n使用此项功能，请登陆！");
	%>
	     <jsp:forward page="dl.jsp"/>
	<%
	   }
	%>
    <script language="javascript" src="script/trim.js"></script>
    <link href="script/style.css" rel="stylesheet" type="text/css"/>
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
	      <hr></hr>	 
	     	<%		
	     			String ddfs=(String)session.getAttribute("ddfs");
						if(ddfs==null)
						{
							ddfs="ordergl";
						}	
	     			String ddtitle="";
						if(ddfs.equals("ordergl"))
						{
						   ddtitle="全部";
						}
					  else if(ddfs.equals("orderyfs"))
						{
						   ddtitle="已发送";
						}
					  else if(ddfs.equals("orderwfs"))
						{
						   ddtitle="未发送";
						}	
				%>		 
	           
	        <tr align="left"><td><a href="welcome.jsp"><img src="img/left_green.png"/>单击这里返回</a></td></tr> 
<table width="100%" border="0" height="42">
    <tr>
    <form action="ManageServlet">				
			<td align="center">	  
		      按订单时间排列 
		      <input type="hidden" name="action" value="<%=ddfs%>"/>
		      <input 
		        type="radio" 
		        name="pxfs" 
		        value="asc"
		        <%=(session.getAttribute("pxfs")==null||session.getAttribute("pxfs").equals("asc"))?"checked":""%> 
		        onclick="this.form.submit();"
		      >升序
		      <input 
		         type="radio" 
		         name="pxfs" 
		         value="desc" 
		         <%=(session.getAttribute("pxfs")!=null&&session.getAttribute("pxfs").equals("desc"))?"checked":""%>
		         onclick="this.form.submit();"
		      >降序
			</td>	
		</form>	
		<td width="200">&nbsp;</td>	
	 </tr>	      	
</table> 
	     <% 
	    Vector<String[]> vv = (Vector<String[]>)request.getAttribute("vv"); 	
	   	int i=0;
	      	%>
<table border="0" align="center" width="950">
   <tr>
      <td>
      	<table width="100%" cellpadding="1" cellspacing="1" bgcolor="black" border="0" align="center">
      	<caption style="font-size:1.6em;font-weight:bold"><%=ddtitle%>订单信息</caption>
      	<tr bgcolor="#d2e9ff">
	      	  <th width="70" align="center" height="30">订单号</th>
	      	  <th width="100" align="center" height="30">总价格</th>
	      	  <th width="100" align="center" height="30">订货人姓名</th>
	      	  <th width="100" align="center" height="30">收货人姓名</th>
	      	  <th width="150" align="center" height="30">收货人地址</th>
	      	  <th width="100" align="center" height="30">收货人电话</th>
	      	  <th width="70" align="center" height="30">状态</th>
	      	  <th align="center" height="30">预订时间</th>
	      	  <th width="70" align="center" height="30">查看明细</th>
	      </tr>
<%	
for(String[] str:vv)
{i++;%>	  <tr  bgcolor="<%=(i%2==0)?"#d2e9ff":"#e4f0ff"%>">   
		      	  <td align="center"><%= str[0]%></td>
		      	  <td align="center">￥<%= (str[5].indexOf(".")==-1)?str[5]+".00":str[5]%>元</td>
			      <td><%= str[1] %></td>
			      <td><%= str[2] %></td>
			      <td><%= str[3] %></td>
			      <td><%= str[4] %></td>
			      <td align="center"><%= str[6] %></td>
			      <td><%=(str[7].length()>19)?str[7].substring(0,19):str[7] %></td>
			      <form action="ManageServlet">
			      <td align="center" height="20">			      
				      <input type="hidden" name="oid" value="<%= str[0]%>"/>
				      <input type="hidden" name="action" value="chakan"/>
				      <input type="submit" value="查看"/>
			      </td>
		      	  </form>
<%}%>		</tr>
          </table>
		</td>
	</tr>
</table>

<%
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
<table width="100%" border="0">
	        <hr></hr>
	        
	        <tr align="left"><td><a href="welcome.jsp"><img src="img/left_green.png"/>单击这里返回</a></td></tr>
</table>
  </body>
</html>

<%
   String msg=(String)request.getAttribute("msg");
   if(msg!=null)
   {
%>
   <script>
     alert('<%=msg%>');
   </script>
<%
   }
%>