<%@ page contentType="text/html;charset=gb2312" %>
<html>
  <head>
    <title>提示页面</title>
    <link href="ccript/generalstyle.css" type="text/css" rel="stylesheet">
  </head>
  <body style="background:url('img/top/bg.gif')">
    <%
 		String msg = (String)request.getAttribute("msg");
     %>
      <table width="100%">
		  <tr height="15">
		    <td><hr color="#FF7F00" width="100%"/></hr></td>
		  </tr>
	 </table>
	 <br/><br/><br/><br/><br/><br/>
	 <center>
	   <table border="0" width="700" align="center">
	 	  <tr>
	 	    <td>
	 	     <img src="img/png-0446.png"/>
	 	    </td>
	 	    <td>
	 	     <font size="7"><%= msg %></font>
	 	    </td>
	 	  </tr>
	   </table>
	   
	   
	   <br/><br/>
	   &nbsp;&nbsp;&nbsp;&nbsp;
	   <a href="pagination.jsp"><img src="img/left_green.png" border="0"/>返回主页</a>
	 </center>
  </body>
</html>