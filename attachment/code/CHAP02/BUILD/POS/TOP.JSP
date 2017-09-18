<%@ page contentType="text/html;charset=gbk" 
	import="wyf.zrk.UserBean"
%>
<html>
  <head>
    <title>top</title>
    <link rel=stylesheet href="css/style.css" type="text/css">
  </head>
  <body style="background: url(img/backimg.jpg) no-repeat">
  <jsp:useBean id="userBean" class="wyf.zrk.UserBean" scope="session"/>
    <center>
      <br/><h1 style="color: #DFC77F"><i>飞达商贸有限公司POS系统</i></h1>
    </center>
    <div style="position:absolute;top:65px">
      <table align="right">
        <tr align="right">
          <td><a href="index.jsp" target="bottom">
          	<img border="0" src="img/sy.gif" id="sy"
          	  onmouseover="document.all.sy.src='img/sya.gif'"
          	  onmouseout="document.all.sy.src='img/sy.gif'"
          	  onmouseup="document.all.sy.src='img/sya.gif'"
          	  onmousedown="document.all.sy.src='img/syb.gif'"/></a></td>
          <td><a href="adminlogin.jsp" target="bottom">
          	<img border="0" src="img/dl.gif" id="dl"
          	  onmouseover="document.all.dl.src='img/dla.gif'"
          	  onmouseout="document.all.dl.src='img/dl.gif'"
          	  onmouseup="document.all.dl.src='img/dla.gif'"        	
          	  onmousedown="document.all.dl.src='img/dlb.gif'"/></a></td>
          <td><a href="changepwd.jsp" target="bottom">
          	<img border="0" src="img/xgmm.gif" id="xgmm"
          	  onmouseover="document.all.xgmm.src='img/xgmma.gif'"
          	  onmouseout="document.all.xgmm.src='img/xgmm.gif'"
          	  onmouseup="document.all.xgmm.src='img/xgmma.gif'" 
          	  onmousedown="document.all.xgmm.src='img/xgmmb.gif'"/></a></td>
          <td><a href="ManageServlet?action=logout" target="bottom">
          	<img border="0" src="img/zx.gif" id="zx"
          	  onmouseover="document.all.zx.src='img/zxa.gif'"
          	  onmouseout="document.all.zx.src='img/zx.gif'"
          	  onmouseup="document.all.zx.src='img/zxa.gif'"   	
          	  onmousedown="document.all.zx.src='img/zxb.gif'"/></a></td>     
        </tr>
      </table>
    </div>
  </body>
</html>