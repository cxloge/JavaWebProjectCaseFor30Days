<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*,wyf.hxl.PaginationBean,wyf.hxl.DB"%>
<jsp:useBean id="handlePage" class="wyf.hxl.PaginationBean" scope="session"/>
<% 
  request.setCharacterEncoding("gb2312");
  String gtype=(String)request.getParameter("gtype");
	Vector<String[]> vv = (Vector<String[]>)request.getAttribute("vv");
	if(vv==null)
	{
		String sql="select goodsid,goodsname,gprice,gtype,gimgurl,gamount from goodsmessage"+((gtype==null)?"":" where gtype='"+gtype+"'");
		sql=new String(sql.getBytes(),"ISO-8859-1");
		handlePage.setShowPage(1);
		int nowpage = handlePage.getShowPage();
    int totolpage = DB.totolPage(sql);
    handlePage.setTotolPage(totolpage);
    handlePage.setSql(sql);
		vv = DB.selectPageMeg(nowpage,sql);		
	}  
 %>
<html>
<head>
<link href="script/style.css" rel="stylesheet" type="text/css"/>
<script>
   function submitBuy(mf,sl)
   {
       if(sl>0)
       {
          mf.submit();
       }
       else
       {
          alert("缺货商品不能购买！");
       }
   }
   function ckmx(spid)
   {
      document.getElementById('fgoodsid').value=spid;
      document.getElementById('fhf').submit();
   }
</script>
</head>
<body style="background:url('img/top/bg.gif')">
<form action="CustomerServlet" id="fhf" method="post">
	<input type="hidden" name="action" value="getMessage"/>
	<input type="hidden" id="fgoodsid" name="goodsid" />
	<%
	  if(gtype!=null)
	  {
	%>
	    <input type="hidden" name="gtype" value="<%=gtype%>"/>
	<%
	  }
	%>	  
</form>	
<table>
<%if(vv.size()==0)
{
	out.println("数据库中没有商品信息可以显示！！");
}
else
{ 
	for(int i=0;i<vv.size();i++)
	{
		String[] str = vv.get(i);
 %>
 	<tr>
 	  <td>
 	  	<a href="javascript:ckmx('<%=str[0]%>')">
 	  	  <img style="border:1px solid #6daafc"  src="<%= str[4] %>" id="img" height="150" width="120" />
 	    </a>
 	  </td>
 	  <td>
 	    <table width="100%">
 	    <tr><td>商品ID:<%= str[0] %></td></tr> 	  
		<tr><td>名称:<%= str[1] %></td></tr>
		<tr><td>商品类型:<%= str[3] %></td></tr>
		<tr><td>定价:￥<%= str[2] %></td></tr>
		<tr>
		  <td>
		     库存数量：<%= str[5] %> 
		     <%
		       if(str[5].trim().equals("0"))
		       {
		     %>
		      <font color="red"><b>[缺货]</b></font>		     
		     <%
		       }
		     %>		     
		  </td>
		</tr>
	<form action="CustomerServlet" method="post" id="mf<%= i %>" >	
		<tr>
			<td>
			    <img border="0" src="img/dlfh/gm1.png" id="gm" 
			     onclick="submitBuy(document.getElementById('mf<%= i %>'),<%= str[5] %>);"
			     style="cursor:hand" onmousedown="JavaScript:document.all.mf<%= i %>.gm.src='img/dlfh/gm2.png'" 
			     onmousemove="JavaScript:document.all.mf<%= i %>.gm.src='img/dlfh/gm3.png'" 
			     onmouseout="JavaScript:document.all.mf<%= i %>.gm.src='img/dlfh/gm1.png'"/>
			    <input type="hidden" name="gname" value="<%= str[1] %>">
			    <input type="hidden" name="gclass" value="<%= str[3] %>">
			    <input type="hidden" name="amount" value="<%= str[2] %>">
			    <input type="hidden" name="goodsid" value="<%= str[0] %>">
			    <input type="hidden" name="action"  value="buy">
			</td>
		</tr>
	</form>
 	    </table> 	  
 	  </td>
 	</tr>
 <% 
 	}}
  %>
</table>
<hr color="black" size="1"/>
<% int showPage=handlePage.getShowPage();
int totolPage=handlePage.getTotolPage(); %>
<table>
<tr>
<td><br>
 <% 
if(showPage>1) 
{%>
<form action="CustomerServlet" id="syyf" method="post">
	  <input type="hidden" name="gtype" value="<%=gtype%>"/>
    <img src="img/top/prev.gif" style="cursor:hand" onclick="document.getElementById('syyf').submit();">
    <input name="action" type="hidden" value="before"/>
</form>
<% } %>
</td>
<td>
<form action="CustomerServlet" method="post">
	    <input type="hidden" name="gtype" value="<%=gtype%>"/>
      <td align="center" width="200">
      	  <select onchange="this.form.submit()" name="changePage" >
      	   <% 
      	   		for(int i=1;i<=totolPage;i++)
      	   		{
      	   			String flag = "";
      	   			if(i==showPage)
      	   			{
      	   				flag = "selected";
      	   			}
      	    %>
      	    	<option value="<%=i%>" <%= flag %>>第<%= i %>页</option>
      	    <% 
      	    	}
      	     %>
      	  </select>
      	  <input name="action" type="hidden" value="pageChange"/>
      	</td>
      	</form></td><td>
<% if(showPage<totolPage){ %><br>
<form action="CustomerServlet" name="xyyf" method="post">
    <input type="hidden" name="gtype" value="<%=gtype%>"/>
    <img src="img/top/next.gif" style="cursor:hand" onclick="document.getElementById('xyyf').submit();">
    <input name="action" type="hidden" value="next"/>
</form><% } %>
</td></tr></table>
</body>
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
</html>