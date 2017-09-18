<%@ page contentType="text/html; charset=gbk" %>
<html>
  <head>
	<title>修改密码</title>
	<link rel=stylesheet href="css/style.css" type="text/css">
	<script language="JavaScript" src="script/trim.js"></script>
	<script language="JavaScript">
		function check(){
		  if(document.all.aname.value.trim()==""){
		    alert("用户名不能为空!!!");
		    return false;
		  }
		  if(document.all.apwd.value.trim()==""){
		    alert("请输入旧密码!!!");
		    return false;
		  }
		  if(document.all.fpwd.value.trim()==""){
		    alert("新密码不能为空!!!");
		    return false;
		  }
		  if(document.all.fpwd.value.trim()!=document.all.spwd.value.trim()){
		    alert("两次密码输入不一致!!!");
		    return false;
		  }
		  document.all.mf.submit();
		}
	</script>
  </head>
  <body>
  	<div class="out">
  	<center><br/><br/><br/><br/><br/><h2>修改密码</h2></center>
    <div class="login_style">
      <center>
	  <form action="ManageServlet" method="post" id="mf" target="bottom">
	    <table>
	      <tr>
	        <td>用户名:</td>
	        <td><input name="aname" id="aname"/></td>
	      </tr>
	      <tr>
	        <td>密&nbsp;码:</td>
	        <td><input type="password" id="apwd" name="apwd" /></td>
	      </tr>
	      <tr>
	        <td>新密码:</td>
	        <td><input type="password" name="fpwd" id="fpwd"/></td>
	      </tr>
	      <tr>
	        <td>确认新密码:</td>
	        <td><input type="password" name="spwd" id="spwd"/></td>
	      </tr>
		  <tr>
		    <td colspan="2" align="center">
		    <img border="0" src="img/sm.gif" id="xg" onclick="JavaScript:check()"
	          	  style="cursor:hand"
	          	  onmouseover="document.all.xg.src='img/sma.gif'"
	          	  onmouseout="document.all.xg.src='img/sm.gif'"
	          	  onmouseup="document.all.xg.src='img/sma.gif'"        	
	          	  onmousedown="document.all.xg.src='img/smb.gif'"/>
		    <img border="0" src="img/cz.gif" id="cz" onclick="JavaScript:document.all.mf.reset()"
	          	  style="cursor:hand"
	          	  onmouseover="document.all.cz.src='img/cza.gif'"
	          	  onmouseout="document.all.cz.src='img/cz.gif'"
	          	  onmouseup="document.all.cz.src='img/cza.gif'"        	
	          	  onmousedown="document.all.cz.src='img/czb.gif'"/></td>
		  </tr>
	    </table>
	    <input type="hidden" name="action" value="changepwd"/>
	  </form>
	  </center>
	</div>
	</div>
  </body>
</html>