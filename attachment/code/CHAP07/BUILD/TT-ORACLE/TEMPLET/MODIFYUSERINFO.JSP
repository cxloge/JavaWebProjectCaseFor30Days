<%@ page contentType="text/html;charset=gbk" %>

<% 
	String ugender = (String)request.getAttribute("ugender");
	System.out.println("ugender is: "+ugender);
	if(session.getAttribute("user")==null||ugender==null){
		response.sendRedirect("index.jsp");
	}
	else{
		String flag = "checked";
		String no_flag = "";
		if(!ugender.equals("男")){
			flag = "";
			no_flag = "checked";
		}
 %>

<html>
	<head>
		<title>用户资料修改</title>
 		<link href="css/reg.css" type="text/css" rel="stylesheet"/>
 		<script language="JavaScript" src="script/trim.js"></script>
 		<script language="JavaScript" src="script/reg.js"></script>
 		<script language="JavaScript" src="script/general.js"></script>
	</head>
	<body onload="document.getElementById('upwd_old').focus()">
		<div id="wrapper">
		<div id="branding"></div>
		<div id="content">
			<form action="ManageServlet" method="post" name="mf_reg">
			<p id="top">
				<a href="index.jsp">首页</a>>><b>资料修改</b>
			</p>
			<p id="reg_name">
				<span class="reg_left">用户名：</span>&nbsp;&nbsp;<%= session.getAttribute("user") %>  (不可修改)
			</p>
			<p id="reg_old">
				<span class="reg_left">旧口令：</span>
				<input type="password" name="upwd_old" onblur="checkOldUpwd()" onfocus="JavaScript:document.all.reg_old.className='reg_bg_focus'"/>
				<span id="upwd_old_explain"><font color="#909090">&nbsp;&nbsp;&nbsp;&nbsp;密码要至少6位以上，且不能包含空格，英文字母区分大小写</font></span>
			</p>
			<p id="reg_first">
				<span class="reg_left">新口令：</span>
				<input type="password" name="upwd_first" onblur="checkUpwd()" onfocus="JavaScript:document.all.reg_first.className='reg_bg_focus'"/>
				<span id="upwd_first_explain"><font color="#909090">&nbsp;&nbsp;&nbsp;&nbsp;密码要至少6位以上，且不能包含空格，英文字母区分大小写</font></span>
			</p>
			<p id="reg_second">
				<span class="reg_left">再次输入新口令：</span>
				<input type="password" name="upwd_second" onblur="checkSecUpwd()" onfocus="JavaScript:document.all.reg_second.className='reg_bg_focus'"/>
				<span id="upwd_second_explain"><font color="#909090">&nbsp;&nbsp;&nbsp;&nbsp;密码要至少6位以上，且不能包含空格，英文字母区分大小写</font></span>
			</p>
			<p id="reg_gender">
				<span class="reg_left">性别:</span>
				<input id="User_man" name="UserSex" type="radio" <%= flag %> value="男" style="cursor:hand"
							onfocus="JavaScript:document.all.reg_gender.className='reg_bg_focus'" 
							onblur="JavaScript:document.all.reg_gender.className=''"/>
				<img src="images/man.gif"/><label for="User_man" style="cursor:hand">&nbsp;&nbsp;男性</label>
				<input id="User_woman" name="UserSex" type="radio" <%= no_flag %> value="女" style="cursor:hand"
							onfocus="JavaScript:document.all.reg_gender.className='reg_bg_focus'" 
							onblur="JavaScript:document.all.reg_gender.className=''"/>
				<img src="images/woman.gif"/><label for="User_woman" style="cursor:hand">&nbsp;&nbsp;女性</label>
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
				<input type="button"  id='subButton' value="&nbsp;&nbsp;修&nbsp;改&nbsp;&nbsp;"  
					onclick="check_modify()"/>
			</p>
			<input type="hidden" name="action" value="modifyUserInfo"/>
			</form>
		</div>
		</div>
	</body>
</html>
<% 
	}
 %>
