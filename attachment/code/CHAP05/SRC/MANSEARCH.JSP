<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*,wyf.hxl.ManageBean,wyf.hxl.DB"%>
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
  </head>
<body style="background:url('img/top/bg.gif')">
<br/><br/>
<center>
<table border="0" width="400" style="border:1px solid #6daafc">
  <tr>
    <td>
		<table border="0" width="100%" bgcolor="black" cellspacing="1">
		  <caption style="font-size:1.6em;font-weight:bold">管理员信息</caption>
              <tr>
  			    <th bgcolor="#d2e9ff">管理员名</th>
			    <th bgcolor="#d2e9ff">管理员密码</th>
			    <th bgcolor="#d2e9ff">管理员权限</th>         
              </tr>
	       <% 
	        String quanxian=(String)session.getAttribute("chaoji");
	        if(quanxian!=null)
	        {
	        
		      	String sql = "select mname,mpw,mpermitted from mmanager";
		      	String sql11 = new String(sql.getBytes(),"ISO-8859-1");
		      	Vector<String[]> vv = DB.getMessage(sql11);
				for(String[] str:vv)
				{
		       %>
				       <tr align="center">
				       		<td bgcolor="#d2e9ff"><%= str[0] %></td>
				       		<td bgcolor="#d2e9ff"><%= str[1] %></td>
				       		<td bgcolor="#d2e9ff"><%= str[2] %></td>	
				       </tr>
		       <% 
		       	}
		     }
	       	 String putong=(String)session.getAttribute("putong");
	       	 String cname=(String)session.getAttribute("name");
	       	 if(putong!=null)
	       	 {
		       	 String sql = "select mname,mpw,mpermitted from mmanager where mname='"+cname+"'";
		      	 String sql11 = new String(sql.getBytes(),"ISO-8859-1");
		      	 Vector<String[]> vv = DB.getMessage(sql11);
				 for(String[] str:vv)
				 {
		       %>
				       <tr align="center">
				       		<td bgcolor="#d2e9ff"><%= str[0] %></td>
				       		<td bgcolor="#d2e9ff"><%= str[1] %></td>
				       		<td bgcolor="#d2e9ff"><%= str[2] %></td>
				       		
				       </tr>
		       <% 
		       	 }
	        }
	        %>
	       </table border="0">
	        <tr align="center">
	        <td>
	        	<a href="welcome.jsp">
	        	<img border="0" id="qd"
						 onmousedown="document.all.qd.src='img/dlfh/qd1.gif'" 
				    	 onmousemove="document.all.qd.src='img/dlfh/qd2.gif'" 
				    	 onmouseout="document.all.qd.src='img/dlfh/qd3.gif'"
				    	 src="img/dlfh/qd1.gif" style="cursor:hand" /></a>
	        </td>
	        </tr>
	</td>
  </tr>
</table>
  </body>
</html>