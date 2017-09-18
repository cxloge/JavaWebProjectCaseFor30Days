<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>发送消息</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/sendFile.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
		<script language="JavaScript">
			String.prototype.trim = function()
			{
			  return this.replace(/(^\s*)|(\s*$)/g, "");
			}
		
			function getUserList()
			{
				var deptnumber=document.getElementById("deptlist").value;
				
				if(deptnumber!="")
				{
					var uri="userListAction.action?deptNumber="+escape(deptnumber);
					//初始化XMLHttpRequest对象
	              	if(window.XMLHttpRequest)
	              	{//IE之外的浏览器
	              		req=new XMLHttpRequest();
	             	}
	              	else
	              	{
	                	try
	                	{
	                  		req=new ActiveXObject("Msxml2.XMLHTTP");
	                	}
	                	catch(e)
	                	{
	                  		try
	                  		{
	                     		req=new ActiveXObject("Microsoft.XMLHTTP");
	                  		}
	                  		catch(e)
	                  		{
	                     		alert("不能创建XMLHttpRequest对象！！！");
	                     		return;
	                  		}
	                	}
	                
	              	}              
				  	req.open("post",uri,true);
				  	req.onreadystatechange=handleResponse;
	             	req.send(null);    
             	}
			}
			function handleResponse()
	        {
	          if(req.readyState==4)
	          {
	             if(req.status==200)
	             {
	                var msg=req.responseText;
	                msg=unescape(msg);
	                document.getElementById("userlist").innerHTML=msg;
	             }
	          }
	        }
	        function mouseovercolor(id)
	        {
	        	document.getElementById(id).className="mouseover";
	        }
	        function mouseoutcolor(id)
	        {
	        	document.getElementById(id).className="mouseout";
	        }
	        function add(user)
	        {
	        	var area=document.getElementById("receiver");
	        	area.value=user;

	        }
	        function checksend()
	        {

	        	
	        	var receover=document.getElementById("receiver").value.trim();
	        	if(receover=="")
	        	{
	        		alert("消息接收人不能为空");
	        		return false;
	        	}
	        	var info=document.getElementById("info").value.trim();
	        	if(info=="")
	        	{
	        		alert("消息主题不能为空");
	        		return false;
	        	}
	        	var content=document.getElementById("content").value.trim();
	        	alert(touser.length);
	        	if(content=="")
	        	{
	        		alert("消息内容不能为空");
	        		return false;
	        	}
	        	var pos=getElementPos("sub");
	        	var sub=document.getElementById("tishi");
	        	sub.style.left=pos.x-2;
	        	sub.style.top=pos.y-1;
	        	sub.style.display="block";
	        	return true;
	        	
	        	
	        }
		</script>
		
	</head>
	<body id="sendfile" onload="updateTree('li31');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent">
			<table border="0" bgcolor="#eff5fb" width="100%">
			<tr>
				<td valign="top">
				<s:form onsubmit="return checksend();" theme="simple" action="sendMessage2" method="post">
					<table style="width:500px;text-align:center;" border="0">
						<tr>
							<td style="width:80px;"></td>
							<td align="left">发送消息</td>
							<td align="right">发送人:<s:property value="fromuser"/></td>
						</tr>
						<tr>
							<td align="right">接收人</td>
							<td colspan="2" align="left"><s:textfield id="receiver" name="receiver" onkeydown="return false;" size="49" cssStyle="width:420px;height:20px;"/></td>
						</tr>
						<tr>
							<td align="right">消息主题</td>
							<td colspan="2" align="left"><s:textfield id="info" name="info" cssStyle="width:420px;height:20px;"/></td>
						</tr>
						
						
						<tr>
							<td align="right">消息内容</td>
							<td colspan="2" align="left"><s:textarea name="content" id="content" cols="20" wrap="virtual" cssStyle="width:420px;height:200px;" theme="simple"/></td>
						</tr>
						<tr>
							<td></td>
							<td align="left"><s:submit value="发送" id="sub"/>&nbsp&nbsp&nbsp<s:reset value="取消"/></td>
							<td></td>
						</tr>
					</table>
				</s:form>
				</td>
				<td valign="top" style="text-align:center;background-color:#eff5fb">
					<table width="220px" align="center" style="margin:0 auto">
						<tr>
						<td align="center">部门:<s:select id="deptlist" list="deptList" listKey="deptNumber" listValue="deptName" theme="simple" cssStyle="width:150" onchange="getUserList();"/></td>
						</tr>
						<tr>
						<td align="center">
							<div id="userlist" style="width:200;border:2px outset #a8cde4;background-color:white"></div>
						</td>
						</tr>
					
					</table>
				</td>
			</tr>
			</table>
		</div>
	</div>
	<div id="tishi" style="width:300px;height:20px;position:absolute;display:none;">
		<table cellpadding="0" cellspacing="0" width="100%">
			<tr bgcolor="#4b981d" style="height:20px;width:300px;">
				<td>&nbsp&nbsp&nbsp</td>
				<td><img src="images/ico_loading.gif"></td>
				<td>&nbsp&nbsp&nbsp&nbsp正在发送，请稍候.......</td>
			</tr>
		</table>
	</div>
	</body>
</html>
