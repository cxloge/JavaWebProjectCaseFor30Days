<%@ page contentType="text/html;charset=gbk" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
		<head>
			<title>房屋租赁合同样本</title>
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
					<h:outputText value=">>房屋租赁合同样本" />
				</p>
				<div style="width:90%;background-color:#FFFFFF;padding:40px;margin:20px;font-size:14px;text-align:left;">
					<b style="text-align:center;font-size:18px;"><center>房屋租赁合同样本</center></b>
					<p>出租房：×××</p>
					<p>承租方：×××</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;根据《中华人民共和国经济合同法》及有关规定，
						为明确出租方与承租方的权利义务关系，经双方协商一致，签订本合同。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第一条</b>&nbsp;&nbsp;&nbsp;
						房屋坐落、间数、面积、房屋质量
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第二条</b>&nbsp;&nbsp;&nbsp;&nbsp;租赁期限
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;租赁期共××年零××月，出租方从××××年××月××日起将出租房屋交付承租方使用，至××××年××月××日收回。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;承租人有下列情形之一的，出租人可以终止合同、收回房屋：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;１．承租人擅自将房屋转租、转让或转借的；
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;２．承租人利用承租房屋进行非法活动，损害公共利益的；
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;３．承租人拖欠租金累计达××个月的。 					
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;租赁合同如因期满而终止时，如承租人到期确实无法找到房屋，出租人应当酌情延长租赁期限。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;合同期满后，如出租方仍继续出租房屋的，承租方享有优先权。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如承租方逾期不搬迁，出租方有权向人民法院起诉和申请执行，出租方因此所受损失由承租方负责赔偿。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第三条</b>&nbsp;&nbsp;&nbsp;&nbsp;租金和租金的交纳期限
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;租金的标准和交纳期限，按国家××××的规定执行（如国家没有统一规定的，此条由出租方和承租方协商确定，但不得任意抬高）。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第四条</b>&nbsp;&nbsp;&nbsp;&nbsp;租赁期间房屋修缮
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修缮房屋是出租人的义务。出租人对房屋及其设备应每隔××月（或年）认真检查、修缮一次，以保障承租人居住安全和正常使用。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出租人维修房屋时，承租人应积极协助，不得阻挠施工。出租人如确实无力修缮，可同承租人协商合修，届时承租人付出的修缮费用即用以充抵租金或由出租人分期偿还。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第五条</b>&nbsp;&nbsp;&nbsp;&nbsp;出租方与承租方的变更
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;１．如果出租方将房产所有权转移给第三方时，合同对新的房产所有者继续有效。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;２．出租人出卖房屋，须在３个月前通知承租人。在同等条件下，承租人有优先购买权。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;３．承租人需要与第三人互换住房时，应事先征得出租人同意；出租人应当支持承租人的合理要求。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第六条</b>&nbsp;&nbsp;&nbsp;&nbsp;违约责任
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;１．出租方未按前述合同条款的规定向承租人交付合乎要求的房屋的，负责赔偿××元。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;２．出租方未按时交付出租房屋供承租人使用的，负责偿付违约金××元。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;３．出租方未按时（或未按要求）修缮出租房屋的，负责偿付违约金××元；如因此造成承租方人员人身受到伤害或财物受毁的，负责赔偿损失。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;４．承租方逾期交付租金的，除仍应及时如数补交外，应支付违约金××元。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;５．承租方违反合同，擅自将承租房屋转给他人使用的，应支付违约金××元；如因此造成承租房屋毁坏的，还应负责赔偿。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第七条</b>&nbsp;&nbsp;&nbsp;&nbsp;免责条件
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;房屋如因不可抗力的原因导致毁损和造成承租方损失的，双方互不承担责任。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第八条</b>&nbsp;&nbsp;&nbsp;&nbsp;争议的解决方式
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本合同在履行中如发生争议，双方应协商解决；协商不成时，任何一方均可向工商局经济合同仲裁委员会申请调解或仲裁，也可以向人民法院起诉。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第九条</b>&nbsp;&nbsp;&nbsp;&nbsp;其他约定事项
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>第十条</b>
						&nbsp;&nbsp;&nbsp;本合同未尽事宜，一律按《中华人民共和国经济合同法》的有关规定，经合同双方共同协商，作出补充规定，补充规定与本合同具有同等效力。
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本合同正本壹式贰份，出租方、承租方各执壹份；合同副本××份，送××××单位备案。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出租方（盖章）：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;承租方（盖章）：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法定代表人（签名）：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;法定代表人（签名）：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;委托代理人（签名）：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;委托代理人（签名）：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开户银行：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开户银行：　
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经办人帐号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;帐号：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：　
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电挂：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电挂：　
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;鉴（公）证意见：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;鉴（公）证机关（章）：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签约地点：
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有效期限：至××××年××月××日
						<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签约时间：&nbsp;&nbsp;&nbsp;××××年××月××日
					</p>
				</div>
			</div>	
		</body>
	</html>
</f:view>