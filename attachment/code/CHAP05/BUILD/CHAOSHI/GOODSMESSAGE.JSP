<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="wyf.hxl.DB,java.util.*"%>
<jsp:useBean id="handlePage" class="wyf.hxl.PaginationBean" scope="session"/>
<% 
  request.setCharacterEncoding("gb2312");
	Vector<String[]> vv = (Vector<String[]>)request.getAttribute("vv");
	for(int i=0;i<vv.size();i++)
	{
		String[] str = vv.get(i);
 %>
<html>
  <head>
    <title>物品详细信息</title>
  </head>
<body style="background:url('img/top/bg.gif')"><center>
<table border="0" width="700" style="border:1px solid #6daafc">
  <tr>
    <td>
		<table border="0" width="100%" bgcolor="#d2e9ff">
		  <caption style="font-size:1.6em;font-weight:bold"><%=str[0]%>号商品详细信息</caption>
          	<tr><td height="160" width="125"><table border="0"><tr><td>
          		<img src="<%= str[6] %>"  
          		style="border:1px solid #6daafc"
          	height="130" width="105" border="0"/></td></tr></table></td>
          	<td>
          	
          	<table width="100%" bgcolor="#d2e9ff">
          		  <tr>
                    <td bgcolor="#e4f0ff">&nbsp;&nbsp;商品ID：<%= str[0] %></td>
                  </tr>
          	      <tr>
                    <td>商品名称：<%= str[1] %></td>
                  </tr>
                  <tr>
			        <td bgcolor="#e4f0ff">商品类型：<%= str[2] %></td>
			      </tr>
			      <tr>
			        <td>上架日期：<%= str[4] %></td>
			      </tr>
			      <tr>
			        <td bgcolor="#e4f0ff">&nbsp;&nbsp;&nbsp;&nbsp;定价:￥<%= str[3] %></td>
			      </tr>
			      <tr>
			      <td>
			     	<a href="CustomerServlet?action=buy&goodsid=<%= str[0]%>">
				       	<img border="0" id="fh"
						 onmousedown="document.all.fh.src='img/dlfh/gm1.png'" 
				    	 onmousemove="document.all.fh.src='img/dlfh/gm2.png'" 
				    	 onmouseout="document.all.fh.src='img/dlfh/gm3.png'"
				    	 src="img/dlfh/gm1.png" style="cursor:hand" />
			        </a>
			       </td>
                  </tr>
          	</table>
          	</td>      	
          	</tr>
		</table>
		</td>
		</tr>
		<tr>
			<td>
			<table border="0">
				<tr>
					<td><b>商品简述:</b></td>
				</tr>
				<tr colspan="2">
					<td><%= str[7] %></td>
				</tr>
			</table>
			</td>
		</tr>
		<br>
	  </td>
   </tr>
</table>
<form action="pagination.jsp" id="fhf" method="post">
	<%
	  String gtype=(String)request.getParameter("gtype");
	  if(gtype!=null)
	  {
	%>
	    <input type="hidden" name="gtype" value="<%=gtype%>"/>
	<%
	  }
	%>	  
</form>
<table border="0" align="left">
	<tr>
		<td>
			<a href="javascript:document.getElementById('fhf').submit();">
				<img src="img/left_green.png" border="0"/>返回上一层
			</a>
		</td>
	</tr>
</table>
</body>
</html>
<% } %>