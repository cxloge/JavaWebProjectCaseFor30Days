<%@ page contentType="text/html;charset=gbk"
    import="java.util.*"%>
 <html>
  <head>
   <link href="images/navigation.css" type="text/css" rel="stylesheet">
   <link href="images/globalstyle.css" type="text/css" rel=stylesheet>
    <script language="JavaScript">
        function myMouseOver(xx){
           eval("document.all."+xx+".className='moverbutton';");
        }
        function myMouseOut(xx){
           eval("document.all."+xx+".className='mbutton';");
        }
    </script>
  </head>
 <body bgcolor="#FEFFE1">
 	<table border="0" width="100%">
 		<tr>
 			<td width="40"><img src="images/ico.png" width="40" height="40"></td>
 			<td><span style="vertical-align:middle">
 				<font color="black" size="5">慕仁大学图书管理系统管理端</font>
 			</span></td>
 		</tr>
 		<tr><td colspan="2" align="right"><hr size="1" width="100%">
 		</td></tr>
 	</table> 	
	<table  border="0" width="100%" bgcolor="006000">
		<tr height="%16">
			<td width="10%">
				<a id="button1" class="mbutton" href="admin_login.jsp" target="bottomFrame"
					onMouseOut="myMouseOut('button1')" onMouseOver="myMouseOver('button1');">管理登录</a>
			</td>
			<td width="10%">
				<a id="button2" class="mbutton" href="ManageServlet?action=adManage" target="bottomFrame"
					onMouseOut="myMouseOut('button2')" onMouseOver="myMouseOver('button2');">账号维护</a>
			</td>
			<td width="10%">
				<a id="button3" class="mbutton" href="ManageServlet?action=stu_manage" target="bottomFrame" 
					onMouseOut="myMouseOut('button3')" onMouseOver="myMouseOver('button3');">学生管理</a>
			</td>
			<td width="10%">
				<a id="button4" class="mbutton" href="ManageServlet?action=book_manage" target="bottomFrame" 
					onMouseOut="myMouseOut('button4')"	onMouseOver="myMouseOver('button4');">图书管理</a>
			</td>
			<td width="10%">
				<a id="button5" class="mbutton" href="ManageServlet?action=borrow_manage" 
							target="bottomFrame" onMouseOut="myMouseOut('button5')" 
										onMouseOver="myMouseOver('button5');">借阅管理</a>
			</td>
			<td></td>
		</tr>
  	</table>
  </body>
</html>