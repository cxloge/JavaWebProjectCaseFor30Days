<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="s" uri="/struts-tags"%>
	 <style type="text/css">
		@import "dojo-release-1.1.1/dojo/resources/dojo.css";
		@import "dojo-release-1.1.1/dijit/themes/tundra/tundra.css";
		@import "dojo-release-1.1.1/dojox/widget/FisheyeList/FisheyeList.css";
	
		.dojoxFisheyeListBar {
			margin: 0 auto;
			text-align: center;
		}

		.outerbar {
			background-color: #fff;
			text-align: center;
			position: relative;
			left: 0px;
			top: 0px;
			width: 100%;
		}
		
		
		.page {
			padding: 50px 20px 20px 20px;
		}
		
	</style>

	<script 
	    type="text/javascript" 
	    src="dojo-release-1.1.1/dojo/dojo.js" 
	    djConfig="isDebug:false, parseOnLoad: true">	   
	</script>
	<script type="text/javascript">
		dojo.require("dojox.widget.FisheyeList");
		dojo.require("dojo.parser");
	</script>


<table cellpadding="0" cellspacing="0" width="100%" bgcolor="#a8cde4;">
	<tr bgcolor="#a8cde4">
		<td>
			<a href="mainManage.action" id="mainManage"><img src="images/icon.png" alt="返回首页"></a>
		</td>
		<td align="center" valign="center">
			<div style="height:70px;background-color:#a8cde4;">
		<div dojoType="dojox.widget.FisheyeList"
			itemWidth="70" itemHeight="50"
			itemMaxWidth="85" itemMaxHeight="80"
			orientation="horizontal"
			effectUnits="2"
			itemPadding="10"
			attachEdge="top"
			labelEdge="bottom"
			id="fisheye1"
		>
			<div dojoType="dojox.widget.FisheyeListItem"
				onClick="document.location.href='mainManage.action';"
				label="系统主页"
				iconSrc="images/top/001.png">
			</div>
			
			<div dojoType="dojox.widget.FisheyeListItem"
				onClick="document.location.href='sendFile.action';"
				label="发送文件"
				iconSrc="images/top/002.png">
			</div>
			
			<div dojoType="dojox.widget.FisheyeListItem"
				onClick="document.location.href='viewShare.action';"
				label="查看共享"
				iconSrc="images/top/003.png">
			</div>
			<div dojoType="dojox.widget.FisheyeListItem"
				onClick="document.location.href='sendMessage.action';"
				label="发送消息"
				iconSrc="images/top/004.png">
			</div>
			<s:if test="right!=1">
			<div dojoType="dojox.widget.FisheyeListItem"
				onClick="document.location.href='viewDoc.action';"
				label="待批申请"
				iconSrc="images/top/005.png">
			</div>
			</s:if>
			<s:if test="right==3">
			<div dojoType="dojox.widget.FisheyeListItem"
				onClick="document.location.href='addUser.action';"
				label="添加员工"
				iconSrc="images/top/006.png">
			</div>
			</s:if>
			<div dojoType="dojox.widget.FisheyeListItem"
				onClick="document.location.href='sendEmail.jsp';"
				label="电子邮件"
				iconSrc="images/top/007.png">
			</div>
			<div dojoType="dojox.widget.FisheyeListItem"
				onClick="document.location.href='exitSys.action';"
				label="退出系统"
				iconSrc="images/top/008.png">
			</div>
		</div>
       </div>
		</td>
	</tr>
    <tr style="height:20px;">
    	<td colspan="2" style="color:#154ba0;background-color:#ffffd9;">
    	<MARQUEE onmouseover=this.stop() onmouseout=this.start() 
                  		trueSpeed scrollAmount=1 scrollDelay=30 direction=left
                 		 height=20px width="100%">
    	你好，现在的时间是<span id="now"></span>
    	</MARQUEE>
    	</td>
    </tr> 
    <script language="JavaScript" defer="defer">
    	realtime();
    </script>
</table>
