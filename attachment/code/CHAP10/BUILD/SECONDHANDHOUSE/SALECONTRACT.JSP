<%@ page contentType="text/html;charset=gbk" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
		<head>
			<title>二手房屋买卖合同样本</title>
			<link href="css/index.css" rel="stylesheet" type="text/css" />
			<script type="text/JavaScript" src="script/index.js"></script>
			<script type="text/javascript" src="script/general.js"></script>
		</head>
		<body>
			<div id="wrapper">
				<h:graphicImage value="images/logo_pic.gif"/>
				<%@ include file="Menu.jsp" %>
				<p style="text-align:left;padding-top:10px;">
					<h:outputText value="  当前位置："/>
					<h:outputLink value="#{facesContext.externalContext.requestContextPath}/faces/Index.jsp">
						<h:outputText value="首页" />
					</h:outputLink>
					<h:outputText value=">>二手房屋买卖合同样本" />
				</p>
				<div style="width:90%;background-color:#FFFFFF;padding:40px;margin:20px;font-size:14px;text-align:left;">
					<b style="text-align:center;font-size:18px;"><center>二手房屋买卖合同样本</center></b>
					<p>卖方（简称甲方）：×××&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号：××××××××××××××××××</p>
					<p>买方（简称乙方）：×××&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号：××××××××××××××××××</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;根据《中华人民共和国经济合同法》、《中华人民共和国城市房地产管理法》及其他有关法律、法规之规定，甲、乙双方在平等、自愿、协商一致的基础上，就乙方向甲方购买房产签订本合同，以资共同信守执行。 
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第一条</b>&nbsp;&nbsp;&nbsp;
						乙方同意购买甲方拥有的座落在×××市×××区×××拥有的房产住宅，建筑面积为×××平方米。（详见土地房屋权证第×××号）。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第二条</b>&nbsp;&nbsp;&nbsp;
						上述房产的交易价格为：单价：人民币×××元/平方米，总价：人民币×××元整（大写：×佰×拾×万×仟×佰×拾×元整）。本合同签定之日，乙方向甲方支付人民币×××××××元整，作为购房定金。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第三条</b>&nbsp;&nbsp;&nbsp;&nbsp;付款时间与办法
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;１、甲乙双方同意以银行按揭方式付款，并约定在房地产交易中心缴交税费当日支付首付款（含定金）人民币×拾×万×仟×佰×拾×元整给甲方，剩余房款人民币××××××元整申请银行按揭（如银行实际审批数额不足前述申请额度，乙方应在缴交税费当日将差额一并支付给甲方），并于银行放款当日付给甲方。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、甲乙双方同意以一次性付款方式付款，并约定在房地产交易中心缴交税费当日支付首付款（含定金）人民币×拾×万×仟×佰×拾×元整给甲方，剩余房款人民币××××××元整于产权交割完毕当日付给甲方。		
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第四条</b>&nbsp;&nbsp;&nbsp;&nbsp;甲方应于收到乙方全额房款之日起×××天内将交易的房产全部交付给乙方使用，并应在交房当日将×××等费用结清。	
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第五条</b>&nbsp;&nbsp;&nbsp;&nbsp;
						税费分担 甲乙双方应遵守国家房地产政策、法规，并按规定缴纳办理房地产过户手续所需缴纳的税费。经双方协商，交易税费由×方承担，中介费及代办产权过户手续费由×方承担。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第六条</b>&nbsp;&nbsp;&nbsp;&nbsp;
						违约责任 甲、乙双方合同签定后，若乙方中途违约，应书面通知甲方，甲方应在×××日内将乙方的已付款不记利息）返还给乙方，但购房定金归甲方所有。若甲方中途违约，应书面通知乙方，并自违约之日起×××日内应以乙方所付定金的双倍及已付款返还给乙方。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第七条</b>&nbsp;&nbsp;&nbsp;&nbsp;本合同主体
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;１、甲方是×××共×××人，委托代理人×××即甲方代表人。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;２．乙方是×××，代表人是×××。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第八条</b>&nbsp;&nbsp;&nbsp;
						本合同如需办理公证，经国家公证机关×××公证处公证。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第九条</b>&nbsp;&nbsp;&nbsp;
						本合同一式 份。甲方产权人一份，甲方委托代理人一份，乙方一份,唐山市房地产交易中心一份、×××公证处各一份。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第十条</b>
						&nbsp;&nbsp;&nbsp;本合同发生争议的解决方式：在履约过程中发生的争议，双方可通过协商、诉讼方式解决。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第十一条</b>&nbsp;&nbsp;&nbsp;
						本合同未尽事宜，甲乙双方可另行约定，其补充约定经双方签章与本合同同具法律效力。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第十二条</b>&nbsp;&nbsp;&nbsp;&nbsp;双方约定的其他事项。
					</p><br/>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出卖方(甲方)：×××&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;购买方(乙方)：×××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号码：×××××××&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号码：×××××××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：×××××××&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：×××××××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮编：×××××××&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮编：×××××××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：×××××××&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：×××××××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代理人(甲方)：×××&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代理人(乙方)：×××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号码：×××××××&nbsp;&nbsp;&nbsp;&nbsp;身份证号码：×××××××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;见证方：×××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;鉴证机关：×××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：×××××××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮编：×××××××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：×××××××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法人代表：×××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代表：×××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经办人：×××
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签约时间：&nbsp;&nbsp;&nbsp;××××年××月××日
					</p>
				</div>
			
			
			</div>
		</body>
	</html>
</f:view>