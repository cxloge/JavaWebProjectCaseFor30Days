<%@ page contentType="text/html;charset=gbk" %>

<% 
	if(session.getAttribute("user")==null){
		session.setAttribute("flag","yes");
		session.setAttribute("url","/publishmsg.jsp");
		out.println("<script language='JavaScript'>alert('请你先登录！！！');window.location.href='index.jsp'</script>");
	}
	else{
 %>

<html>
	<head>
		<title>发布信息</title>
 		<link href="css/reg.css" type="text/css" rel="stylesheet"/>
 		<script language="JavaScript" src="script/trim.js"></script>
 		<script language="JavaScript" src="script/reg.js"></script>
 		<script language="JavaScript" src="script/publish.js"></script>
 		<script language="JavaScript" src="script/general.js"></script>
 		<script language="javascript" src="script/calendar.js"></script>
	</head>
	<body>
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content">
			<form action="ManageServlet" method="post" name="mf_publish">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>发布信息</b>
			</p>
			<p id="p_type">
				<span class="reg_left">请选择信息类型：</span>
				<select name="msg_type" onclick="JavaScript:document.all.p_type.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_type.className=''">
					<option value="2">&nbsp;&nbsp;求购&nbsp;&nbsp;</option>
					<option value="1">&nbsp;&nbsp;转让&nbsp;&nbsp;</option>
				</select>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请选择你要的发布信息的种类</font>
			</p>
			<p id="p_level">
				<span class="reg_left">请选择席别：</span>
				<select name="mlevel" onclick="JavaScript:document.all.p_level.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_level.className=''">
					<option value="座票">&nbsp;&nbsp;座票&nbsp;&nbsp;</option>
					<option value="卧铺">&nbsp;&nbsp;卧铺&nbsp;&nbsp;</option>
					<option value="不限">&nbsp;&nbsp;不限&nbsp;&nbsp;</option>
				</select>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请选择你要转让/求购车票的席别，如：座票</font>
			</p>
			<p id="p_name">
				<span class="reg_left">请输入车次的名字：</span>
				<input id="mname" name="mname"
						onclick="JavaScript:document.all.p_name.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_name.className=''"/>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请填写你要求购/转让的车次，如：K39</font>
			</p>
			<p id="p_date">
				<span class="reg_left">车票日期：</span>
				<input name="mtickettime" id="mtickettime"
						class="boxinput" onmouseout="calshow=false"
						onclick="JavaScript:showCalendar('mtickettime');this.blur();"
						onblur="JavaScript:document.all.p_date.className=''"/>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请填写你要转让/求购车票的日期，格式yyyy-mm-dd</font>
			</p>
			<p id="p_amount">
				<span class="reg_left">车票数量：</span>
				<input name="mamount" id="mamount"
						onclick="JavaScript:document.all.p_amount.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_amount.className=''"/>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请填写你要转让/求购车票的数量，只能为数字，且不可为0</font>
			</p>
			<p id="p_start">
				<span class="reg_left">出发城市：</span>
				<input name="mstart"
						onclick="JavaScript:document.all.p_start.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_start.className=''"/>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请填写你的出发城市，如：唐山</font>
			</p>
			<p id="p_end">
				<span class="reg_left">目的城市：</span>
				<input name="mend"
						onclick="JavaScript:document.all.p_end.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_end.className=''"/>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请填写你的目的城市，如：北京</font>
			</p>
			<p id="p_price">
				<span class="reg_left">车票价格：</span>
				<input name="mticketprice"
						onclick="JavaScript:document.all.p_price.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_price.className=''"/>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请填写车票的价格，也可不填，默认为：不限</font>
			</p>
			<p id="p_linkman">
				<span class="reg_left">联系人：</span>
				<input name="mlinkman"
						onclick="JavaScript:document.all.p_linkman.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_linkman.className=''"/>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请填写联系人的姓名，如：李逸晨</font>
			</p>
			<p id="p_tel">
				<span class="reg_left">联系电话：</span>
				<input name="mtel"
						onclick="JavaScript:document.all.p_tel.className='reg_bg_focus'"
						onblur="JavaScript:document.all.p_tel.className=''"/>
				<font color="#909090">&nbsp;&nbsp;&nbsp;请填写你的联系电话，如：0315-3860548</font>
			</p>
			<p id="p_content">
				<span class="reg_left">信息内容：</span>
				<textarea cols="50" rows="3" name="mmsg"
					onclick="JavaScript:document.all.p_content.className='reg_bg_focus'"
					onblur="JavaScript:document.all.p_content.className=''"
				>在此输入你要发布的信息</textarea>
			</p>
			<p id="reg_yzm" style="height:70px">
				<span class="reg_left">请输入右侧的验证码：</span>
				<input name="identify" onfocus="JavaScript:document.all.reg_yzm.className='reg_bg_focus'"
						onblur="JavaScript:document.all.reg_yzm.className=''" />
				<span>&nbsp;&nbsp;&nbsp;&nbsp;<img id="yzm" src="yzm.jsp" valign="center"/>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="JavaScript:loadImg()">看不清楚？点击再换一个</a></span>
			</p>
			<p>
				<span class="reg_left"></span>&nbsp;
				<input type="button"  id='subButton' value="&nbsp;&nbsp;发&nbsp;布&nbsp;&nbsp;"  
					onclick="JavaScript:checkPublishMsg()"/>
			</p>
			<input type="hidden" name="action" value="publish"/>
			</form> 
			<%@ include file="calendar.jsp" %>
		</div>
		<%@ include file="tip.jsp" %>
		</div>
	</body>
</html>
<% 
	}
 %>