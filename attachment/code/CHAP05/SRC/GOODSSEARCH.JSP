<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*,wyf.hxl.ManageBean,wyf.hxl.DB"%>
<jsp:useBean id="spSearch" class="wyf.hxl.ManageBean" scope="session"/>
<% 
	if(session.getAttribute("manager")==null)
	{
		response.sendRedirect("dl.jsp");
	}
	else
	{ 
		Vector<String[]> vv = (Vector<String[]>)request.getAttribute("vv");
		if(vv==null)
		{
			String sql="select goodsname,gtype,gprice,gdate,gamount,gimgurl,gintroduction from goodsmessage";
			spSearch.setShowPage(1);
			int nowpage = spSearch.getShowPage();
	        int totolpage = DB.totolPage("select * from goodsmessage");
	        spSearch.setTotolPage(totolpage);
	        spSearch.setSql(sql);
			vv = DB.selectPageMeg(nowpage,sql);
			
		}

 %>
<html>
  <head>
    <title></title>
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
  
		function qingchu()
	    {  
	        document.all.searchgoods.value="";
	    }
		function checkSearch()
		{ 
			var flag=document.searchs.searchgoods.value;
			if(flag.trim()=="")
			{	
				alert("请输入要查找商品的关键字！！");
				return;
			}
			document.searchs.submit();
		}
       function check(temp,mmf){
      	if(temp=="mod"){
      	
      		mmf.action.value="ordercx";
      	}
      	mmf.submit();
      }
    </script>
  </head>
  <body style="background:url('img/top/bg.gif')">
  <tr align="left"><td><a href="javascript:history.back()"><img src="img/left_green.png"/>单击这里返回</a></td></tr>
<hr></hr>
<form action="ManageServlet" name="searchs" method="post" target="mainFrame">

 <table width="100%" border="0" height="40" style="background:url(img/top/search.gif) no-repeat">
	      	<tr>
	      	  <td width="198">&nbsp;<input name="searchgoods" id="searchgoods"
	      	   value="请输入商品名" onclick="qingchu()" size="11" style="border:0" /></td>
	      	  <td align="center"><input name="action" type="hidden" value="searchgoods">
	      	  <td><img id="sear" src="img/top/bt.gif" onclick="checkSearch()" style="cursor:hand" 
	      	  		 onmousedown="Javascript:document.all.sear.src='img/top/bt1.gif'"
	      	  		 onmouseup="Javascript:document.all.sear.src='img/top/bt.gif'"
	      	  		 /></td>
	      	</tr>	      	
	      </table>
</form>  
	      <hr></hr>


<%if(vv.size()==0)
{
	out.println("数据库中没有商品信息可以显示！！");
}
else
{  %>
 <table width="90%" cellpadding="2" bgcolor="black" cellspacing="1">
                  <tr>
      			   <th bgcolor="#e3fcff" width="150">商品名</th>
				    <th bgcolor="#e3fcff" width="50">商品类型</th>
				    <th bgcolor="#e3fcff" width="80">商品价格</th>
				    <th bgcolor="#e3fcff" width="100">上架日期</th>
				    <th bgcolor="#e3fcff" width="50">商品数量</th>
				    <th bgcolor="#e3fcff" width="150">图片URL</th>
				    <th bgcolor="#e3fcff" width="100">商品简介</th>        
                  </tr>
<% 
	for(int i=0;i<vv.size();i++)
	{
		String[] str = vv.get(i);
 %>
 
			<tr align='center' >
       		<td bgcolor="#e3fcff" width="150"><%= str[0] %></td>
       		<td bgcolor="#e3fcff" width="50"><%= str[1] %></td>
       		<td bgcolor="#e3fcff" width="80"><%= str[2] %></td>
       		<td bgcolor="#e3fcff" width="100"><%= str[3] %></td>
       		<td bgcolor="#e3fcff" width="50"><%= str[4] %></td>
       		<td bgcolor="#e3fcff" width="150"><%= str[5] %></td>
       		<td bgcolor="#e3fcff" width="100"><%= str[6] %></td>
      </tr>
       <% 
    } 
}
        %>
	        </table><br>
	  <% int showPage=spSearch.getShowPage();
		 int totolPage=spSearch.getTotolPage(); %>
	  <table><tr>
<td><br>
 <% if(showPage>1) {%>
<form action="ManageServlet" name="form" method="post">
 
    <img src="img/top/prev.gif" style="cursor:hand" onclick="JavaScript:document.form.submit()">
    <input name="action" type="hidden" value="before"/>
</form><% } %></td><td>
<form action="ManageServlet" method="post">
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
<form action="ManageServlet" name="form1" method="post">

    <img src="img/top/next.gif" style="cursor:hand" onclick="JavaScript:document.form1.submit()">
    <input name="action" type="hidden" value="next"/>

</form><% } %>
</td></tr></table>
	  
	  
	  
	        <hr></hr>
	        <tr align="left"><td><a href="javascript:history.back()"><img src="img/left_green.png"/>单击这里返回</a></td></tr>
	<% 
	}
	 %>         
  </body>
</html>