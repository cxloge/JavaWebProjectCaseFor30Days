<%@ page contentType="text/html;charset=gbk" %>
<% 
	List<String[]> ls = (List<String[]>)session.getAttribute("initlist");
 %>
<html>
	<head>
		<title>网上票务查询</title>
		<link href="css/main.css" type="text/css" rel="stylesheet" />
		<script language="JavaScript" src="script/trim.js"></script>
		<script language="JavaScript" src="script/general.js"></script>
		<script language="JavaScript" src="script/index.js"></script>
		<script language="JavaScript" src="script/showtip.js"></script>
	</head>
	<body>
		<div id="wrapper">
			<div id="branding"></div>
			<div id="log">
			<% 
				String msg = "";
				if(session.getAttribute("user")!=null){
					msg = session.getAttribute("user")+"，你好！";
				}
			 %>
			<marquee width="350" scrolldelay="5" scrollamount="1" onmouseover="this.stop()" onmouseout="this.start()"><%= msg %>欢迎光临骄阳火车票务网</marquee>
			</div>
			<div id="content">
				<p id="con_title">&nbsp;&nbsp;&nbsp;<b title="欢迎使用骄阳票务查询网">火车在线查询</b></p>
				<p id="zzcx">
					<form action="ManageServlet" method="post" name="mf_zzcx">
					【 <b>站站查询</b> 】&nbsp;&nbsp;&nbsp;
					请输入您的出发地及目的地。如：北京-->唐山<br/><br/>
					&nbsp;&nbsp;&nbsp;<img border="0" src="images/train_1.gif"/>&nbsp;
					出发城市：<input size="10" id="start" name="start" onfocus="JavaScript:setId('start')"/>&nbsp;&nbsp;&nbsp;&nbsp;
					目的城市：<input size="10" id="end" name="end" onfocus="JavaScript:setId('end')"/>&nbsp;&nbsp;&nbsp;
					<!--  
					<button onclick="JavaScript:zzcx()">查询</button>&nbsp;&nbsp;
					<button onclick="JavaScript:document.mf_zzcx.reset()">重置</button>
					-->
					<input class="btn" type="button" onclick="JavaScript:zzcx()" value="&nbsp;查询&nbsp;"/>
					<input class="btn" type="button" onclick="JavaScript:document.mf_zzcx.reset()" value="&nbsp;重置&nbsp;"/>
					
					<input type="hidden" name="action" value="zzcx"/>
					</form>
				</p>
				<p id="czcx" class="train_search">
					<form action="ManageServlet" method="post" name="mf_czcx">
					【 <b>车站查询</b> 】&nbsp;&nbsp;&nbsp;
					此处用于查询经过某站的所有列车。如：唐山<br/><br/>
					&nbsp;&nbsp;<img border="0" src="images/train_2.gif"/>车站名称：
					<input name="station" id="station" onfocus="JavaScript:setId('station')"/>&nbsp;&nbsp;&nbsp;
					<!--  
					<button onclick="JavaScript:czcx()">查询</button>&nbsp;&nbsp;
					<button onclick="JavaScript:document.mf_czcx.reset()">重置</button>
					-->					
					<input class="btn" type="button" onclick="JavaScript:czcx()" value="&nbsp;查询&nbsp;"/>
					<input class="btn" type="button" onclick="JavaScript:document.mf_czcx.reset()" value="&nbsp;重置&nbsp;"/>
					
					<input type="hidden" name="action" value="czcx"/>
					</form>
				</p>
				<p id="cccx" class="train_search" >
					<form action="ManageServlet" method="post" name="mf_cccx">
					【 <b>车次查询</b> 】&nbsp;&nbsp;&nbsp;
					请输入您要查询的车次。如：K39<br/><br/>
					&nbsp;&nbsp;<img border="0" src="images/train_3.gif"/>车次名称：
					<input name="train" id="train"/>&nbsp;&nbsp;&nbsp;
					<!--  
					<button onclick="JavaScript:cccx()">查询</button>&nbsp;&nbsp;
					<button onclick="JavaScript:document.mf_cccx.reset()">重置</button>
					-->
					<input class="btn" type="button" onclick="JavaScript:train_search()" value="&nbsp;查询&nbsp;"/>
					<input class="btn" type="button" onclick="JavaScript:document.mf_cccx.reset()" value="&nbsp;重置&nbsp;"/>					
					<input type="hidden" name="action" value="cccx"/>
					</form>
				</p>
			<div class="list_hidden" id="city" border="1"></div>
			</div>
			<script language="JavaScript">
				if (!isIE) document.captureEvents(Event.KEYUP);
				document.all.start.onkeyup = processKey;
				document.all.end.onkeyup = processKey;
				document.all.station.onkeyup = processKey;
			</script>
			<fieldset class="login">
				<legend>登录</legend>
				<% 
					if(session.getAttribute("user")==null){
				 %>
				<form action="ManageServlet" method="post" name="mf_login">
					<li>用户名：</li>
					<li><input size="17" name="uname" value="zrk" alt="请输入用户名"/></li>
					<li>密&nbsp;&nbsp;码：</li>
					<li><input type="password" size="17" name="upwd" value="860607" alt="请输入密码"/></li>
					<li>
						<input type="button" class="btn" onclick="JavaScript:check()" value="&nbsp;登录&nbsp;"/>&nbsp;&nbsp;&nbsp;
						<input type="button" onclick="window.location.href='register.jsp'" class="btn" value="&nbsp;注册&nbsp;"/>
					</li>
					<input type="hidden" name="action" value="login"/>
				</form>
				<% 
					}
					else{
				 %>
				 <ul>
				 	<li><a href="<%= request.getContextPath() %>/ManageServlet?action=logout">退出登录</a></li>
				 	<li><a href="<%= request.getContextPath() %>/ManageServlet?action=msgManage">信息管理</a></li>
				 	<li><a href="<%= request.getContextPath() %>/ManageServlet?action=lookUserInfo">资料修改</a></li>
				 	<li><a href="<%= request.getContextPath() %>/ManageServlet?action=lookBookInfo">我的预订</a></li>
				 </ul>
				<%
					}
				 %>
			</fieldset>
			<fieldset class="login">
				<legend>导航</legend>
				<ul>
					<li><a href="index.jsp">车次查询</a></li>
					<li><a href="bookticket_a.jsp">车票预订</a></li>  
					<li><a href="<%= request.getContextPath() %>/ManageServlet?action=getTicketMsg&type=1">转让信息</a></li> 
					<li><a href="<%= request.getContextPath() %>/ManageServlet?action=getTicketMsg&type=2">求购信息</a></li>
					<li><a href="publishmsg.jsp">发布信息</a></li>
				</ul>
			</fieldset>
 			<div id="msg">
 				<p id="msg_top"><a href="<%= request.getContextPath() %>/ManageServlet?action=getTicketMsg&type=3">>><i>查看更多信息</i></a></p>
				<div id="msg_inner">
					<marquee behavior="scroll" direction="up" height="120" scrollamount="1" scrolldelay="60" onmouseover="this.stop()" onmouseout="this.start()">
					<% 
						StringBuilder sb = new StringBuilder();
						if(ls==null||ls.size()==0){
							out.println("暂无信息");
						}
						else{
							for(int i=0;i<ls.size();i++){
								String str[] = ls.get(i);
								sb.append("<a href=");
								sb.append(request.getContextPath());
								sb.append("/ManageServlet?action=lookdetail&mid=");
								sb.append(str[0]);
								sb.append("&flag=3>&nbsp;&nbsp;&nbsp;");
								if(str[1].equals("1")){
									sb.append("转让");
								}
								else{
									sb.append("求购");
								}
								String[] dd = str[2].split("-");
								sb.append(dd[0]);
								sb.append("年");
								sb.append(dd[1]);
								sb.append("月");
								sb.append(dd[2]);
								sb.append("日");
								sb.append(str[3]);
								sb.append("次列车车票，联系人：");
								sb.append(str[4]);
								sb.append("，联系电话：");
								sb.append(str[5]);
								sb.append("</a></br>");
							}
						}
					 %>
					 <font size="2.5"><%= sb.toString() %></font>
  					</marquee>
					
				</div>
 			</div>
			<div id="footer">
				<p><i>欢迎光临本网站,如果您有什么疑问，请联系我们&nbsp;&nbsp;
					www.zhairuike@yahoo.com.cn
				</i></p>
			</div>
			<%@ include file="tip.jsp" %>
		</div>
	</body>
</html>
