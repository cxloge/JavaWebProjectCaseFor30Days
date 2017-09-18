<%@ page contentType="text/html;charset=gbk" %>

<html>
	<head>
		<title>车票预订</title>
 		<link href="css/book.css" type="text/css" rel="stylesheet"/>
 		<script language="JavaScript" src="script/trim.js"></script>
		<script language="JavaScript" src="script/general.js"></script>
		<script language="JavaScript" src="script/book.js"></script>
		<script language="JavaScript" src="script/showtip.js"></script>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>车票预订</b>
			</p>
				<fieldset class="book_input">
				<legend>
					<a href="#" onclick="document.all.mf_book.style.display='block';document.all.mf_train.style.display='none';">站站预订<a/><font size="3">/</font>
					<a href="#" onclick="document.all.mf_book.style.display='none';document.all.mf_train.style.display='block';">车次预订</a>
				</legend>
				<form action="ManageServlet" method="post" name="mf_book" id="mf_book">
				<ul>
					<li>&nbsp;</li>
					<li><span class="book_error">*</span>出发城市：<input id="tstart" name="tstart" onfocus="JavaScript:setId('tstart')"/></li>
					<li><span class="book_error">*</span>目的城市：<input id="tend" name="tend"  onfocus="JavaScript:setId('tend')"/></li>
					<script language="JavaScript">
						if (!isIE) document.captureEvents(Event.KEYUP);
						document.all.tstart.onkeyup = processKey;
						document.all.tend.onkeyup = processKey;
					</script>
					<li>&nbsp;</li>
					<li>
						<input class="btn" type="button" onclick="JavaScript:checkInfo()" value="&nbsp;下一步&nbsp;"/>
						<input class="btn" type="button" onclick="JavaScript:document.mf_book.reset()" value="&nbsp;重&nbsp;&nbsp;置&nbsp;"/>
					</li>
					<li><br/><br/>请输入上面的各项信息，并单击确定按钮，进行车次选择其中带*的为必填项。</li>
					<input type="hidden" name="action" value="zzSearch"/>
				</ul>
				</form>
				<form action="ManageServlet" method="post" name="mf_train" id="mf_train" style="display:none">
				<ul>
					<li>&nbsp;</li>
					<li><span class="book_error">*</span>&nbsp;&nbsp;&nbsp;&nbsp;车次&nbsp;&nbsp;&nbsp;&nbsp;：<input id="tname" name="tname"/>
					<li>&nbsp;</li>
					<li>
						<input class="btn" type="button" onclick="JavaScript:checkMsg()" value="&nbsp;下一步&nbsp;"/>
						<input class="btn" type="button" onclick="JavaScript:document.mf_train.reset()" value="&nbsp;重&nbsp;&nbsp;置&nbsp;"/>
					</li>
					<li><br/><br/>请输入上面的各项信息，并单击确定按钮，进行车次选择其中带*的为必填项。</li>
					<input type="hidden" name="action" value="book"/>
				</ul>
			</form>
			</fieldset>
			<div class="list_hidden" id="city" border="1"></div>
			<%@ include file="tip.jsp" %>
		</div>
		</div>
	</body>
</html>

