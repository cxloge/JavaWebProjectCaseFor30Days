<%@ page contentType="text/html;charset=gbk" %>

<% 
	String msg = (String)request.getAttribute("msg");
 %>
 <html>
 	<head>
 		<title>信息页面</title>
 		<link href="css/top.css" type="text/css" rel="stylesheet" />
 	</head>
 	<body>
 		<div style="background:url(images/bg.gif);width:760px;height:100%;">
	 		<div id="branding"></div>
	 		<center>
	 			<br/><br/><br/><br/><br/>
	 			<h1><%= msg %></h1>
	 			<br/><br/><br/><br/> 		
	 			<b id="content"></b>
			<script language="JavaScript">
				var count = 4;
				function waitTime(){
					if(count!=1){
						count--;
						document.all.content.innerHTML="系统将会在"+count+"秒后自动返回！！！";
					}
					else{
						history.back();
					}
					setTimeout("waitTime()",1000);
				}
				waitTime();
			</script>
			</center>
		</div>
 	</body>
 </html>