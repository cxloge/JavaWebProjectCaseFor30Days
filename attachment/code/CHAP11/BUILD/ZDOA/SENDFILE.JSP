<%@ page contentType="text/html;charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>管理首页</title>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/sendFile.css" rel="stylesheet" type="text/css"/>
		<script language="JavaScript" src="javascript/position.js"></script>
		<script language="JavaScript">
			String.prototype.trim = function()
			{
			  return this.replace(/(^\s*)|(\s*$)/g, "");
			}
		
			function getUserList()	{
				var deptnumber=document.getElementById("deptlist").value;//获得选择的部门编号
				if(deptnumber!=""){//如果部门编号不是空字符串
					var uri="userListAction.action?deptNumber="+escape(deptnumber);//组织uri
					
	              	if(window.XMLHttpRequest)//初始化XMLHttpRequest对象
	              	{//IE之外的浏览器
	              		req=new XMLHttpRequest();
	             	}else{//如果是IE浏览器
	                	try{req=new ActiveXObject("Msxml2.XMLHTTP");}
	                	catch(e){
	                  		try	{req=new ActiveXObject("Microsoft.XMLHTTP");}
	                  		catch(e){
	                     		alert("不能创建XMLHttpRequest对象！！！");
	                     		return;
	                  		}
	                	}
	              	}              
				  	req.open("post",uri,true);
				  	req.onreadystatechange=handleResponse;//设置状态处理函数
	             	req.send(null); //发送请求   
             	}
			}
			function handleResponse(){
	          if(req.readyState==4){
	             if(req.status==200){
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
	        	var area=document.getElementById("touser");
	        	
	        	touser=area.value.trim();
	        	var array=touser.split(";");
	        	for(var i=0;i< array.length;i++)
	        	{
	        		if(array[i].trim()==user.trim())
	        		return;
	        	}
	        	if(touser!="")
	        	{
	        		touser=touser+" ";
	        	}
	        	touser=touser+user.trim()+";";
	        	area.value=touser;

	        }
	        function checksend()
	        {

	        	
	        	var info=document.getElementById("info").value.trim();
	        	if(info=="")
	        	{
	        		alert("简要主题不能为空");
	        		return false;
	        	}
	        	var myFile=document.getElementById("myFile").value.trim();
	        	if(myFile=="")
	        	{
	        		alert("请选择要发送的文件");
	        		return false;
	        	}
	        	var touser=document.getElementById("touser").value.trim();
	        	alert(touser.length);
	        	if(touser=="")
	        	{
	        		alert("收件人不能为空");
	        		return false;
	        	}
	        	if(touser.length>350)
	        	{
	        		alert("收件人过多");
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
	<body id="sendfile" onload="updateTree('li11');">
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
				<s:form onsubmit="return checksend();" theme="simple" action="sendFile2" method="post" enctype="multipart/form-data">
					<table style="width:500px;text-align:center;" border="0">
						<tr>
							<td style="width:80px;"></td>
							<td align="left">发送文件</td>
							<td align="right">发件人:<s:property value="fromuser"/></td>
						</tr>
						<tr>
							<td align="right">简要主题</td>
							<td colspan="2" align="left"><s:textfield id="info" name="info" cssStyle="width:420px;height:20px;"/></td>
						</tr>
						<tr>
							<td align="right">选择文件</td>
							<td colspan="2" align="left"><s:file id="myFile" name="myFile" onkeydown="return false;" size="49" cssStyle="width:420px;height:20px;"/></td>
						</tr>
						
						<tr>
							<td align="right">收件人列表</td>
							<td colspan="2" align="left"><s:textarea onfocus="this.blur();" name="touser" id="touser" cols="20" wrap="virtual" cssStyle="width:420px;height:100px;" theme="simple"/></td>
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
