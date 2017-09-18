<%@ page contentType="text/html;charset=gbk"%><html>
<jsp:useBean id="status" class="wyf.wyy.StatusBean" scope="session"/>
<head>
 	<title></title>
 	<script language="JavaScript" src="images/trim.js"></script>
 	<link href="images/div.css" type="text/css" rel=stylesheet> 	
 	<link href="images/globalstyle.css" type="text/css" rel=stylesheet>
 	<script language="JavaScript">
 		function show(search){
 			if(search=="simple"){
 				document.getElementById(search).style.display='block'; 
 				document.getElementById('complex').style.display='none';			
 			}
 			if(search=="complex"){
 				document.getElementById(search).style.display='block';
 				document.getElementById('simple').style.display='none';	 			
 			}
 		}
 	</script>
 </head>
 <body>
 	<div id="father">
 		<div id="condition">搜索方式：
 			<input type="radio" name="tj" checked="true" onclick="show('simple')">简单搜索
			<input type="radio" name="tj" onclick="show('complex')">复杂搜索
 		</div>					
 		<div id="search">
			<form name="jd" action="StudentServlet?action=simple" method="post">
				<table border="0" id="simple">
					<tr>
						<td align="right">请输入关键字：</td>
						<td><input type="text" name="key"/></td>
					</tr>
					<tr>
						<td align="right">选择查询条件：</td>
						<td>
							<select name="condition">
								<option value="BookName" selected>书名</option>
								<option value="Author" size="5">作者</option>
								<option value="Publish">出版社</option>
								<option value="BookIsbn">ISBN号</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<img id="ssa" src="images/ssa.gif" onclick="submit()"
							  	onmouseover="document.all.ssa.src='images/ssb.gif'"
							   	onmouseout="document.all.ssa.src='images/ssa.gif'"
							    onmousedown="document.all.ssa.src='images/ssc.gif'"
							    style="cursor:hand">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<!--<input type="submit" value="检索"/>  
							<input type="reset" value="重置">-->
							<img src="images/qka.gif" id="qka" onclick="reset()" 
								onmouseover="document.all.qka.src='images/qkb.gif'"
							 	onmouseout="document.all.qka.src='images/qka.gif'"
							  	onmousedown="document.all.qka.src='images/qkc.gif'"
							   	onmouseup="document.all.qka.src='images/qkb.gif'"
							  	style="cursor:hand" >
						</td>
					</tr>
				</table>
			</form>
			<form name="fz" action="StudentServlet?action=complex" method="post">
				<table border="0" id="complex" style="display:none;">
					<tr>
						<td align="right">书名：</td>
						<td><input type="text" name="BookName" size="24"/></td>
					</tr>
					<tr>
						<td align="right">作者：</td>
						<td><input type="text" name="Author" size="24"/></td>
					</tr>
					<tr>
						<td align="right">出版社：</td>
						<td><input type="text" name="Publish" size="24"/></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<img id="ss" src="images/ssa.gif" onclick="submit()"
							  	onmouseover="document.all.ss.src='images/ssb.gif'"
							   	onmouseout="document.all.ss.src='images/ssa.gif'"
							    onmousedown="document.all.ss.src='images/ssc.gif'"
							    style="cursor:hand">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<img src="images/qka.gif" id="qk" onclick="reset()" 
								onmouseover="document.all.qk.src='images/qkb.gif'"
							 	onmouseout="document.all.qk.src='images/qka.gif'"
							  	onmousedown="document.all.qk.src='images/qkc.gif'"
							   	onmouseup="document.all.qk.src='images/qkb.gif'"
							  	style="cursor:hand" >
						</td>
					</tr>
				</table>
			</form>
 		</div>
 		<div id="message">
 		 提示：
 		  <ul>
	 		  <li>图书检索在关键字文本框输入关键字</li><br/><br/>
	 		  <li>查找方式默认为模糊搜索</li><br/><br/>
	 		  <li>关键字为空则默认搜索所有图书</li><br/><br/>
	 		  <li>可在条件列表框中选择不同查找条件进行查找</li>
 		  </ul>
 		</div>
 	</div>
 </body>
</html>