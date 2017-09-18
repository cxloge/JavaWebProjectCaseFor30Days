<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*,wyf.hxl.DB"%>
<jsp:useBean id="handlePage" class="wyf.hxl.PaginationBean" scope="session"/>
<html>
<head>
<title>top</title>
</head>
<body style="background:url('img/other/shouye.png') no-repeat">

 <table width="100%" border="0">
   <tr height="74"><td align="center" colspan="6"> 
    <h1>欢迎来到远洋网络购物广场</h1>
     </td></tr><tr>
    <td align="right">
     <a href="CustomerServlet?action=quanbuxinxi" target="mainFrame"><img border="0" id="zy" src="img/top/zy1.gif" 
     onmousedown="document.all.zy.src='img/top/zy2.gif'" 
     onmousemove="document.all.zy.src='img/top/zy3.gif'" 
     onmouseout="document.all.zy.src='img/top/zy1.gif'"/></a><a href="cart.jsp" target="mainFrame"><img border="0"
     id="gw" src="img/top/gwc1.gif" 
     onmousedown="document.all.gw.src='img/top/gwc2.gif'" 
     onmousemove="document.all.gw.src='img/top/gwc3.gif'" 
     onmouseout="document.all.gw.src='img/top/gwc1.gif'"/></a><a href='CustomerServlet?action=modify2' target="mainFrame"><img border="0" 
 	 id="dd" src="img/top/wddd1.gif" 
     onmousedown="document.all.dd.src='img/top/wddd2.gif'" 
     onmousemove="document.all.dd.src='img/top/wddd3.gif'" 
     onmouseout="document.all.dd.src='img/top/wddd1.gif'"/></a><a href="customerzc.jsp" target="mainFrame"><img border="0" 
	 id="yhzc" onmousedown="document.all.yhzc.src='img/top/yhzc1.gif'" 
	 onmousemove="document.all.yhzc.src='img/top/yhzc2.gif'" 
	 onmouseout="document.all.yhzc.src='img/top/yhzc3.gif'"
	 src="img/top/yhzc1.gif"  style="cursor:hand" /></a><a href="customermanage.jsp" target="mainFrame"><img border="0" 
	 id="yhdl" onmousedown="document.all.yhdl.src='img/top/yhdl11.gif'" 
	 onmousemove="document.all.yhdl.src='img/top/yhdl12.gif'" 
	 onmouseout="document.all.yhdl.src='img/top/yhdl13.gif'"
	 src="img/top/yhdl11.gif" style="cursor:hand" /></a><a href="customerpwchange.jsp" target="mainFrame"><img border="0" 
	 id="mmcz" onmousedown="document.all.mmcz.src='img/top/mmcz1.gif'" 
	 onmousemove="document.all.mmcz.src='img/top/mmcz2.gif'" 
	 onmouseout="document.all.mmcz.src='img/top/mmcz3.gif'"
	 src="img/top/mmcz1.gif" style="cursor:hand" /></a><a href='CustomerServlet?action=logout' target="mainFrame"><img border="0" 
	 id="yhzx" onmousedown="document.all.yhzx.src='img/top/zx1.gif'" 
	 onmousemove="document.all.yhzx.src='img/top/zx2.gif'" 
	 onmouseout="document.all.yhzx.src='img/top/zx3.gif'"
     src="img/top/zx1.gif" style="cursor:hand" /></a>
    </td></tr>
  </table>

</body>
</html>