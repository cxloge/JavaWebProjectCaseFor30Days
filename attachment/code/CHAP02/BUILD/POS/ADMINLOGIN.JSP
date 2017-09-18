<%@ page contentType="text/html; charset=gbk" %>
<html>
  <head>
	<title>登陆页面</title>
	<link rel=stylesheet href="css/style.css" type="text/css">
	<script language="JavaScript" src="script/trim.js"></script>
	<script language="JavaScript">
		function check(){
			var uname = document.all.uname.value;
			var upwd = document.all.upwd.value;
			if(uname.trim()==""){
				alert("用户名为空,请重新输入!!!");
				return;
			}
			if(upwd.trim()==""){
				alert("密码为空,请重新输入!!!");
				return;
			}
			document.all.mf.submit();
		}
	</script>
  </head>
  <body>
  	<div class="out">
    <div class="login_style">
      <center>
	  <form action="ManageServlet" method="post" id="mf" target="bottom">
	    <table>
	      <tr>
	        <td>用户名:</td>
	        <td><input type="text" id="uname" name="uname" value="zrk"/></td>
	      </tr>
	      <tr>
	        <td>密&nbsp;码:</td>
	        <td><input type="password" id="upwd" name="upwd" value="12345"/></td>
	      </tr>
	      <tr>
	        <td colspan="2" align="center">
	        <img border="0" src="img/ddl.gif" id="lg" onclick="JavaScript:check()"
          	  style="cursor:hand"
          	  onmouseover="document.all.lg.src='img/ddla.gif'"
          	  onmouseout="document.all.lg.src='img/ddl.gif'"
          	  onmouseup="document.all.lg.src='img/ddla.gif'"        	
          	  onmousedown="document.all.lg.src='img/ddlb.gif'"/>
	        <img border="0" src="img/cz.gif" id="cz" onclick="JavaScript:document.all.mf.reset()"
          	  style="cursor:hand"
          	  onmouseover="document.all.cz.src='img/cza.gif'"
          	  onmouseout="document.all.cz.src='img/cz.gif'"
          	  onmouseup="document.all.cz.src='img/cza.gif'"        	
          	  onmousedown="document.all.cz.src='img/czb.gif'"/></td>
	      </tr>
	    </table>
	    <input type="hidden" name="action" value="login"/>
	  </form>
	  </center>
	</div>
	</div>
  </body>
</html>