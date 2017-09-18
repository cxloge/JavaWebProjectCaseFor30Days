<%@ page contentType="text/html;charset=gbk" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>二手房屋买卖合同</title>
			<link href="css/index.css" rel="stylesheet" type="text/css" />
			<link type="text/css" rel="stylesheet" href="css/admin.css"/>
			<script type="text/JavaScript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="images/logo_pic.gif"/>
				<%@ include file="AdminMenu.jsp" %>
				<p style="text-align:left;padding-top:10px;">&nbsp;&nbsp;
					<h:outputText value="当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>二手房屋买卖合同" />
				</p>
				
				<div style="width:90%;background-color:#FFFFFF;padding:40px;margin:20px;font-size:14px;text-align:left;">
					<b style="text-align:center;font-size:18px;"><center>二手房屋买卖合同</center></b>
					<p>卖方（简称甲方）：<h:outputText value="#{SaleContractDetailBean.first}" style="width:80px;"/>身份证号：<h:outputText value="#{SaleContractDetailBean.firstCardId}" style="width:80px;"/></p>
					<p>买方（简称乙方）：<h:outputText value="#{SaleContractDetailBean.second}" style="width:80px;"/>身份证号：<h:outputText value="#{SaleContractDetailBean.secondCardId}" style="width:80px;"/></p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;根据《中华人民共和国经济合同法》、《中华人民共和国城市房地产管理法》及其他有关法律、法规之规定，甲、乙双方在平等、自愿、协商一致的基础上，就乙方向甲方购买房产签订本合同，以资共同信守执行。 
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第一条</b>&nbsp;&nbsp;&nbsp;
						乙方同意购买甲方拥有的座落在<h:outputText value="#{SaleContractDetailBean.location}"/>拥有的房产住宅，建筑面积为<h:outputText value="#{SaleContractDetailBean.area}"/>平方米。（详见土地房屋权证第×××号）。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第二条</b>&nbsp;&nbsp;&nbsp;
						上述房产的交易价格为：<h:outputText value="#{SaleContractDetailBean.price}"/>万元。本合同签定之日，乙方向甲方支付人民币<h:outputText value="#{SaleContractDetailBean.price}"/>元整，作为购房定金。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第三条</b>&nbsp;&nbsp;&nbsp;&nbsp;付款时间与办法
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;甲乙双方同意以一次性付款方式付款，并约定在房地产交易中心缴交税费当日支付首付款（含定金）人民币拾万元整给甲方，剩余房款于产权交割完毕当日付给甲方。		
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第四条</b>&nbsp;&nbsp;&nbsp;&nbsp;甲方应于收到乙方全额房款之日起30天内将交易的房产全部交付给乙方使用，并应在交房当日将各种费用结清。	
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第五条</b>&nbsp;&nbsp;&nbsp;&nbsp;
						税费分担 甲乙双方应遵守国家房地产政策、法规，并按规定缴纳办理房地产过户手续所需缴纳的税费。经双方协商，交易税费由甲方承担，中介费及代办产权过户手续费由甲方承担。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第六条</b>&nbsp;&nbsp;&nbsp;&nbsp;
						违约责任 甲、乙双方合同签定后，若乙方中途违约，应书面通知甲方，甲方应在7日内将乙方的已付款不记利息）返还给乙方，但购房定金归甲方所有。若甲方中途违约，应书面通知乙方，并自违约之日起7日内应以乙方所付定金的双倍及已付款返还给乙方。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第七条</b>&nbsp;&nbsp;&nbsp;&nbsp;本合同主体
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;１、甲方代表人：<h:outputText value="#{SaleContractDetailBean.first}"/>。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;２．乙方代表人：<h:outputText value="#{SaleContractDetailBean.second}"/>。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第八条</b>&nbsp;&nbsp;&nbsp;
						本合同需办理公证，经国家公证机关唐山市公证处公证。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第九条</b>&nbsp;&nbsp;&nbsp;
						本合同一式 份。甲方产权人一份，甲方委托代理人一份，乙方一份,唐山市房地产交易中心一份、唐山市公证处各一份。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第十条</b>
						&nbsp;&nbsp;&nbsp;本合同发生争议的解决方式：在履约过程中发生的争议，双方可通过协商、诉讼方式解决。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第十一条</b>&nbsp;&nbsp;&nbsp;
						本合同未尽事宜，甲乙双方可另行约定，其补充约定经双方签章与本合同同具法律效力。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第十二条</b>&nbsp;&nbsp;&nbsp;&nbsp;双方约定的其他事项。
					</p><br/>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出卖方(甲方)：<h:outputText value="#{SaleContractDetailBean.first}" style="width:80px;"/>购买方(乙方)：<h:outputText value="#{SaleContractDetailBean.second}" style="width:80px;"/>
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号码：<h:outputText value="#{SaleContractDetailBean.firstCardId}"/>身份证号码：<h:outputText value="#{SaleContractDetailBean.secondCardId}"/>
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：<h:outputText value="#{SaleContractDetailBean.firstTel}" style="width:120px;"/>电话：<h:outputText value="#{SaleContractDetailBean.secondTel}"/>
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代理人(甲方)：<h:outputText value="#{SaleContractDetailBean.firstAgent}" style="width:80px;"/>代理人(乙方)：<h:outputText value="#{SaleContractDetailBean.secondAgent}" style="width:80px;"/>
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;见证方：迅捷二手房交易公司
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签约时间：<h:outputText value="#{SaleContractDetailBean.signTime}"><f:convertDateTime pattern="yyyy年MM月dd日"/></h:outputText>
					</p>
				</div>
			
			
			</div>
		</body>
	</html>
</f:view>