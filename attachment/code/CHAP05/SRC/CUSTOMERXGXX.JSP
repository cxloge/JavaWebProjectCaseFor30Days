<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="wyf.hxl.PaginationBean,wyf.hxl.DB,java.util.*"%>
<html>
  <head>
    <title>顾客信息修改</title>
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function check()
      {
      	var pwd = document.mfmodify.upwd.value;
      	var email = document.mfmodify.uemail.value;
      	if(pwd.trim()=="")
      	{
      		alert("密码不可以为空!!!");
      		return;
      	}
      	else if(pwd.trim().length<6)
      	{
      		alert("密码长度不得少于6!!!");
      		return;
      	}
      	else if(email.trim()=="")
      	{
      		alert("E-mail不得为空!!!");
      		return;
      	}
      	document.mfmodify.submit();
      }
    </script>
  </head>
  <body style="background:url('img/top/bg.gif')">
     <table width="100%">
		  <tr align="center">
		    <td>
		      <table>
		        <form action="CustomerServlet" method="post" name="mfmodify">
		          <% 
		              String uname = (String)session.getAttribute("user");
		              uname = new String(uname.getBytes(),"ISO-8859-1");
		          	  String sql = "select cname,cpw,cemail from gcustomer where cname='"+uname+"'";
		          	  Vector<String[]> vuser = DB.getMessage(sql);
		          	  String[] str = vuser.get(0);
		           %>
		          <tr align="center">
		            <td><br/><br/>用户名:</td>
		            <td align="left"><br/><br/><%=str[0] %></td>
		          </tr>
		          <tr>
		            <td><br/><br/>密&nbsp;码:</td>
		            <td><br/><br/><input  name="cpw" value="<%=str[1] %>"/></td>
		          </tr>
		          <tr>
		            <td><br/><br/>Email:</td>
		            <td><br/><br/><input name="cemail" value="<%=str[2] %>"/></td>
		          </tr>
		          <tr>
		            <td align="right">
		              <br/><br/><input type="button" value="修改" onclick="check()"/>
		              <input type="hidden" name="action" value="customermodify"/>
		            </td>
		            <td align="right"><br/><br/>
		              <a href="javascript:history.back()">返回上一层</a>
		            </td>
		          </tr>
		        </form>
		      </table>
		    </td>
		  </tr>
	</table>
  </body>
</html>