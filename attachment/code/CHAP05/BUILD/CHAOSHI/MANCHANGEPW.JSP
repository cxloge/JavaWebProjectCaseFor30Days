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
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function check()
      {
      	var aname = document.getElementById('aname').value.trim();
      	var apwd = document.addform.apwd.value.trim();
      	var secpwd = document.addform.secpwd.value.trim();
      	if(aname=="")
      	{
      		alert("管理员名不能为空!!!");
      		return;
      	}
      	if(apwd==""||apwd.length<6)
      	{
      		alert("密码不合法,长度不得小于6!!!");
      		return;
      	}
      	if(secpwd!=apwd)
      	{
      		alert("两次密码输入不一至!!!");
      		return;
      	}
      	document.addform.submit();
      }
    </script>
  </head>
<body style="background:url('img/top/bg.gif')">
<br/><br/>


<table border="0" width="400" style="border:1px solid #6daafc" align="center">
  <tr>
    <td>
		<table border="0" width="100%">
		  <caption style="font-size:1.6em;font-weight:bold">管理员密码修改</caption>
              <form action="ManageServlet" method="post" name="addform">
                <tr>
                  <td align="right">请输入管理员名</td>
                  <td>
                  	<%
                  	   if(chaoji==null)
                  	   {
                  	%>
                  	    <input type="hidden" name="aname" value="<%=session.getAttribute("manager")%>"/>
                  	    <input type="text" id="aname" value="<%=session.getAttribute("manager")%>" disabled/>
                  	<%
                  	   }
                  	   else
                  	   {
                  	%>
                  	    <input type="text" name="aname" id="aname" value="<%=session.getAttribute("manager")%>"/>
                  	<%
                  	   }
                  	%>   
                  </td>
                </tr>
                <tr>
                  <td align="right">请输入新密码</td>
                  <td><input type="password" name="apwd"/></td>
                </tr>
                <tr>
                  <td align="right">请再次输入新密码</td>
                  <td><input type="password" name="secpwd"/></td>
                </tr>
                <tr>
                  <td align="right">
                    <input type="hidden" name="action" value="resetpwd"/>
                    <input type="button" value="提交" onclick="check()"/>
                  </td>
                  <td><input type="reset" value="重置"/></td>
                </tr>
              </form>
         </table>
     </td>
  </tr>
</table>
</body>
</html>
<%
   String msg=(String)request.getAttribute("msg");
   if(msg!=null)
   {
%>
   <script>
     alert('<%=msg%>');
   </script>
<%
   }
%>
