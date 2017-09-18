<%@ page contentType="text/html;charset=gbk" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>法律法规知识查询</title>
			<link type="text/css" rel="stylesheet" href="css/index.css"/>
			<link type="text/css" rel="stylesheet" href="css/tip.css" />
			<script type="text/javascript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="/images/logo_pic.gif" />
				<%@ include file="Menu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value=" 当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>法律法规查询" />
				</p><br/>
				<div style="text-align:left;padding:10px;">					
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《中华人民共和国城市房地产管理法》第三十七条下列房地产，不得转让：
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（一）以出让方式取得土地使用权的，不符合本法第三十八条规定的条件的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（二）司法机关和行政机关依法裁定、决定查封或者以其他形式限制房地产权利的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（三）依法收回土地使用权的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（四）共有房地产，未经其他共有人书面同意的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（五）权属有争议的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（六）未依法登记领取权属证书的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（七）法律、行政法规规定禁止转让的其他情形。
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《城市房地产转让管理规定》第六条下列房地产不得转让：
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（一）以出让方式取得土地使用权但不符合本规定第十条规定的条件的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（二）司法机关和行政机关依法裁定，决定查封或者以其他形式限制房地产权利的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（三）依法收回土地使用权的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（四）共有房地产，未经其他共有人书面同意的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（五）权属有争议的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（六）未依法登记领取权属证书的；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（七）法律、行政法规规定禁止转让的其他情形。
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第七条房地产转让，应当按照下列程序办理：
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（一）房地产转让当事人签订书面转让合同；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（二）房地产转让当事人在房地产转让合同签订后30日内持房地产权属证书、当事人的合法证明、转让合同等有关文件向房地产所在地的房地产管理部门提出申请，并申报成交价格；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（三）房地产管理部门对提供的有关文件进行审查，并在15日内做出是否受理申请的书面答复；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（四）房地产管理部门核实申报的成交价格，并根据需要对转让的房地产进行现场查勘和评估；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（五）房地产转让当事人按照规定缴纳有关税费；
					<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（六）房地产管理部门核发过户单。
				</p>									
				</div>
				<div style="padding:30px;">
					<ul style="text-align:left;">
						<li>
							<h:outputLink value="#">
								<h:outputText value="● 关于个人住房转让营业税政策的通知"/>
							</h:outputLink>					
						</li>
						<li>
							<h:outputLink value="#">
								<h:outputText value="● 国务院办公厅转发建设部关于进一步清理整顿房地产..."/>
							</h:outputLink>
						</li>
						<li>
							<h:outputLink value="#">
								<h:outputText value="● 国务院关于房地产建设进口物资税收问题的通知"/>
							</h:outputLink>
						</li>
						<li>
							<h:outputLink value="#">
								<h:outputText value="● 关于加强房地产价格调控加快住房建设的意见 "/>
							</h:outputLink>
						</li>
						<li>
							<h:outputLink value="#">
								<h:outputText value="● 国务院关于促进房地产市场持续健康发展的通知"/>
							</h:outputLink>
						</li>
						<li>
							<h:outputLink value="#">
								<h:outputText value="● 营业税减免将带来二手房交易升温的契机"/>
							</h:outputLink>
						</li>
						<li>
							<h:outputLink value="#">
								<h:outputText value=""/>
							</h:outputLink>
						</li>
					</ul>
				</div>

				
			</div>
		</body>
	</html>
</f:view>