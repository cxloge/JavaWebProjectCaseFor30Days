<%@ page contentType="text/html;charset=gbk"
	import="java.util.*"
 %>

 <html>
 	<head>
 		<title>联系人资料填写</title>
 		<link href="css/book.css" type="text/css" rel="stylesheet"/>
 		<script language="JavaScript" src="script/trim.js"></script>
		<script language="JavaScript" src="script/general.js"></script>
		<script language="JavaScript" src="script/book.js"></script>
		<script language="javascript" src="script/calendar.js"></script>
 	</head>
 	<body>
 		<div id="wrapper">
		<div id="branding"></div>
		<div id="content" style="height:400px">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>车票预订</b>
			</p>
		
			<form action="ManageServlet" method="post" name="mf_msg">
			<fieldset class="msg_input">
				<legend>联系人信息</legend>
				<p>
					<label for="linkman">联系人姓名：</label>
					<input name="linkman" id="linkman" />
				</p>
				<p>
					<label for="tamount">车票数量：</label>
					<input name="tamount" id="tamount" />
				</p>
				<p>
					<label for="tdate">车票日期：</label>
					<input name="tdate" id="tdate" onmouseout="calshow=false"
						onclick="JavaScript:showCalendar('tdate');this.blur();"/>
				</p>
				<p>
					<label for="address">联系人地址：</label>
					<input name="address" id="address" />
				</p>
				<p>
					<label for="tel">联系人电话：</label>
					<input name="tel" id="tel" />
				</p>
				<p>
					<input type="hidden" name="action" value="saveMsg" />
					<input type="button" class="btn" value="下一步" onclick="JavaScript:check()" />&nbsp;&nbsp;
					<input type="reset" class="btn" value="重&nbsp;&nbsp;置"/>
				</p>
			</fieldset>
			</form><br/><br/>
			请填写您的真实姓名及联系方式，以确保您能及时地、准确地预订到您的车票，以免造成不必要的麻烦，耽误您的行程。
			<%@ include file="calendar.jsp" %>			
		</div>
		<%@ include file="tip.jsp" %>
		</div>
 	</body>
 </html>