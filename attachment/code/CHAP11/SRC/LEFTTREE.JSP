<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="s" uri="/struts-tags"%>
		<link href="css/treeStyle.css" type="text/css" rel="stylesheet"/>
		<script language="javaScript">
			function changetree(id)
			{
				for(var i=1;i<10;i++)
				{
					if(id!="li"+i)
					{
						if(document.getElementById("li"+i+1)!=null)
						{
							document.getElementById("li"+i+1).style.display="none";
						}
					}
					else
					{
						var opdiv=document.getElementById(id+1);
						var display_value=opdiv.style.display;
						if(display_value=="none")
						{
							opdiv.style.display="block";
						}
						else
						{
							opdiv.style.display="none";
						}
					}
				}	
			}
		</script>
		
		<div id="lefttree">
		<ul>
			<li id="li1" ><a onclick="changetree('li1');" href="#">文件管理</a></li>
			<div id="li11" class="lidiv" style="display:none;">
				
				<a href="receiveFile.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/001.gif"><br>接受文件</a><br>
				<a href="sendFile.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/002.gif"><br>发送文件</a><br>	
			</div>
			<li id="li2"><a onclick="changetree('li2');" href="#">企业共享</a></li>
			<div id="li21" class="lidiv" style="display:none;">
				<a href="viewShare.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/003.gif"><br>查看共享</a><br>
				<a href="uploadShare.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/004.gif"><br>上传共享</a><br>
				<s:if test="right==3">
				<a href="manageShare.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/005.gif"><br>管理共享</a><br>	
				</s:if>
			</div>
			<li id="li3"><a onclick="changetree('li3');" href="#">消息管理</a></li>
			<div id="li31" class="lidiv" style="display:none;">
				<a href="receiveMessage.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/006.gif"><br>接收消息</a><br>
				<a href="sendMessage.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/007.gif"><br>发送消息</a><br>
			
				
				
				
			</div>
			<li id="li4"><a onclick="changetree('li4');" href="#">申请审批</a></li>
			<div id="li41" class="lidiv" style="display:none;">
				<s:if test="right==3">
				<a href="viewDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/009.gif"><br>待批申请</a><br>
				<a href="sendDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/010.gif"><br>发送申请</a><br>
				<a href="allDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/011.gif"><br>所有申请</a><br>
				<a href="myDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/012.gif"><br>我的申请</a><br>
				</s:if>
				<s:else>
					<s:if test="right==2">
						<a href="viewDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/009.gif"><br>待批申请</a><br>
						<a href="sendDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/010.gif"><br>发送申请</a><br>
						<a href="myDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/012.gif"><br>我的申请</a><br>
					</s:if>
					<s:else>
						<a href="sendDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/010.gif"><br>发送申请</a><br>
						<a href="myDoc.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/012.gif"><br>我的申请</a><br>
					</s:else>
				</s:else>
					
			</div>
			<li id="li9"><a onclick="changetree('li9');" href="#">考勤管理</a></li>
			<div id="li91" class="lidiv" style="display:none;">
				<s:if test="right==3">
				<a href="attTime.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/008.gif"><br>考勤时间</a><br>
				<a href="viewAtt.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/013.gif"><br>考勤查询</a><br>
				</s:if>
				<a href="attOnline.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/012.gif"><br>在线考勤</a><br>
			</div>
			<s:if test="right==3">
			<li id="li5"><a onclick="changetree('li5');" href="#">人力资源</a></li>
			<div id="li51" class="lidiv" style="display:none;">
				<a href="addUser.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/014.gif"><br>添加员工</a><br>
				<a href="viewUser.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/015.gif"><br>员工管理</a><br>
			</div>
			</s:if>
			<li id="li6"><a onclick="changetree('li6');" href="#">电子邮件</a></li>
			<div id="li61" class="lidiv" style="display:none;">
				<a href="sendEmail.jsp"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/016.gif"><br>发送邮件</a><br>
				
				
			</div>
			<li id="li8"><a onclick="changetree('li8');" href="#">紧急事务</a></li>
			<div id="li81" class="lidiv" style="display:none;">
				<a href="sendAlarm1.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/010.gif"><br>紧急报警</a><br>
				<s:if test="right==3">
				<a href="viewAlarm.action"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/011.gif"><br>查看报警</a><br>
				</s:if>
				
			</div>
			<li id="li7"><a onclick="changetree('li7');" href="#">系统管理</a></li>
			<div id="li71" class="lidiv" style="display:none;">
				<a href="changePwd.jsp"><img class="nomal" onmousedown="this.className='Down'" onmouseover="this.className='Up'" onmouseout="this.className='nomal'" src="images/left/017.gif"><br>修改密码</a><br>
			</div>
		</ul>
		</div><br><br>
		<div id="marq" style="width:190px;text-align:center;margin:0 auto;background-color:#fff;">
		
					<MARQUEE onmouseover=this.stop() onmouseout=this.start() 
                  		trueSpeed scrollAmount=1 scrollDelay=40 direction=up 
                 		 height=180>
                 		 <center>
                 		 <s:if test="right==3">
		                <a href="receiveFile.action">接 受 文 件</a>&nbsp&nbsp|&nbsp&nbsp<a href="sendFile.action">发 送 文 件</a><br>	
						<a href="viewShare.action">查 看 共 享</a>&nbsp&nbsp|&nbsp&nbsp<a href="uploadShare.action">上 传 共 享</a><br>
						<a href="manageShare.action">管 理 共 享</a>&nbsp&nbsp|&nbsp&nbsp<a href="receiveMessage.action">接 收 消 息</a><br>
						<a href="sendMessage.action">发 送 消 息</a>&nbsp&nbsp|&nbsp&nbsp<a href="#">接 收 公 文</a><br>
						<a href="viewDoc.action">待 批 申 请</a>&nbsp&nbsp|&nbsp&nbsp<a href="sendDoc.action">发 送 申 请</a><br>
						<a href="allDoc.action">所 有 申 请</a>&nbsp&nbsp|&nbsp&nbsp<a href="myDoc.action">我 的 申 请</a><br>
						<a href="attTime.action">考 勤 时 间</a>&nbsp&nbsp|&nbsp&nbsp<a href="attOnline.action">在 线 考 勤</a><br>
						<a href="viewAtt.action">考 勤 查 询</a>&nbsp&nbsp|&nbsp&nbsp<a href="addUser.action">添 加 员 工</a><br>
						<a href="viewUser.action">员 工 管 理</a>&nbsp&nbsp|&nbsp&nbsp<a href="sendEmail.jsp">发 送 邮 件</a><br>
						<a href="sendAlarm1.action">紧 急 报 警</a>&nbsp&nbsp|&nbsp&nbsp<a href="viewAlarm.action">查 看 报 警</a><br>
						<a href="changePwd.jsp">修 改 密 码</a>
						</s:if>
						<s:else>
						<s:if test="right==2">
						<a href="receiveFile.action">接 受 文 件</a>&nbsp&nbsp|&nbsp&nbsp<a href="sendFile.action">发 送 文 件</a><br>	
						<a href="viewShare.action">查 看 共 享</a>&nbsp&nbsp|&nbsp&nbsp<a href="uploadShare.action">上 传 共 享</a><br>
						<a href="sendMessage.action">发 送 消 息</a>&nbsp&nbsp|&nbsp&nbsp<a href="receiveMessage.action">接 收 消 息</a><br>
						<a href="viewDoc.action">待 批 申 请</a>&nbsp&nbsp|&nbsp&nbsp<a href="sendDoc.action">发 送 申 请</a><br>
						<a href="myDoc.action">我 的 申 请</a>&nbsp&nbsp|&nbsp&nbsp<a href="attOnline.action">在 线 考 勤</a><br>
						<a href="sendEmail.jsp">发 送 邮 件</a>&nbsp&nbsp|&nbsp&nbsp<a href="sendAlarm1.action">紧 急 报 警</a><br>
						<a href="changePwd.jsp">修 改 密 码</a>
						</s:if>
						<s:else>
						<a href="receiveFile.action">接 &nbsp 受 &nbsp 文 &nbsp 件</a><br><a href="sendFile.action">发 &nbsp 送 &nbsp 文 &nbsp 件</a><br>	
						<a href="viewShare.action">查 &nbsp  看 &nbsp  共 &nbsp  享</a><br><a href="uploadShare.action">上 &nbsp 传 &nbsp 共 &nbsp 享</a><br>
						<a href="sendMessage.action">发 &nbsp 送 &nbsp 消 &nbsp 息</a><br><a href="receiveMessage.action">接 &nbsp 收 &nbsp 消 &nbsp 息</a><br>
						<a href="sendDoc.action">发 &nbsp 送 &nbsp 申 &nbsp 请</a><br>
						<a href="myDoc.action">我 &nbsp 的 &nbsp 申  &nbsp 请</a><br><a href="attOnline.action">在  &nbsp 线 &nbsp 考&nbsp  勤</a><br>
						<a href="sendEmail.jsp">发 &nbsp 送 &nbsp 邮 &nbsp 件</a><br><a href="sendAlarm1.action">紧 &nbsp 急 &nbsp 报 &nbsp 警</a><br>
						<a href="changePwd.jsp">修 &nbsp 改 &nbsp 密 &nbsp 码</a>
						</s:else>
						</s:else>
					    </center>
					</MARQUEE>
		</div>
		
		
		

