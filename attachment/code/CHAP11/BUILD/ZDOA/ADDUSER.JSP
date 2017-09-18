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
			function getreq(){
				if(window.XMLHttpRequest)
	              	{//IE之外的浏览器
	              		req=new XMLHttpRequest();
	              		return req;
	             	}
	              	else
	              	{
	                	try
	                	{
	                  		req=new ActiveXObject("Msxml2.XMLHTTP");
	                  		return req;
	                	}
	                	catch(e)
	                	{
	                  		try
	                  		{
	                     		req=new ActiveXObject("Microsoft.XMLHTTP");
	                     		return req;
	                  		}
	                  		catch(e)
	                  		{
	                     		alert("不能创建XMLHttpRequest对象！！！");
	                     		return "";
	                  		}
	                	}
	                
	              	}
			}
			function checkUnique()
			{
				var name=document.getElementById("name").value.trim();
				
				if(name!="")
				{
					var uri="userUnique.action?name="+escape(name);
					//初始化XMLHttpRequest对象
	              	req=getreq();
	              	if(req=="")
	              	{
	              		return "";
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
	                if(msg.trim()=="no")
	                {
	                	alert("该用户名已经被占用，请重新填写");
	                }
	             }
	          }
	        }
	        function updateGroup()
	        {
	        	var dept=document.getElementById("dept").value.trim();

	        	document.getElementById("roleL").innerHTML="\<select name=\"role\" id=\"role\" style=\"width:200px;\"\>\<option value=\"\"\>选择角色\</option>\</select>"
	 
        		var uri="groupList.action?dept="+escape(dept);
				//初始化XMLHttpRequest对象
              	req=getreq();
              	if(req=="")
              	{
              		return "";
              	}        
			  	req.open("post",uri,true);
			  	req.onreadystatechange=handleResponse1;
             	req.send(null);
	        }
	        function handleResponse1()
	        {
	          if(req.readyState==4)
	          {
	             if(req.status==200)
	             {
	                var msg=req.responseText;
	                document.getElementById("groupL").innerHTML=msg;
	             }
	          }
	        }
	        function updateRole()
	        {
	        	var group=document.getElementById("group").value.trim();
        		var uri="roleList.action?group="+escape(group);
				//初始化XMLHttpRequest对象
              	req=getreq();
              	if(req=="")
              	{
              		return "";
              	}        
			  	req.open("post",uri,true);
			  	req.onreadystatechange=handleResponse2;
             	req.send(null);
	        }
	        function handleResponse2()
	        {
	          if(req.readyState==4)
	          {
	             if(req.status==200)
	             {
	                var msg=req.responseText;
	                document.getElementById("roleL").innerHTML=msg;
	             }
	          }
	        }
	        function checkAddUser()
	        {
	        	var name=document.getElementById("name").value.trim();
	        	var namepat=/^[0-9a-zA-Z_]{1,10}$/;
	        	if(name=="")
	        	{
	        		alert("用户名不能为空");
	        		return false;
	        	}
	        	if(name.length>10)
	        	{
	        		alert("用户名太长");
	        		return false;
	        	}
	        	if(!namepat.exec(name))
	        	{
	        		alert("用户名只能由字母数字和下划线组成");
	        		return false;
	        	}
	        	var pwd1=document.getElementById("pwd1").value.trim();
	        	if(pwd1=="")
	        	{
	        		alert("密码不能为空");
	        		return false;
	        	}
	        	var pwdpat=/^[0-9a-zA-Z_]{1,10}$/;
	        	if(!pwdpat.exec(pwd1))
	        	{
	        		alert("密码只能由10位以内的字母数字和下划线组成");
	        		return false;
	        	}
	        	var pwd2=document.getElementById("pwd2").value.trim();
	        	if(pwd1!=pwd2)
	        	{
	        		alert("两次密码输入不一致");
	        		return false;
	        	}
	        	var realName=document.getElementById("realName").value.trim();
	        	if(realName=="")
	        	{
	        		alert("真实姓名不能为空");
	        		return false;
	        	}
	        	if(realName.length>10)
	        	{
	        		alert("真实姓名过长，请检查正确性");
	        		return false;
	        	}
	        	var birth=document.getElementById("birth").value.trim();
	        	var birthpat=/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
	        	if(!birthpat.exec(birth))
	        	{
	        		alert("出生日期格式不正确，请您确认");
	        		return false;
	        	}
	        	var role=document.getElementById("role").value.trim();
	        	if(role=="")
	        	{
	        		alert("请选择员工的工作职位");
	        		return false;
	        	}
	        	var email=document.getElementById("email").value.trim();
	        	var emailpat=/^[.-_a-zA-Z0-9]+@[-_a-zA-Z0-9]+\.[.a-zA-Z0-9]+$/;
	        	if(!emailpat.exec(email))
	        	{
	        		alert("邮箱格式不正确，请检查");
	        		return false;
	        	}
	        	var tel=document.getElementById("tel").value.trim();
	        	var telpat=/^[0-9]{7,20}$/;
	        	if(!telpat.exec(tel))
	        	{
	        		alert("联系电话格式不正确，请检查");
	        		return false;
	        	}
	        	var salary=document.getElementById("salary").value.trim();
	        	var salarypat=/^[0-9]{1,5}[\.]?[0-9]{0,2}$/;
	        	if(!salarypat.exec(salary))
	        	{
	        		alert("基本薪资填写错误，请检查");
	        		return false;
	        	}
	        	if(salary>99999.99||salary<0)
	        	{
	        		alert("基本薪资超出范围");
	        		return false;
	        	}
	        	var jianli=document.getElementById("jianli").value.trim();
	        	if(jianli=="")
	        	{
	        		alert("个人简历不能为空");
	        		return false;
	        	}
	        	if(jianli.length>2000)
	        	{
	        		alert("个人简历太长");
	        		return false;
	        	}
	        	return true;
	        }
		</script>
	
	</head>
	<body id="sendfile" onload="updateTree('li51');">
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent">
		<s:form action="addUser2" theme="simple" onsubmit="return checkAddUser();" method="post" enctype="multipart/form-data">
			<table border="0" width="100%" cellpadding="0" cellspacing="0">
				<tr style="height:40px;">
					<td align="right" style="width:120px;border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">用户名：</td>
					<td style="width:230px;border-bottom:#a8cde4 solid 1px;"><s:textfield name="name" id="name" cssStyle="width:200px;" onblur="checkUnique();"/></td>
					<td style="width:400px;border-bottom:#a8cde4 solid 1px;">由字母、数字或下划线组成，且不能超出10位，必填</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">密码：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:password name="pwd1" id="pwd1" cssStyle="width:200px;"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;width:450px;">由字母、数字或下划线组成，且不能超出10位，必填</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">再次输入密码：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:password name="pwd2" id="pwd2"  cssStyle="width:200px;"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">由字母、数字或下划线组成，且不能超出10位，必填</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">真实姓名：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:textfield id="realName" name="realName" cssStyle="width:200px;"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">填写您的真实姓名，必填</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">性别：</td>
					<td style="border-bottom:#a8cde4 solid 1px;">
						<s:select id="gender" cssStyle="width:50px;" name="gender" list="#{'男':'男','女':'女'}" listKey="key" listValue="value"/>
				
					</td>
					<td style="border-bottom:#a8cde4 solid 1px;">选择性别，必填</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">出生日期：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:textfield id="birth" name="birth" cssStyle="width:200px;"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">格式为YYYY-MM-DD,如2009-01-17表示2009年1月17日</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">所属部门：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:select name="dept" id="dept" onchange="updateGroup();" cssStyle="width:200px;" list="deptList" listKey="deptNumber" listValue="deptName"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">必选项</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">所属组：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"  id="groupL"><s:select id="group" name="group" onchange="updateRole();" cssStyle="width:200px;" list="groupList" listKey="groupNumber" listValue="groupName"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">必选项</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">职位角色：</td>
					<td id="roleL" style="border-bottom:#a8cde4 solid 1px;"><s:select name="role" id="role" cssStyle="width:200px;" list="roleList" listKey="roleNumber" listValue="roleName"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">必选项</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">电子邮箱：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:textfield name="email" id="email" cssStyle="width:200px;"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">格式必须正确</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">电话：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:textfield id="tel" name="tel"  cssStyle="width:200px;"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">请填写您最常用的联系西电话</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">基本工资：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:textfield name="salary" id="salary" cssStyle="width:200px;"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">必填项</td>
				</tr>
				<tr style="height:40px;">
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">上传头像：</td>
					<td style="border-bottom:#a8cde4 solid 1px;"><s:file name="pic" id="pic" cssStyle="width:200px;"/></td>
					<td style="border-bottom:#a8cde4 solid 1px;">可选项</td>
				</tr>
				<tr>
					<td align="right" style="border-bottom:#a8cde4 solid 1px;border-right:#a8cde4 solid 1px;">个人简历：</td>
					<td colspan="2" style="border-bottom:#a8cde4 solid 1px;"><s:textarea name="jianli" id="jianli" cssStyle="width:610px;height:250px;"/></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><s:submit value="提交"/>&nbsp&nbsp&nbsp&nbsp&nbsp<s:reset value="取消"/></td>
				</tr>
			</table>
		</s:form>
		</div>
	</div>
	<script language="JavaScript">
		var result="<s:property value="result"/>";
		if(result!="")
		{
			alert(result);
		}
	</script>
	</body>
</html>
