<%@ page contentType="text/html; charset=GBK" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>管理首页</title>
		<script language="JavaScript" src="javascript/position.js"></script>
	<style type="text/css">
		@import "dojo-release-1.1.1/dijit/tests/css/dijitTests.css";
	 	</style>     
	 <script type="text/javascript">
		 //处理实时消息的类
		 function msgProcessorType()
	     {
	        this.processHQ=processHQ;
	     }  
	     
	     //处理行情实时消息的方法
	     function processHQ(msg)
	     {       
	          if(msg.data.deptNumber=="10000")
	          {
	          	changepic("zongjingli");
	          }
	          else if(msg.data.deptNumber=="10001")
	          {
	          	changepic("shichang");
	          }
	          else if(msg.data.deptNumber=="10002")
	          {
	          	changepic("jishu");
	          }
	          else if(msg.data.deptNumber=="10003")
	          {
	          	changepic("gongguan");
	          }
	          else if(msg.data.deptNumber=="10004")
	          {
	          	changepic("caiwu");
	          }
	          else if(msg.data.deptNumber=="10005")
	          {
	          	changepic("houqin");
	          }
	     }
	     //创建处理实时消息的对象
	     currentProcessor=new msgProcessorType();
	 </script>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
		<link href="css/mainstyle.css" rel="stylesheet" type="text/css"/>
		<link href="css/dashboard.css" type="text/css" rel="stylesheet"/>
		<script language="JavaScript">
			String.prototype.trim = function()
			{
			  return this.replace(/(^\s*)|(\s*$)/g, "");
			}
			function changepic(picid)
			{
				var obj=document.getElementById(picid);
				var strArray=new Array();
				var picsrc=obj.src;
				strArray=picsrc.split("/");
				var size=strArray.length;
				if(strArray[size-1]=="light.png")
				{
					obj.src="images/dashboard/weight.png";
				}
				else
				{
					obj.src="images/dashboard/light.png";
				}
					setTimeout("changepic('"+picid+"')",500);
			}
		</script>	
	</head>
	<body>
	<div id="container">
		<div id="tophead">
			<s:action name="top" executeResult="true"/>
		</div>
		<div id="leftcontent">
			<s:action name="leftTree" executeResult="true"/>
		</div>
		<div id="maincontent">
		<s:if test="right==3">
			<table cellpadding="0" width="100%" align="center" style="text-align:center;margin:55px auto;">
		
				<tr>
					<td align="left" style="background:url(images/dashboard/zongjingli.png) no-repeat center;width:100px;height:150px;background-color:#f7f7f7;"><a href="viewAlarm.action?deptNumber=10000"><img style="width:20px;height:30px;" id="zongjingli" src="images/dashboard/ok.png">总经理</a></td>
					<td align="left" style="background:url(images/dashboard/caiwubu.png) no-repeat center;width:128px;height:150px;background-color:#f7f7f7;"><a href="viewAlarm.action?deptNumber=10004"><img style="width:20px;height:30px;" id="caiwu" src="images/dashboard/ok.png">财务部</a></td>
					
					<td align="left" style="background:url(images/dashboard/gongguan.png) no-repeat center;width:128px;height:150px;background-color:#f7f7f7;"><a href="viewAlarm.action?deptNumber=10003"><img style="width:20px;height:30px;" id="gongguan" src="images/dashboard/ok.png">公关部</a></td>
				</tr>
				<tr style="height:20px;">
					<td colspan="3" bgcolor="#f7f7f7"></td>
				</tr>
				<tr>
					<td align="left" style="background:url(images/dashboard/jishu.png) no-repeat center;width:128px;height:150px;background-color:#f7f7f7;"><a href="viewAlarm.action?deptNumber=10002"><img style="width:20px;height:30px;" id="jishu" src="images/dashboard/ok.png">技术部</a></td>
					<td align="left" style="background:url(images/dashboard/shichangbu.png) no-repeat center;width:128px;height:150px;background-color:#f7f7f7;"><a href="viewAlarm.action?deptNumber=10001"><img style="width:20px;height:30px;" id="shichang" src="images/dashboard/ok.png">市场部</a></td>
					
					<td align="left" style="background:url(images/dashboard/houqin.png) no-repeat center;width:128px;height:150px;background-color:#f7f7f7;"><a href="viewAlarm.action?deptNumber=10005"><img style="width:20px;height:30px;" id="houqin" src="images/dashboard/ok.png">后勤部</td>
				</tr>
			</table>
		</s:if>
		<s:else>
			<table width="99%" style="margin:20px auto;" align="center">
				<tr>
					<td style="width:33%">
						<table bgcolor="#f7f7f7" style="color:#333;">
							<tr>
								<td rowspan="2"><img src="images/dashboard/zongjingli.png"></td>
								<td style="color:#154ba0;font-size:15px;height:30px;">总经理室</td>
							</tr>
							<tr>
								<td>负责管理公司的重大业务</td>
							</tr>
						</table>
					</td>
					<td style="width:33%">
						<table bgcolor="#f7f7f7" style="color:#333;">
							<tr>
								<td rowspan="2"><img src="images/dashboard/caiwubu.png"></td>
								<td style="color:#154ba0;font-size:14px;height:30px;">财务部</td>
							</tr>
							<tr>
								<td>主要职能是在本机构一定的整体目标下，关于资产的购置(投资)，资本的融通(筹资)和经营中现金流量(营运资金)，以及利润分配的管理。</td>
							</tr>
						</table>
					</td>
					<td style="width:34%">
						<table bgcolor="#f7f7f7" style="color:#333;">
							<tr>
								<td rowspan="2"><img src="images/dashboard/gongguan.png"></td>
								<td style="color:#154ba0;font-size:14px;height:30px;">公关部</td>
							</tr>
							<tr>
								<td>
								公关部有这一套合理的工作模式。每周有固定的例会时间，总结上周的工作，并布置下周工作，集体讨论遇到各种问题
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr style="height:20px;">
					<td colspan="3" bgcolor="#f7f7f7"></td>
				</tr>
				<tr>
					<td>
						<table bgcolor="#f7f7f7" style="color:#333;">
							<tr>
								<td rowspan="2"><img src="images/dashboard/jishu.png"></td>
								<td style="color:#154ba0;font-size:14px;height:30px;">技术部</td>
							</tr>
							<tr>
								<td>
								研究提出科技发展的宏观战略和科技促进经济社会发展的方针、政策、法规；研究科技促进经济社会发展的重大问题；研究确定科技发展的重大布局和优先领域；
								
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table bgcolor="#f7f7f7" style="color:#333;">
							<tr>
								<td rowspan="2"><img src="images/dashboard/shichangbu.png"></td>
								<td style="color:#154ba0;font-size:14px;height:30px;">市场部</td>
							</tr>
							<tr>
								<td>
								市场部是为实现企业的经营目标制定策略的部门，而销售部是落实策略并具体执行销售计划以完成企业经营目标的部门。
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table bgcolor="#f7f7f7" style="color:#333;">
							<tr>
								<td rowspan="2"><img src="images/dashboard/houqin.png"></td>
								<td style="color:#154ba0;font-size:14px;height:30px;">后勤部</td>
							</tr>
							<tr>
								<td>
								根据上级指示精神结合我院实际，制定总务科管理规章制度和学期工作计划，并负责组织实施，检查落实执行情况。
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</s:else>
		</div>
	</div>
	<script language="JavaScript">
		var zongjingli=<s:property value="zongjingli"/>;
		if(zongjingli!=0){
			changepic("zongjingli");
		}
		var shichang=<s:property value="shichang"/>;
		if(shichang!=0){
			changepic("shichang");
		}
		
		var jishu=<s:property value="jishu"/>;
		if(jishu!=0){
			changepic("jishu");
		}
		var gongguan="<s:property value="gongguan"/>";
		if(gongguan!=0){
			changepic("gongguan");
		}
		var caiwu=<s:property value="caiwu"/>;
		if(caiwu!=0){
			changepic("caiwu");
		}
		var houqin=<s:property value="houqin"/>;
		if(houqin!=0){
			changepic("houqin");
		}
	</script>
	<script type="text/javascript">
	    dojo.require("dojox.cometd");
	    //连接comet服务
	    r=dojox.cometd.init("cometd");
      //注册信道
	    dojox.cometd.subscribe("/Alarm",currentProcessor,"processHQ");
	 </script>
	</body>
</html>