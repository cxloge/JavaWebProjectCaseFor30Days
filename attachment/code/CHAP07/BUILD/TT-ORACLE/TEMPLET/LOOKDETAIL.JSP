<%@ page contentType="text/html;charset=gbk" %>

<% 
	String[] str = (String[])request.getAttribute("list");
	String flag = (String)request.getAttribute("flag");
	if(str==null){
		response.sendRedirect(request.getContextPath()+"/ManageServlet?action=getTicketMsg&type=3");
	}
 %>

<html>
	<head>
		<title>查看具体信息</title>
		<link href="css/top.css" type="text/css" rel="stylesheet"/>
		<style type="text/css">
			ul{
				background-color:#ffffff;
				border:solid 1px #C1DCF7;
				padding:30px;
				text-align:left;
				width:80%;
				font-size: 14px;
				color: #000000;
				list-style:none;
			}
			li{
				border-bottom:solid 1px #C1DCF7;
			}
		</style>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content">
			<p id="top">
				<a href="index.jsp">首页</a>>>
				<% 
					if(flag.equals("1")){
						out.println("<a href=\"messagemanage.jsp\">信息管理</a>>>");
					}
					else if(flag.equals("2")){
						out.println("<a href=\"messageinfo.jsp\">查看信息</a>>>");
					}
				 %><b>详细信息</b>
			</p><br/><br/>
			<center><font size="3"><b>详细信息<b/></center>
			<ul>
				<li>车次：<%= str[0] %></li>
				<li>列车类型：<%= str[1] %></li>
				<li>席别：<%= str[2] %></li>
				<li>发车日期：<%= str[3] %></li>
				<li>转让价格：<%= str[4] %></li>
				<li>出发城市：<%= str[5] %></li>
				<li>目的城市：<%= str[6] %></li>
				<li>联系人：<%= str[8] %></li>
				<li>联系电话：<%= str[9] %></li>
				<li>信息发布时间：<%= str[7].substring(0,19) %></li>
				<li>信息内容：<%= str[10] %></li>
			</ul>
		</div>
		</div>
	</body>
</html>









