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
 				<font color="black" size="5">慕仁大学图书管理系统</font>
 			</span></td>
 		</tr>
 		<tr><td colspan="2" align="right"><hr size="1" width="100%">
 		</td></tr>
 	</table> 	
	<table  border="0" width="100%" bgcolor="#006000">
		<tr height="%16">
			<td width="10%">
				<a id="button1" class="mbutton" href="login.jsp" target="bottomFrame"
					onMouseOut="myMouseOut('button1')" onMouseOver="myMouseOver('button1');">登录系统</a>
			</td>
			<td width="10%">
				<a id="button2" class="mbutton" href="StudentServlet?action=stuInfo" target="bottomFrame"
					onMouseOut="myMouseOut('button2')" onMouseOver="myMouseOver('button2');">读者信息</a>
			</td>
			<td width="10%">
				<a id="button3" class="mbutton" href="StudentServlet?action=cb" target="bottomFrame" 
					onMouseOut="myMouseOut('button3')" onMouseOver="myMouseOver('button3');">书刊借阅</a>
			</td>
			<td width="10%">
				<a id="button4" class="mbutton" href="StudentServlet?action=inform" target="bottomFrame" 
					onMouseOut="myMouseOut('button4')"	onMouseOver="myMouseOver('button4');">预约通知</a>
			</td>
			<td width="10%">
				<a id="button5" class="mbutton" href="query_book.jsp" target="bottomFrame" 
					onMouseOut="myMouseOut('button5')" onMouseOver="myMouseOver('button5');">书刊检索</a>
			</td>
			<td></td>
		</tr>
  	</table>
  </body>
</html>