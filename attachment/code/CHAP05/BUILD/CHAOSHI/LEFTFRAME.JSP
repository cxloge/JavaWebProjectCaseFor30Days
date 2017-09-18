<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*,wyf.hxl.DB"%>
<jsp:useBean id="handlePage" class="wyf.hxl.PaginationBean" scope="session"/>
<html>
<head>
<link href="script/div.css" type="text/css" rel=stylesheet>
<script language="javascript" src="script/trim.js"></script>
<script language="javascript">
	function qingchu()
    {
        document.getElementById("searchthings").value="";
    }
	function checkSearch()
	{ 
		var flag=document.getElementById("searchthings").value;
		if(flag.trim()==""||flag.trim()=="请输入关键字")
		{	
			alert("请输入要查找商品的关键字！！");
			return;
		}
		document.getElementById("searchsF").submit();
	}
	
	function searchSP(gtype)
	{
	   document.getElementById("mf_gtype").value=gtype;
	   document.getElementById("mf").submit();
	}
</script></head>
<body style="background:url('img/top/bg.gif')">
<form action="CustomerServlet" name="searchs" method="post" target="mainFrame" id="searchsF"> 
  <table width="100%" border="0" height="40" style="background:url(img/sear.gif) no-repeat">
  	<tr>
  	  <td width="118">&nbsp;<input name="searchthings" id="searchthings" 
  	  	value="请输入关键字" onclick="qingchu()" size="11" style="border:0" /></td>
  	  <td align="center"><input name="action" type="hidden" value="searchthing">
  	  <td><img id="sear" src="img/other/so1.gif" onclick="checkSearch()" style="cursor:hand" 
  	  	onmousedown="Javascript:document.all.sear.src='img/other/so2.gif'"
  	  	onmouseup="Javascript:document.all.sear.src='img/other/so1.gif'"/>
  	  </td>
  	</tr>	      	
  </table>
</form>
<center>
	<form action="CustomerServlet" method="post" id="mf" target="mainFrame">
	  <input type="hidden" name="action" value="search"/>
	  <input type="hidden" name="gtype" id="mf_gtype" value="图书"/>
	</form>
	<div id="Nav">		
		<ul>
	  <% 
	  	String sql = "select distinct gtype from goodsmessage";
	  	String sql11 = new String(sql.getBytes(),"ISO-8859-1");
	    Vector<String[]> gtype = DB.getMessage(sql11);
	    for(String[] st:gtype)
	    {
	  %>
	    <tr>
	      <td align="center" bgcolor="#FFCeE1">
	        <li><a href="javascript:searchSP('<%= st[0] %>');"><img src="img/fav.gif" align="left" border="0"/><%= st[0] %></a></li>
	      </td>
	    </tr>
	  <%
	    }
	  %>							
		</ul>
	</div>
</center>
</body>
</html>