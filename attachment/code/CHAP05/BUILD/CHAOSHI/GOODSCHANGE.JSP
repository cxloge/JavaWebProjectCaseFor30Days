<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="wyf.hxl.ManageBean,wyf.hxl.DB,java.util.*"%>
<table border="0" width="100%">
<% 
	Vector<String[]> vv = (Vector<String[]>)request.getAttribute("vv");
	if(vv==null)
	{
		adBean.setShowPage(1);
        String gsql = "select * from goodsmessage";
        int totolpage = DB.getTotolPage(gsql);
        adBean.setTotolPage(totolpage);
        adBean.setSql(gsql);
		vv = DBcart.getPageContent(1,gsql);
	}
	for(int i=0;i<vv.size();i++)
	{
		String[] str = vv.get(i);
 %>
<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*,wyf.hxl.PaginationBean,wyf.hxl.DB"%>
<jsp:useBean id="handlePage" class="wyf.hxl.PaginationBean" scope="session"/>
<% 
	Vector<String[]> vv = (Vector<String[]>)request.getAttribute("vv");
	if(vv==null)
	{
		String sql="select goodsname,gprice,gtype,gimgurl,gamount from goodsmessage";
		handlePage.setShowPage(1);
		int nowpage = handlePage.getShowPage();
        int totolpage = DB.totolPage("select * from goodsmessage");
        handlePage.setTotolPage(totolpage);
        handlePage.setSql(sql);
		vv = DB.selectPageMeg(nowpage,sql);
	}

 %>
<html>
<head>

</head>
<body style="background:url('img/top/bg.gif')">
<table>
<% 
	for(int i=0;i<vv.size();i++)
	{
		String[] str = vv.get(i);
 %>
 	<tr>
 	  <td><img src="<%=str[3]%>" height="150" border="1"/></td>
 	  <td>
 	    <table width="100%"> 	  
		<tr><td>名称:<%= str[0] %></td></tr>
		<tr><td>商品类型:<%= str[2] %></td></tr>
		<tr><td>定价:￥<%= str[1] %></td></tr>
		<tr><td>库存数量：<%= str[4] %></td></tr>
		<% 
	String sql="select gamount from goodsmessage where gamount<1 and goodsname='"+str[0]+"'";
	boolean amount=DB.selectMsg(sql);
	if(!amount){ %>
	<form action="CustomerServlet" method="post">	<tr><td>
		    <input name="buy" type="submit" value="修改商品">
		    <input type="hidden" name="gname" value="<%= str[0] %>">
		    <input type="hidden" name="gclass" value="<%= str[2] %>">
		    <input type="hidden" name="amount" value="<%= str[1] %>">
		    <input name="action" type="hidden" value="goodsManage">
			</td>
		</tr></form>
		<% }
		else
		{
		 %>	<font>缺货</font>
		 <% } %>
		 
 	    </table> 	  
 	  </td>
 	</tr>
 <% 
 	}
  %>
</table>
<hr color="black" size="1"/>
<% int showPage=handlePage.getShowPage();
int totolPage=handlePage.getTotolPage(); %>
<table><tr>
<td><br>
 <% if(showPage>1) {%>
<form action="CustomerServlet" name="form" method="post">
 
    <input name="before" type="submit" value="上一页"/>
    <input name="action" type="hidden" value="before"/>
</form><% } %></td><td>
<form action="CustomerServlet" method="post">
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
<form action="CustomerServlet" name="form1" method="post">

    <input name="next" type="submit" value="下一页"/>
    <input name="action" type="hidden" value="next"/>

</form><% } %>
</td></tr></table>
</body>
</html>
 