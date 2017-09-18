<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*,wyf.hxl.PaginationBean" %>
<jsp:useBean id="handlePage" class="wyf.hxl.PaginationBean" scope="session"/>
<% 
	if(session.getAttribute("user")==null)
	{
		response.sendRedirect("customermanage.jsp");
	}
	else
	{
 %>
<html>
  <head>
    <title>订单信息</title>
    <script language="javascript" src="script/trim.js"></script>
    <script language="javascript">
      function checkMsg()
      {
        
      	var recname = document.getElementById("recname").value;
      	var recadr = document.getElementById("recadr").value;
      	var rectel = document.getElementById("rectel").value;
      	var zzs =/^[0-9]{1,13}$/;
      	
      	if(recname.trim()=="")
      	{
      		alert("收货人不能为空!!!");
      		return false;
      	}
      	if(recadr.trim()=="")
      	{
      		alert("收货人地址不能为空!!!");
      		return false;
      	}
      	if(rectel.trim()=="")
      	{
      		alert("电话号码不能为空!!!");
      		return false;
      	}
      	if(!zzs.test(rectel))
      	{
      		alert("电话号码格式错误!!!");
      		return false;
      	}
      	return true;
      }
    </script>
  </head>
  <body style="background:url('img/top/bg.gif')">
    <center>
    <table border="0" width="400" style="border:1px solid #6daafc">
    <tr>
     <td>
            <table border="0" width="100%">
              <caption style="font-size:1.5em;font-weight:bold">收货人信息</caption>
              <form action="CustomerServlet" method="post" onsubmit="return checkMsg();">
              <input type="hidden" name="action" value="saveRec">
              <input type="hidden" name="orderid" value="<%=request.getAttribute("orderid")%>">
                <tr>
                  <td width="100" align="right">收货人姓名</td>
                  <td><input name="recname" id="recname" size="38"/></td>
                </tr>
                <tr>
                  <td align="right">收货人地址</td>
                  <td><input name="recadr" id="recadr" size="38"/></td>
                </tr>
                <tr>
                  <td align="right">收货人电话</td>
                  <td><input name="rectel" id="rectel" size="38"/></td>
                </tr>
             </table>
             <table width="100%" border="0">
                <tr>
                  <td style="color:red">
                    &nbsp;&nbsp;请务必填写正确的信息,以保证您的货物能顺利收到.
                  </td>
                </tr>
                <tr>
                  <td>
                    &nbsp;&nbsp;<input type="submit" value="确定"/>
                    <input type="button" value="取消" onclick="location.reload('cart.jsp');"/>
                  </td>
                </tr>
              </table> 
      </td></tr></table>
    </center>
  </body>
</html>
<% 
	}
 %>